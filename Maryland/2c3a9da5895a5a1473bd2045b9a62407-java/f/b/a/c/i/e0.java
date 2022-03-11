package f.b.a.c.i;

import java.util.concurrent.Callable;

public final class e0 implements Runnable {
    public final /* synthetic */ c0 b;
    public final /* synthetic */ Callable c;

    public e0(c0 c0Var, Callable callable) {
        this.b = c0Var;
        this.c = callable;
    }

    public final void run() {
        try {
            this.b.q(this.c.call());
        } catch (Exception e2) {
            this.b.p(e2);
        } catch (Throwable th) {
            this.b.p(new RuntimeException(th));
        }
    }
}
