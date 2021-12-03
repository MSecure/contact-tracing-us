package f.b.b.b;

import f.b.a.c.b.o.b;

public final class i<E> extends e<E> {

    /* renamed from: j  reason: collision with root package name */
    public static final i<Object> f3152j = new i<>(new Object[0], 0, null, 0, 0);

    /* renamed from: e  reason: collision with root package name */
    public final transient Object[] f3153e;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object[] f3154f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f3155g;

    /* renamed from: h  reason: collision with root package name */
    public final transient int f3156h;

    /* renamed from: i  reason: collision with root package name */
    public final transient int f3157i;

    public i(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f3153e = objArr;
        this.f3154f = objArr2;
        this.f3155g = i3;
        this.f3156h = i2;
        this.f3157i = i4;
    }

    @Override // f.b.b.b.b
    public boolean contains(Object obj) {
        Object[] objArr = this.f3154f;
        if (obj == null || objArr == null) {
            return false;
        }
        int r1 = b.r1(obj.hashCode());
        while (true) {
            int i2 = r1 & this.f3155g;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            r1 = i2 + 1;
        }
    }

    @Override // f.b.b.b.e
    public int hashCode() {
        return this.f3156h;
    }

    @Override // f.b.b.b.b
    public int i(Object[] objArr, int i2) {
        System.arraycopy(this.f3153e, 0, objArr, i2, this.f3157i);
        return i2 + this.f3157i;
    }

    @Override // f.b.b.b.b
    public Object[] j() {
        return this.f3153e;
    }

    @Override // f.b.b.b.b
    public int k() {
        return this.f3157i;
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
        return c.p(this.f3153e, this.f3157i);
    }

    @Override // f.b.b.b.e
    public boolean s() {
        return true;
    }

    public int size() {
        return this.f3157i;
    }
}
