package c.b.a.a.g.e;

import b.x.t;

public final class ua<E> extends na<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final na<Object> f3764f = new ua(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f3765d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f3766e;

    public ua(Object[] objArr, int i) {
        this.f3765d = objArr;
        this.f3766e = i;
    }

    @Override // c.b.a.a.g.e.na, c.b.a.a.g.e.ma
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.f3765d, 0, objArr, 0, this.f3766e);
        return this.f3766e + 0;
    }

    @Override // c.b.a.a.g.e.ma
    public final Object[] e() {
        return this.f3765d;
    }

    @Override // c.b.a.a.g.e.ma
    public final int g() {
        return 0;
    }

    @Override // java.util.List
    public final E get(int i) {
        t.E3(i, this.f3766e);
        return (E) this.f3765d[i];
    }

    @Override // c.b.a.a.g.e.ma
    public final int h() {
        return this.f3766e;
    }

    @Override // c.b.a.a.g.e.ma
    public final boolean l() {
        return false;
    }

    public final int size() {
        return this.f3766e;
    }
}
