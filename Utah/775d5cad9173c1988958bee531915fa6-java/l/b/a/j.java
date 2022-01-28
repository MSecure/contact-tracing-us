package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.u.h;
import l.b.a.u.m;
import l.b.a.v.d;
import l.b.a.w.c;
import l.b.a.x.a;
import l.b.a.x.e;
import l.b.a.x.f;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;
import l.b.a.x.o;

public final class j extends c implements e, f, Comparable<j>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f4378d = 0;
    public final int b;
    public final int c;

    static {
        d dVar = new d();
        dVar.e("--");
        dVar.m(a.MONTH_OF_YEAR, 2);
        dVar.d('-');
        dVar.m(a.DAY_OF_MONTH, 2);
        dVar.q();
    }

    public j(int i2, int i3) {
        this.b = i2;
        this.c = i3;
    }

    public static j q(int i2, int i3) {
        i u = i.u(i2);
        g.b.a.c.c.d.u(u, "month");
        a aVar = a.DAY_OF_MONTH;
        aVar.f4506e.b((long) i3, aVar);
        if (i3 <= u.t()) {
            return new j(u.r(), i3);
        }
        throw new b("Illegal value for DayOfMonth field, value " + i3 + " is not valid for month " + u.name());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new n((byte) 64, this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public o a(l.b.a.x.j jVar) {
        if (jVar == a.MONTH_OF_YEAR) {
            return jVar.h();
        }
        if (jVar != a.DAY_OF_MONTH) {
            return super.a(jVar);
        }
        int ordinal = i.u(this.b).ordinal();
        return o.e(1, (long) (ordinal != 1 ? (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31 : 28), (long) i.u(this.b).t());
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public int b(l.b.a.x.j jVar) {
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public <R> R c(l<R> lVar) {
        return lVar == k.b ? (R) m.f4408d : (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(j jVar) {
        j jVar2 = jVar;
        int i2 = this.b - jVar2.b;
        return i2 == 0 ? this.c - jVar2.c : i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.b == jVar.b && this.c == jVar.c;
    }

    @Override // l.b.a.x.e
    public boolean f(l.b.a.x.j jVar) {
        return jVar instanceof a ? jVar == a.MONTH_OF_YEAR || jVar == a.DAY_OF_MONTH : jVar != null && jVar.b(this);
    }

    public int hashCode() {
        return (this.b << 6) + this.c;
    }

    @Override // l.b.a.x.e
    public long i(l.b.a.x.j jVar) {
        int i2;
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 18) {
            i2 = this.c;
        } else if (ordinal == 23) {
            i2 = this.b;
        } else {
            throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
        return (long) i2;
    }

    @Override // l.b.a.x.f
    public l.b.a.x.d n(l.b.a.x.d dVar) {
        if (h.l(dVar).equals(m.f4408d)) {
            l.b.a.x.d l2 = dVar.l(a.MONTH_OF_YEAR, (long) this.b);
            a aVar = a.DAY_OF_MONTH;
            return l2.l(aVar, Math.min(l2.a(aVar).f4527e, (long) this.c));
        }
        throw new b("Adjustment only supported on ISO date-time");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.b < 10 ? "0" : "");
        sb.append(this.b);
        sb.append(this.c < 10 ? "-0" : "-");
        sb.append(this.c);
        return sb.toString();
    }
}
