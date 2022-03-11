package com.google.android.apps.exposurenotification.notify;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;
import e.r.c0;
import e.r.e0;
import e.r.q;
import e.r.s;
import e.r.y;
import e.v.i;
import e.v.n.d;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.d0.d;
import f.b.a.a.a.e0.d3;
import f.b.a.a.a.e0.e3;
import f.b.a.a.a.e0.f3;
import f.b.a.a.a.e0.h3;
import f.b.a.a.a.e0.k3;
import f.b.a.a.a.e0.k4;
import f.b.a.a.a.e0.k6;
import f.b.a.a.a.e0.l3;
import f.b.a.a.a.e0.m5;
import f.b.a.a.a.e0.n3;
import f.b.a.a.a.e0.o3;
import f.b.a.a.a.e0.r4;
import f.b.a.a.a.e0.v4;
import f.b.a.a.a.e0.w4;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.d0;
import f.b.a.a.a.n0.f1;
import f.b.a.a.a.n0.g1;
import f.b.a.a.a.n0.i1;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.j1;
import f.b.a.a.a.n0.k;
import f.b.a.a.a.n0.k0;
import f.b.a.a.a.n0.k1;
import f.b.a.a.a.n0.l1;
import f.b.a.a.a.n0.p;
import f.b.a.a.a.s.g;
import f.b.a.a.a.t.l0;
import f.b.a.a.a.t.n0;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.z.a0;
import f.b.a.a.a.z.e0;
import f.b.a.a.a.z.f0;
import f.b.a.a.a.z.g0;
import f.b.a.a.a.z.i0;
import f.b.a.c.b.l.b;
import f.b.a.d.a.a0;
import f.b.a.f.a.a.c;
import f.b.a.f.a.h.r;
import f.b.b.a.l;
import f.b.b.b.b;
import f.b.b.f.a.a;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import gov.nm.covid19.exposurenotifications.R;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.e;
/* loaded from: classes.dex */
public class ShareDiagnosisViewModel extends e0 {
    public static final e S;
    public static final e T;
    public final ScheduledExecutorService A;
    public final g I;
    public final Context J;
    public y K;
    public boolean Q;
    public final k0 c;

    /* renamed from: d */
    public final l1 f406d;

    /* renamed from: e */
    public final f0 f407e;

    /* renamed from: f */
    public final q1 f408f;

    /* renamed from: g */
    public final Resources f409g;

    /* renamed from: h */
    public final a1 f410h;

    /* renamed from: i */
    public final a0 f411i;

    /* renamed from: j */
    public final f.b.a.a.a.t.q0.a f412j;

    /* renamed from: k */
    public final n0 f413k;

    /* renamed from: l */
    public final SecureRandom f414l;
    public final f.b.a.a.a.d0.b m;
    public final ExecutorService y;
    public final ExecutorService z;
    public static final f.b.a.a.a.t.p0.a R = f.b.a.a.a.t.p0.a.e("ShareDiagnosisViewModel");
    public static final l.b.a.d U = l.b.a.d.n(5);
    public static final Set<String> V = f.b.b.b.e.p(2, "ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_TEST_DATE", "ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_PHONE_NUMBER");
    public static final Set<ExposureNotificationViewModel.b> W = f.b.b.b.e.t(ExposureNotificationViewModel.b.DISABLED, ExposureNotificationViewModel.b.FOCUS_LOST, ExposureNotificationViewModel.b.STORAGE_LOW, ExposureNotificationViewModel.b.PAUSED_USER_PROFILE_NOT_SUPPORT, ExposureNotificationViewModel.b.PAUSED_NOT_IN_ALLOWLIST, ExposureNotificationViewModel.b.PAUSED_HW_NOT_SUPPORT, ExposureNotificationViewModel.b.PAUSED_EN_NOT_SUPPORT);
    public static final j0 X = j0.q().a();
    public static final l.b.a.d Y = l.b.a.d.n(10);
    public final s<Long> n = new s<>(-1L);
    public final s<Boolean> o = new s<>(Boolean.FALSE);
    public final l0<Void> p = new l0<>();
    public final l0<Void> q = new l0<>();
    public final l0<String> r = new l0<>();
    public final l0<f.b.a.c.b.l.b> s = new l0<>();
    public final l0<f.b.a.c.b.l.b> t = new l0<>();
    public final l0<Boolean> u = new l0<>();
    public final l0<Boolean> v = new l0<>();
    public final l0<Boolean> w = new l0<>();
    public final s<l<a1.i>> x = new s<>(f.b.b.a.a.b);
    public final LiveData<j0> B = new s(X);
    public final s<b> C = new s<>();
    public final Stack<b> D = new Stack<>();
    public final s<String> E = new s<>();
    public final s<String> F = new s<>();
    public final s<String> G = new s<>();
    public final s<String> H = new s<>();
    public k6 L = k6.DEFAULT;
    public boolean M = false;
    public boolean N = false;
    public boolean O = false;
    public boolean P = false;

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract boolean a();

        public abstract l<String> b();
    }

    /* loaded from: classes.dex */
    public enum b {
        BEGIN,
        IS_CODE_NEEDED,
        GET_CODE,
        CODE,
        UPLOAD,
        SHARED,
        NOT_SHARED,
        VIEW,
        ALREADY_REPORTED,
        PRE_AUTH,
        VACCINATION
    }

    /* loaded from: classes.dex */
    public static class c extends Exception {
        public final String b;

        public c(String str) {
            this.b = str;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends Exception {
        public final j0 b;

        public d(j0 j0Var) {
            this.b = j0Var;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
        public abstract Integer a();

        public abstract l.b.a.d b();
    }

    static {
        l.b.a.d f2 = l.b.a.d.f(30);
        Objects.requireNonNull(3, "Null numOfRequests");
        S = new m5(f2, 3, null);
        l.b.a.d l2 = l.b.a.d.l(30);
        Objects.requireNonNull(1, "Null numOfRequests");
        T = new m5(l2, 1, null);
        int i2 = f.b.b.b.e.f3389d;
    }

    public ShareDiagnosisViewModel(Context context, y yVar, f0 f0Var, k0 k0Var, l1 l1Var, q1 q1Var, a1 a1Var, a0 a0Var, f.b.a.a.a.t.q0.a aVar, n0 n0Var, SecureRandom secureRandom, f.b.a.a.a.d0.b bVar, g gVar, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService) {
        this.J = context;
        this.K = yVar;
        this.f407e = f0Var;
        this.c = k0Var;
        this.f406d = l1Var;
        this.f408f = q1Var;
        this.f410h = a1Var;
        this.f411i = a0Var;
        this.f412j = aVar;
        this.f413k = n0Var;
        this.f414l = secureRandom;
        this.m = bVar;
        this.I = gVar;
        this.y = executorService;
        this.z = executorService2;
        this.A = scheduledExecutorService;
        this.f409g = context.getResources();
    }

    public final u<Long> c(i0 i0Var) {
        Long l2 = 0L;
        l.b.a.e c2 = this.f412j.c();
        Objects.requireNonNull(c2, "Null requestTime");
        String e2 = i0Var.e();
        Objects.requireNonNull(e2, "Null nonce");
        l.b.a.e A = i0Var.b() > 0 ? l.b.a.e.A(i0Var.b()) : null;
        l1 l1Var = this.f406d;
        String str = l2 == null ? " id" : "";
        if (str.isEmpty()) {
            p pVar = new p(l2.longValue(), c2, A, e2, null);
            f1 f1Var = (f1) l1Var.a;
            return e.v.n.d.a(f1Var.a, true, new g1(f1Var, pVar));
        }
        throw new IllegalStateException(f.a.a.a.a.x("Missing required properties:", str));
    }

    public final u<l.b.a.e> d(e eVar) {
        l.b.a.e w = this.f412j.c().w(eVar.b());
        l1 l1Var = this.f406d;
        int intValue = eVar.a().intValue();
        f1 f1Var = (f1) l1Var.a;
        Objects.requireNonNull(f1Var);
        i t = i.t("SELECT * FROM VerificationCodeRequestEntity WHERE requestTime >= ? ORDER BY requestTime DESC LIMIT ?", 2);
        t.x(1, m.e.c0(w));
        t.x(2, (long) intValue);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return f.b.b.f.a.l.x(e.v.n.d.b(f1Var.a, false, new j1(f1Var, t, cancellationSignal), t, true, cancellationSignal)).y(new f.b.b.a.g() { // from class: f.b.a.a.a.e0.u3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel.e eVar2 = ShareDiagnosisViewModel.e.this;
                List list = (List) obj;
                a aVar = ShareDiagnosisViewModel.R;
                if (list.isEmpty() || list.size() < eVar2.a().intValue()) {
                    return null;
                }
                return ((k1) list.get(0)).e();
            }
        }, this.z);
    }

    public final u<j0> e() {
        return f.b.b.f.a.l.x(this.c.b(this.n.d().longValue())).y(new f.b.b.a.g() { // from class: f.b.a.a.a.e0.a3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                j0 j0Var = (j0) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                if (j0Var == null) {
                    a aVar = ShareDiagnosisViewModel.R;
                    StringBuilder h2 = f.a.a.a.a.h("No diagnosis id [");
                    h2.append(shareDiagnosisViewModel.n);
                    h2.append("] exists in storage. Returning a fresh empty one.");
                    aVar.a(h2.toString());
                    return ShareDiagnosisViewModel.X;
                }
                a aVar2 = ShareDiagnosisViewModel.R;
                StringBuilder h3 = f.a.a.a.a.h("Got saved diagnosis for id ");
                h3.append(shareDiagnosisViewModel.n.d());
                aVar2.a(h3.toString());
                return j0Var;
            }
        }, this.y);
    }

    public LiveData<j0> f() {
        s<Long> sVar = this.n;
        n3 n3Var = new e.c.a.c.a() { // from class: f.b.a.a.a.e0.n3
            @Override // e.c.a.c.a
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                Long l2 = (Long) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                if (l2.longValue() <= 0) {
                    return shareDiagnosisViewModel.B;
                }
                k0 k0Var = shareDiagnosisViewModel.c;
                long longValue = l2.longValue();
                d0 d0Var = (d0) k0Var.a;
                Objects.requireNonNull(d0Var);
                i t = i.t("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
                t.x(1, longValue);
                return d0Var.a.f2062e.b(new String[]{"DiagnosisEntity"}, false, new f.b.a.a.a.n0.i0(d0Var, t));
            }
        };
        q qVar = new q();
        qVar.m(sVar, new c0(n3Var, qVar));
        return m.e.V(qVar);
    }

    public LiveData<Pair<Integer, Integer>> g() {
        return m.e.X0(this.C, new e.c.a.c.a() { // from class: f.b.a.a.a.e0.a5
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
                if (r8 == r4) goto L_0x002d;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
                if (r8 == r4) goto L_0x0033;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
                r2 = 0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
                if (r0 != 2) goto L_0x0032;
             */
            @Override // e.c.a.c.a
            /* Code decompiled incorrectly, please refer to instructions dump */
            public final Object a(Object obj) {
                ShareDiagnosisViewModel.b bVar = (ShareDiagnosisViewModel.b) obj;
                k6 k6Var = ShareDiagnosisViewModel.this.L;
                int i2 = 3;
                int i3 = k6Var == k6.SELF_REPORT ? 3 : 2;
                ShareDiagnosisViewModel.b bVar2 = ShareDiagnosisViewModel.b.UPLOAD;
                ShareDiagnosisViewModel.b bVar3 = ShareDiagnosisViewModel.b.CODE;
                int ordinal = k6Var.ordinal();
                if (ordinal == 0 || ordinal == 1) {
                    if (bVar != bVar3) {
                    }
                    i2 = 1;
                    return Pair.create(Integer.valueOf(i2), Integer.valueOf(i3));
                }
                if (bVar != ShareDiagnosisViewModel.b.GET_CODE) {
                    if (bVar != bVar3) {
                    }
                    i2 = 2;
                    return Pair.create(Integer.valueOf(i2), Integer.valueOf(i3));
                }
                i2 = 1;
                return Pair.create(Integer.valueOf(i2), Integer.valueOf(i3));
            }
        });
    }

    public final void h(g0 g0Var, s<String> sVar) {
        if (g0Var.equals(g0.UNAUTHORIZED_CLIENT)) {
            r<f.b.a.f.a.a.a> a2 = this.I.a.a();
            k3 k3Var = new f.b.a.f.a.h.c(sVar, g0Var) { // from class: f.b.a.a.a.e0.k3
                public final /* synthetic */ s b;
                public final /* synthetic */ g0 c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // f.b.a.f.a.h.c
                public final void a(Object obj) {
                    ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                    s sVar2 = this.b;
                    g0 g0Var2 = this.c;
                    f.b.a.f.a.a.a aVar = (f.b.a.f.a.a.a) obj;
                    shareDiagnosisViewModel.o.j(Boolean.FALSE);
                    Objects.requireNonNull(shareDiagnosisViewModel.I);
                    boolean z = false;
                    if (aVar.a == 2) {
                        if (aVar.a(c.c(1)) != null) {
                            z = true;
                        }
                    }
                    if (z) {
                        shareDiagnosisViewModel.q.j(null);
                    } else {
                        sVar2.j(g0Var2.a(shareDiagnosisViewModel.f409g, k6.SELF_REPORT.equals(shareDiagnosisViewModel.L)));
                    }
                }
            };
            Objects.requireNonNull(a2);
            a2.b(f.b.a.f.a.h.e.a, k3Var);
            a2.a(this.z, new f.b.a.f.a.h.b(sVar, g0Var) { // from class: f.b.a.a.a.e0.b4
                public final /* synthetic */ s b;
                public final /* synthetic */ g0 c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // f.b.a.f.a.h.b
                public final void b(Exception exc) {
                    ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                    s sVar2 = this.b;
                    g0 g0Var2 = this.c;
                    shareDiagnosisViewModel.o.j(Boolean.FALSE);
                    sVar2.j(g0Var2.a(shareDiagnosisViewModel.f409g, k6.SELF_REPORT.equals(shareDiagnosisViewModel.L)));
                }
            });
            return;
        }
        this.o.j(Boolean.FALSE);
        sVar.j(g0Var.a(this.f409g, k6.SELF_REPORT.equals(this.L)));
    }

    public boolean i() {
        return TextUtils.isEmpty(this.J.getResources().getString(R.string.share_travel_detail));
    }

    public final void j() {
        if (!this.D.isEmpty()) {
            this.D.pop();
        }
    }

    public void k(b bVar) {
        if (bVar != null) {
            this.D.push(bVar);
            this.C.j(bVar);
        }
    }

    public void l(b bVar) {
        if (bVar != null) {
            this.D.clear();
            k(bVar);
        }
    }

    public void m(long j2) {
        this.n.j(Long.valueOf(j2));
    }

    public u<?> n() {
        this.o.j(Boolean.TRUE);
        f.b.b.f.a.l y = f.b.b.f.a.l.x(m.e.o0(this.f408f.a.h(), U, this.A)).y(new f.b.b.a.g() { // from class: f.b.a.a.a.e0.x4
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                Void r3 = (Void) obj;
                shareDiagnosisViewModel.w.j(Boolean.TRUE);
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                return null;
            }
        }, this.z);
        o3 o3Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.o3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                b bVar = (b) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                if (bVar.b.c == 6) {
                    shareDiagnosisViewModel.t.j(bVar);
                    return null;
                }
                shareDiagnosisViewModel.r.j(shareDiagnosisViewModel.f409g.getString(R.string.generic_error_message));
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                return null;
            }
        };
        ExecutorService executorService = this.z;
        a.b bVar = new a.b(y, f.b.a.c.b.l.b.class, o3Var);
        y.a(bVar, f.b.a.c.b.o.b.k1(executorService, bVar));
        w4 w4Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.w4
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                Exception exc = (Exception) obj;
                shareDiagnosisViewModel.r.j(shareDiagnosisViewModel.f409g.getString(R.string.generic_error_message));
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                return null;
            }
        };
        ExecutorService executorService2 = this.z;
        a.b bVar2 = new a.b(bVar, Exception.class, w4Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.k1(executorService2, bVar2));
        return bVar2;
    }

    public void o(b bVar) {
        if (bVar != null) {
            j();
            if (!this.D.isEmpty()) {
                if (!this.D.peek().equals(bVar)) {
                    this.D.clear();
                }
                this.C.j(bVar);
            }
            this.D.push(bVar);
            this.C.j(bVar);
        }
    }

    public final u<Long> p(f.b.b.a.g<j0, j0> gVar) {
        return f.b.b.f.a.l.x(e()).y(new f.b.b.a.g(gVar) { // from class: f.b.a.a.a.e0.m4
            public final /* synthetic */ f.b.b.a.g b;

            {
                this.b = r2;
            }

            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                return shareDiagnosisViewModel.c.a(((j0) obj).e(), this.b);
            }
        }, this.y).y(new f.b.b.a.g() { // from class: f.b.a.a.a.e0.p4
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                Long l2 = (Long) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                shareDiagnosisViewModel.m(l2.longValue());
                return l2;
            }
        }, this.z);
    }

    public void q(long j2) {
        this.n.l(Long.valueOf(j2));
    }

    public void r(k6 k6Var) {
        if (k6.SELF_REPORT.equals(k6Var)) {
            q(-1);
            y yVar = this.K;
            Objects.requireNonNull(yVar);
            HashSet hashSet = new HashSet(yVar.a.keySet());
            hashSet.addAll(yVar.b.keySet());
            hashSet.addAll(yVar.c.keySet());
            hashSet.removeAll(V);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                y yVar2 = this.K;
                yVar2.a.remove(str);
                y.b<?> remove = yVar2.c.remove(str);
                if (remove != null) {
                    remove.m = null;
                }
            }
        }
        this.L = k6Var;
    }

    public boolean s(Resources resources) {
        return this.f411i.a() && this.f411i.b() && !TextUtils.isEmpty(resources.getString(R.string.share_vaccination_detail));
    }

    public void t(j0 j0Var) {
        j();
        k(m.e.w0(b.CODE, j0Var, this.L, s(this.f409g), this.J));
    }

    public void u(f.b.a.c.b.l.b bVar, e.a.e.c<e.a.e.e> cVar) {
        PendingIntent pendingIntent = bVar.b.f462e;
        if (pendingIntent != null) {
            cVar.a(new e.a.e.e(pendingIntent.getIntentSender(), null, 0, 0), null);
        }
    }

    public u<?> v(String str, boolean z) {
        if (this.o.d().booleanValue()) {
            return f.b.b.f.a.s.c;
        }
        this.o.j(Boolean.TRUE);
        R.a("Checking verification code locally");
        f.b.b.f.a.l y = f.b.b.f.a.l.x(this.c.c(str)).z(new f.b.b.f.a.i() { // from class: f.b.a.a.a.e0.s4
            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                List list = (List) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                if (!list.isEmpty()) {
                    return new s.a(new ShareDiagnosisViewModel.d((j0) list.get(0)));
                }
                l1 l1Var = shareDiagnosisViewModel.f406d;
                e c2 = shareDiagnosisViewModel.f412j.c();
                f1 f1Var = (f1) l1Var.a;
                Objects.requireNonNull(f1Var);
                i t = i.t("SELECT nonce FROM VerificationCodeRequestEntity WHERE expiresAtTime > ? ORDER BY expiresAtTime DESC", 1);
                t.x(1, m.e.c0(c2));
                CancellationSignal cancellationSignal = new CancellationSignal();
                return d.b(f1Var.a, false, new i1(f1Var, t, cancellationSignal), t, true, cancellationSignal);
            }
        }, this.z).z(new f.b.b.f.a.i(str) { // from class: f.b.a.a.a.e0.c4
            public final /* synthetic */ String b;

            {
                this.b = r2;
            }

            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                String str2 = this.b;
                List list = (List) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                ShareDiagnosisViewModel.R.a("Submitting verification code...");
                e0.a i2 = f.b.a.a.a.z.e0.i(str2, f.b.a.a.a.t.j0.a(shareDiagnosisViewModel.f414l));
                if (!list.isEmpty()) {
                    ((a0.b) i2).f2526l = (String) list.get(0);
                }
                return shareDiagnosisViewModel.f407e.b(i2.a());
            }
        }, this.z).z(new f.b.b.f.a.i(str, z) { // from class: f.b.a.a.a.e0.o4
            public final /* synthetic */ String b;
            public final /* synthetic */ boolean c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                String str2 = this.b;
                boolean z2 = this.c;
                f.b.a.a.a.z.e0 e0Var = (f.b.a.a.a.z.e0) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                k.b bVar = (k.b) j0.q();
                bVar.f2358d = str2;
                bVar.m = Boolean.valueOf(z2);
                bVar.c = j0.c.NOT_ATTEMPTED;
                bVar.f2359e = e0Var.h();
                if (e0Var.o() != null) {
                    bVar.g(true);
                    bVar.f2362h = e0Var.o();
                    bVar.c(j0.b.YES);
                }
                if (e0Var.p() != null) {
                    bVar.f2361g = j0.d.a(e0Var.p());
                }
                if (shareDiagnosisViewModel.P) {
                    shareDiagnosisViewModel.P = false;
                }
                shareDiagnosisViewModel.f410h.w(shareDiagnosisViewModel.f412j.c());
                k0 k0Var = shareDiagnosisViewModel.c;
                f.b.a.a.a.n0.b bVar2 = new f.b.a.a.a.n0.b(k0Var, bVar.a());
                ExecutorService executorService = k0Var.b;
                f.b.b.f.a.d0 d0Var = new f.b.b.f.a.d0(bVar2);
                executorService.execute(d0Var);
                return d0Var;
            }
        }, this.y).z(new f.b.b.f.a.i() { // from class: f.b.a.a.a.e0.s3
            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                Long l2 = (Long) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                ShareDiagnosisViewModel.R.a("Current diagnosis stored, notifying view");
                shareDiagnosisViewModel.m(l2.longValue());
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                shareDiagnosisViewModel.E.j("");
                return shareDiagnosisViewModel.c.b(l2.longValue());
            }
        }, this.z).y(new f.b.b.a.g() { // from class: f.b.a.a.a.e0.x3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                j0 j0Var = (j0) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                if (m.e.M0(j0Var)) {
                    shareDiagnosisViewModel.t(j0Var);
                    return null;
                }
                shareDiagnosisViewModel.v.j(Boolean.TRUE);
                shareDiagnosisViewModel.k(m.e.w0(ShareDiagnosisViewModel.b.CODE, j0Var, shareDiagnosisViewModel.L, shareDiagnosisViewModel.s(shareDiagnosisViewModel.f409g), shareDiagnosisViewModel.J));
                return null;
            }
        }, this.z);
        d3 d3Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.d3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                ShareDiagnosisViewModel.d dVar = (ShareDiagnosisViewModel.d) obj;
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                shareDiagnosisViewModel.m(dVar.b.e());
                if (j0.c.SHARED.equals(dVar.b.m())) {
                    shareDiagnosisViewModel.E.j(shareDiagnosisViewModel.f409g.getString(R.string.code_error_already_submitted));
                }
                if (m.e.M0(dVar.b)) {
                    shareDiagnosisViewModel.t(dVar.b);
                    return null;
                }
                shareDiagnosisViewModel.v.j(Boolean.TRUE);
                return null;
            }
        };
        ExecutorService executorService = this.z;
        a.b bVar = new a.b(y, d.class, d3Var);
        y.a(bVar, f.b.a.c.b.o.b.k1(executorService, bVar));
        k4 k4Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.k4
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                f0.c cVar = (f0.c) obj;
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                shareDiagnosisViewModel.E.j(shareDiagnosisViewModel.f409g.getString(R.string.share_error_no_internet));
                shareDiagnosisViewModel.v.j(Boolean.TRUE);
                return null;
            }
        };
        ExecutorService executorService2 = this.z;
        a.b bVar2 = new a.b(bVar, f0.c.class, k4Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.k1(executorService2, bVar2));
        e3 e3Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.e3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                shareDiagnosisViewModel.v.j(Boolean.TRUE);
                shareDiagnosisViewModel.h(((f0.d) obj).b, shareDiagnosisViewModel.E);
                return null;
            }
        };
        ExecutorService executorService3 = this.z;
        a.b bVar3 = new a.b(bVar2, f0.d.class, e3Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.k1(executorService3, bVar3));
        v4 v4Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.v4
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                Objects.requireNonNull(shareDiagnosisViewModel);
                ShareDiagnosisViewModel.R.d("Failed to submit verification code.", (Exception) obj);
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                shareDiagnosisViewModel.v.j(Boolean.TRUE);
                shareDiagnosisViewModel.E.j(shareDiagnosisViewModel.f409g.getString(R.string.generic_error_message));
                return null;
            }
        };
        ExecutorService executorService4 = this.z;
        a.b bVar4 = new a.b(bVar3, Exception.class, v4Var);
        bVar3.a(bVar4, f.b.a.c.b.o.b.k1(executorService4, bVar4));
        return bVar4;
    }

    public u<?> w() {
        this.o.j(Boolean.TRUE);
        R.a("Getting current TEKs from EN API...");
        f.b.b.f.a.l y = f.b.b.f.a.l.x(m.e.o0(this.f408f.a.c(), Y, this.A)).y(new f.b.b.a.g() { // from class: f.b.a.a.a.e0.q3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                f.b.a.a.a.t.p0.a aVar = ShareDiagnosisViewModel.R;
                Objects.requireNonNull(shareDiagnosisViewModel);
                ShareDiagnosisViewModel.R.a("Converting TEKs into DiagnosisKeys...");
                f.b.a.c.b.o.b.z(4, "initialCapacity");
                Object[] objArr = new Object[4];
                int i2 = 0;
                for (TemporaryExposureKey temporaryExposureKey : (List) obj) {
                    d.a f2 = f.b.a.a.a.d0.d.f();
                    f2.c(temporaryExposureKey.d());
                    f2.b(temporaryExposureKey.c);
                    f2.d(temporaryExposureKey.f487e);
                    f.b.a.a.a.d0.d a2 = f2.a();
                    int i3 = i2 + 1;
                    if (objArr.length < i3) {
                        objArr = Arrays.copyOf(objArr, b.AbstractC0105b.b(objArr.length, i3));
                    }
                    objArr[i2] = a2;
                    i2 = i3;
                }
                return f.b.b.b.c.p(objArr, i2);
            }
        }, this.z).z(new f.b.b.f.a.i() { // from class: f.b.a.a.a.e0.y2
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: INVOKE  (r5v7 'y2' f.b.b.f.a.l) = 
                  (wrap: f.b.b.f.a.l : 0x0040: INVOKE  (r5v6 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x0035: INVOKE  (r5v5 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x002a: INVOKE  (r5v4 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x001f: INVOKE  (r5v3 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x0014: INVOKE  (r1v3 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.u<f.b.a.a.a.n0.j0> : 0x0010: INVOKE  (r1v2 f.b.b.f.a.u<f.b.a.a.a.n0.j0> A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) type: VIRTUAL call: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.e():f.b.b.f.a.u)
                 type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.e0.z4 : 0x001a: CONSTRUCTOR  (r2v1 f.b.a.a.a.e0.z4 A[REMOVE]) = 
                  (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel)
                  (wrap: f.b.b.b.c : 0x0002: CHECK_CAST (r5v1 f.b.b.b.c A[REMOVE]) = (f.b.b.b.c) (r5v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.z4.<init>(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel, f.b.b.b.c):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x001d: IGET  (r5v2 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.z java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.y(f.b.b.a.g, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.e0.l4 : 0x0025: CONSTRUCTOR  (r1v4 f.b.a.a.a.e0.l4 A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) call: f.b.a.a.a.e0.l4.<init>(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0028: IGET  (r2v2 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.y java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.e0.j3 : 0x0030: CONSTRUCTOR  (r1v5 f.b.a.a.a.e0.j3 A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) call: f.b.a.a.a.e0.j3.<init>(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0033: IGET  (r2v3 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.z java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.e0.i3 : 0x003b: CONSTRUCTOR  (r1v6 f.b.a.a.a.e0.i3 A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) call: f.b.a.a.a.e0.i3.<init>(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x003e: IGET  (r2v4 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.y java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.e0.z3 : 0x0046: CONSTRUCTOR  (r1v7 f.b.a.a.a.e0.z3 A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) call: f.b.a.a.a.e0.z3.<init>(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0049: IGET  (r2v5 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.z java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.y(f.b.b.a.g, java.util.concurrent.Executor):f.b.b.f.a.l in method: f.b.a.a.a.e0.y2.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.z4, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 10 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r5) {
                /*
                    r4 = this;
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel r0 = com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.this
                    f.b.b.b.c r5 = (f.b.b.b.c) r5
                    f.b.a.a.a.t.p0.a r1 = com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.R
                    java.util.Objects.requireNonNull(r0)
                    f.b.a.a.a.t.p0.a r1 = com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.R
                    java.lang.String r2 = "Certifying and uploading keys..."
                    r1.a(r2)
                    f.b.b.f.a.u r1 = r0.e()
                    f.b.b.f.a.l r1 = f.b.b.f.a.l.x(r1)
                    f.b.a.a.a.e0.z4 r2 = new f.b.a.a.a.e0.z4
                    r2.<init>(r0, r5)
                    java.util.concurrent.ExecutorService r5 = r0.z
                    f.b.b.f.a.l r5 = r1.y(r2, r5)
                    f.b.a.a.a.e0.l4 r1 = new f.b.a.a.a.e0.l4
                    r1.<init>(r0)
                    java.util.concurrent.ExecutorService r2 = r0.y
                    f.b.b.f.a.l r5 = r5.z(r1, r2)
                    f.b.a.a.a.e0.j3 r1 = new f.b.a.a.a.e0.j3
                    r1.<init>(r0)
                    java.util.concurrent.ExecutorService r2 = r0.z
                    f.b.b.f.a.l r5 = r5.z(r1, r2)
                    f.b.a.a.a.e0.i3 r1 = new f.b.a.a.a.e0.i3
                    r1.<init>(r0)
                    java.util.concurrent.ExecutorService r2 = r0.y
                    f.b.b.f.a.l r5 = r5.z(r1, r2)
                    f.b.a.a.a.e0.z3 r1 = new f.b.a.a.a.e0.z3
                    r1.<init>(r0)
                    java.util.concurrent.ExecutorService r2 = r0.z
                    f.b.b.f.a.l r5 = r5.y(r1, r2)
                    java.lang.Class<f.b.a.c.b.l.b> r1 = f.b.a.c.b.l.b.class
                    f.b.a.a.a.e0.d4 r2 = new f.b.a.a.a.e0.d4
                    r2.<init>(r0)
                    java.util.concurrent.ExecutorService r0 = r0.z
                    f.b.b.f.a.a$b r3 = new f.b.b.f.a.a$b
                    r3.<init>(r5, r1, r2)
                    java.util.concurrent.Executor r0 = f.b.a.c.b.o.b.k1(r0, r3)
                    r5.a(r3, r0)
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.y2.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, this.y).y(new f.b.b.a.g() { // from class: f.b.a.a.a.e0.v3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel.this.o.j(Boolean.FALSE);
                return null;
            }
        }, this.z);
        l3 l3Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.l3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                f0.c cVar = (f0.c) obj;
                shareDiagnosisViewModel.r.j(shareDiagnosisViewModel.f409g.getString(R.string.share_error_no_internet));
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                return null;
            }
        };
        ExecutorService executorService = this.z;
        a.b bVar = new a.b(y, f0.c.class, l3Var);
        y.a(bVar, f.b.a.c.b.o.b.k1(executorService, bVar));
        h3 h3Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.h3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                Objects.requireNonNull(shareDiagnosisViewModel);
                shareDiagnosisViewModel.h(((f0.d) obj).b, shareDiagnosisViewModel.r);
                return null;
            }
        };
        ExecutorService executorService2 = this.z;
        a.b bVar2 = new a.b(bVar, f0.d.class, h3Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.k1(executorService2, bVar2));
        r4 r4Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.r4
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                f.b.a.c.b.l.b bVar3 = (f.b.a.c.b.l.b) obj;
                Objects.requireNonNull(shareDiagnosisViewModel);
                if (bVar3.b.c == 6) {
                    shareDiagnosisViewModel.s.j(bVar3);
                    return null;
                }
                ShareDiagnosisViewModel.R.h("No RESOLUTION_REQUIRED in result", bVar3);
                shareDiagnosisViewModel.r.j(shareDiagnosisViewModel.f409g.getString(R.string.generic_error_message));
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                return null;
            }
        };
        ExecutorService executorService3 = this.z;
        a.b bVar3 = new a.b(bVar2, f.b.a.c.b.l.b.class, r4Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.k1(executorService3, bVar3));
        f3 f3Var = new f.b.b.a.g() { // from class: f.b.a.a.a.e0.f3
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisViewModel.this;
                Exception exc = (Exception) obj;
                shareDiagnosisViewModel.r.j(shareDiagnosisViewModel.f409g.getString(R.string.generic_error_message));
                shareDiagnosisViewModel.o.j(Boolean.FALSE);
                return null;
            }
        };
        ExecutorService executorService4 = this.z;
        a.b bVar4 = new a.b(bVar3, Exception.class, f3Var);
        bVar3.a(bVar4, f.b.a.c.b.o.b.k1(executorService4, bVar4));
        return bVar4;
    }
}
