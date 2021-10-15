package c.b.a.a.g.h;

import java.util.Map;

public final class y3 implements Comparable<y3>, Map.Entry<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final K f4070b;

    /* renamed from: c  reason: collision with root package name */
    public V f4071c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ r3 f4072d;

    public y3(r3 r3Var, K k, V v) {
        this.f4072d = r3Var;
        this.f4070b = k;
        this.f4071c = v;
    }

    public y3(r3 r3Var, Map.Entry<K, V> entry) {
        V value = entry.getValue();
        this.f4072d = r3Var;
        this.f4070b = entry.getKey();
        this.f4071c = value;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(y3 y3Var) {
        return this.f4070b.compareTo(y3Var.f4070b);
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
        K k = this.f4070b;
        Object key = entry.getKey();
        if (k == null ? key == null : k.equals(key)) {
            V v = this.f4071c;
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
        return this.f4070b;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f4071c;
    }

    public final int hashCode() {
        K k = this.f4070b;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f4071c;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f4072d.j();
        V v2 = this.f4071c;
        this.f4071c = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f4070b);
        String valueOf2 = String.valueOf(this.f4071c);
        StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length() + 1);
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}
