package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class a3<E> extends x2<E> implements List<E>, RandomAccess {
    public static final w2<Object> c = new y2(d3.f2667f, 0);

    public static <E> a3<E> p(Object[] objArr, int i2) {
        return i2 == 0 ? (a3<E>) d3.f2667f : new d3(objArr, i2);
    }

    public static <E> a3<E> q(Collection<? extends E> collection) {
        if (collection instanceof x2) {
            a3<E> k2 = ((x2) collection).k();
            if (!k2.m()) {
                return k2;
            }
            Object[] array = k2.toArray();
            return p(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i2 = 0; i2 < length; i2++) {
            b.y1(array2[i2], i2);
        }
        return p(array2, length);
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
                        if (b.A1(get(i2), list.get(i2))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator<E> it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!b.A1(it.next(), it2.next())) {
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

    @Override // f.b.a.c.e.c.x2
    public int h(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i3] = get(i3);
        }
        return size;
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

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable, f.b.a.c.e.c.x2
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // f.b.a.c.e.c.x2
    @Deprecated
    public final a3<E> k() {
        return this;
    }

    @Override // f.b.a.c.e.c.x2
    public final g3<E> l() {
        return listIterator(0);
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

    /* renamed from: o */
    public a3<E> subList(int i2, int i3) {
        b.B1(i2, i3, size());
        int i4 = i3 - i2;
        return i4 == size() ? this : i4 == 0 ? (a3<E>) d3.f2667f : new z2(this, i2, i4);
    }

    /* renamed from: r */
    public final w2<E> listIterator(int i2) {
        int size = size();
        if (i2 >= 0 && i2 <= size) {
            return isEmpty() ? (w2<E>) c : new y2(this, i2);
        }
        throw new IndexOutOfBoundsException(b.C1(i2, size, "index"));
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
