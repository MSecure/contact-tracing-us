package f.b.b.b;

import f.b.a.c.b.o.b;

public final class i<E> extends e<E> {

    /* renamed from: j  reason: collision with root package name */
    public static final i<Object> f2899j = new i<>(new Object[0], 0, null, 0, 0);

    /* renamed from: e  reason: collision with root package name */
    public final transient Object[] f2900e;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object[] f2901f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f2902g;

    /* renamed from: h  reason: collision with root package name */
    public final transient int f2903h;

    /* renamed from: i  reason: collision with root package name */
    public final transient int f2904i;

    public i(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f2900e = objArr;
        this.f2901f = objArr2;
        this.f2902g = i3;
        this.f2903h = i2;
        this.f2904i = i4;
    }

    @Override // f.b.b.b.b
    public boolean contains(Object obj) {
        Object[] objArr = this.f2901f;
        if (obj == null || objArr == null) {
            return false;
        }
        int R1 = b.R1(obj.hashCode());
        while (true) {
            int i2 = R1 & this.f2902g;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            R1 = i2 + 1;
        }
    }

    @Override // f.b.b.b.e
    public int hashCode() {
        return this.f2903h;
    }

    @Override // f.b.b.b.b
    public int i(Object[] objArr, int i2) {
        System.arraycopy(this.f2900e, 0, objArr, i2, this.f2904i);
        return i2 + this.f2904i;
    }

    @Override // f.b.b.b.b
    public Object[] j() {
        return this.f2900e;
    }

    @Override // f.b.b.b.b
    public int k() {
        return this.f2904i;
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
        return c.p(this.f2900e, this.f2904i);
    }

    @Override // f.b.b.b.e
    public boolean s() {
        return true;
    }

    public int size() {
        return this.f2904i;
    }
}
