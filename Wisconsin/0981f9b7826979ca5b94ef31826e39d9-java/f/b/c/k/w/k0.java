package f.b.c.k.w;

import f.b.c.k.x.m;

public final /* synthetic */ class k0 implements Runnable {
    public final l0 b;

    public k0(l0 l0Var) {
        this.b = l0Var;
    }

    public void run() {
        l0 l0Var = this.b;
        if (l0Var.f3150e) {
            m.a(m.a.DEBUG, "RemoteStore", "Restarting streams for network reachability change.", new Object[0]);
            l0Var.d();
        }
    }
}
