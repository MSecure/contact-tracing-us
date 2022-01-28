package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Iterator;

public final class e3<E> extends b3<E> {

    /* renamed from: i  reason: collision with root package name */
    public static final Object[] f2670i;

    /* renamed from: j  reason: collision with root package name */
    public static final e3<Object> f2671j;

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2672d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2673e;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object[] f2674f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f2675g;

    /* renamed from: h  reason: collision with root package name */
    public final transient int f2676h;

    static {
        Object[] objArr = new Object[0];
        f2670i = objArr;
        f2671j = new e3<>(objArr, 0, objArr, 0, 0);
    }

    public e3(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f2672d = objArr;
        this.f2673e = i2;
        this.f2674f = objArr2;
        this.f2675g = i3;
        this.f2676h = i4;
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.f2674f;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int u1 = b.u1(obj.hashCode());
        while (true) {
            int i2 = u1 & this.f2675g;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            u1 = i2 + 1;
        }
    }

    @Override // f.b.a.c.e.c.x2
    public final int h(Object[] objArr, int i2) {
        System.arraycopy(this.f2672d, 0, objArr, 0, this.f2676h);
        return this.f2676h;
    }

    @Override // f.b.a.c.e.c.b3
    public final int hashCode() {
        return this.f2673e;
    }

    @Override // f.b.a.c.e.c.x2
    public final int i() {
        return this.f2676h;
    }

    @Override // java.util.AbstractCollection, f.b.a.c.e.c.b3, java.util.Collection, java.util.Set, java.lang.Iterable, f.b.a.c.e.c.x2
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return k().listIterator(0);
    }

    @Override // f.b.a.c.e.c.x2
    public final int j() {
        return 0;
    }

    @Override // f.b.a.c.e.c.x2
    public final g3<E> l() {
        return k().listIterator(0);
    }

    @Override // f.b.a.c.e.c.x2
    public final Object[] n() {
        return this.f2672d;
    }

    @Override // f.b.a.c.e.c.b3
    public final a3<E> p() {
        return a3.p(this.f2672d, this.f2676h);
    }

    @Override // f.b.a.c.e.c.b3
    public final boolean q() {
        return true;
    }

    public final int size() {
        return this.f2676h;
    }
}
