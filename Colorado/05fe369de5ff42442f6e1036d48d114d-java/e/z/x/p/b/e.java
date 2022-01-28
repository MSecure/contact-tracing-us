package e.z.x.p.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.z.l;
import e.z.x.t.i;
import e.z.x.t.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class e implements e.z.x.b {

    /* renamed from: l  reason: collision with root package name */
    public static final String f1945l = l.e("SystemAlarmDispatcher");
    public final Context b;
    public final e.z.x.t.q.a c;

    /* renamed from: d  reason: collision with root package name */
    public final o f1946d = new o();

    /* renamed from: e  reason: collision with root package name */
    public final e.z.x.d f1947e;

    /* renamed from: f  reason: collision with root package name */
    public final e.z.x.l f1948f;

    /* renamed from: g  reason: collision with root package name */
    public final b f1949g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f1950h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Intent> f1951i;

    /* renamed from: j  reason: collision with root package name */
    public Intent f1952j;

    /* renamed from: k  reason: collision with root package name */
    public c f1953k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e eVar;
            d dVar;
            synchronized (e.this.f1951i) {
                e eVar2 = e.this;
                eVar2.f1952j = eVar2.f1951i.get(0);
            }
            Intent intent = e.this.f1952j;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.f1952j.getIntExtra("KEY_START_ID", 0);
                l c = l.c();
                String str = e.f1945l;
                c.a(str, String.format("Processing command %s, %s", e.this.f1952j, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock a = e.z.x.t.l.a(e.this.b, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    l.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.acquire();
                    e eVar3 = e.this;
                    eVar3.f1949g.e(eVar3.f1952j, intExtra, eVar3);
                    l.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th) {
                    l.c().a(e.f1945l, String.format("Releasing operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.release();
                    e eVar4 = e.this;
                    eVar4.f1950h.post(new d(eVar4));
                    throw th;
                }
                eVar.f1950h.post(dVar);
            }
        }
    }

    public static class b implements Runnable {
        public final e b;
        public final Intent c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1954d;

        public b(e eVar, Intent intent, int i2) {
            this.b = eVar;
            this.c = intent;
            this.f1954d = i2;
        }

        public void run() {
            this.b.b(this.c, this.f1954d);
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
            String str = e.f1945l;
            c.a(str, "Checking if commands are complete.", new Throwable[0]);
            eVar.c();
            synchronized (eVar.f1951i) {
                boolean z2 = true;
                if (eVar.f1952j != null) {
                    l.c().a(str, String.format("Removing command %s", eVar.f1952j), new Throwable[0]);
                    if (eVar.f1951i.remove(0).equals(eVar.f1952j)) {
                        eVar.f1952j = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                i iVar = ((e.z.x.t.q.b) eVar.c).a;
                b bVar = eVar.f1949g;
                synchronized (bVar.f1934d) {
                    z = !bVar.c.isEmpty();
                }
                if (!z && eVar.f1951i.isEmpty()) {
                    synchronized (iVar.f2007d) {
                        if (iVar.b.isEmpty()) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        l.c().a(str, "No more commands & intents.", new Throwable[0]);
                        c cVar = eVar.f1953k;
                        if (cVar != null) {
                            ((SystemAlarmService) cVar).e();
                        }
                    }
                }
                if (!eVar.f1951i.isEmpty()) {
                    eVar.e();
                }
            }
        }
    }

    public e(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f1949g = new b(applicationContext);
        e.z.x.l f2 = e.z.x.l.f(context);
        this.f1948f = f2;
        e.z.x.d dVar = f2.f1905f;
        this.f1947e = dVar;
        this.c = f2.f1903d;
        dVar.b(this);
        this.f1951i = new ArrayList();
        this.f1952j = null;
        this.f1950h = new Handler(Looper.getMainLooper());
    }

    @Override // e.z.x.b
    public void a(String str, boolean z) {
        Context context = this.b;
        String str2 = b.f1933e;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        this.f1950h.post(new b(this, intent, 0));
    }

    public boolean b(Intent intent, int i2) {
        boolean z;
        l c2 = l.c();
        String str = f1945l;
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
            synchronized (this.f1951i) {
                Iterator<Intent> it = this.f1951i.iterator();
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
        synchronized (this.f1951i) {
            if (!this.f1951i.isEmpty()) {
                z2 = true;
            }
            this.f1951i.add(intent);
            if (!z2) {
                e();
            }
        }
        return true;
    }

    public final void c() {
        if (this.f1950h.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void d() {
        l.c().a(f1945l, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f1947e.e(this);
        o oVar = this.f1946d;
        if (!oVar.b.isShutdown()) {
            oVar.b.shutdownNow();
        }
        this.f1953k = null;
    }

    public final void e() {
        c();
        PowerManager.WakeLock a2 = e.z.x.t.l.a(this.b, "ProcessCommand");
        try {
            a2.acquire();
            e.z.x.t.q.a aVar = this.f1948f.f1903d;
            ((e.z.x.t.q.b) aVar).a.execute(new a());
        } finally {
            a2.release();
        }
    }
}
