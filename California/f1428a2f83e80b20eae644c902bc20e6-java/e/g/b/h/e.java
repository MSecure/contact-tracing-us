package e.g.b.h;

import androidx.constraintlayout.widget.ConstraintLayout;
import e.b.a.m;
import e.g.b.d;
import e.g.b.h.c;
import e.g.b.h.d;
import e.g.b.h.l.b;
import e.g.b.h.l.g;
import e.g.b.h.l.h;
import e.g.b.h.l.n;
import e.g.b.h.l.o;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class e extends k {
    public WeakReference<c> A0 = null;
    public WeakReference<c> B0 = null;
    public WeakReference<c> C0 = null;
    public WeakReference<c> D0 = null;
    public b.a E0 = new b.a();
    public b m0 = new b(this);
    public e.g.b.h.l.e n0 = new e.g.b.h.l.e(this);
    public b.AbstractC0028b o0 = null;
    public boolean p0 = false;
    public d q0 = new d();
    public int r0;
    public int s0;
    public int t0 = 0;
    public int u0 = 0;
    public b[] v0 = new b[4];
    public b[] w0 = new b[4];
    public int x0 = 257;
    public boolean y0 = false;
    public boolean z0 = false;

    public static boolean X(d dVar, b.AbstractC0028b bVar, b.a aVar, int i2) {
        int i3;
        int i4;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        if (bVar == null) {
            return false;
        }
        aVar.a = dVar.m();
        aVar.b = dVar.q();
        aVar.c = dVar.r();
        aVar.f1286d = dVar.l();
        aVar.f1291i = false;
        aVar.f1292j = i2;
        d.a aVar4 = aVar.a;
        d.a aVar5 = d.a.MATCH_CONSTRAINT;
        boolean z = aVar4 == aVar5;
        boolean z2 = aVar.b == aVar5;
        boolean z3 = z && dVar.S > 0.0f;
        boolean z4 = z2 && dVar.S > 0.0f;
        if (z && dVar.u(0) && dVar.f1282l == 0 && !z3) {
            aVar.a = aVar2;
            if (z2 && dVar.m == 0) {
                aVar.a = aVar3;
            }
            z = false;
        }
        if (z2 && dVar.u(1) && dVar.m == 0 && !z4) {
            aVar.b = aVar2;
            if (z && dVar.f1282l == 0) {
                aVar.b = aVar3;
            }
            z2 = false;
        }
        if (dVar.z()) {
            aVar.a = aVar3;
            z = false;
        }
        if (dVar.A()) {
            aVar.b = aVar3;
            z2 = false;
        }
        if (z3) {
            if (dVar.n[0] == 4) {
                aVar.a = aVar3;
            } else if (!z2) {
                if (aVar.b == aVar3) {
                    i4 = aVar.f1286d;
                } else {
                    aVar.a = aVar2;
                    ((ConstraintLayout.b) bVar).b(dVar, aVar);
                    i4 = aVar.f1288f;
                }
                aVar.a = aVar3;
                int i5 = dVar.T;
                aVar.c = (int) ((i5 == 0 || i5 == -1) ? dVar.S * ((float) i4) : dVar.S / ((float) i4));
            }
        }
        if (z4) {
            if (dVar.n[1] == 4) {
                aVar.b = aVar3;
            } else if (!z) {
                if (aVar.a == aVar3) {
                    i3 = aVar.c;
                } else {
                    aVar.b = aVar2;
                    ((ConstraintLayout.b) bVar).b(dVar, aVar);
                    i3 = aVar.f1287e;
                }
                aVar.b = aVar3;
                int i6 = dVar.T;
                aVar.f1286d = (int) ((i6 == 0 || i6 == -1) ? ((float) i3) / dVar.S : ((float) i3) * dVar.S);
            }
        }
        ((ConstraintLayout.b) bVar).b(dVar, aVar);
        dVar.M(aVar.f1287e);
        dVar.H(aVar.f1288f);
        dVar.y = aVar.f1290h;
        dVar.E(aVar.f1289g);
        aVar.f1292j = 0;
        return aVar.f1291i;
    }

    @Override // e.g.b.h.d, e.g.b.h.k
    public void B() {
        this.q0.u();
        this.r0 = 0;
        this.s0 = 0;
        super.B();
    }

    @Override // e.g.b.h.d
    public void N(boolean z, boolean z2) {
        super.N(z, z2);
        int size = this.l0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.l0.get(i2).N(z, z2);
        }
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x05dd, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x05a8  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0603  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x0619  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x064b  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0670  */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0684  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x06a1  */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x07ae  */
    /* JADX WARNING: Removed duplicated region for block: B:441:0x07d4  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x07ec  */
    /* JADX WARNING: Removed duplicated region for block: B:465:0x0863  */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x087e  */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x088a  */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x088d  */
    /* JADX WARNING: Removed duplicated region for block: B:487:0x08d0  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // e.g.b.h.k
    public void P() {
        d.a aVar;
        d.a aVar2;
        int i2;
        int i3;
        boolean[] zArr;
        d.a aVar3;
        int i4;
        int i5;
        int i6;
        d.a aVar4;
        d.a aVar5;
        d.a aVar6;
        boolean z;
        int i7;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int max;
        int max2;
        ?? r3;
        Exception e2;
        int i8;
        int i9;
        d.a aVar7;
        d.a aVar8;
        n nVar;
        n nVar2;
        boolean z6;
        a aVar9;
        ArrayList arrayList;
        a aVar10;
        int i10;
        int i11;
        d.a aVar11;
        boolean[] zArr2 = i.a;
        d.a aVar12 = d.a.MATCH_CONSTRAINT;
        d.a aVar13 = d.a.WRAP_CONTENT;
        d.a aVar14 = d.a.FIXED;
        this.U = 0;
        this.V = 0;
        this.y0 = false;
        this.z0 = false;
        int size = this.l0.size();
        int max3 = Math.max(0, r());
        int max4 = Math.max(0, l());
        d.a[] aVarArr = this.O;
        d.a aVar15 = aVarArr[1];
        d.a aVar16 = aVarArr[0];
        if (i.b(this.x0, 1)) {
            b.AbstractC0028b bVar = this.o0;
            d.a m = m();
            d.a q = q();
            C();
            ArrayList<d> arrayList2 = this.l0;
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                arrayList2.get(i12).C();
            }
            boolean z7 = this.p0;
            if (m == aVar14) {
                zArr = zArr2;
                F(0, r());
                i3 = max4;
            } else {
                zArr = zArr2;
                c cVar = this.D;
                cVar.b = 0;
                i3 = max4;
                cVar.c = true;
                this.U = 0;
            }
            boolean z8 = false;
            int i13 = 0;
            boolean z9 = false;
            while (true) {
                i2 = max3;
                if (i13 >= size2) {
                    break;
                }
                d dVar = arrayList2.get(i13);
                if (dVar instanceof f) {
                    f fVar = (f) dVar;
                    aVar11 = aVar13;
                    if (fVar.p0 == 1) {
                        int i14 = fVar.m0;
                        if (i14 == -1) {
                            if (fVar.n0 == -1 || !z()) {
                                if (z()) {
                                    i14 = (int) ((fVar.l0 * ((float) r())) + 0.5f);
                                }
                                z8 = true;
                            } else {
                                i14 = r() - fVar.n0;
                            }
                        }
                        fVar.P(i14);
                        z8 = true;
                    }
                } else {
                    aVar11 = aVar13;
                    if ((dVar instanceof a) && ((a) dVar).R() == 0) {
                        z9 = true;
                    }
                }
                i13++;
                max3 = i2;
                aVar15 = aVar15;
                aVar13 = aVar11;
            }
            aVar = aVar13;
            aVar2 = aVar15;
            if (z8) {
                for (int i15 = 0; i15 < size2; i15++) {
                    d dVar2 = arrayList2.get(i15);
                    if (dVar2 instanceof f) {
                        f fVar2 = (f) dVar2;
                        if (fVar2.p0 == 1) {
                            h.b(fVar2, bVar, z7);
                        }
                    }
                }
            }
            h.b(this, bVar, z7);
            if (z9) {
                for (int i16 = 0; i16 < size2; i16++) {
                    d dVar3 = arrayList2.get(i16);
                    if (dVar3 instanceof a) {
                        a aVar17 = (a) dVar3;
                        if (aVar17.R() == 0 && aVar17.Q()) {
                            h.b(aVar17, bVar, z7);
                        }
                    }
                }
            }
            if (q == aVar14) {
                G(0, l());
            } else {
                c cVar2 = this.E;
                cVar2.b = 0;
                cVar2.c = true;
                this.V = 0;
            }
            boolean z10 = false;
            boolean z11 = false;
            for (int i17 = 0; i17 < size2; i17++) {
                d dVar4 = arrayList2.get(i17);
                if (dVar4 instanceof f) {
                    f fVar3 = (f) dVar4;
                    if (fVar3.p0 == 0) {
                        int i18 = fVar3.m0;
                        if (i18 == -1) {
                            if (fVar3.n0 == -1 || !A()) {
                                if (A()) {
                                    i18 = (int) ((fVar3.l0 * ((float) l())) + 0.5f);
                                }
                                z10 = true;
                            } else {
                                i18 = l() - fVar3.n0;
                            }
                        }
                        fVar3.P(i18);
                        z10 = true;
                    }
                } else if ((dVar4 instanceof a) && ((a) dVar4).R() == 1) {
                    z11 = true;
                }
            }
            if (z10) {
                for (int i19 = 0; i19 < size2; i19++) {
                    d dVar5 = arrayList2.get(i19);
                    if (dVar5 instanceof f) {
                        f fVar4 = (f) dVar5;
                        if (fVar4.p0 == 0) {
                            h.g(fVar4, bVar);
                        }
                    }
                }
            }
            h.g(this, bVar);
            if (z11) {
                for (int i20 = 0; i20 < size2; i20++) {
                    d dVar6 = arrayList2.get(i20);
                    if (dVar6 instanceof a) {
                        a aVar18 = (a) dVar6;
                        if (aVar18.R() == 1 && aVar18.Q()) {
                            h.g(aVar18, bVar);
                        }
                    }
                }
            }
            for (int i21 = 0; i21 < size2; i21++) {
                d dVar7 = arrayList2.get(i21);
                if (dVar7.y() && h.a(dVar7)) {
                    X(dVar7, bVar, h.a, 0);
                    h.b(dVar7, bVar, z7);
                    h.g(dVar7, bVar);
                }
            }
            for (int i22 = 0; i22 < size; i22++) {
                d dVar8 = this.l0.get(i22);
                if (dVar8.y() && !(dVar8 instanceof f) && !(dVar8 instanceof a) && !(dVar8 instanceof j) && !dVar8.A) {
                    if (!(dVar8.k(0) == aVar12 && dVar8.f1282l != 1 && dVar8.k(1) == aVar12 && dVar8.m != 1)) {
                        X(dVar8, this.o0, new b.a(), 0);
                    }
                }
            }
        } else {
            zArr = zArr2;
            aVar = aVar13;
            i2 = max3;
            i3 = max4;
            aVar2 = aVar15;
        }
        if (size > 2) {
            d.a aVar19 = aVar;
            d.a aVar20 = aVar2;
            if ((aVar16 == aVar19 || aVar20 == aVar19) && i.b(this.x0, 1024)) {
                b.AbstractC0028b bVar2 = this.o0;
                c.a aVar21 = c.a.CENTER;
                ArrayList<d> arrayList3 = this.l0;
                int size3 = arrayList3.size();
                int i23 = 0;
                while (true) {
                    if (i23 < size3) {
                        d dVar9 = arrayList3.get(i23);
                        if (!m.h.t1(m(), q(), dVar9.m(), dVar9.q())) {
                            aVar3 = aVar14;
                            aVar5 = aVar19;
                            i4 = size;
                            aVar7 = aVar20;
                            aVar8 = aVar16;
                            break;
                        }
                        i23++;
                    } else {
                        int i24 = 0;
                        ArrayList arrayList4 = null;
                        ArrayList arrayList5 = null;
                        ArrayList arrayList6 = null;
                        ArrayList arrayList7 = null;
                        ArrayList arrayList8 = null;
                        ArrayList arrayList9 = null;
                        while (i24 < size3) {
                            d dVar10 = arrayList3.get(i24);
                            if (!m.h.t1(m(), q(), dVar10.m(), dVar10.q())) {
                                X(dVar10, bVar2, this.E0, 0);
                            }
                            boolean z12 = dVar10 instanceof f;
                            if (z12) {
                                f fVar5 = (f) dVar10;
                                if (fVar5.p0 == 0) {
                                    if (arrayList6 == null) {
                                        arrayList6 = new ArrayList();
                                    }
                                    arrayList6.add(fVar5);
                                }
                                if (fVar5.p0 == 1) {
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                    }
                                    arrayList4.add(fVar5);
                                }
                            }
                            if (dVar10 instanceof h) {
                                if (dVar10 instanceof a) {
                                    a aVar22 = (a) dVar10;
                                    if (aVar22.R() == 0) {
                                        if (arrayList5 == null) {
                                            arrayList5 = new ArrayList();
                                        }
                                        arrayList5.add(aVar22);
                                    }
                                    int R = aVar22.R();
                                    aVar9 = aVar22;
                                    if (R == 1) {
                                        if (arrayList7 == null) {
                                            arrayList = new ArrayList();
                                            aVar10 = aVar22;
                                        }
                                        arrayList7.add(aVar9 == 1 ? 1 : 0);
                                    }
                                } else {
                                    h hVar = (h) dVar10;
                                    if (arrayList5 == null) {
                                        arrayList5 = new ArrayList();
                                    }
                                    arrayList5.add(hVar);
                                    aVar9 = hVar;
                                    if (arrayList7 == null) {
                                        arrayList = new ArrayList();
                                        aVar10 = hVar;
                                    }
                                    arrayList7.add(aVar9 == 1 ? 1 : 0);
                                }
                                arrayList7 = arrayList;
                                aVar9 = aVar10;
                                arrayList7.add(aVar9 == 1 ? 1 : 0);
                            }
                            if (dVar10.D.f1262f == null && dVar10.F.f1262f == null && !z12 && !(dVar10 instanceof a)) {
                                if (arrayList8 == null) {
                                    arrayList8 = new ArrayList();
                                }
                                arrayList8.add(dVar10);
                                arrayList8 = arrayList8;
                            }
                            if (dVar10.E.f1262f == null && dVar10.G.f1262f == null && dVar10.H.f1262f == null && !z12 && !(dVar10 instanceof a)) {
                                if (arrayList9 == null) {
                                    arrayList9 = new ArrayList();
                                }
                                arrayList9.add(dVar10);
                                arrayList9 = arrayList9;
                            }
                            i24++;
                            aVar20 = aVar20;
                            size = size;
                            aVar16 = aVar16;
                            aVar14 = aVar14;
                            aVar19 = aVar19;
                        }
                        aVar3 = aVar14;
                        i4 = size;
                        aVar7 = aVar20;
                        aVar8 = aVar16;
                        ArrayList<n> arrayList10 = new ArrayList<>();
                        if (arrayList4 != null) {
                            Iterator it = arrayList4.iterator();
                            while (it.hasNext()) {
                                m.h.V((f) it.next(), 0, arrayList10, null);
                            }
                        }
                        n nVar3 = null;
                        int i25 = 0;
                        if (arrayList5 != null) {
                            Iterator it2 = arrayList5.iterator();
                            while (it2.hasNext()) {
                                h hVar2 = (h) it2.next();
                                n V = m.h.V(hVar2, i25, arrayList10, nVar3);
                                hVar2.P(arrayList10, i25, V);
                                V.b(arrayList10);
                                nVar3 = null;
                                i25 = 0;
                            }
                        }
                        HashSet<c> hashSet = i(c.a.LEFT).a;
                        if (hashSet != null) {
                            Iterator<c> it3 = hashSet.iterator();
                            while (it3.hasNext()) {
                                m.h.V(it3.next().f1260d, 0, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet2 = i(c.a.RIGHT).a;
                        if (hashSet2 != null) {
                            Iterator<c> it4 = hashSet2.iterator();
                            while (it4.hasNext()) {
                                m.h.V(it4.next().f1260d, 0, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet3 = i(aVar21).a;
                        if (hashSet3 != null) {
                            Iterator<c> it5 = hashSet3.iterator();
                            while (it5.hasNext()) {
                                m.h.V(it5.next().f1260d, 0, arrayList10, null);
                            }
                        }
                        n nVar4 = null;
                        if (arrayList8 != null) {
                            Iterator it6 = arrayList8.iterator();
                            while (it6.hasNext()) {
                                m.h.V((d) it6.next(), 0, arrayList10, null);
                            }
                        }
                        if (arrayList6 != null) {
                            Iterator it7 = arrayList6.iterator();
                            while (it7.hasNext()) {
                                m.h.V((f) it7.next(), 1, arrayList10, null);
                            }
                        }
                        int i26 = 1;
                        if (arrayList7 != null) {
                            Iterator it8 = arrayList7.iterator();
                            while (it8.hasNext()) {
                                h hVar3 = (h) it8.next();
                                n V2 = m.h.V(hVar3, i26, arrayList10, nVar4);
                                hVar3.P(arrayList10, i26, V2);
                                V2.b(arrayList10);
                                nVar4 = null;
                                i26 = 1;
                            }
                        }
                        HashSet<c> hashSet4 = i(c.a.TOP).a;
                        if (hashSet4 != null) {
                            Iterator<c> it9 = hashSet4.iterator();
                            while (it9.hasNext()) {
                                m.h.V(it9.next().f1260d, 1, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet5 = i(c.a.BASELINE).a;
                        if (hashSet5 != null) {
                            Iterator<c> it10 = hashSet5.iterator();
                            while (it10.hasNext()) {
                                m.h.V(it10.next().f1260d, 1, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet6 = i(c.a.BOTTOM).a;
                        if (hashSet6 != null) {
                            Iterator<c> it11 = hashSet6.iterator();
                            while (it11.hasNext()) {
                                m.h.V(it11.next().f1260d, 1, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet7 = i(aVar21).a;
                        if (hashSet7 != null) {
                            Iterator<c> it12 = hashSet7.iterator();
                            while (it12.hasNext()) {
                                m.h.V(it12.next().f1260d, 1, arrayList10, null);
                            }
                        }
                        char c = 1;
                        if (arrayList9 != null) {
                            Iterator it13 = arrayList9.iterator();
                            while (it13.hasNext()) {
                                m.h.V((d) it13.next(), 1, arrayList10, null);
                            }
                        }
                        int i27 = 0;
                        while (i27 < size3) {
                            d dVar11 = arrayList3.get(i27);
                            d.a[] aVarArr2 = dVar11.O;
                            if (aVarArr2[0] == aVar12 && aVarArr2[c] == aVar12) {
                                n W = m.h.W(arrayList10, dVar11.j0);
                                n W2 = m.h.W(arrayList10, dVar11.k0);
                                if (!(W == null || W2 == null)) {
                                    W.d(0, W2);
                                    W2.c = 2;
                                    arrayList10.remove(W);
                                }
                            }
                            i27++;
                            c = 1;
                        }
                        int i28 = 1;
                        if (arrayList10.size() <= 1) {
                            aVar5 = aVar19;
                        } else {
                            aVar5 = aVar19;
                            if (m() == aVar5) {
                                Iterator<n> it14 = arrayList10.iterator();
                                int i29 = 0;
                                nVar = null;
                                while (it14.hasNext()) {
                                    n next = it14.next();
                                    if (next.c != i28) {
                                        int c2 = next.c(this.q0, 0);
                                        if (c2 > i29) {
                                            i29 = c2;
                                            nVar = next;
                                        }
                                    }
                                    i28 = 1;
                                }
                                if (nVar != null) {
                                    this.O[0] = aVar3;
                                    M(i29);
                                    if (q() == aVar5) {
                                        Iterator<n> it15 = arrayList10.iterator();
                                        int i30 = 0;
                                        nVar2 = null;
                                        while (it15.hasNext()) {
                                            n next2 = it15.next();
                                            if (next2.c != 0) {
                                                int c3 = next2.c(this.q0, 1);
                                                if (c3 > i30) {
                                                    nVar2 = next2;
                                                    i30 = c3;
                                                }
                                            }
                                        }
                                        if (nVar2 != null) {
                                            this.O[1] = aVar3;
                                            H(i30);
                                            if (nVar != null || nVar2 != null) {
                                                z6 = true;
                                            }
                                        }
                                    }
                                    nVar2 = null;
                                    z6 = true;
                                }
                            }
                            nVar = null;
                            if (q() == aVar5) {
                            }
                            nVar2 = null;
                            z6 = true;
                        }
                    }
                }
                if (z6) {
                    aVar6 = aVar8;
                    if (aVar6 == aVar5) {
                        i11 = i2;
                        if (i11 >= r() || i11 <= 0) {
                            i6 = r();
                            aVar4 = aVar7;
                            if (aVar4 != aVar5) {
                                i10 = i3;
                                if (i10 >= l() || i10 <= 0) {
                                    i5 = l();
                                    z = true;
                                    boolean z13 = !Y(64) || Y(128);
                                    e.g.b.d dVar12 = this.q0;
                                    Objects.requireNonNull(dVar12);
                                    dVar12.f1227g = false;
                                    if (this.x0 != 0 && z13) {
                                        dVar12.f1227g = true;
                                    }
                                    ArrayList<d> arrayList11 = this.l0;
                                    boolean z14 = m() != aVar5 || q() == aVar5;
                                    this.t0 = 0;
                                    this.u0 = 0;
                                    for (i7 = 0; i7 < i4; i7++) {
                                        d dVar13 = this.l0.get(i7);
                                        if (dVar13 instanceof k) {
                                            ((k) dVar13).P();
                                        }
                                    }
                                    boolean Y = Y(64);
                                    z2 = z;
                                    int i31 = 0;
                                    z3 = true;
                                    while (z3) {
                                        int i32 = i31 + 1;
                                        try {
                                            this.q0.u();
                                            this.t0 = 0;
                                            this.u0 = 0;
                                            g(this.q0);
                                            for (int i33 = 0; i33 < i4; i33++) {
                                                this.l0.get(i33).g(this.q0);
                                            }
                                            R(this.q0);
                                            try {
                                                WeakReference<c> weakReference = this.A0;
                                                if (weakReference == null || weakReference.get() == null) {
                                                    z4 = z2;
                                                } else {
                                                    z4 = z2;
                                                    try {
                                                        this.q0.f(this.q0.l(this.A0.get()), this.q0.l(this.E), 0, 5);
                                                        this.A0 = null;
                                                    } catch (Exception e3) {
                                                        e2 = e3;
                                                        z3 = true;
                                                        e2.printStackTrace();
                                                        PrintStream printStream = System.out;
                                                        printStream.println("EXCEPTION : " + e2);
                                                        e.g.b.d dVar14 = this.q0;
                                                        if (z3) {
                                                        }
                                                        if (z14) {
                                                        }
                                                        z5 = false;
                                                        max = Math.max(this.X, r());
                                                        if (max > r()) {
                                                        }
                                                        max2 = Math.max(this.Y, l());
                                                        if (max2 > l()) {
                                                        }
                                                        if (!z4) {
                                                        }
                                                        z3 = z5;
                                                        z2 = z4;
                                                        i31 = i32;
                                                    }
                                                }
                                                WeakReference<c> weakReference2 = this.C0;
                                                if (!(weakReference2 == null || weakReference2.get() == null)) {
                                                    this.q0.f(this.q0.l(this.G), this.q0.l(this.C0.get()), 0, 5);
                                                    this.C0 = null;
                                                }
                                                WeakReference<c> weakReference3 = this.B0;
                                                if (!(weakReference3 == null || weakReference3.get() == null)) {
                                                    this.q0.f(this.q0.l(this.B0.get()), this.q0.l(this.D), 0, 5);
                                                    this.B0 = null;
                                                }
                                                WeakReference<c> weakReference4 = this.D0;
                                                if (weakReference4 != null && weakReference4.get() != null) {
                                                    this.q0.f(this.q0.l(this.F), this.q0.l(this.D0.get()), 0, 5);
                                                    try {
                                                        this.D0 = null;
                                                    } catch (Exception e4) {
                                                        e2 = e4;
                                                        z3 = true;
                                                        e2.printStackTrace();
                                                        PrintStream printStream2 = System.out;
                                                        printStream2.println("EXCEPTION : " + e2);
                                                        e.g.b.d dVar142 = this.q0;
                                                        if (z3) {
                                                        }
                                                        if (z14) {
                                                        }
                                                        z5 = false;
                                                        max = Math.max(this.X, r());
                                                        if (max > r()) {
                                                        }
                                                        max2 = Math.max(this.Y, l());
                                                        if (max2 > l()) {
                                                        }
                                                        if (!z4) {
                                                        }
                                                        z3 = z5;
                                                        z2 = z4;
                                                        i31 = i32;
                                                    }
                                                }
                                                this.q0.q();
                                                z3 = true;
                                            } catch (Exception e5) {
                                                e2 = e5;
                                                z4 = z2;
                                                z3 = true;
                                                e2.printStackTrace();
                                                PrintStream printStream22 = System.out;
                                                printStream22.println("EXCEPTION : " + e2);
                                                e.g.b.d dVar1422 = this.q0;
                                                if (z3) {
                                                }
                                                if (z14) {
                                                }
                                                z5 = false;
                                                max = Math.max(this.X, r());
                                                if (max > r()) {
                                                }
                                                max2 = Math.max(this.Y, l());
                                                if (max2 > l()) {
                                                }
                                                if (!z4) {
                                                }
                                                z3 = z5;
                                                z2 = z4;
                                                i31 = i32;
                                            }
                                        } catch (Exception e6) {
                                            e2 = e6;
                                            z4 = z2;
                                            e2.printStackTrace();
                                            PrintStream printStream222 = System.out;
                                            printStream222.println("EXCEPTION : " + e2);
                                            e.g.b.d dVar14222 = this.q0;
                                            if (z3) {
                                            }
                                            if (z14) {
                                            }
                                            z5 = false;
                                            max = Math.max(this.X, r());
                                            if (max > r()) {
                                            }
                                            max2 = Math.max(this.Y, l());
                                            if (max2 > l()) {
                                            }
                                            if (!z4) {
                                            }
                                            z3 = z5;
                                            z2 = z4;
                                            i31 = i32;
                                        }
                                        e.g.b.d dVar142222 = this.q0;
                                        if (z3) {
                                            zArr[2] = false;
                                            boolean Y2 = Y(64);
                                            O(dVar142222, Y2);
                                            int size4 = this.l0.size();
                                            for (int i34 = 0; i34 < size4; i34++) {
                                                this.l0.get(i34).O(dVar142222, Y2);
                                            }
                                        } else {
                                            O(dVar142222, Y);
                                            for (int i35 = 0; i35 < i4; i35++) {
                                                this.l0.get(i35).O(this.q0, Y);
                                            }
                                        }
                                        if (z14 || i32 >= 8 || !zArr[2]) {
                                            z5 = false;
                                        } else {
                                            int i36 = 0;
                                            int i37 = 0;
                                            for (int i38 = 0; i38 < i4; i38++) {
                                                d dVar15 = this.l0.get(i38);
                                                i36 = Math.max(i36, dVar15.r() + dVar15.U);
                                                i37 = Math.max(i37, dVar15.l() + dVar15.V);
                                            }
                                            int max5 = Math.max(this.X, i36);
                                            int max6 = Math.max(this.Y, i37);
                                            if (aVar6 != aVar5 || r() >= max5) {
                                                z5 = false;
                                            } else {
                                                M(max5);
                                                this.O[0] = aVar5;
                                                z5 = true;
                                                z4 = true;
                                            }
                                            if (aVar4 == aVar5 && l() < max6) {
                                                H(max6);
                                                this.O[1] = aVar5;
                                                z5 = true;
                                                z4 = true;
                                            }
                                        }
                                        max = Math.max(this.X, r());
                                        if (max > r()) {
                                            M(max);
                                            this.O[0] = aVar3;
                                            z5 = true;
                                            z4 = true;
                                        }
                                        max2 = Math.max(this.Y, l());
                                        if (max2 > l()) {
                                            H(max2);
                                            r3 = 1;
                                            this.O[1] = aVar3;
                                            z5 = true;
                                            z4 = true;
                                        } else {
                                            r3 = 1;
                                        }
                                        if (!z4) {
                                            if (this.O[0] == aVar5 && i6 > 0 && r() > i6) {
                                                this.y0 = r3;
                                                this.O[0] = aVar3;
                                                M(i6);
                                                z5 = true;
                                                z4 = true;
                                            }
                                            d.a[] aVarArr3 = this.O;
                                            char c4 = r3 == true ? 1 : 0;
                                            char c5 = r3 == true ? 1 : 0;
                                            char c6 = r3 == true ? 1 : 0;
                                            if (aVarArr3[c4] == aVar5 && i5 > 0 && l() > i5) {
                                                this.z0 = r3;
                                                this.O[r3] = aVar3;
                                                H(i5);
                                                z2 = true;
                                                z3 = true;
                                                i31 = i32;
                                            }
                                        }
                                        z3 = z5;
                                        z2 = z4;
                                        i31 = i32;
                                    }
                                    this.l0 = arrayList11;
                                    if (z2) {
                                        d.a[] aVarArr4 = this.O;
                                        aVarArr4[0] = aVar6;
                                        aVarArr4[1] = aVar4;
                                    }
                                    D(this.q0.f1232l);
                                }
                                H(i10);
                                this.z0 = true;
                            } else {
                                i10 = i3;
                            }
                            i5 = i10;
                            z = true;
                            if (!Y(64)) {
                            }
                            e.g.b.d dVar122 = this.q0;
                            Objects.requireNonNull(dVar122);
                            dVar122.f1227g = false;
                            dVar122.f1227g = true;
                            ArrayList<d> arrayList112 = this.l0;
                            if (m() != aVar5) {
                            }
                            this.t0 = 0;
                            this.u0 = 0;
                            while (i7 < i4) {
                            }
                            boolean Y3 = Y(64);
                            z2 = z;
                            int i312 = 0;
                            z3 = true;
                            while (z3) {
                            }
                            this.l0 = arrayList112;
                            if (z2) {
                            }
                            D(this.q0.f1232l);
                        }
                        M(i11);
                        this.y0 = true;
                    } else {
                        i11 = i2;
                    }
                    i6 = i11;
                    aVar4 = aVar7;
                    if (aVar4 != aVar5) {
                    }
                    i5 = i10;
                    z = true;
                    if (!Y(64)) {
                    }
                    e.g.b.d dVar1222 = this.q0;
                    Objects.requireNonNull(dVar1222);
                    dVar1222.f1227g = false;
                    dVar1222.f1227g = true;
                    ArrayList<d> arrayList1122 = this.l0;
                    if (m() != aVar5) {
                    }
                    this.t0 = 0;
                    this.u0 = 0;
                    while (i7 < i4) {
                    }
                    boolean Y32 = Y(64);
                    z2 = z;
                    int i3122 = 0;
                    z3 = true;
                    while (z3) {
                    }
                    this.l0 = arrayList1122;
                    if (z2) {
                    }
                    D(this.q0.f1232l);
                }
                i8 = i3;
                i9 = i2;
                aVar4 = aVar7;
                aVar6 = aVar8;
            } else {
                aVar3 = aVar14;
                aVar5 = aVar19;
                i4 = size;
                aVar4 = aVar20;
                aVar6 = aVar16;
                i8 = i3;
                i9 = i2;
            }
        } else {
            aVar3 = aVar14;
            i4 = size;
            aVar6 = aVar16;
            i8 = i3;
            i9 = i2;
            aVar4 = aVar2;
            aVar5 = aVar;
        }
        i6 = i9;
        i5 = i8;
        z = false;
        if (!Y(64)) {
        }
        e.g.b.d dVar12222 = this.q0;
        Objects.requireNonNull(dVar12222);
        dVar12222.f1227g = false;
        dVar12222.f1227g = true;
        ArrayList<d> arrayList11222 = this.l0;
        if (m() != aVar5) {
        }
        this.t0 = 0;
        this.u0 = 0;
        while (i7 < i4) {
        }
        boolean Y322 = Y(64);
        z2 = z;
        int i31222 = 0;
        z3 = true;
        while (z3) {
        }
        this.l0 = arrayList11222;
        if (z2) {
        }
        D(this.q0.f1232l);
    }

    public void Q(d dVar, int i2) {
        if (i2 == 0) {
            int i3 = this.t0 + 1;
            b[] bVarArr = this.w0;
            if (i3 >= bVarArr.length) {
                this.w0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.w0;
            int i4 = this.t0;
            bVarArr2[i4] = new b(dVar, 0, this.p0);
            this.t0 = i4 + 1;
        } else if (i2 == 1) {
            int i5 = this.u0 + 1;
            b[] bVarArr3 = this.v0;
            if (i5 >= bVarArr3.length) {
                this.v0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.v0;
            int i6 = this.u0;
            bVarArr4[i6] = new b(dVar, 1, this.p0);
            this.u0 = i6 + 1;
        }
    }

    public boolean R(e.g.b.d dVar) {
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.WRAP_CONTENT;
        boolean Y = Y(64);
        d(dVar, Y);
        int size = this.l0.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar2 = this.l0.get(i2);
            boolean[] zArr = dVar2.N;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar2 instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                d dVar3 = this.l0.get(i3);
                if (dVar3 instanceof a) {
                    a aVar3 = (a) dVar3;
                    for (int i4 = 0; i4 < aVar3.m0; i4++) {
                        d dVar4 = aVar3.l0[i4];
                        int i5 = aVar3.n0;
                        if (i5 == 0 || i5 == 1) {
                            dVar4.N[0] = true;
                        } else if (i5 == 2 || i5 == 3) {
                            dVar4.N[1] = true;
                        }
                    }
                }
            }
        }
        for (int i6 = 0; i6 < size; i6++) {
            d dVar5 = this.l0.get(i6);
            if (dVar5.c()) {
                dVar5.d(dVar, Y);
            }
        }
        if (e.g.b.d.p) {
            HashSet<d> hashSet = new HashSet<>();
            for (int i7 = 0; i7 < size; i7++) {
                d dVar6 = this.l0.get(i7);
                if (!dVar6.c()) {
                    hashSet.add(dVar6);
                }
            }
            b(this, dVar, hashSet, m() == aVar2 ? 0 : 1, false);
            Iterator<d> it = hashSet.iterator();
            while (it.hasNext()) {
                d next = it.next();
                i.a(this, dVar, next);
                next.d(dVar, Y);
            }
        } else {
            for (int i8 = 0; i8 < size; i8++) {
                d dVar7 = this.l0.get(i8);
                if (dVar7 instanceof e) {
                    d.a[] aVarArr = dVar7.O;
                    d.a aVar4 = aVarArr[0];
                    d.a aVar5 = aVarArr[1];
                    if (aVar4 == aVar2) {
                        aVarArr[0] = aVar;
                    }
                    if (aVar5 == aVar2) {
                        aVarArr[1] = aVar;
                    }
                    dVar7.d(dVar, Y);
                    if (aVar4 == aVar2) {
                        dVar7.I(aVar4);
                    }
                    if (aVar5 == aVar2) {
                        dVar7.L(aVar5);
                    }
                } else {
                    i.a(this, dVar, dVar7);
                    if (!dVar7.c()) {
                        dVar7.d(dVar, Y);
                    }
                }
            }
        }
        if (this.t0 > 0) {
            m.h.b(this, dVar, null, 0);
        }
        if (this.u0 > 0) {
            m.h.b(this, dVar, null, 1);
        }
        return true;
    }

    public void S(c cVar) {
        WeakReference<c> weakReference = this.D0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.D0.get().c()) {
            this.D0 = new WeakReference<>(cVar);
        }
    }

    public void T(c cVar) {
        WeakReference<c> weakReference = this.C0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.C0.get().c()) {
            this.C0 = new WeakReference<>(cVar);
        }
    }

    public void U(c cVar) {
        WeakReference<c> weakReference = this.A0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.A0.get().c()) {
            this.A0 = new WeakReference<>(cVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012c A[EDGE_INSN: B:76:0x012c->B:61:0x012c ?: BREAK  , SYNTHETIC] */
    public boolean V(boolean z, int i2) {
        boolean z2;
        Iterator<o> it;
        Iterator<o> it2;
        int i3;
        g gVar;
        int i4;
        g gVar2;
        e.g.b.h.l.e eVar = this.n0;
        d.a aVar = d.a.MATCH_PARENT;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        boolean z3 = true;
        boolean z4 = z & true;
        d.a k2 = eVar.a.k(0);
        d.a k3 = eVar.a.k(1);
        int s = eVar.a.s();
        int t = eVar.a.t();
        if (z4 && (k2 == aVar2 || k3 == aVar2)) {
            Iterator<o> it3 = eVar.f1296e.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                o next = it3.next();
                if (next.f1324f == i2 && !next.k()) {
                    z4 = false;
                    break;
                }
            }
            if (i2 == 0) {
                if (z4 && k2 == aVar2) {
                    e eVar2 = eVar.a;
                    eVar2.O[0] = aVar3;
                    eVar2.M(eVar.d(eVar2, 0));
                    e eVar3 = eVar.a;
                    gVar2 = eVar3.f1274d.f1323e;
                    i4 = eVar3.r();
                }
            } else if (z4 && k3 == aVar2) {
                e eVar4 = eVar.a;
                eVar4.O[1] = aVar3;
                eVar4.H(eVar.d(eVar4, 1));
                e eVar5 = eVar.a;
                gVar2 = eVar5.f1275e.f1323e;
                i4 = eVar5.l();
            }
            gVar2.c(i4);
        }
        e eVar6 = eVar.a;
        d.a[] aVarArr = eVar6.O;
        if (i2 == 0) {
            if (aVarArr[0] == aVar3 || aVarArr[0] == aVar) {
                int r = eVar6.r() + s;
                eVar.a.f1274d.f1327i.c(r);
                gVar = eVar.a.f1274d.f1323e;
                i3 = r - s;
                gVar.c(i3);
                z2 = true;
                eVar.g();
                it = eVar.f1296e.iterator();
                while (it.hasNext()) {
                    o next2 = it.next();
                    if (next2.f1324f == i2 && (next2.b != eVar.a || next2.f1325g)) {
                        next2.e();
                    }
                }
                it2 = eVar.f1296e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    o next3 = it2.next();
                    if (next3.f1324f == i2 && ((z2 || next3.b != eVar.a) && (!next3.f1326h.f1306j || !next3.f1327i.f1306j || (!(next3 instanceof e.g.b.h.l.c) && !next3.f1323e.f1306j)))) {
                        z3 = false;
                    }
                }
                z3 = false;
                eVar.a.I(k2);
                eVar.a.L(k3);
                return z3;
            }
        } else if (aVarArr[1] == aVar3 || aVarArr[1] == aVar) {
            int l2 = eVar6.l() + t;
            eVar.a.f1275e.f1327i.c(l2);
            gVar = eVar.a.f1275e.f1323e;
            i3 = l2 - t;
            gVar.c(i3);
            z2 = true;
            eVar.g();
            it = eVar.f1296e.iterator();
            while (it.hasNext()) {
            }
            it2 = eVar.f1296e.iterator();
            while (true) {
                if (!it2.hasNext()) {
                }
            }
            z3 = false;
            eVar.a.I(k2);
            eVar.a.L(k3);
            return z3;
        }
        z2 = false;
        eVar.g();
        it = eVar.f1296e.iterator();
        while (it.hasNext()) {
        }
        it2 = eVar.f1296e.iterator();
        while (true) {
            if (!it2.hasNext()) {
            }
        }
        z3 = false;
        eVar.a.I(k2);
        eVar.a.L(k3);
        return z3;
    }

    public void W() {
        this.n0.b = true;
    }

    public boolean Y(int i2) {
        return (this.x0 & i2) == i2;
    }

    public void Z(int i2) {
        this.x0 = i2;
        e.g.b.d.p = Y(512);
    }
}
