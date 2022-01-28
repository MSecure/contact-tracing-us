package e.c.a;

import e.c.a.t.h;
import e.c.a.t.m;
import e.c.a.u.d;
import e.c.a.v.c;
import e.c.a.w.a;
import e.c.a.w.e;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.n;
import e.c.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class i extends c implements e, f, Comparable<i>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final int f4985b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4986c;

    static {
        d dVar = new d();
        dVar.e("--");
        dVar.m(a.MONTH_OF_YEAR, 2);
        dVar.d('-');
        dVar.m(a.DAY_OF_MONTH, 2);
        dVar.q();
    }

    public i(int i, int i2) {
        this.f4985b = i;
        this.f4986c = i2;
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static i s(int i, int i2) {
        h w = h.w(i);
        c.b.a.a.c.n.c.T1(w, "month");
        a aVar = a.DAY_OF_MONTH;
        aVar.f5158c.b((long) i2, aVar);
        if (i2 <= w.v()) {
            return new i(w.t(), i2);
        }
        StringBuilder h = c.a.a.a.a.h("Illegal value for DayOfMonth field, value ", i2, " is not valid for month ");
        h.append(w.name());
        throw new a(h.toString());
    }

    public static i t(DataInput dataInput) {
        return s(dataInput.readByte(), dataInput.readByte());
    }

    private Object writeReplace() {
        return new m((byte) 64, this);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        if (jVar == a.MONTH_OF_YEAR) {
            return jVar.k();
        }
        if (jVar != a.DAY_OF_MONTH) {
            return super.b(jVar);
        }
        int ordinal = h.w(this.f4985b).ordinal();
        return o.e(1, (long) (ordinal != 1 ? (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31 : 28), (long) h.w(this.f4985b).v());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(i iVar) {
        i iVar2 = iVar;
        int i = this.f4985b - iVar2.f4985b;
        return i == 0 ? this.f4986c - iVar2.f4986c : i;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        return b(jVar).a(l(jVar), jVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f4985b == iVar.f4985b && this.f4986c == iVar.f4986c;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        return lVar == k.f5178b ? (R) m.f5027d : (R) super.f(lVar);
    }

    public int hashCode() {
        return (this.f4985b << 6) + this.f4986c;
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof a ? jVar == a.MONTH_OF_YEAR || jVar == a.DAY_OF_MONTH : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        int i;
        if (!(jVar instanceof a)) {
            return jVar.i(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 18) {
            i = this.f4986c;
        } else if (ordinal == 23) {
            i = this.f4985b;
        } else {
            throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
        return (long) i;
    }

    @Override // e.c.a.w.f
    public e.c.a.w.d p(e.c.a.w.d dVar) {
        if (h.n(dVar).equals(m.f5027d)) {
            e.c.a.w.d n = dVar.n(a.MONTH_OF_YEAR, (long) this.f4985b);
            a aVar = a.DAY_OF_MONTH;
            return n.n(aVar, Math.min(n.b(aVar).f5185e, (long) this.f4986c));
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.f4985b < 10 ? "0" : "");
        sb.append(this.f4985b);
        sb.append(this.f4986c < 10 ? "-0" : "-");
        sb.append(this.f4986c);
        return sb.toString();
    }
}
