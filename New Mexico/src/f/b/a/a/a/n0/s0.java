package f.b.a.a.a.n0;

import e.v.l;
import e.x.a.f.f;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class s0 implements Callable<Void> {
    public final /* synthetic */ r0 a;

    public s0(r0 r0Var) {
        this.a = r0Var;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        f a = this.a.f2371d.a();
        this.a.a.c();
        try {
            a.d();
            this.a.a.l();
            this.a.a.g();
            l lVar = this.a.f2371d;
            if (a != lVar.c) {
                return null;
            }
            lVar.a.set(false);
            return null;
        } catch (Throwable th) {
            this.a.a.g();
            this.a.f2371d.c(a);
            throw th;
        }
    }
}
