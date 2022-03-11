package l.b.a.u;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import l.b.a.d;
import l.b.a.g;
import l.b.a.l;
import l.b.a.n;
import l.b.a.p;
import l.b.a.q;
import l.b.a.t.b;
import l.b.a.t.f;
import l.b.a.t.h;
import l.b.a.t.m;
import l.b.a.v.c;
import l.b.a.w.e;
import l.b.a.w.j;
import l.b.a.w.k;

public final class a extends c implements e, Cloneable {
    public final Map<j, Long> b = new HashMap();
    public h c;

    /* renamed from: d  reason: collision with root package name */
    public p f4115d;

    /* renamed from: e  reason: collision with root package name */
    public b f4116e;

    /* renamed from: f  reason: collision with root package name */
    public g f4117f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4118g;

    /* renamed from: h  reason: collision with root package name */
    public l f4119h;

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l.b.a.w.l<R> lVar) {
        if (lVar == k.a) {
            return (R) this.f4115d;
        }
        if (lVar == k.b) {
            return (R) this.c;
        }
        if (lVar == k.f4208f) {
            b bVar = this.f4116e;
            if (bVar != null) {
                return (R) l.b.a.e.E(bVar);
            }
            return null;
        } else if (lVar == k.f4209g) {
            return (R) this.f4117f;
        } else {
            if (lVar == k.f4206d || lVar == k.f4207e) {
                return lVar.a(this);
            }
            if (lVar == k.c) {
                return null;
            }
            return lVar.a(this);
        }
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        b bVar;
        g gVar;
        if (jVar == null) {
            return false;
        }
        return this.b.containsKey(jVar) || ((bVar = this.f4116e) != null && bVar.f(jVar)) || ((gVar = this.f4117f) != null && gVar.f(jVar));
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        f.b.a.c.b.o.b.B1(jVar, "field");
        Long l2 = this.b.get(jVar);
        if (l2 != null) {
            return l2.longValue();
        }
        b bVar = this.f4116e;
        if (bVar != null && bVar.f(jVar)) {
            return this.f4116e.i(jVar);
        }
        g gVar = this.f4117f;
        if (gVar != null && gVar.f(jVar)) {
            return this.f4117f.i(jVar);
        }
        throw new l.b.a.a(f.a.a.a.a.d("Field not found: ", jVar));
    }

    public a q(j jVar, long j2) {
        f.b.a.c.b.o.b.B1(jVar, "field");
        Long l2 = this.b.get(jVar);
        if (l2 == null || l2.longValue() == j2) {
            this.b.put(jVar, Long.valueOf(j2));
            return this;
        }
        throw new l.b.a.a("Conflict found: " + jVar + " " + l2 + " differs from " + jVar + " " + j2 + ": " + this);
    }

    public final void r(l.b.a.e eVar) {
        if (eVar != null) {
            this.f4116e = eVar;
            for (j jVar : this.b.keySet()) {
                if ((jVar instanceof l.b.a.w.a) && jVar.a()) {
                    try {
                        long i2 = eVar.i(jVar);
                        Long l2 = this.b.get(jVar);
                        if (i2 != l2.longValue()) {
                            throw new l.b.a.a("Conflict found: Field " + jVar + " " + i2 + " differs from " + jVar + " " + l2 + " derived from " + eVar);
                        }
                    } catch (l.b.a.a unused) {
                        continue;
                    }
                }
            }
        }
    }

    public final void s(e eVar) {
        Iterator<Map.Entry<j, Long>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<j, Long> next = it.next();
            j key = next.getKey();
            long longValue = next.getValue().longValue();
            if (eVar.f(key)) {
                try {
                    long i2 = eVar.i(key);
                    if (i2 == longValue) {
                        it.remove();
                    } else {
                        throw new l.b.a.a("Cross check failed: " + key + " " + i2 + " vs " + key + " " + longValue);
                    }
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0091, code lost:
        if (r12.longValue() > 0) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a1, code lost:
        if (r12.longValue() <= 0) goto L_0x00a4;
     */
    public final void t(l lVar) {
        l.b.a.e eVar;
        l.b.a.e a0;
        long L1;
        long L12;
        l.b.a.e P;
        int m;
        l.b.a.e a02;
        int i2;
        long j2;
        l.b.a.w.a aVar;
        long j3;
        if (this.c instanceof m) {
            m mVar = m.f4092d;
            Map<j, Long> map = this.b;
            l lVar2 = l.STRICT;
            l lVar3 = l.LENIENT;
            l.b.a.w.a aVar2 = l.b.a.w.a.EPOCH_DAY;
            if (map.containsKey(aVar2)) {
                eVar = l.b.a.e.R(map.remove(aVar2).longValue());
            } else {
                l.b.a.w.a aVar3 = l.b.a.w.a.PROLEPTIC_MONTH;
                Long remove = map.remove(aVar3);
                if (remove != null) {
                    if (lVar != lVar3) {
                        aVar3.f4190e.b(remove.longValue(), aVar3);
                    }
                    mVar.r(map, l.b.a.w.a.MONTH_OF_YEAR, (long) (f.b.a.c.b.o.b.C0(remove.longValue(), 12) + 1));
                    mVar.r(map, l.b.a.w.a.YEAR, f.b.a.c.b.o.b.B0(remove.longValue(), 12));
                }
                l.b.a.w.a aVar4 = l.b.a.w.a.YEAR_OF_ERA;
                Long remove2 = map.remove(aVar4);
                if (remove2 != null) {
                    if (lVar != lVar3) {
                        aVar4.f4190e.b(remove2.longValue(), aVar4);
                    }
                    Long remove3 = map.remove(l.b.a.w.a.ERA);
                    if (remove3 == null) {
                        l.b.a.w.a aVar5 = l.b.a.w.a.YEAR;
                        Long l2 = map.get(aVar5);
                        if (lVar != lVar2) {
                            if (l2 != null) {
                            }
                            j3 = remove2.longValue();
                            mVar.r(map, aVar5, j3);
                        } else if (l2 == null) {
                            map.put(aVar4, remove2);
                        }
                        j3 = f.b.a.c.b.o.b.L1(1, remove2.longValue());
                        mVar.r(map, aVar5, j3);
                    } else {
                        if (remove3.longValue() == 1) {
                            aVar = l.b.a.w.a.YEAR;
                            j2 = remove2.longValue();
                        } else if (remove3.longValue() == 0) {
                            aVar = l.b.a.w.a.YEAR;
                            j2 = f.b.a.c.b.o.b.L1(1, remove2.longValue());
                        } else {
                            throw new l.b.a.a("Invalid value for era: " + remove3);
                        }
                        mVar.r(map, aVar, j2);
                    }
                } else {
                    l.b.a.w.a aVar6 = l.b.a.w.a.ERA;
                    if (map.containsKey(aVar6)) {
                        aVar6.f4190e.b(map.get(aVar6).longValue(), aVar6);
                    }
                }
                l.b.a.w.a aVar7 = l.b.a.w.a.YEAR;
                if (map.containsKey(aVar7)) {
                    l.b.a.w.a aVar8 = l.b.a.w.a.MONTH_OF_YEAR;
                    if (map.containsKey(aVar8)) {
                        l.b.a.w.a aVar9 = l.b.a.w.a.DAY_OF_MONTH;
                        if (map.containsKey(aVar9)) {
                            int m2 = aVar7.m(map.remove(aVar7).longValue());
                            int M1 = f.b.a.c.b.o.b.M1(map.remove(aVar8).longValue());
                            int M12 = f.b.a.c.b.o.b.M1(map.remove(aVar9).longValue());
                            if (lVar == lVar3) {
                                long K1 = (long) f.b.a.c.b.o.b.K1(M1, 1);
                                eVar = l.b.a.e.P(m2, 1, 1).W(K1).V((long) f.b.a.c.b.o.b.K1(M12, 1));
                            } else {
                                if (lVar == l.SMART) {
                                    aVar9.f4190e.b((long) M12, aVar9);
                                    if (M1 == 4 || M1 == 6 || M1 == 9 || M1 == 11) {
                                        i2 = 30;
                                    } else if (M1 == 2) {
                                        i2 = l.b.a.h.FEBRUARY.s(n.r((long) m2));
                                    }
                                    M12 = Math.min(M12, i2);
                                }
                                eVar = l.b.a.e.P(m2, M1, M12);
                            }
                        } else {
                            l.b.a.w.a aVar10 = l.b.a.w.a.ALIGNED_WEEK_OF_MONTH;
                            if (map.containsKey(aVar10)) {
                                l.b.a.w.a aVar11 = l.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                                if (map.containsKey(aVar11)) {
                                    m = aVar7.m(map.remove(aVar7).longValue());
                                    if (lVar != lVar3) {
                                        int m3 = aVar8.m(map.remove(aVar8).longValue());
                                        int m4 = aVar10.m(map.remove(aVar10).longValue());
                                        a02 = l.b.a.e.P(m, m3, 1).V((long) ((aVar11.m(map.remove(aVar11).longValue()) - 1) + ((m4 - 1) * 7)));
                                        if (lVar == lVar2 && a02.b(aVar8) != m3) {
                                            throw new l.b.a.a("Strict mode rejected date parsed to a different month");
                                        }
                                        eVar = a02;
                                    }
                                } else {
                                    aVar11 = l.b.a.w.a.DAY_OF_WEEK;
                                    if (map.containsKey(aVar11)) {
                                        m = aVar7.m(map.remove(aVar7).longValue());
                                        if (lVar != lVar3) {
                                            int m5 = aVar8.m(map.remove(aVar8).longValue());
                                            a02 = l.b.a.e.P(m, m5, 1).X((long) (aVar10.m(map.remove(aVar10).longValue()) - 1)).y(f.b.a.c.b.o.b.s1(l.b.a.b.r(aVar11.m(map.remove(aVar11).longValue()))));
                                            if (lVar == lVar2 && a02.b(aVar8) != m5) {
                                                throw new l.b.a.a("Strict mode rejected date parsed to a different month");
                                            }
                                            eVar = a02;
                                        }
                                    }
                                }
                                long L13 = f.b.a.c.b.o.b.L1(map.remove(aVar8).longValue(), 1);
                                long L14 = f.b.a.c.b.o.b.L1(map.remove(aVar10).longValue(), 1);
                                eVar = l.b.a.e.P(m, 1, 1).W(L13).X(L14).V(f.b.a.c.b.o.b.L1(map.remove(aVar11).longValue(), 1));
                            }
                        }
                    }
                    l.b.a.w.a aVar12 = l.b.a.w.a.DAY_OF_YEAR;
                    if (map.containsKey(aVar12)) {
                        int m6 = aVar7.m(map.remove(aVar7).longValue());
                        long longValue = map.remove(aVar12).longValue();
                        if (lVar == lVar3) {
                            eVar = l.b.a.e.S(m6, 1).V(f.b.a.c.b.o.b.L1(longValue, 1));
                        } else {
                            eVar = l.b.a.e.S(m6, aVar12.m(longValue));
                        }
                    } else {
                        l.b.a.w.a aVar13 = l.b.a.w.a.ALIGNED_WEEK_OF_YEAR;
                        if (map.containsKey(aVar13)) {
                            l.b.a.w.a aVar14 = l.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                            if (map.containsKey(aVar14)) {
                                int m7 = aVar7.m(map.remove(aVar7).longValue());
                                if (lVar == lVar3) {
                                    L1 = f.b.a.c.b.o.b.L1(map.remove(aVar13).longValue(), 1);
                                    L12 = f.b.a.c.b.o.b.L1(map.remove(aVar14).longValue(), 1);
                                    P = l.b.a.e.P(m7, 1, 1);
                                } else {
                                    int m8 = aVar13.m(map.remove(aVar13).longValue());
                                    a0 = l.b.a.e.P(m7, 1, 1).V((long) ((aVar14.m(map.remove(aVar14).longValue()) - 1) + ((m8 - 1) * 7)));
                                    if (lVar == lVar2 && a0.b(aVar7) != m7) {
                                        throw new l.b.a.a("Strict mode rejected date parsed to a different year");
                                    }
                                    eVar = a0;
                                }
                            } else {
                                l.b.a.w.a aVar15 = l.b.a.w.a.DAY_OF_WEEK;
                                if (map.containsKey(aVar15)) {
                                    int m9 = aVar7.m(map.remove(aVar7).longValue());
                                    if (lVar == lVar3) {
                                        L1 = f.b.a.c.b.o.b.L1(map.remove(aVar13).longValue(), 1);
                                        L12 = f.b.a.c.b.o.b.L1(map.remove(aVar15).longValue(), 1);
                                        P = l.b.a.e.P(m9, 1, 1);
                                    } else {
                                        a0 = l.b.a.e.P(m9, 1, 1).X((long) (aVar13.m(map.remove(aVar13).longValue()) - 1)).y(f.b.a.c.b.o.b.s1(l.b.a.b.r(aVar15.m(map.remove(aVar15).longValue()))));
                                        if (lVar == lVar2 && a0.b(aVar7) != m9) {
                                            throw new l.b.a.a("Strict mode rejected date parsed to a different month");
                                        }
                                        eVar = a0;
                                    }
                                }
                            }
                            eVar = P.X(L1).V(L12);
                        }
                    }
                }
                eVar = null;
            }
            r(eVar);
            return;
        }
        Map<j, Long> map2 = this.b;
        l.b.a.w.a aVar16 = l.b.a.w.a.EPOCH_DAY;
        if (map2.containsKey(aVar16)) {
            r(l.b.a.e.R(this.b.remove(aVar16).longValue()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("DateTimeBuilder[");
        if (this.b.size() > 0) {
            sb.append("fields=");
            sb.append(this.b);
        }
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.f4115d);
        sb.append(", ");
        sb.append(this.f4116e);
        sb.append(", ");
        sb.append(this.f4117f);
        sb.append(']');
        return sb.toString();
    }

    public final void u() {
        if (this.b.containsKey(l.b.a.w.a.INSTANT_SECONDS)) {
            p pVar = this.f4115d;
            if (pVar == null) {
                Long l2 = this.b.get(l.b.a.w.a.OFFSET_SECONDS);
                if (l2 != null) {
                    pVar = q.z(l2.intValue());
                } else {
                    return;
                }
            }
            v(pVar);
        }
    }

    public final void v(p pVar) {
        Map<j, Long> map = this.b;
        l.b.a.w.a aVar = l.b.a.w.a.INSTANT_SECONDS;
        f<?> s = this.c.s(d.r(map.remove(aVar).longValue(), 0), pVar);
        if (this.f4116e == null) {
            this.f4116e = s.x();
        } else {
            z(aVar, s.x());
        }
        q(l.b.a.w.a.SECOND_OF_DAY, (long) s.z().F());
    }

    public final void w(l lVar) {
        l.b.a.w.a aVar;
        long j2;
        l lVar2 = l.SMART;
        l lVar3 = l.LENIENT;
        Map<j, Long> map = this.b;
        l.b.a.w.a aVar2 = l.b.a.w.a.CLOCK_HOUR_OF_DAY;
        long j3 = 0;
        if (map.containsKey(aVar2)) {
            long longValue = this.b.remove(aVar2).longValue();
            if (!(lVar == lVar3 || (lVar == lVar2 && longValue == 0))) {
                aVar2.f4190e.b(longValue, aVar2);
            }
            l.b.a.w.a aVar3 = l.b.a.w.a.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            q(aVar3, longValue);
        }
        Map<j, Long> map2 = this.b;
        l.b.a.w.a aVar4 = l.b.a.w.a.CLOCK_HOUR_OF_AMPM;
        if (map2.containsKey(aVar4)) {
            long longValue2 = this.b.remove(aVar4).longValue();
            if (!(lVar == lVar3 || (lVar == lVar2 && longValue2 == 0))) {
                aVar4.f4190e.b(longValue2, aVar4);
            }
            l.b.a.w.a aVar5 = l.b.a.w.a.HOUR_OF_AMPM;
            if (longValue2 != 12) {
                j3 = longValue2;
            }
            q(aVar5, j3);
        }
        if (lVar != lVar3) {
            Map<j, Long> map3 = this.b;
            l.b.a.w.a aVar6 = l.b.a.w.a.AMPM_OF_DAY;
            if (map3.containsKey(aVar6)) {
                aVar6.f4190e.b(this.b.get(aVar6).longValue(), aVar6);
            }
            Map<j, Long> map4 = this.b;
            l.b.a.w.a aVar7 = l.b.a.w.a.HOUR_OF_AMPM;
            if (map4.containsKey(aVar7)) {
                aVar7.f4190e.b(this.b.get(aVar7).longValue(), aVar7);
            }
        }
        Map<j, Long> map5 = this.b;
        l.b.a.w.a aVar8 = l.b.a.w.a.AMPM_OF_DAY;
        if (map5.containsKey(aVar8)) {
            Map<j, Long> map6 = this.b;
            l.b.a.w.a aVar9 = l.b.a.w.a.HOUR_OF_AMPM;
            if (map6.containsKey(aVar9)) {
                q(l.b.a.w.a.HOUR_OF_DAY, (this.b.remove(aVar8).longValue() * 12) + this.b.remove(aVar9).longValue());
            }
        }
        Map<j, Long> map7 = this.b;
        l.b.a.w.a aVar10 = l.b.a.w.a.NANO_OF_DAY;
        if (map7.containsKey(aVar10)) {
            long longValue3 = this.b.remove(aVar10).longValue();
            if (lVar != lVar3) {
                aVar10.f4190e.b(longValue3, aVar10);
            }
            q(l.b.a.w.a.SECOND_OF_DAY, longValue3 / 1000000000);
            q(l.b.a.w.a.NANO_OF_SECOND, longValue3 % 1000000000);
        }
        Map<j, Long> map8 = this.b;
        l.b.a.w.a aVar11 = l.b.a.w.a.MICRO_OF_DAY;
        if (map8.containsKey(aVar11)) {
            long longValue4 = this.b.remove(aVar11).longValue();
            if (lVar != lVar3) {
                aVar11.f4190e.b(longValue4, aVar11);
            }
            q(l.b.a.w.a.SECOND_OF_DAY, longValue4 / 1000000);
            q(l.b.a.w.a.MICRO_OF_SECOND, longValue4 % 1000000);
        }
        Map<j, Long> map9 = this.b;
        l.b.a.w.a aVar12 = l.b.a.w.a.MILLI_OF_DAY;
        if (map9.containsKey(aVar12)) {
            long longValue5 = this.b.remove(aVar12).longValue();
            if (lVar != lVar3) {
                aVar12.f4190e.b(longValue5, aVar12);
            }
            q(l.b.a.w.a.SECOND_OF_DAY, longValue5 / 1000);
            q(l.b.a.w.a.MILLI_OF_SECOND, longValue5 % 1000);
        }
        Map<j, Long> map10 = this.b;
        l.b.a.w.a aVar13 = l.b.a.w.a.SECOND_OF_DAY;
        if (map10.containsKey(aVar13)) {
            long longValue6 = this.b.remove(aVar13).longValue();
            if (lVar != lVar3) {
                aVar13.f4190e.b(longValue6, aVar13);
            }
            q(l.b.a.w.a.HOUR_OF_DAY, longValue6 / 3600);
            q(l.b.a.w.a.MINUTE_OF_HOUR, (longValue6 / 60) % 60);
            q(l.b.a.w.a.SECOND_OF_MINUTE, longValue6 % 60);
        }
        Map<j, Long> map11 = this.b;
        l.b.a.w.a aVar14 = l.b.a.w.a.MINUTE_OF_DAY;
        if (map11.containsKey(aVar14)) {
            long longValue7 = this.b.remove(aVar14).longValue();
            if (lVar != lVar3) {
                aVar14.f4190e.b(longValue7, aVar14);
            }
            q(l.b.a.w.a.HOUR_OF_DAY, longValue7 / 60);
            q(l.b.a.w.a.MINUTE_OF_HOUR, longValue7 % 60);
        }
        if (lVar != lVar3) {
            Map<j, Long> map12 = this.b;
            l.b.a.w.a aVar15 = l.b.a.w.a.MILLI_OF_SECOND;
            if (map12.containsKey(aVar15)) {
                aVar15.f4190e.b(this.b.get(aVar15).longValue(), aVar15);
            }
            Map<j, Long> map13 = this.b;
            l.b.a.w.a aVar16 = l.b.a.w.a.MICRO_OF_SECOND;
            if (map13.containsKey(aVar16)) {
                aVar16.f4190e.b(this.b.get(aVar16).longValue(), aVar16);
            }
        }
        Map<j, Long> map14 = this.b;
        l.b.a.w.a aVar17 = l.b.a.w.a.MILLI_OF_SECOND;
        if (map14.containsKey(aVar17)) {
            Map<j, Long> map15 = this.b;
            l.b.a.w.a aVar18 = l.b.a.w.a.MICRO_OF_SECOND;
            if (map15.containsKey(aVar18)) {
                q(aVar18, (this.b.get(aVar18).longValue() % 1000) + (this.b.remove(aVar17).longValue() * 1000));
            }
        }
        Map<j, Long> map16 = this.b;
        l.b.a.w.a aVar19 = l.b.a.w.a.MICRO_OF_SECOND;
        if (map16.containsKey(aVar19)) {
            Map<j, Long> map17 = this.b;
            l.b.a.w.a aVar20 = l.b.a.w.a.NANO_OF_SECOND;
            if (map17.containsKey(aVar20)) {
                q(aVar19, this.b.get(aVar20).longValue() / 1000);
                this.b.remove(aVar19);
            }
        }
        if (this.b.containsKey(aVar17)) {
            Map<j, Long> map18 = this.b;
            l.b.a.w.a aVar21 = l.b.a.w.a.NANO_OF_SECOND;
            if (map18.containsKey(aVar21)) {
                q(aVar17, this.b.get(aVar21).longValue() / 1000000);
                this.b.remove(aVar17);
            }
        }
        if (this.b.containsKey(aVar19)) {
            long longValue8 = this.b.remove(aVar19).longValue();
            aVar = l.b.a.w.a.NANO_OF_SECOND;
            j2 = longValue8 * 1000;
        } else if (this.b.containsKey(aVar17)) {
            long longValue9 = this.b.remove(aVar17).longValue();
            aVar = l.b.a.w.a.NANO_OF_SECOND;
            j2 = longValue9 * 1000000;
        } else {
            return;
        }
        q(aVar, j2);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x026c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [l.b.a.w.e, l.b.a.u.a] */
    /* JADX WARN: Type inference failed for: r2v21, types: [l.b.a.t.b] */
    /* JADX WARN: Type inference failed for: r2v22, types: [l.b.a.w.e] */
    /* JADX WARN: Type inference failed for: r2v23, types: [l.b.a.g] */
    /* JADX WARN: Type inference failed for: r2v24, types: [l.b.a.t.c] */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0271, code lost:
        if (r2 != 0) goto L_0x0273;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    public a x(l lVar, Set<j> set) {
        f<?> fVar;
        b bVar;
        g gVar;
        int i2;
        g gVar2;
        g gVar3;
        g gVar4;
        if (set != null) {
            this.b.keySet().retainAll(set);
        }
        u();
        t(lVar);
        w(lVar);
        int i3 = 0;
        loop0:
        while (i3 < 100) {
            for (Map.Entry<j, Long> entry : this.b.entrySet()) {
                j key = entry.getKey();
                e e2 = key.e(this.b, this, lVar);
                if (e2 != null) {
                    if (e2 instanceof f) {
                        f fVar2 = (f) e2;
                        p pVar = this.f4115d;
                        if (pVar == null) {
                            this.f4115d = fVar2.s();
                        } else if (!pVar.equals(fVar2.s())) {
                            StringBuilder h2 = f.a.a.a.a.h("ChronoZonedDateTime must use the effective parsed zone: ");
                            h2.append(this.f4115d);
                            throw new l.b.a.a(h2.toString());
                        }
                        e2 = fVar2.y();
                    }
                    if (e2 instanceof b) {
                        z(key, (b) e2);
                    } else if (e2 instanceof g) {
                        y(key, (g) e2);
                    } else if (e2 instanceof l.b.a.t.c) {
                        l.b.a.t.c cVar = (l.b.a.t.c) e2;
                        z(key, cVar.x());
                        y(key, cVar.y());
                    } else {
                        throw new l.b.a.a(f.a.a.a.a.f(e2, f.a.a.a.a.h("Unknown type: ")));
                    }
                } else if (!this.b.containsKey(key)) {
                }
                i3++;
            }
        }
        if (i3 != 100) {
            if (i3 > 0) {
                u();
                t(lVar);
                w(lVar);
            }
            Map<j, Long> map = this.b;
            l.b.a.w.a aVar = l.b.a.w.a.HOUR_OF_DAY;
            Long l2 = map.get(aVar);
            Map<j, Long> map2 = this.b;
            l.b.a.w.a aVar2 = l.b.a.w.a.MINUTE_OF_HOUR;
            Long l3 = map2.get(aVar2);
            Map<j, Long> map3 = this.b;
            l.b.a.w.a aVar3 = l.b.a.w.a.SECOND_OF_MINUTE;
            Long l4 = map3.get(aVar3);
            Map<j, Long> map4 = this.b;
            l.b.a.w.a aVar4 = l.b.a.w.a.NANO_OF_SECOND;
            Long l5 = map4.get(aVar4);
            if (l2 != null && ((l3 != null || (l4 == null && l5 == null)) && (l3 == null || l4 != null || l5 == null))) {
                if (lVar != l.LENIENT) {
                    if (lVar == l.SMART && l2.longValue() == 24 && ((l3 == null || l3.longValue() == 0) && ((l4 == null || l4.longValue() == 0) && (l5 == null || l5.longValue() == 0)))) {
                        l2 = 0L;
                        this.f4119h = l.c(1);
                    }
                    int m = aVar.m(l2.longValue());
                    if (l3 != null) {
                        int m2 = aVar2.m(l3.longValue());
                        if (l4 != null) {
                            int m3 = aVar3.m(l4.longValue());
                            if (l5 != null) {
                                gVar4 = g.v(m, m2, m3, aVar4.m(l5.longValue()));
                            } else {
                                g gVar5 = g.f4047f;
                                aVar.f4190e.b((long) m, aVar);
                                if ((m2 | m3) == 0) {
                                    gVar4 = g.f4050i[m];
                                } else {
                                    aVar2.f4190e.b((long) m2, aVar2);
                                    aVar3.f4190e.b((long) m3, aVar3);
                                    gVar4 = new g(m, m2, m3, 0);
                                }
                            }
                        } else if (l5 == null) {
                            gVar4 = g.u(m, m2);
                        }
                    } else if (l4 == null && l5 == null) {
                        gVar4 = g.u(m, 0);
                    }
                    this.f4117f = gVar4;
                } else {
                    long longValue = l2.longValue();
                    if (l3 != null) {
                        if (l4 != null) {
                            if (l5 == null) {
                                l5 = 0L;
                            }
                            long H1 = f.b.a.c.b.o.b.H1(f.b.a.c.b.o.b.H1(f.b.a.c.b.o.b.H1(f.b.a.c.b.o.b.J1(longValue, 3600000000000L), f.b.a.c.b.o.b.J1(l3.longValue(), 60000000000L)), f.b.a.c.b.o.b.J1(l4.longValue(), 1000000000)), l5.longValue());
                            i2 = (int) f.b.a.c.b.o.b.B0(H1, 86400000000000L);
                            gVar3 = g.w(f.b.a.c.b.o.b.D0(H1, 86400000000000L));
                        } else {
                            long H12 = f.b.a.c.b.o.b.H1(f.b.a.c.b.o.b.J1(longValue, 3600), f.b.a.c.b.o.b.J1(l3.longValue(), 60));
                            i2 = (int) f.b.a.c.b.o.b.B0(H12, 86400);
                            gVar3 = g.x(f.b.a.c.b.o.b.D0(H12, 86400));
                        }
                        gVar2 = gVar3;
                    } else {
                        i2 = f.b.a.c.b.o.b.M1(f.b.a.c.b.o.b.B0(longValue, 24));
                        gVar2 = g.u((int) ((long) f.b.a.c.b.o.b.C0(longValue, 24)), 0);
                    }
                    this.f4117f = gVar2;
                    this.f4119h = l.c(i2);
                }
                this.b.remove(aVar);
                this.b.remove(aVar2);
                this.b.remove(aVar3);
                this.b.remove(aVar4);
            }
            if (this.b.size() > 0) {
                ?? r2 = this.f4116e;
                if (r2 != 0 && (gVar = this.f4117f) != null) {
                    r2 = r2.q(gVar);
                } else if (r2 == 0) {
                    r2 = this.f4117f;
                }
                s(r2);
            }
            l lVar2 = this.f4119h;
            if (lVar2 != null) {
                Objects.requireNonNull(lVar2);
                l lVar3 = l.f4065e;
                if (!((lVar2 == lVar3) || (bVar = this.f4116e) == null || this.f4117f == null)) {
                    this.f4116e = bVar.w(this.f4119h);
                    this.f4119h = lVar3;
                }
            }
            if (this.f4117f == null && (this.b.containsKey(l.b.a.w.a.INSTANT_SECONDS) || this.b.containsKey(l.b.a.w.a.SECOND_OF_DAY) || this.b.containsKey(aVar3))) {
                if (this.b.containsKey(aVar4)) {
                    long longValue2 = this.b.get(aVar4).longValue();
                    this.b.put(l.b.a.w.a.MICRO_OF_SECOND, Long.valueOf(longValue2 / 1000));
                    this.b.put(l.b.a.w.a.MILLI_OF_SECOND, Long.valueOf(longValue2 / 1000000));
                } else {
                    this.b.put(aVar4, 0L);
                    this.b.put(l.b.a.w.a.MICRO_OF_SECOND, 0L);
                    this.b.put(l.b.a.w.a.MILLI_OF_SECOND, 0L);
                }
            }
            if (!(this.f4116e == null || this.f4117f == null)) {
                Long l6 = this.b.get(l.b.a.w.a.OFFSET_SECONDS);
                if (l6 != null) {
                    fVar = this.f4116e.q(this.f4117f).q(q.z(l6.intValue()));
                } else if (this.f4115d != null) {
                    fVar = this.f4116e.q(this.f4117f).q(this.f4115d);
                }
                l.b.a.w.a aVar5 = l.b.a.w.a.INSTANT_SECONDS;
                this.b.put(aVar5, Long.valueOf(fVar.i(aVar5)));
            }
            return this;
        }
        throw new l.b.a.a("Badly written field");
    }

    public final void y(j jVar, g gVar) {
        long E = gVar.E();
        Long put = this.b.put(l.b.a.w.a.NANO_OF_DAY, Long.valueOf(E));
        if (put != null && put.longValue() != E) {
            StringBuilder h2 = f.a.a.a.a.h("Conflict found: ");
            h2.append(g.w(put.longValue()));
            h2.append(" differs from ");
            h2.append(gVar);
            h2.append(" while resolving  ");
            h2.append(jVar);
            throw new l.b.a.a(h2.toString());
        }
    }

    public final void z(j jVar, b bVar) {
        if (this.c.equals(bVar.s())) {
            long x = bVar.x();
            Long put = this.b.put(l.b.a.w.a.EPOCH_DAY, Long.valueOf(x));
            if (put != null && put.longValue() != x) {
                StringBuilder h2 = f.a.a.a.a.h("Conflict found: ");
                h2.append(l.b.a.e.R(put.longValue()));
                h2.append(" differs from ");
                h2.append(l.b.a.e.R(x));
                h2.append(" while resolving  ");
                h2.append(jVar);
                throw new l.b.a.a(h2.toString());
            }
            return;
        }
        StringBuilder h3 = f.a.a.a.a.h("ChronoLocalDate must use the effective parsed chronology: ");
        h3.append(this.c);
        throw new l.b.a.a(h3.toString());
    }
}
