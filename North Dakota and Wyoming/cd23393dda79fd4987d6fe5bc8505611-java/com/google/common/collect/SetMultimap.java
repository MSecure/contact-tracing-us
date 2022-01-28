package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface SetMultimap<K, V> extends Multimap<K, V> {
    @Override // com.google.common.collect.Multimap
    Map<K, Collection<V>> asMap();

    @Override // com.google.common.collect.Multimap
    Set<Map.Entry<K, V>> entries();

    @Override // com.google.common.collect.Multimap
    boolean equals(@NullableDecl Object obj);

    @Override // com.google.common.collect.Multimap
    Set<V> get(@NullableDecl K k);

    @Override // com.google.common.collect.Multimap
    Set<V> removeAll(@NullableDecl Object obj);

    @Override // com.google.common.collect.Multimap
    Set<V> replaceValues(K k, Iterable<? extends V> iterable);
}
