package c.b.a.a.g.h;

import java.util.Iterator;
import java.util.Map;

public final class i2<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: b  reason: collision with root package name */
    public Iterator<Map.Entry<K, Object>> f3908b;

    public i2(Iterator<Map.Entry<K, Object>> it) {
        this.f3908b = it;
    }

    public final boolean hasNext() {
        return this.f3908b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f3908b.next();
        return next.getValue() instanceof d2 ? new f2(next, null) : next;
    }

    public final void remove() {
        this.f3908b.remove();
    }
}
