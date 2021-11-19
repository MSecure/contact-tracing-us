package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface BiMap<K, V> extends Map<K, V> {
    @NullableDecl
    V forcePut(@NullableDecl K k, @NullableDecl V v);

    BiMap<V, K> inverse();

    @Override // java.util.Map
    @NullableDecl
    V put(@NullableDecl K k, @NullableDecl V v);

    @Override // java.util.Map
    void putAll(Map<? extends K, ? extends V> map);

    @Override // java.util.Map
    Set<V> values();
}
