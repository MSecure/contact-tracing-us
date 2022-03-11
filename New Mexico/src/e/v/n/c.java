package e.v.n;

import e.g.a.f;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class c implements Runnable {
    public final /* synthetic */ Callable b;
    public final /* synthetic */ f c;

    public c(Callable callable, f fVar) {
        this.b = callable;
        this.c = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.c.i(this.b.call());
        } catch (Throwable th) {
            this.c.j(th);
        }
    }
}
