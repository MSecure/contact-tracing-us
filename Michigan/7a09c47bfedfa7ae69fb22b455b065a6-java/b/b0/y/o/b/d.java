package b.b0.y.o.b;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import b.b0.m;
import b.b0.y.b;
import b.b0.y.o.b.e;
import b.b0.y.p.c;
import b.b0.y.r.p;
import b.b0.y.r.r;
import b.b0.y.s.l;
import b.b0.y.s.q;
import java.util.Collections;
import java.util.List;

public class d implements c, b, q.b {
    public static final String k = m.e("DelayMetCommandHandler");

    /* renamed from: b  reason: collision with root package name */
    public final Context f1141b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1142c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1143d;

    /* renamed from: e  reason: collision with root package name */
    public final e f1144e;

    /* renamed from: f  reason: collision with root package name */
    public final b.b0.y.p.d f1145f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f1146g = new Object();
    public int h = 0;
    public PowerManager.WakeLock i;
    public boolean j = false;

    public d(Context context, int i2, String str, e eVar) {
        this.f1141b = context;
        this.f1142c = i2;
        this.f1144e = eVar;
        this.f1143d = str;
        this.f1145f = new b.b0.y.p.d(this.f1141b, eVar.f1148c, this);
    }

    @Override // b.b0.y.b
    public void a(String str, boolean z) {
        m.c().a(k, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        d();
        if (z) {
            Intent e2 = b.e(this.f1141b, this.f1143d);
            e eVar = this.f1144e;
            eVar.h.post(new e.b(eVar, e2, this.f1142c));
        }
        if (this.j) {
            Intent b2 = b.b(this.f1141b);
            e eVar2 = this.f1144e;
            eVar2.h.post(new e.b(eVar2, b2, this.f1142c));
        }
    }

    @Override // b.b0.y.s.q.b
    public void b(String str) {
        m.c().a(k, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // b.b0.y.p.c
    public void c(List<String> list) {
        if (list.contains(this.f1143d)) {
            synchronized (this.f1146g) {
                if (this.h == 0) {
                    this.h = 1;
                    m.c().a(k, String.format("onAllConstraintsMet for %s", this.f1143d), new Throwable[0]);
                    if (this.f1144e.f1150e.g(this.f1143d, null)) {
                        this.f1144e.f1149d.a(this.f1143d, 600000, this);
                    } else {
                        d();
                    }
                } else {
                    m.c().a(k, String.format("Already started work for %s", this.f1143d), new Throwable[0]);
                }
            }
        }
    }

    public final void d() {
        synchronized (this.f1146g) {
            this.f1145f.c();
            this.f1144e.f1149d.b(this.f1143d);
            if (this.i != null && this.i.isHeld()) {
                m.c().a(k, String.format("Releasing wakelock %s for WorkSpec %s", this.i, this.f1143d), new Throwable[0]);
                this.i.release();
            }
        }
    }

    @Override // b.b0.y.p.c
    public void e(List<String> list) {
        g();
    }

    public void f() {
        this.i = l.b(this.f1141b, String.format("%s (%s)", this.f1143d, Integer.valueOf(this.f1142c)));
        m.c().a(k, String.format("Acquiring wakelock %s for WorkSpec %s", this.i, this.f1143d), new Throwable[0]);
        this.i.acquire();
        p i2 = ((r) this.f1144e.f1151f.f1096c.h()).i(this.f1143d);
        if (i2 == null) {
            g();
            return;
        }
        boolean b2 = i2.b();
        this.j = b2;
        if (!b2) {
            m.c().a(k, String.format("No constraints for %s", this.f1143d), new Throwable[0]);
            c(Collections.singletonList(this.f1143d));
            return;
        }
        this.f1145f.b(Collections.singletonList(i2));
    }

    public final void g() {
        synchronized (this.f1146g) {
            if (this.h < 2) {
                this.h = 2;
                m.c().a(k, String.format("Stopping work for WorkSpec %s", this.f1143d), new Throwable[0]);
                Context context = this.f1141b;
                String str = this.f1143d;
                Intent intent = new Intent(context, SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str);
                e eVar = this.f1144e;
                eVar.h.post(new e.b(this.f1144e, intent, this.f1142c));
                if (this.f1144e.f1150e.d(this.f1143d)) {
                    m.c().a(k, String.format("WorkSpec %s needs to be rescheduled", this.f1143d), new Throwable[0]);
                    Intent e2 = b.e(this.f1141b, this.f1143d);
                    e eVar2 = this.f1144e;
                    eVar2.h.post(new e.b(this.f1144e, e2, this.f1142c));
                } else {
                    m.c().a(k, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f1143d), new Throwable[0]);
                }
            } else {
                m.c().a(k, String.format("Already stopped work for %s", this.f1143d), new Throwable[0]);
            }
        }
    }
}
