package c.b.b.b;

import c.b.a.a.c.n.c;

public class d<E> extends c<E> {
    public static final c<Object> f = new d(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f3349d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f3350e;

    public d(Object[] objArr, int i) {
        this.f3349d = objArr;
        this.f3350e = i;
    }

    @Override // c.b.b.b.b, c.b.b.b.c
    public int a(Object[] objArr, int i) {
        System.arraycopy(this.f3349d, 0, objArr, i, this.f3350e);
        return i + this.f3350e;
    }

    @Override // c.b.b.b.b
    public Object[] c() {
        return this.f3349d;
    }

    @Override // c.b.b.b.b
    public int e() {
        return this.f3350e;
    }

    @Override // java.util.List
    public E get(int i) {
        c.r(i, this.f3350e);
        return (E) this.f3349d[i];
    }

    @Override // c.b.b.b.b
    public int h() {
        return 0;
    }

    @Override // c.b.b.b.b
    public boolean j() {
        return false;
    }

    public int size() {
        return this.f3350e;
    }
}
