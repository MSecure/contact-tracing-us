package e.c0.a0.p.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.c0.a0.l;
import e.c0.a0.t.j;
import e.c0.a0.t.m;
import e.c0.a0.t.r;
import e.c0.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class e implements e.c0.a0.b {

    /* renamed from: l */
    public static final String f1148l = n.e("SystemAlarmDispatcher");
    public final Context b;
    public final e.c0.a0.t.t.a c;

    /* renamed from: e */
    public final e.c0.a0.d f1150e;

    /* renamed from: f */
    public final l f1151f;

    /* renamed from: g */
    public final b f1152g;

    /* renamed from: k */
    public c f1156k;

    /* renamed from: d */
    public final r f1149d = new r();

    /* renamed from: i */
    public final List<Intent> f1154i = new ArrayList();

    /* renamed from: j */
    public Intent f1155j = null;

    /* renamed from: h */
    public final Handler f1153h = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            e.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            d dVar;
            synchronized (e.this.f1154i) {
                try {
                    e eVar2 = e.this;
                    eVar2.f1155j = eVar2.f1154i.get(0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intent intent = e.this.f1155j;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.f1155j.getIntExtra("KEY_START_ID", 0);
                n c = n.c();
                String str = e.f1148l;
                c.a(str, String.format("Processing command %s, %s", e.this.f1155j, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock a = m.a(e.this.b, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    n.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.acquire();
                    e eVar3 = e.this;
                    eVar3.f1152g.e(eVar3.f1155j, intExtra, eVar3);
                    n.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, a), new Throwable[0]);
                    a.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th2) {
                    try {
                        n c2 = n.c();
                        String str2 = e.f1148l;
                        c2.b(str2, "Unexpected error in onHandleIntent", th2);
                        n.c().a(str2, String.format("Releasing operation wake lock (%s) %s", action, a), new Throwable[0]);
                        a.release();
                        eVar = e.this;
                        dVar = new d(eVar);
                    } catch (Throwable th3) {
                        n.c().a(e.f1148l, String.format("Releasing operation wake lock (%s) %s", action, a), new Throwable[0]);
                        a.release();
                        e eVar4 = e.this;
                        eVar4.f1153h.post(new d(eVar4));
                        throw th3;
                    }
                }
                eVar.f1153h.post(dVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public final e b;
        public final Intent c;

        /* renamed from: d */
        public final int f1157d;

        public b(e eVar, Intent intent, int i2) {
            this.b = eVar;
            this.c = intent;
            this.f1157d = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b(this.c, this.f1157d);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public final e b;

        public d(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            e eVar = this.b;
            Objects.requireNonNull(eVar);
            n c = n.c();
            String str = e.f1148l;
            c.a(str, "Checking if commands are complete.", new Throwable[0]);
            eVar.c();
            synchronized (eVar.f1154i) {
                boolean z2 = true;
                if (eVar.f1155j != null) {
                    n.c().a(str, String.format("Removing command %s", eVar.f1155j), new Throwable[0]);
                    if (eVar.f1154i.remove(0).equals(eVar.f1155j)) {
                        eVar.f1155j = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                j jVar = ((e.c0.a0.t.t.b) eVar.c).a;
                b bVar = eVar.f1152g;
                synchronized (bVar.f1137d) {
                    z = !bVar.c.isEmpty();
                }
                if (!z && eVar.f1154i.isEmpty()) {
                    synchronized (jVar.f1210d) {
                        if (jVar.b.isEmpty()) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        n.c().a(str, "No more commands & intents.", new Throwable[0]);
                        c cVar = eVar.f1156k;
                        if (cVar != null) {
                            ((SystemAlarmService) cVar).e();
                        }
                    }
                }
                if (!eVar.f1154i.isEmpty()) {
                    eVar.e();
                }
            }
        }
    }

    public e(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f1152g = new b(applicationContext);
        l h2 = l.h(context);
        this.f1151f = h2;
        e.c0.a0.d dVar = h2.f1108f;
        this.f1150e = dVar;
        this.c = h2.f1106d;
        dVar.b(this);
    }

    @Override // e.c0.a0.b
    public void a(String str, boolean z) {
        Context context = this.b;
        String str2 = b.f1136e;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        this.f1153h.post(new b(this, intent, 0));
    }

    public boolean b(Intent intent, int i2) {
        boolean z;
        n c2 = n.c();
        String str = f1148l;
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
            synchronized (this.f1154i) {
                Iterator<Intent> it = this.f1154i.iterator();
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
        synchronized (this.f1154i) {
            if (!this.f1154i.isEmpty()) {
                z2 = true;
            }
            this.f1154i.add(intent);
            if (!z2) {
                e();
            }
        }
        return true;
    }

    public final void c() {
        if (this.f1153h.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void d() {
        n.c().a(f1148l, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f1150e.e(this);
        r rVar = this.f1149d;
        if (!rVar.b.isShutdown()) {
            rVar.b.shutdownNow();
        }
        this.f1156k = null;
    }

    public final void e() {
        c();
        PowerManager.WakeLock a2 = m.a(this.b, "ProcessCommand");
        try {
            a2.acquire();
            e.c0.a0.t.t.a aVar = this.f1151f.f1106d;
            ((e.c0.a0.t.t.b) aVar).a.execute(new a());
        } finally {
            a2.release();
        }
    }
}
