package c.b.d;

import java.util.Iterator;
import java.util.Map;

public class p0 extends q0 {

    /* renamed from: e  reason: collision with root package name */
    public final h1 f4023e;

    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: b  reason: collision with root package name */
        public Map.Entry<K, p0> f4024b;

        public b(Map.Entry entry, a aVar) {
            this.f4024b = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4024b.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            p0 value = this.f4024b.getValue();
            if (value == null) {
                return null;
            }
            return value.c();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof h1) {
                p0 value = this.f4024b.getValue();
                h1 h1Var = value.f4054c;
                value.f4052a = null;
                value.f4055d = null;
                value.f4054c = (h1) obj;
                return h1Var;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: b  reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f4025b;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f4025b = it;
        }

        public boolean hasNext() {
            return this.f4025b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            Map.Entry<K, Object> next = this.f4025b.next();
            return next.getValue() instanceof p0 ? new b(next, null) : next;
        }

        public void remove() {
            this.f4025b.remove();
        }
    }

    public p0(h1 h1Var, z zVar, j jVar) {
        super(zVar, jVar);
        this.f4023e = h1Var;
    }

    public h1 c() {
        return a(this.f4023e);
    }

    @Override // c.b.d.q0
    public boolean equals(Object obj) {
        return c().equals(obj);
    }

    @Override // c.b.d.q0
    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString();
    }
}
