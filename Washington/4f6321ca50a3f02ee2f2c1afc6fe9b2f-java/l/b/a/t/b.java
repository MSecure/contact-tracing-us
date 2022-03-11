package l.b.a.t;

import l.b.a.e;
import l.b.a.g;
import l.b.a.w.a;
import l.b.a.w.d;
import l.b.a.w.f;
import l.b.a.w.i;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.m;

public abstract class b extends l.b.a.v.b implements d, f, Comparable<b> {
    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) s();
        }
        if (lVar == k.c) {
            return (R) l.b.a.w.b.DAYS;
        }
        if (lVar == k.f4208f) {
            return (R) e.R(x());
        }
        if (lVar == k.f4209g || lVar == k.f4206d || lVar == k.a || lVar == k.f4207e) {
            return null;
        }
        return (R) super.c(lVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar.a() : jVar != null && jVar.b(this);
    }

    public int hashCode() {
        long x = x();
        return s().hashCode() ^ ((int) (x ^ (x >>> 32)));
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(a.EPOCH_DAY, x());
    }

    public c<?> q(g gVar) {
        return new d(this, gVar);
    }

    /* renamed from: r */
    public int compareTo(b bVar) {
        int L = f.b.a.c.b.o.b.L(x(), bVar.x());
        return L == 0 ? s().compareTo(bVar.s()) : L;
    }

    public abstract h s();

    public i t() {
        return s().i(b(a.ERA));
    }

    public String toString() {
        long i2 = i(a.YEAR_OF_ERA);
        long i3 = i(a.MONTH_OF_YEAR);
        long i4 = i(a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(s().toString());
        sb.append(" ");
        sb.append(t());
        sb.append(" ");
        sb.append(i2);
        String str = "-0";
        sb.append(i3 < 10 ? str : "-");
        sb.append(i3);
        if (i4 >= 10) {
            str = "-";
        }
        sb.append(str);
        sb.append(i4);
        return sb.toString();
    }

    /* renamed from: u */
    public b h(long j2, m mVar) {
        return s().e(super.h(j2, mVar));
    }

    /* renamed from: v */
    public abstract b m(long j2, m mVar);

    public b w(i iVar) {
        return s().e(((l.b.a.l) iVar).b(this));
    }

    public long x() {
        return i(a.EPOCH_DAY);
    }

    /* renamed from: y */
    public b e(f fVar) {
        return s().e(fVar.n(this));
    }

    /* renamed from: z */
    public abstract b l(j jVar, long j2);
}
