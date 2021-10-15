package c.b.b.b;

import b.x.t;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class b<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final Object[] f4680b = new Object[0];

    public static abstract class a<E> extends AbstractC0085b<E> {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f4681a;

        /* renamed from: b  reason: collision with root package name */
        public int f4682b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4683c;

        public a(int i) {
            t.y(i, "initialCapacity");
            this.f4681a = new Object[i];
        }
    }

    /* renamed from: c.b.b.b.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0085b<E> {
    }

    public int a(Object[] objArr, int i) {
        e<E> w = ((c) this).listIterator();
        while (w.hasNext()) {
            objArr[i] = w.next();
            i++;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public Object[] c() {
        return null;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public int e() {
        throw new UnsupportedOperationException();
    }

    public int g() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean h();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return ((c) this).listIterator();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(f4680b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        if (tArr != null) {
            int size = size();
            if (tArr.length < size) {
                Object[] c2 = c();
                if (c2 != null) {
                    return (T[]) Arrays.copyOfRange(c2, g(), e(), tArr.getClass());
                }
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            } else if (tArr.length > size) {
                tArr[size] = null;
            }
            a(tArr, 0);
            return tArr;
        }
        throw null;
    }
}
