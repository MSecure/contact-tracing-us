package c.b.a.a.g.e;

import b.x.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class na<E> extends ma<E> implements List<E>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public static final wa<Object> f3668c = new pa(ua.f3764f, 0);

    public static <E> na<E> p(E e2) {
        Object[] objArr = {e2};
        for (int i = 0; i <= 0; i++) {
            t.a4(objArr[0], 0);
        }
        return v(objArr, 1);
    }

    public static <E> na<E> q(Collection<? extends E> collection) {
        if (collection instanceof ma) {
            na<E> j = ((ma) collection).j();
            if (!j.l()) {
                return j;
            }
            Object[] array = j.toArray();
            return v(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            t.a4(array2[i], i);
        }
        return v(array2, array2.length);
    }

    public static <E> na<E> u(Object[] objArr) {
        return v(objArr, objArr.length);
    }

    public static <E> na<E> v(Object[] objArr, int i) {
        return i == 0 ? (na<E>) ua.f3764f : new ua(objArr, i);
    }

    public static <E> na<E> w() {
        return (na<E>) ua.f3764f;
    }

    @Override // c.b.a.a.g.e.ma
    public int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // c.b.a.a.g.e.ma
    /* renamed from: c */
    public final xa<E> iterator() {
        return (wa) listIterator();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (t.m4(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e2 = get(i2);
                        i2++;
                        if (!t.m4(e2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // c.b.a.a.g.e.ma
    public final na<E> j() {
        return this;
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (wa) listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        int size = size();
        if (i >= 0 && i <= size) {
            return isEmpty() ? f3668c : new pa(this, i);
        }
        throw new IndexOutOfBoundsException(t.c4(i, size, "index"));
    }

    /* renamed from: o */
    public na<E> subList(int i, int i2) {
        t.e4(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? (na<E>) ua.f3764f : new oa(this, i, i3);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }
}
