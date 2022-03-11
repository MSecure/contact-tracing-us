package f.b.c.g.a;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a implements Iterator<Map.Entry<K, V>> {
    public int b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f3483d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f3484e;

    public a(b bVar, int i2, boolean z) {
        this.f3484e = bVar;
        this.c = i2;
        this.f3483d = z;
        this.b = i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f3483d ? this.b < this.f3484e.b.length : this.b >= 0;
    }

    @Override // java.util.Iterator
    public Object next() {
        b bVar = this.f3484e;
        Object[] objArr = bVar.b;
        int i2 = this.b;
        Object obj = objArr[i2];
        Object obj2 = bVar.c[i2];
        this.b = this.f3483d ? i2 - 1 : i2 + 1;
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
    }
}
