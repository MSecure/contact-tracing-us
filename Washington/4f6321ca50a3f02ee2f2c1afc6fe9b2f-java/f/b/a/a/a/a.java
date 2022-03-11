package f.b.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.StatFs;
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
import e.p.b0;
import f.b.a.a.a.h.i;
import f.b.a.a.a.h.k;
import f.b.a.a.a.h.o;
import f.b.a.a.a.k.n;
import f.b.a.a.a.l.u;
import f.b.a.a.a.l.v;
import f.b.a.a.a.m.p;
import f.b.a.a.a.m.q;
import f.b.a.a.a.m.r;
import f.b.a.a.a.m.t;
import f.b.a.a.a.n.d0;
import f.b.a.a.a.n.f0;
import f.b.a.a.a.n.g0;
import f.b.a.a.a.n.i0;
import f.b.a.a.a.n.j0;
import f.b.a.a.a.o.g;
import f.b.a.a.a.p.a4;
import f.b.a.a.a.p.f3;
import f.b.a.a.a.p.h3;
import f.b.a.a.a.p.j3;
import f.b.a.a.a.p.l3;
import f.b.a.a.a.p.o3;
import f.b.a.a.a.p.q3;
import f.b.a.a.a.p.s3;
import f.b.a.a.a.p.u3;
import f.b.a.a.a.p.w3;
import f.b.a.a.a.p.y3;
import f.b.a.a.a.q.e0;
import f.b.a.a.a.q.y;
import f.b.a.a.a.r.a0;
import f.b.a.a.a.r.b0;
import f.b.a.a.a.r.w;
import f.b.a.a.a.r.x;
import f.b.a.a.a.r.z;
import f.b.a.a.a.t.e;
import f.b.a.a.a.t.f;
import f.b.a.a.a.v.s0;
import f.b.a.a.a.v.t0;
import f.b.a.a.a.w.c0;
import f.b.a.a.a.w.k0;
import f.b.a.a.a.w.l0;
import f.b.a.a.a.w.n0;
import f.b.a.a.a.w.r0;
import f.b.a.a.a.w.s;
import f.b.a.a.a.x.l;
import f.b.a.c.e.c.s2;
import f.b.b.b.b;
import f.b.b.b.d;
import f.b.b.b.h;
import f.b.b.b.j;
import gov.wa.doh.exposurenotifications.R;
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
    public volatile i.a.a<l> B;
    public volatile i.a.a<p> C;
    public volatile i.a.a<f.b.a.a.a.u.c> D;
    public volatile i.a.a<r> E;
    public volatile Object F = new g.b.b();
    public volatile Object G = new g.b.b();
    public volatile Object H = new g.b.b();
    public volatile i.a.a<n> I;
    public volatile i.a.a<f0> J;
    public volatile i.a.a<d0> K;
    public volatile i.a.a<DiagnosisKeysDataMapping> L;
    public volatile i.a.a<ScheduledExecutorService> M;
    public volatile i.a.a<j0> N;
    public volatile i.a.a<l0> O;
    public volatile i.a.a<k0> P;
    public volatile i.a.a<e> Q;
    public volatile i.a.a<DailySummariesConfig> R;
    public volatile i.a.a<f.b.a.a.a.t.c> S;
    public volatile i.a.a<o> T;
    public volatile i.a.a<ExecutorService> U;
    public volatile i.a.a<f.b.a.a.a.h.s.a> V;
    public volatile i.a.a<f.b.a.a.a.n.k0> W;
    public volatile Object X = new g.b.b();
    public volatile Object Y = new g.b.b();
    public volatile Object Z = new g.b.b();
    public final k a;
    public volatile Object a0 = new g.b.b();
    public final g.a.a.b.d.a b;
    public volatile i.a.a<b0> b0;
    public final i c;
    public volatile i.a.a<f.b.a.a.a.r.d0> c0;

    /* renamed from: d  reason: collision with root package name */
    public final s f2055d;
    public volatile i.a.a<u> d0;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.a.a.a.h.s.b f2056e;
    public volatile i.a.a<SecureRandom> e0;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.a.a.u.e f2057f;
    public volatile i.a.a<v> f0;

    /* renamed from: g  reason: collision with root package name */
    public final g0 f2058g;
    public volatile i.a.a<LocationManager> g0;

    /* renamed from: h  reason: collision with root package name */
    public final n0 f2059h;
    public volatile i.a.a<StatFs> h0;

    /* renamed from: i  reason: collision with root package name */
    public final t f2060i;
    public volatile i.a.a<i0> i0;

    /* renamed from: j  reason: collision with root package name */
    public final f.b.a.a.a.m.s f2061j;
    public volatile i.a.a<e.b0.t> j0;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.a.a.o.e f2062k;
    public volatile i.a.a<Context> k0;

    /* renamed from: l  reason: collision with root package name */
    public final f.b.a.a.a.k.p f2063l;
    public final f m;
    public final a0 n;
    public final x o;
    public final f.b.a.a.a.r.u p;
    public final f.b.a.a.a.l.x q;
    public final f.b.a.a.a.x.e r;
    public volatile Object s = new g.b.b();
    public volatile Object t = new g.b.b();
    public volatile i.a.a<ExecutorService> u;
    public volatile Object v = new g.b.b();
    public volatile i.a.a<f.b.a.a.a.u.d> w;
    public volatile Object x = new g.b.b();
    public volatile Object y = new g.b.b();
    public volatile Object z = new g.b.b();

    public final class b implements g.a.a.b.a.b {
        public b(C0065a aVar) {
        }
    }

    public final class c extends d {

        /* renamed from: f.b.a.a.a.a$c$a  reason: collision with other inner class name */
        public final class C0066a implements g.a.a.b.a.a {
            public Activity a;

            public C0066a(C0065a aVar) {
            }
        }

        public final class b extends c {
            public final Activity a;
            public volatile i.a.a<f.b.a.a.a.v.i0> b;
            public volatile i.a.a<f.b.a.a.a.i.n> c;

            /* renamed from: d  reason: collision with root package name */
            public volatile i.a.a<f.b.a.a.a.j.a0> f2064d;

            /* renamed from: e  reason: collision with root package name */
            public volatile i.a.a<c0> f2065e;

            /* renamed from: f  reason: collision with root package name */
            public volatile i.a.a<h3> f2066f;

            /* renamed from: g  reason: collision with root package name */
            public volatile i.a.a<e0> f2067g;

            /* renamed from: h  reason: collision with root package name */
            public volatile i.a.a<s0> f2068h;

            /* renamed from: i  reason: collision with root package name */
            public volatile i.a.a<f.b.a.a.a.o.b> f2069i;

            /* renamed from: j  reason: collision with root package name */
            public volatile i.a.a<a4> f2070j;

            /* renamed from: k  reason: collision with root package name */
            public volatile i.a.a<f.b.a.a.a.j.l0> f2071k;

            /* renamed from: f.b.a.a.a.a$c$b$a  reason: collision with other inner class name */
            public final class C0067a implements g.a.a.b.a.c {
                public e.m.a.l a;

                public C0067a(C0065a aVar) {
                }
            }

            /* renamed from: f.b.a.a.a.a$c$b$b  reason: collision with other inner class name */
            public final class C0068b extends e {
                public final e.m.a.l a;

                public C0068b(e.m.a.l lVar, C0065a aVar) {
                    this.a = lVar;
                }

                @Override // f.b.a.a.a.p.k3
                public void a(j3 j3Var) {
                }

                @Override // g.a.a.b.b.b
                public Set<b0.b> b() {
                    e.m.a.l lVar = this.a;
                    Application application = (Application) a.this.b.a.getApplicationContext();
                    Objects.requireNonNull(application, "Cannot return null from a non-@Nullable @Provides method");
                    Map<String, i.a.a<e.n.a.b<? extends e.p.a0>>> j2 = b.this.j();
                    Bundle bundle = lVar.f1620g;
                    e.n.a.a aVar = new e.n.a.a(lVar, bundle, new e.p.v(application, lVar, bundle), j2);
                    int i2 = f.b.b.b.e.f2881d;
                    return new j(aVar);
                }

                @Override // f.b.a.a.a.q.d0
                public void c(f.b.a.a.a.q.c0 c0Var) {
                }

                @Override // f.b.a.a.a.p.v3
                public void d(u3 u3Var) {
                }

                @Override // f.b.a.a.a.i.m
                public void e(f.b.a.a.a.i.l lVar) {
                }

                @Override // f.b.a.a.a.j.g0
                public void f(f.b.a.a.a.j.e0 e0Var) {
                }

                @Override // f.b.a.a.a.q.b0
                public void g(f.b.a.a.a.q.a0 a0Var) {
                }

                @Override // f.b.a.a.a.p.p3
                public void h(o3 o3Var) {
                }

                @Override // f.b.a.a.a.v.u0
                public void i(t0 t0Var) {
                }

                @Override // f.b.a.a.a.j.j0
                public void j(f.b.a.a.a.j.i0 i0Var) {
                    i0Var.Z = m.h.O0(a.this.f2056e);
                }

                @Override // f.b.a.a.a.p.t3
                public void k(s3 s3Var) {
                    s3Var.a0 = new f.b.a.a.a.o.b(f.b.a.c.b.o.b.y1(a.this.b));
                }

                @Override // f.b.a.a.a.p.m3
                public void l(l3 l3Var) {
                }

                @Override // f.b.a.a.a.p.r3
                public void m(q3 q3Var) {
                    q3Var.Z = m.h.O0(a.this.f2056e);
                }

                @Override // f.b.a.a.a.p.g3
                public void n(f3 f3Var) {
                }

                @Override // f.b.a.a.a.p.x3
                public void o(w3 w3Var) {
                }

                @Override // f.b.a.a.a.p.z3
                public void p(y3 y3Var) {
                }

                @Override // f.b.a.a.a.q.z
                public void q(y yVar) {
                }
            }

            /* renamed from: f.b.a.a.a.a$c$b$c  reason: collision with other inner class name */
            public final class C0069c<T> implements i.a.a<T> {
                public final int a;

                public C0069c(int i2) {
                    this.a = i2;
                }

                @Override // i.a.a
                public T get() {
                    switch (this.a) {
                        case 0:
                            return (T) new f.b.a.a.a.v.i0(a.e(a.this));
                        case 1:
                            return (T) new f.b.a.a.a.i.n(a.e(a.this));
                        case 2:
                            b bVar = b.this;
                            i.a.a e2 = a.e(a.this);
                            i.a.a<f0> n = a.this.n();
                            a aVar = a.this;
                            i.a.a aVar2 = aVar.g0;
                            if (aVar2 == null) {
                                aVar2 = new d(26);
                                aVar.g0 = aVar2;
                            }
                            a aVar3 = a.this;
                            i.a.a aVar4 = aVar3.h0;
                            if (aVar4 == null) {
                                aVar4 = new d(27);
                                aVar3.h0 = aVar4;
                            }
                            i.a.a<p> g2 = a.this.g();
                            a aVar5 = a.this;
                            i.a.a aVar6 = aVar5.i0;
                            if (aVar6 == null) {
                                aVar6 = new d(28);
                                aVar5.i0 = aVar6;
                            }
                            a aVar7 = a.this;
                            i.a.a aVar8 = aVar7.V;
                            if (aVar8 == null) {
                                aVar8 = new d(20);
                                aVar7.V = aVar8;
                            }
                            return (T) new f.b.a.a.a.j.a0(e2, n, aVar2, aVar4, g2, aVar6, aVar8);
                        case 3:
                            b bVar2 = b.this;
                            i.a.a aVar9 = bVar2.f2065e;
                            if (aVar9 == null) {
                                aVar9 = new C0069c(4);
                                bVar2.f2065e = aVar9;
                            }
                            return (T) new h3(aVar9);
                        case 4:
                            b bVar3 = b.this;
                            return (T) new c0(a.this.o(), a.this.h(), m.h.O0(a.this.f2056e));
                        case 5:
                            b bVar4 = b.this;
                            i.a.a e3 = a.e(a.this);
                            a aVar10 = a.this;
                            i.a.a aVar11 = aVar10.j0;
                            if (aVar11 == null) {
                                aVar11 = new d(29);
                                aVar10.j0 = aVar11;
                            }
                            return (T) new e0(e3, aVar11);
                        case 6:
                            return (T) new s0(a.e(a.this));
                        case 7:
                            b bVar5 = b.this;
                            a aVar12 = a.this;
                            i.a.a aVar13 = aVar12.k0;
                            if (aVar13 == null) {
                                aVar13 = new d(30);
                                aVar12.k0 = aVar13;
                            }
                            a aVar14 = a.this;
                            i.a.a aVar15 = aVar14.d0;
                            if (aVar15 == null) {
                                aVar15 = new d(24);
                                aVar14.d0 = aVar15;
                            }
                            i.a.a aVar16 = bVar5.f2065e;
                            if (aVar16 == null) {
                                aVar16 = new C0069c(4);
                                bVar5.f2065e = aVar16;
                            }
                            i.a.a<f0> n2 = a.this.n();
                            i.a.a aVar17 = bVar5.f2069i;
                            if (aVar17 == null) {
                                aVar17 = new C0069c(8);
                                bVar5.f2069i = aVar17;
                            }
                            return (T) new a4(aVar13, aVar15, aVar16, n2, aVar17, a.this.i(), a.this.t(), a.this.y());
                        case 8:
                            return (T) new f.b.a.a.a.o.b(f.b.a.c.b.o.b.y1(a.this.b));
                        case 9:
                            return (T) new f.b.a.a.a.j.l0(a.e(a.this));
                        default:
                            throw new AssertionError(this.a);
                    }
                }
            }

            public b(Activity activity, C0065a aVar) {
                this.a = activity;
            }

            @Override // g.a.a.b.b.a
            public Set<b0.b> a() {
                Activity activity = this.a;
                Application application = (Application) a.this.b.a.getApplicationContext();
                Objects.requireNonNull(application, "Cannot return null from a non-@Nullable @Provides method");
                Map<String, i.a.a<e.n.a.b<? extends e.p.a0>>> j2 = j();
                ComponentActivity componentActivity = (ComponentActivity) activity;
                Bundle extras = activity.getIntent() != null ? activity.getIntent().getExtras() : null;
                e.n.a.a aVar = new e.n.a.a(componentActivity, extras, new e.p.v(application, componentActivity, extras), j2);
                int i2 = f.b.b.b.e.f2881d;
                return new j(aVar);
            }

            @Override // f.b.a.a.a.v.q0
            public void b(LegalTermsActivity legalTermsActivity) {
            }

            @Override // f.b.a.a.a.v.r0
            public void c(PrivateAnalyticsActivity privateAnalyticsActivity) {
            }

            @Override // f.b.a.a.a.v.j0
            public void d(ExposureAboutActivity exposureAboutActivity) {
            }

            @Override // f.b.a.a.a.p.i3
            public void e(ShareDiagnosisActivity shareDiagnosisActivity) {
            }

            @Override // f.b.a.a.a.v.h0
            public void f(AppAnalyticsActivity appAnalyticsActivity) {
            }

            @Override // f.b.a.a.a.v.g0
            public void g(AgencyActivity agencyActivity) {
            }

            @Override // g.a.a.b.c.e.a
            public g.a.a.b.a.c h() {
                return new C0067a(null);
            }

            @Override // f.b.a.a.a.j.z
            public void i(ExposureNotificationActivity exposureNotificationActivity) {
            }

            public final Map<String, i.a.a<e.n.a.b<? extends e.p.a0>>> j() {
                f.b.a.c.b.o.b.z(8, "expectedSize");
                d.a aVar = new d.a(8);
                i.a.a aVar2 = this.b;
                if (aVar2 == null) {
                    aVar2 = new C0069c(0);
                    this.b = aVar2;
                }
                aVar.b("com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel", aVar2);
                i.a.a aVar3 = this.c;
                if (aVar3 == null) {
                    aVar3 = new C0069c(1);
                    this.c = aVar3;
                }
                aVar.b("com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel", aVar3);
                i.a.a aVar4 = this.f2064d;
                if (aVar4 == null) {
                    aVar4 = new C0069c(2);
                    this.f2064d = aVar4;
                }
                aVar.b("com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel", aVar4);
                i.a.a aVar5 = this.f2066f;
                if (aVar5 == null) {
                    aVar5 = new C0069c(3);
                    this.f2066f = aVar5;
                }
                aVar.b("com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel", aVar5);
                i.a.a aVar6 = this.f2067g;
                if (aVar6 == null) {
                    aVar6 = new C0069c(5);
                    this.f2067g = aVar6;
                }
                aVar.b("com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel", aVar6);
                i.a.a aVar7 = this.f2068h;
                if (aVar7 == null) {
                    aVar7 = new C0069c(6);
                    this.f2068h = aVar7;
                }
                aVar.b("com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel", aVar7);
                i.a.a aVar8 = this.f2070j;
                if (aVar8 == null) {
                    aVar8 = new C0069c(7);
                    this.f2070j = aVar8;
                }
                aVar.b("com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel", aVar8);
                i.a.a aVar9 = this.f2071k;
                if (aVar9 == null) {
                    aVar9 = new C0069c(9);
                    this.f2071k = aVar9;
                }
                aVar.b("com.google.android.apps.exposurenotification.home.SplashViewModel", aVar9);
                return aVar.a();
            }
        }

        public c(C0065a aVar) {
        }

        @Override // g.a.a.b.c.a.AbstractC0133a
        public g.a.a.b.a.a a() {
            return new C0066a(null);
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
                    i.a.a<ExecutorService> i4 = aVar.i();
                    i.a.a aVar2 = aVar.w;
                    if (aVar2 == null) {
                        aVar2 = new d(2);
                        aVar.w = aVar2;
                    }
                    return (T) new f.b.a.a.a.u.c(i4, aVar2, aVar.B(), aVar.g());
                case 1:
                    return (T) a.this.h();
                case 2:
                    return (T) a.this.k();
                case 3:
                    a aVar3 = a.this;
                    Objects.requireNonNull(aVar3);
                    return (T) new l(aVar3.m(), aVar3.h(), aVar3.x(), new i0(aVar3.p()));
                case 4:
                    return (T) a.this.f();
                case 5:
                    a aVar4 = a.this;
                    return (T) new r(aVar4.g(), aVar4.B(), aVar4.i());
                case 6:
                    a aVar5 = a.this;
                    i.a.a aVar6 = aVar5.I;
                    if (aVar6 == null) {
                        aVar6 = new d(7);
                        aVar5.I = aVar6;
                    }
                    i.a.a<f0> n = aVar5.n();
                    i.a.a aVar7 = aVar5.K;
                    if (aVar7 == null) {
                        aVar7 = new d(9);
                        aVar5.K = aVar7;
                    }
                    i.a.a aVar8 = aVar5.L;
                    if (aVar8 == null) {
                        aVar8 = new d(10);
                        aVar5.L = aVar8;
                    }
                    return (T) new j0(aVar6, n, aVar7, aVar8, aVar5.i(), aVar5.y(), aVar5.B(), aVar5.g());
                case 7:
                    a aVar9 = a.this;
                    Context y1 = f.b.a.c.b.o.b.y1(aVar9.b);
                    g w = aVar9.w();
                    f.b.a.a.a.u.d k2 = aVar9.k();
                    f.b.a.a.a.k.r rVar = new f.b.a.a.a.k.r(new f.b.a.a.a.w.g0(aVar9.o()), aVar9.w(), m.h.O0(aVar9.f2056e), aVar9.h(), aVar9.s());
                    f.b.a.a.a.k.p pVar = aVar9.f2063l;
                    Context y12 = f.b.a.c.b.o.b.y1(aVar9.b);
                    Objects.requireNonNull(pVar);
                    f.b.a.a.a.k.l lVar = new f.b.a.a.a.k.l(Uri.parse(y12.getString(R.string.enx_tekLocalDownloadIndexFile)), Uri.parse(y12.getString(R.string.enx_tekLocalDownloadBasePath)));
                    f.b.a.a.a.k.p pVar2 = aVar9.f2063l;
                    Context y13 = f.b.a.c.b.o.b.y1(aVar9.b);
                    Objects.requireNonNull(pVar2);
                    try {
                        JSONObject jSONObject = new JSONObject(y13.getString(R.string.enx_tekRoamingUrls));
                        Object[] objArr = new Object[8];
                        Iterator<String> keys = jSONObject.keys();
                        int i5 = 0;
                        while (keys.hasNext()) {
                            String next = keys.next();
                            f.b.b.b.a<Object> aVar10 = f.b.b.b.c.c;
                            f.b.a.c.b.o.b.z(i2, "initialCapacity");
                            Object[] objArr2 = new Object[i2];
                            int i6 = 0;
                            for (JSONArray jSONArray = jSONObject.getJSONArray(next); i6 < jSONArray.length(); jSONArray = jSONArray) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                                f.b.a.a.a.k.l lVar2 = new f.b.a.a.a.k.l(Uri.parse(jSONObject2.getString("index")), Uri.parse(jSONObject2.getString("base")));
                                int i7 = i3 + 1;
                                if (objArr2.length < i7) {
                                    objArr2 = Arrays.copyOf(objArr2, b.AbstractC0100b.b(objArr2.length, i7));
                                }
                                objArr2[i3] = lVar2;
                                i6++;
                                i3 = i7;
                                keys = keys;
                            }
                            f.b.b.b.c p = f.b.b.b.c.p(objArr2, i3);
                            int i8 = i5 + 1;
                            int i9 = i8 * 2;
                            if (i9 > objArr.length) {
                                objArr = Arrays.copyOf(objArr, b.AbstractC0100b.b(objArr.length, i9));
                            }
                            f.b.a.c.b.o.b.y(next, p);
                            int i10 = i5 * 2;
                            objArr[i10] = next;
                            objArr[i10 + 1] = p;
                            i5 = i8;
                            jSONObject = jSONObject;
                            keys = keys;
                            i2 = 4;
                            i3 = 0;
                        }
                        h.d(i5, objArr);
                        map = h.d(i5, objArr);
                    } catch (Exception e2) {
                        Log.e("RoamingConfigParser", "Failed to parse JSON roaming download config, continuing with no roaming servers.", e2);
                        map = new HashMap();
                    }
                    return (T) new n(y1, w, k2, rVar, lVar, map, aVar9.h(), aVar9.s(), aVar9.x(), aVar9.f(), m.h.O0(aVar9.f2056e));
                case 8:
                    return (T) a.this.m();
                case 9:
                    a aVar11 = a.this;
                    return (T) new d0(aVar11.m(), new f.b.a.a.a.w.g0(aVar11.o()), aVar11.p(), aVar11.h(), aVar11.x());
                case 10:
                    a aVar12 = a.this;
                    f fVar = aVar12.m;
                    Context y14 = f.b.a.c.b.o.b.y1(aVar12.b);
                    Objects.requireNonNull(fVar);
                    String string = y14.getResources().getString(R.string.enx_symptomOnsetToInfectiousnessMap);
                    int integer = y14.getResources().getInteger(R.integer.enx_reportTypeNoneMap);
                    byte[] a2 = f.b.b.c.a.c.a(string.substring(2).toUpperCase());
                    int[] iArr = new int[(a2.length * 4)];
                    int length = a2.length;
                    while (true) {
                        length--;
                        if (length >= 0) {
                            byte b2 = a2[length];
                            for (byte b3 = 3; b3 >= 0; b3 = (byte) (b3 - 1)) {
                                iArr[(3 - b3) + (((a2.length - 1) - length) * 4)] = (byte) (b2 & 3);
                                b2 = (byte) (b2 >> 2);
                            }
                        } else {
                            HashMap hashMap = new HashMap();
                            for (int i11 = -14; i11 <= 14; i11++) {
                                hashMap.put(Integer.valueOf(i11), Integer.valueOf(iArr[i11 + 14]));
                            }
                            m.h.j(true, "daysSinceOnsetToInfectiousness must not be null.");
                            m.h.h(hashMap.size() <= 29, "the size of daysSinceOnsetToInfectiousness exceeds maximum size %d.", 29);
                            Integer[] numArr = new Integer[29];
                            Arrays.fill((Object[]) numArr, (Object) 0);
                            for (Map.Entry entry : hashMap.entrySet()) {
                                int intValue = ((Integer) entry.getKey()).intValue();
                                int intValue2 = ((Integer) entry.getValue()).intValue();
                                m.h.h(Math.abs(intValue) <= 14, "Invalid day since onset %d", Integer.valueOf(intValue));
                                m.h.h(f.b.a.c.f.b.k.a(intValue2) != null, "Invalid value of Infectiousness %d", Integer.valueOf(intValue2));
                                numArr[intValue + 14] = Integer.valueOf(intValue2);
                            }
                            List asList = Arrays.asList(numArr);
                            int i12 = iArr[29];
                            m.h.h(f.b.a.c.f.b.k.a(i12) != null, "Invalid value of Infectiousness %d", Integer.valueOf(i12));
                            Integer valueOf = Integer.valueOf(i12);
                            m.h.j(integer != 0, "Invalid reportTypeWhenMissing value");
                            m.h.h(integer >= 0 && integer <= 5, "Invalid value of ReportType %d", Integer.valueOf(integer));
                            m.h.j(asList != null, "Must set daysSinceOnsetToInfectiousness");
                            m.h.j(integer != 0, "Must set reportTypeWhenMissing");
                            if (valueOf != null) {
                                z = true;
                            }
                            m.h.j(z, "Must set infectiousnessWhenDaysSinceOnsetMissing");
                            T t = (T) new DiagnosisKeysDataMapping(asList, integer, valueOf.intValue());
                            String str = "Created diagnosisKeysDataMapping: " + ((Object) t);
                            return t;
                        }
                    }
                    break;
                case 11:
                    return (T) a.this.x();
                case 12:
                    a aVar13 = a.this;
                    i.a.a aVar14 = aVar13.O;
                    if (aVar14 == null) {
                        aVar14 = new d(13);
                        aVar13.O = aVar14;
                    }
                    i.a.a<f0> n2 = aVar13.n();
                    i.a.a aVar15 = aVar13.P;
                    if (aVar15 == null) {
                        aVar15 = new d(14);
                        aVar13.P = aVar15;
                    }
                    i.a.a aVar16 = aVar13.Q;
                    if (aVar16 == null) {
                        aVar16 = new d(15);
                        aVar13.Q = aVar16;
                    }
                    i.a.a aVar17 = aVar13.R;
                    if (aVar17 == null) {
                        aVar17 = new d(16);
                        aVar13.R = aVar17;
                    }
                    i.a.a aVar18 = aVar13.S;
                    if (aVar18 == null) {
                        aVar18 = new d(17);
                        aVar13.S = aVar18;
                    }
                    i.a.a aVar19 = aVar13.T;
                    if (aVar19 == null) {
                        aVar19 = new d(18);
                        aVar13.T = aVar19;
                    }
                    i.a.a<ExecutorService> i13 = aVar13.i();
                    i.a.a<ExecutorService> t2 = aVar13.t();
                    i.a.a<ScheduledExecutorService> y = aVar13.y();
                    i.a.a<p> g2 = aVar13.g();
                    i.a.a aVar20 = aVar13.V;
                    if (aVar20 == null) {
                        aVar20 = new d(20);
                        aVar13.V = aVar20;
                    }
                    return (T) new f.b.a.a.a.n.k0(aVar14, n2, aVar15, aVar16, aVar17, aVar18, aVar19, i13, t2, y, g2, aVar20);
                case 13:
                    return (T) new l0(a.this.o());
                case 14:
                    return (T) a.this.p();
                case 15:
                    a aVar21 = a.this;
                    f fVar2 = aVar21.m;
                    DailySummariesConfig l2 = aVar21.l();
                    Objects.requireNonNull(fVar2);
                    return (T) new e(l2);
                case 16:
                    return (T) a.this.l();
                case 17:
                    a aVar22 = a.this;
                    f fVar3 = aVar22.m;
                    Context y15 = f.b.a.c.b.o.b.y1(aVar22.b);
                    Objects.requireNonNull(fVar3);
                    return (T) new f.b.a.a.a.t.c(new f.b.a.a.a.t.b[]{new f.b.a.a.a.t.b(y15, 1), new f.b.a.a.a.t.b(y15, 2), new f.b.a.a.a.t.b(y15, 3), new f.b.a.a.a.t.b(y15, 4)});
                case 18:
                    Objects.requireNonNull(a.this.c);
                    return (T) new o();
                case 19:
                    return (T) a.this.s();
                case 20:
                    return (T) m.h.O0(a.this.f2056e);
                case 21:
                    a aVar23 = a.this;
                    i.a.a aVar24 = aVar23.b0;
                    if (aVar24 == null) {
                        aVar24 = new d(22);
                        aVar23.b0 = aVar24;
                    }
                    return (T) new f.b.a.a.a.r.d0(aVar24, aVar23.i(), aVar23.B(), aVar23.g());
                case 22:
                    a aVar25 = a.this;
                    ExecutorService h2 = aVar25.h();
                    SecureRandom z2 = aVar25.z();
                    f.b.a.c.b.o.b.y1(aVar25.b);
                    f.b.a.a.a.r.e0.b bVar = new f.b.a.a.a.r.e0.b(aVar25.x(), aVar25.m(), aVar25.l(), m.h.O0(aVar25.f2056e));
                    f.b.a.a.a.r.e0.d dVar = new f.b.a.a.a.r.e0.d(aVar25.p());
                    z v = aVar25.v();
                    w wVar = new w(f.b.a.c.b.o.b.y1(aVar25.b), m.h.O0(aVar25.f2056e));
                    f.b.a.a.a.h.s.a O0 = m.h.O0(aVar25.f2056e);
                    Object obj3 = aVar25.Z;
                    if (obj3 instanceof g.b.b) {
                        synchronized (obj3) {
                            obj2 = aVar25.Z;
                            if (obj2 instanceof g.b.b) {
                                obj2 = aVar25.o.a(aVar25.q());
                                g.b.a.a(aVar25.Z, obj2);
                                aVar25.Z = obj2;
                            }
                        }
                        obj3 = obj2;
                    }
                    f.b.a.a.a.r.y yVar = new f.b.a.a.a.r.y(wVar, O0, (f.b.c.k.f) obj3, aVar25.x(), aVar25.z());
                    k0 p2 = aVar25.p();
                    f.b.a.a.a.r.e0.c cVar = new f.b.a.a.a.r.e0.c(aVar25.p());
                    Object obj4 = aVar25.a0;
                    if (obj4 instanceof g.b.b) {
                        synchronized (obj4) {
                            obj = aVar25.a0;
                            if (obj instanceof g.b.b) {
                                Objects.requireNonNull(aVar25.p);
                                obj = new PrioJni();
                                g.b.a.a(aVar25.a0, obj);
                                aVar25.a0 = obj;
                            }
                        }
                        obj4 = obj;
                    }
                    return (T) new f.b.a.a.a.r.b0(h2, z2, bVar, dVar, v, yVar, p2, cVar, (f.b.a.a.a.r.t) obj4);
                case 23:
                    a aVar26 = a.this;
                    i.a.a aVar27 = aVar26.d0;
                    if (aVar27 == null) {
                        aVar27 = new d(24);
                        aVar26.d0 = aVar27;
                    }
                    i.a.a<ExecutorService> i14 = aVar26.i();
                    i.a.a<ExecutorService> t3 = aVar26.t();
                    i.a.a aVar28 = aVar26.e0;
                    if (aVar28 == null) {
                        aVar28 = new d(25);
                        aVar26.e0 = aVar28;
                    }
                    return (T) new v(aVar27, i14, t3, aVar28, aVar26.B());
                case 24:
                    a aVar29 = a.this;
                    Context y16 = f.b.a.c.b.o.b.y1(aVar29.b);
                    f.b.a.a.a.l.x xVar = aVar29.q;
                    Context y17 = f.b.a.c.b.o.b.y1(aVar29.b);
                    Objects.requireNonNull(xVar);
                    Uri parse = Uri.parse(y17.getString(R.string.enx_testVerificationURL));
                    Objects.requireNonNull(parse, "Cannot return null from a non-@Nullable @Provides method");
                    f.b.a.a.a.l.x xVar2 = aVar29.q;
                    Context y18 = f.b.a.c.b.o.b.y1(aVar29.b);
                    Objects.requireNonNull(xVar2);
                    Uri parse2 = Uri.parse(y18.getString(R.string.enx_testVerificationCertificateURL));
                    Objects.requireNonNull(parse2, "Cannot return null from a non-@Nullable @Provides method");
                    f.b.a.a.a.l.r rVar2 = new f.b.a.a.a.l.r(y16, parse, parse2, aVar29.w(), m.h.O0(aVar29.f2056e), aVar29.f());
                    Context y19 = f.b.a.c.b.o.b.y1(aVar29.b);
                    f.b.a.a.a.l.x xVar3 = aVar29.q;
                    Context y110 = f.b.a.c.b.o.b.y1(aVar29.b);
                    Objects.requireNonNull(xVar3);
                    Uri parse3 = Uri.parse(y110.getString(R.string.enx_tekUploadURL));
                    Objects.requireNonNull(parse3, "Cannot return null from a non-@Nullable @Provides method");
                    return (T) new u(rVar2, new f.b.a.a.a.l.s(y19, parse3, aVar29.w(), aVar29.h(), aVar29.s(), m.h.O0(aVar29.f2056e), aVar29.f()));
                case 25:
                    return (T) a.this.z();
                case 26:
                    a aVar30 = a.this;
                    i iVar = aVar30.c;
                    Context y111 = f.b.a.c.b.o.b.y1(aVar30.b);
                    Objects.requireNonNull(iVar);
                    T t4 = (T) ((LocationManager) y111.getSystemService("location"));
                    Objects.requireNonNull(t4, "Cannot return null from a non-@Nullable @Provides method");
                    return t4;
                case 27:
                    a aVar31 = a.this;
                    n0 n0Var = aVar31.f2059h;
                    Context y112 = f.b.a.c.b.o.b.y1(aVar31.b);
                    Objects.requireNonNull(n0Var);
                    return (T) new StatFs(y112.getFilesDir().toString());
                case 28:
                    return (T) new i0(a.this.p());
                case 29:
                    return (T) a.this.A();
                case 30:
                    return (T) f.b.a.c.b.o.b.y1(a.this.b);
                default:
                    throw new AssertionError(this.a);
            }
        }
    }

    public a(g.a.a.b.d.a aVar, i iVar, s sVar, f.b.a.a.a.k.p pVar, k kVar, g0 g0Var, f.b.a.a.a.u.e eVar, f.b.a.a.a.m.s sVar2, f.b.a.a.a.r.u uVar, x xVar, a0 a0Var, f.b.a.a.a.o.e eVar2, f.b.a.a.a.h.s.b bVar, f fVar, n0 n0Var, t tVar, f.b.a.a.a.l.x xVar2, f.b.a.a.a.x.e eVar3, C0065a aVar2) {
        this.a = kVar;
        this.b = aVar;
        this.c = iVar;
        this.f2055d = sVar;
        this.f2056e = bVar;
        this.f2057f = eVar;
        this.f2058g = g0Var;
        this.f2059h = n0Var;
        this.f2060i = tVar;
        this.f2061j = sVar2;
        this.f2062k = eVar2;
        this.f2063l = pVar;
        this.m = fVar;
        this.n = a0Var;
        this.o = xVar;
        this.p = uVar;
        this.q = xVar2;
        this.r = eVar3;
    }

    public static i.a.a e(a aVar) {
        i.a.a<k0> aVar2 = aVar.P;
        if (aVar2 != null) {
            return aVar2;
        }
        d dVar = new d(14);
        aVar.P = dVar;
        return dVar;
    }

    public final e.b0.t A() {
        f.b.a.a.a.x.e eVar = this.r;
        Context y1 = f.b.a.c.b.o.b.y1(this.b);
        Objects.requireNonNull(eVar);
        e.b0.x.l d2 = e.b0.x.l.d(y1);
        Objects.requireNonNull(d2, "Cannot return null from a non-@Nullable @Provides method");
        return d2;
    }

    public final i.a.a<l> B() {
        i.a.a<l> aVar = this.B;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(3);
        this.B = dVar;
        return dVar;
    }

    @Override // f.b.a.a.a.h.l
    public void a(ExposureNotificationDismissedReceiver exposureNotificationDismissedReceiver) {
        exposureNotificationDismissedReceiver.c = p();
        exposureNotificationDismissedReceiver.f330d = m.h.O0(this.f2056e);
    }

    @Override // f.b.a.a.a.n.e0
    public void b(ExposureNotificationBroadcastReceiver exposureNotificationBroadcastReceiver) {
        exposureNotificationBroadcastReceiver.c = A();
    }

    @Override // f.b.a.a.a.b
    public void c(ExposureNotificationApplication exposureNotificationApplication) {
        f.b.a.c.b.o.b.z(6, "expectedSize");
        d.a aVar = new d.a(6);
        i.a.a aVar2 = this.D;
        if (aVar2 == null) {
            aVar2 = new d(0);
            this.D = aVar2;
        }
        aVar.b("com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker", aVar2);
        i.a.a aVar3 = this.E;
        if (aVar3 == null) {
            aVar3 = new d(5);
            this.E = aVar3;
        }
        aVar.b("com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker", aVar3);
        i.a.a aVar4 = this.N;
        if (aVar4 == null) {
            aVar4 = new d(6);
            this.N = aVar4;
        }
        aVar.b("com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker", aVar4);
        i.a.a aVar5 = this.W;
        if (aVar5 == null) {
            aVar5 = new d(12);
            this.W = aVar5;
        }
        aVar.b("com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker", aVar5);
        i.a.a aVar6 = this.c0;
        if (aVar6 == null) {
            aVar6 = new d(21);
            this.c0 = aVar6;
        }
        aVar.b("com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker", aVar6);
        i.a.a aVar7 = this.f0;
        if (aVar7 == null) {
            aVar7 = new d(23);
            this.f0 = aVar7;
        }
        aVar.b("com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker", aVar7);
        exposureNotificationApplication.c = new e.n.b.a(aVar.a());
        exposureNotificationApplication.workManager = A();
        f.b.a.a.a.x.e eVar = this.r;
        Context y1 = f.b.a.c.b.o.b.y1(this.b);
        e.b0.t A2 = A();
        f.b.b.f.a.v u2 = u();
        z v2 = v();
        Objects.requireNonNull(eVar);
        exposureNotificationApplication.f329d = new f.b.a.a.a.x.k(A2, u2, l.b.a.c.f((long) y1.getResources().getInteger(R.integer.enx_tekPublishInterval)), v2);
        exposureNotificationApplication.firebaseApp = q();
    }

    @Override // g.a.a.b.c.b.c
    public g.a.a.b.a.b d() {
        return new b(null);
    }

    public final p f() {
        Object obj;
        Object obj2 = this.y;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.y;
                if (obj instanceof g.b.b) {
                    f.b.a.a.a.m.s sVar = this.f2061j;
                    String string = f.b.a.c.b.o.b.y1(this.b).getApplicationContext().getResources().getString(R.string.enx_regionIdentifier);
                    Log.i("ENX." + string, "Using logcat analytics logger.");
                    q r2 = r();
                    synchronized (sVar) {
                    }
                    g.b.a.a(this.y, r2);
                    this.y = r2;
                    obj = r2;
                }
            }
            obj2 = obj;
        }
        return (p) obj2;
    }

    public final i.a.a<p> g() {
        i.a.a<p> aVar = this.C;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(4);
        this.C = dVar;
        return dVar;
    }

    public final ExecutorService h() {
        Object obj;
        Object obj2 = this.t;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.t;
                if (obj instanceof g.b.b) {
                    k kVar = this.a;
                    f.b.b.f.a.v j2 = j();
                    Objects.requireNonNull(kVar);
                    Objects.requireNonNull(j2, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.t, j2);
                    this.t = j2;
                    obj = j2;
                }
            }
            obj2 = obj;
        }
        return (ExecutorService) obj2;
    }

    public final i.a.a<ExecutorService> i() {
        i.a.a<ExecutorService> aVar = this.u;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(1);
        this.u = dVar;
        return dVar;
    }

    public final f.b.b.f.a.v j() {
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
        return (f.b.b.f.a.v) obj2;
    }

    public final f.b.a.a.a.u.d k() {
        i iVar = this.c;
        Context y1 = f.b.a.c.b.o.b.y1(this.b);
        Objects.requireNonNull(iVar);
        TelephonyManager telephonyManager = (TelephonyManager) y1.getSystemService("phone");
        Objects.requireNonNull(telephonyManager, "Cannot return null from a non-@Nullable @Provides method");
        f.b.a.a.a.u.f fVar = new f.b.a.a.a.u.f(telephonyManager);
        f.b.a.a.a.w.r rVar = new f.b.a.a.a.w.r(o(), m.h.O0(this.f2056e));
        f.b.a.a.a.h.s.a O0 = m.h.O0(this.f2056e);
        f.b.a.a.a.u.e eVar = this.f2057f;
        Context y12 = f.b.a.c.b.o.b.y1(this.b);
        Objects.requireNonNull(eVar);
        if (y12.getString(R.string.enx_regionIdentifier).length() >= 2) {
            String substring = y12.getString(R.string.enx_regionIdentifier).substring(0, 2);
            Objects.requireNonNull(substring, "Cannot return null from a non-@Nullable @Provides method");
            return new f.b.a.a.a.u.d(fVar, rVar, O0, substring);
        }
        throw new RuntimeException("Failed to determine user's home region from configuration.");
    }

    public final DailySummariesConfig l() {
        f fVar = this.m;
        Context y1 = f.b.a.c.b.o.b.y1(this.b);
        Objects.requireNonNull(fVar);
        Resources resources = y1.getResources();
        DailySummariesConfig.a aVar = new DailySummariesConfig.a();
        boolean z2 = false;
        List asList = Arrays.asList(Integer.valueOf(resources.getInteger(R.integer.enx_attenuationImmediateNearThreshold)), Integer.valueOf(resources.getInteger(R.integer.enx_attenuationNearMedThreshold)), Integer.valueOf(resources.getInteger(R.integer.enx_attenuationMedFarThreshold)));
        List<Double> asList2 = Arrays.asList(Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationImmediateWeight)) * 0.01d), Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationNearWeight)) * 0.01d), Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationMedWeight)) * 0.01d), Double.valueOf(((double) resources.getInteger(R.integer.enx_attenuationOtherWeight)) * 0.01d));
        int[] iArr = DailySummariesConfig.b.a;
        DailySummariesConfig.a.d(asList, ((int[]) iArr.clone()).length - 1, "attenuationBucketThresholdDb");
        for (int i2 = 0; i2 < asList.size(); i2++) {
            m.h.j(((Integer) asList.get(i2)).intValue() >= 0 && ((Integer) asList.get(i2)).intValue() <= 255, "Element of attenuationBucketThreshold must between 0 ~ 255");
            if (i2 != 0) {
                int i3 = i2 - 1;
                m.h.j(((Integer) asList.get(i3)).intValue() < ((Integer) asList.get(i2)).intValue(), String.format(Locale.ENGLISH, "attenuationBucketThresholdDb of index %d must be larger than index %d", Integer.valueOf(i2), Integer.valueOf(i3)));
            }
        }
        aVar.c = new ArrayList(asList);
        DailySummariesConfig.a.d(asList2, ((int[]) iArr.clone()).length, "attenuationBucketWeights");
        for (Double d2 : asList2) {
            DailySummariesConfig.a.c(d2.doubleValue(), "attenuationBucketWeights");
        }
        aVar.f430d = new ArrayList(asList2);
        aVar.a(1, ((double) resources.getInteger(R.integer.enx_infectiousnessStandardWeight)) * 0.01d);
        aVar.a(2, ((double) resources.getInteger(R.integer.enx_infectiousnessHighWeight)) * 0.01d);
        aVar.b(1, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedTestWeight)) * 0.01d);
        aVar.b(2, ((double) resources.getInteger(R.integer.enx_reportTypeConfirmedClinicalDiagnosisWeight)) * 0.01d);
        aVar.b(3, ((double) resources.getInteger(R.integer.enx_reportTypeSelfReportWeight)) * 0.01d);
        int integer = resources.getInteger(R.integer.enx_daysSinceExposureThreshold);
        m.h.j(integer >= 0, "daysSinceExposureThreshold must not be negative");
        aVar.f431e = integer;
        m.h.j(aVar.c != null, "Must set attenuationBucketThresholdDb");
        if (aVar.f430d != null) {
            z2 = true;
        }
        m.h.j(z2, "Must set attenuationBucketWeights");
        DailySummariesConfig dailySummariesConfig = new DailySummariesConfig(Arrays.asList(aVar.a), Arrays.asList(aVar.b), aVar.c, aVar.f430d, aVar.f431e, 0.0d);
        String str = "Created dailySummaryConfig: " + dailySummariesConfig;
        return dailySummariesConfig;
    }

    public final f0 m() {
        Object obj;
        Object obj2 = this.z;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.z;
                if (obj instanceof g.b.b) {
                    g0 g0Var = this.f2058g;
                    Context y1 = f.b.a.c.b.o.b.y1(this.b);
                    Objects.requireNonNull(g0Var);
                    m.h.p(y1, "Context must not be null");
                    s2 s2Var = new s2(y1);
                    p f2 = f();
                    Objects.requireNonNull(g0Var);
                    obj = new f0(s2Var, f2);
                    g.b.a.a(this.z, obj);
                    this.z = obj;
                }
            }
            obj2 = obj;
        }
        return (f0) obj2;
    }

    public final i.a.a<f0> n() {
        i.a.a<f0> aVar = this.J;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(8);
        this.J = dVar;
        return dVar;
    }

    public final ExposureNotificationDatabase o() {
        Object obj;
        Object obj2 = this.v;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.v;
                if (obj instanceof g.b.b) {
                    obj = m.h.L0(this.f2055d, f.b.a.c.b.o.b.y1(this.b));
                    g.b.a.a(this.v, obj);
                    this.v = obj;
                }
            }
            obj2 = obj;
        }
        return (ExposureNotificationDatabase) obj2;
    }

    public final k0 p() {
        n0 n0Var = this.f2059h;
        Context y1 = f.b.a.c.b.o.b.y1(this.b);
        f.b.a.a.a.h.s.a O0 = m.h.O0(this.f2056e);
        Objects.requireNonNull(n0Var);
        return new k0(y1, O0);
    }

    public final f.b.c.a q() {
        Object obj;
        Object obj2 = this.Y;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.Y;
                if (obj instanceof g.b.b) {
                    x xVar = this.o;
                    Context y1 = f.b.a.c.b.o.b.y1(this.b);
                    Objects.requireNonNull(xVar);
                    obj = f.b.c.a.d(y1);
                    g.b.a.a(this.Y, obj);
                    this.Y = obj;
                }
            }
            obj2 = obj;
        }
        return (f.b.c.a) obj2;
    }

    public final q r() {
        Object obj;
        Context y1 = f.b.a.c.b.o.b.y1(this.b);
        k0 p2 = p();
        Object obj2 = this.x;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.x;
                if (obj instanceof g.b.b) {
                    obj = m.h.M0(this.f2060i, f.b.a.c.b.o.b.y1(this.b));
                    g.b.a.a(this.x, obj);
                    this.x = obj;
                }
            }
            obj2 = obj;
        }
        return new q(y1, p2, (f.b.a.b.f) obj2, new f.b.a.a.a.w.g(o()), m.h.O0(this.f2056e), new r0(o()), j());
    }

    public final ExecutorService s() {
        Object obj;
        Object obj2 = this.H;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.H;
                if (obj instanceof g.b.b) {
                    k kVar = this.a;
                    f.b.b.f.a.v u2 = u();
                    Objects.requireNonNull(kVar);
                    Objects.requireNonNull(u2, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.H, u2);
                    this.H = u2;
                    obj = u2;
                }
            }
            obj2 = obj;
        }
        return (ExecutorService) obj2;
    }

    public final i.a.a<ExecutorService> t() {
        i.a.a<ExecutorService> aVar = this.U;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(19);
        this.U = dVar;
        return dVar;
    }

    public final f.b.b.f.a.v u() {
        Object obj;
        Object obj2 = this.G;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.G;
                if (obj instanceof g.b.b) {
                    Objects.requireNonNull(this.a);
                    obj = k.a("Lightweight", Math.max(2, Runtime.getRuntime().availableProcessors() - 2), 0, k.a);
                    Objects.requireNonNull(obj, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.G, obj);
                    this.G = obj;
                }
            }
            obj2 = obj;
        }
        return (f.b.b.f.a.v) obj2;
    }

    public final z v() {
        f.b.b.f.a.v u2 = u();
        a0 a0Var = this.n;
        Context y1 = f.b.a.c.b.o.b.y1(this.b);
        Objects.requireNonNull(a0Var);
        Uri parse = Uri.parse(y1.getString(R.string.enx_enpaRemoteConfigURL));
        Objects.requireNonNull(parse, "Cannot return null from a non-@Nullable @Provides method");
        return new z(u2, parse, w(), f(), m.h.O0(this.f2056e));
    }

    public final g w() {
        Object obj;
        Object obj2 = this.F;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.F;
                if (obj instanceof g.b.b) {
                    obj = m.h.N0(this.f2062k);
                    g.b.a.a(this.F, obj);
                    this.F = obj;
                }
            }
            obj2 = obj;
        }
        return (g) obj2;
    }

    public final ScheduledExecutorService x() {
        Object obj;
        Object obj2 = this.A;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.A;
                if (obj instanceof g.b.b) {
                    Objects.requireNonNull(this.a);
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4, k.b("Scheduled", 10, k.b));
                    obj = newScheduledThreadPool instanceof f.b.b.f.a.w ? (f.b.b.f.a.w) newScheduledThreadPool : new f.b.b.f.a.z(newScheduledThreadPool);
                    Objects.requireNonNull(obj, "Cannot return null from a non-@Nullable @Provides method");
                    g.b.a.a(this.A, obj);
                    this.A = obj;
                }
            }
            obj2 = obj;
        }
        return (ScheduledExecutorService) obj2;
    }

    public final i.a.a<ScheduledExecutorService> y() {
        i.a.a<ScheduledExecutorService> aVar = this.M;
        if (aVar != null) {
            return aVar;
        }
        d dVar = new d(11);
        this.M = dVar;
        return dVar;
    }

    public final SecureRandom z() {
        Object obj;
        Object obj2 = this.X;
        if (obj2 instanceof g.b.b) {
            synchronized (obj2) {
                obj = this.X;
                if (obj instanceof g.b.b) {
                    Objects.requireNonNull(this.c);
                    obj = new SecureRandom();
                    g.b.a.a(this.X, obj);
                    this.X = obj;
                }
            }
            obj2 = obj;
        }
        return (SecureRandom) obj2;
    }
}
