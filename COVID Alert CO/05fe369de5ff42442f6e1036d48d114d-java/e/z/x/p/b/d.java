package e.z.x.p.b;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.z.l;
import e.z.x.b;
import e.z.x.p.b.e;
import e.z.x.q.c;
import e.z.x.s.q;
import e.z.x.t.o;
import java.util.Collections;
import java.util.List;

public class d implements c, b, o.b {

    /* renamed from: k  reason: collision with root package name */
    public static final String f1937k = l.e("DelayMetCommandHandler");
    public final Context b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1938d;

    /* renamed from: e  reason: collision with root package name */
    public final e f1939e;

    /* renamed from: f  reason: collision with root package name */
    public final e.z.x.q.d f1940f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f1941g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public int f1942h = 0;

    /* renamed from: i  reason: collision with root package name */
    public PowerManager.WakeLock f1943i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1944j = false;

    public d(Context context, int i2, String str, e eVar) {
        this.b = context;
        this.c = i2;
        this.f1939e = eVar;
        this.f1938d = str;
        this.f1940f = new e.z.x.q.d(context, eVar.c, this);
    }

    @Override // e.z.x.b
    public void a(String str, boolean z) {
        l.c().a(f1937k, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        d();
        if (z) {
            Intent d2 = b.d(this.b, this.f1938d);
            e eVar = this.f1939e;
            eVar.f1950h.post(new e.b(eVar, d2, this.c));
        }
        if (this.f1944j) {
            Intent b2 = b.b(this.b);
            e eVar2 = this.f1939e;
            eVar2.f1950h.post(new e.b(eVar2, b2, this.c));
        }
    }

    @Override // e.z.x.t.o.b
    public void b(String str) {
        l.c().a(f1937k, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // e.z.x.q.c
    public void c(List<String> list) {
        if (list.contains(this.f1938d)) {
            synchronized (this.f1941g) {
                if (this.f1942h == 0) {
                    this.f1942h = 1;
                    l.c().a(f1937k, String.format("onAllConstraintsMet for %s", this.f1938d), new Throwable[0]);
                    if (this.f1939e.f1947e.f(this.f1938d, null)) {
                        this.f1939e.f1946d.a(this.f1938d, 600000, this);
                    } else {
                        d();
                    }
                } else {
                    l.c().a(f1937k, String.format("Already started work for %s", this.f1938d), new Throwable[0]);
                }
            }
        }
    }

    public final void d() {
        synchronized (this.f1941g) {
            this.f1940f.c();
            this.f1939e.f1946d.b(this.f1938d);
            PowerManager.WakeLock wakeLock = this.f1943i;
            if (wakeLock != null && wakeLock.isHeld()) {
                l.c().a(f1937k, String.format("Releasing wakelock %s for WorkSpec %s", this.f1943i, this.f1938d), new Throwable[0]);
                this.f1943i.release();
            }
        }
    }

    @Override // e.z.x.q.c
    public void e(List<String> list) {
        g();
    }

    public void f() {
        this.f1943i = e.z.x.t.l.a(this.b, String.format("%s (%s)", this.f1938d, Integer.valueOf(this.c)));
        l c2 = l.c();
        String str = f1937k;
        c2.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f1943i, this.f1938d), new Throwable[0]);
        this.f1943i.acquire();
        e.z.x.s.o i2 = ((q) this.f1939e.f1948f.c.r()).i(this.f1938d);
        if (i2 == null) {
            g();
            return;
        }
        boolean b2 = i2.b();
        this.f1944j = b2;
        if (!b2) {
            l.c().a(str, String.format("No constraints for %s", this.f1938d), new Throwable[0]);
            c(Collections.singletonList(this.f1938d));
            return;
        }
        this.f1940f.b(Collections.singletonList(i2));
    }

    public final void g() {
        synchronized (this.f1941g) {
            if (this.f1942h < 2) {
                this.f1942h = 2;
                l c2 = l.c();
                String str = f1937k;
                c2.a(str, String.format("Stopping work for WorkSpec %s", this.f1938d), new Throwable[0]);
                Context context = this.b;
                String str2 = this.f1938d;
                Intent intent = new Intent(context, SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str2);
                e eVar = this.f1939e;
                eVar.f1950h.post(new e.b(eVar, intent, this.c));
                if (this.f1939e.f1947e.d(this.f1938d)) {
                    l.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f1938d), new Throwable[0]);
                    Intent d2 = b.d(this.b, this.f1938d);
                    e eVar2 = this.f1939e;
                    eVar2.f1950h.post(new e.b(eVar2, d2, this.c));
                } else {
                    l.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f1938d), new Throwable[0]);
                }
            } else {
                l.c().a(f1937k, String.format("Already stopped work for %s", this.f1938d), new Throwable[0]);
            }
        }
    }
}
