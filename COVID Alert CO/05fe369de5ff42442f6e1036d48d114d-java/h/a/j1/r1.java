package h.a.j1;

import h.a.c;
import h.a.c1;
import h.a.j;
import h.a.j1.m1;
import h.a.j1.n2;
import h.a.j1.o2;
import h.a.j1.s0;
import h.a.n0;
import h.a.o0;
import h.a.q;
import java.util.HashSet;
import java.util.concurrent.Executor;

public final class r1 extends n2<ReqT> {
    public final /* synthetic */ o0 A;
    public final /* synthetic */ c B;
    public final /* synthetic */ q C;
    public final /* synthetic */ m1.h D;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    /* JADX WARNING: Illegal instructions before constructor call */
    public r1(m1.h hVar, o0 o0Var, n0 n0Var, c cVar, n2.x xVar, q qVar) {
        super(o0Var, n0Var, r3, r4, r6, r8 == null ? r0.f3905h : r8, r0.f3903f.p(), (o2.a) cVar.a(r2.f4007d), (s0.a) cVar.a(r2.f4008e), xVar);
        this.D = hVar;
        this.A = o0Var;
        this.B = cVar;
        this.C = qVar;
        m1 m1Var = m1.this;
        n2.q qVar2 = m1Var.T;
        long j2 = m1Var.U;
        long j3 = m1Var.V;
        Executor executor = cVar.b;
    }

    @Override // h.a.j1.n2
    public u v(j.a aVar, n0 n0Var) {
        c f2 = this.B.f(aVar);
        w a = this.D.a(new h2(this.A, n0Var, f2));
        q d2 = this.C.d();
        try {
            return a.g(this.A, n0Var, f2);
        } finally {
            this.C.Q(d2);
        }
    }

    @Override // h.a.j1.n2
    public void w() {
        c1 c1Var;
        m1.v vVar = m1.this.E;
        synchronized (vVar.a) {
            vVar.b.remove(this);
            if (vVar.b.isEmpty()) {
                c1Var = vVar.c;
                vVar.b = new HashSet();
            } else {
                c1Var = null;
            }
        }
        if (c1Var != null) {
            m1.this.D.d(c1Var);
        }
    }

    @Override // h.a.j1.n2
    public c1 x() {
        c1 c1Var;
        m1.v vVar = m1.this.E;
        synchronized (vVar.a) {
            c1Var = vVar.c;
            if (c1Var == null) {
                vVar.b.add(this);
                c1Var = null;
            }
        }
        return c1Var;
    }
}
