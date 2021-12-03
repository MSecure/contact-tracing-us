package l.b.a.u;

import f.a.a.a.a;
import java.io.Serializable;
import l.b.a.b;
import l.b.a.f;
import l.b.a.g;
import l.b.a.q;
import l.b.a.t;
import l.b.a.x.e;

public final class m extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final m f4408d = new m();

    private Object readResolve() {
        return f4408d;
    }

    @Override // l.b.a.u.h
    public b b(int i2, int i3, int i4) {
        return f.P(i2, i3, i4);
    }

    @Override // l.b.a.u.h
    public b c(e eVar) {
        return f.E(eVar);
    }

    @Override // l.b.a.u.h
    public i i(int i2) {
        if (i2 == 0) {
            return n.BCE;
        }
        if (i2 == 1) {
            return n.CE;
        }
        throw new b(a.t("Invalid era: ", i2));
    }

    @Override // l.b.a.u.h
    public String m() {
        return "iso8601";
    }

    @Override // l.b.a.u.h
    public String n() {
        return "ISO";
    }

    @Override // l.b.a.u.h
    public c o(e eVar) {
        return g.C(eVar);
    }

    @Override // l.b.a.u.h
    public f s(l.b.a.e eVar, q qVar) {
        return t.I(eVar, qVar);
    }

    @Override // l.b.a.u.h
    public f t(e eVar) {
        return t.F(eVar);
    }

    public boolean u(long j2) {
        return (3 & j2) == 0 && (j2 % 100 != 0 || j2 % 400 == 0);
    }
}
