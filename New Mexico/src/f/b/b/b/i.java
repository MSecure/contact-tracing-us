package f.b.b.b;

import f.b.a.c.b.o.b;
/* loaded from: classes.dex */
public final class i<E> extends e<E> {

    /* renamed from: j  reason: collision with root package name */
    public static final i<Object> f3407j = new i<>(new Object[0], 0, null, 0, 0);

    /* renamed from: e  reason: collision with root package name */
    public final transient Object[] f3408e;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object[] f3409f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f3410g;

    /* renamed from: h  reason: collision with root package name */
    public final transient int f3411h;

    /* renamed from: i  reason: collision with root package name */
    public final transient int f3412i;

    public i(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f3408e = objArr;
        this.f3409f = objArr2;
        this.f3410g = i3;
        this.f3411h = i2;
        this.f3412i = i4;
    }

    @Override // f.b.b.b.b, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f3409f;
        if (obj == null || objArr == null) {
            return false;
        }
        int s1 = b.s1(obj.hashCode());
        while (true) {
            int i2 = s1 & this.f3410g;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            s1 = i2 + 1;
        }
    }

    @Override // f.b.b.b.e, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return this.f3411h;
    }

    @Override // f.b.b.b.b
    public int i(Object[] objArr, int i2) {
        System.arraycopy(this.f3408e, 0, objArr, i2, this.f3412i);
        return i2 + this.f3412i;
    }

    @Override // f.b.b.b.b
    public Object[] j() {
        return this.f3408e;
    }

    @Override // f.b.b.b.b
    public int k() {
        return this.f3412i;
    }

    @Override // f.b.b.b.b
    public int l() {
        return 0;
    }

    @Override // f.b.b.b.b
    public boolean m() {
        return false;
    }

    @Override // f.b.b.b.b
    /* renamed from: n */
    public k<E> iterator() {
        return h().listIterator();
    }

    @Override // f.b.b.b.e
    public c<E> r() {
        return c.p(this.f3408e, this.f3412i);
    }

    @Override // f.b.b.b.e
    public boolean s() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f3412i;
    }
}
