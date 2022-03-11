package f.b.a.c.i;

import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class e0 implements Runnable {
    public final /* synthetic */ c0 b;
    public final /* synthetic */ Callable c;

    public e0(c0 c0Var, Callable callable) {
        this.b = c0Var;
        this.c = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.r(this.c.call());
        } catch (Exception e2) {
            this.b.q(e2);
        } catch (Throwable th) {
            this.b.q(new RuntimeException(th));
        }
    }
}
