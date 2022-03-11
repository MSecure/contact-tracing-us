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
public final class w extends a<w> implements Serializable {
    public final f b;

    public w(f fVar) {
        d.u(fVar, "date");
        this.b = fVar;
    }

    private Object writeReplace() {
        return new u((byte) 7, this);
    }

    @Override // l.b.a.u.a
    public a<w> A(long j2, m mVar) {
        return (w) super.v(j2, mVar);
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
        return this.b.b + 543;
    }

    public final w G(f fVar) {
        return fVar.equals(this.b) ? this : new w(fVar);
    }

    /* renamed from: H */
    public w z(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (w) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        if (i(aVar) == j2) {
            return this;
        }
        switch (aVar.ordinal()) {
            case 24:
                v.f4681d.u(aVar).b(j2, aVar);
                return G(this.b.W(j2 - E()));
            case 25:
            case 26:
            case 27:
                int a = v.f4681d.u(aVar).a(j2, aVar);
                switch (aVar.ordinal()) {
                    case 25:
                        f fVar = this.b;
                        if (F() < 1) {
                            a = 1 - a;
                        }
                        return G(fVar.c0(a - 543));
                    case 26:
                        return G(this.b.c0(a - 543));
                    case 27:
                        return G(this.b.c0((1 - F()) - 543));
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
                return v.f4681d.u(aVar);
            }
            o oVar = a.YEAR.f4761e;
            if (F() <= 0) {
                j2 = (-(oVar.b + 543)) + 1;
            } else {
                j2 = 543 + oVar.f4782e;
            }
            return o.d(1, j2);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    public l.b.a.x.d e(l.b.a.x.f fVar) {
        return (w) v.f4681d.e(fVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return this.b.equals(((w) obj).b);
        }
        return false;
    }

    public l.b.a.x.d h(long j2, m mVar) {
        return (w) super.h(j2, mVar);
    }

    public int hashCode() {
        v vVar = v.f4681d;
        return 146118545 ^ this.b.hashCode();
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
        return (w) super.v(j2, mVar);
    }

    public final c<w> q(h hVar) {
        return new d(this, hVar);
    }

    public h s() {
        return v.f4681d;
    }

    public i t() {
        return (x) super.t();
    }

    public b u(long j2, m mVar) {
        return (w) super.h(j2, mVar);
    }

    public b v(long j2, m mVar) {
        return (w) super.v(j2, mVar);
    }

    public b w(i iVar) {
        return (w) v.f4681d.e(((l.b.a.m) iVar).b(this));
    }

    public long x() {
        return this.b.x();
    }

    public b y(l.b.a.x.f fVar) {
        return (w) v.f4681d.e(fVar.n(this));
    }
}
