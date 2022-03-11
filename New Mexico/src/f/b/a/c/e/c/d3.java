package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
/* loaded from: classes.dex */
public final class d3<E> extends a3<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final a3<Object> f2763f = new d3(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2764d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2765e;

    public d3(Object[] objArr, int i2) {
        this.f2764d = objArr;
        this.f2765e = i2;
    }

    @Override // java.util.List
    public final E get(int i2) {
        b.z1(i2, this.f2765e, "index");
        E e2 = (E) this.f2764d[i2];
        e2.getClass();
        return e2;
    }

    @Override // f.b.a.c.e.c.a3, f.b.a.c.e.c.x2
    public final int h(Object[] objArr, int i2) {
        System.arraycopy(this.f2764d, 0, objArr, 0, this.f2765e);
        return this.f2765e;
    }

    @Override // f.b.a.c.e.c.x2
    public final int i() {
        return this.f2765e;
    }

    @Override // f.b.a.c.e.c.x2
    public final int j() {
        return 0;
    }

    @Override // f.b.a.c.e.c.x2
    public final boolean m() {
        return false;
    }

    @Override // f.b.a.c.e.c.x2
    public final Object[] n() {
        return this.f2764d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2765e;
    }
}
