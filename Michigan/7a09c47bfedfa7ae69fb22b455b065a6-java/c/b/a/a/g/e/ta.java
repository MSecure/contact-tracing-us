package c.b.a.a.g.e;

import b.x.t;

public final class ta<E> extends qa<E> {
    public static final ta<Object> i = new ta<>(new Object[0], 0, null, 0, 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f3740d;

    /* renamed from: e  reason: collision with root package name */
    public final transient Object[] f3741e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f3742f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f3743g;
    public final transient int h;

    public ta(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f3740d = objArr;
        this.f3741e = objArr2;
        this.f3742f = i3;
        this.f3743g = i2;
        this.h = i4;
    }

    @Override // c.b.a.a.g.e.ma
    public final int a(Object[] objArr, int i2) {
        System.arraycopy(this.f3740d, 0, objArr, 0, this.h);
        return this.h + 0;
    }

    @Override // c.b.a.a.g.e.ma
    /* renamed from: c */
    public final xa<E> iterator() {
        na<E> naVar = this.f3699c;
        if (naVar == null) {
            naVar = v();
            this.f3699c = naVar;
        }
        return naVar.iterator();
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.f3741e;
        if (obj == null || objArr == null) {
            return false;
        }
        int D3 = t.D3(obj.hashCode());
        while (true) {
            int i2 = D3 & this.f3742f;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            D3 = i2 + 1;
        }
    }

    @Override // c.b.a.a.g.e.ma
    public final Object[] e() {
        return this.f3740d;
    }

    @Override // c.b.a.a.g.e.ma
    public final int g() {
        return 0;
    }

    @Override // c.b.a.a.g.e.ma
    public final int h() {
        return this.h;
    }

    @Override // c.b.a.a.g.e.qa
    public final int hashCode() {
        return this.f3743g;
    }

    @Override // c.b.a.a.g.e.ma
    public final boolean l() {
        return false;
    }

    public final int size() {
        return this.h;
    }

    @Override // c.b.a.a.g.e.qa
    public final boolean u() {
        return true;
    }

    @Override // c.b.a.a.g.e.qa
    public final na<E> v() {
        return na.v(this.f3740d, this.h);
    }
}
