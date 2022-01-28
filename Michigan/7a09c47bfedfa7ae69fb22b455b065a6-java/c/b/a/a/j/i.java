package c.b.a.a.j;

import java.util.concurrent.Executor;

public abstract class i<TResult> {
    public i<TResult> a(Executor executor, c cVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public i<TResult> b(d<TResult> dVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract i<TResult> c(Executor executor, e eVar);

    public abstract i<TResult> d(Executor executor, f<? super TResult> fVar);

    public abstract Exception e();

    public abstract TResult f();

    public abstract boolean g();
}
