package f.b.b.f.a;

import f.b.b.f.a.l;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

public class d0<V> extends l.a<V> implements RunnableFuture<V> {

    /* renamed from: i  reason: collision with root package name */
    public volatile t<?> f3193i;

    public final class a extends t<V> {

        /* renamed from: e  reason: collision with root package name */
        public final Callable<V> f3194e;

        public a(Callable<V> callable) {
            Objects.requireNonNull(callable);
            this.f3194e = callable;
        }

        @Override // f.b.b.f.a.t
        public void a(V v, Throwable th) {
            if (th == null) {
                d0.this.t(v);
            } else {
                d0.this.u(th);
            }
        }
    }

    public d0(Callable<V> callable) {
        this.f3193i = new a(callable);
    }

    @Override // f.b.b.f.a.b
    public void j() {
        t<?> tVar;
        if (w() && (tVar = this.f3193i) != null) {
            Runnable runnable = (Runnable) tVar.get();
            if ((runnable instanceof Thread) && tVar.compareAndSet(runnable, t.c)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (((Runnable) tVar.getAndSet(t.b)) == t.f3204d) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
        this.f3193i = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        t<?> tVar = this.f3193i;
        if (tVar == null) {
            return super.r();
        }
        return "task=[" + tVar + "]";
    }

    public void run() {
        t<?> tVar = this.f3193i;
        if (tVar != null) {
            tVar.run();
        }
        this.f3193i = null;
    }
}
