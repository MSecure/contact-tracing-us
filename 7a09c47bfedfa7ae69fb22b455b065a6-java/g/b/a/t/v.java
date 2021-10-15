package g.b.a.t;

import g.b.a.d;
import g.b.a.p;
import g.b.a.w.a;
import g.b.a.w.e;
import g.b.a.w.o;
import java.io.Serializable;
import java.util.HashMap;

public final class v extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final v f6501d = new v();

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, String[]> f6502e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, String[]> f6503f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, String[]> f6504g = new HashMap<>();

    static {
        f6502e.put("en", new String[]{"BB", "BE"});
        f6502e.put("th", new String[]{"BB", "BE"});
        f6503f.put("en", new String[]{"B.B.", "B.E."});
        f6503f.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        f6504g.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        f6504g.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private Object readResolve() {
        return f6501d;
    }

    @Override // g.b.a.t.h
    public f<w> B(d dVar, p pVar) {
        return g.W(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: g.b.a.t.f<?>, g.b.a.t.f<g.b.a.t.w> */
    @Override // g.b.a.t.h
    public f<w> D(e eVar) {
        return super.D(eVar);
    }

    public o F(a aVar) {
        switch (aVar.ordinal()) {
            case 24:
                o oVar = a.PROLEPTIC_MONTH.f6633c;
                return o.d(oVar.f6663b + 6516, oVar.f6666e + 6516);
            case 25:
                o oVar2 = a.YEAR.f6633c;
                return o.e(1, (-(oVar2.f6663b + 543)) + 1, oVar2.f6666e + 543);
            case 26:
                o oVar3 = a.YEAR.f6633c;
                return o.d(oVar3.f6663b + 543, oVar3.f6666e + 543);
            default:
                return aVar.f6633c;
        }
    }

    @Override // g.b.a.t.h
    public b d(int i, int i2, int i3) {
        return new w(g.b.a.e.f0(i - 543, i2, i3));
    }

    @Override // g.b.a.t.h
    public b f(e eVar) {
        return eVar instanceof w ? (w) eVar : new w(g.b.a.e.V(eVar));
    }

    @Override // g.b.a.t.h
    public i n(int i) {
        return x.p(i);
    }

    @Override // g.b.a.t.h
    public String r() {
        return "buddhist";
    }

    @Override // g.b.a.t.h
    public String s() {
        return "ThaiBuddhist";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: g.b.a.t.c<?>, g.b.a.t.c<g.b.a.t.w> */
    @Override // g.b.a.t.h
    public c<w> t(e eVar) {
        return super.t(eVar);
    }
}
