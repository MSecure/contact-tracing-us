package f.b.a.c.e.c;

import f.b.a.c.b.o.b;

public final class l2 extends k2<E> {

    /* renamed from: d  reason: collision with root package name */
    public final transient int f2509d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2510e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k2 f2511f;

    public l2(k2 k2Var, int i2, int i3) {
        this.f2511f = k2Var;
        this.f2509d = i2;
        this.f2510e = i3;
    }

    @Override // java.util.List
    public final E get(int i2) {
        b.X1(i2, this.f2510e);
        return (E) this.f2511f.get(i2 + this.f2509d);
    }

    @Override // f.b.a.c.e.c.j2
    public final Object[] j() {
        return this.f2511f.j();
    }

    @Override // f.b.a.c.e.c.j2
    public final int k() {
        return this.f2511f.k() + this.f2509d;
    }

    @Override // f.b.a.c.e.c.j2
    public final int l() {
        return this.f2511f.k() + this.f2509d + this.f2510e;
    }

    @Override // f.b.a.c.e.c.j2
    public final boolean n() {
        return true;
    }

    @Override // f.b.a.c.e.c.k2
    /* renamed from: o */
    public final k2<E> subList(int i2, int i3) {
        b.b2(i2, i3, this.f2510e);
        k2 k2Var = this.f2511f;
        int i4 = this.f2509d;
        return (k2) k2Var.subList(i2 + i4, i3 + i4);
    }

    public final int size() {
        return this.f2510e;
    }
}
