package f.b.a.c.i;

import java.util.concurrent.CountDownLatch;

public final class k implements c, e, f {
    public final CountDownLatch a = new CountDownLatch(1);

    public k(e0 e0Var) {
    }

    @Override // f.b.a.c.i.f
    public final void b(Object obj) {
        this.a.countDown();
    }

    @Override // f.b.a.c.i.c
    public final void c() {
        this.a.countDown();
    }

    @Override // f.b.a.c.i.e
    public final void d(Exception exc) {
        this.a.countDown();
    }
}
