package com.google.android.apps.exposurenotification.home;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import e.r.e0;
import e.r.s;
import e.v.i;
import e.v.n.d;
import e.v.p.c;
import f.a.a.a.a;
import f.b.a.a.a.a0.r;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.c0.u1;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.d0;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.k0;
import f.b.a.a.a.n0.x;
import f.b.a.a.a.n0.z;
import f.b.a.a.a.t.i0;
import f.b.a.a.a.t.l0;
import f.b.a.a.a.x.g;
import f.b.a.a.a.x.y;
import f.b.a.c.b.l.b;
import f.b.a.c.i.e;
import f.b.a.c.i.f;
import f.b.b.a.l;
import f.b.b.f.a.p;
import f.b.b.f.a.q;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class ExposureNotificationViewModel extends e0 {
    public static final f.b.a.a.a.t.p0.a y = f.b.a.a.a.t.p0.a.e("ExposureNotificationVM");
    public final s<b> c;

    /* renamed from: d */
    public final s<Boolean> f341d;

    /* renamed from: e */
    public final s<Boolean> f342e;

    /* renamed from: f */
    public final s<Boolean> f343f;

    /* renamed from: g */
    public final s<Boolean> f344g;

    /* renamed from: j */
    public final a1 f347j;

    /* renamed from: k */
    public final i0<b, Boolean> f348k;
    public final q1 q;
    public final k0 r;
    public final r s;
    public final u1 t;
    public final f.b.a.a.a.t.q0.a u;
    public final ExecutorService v;

    /* renamed from: h */
    public final s<Boolean> f345h = new s<>(Boolean.TRUE);

    /* renamed from: i */
    public final s<l<Boolean>> f346i = new s<>(f.b.b.a.a.b);

    /* renamed from: l */
    public final l0<Void> f349l = new l0<>();
    public final l0<Void> m = new l0<>();
    public final l0<Boolean> n = new l0<>();
    public final l0<f.b.a.c.b.l.b> o = new l0<>();
    public final l0<j0> p = new l0<>();
    public LiveData<Boolean> w = null;
    public boolean x = false;

    /* loaded from: classes.dex */
    public class a implements p<j0> {
        public a() {
            ExposureNotificationViewModel.this = r1;
        }

        @Override // f.b.b.f.a.p
        public void a(j0 j0Var) {
            j0 j0Var2 = j0Var;
            l0<j0> l0Var = ExposureNotificationViewModel.this.p;
            if (j0Var2 == null) {
                j0Var2 = ShareDiagnosisViewModel.X;
            }
            l0Var.j(j0Var2);
        }

        @Override // f.b.b.f.a.p
        public void b(Throwable th) {
            ExposureNotificationViewModel.y.h("Failed to retrieve last not shared diagnosis", th);
        }
    }

    /* loaded from: classes.dex */
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

    public ExposureNotificationViewModel(a1 a1Var, q1 q1Var, k0 k0Var, r rVar, u1 u1Var, f.b.a.a.a.t.q0.a aVar, ExecutorService executorService) {
        Boolean bool = Boolean.FALSE;
        s<Boolean> sVar = new s<>(bool);
        this.f341d = sVar;
        this.f342e = new s<>(bool);
        this.f344g = new s<>(bool);
        this.f347j = a1Var;
        this.q = q1Var;
        this.r = k0Var;
        this.s = rVar;
        this.t = u1Var;
        this.u = aVar;
        this.v = executorService;
        this.f343f = new s<>(Boolean.valueOf(a1Var.a.getBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", false)));
        s<b> sVar2 = new s<>(b.values()[a1Var.a.getInt("ExposureNotificationSharedPreferences.EN_STATE_CACHE_KEY", 0)]);
        this.c = sVar2;
        this.f348k = new i0<>(sVar2, sVar);
        new i0(sVar2, a1Var.f2317h);
    }

    public void c() {
        x xVar = this.r.a;
        List<j0.c> list = k0.f2367d;
        d0 d0Var = (d0) xVar;
        Objects.requireNonNull(d0Var);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM DiagnosisEntity WHERE sharedStatus IN (");
        int size = list.size();
        c.a(sb, size);
        sb.append(") ORDER BY createdTimestampMs DESC LIMIT 1");
        i t = i.t(sb.toString(), size + 0);
        int i2 = 1;
        for (j0.c cVar : list) {
            String d0 = m.e.d0(cVar);
            if (d0 == null) {
                t.J(i2);
            } else {
                t.L(i2, d0);
            }
            i2++;
        }
        CancellationSignal cancellationSignal = new CancellationSignal();
        u b2 = d.b(d0Var.a, false, new z(d0Var, t, cancellationSignal), t, true, cancellationSignal);
        a aVar = new a();
        ExecutorService executorService = this.v;
        ((e.g.a.a) b2).a(new q(b2, aVar), executorService);
    }

    public final synchronized void d(boolean z) {
        this.f341d.l(Boolean.TRUE);
        this.q.b().f(new f(z) { // from class: f.b.a.a.a.x.w
            public final /* synthetic */ boolean b;

            {
                this.b = r2;
            }

            @Override // f.b.a.c.i.f
            public final void a(Object obj) {
                Boolean bool;
                s<Boolean> sVar;
                ExposureNotificationViewModel exposureNotificationViewModel = ExposureNotificationViewModel.this;
                boolean z2 = this.b;
                Set set = (Set) obj;
                Objects.requireNonNull(exposureNotificationViewModel);
                f.b.a.c.f.b.d dVar = f.b.a.c.f.b.d.LOCATION_DISABLED;
                if (set != null) {
                    if (set.contains(dVar)) {
                        sVar = exposureNotificationViewModel.f345h;
                        bool = Boolean.TRUE;
                    } else {
                        sVar = exposureNotificationViewModel.f345h;
                        bool = Boolean.FALSE;
                    }
                    sVar.l(bool);
                }
                f.b.a.c.f.b.d dVar2 = f.b.a.c.f.b.d.BLUETOOTH_SUPPORT_UNKNOWN;
                f.b.a.c.f.b.d dVar3 = f.b.a.c.f.b.d.BLUETOOTH_DISABLED;
                ExposureNotificationViewModel.b bVar = ExposureNotificationViewModel.b.STORAGE_LOW;
                f.b.a.c.f.b.d dVar4 = f.b.a.c.f.b.d.LOW_STORAGE;
                bVar = ExposureNotificationViewModel.b.DISABLED;
                if (!z2) {
                    if (set.contains(f.b.a.c.f.b.d.EN_NOT_SUPPORT)) {
                        bVar = ExposureNotificationViewModel.b.PAUSED_EN_NOT_SUPPORT;
                    } else if (set.contains(f.b.a.c.f.b.d.HW_NOT_SUPPORT)) {
                        bVar = ExposureNotificationViewModel.b.PAUSED_HW_NOT_SUPPORT;
                    } else if (set.contains(f.b.a.c.f.b.d.USER_PROFILE_NOT_SUPPORT)) {
                        bVar = ExposureNotificationViewModel.b.PAUSED_USER_PROFILE_NOT_SUPPORT;
                    } else if (set.contains(f.b.a.c.f.b.d.NOT_IN_ALLOWLIST)) {
                        bVar = ExposureNotificationViewModel.b.PAUSED_NOT_IN_ALLOWLIST;
                    } else if (!set.contains(dVar4)) {
                        if (!set.contains(f.b.a.c.f.b.d.NO_CONSENT) && set.contains(f.b.a.c.f.b.d.FOCUS_LOST)) {
                            bVar = ExposureNotificationViewModel.b.FOCUS_LOST;
                        }
                    }
                } else if (set.contains(f.b.a.c.f.b.d.ACTIVATED)) {
                    bVar = ExposureNotificationViewModel.b.ENABLED;
                } else if (set.contains(f.b.a.c.f.b.d.INACTIVATED)) {
                    if (!set.contains(dVar4)) {
                        if (set.contains(dVar) && (set.contains(dVar3) || set.contains(dVar2))) {
                            bVar = ExposureNotificationViewModel.b.PAUSED_LOCATION_BLE;
                        } else if (set.contains(dVar3) || set.contains(dVar2)) {
                            bVar = ExposureNotificationViewModel.b.PAUSED_BLE;
                        } else if (set.contains(dVar)) {
                            bVar = ExposureNotificationViewModel.b.PAUSED_LOCATION;
                        }
                    }
                }
                exposureNotificationViewModel.c.l(bVar);
                a1 a1Var = exposureNotificationViewModel.f347j;
                a1Var.a.edit().putInt("ExposureNotificationSharedPreferences.EN_STATE_CACHE_KEY", bVar.ordinal()).apply();
                exposureNotificationViewModel.f341d.l(Boolean.FALSE);
            }
        }).a(new f.b.a.c.i.c() { // from class: f.b.a.a.a.x.e
            @Override // f.b.a.c.i.c
            public final void d() {
                ExposureNotificationViewModel exposureNotificationViewModel = ExposureNotificationViewModel.this;
                Objects.requireNonNull(exposureNotificationViewModel);
                ExposureNotificationViewModel.y.f("Call getStatus is canceled");
                exposureNotificationViewModel.f341d.l(Boolean.FALSE);
            }
        }).d(new e() { // from class: f.b.a.a.a.x.t
            @Override // f.b.a.c.i.e
            public final void b(Exception exc) {
                ExposureNotificationViewModel exposureNotificationViewModel = ExposureNotificationViewModel.this;
                Objects.requireNonNull(exposureNotificationViewModel);
                ExposureNotificationViewModel.y.d("Error calling getStatus", exc);
                exposureNotificationViewModel.c.l(ExposureNotificationViewModel.b.DISABLED);
                exposureNotificationViewModel.f347j.a.edit().putInt("ExposureNotificationSharedPreferences.EN_STATE_CACHE_KEY", 0).apply();
                exposureNotificationViewModel.f341d.l(Boolean.FALSE);
            }
        });
    }

    public void e() {
        synchronized (this) {
            if (!this.x) {
                this.x = true;
                this.q.c().f(new f() { // from class: f.b.a.a.a.x.h
                    @Override // f.b.a.c.i.f
                    public final void a(Object obj) {
                        ExposureNotificationViewModel exposureNotificationViewModel = ExposureNotificationViewModel.this;
                        Boolean bool = (Boolean) obj;
                        Objects.requireNonNull(exposureNotificationViewModel);
                        exposureNotificationViewModel.d(bool.booleanValue());
                        exposureNotificationViewModel.f343f.l(bool);
                        exposureNotificationViewModel.f344g.l(bool);
                        a1 a1Var = exposureNotificationViewModel.f347j;
                        a.o(a1Var.a, "ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", bool.booleanValue());
                        exposureNotificationViewModel.x = false;
                    }
                }).a(new f.b.a.c.i.c() { // from class: f.b.a.a.a.x.b
                    @Override // f.b.a.c.i.c
                    public final void d() {
                        ExposureNotificationViewModel exposureNotificationViewModel = ExposureNotificationViewModel.this;
                        Objects.requireNonNull(exposureNotificationViewModel);
                        ExposureNotificationViewModel.y.f("Call isEnabled is canceled");
                        exposureNotificationViewModel.x = false;
                    }
                }).d(new e() { // from class: f.b.a.a.a.x.j
                    @Override // f.b.a.c.i.e
                    public final void b(Exception exc) {
                        ExposureNotificationViewModel exposureNotificationViewModel = ExposureNotificationViewModel.this;
                        exposureNotificationViewModel.d(false);
                        s<Boolean> sVar = exposureNotificationViewModel.f343f;
                        Boolean bool = Boolean.FALSE;
                        sVar.l(bool);
                        exposureNotificationViewModel.f344g.l(bool);
                        a.o(exposureNotificationViewModel.f347j.a, "ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", false);
                        exposureNotificationViewModel.x = false;
                    }
                });
            }
        }
        synchronized (this) {
            this.q.a().f(new f() { // from class: f.b.a.a.a.x.s
                @Override // f.b.a.c.i.f
                public final void a(Object obj) {
                    Bundle bundle;
                    ExposureNotificationViewModel exposureNotificationViewModel = ExposureNotificationViewModel.this;
                    f.b.a.c.f.b.f fVar = (f.b.a.c.f.b.f) obj;
                    exposureNotificationViewModel.t.a(fVar);
                    exposureNotificationViewModel.t.b(fVar);
                    e.r.s<l<Boolean>> sVar = exposureNotificationViewModel.f346i;
                    boolean z = false;
                    if (!(fVar == null || (bundle = fVar.b) == null)) {
                        z = bundle.getBoolean("SMS_NOTICE", false);
                    }
                    sVar.j(l.c(Boolean.valueOf(z)));
                }
            }).a(y.a).d(g.a);
        }
    }

    public void f() {
        this.f341d.l(Boolean.TRUE);
        this.q.d().f(new f() { // from class: f.b.a.a.a.x.x
            @Override // f.b.a.c.i.f
            public final void a(Object obj) {
                ExposureNotificationViewModel exposureNotificationViewModel = ExposureNotificationViewModel.this;
                Void r3 = (Void) obj;
                exposureNotificationViewModel.d(true);
                s<Boolean> sVar = exposureNotificationViewModel.f343f;
                Boolean bool = Boolean.TRUE;
                sVar.l(bool);
                exposureNotificationViewModel.f344g.l(bool);
                exposureNotificationViewModel.f341d.l(Boolean.FALSE);
                exposureNotificationViewModel.e();
            }
        }).d(new e() { // from class: f.b.a.a.a.x.i
            @Override // f.b.a.c.i.e
            public final void b(Exception exc) {
                f.b.a.c.b.a aVar;
                ExposureNotificationViewModel exposureNotificationViewModel = ExposureNotificationViewModel.this;
                Objects.requireNonNull(exposureNotificationViewModel);
                if (!(exc instanceof b)) {
                    exposureNotificationViewModel.f341d.l(Boolean.FALSE);
                    exposureNotificationViewModel.f349l.l(null);
                    return;
                }
                b bVar = (b) exc;
                if (bVar.b.c != 6) {
                    ExposureNotificationViewModel.y.h("No RESOLUTION_REQUIRED in result", bVar);
                    int i2 = -1;
                    Status status = bVar.b;
                    if (!(status == null || (aVar = status.f463f) == null)) {
                        i2 = aVar.c;
                    }
                    ((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9) ? exposureNotificationViewModel.m : exposureNotificationViewModel.f349l).l(null);
                    exposureNotificationViewModel.f341d.l(Boolean.FALSE);
                } else if (exposureNotificationViewModel.f342e.d().booleanValue()) {
                    ExposureNotificationViewModel.y.d("Error, has in flight resolution", exc);
                } else {
                    exposureNotificationViewModel.f342e.l(Boolean.TRUE);
                    exposureNotificationViewModel.o.j(bVar);
                }
            }
        }).a(new f.b.a.c.i.c() { // from class: f.b.a.a.a.x.c
            @Override // f.b.a.c.i.c
            public final void d() {
                ExposureNotificationViewModel.this.f341d.l(Boolean.FALSE);
            }
        });
    }

    public final void g(f.b.a.c.b.l.b bVar, e.a.e.c<e.a.e.e> cVar) {
        y.a("startResolutionForResult");
        PendingIntent pendingIntent = bVar.b.f462e;
        if (pendingIntent != null) {
            cVar.a(new e.a.e.e(pendingIntent.getIntentSender(), null, 0, 0), null);
        }
    }
}
