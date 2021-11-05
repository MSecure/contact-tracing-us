package e.b.f;

import java.util.ArrayList;
import java.util.Collection;

public abstract class a<E> extends ArrayList<E> {
    public a(int i) {
        super(i);
    }

    public abstract void a();

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public void add(int i, E e2) {
        a();
        super.add(i, e2);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.util.ArrayList
    public boolean add(E e2) {
        a();
        return super.add(e2);
    }

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public boolean addAll(int i, Collection<? extends E> collection) {
        a();
        return super.addAll(i, collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.ArrayList
    public boolean addAll(Collection<? extends E> collection) {
        a();
        return super.addAll(collection);
    }

    public void clear() {
        a();
        super.clear();
    }

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public E remove(int i) {
        a();
        return (E) super.remove(i);
    }

    @Override // java.util.List, java.util.ArrayList
    public boolean remove(Object obj) {
        a();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.ArrayList
    public boolean removeAll(Collection<?> collection) {
        a();
        return super.removeAll(collection);
    }

    public void removeRange(int i, int i2) {
        a();
        super.removeRange(i, i2);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.ArrayList
    public boolean retainAll(Collection<?> collection) {
        a();
        return super.retainAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public E set(int i, E e2) {
        a();
        return (E) super.set(i, e2);
    }
}
