package g.b.a.t;

import g.b.a.a;
import g.b.a.e;
import g.b.a.g;
import g.b.a.l;
import g.b.a.w.d;
import g.b.a.w.f;
import g.b.a.w.i;
import g.b.a.w.j;
import g.b.a.w.m;
import g.b.a.w.n;
import g.b.a.w.o;
import java.io.DataInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;

public final class p extends a<p> implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final e f6484e = e.f0(1873, 1, 1);

    /* renamed from: b  reason: collision with root package name */
    public final e f6485b;

    /* renamed from: c  reason: collision with root package name */
    public transient q f6486c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f6487d;

    public p(e eVar) {
        if (!eVar.a0(f6484e)) {
            q B = q.B(eVar);
            this.f6486c = B;
            this.f6487d = eVar.f6409b - (B.f6492c.f6409b - 1);
            this.f6485b = eVar;
            return;
        }
        throw new a("Minimum supported date is January 1st Meiji 6");
    }

    public static b Y(DataInput dataInput) {
        int readInt = dataInput.readInt();
        byte readByte = dataInput.readByte();
        byte readByte2 = dataInput.readByte();
        if (o.f6481e != null) {
            return new p(e.f0(readInt, readByte, readByte2));
        }
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        q B = q.B(this.f6485b);
        this.f6486c = B;
        this.f6487d = this.f6485b.f6409b - (B.f6492c.f6409b - 1);
    }

    private Object writeReplace() {
        return new u((byte) 1, this);
    }

    @Override // g.b.a.t.b, g.b.a.t.a
    public final c<p> A(g gVar) {
        return new d(this, gVar);
    }

    @Override // g.b.a.t.b
    public h D() {
        return o.f6481e;
    }

    @Override // g.b.a.t.b
    public i F() {
        return this.f6486c;
    }

    @Override // g.b.a.t.b
    public b G(long j, m mVar) {
        return (p) super.m(j, mVar);
    }

    @Override // g.b.a.t.b, g.b.a.t.a
    public b H(long j, m mVar) {
        return (p) super.s(j, mVar);
    }

    @Override // g.b.a.t.b
    public b L(i iVar) {
        return (p) o.f6481e.i(((l) iVar).a(this));
    }

    @Override // g.b.a.t.b
    public long P() {
        return this.f6485b.P();
    }

    @Override // g.b.a.t.b
    public b Q(f fVar) {
        return (p) o.f6481e.i(fVar.t(this));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<p> S(long j, m mVar) {
        return (p) super.s(j, mVar);
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<p> T(long j) {
        return Z(this.f6485b.l0(j));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<p> U(long j) {
        return Z(this.f6485b.m0(j));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<p> V(long j) {
        return Z(this.f6485b.o0(j));
    }

    public final o W(int i) {
        Calendar instance = Calendar.getInstance(o.f6480d);
        instance.set(0, this.f6486c.f6491b + 2);
        int i2 = this.f6487d;
        e eVar = this.f6485b;
        instance.set(i2, eVar.f6410c - 1, eVar.f6411d);
        return o.d((long) instance.getActualMinimum(i), (long) instance.getActualMaximum(i));
    }

    public final long X() {
        return (long) (this.f6487d == 1 ? (this.f6485b.Y() - this.f6486c.f6492c.Y()) + 1 : this.f6485b.Y());
    }

    public final p Z(e eVar) {
        return eVar.equals(this.f6485b) ? this : new p(eVar);
    }

    /* renamed from: a0 */
    public p r(j jVar, long j) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return (p) jVar.f(this, j);
        }
        g.b.a.w.a aVar = (g.b.a.w.a) jVar;
        if (n(aVar) == j) {
            return this;
        }
        int ordinal = aVar.ordinal();
        if (ordinal == 19 || ordinal == 25 || ordinal == 27) {
            int a2 = o.f6481e.F(aVar).a(j, aVar);
            int ordinal2 = aVar.ordinal();
            if (ordinal2 == 19) {
                return Z(this.f6485b.l0(((long) a2) - X()));
            }
            if (ordinal2 == 25) {
                return b0(this.f6486c, a2);
            }
            if (ordinal2 == 27) {
                return b0(q.D(a2), this.f6487d);
            }
        }
        return Z(this.f6485b.r(jVar, j));
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        int i;
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.p(this);
        }
        if (k(jVar)) {
            g.b.a.w.a aVar = (g.b.a.w.a) jVar;
            int ordinal = aVar.ordinal();
            if (ordinal == 19) {
                i = 6;
            } else if (ordinal != 25) {
                return o.f6481e.F(aVar);
            } else {
                i = 1;
            }
            return W(i);
        }
        throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    public final p b0(q qVar, int i) {
        if (o.f6481e == null) {
            throw null;
        } else if (qVar instanceof q) {
            o.d(1, (long) ((qVar.A().f6409b - qVar.f6492c.f6409b) + 1)).b((long) i, g.b.a.w.a.YEAR_OF_ERA);
            return Z(this.f6485b.t0((qVar.f6492c.f6409b + i) - 1));
        } else {
            throw new ClassCastException("Era must be JapaneseEra");
        }
    }

    @Override // g.b.a.t.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return this.f6485b.equals(((p) obj).f6485b);
        }
        return false;
    }

    @Override // g.b.a.t.b
    public int hashCode() {
        if (o.f6481e != null) {
            return -688086063 ^ this.f6485b.hashCode();
        }
        throw null;
    }

    @Override // g.b.a.w.d, g.b.a.t.b
    public d i(f fVar) {
        return (p) o.f6481e.i(((e) fVar).t(this));
    }

    @Override // g.b.a.w.e, g.b.a.t.b
    public boolean k(j jVar) {
        if (jVar == g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || jVar == g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || jVar == g.b.a.w.a.ALIGNED_WEEK_OF_MONTH || jVar == g.b.a.w.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.k(jVar);
    }

    @Override // g.b.a.w.d, g.b.a.t.b, g.b.a.v.b
    public d m(long j, m mVar) {
        return (p) super.m(j, mVar);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        int ordinal = ((g.b.a.w.a) jVar).ordinal();
        if (!(ordinal == 16 || ordinal == 17)) {
            if (ordinal == 19) {
                return X();
            }
            if (ordinal == 25) {
                return (long) this.f6487d;
            }
            if (ordinal == 27) {
                return (long) this.f6486c.f6491b;
            }
            if (!(ordinal == 21 || ordinal == 22)) {
                return this.f6485b.n(jVar);
            }
        }
        throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.d, g.b.a.t.b, g.b.a.t.a
    public d s(long j, m mVar) {
        return (p) super.s(j, mVar);
    }
}
