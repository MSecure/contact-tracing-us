package e.c.a.t;

import e.c.a.d;
import e.c.a.e;
import e.c.a.p;
import e.c.a.w.a;
import e.c.a.w.o;
import java.io.Serializable;

public final class r extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final r f5041d = new r();

    private Object readResolve() {
        return f5041d;
    }

    @Override // e.c.a.t.h
    public b d(int i, int i2, int i3) {
        return new s(e.P(i + 1911, i2, i3));
    }

    @Override // e.c.a.t.h
    public b f(e.c.a.w.e eVar) {
        return eVar instanceof s ? (s) eVar : new s(e.F(eVar));
    }

    @Override // e.c.a.t.h
    public i l(int i) {
        return t.s(i);
    }

    @Override // e.c.a.t.h
    public String o() {
        return "roc";
    }

    @Override // e.c.a.t.h
    public String p() {
        return "Minguo";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: e.c.a.t.c<?>, e.c.a.t.c<e.c.a.t.s> */
    @Override // e.c.a.t.h
    public c<s> q(e.c.a.w.e eVar) {
        return super.q(eVar);
    }

    @Override // e.c.a.t.h
    public f<s> v(d dVar, p pVar) {
        return g.G(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: e.c.a.t.f<?>, e.c.a.t.f<e.c.a.t.s> */
    @Override // e.c.a.t.h
    public f<s> w(e.c.a.w.e eVar) {
        return super.w(eVar);
    }

    public o x(a aVar) {
        switch (aVar.ordinal()) {
            case 24:
                o oVar = a.PROLEPTIC_MONTH.f5158c;
                return o.d(oVar.f5182b - 22932, oVar.f5185e - 22932);
            case 25:
                o oVar2 = a.YEAR.f5158c;
                return o.e(1, oVar2.f5185e - 1911, (-oVar2.f5182b) + 1 + 1911);
            case 26:
                o oVar3 = a.YEAR.f5158c;
                return o.d(oVar3.f5182b - 1911, oVar3.f5185e - 1911);
            default:
                return aVar.f5158c;
        }
    }
}
