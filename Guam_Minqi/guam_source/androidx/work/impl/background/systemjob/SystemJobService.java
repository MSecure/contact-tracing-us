package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("SystemJobService");
    public final Map<String, JobParameters> mJobParameters = new HashMap();
    public WorkManagerImpl mWorkManagerImpl;

    public static String getWorkSpecIdFromJobParameters(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl instance = WorkManagerImpl.getInstance(getApplicationContext());
            this.mWorkManagerImpl = instance;
            instance.mProcessor.addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl != null) {
            workManagerImpl.mProcessor.removeExecutionListener(this);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String str, boolean z) {
        JobParameters remove;
        Logger.get().debug(TAG, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.mJobParameters) {
            remove = this.mJobParameters.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = new androidx.work.WorkerParameters.RuntimeExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (r9.getTriggeredContentUris() == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        java.util.Arrays.asList(r9.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        if (r9.getTriggeredContentAuthorities() == null) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
        java.util.Arrays.asList(r9.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        r9.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
        r9 = r8.mWorkManagerImpl;
        r3 = r9.mWorkTaskExecutor;
        ((androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor) r3).mBackgroundExecutor.execute(new androidx.work.impl.utils.StartWorkRunnable(r9, r0, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
        return true;
     */
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String workSpecIdFromJobParameters = getWorkSpecIdFromJobParameters(jobParameters);
        if (TextUtils.isEmpty(workSpecIdFromJobParameters)) {
            Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.mJobParameters) {
            if (this.mJobParameters.containsKey(workSpecIdFromJobParameters)) {
                Logger.get().debug(TAG, String.format("Job is already being executed by SystemJobService: %s", workSpecIdFromJobParameters), new Throwable[0]);
                return false;
            }
            Logger.get().debug(TAG, String.format("onStartJob for %s", workSpecIdFromJobParameters), new Throwable[0]);
            this.mJobParameters.put(workSpecIdFromJobParameters, jobParameters);
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        boolean contains;
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String workSpecIdFromJobParameters = getWorkSpecIdFromJobParameters(jobParameters);
        if (TextUtils.isEmpty(workSpecIdFromJobParameters)) {
            Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger.get().debug(TAG, String.format("onStopJob for %s", workSpecIdFromJobParameters), new Throwable[0]);
        synchronized (this.mJobParameters) {
            this.mJobParameters.remove(workSpecIdFromJobParameters);
        }
        this.mWorkManagerImpl.stopWork(workSpecIdFromJobParameters);
        Processor processor = this.mWorkManagerImpl.mProcessor;
        synchronized (processor.mLock) {
            contains = processor.mCancelledIds.contains(workSpecIdFromJobParameters);
        }
        return !contains;
    }
}
