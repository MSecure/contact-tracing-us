package e.h.a.i.l;

import e.h.a.i.d;
import e.h.a.i.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends o {

    /* renamed from: k */
    public ArrayList<o> f1410k = new ArrayList<>();

    /* renamed from: l */
    public int f1411l;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r2 == 1) goto L_0x003f;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public c(d dVar, int i2) {
        super(dVar);
        c cVar;
        o oVar;
        int i3;
        this.f1441f = i2;
        d dVar2 = this.b;
        while (true) {
            d o = dVar2.o(this.f1441f);
            if (o == null) {
                break;
            }
            dVar2 = o;
        }
        this.b = dVar2;
        ArrayList<o> arrayList = this.f1410k;
        int i4 = this.f1441f;
        if (i4 == 0) {
            cVar = this;
            oVar = dVar2.f1391d;
            arrayList.add(oVar);
            dVar2 = dVar2.n(cVar.f1441f);
            if (dVar2 == null) {
                arrayList = cVar.f1410k;
                int i5 = cVar.f1441f;
                if (i5 != 0) {
                }
                oVar = dVar2.f1391d;
                arrayList.add(oVar);
                dVar2 = dVar2.n(cVar.f1441f);
                if (dVar2 == null) {
                    Iterator<o> it = cVar.f1410k.iterator();
                    while (it.hasNext()) {
                        o next = it.next();
                        int i6 = cVar.f1441f;
                        if (i6 == 0) {
                            next.b.b = cVar;
                        } else if (i6 == 1) {
                            next.b.c = cVar;
                        }
                    }
                    if ((cVar.f1441f == 0 && ((e) cVar.b.U).v0) && cVar.f1410k.size() > 1) {
                        ArrayList<o> arrayList2 = cVar.f1410k;
                        cVar.b = arrayList2.get(arrayList2.size() - 1).b;
                    }
                    if (cVar.f1441f == 0) {
                        i3 = cVar.b.j0;
                    } else {
                        i3 = cVar.b.k0;
                    }
                    cVar.f1411l = i3;
                }
            }
        } else if (i4 == 1) {
            cVar = this;
            oVar = dVar2.f1392e;
            arrayList.add(oVar);
            dVar2 = dVar2.n(cVar.f1441f);
            if (dVar2 == null) {
            }
        } else {
            cVar = this;
            oVar = null;
            arrayList.add(oVar);
            dVar2 = dVar2.n(cVar.f1441f);
            if (dVar2 == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:271:0x03a5, code lost:
        r10 = r10 - r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00db  */
    @Override // e.h.a.i.l.o, e.h.a.i.l.d
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void a(d dVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        boolean z;
        d.a aVar;
        int i7;
        int i8;
        float f3;
        d.a aVar2;
        boolean z2;
        float f4;
        d.a aVar3;
        int i9;
        int i10;
        int i11;
        boolean z3;
        int i12;
        int i13;
        d.a aVar4 = d.a.MATCH_CONSTRAINT;
        f fVar = this.f1443h;
        if (fVar.f1423j) {
            f fVar2 = this.f1444i;
            if (fVar2.f1423j) {
                d dVar2 = this.b.U;
                boolean z4 = dVar2 instanceof e ? ((e) dVar2).v0 : false;
                int i14 = fVar2.f1420g - fVar.f1420g;
                int size = this.f1410k.size();
                int i15 = 0;
                while (true) {
                    i2 = -1;
                    i3 = 8;
                    if (i15 >= size) {
                        i15 = -1;
                        break;
                    }
                    if (this.f1410k.get(i15).b.h0 != 8) {
                        break;
                    }
                    i15++;
                }
                int i16 = size - 1;
                int i17 = i16;
                while (true) {
                    if (i17 < 0) {
                        break;
                    }
                    if (this.f1410k.get(i17).b.h0 != 8) {
                        i2 = i17;
                        break;
                    }
                    i17--;
                }
                int i18 = 0;
                while (i18 < 2) {
                    int i19 = 0;
                    i6 = 0;
                    int i20 = 0;
                    int i21 = 0;
                    f2 = 0.0f;
                    while (i19 < size) {
                        o oVar = this.f1410k.get(i19);
                        d dVar3 = oVar.b;
                        if (dVar3.h0 != i3) {
                            i21++;
                            if (i19 > 0 && i19 >= i15) {
                                i6 += oVar.f1443h.f1419f;
                            }
                            g gVar = oVar.f1440e;
                            int i22 = gVar.f1420g;
                            boolean z5 = oVar.f1439d != aVar4;
                            if (z5) {
                                int i23 = this.f1441f;
                                i13 = i22;
                                if (i23 == 0 && !dVar3.f1391d.f1440e.f1423j) {
                                    return;
                                }
                                if (i23 != 1 || dVar3.f1392e.f1440e.f1423j) {
                                    z3 = z5;
                                } else {
                                    return;
                                }
                            } else {
                                i13 = i22;
                                z3 = z5;
                                if (oVar.a == 1 && i18 == 0) {
                                    i12 = gVar.m;
                                    i20++;
                                } else if (gVar.f1423j) {
                                    i12 = i13;
                                }
                                z3 = true;
                                if (z3) {
                                    i20++;
                                    float f5 = dVar3.l0[this.f1441f];
                                    if (f5 >= 0.0f) {
                                        f2 += f5;
                                    }
                                } else {
                                    i6 += i12;
                                }
                                if (i19 < i16 && i19 < i2) {
                                    i6 += -oVar.f1444i.f1419f;
                                }
                            }
                            i12 = i13;
                            if (z3) {
                            }
                            if (i19 < i16) {
                                i6 += -oVar.f1444i.f1419f;
                            }
                        }
                        i19++;
                        i3 = 8;
                    }
                    if (i6 < i14 || i20 == 0) {
                        i4 = i20;
                        i5 = i21;
                        break;
                    }
                    i18++;
                    i3 = 8;
                }
                i4 = 0;
                i5 = 0;
                i6 = 0;
                f2 = 0.0f;
                int i24 = this.f1443h.f1420g;
                if (z4) {
                    i24 = this.f1444i.f1420g;
                }
                if (i6 > i14) {
                    int i25 = (int) ((((float) (i6 - i14)) / 2.0f) + 0.5f);
                    i24 = z4 ? i24 + i25 : i24 - i25;
                }
                if (i4 > 0) {
                    float f6 = (float) (i14 - i6);
                    int i26 = (int) ((f6 / ((float) i4)) + 0.5f);
                    int i27 = 0;
                    int i28 = 0;
                    while (i27 < size) {
                        o oVar2 = this.f1410k.get(i27);
                        d dVar4 = oVar2.b;
                        if (dVar4.h0 != 8 && oVar2.f1439d == aVar4) {
                            g gVar2 = oVar2.f1440e;
                            if (!gVar2.f1423j) {
                                if (f2 > 0.0f) {
                                    aVar3 = aVar4;
                                    i9 = (int) (((dVar4.l0[this.f1441f] * f6) / f2) + 0.5f);
                                } else {
                                    aVar3 = aVar4;
                                    i9 = i26;
                                }
                                if (this.f1441f == 0) {
                                    i10 = dVar4.u;
                                    i11 = dVar4.t;
                                } else {
                                    i10 = dVar4.x;
                                    i11 = dVar4.w;
                                }
                                f4 = f6;
                                z2 = z4;
                                int max = Math.max(i11, oVar2.a == 1 ? Math.min(i9, gVar2.m) : i9);
                                if (i10 > 0) {
                                    max = Math.min(i10, max);
                                }
                                if (max != i9) {
                                    i28++;
                                    i9 = max;
                                }
                                oVar2.f1440e.c(i9);
                                i27++;
                                i26 = i26;
                                i6 = i6;
                                i24 = i24;
                                aVar4 = aVar3;
                                f6 = f4;
                                z4 = z2;
                            }
                        }
                        aVar3 = aVar4;
                        z2 = z4;
                        f4 = f6;
                        i27++;
                        i26 = i26;
                        i6 = i6;
                        i24 = i24;
                        aVar4 = aVar3;
                        f6 = f4;
                        z4 = z2;
                    }
                    aVar = aVar4;
                    z = z4;
                    i7 = i24;
                    if (i28 > 0) {
                        i4 -= i28;
                        int i29 = 0;
                        for (int i30 = 0; i30 < size; i30++) {
                            o oVar3 = this.f1410k.get(i30);
                            if (oVar3.b.h0 != 8) {
                                if (i30 > 0 && i30 >= i15) {
                                    i29 += oVar3.f1443h.f1419f;
                                }
                                i29 += oVar3.f1440e.f1420g;
                                if (i30 < i16 && i30 < i2) {
                                    i29 += -oVar3.f1444i.f1419f;
                                }
                            }
                        }
                        i6 = i29;
                    } else {
                        i6 = i6;
                    }
                    i8 = 2;
                    if (this.f1411l == 2 && i28 == 0) {
                        this.f1411l = 0;
                    }
                } else {
                    aVar = aVar4;
                    z = z4;
                    i7 = i24;
                    i8 = 2;
                }
                if (i6 > i14) {
                    this.f1411l = i8;
                }
                if (i5 > 0 && i4 == 0 && i15 == i2) {
                    this.f1411l = i8;
                }
                int i31 = this.f1411l;
                if (i31 == 1) {
                    int i32 = i5 > 1 ? (i14 - i6) / (i5 - 1) : i5 == 1 ? (i14 - i6) / 2 : 0;
                    if (i4 > 0) {
                        i32 = 0;
                    }
                    int i33 = i7;
                    int i34 = 0;
                    while (i34 < size) {
                        o oVar4 = this.f1410k.get(z ? size - (i34 + 1) : i34);
                        if (oVar4.b.h0 == 8) {
                            oVar4.f1443h.c(i33);
                            oVar4.f1444i.c(i33);
                            aVar2 = aVar;
                        } else {
                            if (i34 > 0) {
                                i33 = z ? i33 - i32 : i33 + i32;
                            }
                            if (i34 > 0 && i34 >= i15) {
                                int i35 = oVar4.f1443h.f1419f;
                                i33 = z ? i33 - i35 : i33 + i35;
                            }
                            (z ? oVar4.f1444i : oVar4.f1443h).c(i33);
                            g gVar3 = oVar4.f1440e;
                            int i36 = gVar3.f1420g;
                            aVar2 = aVar;
                            if (oVar4.f1439d == aVar2 && oVar4.a == 1) {
                                i36 = gVar3.m;
                            }
                            i33 = z ? i33 - i36 : i33 + i36;
                            (z ? oVar4.f1443h : oVar4.f1444i).c(i33);
                            oVar4.f1442g = true;
                            if (i34 < i16 && i34 < i2) {
                                int i37 = -oVar4.f1444i.f1419f;
                                i33 = z ? i33 - i37 : i33 + i37;
                            }
                        }
                        i34++;
                        aVar = aVar2;
                    }
                } else if (i31 == 0) {
                    int i38 = (i14 - i6) / (i5 + 1);
                    if (i4 > 0) {
                        i38 = 0;
                    }
                    int i39 = i7;
                    for (int i40 = 0; i40 < size; i40++) {
                        o oVar5 = this.f1410k.get(z ? size - (i40 + 1) : i40);
                        if (oVar5.b.h0 == 8) {
                            oVar5.f1443h.c(i39);
                            oVar5.f1444i.c(i39);
                        } else {
                            int i41 = z ? i39 - i38 : i39 + i38;
                            if (i40 > 0 && i40 >= i15) {
                                int i42 = oVar5.f1443h.f1419f;
                                i41 = z ? i41 - i42 : i41 + i42;
                            }
                            (z ? oVar5.f1444i : oVar5.f1443h).c(i41);
                            g gVar4 = oVar5.f1440e;
                            int i43 = gVar4.f1420g;
                            if (oVar5.f1439d == aVar && oVar5.a == 1) {
                                i43 = Math.min(i43, gVar4.m);
                            }
                            i39 = z ? i41 - i43 : i41 + i43;
                            (z ? oVar5.f1443h : oVar5.f1444i).c(i39);
                            if (i40 < i16 && i40 < i2) {
                                int i44 = -oVar5.f1444i.f1419f;
                                i39 = z ? i39 - i44 : i39 + i44;
                            }
                        }
                    }
                } else if (i31 == 2) {
                    if (this.f1441f == 0) {
                        f3 = this.b.e0;
                    } else {
                        f3 = this.b.f0;
                    }
                    if (z) {
                        f3 = 1.0f - f3;
                    }
                    int i45 = (int) ((((float) (i14 - i6)) * f3) + 0.5f);
                    if (i45 < 0 || i4 > 0) {
                        i45 = 0;
                    }
                    int i46 = z ? i7 - i45 : i7 + i45;
                    for (int i47 = 0; i47 < size; i47++) {
                        o oVar6 = this.f1410k.get(z ? size - (i47 + 1) : i47);
                        if (oVar6.b.h0 == 8) {
                            oVar6.f1443h.c(i46);
                            oVar6.f1444i.c(i46);
                        } else {
                            if (i47 > 0 && i47 >= i15) {
                                int i48 = oVar6.f1443h.f1419f;
                                i46 = z ? i46 - i48 : i46 + i48;
                            }
                            (z ? oVar6.f1444i : oVar6.f1443h).c(i46);
                            g gVar5 = oVar6.f1440e;
                            int i49 = gVar5.f1420g;
                            if (oVar6.f1439d == aVar && oVar6.a == 1) {
                                i49 = gVar5.m;
                            }
                            i46 += i49;
                            (z ? oVar6.f1443h : oVar6.f1444i).c(i46);
                            if (i47 < i16 && i47 < i2) {
                                int i50 = -oVar6.f1444i.f1419f;
                                i46 = z ? i46 - i50 : i46 + i50;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
        if (r1 != null) goto L_0x0078;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
        r2 = r6.f1444i;
        r2.f1425l.add(r1);
        r2.f1419f = -r0;
        r1.f1424k.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c4, code lost:
        if (r1 != null) goto L_0x0078;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c7, code lost:
        r6.f1443h.a = r6;
        r6.f1444i.a = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cf, code lost:
        return;
     */
    @Override // e.h.a.i.l.o
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void d() {
        f i2;
        int d2;
        Iterator<o> it = this.f1410k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f1410k.size();
        if (size >= 1) {
            d dVar = this.f1410k.get(0).b;
            d dVar2 = this.f1410k.get(size - 1).b;
            if (this.f1441f == 0) {
                e.h.a.i.c cVar = dVar.I;
                e.h.a.i.c cVar2 = dVar2.K;
                f i3 = i(cVar, 0);
                int d3 = cVar.d();
                d m = m();
                if (m != null) {
                    d3 = m.I.d();
                }
                if (i3 != null) {
                    f fVar = this.f1443h;
                    fVar.f1425l.add(i3);
                    fVar.f1419f = d3;
                    i3.f1424k.add(fVar);
                }
                i2 = i(cVar2, 0);
                d2 = cVar2.d();
                d n = n();
                if (n != null) {
                    d2 = n.K.d();
                }
            } else {
                e.h.a.i.c cVar3 = dVar.J;
                e.h.a.i.c cVar4 = dVar2.L;
                f i4 = i(cVar3, 1);
                int d4 = cVar3.d();
                d m2 = m();
                if (m2 != null) {
                    d4 = m2.J.d();
                }
                if (i4 != null) {
                    f fVar2 = this.f1443h;
                    fVar2.f1425l.add(i4);
                    fVar2.f1419f = d4;
                    i4.f1424k.add(fVar2);
                }
                i2 = i(cVar4, 1);
                d2 = cVar4.d();
                d n2 = n();
                if (n2 != null) {
                    d2 = n2.L.d();
                }
            }
        }
    }

    @Override // e.h.a.i.l.o
    public void e() {
        for (int i2 = 0; i2 < this.f1410k.size(); i2++) {
            this.f1410k.get(i2).e();
        }
    }

    @Override // e.h.a.i.l.o
    public void f() {
        this.c = null;
        Iterator<o> it = this.f1410k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // e.h.a.i.l.o
    public long j() {
        int size = this.f1410k.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            o oVar = this.f1410k.get(i2);
            j2 = ((long) oVar.f1444i.f1419f) + oVar.j() + j2 + ((long) oVar.f1443h.f1419f);
        }
        return j2;
    }

    @Override // e.h.a.i.l.o
    public boolean k() {
        int size = this.f1410k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f1410k.get(i2).k()) {
                return false;
            }
        }
        return true;
    }

    public final d m() {
        for (int i2 = 0; i2 < this.f1410k.size(); i2++) {
            d dVar = this.f1410k.get(i2).b;
            if (dVar.h0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final d n() {
        for (int size = this.f1410k.size() - 1; size >= 0; size--) {
            d dVar = this.f1410k.get(size).b;
            if (dVar.h0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f1441f == 0 ? "horizontal : " : "vertical : ");
        Iterator<o> it = this.f1410k.iterator();
        while (it.hasNext()) {
            sb.append("<");
            sb.append(it.next());
            sb.append("> ");
        }
        return sb.toString();
    }
}
