package f.b.b.b;

import f.b.a.c.b.o.b;
/* loaded from: classes.dex */
public class g<E> extends c<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final c<Object> f3390f = new g(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f3391d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f3392e;

    public g(Object[] objArr, int i2) {
        this.f3391d = objArr;
        this.f3392e = i2;
    }

    @Override // java.util.List
    public E get(int i2) {
        b.w(i2, this.f3392e);
        return (E) this.f3391d[i2];
    }

    @Override // f.b.b.b.c, f.b.b.b.b
    public int i(Object[] objArr, int i2) {
        System.arraycopy(this.f3391d, 0, objArr, i2, this.f3392e);
        return i2 + this.f3392e;
    }

    @Override // f.b.b.b.b
    public Object[] j() {
        return this.f3391d;
    }

    @Override // f.b.b.b.b
    public int k() {
        return this.f3392e;
    }

    @Override // f.b.b.b.b
    public int l() {
        return 0;
    }

    @Override // f.b.b.b.b
    public boolean m() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3392e;
    }
}
