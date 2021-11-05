package c.b.a.a.g;

import java.util.concurrent.Executor;

public abstract class h<TResult> {
    public h<TResult> a(Executor executor, b bVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public h<TResult> b(c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract h<TResult> c(Executor executor, d dVar);

    public abstract h<TResult> d(Executor executor, e<? super TResult> eVar);

    public abstract Exception e();

    public abstract TResult f();

    public abstract boolean g();
}
