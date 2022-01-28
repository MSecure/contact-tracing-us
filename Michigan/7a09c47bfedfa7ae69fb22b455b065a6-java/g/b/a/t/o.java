package g.b.a.t;

import g.b.a.d;
import g.b.a.p;
import g.b.a.w.a;
import g.b.a.w.e;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class o extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final Locale f6480d = new Locale("ja", "JP", "JP");

    /* renamed from: e  reason: collision with root package name */
    public static final o f6481e = new o();

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, String[]> f6482f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public static final Map<String, String[]> f6483g = new HashMap();
    public static final Map<String, String[]> h = new HashMap();

    static {
        f6482f.put("en", new String[]{"Unknown", "K", "M", "T", "S", BuildConfig.DOWNLOAD_SCHEDULE_UNIT});
        f6482f.put("ja", new String[]{"Unknown", "K", "M", "T", "S", BuildConfig.DOWNLOAD_SCHEDULE_UNIT});
        f6483g.put("en", new String[]{"Unknown", "K", "M", "T", "S", BuildConfig.DOWNLOAD_SCHEDULE_UNIT});
        f6483g.put("ja", new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        h.put("en", new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        h.put("ja", new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private Object readResolve() {
        return f6481e;
    }

    @Override // g.b.a.t.h
    public f<p> B(d dVar, p pVar) {
        return g.W(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: g.b.a.t.f<?>, g.b.a.t.f<g.b.a.t.p> */
    @Override // g.b.a.t.h
    public f<p> D(e eVar) {
        return super.D(eVar);
    }

    public g.b.a.w.o F(a aVar) {
        int ordinal = aVar.ordinal();
        if (!(ordinal == 15 || ordinal == 18 || ordinal == 20 || ordinal == 24)) {
            switch (ordinal) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    Calendar instance = Calendar.getInstance(f6480d);
                    int ordinal2 = aVar.ordinal();
                    int i = 0;
                    if (ordinal2 == 19) {
                        q[] G = q.G();
                        int i2 = 366;
                        while (i < G.length) {
                            i2 = Math.min(i2, ((G[i].f6492c.b0() ? 366 : 365) - G[i].f6492c.Y()) + 1);
                            i++;
                        }
                        return g.b.a.w.o.e(1, (long) i2, 366);
                    } else if (ordinal2 == 23) {
                        return g.b.a.w.o.f((long) (instance.getMinimum(2) + 1), (long) (instance.getGreatestMinimum(2) + 1), (long) (instance.getLeastMaximum(2) + 1), (long) (instance.getMaximum(2) + 1));
                    } else {
                        switch (ordinal2) {
                            case 25:
                                q[] G2 = q.G();
                                int i3 = (G2[G2.length - 1].A().f6409b - G2[G2.length - 1].f6492c.f6409b) + 1;
                                int i4 = Integer.MAX_VALUE;
                                while (i < G2.length) {
                                    i4 = Math.min(i4, (G2[i].A().f6409b - G2[i].f6492c.f6409b) + 1);
                                    i++;
                                }
                                return g.b.a.w.o.f(1, 6, (long) i4, (long) i3);
                            case 26:
                                q[] G3 = q.G();
                                return g.b.a.w.o.d((long) p.f6484e.f6409b, (long) G3[G3.length - 1].A().f6409b);
                            case 27:
                                q[] G4 = q.G();
                                return g.b.a.w.o.d((long) G4[0].f6491b, (long) G4[G4.length - 1].f6491b);
                            default:
                                throw new UnsupportedOperationException("Unimplementable field: " + aVar);
                        }
                    }
            }
        }
        return aVar.f6633c;
    }

    @Override // g.b.a.t.h
    public b d(int i, int i2, int i3) {
        return new p(g.b.a.e.f0(i, i2, i3));
    }

    @Override // g.b.a.t.h
    public b f(e eVar) {
        return eVar instanceof p ? (p) eVar : new p(g.b.a.e.V(eVar));
    }

    @Override // g.b.a.t.h
    public i n(int i) {
        return q.D(i);
    }

    @Override // g.b.a.t.h
    public String r() {
        return "japanese";
    }

    @Override // g.b.a.t.h
    public String s() {
        return "Japanese";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: g.b.a.t.c<?>, g.b.a.t.c<g.b.a.t.p> */
    @Override // g.b.a.t.h
    public c<p> t(e eVar) {
        return super.t(eVar);
    }
}
