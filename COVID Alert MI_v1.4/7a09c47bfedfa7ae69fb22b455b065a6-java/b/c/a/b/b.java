package b.c.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    public c<K, V> f1349b;

    /* renamed from: c  reason: collision with root package name */
    public c<K, V> f1350c;

    /* renamed from: d  reason: collision with root package name */
    public WeakHashMap<f<K, V>, Boolean> f1351d = new WeakHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public int f1352e = 0;

    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f1356e;
        }

        @Override // b.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f1355d;
        }
    }

    /* renamed from: b.c.a.b.b$b  reason: collision with other inner class name */
    public static class C0021b<K, V> extends e<K, V> {
        public C0021b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f1355d;
        }

        @Override // b.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f1356e;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final K f1353b;

        /* renamed from: c  reason: collision with root package name */
        public final V f1354c;

        /* renamed from: d  reason: collision with root package name */
        public c<K, V> f1355d;

        /* renamed from: e  reason: collision with root package name */
        public c<K, V> f1356e;

        public c(K k, V v) {
            this.f1353b = k;
            this.f1354c = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f1353b.equals(cVar.f1353b) && this.f1354c.equals(cVar.f1354c);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f1353b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f1354c;
        }

        public int hashCode() {
            return this.f1353b.hashCode() ^ this.f1354c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return ((Object) this.f1353b) + "=" + ((Object) this.f1354c);
        }
    }

    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public c<K, V> f1357b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1358c = true;

        public d() {
        }

        @Override // b.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f1357b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f1356e;
                this.f1357b = cVar3;
                this.f1358c = cVar3 == null;
            }
        }

        public boolean hasNext() {
            if (this.f1358c) {
                return b.this.f1349b != null;
            }
            c<K, V> cVar = this.f1357b;
            return (cVar == null || cVar.f1355d == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar;
            if (this.f1358c) {
                this.f1358c = false;
                cVar = b.this.f1349b;
            } else {
                c<K, V> cVar2 = this.f1357b;
                cVar = cVar2 != null ? cVar2.f1355d : null;
            }
            this.f1357b = cVar;
            return cVar;
        }
    }

    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public c<K, V> f1360b;

        /* renamed from: c  reason: collision with root package name */
        public c<K, V> f1361c;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f1360b = cVar2;
            this.f1361c = cVar;
        }

        @Override // b.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.f1360b == cVar && cVar == this.f1361c) {
                this.f1361c = null;
                this.f1360b = null;
            }
            c<K, V> cVar3 = this.f1360b;
            if (cVar3 == cVar) {
                this.f1360b = b(cVar3);
            }
            c<K, V> cVar4 = this.f1361c;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.f1360b;
                if (!(cVar4 == cVar5 || cVar5 == null)) {
                    cVar2 = c(cVar4);
                }
                this.f1361c = cVar2;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        public boolean hasNext() {
            return this.f1361c != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar = this.f1361c;
            c<K, V> cVar2 = this.f1360b;
            this.f1361c = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public c<K, V> a(K k) {
        c<K, V> cVar = this.f1349b;
        while (cVar != null && !cVar.f1353b.equals(k)) {
            cVar = cVar.f1355d;
        }
        return cVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f1351d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public c<K, V> e(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f1352e++;
        c<K, V> cVar2 = this.f1350c;
        if (cVar2 == null) {
            this.f1349b = cVar;
        } else {
            cVar2.f1355d = cVar;
            cVar.f1356e = cVar2;
        }
        this.f1350c = cVar;
        return cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r3.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (((b.c.a.b.b.e) r7).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return true;
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f1352e != bVar.f1352e) {
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

    public V g(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f1354c;
        }
        e(k, v);
        return null;
    }

    public V h(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f1352e--;
        if (!this.f1351d.isEmpty()) {
            for (f<K, V> fVar : this.f1351d.keySet()) {
                fVar.a(a2);
            }
        }
        c<K, V> cVar = a2.f1356e;
        if (cVar != null) {
            cVar.f1355d = a2.f1355d;
        } else {
            this.f1349b = a2.f1355d;
        }
        c<K, V> cVar2 = a2.f1355d;
        if (cVar2 != null) {
            cVar2.f1356e = a2.f1356e;
        } else {
            this.f1350c = a2.f1356e;
        }
        a2.f1355d = null;
        a2.f1356e = null;
        return a2.f1354c;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return i;
            }
            i += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f1349b, this.f1350c);
        this.f1351d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public String toString() {
        StringBuilder h = c.a.a.a.a.h("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                h.append(((Map.Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    h.append(", ");
                }
            } else {
                h.append("]");
                return h.toString();
            }
        }
    }
}
