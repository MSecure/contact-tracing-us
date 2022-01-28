package c.b.a.a.j;

import java.util.concurrent.Executor;

public final class p<TResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f4126a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4127b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public c f4128c;

    public p(Executor executor, c cVar) {
        this.f4126a = executor;
        this.f4128c = cVar;
    }

    @Override // c.b.a.a.j.z
    public final void a(i<TResult> iVar) {
        if (((b0) iVar).f4104d) {
            synchronized (this.f4127b) {
                if (this.f4128c != null) {
                    this.f4126a.execute(new o(this));
                }
            }
        }
    }
}
