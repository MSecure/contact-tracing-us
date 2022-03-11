package f.b.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.activity.ComponentActivity;
import com.google.android.apps.exposurenotification.ExposureNotificationApplication;
import com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver;
import com.google.android.apps.exposurenotification.home.ExposureNotificationActivity;
import com.google.android.apps.exposurenotification.nearby.ExposureNotificationBroadcastReceiver;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.privateanalytics.PrioJni;
import com.google.android.apps.exposurenotification.settings.AgencyActivity;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsActivity;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import com.google.android.apps.exposurenotification.settings.LegalTermsActivity;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsActivity;
import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import e.m.a.l;
import e.p.b0;
import f.b.a.a.a.h.i;
import f.b.a.a.a.h.k;
import f.b.a.a.a.h.o;
import f.b.a.a.a.j.h;
import f.b.a.a.a.l.h0;
import f.b.a.a.a.l.l0;
import f.b.a.a.a.l.p0;
import f.b.a.a.a.l.s0;
import f.b.a.a.a.m.n;
import f.b.a.a.a.n.v;
import f.b.a.a.a.n.w;
import f.b.a.a.a.n.y;
import f.b.a.a.a.o.p;
import f.b.a.a.a.o.q;
import f.b.a.a.a.o.r;
import f.b.a.a.a.o.s;
import f.b.a.a.a.p.d0;
import f.b.a.a.a.p.f0;
import f.b.a.a.a.p.g0;
import f.b.a.a.a.p.i0;
import f.b.a.a.a.p.j0;
import f.b.a.a.a.p.k0;
import f.b.a.a.a.q.g;
import f.b.a.a.a.r.a4;
import f.b.a.a.a.r.c4;
import f.b.a.a.a.r.e4;
import f.b.a.a.a.r.g4;
import f.b.a.a.a.r.i4;
import f.b.a.a.a.r.k4;
import f.b.a.a.a.r.m4;
import f.b.a.a.a.r.q3;
import f.b.a.a.a.r.t3;
import f.b.a.a.a.r.v3;
import f.b.a.a.a.r.x3;
import f.b.a.a.a.s.e0;
import f.b.a.a.a.t.a0;
import f.b.a.a.a.t.c0;
import f.b.a.a.a.t.z;
import f.b.a.a.a.v.e;
import f.b.a.a.a.v.f;
import f.b.a.a.a.y.m0;
import f.b.a.a.a.y.q0;
import f.b.a.a.a.y.r0;
import f.b.a.a.a.y.t;
import f.b.a.a.a.y.t0;
import f.b.a.a.a.y.x0;
import f.b.a.a.a.z.m;
import f.b.b.b.b;
import f.b.b.b.d;
import f.b.b.b.j;
import f.b.b.f.a.x;
import g.a.a.c.c.b;
import gov.md.covid19.exposurenotifications.R;
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

public final class a extends f {
    public volatile Object A = new g.b.b();
    public volatile Object B = new g.b.b();
    public volatile i.a.a<m> C;
    public volatile i.a.a<p> D;
    public volatile i.a.a<f.b.a.a.a.w.c> E;
    public volatile i.a.a<r> F;
    public volatile Object G = new g.b.b();
    public volatile Object H = new g.b.b();
    public volatile Object I = new g.b.b();
    public volatile i.a.a<n> J;
    public volatile i.a.a<f0> K;
    public volatile i.a.a<d0> L;
    public volatile i.a.a<DiagnosisKeysDataMapping> M;
    public volatile i.a.a<ScheduledExecutorService> N;
    public volatile i.a.a<j0> O;
    public volatile i.a.a<r0> P;
    public volatile i.a.a<q0> Q;
    public volatile i.a.a<e> R;
    public volatile i.a.a<DailySummariesConfig> S;
    public volatile i.a.a<f.b.a.a.a.v.c> T;
    public volatile i.a.a<o> U;
    public volatile i.a.a<ExecutorService> V;
    public volatile i.a.a<f.b.a.a.a.h.s.a> W;
    public volatile i.a.a<k0> X;
    public volatile Object Y = new g.b.b();
    public volatile Object Z = new g.b.b();
    public final k a;
    public volatile Object a0 = new g.b.b();
    public final g.a.a.c.d.a b;
    public volatile Object b0 = new g.b.b();
    public final i c;
    public volatile i.a.a<a0> c0;

    /* renamed from: d  reason: collision with root package name */
    public final t f2076d;
    public volatile i.a.a<c0> d0;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.a.a.a.h.s.b f2077e;
    public volatile i.a.a<v> e0;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.w.e f2078f;
    public volatile i.a.a<x> f0;

    /* renamed from: g  reason: collision with root package name */
    public final g0 f2079g;
    public volatile i.a.a<SecureRandom> g0;

    /* renamed from: h  reason: collision with root package name */
    public final t0 f2080h;
    public volatile i.a.a<w> h0;

    /* renamed from: i  reason: collision with root package name */
    public final f.b.a.a.a.o.t f2081i;
    public volatile i.a.a<m0> i0;

    /* renamed from: j  reason: collision with root package name */
    public final s f2082j;
    public volatile i.a.a<i0> j0;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.a.a.q.e f2083k;
    public volatile i.a.a<e.c0.t> k0;

    /* renamed from: l  reason: collision with root package name */
    public final f.b.a.a.a.m.p f2084l;
    public volatile i.a.a<Context> l0;
    public final f m;
    public final z n;
    public final f.b.a.a.a.t.w o;
    public final f.b.a.a.a.t.t p;
    public final y q;
    public final f.b.a.a.a.z.f r;
    public volatile Object s = new g.b.b();
    public volatile Object t = new g.b.b();
    public volatile i.a.a<ExecutorService> u;
    public volatile Object v = new g.b.b();
    public volatile i.a.a<f.b.a.a.a.w.d> w;
    public volatile Object x = new g.b.b();
    public volatile Object y = new g.b.b();
    public volatile Object z = new g.b.b();

    public final class b implements g.a.a.c.a.b {
        public b(C0068a aVar) {
        }
    }

    public final class c extends d {
        public volatile Object a = new g.b.b();

        /* renamed from: f.b.a.a.a.a$c$a  reason: collision with other inner class name */
        public final class C0069a implements g.a.a.c.a.a {
            public Activity a;

            public C0069a(C0068a aVar) {
            }
        }

        public final class b extends c {
            public final Activity a;
            public volatile i.a.a<f.b.a.a.a.x.g0> b;
            public volatile i.a.a<f.b.a.a.a.k.p> c;

            /* renamed from: d  reason: collision with root package name */
            public volatile i.a.a<h0> f2085d;

            /* renamed from: e  reason: collision with root package name */
            public volatile i.a.a<f.b.a.a.a.y.d0> f2086e;

            /* renamed from: f  reason: collision with root package name */
            public volatile i.a.a<t3> f2087f;

            /* renamed from: g  reason: collision with root package name */
            public volatile i.a.a<e0> f2088g;

            /* renamed from: h  reason: collision with root package name */
            public volatile i.a.a<f.b.a.a.a.x.q0> f2089h;

            /* renamed from: i  reason: collision with root package name */
            public volatile i.a.a<f.b.a.a.a.q.b> f2090i;

            /* renamed from: j  reason: collision with root package name */
            public volatile i.a.a<m4> f2091j;

            /* renamed from: k  reason: collision with root package name */
            public volatile i.a.a<s0> f2092k;

            /* renamed from: f.b.a.a.a.a$c$b$a  reason: collision with other inner class name */
            public final class C0070a implements g.a.a.c.a.c {
                public l a;

                public C0070a(C0068a aVar) {
                }
            }

            /* renamed from: f.b.a.a.a.a$c$b$b  reason: collision with other inner class name */
            public final class C0071b extends e {
                public final l a;

                public C0071b(l lVar, C0068a aVar) {
                    this.a = lVar;
                }

                @Override // f.b.a.a.a.j.o
                public void a(f.b.a.a.a.j.n nVar) {
                }

                @Override // f.b.a.a.a.r.w3
                public void b(v3 v3Var) {
                }

                @Override // g.a.a.c.b.b
                public Set<b0.b> c() {
                    l lVar = this.a;
                    Application application = (Application) a.this.b.a.getApplicationContext();
                    Objects.requireNonNull(application, "Cannot return null from a non-@Nullable @Provides method");
                    Map<String, i.a.a<e.n.a.b<? extends e.p.a0>>> j2 = b.this.j();
                    Bundle bundle = lVar.f1632g;
                    e.n.a.a aVar = new e.n.a.a(lVar, bundle, new e.p.v(application, lVar, bundle), j2);
                    int i2 = f.b.b.b.e.f2977d;
                    return new j(aVar);
                }

                @Override // f.b.a.a.a.j.i
                public void d(h hVar) {
                }

                @Override // f.b.a.a.a.s.d0
                public void e(f.b.a.a.a.s.c0 c0Var) {
                }

                @Override // f.b.a.a.a.r.h4
                public void f(g4 g4Var) {
                }

                @Override // f.b.a.a.a.k.o
                public void g(f.b.a.a.a.k.n nVar) {
                }

                @Override // f.b.a.a.a.l.n0
                public void h(l0 l0Var) {
                }

                @Override // f.b.a.a.a.s.b0
                public void i(f.b.a.a.a.s.a0 a0Var) {
                }

                @Override // f.b.a.a.a.r.b4
                public void j(a4 a4Var) {
                }

                @Override // f.b.a.a.a.x.s0
                public void k(f.b.a.a.a.x.r0 r0Var) {
                }

                @Override // f.b.a.a.a.l.q0
                public void l(p0 p0Var) {
                    p0Var.a0 = m.h.O0(a.this.f2077e);
                }

                @Override // f.b.a.a.a.r.f4
                public void m(e4 e4Var) {
                    e4Var.c0 = new f.b.a.a.a.q.b(f.b.a.c.b.o.b.x1(a.this.b));
                }

                @Override // f.b.a.a.a.r.y3
                public void n(x3 x3Var) {
                }

                @Override // f.b.a.a.a.r.d4
                public void o(c4 c4Var) {
                    c4Var.a0 = m.h.O0(a.this.f2077e);
                }

                @Override // f.b.a.a.a.j.q
                public void p(f.b.a.a.a.j.p pVar) {
                }

                @Override // f.b.a.a.a.r.r3
                public void q(q3 q3Var) {
                }

                @Override // f.b.a.a.a.r.j4
                public void r(i4 i4Var) {
                }

                @Override // f.b.a.a.a.r.l4
                public void s(k4 k4Var) {
                }

                @Override // f.b.a.a.a.s.z
                public void t(f.b.a.a.a.s.y yVar) {
                }
            }

            /* renamed from: f.b.a.a.a.a$c$b$c  reason: collision with other inner class name */
            public final class C0072c<T> implements i.a.a<T> {
                public final int a;

                public C0072c(int i2) {
                    this.a = i2;
                }

                @Override // i.a.a
                public T get() {
                    switch (this.a) {
                        case 0:
                            return (T) new f.b.a.a.a.x.g0(a.this.r());
                        case 1:
                            b bVar = b.this;
                            i.a.a<q0> r = a.this.r();
                            a aVar = a.this;
                            i.a.a aVar2 = aVar.i0;
                            if (aVar2 == null) {
                                aVar2 = new d(27);
                                aVar.i0 = aVar2;
                            }
                            return (T) new f.b.a.a.a.k.p(r, aVar2);
                        case 2:
                            b bVar2 = b.this;
                            i.a.a<q0> r2 = a.this.r();
                            i.a.a<f0> o = a.this.o();
                            i.a.a<p> f2 = a.this.f();
                            a aVar3 = a.this;
                            i.a.a aVar4 = aVar3.j0;
                            if (aVar4 == null) {
                                aVar4 = new d(28);
                                aVar3.j0 = aVar4;
                            }
                            return (T) new h0(r2, o, f2, aVar4, a.this.j());
                        case 3:
                            b bVar3 = b.this;
                            i.a.a aVar5 = bVar3.f2086e;
                            if (aVar5 == null) {
                                aVar5 = new C0072c(4);
                                bVar3.f2086e = aVar5;
                            }
                            return (T) new t3(aVar5, a.this.v());
                        case 4:
                            b bVar4 = b.this;
                            return (T) new f.b.a.a.a.y.d0(a.this.p(), a.this.g(), m.h.O0(a.this.f2077e));
                        case 5:
                            b bVar5 = b.this;
                            i.a.a<q0> r3 = a.this.r();
                            a aVar6 = a.this;
                            i.a.a aVar7 = aVar6.k0;
                            if (aVar7 == null) {
                                aVar7 = new d(29);
                                aVar6.k0 = aVar7;
                            }
                            return (T) new e0(r3, aVar7);
                        case 6:
                            return (T) new f.b.a.a.a.x.q0(a.this.r());
                        case 7:
                            b bVar6 = b.this;
                            a aVar8 = a.this;
                            i.a.a aVar9 = aVar8.l0;
                            if (aVar9 == null) {
                                aVar9 = new d(30);
                                aVar8.l0 = aVar9;
                            }
                            a aVar10 = a.this;
                            i.a.a aVar11 = aVar10.e0;
                            if (aVar11 == null) {
                                aVar11 = new d(24);
                                aVar10.e0 = aVar11;
                            }
                            i.a.a aVar12 = bVar6.f2086e;
                            if (aVar12 == null) {
                                aVar12 = new C0072c(4);
                                bVar6.f2086e = aVar12;
                            }
                            i.a.a<f0> o2 = a.this.o();
                            i.a.a<q0> r4 = a.this.r();
                            i.a.a<f.b.a.a.a.h.s.a> j2 = a.this.j();
                            i.a.a aVar13 = bVar6.f2090i;
                            if (aVar13 == null) {
                                aVar13 = new C0072c(8);
                                bVar6.f2090i = aVar13;
                            }
                            return (T) new m4(aVar9, aVar11, aVar12, o2, r4, j2, aVar13, a.this.h(), a.this.v(), a.this.B());
                        case 8:
                            return (T) new f.b.a.a.a.q.b(f.b.a.c.b.o.b.x1(a.this.b));
                        case 9:
                            return (T) new s0(a.this.r());
                        default:
                            throw new AssertionError(this.a);
                    }
                }
            }

            public b(Activity activity, C0068a aVar) {
                this.a = activity;
            }

            @Override // g.a.a.c.b.a
            public Set<b0.b> a() {
                Activity activity = this.a;
                Application application = (Application) a.this.b.a.getApplicationContext();
                Objects.requireNonNull(application, "Cannot return null from a non-@Nullable @Provides method");
                Map<String, i.a.a<e.n.a.b<? extends e.p.a0>>> j2 = j();
                ComponentActivity componentActivity = (ComponentActivity) activity;
                Bundle extras = activity.getIntent() != null ? activity.getIntent().getExtras() : null;
                e.n.a.a aVar = new e.n.a.a(componentActivity, extras, new e.p.v(application, componentActivity, extras), j2);
                int i2 = f.b.b.b.e.f2977d;
                return new j(aVar);
            }

            @Override // f.b.a.a.a.x.o0
            public void b(LegalTermsActivity legalTermsActivity) {
            }

            @Override // f.b.a.a.a.x.p0
            public void c(PrivateAnalyticsActivity privateAnalyticsActivity) {
            }

            @Override // f.b.a.a.a.x.h0
            public void d(ExposureAboutActivity exposureAboutActivity) {
            }

            @Override // f.b.a.a.a.r.u3
            public void e(ShareDiagnosisActivity shareDiagnosisActivity) {
            }

            @Override // f.b.a.a.a.x.f0
            public void f(AppAnalyticsActivity appAnalyticsActivity) {
            }

            @Override // f.b.a.a.a.x.e0
            public void g(AgencyActivity agencyActivity) {
            }

            @Override // g.a.a.c.c.e.a
            public g.a.a.c.a.c h() {
                return new C0070a(null);
            }

            @Override // f.b.a.a.a.l.g0
            public void i(ExposureNotificationActivity exposureNotificationActivity) {
            }

            public final Map<String, i.a.a<e.n.a.b<? extends e.p.a0>>> j() {
                f.b.a.c.b.o.b.z(8, "expectedSize");
                d.a aVar = new d.a(8);
                i.a.a aVar2 = this.b;
                if (aVar2 == null) {
                    aVar2 = new C0072c(0);
                    this.b = aVar2;
                }
                aVar.b("com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel", aVar2);
                i.a.a aVar3 = this.c;
                if (aVar3 == null) {
                    aVar3 = new C0072c(1);
                    this.c = aVar3;
                }
                aVar.b("com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel", aVar3);
                i.a.a aVar4 = this.f2085d;
                if (aVar4 == null) {
                    aVar4 = new C0072c(2);
                    this.f2085d = aVar4;
                }
                aVar.b("com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel", aVar4);
                i.a.a aVar5 = this.f2087f;
                if (aVar5 == null) {
                    aVar5 = new C0072c(3);
                    this.f2087f = aVar5;
                }
                aVar.b("com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel", aVar5);
                i.a.a aVar6 = this.f2088g;
                if (aVar6 == null) {
                    aVar6 = new C0072c(5);
                    this.f2088g = aVar6;
                }
                aVar.b("com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel", aVar6);
                i.a.a aVar7 = this.f2089h;
                if (aVar7 == null) {
                    aVar7 = new C0072c(6);
                    this.f2089h = aVar7;
                }
                aVar.b("com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel", aVar7);
                i.a.a aVar8 = this.f2091j;
                if (aVar8 == null) {
                    aVar8 = new C0072c(7);
                    this.f2091j = aVar8;
                }
                aVar.b("com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel", aVar8);
                i.a.a aVar9 = this.f2092k;
                if (aVar9 == null) {
                    aVar9 = new C0072c(9);
                    this.f2092k = aVar9;
                }
                aVar.b("com.google.android.apps.exposurenotification.home.SplashViewModel", aVar9);
                return aVar.a();
            }
        }

        public c(C0068a aVar) {
        }

        @Override // g.a.a.c.c.a.AbstractC0138a
        public g.a.a.c.a.a a() {
            return new C0069a(null);
        }

        @Override // g.a.a.c.c.b.d
        public g.a.a.a b() {
            Object obj;
            Object obj2 = this.a;
            if (obj2 instanceof g.b.b) {
                synchronized (obj2) {
                    obj = this.a;
                    if (obj instanceof g.b.b) {
                        obj = new b.e();
                        g.b.a.a(this.a, obj);
                        this.a = obj;
                    }
                }
                obj2 = obj;
            }
            return (g.a.a.a) obj2;
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
            Object obj2;
            int i2 = 4;
            int i3 = 0;
            boolean z = false;
            switch (this.a) {
                case 0:
                    a aVar = a.this;
                    i.a.a<ExecutorService> h2 = aVar.h();
                    i.a.a aVar2 = aVar.w;
                    if (aVar2 == null) {
                        aVar2 = new d(2);
                        aVar.w = aVar2;
                    }
                    return (T) new f.b.a.a.a.w.c(h2, aVar2, aVar.E(), aVar.f());
                case 1:
                    return (T) a.this.g();
                case 2:
                    return (T) a.this.k();
                case 3:
                    a aVar3 = a.this;
                    Objects.requireNonNull(aVar3);
                    return (T) new f.b.a.a.a.z.m(aVar3.n(), aVar3.g(), aVar3.A(), new i0(aVar3.q()), aVar3.m(), m.h.O0(aVar3.f2077e));
                case 4:
                    return (T) a.this.e();
                case 5:
                    a aVar4 = a.this;
                    return (T) new r(aVar4.f(), aVar4.E(), aVar4.h());
                case 6:
                    a aVar5 = a.this;
                    i.a.a aVar6 = aVar5.J;
                    if (aVar6 == null) {
                        aVar6 = new d(7);
                        aVar5.J = aVar6;
                    }
                    i.a.a<f0> o = aVar5.o();
                    i.a.a aVar7 = aVar5.L;
                    if (aVar7 == null) {
                        aVar7 = new d(9);
                        aVar5.L = aVar7;
                    }
                    i.a.a aVar8 = aVar5.M;
                    if (aVar8 == null) {
                        aVar8 = new d(10);
                        aVar5.M = aVar8;
                    }
                    return (T) new j0(aVar6, o, aVar7, aVar8, aVar5.h(), aVar5.B(), aVar5.E(), aVar5.f());
                case 7:
                    a aVar9 = a.this;
                    Context x1 = f.b.a.c.b.o.b.x1(aVar9.b);
                    g y = aVar9.y();
                    f.b.a.a.a.w.d k2 = aVar9.k();
                    f.b.a.a.a.m.r rVar = new f.b.a.a.a.m.r(new f.b.a.a.a.y.h0(aVar9.p()), aVar9.y(), m.h.O0(aVar9.f2077e), aVar9.g(), aVar9.u());
                    f.b.a.a.a.m.p pVar = aVar9.f2084l;
                    Context x12 = f.b.a.c.b.o.b.x1(aVar9.b);
                    Objects.requireNonNull(pVar);
                    f.b.a.a.a.m.l lVar = new f.b.a.a.a.m.l(Uri.parse(x12.getString(R.string.enx_tekLocalDownloadIndexFile)), Uri.parse(x12.getString(R.string.enx_tekLocalDownloadBasePath)));
                    f.b.a.a.a.m.p pVar2 = aVar9.f2084l;
                    Context x13 = f.b.a.c.b.o.b.x1(aVar9.b);
                    Objects.requireNonNull(pVar2);
                    try {
                        JSONObject jSONObject = new JSONObject(x13.getString(R.string.enx_tekRoamingUrls));
                        Object[] objArr = new Object[8];
                        Iterator<String> keys = jSONObject.keys();
                        int i4 = 0;
                        while (keys.hasNext()) {
                            String next = keys.next();
                            f.b.b.b.a<Object> aVar10 = f.b.b.b.c.c;
                            f.b.a.c.b.o.b.z(i2, "initialCapacity");
                            Object[] objArr2 = new Object[i2];
                            int i5 = 0;
                            for (JSONArray jSONArray = jSONObject.getJSONArray(next); i5 < jSONArray.length(); jSONArray = jSONArray) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                                f.b.a.a.a.m.l lVar2 = new f.b.a.a.a.m.l(Uri.parse(jSONObject2.getString("index")), Uri.parse(jSONObject2.getString("base")));
                                int i6 = i3 + 1;
                                if (objArr2.length < i6) {
                                    objArr2 = Arrays.copyOf(objArr2, b.AbstractC0104b.b(objArr2.length, i6));
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
                                objArr = Arrays.copyOf(objArr, b.AbstractC0104b.b(objArr.length, i8));
                            }
                            f.b.a.c.b.o.b.y(next, p);
                            int i9 = i4 * 2;
                            objArr[i9] = next;
                            objArr[i9 + 1] = p;
                            i4 = i7;
                            jSONObject = jSONObject;
                            keys = keys;
                            i2 = 4;
                            i3 = 0;
                        }
                        f.b.b.b.h.d(i4, objArr);
                        map = f.b.b.b.h.d(i4, objArr);
                    } catch (Exception e2) {
                        Log.e("RoamingConfigParser", "Failed to parse JSON roaming download config, continuing with no roaming servers.", e2);
                        map = new HashMap();
                    }
                    return (T) new n(x1, y, k2, rVar, lVar, map, aVar9.g(), aVar9.u(), aVar9.A(), aVar9.e(), m.h.O0(aVar9.f2077e));
                case 8:
                    return (T) a.this.n();
                case 9:
                    a aVar11 = a.this;
                    return (T) new d0(aVar11.n(), new f.b.a.a.a.y.h0(aVar11.p()), aVar11.m(), aVar11.q(), m.h.O0(aVar11.f2077e), aVar11.g(), aVar11.A());
                case 10:
                    a aVar12 = a.this;
                    f fVar = aVar12.m;
                    Context x14 = f.b.a.c.b.o.b.x1(aVar12.b);
                    Objects.requireNonNull(fVar);
                    String string = x14.getResources().getString(R.string.enx_symptomOnsetToInfectiousnessMap);
                    int integer = x14.getResources().getInteger(R.integer.enx_reportTypeNoneMap);
                    String upperCase = string.substring(2).toUpperCase();
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
                            m.h.h(hashMap.size() <= 29, "the size of daysSinceOnsetToInfectiousness exceeds maximum size %d.", 29);
                            Integer[] numArr = new Integer[29];
                            Arrays.fill((Object[]) numArr, (Object) 0);
                            for (Map.Entry entry : hashMap.entrySet()) {
                                int intValue = ((Integer) entry.getKey()).intValue();
                                int intValue2 = ((Integer) entry.getValue()).intValue();
                                m.h.h(Math.abs(intValue) <= 14, "Invalid day since onset %d", Integer.valueOf(intValue));
                                boolean z2 = f.b.a.c.f.b.l.a(intValue2) != null;
                                Integer valueOf = Integer.valueOf(intValue2);
                                m.h.h(z2, "Invalid value of Infectiousness %d", valueOf);
                                numArr[intValue + 14] = valueOf;
                            }
                            List asList = Arrays.asList(numArr);
                            int i11 = iArr[29];
                            boolean z3 = f.b.a.c.f.b.l.a(i11) != null;
                            Integer valueOf2 = Integer.valueOf(i11);
                            m.h.h(z3, "Invalid value of Infectiousness %d", valueOf2);
                            m.h.j(integer != 0, "Invalid reportTypeWhenMissing value");
                            m.h.h(integer >= 0 && integer <= 5, "Invalid value of ReportType %d", Integer.valueOf(integer));
                            m.h.j(asList != null, "Must set daysSinceOnsetToInfectiousness");
                            m.h.j(integer != 0, "Must set reportTypeWhenMissing");
                            if (valueOf2 != null) {
                                z = true;
                            }
                            m.h.j(z, "Must set infectiousnessWhenDaysSinceOnsetMissing");
                            T t = (T) new DiagnosisKeysDataMapping(asList, integer, valueOf2.intValue());
                            String str = "Created diagnosisKeysDataMapping: " + ((Object) t);
                            return t;
                        }
                    }
                    break;
                case 11:
                    return (T) a.this.A();
                case 12:
                    a aVar13 = a.this;
                    i.a.a aVar14 = aVar13.P;
                    if (aVar14 == null) {
                        aVar14 = new d(13);
                        aVar13.P = aVar14;
                    }
                    i.a.a<f0> o2 = aVar13.o();
                    i.a.a<q0> r = aVar13.r();
                    i.a.a aVar15 = aVar13.R;
                    if (aVar15 == null) {
                        aVar15 = new d(15);
                        aVar13.R = aVar15;
                    }
                    i.a.a aVar16 = aVar13.S;
                    if (aVar16 == null) {
                        aVar16 = new d(16);
                        aVar13.S = aVar16;
                    }
                    i.a.a aVar17 = aVar13.T;
                    if (aVar17 == null) {
                        aVar17 = new d(17);
                        aVar13.T = aVar17;
                    }
                    i.a.a aVar18 = aVar13.U;
                    if (aVar18 == null) {
                        aVar18 = new d(18);
                        aVar13.U = aVar18;
                    }
                    return (T) new k0(aVar14, o2, r, aVar15, aVar16, aVar17, aVar18, aVar13.h(), aVar13.v(), aVar13.B(), aVar13.f(), aVar13.j());
                case 13:
                    return (T) new r0(a.this.p());
                case 14:
                    return (T) a.this.q();
                case 15:
                    a aVar19 = a.this;
                    f fVar2 = aVar19.m;
                    DailySummariesConfig l2 = aVar19.l();
                    Objects.requireNonNull(fVar2);
                    return (T) new e(l2);
                case 16:
                    return (T) a.this.l();
                case 17:
                    a aVar20 = a.this;
                    f fVar3 = aVar20.m;
                    Context x15 = f.b.a.c.b.o.b.x1(aVar20.b);
                    Objects.requireNonNull(fVar3);
                    return (T) new f.b.a.a.a.v.c(new f.b.a.a.a.v.b[]{new f.b.a.a.a.v.b(x15, 1), new f.b.a.a.a.v.b(x15, 2), new f.b.a.a.a.v.b(x15, 3), new f.b.a.a.a.v.b(x15, 4)});
                case 18:
                    Objects.requireNonNull(a.this.c);
                    return (T) new o();
                case 19:
                    return (T) a.this.u();
                case 20:
                    return (T) m.h.O0(a.this.f2077e);
                case 21:
                    a aVar21 = a.this;
                    i.a.a aVar22 = aVar21.c0;
                    if (aVar22 == null) {
                        aVar22 = new d(22);
                        aVar21.c0 = aVar22;
                    }
                    return (T) new c0(aVar22, aVar21.h(), aVar21.E(), aVar21.f(), aVar21.j(), aVar21.r());
                case 22:
                    a aVar23 = a.this;
                    ExecutorService g2 = aVar23.g();
                    SecureRandom C = aVar23.C();
                    f.b.a.c.b.o.b.x1(aVar23.b);
                    f.b.a.a.a.t.d0.c cVar = new f.b.a.a.a.t.d0.c(aVar23.A(), aVar23.n(), aVar23.l(), m.h.O0(aVar23.f2077e));
                    f.b.a.a.a.t.d0.f fVar4 = new f.b.a.a.a.t.d0.f(aVar23.q());
                    f.b.a.a.a.t.d0.e eVar = new f.b.a.a.a.t.d0.e(aVar23.q());
                    f.b.a.a.a.t.d0.b bVar = new f.b.a.a.a.t.d0.b(aVar23.q());
                    f.b.a.a.a.t.d0.d dVar = new f.b.a.a.a.t.d0.d(aVar23.q());
                    f.b.a.a.a.t.y x = aVar23.x();
                    f.b.a.a.a.t.v vVar = new f.b.a.a.a.t.v(f.b.a.c.b.o.b.x1(aVar23.b), m.h.O0(aVar23.f2077e));
                    f.b.a.a.a.h.s.a O0 = m.h.O0(aVar23.f2077e);
                    Object obj3 = aVar23.a0;
                    if (obj3 instanceof g.b.b) {
                        synchronized (obj3) {
                            obj2 = aVar23.a0;
                            if (obj2 instanceof g.b.b) {
                                obj2 = aVar23.o.a(aVar23.s());
                                g.b.a.a(aVar23.a0, obj2);
                                aVar23.a0 = obj2;
                            }
                        }
                        obj3 = obj2;
                    }
                    f.b.a.a.a.t.x xVar = new f.b.a.a.a.t.x(vVar, O0, (f.b.c.k.f) obj3, aVar23.A(), aVar23.C());
                    q0 q = aVar23.q();
                    Object obj4 = aVar23.b0;
                    if (obj4 instanceof g.b.b) {
                        synchronized (obj4) {
                            obj = aVar23.b0;
                            if (obj instanceof g.b.b) {
                                Objects.requireNonNull(aVar23.p);
                                obj = new PrioJni();
                                g.b.a.a(aVar23.b0, obj);
                                aVar23.b0 = obj;
                            }
                        }
                        obj4 = obj;
                    }
                    return (T) new a0(g2, C, cVar, fVar4, eVar, bVar, dVar, x, xVar, q, (f.b.a.a.a.t.s) obj4);
                case 23:
                    a aVar24 = a.this;
                    i.a.a aVar25 = aVar24.e0;
                    if (aVar25 == null) {
                        aVar25 = new d(24);
                        aVar24.e0 = aVar25;
                    }
                    i.a.a<ExecutorService> h3 = aVar24.h();
                    i.a.a<ExecutorService> v = aVar24.v();
                    i.a.a aVar26 = aVar24.f0;
                    if (aVar26 == null) {
                        aVar26 = new d(25);
                        aVar24.f0 = aVar26;
                    }
                    i.a.a aVar27 = aVar24.g0;
                    if (aVar27 == null) {
                        aVar27 = new d(26);
                        aVar24.g0 = aVar27;
                    }
                    return (T) new w(aVar25, h3, v, aVar26, aVar27, aVar24.E());
                case 24:
                    a aVar28 = a.this;
                    Context x16 = f.b.a.c.b.o.b.x1(aVar28.b);
                    y yVar = aVar28.q;
                    Context x17 = f.b.a.c.b.o.b.x1(aVar28.b);
                    Objects.requireNonNull(yVar);
                    Uri parse = Uri.parse(x17.getString(R.string.enx_testVerificationURL));
                    Objects.requireNonNull(parse, "Cannot return null from a non-@Nullable @Provides method");
                    y yVar2 = aVar28.q;
                    Context x18 = f.b.a.c.b.o.b.x1(aVar28.b);
                    Objects.requireNonNull(yVar2);
                    Uri parse2 = Uri.parse(x18.getString(R.string.enx_testVerificationCertificateURL));
                    Objects.requireNonNull(parse2, "Cannot return null from a non-@Nullable @Provides method");
                    f.b.a.a.a.n.s sVar = new f.b.a.a.a.n.s(x16, parse, parse2, aVar28.y(), m.h.O0(aVar28.f2077e), aVar28.e());
                    Context x19 = f.b.a.c.b.o.b.x1(aVar28.b);
                    y yVar3 = aVar28.q;
                    Context x110 = f.b.a.c.b.o.b.x1(aVar28.b);
                    Objects.requireNonNull(yVar3);
                    Uri parse3 = Uri.parse(x110.getString(R.string.enx_tekUploadURL));
                    Objects.requireNonNull(parse3, "Cannot return null from a non-@Nullable @Provides method");
                    return (T) new v(sVar, new f.b.a.a.a.n.t(x19, parse3, aVar28.y(), aVar28.g(), aVar28.u(), m.h.O0(aVar28.f2077e), aVar28.e()));
                case 25:
                    return (T) a.this.z();
                case 26:
                    return (T) a.this.C();
                case 27:
                    return (T) a.this.m();
                case 28:
                    return (T) new i0(a.this.q());
                case 29:
                    return (T) a.this.D();
                case 30:
                    return (T) f.b.a.c.b.o.b.x1(a.this.b);
                default:
                    throw new AssertionError(this.a);
            }
        }
    }

    public a(g.a.a.c.d.a aVar, i iVar, t tVar, f.b.a.a.a.m.p pVar, k kVar, g0 g0Var, f.b.a.a.a.w.e eVar, s sVar, f.b.a.a.a.t.t tVar2, f.b.a.a.a.t.w wVar, z zVar, f.b.a.a.a.q.e eVar2, f.b.a.a.a.h.s.b bVar, f fVar, t0 t0Var, f.b.a.a.a.o.t tVar3, y yVar, f.b.a.a.a.z.f fVar2, C0068a aVar2) {
        this.a = kVar;
        this.b = aVar;
        this.c = iVar;
        this.f2076d = tVar;
        this.f2077e = bVar;
        this.f2078f = eVar;
        this.f2079g = g0Var;
        this.f2080h = t0Var;
        this.f2081i = tVar3;
        this.f2082j = sVar;
        this.f2083k = eVar2;
        this.f2084l = pVar;
        this.m = fVar;
        this.n = zVar;
        this.o = wVar;
        this.p = tVar2;
        this.q = yVar;
        this.r = fVar2;
    }

    public final ScheduledExecutorService A() {
        Object obj;
        Object obj2 = this.B;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.B;
                if (obj instanceof g.b.b) {
                    k kVar = this.a;
                    x z2 = z();
                    Objects.requireNonNull(kVar);
                    Objects.requireNonNull(z2, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.B, z2);
                    this.B = z2;
                    obj = z2;
                }
            }
            obj2 = obj;
        }
        return (ScheduledExecutorService) obj2;
    }

    public final i.a.a<ScheduledExecutorService> B() {
        i.a.a<ScheduledExecutorService> aVar = this.N;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(11);
        this.N = dVar;
        return dVar;
    }

    public final SecureRandom C() {
        Object obj;
        Object obj2 = this.Y;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.Y;
                if (obj instanceof g.b.b) {
                    Objects.requireNonNull(this.c);
                    obj = new SecureRandom();
                    g.b.a.a(this.Y, obj);
                    this.Y = obj;
                }
            }
            obj2 = obj;
        }
        return (SecureRandom) obj2;
    }

    public final e.c0.t D() {
        f.b.a.a.a.z.f fVar = this.r;
        Context x1 = f.b.a.c.b.o.b.x1(this.b);
        Objects.requireNonNull(fVar);
        e.c0.x.l d2 = e.c0.x.l.d(x1);
        Objects.requireNonNull(d2, "Cannot return null from a non-@Nullable @Provides method");
        return d2;
    }

    public final i.a.a<f.b.a.a.a.z.m> E() {
        i.a.a<f.b.a.a.a.z.m> aVar = this.C;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(3);
        this.C = dVar;
        return dVar;
    }

    @Override // f.b.a.a.a.h.l
    public void a(ExposureNotificationDismissedReceiver exposureNotificationDismissedReceiver) {
        exposureNotificationDismissedReceiver.c = q();
        exposureNotificationDismissedReceiver.f338d = m.h.O0(this.f2077e);
    }

    @Override // f.b.a.a.a.p.e0
    public void b(ExposureNotificationBroadcastReceiver exposureNotificationBroadcastReceiver) {
        exposureNotificationBroadcastReceiver.c = D();
    }

    @Override // f.b.a.a.a.b
    public void c(ExposureNotificationApplication exposureNotificationApplication) {
        f.b.a.c.b.o.b.z(6, "expectedSize");
        d.a aVar = new d.a(6);
        i.a.a aVar2 = this.E;
        if (aVar2 == null) {
            aVar2 = new d(0);
            this.E = aVar2;
        }
        aVar.b("com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker", aVar2);
        i.a.a aVar3 = this.F;
        if (aVar3 == null) {
            aVar3 = new d(5);
            this.F = aVar3;
        }
        aVar.b("com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker", aVar3);
        i.a.a aVar4 = this.O;
        if (aVar4 == null) {
            aVar4 = new d(6);
            this.O = aVar4;
        }
        aVar.b("com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker", aVar4);
        i.a.a aVar5 = this.X;
        if (aVar5 == null) {
            aVar5 = new d(12);
            this.X = aVar5;
        }
        aVar.b("com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker", aVar5);
        i.a.a aVar6 = this.d0;
        if (aVar6 == null) {
            aVar6 = new d(21);
            this.d0 = aVar6;
        }
        aVar.b("com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker", aVar6);
        i.a.a aVar7 = this.h0;
        if (aVar7 == null) {
            aVar7 = new d(23);
            this.h0 = aVar7;
        }
        aVar.b("com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker", aVar7);
        exposureNotificationApplication.c = new e.n.b.a(aVar.a());
        exposureNotificationApplication.workManager = D();
        f.b.a.a.a.z.f fVar = this.r;
        Context x1 = f.b.a.c.b.o.b.x1(this.b);
        e.c0.t D2 = D();
        f.b.b.f.a.w w2 = w();
        f.b.a.a.a.t.y x2 = x();
        Objects.requireNonNull(fVar);
        exposureNotificationApplication.f337d = new f.b.a.a.a.z.l(D2, w2, l.b.a.c.f((long) x1.getResources().getInteger(R.integer.enx_tekPublishInterval)), x2);
        exposureNotificationApplication.firebaseApp = s();
    }

    @Override // g.a.a.c.c.b.AbstractC0139b
    public g.a.a.c.a.b d() {
        return new b(null);
    }

    public final p e() {
        Object obj;
        Object obj2 = this.y;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.y;
                if (obj instanceof g.b.b) {
                    s sVar = this.f2082j;
                    String string = f.b.a.c.b.o.b.x1(this.b).getApplicationContext().getResources().getString(R.string.enx_regionIdentifier);
                    Log.i("ENX." + string, "Using logcat analytics logger.");
                    q t2 = t();
                    synchronized (sVar) {
                    }
                    g.b.a.a(this.y, t2);
                    this.y = t2;
                    obj = t2;
                }
            }
            obj2 = obj;
        }
        return (p) obj2;
    }

    public final i.a.a<p> f() {
        i.a.a<p> aVar = this.D;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(4);
        this.D = dVar;
        return dVar;
    }

    public final ExecutorService g() {
        Object obj;
        Object obj2 = this.t;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.t;
                if (obj instanceof g.b.b) {
                    k kVar = this.a;
                    f.b.b.f.a.w i2 = i();
                    Objects.requireNonNull(kVar);
                    Objects.requireNonNull(i2, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.t, i2);
                    this.t = i2;
                    obj = i2;
                }
            }
            obj2 = obj;
        }
        return (ExecutorService) obj2;
    }

    public final i.a.a<ExecutorService> h() {
        i.a.a<ExecutorService> aVar = this.u;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(1);
        this.u = dVar;
        return dVar;
    }

    public final f.b.b.f.a.w i() {
        Object obj;
        Object obj2 = this.s;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.s;
                if (obj instanceof g.b.b) {
                    Objects.requireNonNull(this.a);
                    obj = k.a("Background", 4, 10, k.b);
                    Objects.requireNonNull(obj, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.s, obj);
                    this.s = obj;
                }
            }
            obj2 = obj;
        }
        return (f.b.b.f.a.w) obj2;
    }

    public final i.a.a<f.b.a.a.a.h.s.a> j() {
        i.a.a<f.b.a.a.a.h.s.a> aVar = this.W;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(20);
        this.W = dVar;
        return dVar;
    }

    public final f.b.a.a.a.w.d k() {
        i iVar = this.c;
        Context x1 = f.b.a.c.b.o.b.x1(this.b);
        Objects.requireNonNull(iVar);
        TelephonyManager telephonyManager = (TelephonyManager) x1.getSystemService("phone");
        Objects.requireNonNull(telephonyManager, "Cannot return null from a non-@Nullable @Provides method");
        f.b.a.a.a.w.f fVar = new f.b.a.a.a.w.f(telephonyManager);
        f.b.a.a.a.y.s sVar = new f.b.a.a.a.y.s(p(), m.h.O0(this.f2077e));
        f.b.a.a.a.h.s.a O0 = m.h.O0(this.f2077e);
        f.b.a.a.a.w.e eVar = this.f2078f;
        Context x12 = f.b.a.c.b.o.b.x1(this.b);
        Objects.requireNonNull(eVar);
        if (x12.getString(R.string.enx_regionIdentifier).length() >= 2) {
            String substring = x12.getString(R.string.enx_regionIdentifier).substring(0, 2);
            Objects.requireNonNull(substring, "Cannot return null from a non-@Nullable @Provides method");
            return new f.b.a.a.a.w.d(fVar, sVar, O0, substring);
        }
        throw new RuntimeException("Failed to determine user's home region from configuration.");
    }

    public final DailySummariesConfig l() {
        f fVar = this.m;
        Context x1 = f.b.a.c.b.o.b.x1(this.b);
        Objects.requireNonNull(fVar);
        Resources resources = x1.getResources();
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
        aVar.f446d = new ArrayList(asList2);
        aVar.a(1, ((double) resources.getInteger(R.integer.enx_infectiousnessStandardWeight)) * 0.01d);
        aVar.a(2, ((double) resources.getInteger(R.integer.enx_infectiousnessHighWeight)) * 0.01d);
        aVar.b(1, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedTestWeight)) * 0.01d);
        aVar.b(2, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedClinicalDiagnosisWeight)) * 0.01d);
        aVar.b(3, ((double) resources.getInteger(R.integer.enx_reportTypeSelfReportWeight)) * 0.01d);
        int integer = resources.getInteger(R.integer.enx_daysSinceExposureThreshold);
        m.h.j(integer >= 0, "daysSinceExposureThreshold must not be negative");
        aVar.f447e = integer;
        m.h.j(aVar.c != null, "Must set attenuationBucketThresholdDb");
        if (aVar.f446d != null) {
            z2 = true;
        }
        m.h.j(z2, "Must set attenuationBucketWeights");
        DailySummariesConfig dailySummariesConfig = new DailySummariesConfig(Arrays.asList(aVar.a), Arrays.asList(aVar.b), aVar.c, aVar.f446d, aVar.f447e, 0.0d);
        String str = "Created dailySummaryConfig: " + dailySummariesConfig;
        return dailySummariesConfig;
    }

    public final m0 m() {
        return new m0(p());
    }

    public final f0 n() {
        Object obj;
        Object obj2 = this.z;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.z;
                if (obj instanceof g.b.b) {
                    g0 g0Var = this.f2079g;
                    Context x1 = f.b.a.c.b.o.b.x1(this.b);
                    Objects.requireNonNull(g0Var);
                    m.h.p(x1, "Context must not be null");
                    f.b.a.c.e.c.t tVar = new f.b.a.c.e.c.t(x1);
                    p e2 = e();
                    Objects.requireNonNull(g0Var);
                    obj = new f0(tVar, e2);
                    g.b.a.a(this.z, obj);
                    this.z = obj;
                }
            }
            obj2 = obj;
        }
        return (f0) obj2;
    }

    public final i.a.a<f0> o() {
        i.a.a<f0> aVar = this.K;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(8);
        this.K = dVar;
        return dVar;
    }

    public final ExposureNotificationDatabase p() {
        Object obj;
        Object obj2 = this.v;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.v;
                if (obj instanceof g.b.b) {
                    obj = m.h.L0(this.f2076d, f.b.a.c.b.o.b.x1(this.b));
                    g.b.a.a(this.v, obj);
                    this.v = obj;
                }
            }
            obj2 = obj;
        }
        return (ExposureNotificationDatabase) obj2;
    }

    public final q0 q() {
        t0 t0Var = this.f2080h;
        Context x1 = f.b.a.c.b.o.b.x1(this.b);
        f.b.a.a.a.h.s.a O0 = m.h.O0(this.f2077e);
        Objects.requireNonNull(t0Var);
        return new q0(x1, O0);
    }

    public final i.a.a<q0> r() {
        i.a.a<q0> aVar = this.Q;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(14);
        this.Q = dVar;
        return dVar;
    }

    public final f.b.c.a s() {
        Object obj;
        Object obj2 = this.Z;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.Z;
                if (obj instanceof g.b.b) {
                    f.b.a.a.a.t.w wVar = this.o;
                    Context x1 = f.b.a.c.b.o.b.x1(this.b);
                    Objects.requireNonNull(wVar);
                    obj = f.b.c.a.d(x1);
                    g.b.a.a(this.Z, obj);
                    this.Z = obj;
                }
            }
            obj2 = obj;
        }
        return (f.b.c.a) obj2;
    }

    public final q t() {
        Object obj;
        Context x1 = f.b.a.c.b.o.b.x1(this.b);
        q0 q2 = q();
        Object obj2 = this.x;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.x;
                if (obj instanceof g.b.b) {
                    obj = m.h.M0(this.f2081i, f.b.a.c.b.o.b.x1(this.b));
                    g.b.a.a(this.x, obj);
                    this.x = obj;
                }
            }
            obj2 = obj;
        }
        return new q(x1, q2, (f.b.a.b.f) obj2, new f.b.a.a.a.y.g(p()), m.h.O0(this.f2077e), new x0(p()), i());
    }

    public final ExecutorService u() {
        Object obj;
        Object obj2 = this.I;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.I;
                if (obj instanceof g.b.b) {
                    k kVar = this.a;
                    f.b.b.f.a.w w2 = w();
                    Objects.requireNonNull(kVar);
                    Objects.requireNonNull(w2, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.I, w2);
                    this.I = w2;
                    obj = w2;
                }
            }
            obj2 = obj;
        }
        return (ExecutorService) obj2;
    }

    public final i.a.a<ExecutorService> v() {
        i.a.a<ExecutorService> aVar = this.V;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(19);
        this.V = dVar;
        return dVar;
    }

    public final f.b.b.f.a.w w() {
        Object obj;
        Object obj2 = this.H;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.H;
                if (obj instanceof g.b.b) {
                    Objects.requireNonNull(this.a);
                    obj = k.a("Lightweight", Math.max(2, Runtime.getRuntime().availableProcessors() - 2), 0, k.a);
                    Objects.requireNonNull(obj, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.H, obj);
                    this.H = obj;
                }
            }
            obj2 = obj;
        }
        return (f.b.b.f.a.w) obj2;
    }

    public final f.b.a.a.a.t.y x() {
        f.b.b.f.a.w w2 = w();
        z zVar = this.n;
        Context x1 = f.b.a.c.b.o.b.x1(this.b);
        Objects.requireNonNull(zVar);
        Uri parse = Uri.parse(x1.getString(R.string.enx_enpaRemoteConfigURL));
        Objects.requireNonNull(parse, "Cannot return null from a non-@Nullable @Provides method");
        return new f.b.a.a.a.t.y(w2, parse, y(), e(), m.h.O0(this.f2077e));
    }

    public final g y() {
        Object obj;
        Object obj2 = this.G;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.G;
                if (obj instanceof g.b.b) {
                    obj = m.h.N0(this.f2083k);
                    g.b.a.a(this.G, obj);
                    this.G = obj;
                }
            }
            obj2 = obj;
        }
        return (g) obj2;
    }

    public final x z() {
        Object obj;
        Object obj2 = this.A;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.A;
                if (obj instanceof g.b.b) {
                    Objects.requireNonNull(this.a);
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4, k.b("Scheduled", 10, k.b));
                    obj = newScheduledThreadPool instanceof x ? (x) newScheduledThreadPool : new f.b.b.f.a.a0(newScheduledThreadPool);
                    Objects.requireNonNull(obj, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.A, obj);
                    this.A = obj;
                }
            }
            obj2 = obj;
        }
        return (x) obj2;
    }
}
