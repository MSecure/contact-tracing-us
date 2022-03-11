package f.b.b.f.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import f.b.b.f.a.e0.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public final class q<V> implements Runnable {
    public final Future<V> b;
    public final p<? super V> c;

    public q(Future<V> future, p<? super V> pVar) {
        this.b = future;
        this.c = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable e2;
        Throwable b;
        Future<V> future = this.b;
        if (!(future instanceof a) || (b = ((a) future).b()) == null) {
            try {
                this.c.a(b.D0(this.b));
            } catch (Error e3) {
                e2 = e3;
                this.c.b(e2);
            } catch (RuntimeException e4) {
                e2 = e4;
                this.c.b(e2);
            } catch (ExecutionException e5) {
                this.c.b(e5.getCause());
            }
        } else {
            this.c.b(b);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        k u1 = b.u1(this);
        p<? super V> pVar = this.c;
        k.a aVar = new k.a(null);
        u1.c.c = aVar;
        u1.c = aVar;
        aVar.b = pVar;
        return u1.toString();
    }
}
