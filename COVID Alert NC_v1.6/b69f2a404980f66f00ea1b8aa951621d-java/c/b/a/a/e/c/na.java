package c.b.a.a.e.c;

import c.b.a.a.c.n.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class na<E> extends ma<E> implements List<E>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public static final wa<Object> f2676c = new pa(ua.f, 0);

    public static <E> na<E> q(E e2) {
        Object[] objArr = {e2};
        for (int i = 0; i <= 0; i++) {
            c.I2(objArr[0], 0);
        }
        return t(objArr, 1);
    }

    public static <E> na<E> r(Collection<? extends E> collection) {
        if (collection instanceof ma) {
            na<E> m = ((ma) collection).m();
            if (!m.o()) {
                return m;
            }
            Object[] array = m.toArray();
            return t(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            c.I2(array2[i], i);
        }
        return t(array2, array2.length);
    }

    public static <E> na<E> s(Object[] objArr) {
        return t(objArr, objArr.length);
    }

    public static <E> na<E> t(Object[] objArr, int i) {
        return i == 0 ? (na<E>) ua.f : new ua(objArr, i);
    }

    public static <E> na<E> u() {
        return (na<E>) ua.f;
    }

    @Override // c.b.a.a.e.c.ma
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

    @Override // c.b.a.a.e.c.ma
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
                        if (c.M2(get(i), list.get(i))) {
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
                        if (!c.M2(e2, it.next())) {
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
            return isEmpty() ? f2676c : new pa(this, i);
        }
        throw new IndexOutOfBoundsException(c.J2(i, size, "index"));
    }

    @Override // c.b.a.a.e.c.ma
    public final na<E> m() {
        return this;
    }

    /* renamed from: p */
    public na<E> subList(int i, int i2) {
        c.L2(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? (na<E>) ua.f : new oa(this, i, i3);
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
