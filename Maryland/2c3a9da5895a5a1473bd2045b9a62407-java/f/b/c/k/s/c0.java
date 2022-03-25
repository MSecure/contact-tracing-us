package f.b.c.k.s;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.k.s.w;
import f.b.c.k.u.f;
import f.b.c.k.u.l;
import java.util.List;

public final class c0 {
    public String a;
    public final List<w> b;
    public final List<i> c;

    /* renamed from: d  reason: collision with root package name */
    public final l f3112d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3113e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3114f;

    /* renamed from: g  reason: collision with root package name */
    public final c f3115g;

    /* renamed from: h  reason: collision with root package name */
    public final c f3116h;

    public c0(l lVar, String str, List<i> list, List<w> list2, long j2, c cVar, c cVar2) {
        this.f3112d = lVar;
        this.f3113e = str;
        this.b = list2;
        this.c = list;
        this.f3114f = j2;
        this.f3115g = cVar;
        this.f3116h = cVar2;
    }

    public String a() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3112d.c());
        if (this.f3113e != null) {
            sb.append("|cg:");
            sb.append(this.f3113e);
        }
        sb.append("|f:");
        for (i iVar : this.c) {
            sb.append(iVar.a());
        }
        sb.append("|ob:");
        for (w wVar : this.b) {
            sb.append(wVar.b.c());
            sb.append(wVar.a.equals(w.a.ASCENDING) ? "asc" : "desc");
        }
        if (b()) {
            sb.append("|l:");
            b.b1(b(), "Called getLimit when no limit was set", new Object[0]);
            sb.append(this.f3114f);
        }
        if (this.f3115g != null) {
            sb.append("|lb:");
            sb.append(this.f3115g.a());
        }
        if (this.f3116h != null) {
            sb.append("|ub:");
            sb.append(this.f3116h.a());
        }
        String sb2 = sb.toString();
        this.a = sb2;
        return sb2;
    }

    public boolean b() {
        return this.f3114f != -1;
    }

    public boolean c() {
        return f.c(this.f3112d) && this.f3113e == null && this.c.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        String str = this.f3113e;
        if (str == null ? c0Var.f3113e != null : !str.equals(c0Var.f3113e)) {
            return false;
        }
        if (this.f3114f != c0Var.f3114f || !this.b.equals(c0Var.b) || !this.c.equals(c0Var.c) || !this.f3112d.equals(c0Var.f3112d)) {
            return false;
        }
        c cVar = this.f3115g;
        if (cVar == null ? c0Var.f3115g != null : !cVar.equals(c0Var.f3115g)) {
            return false;
        }
        c cVar2 = this.f3116h;
        c cVar3 = c0Var.f3116h;
        return cVar2 != null ? cVar2.equals(cVar3) : cVar3 == null;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode() * 31;
        String str = this.f3113e;
        int i2 = 0;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = this.c.hashCode();
        int hashCode4 = this.f3112d.hashCode();
        long j2 = this.f3114f;
        int i3 = (((hashCode4 + ((hashCode3 + ((hashCode + hashCode2) * 31)) * 31)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        c cVar = this.f3115g;
        int hashCode5 = (i3 + (cVar != null ? cVar.hashCode() : 0)) * 31;
        c cVar2 = this.f3116h;
        if (cVar2 != null) {
            i2 = cVar2.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        StringBuilder h2 = a.h("Query(");
        h2.append(this.f3112d.c());
        if (this.f3113e != null) {
            h2.append(" collectionGroup=");
            h2.append(this.f3113e);
        }
        if (!this.c.isEmpty()) {
            h2.append(" where ");
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                if (i2 > 0) {
                    h2.append(" and ");
                }
                h2.append(this.c.get(i2).toString());
            }
        }
        if (!this.b.isEmpty()) {
            h2.append(" order by ");
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                if (i3 > 0) {
                    h2.append(", ");
                }
                h2.append(this.b.get(i3));
            }
        }
        h2.append(")");
        return h2.toString();
    }
}
