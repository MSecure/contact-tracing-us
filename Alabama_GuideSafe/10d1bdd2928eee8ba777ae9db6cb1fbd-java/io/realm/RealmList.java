package io.realm;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.internal.InvalidRow;
import io.realm.internal.OsList;
import io.realm.internal.RealmObjectProxy;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class RealmList<E> extends AbstractList<E> implements OrderedRealmCollection<E> {
    public Class<E> clazz;
    public final ManagedListOperator<E> osListOperator;
    public final BaseRealm realm;
    public List<E> unmanagedList;

    public class RealmItr implements Iterator<E> {
        public int cursor = 0;
        public int expectedModCount = ((AbstractList) RealmList.this).modCount;
        public int lastRet = -1;

        public RealmItr(AnonymousClass1 r2) {
        }

        public final void checkConcurrentModification() {
            if (((AbstractList) RealmList.this).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            RealmList.this.realm.checkIfValid();
            checkConcurrentModification();
            return this.cursor != RealmList.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            RealmList.this.realm.checkIfValid();
            checkConcurrentModification();
            int i = this.cursor;
            try {
                E e = (E) RealmList.this.get(i);
                this.lastRet = i;
                this.cursor = i + 1;
                return e;
            } catch (IndexOutOfBoundsException unused) {
                checkConcurrentModification();
                StringBuilder outline18 = GeneratedOutlineSupport.outline18("Cannot access index ", i, " when size is ");
                outline18.append(RealmList.this.size());
                outline18.append(". Remember to check hasNext() before using next().");
                throw new NoSuchElementException(outline18.toString());
            }
        }

        public void remove() {
            RealmList.this.realm.checkIfValid();
            if (this.lastRet >= 0) {
                checkConcurrentModification();
                try {
                    RealmList.this.remove(this.lastRet);
                    if (this.lastRet < this.cursor) {
                        this.cursor--;
                    }
                    this.lastRet = -1;
                    this.expectedModCount = ((AbstractList) RealmList.this).modCount;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException("Cannot call remove() twice. Must call next() in between.");
            }
        }
    }

    public class RealmListItr extends RealmList<E>.RealmItr implements ListIterator<E> {
        public RealmListItr(int i) {
            super(null);
            if (i < 0 || i > RealmList.this.size()) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Starting location must be a valid index: [0, ");
                outline17.append(RealmList.this.size() - 1);
                outline17.append("]. Index was ");
                outline17.append(i);
                throw new IndexOutOfBoundsException(outline17.toString());
            }
            this.cursor = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            RealmList.this.realm.checkIfValid();
            checkConcurrentModification();
            try {
                int i = this.cursor;
                RealmList.this.add(i, e);
                this.lastRet = -1;
                this.cursor = i + 1;
                this.expectedModCount = ((AbstractList) RealmList.this).modCount;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        public int nextIndex() {
            return this.cursor;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkConcurrentModification();
            int i = this.cursor - 1;
            try {
                E e = (E) RealmList.this.get(i);
                this.cursor = i;
                this.lastRet = i;
                return e;
            } catch (IndexOutOfBoundsException unused) {
                checkConcurrentModification();
                throw new NoSuchElementException(GeneratedOutlineSupport.outline6("Cannot access index less than zero. This was ", i, ". Remember to check hasPrevious() before using previous()."));
            }
        }

        public int previousIndex() {
            return this.cursor - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            RealmList.this.realm.checkIfValid();
            if (this.lastRet >= 0) {
                checkConcurrentModification();
                try {
                    RealmList.this.set(this.lastRet, e);
                    this.expectedModCount = ((AbstractList) RealmList.this).modCount;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public RealmList() {
        this.realm = null;
        this.osListOperator = null;
        this.unmanagedList = new ArrayList();
    }

    public static boolean isClassForRealmModel(Class<?> cls) {
        return RealmModel.class.isAssignableFrom(cls);
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        if (isManaged()) {
            this.realm.checkIfValid();
            ManagedListOperator<E> managedListOperator = this.osListOperator;
            managedListOperator.checkValidValue(e);
            if (e == null) {
                managedListOperator.insertNull(i);
            } else {
                managedListOperator.insertValue(i, e);
            }
        } else {
            this.unmanagedList.add(i, e);
        }
        ((AbstractList) this).modCount++;
    }

    public void clear() {
        if (isManaged()) {
            this.realm.checkIfValid();
            OsList.nativeRemoveAll(this.osListOperator.osList.nativePtr);
        } else {
            this.unmanagedList.clear();
        }
        ((AbstractList) this).modCount++;
    }

    public boolean contains(Object obj) {
        if (!isManaged()) {
            return this.unmanagedList.contains(obj);
        }
        this.realm.checkIfValid();
        if (!(obj instanceof RealmObjectProxy) || ((RealmObjectProxy) obj).realmGet$proxyState().row != InvalidRow.INSTANCE) {
            return super.contains(obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.AbstractList
    public E get(int i) {
        if (!isManaged()) {
            return this.unmanagedList.get(i);
        }
        this.realm.checkIfValid();
        return this.osListOperator.get(i);
    }

    @Override // io.realm.RealmCollection
    public boolean isLoaded() {
        return true;
    }

    public boolean isManaged() {
        return this.realm != null;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<E> iterator() {
        if (isManaged()) {
            return new RealmItr(null);
        }
        return super.iterator();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        E e;
        if (isManaged()) {
            this.realm.checkIfValid();
            e = get(i);
            OsList.nativeRemove(this.osListOperator.osList.nativePtr, (long) i);
        } else {
            e = this.unmanagedList.remove(i);
        }
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        if (!isManaged() || this.realm.isInTransaction()) {
            return super.removeAll(collection);
        }
        throw new IllegalStateException("Objects can only be removed from inside a write transaction.");
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        if (!isManaged()) {
            return this.unmanagedList.set(i, e);
        }
        this.realm.checkIfValid();
        ManagedListOperator<E> managedListOperator = this.osListOperator;
        managedListOperator.checkValidValue(e);
        E e2 = managedListOperator.get(i);
        if (e == null) {
            managedListOperator.setNull(i);
            return e2;
        }
        managedListOperator.setValue(i, e);
        return e2;
    }

    public int size() {
        if (!isManaged()) {
            return this.unmanagedList.size();
        }
        this.realm.checkIfValid();
        long size = this.osListOperator.osList.size();
        if (size < 2147483647L) {
            return (int) size;
        }
        return Integer.MAX_VALUE;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (!isManaged()) {
            sb.append("RealmList<?>@[");
            int size = size();
            while (i < size) {
                E e = get(i);
                if (e instanceof RealmModel) {
                    sb.append(System.identityHashCode(e));
                } else if (e instanceof byte[]) {
                    sb.append("byte[");
                    sb.append(((byte[]) e).length);
                    sb.append("]");
                } else {
                    sb.append((Object) e);
                }
                sb.append(",");
                i++;
            }
            if (size() > 0) {
                sb.setLength(sb.length() - 1);
            }
            sb.append("]");
        } else {
            sb.append("RealmList<");
            if (isClassForRealmModel(this.clazz)) {
                sb.append(this.realm.getSchema().getSchemaForClass(this.clazz).getClassName());
            } else {
                Class<E> cls = this.clazz;
                if (cls == byte[].class) {
                    sb.append(cls.getSimpleName());
                } else {
                    sb.append(cls.getName());
                }
            }
            sb.append(">@[");
            ManagedListOperator<E> managedListOperator = this.osListOperator;
            if (!(managedListOperator != null && OsList.nativeIsValid(managedListOperator.osList.nativePtr))) {
                sb.append("invalid");
            } else if (isClassForRealmModel(this.clazz)) {
                while (i < size()) {
                    sb.append(get(i).realmGet$proxyState().row.getObjectKey());
                    sb.append(",");
                    i++;
                }
                if (size() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            } else {
                while (i < size()) {
                    E e2 = get(i);
                    if (e2 instanceof byte[]) {
                        sb.append("byte[");
                        sb.append(((byte[]) e2).length);
                        sb.append("]");
                    } else {
                        sb.append((Object) e2);
                    }
                    sb.append(",");
                    i++;
                }
                if (size() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    @Override // java.util.List, java.util.AbstractList
    public ListIterator<E> listIterator(int i) {
        if (isManaged()) {
            return new RealmListItr(i);
        }
        return super.listIterator(i);
    }

    public RealmList(Class<E> cls, OsList osList, BaseRealm baseRealm) {
        ManagedListOperator<E> managedListOperator;
        this.clazz = cls;
        if (isClassForRealmModel(cls)) {
            managedListOperator = new RealmModelListOperator<>(baseRealm, osList, cls, null);
        } else if (cls == String.class) {
            managedListOperator = new StringListOperator(baseRealm, osList, cls);
        } else if (cls == Long.class || cls == Integer.class || cls == Short.class || cls == Byte.class) {
            managedListOperator = new LongListOperator<>(baseRealm, osList, cls);
        } else if (cls == Boolean.class) {
            managedListOperator = new BooleanListOperator(baseRealm, osList, cls);
        } else if (cls == byte[].class) {
            managedListOperator = new BinaryListOperator(baseRealm, osList, cls);
        } else if (cls == Double.class) {
            managedListOperator = new DoubleListOperator(baseRealm, osList, cls);
        } else if (cls == Float.class) {
            managedListOperator = new FloatListOperator(baseRealm, osList, cls);
        } else if (cls == Date.class) {
            managedListOperator = new DateListOperator(baseRealm, osList, cls);
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Unexpected value class: ");
            outline17.append(cls.getName());
            throw new IllegalArgumentException(outline17.toString());
        }
        this.osListOperator = managedListOperator;
        this.realm = baseRealm;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e) {
        if (isManaged()) {
            this.realm.checkIfValid();
            ManagedListOperator<E> managedListOperator = this.osListOperator;
            managedListOperator.checkValidValue(e);
            if (e == null) {
                OsList.nativeAddNull(managedListOperator.osList.nativePtr);
            } else {
                managedListOperator.appendValue(e);
            }
        } else {
            this.unmanagedList.add(e);
        }
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        if (!isManaged() || this.realm.isInTransaction()) {
            return super.remove(obj);
        }
        throw new IllegalStateException("Objects can only be removed from inside a write transaction.");
    }
}
