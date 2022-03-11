package f.b.a.c.i;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class m<TResult, TContinuationResult> implements c, e, f<TContinuationResult>, a0<TResult> {
    public final Executor a;
    public final a<TResult, h<TContinuationResult>> b;
    public final c0<TContinuationResult> c;

    public m(Executor executor, a<TResult, h<TContinuationResult>> aVar, c0<TContinuationResult> c0Var) {
        this.a = executor;
        this.b = aVar;
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
        this.a.execute(new o(this, hVar));
    }

    @Override // f.b.a.c.i.c
    public final void d() {
        this.c.s();
    }
}
