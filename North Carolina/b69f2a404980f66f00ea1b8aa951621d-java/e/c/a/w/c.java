package e.c.a.w;

import e.c.a.e;
import e.c.a.t.h;
import e.c.a.t.m;
import e.c.a.u.l;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final j f5163a = b.QUARTER_OF_YEAR;

    /* renamed from: b  reason: collision with root package name */
    public static final j f5164b = b.WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: c  reason: collision with root package name */
    public static final j f5165c = b.WEEK_BASED_YEAR;

    /* renamed from: d  reason: collision with root package name */
    public static final m f5166d = EnumC0124c.WEEK_BASED_YEARS;

    public enum b implements j {
        DAY_OF_QUARTER {
            @Override // e.c.a.w.j
            public boolean d(e eVar) {
                return eVar.i(a.DAY_OF_YEAR) && eVar.i(a.MONTH_OF_YEAR) && eVar.i(a.YEAR) && b.o(eVar);
            }

            @Override // e.c.a.w.j
            public <R extends d> R f(R r, long j) {
                long i = i(r);
                k().b(j, this);
                a aVar = a.DAY_OF_YEAR;
                return (R) r.n(aVar, (j - i) + r.l(aVar));
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x007b, code lost:
                if (r0 == 2) goto L_0x007d;
             */
            @Override // e.c.a.w.c.b, e.c.a.w.j
            public e g(Map<j, Long> map, e eVar, l lVar) {
                e eVar2;
                o oVar;
                Long l = map.get(a.YEAR);
                Long l2 = map.get(b.QUARTER_OF_YEAR);
                if (l == null || l2 == null) {
                    return null;
                }
                int o = a.YEAR.o(l.longValue());
                long longValue = map.get(b.DAY_OF_QUARTER).longValue();
                if (lVar == l.LENIENT) {
                    eVar2 = e.P(o, 1, 1).W(c.b.a.a.c.n.c.Z1(c.b.a.a.c.n.c.c2(l2.longValue(), 1), 3)).V(c.b.a.a.c.n.c.c2(longValue, 1));
                } else {
                    int a2 = ((C0122b) b.QUARTER_OF_YEAR).k().a(l2.longValue(), b.QUARTER_OF_YEAR);
                    if (lVar == l.STRICT) {
                        int i = 92;
                        if (a2 == 1) {
                            if (!m.f5027d.x((long) o)) {
                                i = 90;
                                oVar = o.d(1, (long) i);
                            }
                        }
                        i = 91;
                        oVar = o.d(1, (long) i);
                    } else {
                        oVar = k();
                    }
                    oVar.b(longValue, this);
                    eVar2 = e.P(o, ((a2 - 1) * 3) + 1, 1).V(longValue - 1);
                }
                map.remove(this);
                map.remove(a.YEAR);
                map.remove(b.QUARTER_OF_YEAR);
                return eVar2;
            }

            @Override // e.c.a.w.j
            public long i(e eVar) {
                if (eVar.i(this)) {
                    return (long) (eVar.d(a.DAY_OF_YEAR) - b.f[((eVar.d(a.MONTH_OF_YEAR) - 1) / 3) + (m.f5027d.x(eVar.l(a.YEAR)) ? 4 : 0)]);
                }
                throw new n("Unsupported field: DayOfQuarter");
            }

            @Override // e.c.a.w.j
            public o k() {
                return o.e(1, 90, 92);
            }

            @Override // e.c.a.w.j
            public o n(e eVar) {
                if (eVar.i(this)) {
                    long l = eVar.l(b.QUARTER_OF_YEAR);
                    if (l != 1) {
                        return l == 2 ? o.d(1, 91) : (l == 3 || l == 4) ? o.d(1, 92) : k();
                    }
                    return m.f5027d.x(eVar.l(a.YEAR)) ? o.d(1, 91) : o.d(1, 90);
                }
                throw new n("Unsupported field: DayOfQuarter");
            }

            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR {
            @Override // e.c.a.w.j
            public boolean d(e eVar) {
                return eVar.i(a.MONTH_OF_YEAR) && b.o(eVar);
            }

            @Override // e.c.a.w.j
            public <R extends d> R f(R r, long j) {
                long i = i(r);
                k().b(j, this);
                a aVar = a.MONTH_OF_YEAR;
                return (R) r.n(aVar, ((j - i) * 3) + r.l(aVar));
            }

            @Override // e.c.a.w.j
            public long i(e eVar) {
                if (eVar.i(this)) {
                    return (eVar.l(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new n("Unsupported field: QuarterOfYear");
            }

            @Override // e.c.a.w.j
            public o k() {
                return o.d(1, 4);
            }

            @Override // e.c.a.w.j
            public o n(e eVar) {
                return k();
            }

            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            @Override // e.c.a.w.j
            public boolean d(e eVar) {
                return eVar.i(a.EPOCH_DAY) && b.o(eVar);
            }

            @Override // e.c.a.w.j
            public <R extends d> R f(R r, long j) {
                k().b(j, this);
                return (R) r.o(c.b.a.a.c.n.c.c2(j, i(r)), b.WEEKS);
            }

            @Override // e.c.a.w.c.b, e.c.a.w.j
            public e g(Map<j, Long> map, e eVar, l lVar) {
                e eVar2;
                o oVar;
                Long l = map.get(b.WEEK_BASED_YEAR);
                Long l2 = map.get(a.DAY_OF_WEEK);
                if (l == null || l2 == null) {
                    return null;
                }
                int a2 = a.YEAR.f5158c.a(l.longValue(), b.WEEK_BASED_YEAR);
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
                    eVar2 = e.P(a2, 1, 4).X(longValue - 1).X(j).n(a.DAY_OF_WEEK, longValue2);
                } else {
                    int o = a.DAY_OF_WEEK.o(l2.longValue());
                    if (lVar == l.STRICT) {
                        oVar = o.d(1, (long) b.s(b.q(e.P(a2, 1, 4))));
                    } else {
                        oVar = k();
                    }
                    oVar.b(longValue, this);
                    eVar2 = e.P(a2, 1, 4).X(longValue - 1).n(a.DAY_OF_WEEK, (long) o);
                }
                map.remove(this);
                map.remove(b.WEEK_BASED_YEAR);
                map.remove(a.DAY_OF_WEEK);
                return eVar2;
            }

            @Override // e.c.a.w.j
            public long i(e eVar) {
                if (eVar.i(this)) {
                    return (long) b.p(e.F(eVar));
                }
                throw new n("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // e.c.a.w.j
            public o k() {
                return o.e(1, 52, 53);
            }

            @Override // e.c.a.w.j
            public o n(e eVar) {
                if (eVar.i(this)) {
                    return o.d(1, (long) b.s(b.q(e.F(eVar))));
                }
                throw new n("Unsupported field: WeekOfWeekBasedYear");
            }

            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR {
            @Override // e.c.a.w.j
            public boolean d(e eVar) {
                return eVar.i(a.EPOCH_DAY) && b.o(eVar);
            }

            @Override // e.c.a.w.j
            public <R extends d> R f(R r, long j) {
                if (d(r)) {
                    int a2 = a.YEAR.f5158c.a(j, b.WEEK_BASED_YEAR);
                    e F = e.F(r);
                    int d2 = F.d(a.DAY_OF_WEEK);
                    int p = b.p(F);
                    if (p == 53 && b.s(a2) == 52) {
                        p = 52;
                    }
                    e P = e.P(a2, 1, 4);
                    return (R) r.g(P.V((long) (((p - 1) * 7) + (d2 - P.d(a.DAY_OF_WEEK)))));
                }
                throw new n("Unsupported field: WeekBasedYear");
            }

            @Override // e.c.a.w.j
            public long i(e eVar) {
                if (eVar.i(this)) {
                    return (long) b.q(e.F(eVar));
                }
                throw new n("Unsupported field: WeekBasedYear");
            }

            @Override // e.c.a.w.j
            public o k() {
                return a.YEAR.f5158c;
            }

            @Override // e.c.a.w.j
            public o n(e eVar) {
                return a.YEAR.f5158c;
            }

            public String toString() {
                return "WeekBasedYear";
            }
        };
        
        public static final int[] f = {0, 90, 181, 273, 0, 91, 182, 274};

        /* access modifiers changed from: public */
        b(a aVar) {
        }

        public static boolean o(e eVar) {
            return h.n(eVar).equals(m.f5027d);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
            if ((r0 == -3 || (r0 == -2 && r5.L())) == false) goto L_0x0061;
         */
        public static int p(e eVar) {
            int ordinal = eVar.H().ordinal();
            int i = 1;
            int I = eVar.I() - 1;
            int i2 = (3 - ordinal) + I;
            int i3 = (i2 - ((i2 / 7) * 7)) - 3;
            if (i3 < -3) {
                i3 += 7;
            }
            if (I < i3) {
                if (eVar.I() != 180) {
                    eVar = e.S(eVar.f4970b, 180);
                }
                return (int) o.d(1, (long) s(q(eVar.Y(-1)))).f5185e;
            }
            int i4 = ((I - i3) / 7) + 1;
            if (i4 == 53) {
            }
            i = i4;
            return i;
        }

        public static int q(e eVar) {
            int i = eVar.f4970b;
            int I = eVar.I();
            if (I <= 3) {
                return I - eVar.H().ordinal() < -2 ? i - 1 : i;
            }
            if (I < 363) {
                return i;
            }
            return ((I - 363) - (eVar.L() ? 1 : 0)) - eVar.H().ordinal() >= 0 ? i + 1 : i;
        }

        public static int s(int i) {
            e P = e.P(i, 1, 1);
            if (P.H() != e.c.a.b.THURSDAY) {
                return (P.H() != e.c.a.b.WEDNESDAY || !P.L()) ? 52 : 53;
            }
            return 53;
        }

        @Override // e.c.a.w.j
        public boolean b() {
            return true;
        }

        @Override // e.c.a.w.j
        public e g(Map<j, Long> map, e eVar, l lVar) {
            return null;
        }

        @Override // e.c.a.w.j
        public boolean l() {
            return false;
        }
    }

    /* renamed from: e.c.a.w.c$c  reason: collision with other inner class name */
    public enum EnumC0124c implements m {
        WEEK_BASED_YEARS("WeekBasedYears", e.c.a.c.k(31556952)),
        QUARTER_YEARS("QuarterYears", e.c.a.c.k(7889238));
        

        /* renamed from: b  reason: collision with root package name */
        public final String f5174b;

        /* access modifiers changed from: public */
        EnumC0124c(String str, e.c.a.c cVar) {
            this.f5174b = str;
        }

        @Override // e.c.a.w.m
        public boolean b() {
            return true;
        }

        @Override // e.c.a.w.m
        public long d(d dVar, d dVar2) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return c.b.a.a.c.n.c.c2(dVar2.l(c.f5165c), dVar.l(c.f5165c));
            }
            if (ordinal == 1) {
                return dVar.q(dVar2, b.MONTHS) / 3;
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // e.c.a.w.m
        public <R extends d> R f(R r, long j) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return (R) r.n(c.f5165c, c.b.a.a.c.n.c.Y1((long) r.d(c.f5165c), j));
            } else if (ordinal == 1) {
                return (R) r.o(j / 256, b.YEARS).o((j % 256) * 3, b.MONTHS);
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        public String toString() {
            return this.f5174b;
        }
    }

    static {
        EnumC0124c cVar = EnumC0124c.QUARTER_YEARS;
    }
}
