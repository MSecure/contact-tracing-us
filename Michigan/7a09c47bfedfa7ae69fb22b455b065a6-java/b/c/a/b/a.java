package b.c.a.b;

import b.c.a.b.b;
import java.util.HashMap;

public class a<K, V> extends b<K, V> {

    /* renamed from: f  reason: collision with root package name */
    public HashMap<K, b.c<K, V>> f1348f = new HashMap<>();

    @Override // b.c.a.b.b
    public b.c<K, V> a(K k) {
        return this.f1348f.get(k);
    }

    public boolean contains(K k) {
        return this.f1348f.containsKey(k);
    }

    @Override // b.c.a.b.b
    public V g(K k, V v) {
        b.c<K, V> cVar = this.f1348f.get(k);
        if (cVar != null) {
            return cVar.f1354c;
        }
        this.f1348f.put(k, e(k, v));
        return null;
    }

    @Override // b.c.a.b.b
    public V h(K k) {
        V v = (V) super.h(k);
        this.f1348f.remove(k);
        return v;
    }
}
