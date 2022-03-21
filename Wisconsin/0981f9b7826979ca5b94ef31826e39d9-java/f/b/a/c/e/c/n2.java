package f.b.a.c.e.c;

import f.b.a.c.b.o.b;

public final class n2<E> extends k2<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final k2<Object> f2513f = new n2(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2514d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2515e;

    public n2(Object[] objArr, int i2) {
        this.f2514d = objArr;
        this.f2515e = i2;
    }

    @Override // java.util.List
    public final E get(int i2) {
        b.X1(i2, this.f2515e);
        return (E) this.f2514d[i2];
    }

    @Override // f.b.a.c.e.c.k2, f.b.a.c.e.c.j2
    public final int h(Object[] objArr, int i2) {
        System.arraycopy(this.f2514d, 0, objArr, 0, this.f2515e);
        return this.f2515e + 0;
    }

    @Override // f.b.a.c.e.c.j2
    public final Object[] j() {
        return this.f2514d;
    }

    @Override // f.b.a.c.e.c.j2
    public final int k() {
        return 0;
    }

    @Override // f.b.a.c.e.c.j2
    public final int l() {
        return this.f2515e;
    }

    @Override // f.b.a.c.e.c.j2
    public final boolean n() {
        return false;
    }

    public final int size() {
        return this.f2515e;
    }
}
