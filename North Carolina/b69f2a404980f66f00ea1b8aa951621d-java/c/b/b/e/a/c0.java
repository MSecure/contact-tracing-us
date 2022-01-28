package c.b.b.e.a;

import c.b.b.e.a.l;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

public class c0<V> extends l.a<V> implements RunnableFuture<V> {
    public volatile t<?> i;

    public final class a extends t<V> {

        /* renamed from: e  reason: collision with root package name */
        public final Callable<V> f3397e;

        public a(Callable<V> callable) {
            if (callable != null) {
                this.f3397e = callable;
                return;
            }
            throw null;
        }

        @Override // c.b.b.e.a.t
        public void a(V v, Throwable th) {
            if (th == null) {
                c0.this.m(v);
            } else {
                c0.this.n(th);
            }
        }
    }

    public c0(Callable<V> callable) {
        this.i = new a(callable);
    }

    @Override // c.b.b.e.a.b
    public void c() {
        t<?> tVar;
        if (p() && (tVar = this.i) != null) {
            Runnable runnable = (Runnable) tVar.get();
            if ((runnable instanceof Thread) && tVar.compareAndSet(runnable, t.f3415c)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (((Runnable) tVar.getAndSet(t.f3414b)) == t.f3416d) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
        this.i = null;
    }

    @Override // c.b.b.e.a.b
    public String k() {
        t<?> tVar = this.i;
        if (tVar == null) {
            return super.k();
        }
        return "task=[" + tVar + "]";
    }

    public void run() {
        t<?> tVar = this.i;
        if (tVar != null) {
            tVar.run();
        }
        this.i = null;
    }
}
