package c.b.a.a.g.b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public final class q2<E> extends s<E> {

    /* renamed from: d  reason: collision with root package name */
    public static final q2<Object> f3398d;

    /* renamed from: c  reason: collision with root package name */
    public final List<E> f3399c;

    static {
        q2<Object> q2Var = new q2<>();
        f3398d = q2Var;
        q2Var.f3405b = false;
    }

    public q2() {
        this.f3399c = new ArrayList(10);
    }

    public q2(List<E> list) {
        this.f3399c = list;
    }

    @Override // java.util.List, java.util.AbstractList
    public final void add(int i, E e2) {
        a();
        this.f3399c.add(i, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E get(int i) {
        return this.f3399c.get(i);
    }

    @Override // c.b.a.a.g.b.e1
    public final /* synthetic */ e1 r(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f3399c);
            return new q2(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final E remove(int i) {
        a();
        E remove = this.f3399c.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E set(int i, E e2) {
        a();
        E e3 = this.f3399c.set(i, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    public final int size() {
        return this.f3399c.size();
    }
}
