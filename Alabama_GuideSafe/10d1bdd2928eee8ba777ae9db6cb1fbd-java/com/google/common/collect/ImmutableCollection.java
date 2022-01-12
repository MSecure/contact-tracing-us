package com.google.common.collect;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    public static final Object[] EMPTY_ARRAY = new Object[0];

    public static abstract class ArrayBasedBuilder<E> extends Builder<E> {
        public Object[] contents;
        public boolean forceCopy;
        public int size = 0;

        public ArrayBasedBuilder(int i) {
            ReactYogaConfigProvider.checkNonnegative(i, "initialCapacity");
            this.contents = new Object[i];
        }
    }

    public static abstract class Builder<E> {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
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

    public int copyIntoArray(Object[] objArr, int i) {
        UnmodifiableListIterator<E> listIterator = ((ImmutableList) this).listIterator();
        while (listIterator.hasNext()) {
            objArr[i] = listIterator.next();
            i++;
        }
        return i;
    }

    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return ((ImmutableList) this).listIterator();
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
        return toArray(EMPTY_ARRAY);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        if (tArr != null) {
            int size = size();
            if (tArr.length < size) {
                Object[] internalArray = internalArray();
                if (internalArray != null) {
                    return (T[]) Arrays.copyOfRange(internalArray, internalArrayStart(), internalArrayEnd(), tArr.getClass());
                }
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            } else if (tArr.length > size) {
                tArr[size] = null;
            }
            copyIntoArray(tArr, 0);
            return tArr;
        }
        throw null;
    }
}
