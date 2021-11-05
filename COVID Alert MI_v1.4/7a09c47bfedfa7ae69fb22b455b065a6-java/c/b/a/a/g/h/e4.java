package c.b.a.a.g.h;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class e4 extends AbstractList<String> implements j2, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final j2 f3886b;

    public e4(j2 j2Var) {
        this.f3886b = j2Var;
    }

    @Override // c.b.a.a.g.h.j2
    public final j2 A() {
        return this;
    }

    @Override // c.b.a.a.g.h.j2
    public final List<?> P() {
        return this.f3886b.P();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.f3886b.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new g4(this);
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new h4(this, i);
    }

    @Override // c.b.a.a.g.h.j2
    public final Object n(int i) {
        return this.f3886b.n(i);
    }

    public final int size() {
        return this.f3886b.size();
    }
}
