package e.c.a;

import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.c.a.t.m;
import e.c.a.v.b;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.f;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.o;
import e.c.a.x.f;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class j extends b implements d, f, Comparable<j>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final f f4987b;

    /* renamed from: c  reason: collision with root package name */
    public final q f4988c;

    static {
        f fVar = f.f4973d;
        q qVar = q.h;
        if (fVar != null) {
            new j(fVar, qVar);
            f fVar2 = f.f4974e;
            q qVar2 = q.g;
            if (fVar2 != null) {
                new j(fVar2, qVar2);
                return;
            }
            throw null;
        }
        throw null;
    }

    public j(f fVar, q qVar) {
        c.T1(fVar, "dateTime");
        this.f4987b = fVar;
        c.T1(qVar, "offset");
        this.f4988c = qVar;
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static j s(e eVar) {
        if (eVar instanceof j) {
            return (j) eVar;
        }
        try {
            q z = q.z(eVar);
            try {
                return new j(f.E(eVar), z);
            } catch (a unused) {
                return u(d.t(eVar), z);
            }
        } catch (a unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain OffsetDateTime from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(a.d(eVar, sb));
        }
    }

    public static j u(d dVar, p pVar) {
        c.T1(dVar, "instant");
        c.T1(pVar, "zone");
        q qVar = ((f.a) pVar.v()).f5217b;
        return new j(f.J(dVar.f4967b, dVar.f4968c, qVar), qVar);
    }

    public static j w(DataInput dataInput) {
        return new j(f.P(dataInput), q.E(dataInput));
    }

    private Object writeReplace() {
        return new m((byte) 69, this);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(e.c.a.w.j jVar) {
        return jVar instanceof e.c.a.w.a ? (jVar == e.c.a.w.a.INSTANT_SECONDS || jVar == e.c.a.w.a.OFFSET_SECONDS) ? jVar.k() : this.f4987b.b(jVar) : jVar.n(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(j jVar) {
        f fVar;
        f fVar2;
        j jVar2 = jVar;
        if (this.f4988c.equals(jVar2.f4988c)) {
            fVar2 = this.f4987b;
            fVar = jVar2.f4987b;
        } else {
            int A = c.A(x(), jVar2.x());
            if (A != 0) {
                return A;
            }
            fVar2 = this.f4987b;
            int i = fVar2.f4976c.f4980e;
            fVar = jVar2.f4987b;
            int i2 = i - fVar.f4976c.f4980e;
            if (i2 != 0) {
                return i2;
            }
        }
        return fVar2.compareTo(fVar);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(e.c.a.w.j jVar) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return super.d(jVar);
        }
        int ordinal = ((e.c.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            throw new a(a.c("Field too large for an int: ", jVar));
        } else if (ordinal != 29) {
            return this.f4987b.d(jVar);
        } else {
            return this.f4988c.f5002b;
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
        return this.f4987b.equals(jVar.f4987b) && this.f4988c.equals(jVar.f4988c);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5178b) {
            return (R) m.f5027d;
        }
        if (lVar == k.f5179c) {
            return (R) e.c.a.w.b.NANOS;
        }
        if (lVar == k.f5181e || lVar == k.f5180d) {
            return (R) this.f4988c;
        }
        if (lVar == k.f) {
            return (R) this.f4987b.f4975b;
        }
        if (lVar == k.g) {
            return (R) this.f4987b.f4976c;
        }
        if (lVar == k.f5177a) {
            return null;
        }
        return (R) super.f(lVar);
    }

    @Override // e.c.a.w.d
    public d g(e.c.a.w.f fVar) {
        return y(this.f4987b.g(fVar), this.f4988c);
    }

    public int hashCode() {
        return this.f4987b.hashCode() ^ this.f4988c.f5002b;
    }

    @Override // e.c.a.w.e
    public boolean i(e.c.a.w.j jVar) {
        return (jVar instanceof e.c.a.w.a) || (jVar != null && jVar.d(this));
    }

    @Override // e.c.a.v.b, e.c.a.w.d
    public d k(long j, e.c.a.w.m mVar) {
        return j == Long.MIN_VALUE ? o(RecyclerView.FOREVER_NS, mVar).o(1, mVar) : o(-j, mVar);
    }

    @Override // e.c.a.w.e
    public long l(e.c.a.w.j jVar) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.i(this);
        }
        int ordinal = ((e.c.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            return x();
        }
        if (ordinal != 29) {
            return this.f4987b.l(jVar);
        }
        return (long) this.f4988c.f5002b;
    }

    @Override // e.c.a.w.d
    public d n(e.c.a.w.j jVar, long j) {
        q qVar;
        f fVar;
        if (!(jVar instanceof e.c.a.w.a)) {
            return (j) jVar.f(this, j);
        }
        e.c.a.w.a aVar = (e.c.a.w.a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return u(d.w(j, (long) t()), this.f4988c);
        }
        if (ordinal != 29) {
            fVar = this.f4987b.n(jVar, j);
            qVar = this.f4988c;
        } else {
            fVar = this.f4987b;
            qVar = q.C(aVar.f5158c.a(j, aVar));
        }
        return y(fVar, qVar);
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(e.c.a.w.a.EPOCH_DAY, this.f4987b.f4975b.z()).n(e.c.a.w.a.NANO_OF_DAY, this.f4987b.f4976c.I()).n(e.c.a.w.a.OFFSET_SECONDS, (long) this.f4988c.f5002b);
    }

    @Override // e.c.a.w.d
    public long q(d dVar, e.c.a.w.m mVar) {
        j s = s(dVar);
        if (!(mVar instanceof e.c.a.w.b)) {
            return mVar.d(this, s);
        }
        q qVar = this.f4988c;
        if (!qVar.equals(s.f4988c)) {
            s = new j(s.f4987b.N((long) (qVar.f5002b - s.f4988c.f5002b)), qVar);
        }
        return this.f4987b.q(s.f4987b, mVar);
    }

    public int t() {
        return this.f4987b.f4976c.f4980e;
    }

    public String toString() {
        return this.f4987b.toString() + this.f4988c.f5003c;
    }

    /* renamed from: v */
    public j o(long j, e.c.a.w.m mVar) {
        return mVar instanceof e.c.a.w.b ? y(this.f4987b.w(j, mVar), this.f4988c) : (j) mVar.f(this, j);
    }

    public long x() {
        return this.f4987b.x(this.f4988c);
    }

    public final j y(f fVar, q qVar) {
        return (this.f4987b != fVar || !this.f4988c.equals(qVar)) ? new j(fVar, qVar) : this;
    }
}
