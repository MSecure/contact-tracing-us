package h.a.j1;

import h.a.a0;
import h.a.e;

public class d1 implements Runnable {
    public final /* synthetic */ z0 b;

    public d1(z0 z0Var) {
        this.b = z0Var;
    }

    public void run() {
        this.b.f3790j.a(e.a.INFO, "Terminated");
        z0 z0Var = this.b;
        t1 t1Var = (t1) z0Var.f3785e;
        m1.this.B.remove(z0Var);
        a0.b(m1.this.O.b, z0Var);
        m1.p(m1.this);
    }
}
