package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import e.c0.l;
import e.c0.x.p.b.e;
import e.p.m;
import java.util.HashMap;
import java.util.WeakHashMap;

public class SystemAlarmService extends m implements e.c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f316e = l.e("SystemAlarmService");
    public e c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f317d;

    public final void b() {
        e eVar = new e(this);
        this.c = eVar;
        if (eVar.f1098k != null) {
            l.c().b(e.f1090l, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            eVar.f1098k = this;
        }
    }

    public void e() {
        this.f317d = true;
        l.c().a(f316e, "All commands completed in dispatcher", new Throwable[0]);
        String str = e.c0.x.t.l.a;
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = e.c0.x.t.l.b;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                l.c().f(e.c0.x.t.l.a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
        stopSelf();
    }

    @Override // e.p.m
    public void onCreate() {
        super.onCreate();
        b();
        this.f317d = false;
    }

    @Override // e.p.m
    public void onDestroy() {
        super.onDestroy();
        this.f317d = true;
        this.c.d();
    }

    @Override // e.p.m
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f317d) {
            l.c().d(f316e, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.c.d();
            b();
            this.f317d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.c.b(intent, i3);
        return 3;
    }
}
