package c.b.a.a.j;

import java.util.concurrent.Executor;

public final class u<TResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f4139a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4140b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public f<? super TResult> f4141c;

    public u(Executor executor, f<? super TResult> fVar) {
        this.f4139a = executor;
        this.f4141c = fVar;
    }

    @Override // c.b.a.a.j.z
    public final void a(i<TResult> iVar) {
        if (iVar.g()) {
            synchronized (this.f4140b) {
                if (this.f4141c != null) {
                    this.f4139a.execute(new v(this, iVar));
                }
            }
        }
    }
}
