package l.b.a.t;

import f.b.a.c.b.o.b;
import java.io.Serializable;
import l.b.a.a;
import l.b.a.d;
import l.b.a.e;
import l.b.a.f;
import l.b.a.p;
import l.b.a.s;

public final class m extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final m f4188d = new m();

    private Object readResolve() {
        return f4188d;
    }

    @Override // l.b.a.t.h
    public b b(int i2, int i3, int i4) {
        return e.P(i2, i3, i4);
    }

    @Override // l.b.a.t.h
    public b c(l.b.a.w.e eVar) {
        return e.E(eVar);
    }

    @Override // l.b.a.t.h
    public i i(int i2) {
        if (i2 == 0) {
            return n.BCE;
        }
        if (i2 == 1) {
            return n.CE;
        }
        throw new a(f.a.a.a.a.q("Invalid era: ", i2));
    }

    @Override // l.b.a.t.h
    public String m() {
        return "iso8601";
    }

    @Override // l.b.a.t.h
    public String n() {
        return "ISO";
    }

    @Override // l.b.a.t.h
    public c o(l.b.a.w.e eVar) {
        return f.C(eVar);
    }

    @Override // l.b.a.t.h
    public f s(d dVar, p pVar) {
        b.A1(dVar, "instant");
        b.A1(pVar, "zone");
        return s.E(dVar.b, dVar.c, pVar);
    }

    @Override // l.b.a.t.h
    public f t(l.b.a.w.e eVar) {
        return s.F(eVar);
    }

    public boolean u(long j2) {
        return (3 & j2) == 0 && (j2 % 100 != 0 || j2 % 400 == 0);
    }
}
