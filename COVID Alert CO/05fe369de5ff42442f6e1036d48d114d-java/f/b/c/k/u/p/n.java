package f.b.c.k.u.p;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.k.u.c;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.k;
import f.b.d.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class n extends e {
    public final List<d> c;

    public n(f fVar, List<d> list) {
        super(fVar, k.a(true));
        this.c = list;
    }

    @Override // f.b.c.k.u.p.e
    public i a(i iVar, i iVar2, d dVar) {
        g(iVar);
        if (!this.b.c(iVar)) {
            return iVar;
        }
        c h2 = h(iVar);
        ArrayList arrayList = new ArrayList(this.c.size());
        for (d dVar2 : this.c) {
            o oVar = dVar2.b;
            s sVar = null;
            if (iVar instanceof c) {
                sVar = ((c) iVar).b(dVar2.a);
            }
            if (sVar == null && (iVar2 instanceof c)) {
                sVar = ((c) iVar2).b(dVar2.a);
            }
            arrayList.add(oVar.c(sVar, dVar));
        }
        return new c(this.a, h2.b, i(h2.f3306d, arrayList), c.a.LOCAL_MUTATIONS);
    }

    @Override // f.b.c.k.u.p.e
    public i b(i iVar, h hVar) {
        g(iVar);
        b.M0(hVar.b != null, "Transform results missing for TransformMutation.", new Object[0]);
        if (!this.b.c(iVar)) {
            return new f.b.c.k.u.n(this.a, hVar.a);
        }
        c h2 = h(iVar);
        List<s> list = hVar.b;
        ArrayList arrayList = new ArrayList(this.c.size());
        b.M0(this.c.size() == list.size(), "server transform count (%d) should match field transform count (%d)", Integer.valueOf(list.size()), Integer.valueOf(this.c.size()));
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = this.c.get(i2);
            arrayList.add(dVar.b.b(h2.b(dVar.a), list.get(i2)));
        }
        return new c(this.a, hVar.a, i(h2.f3306d, arrayList), c.a.COMMITTED_MUTATIONS);
    }

    @Override // f.b.c.k.u.p.e
    public k c(i iVar) {
        k.a aVar = null;
        for (d dVar : this.c) {
            s a = dVar.b.a(iVar instanceof c ? ((c) iVar).b(dVar.a) : null);
            if (a != null) {
                if (aVar == null) {
                    k kVar = k.b;
                    Objects.requireNonNull(kVar);
                    aVar = new k.a(kVar);
                }
                aVar.c(dVar.a, a);
            }
        }
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return d(nVar) && this.c.equals(nVar.c);
    }

    public final c h(i iVar) {
        b.M0(iVar instanceof c, "Unknown MaybeDocument type %s", iVar);
        c cVar = (c) iVar;
        b.M0(cVar.a.equals(this.a), "Can only transform a document with the same key", new Object[0]);
        return cVar;
    }

    public int hashCode() {
        return this.c.hashCode() + (e() * 31);
    }

    public final k i(k kVar, List<s> list) {
        b.M0(list.size() == this.c.size(), "Transform results length mismatch.", new Object[0]);
        Objects.requireNonNull(kVar);
        k.a aVar = new k.a(kVar);
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            aVar.c(this.c.get(i2).a, list.get(i2));
        }
        return aVar.b();
    }

    public String toString() {
        StringBuilder i2 = a.i("TransformMutation{");
        i2.append(f());
        i2.append(", fieldTransforms=");
        i2.append(this.c);
        i2.append("}");
        return i2.toString();
    }
}
