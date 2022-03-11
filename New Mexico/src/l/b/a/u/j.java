package l.b.a.u;

import java.io.Serializable;
import java.util.HashMap;
import l.b.a.b;
import l.b.a.q;
import l.b.a.x.a;
import l.b.a.x.e;
/* loaded from: classes.dex */
public final class j extends h implements Serializable {

    /* renamed from: d */
    public static final j f4649d = new j();

    /* renamed from: e */
    public static final HashMap<String, String[]> f4650e;

    /* renamed from: f */
    public static final HashMap<String, String[]> f4651f;

    /* renamed from: g */
    public static final HashMap<String, String[]> f4652g;

    static {
        HashMap<String, String[]> hashMap = new HashMap<>();
        f4650e = hashMap;
        HashMap<String, String[]> hashMap2 = new HashMap<>();
        f4651f = hashMap2;
        HashMap<String, String[]> hashMap3 = new HashMap<>();
        f4652g = hashMap3;
        hashMap.put("en", new String[]{"BH", "HE"});
        hashMap2.put("en", new String[]{"B.H.", "H.E."});
        hashMap3.put("en", new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private Object readResolve() {
        return f4649d;
    }

    @Override // l.b.a.u.h
    public b b(int i2, int i3, int i4) {
        return k.N(i2, i3, i4);
    }

    @Override // l.b.a.u.h
    public b c(e eVar) {
        if (eVar instanceof k) {
            return (k) eVar;
        }
        return new k(eVar.i(a.EPOCH_DAY));
    }

    @Override // l.b.a.u.h
    public i i(int i2) {
        if (i2 == 0) {
            return l.BEFORE_AH;
        }
        if (i2 == 1) {
            return l.AH;
        }
        throw new b("invalid Hijrah era");
    }

    @Override // l.b.a.u.h
    public String m() {
        return "islamic-umalqura";
    }

    @Override // l.b.a.u.h
    public String n() {
        return "Hijrah-umalqura";
    }

    @Override // l.b.a.u.h
    public c<k> o(e eVar) {
        return super.o(eVar);
    }

    @Override // l.b.a.u.h
    public f<k> s(l.b.a.e eVar, q qVar) {
        return g.F(this, eVar, qVar);
    }

    @Override // l.b.a.u.h
    public f<k> t(e eVar) {
        return super.t(eVar);
    }
}
