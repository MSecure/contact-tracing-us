package c.b.a.a.g;

import java.util.concurrent.Executor;

public final class l<TResult, TContinuationResult> implements x<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2865a;

    /* renamed from: b  reason: collision with root package name */
    public final a<TResult, TContinuationResult> f2866b;

    /* renamed from: c  reason: collision with root package name */
    public final a0<TContinuationResult> f2867c;

    public l(Executor executor, a<TResult, TContinuationResult> aVar, a0<TContinuationResult> a0Var) {
        this.f2865a = executor;
        this.f2866b = aVar;
        this.f2867c = a0Var;
    }

    @Override // c.b.a.a.g.x
    public final void a(h<TResult> hVar) {
        this.f2865a.execute(new m(this, hVar));
    }
}
