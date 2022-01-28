package f.b.c.k.u.p;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.k.u.c;
import f.b.c.k.u.f;
import f.b.c.k.u.h;
import f.b.c.k.u.i;
import f.b.c.k.u.k;
import f.b.c.k.u.m;
import f.b.c.k.u.n;
import f.b.d.a.s;
import java.util.Objects;

public final class j extends e {
    public final k c;

    /* renamed from: d  reason: collision with root package name */
    public final c f3313d;

    public j(f fVar, k kVar, c cVar, k kVar2) {
        super(fVar, kVar2);
        this.c = kVar;
        this.f3313d = cVar;
    }

    @Override // f.b.c.k.u.p.e
    public i a(i iVar, i iVar2, d dVar) {
        m mVar;
        g(iVar);
        if (!this.b.c(iVar)) {
            return iVar;
        }
        if (iVar instanceof c) {
            mVar = iVar.b;
        } else {
            mVar = m.c;
        }
        return new c(this.a, mVar, h(iVar), c.a.LOCAL_MUTATIONS);
    }

    @Override // f.b.c.k.u.p.e
    public i b(i iVar, h hVar) {
        g(iVar);
        b.M0(hVar.b == null, "Transform results received by PatchMutation.", new Object[0]);
        if (!this.b.c(iVar)) {
            return new n(this.a, hVar.a);
        }
        return new c(this.a, hVar.a, h(iVar), c.a.COMMITTED_MUTATIONS);
    }

    @Override // f.b.c.k.u.p.e
    public k c(i iVar) {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return d(jVar) && this.c.equals(jVar.c);
    }

    public final k h(i iVar) {
        k kVar;
        if (iVar instanceof c) {
            kVar = ((c) iVar).f3306d;
        } else {
            kVar = k.b;
        }
        Objects.requireNonNull(kVar);
        k.a aVar = new k.a(kVar);
        for (h hVar : this.f3313d.a) {
            if (!hVar.l()) {
                s c2 = this.c.c(hVar);
                if (c2 == null) {
                    b.M0(!hVar.l(), "Cannot delete field for empty path on ObjectValue", new Object[0]);
                    aVar.d(hVar, null);
                } else {
                    aVar.c(hVar, c2);
                }
            }
        }
        return aVar.b();
    }

    public int hashCode() {
        return this.c.hashCode() + (e() * 31);
    }

    public String toString() {
        StringBuilder i2 = a.i("PatchMutation{");
        i2.append(f());
        i2.append(", mask=");
        i2.append(this.f3313d);
        i2.append(", value=");
        i2.append(this.c);
        i2.append("}");
        return i2.toString();
    }
}
