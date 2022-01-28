package e.b0.a0;

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
import e.b0.a0.j;
import e.b0.a0.p.b.f;
import e.b0.a0.t.h;
import e.b0.a0.t.j;
import e.b0.a0.t.t.a;
import e.b0.a0.t.t.b;
import e.b0.c;
import e.b0.n;
import e.b0.p;
import e.b0.q;
import e.b0.s;
import e.b0.w;
import e.b0.x;
import e.u.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l extends w {

    /* renamed from: j  reason: collision with root package name */
    public static l f1024j = null;

    /* renamed from: k  reason: collision with root package name */
    public static l f1025k = null;

    /* renamed from: l  reason: collision with root package name */
    public static final Object f1026l = new Object();
    public Context a;
    public c b;
    public WorkDatabase c;

    /* renamed from: d  reason: collision with root package name */
    public a f1027d;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f1028e;

    /* renamed from: f  reason: collision with root package name */
    public d f1029f;

    /* renamed from: g  reason: collision with root package name */
    public h f1030g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1031h;

    /* renamed from: i  reason: collision with root package name */
    public BroadcastReceiver.PendingResult f1032i;

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
            aVar2.f1987h = true;
        } else {
            String str = k.a;
            aVar2 = m.e.S(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            aVar2.f1986g = new h(applicationContext);
        }
        aVar2.f1984e = jVar;
        i iVar = new i();
        if (aVar2.f1983d == null) {
            aVar2.f1983d = new ArrayList<>();
        }
        aVar2.f1983d.add(iVar);
        aVar2.a(j.a);
        aVar2.a(new j.h(applicationContext, 2, 3));
        aVar2.a(j.b);
        aVar2.a(j.c);
        aVar2.a(new j.h(applicationContext, 5, 6));
        aVar2.a(j.f1020d);
        aVar2.a(j.f1021e);
        aVar2.a(j.f1022f);
        aVar2.a(new j.i(applicationContext));
        aVar2.a(new j.h(applicationContext, 10, 11));
        aVar2.a(j.f1023g);
        aVar2.f1988i = false;
        aVar2.f1989j = true;
        WorkDatabase workDatabase = (WorkDatabase) aVar2.b();
        Context applicationContext2 = context.getApplicationContext();
        n.a aVar3 = new n.a(cVar.f1158f);
        synchronized (n.class) {
            n.a = aVar3;
        }
        e[] eVarArr = new e[2];
        String str2 = f.a;
        if (Build.VERSION.SDK_INT >= 23) {
            eVar = new e.b0.a0.p.c.b(applicationContext2, this);
            e.b0.a0.t.g.a(applicationContext2, SystemJobService.class, true);
            n.c().a(f.a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        } else {
            try {
                e eVar3 = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(applicationContext2);
                n.c().a(f.a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
                eVar2 = eVar3;
            } catch (Throwable th) {
                n.c().a(f.a, "Unable to create GCM Scheduler", th);
            }
            if (eVar2 == null) {
                eVar = new f(applicationContext2);
                e.b0.a0.t.g.a(applicationContext2, SystemAlarmService.class, true);
                n.c().a(f.a, "Created SystemAlarmScheduler", new Throwable[0]);
            } else {
                eVar = eVar2;
            }
        }
        eVarArr[0] = eVar;
        eVarArr[1] = new e.b0.a0.p.a.c(applicationContext2, cVar, aVar, this);
        List<e> asList = Arrays.asList(eVarArr);
        d dVar = new d(context, cVar, aVar, workDatabase, asList);
        Context applicationContext3 = context.getApplicationContext();
        this.a = applicationContext3;
        this.b = cVar;
        this.f1027d = aVar;
        this.c = workDatabase;
        this.f1028e = asList;
        this.f1029f = dVar;
        this.f1030g = new h(workDatabase);
        this.f1031h = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext3.isDeviceProtectedStorage()) {
            a aVar4 = this.f1027d;
            ((b) aVar4).a.execute(new ForceStopRunnable(applicationContext3, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static l g(Context context) {
        l lVar;
        Object obj = f1026l;
        synchronized (obj) {
            synchronized (obj) {
                lVar = f1024j;
                if (lVar == null) {
                    lVar = f1025k;
                }
            }
            return lVar;
        }
        if (lVar == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof c.b) {
                h(applicationContext, ((c.b) applicationContext).a());
                lVar = g(applicationContext);
            } else {
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
        }
        return lVar;
    }

    public static void h(Context context, c cVar) {
        synchronized (f1026l) {
            l lVar = f1024j;
            if (lVar != null) {
                if (f1025k != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (lVar == null) {
                Context applicationContext = context.getApplicationContext();
                if (f1025k == null) {
                    f1025k = new l(applicationContext, cVar, new b(cVar.b));
                }
                f1024j = f1025k;
            }
        }
    }

    @Override // e.b0.w
    public q a() {
        e.b0.a0.t.c cVar = new e.b0.a0.t.c(this);
        ((b) this.f1027d).a.execute(cVar);
        return cVar.b;
    }

    @Override // e.b0.w
    public q b(String str) {
        e.b0.a0.t.b bVar = new e.b0.a0.t.b(this, str, true);
        ((b) this.f1027d).a.execute(bVar);
        return bVar.b;
    }

    @Override // e.b0.w
    public q d(List<? extends x> list) {
        if (!list.isEmpty()) {
            return new g(this, null, e.b0.h.KEEP, list, null).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override // e.b0.w
    public q e(String str, e.b0.g gVar, s sVar) {
        return new g(this, str, gVar == e.b0.g.KEEP ? e.b0.h.KEEP : e.b0.h.REPLACE, Collections.singletonList(sVar), null).a();
    }

    @Override // e.b0.w
    public q f(String str, e.b0.h hVar, List<p> list) {
        return new g(this, str, hVar, list, null).a();
    }

    public void i() {
        synchronized (f1026l) {
            this.f1031h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f1032i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f1032i = null;
            }
        }
    }

    public void j() {
        List<JobInfo> e2;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.a;
            String str = e.b0.a0.p.c.b.f1079f;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (!(jobScheduler == null || (e2 = e.b0.a0.p.c.b.e(context, jobScheduler)) == null || e2.isEmpty())) {
                for (JobInfo jobInfo : e2) {
                    e.b0.a0.p.c.b.a(jobScheduler, jobInfo.getId());
                }
            }
        }
        e.b0.a0.s.q qVar = (e.b0.a0.s.q) this.c.r();
        qVar.a.b();
        e.w.a.f.f a2 = qVar.f1126i.a();
        qVar.a.c();
        try {
            a2.d();
            qVar.a.l();
            qVar.a.g();
            e.u.l lVar = qVar.f1126i;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            f.a(this.b, this.c, this.f1028e);
        } catch (Throwable th) {
            qVar.a.g();
            qVar.f1126i.c(a2);
            throw th;
        }
    }

    public void k(String str) {
        a aVar = this.f1027d;
        ((b) aVar).a.execute(new e.b0.a0.t.l(this, str, false));
    }
}
