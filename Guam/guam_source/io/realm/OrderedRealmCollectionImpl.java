package io.realm;

import io.realm.internal.InvalidRow;
import io.realm.internal.OsResults;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.UncheckedRow;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class OrderedRealmCollectionImpl<E> extends AbstractList<E> implements OrderedRealmCollection<E> {
    public final String className = null;
    public final Class<E> classSpec;
    public final OsResults osResults;
    public final BaseRealm realm;

    public class RealmCollectionIterator extends OsResults.Iterator<E> {
        public RealmCollectionIterator() {
            super(OrderedRealmCollectionImpl.this.osResults);
        }

        @Override // io.realm.internal.OsResults.Iterator
        public E convertRowToObject(UncheckedRow uncheckedRow) {
            OrderedRealmCollectionImpl orderedRealmCollectionImpl = OrderedRealmCollectionImpl.this;
            return (E) orderedRealmCollectionImpl.realm.get(orderedRealmCollectionImpl.classSpec, orderedRealmCollectionImpl.className, uncheckedRow);
        }
    }

    public class RealmCollectionListIterator extends OsResults.ListIterator<E> {
        public RealmCollectionListIterator(int i) {
            super(OrderedRealmCollectionImpl.this.osResults, i);
        }

        @Override // io.realm.internal.OsResults.Iterator
        public E convertRowToObject(UncheckedRow uncheckedRow) {
            OrderedRealmCollectionImpl orderedRealmCollectionImpl = OrderedRealmCollectionImpl.this;
            return (E) orderedRealmCollectionImpl.realm.get(orderedRealmCollectionImpl.classSpec, orderedRealmCollectionImpl.className, uncheckedRow);
        }
    }

    public OrderedRealmCollectionImpl(BaseRealm baseRealm, OsResults osResults2, Class<E> cls) {
        this.realm = baseRealm;
        this.osResults = osResults2;
        this.classSpec = cls;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    @Deprecated
    public boolean add(E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.List, java.util.AbstractList
    @Deprecated
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    public boolean contains(Object obj) {
        if (!isLoaded() || ((obj instanceof RealmObjectProxy) && ((RealmObjectProxy) obj).realmGet$proxyState().row == InvalidRow.INSTANCE)) {
            return false;
        }
        RealmCollectionIterator realmCollectionIterator = new RealmCollectionIterator();
        while (realmCollectionIterator.hasNext()) {
            if (realmCollectionIterator.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.AbstractList
    public E get(int i) {
        this.realm.checkIfValid();
        BaseRealm baseRealm = this.realm;
        Class<E> cls = this.classSpec;
        String str = this.className;
        OsResults osResults2 = this.osResults;
        return (E) baseRealm.get(cls, str, osResults2.table.getUncheckedRowByPointer(OsResults.nativeGetRow(osResults2.nativePtr, i)));
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<E> iterator() {
        return new RealmCollectionIterator();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<E> listIterator() {
        return new RealmCollectionListIterator(0);
    }

    @Override // java.util.List, java.util.AbstractList
    @Deprecated
    public E remove(int i) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.List, java.util.AbstractList
    @Deprecated
    public E set(int i, E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    public int size() {
        if (!isLoaded()) {
            return 0;
        }
        long size = this.osResults.size();
        if (size > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) size;
    }

    @Override // java.util.List, java.util.AbstractList
    @Deprecated
    public void add(int i, E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @Deprecated
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<E> listIterator(int i) {
        return new RealmCollectionListIterator(i);
    }

    @Override // java.util.List
    @Deprecated
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }
}
