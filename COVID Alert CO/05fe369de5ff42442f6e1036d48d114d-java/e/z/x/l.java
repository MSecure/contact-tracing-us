package e.z.x;

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
import e.t.g;
import e.z.b;
import e.z.l;
import e.z.n;
import e.z.o;
import e.z.p;
import e.z.t;
import e.z.u;
import e.z.x.j;
import e.z.x.p.a.c;
import e.z.x.s.q;
import e.z.x.t.f;
import e.z.x.t.g;
import e.z.x.t.i;
import e.z.x.t.k;
import e.z.x.t.q.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l extends t {

    /* renamed from: k  reason: collision with root package name */
    public static final String f1901k = e.z.l.e("WorkManagerImpl");

    /* renamed from: l  reason: collision with root package name */
    public static l f1902l = null;
    public static l m = null;
    public static final Object n = new Object();
    public Context a;
    public b b;
    public WorkDatabase c;

    /* renamed from: d  reason: collision with root package name */
    public a f1903d;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f1904e;

    /* renamed from: f  reason: collision with root package name */
    public d f1905f;

    /* renamed from: g  reason: collision with root package name */
    public g f1906g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1907h;

    /* renamed from: i  reason: collision with root package name */
    public BroadcastReceiver.PendingResult f1908i;

    /* renamed from: j  reason: collision with root package name */
    public volatile e.z.y.a f1909j;

    public l(Context context, b bVar, a aVar) {
        g.a aVar2;
        e eVar;
        boolean z = context.getResources().getBoolean(R$bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        i iVar = ((e.z.x.t.q.b) aVar).a;
        int i2 = WorkDatabase.f302l;
        e eVar2 = null;
        if (z) {
            aVar2 = new g.a(applicationContext, WorkDatabase.class, null);
            aVar2.f1712h = true;
        } else {
            String str = k.a;
            aVar2 = m.h.Q(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            aVar2.f1711g = new h(applicationContext);
        }
        aVar2.f1709e = iVar;
        i iVar2 = new i();
        if (aVar2.f1708d == null) {
            aVar2.f1708d = new ArrayList<>();
        }
        aVar2.f1708d.add(iVar2);
        aVar2.a(j.a);
        aVar2.a(new j.g(applicationContext, 2, 3));
        aVar2.a(j.b);
        aVar2.a(j.c);
        aVar2.a(new j.g(applicationContext, 5, 6));
        aVar2.a(j.f1898d);
        aVar2.a(j.f1899e);
        aVar2.a(j.f1900f);
        aVar2.a(new j.h(applicationContext));
        aVar2.a(new j.g(applicationContext, 10, 11));
        aVar2.f1713i = false;
        aVar2.f1714j = true;
        WorkDatabase workDatabase = (WorkDatabase) aVar2.b();
        Context applicationContext2 = context.getApplicationContext();
        l.a aVar3 = new l.a(bVar.f1857f);
        synchronized (e.z.l.class) {
            e.z.l.a = aVar3;
        }
        e[] eVarArr = new e[2];
        String str2 = f.a;
        if (Build.VERSION.SDK_INT >= 23) {
            eVar = new e.z.x.p.c.b(applicationContext2, this);
            f.a(applicationContext2, SystemJobService.class, true);
            e.z.l.c().a(f.a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        } else {
            try {
                e eVar3 = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(applicationContext2);
                e.z.l.c().a(f.a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
                eVar2 = eVar3;
            } catch (Throwable th) {
                e.z.l.c().a(f.a, "Unable to create GCM Scheduler", th);
            }
            if (eVar2 == null) {
                eVar = new e.z.x.p.b.f(applicationContext2);
                f.a(applicationContext2, SystemAlarmService.class, true);
                e.z.l.c().a(f.a, "Created SystemAlarmScheduler", new Throwable[0]);
            } else {
                eVar = eVar2;
            }
        }
        eVarArr[0] = eVar;
        eVarArr[1] = new c(applicationContext2, bVar, aVar, this);
        List<e> asList = Arrays.asList(eVarArr);
        d dVar = new d(context, bVar, aVar, workDatabase, asList);
        Context applicationContext3 = context.getApplicationContext();
        this.a = applicationContext3;
        this.b = bVar;
        this.f1903d = aVar;
        this.c = workDatabase;
        this.f1904e = asList;
        this.f1905f = dVar;
        this.f1906g = new e.z.x.t.g(workDatabase);
        this.f1907h = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext3.isDeviceProtectedStorage()) {
            a aVar4 = this.f1903d;
            ((e.z.x.t.q.b) aVar4).a.execute(new ForceStopRunnable(applicationContext3, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static l f(Context context) {
        l lVar;
        Object obj = n;
        synchronized (obj) {
            synchronized (obj) {
                lVar = f1902l;
                if (lVar == null) {
                    lVar = m;
                }
            }
            return lVar;
        }
        if (lVar == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof b.AbstractC0062b) {
                g(applicationContext, ((b.AbstractC0062b) applicationContext).a());
                lVar = f(applicationContext);
            } else {
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
        }
        return lVar;
    }

    public static void g(Context context, b bVar) {
        synchronized (n) {
            l lVar = f1902l;
            if (lVar != null) {
                if (m != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (lVar == null) {
                Context applicationContext = context.getApplicationContext();
                if (m == null) {
                    m = new l(applicationContext, bVar, new e.z.x.t.q.b(bVar.b));
                }
                f1902l = m;
            }
        }
    }

    @Override // e.z.t
    public o a(String str) {
        e.z.x.t.b bVar = new e.z.x.t.b(this, str, true);
        ((e.z.x.t.q.b) this.f1903d).a.execute(bVar);
        return bVar.b;
    }

    @Override // e.z.t
    public o c(List<? extends u> list) {
        if (!list.isEmpty()) {
            return new g(this, null, e.z.g.KEEP, list, null).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override // e.z.t
    public o d(String str, e.z.f fVar, p pVar) {
        return new g(this, str, fVar == e.z.f.KEEP ? e.z.g.KEEP : e.z.g.REPLACE, Collections.singletonList(pVar), null).a();
    }

    @Override // e.z.t
    public o e(String str, e.z.g gVar, List<n> list) {
        return new g(this, str, gVar, list, null).a();
    }

    public void h() {
        List<JobInfo> e2;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.a;
            String str = e.z.x.p.c.b.f1955f;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (!(jobScheduler == null || (e2 = e.z.x.p.c.b.e(context, jobScheduler)) == null || e2.isEmpty())) {
                for (JobInfo jobInfo : e2) {
                    e.z.x.p.c.b.a(jobScheduler, jobInfo.getId());
                }
            }
        }
        q qVar = (q) this.c.r();
        qVar.a.b();
        e.v.a.f.f a2 = qVar.f2002i.a();
        qVar.a.c();
        try {
            a2.d();
            qVar.a.l();
            qVar.a.g();
            e.t.l lVar = qVar.f2002i;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            f.a(this.b, this.c, this.f1904e);
        } catch (Throwable th) {
            qVar.a.g();
            qVar.f2002i.c(a2);
            throw th;
        }
    }

    public void i(String str) {
        a aVar = this.f1903d;
        ((e.z.x.t.q.b) aVar).a.execute(new k(this, str, false));
    }

    public final void j() {
        try {
            this.f1909j = (e.z.y.a) Class.forName("androidx.work.multiprocess.RemoteWorkManagerClient").getConstructor(Context.class, l.class).newInstance(this.a, this);
        } catch (Throwable th) {
            e.z.l.c().a(f1901k, "Unable to initialize multi-process support", th);
        }
    }
}
