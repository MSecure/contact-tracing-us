package g.b.a.t;

import b.x.t;
import g.b.a.e;
import g.b.a.g;
import g.b.a.l;
import g.b.a.w.a;
import g.b.a.w.d;
import g.b.a.w.f;
import g.b.a.w.i;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.m;

public abstract class b extends g.b.a.v.b implements d, f, Comparable<b> {
    public c<?> A(g gVar) {
        return new d(this, gVar);
    }

    /* renamed from: B */
    public int compareTo(b bVar) {
        int L = t.L(P(), bVar.P());
        return L == 0 ? D().compareTo(bVar.D()) : L;
    }

    public abstract h D();

    public i F() {
        return D().n(d(a.ERA));
    }

    /* renamed from: G */
    public b m(long j, m mVar) {
        return D().i(super.m(j, mVar));
    }

    /* renamed from: H */
    public abstract b s(long j, m mVar);

    public b L(i iVar) {
        return D().i(((l) iVar).a(this));
    }

    public long P() {
        return n(a.EPOCH_DAY);
    }

    /* renamed from: Q */
    public b i(f fVar) {
        return D().i(fVar.t(this));
    }

    /* renamed from: R */
    public abstract b r(j jVar, long j);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return compareTo((b) obj) == 0;
        }
        return false;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(g.b.a.w.l<R> lVar) {
        if (lVar == k.f6657b) {
            return (R) D();
        }
        if (lVar == k.f6658c) {
            return (R) g.b.a.w.b.DAYS;
        }
        if (lVar == k.f6661f) {
            return (R) e.h0(P());
        }
        if (lVar == k.f6662g || lVar == k.f6659d || lVar == k.f6656a || lVar == k.f6660e) {
            return null;
        }
        return (R) super.f(lVar);
    }

    public int hashCode() {
        long P = P();
        return ((int) (P ^ (P >>> 32))) ^ D().hashCode();
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof a ? jVar.b() : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(a.EPOCH_DAY, P());
    }

    public String toString() {
        long n = n(a.YEAR_OF_ERA);
        long n2 = n(a.MONTH_OF_YEAR);
        long n3 = n(a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(D().toString());
        sb.append(" ");
        sb.append(F());
        sb.append(" ");
        sb.append(n);
        String str = "-0";
        sb.append(n2 < 10 ? str : "-");
        sb.append(n2);
        if (n3 >= 10) {
            str = "-";
        }
        sb.append(str);
        sb.append(n3);
        return sb.toString();
    }
}
