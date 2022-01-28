package c.b.a.a.g;

import java.util.concurrent.Executor;

public final class n<TResult> implements x<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2870a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2871b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public b f2872c;

    public n(Executor executor, b bVar) {
        this.f2870a = executor;
        this.f2872c = bVar;
    }

    @Override // c.b.a.a.g.x
    public final void a(h<TResult> hVar) {
        if (((a0) hVar).f2852d) {
            synchronized (this.f2871b) {
                if (this.f2872c != null) {
                    this.f2870a.execute(new o(this));
                }
            }
        }
    }
}
