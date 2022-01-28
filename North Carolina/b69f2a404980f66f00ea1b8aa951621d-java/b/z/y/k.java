package b.z.y;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import b.u.a.f;
import b.z.b;
import b.z.m;
import b.z.s;
import b.z.v;
import b.z.y.o.a.c;
import b.z.y.r.r;
import b.z.y.s.g;
import b.z.y.s.s.a;
import java.util.Arrays;
import java.util.List;

public class k extends v {
    public static final String k = m.e("WorkManagerImpl");
    public static k l = null;
    public static k m = null;
    public static final Object n = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Context f1969a;

    /* renamed from: b  reason: collision with root package name */
    public b f1970b;

    /* renamed from: c  reason: collision with root package name */
    public WorkDatabase f1971c;

    /* renamed from: d  reason: collision with root package name */
    public a f1972d;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f1973e;
    public d f;
    public g g;
    public boolean h;
    public BroadcastReceiver.PendingResult i;
    public volatile b.z.z.a j;

    public k(Context context, b bVar, a aVar) {
        WorkDatabase a2 = WorkDatabase.a(context.getApplicationContext(), ((b.z.y.s.s.b) aVar).f2183a, context.getResources().getBoolean(s.workmanager_test_configuration));
        Context applicationContext = context.getApplicationContext();
        m.a aVar2 = new m.a(bVar.h);
        synchronized (m.class) {
            m.f1923a = aVar2;
        }
        List<e> asList = Arrays.asList(f.a(applicationContext, this), new c(applicationContext, bVar, aVar, this));
        d dVar = new d(context, bVar, aVar, a2, asList);
        Context applicationContext2 = context.getApplicationContext();
        this.f1969a = applicationContext2;
        this.f1970b = bVar;
        this.f1972d = aVar;
        this.f1971c = a2;
        this.f1973e = asList;
        this.f = dVar;
        this.g = new g(a2);
        this.h = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext2.isDeviceProtectedStorage()) {
            a aVar3 = this.f1972d;
            ((b.z.y.s.s.b) aVar3).f2183a.execute(new ForceStopRunnable(applicationContext2, this));
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
                if (applicationContext instanceof b.AbstractC0050b) {
                    c(applicationContext, ((b.AbstractC0050b) applicationContext).a());
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
                    m = new k(applicationContext, bVar, new b.z.y.s.s.b(bVar.f1890b));
                }
                l = m;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void d() {
        b.z.y.o.c.b.a(this.f1969a);
        r rVar = (r) this.f1971c.h();
        rVar.f2098a.assertNotSuspendingTransaction();
        f acquire = rVar.i.acquire();
        rVar.f2098a.beginTransaction();
        b.u.a.g.f fVar = (b.u.a.g.f) acquire;
        try {
            fVar.b();
            rVar.f2098a.setTransactionSuccessful();
            rVar.f2098a.endTransaction();
            rVar.i.release(fVar);
            f.b(this.f1970b, this.f1971c, this.f1973e);
        } catch (Throwable th) {
            rVar.f2098a.endTransaction();
            rVar.i.release(acquire);
            throw th;
        }
    }

    public void e(String str) {
        a aVar = this.f1972d;
        ((b.z.y.s.s.b) aVar).f2183a.execute(new b.z.y.s.k(this, str, false));
    }

    public final void f() {
        try {
            this.j = (b.z.z.a) Class.forName("androidx.work.multiprocess.RemoteWorkManagerClient").getConstructor(Context.class, k.class).newInstance(this.f1969a, this);
        } catch (Throwable th) {
            m.c().a(k, "Unable to initialize multi-process support", th);
        }
    }
}
