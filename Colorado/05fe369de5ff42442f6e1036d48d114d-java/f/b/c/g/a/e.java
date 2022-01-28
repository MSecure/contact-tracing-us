package f.b.c.g.a;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class e<K, V> implements Iterator<Map.Entry<K, V>> {
    public final ArrayDeque<k<K, V>> b = new ArrayDeque<>();
    public final boolean c;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r6 != false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        r3 = r3.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r6 != false) goto L_0x002e;
     */
    public e(i<K, V> iVar, K k2, Comparator<K> comparator, boolean z) {
        int i2;
        this.c = z;
        while (!iVar.isEmpty()) {
            if (k2 != null) {
                K key = iVar.getKey();
                i2 = z ? comparator.compare(k2, key) : comparator.compare(key, k2);
            } else {
                i2 = 1;
            }
            if (i2 >= 0) {
                if (i2 == 0) {
                    this.b.push((k) iVar);
                    return;
                }
                this.b.push((k) iVar);
            }
            iVar = iVar.c();
        }
    }

    public boolean hasNext() {
        return this.b.size() > 0;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            k<K, V> pop = this.b.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.a, pop.b);
            if (this.c) {
                for (i<K, V> iVar = pop.c; !iVar.isEmpty(); iVar = iVar.a()) {
                    this.b.push((k) iVar);
                }
            } else {
                for (i<K, V> iVar2 = pop.f3170d; !iVar2.isEmpty(); iVar2 = iVar2.c()) {
                    this.b.push((k) iVar2);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
