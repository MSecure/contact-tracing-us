package com.google.android.apps.exposurenotification.notify;

import android.content.Context;
import android.content.res.Resources;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.lifecycle.LiveData;
import e.b.a.m;
import e.p.a0;
import e.p.o;
import e.p.q;
import e.p.y;
import e.t.i;
import f.b.a.a.a.n.v;
import f.b.a.a.a.p.f0;
import f.b.a.a.a.r.a3;
import f.b.a.a.a.r.d2;
import f.b.a.a.a.r.g2;
import f.b.a.a.a.r.h2;
import f.b.a.a.a.r.i2;
import f.b.a.a.a.r.l2;
import f.b.a.a.a.r.m2;
import f.b.a.a.a.r.n2;
import f.b.a.a.a.r.o2;
import f.b.a.a.a.r.q2;
import f.b.a.a.a.r.r2;
import f.b.a.a.a.r.s2;
import f.b.a.a.a.r.u2;
import f.b.a.a.a.r.v2;
import f.b.a.a.a.r.x2;
import f.b.a.a.a.r.y1;
import f.b.a.a.a.r.y2;
import f.b.a.a.a.r.z1;
import f.b.a.a.a.y.c0;
import f.b.a.a.a.y.d0;
import f.b.a.a.a.y.q0;
import f.b.a.a.a.y.x;
import f.b.b.a.g;
import f.b.b.a.l;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.p;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class ShareDiagnosisViewModel extends a0 {
    public static final l.b.a.c B = l.b.a.c.m(10);
    public boolean A = false;
    public final d0 c;

    /* renamed from: d  reason: collision with root package name */
    public final v f385d;

    /* renamed from: e  reason: collision with root package name */
    public final f0 f386e;

    /* renamed from: f  reason: collision with root package name */
    public final Resources f387f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.a.a.a.q.b f388g;

    /* renamed from: h  reason: collision with root package name */
    public final q0 f389h;

    /* renamed from: i  reason: collision with root package name */
    public final f.b.a.a.a.h.s.a f390i;

    /* renamed from: j  reason: collision with root package name */
    public final q<Long> f391j = new q<>(-1L);

    /* renamed from: k  reason: collision with root package name */
    public final q<Boolean> f392k = new q<>(Boolean.FALSE);

    /* renamed from: l  reason: collision with root package name */
    public final f.b.a.a.a.h.q<Void> f393l = new f.b.a.a.a.h.q<>();
    public final f.b.a.a.a.h.q<String> m = new f.b.a.a.a.h.q<>();
    public final f.b.a.a.a.h.q<f.b.a.c.b.l.b> n = new f.b.a.a.a.h.q<>();
    public final f.b.a.a.a.h.q<Boolean> o = new f.b.a.a.a.h.q<>();
    public final f.b.a.a.a.h.q<Boolean> p = new f.b.a.a.a.h.q<>();
    public final ExecutorService q;
    public final ExecutorService r;
    public final ScheduledExecutorService s;
    public final LiveData<c0> t = new q(c0.o().a());
    public final q<d> u = new q<>();
    public final Stack<d> v = new Stack<>();
    public final q<String> w = new q<>("");
    public final Context x;
    public boolean y = false;
    public boolean z = false;

    public class a implements p<Void> {
        public a() {
        }

        @Override // f.b.b.f.a.p
        public void a(Throwable th) {
            Log.w("ShareDiagnosisViewModel", "Failed to delete", th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // f.b.b.f.a.p
        public void b(Void r3) {
            ShareDiagnosisViewModel.this.f391j.j(-1L);
            ShareDiagnosisViewModel.this.f393l.j(null);
        }
    }

    public static abstract class b {
        public abstract boolean a();

        public abstract l<String> b();
    }

    public static class c extends Exception {
        public c() {
        }

        public c(a aVar) {
        }
    }

    public enum d {
        BEGIN,
        CODE,
        ONSET,
        REVIEW,
        SHARED,
        NOT_SHARED,
        TRAVEL_STATUS,
        VIEW
    }

    public static class e extends Exception {
        public final c0 b;

        public e(c0 c0Var) {
            this.b = c0Var;
        }
    }

    public ShareDiagnosisViewModel(Context context, v vVar, d0 d0Var, f0 f0Var, q0 q0Var, f.b.a.a.a.h.s.a aVar, f.b.a.a.a.q.b bVar, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService) {
        this.x = context;
        this.f385d = vVar;
        this.c = d0Var;
        this.f386e = f0Var;
        this.f389h = q0Var;
        this.f390i = aVar;
        this.f388g = bVar;
        this.q = executorService;
        this.r = executorService2;
        this.s = scheduledExecutorService;
        this.f387f = context.getResources();
    }

    public void c(c0 c0Var) {
        u<Void> a2 = this.c.a(c0Var.e());
        a aVar = new a();
        ExecutorService executorService = this.r;
        ((e.f.a.a) a2).a(new f.b.b.f.a.q(a2, aVar), executorService);
    }

    public final u<c0> d() {
        return f.b.b.f.a.l.x(this.c.b(this.f391j.d().longValue())).y(new z1(this), this.q);
    }

    public LiveData<c0> e() {
        q<Long> qVar = this.f391j;
        g2 g2Var = new g2(this);
        o oVar = new o();
        oVar.m(qVar, new y(g2Var, oVar));
        return m.h.R(oVar);
    }

    public void f(d dVar) {
        if (dVar != null) {
            this.v.push(dVar);
            this.u.j(dVar);
        }
    }

    public void g(d dVar) {
        if (dVar != null) {
            this.v.clear();
            f(dVar);
        }
    }

    public void h(long j2) {
        this.f391j.j(Long.valueOf(j2));
    }

    public void i(d dVar) {
        if (dVar != null) {
            this.v.pop();
            if (!this.v.isEmpty()) {
                if (!this.v.peek().equals(dVar)) {
                    this.v.clear();
                }
                this.u.j(dVar);
            }
            this.v.push(dVar);
            this.u.j(dVar);
        }
    }

    public final u<Long> j(g<c0, c0> gVar) {
        return f.b.b.f.a.l.x(d()).y(new x2(this, gVar), this.q).y(new d2(this), this.r);
    }

    public u<?> k(String str, boolean z2) {
        if (this.f392k.d().booleanValue()) {
            return s.c;
        }
        this.f392k.l(Boolean.TRUE);
        f.b.a.a.a.y.v vVar = (f.b.a.a.a.y.v) this.c.a;
        Objects.requireNonNull(vVar);
        i v2 = i.v("SELECT * FROM DiagnosisEntity WHERE verificationCode = ?", 1);
        if (str == null) {
            v2.N(1);
        } else {
            v2.P(1, str);
        }
        CancellationSignal cancellationSignal = new CancellationSignal();
        f.b.b.f.a.l y2 = f.b.b.f.a.l.x(e.t.n.d.a(vVar.a, false, new x(vVar, v2, cancellationSignal), v2, true, cancellationSignal)).z(new o2(this, str), this.r).z(new i2(this, str, z2), this.q).z(new l2(this), this.r).y(new y2(this), this.r);
        n2 n2Var = new n2(this);
        ExecutorService executorService = this.r;
        a.b bVar = new a.b(y2, e.class, n2Var);
        ((l.a) y2).a(bVar, f.b.a.c.b.o.b.z1(executorService, bVar));
        u2 u2Var = new u2(this);
        ExecutorService executorService2 = this.r;
        a.b bVar2 = new a.b(bVar, c.class, u2Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.z1(executorService2, bVar2));
        m2 m2Var = new m2(this);
        ExecutorService executorService3 = this.r;
        a.b bVar3 = new a.b(bVar2, v.c.class, m2Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.z1(executorService3, bVar3));
        s2 s2Var = new s2(this);
        ExecutorService executorService4 = this.r;
        a.b bVar4 = new a.b(bVar3, Exception.class, s2Var);
        bVar3.a(bVar4, f.b.a.c.b.o.b.z1(executorService4, bVar4));
        return bVar4;
    }

    public u<?> l() {
        this.f392k.j(Boolean.TRUE);
        f.b.b.f.a.l y2 = f.b.b.f.a.l.x(m.h.g0(this.f386e.a.b(), B, this.s)).y(new h2(this), this.r).z(new y1(this), this.q).y(new a3(this), this.r);
        q2 q2Var = new q2(this);
        ExecutorService executorService = this.r;
        a.b bVar = new a.b(y2, v.c.class, q2Var);
        ((l.a) y2).a(bVar, f.b.a.c.b.o.b.z1(executorService, bVar));
        v2 v2Var = new v2(this);
        ExecutorService executorService2 = this.r;
        a.b bVar2 = new a.b(bVar, f.b.a.c.b.l.b.class, v2Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.z1(executorService2, bVar2));
        r2 r2Var = new r2(this);
        ExecutorService executorService3 = this.r;
        a.b bVar3 = new a.b(bVar2, Exception.class, r2Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.z1(executorService3, bVar3));
        return bVar3;
    }
}
