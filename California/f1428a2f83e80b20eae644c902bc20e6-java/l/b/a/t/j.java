package l.b.a.t;

import java.io.Serializable;
import java.util.HashMap;
import l.b.a.d;
import l.b.a.p;
import l.b.a.w.a;
import l.b.a.w.e;

public final class j extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final j f4070d = new j();

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, String[]> f4071e;

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, String[]> f4072f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, String[]> f4073g;

    static {
        HashMap<String, String[]> hashMap = new HashMap<>();
        f4071e = hashMap;
        HashMap<String, String[]> hashMap2 = new HashMap<>();
        f4072f = hashMap2;
        HashMap<String, String[]> hashMap3 = new HashMap<>();
        f4073g = hashMap3;
        hashMap.put("en", new String[]{"BH", "HE"});
        hashMap2.put("en", new String[]{"B.H.", "H.E."});
        hashMap3.put("en", new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private Object readResolve() {
        return f4070d;
    }

    @Override // l.b.a.t.h
    public b b(int i2, int i3, int i4) {
        return k.N(i2, i3, i4);
    }

    @Override // l.b.a.t.h
    public b c(e eVar) {
        if (eVar instanceof k) {
            return (k) eVar;
        }
        return new k(eVar.i(a.EPOCH_DAY));
    }

    @Override // l.b.a.t.h
    public i i(int i2) {
        if (i2 == 0) {
            return l.BEFORE_AH;
        }
        if (i2 == 1) {
            return l.AH;
        }
        throw new l.b.a.a("invalid Hijrah era");
    }

    @Override // l.b.a.t.h
    public String m() {
        return "islamic-umalqura";
    }

    @Override // l.b.a.t.h
    public String n() {
        return "Hijrah-umalqura";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.t.c<?>, l.b.a.t.c<l.b.a.t.k> */
    @Override // l.b.a.t.h
    public c<k> o(e eVar) {
        return super.o(eVar);
    }

    @Override // l.b.a.t.h
    public f<k> s(d dVar, p pVar) {
        return g.F(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.t.f<?>, l.b.a.t.f<l.b.a.t.k> */
    @Override // l.b.a.t.h
    public f<k> t(e eVar) {
        return super.t(eVar);
    }
}
