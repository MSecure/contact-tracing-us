package c.b.a.a.g;

import java.util.concurrent.Executor;

public final class r<TResult> implements x<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2879a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2880b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public d f2881c;

    public r(Executor executor, d dVar) {
        this.f2879a = executor;
        this.f2881c = dVar;
    }

    @Override // c.b.a.a.g.x
    public final void a(h<TResult> hVar) {
        if (!hVar.g() && !((a0) hVar).f2852d) {
            synchronized (this.f2880b) {
                if (this.f2881c != null) {
                    this.f2879a.execute(new s(this, hVar));
                }
            }
        }
    }
}
