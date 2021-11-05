package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import b.b0.m;
import b.b0.y.b;
import b.b0.y.d;
import b.b0.y.k;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements b {

    /* renamed from: d  reason: collision with root package name */
    public static final String f469d = m.e("SystemJobService");

    /* renamed from: b  reason: collision with root package name */
    public k f470b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, JobParameters> f471c = new HashMap();

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

    @Override // b.b0.y.b
    public void a(String str, boolean z) {
        JobParameters remove;
        m.c().a(f469d, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.f471c) {
            remove = this.f471c.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            k b2 = k.b(getApplicationContext());
            this.f470b = b2;
            b2.f1099f.b(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                m.c().f(f469d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        k kVar = this.f470b;
        if (kVar != null) {
            kVar.f1099f.e(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = new androidx.work.WorkerParameters.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (r9.getTriggeredContentUris() == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r2.f449b = java.util.Arrays.asList(r9.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        if (r9.getTriggeredContentAuthorities() == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        r2.f448a = java.util.Arrays.asList(r9.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
        if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        r2.f450c = r9.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        r9 = r8.f470b;
        r3 = r9.f1097d;
        ((b.b0.y.s.s.b) r3).f1334a.execute(new b.b0.y.s.j(r9, r0, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b4, code lost:
        return true;
     */
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.f470b == null) {
            m.c().a(f469d, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String b2 = b(jobParameters);
        if (TextUtils.isEmpty(b2)) {
            m.c().b(f469d, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.f471c) {
            if (this.f471c.containsKey(b2)) {
                m.c().a(f469d, String.format("Job is already being executed by SystemJobService: %s", b2), new Throwable[0]);
                return false;
            }
            m.c().a(f469d, String.format("onStartJob for %s", b2), new Throwable[0]);
            this.f471c.put(b2, jobParameters);
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        boolean contains;
        if (this.f470b == null) {
            m.c().a(f469d, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String b2 = b(jobParameters);
        if (TextUtils.isEmpty(b2)) {
            m.c().b(f469d, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        m.c().a(f469d, String.format("onStopJob for %s", b2), new Throwable[0]);
        synchronized (this.f471c) {
            this.f471c.remove(b2);
        }
        this.f470b.e(b2);
        d dVar = this.f470b.f1099f;
        synchronized (dVar.l) {
            contains = dVar.j.contains(b2);
        }
        return !contains;
    }
}
