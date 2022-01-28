package e.c.a.t;

import c.b.a.a.c.n.c;
import e.c.a.a;
import e.c.a.d;
import e.c.a.e;
import e.c.a.f;
import e.c.a.p;
import e.c.a.s;
import java.io.Serializable;

public final class m extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final m f5027d = new m();

    private Object readResolve() {
        return f5027d;
    }

    @Override // e.c.a.t.h
    public b d(int i, int i2, int i3) {
        return e.P(i, i2, i3);
    }

    @Override // e.c.a.t.h
    public b f(e.c.a.w.e eVar) {
        return e.F(eVar);
    }

    @Override // e.c.a.t.h
    public i l(int i) {
        if (i == 0) {
            return n.BCE;
        }
        if (i == 1) {
            return n.CE;
        }
        throw new a(c.a.a.a.a.l("Invalid era: ", i));
    }

    @Override // e.c.a.t.h
    public String o() {
        return "iso8601";
    }

    @Override // e.c.a.t.h
    public String p() {
        return "ISO";
    }

    @Override // e.c.a.t.h
    public c q(e.c.a.w.e eVar) {
        return f.E(eVar);
    }

    @Override // e.c.a.t.h
    public f v(d dVar, p pVar) {
        c.T1(dVar, "instant");
        c.T1(pVar, "zone");
        return s.F(dVar.f4967b, dVar.f4968c, pVar);
    }

    @Override // e.c.a.t.h
    public f w(e.c.a.w.e eVar) {
        return s.G(eVar);
    }

    public boolean x(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }
}
