package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class r2<E> extends o2<E> implements List<E>, RandomAccess {
    public static final n2<Object> c = new p2(v2.f2596f, 0);

    public static <E> r2<E> p(Collection<? extends E> collection) {
        if (collection instanceof o2) {
            r2<E> l2 = ((o2) collection).l();
            if (!l2.m()) {
                return l2;
            }
            Object[] array = l2.toArray();
            return q(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i2 = 0; i2 < length; i2++) {
            b.d2(array2[i2], i2);
        }
        return q(array2, length);
    }

    public static <E> r2<E> q(Object[] objArr, int i2) {
        return i2 == 0 ? (r2<E>) v2.f2596f : new v2(objArr, i2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (b.b2(get(i2), list.get(i2))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator<E> it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!b.b2(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // f.b.a.c.e.c.o2
    public final y2<E> h() {
        return listIterator(0);
    }

    public final int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (i2 * 31) + get(i3).hashCode();
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj.equals(get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.List, f.b.a.c.e.c.o2, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // f.b.a.c.e.c.o2
    public final r2<E> l() {
        return this;
    }

    public final int lastIndexOf(Object obj) {
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
    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // f.b.a.c.e.c.o2
    public int n(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i3] = get(i3);
        }
        return size;
    }

    /* renamed from: o */
    public r2<E> subList(int i2, int i3) {
        b.e2(i2, i3, size());
        int i4 = i3 - i2;
        return i4 == size() ? this : i4 == 0 ? (r2<E>) v2.f2596f : new q2(this, i2, i4);
    }

    /* renamed from: r */
    public final n2<E> listIterator(int i2) {
        int size = size();
        if (i2 >= 0 && i2 <= size) {
            return isEmpty() ? (n2<E>) c : new p2(this, i2);
        }
        throw new IndexOutOfBoundsException(b.f2(i2, size, "index"));
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }
}
