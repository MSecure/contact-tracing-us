package h.a.j1;

import h.a.e;
import h.a.n;
/* loaded from: classes.dex */
public final class p1 implements Runnable {
    public final /* synthetic */ m1 b;

    public p1(m1 m1Var) {
        this.b = m1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.N.a(e.a.INFO, "Entering SHUTDOWN state");
        this.b.s.a(n.SHUTDOWN);
    }
}
