package l.b.a.t;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import l.b.a.a;
import l.b.a.e;
import l.b.a.g;
import l.b.a.l;
import l.b.a.w.d;
import l.b.a.w.f;
import l.b.a.w.i;
import l.b.a.w.j;
import l.b.a.w.m;
import l.b.a.w.n;
import l.b.a.w.o;

public final class p extends a<p> implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final e f4195e = e.P(1873, 1, 1);
    public final e b;
    public transient q c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f4196d;

    public p(e eVar) {
        if (!eVar.J(f4195e)) {
            q r = q.r(eVar);
            this.c = r;
            this.f4196d = eVar.b - (r.c.b - 1);
            this.b = eVar;
            return;
        }
        throw new a("Minimum supported date is January 1st Meiji 6");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        q r = q.r(this.b);
        this.c = r;
        this.f4196d = this.b.b - (r.c.b - 1);
    }

    private Object writeReplace() {
        return new u((byte) 1, this);
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<p> A(long j2, m mVar) {
        return (p) super.v(j2, mVar);
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<p> B(long j2) {
        return G(this.b.V(j2));
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<p> C(long j2) {
        return G(this.b.W(j2));
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<p> D(long j2) {
        return G(this.b.Y(j2));
    }

    public final o E(int i2) {
        Calendar instance = Calendar.getInstance(o.f4190d);
        instance.set(0, this.c.b + 2);
        int i3 = this.f4196d;
        e eVar = this.b;
        instance.set(i3, eVar.c - 1, eVar.f4140d);
        return o.d((long) instance.getActualMinimum(i2), (long) instance.getActualMaximum(i2));
    }

    public final long F() {
        return (long) (this.f4196d == 1 ? (this.b.H() - this.c.c.H()) + 1 : this.b.H());
    }

    public final p G(e eVar) {
        return eVar.equals(this.b) ? this : new p(eVar);
    }

    /* renamed from: H */
    public p z(j jVar, long j2) {
        if (!(jVar instanceof l.b.a.w.a)) {
            return (p) jVar.c(this, j2);
        }
        l.b.a.w.a aVar = (l.b.a.w.a) jVar;
        if (i(aVar) == j2) {
            return this;
        }
        int ordinal = aVar.ordinal();
        if (ordinal == 19 || ordinal == 25 || ordinal == 27) {
            int a = o.f4191e.u(aVar).a(j2, aVar);
            int ordinal2 = aVar.ordinal();
            if (ordinal2 == 19) {
                return G(this.b.V(((long) a) - F()));
            }
            if (ordinal2 == 25) {
                return I(this.c, a);
            }
            if (ordinal2 == 27) {
                return I(q.s(a), this.f4196d);
            }
        }
        return G(this.b.z(jVar, j2));
    }

    public final p I(q qVar, int i2) {
        Objects.requireNonNull(o.f4191e);
        if (qVar instanceof q) {
            o.d(1, (long) ((qVar.q().b - qVar.c.b) + 1)).b((long) i2, l.b.a.w.a.YEAR_OF_ERA);
            return G(this.b.c0((qVar.c.b + i2) - 1));
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        int i2;
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.l(this);
        }
        if (f(jVar)) {
            l.b.a.w.a aVar = (l.b.a.w.a) jVar;
            int ordinal = aVar.ordinal();
            if (ordinal == 19) {
                i2 = 6;
            } else if (ordinal != 25) {
                return o.f4191e.u(aVar);
            } else {
                i2 = 1;
            }
            return E(i2);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.d, l.b.a.t.b
    public d e(f fVar) {
        return (p) o.f4191e.e(fVar.n(this));
    }

    @Override // l.b.a.t.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return this.b.equals(((p) obj).b);
        }
        return false;
    }

    @Override // l.b.a.w.e, l.b.a.t.b
    public boolean f(j jVar) {
        if (jVar == l.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || jVar == l.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || jVar == l.b.a.w.a.ALIGNED_WEEK_OF_MONTH || jVar == l.b.a.w.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.f(jVar);
    }

    @Override // l.b.a.w.d, l.b.a.t.b, l.b.a.v.b
    public d h(long j2, m mVar) {
        return (p) super.h(j2, mVar);
    }

    @Override // l.b.a.t.b
    public int hashCode() {
        Objects.requireNonNull(o.f4191e);
        return -688086063 ^ this.b.hashCode();
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.f(this);
        }
        int ordinal = ((l.b.a.w.a) jVar).ordinal();
        if (!(ordinal == 16 || ordinal == 17)) {
            if (ordinal == 19) {
                return F();
            }
            if (ordinal == 25) {
                return (long) this.f4196d;
            }
            if (ordinal == 27) {
                return (long) this.c.b;
            }
            if (!(ordinal == 21 || ordinal == 22)) {
                return this.b.i(jVar);
            }
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.d, l.b.a.t.a, l.b.a.t.b
    public d m(long j2, m mVar) {
        return (p) super.v(j2, mVar);
    }

    @Override // l.b.a.t.a, l.b.a.t.b
    public final c<p> q(g gVar) {
        return new d(this, gVar);
    }

    @Override // l.b.a.t.b
    public h s() {
        return o.f4191e;
    }

    @Override // l.b.a.t.b
    public i t() {
        return this.c;
    }

    @Override // l.b.a.t.b
    public b u(long j2, m mVar) {
        return (p) super.h(j2, mVar);
    }

    @Override // l.b.a.t.a, l.b.a.t.b
    public b v(long j2, m mVar) {
        return (p) super.v(j2, mVar);
    }

    @Override // l.b.a.t.b
    public b w(i iVar) {
        return (p) o.f4191e.e(((l) iVar).b(this));
    }

    @Override // l.b.a.t.b
    public long x() {
        return this.b.x();
    }

    @Override // l.b.a.t.b
    public b y(f fVar) {
        return (p) o.f4191e.e(fVar.n(this));
    }
}
