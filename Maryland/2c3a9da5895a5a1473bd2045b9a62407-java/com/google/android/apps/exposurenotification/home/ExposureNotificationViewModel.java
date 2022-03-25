package com.google.android.apps.exposurenotification.home;

import android.app.PendingIntent;
import androidx.activity.result.ActivityResultRegistry;
import e.a.e.f.d;
import e.b.a.j;
import e.p.a0;
import e.p.o;
import e.p.q;
import f.b.a.a.a.l.c;
import f.b.a.a.a.l.e;
import f.b.a.a.a.l.f;
import f.b.a.a.a.l.g;
import f.b.a.a.a.l.i;
import f.b.a.a.a.l.l;
import f.b.a.a.a.l.m;
import f.b.a.a.a.l.r;
import f.b.a.a.a.l.t;
import f.b.a.a.a.l.u;
import f.b.a.a.a.l.w;
import f.b.a.a.a.o.p;
import f.b.a.a.a.p.f0;
import f.b.a.a.a.p.i0;
import f.b.a.a.a.y.q0;
import f.b.a.c.i.h;
import java.util.Objects;

public class ExposureNotificationViewModel extends a0 {
    public final o<b> c;

    /* renamed from: d  reason: collision with root package name */
    public final q<a> f340d;

    /* renamed from: e  reason: collision with root package name */
    public final q<Boolean> f341e;

    /* renamed from: f  reason: collision with root package name */
    public final q<Boolean> f342f;

    /* renamed from: g  reason: collision with root package name */
    public final q<Boolean> f343g;

    /* renamed from: h  reason: collision with root package name */
    public final q0 f344h;

    /* renamed from: i  reason: collision with root package name */
    public final f.b.a.a.a.h.q<Void> f345i = new f.b.a.a.a.h.q<>();

    /* renamed from: j  reason: collision with root package name */
    public final f.b.a.a.a.h.q<f.b.a.c.b.l.b> f346j = new f.b.a.a.a.h.q<>();

    /* renamed from: k  reason: collision with root package name */
    public final f0 f347k;

    /* renamed from: l  reason: collision with root package name */
    public final p f348l;
    public final i0 m;
    public final f.b.a.a.a.h.s.a n;
    public final b o;
    public boolean p = false;

    public enum a {
        DISABLED,
        ENABLED,
        PAUSED_BLE,
        PAUSED_LOCATION,
        PAUSED_LOCATION_BLE,
        STORAGE_LOW
    }

    public static class b {
        public a a = null;
        public boolean b;

        public b(a aVar, boolean z) {
            this.b = z;
        }
    }

    public ExposureNotificationViewModel(q0 q0Var, f0 f0Var, p pVar, i0 i0Var, f.b.a.a.a.h.s.a aVar) {
        o<b> oVar = new o<>();
        this.c = oVar;
        q<a> qVar = new q<>();
        this.f340d = qVar;
        Boolean bool = Boolean.FALSE;
        q<Boolean> qVar2 = new q<>(bool);
        this.f341e = qVar2;
        this.f342f = new q<>(bool);
        this.f344h = q0Var;
        this.f347k = f0Var;
        this.f348l = pVar;
        this.m = i0Var;
        this.n = aVar;
        this.f343g = new q<>(Boolean.valueOf(q0Var.a.getBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", false)));
        this.o = new b(null, false);
        oVar.m(qVar, new e(this));
        oVar.m(qVar2, new f.b.a.a.a.l.p(this));
    }

    public final synchronized void c(boolean z) {
        this.f341e.l(Boolean.TRUE);
        this.f347k.a.getStatus().f(new w(this, z)).a(new f(this)).d(new r(this));
    }

    public void d() {
        synchronized (this) {
            if (!this.p) {
                this.p = true;
                this.f347k.b().f(new g(this)).a(new c(this)).d(new i(this));
            }
        }
        synchronized (this) {
            h<f.b.a.c.f.b.f> a2 = this.f347k.a();
            i0 i0Var = this.m;
            Objects.requireNonNull(i0Var);
            a2.f(new f.b.a.a.a.l.a(i0Var)).a(m.a).d(t.a);
        }
    }

    public void e(j jVar) {
        d dVar = new d();
        f.b.a.a.a.l.b bVar = new f.b.a.a.a.l.b(this);
        ActivityResultRegistry activityResultRegistry = jVar.f7j;
        StringBuilder h2 = f.a.a.a.a.h("activity_rq#");
        h2.append(jVar.f6i.getAndIncrement());
        this.f346j.f(jVar, new u(this, activityResultRegistry.d(h2.toString(), jVar, dVar, bVar)));
    }

    public void f() {
        this.f341e.l(Boolean.TRUE);
        this.f347k.c().f(new f.b.a.a.a.l.d(this)).d(new l(this)).a(new f.b.a.a.a.l.h(this));
    }

    public final void g(f.b.a.c.b.l.b bVar, e.a.e.c<e.a.e.e> cVar) {
        PendingIntent pendingIntent = bVar.b.f428e;
        if (pendingIntent != null) {
            cVar.a(new e.a.e.e(pendingIntent.getIntentSender(), null, 0, 0), null);
        }
    }
}
