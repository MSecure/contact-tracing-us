package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.t.h;
import l.b.a.u.m;
import l.b.a.v.c;
import l.b.a.w.a;
import l.b.a.w.b;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.o;

public final class n extends c implements d, f, Comparable<n>, Serializable {
    public static final /* synthetic */ int c = 0;
    public final int b;

    static {
        new l.b.a.u.d().n(a.YEAR, 4, 10, m.EXCEEDS_PAD).q();
    }

    public n(int i2) {
        this.b = i2;
    }

    public static n q(e eVar) {
        if (eVar instanceof n) {
            return (n) eVar;
        }
        try {
            if (!l.b.a.t.m.f4084d.equals(h.l(eVar))) {
                eVar = e.E(eVar);
            }
            return s(eVar.b(a.YEAR));
        } catch (a unused) {
            throw new a(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain Year from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    public static boolean r(long j2) {
        return (3 & j2) == 0 && (j2 % 100 != 0 || j2 % 400 == 0);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static n s(int i2) {
        a aVar = a.YEAR;
        aVar.f4182e.b((long) i2, aVar);
        return new n(i2);
    }

    private Object writeReplace() {
        return new m((byte) 67, this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        if (jVar != a.YEAR_OF_ERA) {
            return super.a(jVar);
        }
        return o.d(1, this.b <= 0 ? 1000000000 : 999999999);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) l.b.a.t.m.f4084d;
        }
        if (lVar == k.c) {
            return (R) b.YEARS;
        }
        if (lVar == k.f4200f || lVar == k.f4201g || lVar == k.f4198d || lVar == k.a || lVar == k.f4199e) {
            return null;
        }
        return (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(n nVar) {
        return this.b - nVar.b;
    }

    @Override // l.b.a.w.d
    public d e(f fVar) {
        return (n) fVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n) && this.b == ((n) obj).b;
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar == a.YEAR || jVar == a.YEAR_OF_ERA || jVar == a.ERA : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.w.d
    public d h(long j2, l.b.a.w.m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public int hashCode() {
        return this.b;
    }

    @Override // l.b.a.w.e
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
                throw new l.b.a.w.n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        if (h.l(dVar).equals(l.b.a.t.m.f4084d)) {
            return dVar.l(a.YEAR, (long) this.b);
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    @Override // l.b.a.w.d
    public long o(d dVar, l.b.a.w.m mVar) {
        n q = q(dVar);
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
                throw new l.b.a.w.n("Unsupported unit: " + mVar);
        }
    }

    /* renamed from: t */
    public n m(long j2, l.b.a.w.m mVar) {
        if (!(mVar instanceof b)) {
            return (n) mVar.c(this, j2);
        }
        switch (((b) mVar).ordinal()) {
            case 10:
                return u(j2);
            case 11:
                return u(f.b.a.c.b.o.b.I1(j2, 10));
            case 12:
                return u(f.b.a.c.b.o.b.I1(j2, 100));
            case 13:
                return u(f.b.a.c.b.o.b.I1(j2, 1000));
            case 14:
                a aVar = a.ERA;
                return l(aVar, f.b.a.c.b.o.b.H1(i(aVar), j2));
            default:
                throw new l.b.a.w.n("Unsupported unit: " + mVar);
        }
    }

    public String toString() {
        return Integer.toString(this.b);
    }

    public n u(long j2) {
        return j2 == 0 ? this : s(a.YEAR.m(((long) this.b) + j2));
    }

    /* renamed from: v */
    public n l(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (n) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        aVar.f4182e.b(j2, aVar);
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
                throw new l.b.a.w.n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }
}
