package g.b.a.t;

import g.b.a.d;
import g.b.a.p;
import g.b.a.w.a;
import g.b.a.w.e;
import g.b.a.w.o;
import java.io.Serializable;

public final class r extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final r f6494d = new r();

    private Object readResolve() {
        return f6494d;
    }

    @Override // g.b.a.t.h
    public f<s> B(d dVar, p pVar) {
        return g.W(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: g.b.a.t.f<?>, g.b.a.t.f<g.b.a.t.s> */
    @Override // g.b.a.t.h
    public f<s> D(e eVar) {
        return super.D(eVar);
    }

    public o F(a aVar) {
        switch (aVar.ordinal()) {
            case 24:
                o oVar = a.PROLEPTIC_MONTH.f6633c;
                return o.d(oVar.f6663b - 22932, oVar.f6666e - 22932);
            case 25:
                o oVar2 = a.YEAR.f6633c;
                return o.e(1, oVar2.f6666e - 1911, (-oVar2.f6663b) + 1 + 1911);
            case 26:
                o oVar3 = a.YEAR.f6633c;
                return o.d(oVar3.f6663b - 1911, oVar3.f6666e - 1911);
            default:
                return aVar.f6633c;
        }
    }

    @Override // g.b.a.t.h
    public b d(int i, int i2, int i3) {
        return new s(g.b.a.e.f0(i + 1911, i2, i3));
    }

    @Override // g.b.a.t.h
    public b f(e eVar) {
        return eVar instanceof s ? (s) eVar : new s(g.b.a.e.V(eVar));
    }

    @Override // g.b.a.t.h
    public i n(int i) {
        return t.p(i);
    }

    @Override // g.b.a.t.h
    public String r() {
        return "roc";
    }

    @Override // g.b.a.t.h
    public String s() {
        return "Minguo";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: g.b.a.t.c<?>, g.b.a.t.c<g.b.a.t.s> */
    @Override // g.b.a.t.h
    public c<s> t(e eVar) {
        return super.t(eVar);
    }
}
