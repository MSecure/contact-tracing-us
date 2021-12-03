package e.b0.a0.p.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.b0.a0.l;
import e.b0.a0.t.j;
import e.b0.a0.t.m;
import e.b0.a0.t.r;
import e.b0.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class e implements e.b0.a0.b {

    /* renamed from: l  reason: collision with root package name */
    public static final String f1069l = n.e("SystemAlarmDispatcher");
    public final Context b;
    public final e.b0.a0.t.t.a c;

    /* renamed from: d  reason: collision with root package name */
    public final r f1070d = new r();

    /* renamed from: e  reason: collision with root package name */
    public final e.b0.a0.d f1071e;

    /* renamed from: f  reason: collision with root package name */
    public final l f1072f;

    /* renamed from: g  reason: collision with root package name */
    public final b f1073g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f1074h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Intent> f1075i;

    /* renamed from: j  reason: collision with root package name */
    public Intent f1076j;

    /* renamed from: k  reason: collision with root package name */
    public c f1077k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e eVar;
            d dVar;
            synchronized (e.this.f1075i) {
                e eVar2 = e.this;
                eVar2.f1076j = eVar2.f1075i.get(0);
            }
            Intent intent = e.this.f1076j;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.f1076j.getIntExtra("KEY_START_ID", 0);
                n c = n.c();
                String str = e.f1069l;
                c.a(str, String.format("Processing command %s, %s", e.this.f1076j, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock a = m.a(e.this.b, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    n.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.acquire();
                    e eVar3 = e.this;
                    eVar3.f1073g.e(eVar3.f1076j, intExtra, eVar3);
                    n.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th) {
                    n.c().a(e.f1069l, String.format("Releasing operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.release();
                    e eVar4 = e.this;
                    eVar4.f1074h.post(new d(eVar4));
                    throw th;
                }
                eVar.f1074h.post(dVar);
            }
        }
    }

    public static class b implements Runnable {
        public final e b;
        public final Intent c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1078d;

        public b(e eVar, Intent intent, int i2) {
            this.b = eVar;
            this.c = intent;
            this.f1078d = i2;
        }

        public void run() {
            this.b.b(this.c, this.f1078d);
        }
    }

    public interface c {
    }

    public static class d implements Runnable {
        public final e b;

        public d(e eVar) {
            this.b = eVar;
        }

        public void run() {
            boolean z;
            e eVar = this.b;
            Objects.requireNonNull(eVar);
            n c = n.c();
            String str = e.f1069l;
            c.a(str, "Checking if commands are complete.", new Throwable[0]);
            eVar.c();
            synchronized (eVar.f1075i) {
                boolean z2 = true;
                if (eVar.f1076j != null) {
                    n.c().a(str, String.format("Removing command %s", eVar.f1076j), new Throwable[0]);
                    if (eVar.f1075i.remove(0).equals(eVar.f1076j)) {
                        eVar.f1076j = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                j jVar = ((e.b0.a0.t.t.b) eVar.c).a;
                b bVar = eVar.f1073g;
                synchronized (bVar.f1058d) {
                    z = !bVar.c.isEmpty();
                }
                if (!z && eVar.f1075i.isEmpty()) {
                    synchronized (jVar.f1131d) {
                        if (jVar.b.isEmpty()) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        n.c().a(str, "No more commands & intents.", new Throwable[0]);
                        c cVar = eVar.f1077k;
                        if (cVar != null) {
                            ((SystemAlarmService) cVar).e();
                        }
                    }
                }
                if (!eVar.f1075i.isEmpty()) {
                    eVar.e();
                }
            }
        }
    }

    public e(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f1073g = new b(applicationContext);
        l g2 = l.g(context);
        this.f1072f = g2;
        e.b0.a0.d dVar = g2.f1029f;
        this.f1071e = dVar;
        this.c = g2.f1027d;
        dVar.b(this);
        this.f1075i = new ArrayList();
        this.f1076j = null;
        this.f1074h = new Handler(Looper.getMainLooper());
    }

    @Override // e.b0.a0.b
    public void a(String str, boolean z) {
        Context context = this.b;
        String str2 = b.f1057e;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        this.f1074h.post(new b(this, intent, 0));
    }

    public boolean b(Intent intent, int i2) {
        boolean z;
        n c2 = n.c();
        String str = f1069l;
        boolean z2 = false;
        c2.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i2)), new Throwable[0]);
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            n.c().f(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            c();
            synchronized (this.f1075i) {
                Iterator<Intent> it = this.f1075i.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(it.next().getAction())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                return false;
            }
        }
        intent.putExtra("KEY_START_ID", i2);
        synchronized (this.f1075i) {
            if (!this.f1075i.isEmpty()) {
                z2 = true;
            }
            this.f1075i.add(intent);
            if (!z2) {
                e();
            }
        }
        return true;
    }

    public final void c() {
        if (this.f1074h.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void d() {
        n.c().a(f1069l, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f1071e.e(this);
        r rVar = this.f1070d;
        if (!rVar.b.isShutdown()) {
            rVar.b.shutdownNow();
        }
        this.f1077k = null;
    }

    public final void e() {
        c();
        PowerManager.WakeLock a2 = m.a(this.b, "ProcessCommand");
        try {
            a2.acquire();
            e.b0.a0.t.t.a aVar = this.f1072f.f1027d;
            ((e.b0.a0.t.t.b) aVar).a.execute(new a());
        } finally {
            a2.release();
        }
    }
}
