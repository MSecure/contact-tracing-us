package e.c.a.t;

import e.c.a.d;
import e.c.a.e;
import e.c.a.p;
import e.c.a.w.a;
import e.c.a.w.o;
import java.io.Serializable;
import java.util.HashMap;

public final class v extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final v f5048d = new v();

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, String[]> f5049e = new HashMap<>();
    public static final HashMap<String, String[]> f = new HashMap<>();
    public static final HashMap<String, String[]> g = new HashMap<>();

    static {
        f5049e.put("en", new String[]{"BB", "BE"});
        f5049e.put("th", new String[]{"BB", "BE"});
        f.put("en", new String[]{"B.B.", "B.E."});
        f.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        g.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        g.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private Object readResolve() {
        return f5048d;
    }

    @Override // e.c.a.t.h
    public b d(int i, int i2, int i3) {
        return new w(e.P(i - 543, i2, i3));
    }

    @Override // e.c.a.t.h
    public b f(e.c.a.w.e eVar) {
        return eVar instanceof w ? (w) eVar : new w(e.F(eVar));
    }

    @Override // e.c.a.t.h
    public i l(int i) {
        return x.s(i);
    }

    @Override // e.c.a.t.h
    public String o() {
        return "buddhist";
    }

    @Override // e.c.a.t.h
    public String p() {
        return "ThaiBuddhist";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: e.c.a.t.c<?>, e.c.a.t.c<e.c.a.t.w> */
    @Override // e.c.a.t.h
    public c<w> q(e.c.a.w.e eVar) {
        return super.q(eVar);
    }

    @Override // e.c.a.t.h
    public f<w> v(d dVar, p pVar) {
        return g.G(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: e.c.a.t.f<?>, e.c.a.t.f<e.c.a.t.w> */
    @Override // e.c.a.t.h
    public f<w> w(e.c.a.w.e eVar) {
        return super.w(eVar);
    }

    public o x(a aVar) {
        switch (aVar.ordinal()) {
            case 24:
                o oVar = a.PROLEPTIC_MONTH.f5158c;
                return o.d(oVar.f5182b + 6516, oVar.f5185e + 6516);
            case 25:
                o oVar2 = a.YEAR.f5158c;
                return o.e(1, (-(oVar2.f5182b + 543)) + 1, oVar2.f5185e + 543);
            case 26:
                o oVar3 = a.YEAR.f5158c;
                return o.d(oVar3.f5182b + 543, oVar3.f5185e + 543);
            default:
                return aVar.f5158c;
        }
    }
}
