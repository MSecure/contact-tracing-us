package f.b.a.c.i;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class l<TResult, TContinuationResult> implements a0<TResult> {
    public final Executor a;
    public final a<TResult, TContinuationResult> b;
    public final c0<TContinuationResult> c;

    public l(Executor executor, a<TResult, TContinuationResult> aVar, c0<TContinuationResult> c0Var) {
        this.a = executor;
        this.b = aVar;
        this.c = c0Var;
    }

    @Override // f.b.a.c.i.a0
    public final void c(h<TResult> hVar) {
        this.a.execute(new n(this, hVar));
    }
}
