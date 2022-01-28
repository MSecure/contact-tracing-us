package b.c.a.b;

import b.c.a.b.b;
import java.util.HashMap;

public class a<K, V> extends b<K, V> {
    public HashMap<K, b.c<K, V>> f = new HashMap<>();

    @Override // b.c.a.b.b
    public b.c<K, V> a(K k) {
        return this.f.get(k);
    }

    public boolean contains(K k) {
        return this.f.containsKey(k);
    }

    @Override // b.c.a.b.b
    public V h(K k, V v) {
        b.c<K, V> cVar = this.f.get(k);
        if (cVar != null) {
            return cVar.f780c;
        }
        this.f.put(k, e(k, v));
        return null;
    }

    @Override // b.c.a.b.b
    public V j(K k) {
        V v = (V) super.j(k);
        this.f.remove(k);
        return v;
    }
}
