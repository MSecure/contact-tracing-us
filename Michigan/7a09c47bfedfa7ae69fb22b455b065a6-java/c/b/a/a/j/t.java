package c.b.a.a.j;

import java.util.concurrent.Executor;

public final class t<TResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f4136a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4137b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public e f4138c;

    public t(Executor executor, e eVar) {
        this.f4136a = executor;
        this.f4138c = eVar;
    }

    @Override // c.b.a.a.j.z
    public final void a(i<TResult> iVar) {
        if (!iVar.g() && !((b0) iVar).f4104d) {
            synchronized (this.f4137b) {
                if (this.f4138c != null) {
                    this.f4136a.execute(new s(this, iVar));
                }
            }
        }
    }
}
