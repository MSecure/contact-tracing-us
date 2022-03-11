package e.c0.a0;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import e.c0.a0.o;
import e.c0.a0.t.m;
import e.c0.a0.t.t.b;
import e.c0.c;
import e.c0.i;
import e.c0.n;
import e.j.b.a;
import f.b.b.f.a.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
/* loaded from: classes.dex */
public class d implements b, e.c0.a0.r.a {
    public static final String m = n.e("Processor");
    public Context c;

    /* renamed from: d */
    public c f1082d;

    /* renamed from: e */
    public e.c0.a0.t.t.a f1083e;

    /* renamed from: f */
    public WorkDatabase f1084f;

    /* renamed from: i */
    public List<e> f1087i;

    /* renamed from: h */
    public Map<String, o> f1086h = new HashMap();

    /* renamed from: g */
    public Map<String, o> f1085g = new HashMap();

    /* renamed from: j */
    public Set<String> f1088j = new HashSet();

    /* renamed from: k */
    public final List<b> f1089k = new ArrayList();
    public PowerManager.WakeLock b = null;

    /* renamed from: l */
    public final Object f1090l = new Object();

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public b b;
        public String c;

        /* renamed from: d */
        public u<Boolean> f1091d;

        public a(b bVar, String str, u<Boolean> uVar) {
            this.b = bVar;
            this.c = str;
            this.f1091d = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                z = this.f1091d.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.b.a(this.c, z);
        }
    }

    public d(Context context, c cVar, e.c0.a0.t.t.a aVar, WorkDatabase workDatabase, List<e> list) {
        this.c = context;
        this.f1082d = cVar;
        this.f1083e = aVar;
        this.f1084f = workDatabase;
        this.f1087i = list;
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
            ListenableWorker listenableWorker = oVar.f1117g;
            if (listenableWorker == null || z) {
                n.c().a(o.u, String.format("WorkSpec %s is already done. Not interrupting.", oVar.f1116f), new Throwable[0]);
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

    @Override // e.c0.a0.b
    public void a(String str, boolean z) {
        synchronized (this.f1090l) {
            this.f1086h.remove(str);
            n.c().a(m, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            for (b bVar : this.f1089k) {
                bVar.a(str, z);
            }
        }
    }

    public void b(b bVar) {
        synchronized (this.f1090l) {
            this.f1089k.add(bVar);
        }
    }

    public boolean d(String str) {
        boolean z;
        synchronized (this.f1090l) {
            if (!this.f1086h.containsKey(str) && !this.f1085g.containsKey(str)) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    public void e(b bVar) {
        synchronized (this.f1090l) {
            this.f1089k.remove(bVar);
        }
    }

    public void f(String str, i iVar) {
        synchronized (this.f1090l) {
            n.c().d(m, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            o remove = this.f1086h.remove(str);
            if (remove != null) {
                if (this.b == null) {
                    PowerManager.WakeLock a2 = m.a(this.c, "ProcessorForegroundLck");
                    this.b = a2;
                    a2.acquire();
                }
                this.f1085g.put(str, remove);
                Intent d2 = e.c0.a0.r.c.d(this.c, str, iVar);
                Context context = this.c;
                Object obj = e.j.b.a.a;
                if (Build.VERSION.SDK_INT >= 26) {
                    a.d.a(context, d2);
                } else {
                    context.startService(d2);
                }
            }
        }
    }

    public boolean g(String str, WorkerParameters.a aVar) {
        synchronized (this.f1090l) {
            if (d(str)) {
                n.c().a(m, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            o.a aVar2 = new o.a(this.c, this.f1082d, this.f1083e, this, this.f1084f, str);
            aVar2.f1126g = this.f1087i;
            if (aVar != null) {
                aVar2.f1127h = aVar;
            }
            o oVar = new o(aVar2);
            e.c0.a0.t.s.c<Boolean> cVar = oVar.r;
            cVar.a(new a(this, str, cVar), ((b) this.f1083e).c);
            this.f1086h.put(str, oVar);
            ((b) this.f1083e).a.execute(oVar);
            n.c().a(m, String.format("%s: processing %s", d.class.getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public final void h() {
        synchronized (this.f1090l) {
            if (!(!this.f1085g.isEmpty())) {
                Context context = this.c;
                String str = e.c0.a0.r.c.f1181l;
                Intent intent = new Intent(context, SystemForegroundService.class);
                intent.setAction("ACTION_STOP_FOREGROUND");
                this.c.startService(intent);
                PowerManager.WakeLock wakeLock = this.b;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.b = null;
                }
            }
        }
    }

    public boolean i(String str) {
        boolean c;
        synchronized (this.f1090l) {
            n.c().a(m, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            c = c(str, this.f1085g.remove(str));
        }
        return c;
    }

    public boolean j(String str) {
        boolean c;
        synchronized (this.f1090l) {
            n.c().a(m, String.format("Processor stopping background work %s", str), new Throwable[0]);
            c = c(str, this.f1086h.remove(str));
        }
        return c;
    }
}
