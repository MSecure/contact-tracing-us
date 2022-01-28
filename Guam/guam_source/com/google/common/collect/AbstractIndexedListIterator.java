package com.google.common.collect;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.common.collect.ImmutableList;
import java.util.NoSuchElementException;

public abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
    public int position;
    public final int size;

    public AbstractIndexedListIterator(int i, int i2) {
        if (i2 < 0 || i2 > i) {
            throw new IndexOutOfBoundsException(ReactYogaConfigProvider.badPositionIndex(i2, i, "index"));
        }
        this.size = i;
        this.position = i2;
    }

    public final boolean hasNext() {
        return this.position < this.size;
    }

    public final boolean hasPrevious() {
        return this.position > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.position;
            this.position = i + 1;
            return ((ImmutableList.Itr) this).list.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.position;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.position - 1;
            this.position = i;
            return ((ImmutableList.Itr) this).list.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.position - 1;
    }
}
