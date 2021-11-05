package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import b.n.l;
import b.z.m;
import b.z.y.o.b.e;

public class SystemAlarmService extends l implements e.c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f332e = m.e("SystemAlarmService");

    /* renamed from: c  reason: collision with root package name */
    public e f333c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f334d;

    public final void a() {
        e eVar = new e(this);
        this.f333c = eVar;
        if (eVar.k != null) {
            m.c().b(e.l, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            eVar.k = this;
        }
    }

    @Override // b.n.l
    public void onCreate() {
        super.onCreate();
        a();
        this.f334d = false;
    }

    @Override // b.n.l
    public void onDestroy() {
        super.onDestroy();
        this.f334d = true;
        this.f333c.d();
    }

    @Override // b.n.l
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f334d) {
            m.c().d(f332e, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f333c.d();
            a();
            this.f334d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f333c.b(intent, i2);
        return 3;
    }
}
