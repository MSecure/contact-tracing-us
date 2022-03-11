package e.c.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    public c<K, V> b;
    public c<K, V> c;

    /* renamed from: d  reason: collision with root package name */
    public WeakHashMap<f<K, V>, Boolean> f1075d = new WeakHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public int f1076e = 0;

    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // e.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f1078e;
        }

        @Override // e.c.a.b.b.e
        public c<K, V> d(c<K, V> cVar) {
            return cVar.f1077d;
        }
    }

    /* renamed from: e.c.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0022b<K, V> extends e<K, V> {
        public C0022b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // e.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f1077d;
        }

        @Override // e.c.a.b.b.e
        public c<K, V> d(c<K, V> cVar) {
            return cVar.f1078e;
        }
    }

    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        public final K b;
        public final V c;

        /* renamed from: d  reason: collision with root package name */
        public c<K, V> f1077d;

        /* renamed from: e  reason: collision with root package name */
        public c<K, V> f1078e;

        public c(K k2, V v) {
            this.b = k2;
            this.c = v;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b.equals(cVar.b) && this.c.equals(cVar.c);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.c;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.b.hashCode() ^ this.c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        @Override // java.lang.Object
        public String toString() {
            return this.b + "=" + this.c;
        }
    }

    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> b;
        public boolean c = true;

        public d() {
        }

        @Override // e.c.a.b.b.f
        public void b(c<K, V> cVar) {
            c<K, V> cVar2 = this.b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f1078e;
                this.b = cVar3;
                this.c = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c) {
                return b.this.b != null;
            }
            c<K, V> cVar = this.b;
            return (cVar == null || cVar.f1077d == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar;
            if (this.c) {
                this.c = false;
                cVar = b.this.b;
            } else {
                c<K, V> cVar2 = this.b;
                cVar = cVar2 != null ? cVar2.f1077d : null;
            }
            this.b = cVar;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> b;
        public c<K, V> c;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.b = cVar2;
            this.c = cVar;
        }

        @Override // e.c.a.b.b.f
        public void b(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.b == cVar && cVar == this.c) {
                this.c = null;
                this.b = null;
            }
            c<K, V> cVar3 = this.b;
            if (cVar3 == cVar) {
                this.b = c(cVar3);
            }
            c<K, V> cVar4 = this.c;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.b;
                if (!(cVar4 == cVar5 || cVar5 == null)) {
                    cVar2 = d(cVar4);
                }
                this.c = cVar2;
            }
        }

        public abstract c<K, V> c(c<K, V> cVar);

        public abstract c<K, V> d(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar = this.c;
            c<K, V> cVar2 = this.b;
            this.c = (cVar == cVar2 || cVar2 == null) ? null : d(cVar);
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public interface f<K, V> {
        void b(c<K, V> cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r3.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (((e.c.a.b.b.e) r7).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
        return true;
     */
    @Override // java.lang.Object
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f1076e != bVar.f1076e) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                break;
            }
            e eVar2 = (e) it2;
            if (!eVar2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) eVar.next();
            Object next = eVar2.next();
            if ((entry != null || next == null) && (entry == null || entry.equals(next))) {
            }
        }
        return false;
    }

    public c<K, V> h(K k2) {
        c<K, V> cVar = this.b;
        while (cVar != null && !cVar.b.equals(k2)) {
            cVar = cVar.f1077d;
        }
        return cVar;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i2 = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return i2;
            }
            i2 += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    public b<K, V>.d i() {
        b<K, V>.d dVar = new d();
        this.f1075d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.b, this.c);
        this.f1075d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public c<K, V> j(K k2, V v) {
        c<K, V> cVar = new c<>(k2, v);
        this.f1076e++;
        c<K, V> cVar2 = this.c;
        if (cVar2 == null) {
            this.b = cVar;
        } else {
            cVar2.f1077d = cVar;
            cVar.f1078e = cVar2;
        }
        this.c = cVar;
        return cVar;
    }

    public V k(K k2, V v) {
        c<K, V> h2 = h(k2);
        if (h2 != null) {
            return h2.c;
        }
        j(k2, v);
        return null;
    }

    public V l(K k2) {
        c<K, V> h2 = h(k2);
        if (h2 == null) {
            return null;
        }
        this.f1076e--;
        if (!this.f1075d.isEmpty()) {
            for (f<K, V> fVar : this.f1075d.keySet()) {
                fVar.b(h2);
            }
        }
        c<K, V> cVar = h2.f1078e;
        c<K, V> cVar2 = h2.f1077d;
        if (cVar != null) {
            cVar.f1077d = cVar2;
        } else {
            this.b = cVar2;
        }
        c<K, V> cVar3 = h2.f1077d;
        if (cVar3 != null) {
            cVar3.f1078e = cVar;
        } else {
            this.c = cVar;
        }
        h2.f1077d = null;
        h2.f1078e = null;
        return h2.c;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                h2.append(((Map.Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    h2.append(", ");
                }
            } else {
                h2.append("]");
                return h2.toString();
            }
        }
    }
}
