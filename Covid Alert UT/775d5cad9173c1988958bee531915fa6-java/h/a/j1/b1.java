package h.a.j1;

import h.a.e;
import h.a.g1;
import h.a.n;

public class b1 implements Runnable {
    public final /* synthetic */ z0 b;

    public b1(z0 z0Var) {
        this.b = z0Var;
    }

    public void run() {
        if (this.b.u.a == n.TRANSIENT_FAILURE) {
            z0 z0Var = this.b;
            z0Var.f4106k.d();
            g1.c cVar = z0Var.p;
            if (cVar != null) {
                cVar.a();
                z0Var.p = null;
                z0Var.n = null;
            }
            this.b.f4105j.a(e.a.INFO, "CONNECTING; backoff interrupted");
            z0.h(this.b, n.CONNECTING);
            z0.i(this.b);
        }
    }
}
