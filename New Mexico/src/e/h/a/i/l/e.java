package e.h.a.i.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import e.h.a.i.c;
import e.h.a.i.d;
import e.h.a.i.f;
import e.h.a.i.h;
import e.h.a.i.l.b;
import f.a.a.a.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes.dex */
public class e {
    public e.h.a.i.e a;

    /* renamed from: d  reason: collision with root package name */
    public e.h.a.i.e f1412d;
    public boolean b = true;
    public boolean c = true;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<o> f1413e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public b.AbstractC0031b f1414f = null;

    /* renamed from: g  reason: collision with root package name */
    public b.a f1415g = new b.a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<l> f1416h = new ArrayList<>();

    public e(e.h.a.i.e eVar) {
        new ArrayList();
        this.a = eVar;
        this.f1412d = eVar;
    }

    public final void a(f fVar, int i2, int i3, f fVar2, ArrayList<l> arrayList, l lVar) {
        o oVar = fVar.f1417d;
        if (oVar.c == null) {
            e.h.a.i.e eVar = this.a;
            if (!(oVar == eVar.f1391d || oVar == eVar.f1392e)) {
                if (lVar == null) {
                    lVar = new l(oVar, i3);
                    arrayList.add(lVar);
                }
                oVar.c = lVar;
                lVar.b.add(oVar);
                for (d dVar : oVar.f1443h.f1424k) {
                    if (dVar instanceof f) {
                        a((f) dVar, i2, 0, fVar2, arrayList, lVar);
                    }
                }
                for (d dVar2 : oVar.f1444i.f1424k) {
                    if (dVar2 instanceof f) {
                        a((f) dVar2, i2, 1, fVar2, arrayList, lVar);
                    }
                }
                if (i2 == 1 && (oVar instanceof m)) {
                    for (d dVar3 : ((m) oVar).f1434k.f1424k) {
                        if (dVar3 instanceof f) {
                            a((f) dVar3, i2, 2, fVar2, arrayList, lVar);
                        }
                    }
                }
                for (f fVar3 : oVar.f1443h.f1425l) {
                    a(fVar3, i2, 0, fVar2, arrayList, lVar);
                }
                for (f fVar4 : oVar.f1444i.f1425l) {
                    a(fVar4, i2, 1, fVar2, arrayList, lVar);
                }
                if (i2 == 1 && (oVar instanceof m)) {
                    for (f fVar5 : ((m) oVar).f1434k.f1425l) {
                        a(fVar5, i2, 2, fVar2, arrayList, lVar);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
        if (r15.r == 0) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final boolean b(e.h.a.i.e eVar) {
        g gVar;
        int l2;
        int r;
        int l3;
        e eVar2;
        d dVar;
        d.a aVar;
        int l4;
        int i2;
        e eVar3;
        d dVar2;
        d.a aVar2;
        d.a aVar3;
        d.a aVar4;
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
                if (aVar9 == aVar6 && next.q == 1 && (next.I.f1379f == null || next.K.f1379f == null)) {
                    aVar9 = aVar7;
                }
                d.a aVar11 = (aVar10 == aVar6 && next.r == 1 && (next.J.f1379f == null || next.L.f1379f == null)) ? aVar7 : aVar10;
                k kVar = next.f1391d;
                kVar.f1439d = aVar9;
                int i3 = next.q;
                kVar.a = i3;
                m mVar = next.f1392e;
                mVar.f1439d = aVar11;
                int i4 = next.r;
                mVar.a = i4;
                d.a aVar12 = d.a.MATCH_PARENT;
                if ((aVar9 == aVar12 || aVar9 == aVar8 || aVar9 == aVar7) && (aVar11 == aVar12 || aVar11 == aVar8 || aVar11 == aVar7)) {
                    int i5 = next.r();
                    if (aVar9 == aVar12) {
                        i5 = (eVar.r() - next.I.f1380g) - next.K.f1380g;
                        aVar4 = aVar8;
                    } else {
                        aVar4 = aVar9;
                    }
                    int i6 = next.l();
                    if (aVar11 == aVar12) {
                        i6 = (eVar.l() - next.J.f1380g) - next.L.f1380g;
                        aVar5 = aVar8;
                    } else {
                        aVar5 = aVar11;
                    }
                    f(next, aVar4, i5, aVar5, i6);
                    next.f1391d.f1440e.c(next.r());
                    next.f1392e.f1440e.c(next.l());
                    next.a = true;
                } else {
                    if (aVar9 == aVar6 && (aVar11 == aVar7 || aVar11 == aVar8)) {
                        if (i3 == 3) {
                            if (aVar11 == aVar7) {
                                f(next, aVar7, 0, aVar7, 0);
                            }
                            l4 = next.l();
                            i2 = (int) ((((float) l4) * next.X) + 0.5f);
                            eVar3 = this;
                            dVar2 = next;
                            aVar2 = aVar8;
                            aVar3 = aVar8;
                        } else if (i3 == 1) {
                            f(next, aVar7, 0, aVar11, 0);
                            gVar = next.f1391d.f1440e;
                            l2 = next.r();
                            gVar.m = l2;
                        } else if (i3 == 2) {
                            d.a[] aVarArr2 = eVar.T;
                            if (aVarArr2[0] == aVar8 || aVarArr2[0] == aVar12) {
                                i2 = (int) ((f2 * ((float) eVar.r())) + 0.5f);
                                l4 = next.l();
                                eVar3 = this;
                                dVar2 = next;
                                aVar2 = aVar8;
                                aVar3 = aVar11;
                            }
                        } else {
                            c[] cVarArr = next.Q;
                            if (cVarArr[0].f1379f != null) {
                                if (cVarArr[1].f1379f == null) {
                                }
                            }
                            r = 0;
                            l3 = 0;
                            eVar2 = this;
                            dVar = next;
                            aVar9 = aVar7;
                            aVar = aVar11;
                            eVar2.f(dVar, aVar9, r, aVar, l3);
                            next.f1391d.f1440e.c(next.r());
                            next.f1392e.f1440e.c(next.l());
                            next.a = true;
                        }
                        eVar3.f(dVar2, aVar2, i2, aVar3, l4);
                        next.f1391d.f1440e.c(next.r());
                        next.f1392e.f1440e.c(next.l());
                    }
                    if (aVar11 == aVar6 && (aVar9 == aVar7 || aVar9 == aVar8)) {
                        if (i4 == 3) {
                            if (aVar9 == aVar7) {
                                f(next, aVar7, 0, aVar7, 0);
                            }
                            int r2 = next.r();
                            float f4 = next.X;
                            if (next.Y == -1) {
                                f4 = 1.0f / f4;
                            }
                            f(next, aVar8, r2, aVar8, (int) ((((float) r2) * f4) + 0.5f));
                            next.f1391d.f1440e.c(next.r());
                            next.f1392e.f1440e.c(next.l());
                            next.a = true;
                        } else if (i4 == 1) {
                            f(next, aVar9, 0, aVar7, 0);
                            gVar = next.f1392e.f1440e;
                            l2 = next.l();
                            gVar.m = l2;
                        } else if (i4 == 2) {
                            d.a[] aVarArr3 = eVar.T;
                            if (aVarArr3[1] == aVar8 || aVarArr3[1] == aVar12) {
                                r = next.r();
                                l3 = (int) ((f3 * ((float) eVar.l())) + 0.5f);
                                eVar2 = this;
                                dVar = next;
                                aVar = aVar8;
                                eVar2.f(dVar, aVar9, r, aVar, l3);
                                next.f1391d.f1440e.c(next.r());
                                next.f1392e.f1440e.c(next.l());
                                next.a = true;
                            }
                        } else {
                            c[] cVarArr2 = next.Q;
                            if (!(cVarArr2[2].f1379f == null || cVarArr2[3].f1379f == null)) {
                            }
                            r = 0;
                            l3 = 0;
                            eVar2 = this;
                            dVar = next;
                            aVar9 = aVar7;
                            aVar = aVar11;
                            eVar2.f(dVar, aVar9, r, aVar, l3);
                            next.f1391d.f1440e.c(next.r());
                            next.f1392e.f1440e.c(next.l());
                            next.a = true;
                        }
                    }
                    if (aVar9 == aVar6 && aVar11 == aVar6) {
                        if (i3 == 1 || i4 == 1) {
                            f(next, aVar7, 0, aVar7, 0);
                            next.f1391d.f1440e.m = next.r();
                            gVar = next.f1392e.f1440e;
                            l2 = next.l();
                            gVar.m = l2;
                        } else if (i4 == 2 && i3 == 2) {
                            d.a[] aVarArr4 = eVar.T;
                            if (aVarArr4[0] == aVar8 && aVarArr4[1] == aVar8) {
                                f(next, aVar8, (int) ((f2 * ((float) eVar.r())) + 0.5f), aVar8, (int) ((f3 * ((float) eVar.l())) + 0.5f));
                                next.f1391d.f1440e.c(next.r());
                                next.f1392e.f1440e.c(next.l());
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
        o iVar;
        ArrayList<o> arrayList = this.f1413e;
        arrayList.clear();
        this.f1412d.f1391d.f();
        this.f1412d.f1392e.f();
        arrayList.add(this.f1412d.f1391d);
        arrayList.add(this.f1412d.f1392e);
        Iterator<d> it = this.f1412d.q0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            d next = it.next();
            if (next instanceof f) {
                iVar = new i(next);
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
                    arrayList.add(next.f1391d);
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
                    arrayList.add(next.f1392e);
                }
                if (next instanceof h) {
                    iVar = new j(next);
                }
            }
            arrayList.add(iVar);
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
            if (next2.b != this.f1412d) {
                next2.d();
            }
        }
        this.f1416h.clear();
        l.c = 0;
        e(this.a.f1391d, 0, this.f1416h);
        e(this.a.f1392e, 1, this.f1416h);
        this.b = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final int d(e.h.a.i.e eVar, int i2) {
        boolean contains;
        long j2;
        long j3;
        e eVar2 = this;
        e.h.a.i.e eVar3 = eVar;
        int size = eVar2.f1416h.size();
        long j4 = 0;
        long j5 = 0;
        int i3 = 0;
        while (i3 < size) {
            l lVar = eVar2.f1416h.get(i3);
            o oVar = lVar.a;
            if (oVar instanceof c) {
                if (((c) oVar).f1441f != i2) {
                    j4 = Math.max(j4, j5);
                    i3++;
                    j5 = 0;
                    eVar2 = this;
                    eVar3 = eVar;
                }
                f fVar = (i2 == 0 ? eVar3.f1391d : eVar3.f1392e).f1443h;
                f fVar2 = (i2 == 0 ? eVar3.f1391d : eVar3.f1392e).f1444i;
                contains = oVar.f1443h.f1425l.contains(fVar);
                boolean contains2 = lVar.a.f1444i.f1425l.contains(fVar2);
                long j6 = lVar.a.j();
                if (contains || !contains2) {
                    o oVar2 = lVar.a;
                    if (contains) {
                        f fVar3 = oVar2.f1443h;
                        j3 = lVar.b(fVar3, (long) fVar3.f1419f);
                        j2 = ((long) lVar.a.f1443h.f1419f) + j6;
                    } else if (contains2) {
                        f fVar4 = oVar2.f1444i;
                        long a = lVar.a(fVar4, (long) fVar4.f1419f);
                        j2 = ((long) (-lVar.a.f1444i.f1419f)) + j6;
                        j3 = -a;
                    } else {
                        j5 = (oVar2.j() + ((long) oVar2.f1443h.f1419f)) - ((long) lVar.a.f1444i.f1419f);
                    }
                    j5 = Math.max(j3, j2);
                } else {
                    long b = lVar.b(lVar.a.f1443h, j5);
                    long a2 = lVar.a(lVar.a.f1444i, j5);
                    long j7 = b - j6;
                    o oVar3 = lVar.a;
                    int i4 = oVar3.f1444i.f1419f;
                    if (j7 >= ((long) (-i4))) {
                        j7 += (long) i4;
                    }
                    long j8 = (long) oVar3.f1443h.f1419f;
                    long j9 = ((-a2) - j6) - j8;
                    if (j9 >= j8) {
                        j9 -= j8;
                    }
                    d dVar = oVar3.b;
                    Objects.requireNonNull(dVar);
                    float f2 = i2 == 0 ? dVar.e0 : i2 == 1 ? dVar.f0 : -1.0f;
                    float f3 = (float) (f2 > 0.0f ? (long) ((((float) j7) / (1.0f - f2)) + (((float) j9) / f2)) : 0);
                    long a3 = ((long) ((f3 * f2) + 0.5f)) + j6 + ((long) a.a(1.0f, f2, f3, 0.5f));
                    o oVar4 = lVar.a;
                    j5 = (((long) oVar4.f1443h.f1419f) + a3) - ((long) oVar4.f1444i.f1419f);
                }
                j4 = Math.max(j4, j5);
                i3++;
                j5 = 0;
                eVar2 = this;
                eVar3 = eVar;
            } else if (i2 == 0) {
                if (!(oVar instanceof k)) {
                    j4 = Math.max(j4, j5);
                    i3++;
                    j5 = 0;
                    eVar2 = this;
                    eVar3 = eVar;
                }
                f fVar5 = (i2 == 0 ? eVar3.f1391d : eVar3.f1392e).f1443h;
                f fVar22 = (i2 == 0 ? eVar3.f1391d : eVar3.f1392e).f1444i;
                contains = oVar.f1443h.f1425l.contains(fVar5);
                boolean contains22 = lVar.a.f1444i.f1425l.contains(fVar22);
                long j62 = lVar.a.j();
                if (contains) {
                }
                o oVar22 = lVar.a;
                if (contains) {
                }
                j5 = Math.max(j3, j2);
                j4 = Math.max(j4, j5);
                i3++;
                j5 = 0;
                eVar2 = this;
                eVar3 = eVar;
            } else {
                if (!(oVar instanceof m)) {
                    j4 = Math.max(j4, j5);
                    i3++;
                    j5 = 0;
                    eVar2 = this;
                    eVar3 = eVar;
                }
                f fVar52 = (i2 == 0 ? eVar3.f1391d : eVar3.f1392e).f1443h;
                f fVar222 = (i2 == 0 ? eVar3.f1391d : eVar3.f1392e).f1444i;
                contains = oVar.f1443h.f1425l.contains(fVar52);
                boolean contains222 = lVar.a.f1444i.f1425l.contains(fVar222);
                long j622 = lVar.a.j();
                if (contains) {
                }
                o oVar222 = lVar.a;
                if (contains) {
                }
                j5 = Math.max(j3, j2);
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
        for (d dVar : oVar.f1443h.f1424k) {
            if (dVar instanceof f) {
                a((f) dVar, i2, 0, oVar.f1444i, arrayList, null);
            } else if (dVar instanceof o) {
                a(((o) dVar).f1443h, i2, 0, oVar.f1444i, arrayList, null);
            }
        }
        for (d dVar2 : oVar.f1444i.f1424k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i2, 1, oVar.f1443h, arrayList, null);
            } else if (dVar2 instanceof o) {
                a(((o) dVar2).f1444i, i2, 1, oVar.f1443h, arrayList, null);
            }
        }
        if (i2 == 1) {
            for (d dVar3 : ((m) oVar).f1434k.f1424k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i2, 2, null, arrayList, null);
                }
            }
        }
    }

    public final void f(d dVar, d.a aVar, int i2, d.a aVar2, int i3) {
        b.a aVar3 = this.f1415g;
        aVar3.a = aVar;
        aVar3.b = aVar2;
        aVar3.c = i2;
        aVar3.f1403d = i3;
        ((ConstraintLayout.b) this.f1414f).b(dVar, aVar3);
        dVar.N(this.f1415g.f1404e);
        dVar.I(this.f1415g.f1405f);
        b.a aVar4 = this.f1415g;
        dVar.D = aVar4.f1407h;
        dVar.F(aVar4.f1406g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
        if (r12 == r7) goto L_0x0073;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
        r0.m = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
        r0.c(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
        if (r10 == r7) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
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
                g gVar3 = next.f1391d.f1440e;
                boolean z3 = gVar3.f1423j;
                g gVar4 = next.f1392e.f1440e;
                boolean z4 = gVar4.f1423j;
                if (z3 && z4) {
                    f(next, aVar, gVar3.f1420g, aVar, gVar4.f1420g);
                } else if (!z3 || !z) {
                    if (z4 && z2) {
                        f(next, aVar5, gVar3.f1420g, aVar, gVar4.f1420g);
                        gVar2 = next.f1391d.f1440e;
                        r = next.r();
                    }
                    if (next.a && (gVar = next.f1392e.f1435l) != null) {
                        gVar.c(next.b0);
                    }
                } else {
                    f(next, aVar, gVar3.f1420g, aVar5, gVar4.f1420g);
                    gVar2 = next.f1392e.f1440e;
                    r = next.l();
                }
                next.a = true;
                if (next.a) {
                    gVar.c(next.b0);
                }
            }
        }
    }
}
