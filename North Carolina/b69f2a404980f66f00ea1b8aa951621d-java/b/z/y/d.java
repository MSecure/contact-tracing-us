package b.z.y;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b.z.b;
import b.z.g;
import b.z.m;
import b.z.y.n;
import b.z.y.q.c;
import b.z.y.s.l;
import c.b.b.e.a.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class d implements b, b.z.y.q.a {
    public static final String m = m.e("Processor");

    /* renamed from: b  reason: collision with root package name */
    public PowerManager.WakeLock f1947b;

    /* renamed from: c  reason: collision with root package name */
    public Context f1948c;

    /* renamed from: d  reason: collision with root package name */
    public b f1949d;

    /* renamed from: e  reason: collision with root package name */
    public b.z.y.s.s.a f1950e;
    public WorkDatabase f;
    public Map<String, n> g = new HashMap();
    public Map<String, n> h = new HashMap();
    public List<e> i;
    public Set<String> j;
    public final List<b> k;
    public final Object l;

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public b f1951b;

        /* renamed from: c  reason: collision with root package name */
        public String f1952c;

        /* renamed from: d  reason: collision with root package name */
        public u<Boolean> f1953d;

        public a(b bVar, String str, u<Boolean> uVar) {
            this.f1951b = bVar;
            this.f1952c = str;
            this.f1953d = uVar;
        }

        public void run() {
            boolean z;
            try {
                z = this.f1953d.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.f1951b.a(this.f1952c, z);
        }
    }

    public d(Context context, b bVar, b.z.y.s.s.a aVar, WorkDatabase workDatabase, List<e> list) {
        this.f1948c = context;
        this.f1949d = bVar;
        this.f1950e = aVar;
        this.f = workDatabase;
        this.i = list;
        this.j = new HashSet();
        this.k = new ArrayList();
        this.f1947b = null;
        this.l = new Object();
    }

    public static boolean c(String str, n nVar) {
        boolean z;
        if (nVar != null) {
            nVar.t = true;
            nVar.i();
            u<ListenableWorker.a> uVar = nVar.s;
            if (uVar != null) {
                z = uVar.isDone();
                nVar.s.cancel(true);
            } else {
                z = false;
            }
            ListenableWorker listenableWorker = nVar.g;
            if (listenableWorker == null || z) {
                m.c().a(n.u, String.format("WorkSpec %s is already done. Not interrupting.", nVar.f), new Throwable[0]);
            } else {
                listenableWorker.stop();
            }
            m.c().a(m, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        m.c().a(m, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    @Override // b.z.y.b
    public void a(String str, boolean z) {
        synchronized (this.l) {
            this.h.remove(str);
            m.c().a(m, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            for (b bVar : this.k) {
                bVar.a(str, z);
            }
        }
    }

    public void b(b bVar) {
        synchronized (this.l) {
            this.k.add(bVar);
        }
    }

    public boolean d(String str) {
        boolean z;
        synchronized (this.l) {
            if (!this.h.containsKey(str)) {
                if (!this.g.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void e(b bVar) {
        synchronized (this.l) {
            this.k.remove(bVar);
        }
    }

    public void f(String str, g gVar) {
        synchronized (this.l) {
            m.c().d(m, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            n remove = this.h.remove(str);
            if (remove != null) {
                if (this.f1947b == null) {
                    PowerManager.WakeLock b2 = l.b(this.f1948c, "ProcessorForegroundLck");
                    this.f1947b = b2;
                    b2.acquire();
                }
                this.g.put(str, remove);
                b.i.e.a.e(this.f1948c, c.d(this.f1948c, str, gVar));
            }
        }
    }

    public boolean g(String str, WorkerParameters.a aVar) {
        synchronized (this.l) {
            if (d(str)) {
                m.c().a(m, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            n.a aVar2 = new n.a(this.f1948c, this.f1949d, this.f1950e, this, this.f, str);
            aVar2.g = this.i;
            if (aVar != null) {
                aVar2.h = aVar;
            }
            n nVar = new n(aVar2);
            b.z.y.s.r.c<Boolean> cVar = nVar.r;
            cVar.b(new a(this, str, cVar), ((b.z.y.s.s.b) this.f1950e).f2185c);
            this.h.put(str, nVar);
            ((b.z.y.s.s.b) this.f1950e).f2183a.execute(nVar);
            m.c().a(m, String.format("%s: processing %s", d.class.getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public final void h() {
        synchronized (this.l) {
            if (!(!this.g.isEmpty())) {
                try {
                    this.f1948c.startService(c.f(this.f1948c));
                } catch (Throwable th) {
                    m.c().b(m, "Unable to stop foreground service", th);
                }
                if (this.f1947b != null) {
                    this.f1947b.release();
                    this.f1947b = null;
                }
            }
        }
    }

    public boolean i(String str) {
        boolean c2;
        synchronized (this.l) {
            m.c().a(m, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            c2 = c(str, this.g.remove(str));
        }
        return c2;
    }

    public boolean j(String str) {
        boolean c2;
        synchronized (this.l) {
            m.c().a(m, String.format("Processor stopping background work %s", str), new Throwable[0]);
            c2 = c(str, this.h.remove(str));
        }
        return c2;
    }
}
