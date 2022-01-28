package e.z.x;

import android.content.Context;
import android.content.Intent;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import e.z.b;
import e.z.l;
import e.z.x.o;
import e.z.x.t.p.c;
import f.b.b.f.a.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class d implements b, e.z.x.r.a {

    /* renamed from: l  reason: collision with root package name */
    public static final String f1881l = l.e("Processor");
    public Context b;
    public b c;

    /* renamed from: d  reason: collision with root package name */
    public e.z.x.t.q.a f1882d;

    /* renamed from: e  reason: collision with root package name */
    public WorkDatabase f1883e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, o> f1884f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, o> f1885g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public List<e> f1886h;

    /* renamed from: i  reason: collision with root package name */
    public Set<String> f1887i;

    /* renamed from: j  reason: collision with root package name */
    public final List<b> f1888j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f1889k;

    public static class a implements Runnable {
        public b b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public u<Boolean> f1890d;

        public a(b bVar, String str, u<Boolean> uVar) {
            this.b = bVar;
            this.c = str;
            this.f1890d = uVar;
        }

        public void run() {
            boolean z;
            try {
                z = this.f1890d.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.b.a(this.c, z);
        }
    }

    public d(Context context, b bVar, e.z.x.t.q.a aVar, WorkDatabase workDatabase, List<e> list) {
        this.b = context;
        this.c = bVar;
        this.f1882d = aVar;
        this.f1883e = workDatabase;
        this.f1886h = list;
        this.f1887i = new HashSet();
        this.f1888j = new ArrayList();
        this.f1889k = new Object();
    }

    public static boolean c(String str, o oVar) {
        boolean z;
        if (oVar != null) {
            oVar.t = true;
            oVar.i();
            u<ListenableWorker.a> uVar = oVar.s;
            if (uVar != null) {
                z = uVar.isDone();
                oVar.s.cancel(true);
            } else {
                z = false;
            }
            ListenableWorker listenableWorker = oVar.f1914g;
            if (listenableWorker == null || z) {
                l.c().a(o.u, String.format("WorkSpec %s is already done. Not interrupting.", oVar.f1913f), new Throwable[0]);
            } else {
                listenableWorker.b();
            }
            l.c().a(f1881l, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        l.c().a(f1881l, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    @Override // e.z.x.b
    public void a(String str, boolean z) {
        synchronized (this.f1889k) {
            this.f1885g.remove(str);
            l.c().a(f1881l, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            for (b bVar : this.f1888j) {
                bVar.a(str, z);
            }
        }
    }

    public void b(b bVar) {
        synchronized (this.f1889k) {
            this.f1888j.add(bVar);
        }
    }

    public boolean d(String str) {
        boolean z;
        synchronized (this.f1889k) {
            if (!this.f1885g.containsKey(str)) {
                if (!this.f1884f.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void e(b bVar) {
        synchronized (this.f1889k) {
            this.f1888j.remove(bVar);
        }
    }

    public boolean f(String str, WorkerParameters.a aVar) {
        synchronized (this.f1889k) {
            if (d(str)) {
                l.c().a(f1881l, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            o.a aVar2 = new o.a(this.b, this.c, this.f1882d, this, this.f1883e, str);
            aVar2.f1923g = this.f1886h;
            if (aVar != null) {
                aVar2.f1924h = aVar;
            }
            o oVar = new o(aVar2);
            c<Boolean> cVar = oVar.r;
            cVar.a(new a(this, str, cVar), ((e.z.x.t.q.b) this.f1882d).c);
            this.f1885g.put(str, oVar);
            ((e.z.x.t.q.b) this.f1882d).a.execute(oVar);
            l.c().a(f1881l, String.format("%s: processing %s", d.class.getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public final void g() {
        synchronized (this.f1889k) {
            if (!(!this.f1884f.isEmpty())) {
                Context context = this.b;
                String str = e.z.x.r.c.f1978l;
                Intent intent = new Intent(context, SystemForegroundService.class);
                intent.setAction("ACTION_STOP_FOREGROUND");
                this.b.startService(intent);
            }
        }
    }

    public boolean h(String str) {
        boolean c2;
        synchronized (this.f1889k) {
            l.c().a(f1881l, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            c2 = c(str, this.f1884f.remove(str));
        }
        return c2;
    }

    public boolean i(String str) {
        boolean c2;
        synchronized (this.f1889k) {
            l.c().a(f1881l, String.format("Processor stopping background work %s", str), new Throwable[0]);
            c2 = c(str, this.f1885g.remove(str));
        }
        return c2;
    }
}
