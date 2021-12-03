package f.b.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.google.android.apps.exposurenotification.ExposureNotificationApplication;
import com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import com.google.android.apps.exposurenotification.home.ExposureNotificationActivity;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.home.SplashViewModel;
import com.google.android.apps.exposurenotification.logging.ApplicationObserver;
import com.google.android.apps.exposurenotification.nearby.ExposureNotificationBroadcastReceiver;
import com.google.android.apps.exposurenotification.nearby.SmsVerificationBroadcastReceiver;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import e.q.e0;
import e.q.y;
import e.u.g;
import f.a.b.o;
import f.b.a.a.a.b0.i1;
import f.b.a.a.a.b0.j1;
import f.b.a.a.a.b0.m1;
import f.b.a.a.a.d0.a6;
import f.b.a.a.a.d0.c6;
import f.b.a.a.a.d0.f6;
import f.b.a.a.a.d0.i6;
import f.b.a.a.a.d0.l6;
import f.b.a.a.a.d0.o5;
import f.b.a.a.a.d0.o6;
import f.b.a.a.a.d0.q5;
import f.b.a.a.a.d0.s5;
import f.b.a.a.a.d0.u5;
import f.b.a.a.a.d0.x5;
import f.b.a.a.a.e0.i0;
import f.b.a.a.a.e0.m0;
import f.b.a.a.a.f0.s.m;
import f.b.a.a.a.j0.b1;
import f.b.a.a.a.j0.k0;
import f.b.a.a.a.j0.o0;
import f.b.a.a.a.j0.w0;
import f.b.a.a.a.j0.z0;
import f.b.a.a.a.l0.r0;
import f.b.a.a.a.l0.v;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.l0.y0;
import f.b.a.a.a.n0.l;
import f.b.a.a.a.s.b0;
import f.b.a.a.a.s.p;
import f.b.a.a.a.u.j;
import f.b.a.a.a.v.n;
import f.b.a.a.a.w.f1;
import f.b.a.a.a.y.c0;
import f.b.a.a.a.y.f0;
import f.b.a.a.a.y.h0;
import f.b.a.a.a.z.r;
import f.b.a.a.a.z.s;
import f.b.a.a.a.z.t;
import f.b.a.a.a.z.u;
import f.b.a.d.a.d0;
import f.b.b.b.d;
import f.b.b.f.a.a0;
import f.b.b.f.a.w;
import f.b.b.f.a.x;
import g.b.a.c.c.c;
import gov.ut.covid19.exposurenotifications.R;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class k extends p {
    public i.a.a<r> A;
    public i.a.a<Object> B;
    public i.a.a<Object> C;
    public i.a.a<f.b.a.a.a.c0.g> D;
    public i.a.a<w> E;
    public i.a.a<ExecutorService> F;
    public i.a.a<SecureRandom> G;
    public i.a.a<Object> H;
    public i.a.a<Object> I;
    public i.a.a<Object> J;
    public i.a.a<Object> K;
    public i.a.a<Object> L;
    public i.a.a<f.b.c.a> M;
    public i.a.a<f.b.c.k.f> N;
    public i.a.a<Object> O;
    public i.a.a<Object> P;
    public final f.b.a.a.a.s.r a;
    public final p b;
    public final g.b.a.c.d.a c;

    /* renamed from: d  reason: collision with root package name */
    public final v f2256d;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.a.a.a.s.e0.b f2257e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.i0.d f2258f;

    /* renamed from: g  reason: collision with root package name */
    public final j1 f2259g;

    /* renamed from: h  reason: collision with root package name */
    public final u f2260h;

    /* renamed from: i  reason: collision with root package name */
    public final f.b.a.a.a.z.v f2261i;

    /* renamed from: j  reason: collision with root package name */
    public final h0 f2262j;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.a.a.c0.e f2263k;

    /* renamed from: l  reason: collision with root package name */
    public final f.b.a.a.a.x.p f2264l;
    public final f.b.a.a.a.h0.f m;
    public final m n;
    public final f.b.a.a.a.f0.r o;
    public final f.b.a.a.a.f0.m p;
    public final f.b.a.a.a.n0.f q;
    public final y0 r;
    public final k s = this;
    public i.a.a<w> t;
    public i.a.a<ExecutorService> u;
    public i.a.a<ExposureNotificationDatabase> v;
    public i.a.a<i1> w;
    public i.a.a<f.b.a.b.f<f.b.a.a.a.g0.c>> x;
    public i.a.a<x> y;
    public i.a.a<ScheduledExecutorService> z;

    public static final class a implements g.b.a.c.a.a {
        public final k a;
        public final d b;
        public Activity c;

        public a(k kVar, d dVar, b bVar) {
            this.a = kVar;
            this.b = dVar;
        }
    }

    public static final class b extends m {
        public final k a;
        public final d b;
        public final b c = this;

        public b(k kVar, d dVar, Activity activity) {
            this.a = kVar;
            this.b = dVar;
        }

        @Override // g.b.a.c.b.a
        public g.b.a.c.b.c a() {
            Application u0 = f.b.a.c.b.o.b.u0(this.a.c.a);
            Objects.requireNonNull(u0, "Cannot return null from a non-@Nullable @Provides method");
            return new g.b.a.c.b.c(u0, f.b.b.b.e.t("com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel", "com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel", "com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel", "com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel", "com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel", "com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel", "com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel", "com.google.android.apps.exposurenotification.home.SplashViewModel"), new h(this.a, this.b, null));
        }

        @Override // g.b.a.c.c.g.a
        public g.b.a.c.a.c b() {
            return new e(this.a, this.b, this.c, null);
        }

        @Override // f.b.a.a.a.w.a1
        public void c(ExposureNotificationActivity exposureNotificationActivity) {
        }
    }

    public static final class c implements g.b.a.c.a.b {
        public final k a;

        public c(k kVar, b bVar) {
            this.a = kVar;
        }
    }

    public static final class d extends n {
        public final k a;
        public final d b = this;
        public i.a.a c;

        public static final class a<T> implements i.a.a<T> {
            public a(k kVar, d dVar, int i2) {
            }

            @Override // i.a.a
            public T get() {
                return (T) new c.d();
            }
        }

        public d(k kVar, b bVar) {
            this.a = kVar;
            i.a.a aVar = new a(kVar, this, 0);
            Object obj = g.c.b.c;
            this.c = !(aVar instanceof g.c.b) ? new g.c.b(aVar) : aVar;
        }

        @Override // g.b.a.c.c.a.AbstractC0138a
        public g.b.a.c.a.a a() {
            return new a(this.a, this.b, null);
        }

        @Override // g.b.a.c.c.c.AbstractC0139c
        public g.b.a.a b() {
            return (g.b.a.a) this.c.get();
        }
    }

    public static final class e implements g.b.a.c.a.c {
        public final k a;
        public final d b;
        public final b c;

        /* renamed from: d  reason: collision with root package name */
        public e.n.a.m f2265d;

        public e(k kVar, d dVar, b bVar, b bVar2) {
            this.a = kVar;
            this.b = dVar;
            this.c = bVar;
        }
    }

    public static final class f extends o {
        public final k a;
        public final b b;

        public f(k kVar, d dVar, b bVar, e.n.a.m mVar) {
            this.a = kVar;
            this.b = bVar;
        }

        @Override // f.b.a.a.a.d0.m6
        public void A(l6 l6Var) {
            l6Var.d0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.e0.j0
        public void B(i0 i0Var) {
        }

        @Override // g.b.a.c.b.b
        public g.b.a.c.b.c a() {
            return this.b.a();
        }

        @Override // f.b.a.a.a.j0.x0
        public void b(w0 w0Var) {
        }

        @Override // f.b.a.a.a.d0.t5
        public void c(s5 s5Var) {
            s5Var.d0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.u.k
        public void d(j jVar) {
        }

        @Override // f.b.a.a.a.d0.y5
        public void e(x5 x5Var) {
        }

        @Override // f.b.a.a.a.d0.b6
        public void f(a6 a6Var) {
            a6Var.d0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.d0.r5
        public void g(q5 q5Var) {
            q5Var.d0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.e0.n0
        public void h(m0 m0Var) {
        }

        @Override // f.b.a.a.a.u.q
        public void i(f.b.a.a.a.u.p pVar) {
        }

        @Override // f.b.a.a.a.d0.g6
        public void j(f6 f6Var) {
            f6Var.d0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.w.g1
        public void k(f1 f1Var) {
            f1Var.g0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.j0.l0
        public void l(k0 k0Var) {
        }

        @Override // f.b.a.a.a.e0.l0
        public void m(f.b.a.a.a.e0.k0 k0Var) {
        }

        @Override // f.b.a.a.a.j0.c1
        public void n(b1 b1Var) {
        }

        @Override // f.b.a.a.a.v.o
        public void o(n nVar) {
        }

        @Override // f.b.a.a.a.d0.d6
        public void p(c6 c6Var) {
            c6Var.d0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.v.k
        public void q(f.b.a.a.a.v.j jVar) {
            jVar.c0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.w.k1
        public void r(f.b.a.a.a.w.j1 j1Var) {
            j1Var.b0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.d0.p6
        public void s(o6 o6Var) {
        }

        @Override // f.b.a.a.a.d0.v5
        public void t(u5 u5Var) {
            u5Var.d0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.d0.p5
        public void u(o5 o5Var) {
            o5Var.d0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.u.s
        public void v(f.b.a.a.a.u.r rVar) {
        }

        @Override // f.b.a.a.a.j0.a1
        public void w(z0 z0Var) {
        }

        @Override // f.b.a.a.a.j0.p0
        public void x(o0 o0Var) {
        }

        @Override // f.b.a.a.a.d0.j6
        public void y(i6 i6Var) {
            i6Var.d0 = m.e.e1(this.a.f2257e);
        }

        @Override // f.b.a.a.a.j0.n0
        public void z(f.b.a.a.a.j0.m0 m0Var) {
        }
    }

    public static final class g<T> implements i.a.a<T> {
        public final k a;
        public final int b;

        public g(k kVar, int i2) {
            this.a = kVar;
            this.b = i2;
        }

        @Override // i.a.a
        public T get() {
            T t;
            f.b.c.k.f fVar = null;
            switch (this.b) {
                case 0:
                    k kVar = this.a;
                    Objects.requireNonNull(kVar);
                    return (T) new b(kVar);
                case 1:
                    k kVar2 = this.a;
                    f.b.a.a.a.s.r rVar = kVar2.a;
                    T t2 = (T) kVar2.t.get();
                    Objects.requireNonNull(rVar);
                    Objects.requireNonNull(t2, "Cannot return null from a non-@Nullable @Provides method");
                    return t2;
                case 2:
                    Objects.requireNonNull(this.a.a);
                    T t3 = (T) f.b.a.c.b.o.b.c1(Executors.newFixedThreadPool(4, f.b.a.a.a.s.r.a("Background", 10, f.b.a.a.a.s.r.b)));
                    Objects.requireNonNull(t3, "Cannot return null from a non-@Nullable @Provides method");
                    return t3;
                case 3:
                    k kVar3 = this.a;
                    v vVar = kVar3.f2256d;
                    Context t4 = g.b.a.c.c.d.t(kVar3.c);
                    Objects.requireNonNull(vVar);
                    g.a S = m.e.S(t4.getApplicationContext(), ExposureNotificationDatabase.class, "exposurenotification");
                    S.a(ExposureNotificationDatabase.t);
                    int[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
                    if (S.f1991l == null) {
                        S.f1991l = new HashSet(34);
                    }
                    for (int i2 = 0; i2 < 34; i2++) {
                        S.f1991l.add(Integer.valueOf(iArr[i2]));
                    }
                    return (T) ((ExposureNotificationDatabase) S.b());
                case 4:
                    k kVar4 = this.a;
                    j1 j1Var = kVar4.f2259g;
                    Context t5 = g.b.a.c.c.d.t(kVar4.c);
                    Objects.requireNonNull(j1Var);
                    m.e.r(t5, "Context must not be null");
                    return (T) new i1(new f.b.a.c.e.c.v(t5), kVar4.A.get());
                case 5:
                    k kVar5 = this.a;
                    u uVar = kVar5.f2260h;
                    new t(g.b.a.c.c.d.t(kVar5.c));
                    T t6 = (T) kVar5.l();
                    synchronized (uVar) {
                    }
                    return t6;
                case 6:
                    k kVar6 = this.a;
                    f.b.a.a.a.z.v vVar2 = kVar6.f2261i;
                    Context t7 = g.b.a.c.c.d.t(kVar6.c);
                    synchronized (vVar2) {
                        f.b.a.b.i.m.b(t7);
                        t = (T) ((f.b.a.b.i.j) f.b.a.b.i.m.a().c(f.b.a.b.h.a.f2524g)).a("1537", f.b.a.a.a.g0.c.class, new f.b.a.b.b("proto"), f.b.a.a.a.z.p.a);
                    }
                    return t;
                case 7:
                    k kVar7 = this.a;
                    f.b.a.a.a.s.r rVar2 = kVar7.a;
                    T t8 = (T) kVar7.y.get();
                    Objects.requireNonNull(rVar2);
                    Objects.requireNonNull(t8, "Cannot return null from a non-@Nullable @Provides method");
                    return t8;
                case 8:
                    Objects.requireNonNull(this.a.a);
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4, f.b.a.a.a.s.r.a("Scheduled", 10, f.b.a.a.a.s.r.b));
                    T t9 = newScheduledThreadPool instanceof x ? (T) ((x) newScheduledThreadPool) : (T) new a0(newScheduledThreadPool);
                    Objects.requireNonNull(t9, "Cannot return null from a non-@Nullable @Provides method");
                    return t9;
                case 9:
                    k kVar8 = this.a;
                    Objects.requireNonNull(kVar8);
                    return (T) new c(kVar8);
                case 10:
                    k kVar9 = this.a;
                    Objects.requireNonNull(kVar9);
                    return (T) new d(kVar9);
                case 11:
                    Objects.requireNonNull(this.a.f2263k);
                    o oVar = new o(new f.a.b.w.h(), new f.a.b.w.b(new f.a.b.w.e()));
                    oVar.b();
                    return (T) new f.b.a.a.a.c0.f(oVar);
                case 12:
                    k kVar10 = this.a;
                    f.b.a.a.a.s.r rVar3 = kVar10.a;
                    T t10 = (T) kVar10.E.get();
                    Objects.requireNonNull(rVar3);
                    Objects.requireNonNull(t10, "Cannot return null from a non-@Nullable @Provides method");
                    return t10;
                case 13:
                    Objects.requireNonNull(this.a.a);
                    T t11 = (T) f.b.a.c.b.o.b.c1(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors() - 2), f.b.a.a.a.s.r.a("Lightweight", 0, f.b.a.a.a.s.r.a)));
                    Objects.requireNonNull(t11, "Cannot return null from a non-@Nullable @Provides method");
                    return t11;
                case 14:
                    Objects.requireNonNull(this.a.b);
                    return (T) new SecureRandom();
                case 15:
                    k kVar11 = this.a;
                    Objects.requireNonNull(kVar11);
                    return (T) new e(kVar11);
                case 16:
                    k kVar12 = this.a;
                    Objects.requireNonNull(kVar12);
                    return (T) new f(kVar12);
                case 17:
                    k kVar13 = this.a;
                    Objects.requireNonNull(kVar13);
                    return (T) new g(kVar13);
                case 18:
                    k kVar14 = this.a;
                    Objects.requireNonNull(kVar14);
                    return (T) new h(kVar14);
                case 19:
                    k kVar15 = this.a;
                    Objects.requireNonNull(kVar15);
                    return (T) new i(kVar15);
                case 20:
                    k kVar16 = this.a;
                    f.b.a.a.a.f0.m mVar = kVar16.p;
                    f.b.c.a aVar = kVar16.M.get();
                    Objects.requireNonNull(mVar);
                    if (aVar != null) {
                        f.b.c.a b2 = f.b.c.a.b();
                        f.b.a.c.b.o.b.B(b2, "Provided FirebaseApp must not be null.");
                        b2.a();
                        f.b.c.k.i iVar = (f.b.c.k.i) b2.f3209d.a(f.b.c.k.i.class);
                        f.b.a.c.b.o.b.B(iVar, "Firestore component is not present.");
                        synchronized (iVar) {
                            fVar = iVar.a.get("(default)");
                            if (fVar == null) {
                                fVar = (T) f.b.c.k.f.a(iVar.c, iVar.b, iVar.f3258d, "(default)", iVar, iVar.f3259e);
                                iVar.a.put("(default)", fVar);
                            }
                        }
                    }
                    return fVar;
                case 21:
                    k kVar17 = this.a;
                    f.b.a.a.a.f0.m mVar2 = kVar17.p;
                    Context t12 = g.b.a.c.c.d.t(kVar17.c);
                    kVar17.n();
                    Objects.requireNonNull(mVar2);
                    if (!f.b.a.d.a.r.c()) {
                        return null;
                    }
                    return (T) f.b.c.a.d(t12);
                case 22:
                    k kVar18 = this.a;
                    Objects.requireNonNull(kVar18);
                    return (T) new j(kVar18);
                default:
                    throw new AssertionError(this.b);
            }
        }
    }

    public static final class h implements g.b.a.c.a.d {
        public final k a;
        public final d b;
        public y c;

        public h(k kVar, d dVar, b bVar) {
            this.a = kVar;
            this.b = dVar;
        }
    }

    public static final class i extends q {
        public final y a;
        public final k b;
        public final d c;

        /* renamed from: d  reason: collision with root package name */
        public final i f2266d = this;

        /* renamed from: e  reason: collision with root package name */
        public i.a.a<AppAnalyticsViewModel> f2267e;

        /* renamed from: f  reason: collision with root package name */
        public i.a.a<ExposureHomeViewModel> f2268f;

        /* renamed from: g  reason: collision with root package name */
        public i.a.a<ExposureNotificationViewModel> f2269g;

        /* renamed from: h  reason: collision with root package name */
        public i.a.a<NotifyHomeViewModel> f2270h;

        /* renamed from: i  reason: collision with root package name */
        public i.a.a<OnboardingViewModel> f2271i;

        /* renamed from: j  reason: collision with root package name */
        public i.a.a<PrivateAnalyticsViewModel> f2272j;

        /* renamed from: k  reason: collision with root package name */
        public i.a.a<ShareDiagnosisViewModel> f2273k;

        /* renamed from: l  reason: collision with root package name */
        public i.a.a<SplashViewModel> f2274l;

        public static final class a<T> implements i.a.a<T> {
            public final i a;
            public final int b;

            public a(k kVar, d dVar, i iVar, int i2) {
                this.a = iVar;
                this.b = i2;
            }

            @Override // i.a.a
            public T get() {
                switch (this.b) {
                    case 0:
                        return (T) new AppAnalyticsViewModel(this.a.b.b());
                    case 1:
                        i iVar = this.a;
                        return (T) new ExposureHomeViewModel(iVar.b.b(), iVar.b.k(), m.e.d1(iVar.b.b), m.e.e1(iVar.b.f2257e), iVar.b.s());
                    case 2:
                        i iVar2 = this.a;
                        Objects.requireNonNull(iVar2);
                        return (T) new ExposureNotificationViewModel(iVar2.b.b(), iVar2.b.w.get(), iVar2.b.j(), iVar2.b.A.get(), new m1(iVar2.b.b()), m.e.e1(iVar2.b.f2257e), iVar2.b.F.get());
                    case 3:
                        i iVar3 = this.a;
                        Objects.requireNonNull(iVar3);
                        return (T) new NotifyHomeViewModel(iVar3.b.j(), iVar3.b.F.get());
                    case 4:
                        i iVar4 = this.a;
                        return (T) new OnboardingViewModel(iVar4.b.w.get(), iVar4.b.b(), iVar4.b.n(), iVar4.b.s());
                    case 5:
                        i iVar5 = this.a;
                        return (T) new PrivateAnalyticsViewModel(iVar5.b.b(), iVar5.b.n());
                    case 6:
                        i iVar6 = this.a;
                        Objects.requireNonNull(iVar6);
                        Context t = g.b.a.c.c.d.t(iVar6.b.c);
                        y yVar = iVar6.a;
                        f0 r = iVar6.b.r();
                        f.b.a.a.a.l0.i0 j2 = iVar6.b.j();
                        f.b.a.a.a.l0.f1 f1Var = new f.b.a.a.a.l0.f1(iVar6.b.v.get());
                        i1 i1Var = iVar6.b.w.get();
                        v0 b2 = iVar6.b.b();
                        f.b.a.d.a.a0 n = iVar6.b.n();
                        f.b.a.a.a.s.e0.a e1 = m.e.e1(iVar6.b.f2257e);
                        k kVar = iVar6.b;
                        p pVar = kVar.b;
                        TelephonyManager q = kVar.q();
                        Context t2 = g.b.a.c.c.d.t(kVar.c);
                        Objects.requireNonNull(pVar);
                        return (T) new ShareDiagnosisViewModel(t, yVar, r, j2, f1Var, i1Var, b2, n, e1, new b0(q, t2.getResources()), iVar6.b.G.get(), new f.b.a.a.a.c0.b(g.b.a.c.c.d.t(iVar6.b.c)), iVar6.b.u.get(), iVar6.b.F.get(), iVar6.b.z.get());
                    case 7:
                        i iVar7 = this.a;
                        return (T) new SplashViewModel(iVar7.b.b(), iVar7.b.n());
                    default:
                        throw new AssertionError(this.b);
                }
            }
        }

        public i(k kVar, d dVar, y yVar, b bVar) {
            this.b = kVar;
            this.c = dVar;
            this.a = yVar;
            this.f2267e = new a(kVar, dVar, this, 0);
            this.f2268f = new a(kVar, dVar, this, 1);
            this.f2269g = new a(kVar, dVar, this, 2);
            this.f2270h = new a(kVar, dVar, this, 3);
            this.f2271i = new a(kVar, dVar, this, 4);
            this.f2272j = new a(kVar, dVar, this, 5);
            this.f2273k = new a(kVar, dVar, this, 6);
            this.f2274l = new a(kVar, dVar, this, 7);
        }

        @Override // g.b.a.c.b.d.b
        public Map<String, i.a.a<e0>> a() {
            f.b.a.c.b.o.b.y(8, "expectedSize");
            d.a aVar = new d.a(8);
            aVar.b("com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel", this.f2267e);
            aVar.b("com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel", this.f2268f);
            aVar.b("com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel", this.f2269g);
            aVar.b("com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel", this.f2270h);
            aVar.b("com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel", this.f2271i);
            aVar.b("com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel", this.f2272j);
            aVar.b("com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel", this.f2273k);
            aVar.b("com.google.android.apps.exposurenotification.home.SplashViewModel", this.f2274l);
            return aVar.a();
        }
    }

    public k(g.b.a.c.d.a aVar, p pVar, v vVar, f.b.a.a.a.x.p pVar2, f.b.a.a.a.s.r rVar, j1 j1Var, f.b.a.a.a.i0.d dVar, u uVar, f.b.a.a.a.f0.s.m mVar, f.b.a.a.a.f0.m mVar2, f.b.a.a.a.f0.r rVar2, f.b.a.a.a.c0.e eVar, f.b.a.a.a.s.e0.b bVar, f.b.a.a.a.h0.f fVar, y0 y0Var, f.b.a.a.a.z.v vVar2, h0 h0Var, f.b.a.a.a.n0.f fVar2, b bVar2) {
        this.a = rVar;
        this.b = pVar;
        this.c = aVar;
        this.f2256d = vVar;
        this.f2257e = bVar;
        this.f2258f = dVar;
        this.f2259g = j1Var;
        this.f2260h = uVar;
        this.f2261i = vVar2;
        this.f2262j = h0Var;
        this.f2263k = eVar;
        this.f2264l = pVar2;
        this.m = fVar;
        this.n = mVar;
        this.o = rVar2;
        this.p = mVar2;
        this.q = fVar2;
        this.r = y0Var;
        i.a.a gVar = new g(this, 2);
        Object obj = g.c.b.c;
        this.t = !(gVar instanceof g.c.b) ? new g.c.b(gVar) : gVar;
        i.a.a gVar2 = new g(this, 1);
        this.u = !(gVar2 instanceof g.c.b) ? new g.c.b(gVar2) : gVar2;
        i.a.a gVar3 = new g(this, 3);
        this.v = !(gVar3 instanceof g.c.b) ? new g.c.b(gVar3) : gVar3;
        this.w = new g.c.a();
        i.a.a gVar4 = new g(this, 6);
        this.x = !(gVar4 instanceof g.c.b) ? new g.c.b(gVar4) : gVar4;
        i.a.a gVar5 = new g(this, 8);
        this.y = !(gVar5 instanceof g.c.b) ? new g.c.b(gVar5) : gVar5;
        i.a.a gVar6 = new g(this, 7);
        this.z = !(gVar6 instanceof g.c.b) ? new g.c.b(gVar6) : gVar6;
        i.a.a gVar7 = new g(this, 5);
        this.A = !(gVar7 instanceof g.c.b) ? new g.c.b(gVar7) : gVar7;
        i.a.a<i1> aVar2 = this.w;
        i.a.a gVar8 = new g(this, 4);
        gVar8 = !(gVar8 instanceof g.c.b) ? new g.c.b(gVar8) : gVar8;
        g.c.a aVar3 = (g.c.a) aVar2;
        if (aVar3.a == null) {
            aVar3.a = gVar8;
            this.B = new g(this, 0);
            this.C = new g(this, 9);
            i.a.a gVar9 = new g(this, 11);
            this.D = !(gVar9 instanceof g.c.b) ? new g.c.b(gVar9) : gVar9;
            i.a.a gVar10 = new g(this, 13);
            this.E = !(gVar10 instanceof g.c.b) ? new g.c.b(gVar10) : gVar10;
            i.a.a gVar11 = new g(this, 12);
            this.F = !(gVar11 instanceof g.c.b) ? new g.c.b(gVar11) : gVar11;
            i.a.a gVar12 = new g(this, 14);
            this.G = !(gVar12 instanceof g.c.b) ? new g.c.b(gVar12) : gVar12;
            this.H = new g(this, 10);
            this.I = new g(this, 15);
            this.J = new g(this, 16);
            this.K = new g(this, 17);
            this.L = new g(this, 18);
            i.a.a gVar13 = new g(this, 21);
            this.M = !(gVar13 instanceof g.c.b) ? new g.c.b(gVar13) : gVar13;
            i.a.a gVar14 = new g(this, 20);
            this.N = !(gVar14 instanceof g.c.b) ? new g.c.b(gVar14) : gVar14;
            this.O = new g(this, 19);
            this.P = new g(this, 22);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // f.b.a.a.a.s.s
    public void a(ExposureNotificationDismissedReceiver exposureNotificationDismissedReceiver) {
        exposureNotificationDismissedReceiver.c = b();
        exposureNotificationDismissedReceiver.f334d = m.e.e1(this.f2257e);
    }

    @Override // com.google.android.apps.exposurenotification.restore.ExposureNotificationBackupAgent.a
    public v0 b() {
        Objects.requireNonNull(this.r);
        return new v0(g.b.a.c.c.d.t(this.c), m.e.e1(this.f2257e), this.G.get());
    }

    @Override // f.b.a.a.a.b0.n1
    public void c(SmsVerificationBroadcastReceiver smsVerificationBroadcastReceiver) {
        smsVerificationBroadcastReceiver.c = s();
    }

    @Override // f.b.a.a.a.b0.h1
    public void d(ExposureNotificationBroadcastReceiver exposureNotificationBroadcastReceiver) {
        exposureNotificationBroadcastReceiver.c = s();
        exposureNotificationBroadcastReceiver.f368d = m.e.d1(this.b);
        exposureNotificationBroadcastReceiver.f369e = b();
    }

    @Override // f.b.a.a.a.l
    public void e(ExposureNotificationApplication exposureNotificationApplication) {
        f.b.a.c.b.o.b.y(9, "expectedSize");
        d.a aVar = new d.a(9);
        aVar.b("com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker", this.B);
        aVar.b("com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker", this.C);
        aVar.b("com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker", this.H);
        aVar.b("com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker", this.I);
        aVar.b("com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker", this.J);
        aVar.b("com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker", this.K);
        aVar.b("com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker", this.L);
        aVar.b("com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker", this.O);
        aVar.b("com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker", this.P);
        exposureNotificationApplication.c = new e.o.a.a(aVar.a());
        exposureNotificationApplication.workManager = s();
        f.b.a.a.a.n0.f fVar = this.q;
        Context t2 = g.b.a.c.c.d.t(this.c);
        f.b.a.d.a.a0 n2 = n();
        f.b.a.d.a.f0 o2 = o();
        Objects.requireNonNull(fVar);
        exposureNotificationApplication.f329d = new l(s(), this.E.get(), l.b.a.d.h((long) t2.getResources().getInteger(R.integer.enx_tekPublishInterval)), n2, o2);
        Objects.requireNonNull(this.f2260h);
        exposureNotificationApplication.f330e = new ApplicationObserver(this.A.get());
        exposureNotificationApplication.f331f = f.b.b.a.a.b;
        exposureNotificationApplication.f332g = this.u.get();
        exposureNotificationApplication.firebaseApp = this.M.get();
        exposureNotificationApplication.f333h = new f.b.a.a.a.a0.f(new f.b.a.a.a.a0.e(this.t.get(), b(), s()), this.u.get());
    }

    @Override // g.b.a.c.c.c.a
    public g.b.a.c.a.b f() {
        return new c(this.s, null);
    }

    public final int g() {
        f.b.a.a.a.f0.s.m mVar = this.n;
        v0 b2 = b();
        Objects.requireNonNull(mVar);
        if (!b2.a.contains("ExposureNotificationSharedPreferences.BIWEEKLY_METRICS_UPLOAD_DAY")) {
            b2.a.edit().putInt("ExposureNotificationSharedPreferences.BIWEEKLY_METRICS_UPLOAD_DAY", b2.c.nextInt(14)).commit();
        }
        return b2.a.getInt("ExposureNotificationSharedPreferences.BIWEEKLY_METRICS_UPLOAD_DAY", 0);
    }

    public final f.b.a.a.a.i0.c h() {
        f.b.a.a.a.i0.e eVar = new f.b.a.a.a.i0.e(q());
        f.b.a.a.a.l0.u uVar = new f.b.a.a.a.l0.u(this.v.get(), m.e.e1(this.f2257e));
        f.b.a.a.a.s.e0.a e1 = m.e.e1(this.f2257e);
        f.b.a.a.a.i0.d dVar = this.f2258f;
        Context t2 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(dVar);
        if (t2.getString(R.string.enx_regionIdentifier).length() >= 2) {
            String substring = t2.getString(R.string.enx_regionIdentifier).substring(0, 2);
            Objects.requireNonNull(substring, "Cannot return null from a non-@Nullable @Provides method");
            return new f.b.a.a.a.i0.c(eVar, uVar, e1, substring);
        }
        throw new RuntimeException("Failed to determine user's home region from configuration.");
    }

    public final DailySummariesConfig i() {
        f.b.a.a.a.h0.f fVar = this.m;
        Context t2 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(fVar);
        Resources resources = t2.getResources();
        DailySummariesConfig.a aVar = new DailySummariesConfig.a();
        boolean z2 = false;
        List asList = Arrays.asList(Integer.valueOf(resources.getInteger(R.integer.enx_attenuationImmediateNearThreshold)), Integer.valueOf(resources.getInteger(R.integer.enx_attenuationNearMedThreshold)), Integer.valueOf(resources.getInteger(R.integer.enx_attenuationMedFarThreshold)));
        List<Double> asList2 = Arrays.asList(Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationImmediateWeight)) * 0.01d), Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationNearWeight)) * 0.01d), Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationMedWeight)) * 0.01d), Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationOtherWeight)) * 0.01d));
        DailySummariesConfig.a.c(asList, 3, "attenuationBucketThresholdDb");
        for (int i2 = 0; i2 < asList.size(); i2++) {
            m.e.k(((Integer) asList.get(i2)).intValue() >= 0 && ((Integer) asList.get(i2)).intValue() <= 255, "Element of attenuationBucketThreshold must between 0 ~ 255");
            if (i2 != 0) {
                int i3 = i2 - 1;
                m.e.k(((Integer) asList.get(i3)).intValue() < ((Integer) asList.get(i2)).intValue(), String.format(Locale.ENGLISH, "attenuationBucketThresholdDb of index %d must be larger than index %d", Integer.valueOf(i2), Integer.valueOf(i3)));
            }
        }
        aVar.c = new ArrayList(asList);
        DailySummariesConfig.a.c(asList2, 4, "attenuationBucketWeights");
        for (Double d2 : asList2) {
            DailySummariesConfig.a.d(d2.doubleValue(), "attenuationBucketWeights");
        }
        aVar.f470d = new ArrayList(asList2);
        aVar.a(1, ((double) resources.getInteger(R.integer.enx_infectiousnessStandardWeight)) * 0.01d);
        aVar.a(2, ((double) resources.getInteger(R.integer.enx_infectiousnessHighWeight)) * 0.01d);
        aVar.b(1, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedTestWeight)) * 0.01d);
        aVar.b(2, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedClinicalDiagnosisWeight)) * 0.01d);
        aVar.b(3, ((double) resources.getInteger(R.integer.enx_reportTypeSelfReportWeight)) * 0.01d);
        int integer = resources.getInteger(R.integer.enx_daysSinceExposureThreshold);
        m.e.k(integer >= 0, "daysSinceExposureThreshold must not be negative");
        aVar.f471e = integer;
        m.e.k(aVar.c != null, "Must set attenuationBucketThresholdDb");
        if (aVar.f470d != null) {
            z2 = true;
        }
        m.e.k(z2, "Must set attenuationBucketWeights");
        DailySummariesConfig dailySummariesConfig = new DailySummariesConfig(Arrays.asList(aVar.a), Arrays.asList(aVar.b), aVar.c, aVar.f470d, aVar.f471e, 0.0d);
        f.b.a.a.a.h0.f.a.a("Created dailySummaryConfig: " + dailySummariesConfig);
        return dailySummariesConfig;
    }

    public final f.b.a.a.a.l0.i0 j() {
        return new f.b.a.a.a.l0.i0(this.v.get(), this.u.get(), m.e.e1(this.f2257e));
    }

    public final r0 k() {
        return new r0(this.v.get());
    }

    public final s l() {
        g.a aVar;
        Context t2 = g.b.a.c.c.d.t(this.c);
        v0 b2 = b();
        i.a.a<i1> aVar2 = this.w;
        Object obj = g.c.b.c;
        if (aVar2 instanceof g.a) {
            aVar = (g.a) aVar2;
        } else {
            Objects.requireNonNull(aVar2);
            aVar = new g.c.b(aVar2);
        }
        return new s(t2, b2, aVar, this.x.get(), new f.b.a.a.a.l0.h(this.v.get()), m.e.e1(this.f2257e), new f.b.a.a.a.l0.j1(this.v.get()), this.t.get(), this.z.get());
    }

    public final f.b.b.a.l<f.b.a.d.a.b0> m() {
        f.b.a.a.a.f0.r rVar = this.o;
        new t(g.b.a.c.c.d.t(this.c));
        s l2 = l();
        Objects.requireNonNull(rVar);
        return new f.b.b.a.o(new f.b.a.a.a.f0.p(rVar, l2));
    }

    public final f.b.a.d.a.a0 n() {
        f.b.a.a.a.f0.r rVar = this.o;
        v0 b2 = b();
        Objects.requireNonNull(rVar);
        return new f.b.a.a.a.f0.o(rVar, b2);
    }

    public final f.b.a.d.a.f0 o() {
        f.b.a.a.a.f0.r rVar = this.o;
        Uri p2 = p();
        f.b.b.a.l<f.b.a.d.a.b0> m2 = m();
        d0.a f1 = m.e.f1(this.o);
        Objects.requireNonNull(rVar);
        return new f.b.a.d.a.s(p2, m2, f1);
    }

    public final Uri p() {
        f.b.a.a.a.f0.r rVar = this.o;
        Context t2 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(rVar);
        Uri parse = Uri.parse(t2.getString(R.string.enx_enpaRemoteConfigURL));
        Objects.requireNonNull(parse, "Cannot return null from a non-@Nullable @Provides method");
        return parse;
    }

    public final TelephonyManager q() {
        p pVar = this.b;
        Context t2 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(pVar);
        TelephonyManager telephonyManager = (TelephonyManager) t2.getSystemService("phone");
        Objects.requireNonNull(telephonyManager, "Cannot return null from a non-@Nullable @Provides method");
        return telephonyManager;
    }

    public final f0 r() {
        Context t2 = g.b.a.c.c.d.t(this.c);
        h0 h0Var = this.f2262j;
        Context t3 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(h0Var);
        Uri parse = Uri.parse(t3.getString(R.string.enx_testVerificationURL));
        Objects.requireNonNull(parse, "Cannot return null from a non-@Nullable @Provides method");
        h0 h0Var2 = this.f2262j;
        Context t4 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(h0Var2);
        Uri parse2 = Uri.parse(t4.getString(R.string.enx_testVerificationCertificateURL));
        Objects.requireNonNull(parse2, "Cannot return null from a non-@Nullable @Provides method");
        h0 h0Var3 = this.f2262j;
        Context t5 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(h0Var3);
        Uri parse3 = Uri.parse(t5.getString(R.string.enx_testVerificationUserReportURL));
        Objects.requireNonNull(parse3, "Cannot return null from a non-@Nullable @Provides method");
        c0 c0Var = new c0(t2, parse, parse2, parse3, this.D.get(), m.e.e1(this.f2257e), this.A.get());
        Context t6 = g.b.a.c.c.d.t(this.c);
        h0 h0Var4 = this.f2262j;
        Context t7 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(h0Var4);
        Uri parse4 = Uri.parse(t7.getString(R.string.enx_tekUploadURL));
        Objects.requireNonNull(parse4, "Cannot return null from a non-@Nullable @Provides method");
        return new f0(c0Var, new f.b.a.a.a.y.d0(t6, parse4, this.D.get(), this.u.get(), this.F.get(), m.e.e1(this.f2257e), this.A.get()), new f.b.a.a.a.c0.b(g.b.a.c.c.d.t(this.c)));
    }

    public final e.b0.w s() {
        f.b.a.a.a.n0.f fVar = this.q;
        Context t2 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(fVar);
        e.b0.a0.l g2 = e.b0.a0.l.g(t2);
        Objects.requireNonNull(g2, "Cannot return null from a non-@Nullable @Provides method");
        return g2;
    }

    public final f.b.a.a.a.n0.m t() {
        return new f.b.a.a.a.n0.m(this.w.get(), this.u.get(), this.z.get(), new m1(b()), k(), new f.b.a.a.a.l0.f1(this.v.get()), m.e.e1(this.f2257e));
    }
}
