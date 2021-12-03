package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.u.h;
import l.b.a.v.m;
import l.b.a.w.c;
import l.b.a.x.a;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.f;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;

public final class o extends c implements d, f, Comparable<o>, Serializable {
    public static final /* synthetic */ int c = 0;
    public final int b;

    static {
        new l.b.a.v.d().n(a.YEAR, 4, 10, m.EXCEEDS_PAD).q();
    }

    public o(int i2) {
        this.b = i2;
    }

    public static o q(e eVar) {
        if (eVar instanceof o) {
            return (o) eVar;
        }
        try {
            if (!l.b.a.u.m.f4408d.equals(h.l(eVar))) {
                eVar = f.E(eVar);
            }
            return s(eVar.b(a.YEAR));
        } catch (b unused) {
            throw new b(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain Year from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    public static boolean r(long j2) {
        return (3 & j2) == 0 && (j2 % 100 != 0 || j2 % 400 == 0);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static o s(int i2) {
        a aVar = a.YEAR;
        aVar.f4506e.b((long) i2, aVar);
        return new o(i2);
    }

    private Object writeReplace() {
        return new n((byte) 67, this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public l.b.a.x.o a(j jVar) {
        if (jVar != a.YEAR_OF_ERA) {
            return super.a(jVar);
        }
        return l.b.a.x.o.d(1, this.b <= 0 ? 1000000000 : 999999999);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public int b(j jVar) {
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) l.b.a.u.m.f4408d;
        }
        if (lVar == k.c) {
            return (R) b.YEARS;
        }
        if (lVar == k.f4524f || lVar == k.f4525g || lVar == k.f4522d || lVar == k.a || lVar == k.f4523e) {
            return null;
        }
        return (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(o oVar) {
        return this.b - oVar.b;
    }

    @Override // l.b.a.x.d
    public d e(f fVar) {
        return (o) fVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o) && this.b == ((o) obj).b;
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar == a.YEAR || jVar == a.YEAR_OF_ERA || jVar == a.ERA : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.x.d
    public d h(long j2, l.b.a.x.m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public int hashCode() {
        return this.b;
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int i2 = 1;
        switch (((a) jVar).ordinal()) {
            case 25:
                int i3 = this.b;
                if (i3 < 1) {
                    i3 = 1 - i3;
                }
                return (long) i3;
            case 26:
                return (long) this.b;
            case 27:
                if (this.b < 1) {
                    i2 = 0;
                }
                return (long) i2;
            default:
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        if (h.l(dVar).equals(l.b.a.u.m.f4408d)) {
            return dVar.l(a.YEAR, (long) this.b);
        }
        throw new b("Adjustment only supported on ISO date-time");
    }

    @Override // l.b.a.x.d
    public long o(d dVar, l.b.a.x.m mVar) {
        o q = q(dVar);
        if (!(mVar instanceof b)) {
            return mVar.b(this, q);
        }
        long j2 = ((long) q.b) - ((long) this.b);
        switch (((b) mVar).ordinal()) {
            case 10:
                return j2;
            case 11:
                return j2 / 10;
            case 12:
                return j2 / 100;
            case 13:
                return j2 / 1000;
            case 14:
                a aVar = a.ERA;
                return q.i(aVar) - i(aVar);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    /* renamed from: t */
    public o m(long j2, l.b.a.x.m mVar) {
        if (!(mVar instanceof b)) {
            return (o) mVar.c(this, j2);
        }
        switch (((b) mVar).ordinal()) {
            case 10:
                return u(j2);
            case 11:
                return u(g.b.a.c.c.d.x(j2, 10));
            case 12:
                return u(g.b.a.c.c.d.x(j2, 100));
            case 13:
                return u(g.b.a.c.c.d.x(j2, 1000));
            case 14:
                a aVar = a.ERA;
                return l(aVar, g.b.a.c.c.d.w(i(aVar), j2));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public String toString() {
        return Integer.toString(this.b);
    }

    public o u(long j2) {
        return j2 == 0 ? this : s(a.YEAR.m(((long) this.b) + j2));
    }

    /* renamed from: v */
    public o l(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (o) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        aVar.f4506e.b(j2, aVar);
        switch (aVar.ordinal()) {
            case 25:
                if (this.b < 1) {
                    j2 = 1 - j2;
                }
                return s((int) j2);
            case 26:
                return s((int) j2);
            case 27:
                return i(a.ERA) == j2 ? this : s(1 - this.b);
            default:
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }
}
