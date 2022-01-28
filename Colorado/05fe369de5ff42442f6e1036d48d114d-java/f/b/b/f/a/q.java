package f.b.b.f.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import f.b.b.f.a.e0.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class q<V> implements Runnable {
    public final Future<V> b;
    public final p<? super V> c;

    public q(Future<V> future, p<? super V> pVar) {
        this.b = future;
        this.c = pVar;
    }

    public void run() {
        Throwable b2;
        Future<V> future = this.b;
        if (!(future instanceof a) || (b2 = ((a) future).b()) == null) {
            try {
                this.c.b(b.A0(this.b));
            } catch (ExecutionException e2) {
                this.c.a(e2.getCause());
            } catch (Error | RuntimeException e3) {
                this.c.a(e3);
            }
        } else {
            this.c.a(b2);
        }
    }

    public String toString() {
        k q1 = b.q1(this);
        p<? super V> pVar = this.c;
        k.a aVar = new k.a(null);
        q1.c.c = aVar;
        q1.c = aVar;
        aVar.b = pVar;
        return q1.toString();
    }
}
