package e.c0.a0.p.b;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.c0.a0.b;
import e.c0.a0.p.b.e;
import e.c0.a0.q.c;
import e.c0.a0.s.o;
import e.c0.a0.s.q;
import e.c0.a0.t.m;
import e.c0.a0.t.r;
import e.c0.n;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class d implements c, b, r.b {

    /* renamed from: k  reason: collision with root package name */
    public static final String f1140k = n.e("DelayMetCommandHandler");
    public final Context b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1141d;

    /* renamed from: e  reason: collision with root package name */
    public final e f1142e;

    /* renamed from: f  reason: collision with root package name */
    public final e.c0.a0.q.d f1143f;

    /* renamed from: i  reason: collision with root package name */
    public PowerManager.WakeLock f1146i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1147j = false;

    /* renamed from: h  reason: collision with root package name */
    public int f1145h = 0;

    /* renamed from: g  reason: collision with root package name */
    public final Object f1144g = new Object();

    public d(Context context, int i2, String str, e eVar) {
        this.b = context;
        this.c = i2;
        this.f1142e = eVar;
        this.f1141d = str;
        this.f1143f = new e.c0.a0.q.d(context, eVar.c, this);
    }

    @Override // e.c0.a0.b
    public void a(String str, boolean z) {
        n.c().a(f1140k, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        d();
        if (z) {
            Intent d2 = b.d(this.b, this.f1141d);
            e eVar = this.f1142e;
            eVar.f1153h.post(new e.b(eVar, d2, this.c));
        }
        if (this.f1147j) {
            Intent b = b.b(this.b);
            e eVar2 = this.f1142e;
            eVar2.f1153h.post(new e.b(eVar2, b, this.c));
        }
    }

    @Override // e.c0.a0.t.r.b
    public void b(String str) {
        n.c().a(f1140k, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // e.c0.a0.q.c
    public void c(List<String> list) {
        if (list.contains(this.f1141d)) {
            synchronized (this.f1144g) {
                if (this.f1145h == 0) {
                    this.f1145h = 1;
                    n.c().a(f1140k, String.format("onAllConstraintsMet for %s", this.f1141d), new Throwable[0]);
                    if (this.f1142e.f1150e.g(this.f1141d, null)) {
                        this.f1142e.f1149d.a(this.f1141d, 600000, this);
                    } else {
                        d();
                    }
                } else {
                    n.c().a(f1140k, String.format("Already started work for %s", this.f1141d), new Throwable[0]);
                }
            }
        }
    }

    public final void d() {
        synchronized (this.f1144g) {
            this.f1143f.c();
            this.f1142e.f1149d.b(this.f1141d);
            PowerManager.WakeLock wakeLock = this.f1146i;
            if (wakeLock != null && wakeLock.isHeld()) {
                n.c().a(f1140k, String.format("Releasing wakelock %s for WorkSpec %s", this.f1146i, this.f1141d), new Throwable[0]);
                this.f1146i.release();
            }
        }
    }

    @Override // e.c0.a0.q.c
    public void e(List<String> list) {
        g();
    }

    public void f() {
        this.f1146i = m.a(this.b, String.format("%s (%s)", this.f1141d, Integer.valueOf(this.c)));
        n c = n.c();
        String str = f1140k;
        c.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f1146i, this.f1141d), new Throwable[0]);
        this.f1146i.acquire();
        o i2 = ((q) this.f1142e.f1151f.c.r()).i(this.f1141d);
        if (i2 == null) {
            g();
            return;
        }
        boolean b = i2.b();
        this.f1147j = b;
        if (!b) {
            n.c().a(str, String.format("No constraints for %s", this.f1141d), new Throwable[0]);
            c(Collections.singletonList(this.f1141d));
            return;
        }
        this.f1143f.b(Collections.singletonList(i2));
    }

    public final void g() {
        synchronized (this.f1144g) {
            if (this.f1145h < 2) {
                this.f1145h = 2;
                n c = n.c();
                String str = f1140k;
                c.a(str, String.format("Stopping work for WorkSpec %s", this.f1141d), new Throwable[0]);
                Context context = this.b;
                String str2 = this.f1141d;
                Intent intent = new Intent(context, SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str2);
                e eVar = this.f1142e;
                eVar.f1153h.post(new e.b(eVar, intent, this.c));
                if (this.f1142e.f1150e.d(this.f1141d)) {
                    n.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f1141d), new Throwable[0]);
                    Intent d2 = b.d(this.b, this.f1141d);
                    e eVar2 = this.f1142e;
                    eVar2.f1153h.post(new e.b(eVar2, d2, this.c));
                } else {
                    n.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f1141d), new Throwable[0]);
                }
            } else {
                n.c().a(f1140k, String.format("Already stopped work for %s", this.f1141d), new Throwable[0]);
            }
        }
    }
}
