package f.b.a.c.i;

import java.util.concurrent.Executor;

public final class v<TResult> implements a0<TResult> {
    public final Executor a;
    public final Object b = new Object();
    public f<? super TResult> c;

    public v(Executor executor, f<? super TResult> fVar) {
        this.a = executor;
        this.c = fVar;
    }

    @Override // f.b.a.c.i.a0
    public final void a(h<TResult> hVar) {
        if (hVar.n()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new w(this, hVar));
                }
            }
        }
    }
}
