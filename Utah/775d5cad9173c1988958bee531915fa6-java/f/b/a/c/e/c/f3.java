package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Iterator;

public final class f3<E> extends b3<E> {

    /* renamed from: d  reason: collision with root package name */
    public final transient E f2731d;

    /* renamed from: e  reason: collision with root package name */
    public transient int f2732e;

    public f3(E e2) {
        this.f2731d = e2;
    }

    public f3(E e2, int i2) {
        this.f2731d = e2;
        this.f2732e = i2;
    }

    public final boolean contains(Object obj) {
        return this.f2731d.equals(obj);
    }

    @Override // f.b.a.c.e.c.x2
    public final int h(Object[] objArr, int i2) {
        objArr[0] = this.f2731d;
        return 1;
    }

    @Override // f.b.a.c.e.c.b3
    public final int hashCode() {
        int i2 = this.f2732e;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.f2731d.hashCode();
        this.f2732e = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, f.b.a.c.e.c.b3, java.util.Collection, java.util.Set, java.lang.Iterable, f.b.a.c.e.c.x2
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new c3(this.f2731d);
    }

    @Override // f.b.a.c.e.c.x2
    public final g3<E> l() {
        return new c3(this.f2731d);
    }

    @Override // f.b.a.c.e.c.b3
    public final a3<E> p() {
        E e2 = this.f2731d;
        w2<Object> w2Var = a3.c;
        Object[] objArr = {e2};
        for (int i2 = 0; i2 < 1; i2++) {
            b.B1(objArr[i2], i2);
        }
        return a3.p(objArr, 1);
    }

    @Override // f.b.a.c.e.c.b3
    public final boolean q() {
        return this.f2732e != 0;
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.f2731d.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
