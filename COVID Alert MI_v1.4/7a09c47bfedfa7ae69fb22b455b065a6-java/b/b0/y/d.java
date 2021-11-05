package b.b0.y;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b.b0.b;
import b.b0.g;
import b.b0.m;
import b.b0.y.n;
import b.b0.y.q.c;
import b.b0.y.s.l;
import c.b.b.e.a.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class d implements b, b.b0.y.q.a {
    public static final String m = m.e("Processor");

    /* renamed from: b  reason: collision with root package name */
    public PowerManager.WakeLock f1067b;

    /* renamed from: c  reason: collision with root package name */
    public Context f1068c;

    /* renamed from: d  reason: collision with root package name */
    public b f1069d;

    /* renamed from: e  reason: collision with root package name */
    public b.b0.y.s.s.a f1070e;

    /* renamed from: f  reason: collision with root package name */
    public WorkDatabase f1071f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, n> f1072g = new HashMap();
    public Map<String, n> h = new HashMap();
    public List<e> i;
    public Set<String> j;
    public final List<b> k;
    public final Object l;

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public b f1073b;

        /* renamed from: c  reason: collision with root package name */
        public String f1074c;

        /* renamed from: d  reason: collision with root package name */
        public u<Boolean> f1075d;

        public a(b bVar, String str, u<Boolean> uVar) {
            this.f1073b = bVar;
            this.f1074c = str;
            this.f1075d = uVar;
        }

        public void run() {
            boolean z;
            try {
                z = this.f1075d.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.f1073b.a(this.f1074c, z);
        }
    }

    public d(Context context, b bVar, b.b0.y.s.s.a aVar, WorkDatabase workDatabase, List<e> list) {
        this.f1068c = context;
        this.f1069d = bVar;
        this.f1070e = aVar;
        this.f1071f = workDatabase;
        this.i = list;
        this.j = new HashSet();
        this.k = new ArrayList();
        this.f1067b = null;
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
            ListenableWorker listenableWorker = nVar.f1111g;
            if (listenableWorker == null || z) {
                m.c().a(n.u, String.format("WorkSpec %s is already done. Not interrupting.", nVar.f1110f), new Throwable[0]);
            } else {
                listenableWorker.stop();
            }
            m.c().a(m, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        m.c().a(m, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    @Override // b.b0.y.b
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
                if (!this.f1072g.containsKey(str)) {
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
                if (this.f1067b == null) {
                    PowerManager.WakeLock b2 = l.b(this.f1068c, "ProcessorForegroundLck");
                    this.f1067b = b2;
                    b2.acquire();
                }
                this.f1072g.put(str, remove);
                b.i.e.a.f(this.f1068c, c.d(this.f1068c, str, gVar));
            }
        }
    }

    public boolean g(String str, WorkerParameters.a aVar) {
        synchronized (this.l) {
            if (d(str)) {
                m.c().a(m, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            n.a aVar2 = new n.a(this.f1068c, this.f1069d, this.f1070e, this, this.f1071f, str);
            aVar2.f1118g = this.i;
            if (aVar != null) {
                aVar2.h = aVar;
            }
            n nVar = new n(aVar2);
            b.b0.y.s.r.c<Boolean> cVar = nVar.r;
            cVar.b(new a(this, str, cVar), ((b.b0.y.s.s.b) this.f1070e).f1336c);
            this.h.put(str, nVar);
            ((b.b0.y.s.s.b) this.f1070e).f1334a.execute(nVar);
            m.c().a(m, String.format("%s: processing %s", d.class.getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public final void h() {
        synchronized (this.l) {
            if (!(!this.f1072g.isEmpty())) {
                try {
                    this.f1068c.startService(c.f(this.f1068c));
                } catch (Throwable th) {
                    m.c().b(m, "Unable to stop foreground service", th);
                }
                if (this.f1067b != null) {
                    this.f1067b.release();
                    this.f1067b = null;
                }
            }
        }
    }

    public boolean i(String str) {
        boolean c2;
        synchronized (this.l) {
            m.c().a(m, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            c2 = c(str, this.f1072g.remove(str));
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
