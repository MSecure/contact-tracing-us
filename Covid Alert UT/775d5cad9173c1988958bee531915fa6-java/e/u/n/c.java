package e.u.n;

import e.f.a.f;
import java.util.concurrent.Callable;

public final class c implements Runnable {
    public final /* synthetic */ Callable b;
    public final /* synthetic */ f c;

    public c(Callable callable, f fVar) {
        this.b = callable;
        this.c = fVar;
    }

    public void run() {
        try {
            this.c.i(this.b.call());
        } catch (Throwable th) {
            this.c.j(th);
        }
    }
}
