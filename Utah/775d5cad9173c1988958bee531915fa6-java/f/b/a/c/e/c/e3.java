package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Iterator;

public final class e3<E> extends b3<E> {

    /* renamed from: i  reason: collision with root package name */
    public static final Object[] f2724i;

    /* renamed from: j  reason: collision with root package name */
    public static final e3<Object> f2725j;

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2726d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2727e;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object[] f2728f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f2729g;

    /* renamed from: h  reason: collision with root package name */
    public final transient int f2730h;

    static {
        Object[] objArr = new Object[0];
        f2724i = objArr;
        f2725j = new e3<>(objArr, 0, objArr, 0, 0);
    }

    public e3(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f2726d = objArr;
        this.f2727e = i2;
        this.f2728f = objArr2;
        this.f2729g = i3;
        this.f2730h = i4;
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.f2728f;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int x1 = b.x1(obj.hashCode());
        while (true) {
            int i2 = x1 & this.f2729g;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            x1 = i2 + 1;
        }
    }

    @Override // f.b.a.c.e.c.x2
    public final int h(Object[] objArr, int i2) {
        System.arraycopy(this.f2726d, 0, objArr, 0, this.f2730h);
        return this.f2730h;
    }

    @Override // f.b.a.c.e.c.b3
    public final int hashCode() {
        return this.f2727e;
    }

    @Override // f.b.a.c.e.c.x2
    public final int i() {
        return this.f2730h;
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
        return this.f2726d;
    }

    @Override // f.b.a.c.e.c.b3
    public final a3<E> p() {
        return a3.p(this.f2726d, this.f2730h);
    }

    @Override // f.b.a.c.e.c.b3
    public final boolean q() {
        return true;
    }

    public final int size() {
        return this.f2730h;
    }
}
