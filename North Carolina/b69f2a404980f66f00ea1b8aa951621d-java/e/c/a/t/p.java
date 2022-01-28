package e.c.a.t;

import e.c.a.a;
import e.c.a.e;
import e.c.a.g;
import e.c.a.l;
import e.c.a.w.d;
import e.c.a.w.f;
import e.c.a.w.i;
import e.c.a.w.j;
import e.c.a.w.m;
import e.c.a.w.n;
import e.c.a.w.o;
import java.io.DataInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;

public final class p extends a<p> implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final e f5033e = e.P(1873, 1, 1);

    /* renamed from: b  reason: collision with root package name */
    public final e f5034b;

    /* renamed from: c  reason: collision with root package name */
    public transient q f5035c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f5036d;

    public p(e eVar) {
        if (!eVar.K(f5033e)) {
            q t = q.t(eVar);
            this.f5035c = t;
            this.f5036d = eVar.f4970b - (t.f5039c.f4970b - 1);
            this.f5034b = eVar;
            return;
        }
        throw new a("Minimum supported date is January 1st Meiji 6");
    }

    public static b I(DataInput dataInput) {
        int readInt = dataInput.readInt();
        byte readByte = dataInput.readByte();
        byte readByte2 = dataInput.readByte();
        if (o.f5032e != null) {
            return new p(e.P(readInt, readByte, readByte2));
        }
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        q t = q.t(this.f5034b);
        this.f5035c = t;
        this.f5036d = this.f5034b.f4970b - (t.f5039c.f4970b - 1);
    }

    private Object writeReplace() {
        return new u((byte) 1, this);
    }

    @Override // e.c.a.t.b
    public b A(f fVar) {
        return (p) o.f5032e.g(fVar.p(this));
    }

    /* Return type fixed from 'e.c.a.t.a' to match base method */
    @Override // e.c.a.t.a
    public a<p> C(long j, m mVar) {
        return (p) super.x(j, mVar);
    }

    /* Return type fixed from 'e.c.a.t.a' to match base method */
    @Override // e.c.a.t.a
    public a<p> D(long j) {
        return J(this.f5034b.V(j));
    }

    /* Return type fixed from 'e.c.a.t.a' to match base method */
    @Override // e.c.a.t.a
    public a<p> E(long j) {
        return J(this.f5034b.W(j));
    }

    /* Return type fixed from 'e.c.a.t.a' to match base method */
    @Override // e.c.a.t.a
    public a<p> F(long j) {
        return J(this.f5034b.Y(j));
    }

    public final o G(int i) {
        Calendar instance = Calendar.getInstance(o.f5031d);
        instance.set(0, this.f5035c.f5038b + 2);
        int i2 = this.f5036d;
        e eVar = this.f5034b;
        instance.set(i2, eVar.f4971c - 1, eVar.f4972d);
        return o.d((long) instance.getActualMinimum(i), (long) instance.getActualMaximum(i));
    }

    public final long H() {
        return (long) (this.f5036d == 1 ? (this.f5034b.I() - this.f5035c.f5039c.I()) + 1 : this.f5034b.I());
    }

    public final p J(e eVar) {
        return eVar.equals(this.f5034b) ? this : new p(eVar);
    }

    /* renamed from: K */
    public p n(j jVar, long j) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return (p) jVar.f(this, j);
        }
        e.c.a.w.a aVar = (e.c.a.w.a) jVar;
        if (l(aVar) == j) {
            return this;
        }
        int ordinal = aVar.ordinal();
        if (ordinal == 19 || ordinal == 25 || ordinal == 27) {
            int a2 = o.f5032e.x(aVar).a(j, aVar);
            int ordinal2 = aVar.ordinal();
            if (ordinal2 == 19) {
                return J(this.f5034b.V(((long) a2) - H()));
            }
            if (ordinal2 == 25) {
                return L(this.f5035c, a2);
            }
            if (ordinal2 == 27) {
                return L(q.u(a2), this.f5036d);
            }
        }
        return J(this.f5034b.n(jVar, j));
    }

    public final p L(q qVar, int i) {
        if (o.f5032e == null) {
            throw null;
        } else if (qVar instanceof q) {
            o.d(1, (long) ((qVar.s().f4970b - qVar.f5039c.f4970b) + 1)).b((long) i, e.c.a.w.a.YEAR_OF_ERA);
            return J(this.f5034b.d0((qVar.f5039c.f4970b + i) - 1));
        } else {
            throw new ClassCastException("Era must be JapaneseEra");
        }
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        int i;
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.n(this);
        }
        if (i(jVar)) {
            e.c.a.w.a aVar = (e.c.a.w.a) jVar;
            int ordinal = aVar.ordinal();
            if (ordinal == 19) {
                i = 6;
            } else if (ordinal != 25) {
                return o.f5032e.x(aVar);
            } else {
                i = 1;
            }
            return G(i);
        }
        throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.t.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return this.f5034b.equals(((p) obj).f5034b);
        }
        return false;
    }

    @Override // e.c.a.w.d, e.c.a.t.b
    public d g(f fVar) {
        return (p) o.f5032e.g(((e) fVar).p(this));
    }

    @Override // e.c.a.t.b
    public int hashCode() {
        if (o.f5032e != null) {
            return -688086063 ^ this.f5034b.hashCode();
        }
        throw null;
    }

    @Override // e.c.a.w.e, e.c.a.t.b
    public boolean i(j jVar) {
        if (jVar == e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || jVar == e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || jVar == e.c.a.w.a.ALIGNED_WEEK_OF_MONTH || jVar == e.c.a.w.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.i(jVar);
    }

    @Override // e.c.a.v.b, e.c.a.w.d, e.c.a.t.b
    public d k(long j, m mVar) {
        return (p) super.k(j, mVar);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.i(this);
        }
        int ordinal = ((e.c.a.w.a) jVar).ordinal();
        if (!(ordinal == 16 || ordinal == 17)) {
            if (ordinal == 19) {
                return H();
            }
            if (ordinal == 25) {
                return (long) this.f5036d;
            }
            if (ordinal == 27) {
                return (long) this.f5035c.f5038b;
            }
            if (!(ordinal == 21 || ordinal == 22)) {
                return this.f5034b.l(jVar);
            }
        }
        throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.d, e.c.a.t.b, e.c.a.t.a
    public d o(long j, m mVar) {
        return (p) super.x(j, mVar);
    }

    @Override // e.c.a.t.b, e.c.a.t.a
    public final c<p> s(g gVar) {
        return new d(this, gVar);
    }

    @Override // e.c.a.t.b
    public h u() {
        return o.f5032e;
    }

    @Override // e.c.a.t.b
    public i v() {
        return this.f5035c;
    }

    @Override // e.c.a.t.b
    public b w(long j, m mVar) {
        return (p) super.k(j, mVar);
    }

    @Override // e.c.a.t.b, e.c.a.t.a
    public b x(long j, m mVar) {
        return (p) super.x(j, mVar);
    }

    @Override // e.c.a.t.b
    public b y(i iVar) {
        return (p) o.f5032e.g(((l) iVar).a(this));
    }

    @Override // e.c.a.t.b
    public long z() {
        return this.f5034b.z();
    }
}
