package c.b.a.a.g;

import java.util.concurrent.Executor;

public final class q<TResult> implements x<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2876a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2877b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public c<TResult> f2878c;

    public q(Executor executor, c<TResult> cVar) {
        this.f2876a = executor;
        this.f2878c = cVar;
    }

    @Override // c.b.a.a.g.x
    public final void a(h<TResult> hVar) {
        synchronized (this.f2877b) {
            if (this.f2878c != null) {
                this.f2876a.execute(new p(this, hVar));
            }
        }
    }
}
