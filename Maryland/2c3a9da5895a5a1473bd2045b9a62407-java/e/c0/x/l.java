package e.c0.x;

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
import e.c0.b;
import e.c0.l;
import e.c0.o;
import e.c0.p;
import e.c0.t;
import e.c0.u;
import e.c0.x.j;
import e.c0.x.p.a.c;
import e.c0.x.s.q;
import e.c0.x.t.f;
import e.c0.x.t.g;
import e.c0.x.t.i;
import e.c0.x.t.k;
import e.c0.x.t.q.a;
import e.t.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l extends t {

    /* renamed from: k  reason: collision with root package name */
    public static final String f1046k = e.c0.l.e("WorkManagerImpl");

    /* renamed from: l  reason: collision with root package name */
    public static l f1047l = null;
    public static l m = null;
    public static final Object n = new Object();
    public Context a;
    public b b;
    public WorkDatabase c;

    /* renamed from: d  reason: collision with root package name */
    public a f1048d;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f1049e;

    /* renamed from: f  reason: collision with root package name */
    public d f1050f;

    /* renamed from: g  reason: collision with root package name */
    public g f1051g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1052h;

    /* renamed from: i  reason: collision with root package name */
    public BroadcastReceiver.PendingResult f1053i;

    /* renamed from: j  reason: collision with root package name */
    public volatile e.c0.y.a f1054j;

    public l(Context context, b bVar, a aVar) {
        g.a aVar2;
        e eVar;
        boolean z = context.getResources().getBoolean(R$bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        i iVar = ((e.c0.x.t.q.b) aVar).a;
        int i2 = WorkDatabase.f314l;
        e eVar2 = null;
        if (z) {
            aVar2 = new g.a(applicationContext, WorkDatabase.class, null);
            aVar2.f1896h = true;
        } else {
            String str = k.a;
            aVar2 = m.h.P(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            aVar2.f1895g = new h(applicationContext);
        }
        aVar2.f1893e = iVar;
        i iVar2 = new i();
        if (aVar2.f1892d == null) {
            aVar2.f1892d = new ArrayList<>();
        }
        aVar2.f1892d.add(iVar2);
        aVar2.a(j.a);
        aVar2.a(new j.g(applicationContext, 2, 3));
        aVar2.a(j.b);
        aVar2.a(j.c);
        aVar2.a(new j.g(applicationContext, 5, 6));
        aVar2.a(j.f1043d);
        aVar2.a(j.f1044e);
        aVar2.a(j.f1045f);
        aVar2.a(new j.h(applicationContext));
        aVar2.a(new j.g(applicationContext, 10, 11));
        aVar2.f1897i = false;
        aVar2.f1898j = true;
        WorkDatabase workDatabase = (WorkDatabase) aVar2.b();
        int i3 = Build.VERSION.SDK_INT;
        Context applicationContext2 = context.getApplicationContext();
        l.a aVar3 = new l.a(bVar.f1002f);
        synchronized (e.c0.l.class) {
            e.c0.l.a = aVar3;
        }
        e[] eVarArr = new e[2];
        String str2 = f.a;
        if (i3 >= 23) {
            eVar = new e.c0.x.p.c.b(applicationContext2, this);
            f.a(applicationContext2, SystemJobService.class, true);
            e.c0.l.c().a(f.a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        } else {
            try {
                e eVar3 = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(applicationContext2);
                e.c0.l.c().a(f.a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
                eVar2 = eVar3;
            } catch (Throwable th) {
                e.c0.l.c().a(f.a, "Unable to create GCM Scheduler", th);
            }
            if (eVar2 == null) {
                eVar = new e.c0.x.p.b.f(applicationContext2);
                f.a(applicationContext2, SystemAlarmService.class, true);
                e.c0.l.c().a(f.a, "Created SystemAlarmScheduler", new Throwable[0]);
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
        this.f1048d = aVar;
        this.c = workDatabase;
        this.f1049e = asList;
        this.f1050f = dVar;
        this.f1051g = new e.c0.x.t.g(workDatabase);
        this.f1052h = false;
        if (i3 < 24 || !applicationContext3.isDeviceProtectedStorage()) {
            a aVar4 = this.f1048d;
            ((e.c0.x.t.q.b) aVar4).a.execute(new ForceStopRunnable(applicationContext3, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static l d(Context context) {
        l lVar;
        Object obj = n;
        synchronized (obj) {
            synchronized (obj) {
                lVar = f1047l;
                if (lVar == null) {
                    lVar = m;
                }
            }
            return lVar;
        }
        if (lVar == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof b.AbstractC0023b) {
                e(applicationContext, ((b.AbstractC0023b) applicationContext).a());
                lVar = d(applicationContext);
            } else {
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
        }
        return lVar;
    }

    public static void e(Context context, b bVar) {
        synchronized (n) {
            l lVar = f1047l;
            if (lVar != null) {
                if (m != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (lVar == null) {
                Context applicationContext = context.getApplicationContext();
                if (m == null) {
                    m = new l(applicationContext, bVar, new e.c0.x.t.q.b(bVar.b));
                }
                f1047l = m;
            }
        }
    }

    @Override // e.c0.t
    public o b(List<? extends u> list) {
        if (!list.isEmpty()) {
            return new g(this, null, e.c0.g.KEEP, list, null).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override // e.c0.t
    public o c(String str, e.c0.f fVar, p pVar) {
        return new g(this, str, fVar == e.c0.f.KEEP ? e.c0.g.KEEP : e.c0.g.REPLACE, Collections.singletonList(pVar), null).a();
    }

    public void f() {
        List<JobInfo> e2;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.a;
            String str = e.c0.x.p.c.b.f1100f;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (!(jobScheduler == null || (e2 = e.c0.x.p.c.b.e(context, jobScheduler)) == null || e2.isEmpty())) {
                for (JobInfo jobInfo : e2) {
                    e.c0.x.p.c.b.a(jobScheduler, jobInfo.getId());
                }
            }
        }
        q qVar = (q) this.c.r();
        qVar.a.b();
        e.v.a.f.f a2 = qVar.f1147i.a();
        qVar.a.c();
        try {
            a2.d();
            qVar.a.l();
            qVar.a.g();
            e.t.l lVar = qVar.f1147i;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
            f.a(this.b, this.c, this.f1049e);
        } catch (Throwable th) {
            qVar.a.g();
            qVar.f1147i.c(a2);
            throw th;
        }
    }

    public void g(String str) {
        a aVar = this.f1048d;
        ((e.c0.x.t.q.b) aVar).a.execute(new k(this, str, false));
    }

    public final void h() {
        try {
            this.f1054j = (e.c0.y.a) Class.forName("androidx.work.multiprocess.RemoteWorkManagerClient").getConstructor(Context.class, l.class).newInstance(this.a, this);
        } catch (Throwable th) {
            e.c0.l.c().a(f1046k, "Unable to initialize multi-process support", th);
        }
    }
}
