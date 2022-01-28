package b.g.b.h;

import androidx.recyclerview.widget.RecyclerView;
import b.b.k.i;
import b.g.b.d;
import b.g.b.h.d;
import b.g.b.h.l.b;
import b.g.b.h.l.c;
import b.g.b.h.l.g;
import b.g.b.h.l.m;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class e extends k {
    public b e0 = new b(this);
    public b.g.b.h.l.e f0 = new b.g.b.h.l.e(this);
    public b.AbstractC0025b g0 = null;
    public boolean h0 = false;
    public d i0 = new d();
    public int j0;
    public int k0;
    public int l0 = 0;
    public int m0 = 0;
    public b[] n0 = new b[4];
    public b[] o0 = new b[4];
    public int p0 = 7;
    public boolean q0 = false;
    public boolean r0 = false;

    @Override // b.g.b.h.d
    public void C(boolean z, boolean z2) {
        super.C(z, z2);
        int size = this.d0.size();
        for (int i = 0; i < size; i++) {
            this.d0.get(i).C(z, z2);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x0193 */
    /* JADX WARN: Type inference failed for: r4v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e1  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // b.g.b.h.k
    public void E() {
        boolean z;
        int size;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int max;
        int max2;
        ?? r4;
        Exception e2;
        boolean z7;
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.WRAP_CONTENT;
        int i2 = 0;
        this.N = 0;
        this.O = 0;
        int max3 = Math.max(0, o());
        int max4 = Math.max(0, i());
        this.q0 = false;
        this.r0 = false;
        if (!((this.p0 & 64) == 64)) {
            if (!((this.p0 & RecyclerView.a0.FLAG_IGNORE) == 128)) {
                z = false;
                b.g.b.d dVar = this.i0;
                dVar.f1472g = false;
                dVar.h = false;
                if (this.p0 != 0 && z) {
                    dVar.h = true;
                }
                d.a[] aVarArr = this.H;
                d.a aVar3 = aVarArr[1];
                d.a aVar4 = aVarArr[0];
                ArrayList<d> arrayList = this.d0;
                boolean z8 = j() != aVar2 || n() == aVar2;
                this.l0 = 0;
                this.m0 = 0;
                size = this.d0.size();
                for (i = 0; i < size; i++) {
                    d dVar2 = this.d0.get(i);
                    if (dVar2 instanceof k) {
                        ((k) dVar2).E();
                    }
                }
                int i3 = 0;
                z2 = false;
                z3 = true;
                boolean z9 = z8;
                while (z3) {
                    int i4 = i3 + 1;
                    try {
                        this.i0.t();
                        this.l0 = i2;
                        this.m0 = i2;
                        e(this.i0);
                        for (int i5 = i2; i5 < size; i5++) {
                            this.d0.get(i5).e(this.i0);
                        }
                        G(this.i0);
                        try {
                            b.g.b.d dVar3 = this.i0;
                            if (dVar3.f1472g || dVar3.h) {
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= dVar3.k) {
                                        z7 = true;
                                        break;
                                    } else if (!dVar3.f1471f[i6].f1462e) {
                                        z7 = false;
                                        break;
                                    } else {
                                        i6++;
                                    }
                                }
                                if (z7) {
                                    dVar3.j();
                                    z4 = true;
                                    if (!z4) {
                                        b.g.b.d dVar4 = this.i0;
                                        i.f1523a[2] = false;
                                        D(dVar4);
                                        int size2 = this.d0.size();
                                        for (int i7 = 0; i7 < size2; i7++) {
                                            this.d0.get(i7).D(dVar4);
                                        }
                                    } else {
                                        D(this.i0);
                                        for (int i8 = 0; i8 < size; i8++) {
                                            this.d0.get(i8).D(this.i0);
                                        }
                                    }
                                    if (z9 || i4 >= 8 || !i.f1523a[2]) {
                                        z5 = z9;
                                        z6 = false;
                                    } else {
                                        int i9 = 0;
                                        int i10 = 0;
                                        int i11 = 0;
                                        boolean z10 = z9;
                                        while (i9 < size) {
                                            d dVar5 = this.d0.get(i9);
                                            i10 = Math.max(i10, dVar5.o() + dVar5.N);
                                            i11 = Math.max(i11, dVar5.i() + dVar5.O);
                                            i9++;
                                            z10 = z10;
                                        }
                                        z5 = z10;
                                        int max5 = Math.max(this.Q, i10);
                                        int max6 = Math.max(this.R, i11);
                                        if (aVar4 != aVar2 || o() >= max5) {
                                            z6 = false;
                                        } else {
                                            B(max5);
                                            this.H[0] = aVar2;
                                            z6 = true;
                                            z2 = true;
                                        }
                                        if (aVar3 == aVar2 && i() < max6) {
                                            w(max6);
                                            this.H[1] = aVar2;
                                            z6 = true;
                                            z2 = true;
                                        }
                                    }
                                    max = Math.max(this.Q, o());
                                    if (max > o()) {
                                        B(max);
                                        this.H[0] = aVar;
                                        z6 = true;
                                        z2 = true;
                                    }
                                    max2 = Math.max(this.R, i());
                                    if (max2 <= i()) {
                                        w(max2);
                                        r4 = 1;
                                        this.H[1] = aVar;
                                        z6 = true;
                                        z2 = true;
                                    } else {
                                        r4 = 1;
                                    }
                                    if (!z2) {
                                        if (this.H[0] == aVar2 && max3 > 0 && o() > max3) {
                                            this.q0 = r4;
                                            this.H[0] = aVar;
                                            B(max3);
                                            boolean z11 = r4 == true ? 1 : 0;
                                            boolean z12 = r4 == true ? 1 : 0;
                                            boolean z13 = r4 == true ? 1 : 0;
                                            z6 = z11;
                                            z2 = z6;
                                        }
                                        d.a[] aVarArr2 = this.H;
                                        char c2 = r4 == true ? 1 : 0;
                                        char c3 = r4 == true ? 1 : 0;
                                        char c4 = r4 == true ? 1 : 0;
                                        if (aVarArr2[c2] == aVar2 && max4 > 0 && i() > max4) {
                                            this.r0 = r4;
                                            this.H[r4] = aVar;
                                            w(max4);
                                            z3 = true;
                                            z2 = true;
                                            i3 = i4;
                                            z9 = z5;
                                            i2 = 0;
                                        }
                                    }
                                    z3 = z6;
                                    i3 = i4;
                                    z9 = z5;
                                    i2 = 0;
                                }
                            }
                            dVar3.q(dVar3.f1468c);
                            z4 = true;
                        } catch (Exception e3) {
                            e2 = e3;
                            z3 = true;
                            e2.printStackTrace();
                            PrintStream printStream = System.out;
                            StringBuilder sb = new StringBuilder();
                            z4 = z3;
                            sb.append("EXCEPTION : ");
                            sb.append(e2);
                            printStream.println(sb.toString());
                            if (!z4) {
                            }
                            if (z9) {
                            }
                            z5 = z9;
                            z6 = false;
                            max = Math.max(this.Q, o());
                            if (max > o()) {
                            }
                            max2 = Math.max(this.R, i());
                            if (max2 <= i()) {
                            }
                            if (!z2) {
                            }
                            z3 = z6;
                            i3 = i4;
                            z9 = z5;
                            i2 = 0;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        e2.printStackTrace();
                        PrintStream printStream2 = System.out;
                        StringBuilder sb2 = new StringBuilder();
                        z4 = z3;
                        sb2.append("EXCEPTION : ");
                        sb2.append(e2);
                        printStream2.println(sb2.toString());
                        if (!z4) {
                        }
                        if (z9) {
                        }
                        z5 = z9;
                        z6 = false;
                        max = Math.max(this.Q, o());
                        if (max > o()) {
                        }
                        max2 = Math.max(this.R, i());
                        if (max2 <= i()) {
                        }
                        if (!z2) {
                        }
                        z3 = z6;
                        i3 = i4;
                        z9 = z5;
                        i2 = 0;
                    }
                    if (!z4) {
                    }
                    if (z9) {
                    }
                    z5 = z9;
                    z6 = false;
                    max = Math.max(this.Q, o());
                    if (max > o()) {
                    }
                    max2 = Math.max(this.R, i());
                    if (max2 <= i()) {
                    }
                    if (!z2) {
                    }
                    z3 = z6;
                    i3 = i4;
                    z9 = z5;
                    i2 = 0;
                }
                this.d0 = arrayList;
                if (z2) {
                    d.a[] aVarArr3 = this.H;
                    aVarArr3[0] = aVar4;
                    aVarArr3[1] = aVar3;
                }
                v(this.i0.m);
            }
        }
        z = true;
        b.g.b.d dVar6 = this.i0;
        dVar6.f1472g = false;
        dVar6.h = false;
        dVar6.h = true;
        d.a[] aVarArr4 = this.H;
        d.a aVar32 = aVarArr4[1];
        d.a aVar42 = aVarArr4[0];
        ArrayList<d> arrayList2 = this.d0;
        if (j() != aVar2) {
        }
        this.l0 = 0;
        this.m0 = 0;
        size = this.d0.size();
        while (i < size) {
        }
        int i32 = 0;
        z2 = false;
        z3 = true;
        boolean z92 = z8;
        while (z3) {
        }
        this.d0 = arrayList2;
        if (z2) {
        }
        v(this.i0.m);
    }

    public void F(d dVar, int i) {
        if (i == 0) {
            int i2 = this.l0 + 1;
            b[] bVarArr = this.o0;
            if (i2 >= bVarArr.length) {
                this.o0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            this.o0[this.l0] = new b(dVar, 0, this.h0);
            this.l0++;
        } else if (i == 1) {
            int i3 = this.m0 + 1;
            b[] bVarArr2 = this.n0;
            if (i3 >= bVarArr2.length) {
                this.n0 = (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length * 2);
            }
            this.n0[this.m0] = new b(dVar, 1, this.h0);
            this.m0++;
        }
    }

    public boolean G(b.g.b.d dVar) {
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.WRAP_CONTENT;
        b(dVar);
        int size = this.d0.size();
        for (int i = 0; i < size; i++) {
            d dVar2 = this.d0.get(i);
            if ((dVar2 instanceof j) || (dVar2 instanceof f)) {
                dVar2.b(dVar);
            }
        }
        for (int i2 = 0; i2 < size; i2++) {
            d dVar3 = this.d0.get(i2);
            if (dVar3 instanceof e) {
                d.a[] aVarArr = dVar3.H;
                d.a aVar3 = aVarArr[0];
                d.a aVar4 = aVarArr[1];
                if (aVar3 == aVar2) {
                    aVarArr[0] = aVar;
                }
                if (aVar4 == aVar2) {
                    dVar3.H[1] = aVar;
                }
                dVar3.b(dVar);
                if (aVar3 == aVar2) {
                    dVar3.x(aVar3);
                }
                if (aVar4 == aVar2) {
                    dVar3.A(aVar4);
                }
            } else {
                d.a aVar5 = d.a.MATCH_PARENT;
                dVar3.h = -1;
                dVar3.i = -1;
                if (this.H[0] != aVar2 && dVar3.H[0] == aVar5) {
                    int i3 = dVar3.x.f1502d;
                    int o = o() - dVar3.z.f1502d;
                    c cVar = dVar3.x;
                    cVar.f1504f = dVar.l(cVar);
                    c cVar2 = dVar3.z;
                    cVar2.f1504f = dVar.l(cVar2);
                    dVar.e(dVar3.x.f1504f, i3);
                    dVar.e(dVar3.z.f1504f, o);
                    dVar3.h = 2;
                    dVar3.N = i3;
                    int i4 = o - i3;
                    dVar3.J = i4;
                    int i5 = dVar3.Q;
                    if (i4 < i5) {
                        dVar3.J = i5;
                    }
                }
                if (this.H[1] != aVar2 && dVar3.H[1] == aVar5) {
                    int i6 = dVar3.y.f1502d;
                    int i7 = i() - dVar3.A.f1502d;
                    c cVar3 = dVar3.y;
                    cVar3.f1504f = dVar.l(cVar3);
                    c cVar4 = dVar3.A;
                    cVar4.f1504f = dVar.l(cVar4);
                    dVar.e(dVar3.y.f1504f, i6);
                    dVar.e(dVar3.A.f1504f, i7);
                    if (dVar3.P > 0 || dVar3.V == 8) {
                        c cVar5 = dVar3.B;
                        cVar5.f1504f = dVar.l(cVar5);
                        dVar.e(dVar3.B.f1504f, dVar3.P + i6);
                    }
                    dVar3.i = 2;
                    dVar3.O = i6;
                    int i8 = i7 - i6;
                    dVar3.K = i8;
                    int i9 = dVar3.R;
                    if (i8 < i9) {
                        dVar3.K = i9;
                    }
                }
                if (!(dVar3 instanceof j) && !(dVar3 instanceof f)) {
                    dVar3.b(dVar);
                }
            }
        }
        if (this.l0 > 0) {
            i.j.a(this, dVar, 0);
        }
        if (this.m0 > 0) {
            i.j.a(this, dVar, 1);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0130 A[EDGE_INSN: B:74:0x0130->B:61:0x0130 ?: BREAK  , SYNTHETIC] */
    public boolean H(boolean z, int i) {
        boolean z2;
        Iterator<m> it;
        Iterator<m> it2;
        int i2;
        g gVar;
        int i3;
        g gVar2;
        b.g.b.h.l.e eVar = this.f0;
        d.a aVar = d.a.MATCH_PARENT;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        boolean z3 = true;
        boolean z4 = z & true;
        d.a h = eVar.f1534a.h(0);
        d.a h2 = eVar.f1534a.h(1);
        int p = eVar.f1534a.p();
        int q = eVar.f1534a.q();
        if (z4 && (h == aVar2 || h2 == aVar2)) {
            Iterator<m> it3 = eVar.f1538e.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                m next = it3.next();
                if (next.f1562f == i && !next.k()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && h == aVar2) {
                    e eVar2 = eVar.f1534a;
                    eVar2.H[0] = aVar3;
                    eVar2.B(eVar.d(eVar2, 0));
                    e eVar3 = eVar.f1534a;
                    gVar2 = eVar3.f1514d.f1561e;
                    i3 = eVar3.o();
                }
            } else if (z4 && h2 == aVar2) {
                e eVar4 = eVar.f1534a;
                eVar4.H[1] = aVar3;
                eVar4.w(eVar.d(eVar4, 1));
                e eVar5 = eVar.f1534a;
                gVar2 = eVar5.f1515e.f1561e;
                i3 = eVar5.i();
            }
            gVar2.c(i3);
        }
        d.a[] aVarArr = eVar.f1534a.H;
        if (i == 0) {
            if (aVarArr[0] == aVar3 || aVarArr[0] == aVar) {
                int o = eVar.f1534a.o() + p;
                eVar.f1534a.f1514d.i.c(o);
                gVar = eVar.f1534a.f1514d.f1561e;
                i2 = o - p;
                gVar.c(i2);
                z2 = true;
                eVar.g();
                it = eVar.f1538e.iterator();
                while (it.hasNext()) {
                    m next2 = it.next();
                    if (next2.f1562f == i && (next2.f1558b != eVar.f1534a || next2.f1563g)) {
                        next2.e();
                    }
                }
                it2 = eVar.f1538e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    m next3 = it2.next();
                    if (next3.f1562f == i && ((z2 || next3.f1558b != eVar.f1534a) && (!next3.h.j || !next3.i.j || (!(next3 instanceof c) && !next3.f1561e.j)))) {
                        z3 = false;
                    }
                }
                z3 = false;
                eVar.f1534a.x(h);
                eVar.f1534a.A(h2);
                return z3;
            }
        } else if (aVarArr[1] == aVar3 || aVarArr[1] == aVar) {
            int i4 = eVar.f1534a.i() + q;
            eVar.f1534a.f1515e.i.c(i4);
            gVar = eVar.f1534a.f1515e.f1561e;
            i2 = i4 - q;
            gVar.c(i2);
            z2 = true;
            eVar.g();
            it = eVar.f1538e.iterator();
            while (it.hasNext()) {
            }
            it2 = eVar.f1538e.iterator();
            while (true) {
                if (!it2.hasNext()) {
                }
            }
            z3 = false;
            eVar.f1534a.x(h);
            eVar.f1534a.A(h2);
            return z3;
        }
        z2 = false;
        eVar.g();
        it = eVar.f1538e.iterator();
        while (it.hasNext()) {
        }
        it2 = eVar.f1538e.iterator();
        while (true) {
            if (!it2.hasNext()) {
            }
        }
        z3 = false;
        eVar.f1534a.x(h);
        eVar.f1534a.A(h2);
        return z3;
    }

    public void I() {
        this.f0.f1535b = true;
    }

    @Override // b.g.b.h.k, b.g.b.h.d
    public void u() {
        this.i0.t();
        this.j0 = 0;
        this.k0 = 0;
        super.u();
    }
}
