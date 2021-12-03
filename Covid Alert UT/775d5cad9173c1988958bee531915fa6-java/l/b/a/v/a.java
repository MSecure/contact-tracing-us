package l.b.a.v;

import g.b.a.c.c.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import l.b.a.f;
import l.b.a.i;
import l.b.a.m;
import l.b.a.o;
import l.b.a.q;
import l.b.a.r;
import l.b.a.u.b;
import l.b.a.u.h;
import l.b.a.w.c;
import l.b.a.x.e;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;

public final class a extends c implements e, Cloneable {
    public final Map<j, Long> b = new HashMap();
    public h c;

    /* renamed from: d  reason: collision with root package name */
    public q f4431d;

    /* renamed from: e  reason: collision with root package name */
    public b f4432e;

    /* renamed from: f  reason: collision with root package name */
    public l.b.a.h f4433f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4434g;

    /* renamed from: h  reason: collision with root package name */
    public m f4435h;

    @Override // l.b.a.x.e, l.b.a.w.c
    public <R> R c(l<R> lVar) {
        if (lVar == k.a) {
            return (R) this.f4431d;
        }
        if (lVar == k.b) {
            return (R) this.c;
        }
        if (lVar == k.f4524f) {
            b bVar = this.f4432e;
            if (bVar != null) {
                return (R) f.E(bVar);
            }
            return null;
        } else if (lVar == k.f4525g) {
            return (R) this.f4433f;
        } else {
            if (lVar == k.f4522d || lVar == k.f4523e) {
                return lVar.a(this);
            }
            if (lVar == k.c) {
                return null;
            }
            return lVar.a(this);
        }
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        b bVar;
        l.b.a.h hVar;
        if (jVar == null) {
            return false;
        }
        return this.b.containsKey(jVar) || ((bVar = this.f4432e) != null && bVar.f(jVar)) || ((hVar = this.f4433f) != null && hVar.f(jVar));
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        d.u(jVar, "field");
        Long l2 = this.b.get(jVar);
        if (l2 != null) {
            return l2.longValue();
        }
        b bVar = this.f4432e;
        if (bVar != null && bVar.f(jVar)) {
            return this.f4432e.i(jVar);
        }
        l.b.a.h hVar = this.f4433f;
        if (hVar != null && hVar.f(jVar)) {
            return this.f4433f.i(jVar);
        }
        throw new l.b.a.b(f.a.a.a.a.d("Field not found: ", jVar));
    }

    public a q(j jVar, long j2) {
        d.u(jVar, "field");
        Long l2 = this.b.get(jVar);
        if (l2 == null || l2.longValue() == j2) {
            this.b.put(jVar, Long.valueOf(j2));
            return this;
        }
        throw new l.b.a.b("Conflict found: " + jVar + " " + l2 + " differs from " + jVar + " " + j2 + ": " + this);
    }

    public final void r(f fVar) {
        if (fVar != null) {
            this.f4432e = fVar;
            for (j jVar : this.b.keySet()) {
                if ((jVar instanceof l.b.a.x.a) && jVar.a()) {
                    try {
                        long i2 = fVar.i(jVar);
                        Long l2 = this.b.get(jVar);
                        if (i2 != l2.longValue()) {
                            throw new l.b.a.b("Conflict found: Field " + jVar + " " + i2 + " differs from " + jVar + " " + l2 + " derived from " + fVar);
                        }
                    } catch (l.b.a.b unused) {
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
                        throw new l.b.a.b("Cross check failed: " + key + " " + i2 + " vs " + key + " " + longValue);
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
        f fVar;
        f a0;
        long A;
        long A2;
        f P;
        int m;
        f a02;
        int i2;
        long j2;
        l.b.a.x.a aVar;
        long j3;
        if (this.c instanceof l.b.a.u.m) {
            l.b.a.u.m mVar = l.b.a.u.m.f4408d;
            Map<j, Long> map = this.b;
            l lVar2 = l.STRICT;
            l lVar3 = l.LENIENT;
            l.b.a.x.a aVar2 = l.b.a.x.a.EPOCH_DAY;
            if (map.containsKey(aVar2)) {
                fVar = f.R(map.remove(aVar2).longValue());
            } else {
                l.b.a.x.a aVar3 = l.b.a.x.a.PROLEPTIC_MONTH;
                Long remove = map.remove(aVar3);
                if (remove != null) {
                    if (lVar != lVar3) {
                        aVar3.f4506e.b(remove.longValue(), aVar3);
                    }
                    mVar.r(map, l.b.a.x.a.MONTH_OF_YEAR, (long) (d.k(remove.longValue(), 12) + 1));
                    mVar.r(map, l.b.a.x.a.YEAR, d.i(remove.longValue(), 12));
                }
                l.b.a.x.a aVar4 = l.b.a.x.a.YEAR_OF_ERA;
                Long remove2 = map.remove(aVar4);
                if (remove2 != null) {
                    if (lVar != lVar3) {
                        aVar4.f4506e.b(remove2.longValue(), aVar4);
                    }
                    Long remove3 = map.remove(l.b.a.x.a.ERA);
                    if (remove3 == null) {
                        l.b.a.x.a aVar5 = l.b.a.x.a.YEAR;
                        Long l2 = map.get(aVar5);
                        if (lVar != lVar2) {
                            if (l2 != null) {
                            }
                            j3 = remove2.longValue();
                            mVar.r(map, aVar5, j3);
                        } else if (l2 == null) {
                            map.put(aVar4, remove2);
                        }
                        j3 = d.A(1, remove2.longValue());
                        mVar.r(map, aVar5, j3);
                    } else {
                        if (remove3.longValue() == 1) {
                            aVar = l.b.a.x.a.YEAR;
                            j2 = remove2.longValue();
                        } else if (remove3.longValue() == 0) {
                            aVar = l.b.a.x.a.YEAR;
                            j2 = d.A(1, remove2.longValue());
                        } else {
                            throw new l.b.a.b("Invalid value for era: " + remove3);
                        }
                        mVar.r(map, aVar, j2);
                    }
                } else {
                    l.b.a.x.a aVar6 = l.b.a.x.a.ERA;
                    if (map.containsKey(aVar6)) {
                        aVar6.f4506e.b(map.get(aVar6).longValue(), aVar6);
                    }
                }
                l.b.a.x.a aVar7 = l.b.a.x.a.YEAR;
                if (map.containsKey(aVar7)) {
                    l.b.a.x.a aVar8 = l.b.a.x.a.MONTH_OF_YEAR;
                    if (map.containsKey(aVar8)) {
                        l.b.a.x.a aVar9 = l.b.a.x.a.DAY_OF_MONTH;
                        if (map.containsKey(aVar9)) {
                            int m2 = aVar7.m(map.remove(aVar7).longValue());
                            int B = d.B(map.remove(aVar8).longValue());
                            int B2 = d.B(map.remove(aVar9).longValue());
                            if (lVar == lVar3) {
                                long z = (long) d.z(B, 1);
                                fVar = f.P(m2, 1, 1).W(z).V((long) d.z(B2, 1));
                            } else {
                                if (lVar == l.SMART) {
                                    aVar9.f4506e.b((long) B2, aVar9);
                                    if (B == 4 || B == 6 || B == 9 || B == 11) {
                                        i2 = 30;
                                    } else if (B == 2) {
                                        i2 = i.FEBRUARY.s(o.r((long) m2));
                                    }
                                    B2 = Math.min(B2, i2);
                                }
                                fVar = f.P(m2, B, B2);
                            }
                        } else {
                            l.b.a.x.a aVar10 = l.b.a.x.a.ALIGNED_WEEK_OF_MONTH;
                            if (map.containsKey(aVar10)) {
                                l.b.a.x.a aVar11 = l.b.a.x.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                                if (map.containsKey(aVar11)) {
                                    m = aVar7.m(map.remove(aVar7).longValue());
                                    if (lVar != lVar3) {
                                        int m3 = aVar8.m(map.remove(aVar8).longValue());
                                        int m4 = aVar10.m(map.remove(aVar10).longValue());
                                        a02 = f.P(m, m3, 1).V((long) ((aVar11.m(map.remove(aVar11).longValue()) - 1) + ((m4 - 1) * 7)));
                                        if (lVar == lVar2 && a02.b(aVar8) != m3) {
                                            throw new l.b.a.b("Strict mode rejected date parsed to a different month");
                                        }
                                        fVar = a02;
                                    }
                                } else {
                                    aVar11 = l.b.a.x.a.DAY_OF_WEEK;
                                    if (map.containsKey(aVar11)) {
                                        m = aVar7.m(map.remove(aVar7).longValue());
                                        if (lVar != lVar3) {
                                            int m5 = aVar8.m(map.remove(aVar8).longValue());
                                            a02 = f.P(m, m5, 1).X((long) (aVar10.m(map.remove(aVar10).longValue()) - 1)).y(d.s(l.b.a.c.r(aVar11.m(map.remove(aVar11).longValue()))));
                                            if (lVar == lVar2 && a02.b(aVar8) != m5) {
                                                throw new l.b.a.b("Strict mode rejected date parsed to a different month");
                                            }
                                            fVar = a02;
                                        }
                                    }
                                }
                                long A3 = d.A(map.remove(aVar8).longValue(), 1);
                                long A4 = d.A(map.remove(aVar10).longValue(), 1);
                                fVar = f.P(m, 1, 1).W(A3).X(A4).V(d.A(map.remove(aVar11).longValue(), 1));
                            }
                        }
                    }
                    l.b.a.x.a aVar12 = l.b.a.x.a.DAY_OF_YEAR;
                    if (map.containsKey(aVar12)) {
                        int m6 = aVar7.m(map.remove(aVar7).longValue());
                        long longValue = map.remove(aVar12).longValue();
                        if (lVar == lVar3) {
                            fVar = f.S(m6, 1).V(d.A(longValue, 1));
                        } else {
                            fVar = f.S(m6, aVar12.m(longValue));
                        }
                    } else {
                        l.b.a.x.a aVar13 = l.b.a.x.a.ALIGNED_WEEK_OF_YEAR;
                        if (map.containsKey(aVar13)) {
                            l.b.a.x.a aVar14 = l.b.a.x.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                            if (map.containsKey(aVar14)) {
                                int m7 = aVar7.m(map.remove(aVar7).longValue());
                                if (lVar == lVar3) {
                                    A = d.A(map.remove(aVar13).longValue(), 1);
                                    A2 = d.A(map.remove(aVar14).longValue(), 1);
                                    P = f.P(m7, 1, 1);
                                } else {
                                    int m8 = aVar13.m(map.remove(aVar13).longValue());
                                    a0 = f.P(m7, 1, 1).V((long) ((aVar14.m(map.remove(aVar14).longValue()) - 1) + ((m8 - 1) * 7)));
                                    if (lVar == lVar2 && a0.b(aVar7) != m7) {
                                        throw new l.b.a.b("Strict mode rejected date parsed to a different year");
                                    }
                                    fVar = a0;
                                }
                            } else {
                                l.b.a.x.a aVar15 = l.b.a.x.a.DAY_OF_WEEK;
                                if (map.containsKey(aVar15)) {
                                    int m9 = aVar7.m(map.remove(aVar7).longValue());
                                    if (lVar == lVar3) {
                                        A = d.A(map.remove(aVar13).longValue(), 1);
                                        A2 = d.A(map.remove(aVar15).longValue(), 1);
                                        P = f.P(m9, 1, 1);
                                    } else {
                                        a0 = f.P(m9, 1, 1).X((long) (aVar13.m(map.remove(aVar13).longValue()) - 1)).y(d.s(l.b.a.c.r(aVar15.m(map.remove(aVar15).longValue()))));
                                        if (lVar == lVar2 && a0.b(aVar7) != m9) {
                                            throw new l.b.a.b("Strict mode rejected date parsed to a different month");
                                        }
                                        fVar = a0;
                                    }
                                }
                            }
                            fVar = P.X(A).V(A2);
                        }
                    }
                }
                fVar = null;
            }
            r(fVar);
            return;
        }
        Map<j, Long> map2 = this.b;
        l.b.a.x.a aVar16 = l.b.a.x.a.EPOCH_DAY;
        if (map2.containsKey(aVar16)) {
            r(f.R(this.b.remove(aVar16).longValue()));
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
        sb.append(this.f4431d);
        sb.append(", ");
        sb.append(this.f4432e);
        sb.append(", ");
        sb.append(this.f4433f);
        sb.append(']');
        return sb.toString();
    }

    public final void u() {
        if (this.b.containsKey(l.b.a.x.a.INSTANT_SECONDS)) {
            q qVar = this.f4431d;
            if (qVar == null) {
                Long l2 = this.b.get(l.b.a.x.a.OFFSET_SECONDS);
                if (l2 != null) {
                    qVar = r.z(l2.intValue());
                } else {
                    return;
                }
            }
            v(qVar);
        }
    }

    public final void v(q qVar) {
        Map<j, Long> map = this.b;
        l.b.a.x.a aVar = l.b.a.x.a.INSTANT_SECONDS;
        l.b.a.u.f<?> s = this.c.s(l.b.a.e.A(map.remove(aVar).longValue()), qVar);
        if (this.f4432e == null) {
            this.f4432e = s.x();
        } else {
            z(aVar, s.x());
        }
        q(l.b.a.x.a.SECOND_OF_DAY, (long) s.z().F());
    }

    public final void w(l lVar) {
        l.b.a.x.a aVar;
        long j2;
        l lVar2 = l.SMART;
        l lVar3 = l.LENIENT;
        Map<j, Long> map = this.b;
        l.b.a.x.a aVar2 = l.b.a.x.a.CLOCK_HOUR_OF_DAY;
        long j3 = 0;
        if (map.containsKey(aVar2)) {
            long longValue = this.b.remove(aVar2).longValue();
            if (!(lVar == lVar3 || (lVar == lVar2 && longValue == 0))) {
                aVar2.f4506e.b(longValue, aVar2);
            }
            l.b.a.x.a aVar3 = l.b.a.x.a.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            q(aVar3, longValue);
        }
        Map<j, Long> map2 = this.b;
        l.b.a.x.a aVar4 = l.b.a.x.a.CLOCK_HOUR_OF_AMPM;
        if (map2.containsKey(aVar4)) {
            long longValue2 = this.b.remove(aVar4).longValue();
            if (!(lVar == lVar3 || (lVar == lVar2 && longValue2 == 0))) {
                aVar4.f4506e.b(longValue2, aVar4);
            }
            l.b.a.x.a aVar5 = l.b.a.x.a.HOUR_OF_AMPM;
            if (longValue2 != 12) {
                j3 = longValue2;
            }
            q(aVar5, j3);
        }
        if (lVar != lVar3) {
            Map<j, Long> map3 = this.b;
            l.b.a.x.a aVar6 = l.b.a.x.a.AMPM_OF_DAY;
            if (map3.containsKey(aVar6)) {
                aVar6.f4506e.b(this.b.get(aVar6).longValue(), aVar6);
            }
            Map<j, Long> map4 = this.b;
            l.b.a.x.a aVar7 = l.b.a.x.a.HOUR_OF_AMPM;
            if (map4.containsKey(aVar7)) {
                aVar7.f4506e.b(this.b.get(aVar7).longValue(), aVar7);
            }
        }
        Map<j, Long> map5 = this.b;
        l.b.a.x.a aVar8 = l.b.a.x.a.AMPM_OF_DAY;
        if (map5.containsKey(aVar8)) {
            Map<j, Long> map6 = this.b;
            l.b.a.x.a aVar9 = l.b.a.x.a.HOUR_OF_AMPM;
            if (map6.containsKey(aVar9)) {
                q(l.b.a.x.a.HOUR_OF_DAY, (this.b.remove(aVar8).longValue() * 12) + this.b.remove(aVar9).longValue());
            }
        }
        Map<j, Long> map7 = this.b;
        l.b.a.x.a aVar10 = l.b.a.x.a.NANO_OF_DAY;
        if (map7.containsKey(aVar10)) {
            long longValue3 = this.b.remove(aVar10).longValue();
            if (lVar != lVar3) {
                aVar10.f4506e.b(longValue3, aVar10);
            }
            q(l.b.a.x.a.SECOND_OF_DAY, longValue3 / 1000000000);
            q(l.b.a.x.a.NANO_OF_SECOND, longValue3 % 1000000000);
        }
        Map<j, Long> map8 = this.b;
        l.b.a.x.a aVar11 = l.b.a.x.a.MICRO_OF_DAY;
        if (map8.containsKey(aVar11)) {
            long longValue4 = this.b.remove(aVar11).longValue();
            if (lVar != lVar3) {
                aVar11.f4506e.b(longValue4, aVar11);
            }
            q(l.b.a.x.a.SECOND_OF_DAY, longValue4 / 1000000);
            q(l.b.a.x.a.MICRO_OF_SECOND, longValue4 % 1000000);
        }
        Map<j, Long> map9 = this.b;
        l.b.a.x.a aVar12 = l.b.a.x.a.MILLI_OF_DAY;
        if (map9.containsKey(aVar12)) {
            long longValue5 = this.b.remove(aVar12).longValue();
            if (lVar != lVar3) {
                aVar12.f4506e.b(longValue5, aVar12);
            }
            q(l.b.a.x.a.SECOND_OF_DAY, longValue5 / 1000);
            q(l.b.a.x.a.MILLI_OF_SECOND, longValue5 % 1000);
        }
        Map<j, Long> map10 = this.b;
        l.b.a.x.a aVar13 = l.b.a.x.a.SECOND_OF_DAY;
        if (map10.containsKey(aVar13)) {
            long longValue6 = this.b.remove(aVar13).longValue();
            if (lVar != lVar3) {
                aVar13.f4506e.b(longValue6, aVar13);
            }
            q(l.b.a.x.a.HOUR_OF_DAY, longValue6 / 3600);
            q(l.b.a.x.a.MINUTE_OF_HOUR, (longValue6 / 60) % 60);
            q(l.b.a.x.a.SECOND_OF_MINUTE, longValue6 % 60);
        }
        Map<j, Long> map11 = this.b;
        l.b.a.x.a aVar14 = l.b.a.x.a.MINUTE_OF_DAY;
        if (map11.containsKey(aVar14)) {
            long longValue7 = this.b.remove(aVar14).longValue();
            if (lVar != lVar3) {
                aVar14.f4506e.b(longValue7, aVar14);
            }
            q(l.b.a.x.a.HOUR_OF_DAY, longValue7 / 60);
            q(l.b.a.x.a.MINUTE_OF_HOUR, longValue7 % 60);
        }
        if (lVar != lVar3) {
            Map<j, Long> map12 = this.b;
            l.b.a.x.a aVar15 = l.b.a.x.a.MILLI_OF_SECOND;
            if (map12.containsKey(aVar15)) {
                aVar15.f4506e.b(this.b.get(aVar15).longValue(), aVar15);
            }
            Map<j, Long> map13 = this.b;
            l.b.a.x.a aVar16 = l.b.a.x.a.MICRO_OF_SECOND;
            if (map13.containsKey(aVar16)) {
                aVar16.f4506e.b(this.b.get(aVar16).longValue(), aVar16);
            }
        }
        Map<j, Long> map14 = this.b;
        l.b.a.x.a aVar17 = l.b.a.x.a.MILLI_OF_SECOND;
        if (map14.containsKey(aVar17)) {
            Map<j, Long> map15 = this.b;
            l.b.a.x.a aVar18 = l.b.a.x.a.MICRO_OF_SECOND;
            if (map15.containsKey(aVar18)) {
                q(aVar18, (this.b.get(aVar18).longValue() % 1000) + (this.b.remove(aVar17).longValue() * 1000));
            }
        }
        Map<j, Long> map16 = this.b;
        l.b.a.x.a aVar19 = l.b.a.x.a.MICRO_OF_SECOND;
        if (map16.containsKey(aVar19)) {
            Map<j, Long> map17 = this.b;
            l.b.a.x.a aVar20 = l.b.a.x.a.NANO_OF_SECOND;
            if (map17.containsKey(aVar20)) {
                q(aVar19, this.b.get(aVar20).longValue() / 1000);
                this.b.remove(aVar19);
            }
        }
        if (this.b.containsKey(aVar17)) {
            Map<j, Long> map18 = this.b;
            l.b.a.x.a aVar21 = l.b.a.x.a.NANO_OF_SECOND;
            if (map18.containsKey(aVar21)) {
                q(aVar17, this.b.get(aVar21).longValue() / 1000000);
                this.b.remove(aVar17);
            }
        }
        if (this.b.containsKey(aVar19)) {
            long longValue8 = this.b.remove(aVar19).longValue();
            aVar = l.b.a.x.a.NANO_OF_SECOND;
            j2 = longValue8 * 1000;
        } else if (this.b.containsKey(aVar17)) {
            long longValue9 = this.b.remove(aVar17).longValue();
            aVar = l.b.a.x.a.NANO_OF_SECOND;
            j2 = longValue9 * 1000000;
        } else {
            return;
        }
        q(aVar, j2);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x026c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [l.b.a.x.e, l.b.a.v.a] */
    /* JADX WARN: Type inference failed for: r2v21, types: [l.b.a.u.b] */
    /* JADX WARN: Type inference failed for: r2v22, types: [l.b.a.x.e] */
    /* JADX WARN: Type inference failed for: r2v23, types: [l.b.a.h] */
    /* JADX WARN: Type inference failed for: r2v24, types: [l.b.a.u.c] */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0271, code lost:
        if (r2 != 0) goto L_0x0273;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    public a x(l lVar, Set<j> set) {
        l.b.a.u.f<?> fVar;
        b bVar;
        l.b.a.h hVar;
        int i2;
        l.b.a.h hVar2;
        l.b.a.h hVar3;
        l.b.a.h hVar4;
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
                    if (e2 instanceof l.b.a.u.f) {
                        l.b.a.u.f fVar2 = (l.b.a.u.f) e2;
                        q qVar = this.f4431d;
                        if (qVar == null) {
                            this.f4431d = fVar2.s();
                        } else if (!qVar.equals(fVar2.s())) {
                            StringBuilder h2 = f.a.a.a.a.h("ChronoZonedDateTime must use the effective parsed zone: ");
                            h2.append(this.f4431d);
                            throw new l.b.a.b(h2.toString());
                        }
                        e2 = fVar2.y();
                    }
                    if (e2 instanceof b) {
                        z(key, (b) e2);
                    } else if (e2 instanceof l.b.a.h) {
                        y(key, (l.b.a.h) e2);
                    } else if (e2 instanceof l.b.a.u.c) {
                        l.b.a.u.c cVar = (l.b.a.u.c) e2;
                        z(key, cVar.x());
                        y(key, cVar.y());
                    } else {
                        throw new l.b.a.b(f.a.a.a.a.f(e2, f.a.a.a.a.h("Unknown type: ")));
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
            l.b.a.x.a aVar = l.b.a.x.a.HOUR_OF_DAY;
            Long l2 = map.get(aVar);
            Map<j, Long> map2 = this.b;
            l.b.a.x.a aVar2 = l.b.a.x.a.MINUTE_OF_HOUR;
            Long l3 = map2.get(aVar2);
            Map<j, Long> map3 = this.b;
            l.b.a.x.a aVar3 = l.b.a.x.a.SECOND_OF_MINUTE;
            Long l4 = map3.get(aVar3);
            Map<j, Long> map4 = this.b;
            l.b.a.x.a aVar4 = l.b.a.x.a.NANO_OF_SECOND;
            Long l5 = map4.get(aVar4);
            if (l2 != null && ((l3 != null || (l4 == null && l5 == null)) && (l3 == null || l4 != null || l5 == null))) {
                if (lVar != l.LENIENT) {
                    if (lVar == l.SMART && l2.longValue() == 24 && ((l3 == null || l3.longValue() == 0) && ((l4 == null || l4.longValue() == 0) && (l5 == null || l5.longValue() == 0)))) {
                        l2 = 0L;
                        this.f4435h = m.c(1);
                    }
                    int m = aVar.m(l2.longValue());
                    if (l3 != null) {
                        int m2 = aVar2.m(l3.longValue());
                        if (l4 != null) {
                            int m3 = aVar3.m(l4.longValue());
                            if (l5 != null) {
                                hVar4 = l.b.a.h.v(m, m2, m3, aVar4.m(l5.longValue()));
                            } else {
                                l.b.a.h hVar5 = l.b.a.h.f4363f;
                                aVar.f4506e.b((long) m, aVar);
                                if ((m2 | m3) == 0) {
                                    hVar4 = l.b.a.h.f4366i[m];
                                } else {
                                    aVar2.f4506e.b((long) m2, aVar2);
                                    aVar3.f4506e.b((long) m3, aVar3);
                                    hVar4 = new l.b.a.h(m, m2, m3, 0);
                                }
                            }
                        } else if (l5 == null) {
                            hVar4 = l.b.a.h.u(m, m2);
                        }
                    } else if (l4 == null && l5 == null) {
                        hVar4 = l.b.a.h.u(m, 0);
                    }
                    this.f4433f = hVar4;
                } else {
                    long longValue = l2.longValue();
                    if (l3 != null) {
                        if (l4 != null) {
                            if (l5 == null) {
                                l5 = 0L;
                            }
                            long w = d.w(d.w(d.w(d.y(longValue, 3600000000000L), d.y(l3.longValue(), 60000000000L)), d.y(l4.longValue(), 1000000000)), l5.longValue());
                            i2 = (int) d.i(w, 86400000000000L);
                            hVar3 = l.b.a.h.w(d.l(w, 86400000000000L));
                        } else {
                            long w2 = d.w(d.y(longValue, 3600), d.y(l3.longValue(), 60));
                            i2 = (int) d.i(w2, 86400);
                            hVar3 = l.b.a.h.x(d.l(w2, 86400));
                        }
                        hVar2 = hVar3;
                    } else {
                        i2 = d.B(d.i(longValue, 24));
                        hVar2 = l.b.a.h.u((int) ((long) d.k(longValue, 24)), 0);
                    }
                    this.f4433f = hVar2;
                    this.f4435h = m.c(i2);
                }
                this.b.remove(aVar);
                this.b.remove(aVar2);
                this.b.remove(aVar3);
                this.b.remove(aVar4);
            }
            if (this.b.size() > 0) {
                ?? r2 = this.f4432e;
                if (r2 != 0 && (hVar = this.f4433f) != null) {
                    r2 = r2.q(hVar);
                } else if (r2 == 0) {
                    r2 = this.f4433f;
                }
                s(r2);
            }
            m mVar = this.f4435h;
            if (mVar != null) {
                Objects.requireNonNull(mVar);
                m mVar2 = m.f4381e;
                if (!((mVar == mVar2) || (bVar = this.f4432e) == null || this.f4433f == null)) {
                    this.f4432e = bVar.w(this.f4435h);
                    this.f4435h = mVar2;
                }
            }
            if (this.f4433f == null && (this.b.containsKey(l.b.a.x.a.INSTANT_SECONDS) || this.b.containsKey(l.b.a.x.a.SECOND_OF_DAY) || this.b.containsKey(aVar3))) {
                if (this.b.containsKey(aVar4)) {
                    long longValue2 = this.b.get(aVar4).longValue();
                    this.b.put(l.b.a.x.a.MICRO_OF_SECOND, Long.valueOf(longValue2 / 1000));
                    this.b.put(l.b.a.x.a.MILLI_OF_SECOND, Long.valueOf(longValue2 / 1000000));
                } else {
                    this.b.put(aVar4, 0L);
                    this.b.put(l.b.a.x.a.MICRO_OF_SECOND, 0L);
                    this.b.put(l.b.a.x.a.MILLI_OF_SECOND, 0L);
                }
            }
            if (!(this.f4432e == null || this.f4433f == null)) {
                Long l6 = this.b.get(l.b.a.x.a.OFFSET_SECONDS);
                if (l6 != null) {
                    fVar = this.f4432e.q(this.f4433f).q(r.z(l6.intValue()));
                } else if (this.f4431d != null) {
                    fVar = this.f4432e.q(this.f4433f).q(this.f4431d);
                }
                l.b.a.x.a aVar5 = l.b.a.x.a.INSTANT_SECONDS;
                this.b.put(aVar5, Long.valueOf(fVar.i(aVar5)));
            }
            return this;
        }
        throw new l.b.a.b("Badly written field");
    }

    public final void y(j jVar, l.b.a.h hVar) {
        long E = hVar.E();
        Long put = this.b.put(l.b.a.x.a.NANO_OF_DAY, Long.valueOf(E));
        if (put != null && put.longValue() != E) {
            StringBuilder h2 = f.a.a.a.a.h("Conflict found: ");
            h2.append(l.b.a.h.w(put.longValue()));
            h2.append(" differs from ");
            h2.append(hVar);
            h2.append(" while resolving  ");
            h2.append(jVar);
            throw new l.b.a.b(h2.toString());
        }
    }

    public final void z(j jVar, b bVar) {
        if (this.c.equals(bVar.s())) {
            long x = bVar.x();
            Long put = this.b.put(l.b.a.x.a.EPOCH_DAY, Long.valueOf(x));
            if (put != null && put.longValue() != x) {
                StringBuilder h2 = f.a.a.a.a.h("Conflict found: ");
                h2.append(f.R(put.longValue()));
                h2.append(" differs from ");
                h2.append(f.R(x));
                h2.append(" while resolving  ");
                h2.append(jVar);
                throw new l.b.a.b(h2.toString());
            }
            return;
        }
        StringBuilder h3 = f.a.a.a.a.h("ChronoLocalDate must use the effective parsed chronology: ");
        h3.append(this.c);
        throw new l.b.a.b(h3.toString());
    }
}
