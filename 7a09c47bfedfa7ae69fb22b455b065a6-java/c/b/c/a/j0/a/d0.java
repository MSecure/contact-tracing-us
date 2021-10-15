package c.b.c.a.j0.a;

import java.util.Iterator;
import java.util.Map;

public class d0 extends e0 {

    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: b  reason: collision with root package name */
        public Map.Entry<K, d0> f4905b;

        public b(Map.Entry entry, a aVar) {
            this.f4905b = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4905b.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            d0 value = this.f4905b.getValue();
            if (value == null) {
                return null;
            }
            return value.c();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof r0) {
                d0 value = this.f4905b.getValue();
                r0 r0Var = value.f4916b;
                value.f4915a = null;
                value.f4917c = null;
                value.f4916b = (r0) obj;
                return r0Var;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: b  reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f4906b;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f4906b = it;
        }

        public boolean hasNext() {
            return this.f4906b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            Map.Entry<K, Object> next = this.f4906b.next();
            return next.getValue() instanceof d0 ? new b(next, null) : next;
        }

        public void remove() {
            this.f4906b.remove();
        }
    }

    public r0 c() {
        return a(null);
    }

    @Override // c.b.c.a.j0.a.e0
    public boolean equals(Object obj) {
        return c().equals(obj);
    }

    @Override // c.b.c.a.j0.a.e0
    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString();
    }
}
