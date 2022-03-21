package e.b0.x.p.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.b0.l;
import e.b0.x.t.i;
import e.b0.x.t.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class e implements e.b0.x.b {

    /* renamed from: l  reason: collision with root package name */
    public static final String f1070l = l.e("SystemAlarmDispatcher");
    public final Context b;
    public final e.b0.x.t.q.a c;

    /* renamed from: d  reason: collision with root package name */
    public final o f1071d = new o();

    /* renamed from: e  reason: collision with root package name */
    public final e.b0.x.d f1072e;

    /* renamed from: f  reason: collision with root package name */
    public final e.b0.x.l f1073f;

    /* renamed from: g  reason: collision with root package name */
    public final b f1074g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f1075h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Intent> f1076i;

    /* renamed from: j  reason: collision with root package name */
    public Intent f1077j;

    /* renamed from: k  reason: collision with root package name */
    public c f1078k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e eVar;
            d dVar;
            synchronized (e.this.f1076i) {
                e eVar2 = e.this;
                eVar2.f1077j = eVar2.f1076i.get(0);
            }
            Intent intent = e.this.f1077j;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.f1077j.getIntExtra("KEY_START_ID", 0);
                l c = l.c();
                String str = e.f1070l;
                c.a(str, String.format("Processing command %s, %s", e.this.f1077j, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock a = e.b0.x.t.l.a(e.this.b, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    l.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.acquire();
                    e eVar3 = e.this;
                    eVar3.f1074g.e(eVar3.f1077j, intExtra, eVar3);
                    l.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th) {
                    l.c().a(e.f1070l, String.format("Releasing operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.release();
                    e eVar4 = e.this;
                    eVar4.f1075h.post(new d(eVar4));
                    throw th;
                }
                eVar.f1075h.post(dVar);
            }
        }
    }

    public static class b implements Runnable {
        public final e b;
        public final Intent c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1079d;

        public b(e eVar, Intent intent, int i2) {
            this.b = eVar;
            this.c = intent;
            this.f1079d = i2;
        }

        public void run() {
            this.b.b(this.c, this.f1079d);
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
            l c = l.c();
            String str = e.f1070l;
            c.a(str, "Checking if commands are complete.", new Throwable[0]);
            eVar.c();
            synchronized (eVar.f1076i) {
                boolean z2 = true;
                if (eVar.f1077j != null) {
                    l.c().a(str, String.format("Removing command %s", eVar.f1077j), new Throwable[0]);
                    if (eVar.f1076i.remove(0).equals(eVar.f1077j)) {
                        eVar.f1077j = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                i iVar = ((e.b0.x.t.q.b) eVar.c).a;
                b bVar = eVar.f1074g;
                synchronized (bVar.f1059d) {
                    z = !bVar.c.isEmpty();
                }
                if (!z && eVar.f1076i.isEmpty()) {
                    synchronized (iVar.f1132d) {
                        if (iVar.b.isEmpty()) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        l.c().a(str, "No more commands & intents.", new Throwable[0]);
                        c cVar = eVar.f1078k;
                        if (cVar != null) {
                            ((SystemAlarmService) cVar).e();
                        }
                    }
                }
                if (!eVar.f1076i.isEmpty()) {
                    eVar.e();
                }
            }
        }
    }

    public e(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f1074g = new b(applicationContext);
        e.b0.x.l d2 = e.b0.x.l.d(context);
        this.f1073f = d2;
        e.b0.x.d dVar = d2.f1030f;
        this.f1072e = dVar;
        this.c = d2.f1028d;
        dVar.b(this);
        this.f1076i = new ArrayList();
        this.f1077j = null;
        this.f1075h = new Handler(Looper.getMainLooper());
    }

    @Override // e.b0.x.b
    public void a(String str, boolean z) {
        Context context = this.b;
        String str2 = b.f1058e;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        this.f1075h.post(new b(this, intent, 0));
    }

    public boolean b(Intent intent, int i2) {
        boolean z;
        l c2 = l.c();
        String str = f1070l;
        boolean z2 = false;
        c2.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i2)), new Throwable[0]);
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            l.c().f(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            c();
            synchronized (this.f1076i) {
                Iterator<Intent> it = this.f1076i.iterator();
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
        synchronized (this.f1076i) {
            if (!this.f1076i.isEmpty()) {
                z2 = true;
            }
            this.f1076i.add(intent);
            if (!z2) {
                e();
            }
        }
        return true;
    }

    public final void c() {
        if (this.f1075h.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void d() {
        l.c().a(f1070l, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f1072e.e(this);
        o oVar = this.f1071d;
        if (!oVar.b.isShutdown()) {
            oVar.b.shutdownNow();
        }
        this.f1078k = null;
    }

    public final void e() {
        c();
        PowerManager.WakeLock a2 = e.b0.x.t.l.a(this.b, "ProcessCommand");
        try {
            a2.acquire();
            e.b0.x.t.q.a aVar = this.f1073f.f1028d;
            ((e.b0.x.t.q.b) aVar).a.execute(new a());
        } finally {
            a2.release();
        }
    }
}
