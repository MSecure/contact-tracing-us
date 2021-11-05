package c.b.a.a.g.h;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class k0<E> extends AbstractList<E> implements z1<E> {

    /* renamed from: b  reason: collision with root package name */
    public boolean f3921b = true;

    @Override // c.b.a.a.g.h.z1
    public final void H() {
        this.f3921b = false;
    }

    public final void a() {
        if (!this.f3921b) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e2) {
        a();
        return super.add(e2);
    }

    @Override // java.util.List, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends E> collection) {
        a();
        return super.addAll(i, collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        a();
        return super.addAll(collection);
    }

    public void clear() {
        a();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        a();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        a();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        a();
        return super.retainAll(collection);
    }

    @Override // c.b.a.a.g.h.z1
    public boolean s() {
        return this.f3921b;
    }
}
