package l.b.a.t;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import l.b.a.d;
import l.b.a.e;
import l.b.a.p;
import l.b.a.w.a;

public final class o extends h implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final Locale f4190d = new Locale("ja", "JP", "JP");

    /* renamed from: e  reason: collision with root package name */
    public static final o f4191e = new o();

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, String[]> f4192f;

    /* renamed from: g  reason: collision with root package name */
    public static final Map<String, String[]> f4193g;

    /* renamed from: h  reason: collision with root package name */
    public static final Map<String, String[]> f4194h;

    static {
        HashMap hashMap = new HashMap();
        f4192f = hashMap;
        HashMap hashMap2 = new HashMap();
        f4193g = hashMap2;
        HashMap hashMap3 = new HashMap();
        f4194h = hashMap3;
        hashMap.put("en", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        hashMap.put("ja", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        hashMap2.put("en", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        hashMap2.put("ja", new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        hashMap3.put("en", new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        hashMap3.put("ja", new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private Object readResolve() {
        return f4191e;
    }

    @Override // l.b.a.t.h
    public b b(int i2, int i3, int i4) {
        return new p(e.P(i2, i3, i4));
    }

    @Override // l.b.a.t.h
    public b c(l.b.a.w.e eVar) {
        return eVar instanceof p ? (p) eVar : new p(e.E(eVar));
    }

    @Override // l.b.a.t.h
    public i i(int i2) {
        return q.s(i2);
    }

    @Override // l.b.a.t.h
    public String m() {
        return "japanese";
    }

    @Override // l.b.a.t.h
    public String n() {
        return "Japanese";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.t.c<?>, l.b.a.t.c<l.b.a.t.p> */
    @Override // l.b.a.t.h
    public c<p> o(l.b.a.w.e eVar) {
        return super.o(eVar);
    }

    @Override // l.b.a.t.h
    public f<p> s(d dVar, p pVar) {
        return g.F(this, dVar, pVar);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: l.b.a.t.f<?>, l.b.a.t.f<l.b.a.t.p> */
    @Override // l.b.a.t.h
    public f<p> t(l.b.a.w.e eVar) {
        return super.t(eVar);
    }

    public l.b.a.w.o u(a aVar) {
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
                    Calendar instance = Calendar.getInstance(f4190d);
                    int ordinal2 = aVar.ordinal();
                    int i2 = 0;
                    if (ordinal2 == 19) {
                        q[] t = q.t();
                        int i3 = 366;
                        while (i2 < t.length) {
                            i3 = Math.min(i3, ((t[i2].c.K() ? 366 : 365) - t[i2].c.H()) + 1);
                            i2++;
                        }
                        return l.b.a.w.o.e(1, (long) i3, 366);
                    } else if (ordinal2 == 23) {
                        return l.b.a.w.o.f((long) (instance.getMinimum(2) + 1), (long) (instance.getGreatestMinimum(2) + 1), (long) (instance.getLeastMaximum(2) + 1), (long) (instance.getMaximum(2) + 1));
                    } else {
                        switch (ordinal2) {
                            case 25:
                                q[] t2 = q.t();
                                int i4 = (t2[t2.length - 1].q().b - t2[t2.length - 1].c.b) + 1;
                                int i5 = Integer.MAX_VALUE;
                                while (i2 < t2.length) {
                                    i5 = Math.min(i5, (t2[i2].q().b - t2[i2].c.b) + 1);
                                    i2++;
                                }
                                return l.b.a.w.o.f(1, 6, (long) i5, (long) i4);
                            case 26:
                                q[] t3 = q.t();
                                return l.b.a.w.o.d((long) p.f4195e.b, (long) t3[t3.length - 1].q().b);
                            case 27:
                                q[] t4 = q.t();
                                return l.b.a.w.o.d((long) t4[0].b, (long) t4[t4.length - 1].b);
                            default:
                                throw new UnsupportedOperationException("Unimplementable field: " + aVar);
                        }
                    }
            }
        }
        return aVar.f4286e;
    }
}
