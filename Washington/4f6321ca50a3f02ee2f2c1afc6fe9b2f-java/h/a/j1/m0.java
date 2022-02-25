package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import h.a.c1;
import h.a.d0;
import h.a.j1.w;
import h.a.j1.y1;
import java.util.concurrent.Executor;

public abstract class m0 implements z {
    @Override // h.a.j1.y1
    public void a(c1 c1Var) {
        b().a(c1Var);
    }

    public abstract z b();

    @Override // h.a.c0
    public d0 c() {
        return b().c();
    }

    @Override // h.a.j1.y1
    public void d(c1 c1Var) {
        b().d(c1Var);
    }

    @Override // h.a.j1.y1
    public Runnable e(y1.a aVar) {
        return b().e(aVar);
    }

    @Override // h.a.j1.w
    public void f(w.a aVar, Executor executor) {
        b().f(aVar, executor);
    }

    public String toString() {
        k U1 = b.U1(this);
        U1.d("delegate", b());
        return U1.toString();
    }
}
