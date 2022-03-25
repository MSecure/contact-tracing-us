package f.b.c.k.u.p;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.k.u.c;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.k;

public final class m extends e {
    public final k c;

    public m(f fVar, k kVar, k kVar2) {
        super(fVar, kVar2);
        this.c = kVar;
    }

    @Override // f.b.c.k.u.p.e
    public i a(i iVar, i iVar2, d dVar) {
        f.b.c.k.u.m mVar;
        g(iVar);
        if (!this.b.c(iVar)) {
            return iVar;
        }
        if (iVar instanceof c) {
            mVar = iVar.b;
        } else {
            mVar = f.b.c.k.u.m.c;
        }
        return new c(this.a, mVar, this.c, c.a.LOCAL_MUTATIONS);
    }

    @Override // f.b.c.k.u.p.e
    public i b(i iVar, h hVar) {
        g(iVar);
        b.b1(hVar.b == null, "Transform results received by SetMutation.", new Object[0]);
        return new c(this.a, hVar.a, this.c, c.a.COMMITTED_MUTATIONS);
    }

    @Override // f.b.c.k.u.p.e
    public k c(i iVar) {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return d(mVar) && this.c.equals(mVar.c);
    }

    public int hashCode() {
        return this.c.hashCode() + (e() * 31);
    }

    public String toString() {
        StringBuilder h2 = a.h("SetMutation{");
        h2.append(f());
        h2.append(", value=");
        h2.append(this.c);
        h2.append("}");
        return h2.toString();
    }
}
