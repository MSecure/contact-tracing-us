package c.b.a.a.e.c;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

public abstract class ma<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final Object[] f2669b = new Object[0];

    public int a(Object[] objArr, int i) {
        xa xaVar = (xa) iterator();
        while (xaVar.hasNext()) {
            objArr[i] = xaVar.next();
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

    /* renamed from: c */
    public abstract xa<E> iterator();

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public Object[] e() {
        return null;
    }

    public int h() {
        throw new UnsupportedOperationException();
    }

    public int j() {
        throw new UnsupportedOperationException();
    }

    public na<E> m() {
        return isEmpty() ? na.u() : na.s(toArray());
    }

    public abstract boolean o();

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
        return toArray(f2669b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        if (tArr != null) {
            int size = size();
            if (tArr.length < size) {
                Object[] e2 = e();
                if (e2 != null) {
                    return (T[]) Arrays.copyOfRange(e2, h(), j(), tArr.getClass());
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
