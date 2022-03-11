package f.b.a.a.a.n0;

import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ j0 b;

    public /* synthetic */ b(k0 k0Var, j0 j0Var) {
        this.a = k0Var;
        this.b = j0Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        k0 k0Var = this.a;
        return k0Var.a.a(k0Var.g(k0Var.f(this.b)));
    }
}
