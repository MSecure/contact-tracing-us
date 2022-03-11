package l.b.a.u;

import l.b.a.h;
import l.b.a.x.a;
import l.b.a.x.d;
import l.b.a.x.f;
import l.b.a.x.i;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.m;
/* loaded from: classes.dex */
public abstract class b extends l.b.a.w.b implements d, f, Comparable<b> {
    @Override // l.b.a.w.c, l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) s();
        }
        if (lVar == k.c) {
            return (R) l.b.a.x.b.DAYS;
        }
        if (lVar == k.f4779f) {
            return (R) l.b.a.f.R(x());
        }
        if (lVar == k.f4780g || lVar == k.f4777d || lVar == k.a || lVar == k.f4778e) {
            return null;
        }
        return (R) super.c(lVar);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar.a() : jVar != null && jVar.b(this);
    }

    @Override // java.lang.Object
    public int hashCode() {
        long x = x();
        return s().hashCode() ^ ((int) (x ^ (x >>> 32)));
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(a.EPOCH_DAY, x());
    }

    public c<?> q(h hVar) {
        return new d(this, hVar);
    }

    /* renamed from: r */
    public int compareTo(b bVar) {
        int e2 = g.b.a.c.c.d.e(x(), bVar.x());
        return e2 == 0 ? s().compareTo(bVar.s()) : e2;
    }

    public abstract h s();

    public i t() {
        return s().i(b(a.ERA));
    }

    @Override // java.lang.Object
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
        return s().e(((l.b.a.m) iVar).b(this));
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
