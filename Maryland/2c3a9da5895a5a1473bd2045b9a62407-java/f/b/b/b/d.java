package f.b.b.b;

import f.b.b.b.b;
import f.b.b.b.h;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public abstract class d<K, V> implements Map<K, V>, Serializable {
    public transient e<Map.Entry<K, V>> b;
    public transient e<K> c;

    /* renamed from: d  reason: collision with root package name */
    public transient b<V> f2976d;

    public static class a<K, V> {
        public Object[] a;
        public int b;
        public boolean c;

        public a() {
            this.a = new Object[8];
            this.b = 0;
            this.c = false;
        }

        public a(int i2) {
            this.a = new Object[(i2 * 2)];
            this.b = 0;
            this.c = false;
        }

        public d<K, V> a() {
            this.c = true;
            return h.d(this.b, this.a);
        }

        public a<K, V> b(K k2, V v) {
            int i2 = (this.b + 1) * 2;
            Object[] objArr = this.a;
            if (i2 > objArr.length) {
                this.a = Arrays.copyOf(objArr, b.AbstractC0104b.b(objArr.length, i2));
                this.c = false;
            }
            f.b.a.c.b.o.b.y(k2, v);
            Object[] objArr2 = this.a;
            int i3 = this.b;
            int i4 = i3 * 2;
            objArr2[i4] = k2;
            objArr2[i4 + 1] = v;
            this.b = i3 + 1;
            return this;
        }
    }

    public static <K, V> d<K, V> b(K k2, V v, K k3, V v2) {
        f.b.a.c.b.o.b.y(k2, v);
        f.b.a.c.b.o.b.y(k3, v2);
        return h.d(2, new Object[]{k2, v, k3, v2});
    }

    /* renamed from: a */
    public e<Map.Entry<K, V>> entrySet() {
        e<Map.Entry<K, V>> eVar = this.b;
        if (eVar != null) {
            return eVar;
        }
        h hVar = (h) this;
        h.a aVar = new h.a(hVar, hVar.f2983f, 0, hVar.f2984g);
        this.b = aVar;
        return aVar;
    }

    /* renamed from: c */
    public b<V> values() {
        b<V> bVar = this.f2976d;
        if (bVar != null) {
            return bVar;
        }
        h hVar = (h) this;
        h.c cVar = new h.c(hVar.f2983f, 1, hVar.f2984g);
        this.f2976d = cVar;
        return cVar;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public int hashCode() {
        return f.b.a.c.b.o.b.c1(entrySet());
    }

    public boolean isEmpty() {
        return ((h) this).size() == 0;
    }

    @Override // java.util.Map
    public Set keySet() {
        e<K> eVar = this.c;
        if (eVar != null) {
            return eVar;
        }
        h hVar = (h) this;
        h.b bVar = new h.b(hVar, new h.c(hVar.f2983f, 0, hVar.f2984g));
        this.c = bVar;
        return bVar;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k2, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = ((h) this).size();
        f.b.a.c.b.o.b.z(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }
}
