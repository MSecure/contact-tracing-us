package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {
    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    Map<K, Collection<V>> asMap();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    SortedSet<V> get(@NullableDecl K k);

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    SortedSet<V> removeAll(@NullableDecl Object obj);

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
