package f.b.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import androidx.activity.ComponentActivity;
import com.google.android.apps.exposurenotification.ExposureNotificationApplication;
import com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver;
import com.google.android.apps.exposurenotification.home.ExposureNotificationActivity;
import com.google.android.apps.exposurenotification.logging.ApplicationObserver;
import com.google.android.apps.exposurenotification.nearby.ExposureNotificationBroadcastReceiver;
import com.google.android.apps.exposurenotification.nearby.SmsVerificationBroadcastReceiver;
import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import e.p.e0;
import e.p.f0;
import e.p.z;
import f.b.a.a.a.b0.f1;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.r0;
import f.b.a.a.a.b0.v;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.b0.w0;
import f.b.a.a.a.b0.y0;
import f.b.a.a.a.d0.m;
import f.b.a.a.a.i.c0;
import f.b.a.a.a.i.q;
import f.b.a.a.a.i.s;
import f.b.a.a.a.i.w;
import f.b.a.a.a.l.o;
import f.b.a.a.a.m.b1;
import f.b.a.a.a.n.n;
import f.b.a.a.a.n.p;
import f.b.a.a.a.o.d0;
import f.b.a.a.a.o.f0;
import f.b.a.a.a.p.r;
import f.b.a.a.a.p.t;
import f.b.a.a.a.p.u;
import f.b.a.a.a.q.g1;
import f.b.a.a.a.q.i1;
import f.b.a.a.a.q.j1;
import f.b.a.a.a.q.m1;
import f.b.a.a.a.q.n1;
import f.b.a.a.a.q.o1;
import f.b.a.a.a.q.q1;
import f.b.a.a.a.q.r1;
import f.b.a.a.a.r.g;
import f.b.a.a.a.s.b6;
import f.b.a.a.a.s.d6;
import f.b.a.a.a.s.g6;
import f.b.a.a.a.s.j6;
import f.b.a.a.a.s.m6;
import f.b.a.a.a.s.n5;
import f.b.a.a.a.s.p5;
import f.b.a.a.a.s.p6;
import f.b.a.a.a.s.q6;
import f.b.a.a.a.s.r5;
import f.b.a.a.a.s.t5;
import f.b.a.a.a.s.v5;
import f.b.a.a.a.s.y5;
import f.b.a.a.a.t.k0;
import f.b.a.a.a.t.m0;
import f.b.a.a.a.u.t.i;
import f.b.a.a.a.u.t.k;
import f.b.a.a.a.x.e;
import f.b.a.a.a.x.f;
import f.b.a.a.a.z.a1;
import f.b.a.a.a.z.c1;
import f.b.a.a.a.z.d1;
import f.b.a.a.a.z.o0;
import f.b.a.a.a.z.p0;
import f.b.a.a.a.z.x0;
import f.b.a.d.a.a0;
import f.b.a.d.a.b0;
import f.b.a.d.a.d0;
import f.b.a.d.a.g0;
import f.b.b.a.l;
import f.b.b.b.b;
import f.b.b.b.d;
import f.b.b.b.h;
import f.b.b.b.j;
import f.b.b.f.a.x;
import g.b.a.c.c.b;
import gov.co.cdphe.exposurenotifications.R;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends g {
    public volatile Object A = new g.c.b();
    public volatile Object B = new g.c.b();
    public volatile Object C = new g.c.b();
    public volatile i.a.a<m> D;
    public volatile i.a.a<r> E;
    public volatile i.a.a<f.b.a.a.a.y.c> F;
    public volatile i.a.a<t> G;
    public volatile i.a.a<v0> H;
    public volatile i.a.a<i0> I;
    public volatile Object J = new g.c.b();
    public volatile Object K = new g.c.b();
    public volatile Object L = new g.c.b();
    public volatile i.a.a<f0> M;
    public volatile i.a.a<ExecutorService> N;
    public volatile Object O = new g.c.b();
    public volatile i.a.a<SecureRandom> P;
    public volatile i.a.a<f.b.a.a.a.i.f0.a> Q;
    public volatile i.a.a<n1> R;
    public volatile i.a.a<n> S;
    public volatile i.a.a<g1> T;
    public volatile i.a.a<DiagnosisKeysDataMapping> U;
    public volatile i.a.a<ScheduledExecutorService> V;
    public volatile i.a.a<o1> W;
    public volatile i.a.a<w> X;
    public volatile i.a.a<f.b.a.a.a.w.a> Y;
    public volatile i.a.a<x> Z;
    public final s a;
    public volatile i.a.a<q1> a0;
    public final g.b.a.c.d.a b;
    public volatile i.a.a<w0> b0;
    public final q c;
    public volatile i.a.a<e> c0;

    /* renamed from: d  reason: collision with root package name */
    public final v f2062d;
    public volatile i.a.a<DailySummariesConfig> d0;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.a.a.a.i.f0.b f2063e;
    public volatile i.a.a<f.b.a.a.a.x.c> e0;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.y.e f2064f;
    public volatile i.a.a<r1> f0;

    /* renamed from: g  reason: collision with root package name */
    public final j1 f2065g;
    public volatile Object g0 = new g.c.b();

    /* renamed from: h  reason: collision with root package name */
    public final f.b.a.a.a.p.w f2066h;
    public volatile Object h0 = new g.c.b();

    /* renamed from: i  reason: collision with root package name */
    public final f.b.a.a.a.p.v f2067i;
    public volatile i.a.a<g0> i0;

    /* renamed from: j  reason: collision with root package name */
    public final f.b.a.a.a.o.i0 f2068j;
    public volatile i.a.a<l<b0>> j0;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.a.a.r.e f2069k;
    public volatile i.a.a<Integer> k0;

    /* renamed from: l  reason: collision with root package name */
    public final p f2070l;
    public volatile i.a.a<f.b.a.a.a.u.s> l0;
    public final f m;
    public volatile i.a.a<e.z.t> m0;
    public final f.b.a.a.a.u.r n;
    public volatile i.a.a<f.b.a.a.a.o.g0> n0;
    public final f.b.a.a.a.u.t.m o;
    public volatile i.a.a<r0> o0;
    public final f.b.a.a.a.u.m p;
    public volatile i.a.a<m1> p0;
    public final f.b.a.a.a.d0.f q;
    public volatile i.a.a<a0> q0;
    public final y0 r;
    public volatile i.a.a<Context> r0;
    public volatile Object s = new g.c.b();
    public volatile i.a.a<f1> s0;
    public volatile Object t = new g.c.b();
    public volatile i.a.a<c0> t0;
    public volatile i.a.a<ExecutorService> u;
    public volatile i.a.a<f.b.a.a.a.r.b> u0;
    public volatile Object v = new g.c.b();
    public volatile i.a.a<f.b.a.a.a.y.d> w;
    public volatile i.a.a<i1> x;
    public volatile Object y = new g.c.b();
    public volatile Object z = new g.c.b();

    /* renamed from: f.b.a.a.a.b$b  reason: collision with other inner class name */
    public final class C0067b implements g.b.a.c.a.b {
        public C0067b(a aVar) {
        }
    }

    public final class c extends e {
        public volatile Object a = new g.c.b();

        public final class a implements g.b.a.c.a.a {
            public Activity a;

            public a(a aVar) {
            }
        }

        /* renamed from: f.b.a.a.a.b$c$b  reason: collision with other inner class name */
        public final class C0068b extends d {
            public final Activity a;
            public volatile i.a.a<o0> b;
            public volatile i.a.a<f.b.a.a.a.l.l> c;

            /* renamed from: d  reason: collision with root package name */
            public volatile i.a.a<b1> f2071d;

            /* renamed from: e  reason: collision with root package name */
            public volatile i.a.a<n5> f2072e;

            /* renamed from: f  reason: collision with root package name */
            public volatile i.a.a<m0> f2073f;

            /* renamed from: g  reason: collision with root package name */
            public volatile i.a.a<c1> f2074g;

            /* renamed from: h  reason: collision with root package name */
            public volatile i.a.a<p6> f2075h;

            /* renamed from: i  reason: collision with root package name */
            public volatile i.a.a<f.b.a.a.a.m.m1> f2076i;

            /* renamed from: f.b.a.a.a.b$c$b$a */
            public final class a implements g.b.a.c.a.c {
                public e.m.a.m a;

                public a(a aVar) {
                }
            }

            /* renamed from: f.b.a.a.a.b$c$b$b  reason: collision with other inner class name */
            public final class C0069b extends f {
                public final e.m.a.m a;

                public C0069b(e.m.a.m mVar, a aVar) {
                    this.a = mVar;
                }

                @Override // f.b.a.a.a.s.n6
                public void A(m6 m6Var) {
                    m6Var.c0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.t.h0
                public void B(f.b.a.a.a.t.g0 g0Var) {
                }

                @Override // f.b.a.a.a.z.y0
                public void a(x0 x0Var) {
                }

                @Override // f.b.a.a.a.s.u5
                public void b(t5 t5Var) {
                    t5Var.c0 = m.h.T0(b.this.f2063e);
                }

                @Override // g.b.a.c.b.b
                public Set<f0.b> c() {
                    e.m.a.m mVar = this.a;
                    Application application = (Application) b.this.b.a.getApplicationContext();
                    Objects.requireNonNull(application, "Cannot return null from a non-@Nullable @Provides method");
                    Map<String, i.a.a<e.n.a.b<? extends e0>>> d2 = C0068b.this.d();
                    Bundle bundle = mVar.f1454g;
                    e.n.a.a aVar = new e.n.a.a(mVar, bundle, new z(application, mVar, bundle), d2);
                    int i2 = f.b.b.b.e.f3071d;
                    return new j(aVar);
                }

                @Override // f.b.a.a.a.k.k
                public void d(f.b.a.a.a.k.j jVar) {
                }

                @Override // f.b.a.a.a.s.z5
                public void e(y5 y5Var) {
                }

                @Override // f.b.a.a.a.s.c6
                public void f(b6 b6Var) {
                    b6Var.c0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.s.s5
                public void g(r5 r5Var) {
                    r5Var.c0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.t.l0
                public void h(k0 k0Var) {
                }

                @Override // f.b.a.a.a.k.q
                public void i(f.b.a.a.a.k.p pVar) {
                }

                @Override // f.b.a.a.a.s.h6
                public void j(g6 g6Var) {
                    g6Var.c0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.m.g1
                public void k(f.b.a.a.a.m.f1 f1Var) {
                    f1Var.f0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.z.l0
                public void l(f.b.a.a.a.z.k0 k0Var) {
                }

                @Override // f.b.a.a.a.t.j0
                public void m(f.b.a.a.a.t.i0 i0Var) {
                }

                @Override // f.b.a.a.a.z.e1
                public void n(d1 d1Var) {
                }

                @Override // f.b.a.a.a.l.p
                public void o(o oVar) {
                }

                @Override // f.b.a.a.a.s.e6
                public void p(d6 d6Var) {
                    d6Var.c0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.l.k
                public void q(f.b.a.a.a.l.j jVar) {
                    jVar.b0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.m.k1
                public void r(f.b.a.a.a.m.j1 j1Var) {
                    j1Var.a0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.s.r6
                public void s(q6 q6Var) {
                }

                @Override // f.b.a.a.a.s.w5
                public void t(v5 v5Var) {
                    v5Var.c0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.s.q5
                public void u(p5 p5Var) {
                    p5Var.c0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.k.s
                public void v(f.b.a.a.a.k.r rVar) {
                }

                @Override // f.b.a.a.a.z.b1
                public void w(a1 a1Var) {
                }

                @Override // f.b.a.a.a.z.q0
                public void x(p0 p0Var) {
                }

                @Override // f.b.a.a.a.s.k6
                public void y(j6 j6Var) {
                    j6Var.c0 = m.h.T0(b.this.f2063e);
                }

                @Override // f.b.a.a.a.z.n0
                public void z(f.b.a.a.a.z.m0 m0Var) {
                }
            }

            /* renamed from: f.b.a.a.a.b$c$b$c  reason: collision with other inner class name */
            public final class C0070c<T> implements i.a.a<T> {
                public final int a;

                public C0070c(int i2) {
                    this.a = i2;
                }

                @Override // i.a.a
                public T get() {
                    switch (this.a) {
                        case 0:
                            return (T) new o0(b.this.v());
                        case 1:
                            C0068b bVar = C0068b.this;
                            i.a.a<v0> v = b.this.v();
                            b bVar2 = b.this;
                            i.a.a aVar = bVar2.o0;
                            if (aVar == null) {
                                aVar = new d(34);
                                bVar2.o0 = aVar;
                            }
                            i.a.a<w> B = b.this.B();
                            i.a.a<f.b.a.a.a.i.f0.a> n = b.this.n();
                            b bVar3 = b.this;
                            i.a.a aVar2 = bVar3.m0;
                            if (aVar2 == null) {
                                aVar2 = new d(33);
                                bVar3.m0 = aVar2;
                            }
                            return (T) new f.b.a.a.a.l.l(v, aVar, B, n, aVar2);
                        case 2:
                            C0068b bVar4 = C0068b.this;
                            i.a.a<v0> v2 = b.this.v();
                            i.a.a<i1> t = b.this.t();
                            i.a.a<i0> q = b.this.q();
                            i.a.a<r> i2 = b.this.i();
                            b bVar5 = b.this;
                            i.a.a aVar3 = bVar5.p0;
                            if (aVar3 == null) {
                                aVar3 = new d(35);
                                bVar5.p0 = aVar3;
                            }
                            return (T) new b1(v2, t, q, i2, aVar3, b.this.n(), b.this.z());
                        case 3:
                            C0068b bVar6 = C0068b.this;
                            return (T) new n5(b.this.q(), b.this.z());
                        case 4:
                            C0068b bVar7 = C0068b.this;
                            i.a.a<v0> v3 = b.this.v();
                            i.a.a g2 = b.g(b.this);
                            b bVar8 = b.this;
                            i.a.a aVar4 = bVar8.m0;
                            if (aVar4 == null) {
                                aVar4 = new d(33);
                                bVar8.m0 = aVar4;
                            }
                            return (T) new m0(v3, g2, aVar4);
                        case 5:
                            C0068b bVar9 = C0068b.this;
                            return (T) new c1(b.this.v(), b.g(b.this));
                        case 6:
                            C0068b bVar10 = C0068b.this;
                            b bVar11 = b.this;
                            i.a.a aVar5 = bVar11.r0;
                            if (aVar5 == null) {
                                aVar5 = new d(37);
                                bVar11.r0 = aVar5;
                            }
                            i.a.a<f.b.a.a.a.o.f0> N = b.this.N();
                            i.a.a<i0> q2 = b.this.q();
                            b bVar12 = b.this;
                            i.a.a aVar6 = bVar12.s0;
                            if (aVar6 == null) {
                                aVar6 = new d(38);
                                bVar12.s0 = aVar6;
                            }
                            i.a.a<i1> t2 = b.this.t();
                            i.a.a<v0> v4 = b.this.v();
                            i.a.a g3 = b.g(b.this);
                            i.a.a<f.b.a.a.a.i.f0.a> n2 = b.this.n();
                            b bVar13 = b.this;
                            i.a.a aVar7 = bVar13.t0;
                            if (aVar7 == null) {
                                aVar7 = new d(39);
                                bVar13.t0 = aVar7;
                            }
                            i.a.a<SecureRandom> L = b.this.L();
                            b bVar14 = b.this;
                            i.a.a aVar8 = bVar14.u0;
                            if (aVar8 == null) {
                                aVar8 = new d(40);
                                bVar14.u0 = aVar8;
                            }
                            return (T) new p6(aVar5, N, q2, aVar6, t2, v4, g3, n2, aVar7, L, aVar8, b.this.k(), b.this.z(), b.this.J());
                        case 7:
                            C0068b bVar15 = C0068b.this;
                            return (T) new f.b.a.a.a.m.m1(b.this.v(), b.g(b.this));
                        default:
                            throw new AssertionError(this.a);
                    }
                }
            }

            public C0068b(Activity activity, a aVar) {
                this.a = activity;
            }

            @Override // g.b.a.c.b.a
            public Set<f0.b> a() {
                Activity activity = this.a;
                Application application = (Application) b.this.b.a.getApplicationContext();
                Objects.requireNonNull(application, "Cannot return null from a non-@Nullable @Provides method");
                Map<String, i.a.a<e.n.a.b<? extends e0>>> d2 = d();
                ComponentActivity componentActivity = (ComponentActivity) activity;
                Bundle extras = activity.getIntent() != null ? activity.getIntent().getExtras() : null;
                e.n.a.a aVar = new e.n.a.a(componentActivity, extras, new z(application, componentActivity, extras), d2);
                int i2 = f.b.b.b.e.f3071d;
                return new j(aVar);
            }

            @Override // g.b.a.c.c.f.a
            public g.b.a.c.a.c b() {
                return new a(null);
            }

            @Override // f.b.a.a.a.m.a1
            public void c(ExposureNotificationActivity exposureNotificationActivity) {
            }

            public final Map<String, i.a.a<e.n.a.b<? extends e0>>> d() {
                f.b.a.c.b.o.b.y(8, "expectedSize");
                d.a aVar = new d.a(8);
                i.a.a aVar2 = this.b;
                if (aVar2 == null) {
                    aVar2 = new C0070c(0);
                    this.b = aVar2;
                }
                aVar.b("com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel", aVar2);
                i.a.a aVar3 = this.c;
                if (aVar3 == null) {
                    aVar3 = new C0070c(1);
                    this.c = aVar3;
                }
                aVar.b("com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel", aVar3);
                i.a.a aVar4 = this.f2071d;
                if (aVar4 == null) {
                    aVar4 = new C0070c(2);
                    this.f2071d = aVar4;
                }
                aVar.b("com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel", aVar4);
                i.a.a aVar5 = this.f2072e;
                if (aVar5 == null) {
                    aVar5 = new C0070c(3);
                    this.f2072e = aVar5;
                }
                aVar.b("com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel", aVar5);
                i.a.a aVar6 = this.f2073f;
                if (aVar6 == null) {
                    aVar6 = new C0070c(4);
                    this.f2073f = aVar6;
                }
                aVar.b("com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel", aVar6);
                i.a.a aVar7 = this.f2074g;
                if (aVar7 == null) {
                    aVar7 = new C0070c(5);
                    this.f2074g = aVar7;
                }
                aVar.b("com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel", aVar7);
                i.a.a aVar8 = this.f2075h;
                if (aVar8 == null) {
                    aVar8 = new C0070c(6);
                    this.f2075h = aVar8;
                }
                aVar.b("com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel", aVar8);
                i.a.a aVar9 = this.f2076i;
                if (aVar9 == null) {
                    aVar9 = new C0070c(7);
                    this.f2076i = aVar9;
                }
                aVar.b("com.google.android.apps.exposurenotification.home.SplashViewModel", aVar9);
                return aVar.a();
            }
        }

        public c(a aVar) {
        }

        @Override // g.b.a.c.c.a.AbstractC0138a
        public g.b.a.c.a.a a() {
            return new a(null);
        }

        @Override // g.b.a.c.c.b.d
        public g.b.a.a b() {
            Object obj;
            Object obj2 = this.a;
            if (obj2 instanceof g.c.b) {
                synchronized (obj2) {
                    obj = this.a;
                    if (obj instanceof g.c.b) {
                        obj = new b.e();
                        g.c.a.a(this.a, obj);
                        this.a = obj;
                    }
                }
                obj2 = obj;
            }
            return (g.b.a.a) obj2;
        }
    }

    public final class d<T> implements i.a.a<T> {
        public final int a;

        public d(int i2) {
            this.a = i2;
        }

        @Override // i.a.a
        public T get() {
            Map map;
            Object obj;
            int i2 = 4;
            int i3 = 0;
            boolean z = false;
            switch (this.a) {
                case 0:
                    b bVar = b.this;
                    i.a.a<ExecutorService> k2 = bVar.k();
                    i.a.a aVar = bVar.w;
                    if (aVar == null) {
                        aVar = new d(2);
                        bVar.w = aVar;
                    }
                    return (T) new f.b.a.a.a.y.c(k2, aVar, bVar.P(), bVar.i());
                case 1:
                    return (T) b.this.j();
                case 2:
                    return (T) b.this.o();
                case 3:
                    b bVar2 = b.this;
                    Objects.requireNonNull(bVar2);
                    return (T) new f.b.a.a.a.d0.m(bVar2.s(), bVar2.j(), bVar2.I(), new m1(bVar2.b()), bVar2.r(), new f1(bVar2.u()), m.h.T0(bVar2.f2063e));
                case 4:
                    return (T) b.this.s();
                case 5:
                    return (T) b.this.h();
                case 6:
                    b bVar3 = b.this;
                    return (T) new t(bVar3.i(), bVar3.P(), bVar3.k());
                case 7:
                    b bVar4 = b.this;
                    return (T) new n1(bVar4.v(), bVar4.q(), bVar4.N(), bVar4.k(), bVar4.z(), bVar4.L(), bVar4.n());
                case 8:
                    return (T) b.this.b();
                case 9:
                    b bVar5 = b.this;
                    return (T) new i0(bVar5.u(), bVar5.j(), m.h.T0(bVar5.f2063e));
                case 10:
                    b bVar6 = b.this;
                    return (T) new f.b.a.a.a.o.f0(new f.b.a.a.a.o.c0(g.b.a.c.c.c.t(bVar6.b), f.a.a.a.a.m(bVar6.b, bVar6.f2068j, R.string.enx_testVerificationURL, "Cannot return null from a non-@Nullable @Provides method"), f.a.a.a.a.m(bVar6.b, bVar6.f2068j, R.string.enx_testVerificationCertificateURL, "Cannot return null from a non-@Nullable @Provides method"), f.a.a.a.a.m(bVar6.b, bVar6.f2068j, R.string.enx_testVerificationUserReportURL, "Cannot return null from a non-@Nullable @Provides method"), bVar6.G(), m.h.T0(bVar6.f2063e), bVar6.h()), new d0(g.b.a.c.c.c.t(bVar6.b), f.a.a.a.a.m(bVar6.b, bVar6.f2068j, R.string.enx_tekUploadURL, "Cannot return null from a non-@Nullable @Provides method"), bVar6.G(), bVar6.j(), bVar6.y(), m.h.T0(bVar6.f2063e), bVar6.h()), new f.b.a.a.a.r.b(g.b.a.c.c.c.t(bVar6.b)));
                case 11:
                    return (T) b.this.y();
                case 12:
                    return (T) b.this.K();
                case 13:
                    return (T) m.h.T0(b.this.f2063e);
                case 14:
                    b bVar7 = b.this;
                    i.a.a aVar2 = bVar7.S;
                    if (aVar2 == null) {
                        aVar2 = new d(15);
                        bVar7.S = aVar2;
                    }
                    i.a.a<i1> t = bVar7.t();
                    i.a.a aVar3 = bVar7.T;
                    if (aVar3 == null) {
                        aVar3 = new d(16);
                        bVar7.T = aVar3;
                    }
                    i.a.a aVar4 = bVar7.U;
                    if (aVar4 == null) {
                        aVar4 = new d(17);
                        bVar7.U = aVar4;
                    }
                    return (T) new o1(aVar2, t, aVar3, aVar4, bVar7.k(), bVar7.J(), bVar7.P(), bVar7.i());
                case 15:
                    b bVar8 = b.this;
                    Context t2 = g.b.a.c.c.c.t(bVar8.b);
                    g G = bVar8.G();
                    f.b.a.a.a.y.d o = bVar8.o();
                    f.b.a.a.a.n.r rVar = new f.b.a.a.a.n.r(new f.b.a.a.a.b0.m0(bVar8.u()), bVar8.G(), m.h.T0(bVar8.f2063e), bVar8.j(), bVar8.y());
                    p pVar = bVar8.f2070l;
                    Context t3 = g.b.a.c.c.c.t(bVar8.b);
                    Objects.requireNonNull(pVar);
                    f.b.a.a.a.n.l lVar = new f.b.a.a.a.n.l(Uri.parse(t3.getString(R.string.enx_tekLocalDownloadIndexFile)), Uri.parse(t3.getString(R.string.enx_tekLocalDownloadBasePath)));
                    p pVar2 = bVar8.f2070l;
                    Context t4 = g.b.a.c.c.c.t(bVar8.b);
                    Objects.requireNonNull(pVar2);
                    String string = t4.getString(R.string.enx_tekRoamingUrls);
                    f.b.a.a.a.i.e0.a aVar5 = f.b.a.a.a.n.s.a;
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        Object[] objArr = new Object[8];
                        Iterator<String> keys = jSONObject.keys();
                        int i4 = 0;
                        while (keys.hasNext()) {
                            String next = keys.next();
                            f.b.b.b.a<Object> aVar6 = f.b.b.b.c.c;
                            f.b.a.c.b.o.b.y(i2, "initialCapacity");
                            Object[] objArr2 = new Object[i2];
                            int i5 = 0;
                            for (JSONArray jSONArray = jSONObject.getJSONArray(next); i5 < jSONArray.length(); jSONArray = jSONArray) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                                f.b.a.a.a.n.l lVar2 = new f.b.a.a.a.n.l(Uri.parse(jSONObject2.getString("index")), Uri.parse(jSONObject2.getString("base")));
                                int i6 = i3 + 1;
                                if (objArr2.length < i6) {
                                    objArr2 = Arrays.copyOf(objArr2, b.AbstractC0103b.b(objArr2.length, i6));
                                }
                                objArr2[i3] = lVar2;
                                i5++;
                                i3 = i6;
                                keys = keys;
                            }
                            f.b.b.b.c p = f.b.b.b.c.p(objArr2, i3);
                            int i7 = i4 + 1;
                            int i8 = i7 * 2;
                            if (i8 > objArr.length) {
                                objArr = Arrays.copyOf(objArr, b.AbstractC0103b.b(objArr.length, i8));
                            }
                            f.b.a.c.b.o.b.x(next, p);
                            int i9 = i4 * 2;
                            objArr[i9] = next;
                            objArr[i9 + 1] = p;
                            i2 = 4;
                            i4 = i7;
                            jSONObject = jSONObject;
                            keys = keys;
                            i3 = 0;
                        }
                        f.b.a.a.a.n.s.a.a("Parsed " + h.d(i4, objArr).f3078g + " region(s) roaming config");
                        map = h.d(i4, objArr);
                    } catch (Exception e2) {
                        f.b.a.a.a.n.s.a.d("Failed to parse JSON roaming download config, continuing with no roaming servers.", e2);
                        map = new HashMap();
                    }
                    return (T) new n(t2, G, o, rVar, lVar, map, bVar8.j(), bVar8.y(), bVar8.I(), bVar8.h(), m.h.T0(bVar8.f2063e));
                case 16:
                    b bVar9 = b.this;
                    return (T) new g1(bVar9.s(), new f.b.a.a.a.b0.m0(bVar9.u()), bVar9.r(), bVar9.b(), m.h.T0(bVar9.f2063e), bVar9.j(), bVar9.I());
                case 17:
                    b bVar10 = b.this;
                    f fVar = bVar10.m;
                    Context t5 = g.b.a.c.c.c.t(bVar10.b);
                    Objects.requireNonNull(fVar);
                    String string2 = t5.getResources().getString(R.string.enx_symptomOnsetToInfectiousnessMap);
                    int integer = t5.getResources().getInteger(R.integer.enx_reportTypeNoneMap);
                    String upperCase = string2.substring(2).toUpperCase();
                    Objects.requireNonNull(upperCase);
                    if (upperCase.length() < 16) {
                        StringBuilder sb = new StringBuilder(16);
                        for (int length = upperCase.length(); length < 16; length++) {
                            sb.append('0');
                        }
                        sb.append(upperCase);
                        upperCase = sb.toString();
                    }
                    byte[] a2 = f.b.b.c.a.c.a(upperCase);
                    int[] iArr = new int[(a2.length * 4)];
                    int length2 = a2.length;
                    while (true) {
                        length2--;
                        if (length2 >= 0) {
                            byte b2 = a2[length2];
                            for (byte b3 = 3; b3 >= 0; b3 = (byte) (b3 - 1)) {
                                iArr[(3 - b3) + (((a2.length - 1) - length2) * 4)] = (byte) (b2 & 3);
                                b2 = (byte) (b2 >> 2);
                            }
                        } else {
                            HashMap hashMap = new HashMap();
                            for (int i10 = -14; i10 <= 14; i10++) {
                                hashMap.put(Integer.valueOf(i10), Integer.valueOf(iArr[i10 + 14]));
                            }
                            m.h.j(true, "daysSinceOnsetToInfectiousness must not be null.");
                            m.h.i(hashMap.size() <= 29, "the size of daysSinceOnsetToInfectiousness exceeds maximum size %d.", 29);
                            Integer[] numArr = new Integer[29];
                            Arrays.fill((Object[]) numArr, (Object) 0);
                            for (Map.Entry entry : hashMap.entrySet()) {
                                int intValue = ((Integer) entry.getKey()).intValue();
                                int intValue2 = ((Integer) entry.getValue()).intValue();
                                m.h.i(Math.abs(intValue) <= 14, "Invalid day since onset %d", Integer.valueOf(intValue));
                                boolean z2 = f.b.a.c.f.b.l.a(intValue2) != null;
                                Integer valueOf = Integer.valueOf(intValue2);
                                m.h.i(z2, "Invalid value of Infectiousness %d", valueOf);
                                numArr[intValue + 14] = valueOf;
                            }
                            List asList = Arrays.asList(numArr);
                            int i11 = iArr[29];
                            boolean z3 = f.b.a.c.f.b.l.a(i11) != null;
                            Integer valueOf2 = Integer.valueOf(i11);
                            m.h.i(z3, "Invalid value of Infectiousness %d", valueOf2);
                            m.h.j(integer != 0, "Invalid reportTypeWhenMissing value");
                            m.h.i(integer >= 0 && integer <= 5, "Invalid value of ReportType %d", Integer.valueOf(integer));
                            m.h.j(asList != null, "Must set daysSinceOnsetToInfectiousness");
                            m.h.j(integer != 0, "Must set reportTypeWhenMissing");
                            if (valueOf2 != null) {
                                z = true;
                            }
                            m.h.j(z, "Must set infectiousnessWhenDaysSinceOnsetMissing");
                            T t6 = (T) new DiagnosisKeysDataMapping(asList, integer, valueOf2.intValue());
                            f.a.a("Created diagnosisKeysDataMapping: " + ((Object) t6));
                            return t6;
                        }
                    }
                    break;
                case 18:
                    return (T) b.this.I();
                case 19:
                    b bVar11 = b.this;
                    return (T) new f.b.a.a.a.w.a(bVar11.B(), bVar11.v());
                case 20:
                    Objects.requireNonNull(b.this.c);
                    return (T) new w();
                case 21:
                    b bVar12 = b.this;
                    i.a.a<i1> t7 = bVar12.t();
                    i.a.a<v0> v = bVar12.v();
                    i.a.a<i0> q = bVar12.q();
                    i.a.a<f.b.a.a.a.o.f0> N = bVar12.N();
                    i.a.a<w> B = bVar12.B();
                    i.a.a<ExecutorService> k3 = bVar12.k();
                    i.a.a<ExecutorService> z4 = bVar12.z();
                    i.a.a aVar7 = bVar12.Z;
                    if (aVar7 == null) {
                        aVar7 = new d(22);
                        bVar12.Z = aVar7;
                    }
                    return (T) new q1(t7, v, q, N, B, k3, z4, aVar7, bVar12.L(), bVar12.P(), bVar12.n());
                case 22:
                    return (T) b.this.H();
                case 23:
                    b bVar13 = b.this;
                    i.a.a aVar8 = bVar13.b0;
                    if (aVar8 == null) {
                        aVar8 = new d(24);
                        bVar13.b0 = aVar8;
                    }
                    i.a.a<i1> t8 = bVar13.t();
                    i.a.a<v0> v2 = bVar13.v();
                    i.a.a aVar9 = bVar13.c0;
                    if (aVar9 == null) {
                        aVar9 = new d(25);
                        bVar13.c0 = aVar9;
                    }
                    i.a.a aVar10 = bVar13.d0;
                    if (aVar10 == null) {
                        aVar10 = new d(26);
                        bVar13.d0 = aVar10;
                    }
                    i.a.a aVar11 = bVar13.e0;
                    if (aVar11 == null) {
                        aVar11 = new d(27);
                        bVar13.e0 = aVar11;
                    }
                    return (T) new r1(aVar8, t8, v2, aVar9, aVar10, aVar11, bVar13.B(), bVar13.k(), bVar13.J(), bVar13.i(), bVar13.n());
                case 24:
                    return (T) new w0(b.this.u());
                case 25:
                    b bVar14 = b.this;
                    f fVar2 = bVar14.m;
                    DailySummariesConfig p2 = bVar14.p();
                    Objects.requireNonNull(fVar2);
                    return (T) new e(p2);
                case 26:
                    return (T) b.this.p();
                case 27:
                    b bVar15 = b.this;
                    f fVar3 = bVar15.m;
                    Context t9 = g.b.a.c.c.c.t(bVar15.b);
                    Objects.requireNonNull(fVar3);
                    return (T) new f.b.a.a.a.x.c(new f.b.a.a.a.x.b[]{new f.b.a.a.a.x.b(t9, 1), new f.b.a.a.a.x.b(t9, 2), new f.b.a.a.a.x.b(t9, 3), new f.b.a.a.a.x.b(t9, 4)});
                case 28:
                    b bVar16 = b.this;
                    i.a.a aVar12 = bVar16.i0;
                    if (aVar12 == null) {
                        aVar12 = new d(29);
                        bVar16.i0 = aVar12;
                    }
                    i.a.a<ExecutorService> k4 = bVar16.k();
                    i.a.a<f.b.a.a.a.d0.m> P = bVar16.P();
                    i.a.a<f.b.a.a.a.i.f0.a> n = bVar16.n();
                    i.a.a<v0> v3 = bVar16.v();
                    i.a.a aVar13 = bVar16.j0;
                    if (aVar13 == null) {
                        aVar13 = new d(30);
                        bVar16.j0 = aVar13;
                    }
                    i.a.a aVar14 = bVar16.k0;
                    if (aVar14 == null) {
                        aVar14 = new d(31);
                        bVar16.k0 = aVar14;
                    }
                    return (T) new f.b.a.a.a.u.s(aVar12, k4, P, n, v3, aVar13, aVar14);
                case 29:
                    b bVar17 = b.this;
                    f.b.a.a.a.u.t.m mVar = bVar17.o;
                    Context t10 = g.b.a.c.c.c.t(bVar17.b);
                    f.b.a.a.a.u.n nVar = new f.b.a.a.a.u.n(bVar17.A(), bVar17.F(), bVar17.G(), bVar17.C());
                    f.b.b.f.a.w l2 = bVar17.l();
                    f.b.a.a.a.u.t.p pVar3 = new f.b.a.a.a.u.t.p(bVar17.b());
                    f.b.a.a.a.u.t.g gVar = new f.b.a.a.a.u.t.g(bVar17.I(), bVar17.s(), bVar17.p(), m.h.T0(bVar17.f2063e));
                    f.b.a.a.a.u.t.o oVar = new f.b.a.a.a.u.t.o(bVar17.b());
                    f.b.a.a.a.u.t.d dVar = new f.b.a.a.a.u.t.d(bVar17.b());
                    f.b.a.a.a.u.t.e eVar = new f.b.a.a.a.u.t.e(bVar17.b());
                    i iVar = new i(bVar17.b());
                    k kVar = new k(bVar17.b());
                    f.b.a.a.a.u.t.f fVar4 = new f.b.a.a.a.u.t.f(bVar17.b());
                    f.b.a.a.a.u.t.j jVar = new f.b.a.a.a.u.t.j(bVar17.b());
                    f.b.a.a.a.u.t.h hVar = new f.b.a.a.a.u.t.h(bVar17.b());
                    f.b.a.a.a.u.t.n nVar2 = new f.b.a.a.a.u.t.n(bVar17.b());
                    Objects.requireNonNull(mVar);
                    f.b.a.a.a.u.t.c cVar = new f.b.a.a.a.u.t.c(mVar, nVar, pVar3, gVar, oVar, dVar, iVar, fVar4, t10, jVar, eVar, kVar, hVar, nVar2, l2);
                    f.b.a.d.a.f0 E = bVar17.E();
                    f.b.a.a.a.u.r rVar2 = bVar17.n;
                    Context t11 = g.b.a.c.c.c.t(bVar17.b);
                    f.b.a.a.a.u.r rVar3 = bVar17.n;
                    Context t12 = g.b.a.c.c.c.t(bVar17.b);
                    Objects.requireNonNull(rVar3);
                    String string3 = t12.getString(R.string.enx_healthAuthorityID);
                    Objects.requireNonNull(string3, "Cannot return null from a non-@Nullable @Provides method");
                    d0.a U0 = m.h.U0(bVar17.n);
                    Objects.requireNonNull(rVar2);
                    f.b.a.d.a.r rVar4 = new f.b.a.d.a.r(t11, string3, U0);
                    Object obj2 = bVar17.h0;
                    if (obj2 instanceof g.c.b) {
                        synchronized (obj2) {
                            obj = bVar17.h0;
                            if (obj instanceof g.c.b) {
                                obj = bVar17.p.a(bVar17.w());
                                g.c.a.a(bVar17.h0, obj);
                                bVar17.h0 = obj;
                            }
                        }
                        obj2 = obj;
                    }
                    return (T) new g0(cVar, E, new f.b.a.d.a.c0(rVar4, (f.b.c.k.f) obj2, m.h.U0(bVar17.n)), bVar17.D(), m.h.U0(bVar17.n), bVar17.m());
                case 30:
                    return (T) b.this.C();
                case 31:
                    return (T) Integer.valueOf(b.this.m());
                case 32:
                    b bVar18 = b.this;
                    i.a.a<f.b.a.a.a.o.f0> N2 = bVar18.N();
                    i.a.a<ExecutorService> k5 = bVar18.k();
                    i.a.a<ExecutorService> z5 = bVar18.z();
                    i.a.a aVar15 = bVar18.Z;
                    if (aVar15 == null) {
                        aVar15 = new d(22);
                        bVar18.Z = aVar15;
                    }
                    i.a.a<SecureRandom> L = bVar18.L();
                    i.a.a<f.b.a.a.a.d0.m> P2 = bVar18.P();
                    i.a.a aVar16 = bVar18.m0;
                    if (aVar16 == null) {
                        aVar16 = new d(33);
                        bVar18.m0 = aVar16;
                    }
                    return (T) new f.b.a.a.a.o.g0(N2, k5, z5, aVar15, L, P2, aVar16);
                case 33:
                    return (T) b.this.O();
                case 34:
                    return (T) b.this.r();
                case 35:
                    return (T) new m1(b.this.b());
                case 36:
                    return (T) b.this.D();
                case 37:
                    return (T) g.b.a.c.c.c.t(b.this.b);
                case 38:
                    return (T) new f1(b.this.u());
                case 39:
                    b bVar19 = b.this;
                    q qVar = bVar19.c;
                    TelephonyManager M = bVar19.M();
                    Context t13 = g.b.a.c.c.c.t(bVar19.b);
                    Objects.requireNonNull(qVar);
                    return (T) new c0(M, t13.getResources());
                case 40:
                    return (T) new f.b.a.a.a.r.b(g.b.a.c.c.c.t(b.this.b));
                default:
                    throw new AssertionError(this.a);
            }
        }
    }

    public b(g.b.a.c.d.a aVar, q qVar, v vVar, p pVar, s sVar, j1 j1Var, f.b.a.a.a.y.e eVar, f.b.a.a.a.p.v vVar2, f.b.a.a.a.u.t.m mVar, f.b.a.a.a.u.m mVar2, f.b.a.a.a.u.r rVar, f.b.a.a.a.r.e eVar2, f.b.a.a.a.i.f0.b bVar, f fVar, y0 y0Var, f.b.a.a.a.p.w wVar, f.b.a.a.a.o.i0 i0Var, f.b.a.a.a.d0.f fVar2, a aVar2) {
        this.a = sVar;
        this.b = aVar;
        this.c = qVar;
        this.f2062d = vVar;
        this.f2063e = bVar;
        this.f2064f = eVar;
        this.f2065g = j1Var;
        this.f2066h = wVar;
        this.f2067i = vVar2;
        this.f2068j = i0Var;
        this.f2069k = eVar2;
        this.f2070l = pVar;
        this.m = fVar;
        this.n = rVar;
        this.o = mVar;
        this.p = mVar2;
        this.q = fVar2;
        this.r = y0Var;
    }

    public static i.a.a g(b bVar) {
        i.a.a<a0> aVar = bVar.q0;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(36);
        bVar.q0 = dVar;
        return dVar;
    }

    public final f.b.b.f.a.w A() {
        Object obj;
        Object obj2 = this.K;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.K;
                if (obj instanceof g.c.b) {
                    Objects.requireNonNull(this.a);
                    obj = f.b.a.c.b.o.b.Z0(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors() - 2), s.a("Lightweight", 0, s.a)));
                    Objects.requireNonNull(obj, "Cannot return null from a non-@Nullable @Provides method");
                    g.c.a.a(this.K, obj);
                    this.K = obj;
                }
            }
            obj2 = obj;
        }
        return (f.b.b.f.a.w) obj2;
    }

    public final i.a.a<w> B() {
        i.a.a<w> aVar = this.X;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(20);
        this.X = dVar;
        return dVar;
    }

    public final l<b0> C() {
        f.b.a.a.a.u.r rVar = this.n;
        new u(g.b.a.c.c.c.t(this.b));
        f.b.a.a.a.p.s x2 = x();
        Objects.requireNonNull(rVar);
        return new f.b.b.a.o(new f.b.a.a.a.u.p(rVar, x2));
    }

    public final a0 D() {
        f.b.a.a.a.u.r rVar = this.n;
        v0 b2 = b();
        Objects.requireNonNull(rVar);
        return new f.b.a.a.a.u.o(rVar, b2);
    }

    public final f.b.a.d.a.f0 E() {
        f.b.a.a.a.u.r rVar = this.n;
        Uri F2 = F();
        l<b0> C2 = C();
        d0.a U0 = m.h.U0(this.n);
        Objects.requireNonNull(rVar);
        return new f.b.a.d.a.s(F2, C2, U0);
    }

    public final Uri F() {
        f.b.a.a.a.u.r rVar = this.n;
        Context t2 = g.b.a.c.c.c.t(this.b);
        Objects.requireNonNull(rVar);
        Uri parse = Uri.parse(t2.getString(R.string.enx_enpaRemoteConfigURL));
        Objects.requireNonNull(parse, "Cannot return null from a non-@Nullable @Provides method");
        return parse;
    }

    public final g G() {
        Object obj;
        Object obj2 = this.J;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.J;
                if (obj instanceof g.c.b) {
                    Objects.requireNonNull(this.f2069k);
                    f.a.b.o oVar = new f.a.b.o(new f.a.b.w.h(), new f.a.b.w.b(new f.a.b.w.e()));
                    oVar.b();
                    f.b.a.a.a.r.f fVar = new f.b.a.a.a.r.f(oVar);
                    g.c.a.a(this.J, fVar);
                    this.J = fVar;
                    obj = fVar;
                }
            }
            obj2 = obj;
        }
        return (g) obj2;
    }

    public final x H() {
        Object obj;
        Object obj2 = this.z;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.z;
                if (obj instanceof g.c.b) {
                    Objects.requireNonNull(this.a);
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4, s.a("Scheduled", 10, s.b));
                    obj = newScheduledThreadPool instanceof x ? (x) newScheduledThreadPool : new f.b.b.f.a.a0(newScheduledThreadPool);
                    Objects.requireNonNull(obj, "Cannot return null from a non-@Nullable @Provides method");
                    g.c.a.a(this.z, obj);
                    this.z = obj;
                }
            }
            obj2 = obj;
        }
        return (x) obj2;
    }

    public final ScheduledExecutorService I() {
        Object obj;
        Object obj2 = this.A;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.A;
                if (obj instanceof g.c.b) {
                    s sVar = this.a;
                    x H2 = H();
                    Objects.requireNonNull(sVar);
                    Objects.requireNonNull(H2, "Cannot return null from a non-@Nullable @Provides method");
                    g.c.a.a(this.A, H2);
                    this.A = H2;
                    obj = H2;
                }
            }
            obj2 = obj;
        }
        return (ScheduledExecutorService) obj2;
    }

    public final i.a.a<ScheduledExecutorService> J() {
        i.a.a<ScheduledExecutorService> aVar = this.V;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(18);
        this.V = dVar;
        return dVar;
    }

    public final SecureRandom K() {
        Object obj;
        Object obj2 = this.O;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.O;
                if (obj instanceof g.c.b) {
                    Objects.requireNonNull(this.c);
                    obj = new SecureRandom();
                    g.c.a.a(this.O, obj);
                    this.O = obj;
                }
            }
            obj2 = obj;
        }
        return (SecureRandom) obj2;
    }

    public final i.a.a<SecureRandom> L() {
        i.a.a<SecureRandom> aVar = this.P;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(12);
        this.P = dVar;
        return dVar;
    }

    public final TelephonyManager M() {
        q qVar = this.c;
        Context t2 = g.b.a.c.c.c.t(this.b);
        Objects.requireNonNull(qVar);
        TelephonyManager telephonyManager = (TelephonyManager) t2.getSystemService("phone");
        Objects.requireNonNull(telephonyManager, "Cannot return null from a non-@Nullable @Provides method");
        return telephonyManager;
    }

    public final i.a.a<f.b.a.a.a.o.f0> N() {
        i.a.a<f.b.a.a.a.o.f0> aVar = this.M;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(10);
        this.M = dVar;
        return dVar;
    }

    public final e.z.t O() {
        f.b.a.a.a.d0.f fVar = this.q;
        Context t2 = g.b.a.c.c.c.t(this.b);
        Objects.requireNonNull(fVar);
        e.z.x.l f2 = e.z.x.l.f(t2);
        Objects.requireNonNull(f2, "Cannot return null from a non-@Nullable @Provides method");
        return f2;
    }

    public final i.a.a<f.b.a.a.a.d0.m> P() {
        i.a.a<f.b.a.a.a.d0.m> aVar = this.D;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(3);
        this.D = dVar;
        return dVar;
    }

    @Override // f.b.a.a.a.i.t
    public void a(ExposureNotificationDismissedReceiver exposureNotificationDismissedReceiver) {
        exposureNotificationDismissedReceiver.c = b();
        exposureNotificationDismissedReceiver.f329d = m.h.T0(this.f2063e);
    }

    @Override // com.google.android.apps.exposurenotification.restore.ExposureNotificationBackupAgent.a
    public v0 b() {
        y0 y0Var = this.r;
        Context t2 = g.b.a.c.c.c.t(this.b);
        f.b.a.a.a.i.f0.a T0 = m.h.T0(this.f2063e);
        SecureRandom K2 = K();
        Objects.requireNonNull(y0Var);
        return new v0(t2, T0, K2);
    }

    @Override // f.b.a.a.a.q.p1
    public void c(SmsVerificationBroadcastReceiver smsVerificationBroadcastReceiver) {
        smsVerificationBroadcastReceiver.c = O();
    }

    @Override // f.b.a.a.a.q.h1
    public void d(ExposureNotificationBroadcastReceiver exposureNotificationBroadcastReceiver) {
        exposureNotificationBroadcastReceiver.c = O();
        Objects.requireNonNull(this.c);
        exposureNotificationBroadcastReceiver.f365d = new w();
        exposureNotificationBroadcastReceiver.f366e = b();
    }

    @Override // f.b.a.a.a.c
    public void e(ExposureNotificationApplication exposureNotificationApplication) {
        f.b.a.c.b.o.b.y(9, "expectedSize");
        d.a aVar = new d.a(9);
        i.a.a aVar2 = this.F;
        if (aVar2 == null) {
            aVar2 = new d(0);
            this.F = aVar2;
        }
        aVar.b("com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker", aVar2);
        i.a.a aVar3 = this.G;
        if (aVar3 == null) {
            aVar3 = new d(6);
            this.G = aVar3;
        }
        aVar.b("com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker", aVar3);
        i.a.a aVar4 = this.R;
        if (aVar4 == null) {
            aVar4 = new d(7);
            this.R = aVar4;
        }
        aVar.b("com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker", aVar4);
        i.a.a aVar5 = this.W;
        if (aVar5 == null) {
            aVar5 = new d(14);
            this.W = aVar5;
        }
        aVar.b("com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker", aVar5);
        i.a.a aVar6 = this.Y;
        if (aVar6 == null) {
            aVar6 = new d(19);
            this.Y = aVar6;
        }
        aVar.b("com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker", aVar6);
        i.a.a aVar7 = this.a0;
        if (aVar7 == null) {
            aVar7 = new d(21);
            this.a0 = aVar7;
        }
        aVar.b("com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker", aVar7);
        i.a.a aVar8 = this.f0;
        if (aVar8 == null) {
            aVar8 = new d(23);
            this.f0 = aVar8;
        }
        aVar.b("com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker", aVar8);
        i.a.a aVar9 = this.l0;
        if (aVar9 == null) {
            aVar9 = new d(28);
            this.l0 = aVar9;
        }
        aVar.b("com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker", aVar9);
        i.a.a aVar10 = this.n0;
        if (aVar10 == null) {
            aVar10 = new d(32);
            this.n0 = aVar10;
        }
        aVar.b("com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker", aVar10);
        exposureNotificationApplication.c = new e.n.b.a(aVar.a());
        exposureNotificationApplication.workManager = O();
        f.b.a.a.a.d0.f fVar = this.q;
        Context t2 = g.b.a.c.c.c.t(this.b);
        e.z.t O2 = O();
        f.b.b.f.a.w A2 = A();
        a0 D2 = D();
        f.b.a.d.a.f0 E2 = E();
        Objects.requireNonNull(fVar);
        exposureNotificationApplication.f325d = new f.b.a.a.a.d0.l(O2, A2, l.b.a.d.h((long) t2.getResources().getInteger(R.integer.enx_tekPublishInterval)), D2, E2);
        f.b.a.a.a.p.v vVar = this.f2067i;
        r h2 = h();
        Objects.requireNonNull(vVar);
        exposureNotificationApplication.f326e = new ApplicationObserver(h2);
        exposureNotificationApplication.f327f = f.b.b.a.a.b;
        exposureNotificationApplication.f328g = j();
        exposureNotificationApplication.firebaseApp = w();
    }

    @Override // g.b.a.c.c.b.AbstractC0139b
    public g.b.a.c.a.b f() {
        return new C0067b(null);
    }

    public final r h() {
        Object obj;
        Object obj2 = this.B;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.B;
                if (obj instanceof g.c.b) {
                    f.b.a.a.a.p.v vVar = this.f2067i;
                    new u(g.b.a.c.c.c.t(this.b));
                    f.b.a.a.a.p.s x2 = x();
                    synchronized (vVar) {
                    }
                    g.c.a.a(this.B, x2);
                    this.B = x2;
                    obj = x2;
                }
            }
            obj2 = obj;
        }
        return (r) obj2;
    }

    public final i.a.a<r> i() {
        i.a.a<r> aVar = this.E;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(5);
        this.E = dVar;
        return dVar;
    }

    public final ExecutorService j() {
        Object obj;
        Object obj2 = this.t;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.t;
                if (obj instanceof g.c.b) {
                    s sVar = this.a;
                    f.b.b.f.a.w l2 = l();
                    Objects.requireNonNull(sVar);
                    Objects.requireNonNull(l2, "Cannot return null from a non-@Nullable @Provides method");
                    g.c.a.a(this.t, l2);
                    this.t = l2;
                    obj = l2;
                }
            }
            obj2 = obj;
        }
        return (ExecutorService) obj2;
    }

    public final i.a.a<ExecutorService> k() {
        i.a.a<ExecutorService> aVar = this.u;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(1);
        this.u = dVar;
        return dVar;
    }

    public final f.b.b.f.a.w l() {
        Object obj;
        Object obj2 = this.s;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.s;
                if (obj instanceof g.c.b) {
                    Objects.requireNonNull(this.a);
                    obj = f.b.a.c.b.o.b.Z0(Executors.newFixedThreadPool(4, s.a("Background", 10, s.b)));
                    Objects.requireNonNull(obj, "Cannot return null from a non-@Nullable @Provides method");
                    g.c.a.a(this.s, obj);
                    this.s = obj;
                }
            }
            obj2 = obj;
        }
        return (f.b.b.f.a.w) obj2;
    }

    public final int m() {
        f.b.a.a.a.u.t.m mVar = this.o;
        v0 b2 = b();
        Objects.requireNonNull(mVar);
        if (!b2.a.contains("ExposureNotificationSharedPreferences.BIWEEKLY_METRICS_UPLOAD_DAY")) {
            b2.a.edit().putInt("ExposureNotificationSharedPreferences.BIWEEKLY_METRICS_UPLOAD_DAY", b2.c.nextInt(14)).commit();
        }
        return b2.a.getInt("ExposureNotificationSharedPreferences.BIWEEKLY_METRICS_UPLOAD_DAY", 0);
    }

    public final i.a.a<f.b.a.a.a.i.f0.a> n() {
        i.a.a<f.b.a.a.a.i.f0.a> aVar = this.Q;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(13);
        this.Q = dVar;
        return dVar;
    }

    public final f.b.a.a.a.y.d o() {
        f.b.a.a.a.y.f fVar = new f.b.a.a.a.y.f(M());
        f.b.a.a.a.b0.u uVar = new f.b.a.a.a.b0.u(u(), m.h.T0(this.f2063e));
        f.b.a.a.a.i.f0.a T0 = m.h.T0(this.f2063e);
        f.b.a.a.a.y.e eVar = this.f2064f;
        Context t2 = g.b.a.c.c.c.t(this.b);
        Objects.requireNonNull(eVar);
        if (t2.getString(R.string.enx_regionIdentifier).length() >= 2) {
            String substring = t2.getString(R.string.enx_regionIdentifier).substring(0, 2);
            Objects.requireNonNull(substring, "Cannot return null from a non-@Nullable @Provides method");
            return new f.b.a.a.a.y.d(fVar, uVar, T0, substring);
        }
        throw new RuntimeException("Failed to determine user's home region from configuration.");
    }

    public final DailySummariesConfig p() {
        f fVar = this.m;
        Context t2 = g.b.a.c.c.c.t(this.b);
        Objects.requireNonNull(fVar);
        Resources resources = t2.getResources();
        DailySummariesConfig.a aVar = new DailySummariesConfig.a();
        boolean z2 = false;
        List asList = Arrays.asList(Integer.valueOf(resources.getInteger(R.integer.enx_attenuationImmediateNearThreshold)), Integer.valueOf(resources.getInteger(R.integer.enx_attenuationNearMedThreshold)), Integer.valueOf(resources.getInteger(R.integer.enx_attenuationMedFarThreshold)));
        List<Double> asList2 = Arrays.asList(Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationImmediateWeight)) * 0.01d), Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationNearWeight)) * 0.01d), Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationMedWeight)) * 0.01d), Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationOtherWeight)) * 0.01d));
        DailySummariesConfig.a.c(asList, 3, "attenuationBucketThresholdDb");
        for (int i2 = 0; i2 < asList.size(); i2++) {
            m.h.j(((Integer) asList.get(i2)).intValue() >= 0 && ((Integer) asList.get(i2)).intValue() <= 255, "Element of attenuationBucketThreshold must between 0 ~ 255");
            if (i2 != 0) {
                int i3 = i2 - 1;
                m.h.j(((Integer) asList.get(i3)).intValue() < ((Integer) asList.get(i2)).intValue(), String.format(Locale.ENGLISH, "attenuationBucketThresholdDb of index %d must be larger than index %d", Integer.valueOf(i2), Integer.valueOf(i3)));
            }
        }
        aVar.c = new ArrayList(asList);
        DailySummariesConfig.a.c(asList2, 4, "attenuationBucketWeights");
        for (Double d2 : asList2) {
            DailySummariesConfig.a.d(d2.doubleValue(), "attenuationBucketWeights");
        }
        aVar.f474d = new ArrayList(asList2);
        aVar.a(1, ((double) resources.getInteger(R.integer.enx_infectiousnessStandardWeight)) * 0.01d);
        aVar.a(2, ((double) resources.getInteger(R.integer.enx_infectiousnessHighWeight)) * 0.01d);
        aVar.b(1, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedTestWeight)) * 0.01d);
        aVar.b(2, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedClinicalDiagnosisWeight)) * 0.01d);
        aVar.b(3, ((double) resources.getInteger(R.integer.enx_reportTypeSelfReportWeight)) * 0.01d);
        int integer = resources.getInteger(R.integer.enx_daysSinceExposureThreshold);
        m.h.j(integer >= 0, "daysSinceExposureThreshold must not be negative");
        aVar.f475e = integer;
        m.h.j(aVar.c != null, "Must set attenuationBucketThresholdDb");
        if (aVar.f474d != null) {
            z2 = true;
        }
        m.h.j(z2, "Must set attenuationBucketWeights");
        DailySummariesConfig dailySummariesConfig = new DailySummariesConfig(Arrays.asList(aVar.a), Arrays.asList(aVar.b), aVar.c, aVar.f474d, aVar.f475e, 0.0d);
        f.a.a("Created dailySummaryConfig: " + dailySummariesConfig);
        return dailySummariesConfig;
    }

    public final i.a.a<i0> q() {
        i.a.a<i0> aVar = this.I;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(9);
        this.I = dVar;
        return dVar;
    }

    public final r0 r() {
        return new r0(u());
    }

    public final i1 s() {
        Object obj;
        Object obj2 = this.C;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.C;
                if (obj instanceof g.c.b) {
                    j1 j1Var = this.f2065g;
                    Context t2 = g.b.a.c.c.c.t(this.b);
                    Objects.requireNonNull(j1Var);
                    m.h.p(t2, "Context must not be null");
                    f.b.a.c.e.c.v vVar = new f.b.a.c.e.c.v(t2);
                    r h2 = h();
                    Objects.requireNonNull(j1Var);
                    obj = new i1(vVar, h2);
                    g.c.a.a(this.C, obj);
                    this.C = obj;
                }
            }
            obj2 = obj;
        }
        return (i1) obj2;
    }

    public final i.a.a<i1> t() {
        i.a.a<i1> aVar = this.x;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(4);
        this.x = dVar;
        return dVar;
    }

    public final ExposureNotificationDatabase u() {
        Object obj;
        Object obj2 = this.v;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.v;
                if (obj instanceof g.c.b) {
                    obj = m.h.R0(this.f2062d, g.b.a.c.c.c.t(this.b));
                    g.c.a.a(this.v, obj);
                    this.v = obj;
                }
            }
            obj2 = obj;
        }
        return (ExposureNotificationDatabase) obj2;
    }

    public final i.a.a<v0> v() {
        i.a.a<v0> aVar = this.H;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(8);
        this.H = dVar;
        return dVar;
    }

    public final f.b.c.a w() {
        Object obj;
        Object obj2 = this.g0;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.g0;
                if (obj instanceof g.c.b) {
                    f.b.a.a.a.u.m mVar = this.p;
                    Context t2 = g.b.a.c.c.c.t(this.b);
                    a0 D2 = D();
                    Objects.requireNonNull(mVar);
                    obj = !((f.b.a.a.a.u.o) D2).a() ? null : f.b.c.a.d(t2);
                    g.c.a.a(this.g0, obj);
                    this.g0 = obj;
                }
            }
            obj2 = obj;
        }
        return (f.b.c.a) obj2;
    }

    public final f.b.a.a.a.p.s x() {
        Object obj;
        Context t2 = g.b.a.c.c.c.t(this.b);
        v0 b2 = b();
        i.a.a<i1> t3 = t();
        Object obj2 = g.c.a.c;
        g.a aVar = t3 instanceof g.a ? (g.a) t3 : new g.c.a(t3);
        Object obj3 = this.y;
        if (obj3 instanceof g.c.b) {
            synchronized (obj3) {
                obj = this.y;
                if (obj instanceof g.c.b) {
                    obj = m.h.S0(this.f2066h, g.b.a.c.c.c.t(this.b));
                    g.c.a.a(this.y, obj);
                    this.y = obj;
                }
            }
            obj3 = obj;
        }
        return new f.b.a.a.a.p.s(t2, b2, aVar, (f.b.a.b.f) obj3, new f.b.a.a.a.b0.h(u()), m.h.T0(this.f2063e), new f.b.a.a.a.b0.j1(u()), l(), I());
    }

    public final ExecutorService y() {
        Object obj;
        Object obj2 = this.L;
        if (obj2 instanceof g.c.b) {
            synchronized (obj2) {
                obj = this.L;
                if (obj instanceof g.c.b) {
                    s sVar = this.a;
                    f.b.b.f.a.w A2 = A();
                    Objects.requireNonNull(sVar);
                    Objects.requireNonNull(A2, "Cannot return null from a non-@Nullable @Provides method");
                    g.c.a.a(this.L, A2);
                    this.L = A2;
                    obj = A2;
                }
            }
            obj2 = obj;
        }
        return (ExecutorService) obj2;
    }

    public final i.a.a<ExecutorService> z() {
        i.a.a<ExecutorService> aVar = this.N;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(11);
        this.N = dVar;
        return dVar;
    }
}
