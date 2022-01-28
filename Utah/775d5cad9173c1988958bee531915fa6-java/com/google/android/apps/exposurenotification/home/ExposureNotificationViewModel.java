package com.google.android.apps.exposurenotification.home;

import android.app.PendingIntent;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.q.e0;
import e.q.s;
import e.u.i;
import e.u.n.d;
import e.u.p.c;
import f.b.a.a.a.b0.i1;
import f.b.a.a.a.b0.m1;
import f.b.a.a.a.l0.a0;
import f.b.a.a.a.l0.g0;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.l0.i0;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.s.w;
import f.b.a.a.a.s.z;
import f.b.a.a.a.w.e;
import f.b.a.a.a.w.g;
import f.b.a.a.a.w.h;
import f.b.a.a.a.w.j;
import f.b.a.a.a.w.t;
import f.b.a.a.a.w.x;
import f.b.a.a.a.w.y;
import f.b.a.a.a.z.r;
import f.b.b.a.l;
import f.b.b.f.a.p;
import f.b.b.f.a.q;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class ExposureNotificationViewModel extends e0 {
    public static final f.b.a.a.a.s.d0.a y = f.b.a.a.a.s.d0.a.e("ExposureNotificationVM");
    public final s<b> c;

    /* renamed from: d  reason: collision with root package name */
    public final s<Boolean> f339d;

    /* renamed from: e  reason: collision with root package name */
    public final s<Boolean> f340e;

    /* renamed from: f  reason: collision with root package name */
    public final s<Boolean> f341f;

    /* renamed from: g  reason: collision with root package name */
    public final s<Boolean> f342g;

    /* renamed from: h  reason: collision with root package name */
    public final s<Boolean> f343h = new s<>(Boolean.TRUE);

    /* renamed from: i  reason: collision with root package name */
    public final s<l<Boolean>> f344i = new s<>(f.b.b.a.a.b);

    /* renamed from: j  reason: collision with root package name */
    public final v0 f345j;

    /* renamed from: k  reason: collision with root package name */
    public final w<b, Boolean> f346k;

    /* renamed from: l  reason: collision with root package name */
    public final z<Void> f347l = new z<>();
    public final z<Void> m = new z<>();
    public final z<Boolean> n = new z<>();
    public final z<f.b.a.c.b.l.b> o = new z<>();
    public final z<h0> p = new z<>();
    public final i1 q;
    public final i0 r;
    public final r s;
    public final m1 t;
    public final f.b.a.a.a.s.e0.a u;
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
            z<h0> zVar = ExposureNotificationViewModel.this.p;
            if (h0Var2 == null) {
                h0Var2 = ShareDiagnosisViewModel.U;
            }
            zVar.j(h0Var2);
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

    public ExposureNotificationViewModel(v0 v0Var, i1 i1Var, i0 i0Var, r rVar, m1 m1Var, f.b.a.a.a.s.e0.a aVar, ExecutorService executorService) {
        Boolean bool = Boolean.FALSE;
        s<Boolean> sVar = new s<>(bool);
        this.f339d = sVar;
        this.f340e = new s<>(bool);
        this.f342g = new s<>(bool);
        this.f345j = v0Var;
        this.q = i1Var;
        this.r = i0Var;
        this.s = rVar;
        this.t = m1Var;
        this.u = aVar;
        this.v = executorService;
        this.f341f = new s<>(Boolean.valueOf(v0Var.a.getBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", false)));
        s<b> sVar2 = new s<>(b.values()[v0Var.a.getInt("ExposureNotificationSharedPreferences.EN_STATE_CACHE_KEY", 0)]);
        this.c = sVar2;
        this.f346k = new w<>(sVar2, sVar);
        new w(sVar2, v0Var.f2316h);
    }

    public void c() {
        f.b.a.a.a.l0.w wVar = this.r.a;
        List<h0.c> list = i0.f2289d;
        a0 a0Var = (a0) wVar;
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
            String c0 = m.e.c0(cVar);
            if (c0 == null) {
                t2.J(i2);
            } else {
                t2.L(i2, c0);
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
        this.f339d.l(Boolean.TRUE);
        this.q.a.getStatus().f(new f.b.a.a.a.w.w(this, z)).a(new e(this)).d(new t(this));
    }

    public void e() {
        synchronized (this) {
            if (!this.x) {
                this.x = true;
                this.q.b().f(new h(this)).a(new f.b.a.a.a.w.b(this)).d(new j(this));
            }
        }
        synchronized (this) {
            this.q.a().f(new f.b.a.a.a.w.s(this)).a(y.a).d(g.a);
        }
    }

    public void f() {
        this.f339d.l(Boolean.TRUE);
        this.q.c().f(new x(this)).d(new f.b.a.a.a.w.i(this)).a(new f.b.a.a.a.w.c(this));
    }

    public final void g(f.b.a.c.b.l.b bVar, e.a.e.c<e.a.e.e> cVar) {
        y.a("startResolutionForResult");
        PendingIntent pendingIntent = bVar.b.f452e;
        if (pendingIntent != null) {
            cVar.a(new e.a.e.e(pendingIntent.getIntentSender(), null, 0, 0), null);
        }
    }
}
