package c.b.a.a.j;

import java.util.concurrent.Executor;

public final class q<TResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f4129a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4130b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public d<TResult> f4131c;

    public q(Executor executor, d<TResult> dVar) {
        this.f4129a = executor;
        this.f4131c = dVar;
    }

    @Override // c.b.a.a.j.z
    public final void a(i<TResult> iVar) {
        synchronized (this.f4130b) {
            if (this.f4131c != null) {
                this.f4129a.execute(new r(this, iVar));
            }
        }
    }
}
