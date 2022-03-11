package f.b.a.a.a.y;

import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ c0 b;

    public /* synthetic */ b(d0 d0Var, c0 c0Var) {
        this.a = d0Var;
        this.b = c0Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        d0 d0Var = this.a;
        return d0Var.a.a(d0Var.c(this.b));
    }
}
