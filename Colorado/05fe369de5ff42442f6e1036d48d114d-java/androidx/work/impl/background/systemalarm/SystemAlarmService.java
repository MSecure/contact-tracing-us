package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import e.p.o;
import e.z.l;
import e.z.x.p.b.e;
import java.util.HashMap;
import java.util.WeakHashMap;

public class SystemAlarmService extends o implements e.c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f304e = l.e("SystemAlarmService");
    public e c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f305d;

    public final void b() {
        e eVar = new e(this);
        this.c = eVar;
        if (eVar.f1953k != null) {
            l.c().b(e.f1945l, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            eVar.f1953k = this;
        }
    }

    public void e() {
        this.f305d = true;
        l.c().a(f304e, "All commands completed in dispatcher", new Throwable[0]);
        String str = e.z.x.t.l.a;
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = e.z.x.t.l.b;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                l.c().f(e.z.x.t.l.a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
        stopSelf();
    }

    @Override // e.p.o
    public void onCreate() {
        super.onCreate();
        b();
        this.f305d = false;
    }

    @Override // e.p.o
    public void onDestroy() {
        super.onDestroy();
        this.f305d = true;
        this.c.d();
    }

    @Override // e.p.o
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f305d) {
            l.c().d(f304e, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.c.d();
            b();
            this.f305d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.c.b(intent, i3);
        return 3;
    }
}
