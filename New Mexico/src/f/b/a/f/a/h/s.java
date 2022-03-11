package f.b.a.f.a.h;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public final class s implements c, b {
    public final CountDownLatch a = new CountDownLatch(1);

    @Override // f.b.a.f.a.h.c
    public final void a(Object obj) {
        this.a.countDown();
    }

    @Override // f.b.a.f.a.h.b
    public final void b(Exception exc) {
        this.a.countDown();
    }
}
