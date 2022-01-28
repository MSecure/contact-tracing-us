package c.b.a.a.c.k.o;

import android.os.Looper;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.a.d;
import c.b.a.a.c.k.i;

public final class g0<O extends a.d> extends w {

    /* renamed from: a  reason: collision with root package name */
    public final c.b.a.a.c.k.d<O> f2353a;

    public g0(c.b.a.a.c.k.d<O> dVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f2353a = dVar;
    }

    @Override // c.b.a.a.c.k.e
    public final <A extends a.b, T extends d<? extends i, A>> T a(T t) {
        return (T) this.f2353a.doWrite(t);
    }

    @Override // c.b.a.a.c.k.e
    public final Looper b() {
        return this.f2353a.getLooper();
    }
}
