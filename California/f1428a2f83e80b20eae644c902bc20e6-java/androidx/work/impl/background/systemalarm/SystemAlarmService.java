package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import e.b0.l;
import e.b0.x.p.b.e;
import e.p.m;
import java.util.HashMap;
import java.util.WeakHashMap;

public class SystemAlarmService extends m implements e.c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f308e = l.e("SystemAlarmService");
    public e c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f309d;

    public final void d() {
        e eVar = new e(this);
        this.c = eVar;
        if (eVar.f1079k != null) {
            l.c().b(e.f1071l, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            eVar.f1079k = this;
        }
    }

    public void e() {
        this.f309d = true;
        l.c().a(f308e, "All commands completed in dispatcher", new Throwable[0]);
        String str = e.b0.x.t.l.a;
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = e.b0.x.t.l.b;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                l.c().f(e.b0.x.t.l.a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
        stopSelf();
    }

    @Override // e.p.m
    public void onCreate() {
        super.onCreate();
        d();
        this.f309d = false;
    }

    @Override // e.p.m
    public void onDestroy() {
        super.onDestroy();
        this.f309d = true;
        this.c.d();
    }

    @Override // e.p.m
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f309d) {
            l.c().d(f308e, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.c.d();
            d();
            this.f309d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.c.b(intent, i3);
        return 3;
    }
}
