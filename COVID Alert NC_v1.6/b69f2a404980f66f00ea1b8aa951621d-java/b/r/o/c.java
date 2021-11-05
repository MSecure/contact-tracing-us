package b.r.o;

import b.f.a.f;
import java.util.concurrent.Callable;

public final class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f1676b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f1677c;

    public c(Callable callable, f fVar) {
        this.f1676b = callable;
        this.f1677c = fVar;
    }

    public void run() {
        try {
            this.f1677c.k(this.f1676b.call());
        } catch (Throwable th) {
            this.f1677c.l(th);
        }
    }
}
