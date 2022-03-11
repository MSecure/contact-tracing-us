package e.c0.a0;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.R$bool;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.utils.ForceStopRunnable;
import e.b.a.m;
import e.c0.a0.j;
import e.c0.a0.p.b.f;
import e.c0.a0.t.h;
import e.c0.a0.t.j;
import e.c0.a0.t.t.a;
import e.c0.a0.t.t.b;
import e.c0.c;
import e.c0.n;
import e.c0.p;
import e.c0.q;
import e.c0.s;
import e.c0.w;
import e.c0.x;
import e.v.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class l extends w {

    /* renamed from: j */
    public static l f1103j = null;

    /* renamed from: k */
    public static l f1104k = null;

    /* renamed from: l */
    public static final Object f1105l = new Object();
    public Context a;
    public c b;
    public WorkDatabase c;

    /* renamed from: d */
    public a f1106d;

    /* renamed from: e */
    public List<e> f1107e;

    /* renamed from: f */
    public d f1108f;

    /* renamed from: g */
    public h f1109g;

    /* renamed from: h */
    public boolean f1110h;

    /* renamed from: i */
    public BroadcastReceiver.PendingResult f1111i;

    static {
        n.e("WorkManagerImpl");
    }

    public l(Context context, c cVar, a aVar) {
        g.a aVar2;
        e eVar;
        boolean z = context.getResources().getBoolean(R$bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        j jVar = ((b) aVar).a;
        int i2 = WorkDatabase.f306l;
        e eVar2 = null;
        if (z) {
            aVar2 = new g.a(applicationContext, WorkDatabase.class, null);
            aVar2.f2072h = true;
        } else {
            String str = k.a;
            aVar2 = m.e.T(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            aVar2.f2071g = new h(applicationContext);
        }
        aVar2.f2069e = jVar;
        i iVar = new i();
        if (aVar2.f2068d == null) {
            aVar2.f2068d = new ArrayList<>();
        }
        aVar2.f2068d.add(iVar);
        aVar2.a(j.a);
        aVar2.a(new j.h(applicationContext, 2, 3));
        aVar2.a(j.b);
        aVar2.a(j.c);
        aVar2.a(new j.h(applicationContext, 5, 6));
        aVar2.a(j.f1099d);
        aVar2.a(j.f1100e);
        aVar2.a(j.f1101f);
        aVar2.a(new j.i(applicationContext));
        aVar2.a(new j.h(applicationContext, 10, 11));
        aVar2.a(j.f1102g);
        aVar2.f2073i = false;
        aVar2.f2074j = true;
        WorkDatabase workDatabase = (WorkDatabase) aVar2.b();
        Context applicationContext2 = context.getApplicationContext();
        n.a aVar3 = new n.a(cVar.f1237f);
        synchronized (n.class) {
            n.a = aVar3;
        }
        e[] eVarArr = new e[2];
        String str2 = f.a;
        if (Build.VERSION.SDK_INT >= 23) {
            eVar = new e.c0.a0.p.c.b(applicationContext2, this);
            e.c0.a0.t.g.a(applicationContext2, SystemJobService.class, true);
            n.c().a(f.a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        } else {
            try {
                eVar2 = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(applicationContext2);
                n.c().a(f.a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            } catch (Throwable th) {
                n.c().a(f.a, "Unable to create GCM Scheduler", th);
            }
            if (eVar2 == null) {
                eVar = new f(applicationContext2);
                e.c0.a0.t.g.a(applicationContext2, SystemAlarmService.class, true);
                n.c().a(f.a, "Created SystemAlarmScheduler", new Throwable[0]);
            } else {
                eVar = eVar2;
            }
        }
        eVarArr[0] = eVar;
        eVarArr[1] = new e.c0.a0.p.a.c(applicationContext2, cVar, aVar, this);
        List<e> asList = Arrays.asList(eVarArr);
        d dVar = new d(context, cVar, aVar, workDatabase, asList);
        Context applicationContext3 = context.getApplicationContext();
        this.a = applicationContext3;
        this.b = cVar;
        this.f1106d = aVar;
        this.c = workDatabase;
        this.f1107e = asList;
        this.f1108f = dVar;
        this.f1109g = new h(workDatabase);
        this.f1110h = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext3.isDeviceProtectedStorage()) {
            ((b) this.f1106d).a.execute(new ForceStopRunnable(applicationContext3, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static l h(Context context) {
        l lVar;
        Object obj = f1105l;
        synchronized (obj) {
            synchronized (obj) {
                lVar = f1103j;
                if (lVar == null) {
                    lVar = f1104k;
                }
            }
            return lVar;
        }
        if (lVar == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof c.b) {
                i(applicationContext, ((c.b) applicationContext).a());
                lVar = h(applicationContext);
            } else {
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
        }
        return lVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0016, code lost:
        r4 = r4.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (e.c0.a0.l.f1104k != null) goto L_0x002c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        e.c0.a0.l.f1104k = new e.c0.a0.l(r4, r5, new e.c0.a0.t.t.b(r5.b));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        e.c0.a0.l.f1103j = e.c0.a0.l.f1104k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static void i(Context context, c cVar) {
        synchronized (f1105l) {
            l lVar = f1103j;
            if (!(lVar == null || f1104k == null)) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
            }
        }
    }

    @Override // e.c0.w
    public q a() {
        e.c0.a0.t.c cVar = new e.c0.a0.t.c(this);
        ((b) this.f1106d).a.execute(cVar);
        return cVar.b;
    }

    @Override // e.c0.w
    public q b(String str) {
        e.c0.a0.t.b bVar = new e.c0.a0.t.b(this, str, true);
        ((b) this.f1106d).a.execute(bVar);
        return bVar.b;
    }

    @Override // e.c0.w
    public q d(List<? extends x> list) {
        if (!list.isEmpty()) {
            return new g(this, null, e.c0.h.KEEP, list, null).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override // e.c0.w
    public q e(String str, e.c0.g gVar, s sVar) {
        return new g(this, str, gVar == e.c0.g.KEEP ? e.c0.h.KEEP : e.c0.h.REPLACE, Collections.singletonList(sVar), null).a();
    }

    @Override // e.c0.w
    public q g(String str, e.c0.h hVar, List<p> list) {
        return new g(this, str, hVar, list, null).a();
    }

    public void j() {
        synchronized (f1105l) {
            this.f1110h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f1111i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f1111i = null;
            }
        }
    }

    public void k() {
        List<JobInfo> e2;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.a;
            String str = e.c0.a0.p.c.b.f1158f;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (!(jobScheduler == null || (e2 = e.c0.a0.p.c.b.e(context, jobScheduler)) == null || e2.isEmpty())) {
                for (JobInfo jobInfo : e2) {
                    e.c0.a0.p.c.b.a(jobScheduler, jobInfo.getId());
                }
            }
        }
        e.c0.a0.s.q qVar = (e.c0.a0.s.q) this.c.r();
        qVar.a.b();
        e.x.a.f.f a = qVar.f1205i.a();
        qVar.a.c();
        try {
            a.d();
            qVar.a.l();
            qVar.a.g();
            e.v.l lVar = qVar.f1205i;
            if (a == lVar.c) {
                lVar.a.set(false);
            }
            f.a(this.b, this.c, this.f1107e);
        } catch (Throwable th) {
            qVar.a.g();
            qVar.f1205i.c(a);
            throw th;
        }
    }

    public void l(String str) {
        a aVar = this.f1106d;
        ((b) aVar).a.execute(new e.c0.a0.t.l(this, str, false));
    }
}
