package h.a.j1;

import h.a.e;
import h.a.n;

public class a1 implements Runnable {
    public final /* synthetic */ z0 b;

    public a1(z0 z0Var) {
        this.b = z0Var;
    }

    public void run() {
        z0 z0Var = this.b;
        z0Var.p = null;
        z0Var.f4105j.a(e.a.INFO, "CONNECTING after backoff");
        z0.h(this.b, n.CONNECTING);
        z0.i(this.b);
    }
}
