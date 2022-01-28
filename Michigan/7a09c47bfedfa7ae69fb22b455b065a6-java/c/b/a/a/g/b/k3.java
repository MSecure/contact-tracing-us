package c.b.a.a.g.b;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class k3 extends AbstractList<String> implements o1, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final o1 f3333b;

    public k3(o1 o1Var) {
        this.f3333b = o1Var;
    }

    @Override // c.b.a.a.g.b.o1
    public final List<?> F() {
        return this.f3333b.F();
    }

    @Override // c.b.a.a.g.b.o1
    public final Object b(int i) {
        return this.f3333b.b(i);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.f3333b.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new m3(this);
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new l3(this, i);
    }

    public final int size() {
        return this.f3333b.size();
    }

    @Override // c.b.a.a.g.b.o1
    public final o1 t() {
        return this;
    }
}
