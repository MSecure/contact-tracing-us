package f.b.a.a.a.n0;

import e.v.l;
import e.x.a.f.f;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class y0 implements Callable<Void> {
    public final /* synthetic */ x0 a;

    public y0(x0 x0Var) {
        this.a = x0Var;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        f a = this.a.c.a();
        this.a.a.c();
        try {
            a.d();
            this.a.a.l();
            this.a.a.g();
            l lVar = this.a.c;
            if (a != lVar.c) {
                return null;
            }
            lVar.a.set(false);
            return null;
        } catch (Throwable th) {
            this.a.a.g();
            this.a.c.c(a);
            throw th;
        }
    }
}
