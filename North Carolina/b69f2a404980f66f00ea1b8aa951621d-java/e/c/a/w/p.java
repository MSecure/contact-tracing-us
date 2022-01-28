package e.c.a.w;

import c.b.a.a.c.n.c;
import e.c.a.b;
import e.c.a.n;
import e.c.a.t.h;
import e.c.a.u.l;
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
    public final b f5186b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5187c;

    /* renamed from: d  reason: collision with root package name */
    public final transient j f5188d = new a("DayOfWeek", this, b.DAYS, b.WEEKS, a.g);

    /* renamed from: e  reason: collision with root package name */
    public final transient j f5189e = new a("WeekOfMonth", this, b.WEEKS, b.MONTHS, a.h);
    public final transient j f;
    public final transient j g;

    public static class a implements j {
        public static final o g = o.d(1, 7);
        public static final o h = o.f(0, 1, 4, 6);
        public static final o i = o.f(0, 1, 52, 54);
        public static final o j = o.e(1, 52, 53);
        public static final o k = a.YEAR.f5158c;

        /* renamed from: b  reason: collision with root package name */
        public final String f5190b;

        /* renamed from: c  reason: collision with root package name */
        public final p f5191c;

        /* renamed from: d  reason: collision with root package name */
        public final m f5192d;

        /* renamed from: e  reason: collision with root package name */
        public final m f5193e;
        public final o f;

        public a(String str, p pVar, m mVar, m mVar2, o oVar) {
            this.f5190b = str;
            this.f5191c = pVar;
            this.f5192d = mVar;
            this.f5193e = mVar2;
            this.f = oVar;
        }

        public final int a(int i2, int i3) {
            return ((i3 - 1) + (i2 + 7)) / 7;
        }

        @Override // e.c.a.w.j
        public boolean b() {
            return true;
        }

        public final int c(e eVar, int i2) {
            return c.S0(eVar.d(a.DAY_OF_WEEK) - i2, 7) + 1;
        }

        @Override // e.c.a.w.j
        public boolean d(e eVar) {
            a aVar;
            if (!eVar.i(a.DAY_OF_WEEK)) {
                return false;
            }
            m mVar = this.f5193e;
            if (mVar == b.WEEKS) {
                return true;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else if (mVar != c.f5166d && mVar != b.FOREVER) {
                return false;
            } else {
                aVar = a.EPOCH_DAY;
            }
            return eVar.i(aVar);
        }

        public final long e(e eVar, int i2) {
            int d2 = eVar.d(a.DAY_OF_YEAR);
            return (long) a(j(d2, i2), d2);
        }

        @Override // e.c.a.w.j
        public <R extends d> R f(R r, long j2) {
            long j3;
            int a2 = this.f.a(j2, this);
            int d2 = r.d(this);
            if (a2 == d2) {
                return r;
            }
            if (this.f5193e != b.FOREVER) {
                return (R) r.o((long) (a2 - d2), this.f5192d);
            }
            int d3 = r.d(this.f5191c.f);
            R r2 = (R) r.o((long) (((double) (j2 - ((long) d2))) * 52.1775d), b.WEEKS);
            if (r2.d(this) > a2) {
                j3 = (long) r2.d(this.f5191c.f);
            } else {
                if (r2.d(this) < a2) {
                    r2 = (R) r2.o(2, b.WEEKS);
                }
                r2 = (R) r2.o((long) (d3 - r2.d(this.f5191c.f)), b.WEEKS);
                if (r2.d(this) <= a2) {
                    return r2;
                }
                j3 = 1;
            }
            return (R) r2.k(j3, b.WEEKS);
        }

        @Override // e.c.a.w.j
        public e g(Map<j, Long> map, e eVar, l lVar) {
            e.c.a.t.b bVar;
            Object obj;
            long j2;
            long j3;
            e.c.a.t.b bVar2;
            long j4;
            e.c.a.t.b bVar3;
            l lVar2 = l.STRICT;
            l lVar3 = l.LENIENT;
            int s = this.f5191c.f5186b.s();
            if (this.f5193e == b.WEEKS) {
                map.put(a.DAY_OF_WEEK, Long.valueOf((long) (c.S0((this.f.a(map.remove(this).longValue(), this) - 1) + (s - 1), 7) + 1)));
                return null;
            } else if (!map.containsKey(a.DAY_OF_WEEK)) {
                return null;
            } else {
                if (this.f5193e == b.FOREVER) {
                    if (!map.containsKey(this.f5191c.f)) {
                        return null;
                    }
                    h n = h.n(eVar);
                    a aVar = a.DAY_OF_WEEK;
                    int S0 = c.S0(aVar.o(map.get(aVar).longValue()) - s, 7) + 1;
                    int a2 = this.f.a(map.get(this).longValue(), this);
                    if (lVar == lVar3) {
                        bVar3 = n.d(a2, 1, this.f5191c.f5187c);
                        j4 = map.get(this.f5191c.f).longValue();
                    } else {
                        bVar3 = n.d(a2, 1, this.f5191c.f5187c);
                        j4 = (long) this.f5191c.f.k().a(map.get(this.f5191c.f).longValue(), this.f5191c.f);
                    }
                    int c2 = c(bVar3, s);
                    bVar = bVar3.o(((j4 - e(bVar3, c2)) * 7) + ((long) (S0 - c2)), b.DAYS);
                    if (lVar != lVar2 || bVar.l(this) == map.get(this).longValue()) {
                        map.remove(this);
                        obj = this.f5191c.f;
                    } else {
                        throw new e.c.a.a("Strict mode rejected date parsed to a different year");
                    }
                } else if (!map.containsKey(a.YEAR)) {
                    return null;
                } else {
                    a aVar2 = a.DAY_OF_WEEK;
                    int S02 = c.S0(aVar2.o(map.get(aVar2).longValue()) - s, 7) + 1;
                    a aVar3 = a.YEAR;
                    int o = aVar3.o(map.get(aVar3).longValue());
                    h n2 = h.n(eVar);
                    m mVar = this.f5193e;
                    if (mVar == b.MONTHS) {
                        if (!map.containsKey(a.MONTH_OF_YEAR)) {
                            return null;
                        }
                        long longValue = map.remove(this).longValue();
                        if (lVar == lVar3) {
                            bVar2 = n2.d(o, 1, 1).o(map.get(a.MONTH_OF_YEAR).longValue() - 1, b.MONTHS);
                            int c3 = c(bVar2, s);
                            int d2 = bVar2.d(a.DAY_OF_MONTH);
                            j3 = ((longValue - ((long) a(j(d2, c3), d2))) * 7) + ((long) (S02 - c3));
                        } else {
                            a aVar4 = a.MONTH_OF_YEAR;
                            bVar2 = n2.d(o, aVar4.o(map.get(aVar4).longValue()), 8);
                            int c4 = c(bVar2, s);
                            int d3 = bVar2.d(a.DAY_OF_MONTH);
                            j3 = ((((long) this.f.a(longValue, this)) - ((long) a(j(d3, c4), d3))) * 7) + ((long) (S02 - c4));
                        }
                        bVar = bVar2.o(j3, b.DAYS);
                        if (lVar != lVar2 || bVar.l(a.MONTH_OF_YEAR) == map.get(a.MONTH_OF_YEAR).longValue()) {
                            map.remove(this);
                            map.remove(a.YEAR);
                            obj = a.MONTH_OF_YEAR;
                        } else {
                            throw new e.c.a.a("Strict mode rejected date parsed to a different month");
                        }
                    } else if (mVar == b.YEARS) {
                        long longValue2 = map.remove(this).longValue();
                        e.c.a.t.b d4 = n2.d(o, 1, 1);
                        if (lVar == lVar3) {
                            int c5 = c(d4, s);
                            j2 = ((longValue2 - e(d4, c5)) * 7) + ((long) (S02 - c5));
                        } else {
                            int c6 = c(d4, s);
                            j2 = ((((long) this.f.a(longValue2, this)) - e(d4, c6)) * 7) + ((long) (S02 - c6));
                        }
                        bVar = d4.o(j2, b.DAYS);
                        if (lVar != lVar2 || bVar.l(a.YEAR) == map.get(a.YEAR).longValue()) {
                            map.remove(this);
                            obj = a.YEAR;
                        } else {
                            throw new e.c.a.a("Strict mode rejected date parsed to a different year");
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

        public final o h(e eVar) {
            int S0 = c.S0(eVar.d(a.DAY_OF_WEEK) - this.f5191c.f5186b.s(), 7) + 1;
            long e2 = e(eVar, S0);
            if (e2 == 0) {
                return h(h.n(eVar).f(eVar).k(2, b.WEEKS));
            }
            int a2 = a(j(eVar.d(a.DAY_OF_YEAR), S0), (n.t((long) eVar.d(a.YEAR)) ? 366 : 365) + this.f5191c.f5187c);
            return e2 >= ((long) a2) ? h(h.n(eVar).f(eVar).o(2, b.WEEKS)) : o.d(1, (long) (a2 - 1));
        }

        @Override // e.c.a.w.j
        public long i(e eVar) {
            a aVar;
            int i2;
            int S0 = c.S0(eVar.d(a.DAY_OF_WEEK) - this.f5191c.f5186b.s(), 7) + 1;
            m mVar = this.f5193e;
            if (mVar == b.WEEKS) {
                return (long) S0;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else {
                int i3 = 366;
                if (mVar == c.f5166d) {
                    int S02 = c.S0(eVar.d(a.DAY_OF_WEEK) - this.f5191c.f5186b.s(), 7) + 1;
                    long e2 = e(eVar, S02);
                    if (e2 == 0) {
                        i2 = ((int) e(h.n(eVar).f(eVar).k(1, b.WEEKS), S02)) + 1;
                    } else {
                        if (e2 >= 53) {
                            int j2 = j(eVar.d(a.DAY_OF_YEAR), S02);
                            if (!n.t((long) eVar.d(a.YEAR))) {
                                i3 = 365;
                            }
                            int a2 = a(j2, i3 + this.f5191c.f5187c);
                            if (e2 >= ((long) a2)) {
                                e2 -= (long) (a2 - 1);
                            }
                        }
                        i2 = (int) e2;
                    }
                    return (long) i2;
                } else if (mVar == b.FOREVER) {
                    int S03 = c.S0(eVar.d(a.DAY_OF_WEEK) - this.f5191c.f5186b.s(), 7) + 1;
                    int d2 = eVar.d(a.YEAR);
                    long e3 = e(eVar, S03);
                    if (e3 == 0) {
                        d2--;
                    } else if (e3 >= 53) {
                        int j3 = j(eVar.d(a.DAY_OF_YEAR), S03);
                        if (!n.t((long) d2)) {
                            i3 = 365;
                        }
                        if (e3 >= ((long) a(j3, i3 + this.f5191c.f5187c))) {
                            d2++;
                        }
                    }
                    return (long) d2;
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
            int d3 = eVar.d(aVar);
            return (long) a(j(d3, S0), d3);
        }

        public final int j(int i2, int i3) {
            int S0 = c.S0(i2 - i3, 7);
            return S0 + 1 > this.f5191c.f5187c ? 7 - S0 : -S0;
        }

        @Override // e.c.a.w.j
        public o k() {
            return this.f;
        }

        @Override // e.c.a.w.j
        public boolean l() {
            return false;
        }

        @Override // e.c.a.w.j
        public o n(e eVar) {
            a aVar;
            m mVar = this.f5193e;
            if (mVar == b.WEEKS) {
                return this.f;
            }
            if (mVar == b.MONTHS) {
                aVar = a.DAY_OF_MONTH;
            } else if (mVar == b.YEARS) {
                aVar = a.DAY_OF_YEAR;
            } else if (mVar == c.f5166d) {
                return h(eVar);
            } else {
                if (mVar == b.FOREVER) {
                    return eVar.b(a.YEAR);
                }
                throw new IllegalStateException("unreachable");
            }
            int s = this.f5191c.f5186b.s();
            int j2 = j(eVar.d(aVar), c.S0(eVar.d(a.DAY_OF_WEEK) - s, 7) + 1);
            o b2 = eVar.b(aVar);
            return o.d((long) a(j2, (int) b2.f5182b), (long) a(j2, (int) b2.f5185e));
        }

        public String toString() {
            return this.f5190b + "[" + this.f5191c.toString() + "]";
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
        this.f = new a("WeekOfWeekBasedYear", this, b.WEEKS, c.f5166d, a.j);
        this.g = new a("WeekBasedYear", this, c.f5166d, b.FOREVER, a.k);
        c.T1(bVar, "firstDayOfWeek");
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.f5186b = bVar;
        this.f5187c = i;
    }

    public static p a(Locale locale) {
        c.T1(locale, "locale");
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
            return b(this.f5186b, this.f5187c);
        } catch (IllegalArgumentException e2) {
            StringBuilder g2 = c.a.a.a.a.g("Invalid WeekFields");
            g2.append(e2.getMessage());
            throw new InvalidObjectException(g2.toString());
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
        return (this.f5186b.ordinal() * 7) + this.f5187c;
    }

    public String toString() {
        StringBuilder g2 = c.a.a.a.a.g("WeekFields[");
        g2.append(this.f5186b);
        g2.append(',');
        g2.append(this.f5187c);
        g2.append(']');
        return g2.toString();
    }
}
