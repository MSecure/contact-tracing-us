package g.b.a.u;

import androidx.recyclerview.widget.RecyclerView;
import b.x.t;
import g.b.a.d;
import g.b.a.g;
import g.b.a.l;
import g.b.a.n;
import g.b.a.p;
import g.b.a.q;
import g.b.a.t.b;
import g.b.a.t.f;
import g.b.a.t.h;
import g.b.a.t.m;
import g.b.a.v.c;
import g.b.a.w.e;
import g.b.a.w.j;
import g.b.a.w.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a extends c implements e, Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public final Map<j, Long> f6509b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public h f6510c;

    /* renamed from: d  reason: collision with root package name */
    public p f6511d;

    /* renamed from: e  reason: collision with root package name */
    public b f6512e;

    /* renamed from: f  reason: collision with root package name */
    public g f6513f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6514g;
    public l h;

    public a A(j jVar, long j) {
        t.y2(jVar, "field");
        Long l = this.f6509b.get(jVar);
        if (l == null || l.longValue() == j) {
            this.f6509b.put(jVar, Long.valueOf(j));
            return this;
        }
        throw new g.b.a.a("Conflict found: " + jVar + " " + l + " differs from " + jVar + " " + j + ": " + this);
    }

    public final void B(g.b.a.e eVar) {
        if (eVar != null) {
            this.f6512e = eVar;
            for (j jVar : this.f6509b.keySet()) {
                if ((jVar instanceof g.b.a.w.a) && jVar.b()) {
                    try {
                        long n = eVar.n(jVar);
                        Long l = this.f6509b.get(jVar);
                        if (n != l.longValue()) {
                            throw new g.b.a.a("Conflict found: Field " + jVar + " " + n + " differs from " + jVar + " " + l + " derived from " + eVar);
                        }
                    } catch (g.b.a.a unused) {
                        continue;
                    }
                }
            }
        }
    }

    public final void D(e eVar) {
        Iterator<Map.Entry<j, Long>> it = this.f6509b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<j, Long> next = it.next();
            j key = next.getKey();
            long longValue = next.getValue().longValue();
            if (eVar.k(key)) {
                try {
                    long n = eVar.n(key);
                    if (n == longValue) {
                        it.remove();
                    } else {
                        throw new g.b.a.a("Cross check failed: " + key + " " + n + " vs " + key + " " + longValue);
                    }
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0099, code lost:
        if (r8.longValue() > 0) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ad, code lost:
        if (r8.longValue() <= 0) goto L_0x00b0;
     */
    public final void F(l lVar) {
        g.b.a.e eVar;
        int r;
        g.b.a.e r0;
        long H2;
        g.b.a.w.a aVar;
        long H22;
        g.b.a.e n0;
        int r2;
        g.b.a.e r02;
        long H23;
        long H24;
        g.b.a.w.a aVar2;
        int i;
        long j;
        g.b.a.w.a aVar3;
        g.b.a.w.a aVar4;
        long j2;
        if (this.f6510c instanceof m) {
            m mVar = m.f6476d;
            Map<j, Long> map = this.f6509b;
            l lVar2 = l.STRICT;
            l lVar3 = l.LENIENT;
            if (map.containsKey(g.b.a.w.a.EPOCH_DAY)) {
                eVar = g.b.a.e.h0(map.remove(g.b.a.w.a.EPOCH_DAY).longValue());
            } else {
                Long remove = map.remove(g.b.a.w.a.PROLEPTIC_MONTH);
                if (remove != null) {
                    if (lVar != lVar3) {
                        g.b.a.w.a aVar5 = g.b.a.w.a.PROLEPTIC_MONTH;
                        aVar5.f6633c.b(remove.longValue(), aVar5);
                    }
                    mVar.A(map, g.b.a.w.a.MONTH_OF_YEAR, (long) (t.v1(remove.longValue(), 12) + 1));
                    mVar.A(map, g.b.a.w.a.YEAR, t.t1(remove.longValue(), 12));
                }
                Long remove2 = map.remove(g.b.a.w.a.YEAR_OF_ERA);
                if (remove2 != null) {
                    if (lVar != lVar3) {
                        g.b.a.w.a aVar6 = g.b.a.w.a.YEAR_OF_ERA;
                        aVar6.f6633c.b(remove2.longValue(), aVar6);
                    }
                    Long remove3 = map.remove(g.b.a.w.a.ERA);
                    if (remove3 == null) {
                        Long l = map.get(g.b.a.w.a.YEAR);
                        if (lVar != lVar2) {
                            aVar4 = g.b.a.w.a.YEAR;
                            if (l != null) {
                            }
                            j2 = remove2.longValue();
                            mVar.A(map, aVar4, j2);
                        } else if (l != null) {
                            aVar4 = g.b.a.w.a.YEAR;
                        } else {
                            map.put(g.b.a.w.a.YEAR_OF_ERA, remove2);
                        }
                        j2 = t.H2(1, remove2.longValue());
                        mVar.A(map, aVar4, j2);
                    } else {
                        if (remove3.longValue() == 1) {
                            aVar3 = g.b.a.w.a.YEAR;
                            j = remove2.longValue();
                        } else if (remove3.longValue() == 0) {
                            aVar3 = g.b.a.w.a.YEAR;
                            j = t.H2(1, remove2.longValue());
                        } else {
                            throw new g.b.a.a("Invalid value for era: " + remove3);
                        }
                        mVar.A(map, aVar3, j);
                    }
                } else if (map.containsKey(g.b.a.w.a.ERA)) {
                    g.b.a.w.a aVar7 = g.b.a.w.a.ERA;
                    aVar7.f6633c.b(map.get(aVar7).longValue(), aVar7);
                }
                if (map.containsKey(g.b.a.w.a.YEAR)) {
                    if (map.containsKey(g.b.a.w.a.MONTH_OF_YEAR)) {
                        if (map.containsKey(g.b.a.w.a.DAY_OF_MONTH)) {
                            g.b.a.w.a aVar8 = g.b.a.w.a.YEAR;
                            int r3 = aVar8.r(map.remove(aVar8).longValue());
                            int I2 = t.I2(map.remove(g.b.a.w.a.MONTH_OF_YEAR).longValue());
                            int I22 = t.I2(map.remove(g.b.a.w.a.DAY_OF_MONTH).longValue());
                            if (lVar == lVar3) {
                                long G2 = (long) t.G2(I2, 1);
                                H22 = (long) t.G2(I22, 1);
                                n0 = g.b.a.e.f0(r3, 1, 1).m0(G2);
                                eVar = n0.l0(H22);
                            } else {
                                if (lVar == l.SMART) {
                                    g.b.a.w.a aVar9 = g.b.a.w.a.DAY_OF_MONTH;
                                    aVar9.f6633c.b((long) I22, aVar9);
                                    if (I2 == 4 || I2 == 6 || I2 == 9 || I2 == 11) {
                                        i = 30;
                                    } else if (I2 == 2) {
                                        i = g.b.a.h.FEBRUARY.A(n.B((long) r3));
                                    }
                                    I22 = Math.min(I22, i);
                                }
                                eVar = g.b.a.e.f0(r3, I2, I22);
                            }
                        } else if (map.containsKey(g.b.a.w.a.ALIGNED_WEEK_OF_MONTH)) {
                            if (map.containsKey(g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH)) {
                                g.b.a.w.a aVar10 = g.b.a.w.a.YEAR;
                                r2 = aVar10.r(map.remove(aVar10).longValue());
                                if (lVar == lVar3) {
                                    H23 = t.H2(map.remove(g.b.a.w.a.MONTH_OF_YEAR).longValue(), 1);
                                    H24 = t.H2(map.remove(g.b.a.w.a.ALIGNED_WEEK_OF_MONTH).longValue(), 1);
                                    aVar2 = g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                                } else {
                                    g.b.a.w.a aVar11 = g.b.a.w.a.MONTH_OF_YEAR;
                                    int r4 = aVar11.r(map.remove(aVar11).longValue());
                                    g.b.a.w.a aVar12 = g.b.a.w.a.ALIGNED_WEEK_OF_MONTH;
                                    int r5 = aVar12.r(map.remove(aVar12).longValue());
                                    g.b.a.w.a aVar13 = g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                                    r02 = g.b.a.e.f0(r2, r4, 1).l0((long) ((aVar13.r(map.remove(aVar13).longValue()) - 1) + ((r5 - 1) * 7)));
                                    if (lVar == lVar2 && r02.d(g.b.a.w.a.MONTH_OF_YEAR) != r4) {
                                        throw new g.b.a.a("Strict mode rejected date parsed to a different month");
                                    }
                                    eVar = r02;
                                }
                            } else if (map.containsKey(g.b.a.w.a.DAY_OF_WEEK)) {
                                g.b.a.w.a aVar14 = g.b.a.w.a.YEAR;
                                r2 = aVar14.r(map.remove(aVar14).longValue());
                                if (lVar == lVar3) {
                                    H23 = t.H2(map.remove(g.b.a.w.a.MONTH_OF_YEAR).longValue(), 1);
                                    H24 = t.H2(map.remove(g.b.a.w.a.ALIGNED_WEEK_OF_MONTH).longValue(), 1);
                                    aVar2 = g.b.a.w.a.DAY_OF_WEEK;
                                } else {
                                    g.b.a.w.a aVar15 = g.b.a.w.a.MONTH_OF_YEAR;
                                    int r6 = aVar15.r(map.remove(aVar15).longValue());
                                    g.b.a.w.a aVar16 = g.b.a.w.a.ALIGNED_WEEK_OF_MONTH;
                                    int r7 = aVar16.r(map.remove(aVar16).longValue());
                                    g.b.a.w.a aVar17 = g.b.a.w.a.DAY_OF_WEEK;
                                    r02 = g.b.a.e.f0(r2, r6, 1).n0((long) (r7 - 1)).i(t.i2(g.b.a.b.x(aVar17.r(map.remove(aVar17).longValue()))));
                                    if (lVar == lVar2 && r02.d(g.b.a.w.a.MONTH_OF_YEAR) != r6) {
                                        throw new g.b.a.a("Strict mode rejected date parsed to a different month");
                                    }
                                    eVar = r02;
                                }
                            }
                            H22 = t.H2(map.remove(aVar2).longValue(), 1);
                            n0 = g.b.a.e.f0(r2, 1, 1).m0(H23).n0(H24);
                            eVar = n0.l0(H22);
                        }
                    }
                    if (map.containsKey(g.b.a.w.a.DAY_OF_YEAR)) {
                        g.b.a.w.a aVar18 = g.b.a.w.a.YEAR;
                        int r8 = aVar18.r(map.remove(aVar18).longValue());
                        if (lVar == lVar3) {
                            eVar = g.b.a.e.i0(r8, 1).l0(t.H2(map.remove(g.b.a.w.a.DAY_OF_YEAR).longValue(), 1));
                        } else {
                            g.b.a.w.a aVar19 = g.b.a.w.a.DAY_OF_YEAR;
                            eVar = g.b.a.e.i0(r8, aVar19.r(map.remove(aVar19).longValue()));
                        }
                    } else if (map.containsKey(g.b.a.w.a.ALIGNED_WEEK_OF_YEAR)) {
                        if (map.containsKey(g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR)) {
                            g.b.a.w.a aVar20 = g.b.a.w.a.YEAR;
                            r = aVar20.r(map.remove(aVar20).longValue());
                            if (lVar == lVar3) {
                                H2 = t.H2(map.remove(g.b.a.w.a.ALIGNED_WEEK_OF_YEAR).longValue(), 1);
                                aVar = g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                            } else {
                                g.b.a.w.a aVar21 = g.b.a.w.a.ALIGNED_WEEK_OF_YEAR;
                                int r9 = aVar21.r(map.remove(aVar21).longValue());
                                g.b.a.w.a aVar22 = g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                                r0 = g.b.a.e.f0(r, 1, 1).l0((long) ((aVar22.r(map.remove(aVar22).longValue()) - 1) + ((r9 - 1) * 7)));
                                if (lVar == lVar2 && r0.d(g.b.a.w.a.YEAR) != r) {
                                    throw new g.b.a.a("Strict mode rejected date parsed to a different year");
                                }
                                eVar = r0;
                            }
                        } else if (map.containsKey(g.b.a.w.a.DAY_OF_WEEK)) {
                            g.b.a.w.a aVar23 = g.b.a.w.a.YEAR;
                            r = aVar23.r(map.remove(aVar23).longValue());
                            if (lVar == lVar3) {
                                H2 = t.H2(map.remove(g.b.a.w.a.ALIGNED_WEEK_OF_YEAR).longValue(), 1);
                                aVar = g.b.a.w.a.DAY_OF_WEEK;
                            } else {
                                g.b.a.w.a aVar24 = g.b.a.w.a.ALIGNED_WEEK_OF_YEAR;
                                int r10 = aVar24.r(map.remove(aVar24).longValue());
                                g.b.a.w.a aVar25 = g.b.a.w.a.DAY_OF_WEEK;
                                r0 = g.b.a.e.f0(r, 1, 1).n0((long) (r10 - 1)).i(t.i2(g.b.a.b.x(aVar25.r(map.remove(aVar25).longValue()))));
                                if (lVar == lVar2 && r0.d(g.b.a.w.a.YEAR) != r) {
                                    throw new g.b.a.a("Strict mode rejected date parsed to a different month");
                                }
                                eVar = r0;
                            }
                        }
                        H22 = t.H2(map.remove(aVar).longValue(), 1);
                        n0 = g.b.a.e.f0(r, 1, 1).n0(H2);
                        eVar = n0.l0(H22);
                    }
                }
                eVar = null;
            }
            B(eVar);
        } else if (this.f6509b.containsKey(g.b.a.w.a.EPOCH_DAY)) {
            B(g.b.a.e.h0(this.f6509b.remove(g.b.a.w.a.EPOCH_DAY).longValue()));
        }
    }

    public final void G() {
        if (this.f6509b.containsKey(g.b.a.w.a.INSTANT_SECONDS)) {
            p pVar = this.f6511d;
            if (pVar == null) {
                Long l = this.f6509b.get(g.b.a.w.a.OFFSET_SECONDS);
                if (l != null) {
                    pVar = q.R(l.intValue());
                } else {
                    return;
                }
            }
            H(pVar);
        }
    }

    public final void H(p pVar) {
        f<?> B = this.f6510c.B(d.A(this.f6509b.remove(g.b.a.w.a.INSTANT_SECONDS).longValue(), 0), pVar);
        if (this.f6512e == null) {
            this.f6512e = B.L();
        } else {
            R(g.b.a.w.a.INSTANT_SECONDS, B.L());
        }
        A(g.b.a.w.a.SECOND_OF_DAY, (long) B.Q().Z());
    }

    public final void L(l lVar) {
        g.b.a.w.a aVar;
        long j;
        l lVar2 = l.SMART;
        l lVar3 = l.LENIENT;
        long j2 = 0;
        if (this.f6509b.containsKey(g.b.a.w.a.CLOCK_HOUR_OF_DAY)) {
            long longValue = this.f6509b.remove(g.b.a.w.a.CLOCK_HOUR_OF_DAY).longValue();
            if (!(lVar == lVar3 || (lVar == lVar2 && longValue == 0))) {
                g.b.a.w.a aVar2 = g.b.a.w.a.CLOCK_HOUR_OF_DAY;
                aVar2.f6633c.b(longValue, aVar2);
            }
            g.b.a.w.a aVar3 = g.b.a.w.a.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            A(aVar3, longValue);
        }
        if (this.f6509b.containsKey(g.b.a.w.a.CLOCK_HOUR_OF_AMPM)) {
            long longValue2 = this.f6509b.remove(g.b.a.w.a.CLOCK_HOUR_OF_AMPM).longValue();
            if (!(lVar == lVar3 || (lVar == lVar2 && longValue2 == 0))) {
                g.b.a.w.a aVar4 = g.b.a.w.a.CLOCK_HOUR_OF_AMPM;
                aVar4.f6633c.b(longValue2, aVar4);
            }
            g.b.a.w.a aVar5 = g.b.a.w.a.HOUR_OF_AMPM;
            if (longValue2 != 12) {
                j2 = longValue2;
            }
            A(aVar5, j2);
        }
        if (lVar != lVar3) {
            if (this.f6509b.containsKey(g.b.a.w.a.AMPM_OF_DAY)) {
                g.b.a.w.a aVar6 = g.b.a.w.a.AMPM_OF_DAY;
                aVar6.f6633c.b(this.f6509b.get(aVar6).longValue(), aVar6);
            }
            if (this.f6509b.containsKey(g.b.a.w.a.HOUR_OF_AMPM)) {
                g.b.a.w.a aVar7 = g.b.a.w.a.HOUR_OF_AMPM;
                aVar7.f6633c.b(this.f6509b.get(aVar7).longValue(), aVar7);
            }
        }
        if (this.f6509b.containsKey(g.b.a.w.a.AMPM_OF_DAY) && this.f6509b.containsKey(g.b.a.w.a.HOUR_OF_AMPM)) {
            A(g.b.a.w.a.HOUR_OF_DAY, (this.f6509b.remove(g.b.a.w.a.AMPM_OF_DAY).longValue() * 12) + this.f6509b.remove(g.b.a.w.a.HOUR_OF_AMPM).longValue());
        }
        if (this.f6509b.containsKey(g.b.a.w.a.NANO_OF_DAY)) {
            long longValue3 = this.f6509b.remove(g.b.a.w.a.NANO_OF_DAY).longValue();
            if (lVar != lVar3) {
                g.b.a.w.a aVar8 = g.b.a.w.a.NANO_OF_DAY;
                aVar8.f6633c.b(longValue3, aVar8);
            }
            A(g.b.a.w.a.SECOND_OF_DAY, longValue3 / 1000000000);
            A(g.b.a.w.a.NANO_OF_SECOND, longValue3 % 1000000000);
        }
        if (this.f6509b.containsKey(g.b.a.w.a.MICRO_OF_DAY)) {
            long longValue4 = this.f6509b.remove(g.b.a.w.a.MICRO_OF_DAY).longValue();
            if (lVar != lVar3) {
                g.b.a.w.a aVar9 = g.b.a.w.a.MICRO_OF_DAY;
                aVar9.f6633c.b(longValue4, aVar9);
            }
            A(g.b.a.w.a.SECOND_OF_DAY, longValue4 / 1000000);
            A(g.b.a.w.a.MICRO_OF_SECOND, longValue4 % 1000000);
        }
        if (this.f6509b.containsKey(g.b.a.w.a.MILLI_OF_DAY)) {
            long longValue5 = this.f6509b.remove(g.b.a.w.a.MILLI_OF_DAY).longValue();
            if (lVar != lVar3) {
                g.b.a.w.a aVar10 = g.b.a.w.a.MILLI_OF_DAY;
                aVar10.f6633c.b(longValue5, aVar10);
            }
            A(g.b.a.w.a.SECOND_OF_DAY, longValue5 / 1000);
            A(g.b.a.w.a.MILLI_OF_SECOND, longValue5 % 1000);
        }
        if (this.f6509b.containsKey(g.b.a.w.a.SECOND_OF_DAY)) {
            long longValue6 = this.f6509b.remove(g.b.a.w.a.SECOND_OF_DAY).longValue();
            if (lVar != lVar3) {
                g.b.a.w.a aVar11 = g.b.a.w.a.SECOND_OF_DAY;
                aVar11.f6633c.b(longValue6, aVar11);
            }
            A(g.b.a.w.a.HOUR_OF_DAY, longValue6 / 3600);
            A(g.b.a.w.a.MINUTE_OF_HOUR, (longValue6 / 60) % 60);
            A(g.b.a.w.a.SECOND_OF_MINUTE, longValue6 % 60);
        }
        if (this.f6509b.containsKey(g.b.a.w.a.MINUTE_OF_DAY)) {
            long longValue7 = this.f6509b.remove(g.b.a.w.a.MINUTE_OF_DAY).longValue();
            if (lVar != lVar3) {
                g.b.a.w.a aVar12 = g.b.a.w.a.MINUTE_OF_DAY;
                aVar12.f6633c.b(longValue7, aVar12);
            }
            A(g.b.a.w.a.HOUR_OF_DAY, longValue7 / 60);
            A(g.b.a.w.a.MINUTE_OF_HOUR, longValue7 % 60);
        }
        if (lVar != lVar3) {
            if (this.f6509b.containsKey(g.b.a.w.a.MILLI_OF_SECOND)) {
                g.b.a.w.a aVar13 = g.b.a.w.a.MILLI_OF_SECOND;
                aVar13.f6633c.b(this.f6509b.get(aVar13).longValue(), aVar13);
            }
            if (this.f6509b.containsKey(g.b.a.w.a.MICRO_OF_SECOND)) {
                g.b.a.w.a aVar14 = g.b.a.w.a.MICRO_OF_SECOND;
                aVar14.f6633c.b(this.f6509b.get(aVar14).longValue(), aVar14);
            }
        }
        if (this.f6509b.containsKey(g.b.a.w.a.MILLI_OF_SECOND) && this.f6509b.containsKey(g.b.a.w.a.MICRO_OF_SECOND)) {
            A(g.b.a.w.a.MICRO_OF_SECOND, (this.f6509b.get(g.b.a.w.a.MICRO_OF_SECOND).longValue() % 1000) + (this.f6509b.remove(g.b.a.w.a.MILLI_OF_SECOND).longValue() * 1000));
        }
        if (this.f6509b.containsKey(g.b.a.w.a.MICRO_OF_SECOND) && this.f6509b.containsKey(g.b.a.w.a.NANO_OF_SECOND)) {
            A(g.b.a.w.a.MICRO_OF_SECOND, this.f6509b.get(g.b.a.w.a.NANO_OF_SECOND).longValue() / 1000);
            this.f6509b.remove(g.b.a.w.a.MICRO_OF_SECOND);
        }
        if (this.f6509b.containsKey(g.b.a.w.a.MILLI_OF_SECOND) && this.f6509b.containsKey(g.b.a.w.a.NANO_OF_SECOND)) {
            A(g.b.a.w.a.MILLI_OF_SECOND, this.f6509b.get(g.b.a.w.a.NANO_OF_SECOND).longValue() / 1000000);
            this.f6509b.remove(g.b.a.w.a.MILLI_OF_SECOND);
        }
        if (this.f6509b.containsKey(g.b.a.w.a.MICRO_OF_SECOND)) {
            long longValue8 = this.f6509b.remove(g.b.a.w.a.MICRO_OF_SECOND).longValue();
            aVar = g.b.a.w.a.NANO_OF_SECOND;
            j = longValue8 * 1000;
        } else if (this.f6509b.containsKey(g.b.a.w.a.MILLI_OF_SECOND)) {
            long longValue9 = this.f6509b.remove(g.b.a.w.a.MILLI_OF_SECOND).longValue();
            aVar = g.b.a.w.a.NANO_OF_SECOND;
            j = longValue9 * 1000000;
        } else {
            return;
        }
        A(aVar, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0259, code lost:
        if (r14 != null) goto L_0x025b;
     */
    public a P(l lVar, Set<j> set) {
        f<?> fVar;
        b bVar;
        e eVar;
        g gVar;
        int i;
        g gVar2;
        g gVar3;
        if (set != null) {
            this.f6509b.keySet().retainAll(set);
        }
        G();
        F(lVar);
        L(lVar);
        boolean z = false;
        int i2 = 0;
        loop0:
        while (i2 < 100) {
            for (Map.Entry<j, Long> entry : this.f6509b.entrySet()) {
                j key = entry.getKey();
                e i3 = key.i(this.f6509b, this, lVar);
                if (i3 != null) {
                    if (i3 instanceof f) {
                        f fVar2 = (f) i3;
                        p pVar = this.f6511d;
                        if (pVar == null) {
                            this.f6511d = fVar2.D();
                        } else if (!pVar.equals(fVar2.D())) {
                            StringBuilder h2 = c.a.a.a.a.h("ChronoZonedDateTime must use the effective parsed zone: ");
                            h2.append(this.f6511d);
                            throw new g.b.a.a(h2.toString());
                        }
                        i3 = fVar2.P();
                    }
                    if (i3 instanceof b) {
                        R(key, (b) i3);
                    } else if (i3 instanceof g) {
                        Q(key, (g) i3);
                    } else if (i3 instanceof g.b.a.t.c) {
                        g.b.a.t.c cVar = (g.b.a.t.c) i3;
                        R(key, cVar.P());
                        Q(key, cVar.Q());
                    } else {
                        throw new g.b.a.a(c.a.a.a.a.e(i3, c.a.a.a.a.h("Unknown type: ")));
                    }
                } else if (!this.f6509b.containsKey(key)) {
                }
                i2++;
            }
        }
        if (i2 != 100) {
            if (i2 > 0) {
                G();
                F(lVar);
                L(lVar);
            }
            Long l = this.f6509b.get(g.b.a.w.a.HOUR_OF_DAY);
            Long l2 = this.f6509b.get(g.b.a.w.a.MINUTE_OF_HOUR);
            Long l3 = this.f6509b.get(g.b.a.w.a.SECOND_OF_MINUTE);
            Long l4 = this.f6509b.get(g.b.a.w.a.NANO_OF_SECOND);
            if (l != null && ((l2 != null || (l3 == null && l4 == null)) && (l2 == null || l3 != null || l4 == null))) {
                if (lVar != l.LENIENT) {
                    if (lVar == l.SMART && l.longValue() == 24 && ((l2 == null || l2.longValue() == 0) && ((l3 == null || l3.longValue() == 0) && (l4 == null || l4.longValue() == 0)))) {
                        l = 0L;
                        this.h = l.b(1);
                    }
                    int r = g.b.a.w.a.HOUR_OF_DAY.r(l.longValue());
                    if (l2 != null) {
                        int r2 = g.b.a.w.a.MINUTE_OF_HOUR.r(l2.longValue());
                        if (l3 != null) {
                            int r3 = g.b.a.w.a.SECOND_OF_MINUTE.r(l3.longValue());
                            gVar3 = l4 != null ? g.L(r, r2, r3, g.b.a.w.a.NANO_OF_SECOND.r(l4.longValue())) : g.H(r, r2, r3);
                        } else if (l4 == null) {
                            gVar3 = g.G(r, r2);
                        }
                    } else if (l3 == null && l4 == null) {
                        gVar3 = g.G(r, 0);
                    }
                    this.f6513f = gVar3;
                } else {
                    long longValue = l.longValue();
                    if (l2 == null) {
                        i = t.I2(t.t1(longValue, 24));
                        gVar2 = g.G((int) ((long) t.v1(longValue, 24)), 0);
                    } else if (l3 != null) {
                        if (l4 == null) {
                            l4 = 0L;
                        }
                        long D2 = t.D2(t.D2(t.D2(t.F2(longValue, 3600000000000L), t.F2(l2.longValue(), 60000000000L)), t.F2(l3.longValue(), 1000000000)), l4.longValue());
                        i = (int) t.t1(D2, 86400000000000L);
                        gVar2 = g.P(t.w1(D2, 86400000000000L));
                    } else {
                        long D22 = t.D2(t.F2(longValue, 3600), t.F2(l2.longValue(), 60));
                        i = (int) t.t1(D22, 86400);
                        gVar2 = g.Q(t.w1(D22, 86400));
                    }
                    this.f6513f = gVar2;
                    this.h = l.b(i);
                }
                this.f6509b.remove(g.b.a.w.a.HOUR_OF_DAY);
                this.f6509b.remove(g.b.a.w.a.MINUTE_OF_HOUR);
                this.f6509b.remove(g.b.a.w.a.SECOND_OF_MINUTE);
                this.f6509b.remove(g.b.a.w.a.NANO_OF_SECOND);
            }
            if (this.f6509b.size() > 0) {
                b bVar2 = this.f6512e;
                if (bVar2 == null || (gVar = this.f6513f) == null) {
                    eVar = this.f6512e;
                    if (eVar == null) {
                        eVar = this.f6513f;
                    }
                } else {
                    eVar = bVar2.A(gVar);
                }
                D(eVar);
            }
            l lVar2 = this.h;
            if (lVar2 != null) {
                if (lVar2 != null) {
                    if (lVar2 == l.f6434e) {
                        z = true;
                    }
                    if (!(z || (bVar = this.f6512e) == null || this.f6513f == null)) {
                        this.f6512e = bVar.L(this.h);
                        this.h = l.f6434e;
                    }
                } else {
                    throw null;
                }
            }
            if (this.f6513f == null && (this.f6509b.containsKey(g.b.a.w.a.INSTANT_SECONDS) || this.f6509b.containsKey(g.b.a.w.a.SECOND_OF_DAY) || this.f6509b.containsKey(g.b.a.w.a.SECOND_OF_MINUTE))) {
                if (this.f6509b.containsKey(g.b.a.w.a.NANO_OF_SECOND)) {
                    long longValue2 = this.f6509b.get(g.b.a.w.a.NANO_OF_SECOND).longValue();
                    this.f6509b.put(g.b.a.w.a.MICRO_OF_SECOND, Long.valueOf(longValue2 / 1000));
                    this.f6509b.put(g.b.a.w.a.MILLI_OF_SECOND, Long.valueOf(longValue2 / 1000000));
                } else {
                    this.f6509b.put(g.b.a.w.a.NANO_OF_SECOND, 0L);
                    this.f6509b.put(g.b.a.w.a.MICRO_OF_SECOND, 0L);
                    this.f6509b.put(g.b.a.w.a.MILLI_OF_SECOND, 0L);
                }
            }
            if (!(this.f6512e == null || this.f6513f == null)) {
                Long l5 = this.f6509b.get(g.b.a.w.a.OFFSET_SECONDS);
                if (l5 != null) {
                    fVar = this.f6512e.A(this.f6513f).A(q.R(l5.intValue()));
                } else if (this.f6511d != null) {
                    fVar = this.f6512e.A(this.f6513f).A(this.f6511d);
                }
                this.f6509b.put(g.b.a.w.a.INSTANT_SECONDS, Long.valueOf(fVar.n(g.b.a.w.a.INSTANT_SECONDS)));
            }
            return this;
        }
        throw new g.b.a.a("Badly written field");
    }

    public final void Q(j jVar, g gVar) {
        long Y = gVar.Y();
        Long put = this.f6509b.put(g.b.a.w.a.NANO_OF_DAY, Long.valueOf(Y));
        if (put != null && put.longValue() != Y) {
            StringBuilder h2 = c.a.a.a.a.h("Conflict found: ");
            h2.append(g.P(put.longValue()));
            h2.append(" differs from ");
            h2.append(gVar);
            h2.append(" while resolving  ");
            h2.append(jVar);
            throw new g.b.a.a(h2.toString());
        }
    }

    public final void R(j jVar, b bVar) {
        if (this.f6510c.equals(bVar.D())) {
            long P = bVar.P();
            Long put = this.f6509b.put(g.b.a.w.a.EPOCH_DAY, Long.valueOf(P));
            if (put != null && put.longValue() != P) {
                StringBuilder h2 = c.a.a.a.a.h("Conflict found: ");
                h2.append(g.b.a.e.h0(put.longValue()));
                h2.append(" differs from ");
                h2.append(g.b.a.e.h0(P));
                h2.append(" while resolving  ");
                h2.append(jVar);
                throw new g.b.a.a(h2.toString());
            }
            return;
        }
        StringBuilder h3 = c.a.a.a.a.h("ChronoLocalDate must use the effective parsed chronology: ");
        h3.append(this.f6510c);
        throw new g.b.a.a(h3.toString());
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(g.b.a.w.l<R> lVar) {
        if (lVar == k.f6656a) {
            return (R) this.f6511d;
        }
        if (lVar == k.f6657b) {
            return (R) this.f6510c;
        }
        if (lVar == k.f6661f) {
            b bVar = this.f6512e;
            if (bVar != null) {
                return (R) g.b.a.e.V(bVar);
            }
            return null;
        } else if (lVar == k.f6662g) {
            return (R) this.f6513f;
        } else {
            if (lVar == k.f6659d || lVar == k.f6660e) {
                return lVar.a(this);
            }
            if (lVar == k.f6658c) {
                return null;
            }
            return lVar.a(this);
        }
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        b bVar;
        g gVar;
        if (jVar == null) {
            return false;
        }
        return this.f6509b.containsKey(jVar) || ((bVar = this.f6512e) != null && bVar.k(jVar)) || ((gVar = this.f6513f) != null && gVar.k(jVar));
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        t.y2(jVar, "field");
        Long l = this.f6509b.get(jVar);
        if (l != null) {
            return l.longValue();
        }
        b bVar = this.f6512e;
        if (bVar != null && bVar.k(jVar)) {
            return this.f6512e.n(jVar);
        }
        g gVar = this.f6513f;
        if (gVar != null && gVar.k(jVar)) {
            return this.f6513f.n(jVar);
        }
        throw new g.b.a.a(c.a.a.a.a.d("Field not found: ", jVar));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) RecyclerView.a0.FLAG_IGNORE);
        sb.append("DateTimeBuilder[");
        if (this.f6509b.size() > 0) {
            sb.append("fields=");
            sb.append(this.f6509b);
        }
        sb.append(", ");
        sb.append(this.f6510c);
        sb.append(", ");
        sb.append(this.f6511d);
        sb.append(", ");
        sb.append(this.f6512e);
        sb.append(", ");
        sb.append(this.f6513f);
        sb.append(']');
        return sb.toString();
    }
}
