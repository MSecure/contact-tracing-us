package e.e;

import e.e.g;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class a<K, V> extends h<K, V> implements Map<K, V> {

    /* renamed from: i  reason: collision with root package name */
    public g<K, V> f1205i;

    /* renamed from: e.e.a$a  reason: collision with other inner class name */
    public class C0025a extends g<K, V> {
        public C0025a() {
        }

        @Override // e.e.g
        public void a() {
            a.this.clear();
        }

        @Override // e.e.g
        public Object b(int i2, int i3) {
            return a.this.c[(i2 << 1) + i3];
        }

        @Override // e.e.g
        public Map<K, V> c() {
            return a.this;
        }

        @Override // e.e.g
        public int d() {
            return a.this.f1232d;
        }

        @Override // e.e.g
        public int e(Object obj) {
            return a.this.e(obj);
        }

        @Override // e.e.g
        public int f(Object obj) {
            return a.this.g(obj);
        }

        @Override // e.e.g
        public void g(K k2, V v) {
            a.this.put(k2, v);
        }

        @Override // e.e.g
        public void h(int i2) {
            a.this.i(i2);
        }

        @Override // e.e.g
        public V i(int i2, V v) {
            int i3 = (i2 << 1) + 1;
            Object[] objArr = a.this.c;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
    }

    public a() {
    }

    public a(int i2) {
        super(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: e.e.a<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(h hVar) {
        if (hVar != null) {
            int i2 = hVar.f1232d;
            b(this.f1232d + i2);
            if (this.f1232d != 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    put(hVar.h(i3), hVar.k(i3));
                }
            } else if (i2 > 0) {
                System.arraycopy(hVar.b, 0, this.b, 0, i2);
                System.arraycopy(hVar.c, 0, this.c, 0, i2 << 1);
                this.f1232d = i2;
            }
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V> l2 = l();
        if (l2.a == null) {
            l2.a = new g.b();
        }
        return l2.a;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        g<K, V> l2 = l();
        if (l2.b == null) {
            l2.b = new g.c();
        }
        return l2.b;
    }

    public final g<K, V> l() {
        if (this.f1205i == null) {
            this.f1205i = new C0025a();
        }
        return this.f1205i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: e.e.a<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.f1232d);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        g<K, V> l2 = l();
        if (l2.c == null) {
            l2.c = new g.e();
        }
        return l2.c;
    }
}
