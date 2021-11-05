package c.b.b.e.a;

import c.b.a.a.c.n.c;
import c.b.b.a.i;
import c.b.b.e.a.d0.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class q<V> implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final Future<V> f3409b;

    /* renamed from: c  reason: collision with root package name */
    public final p<? super V> f3410c;

    public q(Future<V> future, p<? super V> pVar) {
        this.f3409b = future;
        this.f3410c = pVar;
    }

    public void run() {
        Throwable t2;
        Future<V> future = this.f3409b;
        if (!(future instanceof a) || (t2 = c.t2((a) future)) == null) {
            try {
                this.f3410c.onSuccess(c.c1(this.f3409b));
            } catch (ExecutionException e2) {
                this.f3410c.onFailure(e2.getCause());
            } catch (Error | RuntimeException e3) {
                this.f3410c.onFailure(e3);
            }
        } else {
            this.f3410c.onFailure(t2);
        }
    }

    public String toString() {
        i iVar = new i(q.class.getSimpleName(), null);
        p<? super V> pVar = this.f3410c;
        i.a aVar = new i.a(null);
        iVar.f3325c.f3329c = aVar;
        iVar.f3325c = aVar;
        aVar.f3328b = pVar;
        return iVar.toString();
    }
}
