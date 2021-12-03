package e.g.a.i.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import e.g.a.i.c;
import e.g.a.i.d;
import e.g.a.i.f;
import e.g.a.i.h;
import e.g.a.i.l.b;
import f.a.a.a.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class e {
    public e.g.a.i.e a;
    public boolean b = true;
    public boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    public e.g.a.i.e f1328d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<o> f1329e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public b.AbstractC0028b f1330f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f1331g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<l> f1332h;

    public e(e.g.a.i.e eVar) {
        new ArrayList();
        this.f1330f = null;
        this.f1331g = new b.a();
        this.f1332h = new ArrayList<>();
        this.a = eVar;
        this.f1328d = eVar;
    }

    public final void a(f fVar, int i2, int i3, f fVar2, ArrayList<l> arrayList, l lVar) {
        o oVar = fVar.f1333d;
        if (oVar.c == null) {
            e.g.a.i.e eVar = this.a;
            if (!(oVar == eVar.f1307d || oVar == eVar.f1308e)) {
                if (lVar == null) {
                    lVar = new l(oVar, i3);
                    arrayList.add(lVar);
                }
                oVar.c = lVar;
                lVar.b.add(oVar);
                for (d dVar : oVar.f1359h.f1340k) {
                    if (dVar instanceof f) {
                        a((f) dVar, i2, 0, fVar2, arrayList, lVar);
                    }
                }
                for (d dVar2 : oVar.f1360i.f1340k) {
                    if (dVar2 instanceof f) {
                        a((f) dVar2, i2, 1, fVar2, arrayList, lVar);
                    }
                }
                if (i2 == 1 && (oVar instanceof m)) {
                    for (d dVar3 : ((m) oVar).f1350k.f1340k) {
                        if (dVar3 instanceof f) {
                            a((f) dVar3, i2, 2, fVar2, arrayList, lVar);
                        }
                    }
                }
                for (f fVar3 : oVar.f1359h.f1341l) {
                    a(fVar3, i2, 0, fVar2, arrayList, lVar);
                }
                for (f fVar4 : oVar.f1360i.f1341l) {
                    a(fVar4, i2, 1, fVar2, arrayList, lVar);
                }
                if (i2 == 1 && (oVar instanceof m)) {
                    for (f fVar5 : ((m) oVar).f1350k.f1341l) {
                        a(fVar5, i2, 2, fVar2, arrayList, lVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01f8, code lost:
        if (r2[3].f1295f != null) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        if (r15.r == 0) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x013e, code lost:
        if (r6[1].f1295f != null) goto L_0x0165;
     */
    public final boolean b(e.g.a.i.e eVar) {
        g gVar;
        int l2;
        int r;
        int l3;
        e eVar2;
        d dVar;
        d.a aVar;
        int r2;
        int l4;
        e eVar3;
        d dVar2;
        d.a aVar2;
        d.a aVar3;
        int i2;
        d.a aVar4;
        int i3;
        d.a aVar5;
        d.a aVar6 = d.a.MATCH_CONSTRAINT;
        d.a aVar7 = d.a.WRAP_CONTENT;
        d.a aVar8 = d.a.FIXED;
        Iterator<d> it = eVar.q0.iterator();
        while (it.hasNext()) {
            d next = it.next();
            d.a[] aVarArr = next.T;
            d.a aVar9 = aVarArr[0];
            d.a aVar10 = aVarArr[1];
            if (next.h0 != 8) {
                float f2 = next.v;
                if (f2 < 1.0f && aVar9 == aVar6) {
                    next.q = 2;
                }
                float f3 = next.y;
                if (f3 < 1.0f && aVar10 == aVar6) {
                    next.r = 2;
                }
                if (next.X > 0.0f) {
                    if (aVar9 == aVar6 && (aVar10 == aVar7 || aVar10 == aVar8)) {
                        next.q = 3;
                    } else {
                        if (!(aVar10 == aVar6 && (aVar9 == aVar7 || aVar9 == aVar8))) {
                            if (aVar9 == aVar6 && aVar10 == aVar6) {
                                if (next.q == 0) {
                                    next.q = 3;
                                }
                            }
                        }
                        next.r = 3;
                    }
                }
                if (aVar9 == aVar6 && next.q == 1 && (next.I.f1295f == null || next.K.f1295f == null)) {
                    aVar9 = aVar7;
                }
                d.a aVar11 = (aVar10 == aVar6 && next.r == 1 && (next.J.f1295f == null || next.L.f1295f == null)) ? aVar7 : aVar10;
                k kVar = next.f1307d;
                kVar.f1355d = aVar9;
                int i4 = next.q;
                kVar.a = i4;
                m mVar = next.f1308e;
                mVar.f1355d = aVar11;
                int i5 = next.r;
                mVar.a = i5;
                d.a aVar12 = d.a.MATCH_PARENT;
                if ((aVar9 == aVar12 || aVar9 == aVar8 || aVar9 == aVar7) && (aVar11 == aVar12 || aVar11 == aVar8 || aVar11 == aVar7)) {
                    int r3 = next.r();
                    if (aVar9 == aVar12) {
                        i2 = (eVar.r() - next.I.f1296g) - next.K.f1296g;
                        aVar4 = aVar8;
                    } else {
                        aVar4 = aVar9;
                        i2 = r3;
                    }
                    int l5 = next.l();
                    if (aVar11 == aVar12) {
                        i3 = (eVar.l() - next.J.f1296g) - next.L.f1296g;
                        aVar5 = aVar8;
                    } else {
                        i3 = l5;
                        aVar5 = aVar11;
                    }
                    f(next, aVar4, i2, aVar5, i3);
                    next.f1307d.f1356e.c(next.r());
                    next.f1308e.f1356e.c(next.l());
                    next.a = true;
                } else {
                    if (aVar9 == aVar6 && (aVar11 == aVar7 || aVar11 == aVar8)) {
                        if (i4 == 3) {
                            if (aVar11 == aVar7) {
                                f(next, aVar7, 0, aVar7, 0);
                            }
                            l4 = next.l();
                            r2 = (int) ((((float) l4) * next.X) + 0.5f);
                            eVar3 = this;
                            dVar2 = next;
                            aVar2 = aVar8;
                            aVar3 = aVar8;
                        } else if (i4 == 1) {
                            f(next, aVar7, 0, aVar11, 0);
                            gVar = next.f1307d.f1356e;
                            l2 = next.r();
                            gVar.m = l2;
                        } else if (i4 == 2) {
                            d.a[] aVarArr2 = eVar.T;
                            if (aVarArr2[0] == aVar8 || aVarArr2[0] == aVar12) {
                                r2 = (int) ((f2 * ((float) eVar.r())) + 0.5f);
                                l4 = next.l();
                                eVar3 = this;
                                dVar2 = next;
                                aVar2 = aVar8;
                                aVar3 = aVar11;
                            }
                        } else {
                            c[] cVarArr = next.Q;
                            if (cVarArr[0].f1295f != null) {
                            }
                            r = 0;
                            l3 = 0;
                            eVar2 = this;
                            dVar = next;
                            aVar9 = aVar7;
                            aVar = aVar11;
                            eVar2.f(dVar, aVar9, r, aVar, l3);
                            next.f1307d.f1356e.c(next.r());
                            next.f1308e.f1356e.c(next.l());
                            next.a = true;
                        }
                        eVar3.f(dVar2, aVar2, r2, aVar3, l4);
                        next.f1307d.f1356e.c(next.r());
                        next.f1308e.f1356e.c(next.l());
                    }
                    if (aVar11 == aVar6 && (aVar9 == aVar7 || aVar9 == aVar8)) {
                        if (i5 == 3) {
                            if (aVar9 == aVar7) {
                                f(next, aVar7, 0, aVar7, 0);
                            }
                            int r4 = next.r();
                            float f4 = next.X;
                            if (next.Y == -1) {
                                f4 = 1.0f / f4;
                            }
                            f(next, aVar8, r4, aVar8, (int) ((((float) r4) * f4) + 0.5f));
                            next.f1307d.f1356e.c(next.r());
                            next.f1308e.f1356e.c(next.l());
                            next.a = true;
                        } else if (i5 == 1) {
                            f(next, aVar9, 0, aVar7, 0);
                            gVar = next.f1308e.f1356e;
                            l2 = next.l();
                            gVar.m = l2;
                        } else if (i5 == 2) {
                            d.a[] aVarArr3 = eVar.T;
                            if (aVarArr3[1] == aVar8 || aVarArr3[1] == aVar12) {
                                r = next.r();
                                l3 = (int) ((f3 * ((float) eVar.l())) + 0.5f);
                                eVar2 = this;
                                dVar = next;
                                aVar = aVar8;
                                eVar2.f(dVar, aVar9, r, aVar, l3);
                                next.f1307d.f1356e.c(next.r());
                                next.f1308e.f1356e.c(next.l());
                                next.a = true;
                            }
                        } else {
                            c[] cVarArr2 = next.Q;
                            if (cVarArr2[2].f1295f != null) {
                            }
                            r = 0;
                            l3 = 0;
                            eVar2 = this;
                            dVar = next;
                            aVar9 = aVar7;
                            aVar = aVar11;
                            eVar2.f(dVar, aVar9, r, aVar, l3);
                            next.f1307d.f1356e.c(next.r());
                            next.f1308e.f1356e.c(next.l());
                            next.a = true;
                        }
                    }
                    if (aVar9 == aVar6 && aVar11 == aVar6) {
                        if (i4 == 1 || i5 == 1) {
                            f(next, aVar7, 0, aVar7, 0);
                            next.f1307d.f1356e.m = next.r();
                            gVar = next.f1308e.f1356e;
                            l2 = next.l();
                            gVar.m = l2;
                        } else if (i5 == 2 && i4 == 2) {
                            d.a[] aVarArr4 = eVar.T;
                            if (aVarArr4[0] == aVar8 && aVarArr4[1] == aVar8) {
                                f(next, aVar8, (int) ((f2 * ((float) eVar.r())) + 0.5f), aVar8, (int) ((f3 * ((float) eVar.l())) + 0.5f));
                                next.f1307d.f1356e.c(next.r());
                                next.f1308e.f1356e.c(next.l());
                                next.a = true;
                            }
                        }
                    }
                }
            }
            next.a = true;
        }
        return false;
    }

    public void c() {
        o oVar;
        ArrayList<o> arrayList = this.f1329e;
        arrayList.clear();
        this.f1328d.f1307d.f();
        this.f1328d.f1308e.f();
        arrayList.add(this.f1328d.f1307d);
        arrayList.add(this.f1328d.f1308e);
        Iterator<d> it = this.f1328d.q0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            d next = it.next();
            if (next instanceof f) {
                oVar = new i(next);
            } else {
                if (next.x()) {
                    if (next.b == null) {
                        next.b = new c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.b);
                } else {
                    arrayList.add(next.f1307d);
                }
                if (next.y()) {
                    if (next.c == null) {
                        next.c = new c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.c);
                } else {
                    arrayList.add(next.f1308e);
                }
                if (next instanceof h) {
                    oVar = new j(next);
                }
            }
            arrayList.add(oVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<o> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<o> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            o next2 = it3.next();
            if (next2.b != this.f1328d) {
                next2.d();
            }
        }
        this.f1332h.clear();
        l.c = 0;
        e(this.a.f1307d, 0, this.f1332h);
        e(this.a.f1308e, 1, this.f1332h);
        this.b = false;
    }

    public final int d(e.g.a.i.e eVar, int i2) {
        long j2;
        long j3;
        e eVar2 = this;
        e.g.a.i.e eVar3 = eVar;
        int size = eVar2.f1332h.size();
        long j4 = 0;
        long j5 = 0;
        int i3 = 0;
        while (i3 < size) {
            l lVar = eVar2.f1332h.get(i3);
            o oVar = lVar.a;
            if (oVar instanceof c) {
                if (((c) oVar).f1357f != i2) {
                    j4 = Math.max(j4, j5);
                    i3++;
                    j5 = 0;
                    eVar2 = this;
                    eVar3 = eVar;
                }
            } else if (i2 == 0) {
                if (!(oVar instanceof k)) {
                    j4 = Math.max(j4, j5);
                    i3++;
                    j5 = 0;
                    eVar2 = this;
                    eVar3 = eVar;
                }
            } else if (!(oVar instanceof m)) {
                j4 = Math.max(j4, j5);
                i3++;
                j5 = 0;
                eVar2 = this;
                eVar3 = eVar;
            }
            f fVar = (i2 == 0 ? eVar3.f1307d : eVar3.f1308e).f1359h;
            f fVar2 = (i2 == 0 ? eVar3.f1307d : eVar3.f1308e).f1360i;
            boolean contains = oVar.f1359h.f1341l.contains(fVar);
            boolean contains2 = lVar.a.f1360i.f1341l.contains(fVar2);
            long j6 = lVar.a.j();
            if (!contains || !contains2) {
                o oVar2 = lVar.a;
                if (contains) {
                    f fVar3 = oVar2.f1359h;
                    j3 = lVar.b(fVar3, (long) fVar3.f1335f);
                    j2 = ((long) lVar.a.f1359h.f1335f) + j6;
                } else if (contains2) {
                    f fVar4 = oVar2.f1360i;
                    long a2 = lVar.a(fVar4, (long) fVar4.f1335f);
                    j2 = ((long) (-lVar.a.f1360i.f1335f)) + j6;
                    j3 = -a2;
                } else {
                    j5 = (oVar2.j() + ((long) oVar2.f1359h.f1335f)) - ((long) lVar.a.f1360i.f1335f);
                    j4 = Math.max(j4, j5);
                    i3++;
                    j5 = 0;
                    eVar2 = this;
                    eVar3 = eVar;
                }
                j5 = Math.max(j3, j2);
                j4 = Math.max(j4, j5);
                i3++;
                j5 = 0;
                eVar2 = this;
                eVar3 = eVar;
            } else {
                long b2 = lVar.b(lVar.a.f1359h, j5);
                long a3 = lVar.a(lVar.a.f1360i, j5);
                long j7 = b2 - j6;
                o oVar3 = lVar.a;
                int i4 = oVar3.f1360i.f1335f;
                if (j7 >= ((long) (-i4))) {
                    j7 += (long) i4;
                }
                long j8 = (long) oVar3.f1359h.f1335f;
                long j9 = ((-a3) - j6) - j8;
                if (j9 >= j8) {
                    j9 -= j8;
                }
                d dVar = oVar3.b;
                Objects.requireNonNull(dVar);
                float f2 = i2 == 0 ? dVar.e0 : i2 == 1 ? dVar.f0 : -1.0f;
                float f3 = (float) (f2 > 0.0f ? (long) ((((float) j7) / (1.0f - f2)) + (((float) j9) / f2)) : 0);
                long a4 = ((long) ((f3 * f2) + 0.5f)) + j6 + ((long) a.a(1.0f, f2, f3, 0.5f));
                o oVar4 = lVar.a;
                j5 = (((long) oVar4.f1359h.f1335f) + a4) - ((long) oVar4.f1360i.f1335f);
                j4 = Math.max(j4, j5);
                i3++;
                j5 = 0;
                eVar2 = this;
                eVar3 = eVar;
            }
        }
        return (int) j4;
    }

    public final void e(o oVar, int i2, ArrayList<l> arrayList) {
        for (d dVar : oVar.f1359h.f1340k) {
            if (dVar instanceof f) {
                a((f) dVar, i2, 0, oVar.f1360i, arrayList, null);
            } else if (dVar instanceof o) {
                a(((o) dVar).f1359h, i2, 0, oVar.f1360i, arrayList, null);
            }
        }
        for (d dVar2 : oVar.f1360i.f1340k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i2, 1, oVar.f1359h, arrayList, null);
            } else if (dVar2 instanceof o) {
                a(((o) dVar2).f1360i, i2, 1, oVar.f1359h, arrayList, null);
            }
        }
        if (i2 == 1) {
            for (d dVar3 : ((m) oVar).f1350k.f1340k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i2, 2, null, arrayList, null);
                }
            }
        }
    }

    public final void f(d dVar, d.a aVar, int i2, d.a aVar2, int i3) {
        b.a aVar3 = this.f1331g;
        aVar3.a = aVar;
        aVar3.b = aVar2;
        aVar3.c = i2;
        aVar3.f1319d = i3;
        ((ConstraintLayout.b) this.f1330f).b(dVar, aVar3);
        dVar.N(this.f1331g.f1320e);
        dVar.I(this.f1331g.f1321f);
        b.a aVar4 = this.f1331g;
        dVar.D = aVar4.f1323h;
        dVar.F(aVar4.f1322g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        if (r12 == r7) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
        r0.c(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
        if (r10 == r7) goto L_0x0073;
     */
    public void g() {
        g gVar;
        g gVar2;
        int r;
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.MATCH_CONSTRAINT;
        Iterator<d> it = this.a.q0.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (!next.a) {
                d.a[] aVarArr = next.T;
                boolean z = false;
                d.a aVar3 = aVarArr[0];
                d.a aVar4 = aVarArr[1];
                int i2 = next.q;
                int i3 = next.r;
                d.a aVar5 = d.a.WRAP_CONTENT;
                boolean z2 = aVar3 == aVar5 || (aVar3 == aVar2 && i2 == 1);
                if (aVar4 == aVar5 || (aVar4 == aVar2 && i3 == 1)) {
                    z = true;
                }
                g gVar3 = next.f1307d.f1356e;
                boolean z3 = gVar3.f1339j;
                g gVar4 = next.f1308e.f1356e;
                boolean z4 = gVar4.f1339j;
                if (!z3 || !z4) {
                    if (!z3 || !z) {
                        if (z4 && z2) {
                            f(next, aVar5, gVar3.f1336g, aVar, gVar4.f1336g);
                            gVar2 = next.f1307d.f1356e;
                            r = next.r();
                        }
                        if (next.a && (gVar = next.f1308e.f1351l) != null) {
                            gVar.c(next.b0);
                        }
                    } else {
                        f(next, aVar, gVar3.f1336g, aVar5, gVar4.f1336g);
                        gVar2 = next.f1308e.f1356e;
                        r = next.l();
                    }
                    gVar2.m = r;
                    gVar.c(next.b0);
                } else {
                    f(next, aVar, gVar3.f1336g, aVar, gVar4.f1336g);
                }
                next.a = true;
                gVar.c(next.b0);
            }
        }
    }
}
