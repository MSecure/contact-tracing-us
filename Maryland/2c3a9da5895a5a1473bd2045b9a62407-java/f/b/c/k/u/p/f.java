package f.b.c.k.u.p;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.k.u.i;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class f {
    public final int a;
    public final d b;
    public final List<e> c;

    /* renamed from: d  reason: collision with root package name */
    public final List<e> f3215d;

    public f(int i2, d dVar, List<e> list, List<e> list2) {
        b.b1(!list2.isEmpty(), "Cannot create an empty mutation batch", new Object[0]);
        this.a = i2;
        this.b = dVar;
        this.c = list;
        this.f3215d = list2;
    }

    public i a(f.b.c.k.u.f fVar, i iVar) {
        if (iVar != null) {
            b.b1(iVar.a.equals(fVar), "applyToRemoteDocument: key %s doesn't match maybeDoc key %s", fVar, iVar.a);
        }
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            e eVar = this.c.get(i2);
            if (eVar.a.equals(fVar)) {
                iVar = eVar.a(iVar, iVar, this.b);
            }
        }
        i iVar2 = iVar;
        for (int i3 = 0; i3 < this.f3215d.size(); i3++) {
            e eVar2 = this.f3215d.get(i3);
            if (eVar2.a.equals(fVar)) {
                iVar2 = eVar2.a(iVar2, iVar, this.b);
            }
        }
        return iVar2;
    }

    public Set<f.b.c.k.u.f> b() {
        HashSet hashSet = new HashSet();
        for (e eVar : this.f3215d) {
            hashSet.add(eVar.a);
        }
        return hashSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && this.b.equals(fVar.b) && this.c.equals(fVar.c) && this.f3215d.equals(fVar.f3215d);
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        return this.f3215d.hashCode() + ((hashCode2 + ((hashCode + (this.a * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder h2 = a.h("MutationBatch(batchId=");
        h2.append(this.a);
        h2.append(", localWriteTime=");
        h2.append(this.b);
        h2.append(", baseMutations=");
        h2.append(this.c);
        h2.append(", mutations=");
        h2.append(this.f3215d);
        h2.append(')');
        return h2.toString();
    }
}
