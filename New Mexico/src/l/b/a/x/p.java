package l.b.a.x;

import g.b.a.c.c.d;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import l.b.a.c;
import l.b.a.o;
import l.b.a.u.b;
import l.b.a.u.h;
import l.b.a.v.l;
/* loaded from: classes.dex */
public final class p implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final ConcurrentMap<String, p> f4783h = new ConcurrentHashMap(4, 0.75f, 2);
    public final c b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final transient j f4784d;

    /* renamed from: e  reason: collision with root package name */
    public final transient j f4785e;

    /* renamed from: f  reason: collision with root package name */
    public final transient j f4786f;

    /* renamed from: g  reason: collision with root package name */
    public final transient j f4787g;

    /* loaded from: classes.dex */
    public static class a implements j {

        /* renamed from: g  reason: collision with root package name */
        public static final o f4788g = o.d(1, 7);

        /* renamed from: h  reason: collision with root package name */
        public static final o f4789h = o.f(0, 1, 4, 6);

        /* renamed from: i  reason: collision with root package name */
        public static final o f4790i = o.f(0, 1, 52, 54);

        /* renamed from: j  reason: collision with root package name */
        public static final o f4791j = o.e(1, 52, 53);

        /* renamed from: k  reason: collision with root package name */
        public static final o f4792k = a.YEAR.f4761e;
        public final String b;
        public final p c;

        /* renamed from: d  reason: collision with root package name */
        public final m f4793d;

        /* renamed from: e  reason: collision with root package name */
        public final m f4794e;

        /* renamed from: f  reason: collision with root package name */
        public final o f4795f;

        public a(String str, p pVar, m mVar, m mVar2, o oVar) {
            this.b = str;
            this.c = pVar;
            this.f4793d = mVar;
            this.f4794e = mVar2;
            this.f4795f = oVar;
        }

        @Override // l.b.a.x.j
        public boolean a() {
            return true;
        }

        @Override // l.b.a.x.j
        public boolean b(e eVar) {
            a aVar;
            if (!eVar.f(a.DAY_OF_WEEK)) {
                return false;
            }
            m mVar = this.f4794e;
            if (mVar == b.WEEKS) {
                return true;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else if (mVar != c.a && mVar != b.FOREVER) {
                return false;
            } else {
                aVar = a.EPOCH_DAY;
            }
            return eVar.f(aVar);
        }

        @Override // l.b.a.x.j
        public <R extends d> R c(R r, long j2) {
            long j3;
            int a = this.f4795f.a(j2, this);
            int b = r.b(this);
            if (a == b) {
                return r;
            }
            if (this.f4794e != b.FOREVER) {
                return (R) r.m((long) (a - b), this.f4793d);
            }
            int b2 = r.b(this.c.f4786f);
            b bVar = b.WEEKS;
            R r2 = (R) r.m((long) (((double) (j2 - ((long) b))) * 52.1775d), bVar);
            if (r2.b(this) > a) {
                j3 = (long) r2.b(this.c.f4786f);
            } else {
                if (r2.b(this) < a) {
                    r2 = (R) r2.m(2, bVar);
                }
                r2 = (R) r2.m((long) (b2 - r2.b(this.c.f4786f)), bVar);
                if (r2.b(this) <= a) {
                    return r2;
                }
                j3 = 1;
            }
            return (R) r2.h(j3, bVar);
        }

        public final int d(int i2, int i3) {
            return ((i3 - 1) + (i2 + 7)) / 7;
        }

        @Override // l.b.a.x.j
        public e e(Map<j, Long> map, e eVar, l lVar) {
            b bVar;
            int i2;
            int i3;
            b bVar2;
            long j2;
            b bVar3;
            l lVar2 = l.STRICT;
            l lVar3 = l.LENIENT;
            int q = this.c.b.q();
            if (this.f4794e == b.WEEKS) {
                map.put(a.DAY_OF_WEEK, Long.valueOf((long) (d.j((this.f4795f.a(map.remove(this).longValue(), this) - 1) + (q - 1), 7) + 1)));
                return null;
            }
            a aVar = a.DAY_OF_WEEK;
            if (!map.containsKey(aVar)) {
                return null;
            }
            if (this.f4794e != b.FOREVER) {
                a aVar2 = a.YEAR;
                if (!map.containsKey(aVar2)) {
                    return null;
                }
                int j3 = d.j(aVar.m(map.get(aVar).longValue()) - q, 7) + 1;
                int m = aVar2.m(map.get(aVar2).longValue());
                h l2 = h.l(eVar);
                m mVar = this.f4794e;
                b bVar4 = b.MONTHS;
                if (mVar == bVar4) {
                    a aVar3 = a.MONTH_OF_YEAR;
                    if (!map.containsKey(aVar3)) {
                        return null;
                    }
                    long longValue = map.remove(this).longValue();
                    if (lVar == lVar3) {
                        bVar2 = l2.b(m, 1, 1).m(map.get(aVar3).longValue() - 1, bVar4);
                        i3 = g(bVar2, q);
                    } else {
                        bVar2 = l2.b(m, aVar3.m(map.get(aVar3).longValue()), 8);
                        i3 = g(bVar2, q);
                        longValue = (long) this.f4795f.a(longValue, this);
                    }
                    int b = bVar2.b(a.DAY_OF_MONTH);
                    bVar = bVar2.m(((longValue - ((long) d(m(b, i3), b))) * 7) + ((long) (j3 - i3)), b.DAYS);
                    if (lVar != lVar2 || bVar.i(aVar3) == map.get(aVar3).longValue()) {
                        map.remove(this);
                        map.remove(aVar2);
                        map.remove(aVar3);
                    } else {
                        throw new l.b.a.b("Strict mode rejected date parsed to a different month");
                    }
                } else if (mVar == b.YEARS) {
                    long longValue2 = map.remove(this).longValue();
                    b b2 = l2.b(m, 1, 1);
                    if (lVar == lVar3) {
                        i2 = g(b2, q);
                    } else {
                        i2 = g(b2, q);
                        longValue2 = (long) this.f4795f.a(longValue2, this);
                    }
                    bVar = b2.m(((longValue2 - j(b2, i2)) * 7) + ((long) (j3 - i2)), b.DAYS);
                    if (lVar != lVar2 || bVar.i(aVar2) == map.get(aVar2).longValue()) {
                        map.remove(this);
                        map.remove(aVar2);
                    } else {
                        throw new l.b.a.b("Strict mode rejected date parsed to a different year");
                    }
                } else {
                    throw new IllegalStateException("unreachable");
                }
            } else if (!map.containsKey(this.c.f4786f)) {
                return null;
            } else {
                h l3 = h.l(eVar);
                int j4 = d.j(aVar.m(map.get(aVar).longValue()) - q, 7) + 1;
                int a = this.f4795f.a(map.get(this).longValue(), this);
                if (lVar == lVar3) {
                    bVar3 = l3.b(a, 1, this.c.c);
                    j2 = map.get(this.c.f4786f).longValue();
                } else {
                    bVar3 = l3.b(a, 1, this.c.c);
                    j2 = (long) this.c.f4786f.h().a(map.get(this.c.f4786f).longValue(), this.c.f4786f);
                }
                int g2 = g(bVar3, q);
                bVar = bVar3.m(((j2 - j(bVar3, g2)) * 7) + ((long) (j4 - g2)), b.DAYS);
                if (lVar != lVar2 || bVar.i(this) == map.get(this).longValue()) {
                    map.remove(this);
                    map.remove(this.c.f4786f);
                } else {
                    throw new l.b.a.b("Strict mode rejected date parsed to a different year");
                }
            }
            map.remove(aVar);
            return bVar;
        }

        @Override // l.b.a.x.j
        public long f(e eVar) {
            a aVar;
            int i2;
            int q = this.c.b.q();
            a aVar2 = a.DAY_OF_WEEK;
            int j2 = d.j(eVar.b(aVar2) - q, 7) + 1;
            m mVar = this.f4794e;
            b bVar = b.WEEKS;
            if (mVar == bVar) {
                return (long) j2;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else {
                int i3 = 366;
                if (mVar == c.a) {
                    int j3 = d.j(eVar.b(aVar2) - this.c.b.q(), 7) + 1;
                    long j4 = j(eVar, j3);
                    if (j4 == 0) {
                        i2 = ((int) j(h.l(eVar).c(eVar).h(1, bVar), j3)) + 1;
                    } else {
                        if (j4 >= 53) {
                            int m = m(eVar.b(a.DAY_OF_YEAR), j3);
                            if (!o.r((long) eVar.b(a.YEAR))) {
                                i3 = 365;
                            }
                            int d2 = d(m, i3 + this.c.c);
                            if (j4 >= ((long) d2)) {
                                j4 -= (long) (d2 - 1);
                            }
                        }
                        i2 = (int) j4;
                    }
                    return (long) i2;
                } else if (mVar == b.FOREVER) {
                    int j5 = d.j(eVar.b(aVar2) - this.c.b.q(), 7) + 1;
                    int b = eVar.b(a.YEAR);
                    long j6 = j(eVar, j5);
                    if (j6 == 0) {
                        b--;
                    } else if (j6 >= 53) {
                        int m2 = m(eVar.b(a.DAY_OF_YEAR), j5);
                        if (!o.r((long) b)) {
                            i3 = 365;
                        }
                        if (j6 >= ((long) d(m2, i3 + this.c.c))) {
                            b++;
                        }
                    }
                    return (long) b;
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
            int b2 = eVar.b(aVar);
            return (long) d(m(b2, j2), b2);
        }

        public final int g(e eVar, int i2) {
            return d.j(eVar.b(a.DAY_OF_WEEK) - i2, 7) + 1;
        }

        @Override // l.b.a.x.j
        public o h() {
            return this.f4795f;
        }

        @Override // l.b.a.x.j
        public boolean i() {
            return false;
        }

        public final long j(e eVar, int i2) {
            int b = eVar.b(a.DAY_OF_YEAR);
            return (long) d(m(b, i2), b);
        }

        public final o k(e eVar) {
            int j2 = d.j(eVar.b(a.DAY_OF_WEEK) - this.c.b.q(), 7) + 1;
            long j3 = j(eVar, j2);
            if (j3 == 0) {
                return k(h.l(eVar).c(eVar).h(2, b.WEEKS));
            }
            int d2 = d(m(eVar.b(a.DAY_OF_YEAR), j2), (o.r((long) eVar.b(a.YEAR)) ? 366 : 365) + this.c.c);
            return j3 >= ((long) d2) ? k(h.l(eVar).c(eVar).m(2, b.WEEKS)) : o.d(1, (long) (d2 - 1));
        }

        @Override // l.b.a.x.j
        public o l(e eVar) {
            a aVar;
            m mVar = this.f4794e;
            if (mVar == b.WEEKS) {
                return this.f4795f;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else if (mVar == c.a) {
                return k(eVar);
            } else {
                if (mVar == b.FOREVER) {
                    return eVar.a(a.YEAR);
                }
                throw new IllegalStateException("unreachable");
            }
            int q = this.c.b.q();
            int m = m(eVar.b(aVar), d.j(eVar.b(a.DAY_OF_WEEK) - q, 7) + 1);
            o a = eVar.a(aVar);
            return o.d((long) d(m, (int) a.b), (long) d(m, (int) a.f4782e));
        }

        public final int m(int i2, int i3) {
            int j2 = d.j(i2 - i3, 7);
            return j2 + 1 > this.c.c ? 7 - j2 : -j2;
        }

        public String toString() {
            return this.b + "[" + this.c.toString() + "]";
        }
    }

    static {
        new p(c.MONDAY, 4);
        b(c.SUNDAY, 1);
    }

    public p(c cVar, int i2) {
        b bVar = b.DAYS;
        b bVar2 = b.WEEKS;
        this.f4784d = new a("DayOfWeek", this, bVar, bVar2, a.f4788g);
        this.f4785e = new a("WeekOfMonth", this, bVar2, b.MONTHS, a.f4789h);
        b bVar3 = b.YEARS;
        o oVar = a.f4790i;
        m mVar = c.a;
        this.f4786f = new a("WeekOfWeekBasedYear", this, bVar2, mVar, a.f4791j);
        this.f4787g = new a("WeekBasedYear", this, mVar, b.FOREVER, a.f4792k);
        d.u(cVar, "firstDayOfWeek");
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.b = cVar;
        this.c = i2;
    }

    public static p a(Locale locale) {
        d.u(locale, "locale");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry()));
        int firstDayOfWeek = gregorianCalendar.getFirstDayOfWeek();
        c cVar = c.SUNDAY;
        return b(c.f4608i[((((int) (((long) (firstDayOfWeek - 1)) % 7)) + 7) + 6) % 7], gregorianCalendar.getMinimalDaysInFirstWeek());
    }

    public static p b(c cVar, int i2) {
        String str = cVar.toString() + i2;
        ConcurrentMap<String, p> concurrentMap = f4783h;
        p pVar = concurrentMap.get(str);
        if (pVar != null) {
            return pVar;
        }
        concurrentMap.putIfAbsent(str, new p(cVar, i2));
        return concurrentMap.get(str);
    }

    private Object readResolve() {
        try {
            return b(this.b, this.c);
        } catch (IllegalArgumentException e2) {
            StringBuilder h2 = f.a.a.a.a.h("Invalid WeekFields");
            h2.append(e2.getMessage());
            throw new InvalidObjectException(h2.toString());
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && hashCode() == obj.hashCode();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.b.ordinal() * 7) + this.c;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("WeekFields[");
        h2.append(this.b);
        h2.append(',');
        h2.append(this.c);
        h2.append(']');
        return h2.toString();
    }
}
