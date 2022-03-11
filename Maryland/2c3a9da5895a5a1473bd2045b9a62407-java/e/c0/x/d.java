package e.c0.x;

import android.content.Context;
import android.content.Intent;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import e.c0.b;
import e.c0.l;
import e.c0.x.o;
import e.c0.x.t.p.c;
import f.b.b.f.a.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class d implements b, e.c0.x.r.a {

    /* renamed from: l  reason: collision with root package name */
    public static final String f1026l = l.e("Processor");
    public Context b;
    public b c;

    /* renamed from: d  reason: collision with root package name */
    public e.c0.x.t.q.a f1027d;

    /* renamed from: e  reason: collision with root package name */
    public WorkDatabase f1028e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, o> f1029f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, o> f1030g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public List<e> f1031h;

    /* renamed from: i  reason: collision with root package name */
    public Set<String> f1032i;

    /* renamed from: j  reason: collision with root package name */
    public final List<b> f1033j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f1034k;

    public static class a implements Runnable {
        public b b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public u<Boolean> f1035d;

        public a(b bVar, String str, u<Boolean> uVar) {
            this.b = bVar;
            this.c = str;
            this.f1035d = uVar;
        }

        public void run() {
            boolean z;
            try {
                z = this.f1035d.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.b.a(this.c, z);
        }
    }

    public d(Context context, b bVar, e.c0.x.t.q.a aVar, WorkDatabase workDatabase, List<e> list) {
        this.b = context;
        this.c = bVar;
        this.f1027d = aVar;
        this.f1028e = workDatabase;
        this.f1031h = list;
        this.f1032i = new HashSet();
        this.f1033j = new ArrayList();
        this.f1034k = new Object();
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
            ListenableWorker listenableWorker = oVar.f1059g;
            if (listenableWorker == null || z) {
                l.c().a(o.u, String.format("WorkSpec %s is already done. Not interrupting.", oVar.f1058f), new Throwable[0]);
            } else {
                listenableWorker.b();
            }
            l.c().a(f1026l, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        l.c().a(f1026l, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    @Override // e.c0.x.b
    public void a(String str, boolean z) {
        synchronized (this.f1034k) {
            this.f1030g.remove(str);
            l.c().a(f1026l, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            for (b bVar : this.f1033j) {
                bVar.a(str, z);
            }
        }
    }

    public void b(b bVar) {
        synchronized (this.f1034k) {
            this.f1033j.add(bVar);
        }
    }

    public boolean d(String str) {
        boolean z;
        synchronized (this.f1034k) {
            if (!this.f1030g.containsKey(str)) {
                if (!this.f1029f.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void e(b bVar) {
        synchronized (this.f1034k) {
            this.f1033j.remove(bVar);
        }
    }

    public boolean f(String str, WorkerParameters.a aVar) {
        synchronized (this.f1034k) {
            if (d(str)) {
                l.c().a(f1026l, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            o.a aVar2 = new o.a(this.b, this.c, this.f1027d, this, this.f1028e, str);
            aVar2.f1068g = this.f1031h;
            if (aVar != null) {
                aVar2.f1069h = aVar;
            }
            o oVar = new o(aVar2);
            c<Boolean> cVar = oVar.r;
            cVar.a(new a(this, str, cVar), ((e.c0.x.t.q.b) this.f1027d).c);
            this.f1030g.put(str, oVar);
            ((e.c0.x.t.q.b) this.f1027d).a.execute(oVar);
            l.c().a(f1026l, String.format("%s: processing %s", d.class.getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public final void g() {
        synchronized (this.f1034k) {
            if (!(!this.f1029f.isEmpty())) {
                Context context = this.b;
                String str = e.c0.x.r.c.f1123l;
                Intent intent = new Intent(context, SystemForegroundService.class);
                intent.setAction("ACTION_STOP_FOREGROUND");
                this.b.startService(intent);
            }
        }
    }

    public boolean h(String str) {
        boolean c2;
        synchronized (this.f1034k) {
            l.c().a(f1026l, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            c2 = c(str, this.f1029f.remove(str));
        }
        return c2;
    }

    public boolean i(String str) {
        boolean c2;
        synchronized (this.f1034k) {
            l.c().a(f1026l, String.format("Processor stopping background work %s", str), new Throwable[0]);
            c2 = c(str, this.f1030g.remove(str));
        }
        return c2;
    }
}
