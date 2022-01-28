package c.b.b.e.a;

import b.x.t;
import c.b.b.a.i;
import c.b.b.e.a.d0.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class q<V> implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final Future<V> f4759b;

    /* renamed from: c  reason: collision with root package name */
    public final p<? super V> f4760c;

    public q(Future<V> future, p<? super V> pVar) {
        this.f4759b = future;
        this.f4760c = pVar;
    }

    public void run() {
        Throwable b3;
        Future<V> future = this.f4759b;
        if (!(future instanceof a) || (b3 = t.b3((a) future)) == null) {
            try {
                this.f4760c.onSuccess(t.E1(this.f4759b));
            } catch (ExecutionException e2) {
                this.f4760c.onFailure(e2.getCause());
            } catch (Error | RuntimeException e3) {
                this.f4760c.onFailure(e3);
            }
        } else {
            this.f4760c.onFailure(b3);
        }
    }

    public String toString() {
        i iVar = new i(q.class.getSimpleName(), null);
        p<? super V> pVar = this.f4760c;
        i.a aVar = new i.a(null);
        iVar.f4662c.f4666c = aVar;
        iVar.f4662c = aVar;
        aVar.f4665b = pVar;
        return iVar.toString();
    }
}
