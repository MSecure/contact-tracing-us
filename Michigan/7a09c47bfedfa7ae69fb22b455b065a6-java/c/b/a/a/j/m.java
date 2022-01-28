package c.b.a.a.j;

import java.util.concurrent.Executor;

public final class m<TResult, TContinuationResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f4120a;

    /* renamed from: b  reason: collision with root package name */
    public final a<TResult, TContinuationResult> f4121b;

    /* renamed from: c  reason: collision with root package name */
    public final b0<TContinuationResult> f4122c;

    public m(Executor executor, a<TResult, TContinuationResult> aVar, b0<TContinuationResult> b0Var) {
        this.f4120a = executor;
        this.f4121b = aVar;
        this.f4122c = b0Var;
    }

    @Override // c.b.a.a.j.z
    public final void a(i<TResult> iVar) {
        this.f4120a.execute(new n(this, iVar));
    }
}
