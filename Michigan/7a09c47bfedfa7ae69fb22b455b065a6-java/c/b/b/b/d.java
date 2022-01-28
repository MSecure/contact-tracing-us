package c.b.b.b;

import b.x.t;

public class d<E> extends c<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final c<Object> f4689f = new d(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f4690d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f4691e;

    public d(Object[] objArr, int i) {
        this.f4690d = objArr;
        this.f4691e = i;
    }

    @Override // c.b.b.b.b, c.b.b.b.c
    public int a(Object[] objArr, int i) {
        System.arraycopy(this.f4690d, 0, objArr, i, this.f4691e);
        return i + this.f4691e;
    }

    @Override // c.b.b.b.b
    public Object[] c() {
        return this.f4690d;
    }

    @Override // c.b.b.b.b
    public int e() {
        return this.f4691e;
    }

    @Override // c.b.b.b.b
    public int g() {
        return 0;
    }

    @Override // java.util.List
    public E get(int i) {
        t.w(i, this.f4691e);
        return (E) this.f4690d[i];
    }

    @Override // c.b.b.b.b
    public boolean h() {
        return false;
    }

    public int size() {
        return this.f4691e;
    }
}
