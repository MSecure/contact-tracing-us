package l.b.a.w;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import l.b.a.b;
import l.b.a.n;
import l.b.a.t.h;
import l.b.a.u.l;

public final class p implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final ConcurrentMap<String, p> f4204h = new ConcurrentHashMap(4, 0.75f, 2);
    public final b b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final transient j f4205d;

    /* renamed from: e  reason: collision with root package name */
    public final transient j f4206e;

    /* renamed from: f  reason: collision with root package name */
    public final transient j f4207f;

    /* renamed from: g  reason: collision with root package name */
    public final transient j f4208g;

    public static class a implements j {

        /* renamed from: g  reason: collision with root package name */
        public static final o f4209g = o.d(1, 7);

        /* renamed from: h  reason: collision with root package name */
        public static final o f4210h = o.f(0, 1, 4, 6);

        /* renamed from: i  reason: collision with root package name */
        public static final o f4211i = o.f(0, 1, 52, 54);

        /* renamed from: j  reason: collision with root package name */
        public static final o f4212j = o.e(1, 52, 53);

        /* renamed from: k  reason: collision with root package name */
        public static final o f4213k = a.YEAR.f4182e;
        public final String b;
        public final p c;

        /* renamed from: d  reason: collision with root package name */
        public final m f4214d;

        /* renamed from: e  reason: collision with root package name */
        public final m f4215e;

        /* renamed from: f  reason: collision with root package name */
        public final o f4216f;

        public a(String str, p pVar, m mVar, m mVar2, o oVar) {
            this.b = str;
            this.c = pVar;
            this.f4214d = mVar;
            this.f4215e = mVar2;
            this.f4216f = oVar;
        }

        @Override // l.b.a.w.j
        public boolean a() {
            return true;
        }

        @Override // l.b.a.w.j
        public boolean b(e eVar) {
            a aVar;
            if (!eVar.f(a.DAY_OF_WEEK)) {
                return false;
            }
            m mVar = this.f4215e;
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

        @Override // l.b.a.w.j
        public <R extends d> R c(R r, long j2) {
            long j3;
            int a = this.f4216f.a(j2, this);
            int b2 = r.b(this);
            if (a == b2) {
                return r;
            }
            if (this.f4215e != b.FOREVER) {
                return (R) r.m((long) (a - b2), this.f4214d);
            }
            int b3 = r.b(this.c.f4207f);
            b bVar = b.WEEKS;
            R r2 = (R) r.m((long) (((double) (j2 - ((long) b2))) * 52.1775d), bVar);
            if (r2.b(this) > a) {
                j3 = (long) r2.b(this.c.f4207f);
            } else {
                if (r2.b(this) < a) {
                    r2 = (R) r2.m(2, bVar);
                }
                r2 = (R) r2.m((long) (b3 - r2.b(this.c.f4207f)), bVar);
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

        @Override // l.b.a.w.j
        public e e(Map<j, Long> map, e eVar, l lVar) {
            l.b.a.t.b bVar;
            int i2;
            int i3;
            l.b.a.t.b bVar2;
            long j2;
            l.b.a.t.b bVar3;
            l lVar2 = l.STRICT;
            l lVar3 = l.LENIENT;
            int q = this.c.b.q();
            if (this.f4215e == b.WEEKS) {
                map.put(a.DAY_OF_WEEK, Long.valueOf((long) (f.b.a.c.b.o.b.E0((this.f4216f.a(map.remove(this).longValue(), this) - 1) + (q - 1), 7) + 1)));
                return null;
            }
            a aVar = a.DAY_OF_WEEK;
            if (!map.containsKey(aVar)) {
                return null;
            }
            if (this.f4215e != b.FOREVER) {
                a aVar2 = a.YEAR;
                if (!map.containsKey(aVar2)) {
                    return null;
                }
                int E0 = f.b.a.c.b.o.b.E0(aVar.m(map.get(aVar).longValue()) - q, 7) + 1;
                int m = aVar2.m(map.get(aVar2).longValue());
                h l2 = h.l(eVar);
                m mVar = this.f4215e;
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
                        longValue = (long) this.f4216f.a(longValue, this);
                    }
                    int b2 = bVar2.b(a.DAY_OF_MONTH);
                    bVar = bVar2.m(((longValue - ((long) d(m(b2, i3), b2))) * 7) + ((long) (E0 - i3)), b.DAYS);
                    if (lVar != lVar2 || bVar.i(aVar3) == map.get(aVar3).longValue()) {
                        map.remove(this);
                        map.remove(aVar2);
                        map.remove(aVar3);
                    } else {
                        throw new l.b.a.a("Strict mode rejected date parsed to a different month");
                    }
                } else if (mVar == b.YEARS) {
                    long longValue2 = map.remove(this).longValue();
                    l.b.a.t.b b3 = l2.b(m, 1, 1);
                    if (lVar == lVar3) {
                        i2 = g(b3, q);
                    } else {
                        i2 = g(b3, q);
                        longValue2 = (long) this.f4216f.a(longValue2, this);
                    }
                    bVar = b3.m(((longValue2 - j(b3, i2)) * 7) + ((long) (E0 - i2)), b.DAYS);
                    if (lVar != lVar2 || bVar.i(aVar2) == map.get(aVar2).longValue()) {
                        map.remove(this);
                        map.remove(aVar2);
                    } else {
                        throw new l.b.a.a("Strict mode rejected date parsed to a different year");
                    }
                } else {
                    throw new IllegalStateException("unreachable");
                }
            } else if (!map.containsKey(this.c.f4207f)) {
                return null;
            } else {
                h l3 = h.l(eVar);
                int E02 = f.b.a.c.b.o.b.E0(aVar.m(map.get(aVar).longValue()) - q, 7) + 1;
                int a = this.f4216f.a(map.get(this).longValue(), this);
                if (lVar == lVar3) {
                    bVar3 = l3.b(a, 1, this.c.c);
                    j2 = map.get(this.c.f4207f).longValue();
                } else {
                    bVar3 = l3.b(a, 1, this.c.c);
                    j2 = (long) this.c.f4207f.h().a(map.get(this.c.f4207f).longValue(), this.c.f4207f);
                }
                int g2 = g(bVar3, q);
                bVar = bVar3.m(((j2 - j(bVar3, g2)) * 7) + ((long) (E02 - g2)), b.DAYS);
                if (lVar != lVar2 || bVar.i(this) == map.get(this).longValue()) {
                    map.remove(this);
                    map.remove(this.c.f4207f);
                } else {
                    throw new l.b.a.a("Strict mode rejected date parsed to a different year");
                }
            }
            map.remove(aVar);
            return bVar;
        }

        @Override // l.b.a.w.j
        public long f(e eVar) {
            a aVar;
            int i2;
            int q = this.c.b.q();
            a aVar2 = a.DAY_OF_WEEK;
            int E0 = f.b.a.c.b.o.b.E0(eVar.b(aVar2) - q, 7) + 1;
            m mVar = this.f4215e;
            b bVar = b.WEEKS;
            if (mVar == bVar) {
                return (long) E0;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else {
                int i3 = 366;
                if (mVar == c.a) {
                    int E02 = f.b.a.c.b.o.b.E0(eVar.b(aVar2) - this.c.b.q(), 7) + 1;
                    long j2 = j(eVar, E02);
                    if (j2 == 0) {
                        i2 = ((int) j(h.l(eVar).c(eVar).h(1, bVar), E02)) + 1;
                    } else {
                        if (j2 >= 53) {
                            int m = m(eVar.b(a.DAY_OF_YEAR), E02);
                            if (!n.r((long) eVar.b(a.YEAR))) {
                                i3 = 365;
                            }
                            int d2 = d(m, i3 + this.c.c);
                            if (j2 >= ((long) d2)) {
                                j2 -= (long) (d2 - 1);
                            }
                        }
                        i2 = (int) j2;
                    }
                    return (long) i2;
                } else if (mVar == b.FOREVER) {
                    int E03 = f.b.a.c.b.o.b.E0(eVar.b(aVar2) - this.c.b.q(), 7) + 1;
                    int b2 = eVar.b(a.YEAR);
                    long j3 = j(eVar, E03);
                    if (j3 == 0) {
                        b2--;
                    } else if (j3 >= 53) {
                        int m2 = m(eVar.b(a.DAY_OF_YEAR), E03);
                        if (!n.r((long) b2)) {
                            i3 = 365;
                        }
                        if (j3 >= ((long) d(m2, i3 + this.c.c))) {
                            b2++;
                        }
                    }
                    return (long) b2;
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
            int b3 = eVar.b(aVar);
            return (long) d(m(b3, E0), b3);
        }

        public final int g(e eVar, int i2) {
            return f.b.a.c.b.o.b.E0(eVar.b(a.DAY_OF_WEEK) - i2, 7) + 1;
        }

        @Override // l.b.a.w.j
        public o h() {
            return this.f4216f;
        }

        @Override // l.b.a.w.j
        public boolean i() {
            return false;
        }

        public final long j(e eVar, int i2) {
            int b2 = eVar.b(a.DAY_OF_YEAR);
            return (long) d(m(b2, i2), b2);
        }

        public final o k(e eVar) {
            int E0 = f.b.a.c.b.o.b.E0(eVar.b(a.DAY_OF_WEEK) - this.c.b.q(), 7) + 1;
            long j2 = j(eVar, E0);
            if (j2 == 0) {
                return k(h.l(eVar).c(eVar).h(2, b.WEEKS));
            }
            int d2 = d(m(eVar.b(a.DAY_OF_YEAR), E0), (n.r((long) eVar.b(a.YEAR)) ? 366 : 365) + this.c.c);
            return j2 >= ((long) d2) ? k(h.l(eVar).c(eVar).m(2, b.WEEKS)) : o.d(1, (long) (d2 - 1));
        }

        @Override // l.b.a.w.j
        public o l(e eVar) {
            a aVar;
            m mVar = this.f4215e;
            if (mVar == b.WEEKS) {
                return this.f4216f;
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
            int m = m(eVar.b(aVar), f.b.a.c.b.o.b.E0(eVar.b(a.DAY_OF_WEEK) - q, 7) + 1);
            o a = eVar.a(aVar);
            return o.d((long) d(m, (int) a.b), (long) d(m, (int) a.f4203e));
        }

        public final int m(int i2, int i3) {
            int E0 = f.b.a.c.b.o.b.E0(i2 - i3, 7);
            return E0 + 1 > this.c.c ? 7 - E0 : -E0;
        }

        public String toString() {
            return this.b + "[" + this.c.toString() + "]";
        }
    }

    static {
        new p(b.MONDAY, 4);
        b(b.SUNDAY, 1);
    }

    public p(b bVar, int i2) {
        b bVar2 = b.DAYS;
        b bVar3 = b.WEEKS;
        this.f4205d = new a("DayOfWeek", this, bVar2, bVar3, a.f4209g);
        this.f4206e = new a("WeekOfMonth", this, bVar3, b.MONTHS, a.f4210h);
        b bVar4 = b.YEARS;
        o oVar = a.f4211i;
        m mVar = c.a;
        this.f4207f = new a("WeekOfWeekBasedYear", this, bVar3, mVar, a.f4212j);
        this.f4208g = new a("WeekBasedYear", this, mVar, b.FOREVER, a.f4213k);
        f.b.a.c.b.o.b.B1(bVar, "firstDayOfWeek");
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.b = bVar;
        this.c = i2;
    }

    public static p a(Locale locale) {
        f.b.a.c.b.o.b.B1(locale, "locale");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry()));
        int firstDayOfWeek = gregorianCalendar.getFirstDayOfWeek();
        b bVar = b.SUNDAY;
        return b(b.f4029i[((((int) (((long) (firstDayOfWeek - 1)) % 7)) + 7) + 6) % 7], gregorianCalendar.getMinimalDaysInFirstWeek());
    }

    public static p b(b bVar, int i2) {
        String str = bVar.toString() + i2;
        ConcurrentMap<String, p> concurrentMap = f4204h;
        p pVar = concurrentMap.get(str);
        if (pVar != null) {
            return pVar;
        }
        concurrentMap.putIfAbsent(str, new p(bVar, i2));
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && hashCode() == obj.hashCode();
    }

    public int hashCode() {
        return (this.b.ordinal() * 7) + this.c;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("WeekFields[");
        h2.append(this.b);
        h2.append(',');
        h2.append(this.c);
        h2.append(']');
        return h2.toString();
    }
}
