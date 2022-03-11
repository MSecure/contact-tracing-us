package l.b.a.u;

import g.b.a.c.c.d;
import java.io.Serializable;
import l.b.a.f;
import l.b.a.h;
import l.b.a.x.a;
import l.b.a.x.i;
import l.b.a.x.j;
import l.b.a.x.m;
import l.b.a.x.n;
import l.b.a.x.o;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public final class s extends a<s> implements Serializable {
    public final f b;

    public s(f fVar) {
        d.u(fVar, "date");
        this.b = fVar;
    }

    private Object writeReplace() {
        return new u((byte) 5, this);
    }

    @Override // l.b.a.u.a
    public a<s> A(long j2, m mVar) {
        return (s) super.v(j2, mVar);
    }

    public a B(long j2) {
        return G(this.b.V(j2));
    }

    public a C(long j2) {
        return G(this.b.W(j2));
    }

    public a D(long j2) {
        return G(this.b.Y(j2));
    }

    public final long E() {
        return ((((long) F()) * 12) + ((long) this.b.c)) - 1;
    }

    public final int F() {
        return this.b.b - 1911;
    }

    public final s G(f fVar) {
        return fVar.equals(this.b) ? this : new s(fVar);
    }

    /* renamed from: H */
    public s z(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (s) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        if (i(aVar) == j2) {
            return this;
        }
        switch (aVar.ordinal()) {
            case 24:
                r.f4679d.u(aVar).b(j2, aVar);
                return G(this.b.W(j2 - E()));
            case 25:
            case 26:
            case 27:
                int a = r.f4679d.u(aVar).a(j2, aVar);
                switch (aVar.ordinal()) {
                    case 25:
                        return G(this.b.c0(F() >= 1 ? a + 1911 : (1 - a) + 1911));
                    case 26:
                        return G(this.b.c0(a + 1911));
                    case 27:
                        return G(this.b.c0((1 - F()) + 1911));
                }
        }
        return G(this.b.z(jVar, j2));
    }

    public o a(j jVar) {
        long j2;
        if (!(jVar instanceof a)) {
            return jVar.l(this);
        }
        if (f(jVar)) {
            a aVar = (a) jVar;
            int ordinal = aVar.ordinal();
            if (ordinal == 18 || ordinal == 19 || ordinal == 21) {
                return this.b.a(jVar);
            }
            if (ordinal != 25) {
                return r.f4679d.u(aVar);
            }
            o oVar = a.YEAR.f4761e;
            if (F() <= 0) {
                j2 = (-oVar.b) + 1 + 1911;
            } else {
                j2 = oVar.f4782e - 1911;
            }
            return o.d(1, j2);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    public l.b.a.x.d e(l.b.a.x.f fVar) {
        return (s) r.f4679d.e(fVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            return this.b.equals(((s) obj).b);
        }
        return false;
    }

    public l.b.a.x.d h(long j2, m mVar) {
        return (s) super.h(j2, mVar);
    }

    public int hashCode() {
        r rVar = r.f4679d;
        return -1990173233 ^ this.b.hashCode();
    }

    public long i(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int i2 = 1;
        switch (((a) jVar).ordinal()) {
            case 24:
                return E();
            case 25:
                int F = F();
                if (F < 1) {
                    F = 1 - F;
                }
                return (long) F;
            case 26:
                return (long) F();
            case 27:
                if (F() < 1) {
                    i2 = 0;
                }
                return (long) i2;
            default:
                return this.b.i(jVar);
        }
    }

    public l.b.a.x.d m(long j2, m mVar) {
        return (s) super.v(j2, mVar);
    }

    public final c<s> q(h hVar) {
        return new d(this, hVar);
    }

    public h s() {
        return r.f4679d;
    }

    public i t() {
        return (t) super.t();
    }

    public b u(long j2, m mVar) {
        return (s) super.h(j2, mVar);
    }

    public b v(long j2, m mVar) {
        return (s) super.v(j2, mVar);
    }

    public b w(i iVar) {
        return (s) r.f4679d.e(((l.b.a.m) iVar).b(this));
    }

    public long x() {
        return this.b.x();
    }

    public b y(l.b.a.x.f fVar) {
        return (s) r.f4679d.e(fVar.n(this));
    }
}
