package f.b.a.c.i;

import f.b.a.a.a.p.b;
import java.util.concurrent.Executor;

public final class y<TResult, TContinuationResult> implements c, e, f<TContinuationResult>, a0<TResult> {
    public final Executor a;
    public final b<TResult, TContinuationResult> b;
    public final c0<TContinuationResult> c;

    public y(Executor executor, b<TResult, TContinuationResult> bVar, c0<TContinuationResult> c0Var) {
        this.a = executor;
        this.b = bVar;
        this.c = c0Var;
    }

    @Override // f.b.a.c.i.a0
    public final void a(h<TResult> hVar) {
        this.a.execute(new x(this, hVar));
    }

    @Override // f.b.a.c.i.f
    public final void b(TContinuationResult tcontinuationresult) {
        this.c.q(tcontinuationresult);
    }

    @Override // f.b.a.c.i.c
    public final void c() {
        this.c.r();
    }

    @Override // f.b.a.c.i.e
    public final void d(Exception exc) {
        this.c.p(exc);
    }
}
