package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
    private static final long serialVersionUID = 0;
    private transient Class<K> keyType;

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.BiMap, com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.BiMap, com.google.common.collect.ForwardingMap, com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(@NullableDecl Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.BiMap, com.google.common.collect.ForwardingMap, com.google.common.collect.AbstractBiMap, com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> cls) {
        return new EnumHashBiMap<>(cls);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> create = create(EnumBiMap.inferKeyType(map));
        create.putAll(map);
        return create;
    }

    private EnumHashBiMap(Class<K> cls) {
        super(new EnumMap(cls), Maps.newHashMapWithExpectedSize(cls.getEnumConstants().length));
        this.keyType = cls;
    }

    /* access modifiers changed from: package-private */
    public K checkKey(K k) {
        return (K) ((Enum) Preconditions.checkNotNull(k));
    }

    public V put(K k, @NullableDecl V v) {
        return (V) super.put((Object) k, (Object) v);
    }

    public V forcePut(K k, @NullableDecl V v) {
        return (V) super.forcePut((Object) k, (Object) v);
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        Serialization.writeMap(this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class) objectInputStream.readObject();
        setDelegates(new EnumMap(this.keyType), new HashMap((this.keyType.getEnumConstants().length * 3) / 2));
        Serialization.populateMap(this, objectInputStream);
    }
}
