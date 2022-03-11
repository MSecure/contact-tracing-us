package e.g.b.h.l;

import e.g.b.h.d;
import e.g.b.h.e;
import f.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class c extends o {

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<o> f1292k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    public int f1293l;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r2 == 1) goto L_0x003f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0099  */
    public c(d dVar, int i2) {
        super(dVar);
        c cVar;
        o oVar;
        Iterator<o> it;
        int i3;
        this.f1323f = i2;
        d dVar2 = this.b;
        while (true) {
            d o = dVar2.o(this.f1323f);
            if (o == null) {
                break;
            }
            dVar2 = o;
        }
        this.b = dVar2;
        ArrayList<o> arrayList = this.f1292k;
        int i4 = this.f1323f;
        if (i4 == 0) {
            cVar = this;
            oVar = dVar2.f1273d;
            arrayList.add(oVar);
            dVar2 = dVar2.n(cVar.f1323f);
            if (dVar2 == null) {
                arrayList = cVar.f1292k;
                int i5 = cVar.f1323f;
                if (i5 != 0) {
                }
                oVar = dVar2.f1273d;
                arrayList.add(oVar);
                dVar2 = dVar2.n(cVar.f1323f);
                if (dVar2 == null) {
                    it = cVar.f1292k.iterator();
                }
            }
            it = cVar.f1292k.iterator();
            while (it.hasNext()) {
                o next = it.next();
                int i6 = cVar.f1323f;
                if (i6 == 0) {
                    next.b.b = cVar;
                } else if (i6 == 1) {
                    next.b.c = cVar;
                }
            }
            if ((cVar.f1323f != 0 && ((e) cVar.b.P).p0) && cVar.f1292k.size() > 1) {
                ArrayList<o> arrayList2 = cVar.f1292k;
                cVar.b = arrayList2.get(arrayList2.size() - 1).b;
            }
            if (cVar.f1323f == 0) {
                i3 = cVar.b.e0;
            } else {
                i3 = cVar.b.f0;
            }
            cVar.f1293l = i3;
        } else if (i4 == 1) {
            cVar = this;
            oVar = dVar2.f1274e;
            arrayList.add(oVar);
            dVar2 = dVar2.n(cVar.f1323f);
            if (dVar2 == null) {
            }
            it = cVar.f1292k.iterator();
            while (it.hasNext()) {
            }
            ArrayList<o> arrayList22 = cVar.f1292k;
            cVar.b = arrayList22.get(arrayList22.size() - 1).b;
            if (cVar.f1323f == 0) {
            }
            cVar.f1293l = i3;
        } else {
            cVar = this;
        }
        oVar = null;
        arrayList.add(oVar);
        dVar2 = dVar2.n(cVar.f1323f);
        if (dVar2 == null) {
        }
        it = cVar.f1292k.iterator();
        while (it.hasNext()) {
        }
        ArrayList<o> arrayList222 = cVar.f1292k;
        cVar.b = arrayList222.get(arrayList222.size() - 1).b;
        if (cVar.f1323f == 0) {
        }
        cVar.f1293l = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00dd  */
    @Override // e.g.b.h.l.o, e.g.b.h.l.d
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
        f fVar = this.f1325h;
        if (fVar.f1305j) {
            f fVar2 = this.f1326i;
            if (fVar2.f1305j) {
                d dVar2 = this.b.P;
                boolean z4 = (dVar2 == null || !(dVar2 instanceof e)) ? false : ((e) dVar2).p0;
                int i14 = fVar2.f1302g - fVar.f1302g;
                int size = this.f1292k.size();
                int i15 = 0;
                while (true) {
                    i2 = -1;
                    i3 = 8;
                    if (i15 >= size) {
                        i15 = -1;
                        break;
                    }
                    if (this.f1292k.get(i15).b.c0 != 8) {
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
                    if (this.f1292k.get(i17).b.c0 != 8) {
                        i2 = i17;
                        break;
                    }
                    i17--;
                }
                int i18 = 0;
                while (true) {
                    if (i18 >= 2) {
                        i4 = 0;
                        i5 = 0;
                        i6 = 0;
                        f2 = 0.0f;
                        break;
                    }
                    int i19 = 0;
                    i6 = 0;
                    i10 = 0;
                    i11 = 0;
                    f2 = 0.0f;
                    while (i19 < size) {
                        o oVar = this.f1292k.get(i19);
                        d dVar3 = oVar.b;
                        if (dVar3.c0 != i3) {
                            i11++;
                            if (i19 > 0 && i19 >= i15) {
                                i6 += oVar.f1325h.f1301f;
                            }
                            g gVar = oVar.f1322e;
                            int i20 = gVar.f1302g;
                            boolean z5 = oVar.f1321d != aVar4;
                            if (z5) {
                                int i21 = this.f1323f;
                                i13 = i20;
                                if (i21 == 0 && !dVar3.f1273d.f1322e.f1305j) {
                                    return;
                                }
                                if (i21 != 1 || dVar3.f1274e.f1322e.f1305j) {
                                    z3 = z5;
                                } else {
                                    return;
                                }
                            } else {
                                i13 = i20;
                                z3 = z5;
                                if (oVar.a == 1 && i18 == 0) {
                                    i12 = gVar.m;
                                    i10++;
                                } else if (gVar.f1305j) {
                                    i12 = i13;
                                }
                                z3 = true;
                                if (z3) {
                                    i10++;
                                    float f5 = dVar3.g0[this.f1323f];
                                    if (f5 >= 0.0f) {
                                        f2 += f5;
                                    }
                                } else {
                                    i6 += i12;
                                }
                                if (i19 < i16 && i19 < i2) {
                                    i6 += -oVar.f1326i.f1301f;
                                }
                            }
                            i12 = i13;
                            if (z3) {
                            }
                            i6 += -oVar.f1326i.f1301f;
                        }
                        i19++;
                        i3 = 8;
                    }
                    if (i6 < i14 || i10 == 0) {
                        i4 = i10;
                        i5 = i11;
                    } else {
                        i18++;
                        i3 = 8;
                    }
                }
                i4 = i10;
                i5 = i11;
                int i22 = this.f1325h.f1302g;
                if (z4) {
                    i22 = this.f1326i.f1302g;
                }
                if (i6 > i14) {
                    int i23 = (int) ((((float) (i6 - i14)) / 2.0f) + 0.5f);
                    i22 = z4 ? i22 + i23 : i22 - i23;
                }
                if (i4 > 0) {
                    float f6 = (float) (i14 - i6);
                    int i24 = (int) ((f6 / ((float) i4)) + 0.5f);
                    int i25 = 0;
                    int i26 = 0;
                    while (i25 < size) {
                        o oVar2 = this.f1292k.get(i25);
                        d dVar4 = oVar2.b;
                        if (dVar4.c0 != 8 && oVar2.f1321d == aVar4) {
                            g gVar2 = oVar2.f1322e;
                            if (!gVar2.f1305j) {
                                if (f2 > 0.0f) {
                                    aVar3 = aVar4;
                                    i9 = (int) (((dVar4.g0[this.f1323f] * f6) / f2) + 0.5f);
                                } else {
                                    aVar3 = aVar4;
                                    i9 = i24;
                                }
                                if (this.f1323f == 0) {
                                    int i27 = dVar4.p;
                                    f4 = f6;
                                    z2 = z4;
                                    int max = Math.max(dVar4.o, oVar2.a == 1 ? Math.min(i9, gVar2.m) : i9);
                                    if (i27 > 0) {
                                        max = Math.min(i27, max);
                                    }
                                    if (max != i9) {
                                        i26++;
                                        i9 = max;
                                    }
                                } else {
                                    z2 = z4;
                                    f4 = f6;
                                    int i28 = dVar4.s;
                                    int max2 = Math.max(dVar4.r, oVar2.a == 1 ? Math.min(i9, gVar2.m) : i9);
                                    if (i28 > 0) {
                                        max2 = Math.min(i28, max2);
                                    }
                                    if (max2 != i9) {
                                        i26++;
                                        i9 = max2;
                                    }
                                }
                                oVar2.f1322e.c(i9);
                                i25++;
                                i24 = i24;
                                i6 = i6;
                                i22 = i22;
                                aVar4 = aVar3;
                                f6 = f4;
                                z4 = z2;
                            }
                        }
                        aVar3 = aVar4;
                        z2 = z4;
                        f4 = f6;
                        i25++;
                        i24 = i24;
                        i6 = i6;
                        i22 = i22;
                        aVar4 = aVar3;
                        f6 = f4;
                        z4 = z2;
                    }
                    aVar = aVar4;
                    z = z4;
                    i7 = i22;
                    if (i26 > 0) {
                        i4 -= i26;
                        int i29 = 0;
                        for (int i30 = 0; i30 < size; i30++) {
                            o oVar3 = this.f1292k.get(i30);
                            if (oVar3.b.c0 != 8) {
                                if (i30 > 0 && i30 >= i15) {
                                    i29 += oVar3.f1325h.f1301f;
                                }
                                i29 += oVar3.f1322e.f1302g;
                                if (i30 < i16 && i30 < i2) {
                                    i29 += -oVar3.f1326i.f1301f;
                                }
                            }
                        }
                        i6 = i29;
                    } else {
                        i6 = i6;
                    }
                    i8 = 2;
                    if (this.f1293l == 2 && i26 == 0) {
                        this.f1293l = 0;
                    }
                } else {
                    aVar = aVar4;
                    z = z4;
                    i7 = i22;
                    i8 = 2;
                }
                if (i6 > i14) {
                    this.f1293l = i8;
                }
                if (i5 > 0 && i4 == 0 && i15 == i2) {
                    this.f1293l = i8;
                }
                int i31 = this.f1293l;
                if (i31 == 1) {
                    int i32 = i5 > 1 ? (i14 - i6) / (i5 - 1) : i5 == 1 ? (i14 - i6) / 2 : 0;
                    if (i4 > 0) {
                        i32 = 0;
                    }
                    int i33 = i7;
                    int i34 = 0;
                    while (i34 < size) {
                        o oVar4 = this.f1292k.get(z ? size - (i34 + 1) : i34);
                        if (oVar4.b.c0 == 8) {
                            oVar4.f1325h.c(i33);
                            oVar4.f1326i.c(i33);
                            aVar2 = aVar;
                        } else {
                            if (i34 > 0) {
                                i33 = z ? i33 - i32 : i33 + i32;
                            }
                            if (i34 > 0 && i34 >= i15) {
                                int i35 = oVar4.f1325h.f1301f;
                                i33 = z ? i33 - i35 : i33 + i35;
                            }
                            (z ? oVar4.f1326i : oVar4.f1325h).c(i33);
                            g gVar3 = oVar4.f1322e;
                            int i36 = gVar3.f1302g;
                            aVar2 = aVar;
                            if (oVar4.f1321d == aVar2 && oVar4.a == 1) {
                                i36 = gVar3.m;
                            }
                            i33 = z ? i33 - i36 : i33 + i36;
                            (z ? oVar4.f1325h : oVar4.f1326i).c(i33);
                            oVar4.f1324g = true;
                            if (i34 < i16 && i34 < i2) {
                                int i37 = -oVar4.f1326i.f1301f;
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
                        o oVar5 = this.f1292k.get(z ? size - (i40 + 1) : i40);
                        if (oVar5.b.c0 == 8) {
                            oVar5.f1325h.c(i39);
                            oVar5.f1326i.c(i39);
                        } else {
                            int i41 = z ? i39 - i38 : i39 + i38;
                            if (i40 > 0 && i40 >= i15) {
                                int i42 = oVar5.f1325h.f1301f;
                                i41 = z ? i41 - i42 : i41 + i42;
                            }
                            (z ? oVar5.f1326i : oVar5.f1325h).c(i41);
                            g gVar4 = oVar5.f1322e;
                            int i43 = gVar4.f1302g;
                            if (oVar5.f1321d == aVar && oVar5.a == 1) {
                                i43 = Math.min(i43, gVar4.m);
                            }
                            i39 = z ? i41 - i43 : i41 + i43;
                            (z ? oVar5.f1325h : oVar5.f1326i).c(i39);
                            if (i40 < i16 && i40 < i2) {
                                int i44 = -oVar5.f1326i.f1301f;
                                i39 = z ? i39 - i44 : i39 + i44;
                            }
                        }
                    }
                } else if (i31 == 2) {
                    if (this.f1323f == 0) {
                        f3 = this.b.Z;
                    } else {
                        f3 = this.b.a0;
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
                        o oVar6 = this.f1292k.get(z ? size - (i47 + 1) : i47);
                        if (oVar6.b.c0 == 8) {
                            oVar6.f1325h.c(i46);
                            oVar6.f1326i.c(i46);
                        } else {
                            if (i47 > 0 && i47 >= i15) {
                                int i48 = oVar6.f1325h.f1301f;
                                i46 = z ? i46 - i48 : i46 + i48;
                            }
                            (z ? oVar6.f1326i : oVar6.f1325h).c(i46);
                            g gVar5 = oVar6.f1322e;
                            int i49 = gVar5.f1302g;
                            if (oVar6.f1321d == aVar) {
                                if (oVar6.a == 1) {
                                    i49 = gVar5.m;
                                }
                            }
                            i46 = z ? i46 - i49 : i46 + i49;
                            (z ? oVar6.f1325h : oVar6.f1326i).c(i46);
                            if (i47 < i16 && i47 < i2) {
                                int i50 = -oVar6.f1326i.f1301f;
                                i46 = z ? i46 - i50 : i46 + i50;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0076, code lost:
        if (r1 != null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c4, code lost:
        if (r1 != null) goto L_0x0078;
     */
    @Override // e.g.b.h.l.o
    public void d() {
        f i2;
        int d2;
        Iterator<o> it = this.f1292k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f1292k.size();
        if (size >= 1) {
            d dVar = this.f1292k.get(0).b;
            d dVar2 = this.f1292k.get(size - 1).b;
            if (this.f1323f == 0) {
                e.g.b.h.c cVar = dVar.D;
                e.g.b.h.c cVar2 = dVar2.F;
                f i3 = i(cVar, 0);
                int d3 = cVar.d();
                d m = m();
                if (m != null) {
                    d3 = m.D.d();
                }
                if (i3 != null) {
                    f fVar = this.f1325h;
                    fVar.f1307l.add(i3);
                    fVar.f1301f = d3;
                    i3.f1306k.add(fVar);
                }
                i2 = i(cVar2, 0);
                d2 = cVar2.d();
                d n = n();
                if (n != null) {
                    d2 = n.F.d();
                }
            } else {
                e.g.b.h.c cVar3 = dVar.E;
                e.g.b.h.c cVar4 = dVar2.G;
                f i4 = i(cVar3, 1);
                int d4 = cVar3.d();
                d m2 = m();
                if (m2 != null) {
                    d4 = m2.E.d();
                }
                if (i4 != null) {
                    f fVar2 = this.f1325h;
                    fVar2.f1307l.add(i4);
                    fVar2.f1301f = d4;
                    i4.f1306k.add(fVar2);
                }
                i2 = i(cVar4, 1);
                d2 = cVar4.d();
                d n2 = n();
                if (n2 != null) {
                    d2 = n2.G.d();
                }
            }
            f fVar3 = this.f1326i;
            fVar3.f1307l.add(i2);
            fVar3.f1301f = -d2;
            i2.f1306k.add(fVar3);
            this.f1325h.a = this;
            this.f1326i.a = this;
        }
    }

    @Override // e.g.b.h.l.o
    public void e() {
        for (int i2 = 0; i2 < this.f1292k.size(); i2++) {
            this.f1292k.get(i2).e();
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.c = null;
        Iterator<o> it = this.f1292k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // e.g.b.h.l.o
    public long j() {
        int size = this.f1292k.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            o oVar = this.f1292k.get(i2);
            j2 = ((long) oVar.f1326i.f1301f) + oVar.j() + j2 + ((long) oVar.f1325h.f1301f);
        }
        return j2;
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        int size = this.f1292k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f1292k.get(i2).k()) {
                return false;
            }
        }
        return true;
    }

    public final d m() {
        for (int i2 = 0; i2 < this.f1292k.size(); i2++) {
            d dVar = this.f1292k.get(i2).b;
            if (dVar.c0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final d n() {
        for (int size = this.f1292k.size() - 1; size >= 0; size--) {
            d dVar = this.f1292k.get(size).b;
            if (dVar.c0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder h2 = a.h("ChainRun ");
        h2.append(this.f1323f == 0 ? "horizontal : " : "vertical : ");
        String sb = h2.toString();
        Iterator<o> it = this.f1292k.iterator();
        while (it.hasNext()) {
            String t = a.t(sb, "<");
            sb = a.t(t + it.next(), "> ");
        }
        return sb;
    }
}
