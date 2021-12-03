package l.b.a.u;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import l.b.a.b;
import l.b.a.f;
import l.b.a.h;
import l.b.a.x.a;
import l.b.a.x.d;
import l.b.a.x.i;
import l.b.a.x.j;
import l.b.a.x.m;
import l.b.a.x.n;
import l.b.a.x.o;

public final class p extends a<p> implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final f f4415e = f.P(1873, 1, 1);
    public final f b;
    public transient q c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f4416d;

    public p(f fVar) {
        if (!fVar.J(f4415e)) {
            q r = q.r(fVar);
            this.c = r;
            this.f4416d = fVar.b - (r.c.b - 1);
            this.b = fVar;
            return;
        }
        throw new b("Minimum supported date is January 1st Meiji 6");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        q r = q.r(this.b);
        this.c = r;
        this.f4416d = this.b.b - (r.c.b - 1);
    }

    private Object writeReplace() {
        return new u((byte) 1, this);
    }

    /* Return type fixed from 'l.b.a.u.a' to match base method */
    @Override // l.b.a.u.a
    public a<p> A(long j2, m mVar) {
        return (p) super.v(j2, mVar);
    }

    /* Return type fixed from 'l.b.a.u.a' to match base method */
    @Override // l.b.a.u.a
    public a<p> B(long j2) {
        return G(this.b.V(j2));
    }

    /* Return type fixed from 'l.b.a.u.a' to match base method */
    @Override // l.b.a.u.a
    public a<p> C(long j2) {
        return G(this.b.W(j2));
    }

    /* Return type fixed from 'l.b.a.u.a' to match base method */
    @Override // l.b.a.u.a
    public a<p> D(long j2) {
        return G(this.b.Y(j2));
    }

    public final o E(int i2) {
        Calendar instance = Calendar.getInstance(o.f4410d);
        instance.set(0, this.c.b + 2);
        int i3 = this.f4416d;
        f fVar = this.b;
        instance.set(i3, fVar.c - 1, fVar.f4360d);
        return o.d((long) instance.getActualMinimum(i2), (long) instance.getActualMaximum(i2));
    }

    public final long F() {
        return (long) (this.f4416d == 1 ? (this.b.H() - this.c.c.H()) + 1 : this.b.H());
    }

    public final p G(f fVar) {
        return fVar.equals(this.b) ? this : new p(fVar);
    }

    /* renamed from: H */
    public p z(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (p) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        if (i(aVar) == j2) {
            return this;
        }
        int ordinal = aVar.ordinal();
        if (ordinal == 19 || ordinal == 25 || ordinal == 27) {
            int a = o.f4411e.u(aVar).a(j2, aVar);
            int ordinal2 = aVar.ordinal();
            if (ordinal2 == 19) {
                return G(this.b.V(((long) a) - F()));
            }
            if (ordinal2 == 25) {
                return I(this.c, a);
            }
            if (ordinal2 == 27) {
                return I(q.s(a), this.f4416d);
            }
        }
        return G(this.b.z(jVar, j2));
    }

    public final p I(q qVar, int i2) {
        Objects.requireNonNull(o.f4411e);
        if (qVar instanceof q) {
            o.d(1, (long) ((qVar.q().b - qVar.c.b) + 1)).b((long) i2, a.YEAR_OF_ERA);
            return G(this.b.c0((qVar.c.b + i2) - 1));
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public o a(j jVar) {
        int i2;
        if (!(jVar instanceof a)) {
            return jVar.l(this);
        }
        if (f(jVar)) {
            a aVar = (a) jVar;
            int ordinal = aVar.ordinal();
            if (ordinal == 19) {
                i2 = 6;
            } else if (ordinal != 25) {
                return o.f4411e.u(aVar);
            } else {
                i2 = 1;
            }
            return E(i2);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.d, l.b.a.u.b
    public d e(l.b.a.x.f fVar) {
        return (p) o.f4411e.e(fVar.n(this));
    }

    @Override // l.b.a.u.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return this.b.equals(((p) obj).b);
        }
        return false;
    }

    @Override // l.b.a.x.e, l.b.a.u.b
    public boolean f(j jVar) {
        if (jVar == a.ALIGNED_DAY_OF_WEEK_IN_MONTH || jVar == a.ALIGNED_DAY_OF_WEEK_IN_YEAR || jVar == a.ALIGNED_WEEK_OF_MONTH || jVar == a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.f(jVar);
    }

    @Override // l.b.a.w.b, l.b.a.x.d, l.b.a.u.b
    public d h(long j2, m mVar) {
        return (p) super.h(j2, mVar);
    }

    @Override // l.b.a.u.b
    public int hashCode() {
        Objects.requireNonNull(o.f4411e);
        return -688086063 ^ this.b.hashCode();
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (!(ordinal == 16 || ordinal == 17)) {
            if (ordinal == 19) {
                return F();
            }
            if (ordinal == 25) {
                return (long) this.f4416d;
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

    @Override // l.b.a.x.d, l.b.a.u.a, l.b.a.u.b
    public d m(long j2, m mVar) {
        return (p) super.v(j2, mVar);
    }

    @Override // l.b.a.u.a, l.b.a.u.b
    public final c<p> q(h hVar) {
        return new d(this, hVar);
    }

    @Override // l.b.a.u.b
    public h s() {
        return o.f4411e;
    }

    @Override // l.b.a.u.b
    public i t() {
        return this.c;
    }

    @Override // l.b.a.u.b
    public b u(long j2, m mVar) {
        return (p) super.h(j2, mVar);
    }

    @Override // l.b.a.u.a, l.b.a.u.b
    public b v(long j2, m mVar) {
        return (p) super.v(j2, mVar);
    }

    @Override // l.b.a.u.b
    public b w(i iVar) {
        return (p) o.f4411e.e(((l.b.a.m) iVar).b(this));
    }

    @Override // l.b.a.u.b
    public long x() {
        return this.b.x();
    }

    @Override // l.b.a.u.b
    public b y(l.b.a.x.f fVar) {
        return (p) o.f4411e.e(fVar.n(this));
    }
}
