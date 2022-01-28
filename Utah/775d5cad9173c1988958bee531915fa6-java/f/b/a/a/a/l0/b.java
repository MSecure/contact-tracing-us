package f.b.a.a.a.l0;

import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ i0 a;
    public final /* synthetic */ h0 b;

    public /* synthetic */ b(i0 i0Var, h0 h0Var) {
        this.a = i0Var;
        this.b = h0Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        i0 i0Var = this.a;
        return i0Var.a.a(i0Var.g(i0Var.f(this.b)));
    }
}
