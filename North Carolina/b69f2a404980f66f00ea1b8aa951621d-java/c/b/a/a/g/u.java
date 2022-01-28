package c.b.a.a.g;

import java.util.concurrent.Executor;

public final class u<TResult> implements x<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2886a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2887b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public e<? super TResult> f2888c;

    public u(Executor executor, e<? super TResult> eVar) {
        this.f2886a = executor;
        this.f2888c = eVar;
    }

    @Override // c.b.a.a.g.x
    public final void a(h<TResult> hVar) {
        if (hVar.g()) {
            synchronized (this.f2887b) {
                if (this.f2888c != null) {
                    this.f2886a.execute(new t(this, hVar));
                }
            }
        }
    }
}
