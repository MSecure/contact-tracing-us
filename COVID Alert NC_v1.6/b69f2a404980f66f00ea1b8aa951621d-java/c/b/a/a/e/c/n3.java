package c.b.a.a.e.c;

import c.b.a.a.c.k.o.k;
import c.b.a.a.g.d;

public final class n3 implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c.b.a.a.c.k.d f2671a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k.a f2672b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l3 f2673c;

    public n3(l3 l3Var, c.b.a.a.c.k.d dVar, k.a aVar) {
        this.f2673c = l3Var;
        this.f2671a = dVar;
        this.f2672b = aVar;
    }

    @Override // c.b.a.a.g.d
    public final void c(Exception exc) {
        synchronized (this.f2673c) {
            this.f2673c.c(this.f2671a, this.f2672b);
        }
    }
}
