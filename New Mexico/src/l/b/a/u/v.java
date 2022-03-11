package l.b.a.u;

import java.io.Serializable;
import java.util.HashMap;
import l.b.a.f;
import l.b.a.q;
import l.b.a.x.a;
import l.b.a.x.e;
import l.b.a.x.o;
/* loaded from: classes.dex */
public final class v extends h implements Serializable {

    /* renamed from: d */
    public static final v f4681d = new v();

    /* renamed from: e */
    public static final HashMap<String, String[]> f4682e;

    /* renamed from: f */
    public static final HashMap<String, String[]> f4683f;

    /* renamed from: g */
    public static final HashMap<String, String[]> f4684g;

    static {
        HashMap<String, String[]> hashMap = new HashMap<>();
        f4682e = hashMap;
        HashMap<String, String[]> hashMap2 = new HashMap<>();
        f4683f = hashMap2;
        HashMap<String, String[]> hashMap3 = new HashMap<>();
        f4684g = hashMap3;
        hashMap.put("en", new String[]{"BB", "BE"});
        hashMap.put("th", new String[]{"BB", "BE"});
        hashMap2.put("en", new String[]{"B.B.", "B.E."});
        hashMap2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private Object readResolve() {
        return f4681d;
    }

    @Override // l.b.a.u.h
    public b b(int i2, int i3, int i4) {
        return new w(f.P(i2 - 543, i3, i4));
    }

    @Override // l.b.a.u.h
    public b c(e eVar) {
        return eVar instanceof w ? (w) eVar : new w(f.E(eVar));
    }

    @Override // l.b.a.u.h
    public i i(int i2) {
        return x.q(i2);
    }

    @Override // l.b.a.u.h
    public String m() {
        return "buddhist";
    }

    @Override // l.b.a.u.h
    public String n() {
        return "ThaiBuddhist";
    }

    @Override // l.b.a.u.h
    public c<w> o(e eVar) {
        return super.o(eVar);
    }

    @Override // l.b.a.u.h
    public f<w> s(l.b.a.e eVar, q qVar) {
        return g.F(this, eVar, qVar);
    }

    @Override // l.b.a.u.h
    public f<w> t(e eVar) {
        return super.t(eVar);
    }

    public o u(a aVar) {
        switch (aVar.ordinal()) {
            case 24:
                o oVar = a.PROLEPTIC_MONTH.f4761e;
                return o.d(oVar.b + 6516, oVar.f4782e + 6516);
            case 25:
                o oVar2 = a.YEAR.f4761e;
                return o.e(1, (-(oVar2.b + 543)) + 1, oVar2.f4782e + 543);
            case 26:
                o oVar3 = a.YEAR.f4761e;
                return o.d(oVar3.b + 543, oVar3.f4782e + 543);
            default:
                return aVar.f4761e;
        }
    }
}
