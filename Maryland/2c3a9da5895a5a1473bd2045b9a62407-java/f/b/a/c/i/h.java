package f.b.a.c.i;

import f.b.a.a.a.p.b;
import java.util.concurrent.Executor;

public abstract class h<TResult> {
    public h<TResult> a(c cVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public h<TResult> b(Executor executor, c cVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public h<TResult> c(Executor executor, d<TResult> dVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract h<TResult> d(e eVar);

    public abstract h<TResult> e(Executor executor, e eVar);

    public abstract h<TResult> f(f<? super TResult> fVar);

    public abstract h<TResult> g(Executor executor, f<? super TResult> fVar);

    public <TContinuationResult> h<TContinuationResult> h(a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> h<TContinuationResult> i(Executor executor, a<TResult, h<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract Exception j();

    public abstract TResult k();

    public abstract boolean l();

    public abstract boolean m();

    public abstract boolean n();

    public <TContinuationResult> h<TContinuationResult> o(b<TResult, TContinuationResult> bVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
