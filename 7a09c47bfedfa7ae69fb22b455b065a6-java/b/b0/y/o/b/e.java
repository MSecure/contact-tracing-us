package b.b0.y.o.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import b.b0.m;
import b.b0.y.k;
import b.b0.y.s.i;
import b.b0.y.s.l;
import b.b0.y.s.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e implements b.b0.y.b {
    public static final String l = m.e("SystemAlarmDispatcher");

    /* renamed from: b  reason: collision with root package name */
    public final Context f1147b;

    /* renamed from: c  reason: collision with root package name */
    public final b.b0.y.s.s.a f1148c;

    /* renamed from: d  reason: collision with root package name */
    public final q f1149d = new q();

    /* renamed from: e  reason: collision with root package name */
    public final b.b0.y.d f1150e;

    /* renamed from: f  reason: collision with root package name */
    public final k f1151f;

    /* renamed from: g  reason: collision with root package name */
    public final b f1152g = new b(this.f1147b);
    public final Handler h;
    public final List<Intent> i;
    public Intent j;
    public c k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e eVar;
            d dVar;
            synchronized (e.this.i) {
                e.this.j = e.this.i.get(0);
            }
            Intent intent = e.this.j;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.j.getIntExtra("KEY_START_ID", 0);
                m.c().a(e.l, String.format("Processing command %s, %s", e.this.j, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock b2 = l.b(e.this.f1147b, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    m.c().a(e.l, String.format("Acquiring operation wake lock (%s) %s", action, b2), new Throwable[0]);
                    b2.acquire();
                    e.this.f1152g.f(e.this.j, intExtra, e.this);
                    m.c().a(e.l, String.format("Releasing operation wake lock (%s) %s", action, b2), new Throwable[0]);
                    b2.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th) {
                    m.c().a(e.l, String.format("Releasing operation wake lock (%s) %s", action, b2), new Throwable[0]);
                    b2.release();
                    e eVar2 = e.this;
                    eVar2.h.post(new d(eVar2));
                    throw th;
                }
                eVar.h.post(dVar);
            }
        }
    }

    public static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final e f1154b;

        /* renamed from: c  reason: collision with root package name */
        public final Intent f1155c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1156d;

        public b(e eVar, Intent intent, int i) {
            this.f1154b = eVar;
            this.f1155c = intent;
            this.f1156d = i;
        }

        public void run() {
            this.f1154b.b(this.f1155c, this.f1156d);
        }
    }

    public interface c {
    }

    public static class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final e f1157b;

        public d(e eVar) {
            this.f1157b = eVar;
        }

        public void run() {
            boolean z;
            boolean z2;
            e eVar = this.f1157b;
            if (eVar != null) {
                m.c().a(e.l, "Checking if commands are complete.", new Throwable[0]);
                eVar.c();
                synchronized (eVar.i) {
                    if (eVar.j != null) {
                        m.c().a(e.l, String.format("Removing command %s", eVar.j), new Throwable[0]);
                        if (eVar.i.remove(0).equals(eVar.j)) {
                            eVar.j = null;
                        } else {
                            throw new IllegalStateException("Dequeue-d command is not the first.");
                        }
                    }
                    i iVar = ((b.b0.y.s.s.b) eVar.f1148c).f1334a;
                    b bVar = eVar.f1152g;
                    synchronized (bVar.f1135d) {
                        z = !bVar.f1134c.isEmpty();
                    }
                    if (!z && eVar.i.isEmpty()) {
                        synchronized (iVar.f1269d) {
                            z2 = !iVar.f1267b.isEmpty();
                        }
                        if (!z2) {
                            m.c().a(e.l, "No more commands & intents.", new Throwable[0]);
                            if (eVar.k != null) {
                                SystemAlarmService systemAlarmService = (SystemAlarmService) eVar.k;
                                systemAlarmService.f468d = true;
                                m.c().a(SystemAlarmService.f466e, "All commands completed in dispatcher", new Throwable[0]);
                                l.a();
                                systemAlarmService.stopSelf();
                            }
                        }
                    }
                    if (!eVar.i.isEmpty()) {
                        eVar.e();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public e(Context context) {
        this.f1147b = context.getApplicationContext();
        k b2 = k.b(context);
        this.f1151f = b2;
        b.b0.y.d dVar = b2.f1099f;
        this.f1150e = dVar;
        this.f1148c = b2.f1097d;
        dVar.b(this);
        this.i = new ArrayList();
        this.j = null;
        this.h = new Handler(Looper.getMainLooper());
    }

    @Override // b.b0.y.b
    public void a(String str, boolean z) {
        this.h.post(new b(this, b.d(this.f1147b, str, z), 0));
    }

    public boolean b(Intent intent, int i2) {
        boolean z;
        boolean z2 = false;
        m.c().a(l, String.format("Adding command %s (%s)", intent, Integer.valueOf(i2)), new Throwable[0]);
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            m.c().f(l, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            c();
            synchronized (this.i) {
                Iterator<Intent> it = this.i.iterator();
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
        synchronized (this.i) {
            if (!this.i.isEmpty()) {
                z2 = true;
            }
            this.i.add(intent);
            if (!z2) {
                e();
            }
        }
        return true;
    }

    public final void c() {
        if (this.h.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void d() {
        m.c().a(l, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f1150e.e(this);
        q qVar = this.f1149d;
        if (!qVar.f1299b.isShutdown()) {
            qVar.f1299b.shutdownNow();
        }
        this.k = null;
    }

    public final void e() {
        c();
        PowerManager.WakeLock b2 = l.b(this.f1147b, "ProcessCommand");
        try {
            b2.acquire();
            b.b0.y.s.s.a aVar = this.f1151f.f1097d;
            ((b.b0.y.s.s.b) aVar).f1334a.execute(new a());
        } finally {
            b2.release();
        }
    }
}
