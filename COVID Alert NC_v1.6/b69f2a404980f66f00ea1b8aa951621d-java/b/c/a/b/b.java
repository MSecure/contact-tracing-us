package b.c.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    public c<K, V> f775b;

    /* renamed from: c  reason: collision with root package name */
    public c<K, V> f776c;

    /* renamed from: d  reason: collision with root package name */
    public WeakHashMap<f<K, V>, Boolean> f777d = new WeakHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public int f778e = 0;

    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f782e;
        }

        @Override // b.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f781d;
        }
    }

    /* renamed from: b.c.a.b.b$b  reason: collision with other inner class name */
    public static class C0014b<K, V> extends e<K, V> {
        public C0014b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f781d;
        }

        @Override // b.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f782e;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final K f779b;

        /* renamed from: c  reason: collision with root package name */
        public final V f780c;

        /* renamed from: d  reason: collision with root package name */
        public c<K, V> f781d;

        /* renamed from: e  reason: collision with root package name */
        public c<K, V> f782e;

        public c(K k, V v) {
            this.f779b = k;
            this.f780c = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f779b.equals(cVar.f779b) && this.f780c.equals(cVar.f780c);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f779b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f780c;
        }

        public int hashCode() {
            return this.f779b.hashCode() ^ this.f780c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return ((Object) this.f779b) + "=" + ((Object) this.f780c);
        }
    }

    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public c<K, V> f783b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f784c = true;

        public d() {
        }

        @Override // b.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f783b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f782e;
                this.f783b = cVar3;
                this.f784c = cVar3 == null;
            }
        }

        public boolean hasNext() {
            if (this.f784c) {
                return b.this.f775b != null;
            }
            c<K, V> cVar = this.f783b;
            return (cVar == null || cVar.f781d == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar;
            if (this.f784c) {
                this.f784c = false;
                cVar = b.this.f775b;
            } else {
                c<K, V> cVar2 = this.f783b;
                cVar = cVar2 != null ? cVar2.f781d : null;
            }
            this.f783b = cVar;
            return cVar;
        }
    }

    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public c<K, V> f786b;

        /* renamed from: c  reason: collision with root package name */
        public c<K, V> f787c;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f786b = cVar2;
            this.f787c = cVar;
        }

        @Override // b.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.f786b == cVar && cVar == this.f787c) {
                this.f787c = null;
                this.f786b = null;
            }
            c<K, V> cVar3 = this.f786b;
            if (cVar3 == cVar) {
                this.f786b = b(cVar3);
            }
            c<K, V> cVar4 = this.f787c;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.f786b;
                if (!(cVar4 == cVar5 || cVar5 == null)) {
                    cVar2 = c(cVar4);
                }
                this.f787c = cVar2;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        public boolean hasNext() {
            return this.f787c != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar = this.f787c;
            c<K, V> cVar2 = this.f786b;
            this.f787c = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public c<K, V> a(K k) {
        c<K, V> cVar = this.f775b;
        while (cVar != null && !cVar.f779b.equals(k)) {
            cVar = cVar.f781d;
        }
        return cVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f777d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public c<K, V> e(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f778e++;
        c<K, V> cVar2 = this.f776c;
        if (cVar2 == null) {
            this.f775b = cVar;
        } else {
            cVar2.f781d = cVar;
            cVar.f782e = cVar2;
        }
        this.f776c = cVar;
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
        if (this.f778e != bVar.f778e) {
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

    public V h(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f780c;
        }
        e(k, v);
        return null;
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
        a aVar = new a(this.f775b, this.f776c);
        this.f777d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V j(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f778e--;
        if (!this.f777d.isEmpty()) {
            for (f<K, V> fVar : this.f777d.keySet()) {
                fVar.a(a2);
            }
        }
        c<K, V> cVar = a2.f782e;
        if (cVar != null) {
            cVar.f781d = a2.f781d;
        } else {
            this.f775b = a2.f781d;
        }
        c<K, V> cVar2 = a2.f781d;
        if (cVar2 != null) {
            cVar2.f782e = a2.f782e;
        } else {
            this.f776c = a2.f782e;
        }
        a2.f781d = null;
        a2.f782e = null;
        return a2.f780c;
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                g.append(((Map.Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    g.append(", ");
                }
            } else {
                g.append("]");
                return g.toString();
            }
        }
    }
}
