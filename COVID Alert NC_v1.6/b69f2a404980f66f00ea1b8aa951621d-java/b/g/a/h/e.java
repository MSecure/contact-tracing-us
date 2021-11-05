package b.g.a.h;

import b.b.k.i;
import b.g.a.h.c;
import b.g.a.h.d;
import b.g.a.h.m;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e extends n {
    public int A0 = 0;
    public int B0 = 7;
    public boolean C0 = false;
    public boolean D0 = false;
    public boolean E0 = false;
    public boolean k0 = false;
    public b.g.a.e l0 = new b.g.a.e();
    public m m0;
    public int n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0 = 0;
    public int s0 = 0;
    public b[] t0 = new b[4];
    public b[] u0 = new b[4];
    public List<f> v0 = new ArrayList();
    public boolean w0 = false;
    public boolean x0 = false;
    public boolean y0 = false;
    public int z0 = 0;

    /* JADX WARN: Type inference failed for: r5v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03b2  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // b.g.a.h.n
    public void F() {
        ArrayList<d> arrayList;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        ArrayList<d> arrayList2;
        boolean z2;
        int max;
        int max2;
        boolean z3;
        ?? r5;
        ArrayList<d> arrayList3;
        boolean z4;
        Exception e2;
        boolean z5;
        List<d> list;
        int i6;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        d.a aVar2 = d.a.FIXED;
        d.a aVar3 = d.a.WRAP_CONTENT;
        int i7 = this.I;
        int i8 = this.J;
        int i9 = 0;
        int max3 = Math.max(0, n());
        int max4 = Math.max(0, h());
        this.D0 = false;
        this.E0 = false;
        if (this.D != null) {
            if (this.m0 == null) {
                this.m0 = new m(this);
            }
            m mVar = this.m0;
            if (mVar != null) {
                mVar.f931a = this.I;
                mVar.f932b = this.J;
                mVar.f933c = n();
                mVar.f934d = h();
                int size = mVar.f935e.size();
                for (int i10 = 0; i10 < size; i10++) {
                    m.a aVar4 = mVar.f935e.get(i10);
                    c f = f(aVar4.f936a.f899c);
                    aVar4.f936a = f;
                    if (f != null) {
                        aVar4.f937b = f.f900d;
                        aVar4.f938c = f.b();
                        c cVar = aVar4.f936a;
                        aVar4.f939d = cVar.g;
                        i6 = cVar.h;
                    } else {
                        aVar4.f937b = null;
                        aVar4.f938c = 0;
                        aVar4.f939d = c.a.STRONG;
                        i6 = 0;
                    }
                    aVar4.f940e = i6;
                }
                this.I = this.n0;
                this.J = this.o0;
                d dVar = this.D;
                if (dVar != null && (dVar instanceof e)) {
                    e eVar = (e) dVar;
                }
                int size2 = this.B.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    this.B.get(i11).d();
                }
                t(this.l0.l);
            } else {
                throw null;
            }
        } else {
            this.I = 0;
            this.J = 0;
        }
        int i12 = 32;
        if (this.B0 != 0) {
            if (!I(8)) {
                K();
            }
            if (!I(32)) {
                if (!I(8)) {
                    c(this.B0);
                }
                N();
            }
            this.l0.g = true;
        } else {
            this.l0.g = false;
        }
        d.a[] aVarArr = this.C;
        d.a aVar5 = aVarArr[1];
        d.a aVar6 = aVarArr[0];
        M();
        if (this.v0.size() == 0) {
            this.v0.clear();
            this.v0.add(0, new f(this.j0));
        }
        int size3 = this.v0.size();
        ArrayList<d> arrayList4 = this.j0;
        Object[] objArr = (i() == aVar3 || m() == aVar3) ? 1 : null;
        boolean z6 = false;
        while (i9 < size3 && !this.C0) {
            if (this.v0.get(i9).f922d) {
                i = i7;
                i2 = i8;
                i3 = size3;
                arrayList = arrayList4;
            } else {
                if (!I(i12)) {
                    z = z6;
                    i3 = size3;
                } else if (i() == aVar2 && m() == aVar2) {
                    f fVar = this.v0.get(i9);
                    if (!fVar.j.isEmpty()) {
                        list = fVar.j;
                        z = z6;
                        i3 = size3;
                    } else {
                        int size4 = fVar.f919a.size();
                        i3 = size3;
                        int i13 = 0;
                        while (i13 < size4) {
                            d dVar2 = fVar.f919a.get(i13);
                            if (!dVar2.b0) {
                                fVar.b((ArrayList) fVar.j, dVar2);
                            }
                            i13++;
                            size4 = size4;
                            z6 = z6;
                        }
                        z = z6;
                        fVar.k.clear();
                        fVar.k.addAll(fVar.f919a);
                        fVar.k.removeAll(fVar.j);
                        list = fVar.j;
                    }
                    this.j0 = (ArrayList) list;
                } else {
                    z = z6;
                    i3 = size3;
                    this.j0 = (ArrayList) this.v0.get(i9).f919a;
                }
                M();
                int size5 = this.j0.size();
                for (int i14 = 0; i14 < size5; i14++) {
                    d dVar3 = this.j0.get(i14);
                    if (dVar3 instanceof n) {
                        ((n) dVar3).F();
                    }
                }
                int i15 = 0;
                boolean z7 = true;
                while (z7) {
                    boolean z8 = z7;
                    int i16 = i15 + 1;
                    try {
                        this.l0.t();
                        M();
                        e(this.l0);
                        int i17 = 0;
                        while (i17 < size5) {
                            i5 = i8;
                            try {
                                this.j0.get(i17).e(this.l0);
                                i17++;
                                i8 = i5;
                            } catch (Exception e3) {
                                e2 = e3;
                                e2.printStackTrace();
                                PrintStream printStream = System.out;
                                StringBuilder sb = new StringBuilder();
                                i4 = i7;
                                sb.append("EXCEPTION : ");
                                sb.append(e2);
                                printStream.println(sb.toString());
                                if (!z8) {
                                }
                                if (objArr != null) {
                                }
                                z2 = false;
                                max = Math.max(this.R, n());
                                if (max > n()) {
                                }
                                max2 = Math.max(this.S, h());
                                if (max2 > h()) {
                                }
                                if (!z3) {
                                }
                                z = z3;
                                i8 = i5;
                                i7 = i4;
                                arrayList4 = arrayList2;
                                z7 = z2;
                                i15 = i16;
                            }
                        }
                        i5 = i8;
                        H(this.l0);
                        try {
                            b.g.a.e eVar2 = this.l0;
                            if (eVar2.g) {
                                int i18 = 0;
                                while (true) {
                                    if (i18 >= eVar2.j) {
                                        z5 = true;
                                        break;
                                    } else if (!eVar2.f[i18].f872e) {
                                        z5 = false;
                                        break;
                                    } else {
                                        i18++;
                                    }
                                }
                                if (z5) {
                                    eVar2.j();
                                    i4 = i7;
                                    z8 = true;
                                    if (!z8) {
                                        arrayList2 = arrayList4;
                                        E(this.l0);
                                        int i19 = 0;
                                        while (true) {
                                            if (i19 >= size5) {
                                                break;
                                            }
                                            d dVar4 = this.j0.get(i19);
                                            if (dVar4.C[0] == aVar && dVar4.n() < dVar4.T) {
                                                i.f924a[2] = true;
                                                break;
                                            }
                                            if (dVar4.C[1] == aVar && dVar4.h() < dVar4.U) {
                                                i.f924a[2] = true;
                                                break;
                                            }
                                            i19++;
                                        }
                                    } else {
                                        b.g.a.e eVar3 = this.l0;
                                        boolean[] zArr = i.f924a;
                                        char c2 = 0;
                                        zArr[2] = false;
                                        E(eVar3);
                                        int size6 = this.j0.size();
                                        int i20 = 0;
                                        while (i20 < size6) {
                                            d dVar5 = this.j0.get(i20);
                                            dVar5.E(eVar3);
                                            if (dVar5.C[c2] == aVar) {
                                                arrayList3 = arrayList4;
                                                if (dVar5.n() < dVar5.T) {
                                                    z4 = true;
                                                    zArr[2] = true;
                                                    d.a[] aVarArr2 = dVar5.C;
                                                    char c3 = z4 ? 1 : 0;
                                                    char c4 = z4 ? 1 : 0;
                                                    char c5 = z4 ? 1 : 0;
                                                    if (aVarArr2[c3] == aVar && dVar5.h() < dVar5.U) {
                                                        zArr[2] = z4;
                                                    }
                                                    i20++;
                                                    size6 = size6;
                                                    eVar3 = eVar3;
                                                    arrayList4 = arrayList3;
                                                    c2 = 0;
                                                }
                                            } else {
                                                arrayList3 = arrayList4;
                                            }
                                            z4 = true;
                                            d.a[] aVarArr22 = dVar5.C;
                                            char c32 = z4 ? 1 : 0;
                                            char c42 = z4 ? 1 : 0;
                                            char c52 = z4 ? 1 : 0;
                                            zArr[2] = z4;
                                            i20++;
                                            size6 = size6;
                                            eVar3 = eVar3;
                                            arrayList4 = arrayList3;
                                            c2 = 0;
                                        }
                                        arrayList2 = arrayList4;
                                    }
                                    if (objArr != null || i16 >= 8 || !i.f924a[2]) {
                                        z2 = false;
                                    } else {
                                        int i21 = 0;
                                        int i22 = 0;
                                        for (int i23 = 0; i23 < size5; i23++) {
                                            d dVar6 = this.j0.get(i23);
                                            i21 = Math.max(i21, dVar6.n() + dVar6.I);
                                            i22 = Math.max(i22, dVar6.h() + dVar6.J);
                                        }
                                        int max5 = Math.max(this.R, i21);
                                        int max6 = Math.max(this.S, i22);
                                        if (aVar6 != aVar3 || n() >= max5) {
                                            z2 = false;
                                        } else {
                                            C(max5);
                                            this.C[0] = aVar3;
                                            z2 = true;
                                            z = true;
                                        }
                                        if (aVar5 == aVar3 && h() < max6) {
                                            w(max6);
                                            this.C[1] = aVar3;
                                            z2 = true;
                                            z = true;
                                        }
                                    }
                                    max = Math.max(this.R, n());
                                    if (max > n()) {
                                        C(max);
                                        this.C[0] = aVar2;
                                        z2 = true;
                                        z = true;
                                    }
                                    max2 = Math.max(this.S, h());
                                    if (max2 > h()) {
                                        w(max2);
                                        r5 = 1;
                                        this.C[1] = aVar2;
                                        z2 = true;
                                        z3 = true;
                                    } else {
                                        r5 = 1;
                                        z3 = z;
                                    }
                                    if (!z3) {
                                        if (this.C[0] == aVar3 && max3 > 0 && n() > max3) {
                                            this.D0 = r5;
                                            this.C[0] = aVar2;
                                            C(max3);
                                            boolean z9 = r5 == true ? 1 : 0;
                                            Object[] objArr2 = r5 == true ? 1 : 0;
                                            Object[] objArr3 = r5 == true ? 1 : 0;
                                            z2 = z9;
                                            z3 = z2;
                                        }
                                        d.a[] aVarArr3 = this.C;
                                        char c6 = r5 == true ? 1 : 0;
                                        char c7 = r5 == true ? 1 : 0;
                                        char c8 = r5 == true ? 1 : 0;
                                        if (aVarArr3[c6] == aVar3 && max4 > 0 && h() > max4) {
                                            this.E0 = r5;
                                            this.C[r5] = aVar2;
                                            w(max4);
                                            z2 = true;
                                            z = true;
                                            i8 = i5;
                                            i7 = i4;
                                            arrayList4 = arrayList2;
                                            z7 = z2;
                                            i15 = i16;
                                        }
                                    }
                                    z = z3;
                                    i8 = i5;
                                    i7 = i4;
                                    arrayList4 = arrayList2;
                                    z7 = z2;
                                    i15 = i16;
                                }
                            }
                            eVar2.q(eVar2.f878c);
                            i4 = i7;
                            z8 = true;
                        } catch (Exception e4) {
                            e2 = e4;
                            z8 = true;
                            e2.printStackTrace();
                            PrintStream printStream2 = System.out;
                            StringBuilder sb2 = new StringBuilder();
                            i4 = i7;
                            sb2.append("EXCEPTION : ");
                            sb2.append(e2);
                            printStream2.println(sb2.toString());
                            if (!z8) {
                            }
                            if (objArr != null) {
                            }
                            z2 = false;
                            max = Math.max(this.R, n());
                            if (max > n()) {
                            }
                            max2 = Math.max(this.S, h());
                            if (max2 > h()) {
                            }
                            if (!z3) {
                            }
                            z = z3;
                            i8 = i5;
                            i7 = i4;
                            arrayList4 = arrayList2;
                            z7 = z2;
                            i15 = i16;
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        i5 = i8;
                        e2.printStackTrace();
                        PrintStream printStream22 = System.out;
                        StringBuilder sb22 = new StringBuilder();
                        i4 = i7;
                        sb22.append("EXCEPTION : ");
                        sb22.append(e2);
                        printStream22.println(sb22.toString());
                        if (!z8) {
                        }
                        if (objArr != null) {
                        }
                        z2 = false;
                        max = Math.max(this.R, n());
                        if (max > n()) {
                        }
                        max2 = Math.max(this.S, h());
                        if (max2 > h()) {
                        }
                        if (!z3) {
                        }
                        z = z3;
                        i8 = i5;
                        i7 = i4;
                        arrayList4 = arrayList2;
                        z7 = z2;
                        i15 = i16;
                    }
                    if (!z8) {
                    }
                    if (objArr != null) {
                    }
                    z2 = false;
                    max = Math.max(this.R, n());
                    if (max > n()) {
                    }
                    max2 = Math.max(this.S, h());
                    if (max2 > h()) {
                    }
                    if (!z3) {
                    }
                    z = z3;
                    i8 = i5;
                    i7 = i4;
                    arrayList4 = arrayList2;
                    z7 = z2;
                    i15 = i16;
                }
                i = i7;
                i2 = i8;
                arrayList = arrayList4;
                f fVar2 = this.v0.get(i9);
                int size7 = fVar2.k.size();
                for (int i24 = 0; i24 < size7; i24++) {
                    fVar2.c(fVar2.k.get(i24));
                }
                z6 = z;
            }
            i9++;
            size3 = i3;
            i8 = i2;
            i7 = i;
            arrayList4 = arrayList;
            i12 = 32;
        }
        this.j0 = arrayList4;
        if (this.D != null) {
            int max7 = Math.max(this.R, n());
            int max8 = Math.max(this.S, h());
            m mVar2 = this.m0;
            this.I = mVar2.f931a;
            this.J = mVar2.f932b;
            C(mVar2.f933c);
            w(mVar2.f934d);
            int size8 = mVar2.f935e.size();
            for (int i25 = 0; i25 < size8; i25++) {
                m.a aVar7 = mVar2.f935e.get(i25);
                f(aVar7.f936a.f899c).a(aVar7.f937b, aVar7.f938c, -1, aVar7.f939d, aVar7.f940e, false);
            }
            C(max7 + this.n0 + this.p0);
            w(max8 + this.o0 + this.q0);
        } else {
            this.I = i7;
            this.J = i8;
        }
        if (z6) {
            d.a[] aVarArr4 = this.C;
            aVarArr4[0] = aVar6;
            aVarArr4[1] = aVar5;
        }
        t(this.l0.l);
        d dVar7 = this.D;
        e eVar4 = this;
        while (dVar7 != null) {
            d dVar8 = dVar7.D;
            if (dVar7 instanceof e) {
                eVar4 = (e) dVar7;
            }
            dVar7 = dVar8;
        }
        if (this == eVar4) {
            D();
        }
    }

    public void G(d dVar, int i) {
        if (i == 0) {
            int i2 = this.r0 + 1;
            b[] bVarArr = this.u0;
            if (i2 >= bVarArr.length) {
                this.u0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            this.u0[this.r0] = new b(dVar, 0, this.k0);
            this.r0++;
        } else if (i == 1) {
            int i3 = this.s0 + 1;
            b[] bVarArr2 = this.t0;
            if (i3 >= bVarArr2.length) {
                this.t0 = (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length * 2);
            }
            this.t0[this.s0] = new b(dVar, 1, this.k0);
            this.s0++;
        }
    }

    public boolean H(b.g.a.e eVar) {
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.WRAP_CONTENT;
        a(eVar);
        int size = this.j0.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.j0.get(i);
            if (dVar instanceof e) {
                d.a[] aVarArr = dVar.C;
                d.a aVar3 = aVarArr[0];
                d.a aVar4 = aVarArr[1];
                if (aVar3 == aVar2) {
                    dVar.y(aVar);
                }
                if (aVar4 == aVar2) {
                    dVar.B(aVar);
                }
                dVar.a(eVar);
                if (aVar3 == aVar2) {
                    dVar.y(aVar3);
                }
                if (aVar4 == aVar2) {
                    dVar.B(aVar4);
                }
            } else {
                d.a aVar5 = d.a.MATCH_PARENT;
                if (this.C[0] != aVar2 && dVar.C[0] == aVar5) {
                    int i2 = dVar.s.f901e;
                    int n = n() - dVar.u.f901e;
                    c cVar = dVar.s;
                    cVar.i = eVar.l(cVar);
                    c cVar2 = dVar.u;
                    cVar2.i = eVar.l(cVar2);
                    eVar.e(dVar.s.i, i2);
                    eVar.e(dVar.u.i, n);
                    dVar.f910a = 2;
                    dVar.x(i2, n);
                }
                if (this.C[1] != aVar2 && dVar.C[1] == aVar5) {
                    int i3 = dVar.t.f901e;
                    int h = h() - dVar.v.f901e;
                    c cVar3 = dVar.t;
                    cVar3.i = eVar.l(cVar3);
                    c cVar4 = dVar.v;
                    cVar4.i = eVar.l(cVar4);
                    eVar.e(dVar.t.i, i3);
                    eVar.e(dVar.v.i, h);
                    if (dVar.Q > 0 || dVar.Y == 8) {
                        c cVar5 = dVar.w;
                        cVar5.i = eVar.l(cVar5);
                        eVar.e(dVar.w.i, dVar.Q + i3);
                    }
                    dVar.f911b = 2;
                    dVar.A(i3, h);
                }
                dVar.a(eVar);
            }
        }
        if (this.r0 > 0) {
            i.j.a(this, eVar, 0);
        }
        if (this.s0 > 0) {
            i.j.a(this, eVar, 1);
        }
        return true;
    }

    public boolean I(int i) {
        return (this.B0 & i) == i;
    }

    public void J(int i, int i2) {
        k kVar;
        k kVar2;
        d.a aVar = d.a.WRAP_CONTENT;
        if (!(this.C[0] == aVar || (kVar2 = this.f912c) == null)) {
            kVar2.e(i);
        }
        if (this.C[1] != aVar && (kVar = this.f913d) != null) {
            kVar.e(i2);
        }
    }

    public void K() {
        int size = this.j0.size();
        s();
        for (int i = 0; i < size; i++) {
            this.j0.get(i).s();
        }
    }

    public void L() {
        K();
        c(this.B0);
    }

    public final void M() {
        this.r0 = 0;
        this.s0 = 0;
    }

    public void N() {
        j jVar = f(c.b.LEFT).f897a;
        j jVar2 = f(c.b.TOP).f897a;
        jVar.j(null, 0.0f);
        jVar2.j(null, 0.0f);
    }

    @Override // b.g.a.h.d
    public void c(int i) {
        super.c(i);
        int size = this.j0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j0.get(i2).c(i);
        }
    }

    @Override // b.g.a.h.d, b.g.a.h.n
    public void r() {
        this.l0.t();
        this.n0 = 0;
        this.p0 = 0;
        this.o0 = 0;
        this.q0 = 0;
        this.v0.clear();
        this.C0 = false;
        super.r();
    }
}
