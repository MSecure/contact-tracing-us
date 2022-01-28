package c.b.a.a.e.c;

import c.b.a.a.c.n.c;

public final class ua<E> extends na<E> {
    public static final na<Object> f = new ua(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2763d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2764e;

    public ua(Object[] objArr, int i) {
        this.f2763d = objArr;
        this.f2764e = i;
    }

    @Override // c.b.a.a.e.c.ma, c.b.a.a.e.c.na
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.f2763d, 0, objArr, 0, this.f2764e);
        return this.f2764e + 0;
    }

    @Override // c.b.a.a.e.c.ma
    public final Object[] e() {
        return this.f2763d;
    }

    @Override // java.util.List
    public final E get(int i) {
        c.F2(i, this.f2764e);
        return (E) this.f2763d[i];
    }

    @Override // c.b.a.a.e.c.ma
    public final int h() {
        return 0;
    }

    @Override // c.b.a.a.e.c.ma
    public final int j() {
        return this.f2764e;
    }

    @Override // c.b.a.a.e.c.ma
    public final boolean o() {
        return false;
    }

    public final int size() {
        return this.f2764e;
    }
}
