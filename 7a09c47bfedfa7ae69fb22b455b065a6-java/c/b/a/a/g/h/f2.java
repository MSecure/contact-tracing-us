package c.b.a.a.g.h;

import java.util.Map;

public final class f2<K> implements Map.Entry<K, Object> {

    /* renamed from: b  reason: collision with root package name */
    public Map.Entry<K, d2> f3893b;

    public f2(Map.Entry entry, g2 g2Var) {
        this.f3893b = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f3893b.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f3893b.getValue() == null) {
            return null;
        }
        d2.d();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof c3) {
            d2 value = this.f3893b.getValue();
            c3 c3Var = value.f3903a;
            value.f3904b = null;
            value.f3903a = (c3) obj;
            return c3Var;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
