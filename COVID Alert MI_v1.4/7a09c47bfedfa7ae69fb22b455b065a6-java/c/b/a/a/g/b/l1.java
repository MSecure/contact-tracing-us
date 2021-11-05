package c.b.a.a.g.b;

import java.util.Iterator;
import java.util.Map;

public final class l1<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: b  reason: collision with root package name */
    public Iterator<Map.Entry<K, Object>> f3340b;

    public l1(Iterator<Map.Entry<K, Object>> it) {
        this.f3340b = it;
    }

    public final boolean hasNext() {
        return this.f3340b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f3340b.next();
        return next.getValue() instanceof i1 ? new k1(next, null) : next;
    }

    public final void remove() {
        this.f3340b.remove();
    }
}
