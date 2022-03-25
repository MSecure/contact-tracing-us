package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Iterator;
import java.util.Objects;

public final class x2<E> extends t2<E> {

    /* renamed from: d  reason: collision with root package name */
    public final transient E f2609d;

    /* renamed from: e  reason: collision with root package name */
    public transient int f2610e;

    public x2(E e2) {
        Objects.requireNonNull(e2);
        this.f2609d = e2;
    }

    public x2(E e2, int i2) {
        this.f2609d = e2;
        this.f2610e = i2;
    }

    public final boolean contains(Object obj) {
        return this.f2609d.equals(obj);
    }

    @Override // f.b.a.c.e.c.o2
    public final y2<E> h() {
        return new u2(this.f2609d);
    }

    @Override // f.b.a.c.e.c.t2
    public final int hashCode() {
        int i2 = this.f2610e;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.f2609d.hashCode();
        this.f2610e = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, f.b.a.c.e.c.o2, java.util.Collection, java.util.Set, f.b.a.c.e.c.t2, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new u2(this.f2609d);
    }

    @Override // f.b.a.c.e.c.o2
    public final int n(Object[] objArr, int i2) {
        objArr[0] = this.f2609d;
        return 1;
    }

    @Override // f.b.a.c.e.c.t2
    public final boolean p() {
        return this.f2610e != 0;
    }

    @Override // f.b.a.c.e.c.t2
    public final r2<E> q() {
        E e2 = this.f2609d;
        n2<Object> n2Var = r2.c;
        Object[] objArr = {e2};
        for (int i2 = 0; i2 < 1; i2++) {
            b.d2(objArr[i2], i2);
        }
        return r2.q(objArr, 1);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.f2609d.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
