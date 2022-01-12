package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.work.BackoffPolicy;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.WorkInfo$State;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class SystemJobScheduler implements Scheduler {
    public static final String TAG = Logger.tagWithPrefix("SystemJobScheduler");
    public final Context mContext;
    public final JobScheduler mJobScheduler;
    public final SystemJobInfoConverter mSystemJobInfoConverter;
    public final WorkManagerImpl mWorkManager;

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl) {
        SystemJobInfoConverter systemJobInfoConverter = new SystemJobInfoConverter(context);
        this.mContext = context;
        this.mWorkManager = workManagerImpl;
        this.mJobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        this.mSystemJobInfoConverter = systemJobInfoConverter;
    }

    public static void cancelAll(Context context) {
        List<JobInfo> pendingJobs;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (!(jobScheduler == null || (pendingJobs = getPendingJobs(context, jobScheduler)) == null || pendingJobs.isEmpty())) {
            for (JobInfo jobInfo : pendingJobs) {
                cancelJobById(jobScheduler, jobInfo.getId());
            }
        }
    }

    public static void cancelJobById(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static List<Integer> getPendingJobIds(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        if (pendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : pendingJobs) {
            if (str.equals(getWorkSpecIdFromJobInfo(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static List<JobInfo> getPendingJobs(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static String getWorkSpecIdFromJobInfo(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean reconcileJobs(Context context, WorkManagerImpl workManagerImpl) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        SystemIdInfoDao_Impl systemIdInfoDao_Impl = (SystemIdInfoDao_Impl) workManagerImpl.mWorkDatabase.systemIdInfoDao();
        if (systemIdInfoDao_Impl != null) {
            boolean z = false;
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
            systemIdInfoDao_Impl.__db.assertNotSuspendingTransaction();
            Cursor query = DBUtil.query(systemIdInfoDao_Impl.__db, acquire, false, null);
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(query.getString(0));
                }
                HashSet hashSet = new HashSet(pendingJobs != null ? pendingJobs.size() : 0);
                if (pendingJobs != null && !pendingJobs.isEmpty()) {
                    for (JobInfo jobInfo : pendingJobs) {
                        String workSpecIdFromJobInfo = getWorkSpecIdFromJobInfo(jobInfo);
                        if (!TextUtils.isEmpty(workSpecIdFromJobInfo)) {
                            hashSet.add(workSpecIdFromJobInfo);
                        } else {
                            cancelJobById(jobScheduler, jobInfo.getId());
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!hashSet.contains((String) it.next())) {
                            Logger.get().debug(TAG, "Reconciling jobs", new Throwable[0]);
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
                    workDatabase.beginTransaction();
                    try {
                        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((WorkSpecDao_Impl) workSpecDao).markWorkSpecScheduled((String) it2.next(), -1);
                        }
                        workDatabase.setTransactionSuccessful();
                    } finally {
                        workDatabase.endTransaction();
                    }
                }
                return z;
            } finally {
                query.close();
                acquire.release();
            }
        } else {
            throw null;
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String str) {
        List<Integer> pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, str);
        if (!(pendingJobIds == null || pendingJobIds.isEmpty())) {
            for (Integer num : pendingJobIds) {
                cancelJobById(this.mJobScheduler, num.intValue());
            }
            ((SystemIdInfoDao_Impl) this.mWorkManager.mWorkDatabase.systemIdInfoDao()).removeSystemIdInfo(str);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.work.impl.Scheduler
    public void schedule(WorkSpec... workSpecArr) {
        int i;
        List<Integer> pendingJobIds;
        int i2;
        WorkDatabase workDatabase = this.mWorkManager.mWorkDatabase;
        IdGenerator idGenerator = new IdGenerator(workDatabase);
        for (WorkSpec workSpec : workSpecArr) {
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getWorkSpec(workSpec.id);
                if (workSpec2 == null) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.id + " because it's no longer in the DB", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != WorkInfo$State.ENQUEUED) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.id + " because it is no longer enqueued", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemIdInfo systemIdInfo = ((SystemIdInfoDao_Impl) workDatabase.systemIdInfoDao()).getSystemIdInfo(workSpec.id);
                    if (systemIdInfo != null) {
                        i = systemIdInfo.systemId;
                    } else {
                        i = idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.mConfiguration.mMinJobSchedulerId, this.mWorkManager.mConfiguration.mMaxJobSchedulerId);
                    }
                    if (systemIdInfo == null) {
                        ((SystemIdInfoDao_Impl) this.mWorkManager.mWorkDatabase.systemIdInfoDao()).insertSystemIdInfo(new SystemIdInfo(workSpec.id, i));
                    }
                    scheduleInternal(workSpec, i);
                    if (Build.VERSION.SDK_INT == 23 && (pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, workSpec.id)) != null) {
                        int indexOf = pendingJobIds.indexOf(Integer.valueOf(i));
                        if (indexOf >= 0) {
                            pendingJobIds.remove(indexOf);
                        }
                        if (!pendingJobIds.isEmpty()) {
                            i2 = pendingJobIds.get(0).intValue();
                        } else {
                            i2 = idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.mConfiguration.mMinJobSchedulerId, this.mWorkManager.mConfiguration.mMaxJobSchedulerId);
                        }
                        scheduleInternal(workSpec, i2);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (android.os.Build.VERSION.SDK_INT < 26) goto L_0x002f;
     */
    public void scheduleInternal(WorkSpec workSpec, int i) {
        int i2;
        int i3;
        SystemJobInfoConverter systemJobInfoConverter = this.mSystemJobInfoConverter;
        if (systemJobInfoConverter != null) {
            Constraints constraints = workSpec.constraints;
            NetworkType networkType = constraints.mRequiredNetworkType;
            int ordinal = networkType.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            i2 = 4;
                            if (ordinal == 4) {
                            }
                        } else if (Build.VERSION.SDK_INT >= 24) {
                            i2 = 3;
                        }
                        Logger.get().debug(SystemJobInfoConverter.TAG, String.format("API version too low. Cannot convert network type value %s", networkType), new Throwable[0]);
                    } else {
                        i2 = 2;
                    }
                }
                i2 = 1;
            } else {
                i2 = 0;
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.id);
            persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.isPeriodic());
            JobInfo.Builder extras = new JobInfo.Builder(i, systemJobInfoConverter.mWorkServiceComponent).setRequiredNetworkType(i2).setRequiresCharging(constraints.mRequiresCharging).setRequiresDeviceIdle(constraints.mRequiresDeviceIdle).setExtras(persistableBundle);
            if (!constraints.mRequiresDeviceIdle) {
                extras.setBackoffCriteria(workSpec.backoffDelayDuration, workSpec.backoffPolicy == BackoffPolicy.LINEAR ? 0 : 1);
            }
            long max = Math.max(workSpec.calculateNextRunTime() - System.currentTimeMillis(), 0L);
            if (Build.VERSION.SDK_INT <= 28) {
                extras.setMinimumLatency(max);
            } else if (max > 0) {
                extras.setMinimumLatency(max);
            } else {
                extras.setImportantWhileForeground(true);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if ((constraints.mContentUriTriggers.size() > 0 ? 1 : null) != null) {
                    for (ContentUriTriggers.Trigger trigger : constraints.mContentUriTriggers.mTriggers) {
                        extras.addTriggerContentUri(new JobInfo.TriggerContentUri(trigger.mUri, trigger.mTriggerForDescendants ? 1 : 0));
                    }
                    extras.setTriggerContentUpdateDelay(constraints.mTriggerContentUpdateDelay);
                    extras.setTriggerContentMaxDelay(constraints.mTriggerMaxContentDelay);
                }
            }
            extras.setPersisted(false);
            if (Build.VERSION.SDK_INT >= 26) {
                extras.setRequiresBatteryNotLow(constraints.mRequiresBatteryNotLow);
                extras.setRequiresStorageNotLow(constraints.mRequiresStorageNotLow);
            }
            JobInfo build = extras.build();
            Logger.get().debug(TAG, String.format("Scheduling work ID %s Job ID %s", workSpec.id, Integer.valueOf(i)), new Throwable[0]);
            try {
                this.mJobScheduler.schedule(build);
            } catch (IllegalStateException e) {
                List<JobInfo> pendingJobs = getPendingJobs(this.mContext, this.mJobScheduler);
                int size = pendingJobs != null ? pendingJobs.size() : 0;
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(((ArrayList) ((WorkSpecDao_Impl) this.mWorkManager.mWorkDatabase.workSpecDao()).getScheduledWork()).size());
                Configuration configuration = this.mWorkManager.mConfiguration;
                if (Build.VERSION.SDK_INT == 23) {
                    i3 = configuration.mMaxSchedulerLimit / 2;
                } else {
                    i3 = configuration.mMaxSchedulerLimit;
                }
                objArr[2] = Integer.valueOf(i3);
                String format = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", objArr);
                Logger.get().error(TAG, format, new Throwable[0]);
                throw new IllegalStateException(format, e);
            } catch (Throwable th) {
                Logger.get().error(TAG, String.format("Unable to schedule %s", workSpec), th);
            }
        } else {
            throw null;
        }
    }
}
