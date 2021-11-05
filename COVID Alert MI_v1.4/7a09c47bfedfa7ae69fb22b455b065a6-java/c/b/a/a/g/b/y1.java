package c.b.a.a.g.b;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class y1<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: c  reason: collision with root package name */
    public static final y1 f3478c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3479b = true;

    static {
        y1 y1Var = new y1();
        f3478c = y1Var;
        y1Var.f3479b = false;
    }

    public y1() {
    }

    public y1(Map<K, V> map) {
        super(map);
    }

    public static int b(Object obj) {
        if (obj instanceof byte[]) {
            return b1.b((byte[]) obj);
        }
        if (!(obj instanceof c1)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final void a() {
        if (!this.f3479b) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        a();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    Iterator<Map.Entry<K, V>> it = entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<K, V> next = it.next();
                        if (map.containsKey(next.getKey())) {
                            V value = next.getValue();
                            Object obj2 = map.get(next.getKey());
                            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                                z2 = value.equals(obj2);
                                continue;
                            } else {
                                z2 = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            }
                            if (!z2) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += b(entry.getValue()) ^ b(entry.getKey());
        }
        return i;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final V put(K k, V v) {
        a();
        b1.a(k);
        if (v != null) {
            return (V) super.put(k, v);
        }
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final void putAll(Map<? extends K, ? extends V> map) {
        a();
        for (Object obj : map.keySet()) {
            b1.a(obj);
            b1.a(map.get(obj));
        }
        super.putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final V remove(Object obj) {
        a();
        return (V) super.remove(obj);
    }
}
