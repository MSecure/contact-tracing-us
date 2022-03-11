package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import e.c0.a0.b;
import e.c0.a0.d;
import e.c0.a0.l;
import e.c0.a0.t.k;
import e.c0.n;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SystemJobService extends JobService implements b {

    /* renamed from: d */
    public static final String f310d = n.e("SystemJobService");
    public l b;
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

    @Override // e.c0.a0.b
    public void a(String str, boolean z) {
        JobParameters remove;
        n.c().a(f310d, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.c) {
            remove = this.c.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            l h2 = l.h(getApplicationContext());
            this.b = h2;
            h2.f1108f.b(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                n.c().f(f310d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        l lVar = this.b;
        if (lVar != null) {
            lVar.f1108f.e(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.b == null) {
            n.c().a(f310d, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String b = b(jobParameters);
        if (TextUtils.isEmpty(b)) {
            n.c().b(f310d, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.c) {
            if (this.c.containsKey(b)) {
                n.c().a(f310d, String.format("Job is already being executed by SystemJobService: %s", b), new Throwable[0]);
                return false;
            }
            n.c().a(f310d, String.format("onStartJob for %s", b), new Throwable[0]);
            this.c.put(b, jobParameters);
            WorkerParameters.a aVar = null;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                aVar = new WorkerParameters.a();
                if (jobParameters.getTriggeredContentUris() != null) {
                    aVar.b = Arrays.asList(jobParameters.getTriggeredContentUris());
                }
                if (jobParameters.getTriggeredContentAuthorities() != null) {
                    aVar.a = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
                }
                if (i2 >= 28) {
                    jobParameters.getNetwork();
                }
            }
            l lVar = this.b;
            ((e.c0.a0.t.t.b) lVar.f1106d).a.execute(new k(lVar, b, aVar));
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        boolean contains;
        if (this.b == null) {
            n.c().a(f310d, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String b = b(jobParameters);
        if (TextUtils.isEmpty(b)) {
            n.c().b(f310d, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        n.c().a(f310d, String.format("onStopJob for %s", b), new Throwable[0]);
        synchronized (this.c) {
            this.c.remove(b);
        }
        this.b.l(b);
        d dVar = this.b.f1108f;
        synchronized (dVar.f1090l) {
            contains = dVar.f1088j.contains(b);
        }
        return !contains;
    }
}
