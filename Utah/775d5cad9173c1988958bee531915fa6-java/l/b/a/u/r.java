package l.b.a.u;

import java.io.Serializable;
import l.b.a.f;
import l.b.a.q;
import l.b.a.x.a;
import l.b.a.x.e;
import l.b.a.x.o;

public final class r extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final r f4424d = new r();

    private Object readResolve() {
        return f4424d;
    }

    @Override // l.b.a.u.h
    public b b(int i2, int i3, int i4) {
        return new s(f.P(i2 + 1911, i3, i4));
    }

    @Override // l.b.a.u.h
    public b c(e eVar) {
        return eVar instanceof s ? (s) eVar : new s(f.E(eVar));
    }

    @Override // l.b.a.u.h
    public i i(int i2) {
        return t.q(i2);
    }

    @Override // l.b.a.u.h
    public String m() {
        return "roc";
    }

    @Override // l.b.a.u.h
    public String n() {
        return "Minguo";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.u.c<?>, l.b.a.u.c<l.b.a.u.s> */
    @Override // l.b.a.u.h
    public c<s> o(e eVar) {
        return super.o(eVar);
    }

    @Override // l.b.a.u.h
    public f<s> s(l.b.a.e eVar, q qVar) {
        return g.F(this, eVar, qVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.u.f<?>, l.b.a.u.f<l.b.a.u.s> */
    @Override // l.b.a.u.h
    public f<s> t(e eVar) {
        return super.t(eVar);
    }

    public o u(a aVar) {
        switch (aVar.ordinal()) {
            case 24:
                o oVar = a.PROLEPTIC_MONTH.f4506e;
                return o.d(oVar.b - 22932, oVar.f4527e - 22932);
            case 25:
                o oVar2 = a.YEAR.f4506e;
                return o.e(1, oVar2.f4527e - 1911, (-oVar2.b) + 1 + 1911);
            case 26:
                o oVar3 = a.YEAR.f4506e;
                return o.d(oVar3.b - 1911, oVar3.f4527e - 1911);
            default:
                return aVar.f4506e;
        }
    }
}
