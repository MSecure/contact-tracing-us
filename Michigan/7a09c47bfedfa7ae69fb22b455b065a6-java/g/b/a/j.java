package g.b.a;

import b.x.t;
import c.a.a.a.a;
import g.b.a.v.b;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.m;
import g.b.a.w.o;
import g.b.a.x.f;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class j extends b implements d, f, Comparable<j>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final f f6430b;

    /* renamed from: c  reason: collision with root package name */
    public final q f6431c;

    static {
        f fVar = f.f6412d;
        q qVar = q.i;
        if (fVar != null) {
            new j(fVar, qVar);
            f fVar2 = f.f6413e;
            q qVar2 = q.h;
            if (fVar2 != null) {
                new j(fVar2, qVar2);
                return;
            }
            throw null;
        }
        throw null;
    }

    public j(f fVar, q qVar) {
        t.y2(fVar, "dateTime");
        this.f6430b = fVar;
        t.y2(qVar, "offset");
        this.f6431c = qVar;
    }

    public static j A(e eVar) {
        if (eVar instanceof j) {
            return (j) eVar;
        }
        try {
            q L = q.L(eVar);
            try {
                return new j(f.U(eVar), L);
            } catch (a unused) {
                return D(d.B(eVar), L);
            }
        } catch (a unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain OffsetDateTime from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(a.e(eVar, sb));
        }
    }

    public static j D(d dVar, p pVar) {
        t.y2(dVar, "instant");
        t.y2(pVar, "zone");
        q qVar = ((f.a) pVar.B()).f6706b;
        return new j(f.Z(dVar.f6404b, dVar.f6405c, qVar), qVar);
    }

    public static j G(DataInput dataInput) {
        return new j(f.f0(dataInput), q.T(dataInput));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 69, this);
    }

    public int B() {
        return this.f6430b.f6415c.f6421e;
    }

    /* renamed from: F */
    public j s(long j, m mVar) {
        return mVar instanceof g.b.a.w.b ? L(this.f6430b.s(j, mVar), this.f6431c) : (j) mVar.f(this, j);
    }

    public long H() {
        return this.f6430b.H(this.f6431c);
    }

    public final j L(f fVar, q qVar) {
        return (this.f6430b != fVar || !this.f6431c.equals(qVar)) ? new j(fVar, qVar) : this;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(g.b.a.w.j jVar) {
        return jVar instanceof g.b.a.w.a ? (jVar == g.b.a.w.a.INSTANT_SECONDS || jVar == g.b.a.w.a.OFFSET_SECONDS) ? jVar.m() : this.f6430b.b(jVar) : jVar.p(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(j jVar) {
        f fVar;
        f fVar2;
        j jVar2 = jVar;
        if (this.f6431c.equals(jVar2.f6431c)) {
            fVar2 = this.f6430b;
            fVar = jVar2.f6430b;
        } else {
            int L = t.L(H(), jVar2.H());
            if (L != 0) {
                return L;
            }
            fVar2 = this.f6430b;
            int i = fVar2.f6415c.f6421e;
            fVar = jVar2.f6430b;
            int i2 = i - fVar.f6415c.f6421e;
            if (i2 != 0) {
                return i2;
            }
        }
        return fVar2.compareTo(fVar);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(g.b.a.w.j jVar) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return super.d(jVar);
        }
        int ordinal = ((g.b.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            throw new a(a.d("Field too large for an int: ", jVar));
        } else if (ordinal != 29) {
            return this.f6430b.d(jVar);
        } else {
            return this.f6431c.f6447c;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f6430b.equals(jVar.f6430b) && this.f6431c.equals(jVar.f6431c);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6657b) {
            return (R) g.b.a.t.m.f6476d;
        }
        if (lVar == k.f6658c) {
            return (R) g.b.a.w.b.NANOS;
        }
        if (lVar == k.f6660e || lVar == k.f6659d) {
            return (R) this.f6431c;
        }
        if (lVar == k.f6661f) {
            return (R) this.f6430b.f6414b;
        }
        if (lVar == k.f6662g) {
            return (R) this.f6430b.f6415c;
        }
        if (lVar == k.f6656a) {
            return null;
        }
        return (R) super.f(lVar);
    }

    public int hashCode() {
        return this.f6430b.hashCode() ^ this.f6431c.f6447c;
    }

    @Override // g.b.a.w.d
    public d i(g.b.a.w.f fVar) {
        return L(this.f6430b.i(fVar), this.f6431c);
    }

    @Override // g.b.a.w.e
    public boolean k(g.b.a.w.j jVar) {
        return (jVar instanceof g.b.a.w.a) || (jVar != null && jVar.d(this));
    }

    @Override // g.b.a.w.d, g.b.a.v.b
    public d m(long j, m mVar) {
        return j == Long.MIN_VALUE ? s(Long.MAX_VALUE, mVar).s(1, mVar) : s(-j, mVar);
    }

    @Override // g.b.a.w.e
    public long n(g.b.a.w.j jVar) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        int ordinal = ((g.b.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            return H();
        }
        if (ordinal != 29) {
            return this.f6430b.n(jVar);
        }
        return (long) this.f6431c.f6447c;
    }

    @Override // g.b.a.w.d
    public d r(g.b.a.w.j jVar, long j) {
        q qVar;
        f fVar;
        if (!(jVar instanceof g.b.a.w.a)) {
            return (j) jVar.f(this, j);
        }
        g.b.a.w.a aVar = (g.b.a.w.a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return D(d.G(j, (long) B()), this.f6431c);
        }
        if (ordinal != 29) {
            fVar = this.f6430b.r(jVar, j);
            qVar = this.f6431c;
        } else {
            fVar = this.f6430b;
            qVar = q.R(aVar.f6633c.a(j, aVar));
        }
        return L(fVar, qVar);
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(g.b.a.w.a.EPOCH_DAY, this.f6430b.f6414b.P()).r(g.b.a.w.a.NANO_OF_DAY, this.f6430b.f6415c.Y()).r(g.b.a.w.a.OFFSET_SECONDS, (long) this.f6431c.f6447c);
    }

    public String toString() {
        return this.f6430b.toString() + this.f6431c.f6448d;
    }

    @Override // g.b.a.w.d
    public long y(d dVar, m mVar) {
        j A = A(dVar);
        if (!(mVar instanceof g.b.a.w.b)) {
            return mVar.d(this, A);
        }
        q qVar = this.f6431c;
        if (!qVar.equals(A.f6431c)) {
            A = new j(A.f6430b.d0((long) (qVar.f6447c - A.f6431c.f6447c)), qVar);
        }
        return this.f6430b.y(A.f6430b, mVar);
    }
}
