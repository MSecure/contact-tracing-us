package g.b.a.w;

import b.x.t;
import g.b.a.e;
import g.b.a.t.h;
import g.b.a.t.m;
import g.b.a.u.l;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final j f6640a = b.QUARTER_OF_YEAR;

    /* renamed from: b  reason: collision with root package name */
    public static final j f6641b = b.WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: c  reason: collision with root package name */
    public static final j f6642c = b.WEEK_BASED_YEAR;

    /* renamed from: d  reason: collision with root package name */
    public static final m f6643d = EnumC0125c.WEEK_BASED_YEARS;

    public enum b implements j {
        DAY_OF_QUARTER {
            @Override // g.b.a.w.j
            public boolean d(e eVar) {
                return eVar.k(a.DAY_OF_YEAR) && eVar.k(a.MONTH_OF_YEAR) && eVar.k(a.YEAR) && b.r(eVar);
            }

            @Override // g.b.a.w.j
            public <R extends d> R f(R r, long j) {
                long k = k(r);
                m().b(j, this);
                a aVar = a.DAY_OF_YEAR;
                return (R) r.r(aVar, (j - k) + r.n(aVar));
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x007b, code lost:
                if (r0 == 2) goto L_0x007d;
             */
            @Override // g.b.a.w.c.b, g.b.a.w.j
            public e i(Map<j, Long> map, e eVar, l lVar) {
                e eVar2;
                o oVar;
                Long l = map.get(a.YEAR);
                Long l2 = map.get(b.QUARTER_OF_YEAR);
                if (l == null || l2 == null) {
                    return null;
                }
                int r = a.YEAR.r(l.longValue());
                long longValue = map.get(b.DAY_OF_QUARTER).longValue();
                if (lVar == l.LENIENT) {
                    eVar2 = e.f0(r, 1, 1).m0(t.E2(t.H2(l2.longValue(), 1), 3)).l0(t.H2(longValue, 1));
                } else {
                    int a2 = ((C0123b) b.QUARTER_OF_YEAR).m().a(l2.longValue(), b.QUARTER_OF_YEAR);
                    if (lVar == l.STRICT) {
                        int i = 92;
                        if (a2 == 1) {
                            if (!m.f6476d.F((long) r)) {
                                i = 90;
                                oVar = o.d(1, (long) i);
                            }
                        }
                        i = 91;
                        oVar = o.d(1, (long) i);
                    } else {
                        oVar = m();
                    }
                    oVar.b(longValue, this);
                    eVar2 = e.f0(r, ((a2 - 1) * 3) + 1, 1).l0(longValue - 1);
                }
                map.remove(this);
                map.remove(a.YEAR);
                map.remove(b.QUARTER_OF_YEAR);
                return eVar2;
            }

            @Override // g.b.a.w.j
            public long k(e eVar) {
                if (eVar.k(this)) {
                    return (long) (eVar.d(a.DAY_OF_YEAR) - b.f6648f[((eVar.d(a.MONTH_OF_YEAR) - 1) / 3) + (m.f6476d.F(eVar.n(a.YEAR)) ? 4 : 0)]);
                }
                throw new n("Unsupported field: DayOfQuarter");
            }

            @Override // g.b.a.w.j
            public o m() {
                return o.e(1, 90, 92);
            }

            @Override // g.b.a.w.j
            public o p(e eVar) {
                if (eVar.k(this)) {
                    long n = eVar.n(b.QUARTER_OF_YEAR);
                    if (n != 1) {
                        return n == 2 ? o.d(1, 91) : (n == 3 || n == 4) ? o.d(1, 92) : m();
                    }
                    return m.f6476d.F(eVar.n(a.YEAR)) ? o.d(1, 91) : o.d(1, 90);
                }
                throw new n("Unsupported field: DayOfQuarter");
            }

            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR {
            @Override // g.b.a.w.j
            public boolean d(e eVar) {
                return eVar.k(a.MONTH_OF_YEAR) && b.r(eVar);
            }

            @Override // g.b.a.w.j
            public <R extends d> R f(R r, long j) {
                long k = k(r);
                m().b(j, this);
                a aVar = a.MONTH_OF_YEAR;
                return (R) r.r(aVar, ((j - k) * 3) + r.n(aVar));
            }

            @Override // g.b.a.w.j
            public long k(e eVar) {
                if (eVar.k(this)) {
                    return (eVar.n(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new n("Unsupported field: QuarterOfYear");
            }

            @Override // g.b.a.w.j
            public o m() {
                return o.d(1, 4);
            }

            @Override // g.b.a.w.j
            public o p(e eVar) {
                return m();
            }

            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            @Override // g.b.a.w.j
            public boolean d(e eVar) {
                return eVar.k(a.EPOCH_DAY) && b.r(eVar);
            }

            @Override // g.b.a.w.j
            public <R extends d> R f(R r, long j) {
                m().b(j, this);
                return (R) r.s(t.H2(j, k(r)), b.WEEKS);
            }

            @Override // g.b.a.w.c.b, g.b.a.w.j
            public e i(Map<j, Long> map, e eVar, l lVar) {
                e eVar2;
                o oVar;
                Long l = map.get(b.WEEK_BASED_YEAR);
                Long l2 = map.get(a.DAY_OF_WEEK);
                if (l == null || l2 == null) {
                    return null;
                }
                int a2 = a.YEAR.f6633c.a(l.longValue(), b.WEEK_BASED_YEAR);
                long longValue = map.get(b.WEEK_OF_WEEK_BASED_YEAR).longValue();
                if (lVar == l.LENIENT) {
                    long longValue2 = l2.longValue();
                    long j = 0;
                    if (longValue2 > 7) {
                        long j2 = longValue2 - 1;
                        j = j2 / 7;
                        longValue2 = (j2 % 7) + 1;
                    } else if (longValue2 < 1) {
                        j = (longValue2 / 7) - 1;
                        longValue2 = (longValue2 % 7) + 7;
                    }
                    eVar2 = e.f0(a2, 1, 4).n0(longValue - 1).n0(j).r(a.DAY_OF_WEEK, longValue2);
                } else {
                    int r = a.DAY_OF_WEEK.r(l2.longValue());
                    if (lVar == l.STRICT) {
                        oVar = o.d(1, (long) b.x(b.t(e.f0(a2, 1, 4))));
                    } else {
                        oVar = m();
                    }
                    oVar.b(longValue, this);
                    eVar2 = e.f0(a2, 1, 4).n0(longValue - 1).r(a.DAY_OF_WEEK, (long) r);
                }
                map.remove(this);
                map.remove(b.WEEK_BASED_YEAR);
                map.remove(a.DAY_OF_WEEK);
                return eVar2;
            }

            @Override // g.b.a.w.j
            public long k(e eVar) {
                if (eVar.k(this)) {
                    return (long) b.s(e.V(eVar));
                }
                throw new n("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // g.b.a.w.j
            public o m() {
                return o.e(1, 52, 53);
            }

            @Override // g.b.a.w.j
            public o p(e eVar) {
                if (eVar.k(this)) {
                    return o.d(1, (long) b.x(b.t(e.V(eVar))));
                }
                throw new n("Unsupported field: WeekOfWeekBasedYear");
            }

            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR {
            @Override // g.b.a.w.j
            public boolean d(e eVar) {
                return eVar.k(a.EPOCH_DAY) && b.r(eVar);
            }

            @Override // g.b.a.w.j
            public <R extends d> R f(R r, long j) {
                if (d(r)) {
                    int a2 = a.YEAR.f6633c.a(j, b.WEEK_BASED_YEAR);
                    e V = e.V(r);
                    int d2 = V.d(a.DAY_OF_WEEK);
                    int s = b.s(V);
                    if (s == 53 && b.x(a2) == 52) {
                        s = 52;
                    }
                    e f0 = e.f0(a2, 1, 4);
                    return (R) r.i(f0.l0((long) (((s - 1) * 7) + (d2 - f0.d(a.DAY_OF_WEEK)))));
                }
                throw new n("Unsupported field: WeekBasedYear");
            }

            @Override // g.b.a.w.j
            public long k(e eVar) {
                if (eVar.k(this)) {
                    return (long) b.t(e.V(eVar));
                }
                throw new n("Unsupported field: WeekBasedYear");
            }

            @Override // g.b.a.w.j
            public o m() {
                return a.YEAR.f6633c;
            }

            @Override // g.b.a.w.j
            public o p(e eVar) {
                return a.YEAR.f6633c;
            }

            public String toString() {
                return "WeekBasedYear";
            }
        };
        

        /* renamed from: f  reason: collision with root package name */
        public static final int[] f6648f = {0, 90, 181, 273, 0, 91, 182, 274};

        /* access modifiers changed from: public */
        b(a aVar) {
        }

        public static boolean r(e eVar) {
            return h.p(eVar).equals(m.f6476d);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
            if ((r0 == -3 || (r0 == -2 && r5.b0())) == false) goto L_0x0061;
         */
        public static int s(e eVar) {
            int ordinal = eVar.X().ordinal();
            int i = 1;
            int Y = eVar.Y() - 1;
            int i2 = (3 - ordinal) + Y;
            int i3 = (i2 - ((i2 / 7) * 7)) - 3;
            if (i3 < -3) {
                i3 += 7;
            }
            if (Y < i3) {
                if (eVar.Y() != 180) {
                    eVar = e.i0(eVar.f6409b, 180);
                }
                return (int) o.d(1, (long) x(t(eVar.o0(-1)))).f6666e;
            }
            int i4 = ((Y - i3) / 7) + 1;
            if (i4 == 53) {
            }
            i = i4;
            return i;
        }

        public static int t(e eVar) {
            int i = eVar.f6409b;
            int Y = eVar.Y();
            if (Y <= 3) {
                return Y - eVar.X().ordinal() < -2 ? i - 1 : i;
            }
            if (Y < 363) {
                return i;
            }
            return ((Y - 363) - (eVar.b0() ? 1 : 0)) - eVar.X().ordinal() >= 0 ? i + 1 : i;
        }

        public static int x(int i) {
            e f0 = e.f0(i, 1, 1);
            if (f0.X() != g.b.a.b.THURSDAY) {
                return (f0.X() != g.b.a.b.WEDNESDAY || !f0.b0()) ? 52 : 53;
            }
            return 53;
        }

        @Override // g.b.a.w.j
        public boolean b() {
            return true;
        }

        @Override // g.b.a.w.j
        public e i(Map<j, Long> map, e eVar, l lVar) {
            return null;
        }

        @Override // g.b.a.w.j
        public boolean n() {
            return false;
        }
    }

    /* renamed from: g.b.a.w.c$c  reason: collision with other inner class name */
    public enum EnumC0125c implements m {
        WEEK_BASED_YEARS("WeekBasedYears", g.b.a.c.m(31556952)),
        QUARTER_YEARS("QuarterYears", g.b.a.c.m(7889238));
        

        /* renamed from: b  reason: collision with root package name */
        public final String f6653b;

        /* access modifiers changed from: public */
        EnumC0125c(String str, g.b.a.c cVar) {
            this.f6653b = str;
        }

        @Override // g.b.a.w.m
        public boolean b() {
            return true;
        }

        @Override // g.b.a.w.m
        public long d(d dVar, d dVar2) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return t.H2(dVar2.n(c.f6642c), dVar.n(c.f6642c));
            }
            if (ordinal == 1) {
                return dVar.y(dVar2, b.MONTHS) / 3;
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // g.b.a.w.m
        public <R extends d> R f(R r, long j) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return (R) r.r(c.f6642c, t.D2((long) r.d(c.f6642c), j));
            } else if (ordinal == 1) {
                return (R) r.s(j / 256, b.YEARS).s((j % 256) * 3, b.MONTHS);
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        public String toString() {
            return this.f6653b;
        }
    }

    static {
        EnumC0125c cVar = EnumC0125c.QUARTER_YEARS;
    }
}
