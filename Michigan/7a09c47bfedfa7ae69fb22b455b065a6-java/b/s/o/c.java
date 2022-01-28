package b.s.o;

import b.f.a.f;
import java.util.concurrent.Callable;

public final class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f2546b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f2547c;

    public c(Callable callable, f fVar) {
        this.f2546b = callable;
        this.f2547c = fVar;
    }

    public void run() {
        try {
            this.f2547c.k(this.f2546b.call());
        } catch (Throwable th) {
            this.f2547c.l(th);
        }
    }
}
