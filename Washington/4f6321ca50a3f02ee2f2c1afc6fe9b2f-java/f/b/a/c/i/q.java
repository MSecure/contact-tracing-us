package f.b.a.c.i;

import java.util.concurrent.Executor;

public final class q<TResult> implements a0<TResult> {
    public final Executor a;
    public final Object b = new Object();
    public c c;

    public q(Executor executor, c cVar) {
        this.a = executor;
        this.c = cVar;
    }

    @Override // f.b.a.c.i.a0
    public final void a(h<TResult> hVar) {
        if (hVar.l()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new p(this));
                }
            }
        }
    }
}
