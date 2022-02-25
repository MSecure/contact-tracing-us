package f.b.b.f.a;

import f.b.b.f.a.l;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

public class c0<V> extends l.a<V> implements RunnableFuture<V> {

    /* renamed from: i  reason: collision with root package name */
    public volatile t<?> f2928i;

    public final class a extends t<V> {

        /* renamed from: e  reason: collision with root package name */
        public final Callable<V> f2929e;

        public a(Callable<V> callable) {
            Objects.requireNonNull(callable);
            this.f2929e = callable;
        }

        @Override // f.b.b.f.a.t
        public void a(V v, Throwable th) {
            if (th == null) {
                c0.this.t(v);
            } else {
                c0.this.u(th);
            }
        }
    }

    public c0(Callable<V> callable) {
        this.f2928i = new a(callable);
    }

    @Override // f.b.b.f.a.b
    public void j() {
        t<?> tVar;
        if (w() && (tVar = this.f2928i) != null) {
            Runnable runnable = t.f2941d;
            Runnable runnable2 = t.b;
            Runnable runnable3 = (Runnable) tVar.get();
            if ((runnable3 instanceof Thread) && tVar.compareAndSet(runnable3, t.c)) {
                try {
                    ((Thread) runnable3).interrupt();
                } finally {
                    if (((Runnable) tVar.getAndSet(runnable2)) == runnable) {
                        LockSupport.unpark((Thread) runnable3);
                    }
                }
            }
        }
        this.f2928i = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        t<?> tVar = this.f2928i;
        if (tVar == null) {
            return super.r();
        }
        return "task=[" + tVar + "]";
    }

    public void run() {
        t<?> tVar = this.f2928i;
        if (tVar != null) {
            tVar.run();
        }
        this.f2928i = null;
    }
}
