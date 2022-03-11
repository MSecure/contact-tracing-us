package f.b.a.c.e.c;

import f.b.a.c.b.o.b;

public final class v2<E> extends r2<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final r2<Object> f2596f = new v2(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2597d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2598e;

    public v2(Object[] objArr, int i2) {
        this.f2597d = objArr;
        this.f2598e = i2;
    }

    @Override // java.util.List
    public final E get(int i2) {
        b.c2(i2, this.f2598e, "index");
        return (E) this.f2597d[i2];
    }

    @Override // f.b.a.c.e.c.o2
    public final Object[] i() {
        return this.f2597d;
    }

    @Override // f.b.a.c.e.c.o2
    public final int j() {
        return 0;
    }

    @Override // f.b.a.c.e.c.o2
    public final int k() {
        return this.f2598e;
    }

    @Override // f.b.a.c.e.c.o2
    public final boolean m() {
        return false;
    }

    @Override // f.b.a.c.e.c.r2, f.b.a.c.e.c.o2
    public final int n(Object[] objArr, int i2) {
        System.arraycopy(this.f2597d, 0, objArr, 0, this.f2598e);
        return this.f2598e;
    }

    public final int size() {
        return this.f2598e;
    }
}
