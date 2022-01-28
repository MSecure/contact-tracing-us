package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import e.b0.a0.p.b.e;
import e.b0.a0.t.m;
import e.b0.n;
import e.q.o;
import java.util.HashMap;
import java.util.WeakHashMap;

public class SystemAlarmService extends o implements e.c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f308e = n.e("SystemAlarmService");
    public e c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f309d;

    public final void b() {
        e eVar = new e(this);
        this.c = eVar;
        if (eVar.f1077k != null) {
            n.c().b(e.f1069l, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            eVar.f1077k = this;
        }
    }

    public void e() {
        this.f309d = true;
        n.c().a(f308e, "All commands completed in dispatcher", new Throwable[0]);
        String str = m.a;
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = m.b;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                n.c().f(m.a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
        stopSelf();
    }

    @Override // e.q.o
    public void onCreate() {
        super.onCreate();
        b();
        this.f309d = false;
    }

    @Override // e.q.o
    public void onDestroy() {
        super.onDestroy();
        this.f309d = true;
        this.c.d();
    }

    @Override // e.q.o
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f309d) {
            n.c().d(f308e, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.c.d();
            b();
            this.f309d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.c.b(intent, i3);
        return 3;
    }
}
