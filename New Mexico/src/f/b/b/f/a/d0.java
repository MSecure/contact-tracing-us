package f.b.b.f.a;

import f.b.b.f.a.l;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes.dex */
public class d0<V> extends l.a<V> implements RunnableFuture<V> {

    /* renamed from: i */
    public volatile t<?> f3448i;

    /* loaded from: classes.dex */
    public final class a extends t<V> {

        /* renamed from: e */
        public final Callable<V> f3449e;

        public a(Callable<V> callable) {
            d0.this = r1;
            Objects.requireNonNull(callable);
            this.f3449e = callable;
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
        this.f3448i = new a(callable);
    }

    @Override // f.b.b.f.a.b
    public void j() {
        t<?> tVar;
        if (w() && (tVar = this.f3448i) != null) {
            Runnable runnable = tVar.get();
            if ((runnable instanceof Thread) && tVar.compareAndSet(runnable, t.c)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (tVar.getAndSet(t.b) == t.f3459d) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
        this.f3448i = null;
    }

    @Override // f.b.b.f.a.b
    public String r() {
        t<?> tVar = this.f3448i;
        if (tVar == null) {
            return super.r();
        }
        return "task=[" + tVar + "]";
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        t<?> tVar = this.f3448i;
        if (tVar != null) {
            tVar.run();
        }
        this.f3448i = null;
    }
}
