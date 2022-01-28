package e.c.a.t;

import e.c.a.d;
import e.c.a.e;
import e.c.a.p;
import e.c.a.w.a;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class o extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final Locale f5031d = new Locale("ja", "JP", "JP");

    /* renamed from: e  reason: collision with root package name */
    public static final o f5032e = new o();
    public static final Map<String, String[]> f = new HashMap();
    public static final Map<String, String[]> g = new HashMap();
    public static final Map<String, String[]> h = new HashMap();

    static {
        f.put("en", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        f.put("ja", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        g.put("en", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        g.put("ja", new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        h.put("en", new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        h.put("ja", new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private Object readResolve() {
        return f5032e;
    }

    @Override // e.c.a.t.h
    public b d(int i, int i2, int i3) {
        return new p(e.P(i, i2, i3));
    }

    @Override // e.c.a.t.h
    public b f(e.c.a.w.e eVar) {
        return eVar instanceof p ? (p) eVar : new p(e.F(eVar));
    }

    @Override // e.c.a.t.h
    public i l(int i) {
        return q.u(i);
    }

    @Override // e.c.a.t.h
    public String o() {
        return "japanese";
    }

    @Override // e.c.a.t.h
    public String p() {
        return "Japanese";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: e.c.a.t.c<?>, e.c.a.t.c<e.c.a.t.p> */
    @Override // e.c.a.t.h
    public c<p> q(e.c.a.w.e eVar) {
        return super.q(eVar);
    }

    @Override // e.c.a.t.h
    public f<p> v(d dVar, p pVar) {
        return g.G(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: e.c.a.t.f<?>, e.c.a.t.f<e.c.a.t.p> */
    @Override // e.c.a.t.h
    public f<p> w(e.c.a.w.e eVar) {
        return super.w(eVar);
    }

    public e.c.a.w.o x(a aVar) {
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
                    Calendar instance = Calendar.getInstance(f5031d);
                    int ordinal2 = aVar.ordinal();
                    int i = 0;
                    if (ordinal2 == 19) {
                        q[] w = q.w();
                        int i2 = 366;
                        while (i < w.length) {
                            i2 = Math.min(i2, ((w[i].f5039c.L() ? 366 : 365) - w[i].f5039c.I()) + 1);
                            i++;
                        }
                        return e.c.a.w.o.e(1, (long) i2, 366);
                    } else if (ordinal2 == 23) {
                        return e.c.a.w.o.f((long) (instance.getMinimum(2) + 1), (long) (instance.getGreatestMinimum(2) + 1), (long) (instance.getLeastMaximum(2) + 1), (long) (instance.getMaximum(2) + 1));
                    } else {
                        switch (ordinal2) {
                            case 25:
                                q[] w2 = q.w();
                                int i3 = (w2[w2.length - 1].s().f4970b - w2[w2.length - 1].f5039c.f4970b) + 1;
                                int i4 = Integer.MAX_VALUE;
                                while (i < w2.length) {
                                    i4 = Math.min(i4, (w2[i].s().f4970b - w2[i].f5039c.f4970b) + 1);
                                    i++;
                                }
                                return e.c.a.w.o.f(1, 6, (long) i4, (long) i3);
                            case 26:
                                q[] w3 = q.w();
                                return e.c.a.w.o.d((long) p.f5033e.f4970b, (long) w3[w3.length - 1].s().f4970b);
                            case 27:
                                q[] w4 = q.w();
                                return e.c.a.w.o.d((long) w4[0].f5038b, (long) w4[w4.length - 1].f5038b);
                            default:
                                throw new UnsupportedOperationException("Unimplementable field: " + aVar);
                        }
                    }
            }
        }
        return aVar.f5158c;
    }
}
