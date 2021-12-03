package com.google.android.apps.exposurenotification.home;

import android.app.PendingIntent;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.p.e0;
import e.p.s;
import e.t.i;
import e.t.n.d;
import e.t.p.c;
import f.b.a.a.a.b0.g0;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.b0.w;
import f.b.a.a.a.i.a0;
import f.b.a.a.a.i.x;
import f.b.a.a.a.m.e;
import f.b.a.a.a.m.g;
import f.b.a.a.a.m.h;
import f.b.a.a.a.m.j;
import f.b.a.a.a.m.t;
import f.b.a.a.a.m.y;
import f.b.a.a.a.p.r;
import f.b.a.a.a.q.i1;
import f.b.a.a.a.q.m1;
import f.b.b.a.l;
import f.b.b.f.a.p;
import f.b.b.f.a.q;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class ExposureNotificationViewModel extends e0 {
    public static final f.b.a.a.a.i.e0.a y = f.b.a.a.a.i.e0.a.e("ExposureNotificationVM");
    public final s<b> c;

    /* renamed from: d  reason: collision with root package name */
    public final s<Boolean> f334d;

    /* renamed from: e  reason: collision with root package name */
    public final s<Boolean> f335e;

    /* renamed from: f  reason: collision with root package name */
    public final s<Boolean> f336f;

    /* renamed from: g  reason: collision with root package name */
    public final s<Boolean> f337g;

    /* renamed from: h  reason: collision with root package name */
    public final s<Boolean> f338h = new s<>(Boolean.TRUE);

    /* renamed from: i  reason: collision with root package name */
    public final s<l<Boolean>> f339i = new s<>(f.b.b.a.a.b);

    /* renamed from: j  reason: collision with root package name */
    public final v0 f340j;

    /* renamed from: k  reason: collision with root package name */
    public final x<b, Boolean> f341k;

    /* renamed from: l  reason: collision with root package name */
    public final a0<Void> f342l = new a0<>();
    public final a0<Void> m = new a0<>();
    public final a0<Boolean> n = new a0<>();
    public final a0<f.b.a.c.b.l.b> o = new a0<>();
    public final a0<h0> p = new a0<>();
    public final i1 q;
    public final i0 r;
    public final r s;
    public final m1 t;
    public final f.b.a.a.a.i.f0.a u;
    public final ExecutorService v;
    public LiveData<Boolean> w = null;
    public boolean x = false;

    public class a implements p<h0> {
        public a() {
        }

        @Override // f.b.b.f.a.p
        public void a(Throwable th) {
            ExposureNotificationViewModel.y.h("Failed to retrieve last not shared diagnosis", th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // f.b.b.f.a.p
        public void b(h0 h0Var) {
            h0 h0Var2 = h0Var;
            a0<h0> a0Var = ExposureNotificationViewModel.this.p;
            if (h0Var2 == null) {
                h0Var2 = ShareDiagnosisViewModel.U;
            }
            a0Var.j(h0Var2);
        }
    }

    public enum b {
        DISABLED,
        ENABLED,
        PAUSED_BLE,
        PAUSED_LOCATION,
        PAUSED_LOCATION_BLE,
        STORAGE_LOW,
        PAUSED_EN_NOT_SUPPORT,
        FOCUS_LOST,
        PAUSED_HW_NOT_SUPPORT,
        PAUSED_NOT_IN_ALLOWLIST,
        PAUSED_USER_PROFILE_NOT_SUPPORT
    }

    public ExposureNotificationViewModel(v0 v0Var, i1 i1Var, i0 i0Var, r rVar, m1 m1Var, f.b.a.a.a.i.f0.a aVar, ExecutorService executorService) {
        Boolean bool = Boolean.FALSE;
        s<Boolean> sVar = new s<>(bool);
        this.f334d = sVar;
        this.f335e = new s<>(bool);
        this.f337g = new s<>(bool);
        this.f340j = v0Var;
        this.q = i1Var;
        this.r = i0Var;
        this.s = rVar;
        this.t = m1Var;
        this.u = aVar;
        this.v = executorService;
        this.f336f = new s<>(Boolean.valueOf(v0Var.a.getBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", false)));
        s<b> sVar2 = new s<>(b.values()[v0Var.a.getInt("ExposureNotificationSharedPreferences.EN_STATE_CACHE_KEY", 0)]);
        this.c = sVar2;
        this.f341k = new x<>(sVar2, sVar);
        new x(sVar2, v0Var.f2119h);
    }

    public void c() {
        w wVar = this.r.a;
        List<h0.c> list = i0.f2092d;
        f.b.a.a.a.b0.a0 a0Var = (f.b.a.a.a.b0.a0) wVar;
        Objects.requireNonNull(a0Var);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM DiagnosisEntity WHERE sharedStatus IN (");
        int size = list.size();
        c.a(sb, size);
        sb.append(") ORDER BY createdTimestampMs DESC LIMIT 1");
        i t2 = i.t(sb.toString(), size + 0);
        int i2 = 1;
        for (h0.c cVar : list) {
            String a0 = m.h.a0(cVar);
            if (a0 == null) {
                t2.J(i2);
            } else {
                t2.L(i2, a0);
            }
            i2++;
        }
        CancellationSignal cancellationSignal = new CancellationSignal();
        u b2 = d.b(a0Var.a, false, new g0(a0Var, t2, cancellationSignal), t2, true, cancellationSignal);
        a aVar = new a();
        ExecutorService executorService = this.v;
        ((e.f.a.a) b2).a(new q(b2, aVar), executorService);
    }

    public final synchronized void d(boolean z) {
        this.f334d.l(Boolean.TRUE);
        this.q.a.getStatus().f(new f.b.a.a.a.m.w(this, z)).a(new e(this)).d(new t(this));
    }

    public void e() {
        synchronized (this) {
            if (!this.x) {
                this.x = true;
                this.q.b().f(new h(this)).a(new f.b.a.a.a.m.b(this)).d(new j(this));
            }
        }
        synchronized (this) {
            this.q.a().f(new f.b.a.a.a.m.s(this)).a(y.a).d(g.a);
        }
    }

    public void f() {
        this.f334d.l(Boolean.TRUE);
        this.q.c().f(new f.b.a.a.a.m.x(this)).d(new f.b.a.a.a.m.i(this)).a(new f.b.a.a.a.m.c(this));
    }

    public final void g(f.b.a.c.b.l.b bVar, e.a.e.c<e.a.e.e> cVar) {
        y.a("startResolutionForResult");
        PendingIntent pendingIntent = bVar.b.f456e;
        if (pendingIntent != null) {
            cVar.a(new e.a.e.e(pendingIntent.getIntentSender(), null, 0, 0), null);
        }
    }
}
