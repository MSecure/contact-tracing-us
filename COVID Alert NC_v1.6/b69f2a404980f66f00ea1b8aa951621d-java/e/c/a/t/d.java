package e.c.a.t;

import c.b.a.a.c.n.c;
import com.google.android.gms.nearby.messages.Strategy;
import e.c.a.g;
import e.c.a.p;
import e.c.a.t.b;
import e.c.a.w.a;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.m;
import e.c.a.w.o;
import java.io.Serializable;

public final class d<D extends b> extends c<D> implements e.c.a.w.d, f, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final D f5011b;

    /* renamed from: c  reason: collision with root package name */
    public final g f5012c;

    public d(D d2, g gVar) {
        c.T1(d2, "date");
        c.T1(gVar, "time");
        this.f5011b = d2;
        this.f5012c = gVar;
    }

    private Object writeReplace() {
        return new u((byte) 12, this);
    }

    @Override // e.c.a.t.c
    public g A() {
        return this.f5012c;
    }

    /* renamed from: D */
    public d<D> w(long j, m mVar) {
        if (!(mVar instanceof e.c.a.w.b)) {
            return this.f5011b.u().i(mVar.f(this, j));
        }
        switch (((e.c.a.w.b) mVar).ordinal()) {
            case 0:
                return F(j);
            case 1:
                return E(j / 86400000000L).F((j % 86400000000L) * 1000);
            case 2:
                return E(j / 86400000).F((j % 86400000) * 1000000);
            case 3:
                return G(this.f5011b, 0, 0, j, 0);
            case 4:
                return G(this.f5011b, 0, j, 0, 0);
            case 5:
                return G(this.f5011b, j, 0, 0, 0);
            case 6:
                d<D> E = E(j / 256);
                return E.G(E.f5011b, (j % 256) * 12, 0, 0, 0);
            default:
                return H(this.f5011b.o(j, mVar), this.f5012c);
        }
    }

    public final d<D> E(long j) {
        return H(this.f5011b.o(j, e.c.a.w.b.DAYS), this.f5012c);
    }

    public final d<D> F(long j) {
        return G(this.f5011b, 0, 0, 0, j);
    }

    public final d<D> G(D d2, long j, long j2, long j3, long j4) {
        g z;
        b bVar = d2;
        if ((j | j2 | j3 | j4) == 0) {
            z = this.f5012c;
        } else {
            long j5 = j / 24;
            long j6 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
            long I = this.f5012c.I();
            long j7 = j6 + I;
            long R0 = c.R0(j7, 86400000000000L) + j5 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
            long U0 = c.U0(j7, 86400000000000L);
            z = U0 == I ? this.f5012c : g.z(U0);
            bVar = bVar.o(R0, e.c.a.w.b.DAYS);
        }
        return H(bVar, z);
    }

    public final d<D> H(e.c.a.w.d dVar, g gVar) {
        return (this.f5011b == dVar && this.f5012c == gVar) ? this : new d<>(this.f5011b.u().g(dVar), gVar);
    }

    /* renamed from: I */
    public d<D> g(f fVar) {
        return fVar instanceof b ? H((b) fVar, this.f5012c) : fVar instanceof g ? H(this.f5011b, (g) fVar) : fVar instanceof d ? this.f5011b.u().i((d) fVar) : this.f5011b.u().i((d) fVar.p(this));
    }

    /* renamed from: J */
    public d<D> n(j jVar, long j) {
        return jVar instanceof a ? jVar.l() ? H(this.f5011b, this.f5012c.n(jVar, j)) : H(this.f5011b.n(jVar, j), this.f5012c) : this.f5011b.u().i(jVar.f(this, j));
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        return jVar instanceof a ? jVar.l() ? this.f5012c.b(jVar) : this.f5011b.b(jVar) : jVar.n(this);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        return jVar instanceof a ? jVar.l() ? this.f5012c.d(jVar) : this.f5011b.d(jVar) : b(jVar).a(l(jVar), jVar);
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof a ? jVar.b() || jVar.l() : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        return jVar instanceof a ? jVar.l() ? this.f5012c.l(jVar) : this.f5011b.l(jVar) : jVar.i(this);
    }

    @Override // e.c.a.w.d
    public long q(e.c.a.w.d dVar, m mVar) {
        long j;
        int i;
        c<?> q = this.f5011b.u().q(dVar);
        if (!(mVar instanceof e.c.a.w.b)) {
            return mVar.d(this, q);
        }
        e.c.a.w.b bVar = (e.c.a.w.b) mVar;
        boolean z = true;
        if (bVar.compareTo(e.c.a.w.b.DAYS) < 0) {
            long l = q.l(a.EPOCH_DAY) - this.f5011b.l(a.EPOCH_DAY);
            switch (bVar.ordinal()) {
                case 0:
                    j = 86400000000000L;
                    l = c.a2(l, j);
                    return c.Y1(l, this.f5012c.q(q.A(), mVar));
                case 1:
                    j = 86400000000L;
                    l = c.a2(l, j);
                    return c.Y1(l, this.f5012c.q(q.A(), mVar));
                case 2:
                    j = 86400000;
                    l = c.a2(l, j);
                    return c.Y1(l, this.f5012c.q(q.A(), mVar));
                case 3:
                    i = Strategy.TTL_SECONDS_MAX;
                    l = c.Z1(l, i);
                    return c.Y1(l, this.f5012c.q(q.A(), mVar));
                case 4:
                    i = 1440;
                    l = c.Z1(l, i);
                    return c.Y1(l, this.f5012c.q(q.A(), mVar));
                case 5:
                    i = 24;
                    l = c.Z1(l, i);
                    return c.Y1(l, this.f5012c.q(q.A(), mVar));
                case 6:
                    i = 2;
                    l = c.Z1(l, i);
                    return c.Y1(l, this.f5012c.q(q.A(), mVar));
                default:
                    return c.Y1(l, this.f5012c.q(q.A(), mVar));
            }
        } else {
            b z2 = q.z();
            if (q.A().compareTo(this.f5012c) >= 0) {
                z = false;
            }
            if (z) {
                z2 = z2.k(1, e.c.a.w.b.DAYS);
            }
            return this.f5011b.q(z2, mVar);
        }
    }

    @Override // e.c.a.t.c
    public f<D> s(p pVar) {
        return g.F(this, pVar, null);
    }

    @Override // e.c.a.t.c
    public D z() {
        return this.f5011b;
    }
}
