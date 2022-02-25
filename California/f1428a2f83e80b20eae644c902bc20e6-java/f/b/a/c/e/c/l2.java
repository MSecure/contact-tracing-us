package f.b.a.c.e.c;

import f.b.a.c.b.o.b;

public final class l2 extends k2<E> {

    /* renamed from: d  reason: collision with root package name */
    public final transient int f2501d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2502e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k2 f2503f;

    public l2(k2 k2Var, int i2, int i3) {
        this.f2503f = k2Var;
        this.f2501d = i2;
        this.f2502e = i3;
    }

    @Override // java.util.List
    public final E get(int i2) {
        b.X1(i2, this.f2502e);
        return (E) this.f2503f.get(i2 + this.f2501d);
    }

    @Override // f.b.a.c.e.c.j2
    public final Object[] j() {
        return this.f2503f.j();
    }

    @Override // f.b.a.c.e.c.j2
    public final int k() {
        return this.f2503f.k() + this.f2501d;
    }

    @Override // f.b.a.c.e.c.j2
    public final int l() {
        return this.f2503f.k() + this.f2501d + this.f2502e;
    }

    @Override // f.b.a.c.e.c.j2
    public final boolean n() {
        return true;
    }

    @Override // f.b.a.c.e.c.k2
    /* renamed from: o */
    public final k2<E> subList(int i2, int i3) {
        b.b2(i2, i3, this.f2502e);
        k2 k2Var = this.f2503f;
        int i4 = this.f2501d;
        return (k2) k2Var.subList(i2 + i4, i3 + i4);
    }

    public final int size() {
        return this.f2502e;
    }
}
