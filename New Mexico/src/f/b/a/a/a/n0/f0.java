package f.b.a.a.a.n0;

import e.v.l;
import e.x.a.f.f;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class f0 implements Callable<Void> {
    public final /* synthetic */ d0 a;

    public f0(d0 d0Var) {
        this.a = d0Var;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        f a = this.a.f2335e.a();
        this.a.a.c();
        try {
            a.d();
            this.a.a.l();
            this.a.a.g();
            l lVar = this.a.f2335e;
            if (a != lVar.c) {
                return null;
            }
            lVar.a.set(false);
            return null;
        } catch (Throwable th) {
            this.a.a.g();
            this.a.f2335e.c(a);
            throw th;
        }
    }
}
