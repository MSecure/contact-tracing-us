package l.b.a;

import f.a.a.a.a;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Objects;
import l.b.a.t.m;
import l.b.a.v.b;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.o;
import l.b.a.x.f;

public final class j extends b implements d, f, Comparable<j>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f4063d = 0;
    public final f b;
    public final q c;

    static {
        f fVar = f.f4045d;
        q qVar = q.f4072i;
        Objects.requireNonNull(fVar);
        new j(fVar, qVar);
        f fVar2 = f.f4046e;
        q qVar2 = q.f4071h;
        Objects.requireNonNull(fVar2);
        new j(fVar2, qVar2);
    }

    public j(f fVar, q qVar) {
        f.b.a.c.b.o.b.B1(fVar, "dateTime");
        this.b = fVar;
        f.b.a.c.b.o.b.B1(qVar, "offset");
        this.c = qVar;
    }

    public static j q(e eVar) {
        if (eVar instanceof j) {
            return (j) eVar;
        }
        try {
            q w = q.w(eVar);
            try {
                return new j(f.C(eVar), w);
            } catch (a unused) {
                return s(d.s(eVar), w);
            }
        } catch (a unused2) {
            throw new a(a.f(eVar, a.k("Unable to obtain OffsetDateTime from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static j s(d dVar, p pVar) {
        f.b.a.c.b.o.b.B1(dVar, "instant");
        f.b.a.c.b.o.b.B1(pVar, "zone");
        q qVar = ((f.a) pVar.s()).b;
        return new j(f.G(dVar.b, dVar.c, qVar), qVar);
    }

    private Object writeReplace() {
        return new m((byte) 69, this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(l.b.a.w.j jVar) {
        return jVar instanceof l.b.a.w.a ? (jVar == l.b.a.w.a.INSTANT_SECONDS || jVar == l.b.a.w.a.OFFSET_SECONDS) ? jVar.h() : this.b.a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(l.b.a.w.j jVar) {
        if (!(jVar instanceof l.b.a.w.a)) {
            return super.b(jVar);
        }
        int ordinal = ((l.b.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            throw new a(a.d("Field too large for an int: ", jVar));
        } else if (ordinal != 29) {
            return this.b.b(jVar);
        } else {
            return this.c.c;
        }
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) m.f4092d;
        }
        if (lVar == k.c) {
            return (R) l.b.a.w.b.NANOS;
        }
        if (lVar == k.f4207e || lVar == k.f4206d) {
            return (R) this.c;
        }
        if (lVar == k.f4208f) {
            return (R) this.b.b;
        }
        if (lVar == k.f4209g) {
            return (R) this.b.c;
        }
        if (lVar == k.a) {
            return null;
        }
        return (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(j jVar) {
        f fVar;
        f fVar2;
        j jVar2 = jVar;
        if (this.c.equals(jVar2.c)) {
            fVar2 = this.b;
            fVar = jVar2.b;
        } else {
            int L = f.b.a.c.b.o.b.L(u(), jVar2.u());
            if (L != 0) {
                return L;
            }
            fVar2 = this.b;
            int i2 = fVar2.c.f4052e;
            fVar = jVar2.b;
            int i3 = i2 - fVar.c.f4052e;
            if (i3 != 0) {
                return i3;
            }
        }
        return fVar2.compareTo(fVar);
    }

    @Override // l.b.a.w.d
    public d e(l.b.a.w.f fVar) {
        if ((fVar instanceof e) || (fVar instanceof g) || (fVar instanceof f)) {
            return v(this.b.z(fVar), this.c);
        }
        if (fVar instanceof d) {
            return s((d) fVar, this.c);
        }
        if (fVar instanceof q) {
            return v(this.b, (q) fVar);
        }
        boolean z = fVar instanceof j;
        d dVar = fVar;
        if (!z) {
            dVar = fVar.n(this);
        }
        return (j) dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.b.equals(jVar.b) && this.c.equals(jVar.c);
    }

    @Override // l.b.a.w.e
    public boolean f(l.b.a.w.j jVar) {
        return (jVar instanceof l.b.a.w.a) || (jVar != null && jVar.b(this));
    }

    @Override // l.b.a.w.d, l.b.a.v.b
    public d h(long j2, l.b.a.w.m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public int hashCode() {
        return this.b.hashCode() ^ this.c.c;
    }

    @Override // l.b.a.w.e
    public long i(l.b.a.w.j jVar) {
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.f(this);
        }
        int ordinal = ((l.b.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            return u();
        }
        if (ordinal != 29) {
            return this.b.i(jVar);
        }
        return (long) this.c.c;
    }

    @Override // l.b.a.w.d
    public d l(l.b.a.w.j jVar, long j2) {
        q qVar;
        f fVar;
        if (!(jVar instanceof l.b.a.w.a)) {
            return (j) jVar.c(this, j2);
        }
        l.b.a.w.a aVar = (l.b.a.w.a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return s(d.y(j2, (long) r()), this.c);
        }
        if (ordinal != 29) {
            fVar = this.b.l(jVar, j2);
            qVar = this.c;
        } else {
            fVar = this.b;
            qVar = q.z(aVar.f4190e.a(j2, aVar));
        }
        return v(fVar, qVar);
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(l.b.a.w.a.EPOCH_DAY, this.b.b.x()).l(l.b.a.w.a.NANO_OF_DAY, this.b.c.E()).l(l.b.a.w.a.OFFSET_SECONDS, (long) this.c.c);
    }

    @Override // l.b.a.w.d
    public long o(d dVar, l.b.a.w.m mVar) {
        j q = q(dVar);
        if (!(mVar instanceof l.b.a.w.b)) {
            return mVar.b(this, q);
        }
        q qVar = this.c;
        if (!qVar.equals(q.c)) {
            q = new j(q.b.K((long) (qVar.c - q.c.c)), qVar);
        }
        return this.b.o(q.b, mVar);
    }

    public int r() {
        return this.b.c.f4052e;
    }

    /* renamed from: t */
    public j m(long j2, l.b.a.w.m mVar) {
        return mVar instanceof l.b.a.w.b ? v(this.b.u(j2, mVar), this.c) : (j) mVar.c(this, j2);
    }

    public String toString() {
        return this.b.toString() + this.c.f4073d;
    }

    public long u() {
        return this.b.v(this.c);
    }

    public final j v(f fVar, q qVar) {
        return (this.b != fVar || !this.c.equals(qVar)) ? new j(fVar, qVar) : this;
    }
}
