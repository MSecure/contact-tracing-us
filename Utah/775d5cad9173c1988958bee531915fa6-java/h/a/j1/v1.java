package h.a.j1;

import h.a.a0;
import h.a.j1.m1;

public class v1 implements Runnable {
    public final /* synthetic */ z0 b;
    public final /* synthetic */ m1.u c;

    public v1(m1.u uVar, z0 z0Var) {
        this.c = uVar;
        this.b = z0Var;
    }

    public void run() {
        a0 a0Var = m1.this.O;
        a0.a(a0Var.b, this.b);
        m1.this.B.add(this.b);
    }
}
