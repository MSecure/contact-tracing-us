package l.b.a.t;

import java.io.Serializable;
import java.util.HashMap;
import l.b.a.d;
import l.b.a.e;
import l.b.a.p;
import l.b.a.w.a;
import l.b.a.w.o;

public final class v extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final v f4206d = new v();

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, String[]> f4207e;

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, String[]> f4208f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, String[]> f4209g;

    static {
        HashMap<String, String[]> hashMap = new HashMap<>();
        f4207e = hashMap;
        HashMap<String, String[]> hashMap2 = new HashMap<>();
        f4208f = hashMap2;
        HashMap<String, String[]> hashMap3 = new HashMap<>();
        f4209g = hashMap3;
        hashMap.put("en", new String[]{"BB", "BE"});
        hashMap.put("th", new String[]{"BB", "BE"});
        hashMap2.put("en", new String[]{"B.B.", "B.E."});
        hashMap2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private Object readResolve() {
        return f4206d;
    }

    @Override // l.b.a.t.h
    public b b(int i2, int i3, int i4) {
        return new w(e.P(i2 - 543, i3, i4));
    }

    @Override // l.b.a.t.h
    public b c(l.b.a.w.e eVar) {
        return eVar instanceof w ? (w) eVar : new w(e.E(eVar));
    }

    @Override // l.b.a.t.h
    public i i(int i2) {
        return x.q(i2);
    }

    @Override // l.b.a.t.h
    public String m() {
        return "buddhist";
    }

    @Override // l.b.a.t.h
    public String n() {
        return "ThaiBuddhist";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.t.c<?>, l.b.a.t.c<l.b.a.t.w> */
    @Override // l.b.a.t.h
    public c<w> o(l.b.a.w.e eVar) {
        return super.o(eVar);
    }

    @Override // l.b.a.t.h
    public f<w> s(d dVar, p pVar) {
        return g.F(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.t.f<?>, l.b.a.t.f<l.b.a.t.w> */
    @Override // l.b.a.t.h
    public f<w> t(l.b.a.w.e eVar) {
        return super.t(eVar);
    }

    public o u(a aVar) {
        switch (aVar.ordinal()) {
            case 24:
                o oVar = a.PROLEPTIC_MONTH.f4286e;
                return o.d(oVar.b + 6516, oVar.f4307e + 6516);
            case 25:
                o oVar2 = a.YEAR.f4286e;
                return o.e(1, (-(oVar2.b + 543)) + 1, oVar2.f4307e + 543);
            case 26:
                o oVar3 = a.YEAR.f4286e;
                return o.d(oVar3.b + 543, oVar3.f4307e + 543);
            default:
                return aVar.f4286e;
        }
    }
}
