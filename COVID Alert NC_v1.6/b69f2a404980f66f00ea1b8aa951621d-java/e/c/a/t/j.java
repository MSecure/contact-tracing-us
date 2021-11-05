package e.c.a.t;

import e.c.a.d;
import e.c.a.p;
import e.c.a.w.a;
import e.c.a.w.e;
import java.io.Serializable;
import java.util.HashMap;

public final class j extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final j f5018d = new j();

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, String[]> f5019e = new HashMap<>();
    public static final HashMap<String, String[]> f = new HashMap<>();
    public static final HashMap<String, String[]> g = new HashMap<>();

    static {
        f5019e.put("en", new String[]{"BH", "HE"});
        f.put("en", new String[]{"B.H.", "H.E."});
        g.put("en", new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private Object readResolve() {
        return f5018d;
    }

    @Override // e.c.a.t.h
    public b d(int i, int i2, int i3) {
        return k.P(i, i2, i3);
    }

    @Override // e.c.a.t.h
    public b f(e eVar) {
        if (eVar instanceof k) {
            return (k) eVar;
        }
        return new k(eVar.l(a.EPOCH_DAY));
    }

    @Override // e.c.a.t.h
    public i l(int i) {
        if (i == 0) {
            return l.BEFORE_AH;
        }
        if (i == 1) {
            return l.AH;
        }
        throw new e.c.a.a("invalid Hijrah era");
    }

    @Override // e.c.a.t.h
    public String o() {
        return "islamic-umalqura";
    }

    @Override // e.c.a.t.h
    public String p() {
        return "Hijrah-umalqura";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: e.c.a.t.c<?>, e.c.a.t.c<e.c.a.t.k> */
    @Override // e.c.a.t.h
    public c<k> q(e eVar) {
        return super.q(eVar);
    }

    @Override // e.c.a.t.h
    public f<k> v(d dVar, p pVar) {
        return g.G(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: e.c.a.t.f<?>, e.c.a.t.f<e.c.a.t.k> */
    @Override // e.c.a.t.h
    public f<k> w(e eVar) {
        return super.w(eVar);
    }
}
