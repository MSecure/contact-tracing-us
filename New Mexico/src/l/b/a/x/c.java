package l.b.a.x;

import java.util.Map;
import l.b.a.d;
import l.b.a.f;
import l.b.a.u.h;
import l.b.a.u.m;
import l.b.a.v.l;
/* loaded from: classes.dex */
public final class c {
    public static final m a = EnumC0160c.WEEK_BASED_YEARS;

    /* loaded from: classes.dex */
    public enum b implements j {
        DAY_OF_QUARTER {
            @Override // l.b.a.x.j
            public boolean b(e eVar) {
                return eVar.f(a.DAY_OF_YEAR) && eVar.f(a.MONTH_OF_YEAR) && eVar.f(a.YEAR) && b.m(eVar);
            }

            @Override // l.b.a.x.j
            public <R extends d> R c(R r, long j2) {
                long f2 = f(r);
                h().b(j2, this);
                a aVar = a.DAY_OF_YEAR;
                return (R) r.l(aVar, (j2 - f2) + r.i(aVar));
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0076, code lost:
                if (r2 == 2) goto L_0x0078;
             */
            @Override // l.b.a.x.c.b, l.b.a.x.j
            /* Code decompiled incorrectly, please refer to instructions dump */
            public e e(Map<j, Long> map, e eVar, l lVar) {
                f fVar;
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
                    fVar = f.P(m, 1, 1).W(g.b.a.c.c.d.x(g.b.a.c.c.d.A(l3.longValue(), 1), 3)).V(g.b.a.c.c.d.A(longValue, 1));
                } else {
                    int a = ((C0158b) bVar).h().a(l3.longValue(), bVar);
                    if (lVar == l.STRICT) {
                        int i2 = 92;
                        if (a == 1) {
                            if (!m.f4663d.u((long) m)) {
                                i2 = 90;
                                oVar = o.d(1, (long) i2);
                            }
                            i2 = 91;
                            oVar = o.d(1, (long) i2);
                        }
                    } else {
                        oVar = h();
                    }
                    oVar.b(longValue, this);
                    fVar = f.P(m, ((a - 1) * 3) + 1, 1).V(longValue - 1);
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(bVar);
                return fVar;
            }

            @Override // l.b.a.x.j
            public long f(e eVar) {
                if (eVar.f(this)) {
                    return (long) (eVar.b(a.DAY_OF_YEAR) - b.f4773f[((eVar.b(a.MONTH_OF_YEAR) - 1) / 3) + (m.f4663d.u(eVar.i(a.YEAR)) ? 4 : 0)]);
                }
                throw new n("Unsupported field: DayOfQuarter");
            }

            @Override // l.b.a.x.j
            public o h() {
                return o.e(1, 90, 92);
            }

            @Override // l.b.a.x.j
            public o l(e eVar) {
                if (eVar.f(this)) {
                    long i2 = eVar.i(b.QUARTER_OF_YEAR);
                    if (i2 != 1) {
                        return i2 == 2 ? o.d(1, 91) : (i2 == 3 || i2 == 4) ? o.d(1, 92) : h();
                    }
                    return m.f4663d.u(eVar.i(a.YEAR)) ? o.d(1, 91) : o.d(1, 90);
                }
                throw new n("Unsupported field: DayOfQuarter");
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR {
            @Override // l.b.a.x.j
            public boolean b(e eVar) {
                return eVar.f(a.MONTH_OF_YEAR) && b.m(eVar);
            }

            @Override // l.b.a.x.j
            public <R extends d> R c(R r, long j2) {
                long f2 = f(r);
                h().b(j2, this);
                a aVar = a.MONTH_OF_YEAR;
                return (R) r.l(aVar, ((j2 - f2) * 3) + r.i(aVar));
            }

            @Override // l.b.a.x.j
            public long f(e eVar) {
                if (eVar.f(this)) {
                    return (eVar.i(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new n("Unsupported field: QuarterOfYear");
            }

            @Override // l.b.a.x.j
            public o h() {
                return o.d(1, 4);
            }

            @Override // l.b.a.x.j
            public o l(e eVar) {
                return h();
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            @Override // l.b.a.x.j
            public boolean b(e eVar) {
                return eVar.f(a.EPOCH_DAY) && b.m(eVar);
            }

            @Override // l.b.a.x.j
            public <R extends d> R c(R r, long j2) {
                h().b(j2, this);
                return (R) r.m(g.b.a.c.c.d.A(j2, f(r)), b.WEEKS);
            }

            @Override // l.b.a.x.c.b, l.b.a.x.j
            public e e(Map<j, Long> map, e eVar, l lVar) {
                b bVar;
                f fVar;
                o oVar;
                b bVar2 = b.WEEK_BASED_YEAR;
                Long l2 = map.get(bVar2);
                a aVar = a.DAY_OF_WEEK;
                Long l3 = map.get(aVar);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int a = a.YEAR.f4761e.a(l2.longValue(), bVar2);
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
                    fVar = f.P(a, 1, 4).X(longValue - 1).X(j2).z(aVar, longValue2);
                } else {
                    bVar = bVar2;
                    int m = aVar.m(l3.longValue());
                    if (lVar == l.STRICT) {
                        oVar = o.d(1, (long) b.q(b.o(f.P(a, 1, 4))));
                    } else {
                        oVar = h();
                    }
                    oVar.b(longValue, this);
                    fVar = f.P(a, 1, 4).X(longValue - 1).z(aVar, (long) m);
                }
                map.remove(this);
                map.remove(bVar);
                map.remove(aVar);
                return fVar;
            }

            @Override // l.b.a.x.j
            public long f(e eVar) {
                if (eVar.f(this)) {
                    return (long) b.n(f.E(eVar));
                }
                throw new n("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // l.b.a.x.j
            public o h() {
                return o.e(1, 52, 53);
            }

            @Override // l.b.a.x.j
            public o l(e eVar) {
                if (eVar.f(this)) {
                    return o.d(1, (long) b.q(b.o(f.E(eVar))));
                }
                throw new n("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR {
            @Override // l.b.a.x.j
            public boolean b(e eVar) {
                return eVar.f(a.EPOCH_DAY) && b.m(eVar);
            }

            @Override // l.b.a.x.j
            public <R extends d> R c(R r, long j2) {
                if (b(r)) {
                    int a = a.YEAR.f4761e.a(j2, b.WEEK_BASED_YEAR);
                    f E = f.E(r);
                    a aVar = a.DAY_OF_WEEK;
                    int b = E.b(aVar);
                    int n = b.n(E);
                    if (n == 53 && b.q(a) == 52) {
                        n = 52;
                    }
                    f P = f.P(a, 1, 4);
                    return (R) r.e(P.V((long) (((n - 1) * 7) + (b - P.b(aVar)))));
                }
                throw new n("Unsupported field: WeekBasedYear");
            }

            @Override // l.b.a.x.j
            public long f(e eVar) {
                if (eVar.f(this)) {
                    return (long) b.o(f.E(eVar));
                }
                throw new n("Unsupported field: WeekBasedYear");
            }

            @Override // l.b.a.x.j
            public o h() {
                return a.YEAR.f4761e;
            }

            @Override // l.b.a.x.j
            public o l(e eVar) {
                return a.YEAR.f4761e;
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "WeekBasedYear";
            }
        };
        

        /* renamed from: f  reason: collision with root package name */
        public static final int[] f4773f = {0, 90, 181, 273, 0, 91, 182, 274};

        b(a aVar) {
        }

        public static boolean m(e eVar) {
            return h.l(eVar).equals(m.f4663d);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
            if ((r0 == -3 || (r0 == -2 && r5.K())) == false) goto L_0x0061;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public static int n(f fVar) {
            int ordinal = fVar.G().ordinal();
            int i2 = 1;
            int H = fVar.H() - 1;
            int i3 = (3 - ordinal) + H;
            int i4 = (i3 - ((i3 / 7) * 7)) - 3;
            if (i4 < -3) {
                i4 += 7;
            }
            if (H < i4) {
                if (fVar.H() != 180) {
                    fVar = f.S(fVar.b, 180);
                }
                return (int) o.d(1, (long) q(o(fVar.Y(-1)))).f4782e;
            }
            int i5 = ((H - i4) / 7) + 1;
            if (i5 == 53) {
            }
            i2 = i5;
            return i2;
        }

        public static int o(f fVar) {
            int i2 = fVar.b;
            int H = fVar.H();
            if (H <= 3) {
                return H - fVar.G().ordinal() < -2 ? i2 - 1 : i2;
            }
            if (H < 363) {
                return i2;
            }
            return ((H - 363) - (fVar.K() ? 1 : 0)) - fVar.G().ordinal() >= 0 ? i2 + 1 : i2;
        }

        public static int q(int i2) {
            f P = f.P(i2, 1, 1);
            if (P.G() != l.b.a.c.THURSDAY) {
                return (P.G() != l.b.a.c.WEDNESDAY || !P.K()) ? 52 : 53;
            }
            return 53;
        }

        @Override // l.b.a.x.j
        public boolean a() {
            return true;
        }

        @Override // l.b.a.x.j
        public e e(Map<j, Long> map, e eVar, l lVar) {
            return null;
        }

        @Override // l.b.a.x.j
        public boolean i() {
            return false;
        }
    }

    /* renamed from: l.b.a.x.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0160c implements m {
        WEEK_BASED_YEARS("WeekBasedYears", d.n(31556952)),
        QUARTER_YEARS("QuarterYears", d.n(7889238));
        
        public final String b;

        EnumC0160c(String str, d dVar) {
            this.b = str;
        }

        @Override // l.b.a.x.m
        public boolean a() {
            return true;
        }

        @Override // l.b.a.x.m
        public long b(d dVar, d dVar2) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                m mVar = c.a;
                b bVar = b.WEEK_BASED_YEAR;
                return g.b.a.c.c.d.A(dVar2.i(bVar), dVar.i(bVar));
            } else if (ordinal == 1) {
                return dVar.o(dVar2, b.MONTHS) / 3;
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        @Override // l.b.a.x.m
        public <R extends d> R c(R r, long j2) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                m mVar = c.a;
                b bVar = b.WEEK_BASED_YEAR;
                return (R) r.l(bVar, g.b.a.c.c.d.w((long) r.b(bVar), j2));
            } else if (ordinal == 1) {
                return (R) r.m(j2 / 256, b.YEARS).m((j2 % 256) * 3, b.MONTHS);
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.b;
        }
    }

    static {
        EnumC0160c cVar = EnumC0160c.QUARTER_YEARS;
    }
}
