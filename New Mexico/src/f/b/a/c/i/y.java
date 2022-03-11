package f.b.a.c.i;

import f.b.a.a.a.c0.e;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class y<TResult, TContinuationResult> implements c, e, f<TContinuationResult>, a0<TResult> {
    public final Executor a;
    public final e<TResult, TContinuationResult> b;
    public final c0<TContinuationResult> c;

    public y(Executor executor, e<TResult, TContinuationResult> eVar, c0<TContinuationResult> c0Var) {
        this.a = executor;
        this.b = eVar;
        this.c = c0Var;
    }

    @Override // f.b.a.c.i.f
    public final void a(TContinuationResult tcontinuationresult) {
        this.c.r(tcontinuationresult);
    }

    @Override // f.b.a.c.i.e
    public final void b(Exception exc) {
        this.c.q(exc);
    }

    @Override // f.b.a.c.i.a0
    public final void c(h<TResult> hVar) {
        this.a.execute(new x(this, hVar));
    }

    @Override // f.b.a.c.i.c
    public final void d() {
        this.c.s();
    }
}
