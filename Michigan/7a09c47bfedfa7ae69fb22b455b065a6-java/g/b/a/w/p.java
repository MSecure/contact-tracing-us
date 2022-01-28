package g.b.a.w;

import b.x.t;
import g.b.a.b;
import g.b.a.n;
import g.b.a.t.h;
import g.b.a.u.l;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class p implements Serializable {
    public static final ConcurrentMap<String, p> h = new ConcurrentHashMap(4, 0.75f, 2);

    /* renamed from: b  reason: collision with root package name */
    public final b f6667b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6668c;

    /* renamed from: d  reason: collision with root package name */
    public final transient j f6669d = new a("DayOfWeek", this, b.DAYS, b.WEEKS, a.f6673g);

    /* renamed from: e  reason: collision with root package name */
    public final transient j f6670e = new a("WeekOfMonth", this, b.WEEKS, b.MONTHS, a.h);

    /* renamed from: f  reason: collision with root package name */
    public final transient j f6671f;

    /* renamed from: g  reason: collision with root package name */
    public final transient j f6672g;

    public static class a implements j {

        /* renamed from: g  reason: collision with root package name */
        public static final o f6673g = o.d(1, 7);
        public static final o h = o.f(0, 1, 4, 6);
        public static final o i = o.f(0, 1, 52, 54);
        public static final o j = o.e(1, 52, 53);
        public static final o k = a.YEAR.f6633c;

        /* renamed from: b  reason: collision with root package name */
        public final String f6674b;

        /* renamed from: c  reason: collision with root package name */
        public final p f6675c;

        /* renamed from: d  reason: collision with root package name */
        public final m f6676d;

        /* renamed from: e  reason: collision with root package name */
        public final m f6677e;

        /* renamed from: f  reason: collision with root package name */
        public final o f6678f;

        public a(String str, p pVar, m mVar, m mVar2, o oVar) {
            this.f6674b = str;
            this.f6675c = pVar;
            this.f6676d = mVar;
            this.f6677e = mVar2;
            this.f6678f = oVar;
        }

        public final int a(int i2, int i3) {
            return ((i3 - 1) + (i2 + 7)) / 7;
        }

        @Override // g.b.a.w.j
        public boolean b() {
            return true;
        }

        public final int c(e eVar, int i2) {
            return t.u1(eVar.d(a.DAY_OF_WEEK) - i2, 7) + 1;
        }

        @Override // g.b.a.w.j
        public boolean d(e eVar) {
            a aVar;
            if (!eVar.k(a.DAY_OF_WEEK)) {
                return false;
            }
            m mVar = this.f6677e;
            if (mVar == b.WEEKS) {
                return true;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else if (mVar != c.f6643d && mVar != b.FOREVER) {
                return false;
            } else {
                aVar = a.EPOCH_DAY;
            }
            return eVar.k(aVar);
        }

        public final long e(e eVar, int i2) {
            int d2 = eVar.d(a.DAY_OF_YEAR);
            return (long) a(h(d2, i2), d2);
        }

        @Override // g.b.a.w.j
        public <R extends d> R f(R r, long j2) {
            long j3;
            int a2 = this.f6678f.a(j2, this);
            int d2 = r.d(this);
            if (a2 == d2) {
                return r;
            }
            if (this.f6677e != b.FOREVER) {
                return (R) r.s((long) (a2 - d2), this.f6676d);
            }
            int d3 = r.d(this.f6675c.f6671f);
            R r2 = (R) r.s((long) (((double) (j2 - ((long) d2))) * 52.1775d), b.WEEKS);
            if (r2.d(this) > a2) {
                j3 = (long) r2.d(this.f6675c.f6671f);
            } else {
                if (r2.d(this) < a2) {
                    r2 = (R) r2.s(2, b.WEEKS);
                }
                r2 = (R) r2.s((long) (d3 - r2.d(this.f6675c.f6671f)), b.WEEKS);
                if (r2.d(this) <= a2) {
                    return r2;
                }
                j3 = 1;
            }
            return (R) r2.m(j3, b.WEEKS);
        }

        public final o g(e eVar) {
            int u1 = t.u1(eVar.d(a.DAY_OF_WEEK) - this.f6675c.f6667b.p(), 7) + 1;
            long e2 = e(eVar, u1);
            if (e2 == 0) {
                return g(h.p(eVar).f(eVar).m(2, b.WEEKS));
            }
            int a2 = a(h(eVar.d(a.DAY_OF_YEAR), u1), (n.B((long) eVar.d(a.YEAR)) ? 366 : 365) + this.f6675c.f6668c);
            return e2 >= ((long) a2) ? g(h.p(eVar).f(eVar).s(2, b.WEEKS)) : o.d(1, (long) (a2 - 1));
        }

        public final int h(int i2, int i3) {
            int u1 = t.u1(i2 - i3, 7);
            return u1 + 1 > this.f6675c.f6668c ? 7 - u1 : -u1;
        }

        @Override // g.b.a.w.j
        public e i(Map<j, Long> map, e eVar, l lVar) {
            g.b.a.t.b bVar;
            Object obj;
            long j2;
            long j3;
            g.b.a.t.b bVar2;
            long j4;
            g.b.a.t.b bVar3;
            l lVar2 = l.STRICT;
            l lVar3 = l.LENIENT;
            int p = this.f6675c.f6667b.p();
            if (this.f6677e == b.WEEKS) {
                map.put(a.DAY_OF_WEEK, Long.valueOf((long) (t.u1((this.f6678f.a(map.remove(this).longValue(), this) - 1) + (p - 1), 7) + 1)));
                return null;
            } else if (!map.containsKey(a.DAY_OF_WEEK)) {
                return null;
            } else {
                if (this.f6677e == b.FOREVER) {
                    if (!map.containsKey(this.f6675c.f6671f)) {
                        return null;
                    }
                    h p2 = h.p(eVar);
                    a aVar = a.DAY_OF_WEEK;
                    int u1 = t.u1(aVar.r(map.get(aVar).longValue()) - p, 7) + 1;
                    int a2 = this.f6678f.a(map.get(this).longValue(), this);
                    if (lVar == lVar3) {
                        bVar3 = p2.d(a2, 1, this.f6675c.f6668c);
                        j4 = map.get(this.f6675c.f6671f).longValue();
                    } else {
                        bVar3 = p2.d(a2, 1, this.f6675c.f6668c);
                        j4 = (long) this.f6675c.f6671f.m().a(map.get(this.f6675c.f6671f).longValue(), this.f6675c.f6671f);
                    }
                    int c2 = c(bVar3, p);
                    bVar = bVar3.s(((j4 - e(bVar3, c2)) * 7) + ((long) (u1 - c2)), b.DAYS);
                    if (lVar != lVar2 || bVar.n(this) == map.get(this).longValue()) {
                        map.remove(this);
                        obj = this.f6675c.f6671f;
                    } else {
                        throw new g.b.a.a("Strict mode rejected date parsed to a different year");
                    }
                } else if (!map.containsKey(a.YEAR)) {
                    return null;
                } else {
                    a aVar2 = a.DAY_OF_WEEK;
                    int u12 = t.u1(aVar2.r(map.get(aVar2).longValue()) - p, 7) + 1;
                    a aVar3 = a.YEAR;
                    int r = aVar3.r(map.get(aVar3).longValue());
                    h p3 = h.p(eVar);
                    m mVar = this.f6677e;
                    if (mVar == b.MONTHS) {
                        if (!map.containsKey(a.MONTH_OF_YEAR)) {
                            return null;
                        }
                        long longValue = map.remove(this).longValue();
                        if (lVar == lVar3) {
                            bVar2 = p3.d(r, 1, 1).s(map.get(a.MONTH_OF_YEAR).longValue() - 1, b.MONTHS);
                            int c3 = c(bVar2, p);
                            int d2 = bVar2.d(a.DAY_OF_MONTH);
                            j3 = ((longValue - ((long) a(h(d2, c3), d2))) * 7) + ((long) (u12 - c3));
                        } else {
                            a aVar4 = a.MONTH_OF_YEAR;
                            bVar2 = p3.d(r, aVar4.r(map.get(aVar4).longValue()), 8);
                            int c4 = c(bVar2, p);
                            int d3 = bVar2.d(a.DAY_OF_MONTH);
                            j3 = ((((long) this.f6678f.a(longValue, this)) - ((long) a(h(d3, c4), d3))) * 7) + ((long) (u12 - c4));
                        }
                        bVar = bVar2.s(j3, b.DAYS);
                        if (lVar != lVar2 || bVar.n(a.MONTH_OF_YEAR) == map.get(a.MONTH_OF_YEAR).longValue()) {
                            map.remove(this);
                            map.remove(a.YEAR);
                            obj = a.MONTH_OF_YEAR;
                        } else {
                            throw new g.b.a.a("Strict mode rejected date parsed to a different month");
                        }
                    } else if (mVar == b.YEARS) {
                        long longValue2 = map.remove(this).longValue();
                        g.b.a.t.b d4 = p3.d(r, 1, 1);
                        if (lVar == lVar3) {
                            int c5 = c(d4, p);
                            j2 = ((longValue2 - e(d4, c5)) * 7) + ((long) (u12 - c5));
                        } else {
                            int c6 = c(d4, p);
                            j2 = ((((long) this.f6678f.a(longValue2, this)) - e(d4, c6)) * 7) + ((long) (u12 - c6));
                        }
                        bVar = d4.s(j2, b.DAYS);
                        if (lVar != lVar2 || bVar.n(a.YEAR) == map.get(a.YEAR).longValue()) {
                            map.remove(this);
                            obj = a.YEAR;
                        } else {
                            throw new g.b.a.a("Strict mode rejected date parsed to a different year");
                        }
                    } else {
                        throw new IllegalStateException("unreachable");
                    }
                }
                map.remove(obj);
                map.remove(a.DAY_OF_WEEK);
                return bVar;
            }
        }

        @Override // g.b.a.w.j
        public long k(e eVar) {
            a aVar;
            int i2;
            int u1 = t.u1(eVar.d(a.DAY_OF_WEEK) - this.f6675c.f6667b.p(), 7) + 1;
            m mVar = this.f6677e;
            if (mVar == b.WEEKS) {
                return (long) u1;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else {
                int i3 = 366;
                if (mVar == c.f6643d) {
                    int u12 = t.u1(eVar.d(a.DAY_OF_WEEK) - this.f6675c.f6667b.p(), 7) + 1;
                    long e2 = e(eVar, u12);
                    if (e2 == 0) {
                        i2 = ((int) e(h.p(eVar).f(eVar).m(1, b.WEEKS), u12)) + 1;
                    } else {
                        if (e2 >= 53) {
                            int h2 = h(eVar.d(a.DAY_OF_YEAR), u12);
                            if (!n.B((long) eVar.d(a.YEAR))) {
                                i3 = 365;
                            }
                            int a2 = a(h2, i3 + this.f6675c.f6668c);
                            if (e2 >= ((long) a2)) {
                                e2 -= (long) (a2 - 1);
                            }
                        }
                        i2 = (int) e2;
                    }
                    return (long) i2;
                } else if (mVar == b.FOREVER) {
                    int u13 = t.u1(eVar.d(a.DAY_OF_WEEK) - this.f6675c.f6667b.p(), 7) + 1;
                    int d2 = eVar.d(a.YEAR);
                    long e3 = e(eVar, u13);
                    if (e3 == 0) {
                        d2--;
                    } else if (e3 >= 53) {
                        int h3 = h(eVar.d(a.DAY_OF_YEAR), u13);
                        if (!n.B((long) d2)) {
                            i3 = 365;
                        }
                        if (e3 >= ((long) a(h3, i3 + this.f6675c.f6668c))) {
                            d2++;
                        }
                    }
                    return (long) d2;
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
            int d3 = eVar.d(aVar);
            return (long) a(h(d3, u1), d3);
        }

        @Override // g.b.a.w.j
        public o m() {
            return this.f6678f;
        }

        @Override // g.b.a.w.j
        public boolean n() {
            return false;
        }

        @Override // g.b.a.w.j
        public o p(e eVar) {
            a aVar;
            m mVar = this.f6677e;
            if (mVar == b.WEEKS) {
                return this.f6678f;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else if (mVar == c.f6643d) {
                return g(eVar);
            } else {
                if (mVar == b.FOREVER) {
                    return eVar.b(a.YEAR);
                }
                throw new IllegalStateException("unreachable");
            }
            int p = this.f6675c.f6667b.p();
            int h2 = h(eVar.d(aVar), t.u1(eVar.d(a.DAY_OF_WEEK) - p, 7) + 1);
            o b2 = eVar.b(aVar);
            return o.d((long) a(h2, (int) b2.f6663b), (long) a(h2, (int) b2.f6666e));
        }

        public String toString() {
            return this.f6674b + "[" + this.f6675c.toString() + "]";
        }
    }

    static {
        new p(b.MONDAY, 4);
        b(b.SUNDAY, 1);
    }

    public p(b bVar, int i) {
        b bVar2 = b.WEEKS;
        b bVar3 = b.YEARS;
        o oVar = a.i;
        this.f6671f = new a("WeekOfWeekBasedYear", this, b.WEEKS, c.f6643d, a.j);
        this.f6672g = new a("WeekBasedYear", this, c.f6643d, b.FOREVER, a.k);
        t.y2(bVar, "firstDayOfWeek");
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.f6667b = bVar;
        this.f6668c = i;
    }

    public static p a(Locale locale) {
        t.y2(locale, "locale");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry()));
        int firstDayOfWeek = gregorianCalendar.getFirstDayOfWeek();
        b bVar = b.SUNDAY;
        return b(b.i[((((int) (((long) (firstDayOfWeek - 1)) % 7)) + 7) + 6) % 7], gregorianCalendar.getMinimalDaysInFirstWeek());
    }

    public static p b(b bVar, int i) {
        String str = bVar.toString() + i;
        p pVar = h.get(str);
        if (pVar != null) {
            return pVar;
        }
        h.putIfAbsent(str, new p(bVar, i));
        return h.get(str);
    }

    private Object readResolve() {
        try {
            return b(this.f6667b, this.f6668c);
        } catch (IllegalArgumentException e2) {
            StringBuilder h2 = c.a.a.a.a.h("Invalid WeekFields");
            h2.append(e2.getMessage());
            throw new InvalidObjectException(h2.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return hashCode() == obj.hashCode();
        }
        return false;
    }

    public int hashCode() {
        return (this.f6667b.ordinal() * 7) + this.f6668c;
    }

    public String toString() {
        StringBuilder h2 = c.a.a.a.a.h("WeekFields[");
        h2.append(this.f6667b);
        h2.append(',');
        h2.append(this.f6668c);
        h2.append(']');
        return h2.toString();
    }
}
