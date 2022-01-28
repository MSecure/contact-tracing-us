package c.b.a.a.d.k.o;

import android.os.Looper;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.a.d;
import c.b.a.a.d.k.i;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class c0<O extends a.d> extends h1 {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    public final c.b.a.a.d.k.d<O> f2964a;

    public c0(c.b.a.a.d.k.d<O> dVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f2964a = dVar;
    }

    @Override // c.b.a.a.d.k.e
    public final <A extends a.b, T extends d<? extends i, A>> T a(T t) {
        return (T) this.f2964a.doWrite(t);
    }

    @Override // c.b.a.a.d.k.e
    public final Looper b() {
        return this.f2964a.getLooper();
    }

    @Override // c.b.a.a.d.k.e
    public final void c(p0 p0Var) {
    }

    @Override // c.b.a.a.d.k.e
    public final void d(p0 p0Var) {
    }
}
