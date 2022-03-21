package f.b.f;

import java.util.Iterator;
import java.util.Map;

public class f0 extends g0 {

    public static class b<K> implements Map.Entry<K, Object> {
        public Map.Entry<K, f0> b;

        public b(Map.Entry entry, a aVar) {
            this.b = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.b.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            f0 value = this.b.getValue();
            if (value == null) {
                return null;
            }
            return value.c();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof t0) {
                f0 value = this.b.getValue();
                t0 t0Var = value.a;
                value.b = null;
                value.a = (t0) obj;
                return t0Var;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    public static class c<K> implements Iterator<Map.Entry<K, Object>> {
        public Iterator<Map.Entry<K, Object>> b;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.b = it;
        }

        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            Map.Entry<K, Object> next = this.b.next();
            return next.getValue() instanceof f0 ? new b(next, null) : next;
        }

        public void remove() {
            this.b.remove();
        }
    }

    public t0 c() {
        return a(null);
    }

    @Override // f.b.f.g0
    public boolean equals(Object obj) {
        return c().equals(obj);
    }

    @Override // f.b.f.g0
    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString();
    }
}
