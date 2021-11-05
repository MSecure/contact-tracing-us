package b.z.y.o.b;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import b.z.m;
import b.z.y.b;
import b.z.y.o.b.e;
import b.z.y.p.c;
import b.z.y.r.p;
import b.z.y.r.r;
import b.z.y.s.l;
import b.z.y.s.q;
import java.util.Collections;
import java.util.List;

public class d implements c, b, q.b {
    public static final String k = m.e("DelayMetCommandHandler");

    /* renamed from: b  reason: collision with root package name */
    public final Context f2008b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2009c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2010d;

    /* renamed from: e  reason: collision with root package name */
    public final e f2011e;
    public final b.z.y.p.d f;
    public final Object g = new Object();
    public int h = 0;
    public PowerManager.WakeLock i;
    public boolean j = false;

    public d(Context context, int i2, String str, e eVar) {
        this.f2008b = context;
        this.f2009c = i2;
        this.f2011e = eVar;
        this.f2010d = str;
        this.f = new b.z.y.p.d(this.f2008b, eVar.f2013c, this);
    }

    @Override // b.z.y.b
    public void a(String str, boolean z) {
        m.c().a(k, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        d();
        if (z) {
            Intent e2 = b.e(this.f2008b, this.f2010d);
            e eVar = this.f2011e;
            eVar.h.post(new e.b(eVar, e2, this.f2009c));
        }
        if (this.j) {
            Intent b2 = b.b(this.f2008b);
            e eVar2 = this.f2011e;
            eVar2.h.post(new e.b(eVar2, b2, this.f2009c));
        }
    }

    @Override // b.z.y.s.q.b
    public void b(String str) {
        m.c().a(k, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // b.z.y.p.c
    public void c(List<String> list) {
        if (list.contains(this.f2010d)) {
            synchronized (this.g) {
                if (this.h == 0) {
                    this.h = 1;
                    m.c().a(k, String.format("onAllConstraintsMet for %s", this.f2010d), new Throwable[0]);
                    if (this.f2011e.f2015e.g(this.f2010d, null)) {
                        this.f2011e.f2014d.a(this.f2010d, 600000, this);
                    } else {
                        d();
                    }
                } else {
                    m.c().a(k, String.format("Already started work for %s", this.f2010d), new Throwable[0]);
                }
            }
        }
    }

    public final void d() {
        synchronized (this.g) {
            this.f.c();
            this.f2011e.f2014d.b(this.f2010d);
            if (this.i != null && this.i.isHeld()) {
                m.c().a(k, String.format("Releasing wakelock %s for WorkSpec %s", this.i, this.f2010d), new Throwable[0]);
                this.i.release();
            }
        }
    }

    @Override // b.z.y.p.c
    public void e(List<String> list) {
        g();
    }

    public void f() {
        this.i = l.b(this.f2008b, String.format("%s (%s)", this.f2010d, Integer.valueOf(this.f2009c)));
        m.c().a(k, String.format("Acquiring wakelock %s for WorkSpec %s", this.i, this.f2010d), new Throwable[0]);
        this.i.acquire();
        p i2 = ((r) this.f2011e.f.f1971c.h()).i(this.f2010d);
        if (i2 == null) {
            g();
            return;
        }
        boolean b2 = i2.b();
        this.j = b2;
        if (!b2) {
            m.c().a(k, String.format("No constraints for %s", this.f2010d), new Throwable[0]);
            c(Collections.singletonList(this.f2010d));
            return;
        }
        this.f.b(Collections.singletonList(i2));
    }

    public final void g() {
        synchronized (this.g) {
            if (this.h < 2) {
                this.h = 2;
                m.c().a(k, String.format("Stopping work for WorkSpec %s", this.f2010d), new Throwable[0]);
                Context context = this.f2008b;
                String str = this.f2010d;
                Intent intent = new Intent(context, SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str);
                e eVar = this.f2011e;
                eVar.h.post(new e.b(this.f2011e, intent, this.f2009c));
                if (this.f2011e.f2015e.d(this.f2010d)) {
                    m.c().a(k, String.format("WorkSpec %s needs to be rescheduled", this.f2010d), new Throwable[0]);
                    Intent e2 = b.e(this.f2008b, this.f2010d);
                    e eVar2 = this.f2011e;
                    eVar2.h.post(new e.b(this.f2011e, e2, this.f2009c));
                } else {
                    m.c().a(k, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f2010d), new Throwable[0]);
                }
            } else {
                m.c().a(k, String.format("Already stopped work for %s", this.f2010d), new Throwable[0]);
            }
        }
    }
}
