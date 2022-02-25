package e.c.a.b;

import e.c.a.b.b;
import java.util.HashMap;

public class a<K, V> extends b<K, V> {

    /* renamed from: f  reason: collision with root package name */
    public HashMap<K, b.c<K, V>> f1151f = new HashMap<>();

    public boolean contains(K k2) {
        return this.f1151f.containsKey(k2);
    }

    @Override // e.c.a.b.b
    public b.c<K, V> h(K k2) {
        return this.f1151f.get(k2);
    }

    @Override // e.c.a.b.b
    public V k(K k2, V v) {
        b.c<K, V> cVar = this.f1151f.get(k2);
        if (cVar != null) {
            return cVar.c;
        }
        this.f1151f.put(k2, j(k2, v));
        return null;
    }

    @Override // e.c.a.b.b
    public V l(K k2) {
        V v = (V) super.l(k2);
        this.f1151f.remove(k2);
        return v;
    }
}
