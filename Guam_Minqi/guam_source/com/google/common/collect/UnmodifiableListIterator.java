package com.google.common.collect;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX WARN: Failed to parse class signature: <E:Ljava/lang/Object;><TE>Ljava/util/ListIterator<TE;>; */
public abstract class UnmodifiableListIterator implements ListIterator, Iterator {
    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
