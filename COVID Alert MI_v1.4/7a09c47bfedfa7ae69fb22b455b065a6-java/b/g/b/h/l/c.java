package b.g.b.h.l;

import b.g.b.h.d;
import b.g.b.h.e;
import c.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class c extends m {
    public ArrayList<m> k = new ArrayList<>();
    public int l;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r2 == 1) goto L_0x003f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0099  */
    public c(d dVar, int i) {
        super(dVar);
        c cVar;
        m mVar;
        Iterator<m> it;
        int i2;
        this.f1562f = i;
        d dVar2 = this.f1558b;
        while (true) {
            d l2 = dVar2.l(this.f1562f);
            if (l2 == null) {
                break;
            }
            dVar2 = l2;
        }
        this.f1558b = dVar2;
        ArrayList<m> arrayList = this.k;
        int i3 = this.f1562f;
        if (i3 == 0) {
            cVar = this;
            mVar = dVar2.f1514d;
            arrayList.add(mVar);
            dVar2 = dVar2.k(cVar.f1562f);
            if (dVar2 == null) {
                arrayList = cVar.k;
                int i4 = cVar.f1562f;
                if (i4 != 0) {
                }
                mVar = dVar2.f1514d;
                arrayList.add(mVar);
                dVar2 = dVar2.k(cVar.f1562f);
                if (dVar2 == null) {
                    it = cVar.k.iterator();
                }
            }
            it = cVar.k.iterator();
            while (it.hasNext()) {
                m next = it.next();
                int i5 = cVar.f1562f;
                if (i5 == 0) {
                    next.f1558b.f1512b = cVar;
                } else if (i5 == 1) {
                    next.f1558b.f1513c = cVar;
                }
            }
            if ((cVar.f1562f != 0 && ((e) cVar.f1558b.I).h0) && cVar.k.size() > 1) {
                ArrayList<m> arrayList2 = cVar.k;
                cVar.f1558b = arrayList2.get(arrayList2.size() - 1).f1558b;
            }
            if (cVar.f1562f == 0) {
                i2 = cVar.f1558b.Y;
            } else {
                i2 = cVar.f1558b.Z;
            }
            cVar.l = i2;
        } else if (i3 == 1) {
            cVar = this;
            mVar = dVar2.f1515e;
            arrayList.add(mVar);
            dVar2 = dVar2.k(cVar.f1562f);
            if (dVar2 == null) {
            }
            it = cVar.k.iterator();
            while (it.hasNext()) {
            }
            ArrayList<m> arrayList22 = cVar.k;
            cVar.f1558b = arrayList22.get(arrayList22.size() - 1).f1558b;
            if (cVar.f1562f == 0) {
            }
            cVar.l = i2;
        } else {
            cVar = this;
        }
        mVar = null;
        arrayList.add(mVar);
        dVar2 = dVar2.k(cVar.f1562f);
        if (dVar2 == null) {
        }
        it = cVar.k.iterator();
        while (it.hasNext()) {
        }
        ArrayList<m> arrayList222 = cVar.k;
        cVar.f1558b = arrayList222.get(arrayList222.size() - 1).f1558b;
        if (cVar.f1562f == 0) {
        }
        cVar.l = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x018c, code lost:
        if (r1 != r14) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01b2, code lost:
        if (r1 != r14) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c6, code lost:
        if (r3.f1561e.j != false) goto L_0x00c8;
     */
    @Override // b.g.b.h.l.d, b.g.b.h.l.m
    public void a(d dVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        d.a aVar;
        int i6;
        int i7;
        int i8;
        float f3;
        d.a aVar2;
        d.a aVar3;
        float f4;
        int i9;
        int i10;
        int i11;
        d.a aVar4 = d.a.MATCH_CONSTRAINT;
        if (this.h.j && this.i.j) {
            d dVar2 = this.f1558b.I;
            boolean z = (dVar2 == null || !(dVar2 instanceof e)) ? false : ((e) dVar2).h0;
            int i12 = this.i.f1547g - this.h.f1547g;
            int size = this.k.size();
            int i13 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i13 >= size) {
                    i13 = -1;
                    break;
                }
                if (this.k.get(i13).f1558b.V != 8) {
                    break;
                }
                i13++;
            }
            int i14 = size - 1;
            int i15 = i14;
            while (true) {
                if (i15 < 0) {
                    break;
                }
                if (this.k.get(i15).f1558b.V != 8) {
                    i = i15;
                    break;
                }
                i15--;
            }
            int i16 = 0;
            while (true) {
                if (i16 >= 2) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    f2 = 0.0f;
                    break;
                }
                int i17 = 0;
                i5 = 0;
                i10 = 0;
                i11 = 0;
                f2 = 0.0f;
                while (i17 < size) {
                    m mVar = this.k.get(i17);
                    if (mVar.f1558b.V != i2) {
                        i11++;
                        if (i17 > 0 && i17 >= i13) {
                            i5 += mVar.h.f1546f;
                        }
                        int i18 = mVar.f1561e.f1547g;
                        boolean z2 = mVar.f1560d != aVar4;
                        if (!z2) {
                            if (mVar.f1557a == 1 && i16 == 0) {
                                i18 = mVar.f1561e.m;
                                i10++;
                            }
                            z2 = true;
                        } else if (this.f1562f != 0 || mVar.f1558b.f1514d.f1561e.j) {
                            if (this.f1562f == 1 && !mVar.f1558b.f1515e.f1561e.j) {
                                return;
                            }
                        } else {
                            return;
                        }
                        if (!z2) {
                            i10++;
                            float f5 = mVar.f1558b.a0[this.f1562f];
                            if (f5 >= 0.0f) {
                                f2 += f5;
                            }
                        } else {
                            i5 += i18;
                        }
                        if (i17 < i14 && i17 < i) {
                            i5 += -mVar.i.f1546f;
                        }
                    }
                    i17++;
                    i2 = 8;
                }
                if (i5 < i12 || i10 == 0) {
                    i3 = i10;
                    i4 = i11;
                } else {
                    i16++;
                    i2 = 8;
                }
            }
            i3 = i10;
            i4 = i11;
            int i19 = this.h.f1547g;
            if (z) {
                i19 = this.i.f1547g;
            }
            if (i5 > i12) {
                int i20 = (int) ((((float) (i5 - i12)) / 2.0f) + 0.5f);
                i19 = z ? i19 + i20 : i19 - i20;
            }
            if (i3 > 0) {
                float f6 = (float) (i12 - i5);
                int i21 = (int) ((f6 / ((float) i3)) + 0.5f);
                int i22 = 0;
                int i23 = 0;
                while (i22 < size) {
                    m mVar2 = this.k.get(i22);
                    d dVar3 = mVar2.f1558b;
                    if (dVar3.V != 8 && mVar2.f1560d == aVar4 && !mVar2.f1561e.j) {
                        int i24 = f2 > 0.0f ? (int) (((dVar3.a0[this.f1562f] * f6) / f2) + 0.5f) : i21;
                        if (this.f1562f == 0) {
                            d dVar4 = mVar2.f1558b;
                            int i25 = dVar4.n;
                            f4 = f6;
                            aVar3 = aVar4;
                            i9 = Math.max(dVar4.m, mVar2.f1557a == 1 ? Math.min(i24, mVar2.f1561e.m) : i24);
                            if (i25 > 0) {
                                i9 = Math.min(i25, i9);
                            }
                        } else {
                            aVar3 = aVar4;
                            f4 = f6;
                            d dVar5 = mVar2.f1558b;
                            int i26 = dVar5.q;
                            i9 = Math.max(dVar5.p, mVar2.f1557a == 1 ? Math.min(i24, mVar2.f1561e.m) : i24);
                            if (i26 > 0) {
                                i9 = Math.min(i26, i9);
                            }
                        }
                        i23++;
                        i24 = i9;
                        mVar2.f1561e.c(i24);
                    } else {
                        aVar3 = aVar4;
                        f4 = f6;
                    }
                    i22++;
                    i21 = i21;
                    i5 = i5;
                    i19 = i19;
                    f6 = f4;
                    aVar4 = aVar3;
                }
                aVar = aVar4;
                i6 = i19;
                if (i23 > 0) {
                    i3 -= i23;
                    int i27 = 0;
                    for (int i28 = 0; i28 < size; i28++) {
                        m mVar3 = this.k.get(i28);
                        if (mVar3.f1558b.V != 8) {
                            if (i28 > 0 && i28 >= i13) {
                                i27 += mVar3.h.f1546f;
                            }
                            i27 += mVar3.f1561e.f1547g;
                            if (i28 < i14 && i28 < i) {
                                i27 += -mVar3.i.f1546f;
                            }
                        }
                    }
                    i5 = i27;
                } else {
                    i5 = i5;
                }
                i7 = 2;
                if (this.l == 2 && i23 == 0) {
                    i8 = 0;
                    this.l = 0;
                } else {
                    i8 = 0;
                }
            } else {
                aVar = aVar4;
                i6 = i19;
                i8 = 0;
                i7 = 2;
            }
            if (i5 > i12) {
                this.l = i7;
            }
            if (i4 > 0 && i3 == 0 && i13 == i) {
                this.l = i7;
            }
            int i29 = this.l;
            if (i29 == 1) {
                int i30 = i4 > 1 ? (i12 - i5) / (i4 - 1) : i4 == 1 ? (i12 - i5) / 2 : i8;
                if (i3 > 0) {
                    i30 = i8;
                }
                int i31 = i8;
                int i32 = i6;
                while (i31 < size) {
                    m mVar4 = this.k.get(z ? size - (i31 + 1) : i31);
                    if (mVar4.f1558b.V == 8) {
                        mVar4.h.c(i32);
                        mVar4.i.c(i32);
                        aVar2 = aVar;
                    } else {
                        if (i31 > 0) {
                            i32 = z ? i32 - i30 : i32 + i30;
                        }
                        if (i31 > 0 && i31 >= i13) {
                            int i33 = mVar4.h.f1546f;
                            i32 = z ? i32 - i33 : i32 + i33;
                        }
                        (z ? mVar4.i : mVar4.h).c(i32);
                        g gVar = mVar4.f1561e;
                        int i34 = gVar.f1547g;
                        aVar2 = aVar;
                        if (mVar4.f1560d == aVar2 && mVar4.f1557a == 1) {
                            i34 = gVar.m;
                        }
                        i32 = z ? i32 - i34 : i32 + i34;
                        (z ? mVar4.h : mVar4.i).c(i32);
                        mVar4.f1563g = true;
                        if (i31 < i14 && i31 < i) {
                            int i35 = -mVar4.i.f1546f;
                            i32 = z ? i32 - i35 : i32 + i35;
                        }
                    }
                    i31++;
                    aVar = aVar2;
                }
            } else if (i29 == 0) {
                int i36 = (i12 - i5) / (i4 + 1);
                if (i3 > 0) {
                    i36 = i8;
                }
                int i37 = i6;
                for (int i38 = i8; i38 < size; i38++) {
                    m mVar5 = this.k.get(z ? size - (i38 + 1) : i38);
                    if (mVar5.f1558b.V == 8) {
                        mVar5.h.c(i37);
                        mVar5.i.c(i37);
                    } else {
                        int i39 = z ? i37 - i36 : i37 + i36;
                        if (i38 > 0 && i38 >= i13) {
                            int i40 = mVar5.h.f1546f;
                            i39 = z ? i39 - i40 : i39 + i40;
                        }
                        (z ? mVar5.i : mVar5.h).c(i39);
                        g gVar2 = mVar5.f1561e;
                        int i41 = gVar2.f1547g;
                        if (mVar5.f1560d == aVar && mVar5.f1557a == 1) {
                            i41 = Math.min(i41, gVar2.m);
                        }
                        i37 = z ? i39 - i41 : i39 + i41;
                        (z ? mVar5.h : mVar5.i).c(i37);
                        if (i38 < i14 && i38 < i) {
                            int i42 = -mVar5.i.f1546f;
                            i37 = z ? i37 - i42 : i37 + i42;
                        }
                    }
                }
            } else if (i29 == 2) {
                if (this.f1562f == 0) {
                    f3 = this.f1558b.S;
                } else {
                    f3 = this.f1558b.T;
                }
                if (z) {
                    f3 = 1.0f - f3;
                }
                int i43 = (int) ((((float) (i12 - i5)) * f3) + 0.5f);
                if (i43 < 0 || i3 > 0) {
                    i43 = i8;
                }
                int i44 = z ? i6 - i43 : i6 + i43;
                for (int i45 = i8; i45 < size; i45++) {
                    m mVar6 = this.k.get(z ? size - (i45 + 1) : i45);
                    if (mVar6.f1558b.V == 8) {
                        mVar6.h.c(i44);
                        mVar6.i.c(i44);
                    } else {
                        if (i45 > 0 && i45 >= i13) {
                            int i46 = mVar6.h.f1546f;
                            i44 = z ? i44 - i46 : i44 + i46;
                        }
                        (z ? mVar6.i : mVar6.h).c(i44);
                        g gVar3 = mVar6.f1561e;
                        int i47 = gVar3.f1547g;
                        if (mVar6.f1560d == aVar) {
                            if (mVar6.f1557a == 1) {
                                i47 = gVar3.m;
                            }
                        }
                        i44 = z ? i44 - i47 : i44 + i47;
                        (z ? mVar6.h : mVar6.i).c(i44);
                        if (i45 < i14 && i45 < i) {
                            int i48 = -mVar6.i.f1546f;
                            i44 = z ? i44 - i48 : i44 + i48;
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
    @Override // b.g.b.h.l.m
    public void d() {
        f i;
        int b2;
        Iterator<m> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.k.size();
        if (size >= 1) {
            d dVar = this.k.get(0).f1558b;
            d dVar2 = this.k.get(size - 1).f1558b;
            if (this.f1562f == 0) {
                b.g.b.h.c cVar = dVar.x;
                b.g.b.h.c cVar2 = dVar2.z;
                f i2 = i(cVar, 0);
                int b3 = cVar.b();
                d m = m();
                if (m != null) {
                    b3 = m.x.b();
                }
                if (i2 != null) {
                    f fVar = this.h;
                    fVar.l.add(i2);
                    fVar.f1546f = b3;
                    i2.k.add(fVar);
                }
                i = i(cVar2, 0);
                b2 = cVar2.b();
                d n = n();
                if (n != null) {
                    b2 = n.z.b();
                }
            } else {
                b.g.b.h.c cVar3 = dVar.y;
                b.g.b.h.c cVar4 = dVar2.A;
                f i3 = i(cVar3, 1);
                int b4 = cVar3.b();
                d m2 = m();
                if (m2 != null) {
                    b4 = m2.y.b();
                }
                if (i3 != null) {
                    f fVar2 = this.h;
                    fVar2.l.add(i3);
                    fVar2.f1546f = b4;
                    i3.k.add(fVar2);
                }
                i = i(cVar4, 1);
                b2 = cVar4.b();
                d n2 = n();
                if (n2 != null) {
                    b2 = n2.A.b();
                }
            }
            f fVar3 = this.i;
            fVar3.l.add(i);
            fVar3.f1546f = -b2;
            i.k.add(fVar3);
            this.h.f1541a = this;
            this.i.f1541a = this;
        }
    }

    @Override // b.g.b.h.l.m
    public void e() {
        for (int i = 0; i < this.k.size(); i++) {
            this.k.get(i).e();
        }
    }

    @Override // b.g.b.h.l.m
    public void f() {
        this.f1559c = null;
        Iterator<m> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // b.g.b.h.l.m
    public long j() {
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            m mVar = this.k.get(i);
            j = ((long) mVar.i.f1546f) + mVar.j() + j + ((long) mVar.h.f1546f);
        }
        return j;
    }

    @Override // b.g.b.h.l.m
    public boolean k() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            if (!this.k.get(i).k()) {
                return false;
            }
        }
        return true;
    }

    public final d m() {
        for (int i = 0; i < this.k.size(); i++) {
            d dVar = this.k.get(i).f1558b;
            if (dVar.V != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final d n() {
        for (int size = this.k.size() - 1; size >= 0; size--) {
            d dVar = this.k.get(size).f1558b;
            if (dVar.V != 8) {
                return dVar;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder h = a.h("ChainRun ");
        h.append(this.f1562f == 0 ? "horizontal : " : "vertical : ");
        String sb = h.toString();
        Iterator<m> it = this.k.iterator();
        while (it.hasNext()) {
            String q = a.q(sb, "<");
            sb = a.q(q + it.next(), "> ");
        }
        return sb;
    }
}
