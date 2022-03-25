package f.b.c.g.a;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

public class a implements Iterator<Map.Entry<K, V>> {
    public int b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f3070d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f3071e;

    public a(b bVar, int i2, boolean z) {
        this.f3071e = bVar;
        this.c = i2;
        this.f3070d = z;
        this.b = i2;
    }

    public boolean hasNext() {
        return !this.f3070d ? this.b < this.f3071e.b.length : this.b >= 0;
    }

    @Override // java.util.Iterator
    public Object next() {
        b bVar = this.f3071e;
        K[] kArr = bVar.b;
        int i2 = this.b;
        K k2 = kArr[i2];
        V v = bVar.c[i2];
        this.b = this.f3070d ? i2 - 1 : i2 + 1;
        return new AbstractMap.SimpleImmutableEntry(k2, v);
    }

    public void remove() {
        throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
    }
}
