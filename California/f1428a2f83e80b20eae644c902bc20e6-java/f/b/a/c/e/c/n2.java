package f.b.a.c.e.c;

import f.b.a.c.b.o.b;

public final class n2<E> extends k2<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final k2<Object> f2505f = new n2(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2506d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2507e;

    public n2(Object[] objArr, int i2) {
        this.f2506d = objArr;
        this.f2507e = i2;
    }

    @Override // java.util.List
    public final E get(int i2) {
        b.X1(i2, this.f2507e);
        return (E) this.f2506d[i2];
    }

    @Override // f.b.a.c.e.c.k2, f.b.a.c.e.c.j2
    public final int h(Object[] objArr, int i2) {
        System.arraycopy(this.f2506d, 0, objArr, 0, this.f2507e);
        return this.f2507e + 0;
    }

    @Override // f.b.a.c.e.c.j2
    public final Object[] j() {
        return this.f2506d;
    }

    @Override // f.b.a.c.e.c.j2
    public final int k() {
        return 0;
    }

    @Override // f.b.a.c.e.c.j2
    public final int l() {
        return this.f2507e;
    }

    @Override // f.b.a.c.e.c.j2
    public final boolean n() {
        return false;
    }

    public final int size() {
        return this.f2507e;
    }
}
