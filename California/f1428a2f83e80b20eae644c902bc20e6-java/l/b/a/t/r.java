package l.b.a.t;

import java.io.Serializable;
import l.b.a.d;
import l.b.a.e;
import l.b.a.p;
import l.b.a.w.a;
import l.b.a.w.o;

public final class r extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final r f4100d = new r();

    private Object readResolve() {
        return f4100d;
    }

    @Override // l.b.a.t.h
    public b b(int i2, int i3, int i4) {
        return new s(e.P(i2 + 1911, i3, i4));
    }

    @Override // l.b.a.t.h
    public b c(l.b.a.w.e eVar) {
        return eVar instanceof s ? (s) eVar : new s(e.E(eVar));
    }

    @Override // l.b.a.t.h
    public i i(int i2) {
        return t.q(i2);
    }

    @Override // l.b.a.t.h
    public String m() {
        return "roc";
    }

    @Override // l.b.a.t.h
    public String n() {
        return "Minguo";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.t.c<?>, l.b.a.t.c<l.b.a.t.s> */
    @Override // l.b.a.t.h
    public c<s> o(l.b.a.w.e eVar) {
        return super.o(eVar);
    }

    @Override // l.b.a.t.h
    public f<s> s(d dVar, p pVar) {
        return g.F(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.t.f<?>, l.b.a.t.f<l.b.a.t.s> */
    @Override // l.b.a.t.h
    public f<s> t(l.b.a.w.e eVar) {
        return super.t(eVar);
    }

    public o u(a aVar) {
        switch (aVar.ordinal()) {
            case 24:
                o oVar = a.PROLEPTIC_MONTH.f4182e;
                return o.d(oVar.b - 22932, oVar.f4203e - 22932);
            case 25:
                o oVar2 = a.YEAR.f4182e;
                return o.e(1, oVar2.f4203e - 1911, (-oVar2.b) + 1 + 1911);
            case 26:
                o oVar3 = a.YEAR.f4182e;
                return o.d(oVar3.b - 1911, oVar3.f4203e - 1911);
            default:
                return aVar.f4182e;
        }
    }
}
