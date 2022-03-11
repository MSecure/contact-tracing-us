package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e3<E> extends b3<E> {

    /* renamed from: i  reason: collision with root package name */
    public static final Object[] f2766i;

    /* renamed from: j  reason: collision with root package name */
    public static final e3<Object> f2767j;

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f2768d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f2769e;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object[] f2770f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f2771g;

    /* renamed from: h  reason: collision with root package name */
    public final transient int f2772h;

    static {
        Object[] objArr = new Object[0];
        f2766i = objArr;
        f2767j = new e3<>(objArr, 0, objArr, 0, 0);
    }

    public e3(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f2768d = objArr;
        this.f2769e = i2;
        this.f2770f = objArr2;
        this.f2771g = i3;
        this.f2772h = i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object[] objArr = this.f2770f;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int y1 = b.y1(obj.hashCode());
        while (true) {
            int i2 = y1 & this.f2771g;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            y1 = i2 + 1;
        }
    }

    @Override // f.b.a.c.e.c.x2
    public final int h(Object[] objArr, int i2) {
        System.arraycopy(this.f2768d, 0, objArr, 0, this.f2772h);
        return this.f2772h;
    }

    @Override // f.b.a.c.e.c.b3, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        return this.f2769e;
    }

    @Override // f.b.a.c.e.c.x2
    public final int i() {
        return this.f2772h;
    }

    @Override // f.b.a.c.e.c.b3, f.b.a.c.e.c.x2, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
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
        return this.f2768d;
    }

    @Override // f.b.a.c.e.c.b3
    public final a3<E> p() {
        return a3.p(this.f2768d, this.f2772h);
    }

    @Override // f.b.a.c.e.c.b3
    public final boolean q() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f2772h;
    }
}
