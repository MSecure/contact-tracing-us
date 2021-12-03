package f.b.c.g.a;

import f.b.c.g.a.i;

public class g<K, V> extends k<K, V> {

    /* renamed from: e  reason: collision with root package name */
    public int f3168e = -1;

    public g(K k2, V v, i<K, V> iVar, i<K, V> iVar2) {
        super(k2, v, iVar, iVar2);
    }

    @Override // f.b.c.g.a.i
    public boolean g() {
        return false;
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
            iVar2 = this.f3170d;
        }
        return new g(k2, v, iVar, iVar2);
    }

    @Override // f.b.c.g.a.k
    public i.a l() {
        return i.a.BLACK;
    }

    @Override // f.b.c.g.a.k
    public void r(i<K, V> iVar) {
        if (this.f3168e == -1) {
            this.c = iVar;
            return;
        }
        throw new IllegalStateException("Can't set left after using size");
    }

    @Override // f.b.c.g.a.i
    public int size() {
        if (this.f3168e == -1) {
            this.f3168e = this.f3170d.size() + this.c.size() + 1;
        }
        return this.f3168e;
    }
}
