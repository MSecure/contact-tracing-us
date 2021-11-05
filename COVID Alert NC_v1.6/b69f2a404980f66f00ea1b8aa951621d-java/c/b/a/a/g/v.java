package c.b.a.a.g;

import java.util.concurrent.Executor;

public final class v<TResult, TContinuationResult> implements b, d, e<TContinuationResult>, x<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2889a;

    /* renamed from: b  reason: collision with root package name */
    public final g<TResult, TContinuationResult> f2890b;

    /* renamed from: c  reason: collision with root package name */
    public final a0<TContinuationResult> f2891c;

    public v(Executor executor, g<TResult, TContinuationResult> gVar, a0<TContinuationResult> a0Var) {
        this.f2889a = executor;
        this.f2890b = gVar;
        this.f2891c = a0Var;
    }

    @Override // c.b.a.a.g.x
    public final void a(h<TResult> hVar) {
        this.f2889a.execute(new w(this, hVar));
    }

    @Override // c.b.a.a.g.b
    public final void b() {
        this.f2891c.j();
    }

    @Override // c.b.a.a.g.d
    public final void c(Exception exc) {
        this.f2891c.h(exc);
    }

    @Override // c.b.a.a.g.e
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f2891c.i(tcontinuationresult);
    }
}
