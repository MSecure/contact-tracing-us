package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {
    public static final String TAG = Logger.tagWithPrefix("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX INFO: finally extract failed */
    public static String workSpecRows(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", "Job Id"));
        for (WorkSpec workSpec : list) {
            SystemIdInfo systemIdInfo = ((SystemIdInfoDao_Impl) systemIdInfoDao).getSystemIdInfo(workSpec.id);
            Integer valueOf = systemIdInfo != null ? Integer.valueOf(systemIdInfo.systemId) : null;
            String str = workSpec.id;
            WorkNameDao_Impl workNameDao_Impl = (WorkNameDao_Impl) workNameDao;
            if (workNameDao_Impl != null) {
                RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT name FROM workname WHERE work_spec_id=?", 1);
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                workNameDao_Impl.__db.assertNotSuspendingTransaction();
                Cursor query = DBUtil.query(workNameDao_Impl.__db, acquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(query.getString(0));
                    }
                    query.close();
                    acquire.release();
                    sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", workSpec.id, workSpec.workerClassName, valueOf, workSpec.state.name(), TextUtils.join(",", arrayList), TextUtils.join(",", ((WorkTagDao_Impl) workTagDao).getTagsForWorkSpecId(workSpec.id))));
                } catch (Throwable th) {
                    query.close();
                    acquire.release();
                    throw th;
                }
            } else {
                throw null;
            }
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        SystemIdInfoDao systemIdInfoDao;
        WorkTagDao workTagDao;
        WorkNameDao workNameDao;
        int i;
        WorkDatabase workDatabase = WorkManagerImpl.getInstance(this.mAppContext).mWorkDatabase;
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkNameDao workNameDao2 = workDatabase.workNameDao();
        WorkTagDao workTagDao2 = workDatabase.workTagDao();
        SystemIdInfoDao systemIdInfoDao2 = workDatabase.systemIdInfoDao();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);
        WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
        if (workSpecDao_Impl != null) {
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
            acquire.bindLong(1, currentTimeMillis);
            workSpecDao_Impl.__db.assertNotSuspendingTransaction();
            Cursor query = DBUtil.query(workSpecDao_Impl.__db, acquire, false, null);
            try {
                int columnIndexOrThrow = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow2 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow3 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow4 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow5 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow6 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow7 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow8 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "content_uri_triggers");
                int columnIndexOrThrow9 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow10 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "state");
                int columnIndexOrThrow11 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "worker_class_name");
                int columnIndexOrThrow12 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input_merger_class_name");
                int columnIndexOrThrow13 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input");
                int columnIndexOrThrow14 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "output");
                roomSQLiteQuery = acquire;
                try {
                    int columnIndexOrThrow15 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "initial_delay");
                    int columnIndexOrThrow16 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "interval_duration");
                    int columnIndexOrThrow17 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "flex_duration");
                    int columnIndexOrThrow18 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_attempt_count");
                    int columnIndexOrThrow19 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_policy");
                    int columnIndexOrThrow20 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_delay_duration");
                    int columnIndexOrThrow21 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "period_start_time");
                    int columnIndexOrThrow22 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "minimum_retention_duration");
                    int columnIndexOrThrow23 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "schedule_requested_at");
                    int columnIndexOrThrow24 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_in_foreground");
                    int i2 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndexOrThrow9);
                        String string2 = query.getString(columnIndexOrThrow11);
                        Constraints constraints = new Constraints();
                        constraints.mRequiredNetworkType = AppCompatDelegateImpl.ConfigurationImplApi17.intToNetworkType(query.getInt(columnIndexOrThrow));
                        constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                        constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                        constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                        constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                        constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                        constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                        constraints.mContentUriTriggers = AppCompatDelegateImpl.ConfigurationImplApi17.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                        WorkSpec workSpec = new WorkSpec(string, string2);
                        workSpec.state = AppCompatDelegateImpl.ConfigurationImplApi17.intToState(query.getInt(columnIndexOrThrow10));
                        workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                        workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                        workSpec.output = Data.fromByteArray(query.getBlob(i2));
                        i2 = i2;
                        workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                        workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                        workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                        workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                        workSpec.backoffPolicy = AppCompatDelegateImpl.ConfigurationImplApi17.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                        workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                        columnIndexOrThrow21 = columnIndexOrThrow21;
                        workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                        columnIndexOrThrow22 = columnIndexOrThrow22;
                        workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                        workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                        workSpec.constraints = constraints;
                        arrayList.add(workSpec);
                        columnIndexOrThrow23 = columnIndexOrThrow23;
                        columnIndexOrThrow24 = columnIndexOrThrow24;
                        columnIndexOrThrow10 = columnIndexOrThrow10;
                        columnIndexOrThrow12 = columnIndexOrThrow12;
                        columnIndexOrThrow11 = columnIndexOrThrow11;
                        columnIndexOrThrow2 = columnIndexOrThrow2;
                        columnIndexOrThrow = columnIndexOrThrow;
                        columnIndexOrThrow15 = columnIndexOrThrow15;
                        columnIndexOrThrow9 = columnIndexOrThrow9;
                        columnIndexOrThrow20 = columnIndexOrThrow20;
                        columnIndexOrThrow13 = columnIndexOrThrow13;
                        columnIndexOrThrow16 = columnIndexOrThrow16;
                        columnIndexOrThrow18 = columnIndexOrThrow18;
                        columnIndexOrThrow19 = columnIndexOrThrow19;
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    WorkSpecDao_Impl workSpecDao_Impl2 = (WorkSpecDao_Impl) workSpecDao;
                    List<WorkSpec> runningWork = workSpecDao_Impl2.getRunningWork();
                    List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao_Impl2.getAllEligibleWorkSpecsForScheduling(200);
                    if (!arrayList.isEmpty()) {
                        i = 0;
                        Logger.get().info(TAG, "Recently completed work:\n\n", new Throwable[0]);
                        systemIdInfoDao = systemIdInfoDao2;
                        workNameDao = workNameDao2;
                        workTagDao = workTagDao2;
                        Logger.get().info(TAG, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, arrayList), new Throwable[0]);
                    } else {
                        systemIdInfoDao = systemIdInfoDao2;
                        workNameDao = workNameDao2;
                        workTagDao = workTagDao2;
                        i = 0;
                    }
                    if (!((ArrayList) runningWork).isEmpty()) {
                        Logger.get().info(TAG, "Running work:\n\n", new Throwable[i]);
                        Logger.get().info(TAG, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, runningWork), new Throwable[i]);
                    }
                    if (!((ArrayList) allEligibleWorkSpecsForScheduling).isEmpty()) {
                        Logger.get().info(TAG, "Enqueued work:\n\n", new Throwable[i]);
                        Logger.get().info(TAG, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, allEligibleWorkSpecsForScheduling), new Throwable[i]);
                    }
                    return new ListenableWorker.Result.Success();
                } catch (Throwable th2) {
                    th = th2;
                    query.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                roomSQLiteQuery = acquire;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } else {
            throw null;
        }
    }
}
