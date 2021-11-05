package c.b.a.a.e.c;

import c.b.a.a.c.n.c;

public final class ta<E> extends qa<E> {
    public static final ta<Object> i = new ta<>(new Object[0], 0, null, 0, 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2743d;

    /* renamed from: e  reason: collision with root package name */
    public final transient Object[] f2744e;
    public final transient int f;
    public final transient int g;
    public final transient int h;

    public ta(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f2743d = objArr;
        this.f2744e = objArr2;
        this.f = i3;
        this.g = i2;
        this.h = i4;
    }

    @Override // c.b.a.a.e.c.ma
    public final int a(Object[] objArr, int i2) {
        System.arraycopy(this.f2743d, 0, objArr, 0, this.h);
        return this.h + 0;
    }

    @Override // c.b.a.a.e.c.ma
    /* renamed from: c */
    public final xa<E> iterator() {
        na<E> naVar = this.f2705c;
        if (naVar == null) {
            naVar = t();
            this.f2705c = naVar;
        }
        return naVar.iterator();
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.f2744e;
        if (obj == null || objArr == null) {
            return false;
        }
        int E2 = c.E2(obj.hashCode());
        while (true) {
            int i2 = E2 & this.f;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            E2 = i2 + 1;
        }
    }

    @Override // c.b.a.a.e.c.ma
    public final Object[] e() {
        return this.f2743d;
    }

    @Override // c.b.a.a.e.c.ma
    public final int h() {
        return 0;
    }

    @Override // c.b.a.a.e.c.qa
    public final int hashCode() {
        return this.g;
    }

    @Override // c.b.a.a.e.c.ma
    public final int j() {
        return this.h;
    }

    @Override // c.b.a.a.e.c.ma
    public final boolean o() {
        return false;
    }

    @Override // c.b.a.a.e.c.qa
    public final boolean s() {
        return true;
    }

    public final int size() {
        return this.h;
    }

    @Override // c.b.a.a.e.c.qa
    public final na<E> t() {
        return na.t(this.f2743d, this.h);
    }
}
