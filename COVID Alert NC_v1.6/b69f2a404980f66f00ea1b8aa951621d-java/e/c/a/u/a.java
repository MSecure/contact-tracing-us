package e.c.a.u;

import androidx.recyclerview.widget.RecyclerView;
import e.c.a.d;
import e.c.a.g;
import e.c.a.l;
import e.c.a.n;
import e.c.a.p;
import e.c.a.q;
import e.c.a.t.b;
import e.c.a.t.f;
import e.c.a.t.h;
import e.c.a.t.m;
import e.c.a.v.c;
import e.c.a.w.e;
import e.c.a.w.j;
import e.c.a.w.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a extends c implements e, Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public final Map<j, Long> f5054b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public h f5055c;

    /* renamed from: d  reason: collision with root package name */
    public p f5056d;

    /* renamed from: e  reason: collision with root package name */
    public b f5057e;
    public g f;
    public boolean g;
    public l h;

    public final void A(j jVar, g gVar) {
        long I = gVar.I();
        Long put = this.f5054b.put(e.c.a.w.a.NANO_OF_DAY, Long.valueOf(I));
        if (put != null && put.longValue() != I) {
            StringBuilder g2 = c.a.a.a.a.g("Conflict found: ");
            g2.append(g.z(put.longValue()));
            g2.append(" differs from ");
            g2.append(gVar);
            g2.append(" while resolving  ");
            g2.append(jVar);
            throw new e.c.a.a(g2.toString());
        }
    }

    public final void B(j jVar, b bVar) {
        if (this.f5055c.equals(bVar.u())) {
            long z = bVar.z();
            Long put = this.f5054b.put(e.c.a.w.a.EPOCH_DAY, Long.valueOf(z));
            if (put != null && put.longValue() != z) {
                StringBuilder g2 = c.a.a.a.a.g("Conflict found: ");
                g2.append(e.c.a.e.R(put.longValue()));
                g2.append(" differs from ");
                g2.append(e.c.a.e.R(z));
                g2.append(" while resolving  ");
                g2.append(jVar);
                throw new e.c.a.a(g2.toString());
            }
            return;
        }
        StringBuilder g3 = c.a.a.a.a.g("ChronoLocalDate must use the effective parsed chronology: ");
        g3.append(this.f5055c);
        throw new e.c.a.a(g3.toString());
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(e.c.a.w.l<R> lVar) {
        if (lVar == k.f5177a) {
            return (R) this.f5056d;
        }
        if (lVar == k.f5178b) {
            return (R) this.f5055c;
        }
        if (lVar == k.f) {
            b bVar = this.f5057e;
            if (bVar != null) {
                return (R) e.c.a.e.F(bVar);
            }
            return null;
        } else if (lVar == k.g) {
            return (R) this.f;
        } else {
            if (lVar == k.f5180d || lVar == k.f5181e) {
                return lVar.a(this);
            }
            if (lVar == k.f5179c) {
                return null;
            }
            return lVar.a(this);
        }
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        b bVar;
        g gVar;
        if (jVar == null) {
            return false;
        }
        return this.f5054b.containsKey(jVar) || ((bVar = this.f5057e) != null && bVar.i(jVar)) || ((gVar = this.f) != null && gVar.i(jVar));
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        c.b.a.a.c.n.c.T1(jVar, "field");
        Long l = this.f5054b.get(jVar);
        if (l != null) {
            return l.longValue();
        }
        b bVar = this.f5057e;
        if (bVar != null && bVar.i(jVar)) {
            return this.f5057e.l(jVar);
        }
        g gVar = this.f;
        if (gVar != null && gVar.i(jVar)) {
            return this.f.l(jVar);
        }
        throw new e.c.a.a(c.a.a.a.a.c("Field not found: ", jVar));
    }

    public a s(j jVar, long j) {
        c.b.a.a.c.n.c.T1(jVar, "field");
        Long l = this.f5054b.get(jVar);
        if (l == null || l.longValue() == j) {
            this.f5054b.put(jVar, Long.valueOf(j));
            return this;
        }
        throw new e.c.a.a("Conflict found: " + jVar + " " + l + " differs from " + jVar + " " + j + ": " + this);
    }

    public final void t(e.c.a.e eVar) {
        if (eVar != null) {
            this.f5057e = eVar;
            for (j jVar : this.f5054b.keySet()) {
                if ((jVar instanceof e.c.a.w.a) && jVar.b()) {
                    try {
                        long l = eVar.l(jVar);
                        Long l2 = this.f5054b.get(jVar);
                        if (l != l2.longValue()) {
                            throw new e.c.a.a("Conflict found: Field " + jVar + " " + l + " differs from " + jVar + " " + l2 + " derived from " + eVar);
                        }
                    } catch (e.c.a.a unused) {
                        continue;
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) RecyclerView.d0.FLAG_IGNORE);
        sb.append("DateTimeBuilder[");
        if (this.f5054b.size() > 0) {
            sb.append("fields=");
            sb.append(this.f5054b);
        }
        sb.append(", ");
        sb.append(this.f5055c);
        sb.append(", ");
        sb.append(this.f5056d);
        sb.append(", ");
        sb.append(this.f5057e);
        sb.append(", ");
        sb.append(this.f);
        sb.append(']');
        return sb.toString();
    }

    public final void u(e eVar) {
        Iterator<Map.Entry<j, Long>> it = this.f5054b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<j, Long> next = it.next();
            j key = next.getKey();
            long longValue = next.getValue().longValue();
            if (eVar.i(key)) {
                try {
                    long l = eVar.l(key);
                    if (l == longValue) {
                        it.remove();
                    } else {
                        throw new e.c.a.a("Cross check failed: " + key + " " + l + " vs " + key + " " + longValue);
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
    public final void v(l lVar) {
        e.c.a.e eVar;
        int o;
        e.c.a.e b0;
        long c2;
        e.c.a.w.a aVar;
        long c22;
        e.c.a.e X;
        int o2;
        e.c.a.e b02;
        long c23;
        long c24;
        e.c.a.w.a aVar2;
        int i;
        long j;
        e.c.a.w.a aVar3;
        e.c.a.w.a aVar4;
        long j2;
        if (this.f5055c instanceof m) {
            m mVar = m.f5027d;
            Map<j, Long> map = this.f5054b;
            l lVar2 = l.STRICT;
            l lVar3 = l.LENIENT;
            if (map.containsKey(e.c.a.w.a.EPOCH_DAY)) {
                eVar = e.c.a.e.R(map.remove(e.c.a.w.a.EPOCH_DAY).longValue());
            } else {
                Long remove = map.remove(e.c.a.w.a.PROLEPTIC_MONTH);
                if (remove != null) {
                    if (lVar != lVar3) {
                        e.c.a.w.a aVar5 = e.c.a.w.a.PROLEPTIC_MONTH;
                        aVar5.f5158c.b(remove.longValue(), aVar5);
                    }
                    mVar.u(map, e.c.a.w.a.MONTH_OF_YEAR, (long) (c.b.a.a.c.n.c.T0(remove.longValue(), 12) + 1));
                    mVar.u(map, e.c.a.w.a.YEAR, c.b.a.a.c.n.c.R0(remove.longValue(), 12));
                }
                Long remove2 = map.remove(e.c.a.w.a.YEAR_OF_ERA);
                if (remove2 != null) {
                    if (lVar != lVar3) {
                        e.c.a.w.a aVar6 = e.c.a.w.a.YEAR_OF_ERA;
                        aVar6.f5158c.b(remove2.longValue(), aVar6);
                    }
                    Long remove3 = map.remove(e.c.a.w.a.ERA);
                    if (remove3 == null) {
                        Long l = map.get(e.c.a.w.a.YEAR);
                        if (lVar != lVar2) {
                            aVar4 = e.c.a.w.a.YEAR;
                            if (l != null) {
                            }
                            j2 = remove2.longValue();
                            mVar.u(map, aVar4, j2);
                        } else if (l != null) {
                            aVar4 = e.c.a.w.a.YEAR;
                        } else {
                            map.put(e.c.a.w.a.YEAR_OF_ERA, remove2);
                        }
                        j2 = c.b.a.a.c.n.c.c2(1, remove2.longValue());
                        mVar.u(map, aVar4, j2);
                    } else {
                        if (remove3.longValue() == 1) {
                            aVar3 = e.c.a.w.a.YEAR;
                            j = remove2.longValue();
                        } else if (remove3.longValue() == 0) {
                            aVar3 = e.c.a.w.a.YEAR;
                            j = c.b.a.a.c.n.c.c2(1, remove2.longValue());
                        } else {
                            throw new e.c.a.a("Invalid value for era: " + remove3);
                        }
                        mVar.u(map, aVar3, j);
                    }
                } else if (map.containsKey(e.c.a.w.a.ERA)) {
                    e.c.a.w.a aVar7 = e.c.a.w.a.ERA;
                    aVar7.f5158c.b(map.get(aVar7).longValue(), aVar7);
                }
                if (map.containsKey(e.c.a.w.a.YEAR)) {
                    if (map.containsKey(e.c.a.w.a.MONTH_OF_YEAR)) {
                        if (map.containsKey(e.c.a.w.a.DAY_OF_MONTH)) {
                            e.c.a.w.a aVar8 = e.c.a.w.a.YEAR;
                            int o3 = aVar8.o(map.remove(aVar8).longValue());
                            int d2 = c.b.a.a.c.n.c.d2(map.remove(e.c.a.w.a.MONTH_OF_YEAR).longValue());
                            int d22 = c.b.a.a.c.n.c.d2(map.remove(e.c.a.w.a.DAY_OF_MONTH).longValue());
                            if (lVar == lVar3) {
                                long b2 = (long) c.b.a.a.c.n.c.b2(d2, 1);
                                c22 = (long) c.b.a.a.c.n.c.b2(d22, 1);
                                X = e.c.a.e.P(o3, 1, 1).W(b2);
                                eVar = X.V(c22);
                            } else {
                                if (lVar == l.SMART) {
                                    e.c.a.w.a aVar9 = e.c.a.w.a.DAY_OF_MONTH;
                                    aVar9.f5158c.b((long) d22, aVar9);
                                    if (d2 == 4 || d2 == 6 || d2 == 9 || d2 == 11) {
                                        i = 30;
                                    } else if (d2 == 2) {
                                        i = e.c.a.h.FEBRUARY.u(n.t((long) o3));
                                    }
                                    d22 = Math.min(d22, i);
                                }
                                eVar = e.c.a.e.P(o3, d2, d22);
                            }
                        } else if (map.containsKey(e.c.a.w.a.ALIGNED_WEEK_OF_MONTH)) {
                            if (map.containsKey(e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH)) {
                                e.c.a.w.a aVar10 = e.c.a.w.a.YEAR;
                                o2 = aVar10.o(map.remove(aVar10).longValue());
                                if (lVar == lVar3) {
                                    c23 = c.b.a.a.c.n.c.c2(map.remove(e.c.a.w.a.MONTH_OF_YEAR).longValue(), 1);
                                    c24 = c.b.a.a.c.n.c.c2(map.remove(e.c.a.w.a.ALIGNED_WEEK_OF_MONTH).longValue(), 1);
                                    aVar2 = e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                                } else {
                                    e.c.a.w.a aVar11 = e.c.a.w.a.MONTH_OF_YEAR;
                                    int o4 = aVar11.o(map.remove(aVar11).longValue());
                                    e.c.a.w.a aVar12 = e.c.a.w.a.ALIGNED_WEEK_OF_MONTH;
                                    int o5 = aVar12.o(map.remove(aVar12).longValue());
                                    e.c.a.w.a aVar13 = e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                                    b02 = e.c.a.e.P(o2, o4, 1).V((long) ((aVar13.o(map.remove(aVar13).longValue()) - 1) + ((o5 - 1) * 7)));
                                    if (lVar == lVar2 && b02.d(e.c.a.w.a.MONTH_OF_YEAR) != o4) {
                                        throw new e.c.a.a("Strict mode rejected date parsed to a different month");
                                    }
                                    eVar = b02;
                                }
                            } else if (map.containsKey(e.c.a.w.a.DAY_OF_WEEK)) {
                                e.c.a.w.a aVar14 = e.c.a.w.a.YEAR;
                                o2 = aVar14.o(map.remove(aVar14).longValue());
                                if (lVar == lVar3) {
                                    c23 = c.b.a.a.c.n.c.c2(map.remove(e.c.a.w.a.MONTH_OF_YEAR).longValue(), 1);
                                    c24 = c.b.a.a.c.n.c.c2(map.remove(e.c.a.w.a.ALIGNED_WEEK_OF_MONTH).longValue(), 1);
                                    aVar2 = e.c.a.w.a.DAY_OF_WEEK;
                                } else {
                                    e.c.a.w.a aVar15 = e.c.a.w.a.MONTH_OF_YEAR;
                                    int o6 = aVar15.o(map.remove(aVar15).longValue());
                                    e.c.a.w.a aVar16 = e.c.a.w.a.ALIGNED_WEEK_OF_MONTH;
                                    int o7 = aVar16.o(map.remove(aVar16).longValue());
                                    e.c.a.w.a aVar17 = e.c.a.w.a.DAY_OF_WEEK;
                                    b02 = e.c.a.e.P(o2, o6, 1).X((long) (o7 - 1)).g(c.b.a.a.c.n.c.F1(e.c.a.b.t(aVar17.o(map.remove(aVar17).longValue()))));
                                    if (lVar == lVar2 && b02.d(e.c.a.w.a.MONTH_OF_YEAR) != o6) {
                                        throw new e.c.a.a("Strict mode rejected date parsed to a different month");
                                    }
                                    eVar = b02;
                                }
                            }
                            c22 = c.b.a.a.c.n.c.c2(map.remove(aVar2).longValue(), 1);
                            X = e.c.a.e.P(o2, 1, 1).W(c23).X(c24);
                            eVar = X.V(c22);
                        }
                    }
                    if (map.containsKey(e.c.a.w.a.DAY_OF_YEAR)) {
                        e.c.a.w.a aVar18 = e.c.a.w.a.YEAR;
                        int o8 = aVar18.o(map.remove(aVar18).longValue());
                        if (lVar == lVar3) {
                            eVar = e.c.a.e.S(o8, 1).V(c.b.a.a.c.n.c.c2(map.remove(e.c.a.w.a.DAY_OF_YEAR).longValue(), 1));
                        } else {
                            e.c.a.w.a aVar19 = e.c.a.w.a.DAY_OF_YEAR;
                            eVar = e.c.a.e.S(o8, aVar19.o(map.remove(aVar19).longValue()));
                        }
                    } else if (map.containsKey(e.c.a.w.a.ALIGNED_WEEK_OF_YEAR)) {
                        if (map.containsKey(e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR)) {
                            e.c.a.w.a aVar20 = e.c.a.w.a.YEAR;
                            o = aVar20.o(map.remove(aVar20).longValue());
                            if (lVar == lVar3) {
                                c2 = c.b.a.a.c.n.c.c2(map.remove(e.c.a.w.a.ALIGNED_WEEK_OF_YEAR).longValue(), 1);
                                aVar = e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                            } else {
                                e.c.a.w.a aVar21 = e.c.a.w.a.ALIGNED_WEEK_OF_YEAR;
                                int o9 = aVar21.o(map.remove(aVar21).longValue());
                                e.c.a.w.a aVar22 = e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                                b0 = e.c.a.e.P(o, 1, 1).V((long) ((aVar22.o(map.remove(aVar22).longValue()) - 1) + ((o9 - 1) * 7)));
                                if (lVar == lVar2 && b0.d(e.c.a.w.a.YEAR) != o) {
                                    throw new e.c.a.a("Strict mode rejected date parsed to a different year");
                                }
                                eVar = b0;
                            }
                        } else if (map.containsKey(e.c.a.w.a.DAY_OF_WEEK)) {
                            e.c.a.w.a aVar23 = e.c.a.w.a.YEAR;
                            o = aVar23.o(map.remove(aVar23).longValue());
                            if (lVar == lVar3) {
                                c2 = c.b.a.a.c.n.c.c2(map.remove(e.c.a.w.a.ALIGNED_WEEK_OF_YEAR).longValue(), 1);
                                aVar = e.c.a.w.a.DAY_OF_WEEK;
                            } else {
                                e.c.a.w.a aVar24 = e.c.a.w.a.ALIGNED_WEEK_OF_YEAR;
                                int o10 = aVar24.o(map.remove(aVar24).longValue());
                                e.c.a.w.a aVar25 = e.c.a.w.a.DAY_OF_WEEK;
                                b0 = e.c.a.e.P(o, 1, 1).X((long) (o10 - 1)).g(c.b.a.a.c.n.c.F1(e.c.a.b.t(aVar25.o(map.remove(aVar25).longValue()))));
                                if (lVar == lVar2 && b0.d(e.c.a.w.a.YEAR) != o) {
                                    throw new e.c.a.a("Strict mode rejected date parsed to a different month");
                                }
                                eVar = b0;
                            }
                        }
                        c22 = c.b.a.a.c.n.c.c2(map.remove(aVar).longValue(), 1);
                        X = e.c.a.e.P(o, 1, 1).X(c2);
                        eVar = X.V(c22);
                    }
                }
                eVar = null;
            }
            t(eVar);
        } else if (this.f5054b.containsKey(e.c.a.w.a.EPOCH_DAY)) {
            t(e.c.a.e.R(this.f5054b.remove(e.c.a.w.a.EPOCH_DAY).longValue()));
        }
    }

    public final void w() {
        if (this.f5054b.containsKey(e.c.a.w.a.INSTANT_SECONDS)) {
            p pVar = this.f5056d;
            if (pVar == null) {
                Long l = this.f5054b.get(e.c.a.w.a.OFFSET_SECONDS);
                if (l != null) {
                    pVar = q.C(l.intValue());
                } else {
                    return;
                }
            }
            x(pVar);
        }
    }

    public final void x(p pVar) {
        f<?> v = this.f5055c.v(d.s(this.f5054b.remove(e.c.a.w.a.INSTANT_SECONDS).longValue(), 0), pVar);
        if (this.f5057e == null) {
            this.f5057e = v.y();
        } else {
            B(e.c.a.w.a.INSTANT_SECONDS, v.y());
        }
        s(e.c.a.w.a.SECOND_OF_DAY, (long) v.A().J());
    }

    public final void y(l lVar) {
        e.c.a.w.a aVar;
        long j;
        l lVar2 = l.SMART;
        l lVar3 = l.LENIENT;
        long j2 = 0;
        if (this.f5054b.containsKey(e.c.a.w.a.CLOCK_HOUR_OF_DAY)) {
            long longValue = this.f5054b.remove(e.c.a.w.a.CLOCK_HOUR_OF_DAY).longValue();
            if (!(lVar == lVar3 || (lVar == lVar2 && longValue == 0))) {
                e.c.a.w.a aVar2 = e.c.a.w.a.CLOCK_HOUR_OF_DAY;
                aVar2.f5158c.b(longValue, aVar2);
            }
            e.c.a.w.a aVar3 = e.c.a.w.a.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            s(aVar3, longValue);
        }
        if (this.f5054b.containsKey(e.c.a.w.a.CLOCK_HOUR_OF_AMPM)) {
            long longValue2 = this.f5054b.remove(e.c.a.w.a.CLOCK_HOUR_OF_AMPM).longValue();
            if (!(lVar == lVar3 || (lVar == lVar2 && longValue2 == 0))) {
                e.c.a.w.a aVar4 = e.c.a.w.a.CLOCK_HOUR_OF_AMPM;
                aVar4.f5158c.b(longValue2, aVar4);
            }
            e.c.a.w.a aVar5 = e.c.a.w.a.HOUR_OF_AMPM;
            if (longValue2 != 12) {
                j2 = longValue2;
            }
            s(aVar5, j2);
        }
        if (lVar != lVar3) {
            if (this.f5054b.containsKey(e.c.a.w.a.AMPM_OF_DAY)) {
                e.c.a.w.a aVar6 = e.c.a.w.a.AMPM_OF_DAY;
                aVar6.f5158c.b(this.f5054b.get(aVar6).longValue(), aVar6);
            }
            if (this.f5054b.containsKey(e.c.a.w.a.HOUR_OF_AMPM)) {
                e.c.a.w.a aVar7 = e.c.a.w.a.HOUR_OF_AMPM;
                aVar7.f5158c.b(this.f5054b.get(aVar7).longValue(), aVar7);
            }
        }
        if (this.f5054b.containsKey(e.c.a.w.a.AMPM_OF_DAY) && this.f5054b.containsKey(e.c.a.w.a.HOUR_OF_AMPM)) {
            s(e.c.a.w.a.HOUR_OF_DAY, (this.f5054b.remove(e.c.a.w.a.AMPM_OF_DAY).longValue() * 12) + this.f5054b.remove(e.c.a.w.a.HOUR_OF_AMPM).longValue());
        }
        if (this.f5054b.containsKey(e.c.a.w.a.NANO_OF_DAY)) {
            long longValue3 = this.f5054b.remove(e.c.a.w.a.NANO_OF_DAY).longValue();
            if (lVar != lVar3) {
                e.c.a.w.a aVar8 = e.c.a.w.a.NANO_OF_DAY;
                aVar8.f5158c.b(longValue3, aVar8);
            }
            s(e.c.a.w.a.SECOND_OF_DAY, longValue3 / 1000000000);
            s(e.c.a.w.a.NANO_OF_SECOND, longValue3 % 1000000000);
        }
        if (this.f5054b.containsKey(e.c.a.w.a.MICRO_OF_DAY)) {
            long longValue4 = this.f5054b.remove(e.c.a.w.a.MICRO_OF_DAY).longValue();
            if (lVar != lVar3) {
                e.c.a.w.a aVar9 = e.c.a.w.a.MICRO_OF_DAY;
                aVar9.f5158c.b(longValue4, aVar9);
            }
            s(e.c.a.w.a.SECOND_OF_DAY, longValue4 / 1000000);
            s(e.c.a.w.a.MICRO_OF_SECOND, longValue4 % 1000000);
        }
        if (this.f5054b.containsKey(e.c.a.w.a.MILLI_OF_DAY)) {
            long longValue5 = this.f5054b.remove(e.c.a.w.a.MILLI_OF_DAY).longValue();
            if (lVar != lVar3) {
                e.c.a.w.a aVar10 = e.c.a.w.a.MILLI_OF_DAY;
                aVar10.f5158c.b(longValue5, aVar10);
            }
            s(e.c.a.w.a.SECOND_OF_DAY, longValue5 / 1000);
            s(e.c.a.w.a.MILLI_OF_SECOND, longValue5 % 1000);
        }
        if (this.f5054b.containsKey(e.c.a.w.a.SECOND_OF_DAY)) {
            long longValue6 = this.f5054b.remove(e.c.a.w.a.SECOND_OF_DAY).longValue();
            if (lVar != lVar3) {
                e.c.a.w.a aVar11 = e.c.a.w.a.SECOND_OF_DAY;
                aVar11.f5158c.b(longValue6, aVar11);
            }
            s(e.c.a.w.a.HOUR_OF_DAY, longValue6 / 3600);
            s(e.c.a.w.a.MINUTE_OF_HOUR, (longValue6 / 60) % 60);
            s(e.c.a.w.a.SECOND_OF_MINUTE, longValue6 % 60);
        }
        if (this.f5054b.containsKey(e.c.a.w.a.MINUTE_OF_DAY)) {
            long longValue7 = this.f5054b.remove(e.c.a.w.a.MINUTE_OF_DAY).longValue();
            if (lVar != lVar3) {
                e.c.a.w.a aVar12 = e.c.a.w.a.MINUTE_OF_DAY;
                aVar12.f5158c.b(longValue7, aVar12);
            }
            s(e.c.a.w.a.HOUR_OF_DAY, longValue7 / 60);
            s(e.c.a.w.a.MINUTE_OF_HOUR, longValue7 % 60);
        }
        if (lVar != lVar3) {
            if (this.f5054b.containsKey(e.c.a.w.a.MILLI_OF_SECOND)) {
                e.c.a.w.a aVar13 = e.c.a.w.a.MILLI_OF_SECOND;
                aVar13.f5158c.b(this.f5054b.get(aVar13).longValue(), aVar13);
            }
            if (this.f5054b.containsKey(e.c.a.w.a.MICRO_OF_SECOND)) {
                e.c.a.w.a aVar14 = e.c.a.w.a.MICRO_OF_SECOND;
                aVar14.f5158c.b(this.f5054b.get(aVar14).longValue(), aVar14);
            }
        }
        if (this.f5054b.containsKey(e.c.a.w.a.MILLI_OF_SECOND) && this.f5054b.containsKey(e.c.a.w.a.MICRO_OF_SECOND)) {
            s(e.c.a.w.a.MICRO_OF_SECOND, (this.f5054b.get(e.c.a.w.a.MICRO_OF_SECOND).longValue() % 1000) + (this.f5054b.remove(e.c.a.w.a.MILLI_OF_SECOND).longValue() * 1000));
        }
        if (this.f5054b.containsKey(e.c.a.w.a.MICRO_OF_SECOND) && this.f5054b.containsKey(e.c.a.w.a.NANO_OF_SECOND)) {
            s(e.c.a.w.a.MICRO_OF_SECOND, this.f5054b.get(e.c.a.w.a.NANO_OF_SECOND).longValue() / 1000);
            this.f5054b.remove(e.c.a.w.a.MICRO_OF_SECOND);
        }
        if (this.f5054b.containsKey(e.c.a.w.a.MILLI_OF_SECOND) && this.f5054b.containsKey(e.c.a.w.a.NANO_OF_SECOND)) {
            s(e.c.a.w.a.MILLI_OF_SECOND, this.f5054b.get(e.c.a.w.a.NANO_OF_SECOND).longValue() / 1000000);
            this.f5054b.remove(e.c.a.w.a.MILLI_OF_SECOND);
        }
        if (this.f5054b.containsKey(e.c.a.w.a.MICRO_OF_SECOND)) {
            long longValue8 = this.f5054b.remove(e.c.a.w.a.MICRO_OF_SECOND).longValue();
            aVar = e.c.a.w.a.NANO_OF_SECOND;
            j = longValue8 * 1000;
        } else if (this.f5054b.containsKey(e.c.a.w.a.MILLI_OF_SECOND)) {
            long longValue9 = this.f5054b.remove(e.c.a.w.a.MILLI_OF_SECOND).longValue();
            aVar = e.c.a.w.a.NANO_OF_SECOND;
            j = longValue9 * 1000000;
        } else {
            return;
        }
        s(aVar, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0259, code lost:
        if (r14 != null) goto L_0x025b;
     */
    public a z(l lVar, Set<j> set) {
        f<?> fVar;
        b bVar;
        e eVar;
        g gVar;
        int i;
        g gVar2;
        g gVar3;
        if (set != null) {
            this.f5054b.keySet().retainAll(set);
        }
        w();
        v(lVar);
        y(lVar);
        boolean z = false;
        int i2 = 0;
        loop0:
        while (i2 < 100) {
            for (Map.Entry<j, Long> entry : this.f5054b.entrySet()) {
                j key = entry.getKey();
                e g2 = key.g(this.f5054b, this, lVar);
                if (g2 != null) {
                    if (g2 instanceof f) {
                        f fVar2 = (f) g2;
                        p pVar = this.f5056d;
                        if (pVar == null) {
                            this.f5056d = fVar2.u();
                        } else if (!pVar.equals(fVar2.u())) {
                            StringBuilder g3 = c.a.a.a.a.g("ChronoZonedDateTime must use the effective parsed zone: ");
                            g3.append(this.f5056d);
                            throw new e.c.a.a(g3.toString());
                        }
                        g2 = fVar2.z();
                    }
                    if (g2 instanceof b) {
                        B(key, (b) g2);
                    } else if (g2 instanceof g) {
                        A(key, (g) g2);
                    } else if (g2 instanceof e.c.a.t.c) {
                        e.c.a.t.c cVar = (e.c.a.t.c) g2;
                        B(key, cVar.z());
                        A(key, cVar.A());
                    } else {
                        throw new e.c.a.a(c.a.a.a.a.d(g2, c.a.a.a.a.g("Unknown type: ")));
                    }
                } else if (!this.f5054b.containsKey(key)) {
                }
                i2++;
            }
        }
        if (i2 != 100) {
            if (i2 > 0) {
                w();
                v(lVar);
                y(lVar);
            }
            Long l = this.f5054b.get(e.c.a.w.a.HOUR_OF_DAY);
            Long l2 = this.f5054b.get(e.c.a.w.a.MINUTE_OF_HOUR);
            Long l3 = this.f5054b.get(e.c.a.w.a.SECOND_OF_MINUTE);
            Long l4 = this.f5054b.get(e.c.a.w.a.NANO_OF_SECOND);
            if (l != null && ((l2 != null || (l3 == null && l4 == null)) && (l2 == null || l3 != null || l4 == null))) {
                if (lVar != l.LENIENT) {
                    if (lVar == l.SMART && l.longValue() == 24 && ((l2 == null || l2.longValue() == 0) && ((l3 == null || l3.longValue() == 0) && (l4 == null || l4.longValue() == 0)))) {
                        l = 0L;
                        this.h = l.b(1);
                    }
                    int o = e.c.a.w.a.HOUR_OF_DAY.o(l.longValue());
                    if (l2 != null) {
                        int o2 = e.c.a.w.a.MINUTE_OF_HOUR.o(l2.longValue());
                        if (l3 != null) {
                            int o3 = e.c.a.w.a.SECOND_OF_MINUTE.o(l3.longValue());
                            gVar3 = l4 != null ? g.y(o, o2, o3, e.c.a.w.a.NANO_OF_SECOND.o(l4.longValue())) : g.x(o, o2, o3);
                        } else if (l4 == null) {
                            gVar3 = g.w(o, o2);
                        }
                    } else if (l3 == null && l4 == null) {
                        gVar3 = g.w(o, 0);
                    }
                    this.f = gVar3;
                } else {
                    long longValue = l.longValue();
                    if (l2 == null) {
                        i = c.b.a.a.c.n.c.d2(c.b.a.a.c.n.c.R0(longValue, 24));
                        gVar2 = g.w((int) ((long) c.b.a.a.c.n.c.T0(longValue, 24)), 0);
                    } else if (l3 != null) {
                        if (l4 == null) {
                            l4 = 0L;
                        }
                        long Y1 = c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.a2(longValue, 3600000000000L), c.b.a.a.c.n.c.a2(l2.longValue(), 60000000000L)), c.b.a.a.c.n.c.a2(l3.longValue(), 1000000000)), l4.longValue());
                        i = (int) c.b.a.a.c.n.c.R0(Y1, 86400000000000L);
                        gVar2 = g.z(c.b.a.a.c.n.c.U0(Y1, 86400000000000L));
                    } else {
                        long Y12 = c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.a2(longValue, 3600), c.b.a.a.c.n.c.a2(l2.longValue(), 60));
                        i = (int) c.b.a.a.c.n.c.R0(Y12, 86400);
                        gVar2 = g.A(c.b.a.a.c.n.c.U0(Y12, 86400));
                    }
                    this.f = gVar2;
                    this.h = l.b(i);
                }
                this.f5054b.remove(e.c.a.w.a.HOUR_OF_DAY);
                this.f5054b.remove(e.c.a.w.a.MINUTE_OF_HOUR);
                this.f5054b.remove(e.c.a.w.a.SECOND_OF_MINUTE);
                this.f5054b.remove(e.c.a.w.a.NANO_OF_SECOND);
            }
            if (this.f5054b.size() > 0) {
                b bVar2 = this.f5057e;
                if (bVar2 == null || (gVar = this.f) == null) {
                    eVar = this.f5057e;
                    if (eVar == null) {
                        eVar = this.f;
                    }
                } else {
                    eVar = bVar2.s(gVar);
                }
                u(eVar);
            }
            l lVar2 = this.h;
            if (lVar2 != null) {
                if (lVar2 != null) {
                    if (lVar2 == l.f4991e) {
                        z = true;
                    }
                    if (!(z || (bVar = this.f5057e) == null || this.f == null)) {
                        this.f5057e = bVar.y(this.h);
                        this.h = l.f4991e;
                    }
                } else {
                    throw null;
                }
            }
            if (this.f == null && (this.f5054b.containsKey(e.c.a.w.a.INSTANT_SECONDS) || this.f5054b.containsKey(e.c.a.w.a.SECOND_OF_DAY) || this.f5054b.containsKey(e.c.a.w.a.SECOND_OF_MINUTE))) {
                if (this.f5054b.containsKey(e.c.a.w.a.NANO_OF_SECOND)) {
                    long longValue2 = this.f5054b.get(e.c.a.w.a.NANO_OF_SECOND).longValue();
                    this.f5054b.put(e.c.a.w.a.MICRO_OF_SECOND, Long.valueOf(longValue2 / 1000));
                    this.f5054b.put(e.c.a.w.a.MILLI_OF_SECOND, Long.valueOf(longValue2 / 1000000));
                } else {
                    this.f5054b.put(e.c.a.w.a.NANO_OF_SECOND, 0L);
                    this.f5054b.put(e.c.a.w.a.MICRO_OF_SECOND, 0L);
                    this.f5054b.put(e.c.a.w.a.MILLI_OF_SECOND, 0L);
                }
            }
            if (!(this.f5057e == null || this.f == null)) {
                Long l5 = this.f5054b.get(e.c.a.w.a.OFFSET_SECONDS);
                if (l5 != null) {
                    fVar = this.f5057e.s(this.f).s(q.C(l5.intValue()));
                } else if (this.f5056d != null) {
                    fVar = this.f5057e.s(this.f).s(this.f5056d);
                }
                this.f5054b.put(e.c.a.w.a.INSTANT_SECONDS, Long.valueOf(fVar.l(e.c.a.w.a.INSTANT_SECONDS)));
            }
            return this;
        }
        throw new e.c.a.a("Badly written field");
    }
}
