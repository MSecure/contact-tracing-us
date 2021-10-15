package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import b.b0.m;
import b.b0.y.o.b.e;
import b.o.l;

public class SystemAlarmService extends l implements e.c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f466e = m.e("SystemAlarmService");

    /* renamed from: c  reason: collision with root package name */
    public e f467c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f468d;

    public final void a() {
        e eVar = new e(this);
        this.f467c = eVar;
        if (eVar.k != null) {
            m.c().b(e.l, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            eVar.k = this;
        }
    }

    @Override // b.o.l
    public void onCreate() {
        super.onCreate();
        a();
        this.f468d = false;
    }

    @Override // b.o.l
    public void onDestroy() {
        super.onDestroy();
        this.f468d = true;
        this.f467c.d();
    }

    @Override // b.o.l
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f468d) {
            m.c().d(f466e, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f467c.d();
            a();
            this.f468d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f467c.b(intent, i2);
        return 3;
    }
}
