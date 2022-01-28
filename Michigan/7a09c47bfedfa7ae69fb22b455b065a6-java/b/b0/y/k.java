package b.b0.y;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import b.b0.b;
import b.b0.m;
import b.b0.s;
import b.b0.v;
import b.b0.y.o.a.c;
import b.b0.y.r.r;
import b.b0.y.s.g;
import b.b0.y.s.s.a;
import b.w.a.f;
import java.util.Arrays;
import java.util.List;

public class k extends v {
    public static final String k = m.e("WorkManagerImpl");
    public static k l = null;
    public static k m = null;
    public static final Object n = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Context f1094a;

    /* renamed from: b  reason: collision with root package name */
    public b f1095b;

    /* renamed from: c  reason: collision with root package name */
    public WorkDatabase f1096c;

    /* renamed from: d  reason: collision with root package name */
    public a f1097d;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f1098e;

    /* renamed from: f  reason: collision with root package name */
    public d f1099f;

    /* renamed from: g  reason: collision with root package name */
    public g f1100g;
    public boolean h;
    public BroadcastReceiver.PendingResult i;
    public volatile b.b0.z.a j;

    public k(Context context, b bVar, a aVar) {
        WorkDatabase a2 = WorkDatabase.a(context.getApplicationContext(), ((b.b0.y.s.s.b) aVar).f1334a, context.getResources().getBoolean(s.workmanager_test_configuration));
        Context applicationContext = context.getApplicationContext();
        m.a aVar2 = new m.a(bVar.h);
        synchronized (m.class) {
            m.f1039a = aVar2;
        }
        List<e> asList = Arrays.asList(f.a(applicationContext, this), new c(applicationContext, bVar, aVar, this));
        d dVar = new d(context, bVar, aVar, a2, asList);
        Context applicationContext2 = context.getApplicationContext();
        this.f1094a = applicationContext2;
        this.f1095b = bVar;
        this.f1097d = aVar;
        this.f1096c = a2;
        this.f1098e = asList;
        this.f1099f = dVar;
        this.f1100g = new g(a2);
        this.h = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext2.isDeviceProtectedStorage()) {
            a aVar3 = this.f1097d;
            ((b.b0.y.s.s.b) aVar3).f1334a.execute(new ForceStopRunnable(applicationContext2, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static k b(Context context) {
        k kVar;
        synchronized (n) {
            synchronized (n) {
                kVar = l != null ? l : m;
            }
            if (kVar == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof b.AbstractC0016b) {
                    c(applicationContext, ((b.AbstractC0016b) applicationContext).getWorkManagerConfiguration());
                    kVar = b(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return kVar;
    }

    public static void c(Context context, b bVar) {
        synchronized (n) {
            if (l != null) {
                if (m != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (l == null) {
                Context applicationContext = context.getApplicationContext();
                if (m == null) {
                    m = new k(applicationContext, bVar, new b.b0.y.s.s.b(bVar.f998b));
                }
                l = m;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void d() {
        b.b0.y.o.c.b.a(this.f1094a);
        r rVar = (r) this.f1096c.h();
        rVar.f1243a.assertNotSuspendingTransaction();
        f acquire = rVar.i.acquire();
        rVar.f1243a.beginTransaction();
        b.w.a.g.f fVar = (b.w.a.g.f) acquire;
        try {
            fVar.b();
            rVar.f1243a.setTransactionSuccessful();
            rVar.f1243a.endTransaction();
            rVar.i.release(fVar);
            f.b(this.f1095b, this.f1096c, this.f1098e);
        } catch (Throwable th) {
            rVar.f1243a.endTransaction();
            rVar.i.release(acquire);
            throw th;
        }
    }

    public void e(String str) {
        a aVar = this.f1097d;
        ((b.b0.y.s.s.b) aVar).f1334a.execute(new b.b0.y.s.k(this, str, false));
    }

    public final void f() {
        try {
            this.j = (b.b0.z.a) Class.forName("androidx.work.multiprocess.RemoteWorkManagerClient").getConstructor(Context.class, k.class).newInstance(this.f1094a, this);
        } catch (Throwable th) {
            m.c().a(k, "Unable to initialize multi-process support", th);
        }
    }
}
