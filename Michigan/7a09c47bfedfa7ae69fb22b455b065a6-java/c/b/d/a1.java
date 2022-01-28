package c.b.d;

import c.b.d.n0;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class a1<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: c  reason: collision with root package name */
    public static final a1 f5230c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5231b = true;

    static {
        a1 a1Var = new a1();
        f5230c = a1Var;
        a1Var.f5231b = false;
    }

    public a1() {
    }

    public a1(Map<K, V> map) {
        super(map);
    }

    public static <K, V> int a(Map<K, V> map) {
        int i = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            i += b(entry.getValue()) ^ b(entry.getKey());
        }
        return i;
    }

    public static int b(Object obj) {
        if (obj instanceof byte[]) {
            return n0.d((byte[]) obj);
        }
        if (!(obj instanceof n0.c)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public static <K, V> Map<K, V> c(Map<K, V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                value = (V) Arrays.copyOf(bArr, bArr.length);
            }
            linkedHashMap.put(key, value);
        }
        return linkedHashMap;
    }

    public static <K, V> boolean e(Map<K, V> map, Map<K, V> map2) {
        boolean z;
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
            V value = entry.getValue();
            V v = map2.get(entry.getKey());
            if (!(value instanceof byte[]) || !(v instanceof byte[])) {
                z = value.equals(v);
                continue;
            } else {
                z = Arrays.equals((byte[]) value, (byte[]) v);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        d();
        super.clear();
    }

    public final void d() {
        if (!this.f5231b) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && e(this, (Map) obj);
    }

    public int hashCode() {
        return a(this);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public V put(K k, V v) {
        d();
        n0.a(k);
        if (v != null) {
            return (V) super.put(k, v);
        }
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public void putAll(Map<? extends K, ? extends V> map) {
        d();
        for (Object obj : map.keySet()) {
            n0.a(obj);
            n0.a(map.get(obj));
        }
        super.putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public V remove(Object obj) {
        d();
        return (V) super.remove(obj);
    }
}
