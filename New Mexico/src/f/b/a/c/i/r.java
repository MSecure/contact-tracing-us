package f.b.a.c.i;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class r<TResult> implements a0<TResult> {
    public final Executor a;
    public final Object b = new Object();
    public d<TResult> c;

    public r(Executor executor, d<TResult> dVar) {
        this.a = executor;
        this.c = dVar;
    }

    @Override // f.b.a.c.i.a0
    public final void c(h<TResult> hVar) {
        synchronized (this.b) {
            if (this.c != null) {
                this.a.execute(new s(this, hVar));
            }
        }
    }
}
