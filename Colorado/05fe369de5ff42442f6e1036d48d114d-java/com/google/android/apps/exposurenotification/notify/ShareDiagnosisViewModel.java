package com.google.android.apps.exposurenotification.notify;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.b.a.m;
import e.p.e0;
import e.p.q;
import e.p.s;
import e.p.y;
import e.t.i;
import f.b.a.a.a.b0.a1;
import f.b.a.a.a.b0.b1;
import f.b.a.a.a.b0.d1;
import f.b.a.a.a.b0.f1;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.p;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.c0;
import f.b.a.a.a.o.f0;
import f.b.a.a.a.o.j0;
import f.b.a.a.a.q.i1;
import f.b.a.a.a.s.a3;
import f.b.a.a.a.s.b3;
import f.b.a.a.a.s.c4;
import f.b.a.a.a.s.d3;
import f.b.a.a.a.s.d4;
import f.b.a.a.a.s.e4;
import f.b.a.a.a.s.f3;
import f.b.a.a.a.s.f4;
import f.b.a.a.a.s.g4;
import f.b.a.a.a.s.h3;
import f.b.a.a.a.s.i3;
import f.b.a.a.a.s.j3;
import f.b.a.a.a.s.j4;
import f.b.a.a.a.s.k4;
import f.b.a.a.a.s.m3;
import f.b.a.a.a.s.m4;
import f.b.a.a.a.s.n4;
import f.b.a.a.a.s.o3;
import f.b.a.a.a.s.p3;
import f.b.a.a.a.s.s2;
import f.b.a.a.a.s.t2;
import f.b.a.a.a.s.u2;
import f.b.a.a.a.s.v2;
import f.b.a.a.a.s.w3;
import f.b.a.a.a.s.x5;
import f.b.a.a.a.s.y4;
import f.b.a.a.a.s.z2;
import f.b.a.d.a.a0;
import f.b.b.a.g;
import f.b.b.a.l;
import f.b.b.f.a.a;
import f.b.b.f.a.u;
import gov.co.cdphe.exposurenotifications.R;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class ShareDiagnosisViewModel extends e0 {
    public static final f.b.a.a.a.i.e0.a O = f.b.a.a.a.i.e0.a.e("ShareDiagnosisViewModel");
    public static final e P;
    public static final e Q;
    public static final l.b.a.d R = l.b.a.d.n(5);
    public static final Set<String> S = f.b.b.b.e.p(2, "ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_TEST_DATE", "ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_PHONE_NUMBER");
    public static final Set<ExposureNotificationViewModel.b> T;
    public static final h0 U = h0.q().a();
    public static final l.b.a.d V = l.b.a.d.n(10);
    public final LiveData<h0> A = new s(U);
    public final s<b> B = new s<>();
    public final Stack<b> C = new Stack<>();
    public final s<String> D = new s<>();
    public final s<String> E = new s<>();
    public final s<String> F = new s<>();
    public final Context G;
    public y H;
    public x5 I = x5.DEFAULT;
    public boolean J = false;
    public boolean K = false;
    public boolean L = false;
    public boolean M = false;
    public boolean N;
    public final i0 c;

    /* renamed from: d  reason: collision with root package name */
    public final f1 f403d;

    /* renamed from: e  reason: collision with root package name */
    public final f0 f404e;

    /* renamed from: f  reason: collision with root package name */
    public final i1 f405f;

    /* renamed from: g  reason: collision with root package name */
    public final Resources f406g;

    /* renamed from: h  reason: collision with root package name */
    public final v0 f407h;

    /* renamed from: i  reason: collision with root package name */
    public final a0 f408i;

    /* renamed from: j  reason: collision with root package name */
    public final f.b.a.a.a.i.f0.a f409j;

    /* renamed from: k  reason: collision with root package name */
    public final c0 f410k;

    /* renamed from: l  reason: collision with root package name */
    public final SecureRandom f411l;
    public final f.b.a.a.a.r.b m;
    public final s<Long> n = new s<>(-1L);
    public final s<Boolean> o = new s<>(Boolean.FALSE);
    public final f.b.a.a.a.i.a0<Void> p = new f.b.a.a.a.i.a0<>();
    public final f.b.a.a.a.i.a0<String> q = new f.b.a.a.a.i.a0<>();
    public final f.b.a.a.a.i.a0<f.b.a.c.b.l.b> r = new f.b.a.a.a.i.a0<>();
    public final f.b.a.a.a.i.a0<f.b.a.c.b.l.b> s = new f.b.a.a.a.i.a0<>();
    public final f.b.a.a.a.i.a0<Boolean> t = new f.b.a.a.a.i.a0<>();
    public final f.b.a.a.a.i.a0<Boolean> u = new f.b.a.a.a.i.a0<>();
    public final f.b.a.a.a.i.a0<Boolean> v = new f.b.a.a.a.i.a0<>();
    public final s<l<v0.i>> w = new s<>(f.b.b.a.a.b);
    public final ExecutorService x;
    public final ExecutorService y;
    public final ScheduledExecutorService z;

    public static abstract class a {
        public abstract boolean a();

        public abstract l<String> b();
    }

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

    public static class c extends Exception {
        public final String b;

        public c(String str) {
            this.b = str;
        }
    }

    public static class d extends Exception {
        public final h0 b;

        public d(h0 h0Var) {
            this.b = h0Var;
        }
    }

    public static abstract class e {
        public abstract Integer a();

        public abstract l.b.a.d b();
    }

    static {
        l.b.a.d f2 = l.b.a.d.f(30);
        Objects.requireNonNull((Object) 3, "Null numOfRequests");
        P = new y4(f2, 3, null);
        l.b.a.d l2 = l.b.a.d.l(30);
        Objects.requireNonNull((Object) 1, "Null numOfRequests");
        Q = new y4(l2, 1, null);
        int i2 = f.b.b.b.e.f3071d;
        ExposureNotificationViewModel.b bVar = ExposureNotificationViewModel.b.DISABLED;
        ExposureNotificationViewModel.b bVar2 = ExposureNotificationViewModel.b.FOCUS_LOST;
        ExposureNotificationViewModel.b bVar3 = ExposureNotificationViewModel.b.STORAGE_LOW;
        ExposureNotificationViewModel.b bVar4 = ExposureNotificationViewModel.b.PAUSED_USER_PROFILE_NOT_SUPPORT;
        ExposureNotificationViewModel.b bVar5 = ExposureNotificationViewModel.b.PAUSED_NOT_IN_ALLOWLIST;
        ExposureNotificationViewModel.b bVar6 = ExposureNotificationViewModel.b.PAUSED_HW_NOT_SUPPORT;
        ExposureNotificationViewModel.b[] bVarArr = {ExposureNotificationViewModel.b.PAUSED_EN_NOT_SUPPORT};
        f.b.a.c.b.o.b.o(true, "the total number of elements must fit in an int");
        Object[] objArr = new Object[7];
        objArr[0] = bVar;
        objArr[1] = bVar2;
        objArr[2] = bVar3;
        objArr[3] = bVar4;
        objArr[4] = bVar5;
        objArr[5] = bVar6;
        System.arraycopy(bVarArr, 0, objArr, 6, 1);
        T = f.b.b.b.e.p(7, objArr);
    }

    public ShareDiagnosisViewModel(Context context, y yVar, f0 f0Var, i0 i0Var, f1 f1Var, i1 i1Var, v0 v0Var, a0 a0Var, f.b.a.a.a.i.f0.a aVar, c0 c0Var, SecureRandom secureRandom, f.b.a.a.a.r.b bVar, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService) {
        this.G = context;
        this.H = yVar;
        this.f404e = f0Var;
        this.c = i0Var;
        this.f403d = f1Var;
        this.f405f = i1Var;
        this.f407h = v0Var;
        this.f408i = a0Var;
        this.f409j = aVar;
        this.f410k = c0Var;
        this.f411l = secureRandom;
        this.m = bVar;
        this.x = executorService;
        this.y = executorService2;
        this.z = scheduledExecutorService;
        this.f406g = context.getResources();
    }

    public final u<Long> c(j0 j0Var) {
        Long l2 = 0L;
        l.b.a.e c2 = this.f409j.c();
        Objects.requireNonNull(c2, "Null requestTime");
        String e2 = j0Var.e();
        Objects.requireNonNull(e2, "Null nonce");
        l.b.a.e A2 = j0Var.b() > 0 ? l.b.a.e.A(j0Var.b()) : null;
        f1 f1Var = this.f403d;
        String str = l2 == null ? " id" : "";
        if (str.isEmpty()) {
            p pVar = new p(l2.longValue(), c2, A2, e2, null);
            a1 a1Var = (a1) f1Var.a;
            return e.t.n.d.a(a1Var.a, true, new b1(a1Var, pVar));
        }
        throw new IllegalStateException(f.a.a.a.a.c("Missing required properties:", str));
    }

    public final u<l.b.a.e> d(e eVar) {
        l.b.a.e w2 = this.f409j.c().w(eVar.b());
        f1 f1Var = this.f403d;
        int intValue = eVar.a().intValue();
        a1 a1Var = (a1) f1Var.a;
        Objects.requireNonNull(a1Var);
        i t2 = i.t("SELECT * FROM VerificationCodeRequestEntity WHERE requestTime >= ? ORDER BY requestTime DESC LIMIT ?", 2);
        t2.x(1, m.h.Z(w2));
        t2.x(2, (long) intValue);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return f.b.b.f.a.l.x(e.t.n.d.b(a1Var.a, false, new d1(a1Var, t2, cancellationSignal), t2, true, cancellationSignal)).y(new i3(eVar), this.y);
    }

    public final u<h0> e() {
        return f.b.b.f.a.l.x(this.c.b(this.n.d().longValue())).y(new v2(this), this.x);
    }

    public LiveData<h0> f() {
        s<Long> sVar = this.n;
        h3 h3Var = new h3(this);
        q qVar = new q();
        qVar.m(sVar, new e.p.c0(h3Var, qVar));
        return m.h.S(qVar);
    }

    public LiveData<Pair<Integer, Integer>> g() {
        return m.h.G0(this.B, new m4(this));
    }

    public boolean h() {
        return TextUtils.isEmpty(this.G.getResources().getString(R.string.share_travel_detail));
    }

    public final void i() {
        if (!this.C.isEmpty()) {
            this.C.pop();
        }
    }

    public void j(b bVar) {
        if (bVar != null) {
            this.C.push(bVar);
            this.B.j(bVar);
        }
    }

    public void k(b bVar) {
        if (bVar != null) {
            this.C.clear();
            j(bVar);
        }
    }

    public void l(long j2) {
        this.n.j(Long.valueOf(j2));
    }

    public u<?> m() {
        this.o.j(Boolean.TRUE);
        f.b.b.f.a.l y2 = f.b.b.f.a.l.x(m.h.i0(this.f405f.a.h(), R, this.z)).y(new p3(this), this.y);
        u2 u2Var = new u2(this);
        ExecutorService executorService = this.y;
        a.b bVar = new a.b(y2, f.b.a.c.b.l.b.class, u2Var);
        y2.a(bVar, f.b.a.c.b.o.b.g1(executorService, bVar));
        g4 g4Var = new g4(this);
        ExecutorService executorService2 = this.y;
        a.b bVar2 = new a.b(bVar, Exception.class, g4Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.g1(executorService2, bVar2));
        return bVar2;
    }

    public void n(b bVar) {
        if (bVar != null) {
            i();
            if (!this.C.isEmpty()) {
                if (!this.C.peek().equals(bVar)) {
                    this.C.clear();
                }
                this.B.j(bVar);
            }
            this.C.push(bVar);
            this.B.j(bVar);
        }
    }

    public final u<Long> o(g<h0, h0> gVar) {
        return f.b.b.f.a.l.x(e()).y(new c4(this, gVar), this.x).y(new d4(this), this.y);
    }

    public void p(long j2) {
        this.n.l(Long.valueOf(j2));
    }

    public void q(x5 x5Var) {
        if (x5.SELF_REPORT.equals(x5Var)) {
            p(-1);
            y yVar = this.H;
            Objects.requireNonNull(yVar);
            HashSet hashSet = new HashSet(yVar.a.keySet());
            hashSet.addAll(yVar.b.keySet());
            hashSet.addAll(yVar.c.keySet());
            hashSet.removeAll(S);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                y yVar2 = this.H;
                yVar2.a.remove(str);
                y.b<?> remove = yVar2.c.remove(str);
                if (remove != null) {
                    remove.m = null;
                }
            }
        }
        this.I = x5Var;
    }

    public boolean r(Resources resources) {
        return this.f408i.a() && this.f408i.b() && !TextUtils.isEmpty(resources.getString(R.string.share_vaccination_detail));
    }

    public void s(h0 h0Var) {
        i();
        j(m.h.m0(b.CODE, h0Var, this.I, r(this.f406g), this.G));
    }

    public void t(f.b.a.c.b.l.b bVar, e.a.e.c<e.a.e.e> cVar) {
        PendingIntent pendingIntent = bVar.b.f456e;
        if (pendingIntent != null) {
            cVar.a(new e.a.e.e(pendingIntent.getIntentSender(), null, 0, 0), null);
        }
    }

    public u<?> u(String str, boolean z2) {
        if (this.o.d().booleanValue()) {
            return f.b.b.f.a.s.c;
        }
        this.o.j(Boolean.TRUE);
        O.a("Checking verification code locally");
        f.b.b.f.a.l y2 = f.b.b.f.a.l.x(this.c.c(str)).z(new s2(this), this.y).z(new w3(this, str), this.y).z(new n4(this, str, z2), this.x).z(new a3(this), this.y).y(new m3(this), this.y);
        z2 z2Var = new z2(this);
        ExecutorService executorService = this.y;
        a.b bVar = new a.b(y2, d.class, z2Var);
        y2.a(bVar, f.b.a.c.b.o.b.g1(executorService, bVar));
        j4 j4Var = new j4(this);
        ExecutorService executorService2 = this.y;
        a.b bVar2 = new a.b(bVar, f0.c.class, j4Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.g1(executorService2, bVar2));
        f4 f4Var = new f4(this);
        ExecutorService executorService3 = this.y;
        a.b bVar3 = new a.b(bVar2, f0.d.class, f4Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.g1(executorService3, bVar3));
        k4 k4Var = new k4(this);
        ExecutorService executorService4 = this.y;
        a.b bVar4 = new a.b(bVar3, Exception.class, k4Var);
        bVar3.a(bVar4, f.b.a.c.b.o.b.g1(executorService4, bVar4));
        return bVar4;
    }

    public u<?> v() {
        this.o.j(Boolean.TRUE);
        O.a("Getting current TEKs from EN API...");
        f.b.b.f.a.l y2 = f.b.b.f.a.l.x(m.h.i0(this.f405f.a.c(), V, this.z)).y(new j3(this), this.y).z(new t2(this), this.x).y(new o3(this), this.y);
        f3 f3Var = new f3(this);
        ExecutorService executorService = this.y;
        a.b bVar = new a.b(y2, f0.c.class, f3Var);
        y2.a(bVar, f.b.a.c.b.o.b.g1(executorService, bVar));
        d3 d3Var = new d3(this);
        ExecutorService executorService2 = this.y;
        a.b bVar2 = new a.b(bVar, f0.d.class, d3Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.g1(executorService2, bVar2));
        e4 e4Var = new e4(this);
        ExecutorService executorService3 = this.y;
        a.b bVar3 = new a.b(bVar2, f.b.a.c.b.l.b.class, e4Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.g1(executorService3, bVar3));
        b3 b3Var = new b3(this);
        ExecutorService executorService4 = this.y;
        a.b bVar4 = new a.b(bVar3, Exception.class, b3Var);
        bVar3.a(bVar4, f.b.a.c.b.o.b.g1(executorService4, bVar4));
        return bVar4;
    }
}
