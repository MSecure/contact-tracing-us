package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import h.a.c;
import h.a.f;
import h.a.k0;
import h.a.n;
import h.a.o0;

public abstract class n0 extends k0 {
    public final k0 a;

    public n0(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // h.a.d
    public String b() {
        return this.a.b();
    }

    @Override // h.a.d
    public <RequestT, ResponseT> f<RequestT, ResponseT> h(o0<RequestT, ResponseT> o0Var, c cVar) {
        return this.a.h(o0Var, cVar);
    }

    @Override // h.a.k0
    public void i() {
        this.a.i();
    }

    @Override // h.a.k0
    public n j(boolean z) {
        return this.a.j(z);
    }

    @Override // h.a.k0
    public void k(n nVar, Runnable runnable) {
        this.a.k(nVar, runnable);
    }

    @Override // h.a.k0
    public void l() {
        this.a.l();
    }

    public String toString() {
        k t1 = b.t1(this);
        t1.d("delegate", this.a);
        return t1.toString();
    }
}
