package e.g.a.i.l;

import e.g.a.i.d;
import e.g.a.i.e;
import java.util.ArrayList;
import java.util.Iterator;

public class c extends o {

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<o> f1326k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    public int f1327l;

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
        this.f1357f = i2;
        d dVar2 = this.b;
        while (true) {
            d o = dVar2.o(this.f1357f);
            if (o == null) {
                break;
            }
            dVar2 = o;
        }
        this.b = dVar2;
        ArrayList<o> arrayList = this.f1326k;
        int i4 = this.f1357f;
        if (i4 == 0) {
            cVar = this;
            oVar = dVar2.f1307d;
            arrayList.add(oVar);
            dVar2 = dVar2.n(cVar.f1357f);
            if (dVar2 == null) {
                arrayList = cVar.f1326k;
                int i5 = cVar.f1357f;
                if (i5 != 0) {
                }
                oVar = dVar2.f1307d;
                arrayList.add(oVar);
                dVar2 = dVar2.n(cVar.f1357f);
                if (dVar2 == null) {
                    it = cVar.f1326k.iterator();
                }
            }
            it = cVar.f1326k.iterator();
            while (it.hasNext()) {
                o next = it.next();
                int i6 = cVar.f1357f;
                if (i6 == 0) {
                    next.b.b = cVar;
                } else if (i6 == 1) {
                    next.b.c = cVar;
                }
            }
            if ((cVar.f1357f != 0 && ((e) cVar.b.U).v0) && cVar.f1326k.size() > 1) {
                ArrayList<o> arrayList2 = cVar.f1326k;
                cVar.b = arrayList2.get(arrayList2.size() - 1).b;
            }
            if (cVar.f1357f == 0) {
                i3 = cVar.b.j0;
            } else {
                i3 = cVar.b.k0;
            }
            cVar.f1327l = i3;
        } else if (i4 == 1) {
            cVar = this;
            oVar = dVar2.f1308e;
            arrayList.add(oVar);
            dVar2 = dVar2.n(cVar.f1357f);
            if (dVar2 == null) {
            }
            it = cVar.f1326k.iterator();
            while (it.hasNext()) {
            }
            ArrayList<o> arrayList22 = cVar.f1326k;
            cVar.b = arrayList22.get(arrayList22.size() - 1).b;
            if (cVar.f1357f == 0) {
            }
            cVar.f1327l = i3;
        } else {
            cVar = this;
        }
        oVar = null;
        arrayList.add(oVar);
        dVar2 = dVar2.n(cVar.f1357f);
        if (dVar2 == null) {
        }
        it = cVar.f1326k.iterator();
        while (it.hasNext()) {
        }
        ArrayList<o> arrayList222 = cVar.f1326k;
        cVar.b = arrayList222.get(arrayList222.size() - 1).b;
        if (cVar.f1357f == 0) {
        }
        cVar.f1327l = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00db  */
    @Override // e.g.a.i.l.d, e.g.a.i.l.o
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
        int i12;
        int i13;
        boolean z3;
        int i14;
        int i15;
        d.a aVar4 = d.a.MATCH_CONSTRAINT;
        f fVar = this.f1359h;
        if (fVar.f1339j) {
            f fVar2 = this.f1360i;
            if (fVar2.f1339j) {
                d dVar2 = this.b.U;
                boolean z4 = dVar2 instanceof e ? ((e) dVar2).v0 : false;
                int i16 = fVar2.f1336g - fVar.f1336g;
                int size = this.f1326k.size();
                int i17 = 0;
                while (true) {
                    i2 = -1;
                    i3 = 8;
                    if (i17 >= size) {
                        i17 = -1;
                        break;
                    }
                    if (this.f1326k.get(i17).b.h0 != 8) {
                        break;
                    }
                    i17++;
                }
                int i18 = size - 1;
                int i19 = i18;
                while (true) {
                    if (i19 < 0) {
                        break;
                    }
                    if (this.f1326k.get(i19).b.h0 != 8) {
                        i2 = i19;
                        break;
                    }
                    i19--;
                }
                int i20 = 0;
                while (true) {
                    if (i20 >= 2) {
                        i4 = 0;
                        i5 = 0;
                        i6 = 0;
                        f2 = 0.0f;
                        break;
                    }
                    int i21 = 0;
                    i6 = 0;
                    i12 = 0;
                    i13 = 0;
                    f2 = 0.0f;
                    while (i21 < size) {
                        o oVar = this.f1326k.get(i21);
                        d dVar3 = oVar.b;
                        if (dVar3.h0 != i3) {
                            i13++;
                            if (i21 > 0 && i21 >= i17) {
                                i6 += oVar.f1359h.f1335f;
                            }
                            g gVar = oVar.f1356e;
                            int i22 = gVar.f1336g;
                            boolean z5 = oVar.f1355d != aVar4;
                            if (z5) {
                                int i23 = this.f1357f;
                                i15 = i22;
                                if (i23 == 0 && !dVar3.f1307d.f1356e.f1339j) {
                                    return;
                                }
                                if (i23 != 1 || dVar3.f1308e.f1356e.f1339j) {
                                    z3 = z5;
                                } else {
                                    return;
                                }
                            } else {
                                i15 = i22;
                                z3 = z5;
                                if (oVar.a == 1 && i20 == 0) {
                                    i14 = gVar.m;
                                    i12++;
                                } else if (gVar.f1339j) {
                                    i14 = i15;
                                }
                                z3 = true;
                                if (z3) {
                                    i12++;
                                    float f5 = dVar3.l0[this.f1357f];
                                    if (f5 >= 0.0f) {
                                        f2 += f5;
                                    }
                                } else {
                                    i6 += i14;
                                }
                                if (i21 < i18 && i21 < i2) {
                                    i6 += -oVar.f1360i.f1335f;
                                }
                            }
                            i14 = i15;
                            if (z3) {
                            }
                            i6 += -oVar.f1360i.f1335f;
                        }
                        i21++;
                        i3 = 8;
                    }
                    if (i6 < i16 || i12 == 0) {
                        i4 = i12;
                        i5 = i13;
                    } else {
                        i20++;
                        i3 = 8;
                    }
                }
                i4 = i12;
                i5 = i13;
                int i24 = this.f1359h.f1336g;
                if (z4) {
                    i24 = this.f1360i.f1336g;
                }
                if (i6 > i16) {
                    int i25 = (int) ((((float) (i6 - i16)) / 2.0f) + 0.5f);
                    i24 = z4 ? i24 + i25 : i24 - i25;
                }
                if (i4 > 0) {
                    float f6 = (float) (i16 - i6);
                    int i26 = (int) ((f6 / ((float) i4)) + 0.5f);
                    int i27 = 0;
                    int i28 = 0;
                    while (i27 < size) {
                        o oVar2 = this.f1326k.get(i27);
                        d dVar4 = oVar2.b;
                        if (dVar4.h0 != 8 && oVar2.f1355d == aVar4) {
                            g gVar2 = oVar2.f1356e;
                            if (!gVar2.f1339j) {
                                if (f2 > 0.0f) {
                                    aVar3 = aVar4;
                                    i9 = (int) (((dVar4.l0[this.f1357f] * f6) / f2) + 0.5f);
                                } else {
                                    aVar3 = aVar4;
                                    i9 = i26;
                                }
                                if (this.f1357f == 0) {
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
                                oVar2.f1356e.c(i9);
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
                            o oVar3 = this.f1326k.get(i30);
                            if (oVar3.b.h0 != 8) {
                                if (i30 > 0 && i30 >= i17) {
                                    i29 += oVar3.f1359h.f1335f;
                                }
                                i29 += oVar3.f1356e.f1336g;
                                if (i30 < i18 && i30 < i2) {
                                    i29 += -oVar3.f1360i.f1335f;
                                }
                            }
                        }
                        i6 = i29;
                    } else {
                        i6 = i6;
                    }
                    i8 = 2;
                    if (this.f1327l == 2 && i28 == 0) {
                        this.f1327l = 0;
                    }
                } else {
                    aVar = aVar4;
                    z = z4;
                    i7 = i24;
                    i8 = 2;
                }
                if (i6 > i16) {
                    this.f1327l = i8;
                }
                if (i5 > 0 && i4 == 0 && i17 == i2) {
                    this.f1327l = i8;
                }
                int i31 = this.f1327l;
                if (i31 == 1) {
                    int i32 = i5 > 1 ? (i16 - i6) / (i5 - 1) : i5 == 1 ? (i16 - i6) / 2 : 0;
                    if (i4 > 0) {
                        i32 = 0;
                    }
                    int i33 = i7;
                    int i34 = 0;
                    while (i34 < size) {
                        o oVar4 = this.f1326k.get(z ? size - (i34 + 1) : i34);
                        if (oVar4.b.h0 == 8) {
                            oVar4.f1359h.c(i33);
                            oVar4.f1360i.c(i33);
                            aVar2 = aVar;
                        } else {
                            if (i34 > 0) {
                                i33 = z ? i33 - i32 : i33 + i32;
                            }
                            if (i34 > 0 && i34 >= i17) {
                                int i35 = oVar4.f1359h.f1335f;
                                i33 = z ? i33 - i35 : i33 + i35;
                            }
                            (z ? oVar4.f1360i : oVar4.f1359h).c(i33);
                            g gVar3 = oVar4.f1356e;
                            int i36 = gVar3.f1336g;
                            aVar2 = aVar;
                            if (oVar4.f1355d == aVar2 && oVar4.a == 1) {
                                i36 = gVar3.m;
                            }
                            i33 = z ? i33 - i36 : i33 + i36;
                            (z ? oVar4.f1359h : oVar4.f1360i).c(i33);
                            oVar4.f1358g = true;
                            if (i34 < i18 && i34 < i2) {
                                int i37 = -oVar4.f1360i.f1335f;
                                i33 = z ? i33 - i37 : i33 + i37;
                            }
                        }
                        i34++;
                        aVar = aVar2;
                    }
                } else if (i31 == 0) {
                    int i38 = (i16 - i6) / (i5 + 1);
                    if (i4 > 0) {
                        i38 = 0;
                    }
                    int i39 = i7;
                    for (int i40 = 0; i40 < size; i40++) {
                        o oVar5 = this.f1326k.get(z ? size - (i40 + 1) : i40);
                        if (oVar5.b.h0 == 8) {
                            oVar5.f1359h.c(i39);
                            oVar5.f1360i.c(i39);
                        } else {
                            int i41 = z ? i39 - i38 : i39 + i38;
                            if (i40 > 0 && i40 >= i17) {
                                int i42 = oVar5.f1359h.f1335f;
                                i41 = z ? i41 - i42 : i41 + i42;
                            }
                            (z ? oVar5.f1360i : oVar5.f1359h).c(i41);
                            g gVar4 = oVar5.f1356e;
                            int i43 = gVar4.f1336g;
                            if (oVar5.f1355d == aVar && oVar5.a == 1) {
                                i43 = Math.min(i43, gVar4.m);
                            }
                            i39 = z ? i41 - i43 : i41 + i43;
                            (z ? oVar5.f1359h : oVar5.f1360i).c(i39);
                            if (i40 < i18 && i40 < i2) {
                                int i44 = -oVar5.f1360i.f1335f;
                                i39 = z ? i39 - i44 : i39 + i44;
                            }
                        }
                    }
                } else if (i31 == 2) {
                    if (this.f1357f == 0) {
                        f3 = this.b.e0;
                    } else {
                        f3 = this.b.f0;
                    }
                    if (z) {
                        f3 = 1.0f - f3;
                    }
                    int i45 = (int) ((((float) (i16 - i6)) * f3) + 0.5f);
                    if (i45 < 0 || i4 > 0) {
                        i45 = 0;
                    }
                    int i46 = z ? i7 - i45 : i7 + i45;
                    for (int i47 = 0; i47 < size; i47++) {
                        o oVar6 = this.f1326k.get(z ? size - (i47 + 1) : i47);
                        if (oVar6.b.h0 == 8) {
                            oVar6.f1359h.c(i46);
                            oVar6.f1360i.c(i46);
                        } else {
                            if (i47 > 0 && i47 >= i17) {
                                int i48 = oVar6.f1359h.f1335f;
                                i46 = z ? i46 - i48 : i46 + i48;
                            }
                            (z ? oVar6.f1360i : oVar6.f1359h).c(i46);
                            g gVar5 = oVar6.f1356e;
                            int i49 = gVar5.f1336g;
                            if (oVar6.f1355d == aVar) {
                                if (oVar6.a == 1) {
                                    i49 = gVar5.m;
                                }
                            }
                            i46 = z ? i46 - i49 : i46 + i49;
                            (z ? oVar6.f1359h : oVar6.f1360i).c(i46);
                            if (i47 < i18 && i47 < i2) {
                                int i50 = -oVar6.f1360i.f1335f;
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
    @Override // e.g.a.i.l.o
    public void d() {
        f i2;
        int d2;
        Iterator<o> it = this.f1326k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f1326k.size();
        if (size >= 1) {
            d dVar = this.f1326k.get(0).b;
            d dVar2 = this.f1326k.get(size - 1).b;
            if (this.f1357f == 0) {
                e.g.a.i.c cVar = dVar.I;
                e.g.a.i.c cVar2 = dVar2.K;
                f i3 = i(cVar, 0);
                int d3 = cVar.d();
                d m = m();
                if (m != null) {
                    d3 = m.I.d();
                }
                if (i3 != null) {
                    f fVar = this.f1359h;
                    fVar.f1341l.add(i3);
                    fVar.f1335f = d3;
                    i3.f1340k.add(fVar);
                }
                i2 = i(cVar2, 0);
                d2 = cVar2.d();
                d n = n();
                if (n != null) {
                    d2 = n.K.d();
                }
            } else {
                e.g.a.i.c cVar3 = dVar.J;
                e.g.a.i.c cVar4 = dVar2.L;
                f i4 = i(cVar3, 1);
                int d4 = cVar3.d();
                d m2 = m();
                if (m2 != null) {
                    d4 = m2.J.d();
                }
                if (i4 != null) {
                    f fVar2 = this.f1359h;
                    fVar2.f1341l.add(i4);
                    fVar2.f1335f = d4;
                    i4.f1340k.add(fVar2);
                }
                i2 = i(cVar4, 1);
                d2 = cVar4.d();
                d n2 = n();
                if (n2 != null) {
                    d2 = n2.L.d();
                }
            }
            f fVar3 = this.f1360i;
            fVar3.f1341l.add(i2);
            fVar3.f1335f = -d2;
            i2.f1340k.add(fVar3);
            this.f1359h.a = this;
            this.f1360i.a = this;
        }
    }

    @Override // e.g.a.i.l.o
    public void e() {
        for (int i2 = 0; i2 < this.f1326k.size(); i2++) {
            this.f1326k.get(i2).e();
        }
    }

    @Override // e.g.a.i.l.o
    public void f() {
        this.c = null;
        Iterator<o> it = this.f1326k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // e.g.a.i.l.o
    public long j() {
        int size = this.f1326k.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            o oVar = this.f1326k.get(i2);
            j2 = ((long) oVar.f1360i.f1335f) + oVar.j() + j2 + ((long) oVar.f1359h.f1335f);
        }
        return j2;
    }

    @Override // e.g.a.i.l.o
    public boolean k() {
        int size = this.f1326k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f1326k.get(i2).k()) {
                return false;
            }
        }
        return true;
    }

    public final d m() {
        for (int i2 = 0; i2 < this.f1326k.size(); i2++) {
            d dVar = this.f1326k.get(i2).b;
            if (dVar.h0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final d n() {
        for (int size = this.f1326k.size() - 1; size >= 0; size--) {
            d dVar = this.f1326k.get(size).b;
            if (dVar.h0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f1357f == 0 ? "horizontal : " : "vertical : ");
        Iterator<o> it = this.f1326k.iterator();
        while (it.hasNext()) {
            sb.append("<");
            sb.append(it.next());
            sb.append("> ");
        }
        return sb.toString();
    }
}
