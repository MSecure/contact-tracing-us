package f.b.c.k.s;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.k.s.i;
import f.b.c.k.u.o;
import f.b.d.a.s;
/* loaded from: classes.dex */
public class h extends i {
    public final i.a a;
    public final s b;
    public final f.b.c.k.u.h c;

    public h(f.b.c.k.u.h hVar, i.a aVar, s sVar) {
        this.c = hVar;
        this.a = aVar;
        this.b = sVar;
    }

    public static h b(f.b.c.k.u.h hVar, i.a aVar, s sVar) {
        i.a aVar2 = i.a.ARRAY_CONTAINS_ANY;
        i.a aVar3 = i.a.NOT_EQUAL;
        i.a aVar4 = i.a.ARRAY_CONTAINS;
        i.a aVar5 = i.a.NOT_IN;
        i.a aVar6 = i.a.EQUAL;
        i.a aVar7 = i.a.IN;
        boolean z = true;
        if (!hVar.s()) {
            s sVar2 = o.a;
            if (!(sVar != null && sVar.y() == s.c.NULL_VALUE)) {
                if (sVar == null || !Double.isNaN(sVar.r())) {
                    z = false;
                }
                if (z) {
                    if (aVar == aVar6 || aVar == aVar3) {
                        return new h(hVar, aVar, sVar);
                    }
                    throw new IllegalArgumentException("Invalid Query. NaN supports only equality comparisons (via whereEqualTo()).");
                } else if (aVar == aVar4) {
                    return new b(hVar, sVar);
                } else {
                    if (aVar == aVar7) {
                        return new o(hVar, sVar);
                    }
                    if (aVar == aVar2) {
                        return new a(hVar, sVar);
                    }
                    return aVar == aVar5 ? new u(hVar, sVar) : new h(hVar, aVar, sVar);
                }
            } else if (aVar == aVar6 || aVar == aVar3) {
                return new h(hVar, aVar, sVar);
            } else {
                throw new IllegalArgumentException("Invalid Query. Null supports only equality comparisons (via whereEqualTo()).");
            }
        } else if (aVar == aVar7) {
            return new q(hVar, sVar);
        } else {
            if (aVar == aVar5) {
                return new r(hVar, sVar);
            }
            if (aVar == aVar4 || aVar == aVar2) {
                z = false;
            }
            b.P0(z, a.e(new StringBuilder(), aVar.b, "queries don't make sense on document keys"), new Object[0]);
            return new p(hVar, aVar, sVar);
        }
    }

    @Override // f.b.c.k.s.i
    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c.c());
        sb.append(this.a.b);
        s sVar = this.b;
        StringBuilder sb2 = new StringBuilder();
        o.a(sb2, sVar);
        sb.append(sb2.toString());
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.a == hVar.a && this.c.equals(hVar.c) && this.b.equals(hVar.b);
    }

    public int hashCode() {
        int hashCode = this.c.hashCode();
        return this.b.hashCode() + ((hashCode + ((this.a.hashCode() + 1147) * 31)) * 31);
    }

    public String toString() {
        return this.c.c() + " " + this.a + " " + this.b;
    }
}
