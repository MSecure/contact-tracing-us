package g.b.a.t;

import b.x.t;
import com.google.android.gms.nearby.messages.Strategy;
import g.b.a.g;
import g.b.a.p;
import g.b.a.t.b;
import g.b.a.w.a;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.m;
import g.b.a.w.o;
import java.io.Serializable;

public final class d<D extends b> extends c<D> implements g.b.a.w.d, f, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final D f6456b;

    /* renamed from: c  reason: collision with root package name */
    public final g f6457c;

    public d(D d2, g gVar) {
        t.y2(d2, "date");
        t.y2(gVar, "time");
        this.f6456b = d2;
        this.f6457c = gVar;
    }

    private Object writeReplace() {
        return new u((byte) 12, this);
    }

    @Override // g.b.a.t.c
    public f<D> A(p pVar) {
        return g.V(this, pVar, null);
    }

    @Override // g.b.a.t.c
    public D P() {
        return this.f6456b;
    }

    @Override // g.b.a.t.c
    public g Q() {
        return this.f6457c;
    }

    /* renamed from: T */
    public d<D> s(long j, m mVar) {
        if (!(mVar instanceof g.b.a.w.b)) {
            return this.f6456b.D().k(mVar.f(this, j));
        }
        switch (((g.b.a.w.b) mVar).ordinal()) {
            case 0:
                return V(j);
            case 1:
                return U(j / 86400000000L).V((j % 86400000000L) * 1000);
            case 2:
                return U(j / 86400000).V((j % 86400000) * 1000000);
            case 3:
                return W(this.f6456b, 0, 0, j, 0);
            case 4:
                return W(this.f6456b, 0, j, 0, 0);
            case 5:
                return W(this.f6456b, j, 0, 0, 0);
            case 6:
                d<D> U = U(j / 256);
                return U.W(U.f6456b, (j % 256) * 12, 0, 0, 0);
            default:
                return X(this.f6456b.s(j, mVar), this.f6457c);
        }
    }

    public final d<D> U(long j) {
        return X(this.f6456b.s(j, g.b.a.w.b.DAYS), this.f6457c);
    }

    public final d<D> V(long j) {
        return W(this.f6456b, 0, 0, 0, j);
    }

    public final d<D> W(D d2, long j, long j2, long j3, long j4) {
        g P;
        b bVar = d2;
        if ((j | j2 | j3 | j4) == 0) {
            P = this.f6457c;
        } else {
            long j5 = j / 24;
            long j6 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
            long Y = this.f6457c.Y();
            long j7 = j6 + Y;
            long t1 = t.t1(j7, 86400000000000L) + j5 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
            long w1 = t.w1(j7, 86400000000000L);
            P = w1 == Y ? this.f6457c : g.P(w1);
            bVar = bVar.s(t1, g.b.a.w.b.DAYS);
        }
        return X(bVar, P);
    }

    public final d<D> X(g.b.a.w.d dVar, g gVar) {
        return (this.f6456b == dVar && this.f6457c == gVar) ? this : new d<>(this.f6456b.D().i(dVar), gVar);
    }

    /* renamed from: Y */
    public d<D> i(f fVar) {
        return fVar instanceof b ? X((b) fVar, this.f6457c) : fVar instanceof g ? X(this.f6456b, (g) fVar) : fVar instanceof d ? this.f6456b.D().k((d) fVar) : this.f6456b.D().k((d) fVar.t(this));
    }

    /* renamed from: Z */
    public d<D> r(j jVar, long j) {
        return jVar instanceof a ? jVar.n() ? X(this.f6456b, this.f6457c.r(jVar, j)) : X(this.f6456b.r(jVar, j), this.f6457c) : this.f6456b.D().k(jVar.f(this, j));
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        return jVar instanceof a ? jVar.n() ? this.f6457c.b(jVar) : this.f6456b.b(jVar) : jVar.p(this);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        return jVar instanceof a ? jVar.n() ? this.f6457c.d(jVar) : this.f6456b.d(jVar) : b(jVar).a(n(jVar), jVar);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof a ? jVar.b() || jVar.n() : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        return jVar instanceof a ? jVar.n() ? this.f6457c.n(jVar) : this.f6456b.n(jVar) : jVar.k(this);
    }

    @Override // g.b.a.w.d
    public long y(g.b.a.w.d dVar, m mVar) {
        long j;
        int i;
        c<?> t = this.f6456b.D().t(dVar);
        if (!(mVar instanceof g.b.a.w.b)) {
            return mVar.d(this, t);
        }
        g.b.a.w.b bVar = (g.b.a.w.b) mVar;
        boolean z = true;
        if (bVar.compareTo(g.b.a.w.b.DAYS) < 0) {
            long n = t.n(a.EPOCH_DAY) - this.f6456b.n(a.EPOCH_DAY);
            switch (bVar.ordinal()) {
                case 0:
                    j = 86400000000000L;
                    n = t.F2(n, j);
                    return t.D2(n, this.f6457c.y(t.Q(), mVar));
                case 1:
                    j = 86400000000L;
                    n = t.F2(n, j);
                    return t.D2(n, this.f6457c.y(t.Q(), mVar));
                case 2:
                    j = 86400000;
                    n = t.F2(n, j);
                    return t.D2(n, this.f6457c.y(t.Q(), mVar));
                case 3:
                    i = Strategy.TTL_SECONDS_MAX;
                    n = t.E2(n, i);
                    return t.D2(n, this.f6457c.y(t.Q(), mVar));
                case 4:
                    i = 1440;
                    n = t.E2(n, i);
                    return t.D2(n, this.f6457c.y(t.Q(), mVar));
                case 5:
                    i = 24;
                    n = t.E2(n, i);
                    return t.D2(n, this.f6457c.y(t.Q(), mVar));
                case 6:
                    i = 2;
                    n = t.E2(n, i);
                    return t.D2(n, this.f6457c.y(t.Q(), mVar));
                default:
                    return t.D2(n, this.f6457c.y(t.Q(), mVar));
            }
        } else {
            b P = t.P();
            if (t.Q().compareTo(this.f6457c) >= 0) {
                z = false;
            }
            if (z) {
                P = P.m(1, g.b.a.w.b.DAYS);
            }
            return this.f6456b.y(P, mVar);
        }
    }
}
