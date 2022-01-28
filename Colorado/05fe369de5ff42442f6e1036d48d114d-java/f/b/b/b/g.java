package f.b.b.b;

import f.b.a.c.b.o.b;

public class g<E> extends c<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final c<Object> f3072f = new g(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f3073d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f3074e;

    public g(Object[] objArr, int i2) {
        this.f3073d = objArr;
        this.f3074e = i2;
    }

    @Override // java.util.List
    public E get(int i2) {
        b.v(i2, this.f3074e);
        return (E) this.f3073d[i2];
    }

    @Override // f.b.b.b.c, f.b.b.b.b
    public int i(Object[] objArr, int i2) {
        System.arraycopy(this.f3073d, 0, objArr, i2, this.f3074e);
        return i2 + this.f3074e;
    }

    @Override // f.b.b.b.b
    public Object[] j() {
        return this.f3073d;
    }

    @Override // f.b.b.b.b
    public int k() {
        return this.f3074e;
    }

    @Override // f.b.b.b.b
    public int l() {
        return 0;
    }

    @Override // f.b.b.b.b
    public boolean m() {
        return false;
    }

    public int size() {
        return this.f3074e;
    }
}
