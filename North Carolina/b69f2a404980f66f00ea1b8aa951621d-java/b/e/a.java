package b.e;

import b.e.g;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class a<K, V> extends h<K, V> implements Map<K, V> {
    public g<K, V> i;

    /* renamed from: b.e.a$a  reason: collision with other inner class name */
    public class C0015a extends g<K, V> {
        public C0015a() {
        }

        @Override // b.e.g
        public void a() {
            a.this.clear();
        }

        @Override // b.e.g
        public Object b(int i, int i2) {
            return a.this.f828c[(i << 1) + i2];
        }

        @Override // b.e.g
        public Map<K, V> c() {
            return a.this;
        }

        @Override // b.e.g
        public int d() {
            return a.this.f829d;
        }

        @Override // b.e.g
        public int e(Object obj) {
            return a.this.e(obj);
        }

        @Override // b.e.g
        public int f(Object obj) {
            return a.this.g(obj);
        }

        @Override // b.e.g
        public void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // b.e.g
        public void h(int i) {
            a.this.i(i);
        }

        @Override // b.e.g
        public V i(int i, V v) {
            int i2 = (i << 1) + 1;
            Object[] objArr = a.this.f828c;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
    }

    public a() {
    }

    public a(int i2) {
        super(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: b.e.a<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(h hVar) {
        if (hVar != null) {
            int i2 = hVar.f829d;
            b(this.f829d + i2);
            if (this.f829d != 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    put(hVar.h(i3), hVar.k(i3));
                }
            } else if (i2 > 0) {
                System.arraycopy(hVar.f827b, 0, this.f827b, 0, i2);
                System.arraycopy(hVar.f828c, 0, this.f828c, 0, i2 << 1);
                this.f829d = i2;
            }
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V> l = l();
        if (l.f812a == null) {
            l.f812a = new g.b();
        }
        return l.f812a;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        g<K, V> l = l();
        if (l.f813b == null) {
            l.f813b = new g.c();
        }
        return l.f813b;
    }

    public final g<K, V> l() {
        if (this.i == null) {
            this.i = new C0015a();
        }
        return this.i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: b.e.a<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.f829d);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        g<K, V> l = l();
        if (l.f814c == null) {
            l.f814c = new g.e();
        }
        return l.f814c;
    }
}
