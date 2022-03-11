package l.b.a;

import f.b.a.c.b.o.b;
import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.t.h;
import l.b.a.t.m;
import l.b.a.u.d;
import l.b.a.v.c;
import l.b.a.w.a;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.n;
import l.b.a.w.o;

public final class i extends c implements e, f, Comparable<i>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f4062d = 0;
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

    public i(int i2, int i3) {
        this.b = i2;
        this.c = i3;
    }

    public static i q(int i2, int i3) {
        h u = h.u(i2);
        b.B1(u, "month");
        a aVar = a.DAY_OF_MONTH;
        aVar.f4190e.b((long) i3, aVar);
        if (i3 <= u.t()) {
            return new i(u.r(), i3);
        }
        throw new a("Illegal value for DayOfMonth field, value " + i3 + " is not valid for month " + u.name());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 64, this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        if (jVar == a.MONTH_OF_YEAR) {
            return jVar.h();
        }
        if (jVar != a.DAY_OF_MONTH) {
            return super.a(jVar);
        }
        int ordinal = h.u(this.b).ordinal();
        return o.e(1, (long) (ordinal != 1 ? (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31 : 28), (long) h.u(this.b).t());
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        return lVar == k.b ? (R) m.f4092d : (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(i iVar) {
        i iVar2 = iVar;
        int i2 = this.b - iVar2.b;
        return i2 == 0 ? this.c - iVar2.c : i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.b == iVar.b && this.c == iVar.c;
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar == a.MONTH_OF_YEAR || jVar == a.DAY_OF_MONTH : jVar != null && jVar.b(this);
    }

    public int hashCode() {
        return (this.b << 6) + this.c;
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
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

    @Override // l.b.a.w.f
    public l.b.a.w.d n(l.b.a.w.d dVar) {
        if (h.l(dVar).equals(m.f4092d)) {
            l.b.a.w.d l2 = dVar.l(a.MONTH_OF_YEAR, (long) this.b);
            a aVar = a.DAY_OF_MONTH;
            return l2.l(aVar, Math.min(l2.a(aVar).f4211e, (long) this.c));
        }
        throw new a("Adjustment only supported on ISO date-time");
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
