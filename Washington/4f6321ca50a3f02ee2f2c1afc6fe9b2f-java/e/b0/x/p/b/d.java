package e.b0.x.p.b;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.b0.l;
import e.b0.x.b;
import e.b0.x.p.b.e;
import e.b0.x.q.c;
import e.b0.x.s.q;
import e.b0.x.t.o;
import java.util.Collections;
import java.util.List;

public class d implements c, b, o.b {

    /* renamed from: k  reason: collision with root package name */
    public static final String f1062k = l.e("DelayMetCommandHandler");
    public final Context b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1063d;

    /* renamed from: e  reason: collision with root package name */
    public final e f1064e;

    /* renamed from: f  reason: collision with root package name */
    public final e.b0.x.q.d f1065f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f1066g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public int f1067h = 0;

    /* renamed from: i  reason: collision with root package name */
    public PowerManager.WakeLock f1068i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1069j = false;

    public d(Context context, int i2, String str, e eVar) {
        this.b = context;
        this.c = i2;
        this.f1064e = eVar;
        this.f1063d = str;
        this.f1065f = new e.b0.x.q.d(context, eVar.c, this);
    }

    @Override // e.b0.x.b
    public void a(String str, boolean z) {
        l.c().a(f1062k, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        d();
        if (z) {
            Intent d2 = b.d(this.b, this.f1063d);
            e eVar = this.f1064e;
            eVar.f1075h.post(new e.b(eVar, d2, this.c));
        }
        if (this.f1069j) {
            Intent b2 = b.b(this.b);
            e eVar2 = this.f1064e;
            eVar2.f1075h.post(new e.b(eVar2, b2, this.c));
        }
    }

    @Override // e.b0.x.t.o.b
    public void b(String str) {
        l.c().a(f1062k, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // e.b0.x.q.c
    public void c(List<String> list) {
        if (list.contains(this.f1063d)) {
            synchronized (this.f1066g) {
                if (this.f1067h == 0) {
                    this.f1067h = 1;
                    l.c().a(f1062k, String.format("onAllConstraintsMet for %s", this.f1063d), new Throwable[0]);
                    if (this.f1064e.f1072e.f(this.f1063d, null)) {
                        this.f1064e.f1071d.a(this.f1063d, 600000, this);
                    } else {
                        d();
                    }
                } else {
                    l.c().a(f1062k, String.format("Already started work for %s", this.f1063d), new Throwable[0]);
                }
            }
        }
    }

    public final void d() {
        synchronized (this.f1066g) {
            this.f1065f.c();
            this.f1064e.f1071d.b(this.f1063d);
            PowerManager.WakeLock wakeLock = this.f1068i;
            if (wakeLock != null && wakeLock.isHeld()) {
                l.c().a(f1062k, String.format("Releasing wakelock %s for WorkSpec %s", this.f1068i, this.f1063d), new Throwable[0]);
                this.f1068i.release();
            }
        }
    }

    @Override // e.b0.x.q.c
    public void e(List<String> list) {
        g();
    }

    public void f() {
        this.f1068i = e.b0.x.t.l.a(this.b, String.format("%s (%s)", this.f1063d, Integer.valueOf(this.c)));
        l c2 = l.c();
        String str = f1062k;
        c2.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f1068i, this.f1063d), new Throwable[0]);
        this.f1068i.acquire();
        e.b0.x.s.o i2 = ((q) this.f1064e.f1073f.c.r()).i(this.f1063d);
        if (i2 == null) {
            g();
            return;
        }
        boolean b2 = i2.b();
        this.f1069j = b2;
        if (!b2) {
            l.c().a(str, String.format("No constraints for %s", this.f1063d), new Throwable[0]);
            c(Collections.singletonList(this.f1063d));
            return;
        }
        this.f1065f.b(Collections.singletonList(i2));
    }

    public final void g() {
        synchronized (this.f1066g) {
            if (this.f1067h < 2) {
                this.f1067h = 2;
                l c2 = l.c();
                String str = f1062k;
                c2.a(str, String.format("Stopping work for WorkSpec %s", this.f1063d), new Throwable[0]);
                Context context = this.b;
                String str2 = this.f1063d;
                Intent intent = new Intent(context, SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str2);
                e eVar = this.f1064e;
                eVar.f1075h.post(new e.b(eVar, intent, this.c));
                if (this.f1064e.f1072e.d(this.f1063d)) {
                    l.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f1063d), new Throwable[0]);
                    Intent d2 = b.d(this.b, this.f1063d);
                    e eVar2 = this.f1064e;
                    eVar2.f1075h.post(new e.b(eVar2, d2, this.c));
                } else {
                    l.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f1063d), new Throwable[0]);
                }
            } else {
                l.c().a(f1062k, String.format("Already stopped work for %s", this.f1063d), new Throwable[0]);
            }
        }
    }
}
