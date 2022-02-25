package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import e.b0.l;
import e.b0.x.b;
import e.b0.x.d;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements b {

    /* renamed from: d  reason: collision with root package name */
    public static final String f310d = l.e("SystemJobService");
    public e.b0.x.l b;
    public final Map<String, JobParameters> c = new HashMap();

    public static String b(JobParameters jobParameters) {
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

    @Override // e.b0.x.b
    public void a(String str, boolean z) {
        JobParameters remove;
        l.c().a(f310d, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.c) {
            remove = this.c.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            e.b0.x.l d2 = e.b0.x.l.d(getApplicationContext());
            this.b = d2;
            d2.f1031f.b(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                l.c().f(f310d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        e.b0.x.l lVar = this.b;
        if (lVar != null) {
            lVar.f1031f.e(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = null;
        r3 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (r3 < 24) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = new androidx.work.WorkerParameters.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (r9.getTriggeredContentUris() == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r2.b = java.util.Arrays.asList(r9.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        if (r9.getTriggeredContentAuthorities() == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        r2.a = java.util.Arrays.asList(r9.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009a, code lost:
        if (r3 < 28) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009c, code lost:
        r9.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009f, code lost:
        r9 = r8.b;
        r3 = r9.f1029d;
        ((e.b0.x.t.q.b) r3).a.execute(new e.b0.x.t.j(r9, r0, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00af, code lost:
        return true;
     */
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.b == null) {
            l.c().a(f310d, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String b2 = b(jobParameters);
        if (TextUtils.isEmpty(b2)) {
            l.c().b(f310d, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.c) {
            if (this.c.containsKey(b2)) {
                l.c().a(f310d, String.format("Job is already being executed by SystemJobService: %s", b2), new Throwable[0]);
                return false;
            }
            l.c().a(f310d, String.format("onStartJob for %s", b2), new Throwable[0]);
            this.c.put(b2, jobParameters);
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        boolean contains;
        if (this.b == null) {
            l.c().a(f310d, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String b2 = b(jobParameters);
        if (TextUtils.isEmpty(b2)) {
            l.c().b(f310d, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        l.c().a(f310d, String.format("onStopJob for %s", b2), new Throwable[0]);
        synchronized (this.c) {
            this.c.remove(b2);
        }
        this.b.g(b2);
        d dVar = this.b.f1031f;
        synchronized (dVar.f1015k) {
            contains = dVar.f1013i.contains(b2);
        }
        return !contains;
    }
}
