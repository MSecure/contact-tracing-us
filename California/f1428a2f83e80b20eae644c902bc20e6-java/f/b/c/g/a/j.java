package f.b.c.g.a;

import f.b.c.g.a.i;

public class j<K, V> extends k<K, V> {
    /* JADX WARNING: Illegal instructions before constructor call */
    public j(K k2, V v) {
        super(k2, v, r0, r0);
        h hVar = h.a;
    }

    public j(K k2, V v, i<K, V> iVar, i<K, V> iVar2) {
        super(k2, v, iVar, iVar2);
    }

    @Override // f.b.c.g.a.i
    public boolean g() {
        return true;
    }

    @Override // f.b.c.g.a.k
    public k<K, V> j(K k2, V v, i<K, V> iVar, i<K, V> iVar2) {
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
            iVar2 = this.f2971d;
        }
        return new j(k2, v, iVar, iVar2);
    }

    @Override // f.b.c.g.a.k
    public i.a l() {
        return i.a.RED;
    }

    @Override // f.b.c.g.a.i
    public int size() {
        return this.f2971d.size() + this.c.size() + 1;
    }
}
