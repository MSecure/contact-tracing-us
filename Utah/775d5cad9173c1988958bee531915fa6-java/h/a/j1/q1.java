package h.a.j1;

public final class q1 implements Runnable {
    public final /* synthetic */ m1 b;

    public q1(m1 m1Var) {
        this.b = m1Var;
    }

    public void run() {
        m1 m1Var = this.b;
        if (!m1Var.G) {
            m1Var.G = true;
            m1.n(m1Var);
        }
    }
}
