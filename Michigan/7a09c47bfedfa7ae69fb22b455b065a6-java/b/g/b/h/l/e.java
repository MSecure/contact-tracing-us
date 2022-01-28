package b.g.b.h.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.b.h.c;
import b.g.b.h.d;
import b.g.b.h.f;
import b.g.b.h.h;
import b.g.b.h.l.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public b.g.b.h.e f1534a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1535b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1536c = true;

    /* renamed from: d  reason: collision with root package name */
    public b.g.b.h.e f1537d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<m> f1538e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public b.AbstractC0025b f1539f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f1540g;
    public ArrayList<k> h;

    public e(b.g.b.h.e eVar) {
        new ArrayList();
        this.f1539f = null;
        this.f1540g = new b.a();
        this.h = new ArrayList<>();
        this.f1534a = eVar;
        this.f1537d = eVar;
    }

    public final void a(f fVar, int i, int i2, f fVar2, ArrayList<k> arrayList, k kVar) {
        m mVar = fVar.f1544d;
        if (mVar.f1559c == null) {
            b.g.b.h.e eVar = this.f1534a;
            if (!(mVar == eVar.f1514d || mVar == eVar.f1515e)) {
                if (kVar == null) {
                    kVar = new k(mVar, i2);
                    arrayList.add(kVar);
                }
                mVar.f1559c = kVar;
                kVar.f1556b.add(mVar);
                for (d dVar : mVar.h.k) {
                    if (dVar instanceof f) {
                        a((f) dVar, i, 0, fVar2, arrayList, kVar);
                    }
                }
                for (d dVar2 : mVar.i.k) {
                    if (dVar2 instanceof f) {
                        a((f) dVar2, i, 1, fVar2, arrayList, kVar);
                    }
                }
                if (i == 1 && (mVar instanceof l)) {
                    for (d dVar3 : ((l) mVar).k.k) {
                        if (dVar3 instanceof f) {
                            a((f) dVar3, i, 2, fVar2, arrayList, kVar);
                        }
                    }
                }
                for (f fVar3 : mVar.h.l) {
                    a(fVar3, i, 0, fVar2, arrayList, kVar);
                }
                for (f fVar4 : mVar.i.l) {
                    a(fVar4, i, 1, fVar2, arrayList, kVar);
                }
                if (i == 1 && (mVar instanceof l)) {
                    for (f fVar5 : ((l) mVar).k.l) {
                        a(fVar5, i, 2, fVar2, arrayList, kVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01a8, code lost:
        if (r3[3].f1501c != null) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        if (r15.k == 0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013b, code lost:
        if (r3[1].f1501c != null) goto L_0x0145;
     */
    public final boolean b(b.g.b.h.e eVar) {
        g gVar;
        int i;
        int i2;
        float f2;
        int o;
        float i3;
        int i4;
        e eVar2;
        d dVar;
        d.a aVar;
        int i5;
        d.a aVar2;
        d.a aVar3 = d.a.MATCH_PARENT;
        d.a aVar4 = d.a.MATCH_CONSTRAINT;
        d.a aVar5 = d.a.WRAP_CONTENT;
        d.a aVar6 = d.a.FIXED;
        Iterator<d> it = eVar.d0.iterator();
        while (it.hasNext()) {
            d next = it.next();
            d.a[] aVarArr = next.H;
            d.a aVar7 = aVarArr[0];
            d.a aVar8 = aVarArr[1];
            if (next.V != 8) {
                if (next.o < 1.0f && aVar7 == aVar4) {
                    next.j = 2;
                }
                if (next.r < 1.0f && aVar8 == aVar4) {
                    next.k = 2;
                }
                if (next.L > 0.0f) {
                    if (aVar7 == aVar4 && (aVar8 == aVar5 || aVar8 == aVar6)) {
                        next.j = 3;
                    } else {
                        if (!(aVar8 == aVar4 && (aVar7 == aVar5 || aVar7 == aVar6))) {
                            if (aVar7 == aVar4 && aVar8 == aVar4) {
                                if (next.j == 0) {
                                    next.j = 3;
                                }
                            }
                        }
                        next.k = 3;
                    }
                }
                if (aVar7 == aVar4 && next.j == 1 && (next.x.f1501c == null || next.z.f1501c == null)) {
                    aVar7 = aVar5;
                }
                d.a aVar9 = (aVar8 == aVar4 && next.k == 1 && (next.y.f1501c == null || next.A.f1501c == null)) ? aVar5 : aVar8;
                j jVar = next.f1514d;
                jVar.f1560d = aVar7;
                jVar.f1557a = next.j;
                l lVar = next.f1515e;
                lVar.f1560d = aVar9;
                lVar.f1557a = next.k;
                if ((aVar7 == aVar3 || aVar7 == aVar6 || aVar7 == aVar5) && (aVar9 == aVar3 || aVar9 == aVar6 || aVar9 == aVar5)) {
                    int o2 = next.o();
                    if (aVar7 == aVar3) {
                        o2 = (eVar.o() - next.x.f1502d) - next.z.f1502d;
                        aVar7 = aVar6;
                    }
                    int i6 = next.i();
                    if (aVar9 == aVar3) {
                        i5 = (eVar.i() - next.y.f1502d) - next.A.f1502d;
                        aVar2 = aVar6;
                    } else {
                        i5 = i6;
                        aVar2 = aVar9;
                    }
                    f(next, aVar7, o2, aVar2, i5);
                    next.f1514d.f1561e.c(next.o());
                    next.f1515e.f1561e.c(next.i());
                    next.f1511a = true;
                } else {
                    if (aVar7 == aVar4 && (aVar9 == aVar5 || aVar9 == aVar6)) {
                        int i7 = next.j;
                        if (i7 == 3) {
                            if (aVar9 == aVar5) {
                                f(next, aVar5, 0, aVar5, 0);
                            }
                            i4 = next.i();
                            o = (int) ((((float) i4) * next.L) + 0.5f);
                            eVar2 = this;
                            dVar = next;
                            aVar7 = aVar6;
                            aVar = aVar6;
                            eVar2.f(dVar, aVar7, o, aVar, i4);
                            next.f1514d.f1561e.c(next.o());
                            next.f1515e.f1561e.c(next.i());
                        } else if (i7 == 1) {
                            f(next, aVar5, 0, aVar9, 0);
                            gVar = next.f1514d.f1561e;
                            i = next.o();
                            gVar.m = i;
                        } else if (i7 == 2) {
                            d.a[] aVarArr2 = eVar.H;
                            if (aVarArr2[0] == aVar6 || aVarArr2[0] == aVar3) {
                                o = (int) ((next.o * ((float) eVar.o())) + 0.5f);
                                i4 = next.i();
                                eVar2 = this;
                                dVar = next;
                                aVar7 = aVar6;
                                aVar = aVar9;
                                eVar2.f(dVar, aVar7, o, aVar, i4);
                                next.f1514d.f1561e.c(next.o());
                                next.f1515e.f1561e.c(next.i());
                            }
                        } else {
                            c[] cVarArr = next.F;
                            if (cVarArr[0].f1501c != null) {
                            }
                            o = 0;
                            i4 = 0;
                            eVar2 = this;
                            dVar = next;
                            aVar7 = aVar5;
                            aVar = aVar9;
                            eVar2.f(dVar, aVar7, o, aVar, i4);
                            next.f1514d.f1561e.c(next.o());
                            next.f1515e.f1561e.c(next.i());
                        }
                    }
                    if (aVar9 == aVar4 && (aVar7 == aVar5 || aVar7 == aVar6)) {
                        int i8 = next.k;
                        if (i8 == 3) {
                            if (aVar7 == aVar5) {
                                f(next, aVar5, 0, aVar5, 0);
                            }
                            o = next.o();
                            i3 = next.L;
                            if (next.M == -1) {
                                i3 = 1.0f / i3;
                            }
                            f2 = (float) o;
                            i4 = (int) ((f2 * i3) + 0.5f);
                            eVar2 = this;
                            dVar = next;
                            aVar7 = aVar6;
                            aVar = aVar6;
                            eVar2.f(dVar, aVar7, o, aVar, i4);
                            next.f1514d.f1561e.c(next.o());
                            next.f1515e.f1561e.c(next.i());
                        } else if (i8 == 1) {
                            f(next, aVar7, 0, aVar5, 0);
                            gVar = next.f1515e.f1561e;
                            i = next.i();
                            gVar.m = i;
                        } else if (i8 == 2) {
                            d.a[] aVarArr3 = eVar.H;
                            if (aVarArr3[1] == aVar6 || aVarArr3[1] == aVar3) {
                                float f3 = next.r;
                                o = next.o();
                                i4 = (int) ((f3 * ((float) eVar.i())) + 0.5f);
                                eVar2 = this;
                                dVar = next;
                                aVar = aVar6;
                                eVar2.f(dVar, aVar7, o, aVar, i4);
                                next.f1514d.f1561e.c(next.o());
                                next.f1515e.f1561e.c(next.i());
                            }
                        } else {
                            c[] cVarArr2 = next.F;
                            if (cVarArr2[2].f1501c != null) {
                            }
                            o = 0;
                            i4 = 0;
                            eVar2 = this;
                            dVar = next;
                            aVar7 = aVar5;
                            aVar = aVar9;
                            eVar2.f(dVar, aVar7, o, aVar, i4);
                            next.f1514d.f1561e.c(next.o());
                            next.f1515e.f1561e.c(next.i());
                        }
                    }
                    if (aVar7 == aVar4 && aVar9 == aVar4) {
                        int i9 = next.j;
                        if (i9 == 1 || (i2 = next.k) == 1) {
                            f(next, aVar5, 0, aVar5, 0);
                            next.f1514d.f1561e.m = next.o();
                            gVar = next.f1515e.f1561e;
                            i = next.i();
                            gVar.m = i;
                        } else if (i2 == 2 && i9 == 2) {
                            d.a[] aVarArr4 = eVar.H;
                            if (aVarArr4[0] == aVar6 || aVarArr4[0] == aVar6) {
                                d.a[] aVarArr5 = eVar.H;
                                if (aVarArr5[1] == aVar6 || aVarArr5[1] == aVar6) {
                                    float f4 = next.o;
                                    f2 = next.r;
                                    o = (int) ((f4 * ((float) eVar.o())) + 0.5f);
                                    i3 = (float) eVar.i();
                                    i4 = (int) ((f2 * i3) + 0.5f);
                                    eVar2 = this;
                                    dVar = next;
                                    aVar7 = aVar6;
                                    aVar = aVar6;
                                    eVar2.f(dVar, aVar7, o, aVar, i4);
                                    next.f1514d.f1561e.c(next.o());
                                    next.f1515e.f1561e.c(next.i());
                                }
                            }
                        }
                    }
                }
            }
            next.f1511a = true;
        }
        return false;
    }

    public void c() {
        m mVar;
        ArrayList<m> arrayList = this.f1538e;
        arrayList.clear();
        this.f1537d.f1514d.f();
        this.f1537d.f1515e.f();
        arrayList.add(this.f1537d.f1514d);
        arrayList.add(this.f1537d.f1515e);
        Iterator<d> it = this.f1537d.d0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            d next = it.next();
            if (next instanceof f) {
                mVar = new h(next);
            } else {
                if (next.s()) {
                    if (next.f1512b == null) {
                        next.f1512b = new c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f1512b);
                } else {
                    arrayList.add(next.f1514d);
                }
                if (next.t()) {
                    if (next.f1513c == null) {
                        next.f1513c = new c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f1513c);
                } else {
                    arrayList.add(next.f1515e);
                }
                if (next instanceof h) {
                    mVar = new i(next);
                }
            }
            arrayList.add(mVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<m> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<m> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            m next2 = it3.next();
            if (next2.f1558b != this.f1537d) {
                next2.d();
            }
        }
        this.h.clear();
        k.f1554c = 0;
        e(this.f1534a.f1514d, 0, this.h);
        e(this.f1534a.f1515e, 1, this.h);
        this.f1535b = false;
    }

    public final int d(b.g.b.h.e eVar, int i) {
        long j;
        long j2;
        e eVar2 = this;
        b.g.b.h.e eVar3 = eVar;
        int size = eVar2.h.size();
        long j3 = 0;
        int i2 = 0;
        long j4 = 0;
        while (i2 < size) {
            k kVar = eVar2.h.get(i2);
            m mVar = kVar.f1555a;
            if (mVar instanceof c) {
                if (((c) mVar).f1562f != i) {
                    continue;
                    j4 = Math.max(j4, j3);
                    i2++;
                    eVar2 = this;
                    eVar3 = eVar;
                    j3 = 0;
                }
            } else if (i == 0) {
                if (!(mVar instanceof j)) {
                    continue;
                    j4 = Math.max(j4, j3);
                    i2++;
                    eVar2 = this;
                    eVar3 = eVar;
                    j3 = 0;
                }
            } else if (!(mVar instanceof l)) {
                continue;
                j4 = Math.max(j4, j3);
                i2++;
                eVar2 = this;
                eVar3 = eVar;
                j3 = 0;
            }
            f fVar = (i == 0 ? eVar3.f1514d : eVar3.f1515e).h;
            f fVar2 = (i == 0 ? eVar3.f1514d : eVar3.f1515e).i;
            boolean contains = kVar.f1555a.h.l.contains(fVar);
            boolean contains2 = kVar.f1555a.i.l.contains(fVar2);
            long j5 = kVar.f1555a.j();
            if (!contains || !contains2) {
                if (contains) {
                    f fVar3 = kVar.f1555a.h;
                    j2 = kVar.b(fVar3, (long) fVar3.f1546f);
                    j = ((long) kVar.f1555a.h.f1546f) + j5;
                } else {
                    m mVar2 = kVar.f1555a;
                    if (contains2) {
                        f fVar4 = mVar2.i;
                        long a2 = kVar.a(fVar4, (long) fVar4.f1546f);
                        j = ((long) (-kVar.f1555a.i.f1546f)) + j5;
                        j2 = -a2;
                    } else {
                        j3 = (mVar2.j() + ((long) mVar2.h.f1546f)) - ((long) kVar.f1555a.i.f1546f);
                        j4 = Math.max(j4, j3);
                        i2++;
                        eVar2 = this;
                        eVar3 = eVar;
                        j3 = 0;
                    }
                }
                j3 = Math.max(j2, j);
                j4 = Math.max(j4, j3);
                i2++;
                eVar2 = this;
                eVar3 = eVar;
                j3 = 0;
            } else {
                long b2 = kVar.b(kVar.f1555a.h, j3);
                long a3 = kVar.a(kVar.f1555a.i, j3);
                long j6 = b2 - j5;
                int i3 = kVar.f1555a.i.f1546f;
                if (j6 >= ((long) (-i3))) {
                    j6 += (long) i3;
                }
                long j7 = (long) kVar.f1555a.h.f1546f;
                long j8 = ((-a3) - j5) - j7;
                if (j8 >= j7) {
                    j8 -= j7;
                }
                d dVar = kVar.f1555a.f1558b;
                if (dVar != null) {
                    float f2 = i == 0 ? dVar.S : i == 1 ? dVar.T : -1.0f;
                    float f3 = (float) (f2 > 0.0f ? (long) ((((float) j6) / (1.0f - f2)) + (((float) j8) / f2)) : 0);
                    long j9 = ((long) ((f3 * f2) + 0.5f)) + j5 + ((long) (((1.0f - f2) * f3) + 0.5f));
                    m mVar3 = kVar.f1555a;
                    j3 = (((long) mVar3.h.f1546f) + j9) - ((long) mVar3.i.f1546f);
                    j4 = Math.max(j4, j3);
                    i2++;
                    eVar2 = this;
                    eVar3 = eVar;
                    j3 = 0;
                } else {
                    throw null;
                }
            }
        }
        return (int) j4;
    }

    public final void e(m mVar, int i, ArrayList<k> arrayList) {
        for (d dVar : mVar.h.k) {
            if (dVar instanceof f) {
                a((f) dVar, i, 0, mVar.i, arrayList, null);
            } else if (dVar instanceof m) {
                a(((m) dVar).h, i, 0, mVar.i, arrayList, null);
            }
        }
        for (d dVar2 : mVar.i.k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i, 1, mVar.h, arrayList, null);
            } else if (dVar2 instanceof m) {
                a(((m) dVar2).i, i, 1, mVar.h, arrayList, null);
            }
        }
        if (i == 1) {
            for (d dVar3 : ((l) mVar).k.k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    public final void f(d dVar, d.a aVar, int i, d.a aVar2, int i2) {
        b.a aVar3 = this.f1540g;
        aVar3.f1527a = aVar;
        aVar3.f1528b = aVar2;
        aVar3.f1529c = i;
        aVar3.f1530d = i2;
        ((ConstraintLayout.b) this.f1539f).a(dVar, aVar3);
        dVar.B(this.f1540g.f1531e);
        dVar.w(this.f1540g.f1532f);
        b.a aVar4 = this.f1540g;
        dVar.w = aVar4.h;
        int i3 = aVar4.f1533g;
        dVar.P = i3;
        dVar.w = i3 > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        if (r13 == r7) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        r0.c(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        if (r11 == r7) goto L_0x007c;
     */
    public void g() {
        g gVar;
        g gVar2;
        int o;
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.MATCH_CONSTRAINT;
        d.a aVar3 = d.a.WRAP_CONTENT;
        Iterator<d> it = this.f1534a.d0.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (!next.f1511a) {
                d.a[] aVarArr = next.H;
                boolean z = false;
                d.a aVar4 = aVarArr[0];
                d.a aVar5 = aVarArr[1];
                int i = next.j;
                int i2 = next.k;
                boolean z2 = aVar4 == aVar3 || (aVar4 == aVar2 && i == 1);
                if (aVar5 == aVar3 || (aVar5 == aVar2 && i2 == 1)) {
                    z = true;
                }
                g gVar3 = next.f1514d.f1561e;
                boolean z3 = gVar3.j;
                g gVar4 = next.f1515e.f1561e;
                boolean z4 = gVar4.j;
                if (!z3 || !z4) {
                    if (!z3 || !z) {
                        if (z4 && z2) {
                            f(next, aVar3, next.f1514d.f1561e.f1547g, aVar, next.f1515e.f1561e.f1547g);
                            gVar2 = next.f1514d.f1561e;
                            o = next.o();
                        }
                        if (next.f1511a && (gVar = next.f1515e.l) != null) {
                            gVar.c(next.P);
                        }
                    } else {
                        f(next, aVar, next.f1514d.f1561e.f1547g, aVar3, next.f1515e.f1561e.f1547g);
                        gVar2 = next.f1515e.f1561e;
                        o = next.i();
                    }
                    gVar2.m = o;
                    gVar.c(next.P);
                } else {
                    f(next, aVar, gVar3.f1547g, aVar, gVar4.f1547g);
                }
                next.f1511a = true;
                gVar.c(next.P);
            }
        }
    }
}
