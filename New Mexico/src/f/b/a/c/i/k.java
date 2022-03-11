package f.b.a.c.i;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public final class k implements c, e, f {
    public final CountDownLatch a = new CountDownLatch(1);

    public k(e0 e0Var) {
    }

    @Override // f.b.a.c.i.f
    public final void a(Object obj) {
        this.a.countDown();
    }

    @Override // f.b.a.c.i.e
    public final void b(Exception exc) {
        this.a.countDown();
    }

    @Override // f.b.a.c.i.c
    public final void d() {
        this.a.countDown();
    }
}
