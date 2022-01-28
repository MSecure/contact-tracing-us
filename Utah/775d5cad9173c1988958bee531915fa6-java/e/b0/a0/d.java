package e.b0.a0;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import e.b0.a0.o;
import e.b0.a0.t.m;
import e.b0.a0.t.t.b;
import e.b0.c;
import e.b0.i;
import e.b0.n;
import e.i.b.a;
import f.b.b.f.a.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class d implements b, e.b0.a0.r.a {
    public static final String m = n.e("Processor");
    public PowerManager.WakeLock b;
    public Context c;

    /* renamed from: d  reason: collision with root package name */
    public c f1003d;

    /* renamed from: e  reason: collision with root package name */
    public e.b0.a0.t.t.a f1004e;

    /* renamed from: f  reason: collision with root package name */
    public WorkDatabase f1005f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, o> f1006g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public Map<String, o> f1007h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public List<e> f1008i;

    /* renamed from: j  reason: collision with root package name */
    public Set<String> f1009j;

    /* renamed from: k  reason: collision with root package name */
    public final List<b> f1010k;

    /* renamed from: l  reason: collision with root package name */
    public final Object f1011l;

    public static class a implements Runnable {
        public b b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public u<Boolean> f1012d;

        public a(b bVar, String str, u<Boolean> uVar) {
            this.b = bVar;
            this.c = str;
            this.f1012d = uVar;
        }

        public void run() {
            boolean z;
            try {
                z = this.f1012d.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.b.a(this.c, z);
        }
    }

    public d(Context context, c cVar, e.b0.a0.t.t.a aVar, WorkDatabase workDatabase, List<e> list) {
        this.c = context;
        this.f1003d = cVar;
        this.f1004e = aVar;
        this.f1005f = workDatabase;
        this.f1008i = list;
        this.f1009j = new HashSet();
        this.f1010k = new ArrayList();
        this.b = null;
        this.f1011l = new Object();
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
            ListenableWorker listenableWorker = oVar.f1038g;
            if (listenableWorker == null || z) {
                n.c().a(o.u, String.format("WorkSpec %s is already done. Not interrupting.", oVar.f1037f), new Throwable[0]);
            } else {
                listenableWorker.f299d = true;
                listenableWorker.b();
            }
            n.c().a(m, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        n.c().a(m, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    @Override // e.b0.a0.b
    public void a(String str, boolean z) {
        synchronized (this.f1011l) {
            this.f1007h.remove(str);
            n.c().a(m, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            for (b bVar : this.f1010k) {
                bVar.a(str, z);
            }
        }
    }

    public void b(b bVar) {
        synchronized (this.f1011l) {
            this.f1010k.add(bVar);
        }
    }

    public boolean d(String str) {
        boolean z;
        synchronized (this.f1011l) {
            if (!this.f1007h.containsKey(str)) {
                if (!this.f1006g.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void e(b bVar) {
        synchronized (this.f1011l) {
            this.f1010k.remove(bVar);
        }
    }

    public void f(String str, i iVar) {
        synchronized (this.f1011l) {
            n.c().d(m, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            o remove = this.f1007h.remove(str);
            if (remove != null) {
                if (this.b == null) {
                    PowerManager.WakeLock a2 = m.a(this.c, "ProcessorForegroundLck");
                    this.b = a2;
                    a2.acquire();
                }
                this.f1006g.put(str, remove);
                Intent d2 = e.b0.a0.r.c.d(this.c, str, iVar);
                Context context = this.c;
                Object obj = e.i.b.a.a;
                if (Build.VERSION.SDK_INT >= 26) {
                    a.d.a(context, d2);
                } else {
                    context.startService(d2);
                }
            }
        }
    }

    public boolean g(String str, WorkerParameters.a aVar) {
        synchronized (this.f1011l) {
            if (d(str)) {
                n.c().a(m, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            o.a aVar2 = new o.a(this.c, this.f1003d, this.f1004e, this, this.f1005f, str);
            aVar2.f1047g = this.f1008i;
            if (aVar != null) {
                aVar2.f1048h = aVar;
            }
            o oVar = new o(aVar2);
            e.b0.a0.t.s.c<Boolean> cVar = oVar.r;
            cVar.a(new a(this, str, cVar), ((b) this.f1004e).c);
            this.f1007h.put(str, oVar);
            ((b) this.f1004e).a.execute(oVar);
            n.c().a(m, String.format("%s: processing %s", d.class.getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public final void h() {
        synchronized (this.f1011l) {
            if (!(!this.f1006g.isEmpty())) {
                Context context = this.c;
                String str = e.b0.a0.r.c.f1102l;
                Intent intent = new Intent(context, SystemForegroundService.class);
                intent.setAction("ACTION_STOP_FOREGROUND");
                try {
                    this.c.startService(intent);
                } catch (Throwable th) {
                    n.c().b(m, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.b;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.b = null;
                }
            }
        }
    }

    public boolean i(String str) {
        boolean c2;
        synchronized (this.f1011l) {
            n.c().a(m, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            c2 = c(str, this.f1006g.remove(str));
        }
        return c2;
    }

    public boolean j(String str) {
        boolean c2;
        synchronized (this.f1011l) {
            n.c().a(m, String.format("Processor stopping background work %s", str), new Throwable[0]);
            c2 = c(str, this.f1007h.remove(str));
        }
        return c2;
    }
}
