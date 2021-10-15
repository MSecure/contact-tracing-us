package c.b.a.a.g.e;

import c.b.a.a.d.k.d;
import c.b.a.a.d.k.o.k;
import c.b.a.a.j.e;

public final class n3 implements e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f3663a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k.a f3664b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l3 f3665c;

    public n3(l3 l3Var, d dVar, k.a aVar) {
        this.f3665c = l3Var;
        this.f3663a = dVar;
        this.f3664b = aVar;
    }

    @Override // c.b.a.a.j.e
    public final void c(Exception exc) {
        synchronized (this.f3665c) {
            this.f3665c.c(this.f3663a, this.f3664b);
        }
    }
}
