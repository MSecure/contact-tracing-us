package e.b0.a0.p.b;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.b0.a0.b;
import e.b0.a0.p.b.e;
import e.b0.a0.q.c;
import e.b0.a0.s.o;
import e.b0.a0.s.q;
import e.b0.a0.t.m;
import e.b0.a0.t.r;
import e.b0.n;
import java.util.Collections;
import java.util.List;

public class d implements c, b, r.b {

    /* renamed from: k  reason: collision with root package name */
    public static final String f1061k = n.e("DelayMetCommandHandler");
    public final Context b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1062d;

    /* renamed from: e  reason: collision with root package name */
    public final e f1063e;

    /* renamed from: f  reason: collision with root package name */
    public final e.b0.a0.q.d f1064f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f1065g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public int f1066h = 0;

    /* renamed from: i  reason: collision with root package name */
    public PowerManager.WakeLock f1067i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1068j = false;

    public d(Context context, int i2, String str, e eVar) {
        this.b = context;
        this.c = i2;
        this.f1063e = eVar;
        this.f1062d = str;
        this.f1064f = new e.b0.a0.q.d(context, eVar.c, this);
    }

    @Override // e.b0.a0.b
    public void a(String str, boolean z) {
        n.c().a(f1061k, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        d();
        if (z) {
            Intent d2 = b.d(this.b, this.f1062d);
            e eVar = this.f1063e;
            eVar.f1074h.post(new e.b(eVar, d2, this.c));
        }
        if (this.f1068j) {
            Intent b2 = b.b(this.b);
            e eVar2 = this.f1063e;
            eVar2.f1074h.post(new e.b(eVar2, b2, this.c));
        }
    }

    @Override // e.b0.a0.t.r.b
    public void b(String str) {
        n.c().a(f1061k, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // e.b0.a0.q.c
    public void c(List<String> list) {
        if (list.contains(this.f1062d)) {
            synchronized (this.f1065g) {
                if (this.f1066h == 0) {
                    this.f1066h = 1;
                    n.c().a(f1061k, String.format("onAllConstraintsMet for %s", this.f1062d), new Throwable[0]);
                    if (this.f1063e.f1071e.g(this.f1062d, null)) {
                        this.f1063e.f1070d.a(this.f1062d, 600000, this);
                    } else {
                        d();
                    }
                } else {
                    n.c().a(f1061k, String.format("Already started work for %s", this.f1062d), new Throwable[0]);
                }
            }
        }
    }

    public final void d() {
        synchronized (this.f1065g) {
            this.f1064f.c();
            this.f1063e.f1070d.b(this.f1062d);
            PowerManager.WakeLock wakeLock = this.f1067i;
            if (wakeLock != null && wakeLock.isHeld()) {
                n.c().a(f1061k, String.format("Releasing wakelock %s for WorkSpec %s", this.f1067i, this.f1062d), new Throwable[0]);
                this.f1067i.release();
            }
        }
    }

    @Override // e.b0.a0.q.c
    public void e(List<String> list) {
        g();
    }

    public void f() {
        this.f1067i = m.a(this.b, String.format("%s (%s)", this.f1062d, Integer.valueOf(this.c)));
        n c2 = n.c();
        String str = f1061k;
        c2.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f1067i, this.f1062d), new Throwable[0]);
        this.f1067i.acquire();
        o i2 = ((q) this.f1063e.f1072f.c.r()).i(this.f1062d);
        if (i2 == null) {
            g();
            return;
        }
        boolean b2 = i2.b();
        this.f1068j = b2;
        if (!b2) {
            n.c().a(str, String.format("No constraints for %s", this.f1062d), new Throwable[0]);
            c(Collections.singletonList(this.f1062d));
            return;
        }
        this.f1064f.b(Collections.singletonList(i2));
    }

    public final void g() {
        synchronized (this.f1065g) {
            if (this.f1066h < 2) {
                this.f1066h = 2;
                n c2 = n.c();
                String str = f1061k;
                c2.a(str, String.format("Stopping work for WorkSpec %s", this.f1062d), new Throwable[0]);
                Context context = this.b;
                String str2 = this.f1062d;
                Intent intent = new Intent(context, SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str2);
                e eVar = this.f1063e;
                eVar.f1074h.post(new e.b(eVar, intent, this.c));
                if (this.f1063e.f1071e.d(this.f1062d)) {
                    n.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f1062d), new Throwable[0]);
                    Intent d2 = b.d(this.b, this.f1062d);
                    e eVar2 = this.f1063e;
                    eVar2.f1074h.post(new e.b(eVar2, d2, this.c));
                } else {
                    n.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f1062d), new Throwable[0]);
                }
            } else {
                n.c().a(f1061k, String.format("Already stopped work for %s", this.f1062d), new Throwable[0]);
            }
        }
    }
}
