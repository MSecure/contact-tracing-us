package c.b.a.a.g.b;

import java.util.Map;

public final class k1<K> implements Map.Entry<K, Object> {

    /* renamed from: b  reason: collision with root package name */
    public Map.Entry<K, i1> f3332b;

    public k1(Map.Entry entry, j1 j1Var) {
        this.f3332b = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f3332b.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f3332b.getValue() == null) {
            return null;
        }
        i1.d();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof e2) {
            i1 value = this.f3332b.getValue();
            e2 e2Var = value.f3344a;
            value.f3345b = null;
            value.f3344a = (e2) obj;
            return e2Var;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
