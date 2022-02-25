package f.b.c.g.a;

import f.b.c.g.a.d;
import f.b.c.g.a.l;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class b<K, V> extends d<K, V> {
    public final K[] b;
    public final V[] c;

    /* renamed from: d  reason: collision with root package name */
    public final Comparator<K> f2968d;

    public b(Comparator<K> comparator) {
        this.b = (K[]) new Object[0];
        this.c = (V[]) new Object[0];
        this.f2968d = comparator;
    }

    public b(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.b = kArr;
        this.c = vArr;
        this.f2968d = comparator;
    }

    public static <T> T[] o(T[] tArr, int i2, T t) {
        int length = tArr.length + 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i2);
        tArr2[i2] = t;
        System.arraycopy(tArr, i2, tArr2, i2 + 1, (length - i2) - 1);
        return tArr2;
    }

    @Override // f.b.c.g.a.d
    public boolean h(K k2) {
        return p(k2) != -1;
    }

    @Override // f.b.c.g.a.d
    public V i(K k2) {
        int p = p(k2);
        if (p != -1) {
            return this.c[p];
        }
        return null;
    }

    @Override // f.b.c.g.a.d
    public boolean isEmpty() {
        return this.b.length == 0;
    }

    @Override // f.b.c.g.a.d, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new a(this, 0, false);
    }

    @Override // f.b.c.g.a.d
    public Comparator<K> j() {
        return this.f2968d;
    }

    @Override // f.b.c.g.a.d
    public K k() {
        K[] kArr = this.b;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    @Override // f.b.c.g.a.d
    public d<K, V> l(K k2, V v) {
        int p = p(k2);
        int i2 = 0;
        if (p != -1) {
            K[] kArr = this.b;
            if (kArr[p] == k2 && this.c[p] == v) {
                return this;
            }
            int length = kArr.length;
            Object[] objArr = new Object[length];
            System.arraycopy(kArr, 0, objArr, 0, length);
            objArr[p] = k2;
            V[] vArr = this.c;
            int length2 = vArr.length;
            Object[] objArr2 = new Object[length2];
            System.arraycopy(vArr, 0, objArr2, 0, length2);
            objArr2[p] = v;
            return new b(this.f2968d, objArr, objArr2);
        } else if (this.b.length > 25) {
            HashMap hashMap = new HashMap(this.b.length + 1);
            while (true) {
                K[] kArr2 = this.b;
                if (i2 < kArr2.length) {
                    hashMap.put(kArr2[i2], this.c[i2]);
                    i2++;
                } else {
                    hashMap.put(k2, v);
                    Comparator<K> comparator = this.f2968d;
                    ArrayList arrayList = new ArrayList(hashMap.keySet());
                    int i3 = d.a.a;
                    return l.b.b(arrayList, hashMap, c.a, comparator);
                }
            }
        } else {
            int q = q(k2);
            return new b(this.f2968d, o(this.b, q, k2), o(this.c, q, v));
        }
    }

    @Override // f.b.c.g.a.d
    public Iterator<Map.Entry<K, V>> m(K k2) {
        return new a(this, q(k2), false);
    }

    @Override // f.b.c.g.a.d
    public d<K, V> n(K k2) {
        int p = p(k2);
        if (p == -1) {
            return this;
        }
        K[] kArr = this.b;
        int length = kArr.length - 1;
        Object[] objArr = new Object[length];
        System.arraycopy(kArr, 0, objArr, 0, p);
        int i2 = p + 1;
        System.arraycopy(kArr, i2, objArr, p, length - p);
        V[] vArr = this.c;
        int length2 = vArr.length - 1;
        Object[] objArr2 = new Object[length2];
        System.arraycopy(vArr, 0, objArr2, 0, p);
        System.arraycopy(vArr, i2, objArr2, p, length2 - p);
        return new b(this.f2968d, objArr, objArr2);
    }

    public final int p(K k2) {
        int i2 = 0;
        for (K k3 : this.b) {
            if (this.f2968d.compare(k2, k3) == 0) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final int q(K k2) {
        int i2 = 0;
        while (true) {
            K[] kArr = this.b;
            if (i2 >= kArr.length || this.f2968d.compare(kArr[i2], k2) >= 0) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    @Override // f.b.c.g.a.d
    public int size() {
        return this.b.length;
    }
}
