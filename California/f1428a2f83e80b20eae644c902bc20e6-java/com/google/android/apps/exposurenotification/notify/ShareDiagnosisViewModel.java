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
import e.t.g;
import e.t.i;
import f.b.a.a.a.l.u;
import f.b.a.a.a.n.f0;
import f.b.a.a.a.p.d2;
import f.b.a.a.a.p.f2;
import f.b.a.a.a.p.h2;
import f.b.a.a.a.p.i2;
import f.b.a.a.a.p.n2;
import f.b.a.a.a.p.o2;
import f.b.a.a.a.p.p2;
import f.b.a.a.a.p.q2;
import f.b.a.a.a.p.r2;
import f.b.a.a.a.p.u1;
import f.b.a.a.a.p.w1;
import f.b.a.a.a.p.x1;
import f.b.a.a.a.p.z1;
import f.b.a.a.a.w.b0;
import f.b.a.a.a.w.c0;
import f.b.a.a.a.w.v;
import f.b.a.a.a.w.w;
import f.b.b.a.l;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.p;
import f.b.b.f.a.s;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class ShareDiagnosisViewModel extends a0 {
    public static final l.b.a.c z = l.b.a.c.l(10);
    public final c0 c;

    /* renamed from: d  reason: collision with root package name */
    public final u f371d;

    /* renamed from: e  reason: collision with root package name */
    public final f0 f372e;

    /* renamed from: f  reason: collision with root package name */
    public final Resources f373f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.a.a.a.o.b f374g;

    /* renamed from: h  reason: collision with root package name */
    public final q<Long> f375h = new q<>(-1L);

    /* renamed from: i  reason: collision with root package name */
    public final q<Boolean> f376i = new q<>(Boolean.FALSE);

    /* renamed from: j  reason: collision with root package name */
    public final f.b.a.a.a.h.q<Void> f377j = new f.b.a.a.a.h.q<>();

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.a.a.h.q<String> f378k = new f.b.a.a.a.h.q<>();

    /* renamed from: l  reason: collision with root package name */
    public final f.b.a.a.a.h.q<f.b.a.c.b.l.b> f379l = new f.b.a.a.a.h.q<>();
    public final f.b.a.a.a.h.q<Boolean> m = new f.b.a.a.a.h.q<>();
    public final f.b.a.a.a.h.q<Boolean> n = new f.b.a.a.a.h.q<>();
    public final ExecutorService o;
    public final ExecutorService p;
    public final ScheduledExecutorService q;
    public final LiveData<b0> r = new q(b0.o().a());
    public final q<e> s = new q<>();
    public final Stack<e> t = new Stack<>();
    public final q<String> u = new q<>("");
    public final Context v;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;

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
            ShareDiagnosisViewModel.this.f375h.j(-1L);
            ShareDiagnosisViewModel.this.f377j.j(null);
        }
    }

    public class b implements p<Object> {
        public b() {
        }

        @Override // f.b.b.f.a.p
        public void a(Throwable th) {
            String string = ShareDiagnosisViewModel.this.f373f.getString(R.string.generic_error_message);
            if (th instanceof u.b) {
                string = ShareDiagnosisViewModel.this.f373f.getString(R.string.network_error_server_error);
            } else if (th instanceof u.a) {
                string = ShareDiagnosisViewModel.this.f373f.getString(R.string.generic_error_message);
            } else if (th instanceof f.b.a.c.b.l.b) {
                f.b.a.c.b.l.b bVar = (f.b.a.c.b.l.b) th;
                if (bVar.b.c == 6) {
                    ShareDiagnosisViewModel.this.f379l.j(bVar);
                    return;
                }
                Log.w("ShareDiagnosisViewModel", "No RESOLUTION_REQUIRED in result", bVar);
            }
            ShareDiagnosisViewModel.this.f378k.j(string);
            ShareDiagnosisViewModel.this.f376i.j(Boolean.FALSE);
        }

        @Override // f.b.b.f.a.p
        public void b(Object obj) {
            ShareDiagnosisViewModel.this.f376i.j(Boolean.FALSE);
        }
    }

    public static abstract class c {
        public abstract boolean a();

        public abstract l<String> b();
    }

    public static class d extends Exception {
        public d() {
        }

        public d(a aVar) {
        }
    }

    public enum e {
        BEGIN,
        CODE,
        ONSET,
        REVIEW,
        SHARED,
        NOT_SHARED,
        TRAVEL_STATUS,
        VIEW
    }

    public static class f extends Exception {
        public final b0 b;

        public f(b0 b0Var) {
            this.b = b0Var;
        }
    }

    public ShareDiagnosisViewModel(Context context, u uVar, c0 c0Var, f0 f0Var, f.b.a.a.a.o.b bVar, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService) {
        this.v = context;
        this.f371d = uVar;
        this.c = c0Var;
        this.f372e = f0Var;
        this.f374g = bVar;
        this.o = executorService;
        this.p = executorService2;
        this.q = scheduledExecutorService;
        this.f373f = context.getResources();
    }

    public void c(b0 b0Var) {
        c0 c0Var = this.c;
        long e2 = b0Var.e();
        f.b.a.a.a.w.u uVar = (f.b.a.a.a.w.u) c0Var.a;
        g gVar = uVar.a;
        v vVar = new v(uVar, e2);
        Executor executor = gVar.c;
        e.f.a.f fVar = new e.f.a.f();
        executor.execute(new e.t.n.c(vVar, fVar));
        a aVar = new a();
        fVar.a(new f.b.b.f.a.q(fVar, aVar), this.p);
    }

    public final f.b.b.f.a.u<b0> d() {
        return f.b.b.f.a.l.x(this.c.a(this.f375h.d().longValue())).y(new w1(this), this.o);
    }

    public LiveData<b0> e() {
        q<Long> qVar = this.f375h;
        d2 d2Var = new d2(this);
        o oVar = new o();
        oVar.m(qVar, new y(d2Var, oVar));
        return m.h.R(oVar);
    }

    public void f(e eVar) {
        if (eVar != null) {
            this.t.push(eVar);
            this.s.j(eVar);
        }
    }

    public void g(e eVar) {
        if (eVar != null) {
            this.t.clear();
            f(eVar);
        }
    }

    public void h(long j2) {
        this.f375h.j(Long.valueOf(j2));
    }

    public void i(e eVar) {
        if (eVar != null) {
            this.t.pop();
            if (!this.t.isEmpty()) {
                if (!this.t.peek().equals(eVar)) {
                    this.t.clear();
                }
                this.s.j(eVar);
            }
            this.t.push(eVar);
            this.s.j(eVar);
        }
    }

    public final f.b.b.f.a.u<Long> j(f.b.b.a.g<b0, b0> gVar) {
        return f.b.b.f.a.l.x(d()).y(new z1(this, gVar), this.o).y(new h2(this), this.p);
    }

    public f.b.b.f.a.u<?> k(String str, boolean z2) {
        if (this.f376i.d().booleanValue()) {
            return s.c;
        }
        this.f376i.l(Boolean.TRUE);
        f.b.a.a.a.w.u uVar = (f.b.a.a.a.w.u) this.c.a;
        Objects.requireNonNull(uVar);
        i v2 = i.v("SELECT * FROM DiagnosisEntity WHERE verificationCode = ?", 1);
        if (str == null) {
            v2.N(1);
        } else {
            v2.P(1, str);
        }
        CancellationSignal cancellationSignal = new CancellationSignal();
        f.b.b.f.a.l y2 = f.b.b.f.a.l.x(e.t.n.d.a(uVar.a, false, new w(uVar, v2, cancellationSignal), v2, true, cancellationSignal)).z(new n2(this, str), this.p).z(new o2(this, str, z2), this.o).z(new x1(this), this.p).y(new p2(this), this.p);
        q2 q2Var = new q2(this);
        ExecutorService executorService = this.p;
        a.b bVar = new a.b(y2, f.class, q2Var);
        ((l.a) y2).a(bVar, f.b.a.c.b.o.b.A1(executorService, bVar));
        r2 r2Var = new r2(this);
        ExecutorService executorService2 = this.p;
        a.b bVar2 = new a.b(bVar, d.class, r2Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.A1(executorService2, bVar2));
        i2 i2Var = new i2(this);
        ExecutorService executorService3 = this.p;
        a.b bVar3 = new a.b(bVar2, Exception.class, i2Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.A1(executorService3, bVar3));
        return bVar3;
    }

    public f.b.b.f.a.u<?> l() {
        this.f376i.j(Boolean.TRUE);
        f.b.b.f.a.l z2 = f.b.b.f.a.l.x(m.h.g0(this.f372e.a.b(), z, this.q)).y(new f2(this), this.p).z(new u1(this), this.o);
        b bVar = new b();
        ExecutorService executorService = this.p;
        ((l.a) z2).a(new f.b.b.f.a.q(z2, bVar), executorService);
        return z2;
    }
}
