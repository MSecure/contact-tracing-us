package f.b.a.c.i;

import java.util.concurrent.Executor;

public final class u<TResult> implements a0<TResult> {
    public final Executor a;
    public final Object b = new Object();
    public e c;

    public u(Executor executor, e eVar) {
        this.a = executor;
        this.c = eVar;
    }

    @Override // f.b.a.c.i.a0
    public final void a(h<TResult> hVar) {
        if (!hVar.o() && !hVar.m()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new t(this, hVar));
                }
            }
        }
    }
}
