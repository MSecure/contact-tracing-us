package g.b.a.t;

import g.b.a.d;
import g.b.a.p;
import g.b.a.w.a;
import g.b.a.w.e;
import java.io.Serializable;
import java.util.HashMap;

public final class j extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final j f6463d = new j();

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, String[]> f6464e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, String[]> f6465f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, String[]> f6466g = new HashMap<>();

    static {
        f6464e.put("en", new String[]{"BH", "HE"});
        f6465f.put("en", new String[]{"B.H.", "H.E."});
        f6466g.put("en", new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private Object readResolve() {
        return f6463d;
    }

    @Override // g.b.a.t.h
    public f<k> B(d dVar, p pVar) {
        return g.W(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: g.b.a.t.f<?>, g.b.a.t.f<g.b.a.t.k> */
    @Override // g.b.a.t.h
    public f<k> D(e eVar) {
        return super.D(eVar);
    }

    @Override // g.b.a.t.h
    public b d(int i, int i2, int i3) {
        return k.f0(i, i2, i3);
    }

    @Override // g.b.a.t.h
    public b f(e eVar) {
        if (eVar instanceof k) {
            return (k) eVar;
        }
        return new k(eVar.n(a.EPOCH_DAY));
    }

    @Override // g.b.a.t.h
    public i n(int i) {
        if (i == 0) {
            return l.BEFORE_AH;
        }
        if (i == 1) {
            return l.AH;
        }
        throw new g.b.a.a("invalid Hijrah era");
    }

    @Override // g.b.a.t.h
    public String r() {
        return "islamic-umalqura";
    }

    @Override // g.b.a.t.h
    public String s() {
        return "Hijrah-umalqura";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: g.b.a.t.c<?>, g.b.a.t.c<g.b.a.t.k> */
    @Override // g.b.a.t.h
    public c<k> t(e eVar) {
        return super.t(eVar);
    }
}
