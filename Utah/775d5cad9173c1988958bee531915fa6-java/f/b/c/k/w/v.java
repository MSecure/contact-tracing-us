package f.b.c.k.w;

import f.b.c.k.x.m;
import h.a.k0;

public final /* synthetic */ class v implements Runnable {
    public final b0 b;
    public final k0 c;

    public v(b0 b0Var, k0 k0Var) {
        this.b = b0Var;
        this.c = k0Var;
    }

    public void run() {
        b0 b0Var = this.b;
        k0 k0Var = this.c;
        m.a(m.a.DEBUG, "GrpcCallProvider", "connectivityAttemptTimer elapsed. Resetting the channel.", new Object[0]);
        b0Var.a();
        b0Var.b.b(new x(b0Var, k0Var));
    }
}
