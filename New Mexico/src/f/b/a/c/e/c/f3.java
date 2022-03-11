package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class f3<E> extends b3<E> {

    /* renamed from: d  reason: collision with root package name */
    public final transient E f2773d;

    public f3(E e2) {
        this.f2773d = e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f2773d.equals(obj);
    }

    @Override // f.b.a.c.e.c.x2
    public final int h(Object[] objArr, int i2) {
        objArr[0] = this.f2773d;
        return 1;
    }

    @Override // f.b.a.c.e.c.b3, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        return this.f2773d.hashCode();
    }

    @Override // f.b.a.c.e.c.b3, f.b.a.c.e.c.x2, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return new c3(this.f2773d);
    }

    @Override // f.b.a.c.e.c.b3, f.b.a.c.e.c.x2
    public final a3<E> k() {
        E e2 = this.f2773d;
        w2<Object> w2Var = a3.c;
        Object[] objArr = {e2};
        b.P1(objArr, 1);
        return a3.p(objArr, 1);
    }

    @Override // f.b.a.c.e.c.x2
    public final g3<E> l() {
        return new c3(this.f2773d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public final String toString() {
        String obj = this.f2773d.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
