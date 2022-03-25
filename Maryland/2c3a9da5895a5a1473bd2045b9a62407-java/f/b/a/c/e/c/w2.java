package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Iterator;

public final class w2<E> extends t2<E> {

    /* renamed from: i  reason: collision with root package name */
    public static final w2<Object> f2603i = new w2<>(new Object[0], 0, null, 0, 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2604d;

    /* renamed from: e  reason: collision with root package name */
    public final transient Object[] f2605e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f2606f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f2607g;

    /* renamed from: h  reason: collision with root package name */
    public final transient int f2608h;

    public w2(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f2604d = objArr;
        this.f2605e = objArr2;
        this.f2606f = i3;
        this.f2607g = i2;
        this.f2608h = i4;
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.f2605e;
        if (obj == null || objArr == null) {
            return false;
        }
        int X1 = b.X1(obj.hashCode());
        while (true) {
            int i2 = X1 & this.f2606f;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            X1 = i2 + 1;
        }
    }

    @Override // f.b.a.c.e.c.o2
    public final y2<E> h() {
        return l().listIterator(0);
    }

    @Override // f.b.a.c.e.c.t2
    public final int hashCode() {
        return this.f2607g;
    }

    @Override // f.b.a.c.e.c.o2
    public final Object[] i() {
        return this.f2604d;
    }

    @Override // java.util.AbstractCollection, f.b.a.c.e.c.o2, java.util.Collection, java.util.Set, f.b.a.c.e.c.t2, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return l().listIterator(0);
    }

    @Override // f.b.a.c.e.c.o2
    public final int j() {
        return 0;
    }

    @Override // f.b.a.c.e.c.o2
    public final int k() {
        return this.f2608h;
    }

    @Override // f.b.a.c.e.c.o2
    public final int n(Object[] objArr, int i2) {
        System.arraycopy(this.f2604d, 0, objArr, 0, this.f2608h);
        return this.f2608h;
    }

    @Override // f.b.a.c.e.c.t2
    public final boolean p() {
        return true;
    }

    @Override // f.b.a.c.e.c.t2
    public final r2<E> q() {
        return r2.q(this.f2604d, this.f2608h);
    }

    public final int size() {
        return this.f2608h;
    }
}
