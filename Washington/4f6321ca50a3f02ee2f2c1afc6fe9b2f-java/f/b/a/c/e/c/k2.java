package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class k2<E> extends j2<E> implements List<E>, RandomAccess {
    public static final o2<Object> c = new m2(n2.f2513f, 0);

    public static <E> k2<E> p(Collection<? extends E> collection) {
        if (collection instanceof j2) {
            k2<E> m = ((j2) collection).m();
            if (!m.n()) {
                return m;
            }
            Object[] array = m.toArray();
            return q(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (array2[i2] == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i2);
                throw new NullPointerException(sb.toString());
            }
        }
        return q(array2, array2.length);
    }

    public static <E> k2<E> q(Object[] objArr, int i2) {
        return i2 == 0 ? (k2<E>) n2.f2513f : new n2(objArr, i2);
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
                    for (int i2 = 0; i2 < size; i2++) {
                        if (b.c2(get(i2), list.get(i2))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i3 = 0;
                while (true) {
                    if (i3 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e2 = get(i3);
                        i3++;
                        if (!b.c2(e2, it.next())) {
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

    @Override // f.b.a.c.e.c.j2
    public int h(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i3] = get(i3);
        }
        return size;
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = ~(~(get(i3).hashCode() + (i2 * 31)));
        }
        return i2;
    }

    @Override // f.b.a.c.e.c.j2
    public final p2<E> i() {
        return (o2) listIterator();
    }

    public int indexOf(Object obj) {
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

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, f.b.a.c.e.c.j2, java.lang.Iterable
    public Iterator iterator() {
        return (o2) listIterator();
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
        return (o2) listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i2) {
        int size = size();
        if (i2 >= 0 && i2 <= size) {
            return isEmpty() ? c : new m2(this, i2);
        }
        throw new IndexOutOfBoundsException(b.Z1(i2, size, "index"));
    }

    @Override // f.b.a.c.e.c.j2
    public final k2<E> m() {
        return this;
    }

    /* renamed from: o */
    public k2<E> subList(int i2, int i3) {
        b.b2(i2, i3, size());
        int i4 = i3 - i2;
        return i4 == size() ? this : i4 == 0 ? (k2<E>) n2.f2513f : new l2(this, i2, i4);
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
