package e.c.a.t;

import c.b.a.a.c.n.c;
import e.c.a.e;
import e.c.a.g;
import e.c.a.w.a;
import e.c.a.w.d;
import e.c.a.w.f;
import e.c.a.w.i;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.m;

public abstract class b extends e.c.a.v.b implements d, f, Comparable<b> {
    /* renamed from: A */
    public b g(f fVar) {
        return u().g(fVar.p(this));
    }

    /* renamed from: B */
    public abstract b n(j jVar, long j);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return compareTo((b) obj) == 0;
        }
        return false;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5178b) {
            return (R) u();
        }
        if (lVar == k.f5179c) {
            return (R) e.c.a.w.b.DAYS;
        }
        if (lVar == k.f) {
            return (R) e.R(z());
        }
        if (lVar == k.g || lVar == k.f5180d || lVar == k.f5177a || lVar == k.f5181e) {
            return null;
        }
        return (R) super.f(lVar);
    }

    public int hashCode() {
        long z = z();
        return ((int) (z ^ (z >>> 32))) ^ u().hashCode();
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof a ? jVar.b() : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(a.EPOCH_DAY, z());
    }

    public c<?> s(g gVar) {
        return new d(this, gVar);
    }

    /* renamed from: t */
    public int compareTo(b bVar) {
        int A = c.A(z(), bVar.z());
        return A == 0 ? u().compareTo(bVar.u()) : A;
    }

    public String toString() {
        long l = l(a.YEAR_OF_ERA);
        long l2 = l(a.MONTH_OF_YEAR);
        long l3 = l(a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(u().toString());
        sb.append(" ");
        sb.append(v());
        sb.append(" ");
        sb.append(l);
        String str = "-0";
        sb.append(l2 < 10 ? str : "-");
        sb.append(l2);
        if (l3 >= 10) {
            str = "-";
        }
        sb.append(str);
        sb.append(l3);
        return sb.toString();
    }

    public abstract h u();

    public i v() {
        return u().l(d(a.ERA));
    }

    /* renamed from: w */
    public b k(long j, m mVar) {
        return u().g(super.k(j, mVar));
    }

    /* renamed from: x */
    public abstract b o(long j, m mVar);

    public b y(i iVar) {
        return u().g(((e.c.a.l) iVar).a(this));
    }

    public long z() {
        return l(a.EPOCH_DAY);
    }
}
