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
import e.r.e0;
import e.r.y;
import e.v.g;
import f.b.a.a.a.a0.r;
import f.b.a.a.a.a0.s;
import f.b.a.a.a.a0.t;
import f.b.a.a.a.a0.u;
import f.b.a.a.a.a0.v;
import f.b.a.a.a.c0.o1;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.c0.r1;
import f.b.a.a.a.c0.u1;
import f.b.a.a.a.e0.c6;
import f.b.a.a.a.e0.c7;
import f.b.a.a.a.e0.e6;
import f.b.a.a.a.e0.g6;
import f.b.a.a.a.e0.i6;
import f.b.a.a.a.e0.l6;
import f.b.a.a.a.e0.o6;
import f.b.a.a.a.e0.q6;
import f.b.a.a.a.e0.t6;
import f.b.a.a.a.e0.w6;
import f.b.a.a.a.e0.z6;
import f.b.a.a.a.f0.o0;
import f.b.a.a.a.f0.q0;
import f.b.a.a.a.f0.s0;
import f.b.a.a.a.f0.u0;
import f.b.a.a.a.g0.m;
import f.b.a.a.a.g0.s.o;
import f.b.a.a.a.l0.b1;
import f.b.a.a.a.l0.k0;
import f.b.a.a.a.l0.m0;
import f.b.a.a.a.l0.w0;
import f.b.a.a.a.l0.z0;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.d1;
import f.b.a.a.a.n0.l1;
import f.b.a.a.a.n0.p0;
import f.b.a.a.a.n0.v0;
import f.b.a.a.a.p0.q;
import f.b.a.a.a.t.b0;
import f.b.a.a.a.t.d0;
import f.b.a.a.a.t.n0;
import f.b.a.a.a.v.j;
import f.b.a.a.a.x.g1;
import f.b.a.a.a.x.k1;
import f.b.a.a.a.y.p;
import f.b.a.a.a.z.c0;
import f.b.a.a.a.z.h0;
import f.b.a.d.a.d0;
import f.b.a.d.a.f0;
import f.b.b.a.l;
import f.b.b.b.d;
import f.b.b.f.a.a0;
import f.b.b.f.a.w;
import f.b.b.f.a.x;
import g.b.a.c.c.c;
import gov.nm.covid19.exposurenotifications.R;
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
/* loaded from: classes.dex */
public final class k extends p {
    public i.a.a<ScheduledExecutorService> A;
    public i.a.a<r> B;
    public i.a.a<Object> C;
    public i.a.a<Object> D;
    public i.a.a<f.b.a.a.a.d0.g> E;
    public i.a.a<w> F;
    public i.a.a<ExecutorService> G;
    public i.a.a<SecureRandom> H;
    public i.a.a<Object> I;
    public i.a.a<Object> J;
    public i.a.a<Object> K;
    public i.a.a<Object> L;
    public i.a.a<Object> M;
    public i.a.a<f.b.c.a> N;
    public i.a.a<f.b.c.k.f> O;
    public i.a.a<Object> P;
    public i.a.a<Object> Q;
    public i.a.a<f.b.a.f.a.a.b> R;
    public final d0 a;
    public final b0 b;
    public final g.b.a.c.d.a c;

    /* renamed from: d */
    public final f.b.a.a.a.n0.w f2292d;

    /* renamed from: e */
    public final f.b.a.a.a.t.q0.b f2293e;

    /* renamed from: f */
    public final f.b.a.a.a.k0.d f2294f;

    /* renamed from: g */
    public final r1 f2295g;

    /* renamed from: h */
    public final u f2296h;

    /* renamed from: i */
    public final v f2297i;

    /* renamed from: j */
    public final f.b.a.a.a.j0.f f2298j;

    /* renamed from: k */
    public final f.b.a.a.a.p0.k f2299k;

    /* renamed from: l */
    public final h0 f2300l;
    public final f.b.a.a.a.d0.e m;
    public final p n;
    public final o o;
    public final f.b.a.a.a.g0.r p;
    public final m q;
    public final d1 r;
    public final f.b.a.a.a.s.f s;
    public final k t = this;
    public i.a.a<w> u;
    public i.a.a<ExecutorService> v;
    public i.a.a<ExposureNotificationDatabase> w;
    public i.a.a<q1> x;
    public i.a.a<f.b.a.b.f<f.b.a.a.a.h0.c>> y;
    public i.a.a<x> z;

    /* loaded from: classes.dex */
    public static final class a implements g.b.a.c.a.a {
        public final k a;
        public final d b;
        public Activity c;

        public a(k kVar, d dVar, b bVar) {
            this.a = kVar;
            this.b = dVar;
        }
    }

    /* loaded from: classes.dex */
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
            Application v0 = f.b.a.c.b.o.b.v0(this.a.c.a);
            Objects.requireNonNull(v0, "Cannot return null from a non-@Nullable @Provides method");
            return new g.b.a.c.b.c(v0, f.b.b.b.e.t("com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel", "com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel", "com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel", "com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel", "com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel", "com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel", "com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel", "com.google.android.apps.exposurenotification.home.SplashViewModel"), new h(this.a, this.b, null));
        }

        @Override // g.b.a.c.c.g.a
        public g.b.a.c.a.c b() {
            return new e(this.a, this.b, this.c, null);
        }

        @Override // f.b.a.a.a.x.b1
        public void c(ExposureNotificationActivity exposureNotificationActivity) {
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements g.b.a.c.a.b {
        public final k a;

        public c(k kVar, b bVar) {
            this.a = kVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends n {
        public final k a;
        public final d b = this;
        public i.a.a c;

        /* loaded from: classes.dex */
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

        @Override // g.b.a.c.c.a.AbstractC0140a
        public g.b.a.c.a.a a() {
            return new a(this.a, this.b, null);
        }

        @Override // g.b.a.c.c.c.AbstractC0141c
        public g.b.a.a b() {
            return (g.b.a.a) this.c.get();
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements g.b.a.c.a.c {
        public final k a;
        public final d b;
        public final b c;

        /* renamed from: d */
        public e.o.a.m f2301d;

        public e(k kVar, d dVar, b bVar, b bVar2) {
            this.a = kVar;
            this.b = dVar;
            this.c = bVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends o {
        public final k a;
        public final b b;

        public f(k kVar, d dVar, b bVar, e.o.a.m mVar) {
            this.a = kVar;
            this.b = bVar;
        }

        @Override // f.b.a.a.a.e0.x6
        public void A(w6 w6Var) {
            w6Var.f0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.l0.n0
        public void B(m0 m0Var) {
        }

        @Override // f.b.a.a.a.e0.a7
        public void C(z6 z6Var) {
            z6Var.f0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.f0.r0
        public void D(q0 q0Var) {
        }

        @Override // g.b.a.c.b.b
        public g.b.a.c.b.c a() {
            return this.b.a();
        }

        @Override // f.b.a.a.a.l0.x0
        public void b(w0 w0Var) {
        }

        @Override // f.b.a.a.a.e0.h6
        public void c(g6 g6Var) {
            g6Var.f0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.f0.n0
        public void d(f.b.a.a.a.f0.m0 m0Var) {
        }

        @Override // f.b.a.a.a.v.k
        public void e(j jVar) {
        }

        @Override // f.b.a.a.a.e0.m6
        public void f(l6 l6Var) {
        }

        @Override // f.b.a.a.a.e0.p6
        public void g(o6 o6Var) {
            o6Var.f0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.e0.f6
        public void h(e6 e6Var) {
            e6Var.f0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.f0.v0
        public void i(u0 u0Var) {
        }

        @Override // f.b.a.a.a.v.q
        public void j(f.b.a.a.a.v.p pVar) {
        }

        @Override // f.b.a.a.a.e0.u6
        public void k(t6 t6Var) {
            t6Var.f0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.x.h1
        public void l(g1 g1Var) {
            g1Var.h0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.l0.l0
        public void m(k0 k0Var) {
        }

        @Override // f.b.a.a.a.f0.t0
        public void n(s0 s0Var) {
        }

        @Override // f.b.a.a.a.l0.c1
        public void o(b1 b1Var) {
        }

        @Override // f.b.a.a.a.w.p
        public void p(f.b.a.a.a.w.o oVar) {
        }

        @Override // f.b.a.a.a.e0.r6
        public void q(q6 q6Var) {
            q6Var.f0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.w.l
        public void r(f.b.a.a.a.w.k kVar) {
            kVar.c0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.x.l1
        public void s(k1 k1Var) {
            k1Var.b0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.f0.p0
        public void t(o0 o0Var) {
        }

        @Override // f.b.a.a.a.e0.d7
        public void u(c7 c7Var) {
        }

        @Override // f.b.a.a.a.e0.j6
        public void v(i6 i6Var) {
            i6Var.f0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.e0.d6
        public void w(c6 c6Var) {
            c6Var.f0 = m.e.k1(this.a.f2293e);
        }

        @Override // f.b.a.a.a.v.s
        public void x(f.b.a.a.a.v.r rVar) {
        }

        @Override // f.b.a.a.a.l0.a1
        public void y(z0 z0Var) {
        }

        @Override // f.b.a.a.a.l0.p0
        public void z(f.b.a.a.a.l0.o0 o0Var) {
        }
    }

    /* loaded from: classes.dex */
    public static final class g<T> implements i.a.a<T> {
        public final k a;
        public final int b;

        public g(k kVar, int i2) {
            this.a = kVar;
            this.b = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.a.a
        public T get() {
            T t;
            f.b.a.f.a.a.d dVar;
            Object obj = (T) null;
            switch (this.b) {
                case 0:
                    k kVar = this.a;
                    Objects.requireNonNull(kVar);
                    return (T) new b(kVar);
                case 1:
                    k kVar2 = this.a;
                    d0 d0Var = kVar2.a;
                    T t2 = (T) kVar2.u.get();
                    Objects.requireNonNull(d0Var);
                    Objects.requireNonNull(t2, "Cannot return null from a non-@Nullable @Provides method");
                    return t2;
                case 2:
                    Objects.requireNonNull(this.a.a);
                    T t3 = (T) f.b.a.c.b.o.b.d1(Executors.newFixedThreadPool(4, d0.a("Background", 10, d0.b)));
                    Objects.requireNonNull(t3, "Cannot return null from a non-@Nullable @Provides method");
                    return t3;
                case 3:
                    k kVar3 = this.a;
                    f.b.a.a.a.n0.w wVar = kVar3.f2292d;
                    Context t4 = g.b.a.c.c.d.t(kVar3.c);
                    Objects.requireNonNull(wVar);
                    g.a T = m.e.T(t4.getApplicationContext(), ExposureNotificationDatabase.class, "exposurenotification");
                    T.a(ExposureNotificationDatabase.t);
                    int[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
                    if (T.f2076l == null) {
                        T.f2076l = new HashSet(34);
                    }
                    for (int i2 = 0; i2 < 34; i2++) {
                        T.f2076l.add(Integer.valueOf(iArr[i2]));
                    }
                    return (T) ((ExposureNotificationDatabase) T.b());
                case 4:
                    k kVar4 = this.a;
                    r1 r1Var = kVar4.f2295g;
                    Context t5 = g.b.a.c.c.d.t(kVar4.c);
                    Objects.requireNonNull(r1Var);
                    m.e.r(t5, "Context must not be null");
                    return (T) new q1(new f.b.a.c.e.c.v(t5), kVar4.B.get());
                case 5:
                    k kVar5 = this.a;
                    u uVar = kVar5.f2296h;
                    new t(g.b.a.c.c.d.t(kVar5.c));
                    T t6 = (T) kVar5.m();
                    synchronized (uVar) {
                    }
                    return t6;
                case 6:
                    k kVar6 = this.a;
                    v vVar = kVar6.f2297i;
                    Context t7 = g.b.a.c.c.d.t(kVar6.c);
                    synchronized (vVar) {
                        f.b.a.b.i.m.b(t7);
                        t = (T) ((f.b.a.b.i.j) f.b.a.b.i.m.a().c(f.b.a.b.h.a.f2565g)).a("1537", f.b.a.a.a.h0.c.class, new f.b.a.b.b("proto"), f.b.a.a.a.a0.p.a);
                    }
                    return t;
                case 7:
                    k kVar7 = this.a;
                    d0 d0Var2 = kVar7.a;
                    T t8 = (T) kVar7.z.get();
                    Objects.requireNonNull(d0Var2);
                    Objects.requireNonNull(t8, "Cannot return null from a non-@Nullable @Provides method");
                    return t8;
                case 8:
                    Objects.requireNonNull(this.a.a);
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4, d0.a("Scheduled", 10, d0.b));
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
                    Objects.requireNonNull(this.a.m);
                    f.a.b.o oVar = new f.a.b.o(new f.a.b.w.h(), new f.a.b.w.b(new f.a.b.w.e()));
                    oVar.b();
                    return (T) new f.b.a.a.a.d0.f(oVar);
                case 12:
                    k kVar10 = this.a;
                    d0 d0Var3 = kVar10.a;
                    T t10 = (T) kVar10.F.get();
                    Objects.requireNonNull(d0Var3);
                    Objects.requireNonNull(t10, "Cannot return null from a non-@Nullable @Provides method");
                    return t10;
                case 13:
                    Objects.requireNonNull(this.a.a);
                    T t11 = (T) f.b.a.c.b.o.b.d1(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors() - 2), d0.a("Lightweight", 0, d0.a)));
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
                    f.b.a.a.a.g0.m mVar = kVar16.q;
                    f.b.c.a aVar = kVar16.N.get();
                    Objects.requireNonNull(mVar);
                    if (aVar != null) {
                        f.b.c.a b = f.b.c.a.b();
                        f.b.a.c.b.o.b.C(b, "Provided FirebaseApp must not be null.");
                        b.a();
                        f.b.c.k.i iVar = (f.b.c.k.i) b.f3464d.a(f.b.c.k.i.class);
                        f.b.a.c.b.o.b.C(iVar, "Firestore component is not present.");
                        synchronized (iVar) {
                            obj = (f.b.c.k.f) iVar.a.get("(default)");
                            if (obj == null) {
                                obj = (T) f.b.c.k.f.a(iVar.c, iVar.b, iVar.f3513d, "(default)", iVar, iVar.f3514e);
                                iVar.a.put("(default)", obj);
                            }
                        }
                    }
                    return (T) obj;
                case 21:
                    k kVar17 = this.a;
                    f.b.a.a.a.g0.m mVar2 = kVar17.q;
                    Context t12 = g.b.a.c.c.d.t(kVar17.c);
                    kVar17.p();
                    Objects.requireNonNull(mVar2);
                    if (!f.b.a.d.a.r.c()) {
                        return null;
                    }
                    return (T) f.b.c.a.d(t12);
                case 22:
                    k kVar18 = this.a;
                    Objects.requireNonNull(kVar18);
                    return (T) new j(kVar18);
                case 23:
                    k kVar19 = this.a;
                    f.b.a.a.a.s.f fVar = kVar19.s;
                    Context t13 = g.b.a.c.c.d.t(kVar19.c);
                    Objects.requireNonNull(fVar);
                    synchronized (f.b.a.c.b.o.b.class) {
                        if (f.b.a.c.b.o.b.f2761f == null) {
                            Context applicationContext = t13.getApplicationContext();
                            if (applicationContext != null) {
                                t13 = applicationContext;
                            }
                            f.b.a.f.a.a.i iVar2 = new f.b.a.f.a.a.i(t13);
                            f.b.a.c.b.o.b.M1(iVar2, f.b.a.f.a.a.i.class);
                            f.b.a.c.b.o.b.f2761f = new f.b.a.f.a.a.d(iVar2);
                        }
                        dVar = f.b.a.c.b.o.b.f2761f;
                    }
                    T t14 = (T) dVar.f3167f.a();
                    Objects.requireNonNull(t14, "Cannot return null from a non-@Nullable @Provides method");
                    return t14;
                default:
                    throw new AssertionError(this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class h implements g.b.a.c.a.d {
        public final k a;
        public final d b;
        public y c;

        public h(k kVar, d dVar, b bVar) {
            this.a = kVar;
            this.b = dVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends q {
        public final y a;
        public final k b;
        public final d c;

        /* renamed from: d */
        public final i f2302d = this;

        /* renamed from: e */
        public i.a.a<AppAnalyticsViewModel> f2303e;

        /* renamed from: f */
        public i.a.a<ExposureHomeViewModel> f2304f;

        /* renamed from: g */
        public i.a.a<ExposureNotificationViewModel> f2305g;

        /* renamed from: h */
        public i.a.a<NotifyHomeViewModel> f2306h;

        /* renamed from: i */
        public i.a.a<OnboardingViewModel> f2307i;

        /* renamed from: j */
        public i.a.a<PrivateAnalyticsViewModel> f2308j;

        /* renamed from: k */
        public i.a.a<ShareDiagnosisViewModel> f2309k;

        /* renamed from: l */
        public i.a.a<SplashViewModel> f2310l;

        /* loaded from: classes.dex */
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
                        a1 b = iVar.b.b();
                        k kVar = iVar.b;
                        Objects.requireNonNull(kVar);
                        return (T) new ExposureHomeViewModel(b, new o1(kVar.b(), kVar.i(), m.e.k1(kVar.f2293e)), iVar.b.l(), m.e.j1(iVar.b.b), m.e.k1(iVar.b.f2293e), iVar.b.u(), iVar.b.v.get());
                    case 2:
                        i iVar2 = this.a;
                        Objects.requireNonNull(iVar2);
                        return (T) new ExposureNotificationViewModel(iVar2.b.b(), iVar2.b.x.get(), iVar2.b.j(), iVar2.b.B.get(), new u1(iVar2.b.b()), m.e.k1(iVar2.b.f2293e), iVar2.b.G.get());
                    case 3:
                        i iVar3 = this.a;
                        Objects.requireNonNull(iVar3);
                        return (T) new NotifyHomeViewModel(iVar3.b.j(), iVar3.b.G.get());
                    case 4:
                        i iVar4 = this.a;
                        return (T) new OnboardingViewModel(iVar4.b.x.get(), iVar4.b.b(), iVar4.b.p(), iVar4.b.u(), iVar4.b.n());
                    case 5:
                        i iVar5 = this.a;
                        return (T) new PrivateAnalyticsViewModel(iVar5.b.b(), iVar5.b.p());
                    case 6:
                        i iVar6 = this.a;
                        Objects.requireNonNull(iVar6);
                        a1 b2 = iVar6.b.b();
                        f.b.a.d.a.a0 p = iVar6.b.p();
                        f.b.a.a.a.t.q0.a k1 = m.e.k1(iVar6.b.f2293e);
                        k kVar2 = iVar6.b;
                        b0 b0Var = kVar2.b;
                        TelephonyManager s = kVar2.s();
                        Context t = g.b.a.c.c.d.t(kVar2.c);
                        Objects.requireNonNull(b0Var);
                        return (T) new ShareDiagnosisViewModel(g.b.a.c.c.d.t(iVar6.b.c), iVar6.a, iVar6.b.t(), iVar6.b.j(), new l1(iVar6.b.w.get()), iVar6.b.x.get(), b2, p, k1, new n0(s, t.getResources()), iVar6.b.H.get(), new f.b.a.a.a.d0.b(g.b.a.c.c.d.t(iVar6.b.c)), new f.b.a.a.a.s.g(iVar6.b.R.get(), iVar6.b.v.get(), iVar6.b.A.get()), iVar6.b.v.get(), iVar6.b.G.get(), iVar6.b.A.get());
                    case 7:
                        i iVar7 = this.a;
                        return (T) new SplashViewModel(iVar7.b.b(), iVar7.b.p(), iVar7.b.n());
                    default:
                        throw new AssertionError(this.b);
                }
            }
        }

        public i(k kVar, d dVar, y yVar, b bVar) {
            this.b = kVar;
            this.c = dVar;
            this.a = yVar;
            this.f2303e = new a(kVar, dVar, this, 0);
            this.f2304f = new a(kVar, dVar, this, 1);
            this.f2305g = new a(kVar, dVar, this, 2);
            this.f2306h = new a(kVar, dVar, this, 3);
            this.f2307i = new a(kVar, dVar, this, 4);
            this.f2308j = new a(kVar, dVar, this, 5);
            this.f2309k = new a(kVar, dVar, this, 6);
            this.f2310l = new a(kVar, dVar, this, 7);
        }

        @Override // g.b.a.c.b.d.b
        public Map<String, i.a.a<e0>> a() {
            f.b.a.c.b.o.b.z(8, "expectedSize");
            d.a aVar = new d.a(8);
            aVar.b("com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel", this.f2303e);
            aVar.b("com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel", this.f2304f);
            aVar.b("com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel", this.f2305g);
            aVar.b("com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel", this.f2306h);
            aVar.b("com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel", this.f2307i);
            aVar.b("com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel", this.f2308j);
            aVar.b("com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel", this.f2309k);
            aVar.b("com.google.android.apps.exposurenotification.home.SplashViewModel", this.f2310l);
            return aVar.a();
        }
    }

    public k(f.b.a.a.a.s.f fVar, g.b.a.c.d.a aVar, b0 b0Var, f.b.a.a.a.n0.w wVar, p pVar, d0 d0Var, r1 r1Var, f.b.a.a.a.k0.d dVar, u uVar, o oVar, f.b.a.a.a.g0.m mVar, f.b.a.a.a.g0.r rVar, f.b.a.a.a.d0.e eVar, f.b.a.a.a.t.q0.b bVar, f.b.a.a.a.j0.f fVar2, d1 d1Var, v vVar, h0 h0Var, f.b.a.a.a.p0.k kVar, b bVar2) {
        this.a = d0Var;
        this.b = b0Var;
        this.c = aVar;
        this.f2292d = wVar;
        this.f2293e = bVar;
        this.f2294f = dVar;
        this.f2295g = r1Var;
        this.f2296h = uVar;
        this.f2297i = vVar;
        this.f2298j = fVar2;
        this.f2299k = kVar;
        this.f2300l = h0Var;
        this.m = eVar;
        this.n = pVar;
        this.o = oVar;
        this.p = rVar;
        this.q = mVar;
        this.r = d1Var;
        this.s = fVar;
        i.a.a<w> gVar = new g<>(this, 2);
        Object obj = g.c.b.c;
        this.u = !(gVar instanceof g.c.b) ? new g.c.b<>(gVar) : gVar;
        i.a.a<ExecutorService> gVar2 = new g<>(this, 1);
        this.v = !(gVar2 instanceof g.c.b) ? new g.c.b<>(gVar2) : gVar2;
        i.a.a<ExposureNotificationDatabase> gVar3 = new g<>(this, 3);
        this.w = !(gVar3 instanceof g.c.b) ? new g.c.b<>(gVar3) : gVar3;
        this.x = new g.c.a();
        i.a.a<f.b.a.b.f<f.b.a.a.a.h0.c>> gVar4 = new g<>(this, 6);
        this.y = !(gVar4 instanceof g.c.b) ? new g.c.b<>(gVar4) : gVar4;
        i.a.a<x> gVar5 = new g<>(this, 8);
        this.z = !(gVar5 instanceof g.c.b) ? new g.c.b<>(gVar5) : gVar5;
        i.a.a<ScheduledExecutorService> gVar6 = new g<>(this, 7);
        this.A = !(gVar6 instanceof g.c.b) ? new g.c.b<>(gVar6) : gVar6;
        i.a.a<r> gVar7 = new g<>(this, 5);
        this.B = !(gVar7 instanceof g.c.b) ? new g.c.b<>(gVar7) : gVar7;
        i.a.a<q1> aVar2 = this.x;
        i.a.a gVar8 = new g(this, 4);
        gVar8 = !(gVar8 instanceof g.c.b) ? new g.c.b(gVar8) : gVar8;
        g.c.a aVar3 = (g.c.a) aVar2;
        if (aVar3.a == null) {
            aVar3.a = gVar8;
            this.C = new g(this, 0);
            this.D = new g(this, 9);
            i.a.a<f.b.a.a.a.d0.g> gVar9 = new g<>(this, 11);
            this.E = !(gVar9 instanceof g.c.b) ? new g.c.b<>(gVar9) : gVar9;
            i.a.a<w> gVar10 = new g<>(this, 13);
            this.F = !(gVar10 instanceof g.c.b) ? new g.c.b<>(gVar10) : gVar10;
            i.a.a<ExecutorService> gVar11 = new g<>(this, 12);
            this.G = !(gVar11 instanceof g.c.b) ? new g.c.b<>(gVar11) : gVar11;
            i.a.a<SecureRandom> gVar12 = new g<>(this, 14);
            this.H = !(gVar12 instanceof g.c.b) ? new g.c.b<>(gVar12) : gVar12;
            this.I = new g(this, 10);
            this.J = new g(this, 15);
            this.K = new g(this, 16);
            this.L = new g(this, 17);
            this.M = new g(this, 18);
            i.a.a<f.b.c.a> gVar13 = new g<>(this, 21);
            this.N = !(gVar13 instanceof g.c.b) ? new g.c.b<>(gVar13) : gVar13;
            i.a.a<f.b.c.k.f> gVar14 = new g<>(this, 20);
            this.O = !(gVar14 instanceof g.c.b) ? new g.c.b<>(gVar14) : gVar14;
            this.P = new g(this, 19);
            this.Q = new g(this, 22);
            i.a.a<f.b.a.f.a.a.b> gVar15 = new g<>(this, 23);
            this.R = !(gVar15 instanceof g.c.b) ? new g.c.b<>(gVar15) : gVar15;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // f.b.a.a.a.t.e0
    public void a(ExposureNotificationDismissedReceiver exposureNotificationDismissedReceiver) {
        exposureNotificationDismissedReceiver.c = b();
        exposureNotificationDismissedReceiver.f334d = m.e.k1(this.f2293e);
    }

    @Override // com.google.android.apps.exposurenotification.restore.ExposureNotificationBackupAgent.a
    public a1 b() {
        Objects.requireNonNull(this.r);
        return new a1(g.b.a.c.c.d.t(this.c), m.e.k1(this.f2293e), this.H.get());
    }

    @Override // f.b.a.a.a.c0.v1
    public void c(SmsVerificationBroadcastReceiver smsVerificationBroadcastReceiver) {
        smsVerificationBroadcastReceiver.c = u();
    }

    @Override // f.b.a.a.a.c0.p1
    public void d(ExposureNotificationBroadcastReceiver exposureNotificationBroadcastReceiver) {
        exposureNotificationBroadcastReceiver.c = u();
        exposureNotificationBroadcastReceiver.f375d = m.e.j1(this.b);
        exposureNotificationBroadcastReceiver.f376e = b();
    }

    @Override // f.b.a.a.a.l
    public void e(ExposureNotificationApplication exposureNotificationApplication) {
        f.b.a.c.b.o.b.z(9, "expectedSize");
        d.a aVar = new d.a(9);
        aVar.b("com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker", this.C);
        aVar.b("com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker", this.D);
        aVar.b("com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker", this.I);
        aVar.b("com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker", this.J);
        aVar.b("com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker", this.K);
        aVar.b("com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker", this.L);
        aVar.b("com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker", this.M);
        aVar.b("com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker", this.P);
        aVar.b("com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker", this.Q);
        exposureNotificationApplication.c = new e.p.a.a(aVar.a());
        exposureNotificationApplication.workManager = u();
        f.b.a.a.a.p0.k kVar = this.f2299k;
        Context t = g.b.a.c.c.d.t(this.c);
        f.b.a.d.a.a0 p = p();
        f0 q = q();
        Objects.requireNonNull(kVar);
        exposureNotificationApplication.f329d = new q(u(), this.F.get(), l.b.a.d.h((long) t.getResources().getInteger(R.integer.enx_tekPublishInterval)), p, q);
        Objects.requireNonNull(this.f2296h);
        exposureNotificationApplication.f330e = new ApplicationObserver(this.B.get());
        exposureNotificationApplication.f331f = f.b.b.a.a.b;
        exposureNotificationApplication.f332g = this.v.get();
        exposureNotificationApplication.firebaseApp = this.N.get();
        exposureNotificationApplication.f333h = n();
    }

    @Override // g.b.a.c.c.c.a
    public g.b.a.c.a.b f() {
        return new c(this.t, null);
    }

    public final int g() {
        o oVar = this.o;
        a1 b2 = b();
        Objects.requireNonNull(oVar);
        if (!b2.a.contains("ExposureNotificationSharedPreferences.BIWEEKLY_METRICS_UPLOAD_DAY")) {
            b2.a.edit().putInt("ExposureNotificationSharedPreferences.BIWEEKLY_METRICS_UPLOAD_DAY", b2.c.nextInt(14)).commit();
        }
        return b2.a.getInt("ExposureNotificationSharedPreferences.BIWEEKLY_METRICS_UPLOAD_DAY", 0);
    }

    public final f.b.a.a.a.k0.c h() {
        f.b.a.a.a.k0.e eVar = new f.b.a.a.a.k0.e(s());
        f.b.a.a.a.n0.v vVar = new f.b.a.a.a.n0.v(this.w.get(), m.e.k1(this.f2293e));
        f.b.a.a.a.t.q0.a k1 = m.e.k1(this.f2293e);
        f.b.a.a.a.k0.d dVar = this.f2294f;
        Context t = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(dVar);
        if (t.getString(R.string.enx_regionIdentifier).length() >= 2) {
            String substring = t.getString(R.string.enx_regionIdentifier).substring(0, 2);
            Objects.requireNonNull(substring, "Cannot return null from a non-@Nullable @Provides method");
            return new f.b.a.a.a.k0.c(eVar, vVar, k1, substring);
        }
        throw new RuntimeException("Failed to determine user's home region from configuration.");
    }

    public final DailySummariesConfig i() {
        f.b.a.a.a.j0.f fVar = this.f2298j;
        Context t = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(fVar);
        Resources resources = t.getResources();
        DailySummariesConfig.a aVar = new DailySummariesConfig.a();
        boolean z = false;
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
        aVar.f480d = new ArrayList(asList2);
        aVar.a(1, ((double) resources.getInteger(R.integer.enx_infectiousnessStandardWeight)) * 0.01d);
        aVar.a(2, ((double) resources.getInteger(R.integer.enx_infectiousnessHighWeight)) * 0.01d);
        aVar.b(1, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedTestWeight)) * 0.01d);
        aVar.b(2, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedClinicalDiagnosisWeight)) * 0.01d);
        aVar.b(3, ((double) resources.getInteger(R.integer.enx_reportTypeSelfReportWeight)) * 0.01d);
        int integer = resources.getInteger(R.integer.enx_daysSinceExposureThreshold);
        m.e.k(integer >= 0, "daysSinceExposureThreshold must not be negative");
        aVar.f481e = integer;
        m.e.k(aVar.c != null, "Must set attenuationBucketThresholdDb");
        if (aVar.f480d != null) {
            z = true;
        }
        m.e.k(z, "Must set attenuationBucketWeights");
        DailySummariesConfig dailySummariesConfig = new DailySummariesConfig(Arrays.asList(aVar.a), Arrays.asList(aVar.b), aVar.c, aVar.f480d, aVar.f481e, 0.0d);
        f.b.a.a.a.j0.f.a.a("Created dailySummaryConfig: " + dailySummariesConfig);
        return dailySummariesConfig;
    }

    public final f.b.a.a.a.n0.k0 j() {
        return new f.b.a.a.a.n0.k0(this.w.get(), this.v.get(), m.e.k1(this.f2293e));
    }

    public final p0 k() {
        return new p0(this.w.get());
    }

    public final v0 l() {
        return new v0(this.w.get());
    }

    public final s m() {
        g.a aVar;
        Context t = g.b.a.c.c.d.t(this.c);
        a1 b2 = b();
        i.a.a<q1> aVar2 = this.x;
        Object obj = g.c.b.c;
        if (aVar2 instanceof g.a) {
            aVar = (g.a) aVar2;
        } else {
            Objects.requireNonNull(aVar2);
            aVar = new g.c.b(aVar2);
        }
        return new s(t, b2, aVar, this.y.get(), new f.b.a.a.a.n0.h(this.w.get()), m.e.k1(this.f2293e), new f.b.a.a.a.n0.q1(this.w.get()), this.u.get(), this.A.get());
    }

    public final f.b.a.a.a.b0.f n() {
        return new f.b.a.a.a.b0.f(new f.b.a.a.a.b0.e(this.u.get(), b(), u()), b(), this.v.get());
    }

    public final l<f.b.a.d.a.b0> o() {
        f.b.a.a.a.g0.r rVar = this.p;
        new t(g.b.a.c.c.d.t(this.c));
        s m = m();
        Objects.requireNonNull(rVar);
        return new f.b.b.a.o(new f.b.a.a.a.g0.p(rVar, m));
    }

    public final f.b.a.d.a.a0 p() {
        f.b.a.a.a.g0.r rVar = this.p;
        a1 b2 = b();
        Objects.requireNonNull(rVar);
        return new f.b.a.a.a.g0.o(rVar, b2);
    }

    public final f0 q() {
        f.b.a.a.a.g0.r rVar = this.p;
        Uri r = r();
        l<f.b.a.d.a.b0> o = o();
        d0.a l1 = m.e.l1(this.p);
        Objects.requireNonNull(rVar);
        return new f.b.a.d.a.s(r, o, l1);
    }

    public final Uri r() {
        f.b.a.a.a.g0.r rVar = this.p;
        Context t = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(rVar);
        Uri parse = Uri.parse(t.getString(R.string.enx_enpaRemoteConfigURL));
        Objects.requireNonNull(parse, "Cannot return null from a non-@Nullable @Provides method");
        return parse;
    }

    public final TelephonyManager s() {
        b0 b0Var = this.b;
        Context t = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(b0Var);
        TelephonyManager telephonyManager = (TelephonyManager) t.getSystemService("phone");
        Objects.requireNonNull(telephonyManager, "Cannot return null from a non-@Nullable @Provides method");
        return telephonyManager;
    }

    public final f.b.a.a.a.z.f0 t() {
        Context t = g.b.a.c.c.d.t(this.c);
        h0 h0Var = this.f2300l;
        Context t2 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(h0Var);
        Uri parse = Uri.parse(t2.getString(R.string.enx_testVerificationURL));
        Objects.requireNonNull(parse, "Cannot return null from a non-@Nullable @Provides method");
        h0 h0Var2 = this.f2300l;
        Context t3 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(h0Var2);
        Uri parse2 = Uri.parse(t3.getString(R.string.enx_testVerificationCertificateURL));
        Objects.requireNonNull(parse2, "Cannot return null from a non-@Nullable @Provides method");
        h0 h0Var3 = this.f2300l;
        Context t4 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(h0Var3);
        Uri parse3 = Uri.parse(t4.getString(R.string.enx_testVerificationUserReportURL));
        Objects.requireNonNull(parse3, "Cannot return null from a non-@Nullable @Provides method");
        c0 c0Var = new c0(t, parse, parse2, parse3, this.E.get(), m.e.k1(this.f2293e), this.B.get());
        Context t5 = g.b.a.c.c.d.t(this.c);
        h0 h0Var4 = this.f2300l;
        Context t6 = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(h0Var4);
        Uri parse4 = Uri.parse(t6.getString(R.string.enx_tekUploadURL));
        Objects.requireNonNull(parse4, "Cannot return null from a non-@Nullable @Provides method");
        return new f.b.a.a.a.z.f0(c0Var, new f.b.a.a.a.z.d0(t5, parse4, this.E.get(), this.v.get(), this.G.get(), m.e.k1(this.f2293e), this.B.get()), new f.b.a.a.a.d0.b(g.b.a.c.c.d.t(this.c)));
    }

    public final e.c0.w u() {
        f.b.a.a.a.p0.k kVar = this.f2299k;
        Context t = g.b.a.c.c.d.t(this.c);
        Objects.requireNonNull(kVar);
        e.c0.a0.l h2 = e.c0.a0.l.h(t);
        Objects.requireNonNull(h2, "Cannot return null from a non-@Nullable @Provides method");
        return h2;
    }

    public final f.b.a.a.a.p0.r v() {
        return new f.b.a.a.a.p0.r(this.x.get(), this.v.get(), this.A.get(), new u1(b()), new f.b.a.a.a.t.a0(g.b.a.c.c.d.t(this.c), b(), new f.b.a.a.a.n0.h(this.w.get()), new f.b.a.a.a.n0.v(this.w.get(), m.e.k1(this.f2293e)), j(), k(), new f.b.a.a.a.n0.b1(this.w.get()), l(), new l1(this.w.get()), new f.b.a.a.a.n0.q1(this.w.get()), new o1(b(), i(), m.e.k1(this.f2293e)), u(), m.e.j1(this.b), m.e.k1(this.f2293e), this.v.get()));
    }
}
