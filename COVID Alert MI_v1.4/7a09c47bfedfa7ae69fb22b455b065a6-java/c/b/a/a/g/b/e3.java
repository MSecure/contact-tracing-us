package c.b.a.a.g.b;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class e3 extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x2 f3256b;

    public e3(x2 x2Var, y2 y2Var) {
        this.f3256b = x2Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f3256b.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.f3256b.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f3256b.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new d3(this.f3256b, null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f3256b.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.f3256b.size();
    }
}
