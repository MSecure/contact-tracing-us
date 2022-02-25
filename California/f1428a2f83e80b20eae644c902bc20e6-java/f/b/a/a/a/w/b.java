package f.b.a.a.a.w;

import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ b0 b;

    public /* synthetic */ b(c0 c0Var, b0 b0Var) {
        this.a = c0Var;
        this.b = b0Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        c0 c0Var = this.a;
        return c0Var.a.a(c0Var.b(this.b));
    }
}
