package f.b.c.g.a;

import f.b.c.g.a.i;
import java.util.Comparator;

public abstract class k<K, V> implements i<K, V> {
    public final K a;
    public final V b;
    public i<K, V> c;

    /* renamed from: d  reason: collision with root package name */
    public final i<K, V> f3075d;

    public k(K k2, V v, i<K, V> iVar, i<K, V> iVar2) {
        h hVar = h.a;
        this.a = k2;
        this.b = v;
        this.c = iVar == null ? hVar : iVar;
        this.f3075d = iVar2 == null ? hVar : iVar2;
    }

    public static i.a n(i iVar) {
        return iVar.g() ? i.a.BLACK : i.a.RED;
    }

    @Override // f.b.c.g.a.i
    public i<K, V> a() {
        return this.f3075d;
    }

    @Override // f.b.c.g.a.i
    public /* bridge */ /* synthetic */ i b(Object obj, Object obj2, i.a aVar, i iVar, i iVar2) {
        return i(null, null, aVar, iVar, iVar2);
    }

    @Override // f.b.c.g.a.i
    public i<K, V> c() {
        return this.c;
    }

    @Override // f.b.c.g.a.i
    public i<K, V> d(K k2, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k2, this.a);
        return (compare < 0 ? j(null, null, this.c.d(k2, v, comparator), null) : compare == 0 ? j(k2, v, null, null) : j(null, null, null, this.f3075d.d(k2, v, comparator))).k();
    }

    @Override // f.b.c.g.a.i
    public i<K, V> e(K k2, Comparator<K> comparator) {
        k<K, V> kVar;
        if (comparator.compare(k2, this.a) < 0) {
            k<K, V> m = (this.c.isEmpty() || this.c.g() || ((k) this.c).c.g()) ? this : m();
            kVar = m.j(null, null, m.c.e(k2, comparator), null);
        } else {
            k<K, V> q = this.c.g() ? q() : this;
            if (!q.f3075d.isEmpty() && !q.f3075d.g() && !((k) q.f3075d).c.g()) {
                q = q.h();
                if (q.c.c().g()) {
                    q = q.q().h();
                }
            }
            if (comparator.compare(k2, q.a) == 0) {
                if (q.f3075d.isEmpty()) {
                    return h.a;
                }
                i<K, V> f2 = q.f3075d.f();
                q = q.j(f2.getKey(), f2.getValue(), null, ((k) q.f3075d).o());
            }
            kVar = q.j(null, null, null, q.f3075d.e(k2, comparator));
        }
        return kVar.k();
    }

    @Override // f.b.c.g.a.i
    public i<K, V> f() {
        return this.c.isEmpty() ? this : this.c.f();
    }

    @Override // f.b.c.g.a.i
    public K getKey() {
        return this.a;
    }

    @Override // f.b.c.g.a.i
    public V getValue() {
        return this.b;
    }

    public final k<K, V> h() {
        i<K, V> iVar = this.c;
        i<K, V> b2 = iVar.b(null, null, n(iVar), null, null);
        i<K, V> iVar2 = this.f3075d;
        return i(null, null, g() ? i.a.BLACK : i.a.RED, b2, iVar2.b(null, null, n(iVar2), null, null));
    }

    public k<K, V> i(K k2, V v, i.a aVar, i<K, V> iVar, i<K, V> iVar2) {
        if (k2 == null) {
            k2 = this.a;
        }
        if (v == null) {
            v = this.b;
        }
        if (iVar == null) {
            iVar = this.c;
        }
        if (iVar2 == null) {
            iVar2 = this.f3075d;
        }
        return aVar == i.a.RED ? new j(k2, v, iVar, iVar2) : new g(k2, v, iVar, iVar2);
    }

    @Override // f.b.c.g.a.i
    public boolean isEmpty() {
        return false;
    }

    public abstract k<K, V> j(K k2, V v, i<K, V> iVar, i<K, V> iVar2);

    public final k<K, V> k() {
        k<K, V> p = (!this.f3075d.g() || this.c.g()) ? this : p();
        if (p.c.g() && ((k) p.c).c.g()) {
            p = p.q();
        }
        return (!p.c.g() || !p.f3075d.g()) ? p : p.h();
    }

    public abstract i.a l();

    public final k<K, V> m() {
        k<K, V> h2 = h();
        return h2.f3075d.c().g() ? h2.j(null, null, null, ((k) h2.f3075d).q()).p().h() : h2;
    }

    public final i<K, V> o() {
        if (this.c.isEmpty()) {
            return h.a;
        }
        k<K, V> m = (this.c.g() || this.c.c().g()) ? this : m();
        return m.j(null, null, ((k) m.c).o(), null).k();
    }

    public final k<K, V> p() {
        return (k) this.f3075d.b(null, null, l(), i(null, null, i.a.RED, null, ((k) this.f3075d).c), null);
    }

    public final k<K, V> q() {
        return (k) this.c.b(null, null, l(), null, i(null, null, i.a.RED, ((k) this.c).f3075d, null));
    }

    public void r(i<K, V> iVar) {
        this.c = iVar;
    }
}
