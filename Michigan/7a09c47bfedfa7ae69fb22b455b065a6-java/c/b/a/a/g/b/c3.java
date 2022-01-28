package c.b.a.a.g.b;

import java.util.Map;

public final class c3 implements Comparable<c3>, Map.Entry<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final K f3236b;

    /* renamed from: c  reason: collision with root package name */
    public V f3237c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ x2 f3238d;

    public c3(x2 x2Var, K k, V v) {
        this.f3238d = x2Var;
        this.f3236b = k;
        this.f3237c = v;
    }

    public c3(x2 x2Var, Map.Entry<K, V> entry) {
        V value = entry.getValue();
        this.f3238d = x2Var;
        this.f3236b = entry.getKey();
        this.f3237c = value;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(c3 c3Var) {
        return this.f3236b.compareTo(c3Var.f3236b);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        K k = this.f3236b;
        Object key = entry.getKey();
        if (k == null ? key == null : k.equals(key)) {
            V v = this.f3237c;
            Object value = entry.getValue();
            if (v == null) {
                z = value == null;
            } else {
                z = v.equals(value);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f3236b;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f3237c;
    }

    public final int hashCode() {
        K k = this.f3236b;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f3237c;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f3238d.h();
        V v2 = this.f3237c;
        this.f3237c = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f3236b);
        String valueOf2 = String.valueOf(this.f3237c);
        StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length() + 1);
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}
