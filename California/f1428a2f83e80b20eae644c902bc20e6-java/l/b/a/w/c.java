package l.b.a.w;

import java.util.Map;
import l.b.a.e;
import l.b.a.t.h;
import l.b.a.t.m;
import l.b.a.u.l;

public final class c {
    public static final m a = EnumC0152c.WEEK_BASED_YEARS;

    public enum b implements j {
        DAY_OF_QUARTER {
            @Override // l.b.a.w.j
            public boolean b(e eVar) {
                return eVar.f(a.DAY_OF_YEAR) && eVar.f(a.MONTH_OF_YEAR) && eVar.f(a.YEAR) && b.m(eVar);
            }

            @Override // l.b.a.w.j
            public <R extends d> R c(R r, long j2) {
                long f2 = f(r);
                h().b(j2, this);
                a aVar = a.DAY_OF_YEAR;
                return (R) r.l(aVar, (j2 - f2) + r.i(aVar));
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0076, code lost:
                if (r2 == 2) goto L_0x0078;
             */
            @Override // l.b.a.w.c.b, l.b.a.w.j
            public e e(Map<j, Long> map, e eVar, l lVar) {
                e eVar2;
                o oVar;
                a aVar = a.YEAR;
                Long l2 = map.get(aVar);
                b bVar = b.QUARTER_OF_YEAR;
                Long l3 = map.get(bVar);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int m = aVar.m(l2.longValue());
                long longValue = map.get(b.DAY_OF_QUARTER).longValue();
                if (lVar == l.LENIENT) {
                    eVar2 = e.P(m, 1, 1).W(f.b.a.c.b.o.b.I1(f.b.a.c.b.o.b.L1(l3.longValue(), 1), 3)).V(f.b.a.c.b.o.b.L1(longValue, 1));
                } else {
                    int a = ((C0150b) bVar).h().a(l3.longValue(), bVar);
                    if (lVar == l.STRICT) {
                        int i2 = 92;
                        if (a == 1) {
                            if (!m.f4084d.u((long) m)) {
                                i2 = 90;
                                oVar = o.d(1, (long) i2);
                            }
                        }
                        i2 = 91;
                        oVar = o.d(1, (long) i2);
                    } else {
                        oVar = h();
                    }
                    oVar.b(longValue, this);
                    eVar2 = e.P(m, ((a - 1) * 3) + 1, 1).V(longValue - 1);
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(bVar);
                return eVar2;
            }

            @Override // l.b.a.w.j
            public long f(e eVar) {
                if (eVar.f(this)) {
                    return (long) (eVar.b(a.DAY_OF_YEAR) - b.f4194f[((eVar.b(a.MONTH_OF_YEAR) - 1) / 3) + (m.f4084d.u(eVar.i(a.YEAR)) ? 4 : 0)]);
                }
                throw new n("Unsupported field: DayOfQuarter");
            }

            @Override // l.b.a.w.j
            public o h() {
                return o.e(1, 90, 92);
            }

            @Override // l.b.a.w.j
            public o l(e eVar) {
                if (eVar.f(this)) {
                    long i2 = eVar.i(b.QUARTER_OF_YEAR);
                    if (i2 != 1) {
                        return i2 == 2 ? o.d(1, 91) : (i2 == 3 || i2 == 4) ? o.d(1, 92) : h();
                    }
                    return m.f4084d.u(eVar.i(a.YEAR)) ? o.d(1, 91) : o.d(1, 90);
                }
                throw new n("Unsupported field: DayOfQuarter");
            }

            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR {
            @Override // l.b.a.w.j
            public boolean b(e eVar) {
                return eVar.f(a.MONTH_OF_YEAR) && b.m(eVar);
            }

            @Override // l.b.a.w.j
            public <R extends d> R c(R r, long j2) {
                long f2 = f(r);
                h().b(j2, this);
                a aVar = a.MONTH_OF_YEAR;
                return (R) r.l(aVar, ((j2 - f2) * 3) + r.i(aVar));
            }

            @Override // l.b.a.w.j
            public long f(e eVar) {
                if (eVar.f(this)) {
                    return (eVar.i(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new n("Unsupported field: QuarterOfYear");
            }

            @Override // l.b.a.w.j
            public o h() {
                return o.d(1, 4);
            }

            @Override // l.b.a.w.j
            public o l(e eVar) {
                return h();
            }

            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            @Override // l.b.a.w.j
            public boolean b(e eVar) {
                return eVar.f(a.EPOCH_DAY) && b.m(eVar);
            }

            @Override // l.b.a.w.j
            public <R extends d> R c(R r, long j2) {
                h().b(j2, this);
                return (R) r.m(f.b.a.c.b.o.b.L1(j2, f(r)), b.WEEKS);
            }

            @Override // l.b.a.w.c.b, l.b.a.w.j
            public e e(Map<j, Long> map, e eVar, l lVar) {
                b bVar;
                e eVar2;
                o oVar;
                b bVar2 = b.WEEK_BASED_YEAR;
                Long l2 = map.get(bVar2);
                a aVar = a.DAY_OF_WEEK;
                Long l3 = map.get(aVar);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int a = a.YEAR.f4182e.a(l2.longValue(), bVar2);
                long longValue = map.get(b.WEEK_OF_WEEK_BASED_YEAR).longValue();
                if (lVar == l.LENIENT) {
                    long longValue2 = l3.longValue();
                    long j2 = 0;
                    if (longValue2 > 7) {
                        long j3 = longValue2 - 1;
                        j2 = j3 / 7;
                        longValue2 = (j3 % 7) + 1;
                    } else if (longValue2 < 1) {
                        j2 = (longValue2 / 7) - 1;
                        longValue2 = (longValue2 % 7) + 7;
                    }
                    bVar = bVar2;
                    eVar2 = e.P(a, 1, 4).X(longValue - 1).X(j2).z(aVar, longValue2);
                } else {
                    bVar = bVar2;
                    int m = aVar.m(l3.longValue());
                    if (lVar == l.STRICT) {
                        oVar = o.d(1, (long) b.q(b.o(e.P(a, 1, 4))));
                    } else {
                        oVar = h();
                    }
                    oVar.b(longValue, this);
                    eVar2 = e.P(a, 1, 4).X(longValue - 1).z(aVar, (long) m);
                }
                map.remove(this);
                map.remove(bVar);
                map.remove(aVar);
                return eVar2;
            }

            @Override // l.b.a.w.j
            public long f(e eVar) {
                if (eVar.f(this)) {
                    return (long) b.n(e.E(eVar));
                }
                throw new n("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // l.b.a.w.j
            public o h() {
                return o.e(1, 52, 53);
            }

            @Override // l.b.a.w.j
            public o l(e eVar) {
                if (eVar.f(this)) {
                    return o.d(1, (long) b.q(b.o(e.E(eVar))));
                }
                throw new n("Unsupported field: WeekOfWeekBasedYear");
            }

            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR {
            @Override // l.b.a.w.j
            public boolean b(e eVar) {
                return eVar.f(a.EPOCH_DAY) && b.m(eVar);
            }

            @Override // l.b.a.w.j
            public <R extends d> R c(R r, long j2) {
                if (b(r)) {
                    int a = a.YEAR.f4182e.a(j2, b.WEEK_BASED_YEAR);
                    e E = e.E(r);
                    a aVar = a.DAY_OF_WEEK;
                    int b = E.b(aVar);
                    int n = b.n(E);
                    if (n == 53 && b.q(a) == 52) {
                        n = 52;
                    }
                    e P = e.P(a, 1, 4);
                    return (R) r.e(P.V((long) (((n - 1) * 7) + (b - P.b(aVar)))));
                }
                throw new n("Unsupported field: WeekBasedYear");
            }

            @Override // l.b.a.w.j
            public long f(e eVar) {
                if (eVar.f(this)) {
                    return (long) b.o(e.E(eVar));
                }
                throw new n("Unsupported field: WeekBasedYear");
            }

            @Override // l.b.a.w.j
            public o h() {
                return a.YEAR.f4182e;
            }

            @Override // l.b.a.w.j
            public o l(e eVar) {
                return a.YEAR.f4182e;
            }

            public String toString() {
                return "WeekBasedYear";
            }
        };
        

        /* renamed from: f  reason: collision with root package name */
        public static final int[] f4194f = {0, 90, 181, 273, 0, 91, 182, 274};

        /* access modifiers changed from: public */
        b(a aVar) {
        }

        public static boolean m(e eVar) {
            return h.l(eVar).equals(m.f4084d);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
            if ((r0 == -3 || (r0 == -2 && r5.K())) == false) goto L_0x0061;
         */
        public static int n(e eVar) {
            int ordinal = eVar.G().ordinal();
            int i2 = 1;
            int H = eVar.H() - 1;
            int i3 = (3 - ordinal) + H;
            int i4 = (i3 - ((i3 / 7) * 7)) - 3;
            if (i4 < -3) {
                i4 += 7;
            }
            if (H < i4) {
                if (eVar.H() != 180) {
                    eVar = e.S(eVar.b, 180);
                }
                return (int) o.d(1, (long) q(o(eVar.Y(-1)))).f4203e;
            }
            int i5 = ((H - i4) / 7) + 1;
            if (i5 == 53) {
            }
            i2 = i5;
            return i2;
        }

        public static int o(e eVar) {
            int i2 = eVar.b;
            int H = eVar.H();
            if (H <= 3) {
                return H - eVar.G().ordinal() < -2 ? i2 - 1 : i2;
            }
            if (H < 363) {
                return i2;
            }
            return ((H - 363) - (eVar.K() ? 1 : 0)) - eVar.G().ordinal() >= 0 ? i2 + 1 : i2;
        }

        public static int q(int i2) {
            e P = e.P(i2, 1, 1);
            if (P.G() != l.b.a.b.THURSDAY) {
                return (P.G() != l.b.a.b.WEDNESDAY || !P.K()) ? 52 : 53;
            }
            return 53;
        }

        @Override // l.b.a.w.j
        public boolean a() {
            return true;
        }

        @Override // l.b.a.w.j
        public e e(Map<j, Long> map, e eVar, l lVar) {
            return null;
        }

        @Override // l.b.a.w.j
        public boolean i() {
            return false;
        }
    }

    /* renamed from: l.b.a.w.c$c  reason: collision with other inner class name */
    public enum EnumC0152c implements m {
        WEEK_BASED_YEARS("WeekBasedYears", l.b.a.c.l(31556952)),
        QUARTER_YEARS("QuarterYears", l.b.a.c.l(7889238));
        
        public final String b;

        /* access modifiers changed from: public */
        EnumC0152c(String str, l.b.a.c cVar) {
            this.b = str;
        }

        @Override // l.b.a.w.m
        public boolean a() {
            return true;
        }

        @Override // l.b.a.w.m
        public long b(d dVar, d dVar2) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                m mVar = c.a;
                b bVar = b.WEEK_BASED_YEAR;
                return f.b.a.c.b.o.b.L1(dVar2.i(bVar), dVar.i(bVar));
            } else if (ordinal == 1) {
                return dVar.o(dVar2, b.MONTHS) / 3;
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        @Override // l.b.a.w.m
        public <R extends d> R c(R r, long j2) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                m mVar = c.a;
                b bVar = b.WEEK_BASED_YEAR;
                return (R) r.l(bVar, f.b.a.c.b.o.b.H1((long) r.b(bVar), j2));
            } else if (ordinal == 1) {
                return (R) r.m(j2 / 256, b.YEARS).m((j2 % 256) * 3, b.MONTHS);
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        public String toString() {
            return this.b;
        }
    }

    static {
        EnumC0152c cVar = EnumC0152c.QUARTER_YEARS;
    }
}
