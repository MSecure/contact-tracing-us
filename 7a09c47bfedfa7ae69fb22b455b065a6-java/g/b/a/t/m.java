package g.b.a.t;

import g.b.a.a;
import g.b.a.d;
import g.b.a.f;
import g.b.a.p;
import g.b.a.s;
import g.b.a.w.e;
import java.io.Serializable;

public final class m extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final m f6476d = new m();

    private Object readResolve() {
        return f6476d;
    }

    @Override // g.b.a.t.h
    public f B(d dVar, p pVar) {
        return s.Z(dVar, pVar);
    }

    @Override // g.b.a.t.h
    public f D(e eVar) {
        return s.W(eVar);
    }

    public boolean F(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    @Override // g.b.a.t.h
    public b d(int i, int i2, int i3) {
        return g.b.a.e.f0(i, i2, i3);
    }

    @Override // g.b.a.t.h
    public b f(e eVar) {
        return g.b.a.e.V(eVar);
    }

    @Override // g.b.a.t.h
    public i n(int i) {
        if (i == 0) {
            return n.BCE;
        }
        if (i == 1) {
            return n.CE;
        }
        throw new a(c.a.a.a.a.n("Invalid era: ", i));
    }

    @Override // g.b.a.t.h
    public String r() {
        return "iso8601";
    }

    @Override // g.b.a.t.h
    public String s() {
        return "ISO";
    }

    @Override // g.b.a.t.h
    public c t(e eVar) {
        return f.U(eVar);
    }
}
