package f.b.c.k.u.p;

import f.a.a.a.a;
import f.b.c.d;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.j;
import f.b.c.k.u.k;
import f.b.c.k.u.m;

public final class b extends e {
    public b(f fVar, k kVar) {
        super(fVar, kVar);
    }

    @Override // f.b.c.k.u.p.e
    public i a(i iVar, i iVar2, d dVar) {
        g(iVar);
        if (!this.b.c(iVar)) {
            return iVar;
        }
        return new j(this.a, m.c, false);
    }

    @Override // f.b.c.k.u.p.e
    public i b(i iVar, h hVar) {
        g(iVar);
        f.b.a.c.b.o.b.a1(hVar.b == null, "Transform results received by DeleteMutation.", new Object[0]);
        return new j(this.a, hVar.a, true);
    }

    @Override // f.b.c.k.u.p.e
    public k c(i iVar) {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return d((b) obj);
    }

    public int hashCode() {
        return e();
    }

    public String toString() {
        StringBuilder h2 = a.h("DeleteMutation{");
        h2.append(f());
        h2.append("}");
        return h2.toString();
    }
}
