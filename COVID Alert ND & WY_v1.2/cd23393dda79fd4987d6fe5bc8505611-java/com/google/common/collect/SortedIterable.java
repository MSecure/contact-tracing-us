package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

/* access modifiers changed from: package-private */
public interface SortedIterable<T> extends Iterable<T> {
    Comparator<? super T> comparator();

    @Override // java.lang.Iterable
    Iterator<T> iterator();
}
