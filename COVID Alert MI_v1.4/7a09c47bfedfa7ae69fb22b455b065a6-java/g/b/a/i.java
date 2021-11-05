package g.b.a;

import b.x.t;
import g.b.a.t.h;
import g.b.a.t.m;
import g.b.a.u.d;
import g.b.a.v.c;
import g.b.a.w.a;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.n;
import g.b.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class i extends c implements e, f, Comparable<i>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final int f6428b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6429c;

    static {
        d dVar = new d();
        dVar.e("--");
        dVar.m(a.MONTH_OF_YEAR, 2);
        dVar.d('-');
        dVar.m(a.DAY_OF_MONTH, 2);
        dVar.q();
    }

    public i(int i, int i2) {
        this.f6428b = i;
        this.f6429c = i2;
    }

    public static i A(int i, int i2) {
        h D = h.D(i);
        t.y2(D, "month");
        a aVar = a.DAY_OF_MONTH;
        aVar.f6633c.b((long) i2, aVar);
        if (i2 <= D.B()) {
            return new i(D.x(), i2);
        }
        StringBuilder i3 = c.a.a.a.a.i("Illegal value for DayOfMonth field, value ", i2, " is not valid for month ");
        i3.append(D.name());
        throw new a(i3.toString());
    }

    public static i B(DataInput dataInput) {
        return A(dataInput.readByte(), dataInput.readByte());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 64, this);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        if (jVar == a.MONTH_OF_YEAR) {
            return jVar.m();
        }
        if (jVar != a.DAY_OF_MONTH) {
            return super.b(jVar);
        }
        int ordinal = h.D(this.f6428b).ordinal();
        return o.e(1, (long) (ordinal != 1 ? (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31 : 28), (long) h.D(this.f6428b).B());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(i iVar) {
        i iVar2 = iVar;
        int i = this.f6428b - iVar2.f6428b;
        return i == 0 ? this.f6429c - iVar2.f6429c : i;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        return b(jVar).a(n(jVar), jVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f6428b == iVar.f6428b && this.f6429c == iVar.f6429c;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        return lVar == k.f6657b ? (R) m.f6476d : (R) super.f(lVar);
    }

    public int hashCode() {
        return (this.f6428b << 6) + this.f6429c;
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof a ? jVar == a.MONTH_OF_YEAR || jVar == a.DAY_OF_MONTH : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        int i;
        if (!(jVar instanceof a)) {
            return jVar.k(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 18) {
            i = this.f6429c;
        } else if (ordinal == 23) {
            i = this.f6428b;
        } else {
            throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }
        return (long) i;
    }

    @Override // g.b.a.w.f
    public g.b.a.w.d t(g.b.a.w.d dVar) {
        if (h.p(dVar).equals(m.f6476d)) {
            g.b.a.w.d r = dVar.r(a.MONTH_OF_YEAR, (long) this.f6428b);
            a aVar = a.DAY_OF_MONTH;
            return r.r(aVar, Math.min(r.b(aVar).f6666e, (long) this.f6429c));
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.f6428b < 10 ? "0" : "");
        sb.append(this.f6428b);
        sb.append(this.f6429c < 10 ? "-0" : "-");
        sb.append(this.f6429c);
        return sb.toString();
    }
}
