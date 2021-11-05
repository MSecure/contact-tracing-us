package c.b.d;

import java.util.Iterator;
import java.util.Map;

public class q0 extends r0 {

    /* renamed from: e  reason: collision with root package name */
    public final i1 f5479e;

    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: b  reason: collision with root package name */
        public Map.Entry<K, q0> f5480b;

        public b(Map.Entry entry, a aVar) {
            this.f5480b = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f5480b.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            q0 value = this.f5480b.getValue();
            if (value == null) {
                return null;
            }
            return value.c();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof i1) {
                q0 value = this.f5480b.getValue();
                i1 i1Var = value.f5779c;
                value.f5777a = null;
                value.f5780d = null;
                value.f5779c = (i1) obj;
                return i1Var;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: b  reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f5481b;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f5481b = it;
        }

        public boolean hasNext() {
            return this.f5481b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            Map.Entry<K, Object> next = this.f5481b.next();
            return next.getValue() instanceof q0 ? new b(next, null) : next;
        }

        public void remove() {
            this.f5481b.remove();
        }
    }

    public q0(i1 i1Var, z zVar, j jVar) {
        super(zVar, jVar);
        this.f5479e = i1Var;
    }

    public i1 c() {
        return a(this.f5479e);
    }

    @Override // c.b.d.r0
    public boolean equals(Object obj) {
        return c().equals(obj);
    }

    @Override // c.b.d.r0
    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString();
    }
}
