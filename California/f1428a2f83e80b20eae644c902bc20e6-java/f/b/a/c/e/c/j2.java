package f.b.a.c.e.c;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public abstract class j2<E> extends AbstractCollection<E> implements Serializable {
    public static final Object[] b = new Object[0];

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

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public int h(Object[] objArr, int i2) {
        p2 p2Var = (p2) iterator();
        while (p2Var.hasNext()) {
            objArr[i2] = p2Var.next();
            i2++;
        }
        return i2;
    }

    /* renamed from: i */
    public abstract p2<E> iterator();

    public Object[] j() {
        return null;
    }

    public int k() {
        throw new UnsupportedOperationException();
    }

    public int l() {
        throw new UnsupportedOperationException();
    }

    public k2<E> m() {
        if (isEmpty()) {
            o2<Object> o2Var = k2.c;
            return (k2<E>) n2.f2505f;
        }
        Object[] array = toArray();
        o2<Object> o2Var2 = k2.c;
        return k2.q(array, array.length);
    }

    public abstract boolean n();

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
        return toArray(b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        Objects.requireNonNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] j2 = j();
            if (j2 != null) {
                return (T[]) Arrays.copyOfRange(j2, k(), l(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        h(tArr, 0);
        return tArr;
    }
}
