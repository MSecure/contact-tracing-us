package e.h.a.i;

import androidx.constraintlayout.widget.ConstraintLayout;
import e.b.a.m;
import e.h.a.d;
import e.h.a.i.c;
import e.h.a.i.d;
import e.h.a.i.l.b;
import e.h.a.i.l.g;
import e.h.a.i.l.h;
import e.h.a.i.l.n;
import e.h.a.i.l.o;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes.dex */
public class e extends k {
    public int t0;
    public int x0;
    public int y0;
    public b r0 = new b(this);
    public e.h.a.i.l.e s0 = new e.h.a.i.l.e(this);
    public b.AbstractC0031b u0 = null;
    public boolean v0 = false;
    public d w0 = new d();
    public int z0 = 0;
    public int A0 = 0;
    public b[] B0 = new b[4];
    public b[] C0 = new b[4];
    public int D0 = 257;
    public boolean E0 = false;
    public boolean F0 = false;
    public WeakReference<c> G0 = null;
    public WeakReference<c> H0 = null;
    public WeakReference<c> I0 = null;
    public WeakReference<c> J0 = null;
    public HashSet<d> K0 = new HashSet<>();
    public b.a L0 = new b.a();

    public static boolean Z(d dVar, b.AbstractC0031b bVar, b.a aVar, int i2) {
        int i3;
        int i4;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        if (bVar == null) {
            return false;
        }
        if (dVar.h0 == 8 || (dVar instanceof f) || (dVar instanceof a)) {
            aVar.f1404e = 0;
            aVar.f1405f = 0;
            return false;
        }
        aVar.a = dVar.m();
        aVar.b = dVar.q();
        aVar.c = dVar.r();
        aVar.f1403d = dVar.l();
        aVar.f1408i = false;
        aVar.f1409j = i2;
        d.a aVar4 = aVar.a;
        d.a aVar5 = d.a.MATCH_CONSTRAINT;
        boolean z = aVar4 == aVar5;
        boolean z2 = aVar.b == aVar5;
        boolean z3 = z && dVar.X > 0.0f;
        boolean z4 = z2 && dVar.X > 0.0f;
        if (z && dVar.u(0) && dVar.q == 0 && !z3) {
            aVar.a = aVar2;
            if (z2 && dVar.r == 0) {
                aVar.a = aVar3;
            }
            z = false;
        }
        if (z2 && dVar.u(1) && dVar.r == 0 && !z4) {
            aVar.b = aVar2;
            if (z && dVar.q == 0) {
                aVar.b = aVar3;
            }
            z2 = false;
        }
        if (dVar.A()) {
            aVar.a = aVar3;
            z = false;
        }
        if (dVar.B()) {
            aVar.b = aVar3;
            z2 = false;
        }
        if (z3) {
            if (dVar.s[0] == 4) {
                aVar.a = aVar3;
            } else if (!z2) {
                if (aVar.b == aVar3) {
                    i4 = aVar.f1403d;
                } else {
                    aVar.a = aVar2;
                    ((ConstraintLayout.b) bVar).b(dVar, aVar);
                    i4 = aVar.f1405f;
                }
                aVar.a = aVar3;
                aVar.c = (int) (dVar.X * ((float) i4));
            }
        }
        if (z4) {
            if (dVar.s[1] == 4) {
                aVar.b = aVar3;
            } else if (!z) {
                if (aVar.a == aVar3) {
                    i3 = aVar.c;
                } else {
                    aVar.b = aVar2;
                    ((ConstraintLayout.b) bVar).b(dVar, aVar);
                    i3 = aVar.f1404e;
                }
                aVar.b = aVar3;
                aVar.f1403d = dVar.Y == -1 ? (int) (((float) i3) / dVar.X) : (int) (dVar.X * ((float) i3));
            }
        }
        ((ConstraintLayout.b) bVar).b(dVar, aVar);
        dVar.N(aVar.f1404e);
        dVar.I(aVar.f1405f);
        dVar.D = aVar.f1407h;
        dVar.F(aVar.f1406g);
        aVar.f1409j = 0;
        return aVar.f1408i;
    }

    @Override // e.h.a.i.k, e.h.a.i.d
    public void C() {
        this.w0.u();
        this.x0 = 0;
        this.y0 = 0;
        super.C();
    }

    @Override // e.h.a.i.d
    public void O(boolean z, boolean z2) {
        super.O(z, z2);
        int size = this.q0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.q0.get(i2).O(z, z2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:349:0x05ec, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:334:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x05e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x066f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x07b8  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x07ff  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x081d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:478:0x089a  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x08b5  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x08c4  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0901  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0911  */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // e.h.a.i.k
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void Q() {
        d.a aVar;
        int i2;
        int i3;
        d.a aVar2;
        int i4;
        int i5;
        int i6;
        d.a aVar3;
        d.a aVar4;
        d.a aVar5;
        boolean z;
        e.h.a.d dVar;
        int i7;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int max;
        int max2;
        ?? r3;
        int i8;
        Exception e2;
        int i9;
        d.a aVar6;
        d.a aVar7;
        n nVar;
        n nVar2;
        boolean z7;
        int c;
        int c2;
        a aVar8;
        ArrayList arrayList;
        a aVar9;
        int i10;
        d.a aVar10;
        d.a aVar11 = d.a.MATCH_CONSTRAINT;
        d.a aVar12 = d.a.WRAP_CONTENT;
        d.a aVar13 = d.a.FIXED;
        this.Z = 0;
        this.a0 = 0;
        this.E0 = false;
        this.F0 = false;
        int size = this.q0.size();
        int max3 = Math.max(0, r());
        int max4 = Math.max(0, l());
        d.a[] aVarArr = this.T;
        d.a aVar14 = aVarArr[1];
        d.a aVar15 = aVarArr[0];
        if (this.t0 != 0 || !i.b(this.D0, 1)) {
            i2 = max3;
            i3 = max4;
            aVar = aVar14;
        } else {
            b.AbstractC0031b bVar = this.u0;
            d.a m = m();
            d.a q = q();
            h.b = 0;
            h.c = 0;
            D();
            ArrayList<d> arrayList2 = this.q0;
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                arrayList2.get(i11).D();
            }
            boolean z8 = this.v0;
            if (m == aVar13) {
                G(0, r());
                i3 = max4;
            } else {
                c cVar = this.I;
                cVar.b = 0;
                i3 = max4;
                cVar.c = true;
                this.Z = 0;
            }
            boolean z9 = false;
            int i12 = 0;
            boolean z10 = false;
            while (i12 < size2) {
                d dVar2 = arrayList2.get(i12);
                if (dVar2 instanceof f) {
                    f fVar = (f) dVar2;
                    aVar10 = aVar14;
                    if (fVar.u0 == 1) {
                        int i13 = fVar.r0;
                        if (i13 == -1) {
                            if (fVar.s0 == -1 || !A()) {
                                if (A()) {
                                    i13 = (int) ((fVar.q0 * ((float) r())) + 0.5f);
                                }
                                z9 = true;
                            } else {
                                i13 = r() - fVar.s0;
                            }
                        }
                        fVar.Q(i13);
                        z9 = true;
                    }
                } else {
                    aVar10 = aVar14;
                    if ((dVar2 instanceof a) && ((a) dVar2).S() == 0) {
                        z10 = true;
                    }
                }
                i12++;
                max3 = max3;
                aVar14 = aVar10;
            }
            i2 = max3;
            aVar = aVar14;
            if (z9) {
                for (int i14 = 0; i14 < size2; i14++) {
                    d dVar3 = arrayList2.get(i14);
                    if (dVar3 instanceof f) {
                        f fVar2 = (f) dVar3;
                        if (fVar2.u0 == 1) {
                            h.b(0, fVar2, bVar, z8);
                        }
                    }
                }
            }
            h.b(0, this, bVar, z8);
            if (z10) {
                for (int i15 = 0; i15 < size2; i15++) {
                    d dVar4 = arrayList2.get(i15);
                    if (dVar4 instanceof a) {
                        a aVar16 = (a) dVar4;
                        if (aVar16.S() == 0 && aVar16.R()) {
                            h.b(1, aVar16, bVar, z8);
                        }
                    }
                }
            }
            if (q == aVar13) {
                H(0, l());
            } else {
                c cVar2 = this.J;
                cVar2.b = 0;
                cVar2.c = true;
                this.a0 = 0;
            }
            boolean z11 = false;
            boolean z12 = false;
            for (int i16 = 0; i16 < size2; i16++) {
                d dVar5 = arrayList2.get(i16);
                if (dVar5 instanceof f) {
                    f fVar3 = (f) dVar5;
                    if (fVar3.u0 == 0) {
                        int i17 = fVar3.r0;
                        if (i17 == -1) {
                            if (fVar3.s0 == -1 || !B()) {
                                if (B()) {
                                    i17 = (int) ((fVar3.q0 * ((float) l())) + 0.5f);
                                }
                                z11 = true;
                            } else {
                                i17 = l() - fVar3.s0;
                            }
                        }
                        fVar3.Q(i17);
                        z11 = true;
                    }
                } else if ((dVar5 instanceof a) && ((a) dVar5).S() == 1) {
                    z12 = true;
                }
            }
            if (z11) {
                for (int i18 = 0; i18 < size2; i18++) {
                    d dVar6 = arrayList2.get(i18);
                    if (dVar6 instanceof f) {
                        f fVar4 = (f) dVar6;
                        if (fVar4.u0 == 0) {
                            h.g(1, fVar4, bVar);
                        }
                    }
                }
            }
            h.g(0, this, bVar);
            if (z12) {
                for (int i19 = 0; i19 < size2; i19++) {
                    d dVar7 = arrayList2.get(i19);
                    if (dVar7 instanceof a) {
                        a aVar17 = (a) dVar7;
                        if (aVar17.S() == 1 && aVar17.R()) {
                            h.g(1, aVar17, bVar);
                        }
                    }
                }
            }
            for (int i20 = 0; i20 < size2; i20++) {
                d dVar8 = arrayList2.get(i20);
                if (dVar8.z() && h.a(dVar8)) {
                    Z(dVar8, bVar, h.a, 0);
                    if (!(dVar8 instanceof f)) {
                        h.b(0, dVar8, bVar, z8);
                    } else if (((f) dVar8).u0 != 0) {
                        h.b(0, dVar8, bVar, z8);
                    }
                    h.g(0, dVar8, bVar);
                }
            }
            for (int i21 = 0; i21 < size; i21++) {
                d dVar9 = this.q0.get(i21);
                if (dVar9.z() && !(dVar9 instanceof f) && !(dVar9 instanceof a) && !(dVar9 instanceof j) && !dVar9.F) {
                    if (!(dVar9.k(0) == aVar11 && dVar9.q != 1 && dVar9.k(1) == aVar11 && dVar9.r != 1)) {
                        Z(dVar9, this.u0, new b.a(), 0);
                    }
                }
            }
        }
        if (size > 2) {
            d.a aVar18 = aVar;
            if ((aVar15 == aVar12 || aVar18 == aVar12) && i.b(this.D0, 1024)) {
                b.AbstractC0031b bVar2 = this.u0;
                c.a aVar19 = c.a.CENTER;
                ArrayList<d> arrayList3 = this.q0;
                int size3 = arrayList3.size();
                int i22 = 0;
                while (true) {
                    if (i22 < size3) {
                        d dVar10 = arrayList3.get(i22);
                        if (!m.e.V1(m(), q(), dVar10.m(), dVar10.q())) {
                            aVar4 = aVar12;
                            aVar2 = aVar13;
                            i4 = size;
                            aVar6 = aVar18;
                            aVar7 = aVar15;
                            break;
                        }
                        i22++;
                    } else {
                        i4 = size;
                        ArrayList arrayList4 = null;
                        int i23 = 0;
                        ArrayList arrayList5 = null;
                        ArrayList arrayList6 = null;
                        ArrayList arrayList7 = null;
                        ArrayList arrayList8 = null;
                        ArrayList arrayList9 = null;
                        while (i23 < size3) {
                            d dVar11 = arrayList3.get(i23);
                            if (!m.e.V1(m(), q(), dVar11.m(), dVar11.q())) {
                                Z(dVar11, bVar2, this.L0, 0);
                            }
                            boolean z13 = dVar11 instanceof f;
                            if (z13) {
                                f fVar5 = (f) dVar11;
                                if (fVar5.u0 == 0) {
                                    if (arrayList6 == null) {
                                        arrayList6 = new ArrayList();
                                    }
                                    arrayList6.add(fVar5);
                                }
                                if (fVar5.u0 == 1) {
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                    }
                                    arrayList4.add(fVar5);
                                }
                            }
                            if (dVar11 instanceof h) {
                                if (dVar11 instanceof a) {
                                    a aVar20 = (a) dVar11;
                                    if (aVar20.S() == 0) {
                                        if (arrayList5 == null) {
                                            arrayList5 = new ArrayList();
                                        }
                                        arrayList5.add(aVar20);
                                    }
                                    int S = aVar20.S();
                                    aVar8 = aVar20;
                                    if (S == 1) {
                                        if (arrayList7 == null) {
                                            arrayList = new ArrayList();
                                            aVar9 = aVar20;
                                            arrayList7 = arrayList;
                                            aVar8 = aVar9;
                                        }
                                        arrayList7.add(aVar8 == 1 ? 1 : 0);
                                    }
                                } else {
                                    h hVar = (h) dVar11;
                                    if (arrayList5 == null) {
                                        arrayList5 = new ArrayList();
                                    }
                                    arrayList5.add(hVar);
                                    aVar8 = hVar;
                                    if (arrayList7 == null) {
                                        arrayList = new ArrayList();
                                        aVar9 = hVar;
                                        arrayList7 = arrayList;
                                        aVar8 = aVar9;
                                    }
                                    arrayList7.add(aVar8 == 1 ? 1 : 0);
                                }
                            }
                            if (dVar11.I.f1379f == null && dVar11.K.f1379f == null && !z13 && !(dVar11 instanceof a)) {
                                if (arrayList8 == null) {
                                    arrayList8 = new ArrayList();
                                }
                                arrayList8.add(dVar11);
                            }
                            if (dVar11.J.f1379f == null && dVar11.L.f1379f == null && dVar11.M.f1379f == null && !z13 && !(dVar11 instanceof a)) {
                                if (arrayList9 == null) {
                                    arrayList9 = new ArrayList();
                                }
                                arrayList9.add(dVar11);
                                arrayList9 = arrayList9;
                            }
                            i23++;
                            aVar15 = aVar15;
                            aVar18 = aVar18;
                            aVar13 = aVar13;
                            aVar12 = aVar12;
                            aVar11 = aVar11;
                        }
                        d.a aVar21 = aVar11;
                        aVar2 = aVar13;
                        aVar6 = aVar18;
                        aVar7 = aVar15;
                        ArrayList<n> arrayList10 = new ArrayList<>();
                        if (arrayList4 != null) {
                            Iterator it = arrayList4.iterator();
                            while (it.hasNext()) {
                                m.e.Y((f) it.next(), 0, arrayList10, null);
                            }
                        }
                        n nVar3 = null;
                        int i24 = 0;
                        if (arrayList5 != null) {
                            Iterator it2 = arrayList5.iterator();
                            while (it2.hasNext()) {
                                h hVar2 = (h) it2.next();
                                n Y = m.e.Y(hVar2, i24, arrayList10, nVar3);
                                hVar2.Q(arrayList10, i24, Y);
                                Y.b(arrayList10);
                                nVar3 = null;
                                i24 = 0;
                            }
                        }
                        HashSet<c> hashSet = i(c.a.LEFT).a;
                        if (hashSet != null) {
                            Iterator<c> it3 = hashSet.iterator();
                            while (it3.hasNext()) {
                                m.e.Y(it3.next().f1377d, 0, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet2 = i(c.a.RIGHT).a;
                        if (hashSet2 != null) {
                            Iterator<c> it4 = hashSet2.iterator();
                            while (it4.hasNext()) {
                                m.e.Y(it4.next().f1377d, 0, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet3 = i(aVar19).a;
                        if (hashSet3 != null) {
                            Iterator<c> it5 = hashSet3.iterator();
                            while (it5.hasNext()) {
                                m.e.Y(it5.next().f1377d, 0, arrayList10, null);
                            }
                        }
                        n nVar4 = null;
                        if (arrayList8 != null) {
                            Iterator it6 = arrayList8.iterator();
                            while (it6.hasNext()) {
                                m.e.Y((d) it6.next(), 0, arrayList10, null);
                            }
                        }
                        if (arrayList6 != null) {
                            Iterator it7 = arrayList6.iterator();
                            while (it7.hasNext()) {
                                m.e.Y((f) it7.next(), 1, arrayList10, null);
                            }
                        }
                        int i25 = 1;
                        if (arrayList7 != null) {
                            Iterator it8 = arrayList7.iterator();
                            while (it8.hasNext()) {
                                h hVar3 = (h) it8.next();
                                n Y2 = m.e.Y(hVar3, i25, arrayList10, nVar4);
                                hVar3.Q(arrayList10, i25, Y2);
                                Y2.b(arrayList10);
                                nVar4 = null;
                                i25 = 1;
                            }
                        }
                        HashSet<c> hashSet4 = i(c.a.TOP).a;
                        if (hashSet4 != null) {
                            Iterator<c> it9 = hashSet4.iterator();
                            while (it9.hasNext()) {
                                m.e.Y(it9.next().f1377d, 1, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet5 = i(c.a.BASELINE).a;
                        if (hashSet5 != null) {
                            Iterator<c> it10 = hashSet5.iterator();
                            while (it10.hasNext()) {
                                m.e.Y(it10.next().f1377d, 1, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet6 = i(c.a.BOTTOM).a;
                        if (hashSet6 != null) {
                            Iterator<c> it11 = hashSet6.iterator();
                            while (it11.hasNext()) {
                                m.e.Y(it11.next().f1377d, 1, arrayList10, null);
                            }
                        }
                        HashSet<c> hashSet7 = i(aVar19).a;
                        if (hashSet7 != null) {
                            Iterator<c> it12 = hashSet7.iterator();
                            while (it12.hasNext()) {
                                m.e.Y(it12.next().f1377d, 1, arrayList10, null);
                            }
                        }
                        char c3 = 1;
                        if (arrayList9 != null) {
                            Iterator it13 = arrayList9.iterator();
                            while (it13.hasNext()) {
                                m.e.Y((d) it13.next(), 1, arrayList10, null);
                            }
                        }
                        int i26 = 0;
                        while (i26 < size3) {
                            d dVar12 = arrayList3.get(i26);
                            d.a[] aVarArr2 = dVar12.T;
                            if (aVarArr2[0] == aVar21 && aVarArr2[c3] == aVar21) {
                                n Z = m.e.Z(arrayList10, dVar12.o0);
                                n Z2 = m.e.Z(arrayList10, dVar12.p0);
                                if (!(Z == null || Z2 == null)) {
                                    Z.d(0, Z2);
                                    Z2.c = 2;
                                    arrayList10.remove(Z);
                                }
                            }
                            i26++;
                            aVar21 = aVar21;
                            c3 = 1;
                        }
                        int i27 = 1;
                        if (arrayList10.size() <= 1) {
                            aVar4 = aVar12;
                        } else {
                            aVar4 = aVar12;
                            if (m() == aVar4) {
                                Iterator<n> it14 = arrayList10.iterator();
                                nVar = null;
                                int i28 = 0;
                                while (it14.hasNext()) {
                                    n next = it14.next();
                                    if (next.c != i27 && (c2 = next.c(this.w0, 0)) > i28) {
                                        i28 = c2;
                                        nVar = next;
                                    }
                                    i27 = 1;
                                }
                                if (nVar != null) {
                                    this.T[0] = aVar2;
                                    N(i28);
                                    if (q() == aVar4) {
                                        Iterator<n> it15 = arrayList10.iterator();
                                        nVar2 = null;
                                        int i29 = 0;
                                        while (it15.hasNext()) {
                                            n next2 = it15.next();
                                            if (next2.c != 0 && (c = next2.c(this.w0, 1)) > i29) {
                                                nVar2 = next2;
                                                i29 = c;
                                            }
                                        }
                                        if (nVar2 != null) {
                                            this.T[1] = aVar2;
                                            I(i29);
                                            if (nVar == null || nVar2 != null) {
                                                z7 = true;
                                            }
                                        }
                                    }
                                    nVar2 = null;
                                    if (nVar == null) {
                                    }
                                    z7 = true;
                                }
                            }
                            nVar = null;
                            if (q() == aVar4) {
                            }
                            nVar2 = null;
                            if (nVar == null) {
                            }
                            z7 = true;
                        }
                    }
                }
                if (z7) {
                    aVar5 = aVar7;
                    if (aVar5 == aVar4) {
                        i10 = i2;
                        if (i10 >= r() || i10 <= 0) {
                            i6 = r();
                            aVar3 = aVar6;
                            if (aVar3 != aVar4) {
                                i5 = i3;
                                if (i5 >= l() || i5 <= 0) {
                                    i5 = l();
                                } else {
                                    I(i5);
                                    this.F0 = true;
                                }
                            } else {
                                i5 = i3;
                            }
                            z = true;
                            boolean z14 = !a0(64) || a0(128);
                            dVar = this.w0;
                            Objects.requireNonNull(dVar);
                            dVar.f1344g = false;
                            if (this.D0 != 0 && z14) {
                                dVar.f1344g = true;
                            }
                            ArrayList<d> arrayList11 = this.q0;
                            boolean z15 = m() != aVar4 || q() == aVar4;
                            this.z0 = 0;
                            this.A0 = 0;
                            for (i7 = 0; i7 < i4; i7++) {
                                d dVar13 = this.q0.get(i7);
                                if (dVar13 instanceof k) {
                                    ((k) dVar13).Q();
                                }
                            }
                            boolean a0 = a0(64);
                            z2 = z;
                            int i30 = 0;
                            z3 = true;
                            while (z3) {
                                int i31 = i30 + 1;
                                try {
                                    this.w0.u();
                                    this.z0 = 0;
                                    this.A0 = 0;
                                    g(this.w0);
                                    for (int i32 = 0; i32 < i4; i32++) {
                                        this.q0.get(i32).g(this.w0);
                                    }
                                    S(this.w0);
                                    try {
                                        WeakReference<c> weakReference = this.G0;
                                        if (weakReference == null || weakReference.get() == null) {
                                            z4 = z2;
                                        } else {
                                            z4 = z2;
                                            try {
                                                this.w0.f(this.w0.l(this.G0.get()), this.w0.l(this.J), 0, 5);
                                                this.G0 = null;
                                            } catch (Exception e3) {
                                                e2 = e3;
                                                z3 = true;
                                                e2.printStackTrace();
                                                PrintStream printStream = System.out;
                                                printStream.println("EXCEPTION : " + e2);
                                                if (z3) {
                                                }
                                                if (z15) {
                                                }
                                                z6 = z15;
                                                max = Math.max(this.c0, r());
                                                if (max > r()) {
                                                }
                                                max2 = Math.max(this.d0, l());
                                                if (max2 > l()) {
                                                }
                                                if (!z4) {
                                                }
                                                z2 = z4;
                                                i8 = 8;
                                                if (i31 <= i8) {
                                                }
                                                i30 = i31;
                                                z15 = z6;
                                            }
                                        }
                                        WeakReference<c> weakReference2 = this.I0;
                                        if (!(weakReference2 == null || weakReference2.get() == null)) {
                                            this.w0.f(this.w0.l(this.L), this.w0.l(this.I0.get()), 0, 5);
                                            this.I0 = null;
                                        }
                                        WeakReference<c> weakReference3 = this.H0;
                                        if (!(weakReference3 == null || weakReference3.get() == null)) {
                                            this.w0.f(this.w0.l(this.H0.get()), this.w0.l(this.I), 0, 5);
                                            this.H0 = null;
                                        }
                                        WeakReference<c> weakReference4 = this.J0;
                                        if (weakReference4 != null && weakReference4.get() != null) {
                                            this.w0.f(this.w0.l(this.K), this.w0.l(this.J0.get()), 0, 5);
                                            try {
                                                this.J0 = null;
                                            } catch (Exception e4) {
                                                e2 = e4;
                                                z3 = true;
                                                e2.printStackTrace();
                                                PrintStream printStream2 = System.out;
                                                printStream2.println("EXCEPTION : " + e2);
                                                if (z3) {
                                                }
                                                if (z15) {
                                                }
                                                z6 = z15;
                                                max = Math.max(this.c0, r());
                                                if (max > r()) {
                                                }
                                                max2 = Math.max(this.d0, l());
                                                if (max2 > l()) {
                                                }
                                                if (!z4) {
                                                }
                                                z2 = z4;
                                                i8 = 8;
                                                if (i31 <= i8) {
                                                }
                                                i30 = i31;
                                                z15 = z6;
                                            }
                                        }
                                        this.w0.q();
                                        z3 = true;
                                    } catch (Exception e5) {
                                        e2 = e5;
                                        z4 = z2;
                                    }
                                } catch (Exception e6) {
                                    e2 = e6;
                                    z4 = z2;
                                }
                                if (z3) {
                                    e.h.a.d dVar14 = this.w0;
                                    i.a[2] = false;
                                    boolean a02 = a0(64);
                                    P(dVar14, a02);
                                    int size4 = this.q0.size();
                                    int i33 = 0;
                                    z5 = false;
                                    while (i33 < size4) {
                                        d dVar15 = this.q0.get(i33);
                                        dVar15.P(dVar14, a02);
                                        if ((dVar15.f1395h == -1 && dVar15.f1396i == -1) ? false : true) {
                                            z5 = true;
                                        }
                                        i33++;
                                        size4 = size4;
                                        dVar14 = dVar14;
                                        a02 = a02;
                                    }
                                } else {
                                    P(this.w0, a0);
                                    for (int i34 = 0; i34 < i4; i34++) {
                                        this.q0.get(i34).P(this.w0, a0);
                                    }
                                    z5 = false;
                                }
                                if (z15 || i31 >= 8 || !i.a[2]) {
                                    z6 = z15;
                                } else {
                                    int i35 = 0;
                                    int i36 = 0;
                                    int i37 = 0;
                                    while (i35 < i4) {
                                        d dVar16 = this.q0.get(i35);
                                        i36 = Math.max(i36, dVar16.r() + dVar16.Z);
                                        i37 = Math.max(i37, dVar16.l() + dVar16.a0);
                                        i35++;
                                        z15 = z15;
                                    }
                                    z6 = z15;
                                    int max5 = Math.max(this.c0, i36);
                                    int max6 = Math.max(this.d0, i37);
                                    if (aVar5 == aVar4 && r() < max5) {
                                        N(max5);
                                        this.T[0] = aVar4;
                                        z5 = true;
                                        z4 = true;
                                    }
                                    if (aVar3 == aVar4 && l() < max6) {
                                        I(max6);
                                        this.T[1] = aVar4;
                                        z5 = true;
                                        z4 = true;
                                    }
                                }
                                max = Math.max(this.c0, r());
                                if (max > r()) {
                                    N(max);
                                    this.T[0] = aVar2;
                                    z5 = true;
                                    z4 = true;
                                }
                                max2 = Math.max(this.d0, l());
                                if (max2 > l()) {
                                    I(max2);
                                    r3 = 1;
                                    this.T[1] = aVar2;
                                    z5 = true;
                                    z4 = true;
                                } else {
                                    r3 = 1;
                                }
                                if (!z4) {
                                    if (this.T[0] == aVar4 && i6 > 0 && r() > i6) {
                                        this.E0 = r3;
                                        this.T[0] = aVar2;
                                        N(i6);
                                        z5 = true;
                                        z4 = true;
                                    }
                                    d.a[] aVarArr3 = this.T;
                                    char c4 = r3 == true ? 1 : 0;
                                    char c5 = r3 == true ? 1 : 0;
                                    char c6 = r3 == true ? 1 : 0;
                                    if (aVarArr3[c4] == aVar4 && i5 > 0 && l() > i5) {
                                        this.F0 = r3;
                                        this.T[r3] = aVar2;
                                        I(i5);
                                        i8 = 8;
                                        z2 = true;
                                        z5 = true;
                                        z3 = i31 <= i8 ? false : z5;
                                        i30 = i31;
                                        z15 = z6;
                                    }
                                }
                                z2 = z4;
                                i8 = 8;
                                if (i31 <= i8) {
                                }
                                i30 = i31;
                                z15 = z6;
                            }
                            this.q0 = arrayList11;
                            if (z2) {
                                d.a[] aVarArr4 = this.T;
                                aVarArr4[0] = aVar5;
                                aVarArr4[1] = aVar3;
                            }
                            E(this.w0.f1349l);
                        }
                        N(i10);
                        this.E0 = true;
                    } else {
                        i10 = i2;
                    }
                    i6 = i10;
                    aVar3 = aVar6;
                    if (aVar3 != aVar4) {
                    }
                    z = true;
                    if (!a0(64)) {
                    }
                    dVar = this.w0;
                    Objects.requireNonNull(dVar);
                    dVar.f1344g = false;
                    if (this.D0 != 0) {
                        dVar.f1344g = true;
                    }
                    ArrayList<d> arrayList112 = this.q0;
                    if (m() != aVar4) {
                    }
                    this.z0 = 0;
                    this.A0 = 0;
                    while (i7 < i4) {
                    }
                    boolean a03 = a0(64);
                    z2 = z;
                    int i302 = 0;
                    z3 = true;
                    while (z3) {
                    }
                    this.q0 = arrayList112;
                    if (z2) {
                    }
                    E(this.w0.f1349l);
                }
                i5 = i3;
                i9 = i2;
                aVar5 = aVar7;
                aVar3 = aVar6;
            } else {
                aVar4 = aVar12;
                aVar2 = aVar13;
                i4 = size;
                aVar3 = aVar18;
                aVar5 = aVar15;
                i5 = i3;
                i9 = i2;
            }
        } else {
            aVar4 = aVar12;
            aVar2 = aVar13;
            i4 = size;
            aVar5 = aVar15;
            i5 = i3;
            i9 = i2;
            aVar3 = aVar;
        }
        i6 = i9;
        z = false;
        if (!a0(64)) {
        }
        dVar = this.w0;
        Objects.requireNonNull(dVar);
        dVar.f1344g = false;
        if (this.D0 != 0) {
        }
        ArrayList<d> arrayList1122 = this.q0;
        if (m() != aVar4) {
        }
        this.z0 = 0;
        this.A0 = 0;
        while (i7 < i4) {
        }
        boolean a032 = a0(64);
        z2 = z;
        int i3022 = 0;
        z3 = true;
        while (z3) {
        }
        this.q0 = arrayList1122;
        if (z2) {
        }
        E(this.w0.f1349l);
    }

    public void R(d dVar, int i2) {
        if (i2 == 0) {
            int i3 = this.z0 + 1;
            b[] bVarArr = this.C0;
            if (i3 >= bVarArr.length) {
                this.C0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.C0;
            int i4 = this.z0;
            bVarArr2[i4] = new b(dVar, 0, this.v0);
            this.z0 = i4 + 1;
        } else if (i2 == 1) {
            int i5 = this.A0 + 1;
            b[] bVarArr3 = this.B0;
            if (i5 >= bVarArr3.length) {
                this.B0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.B0;
            int i6 = this.A0;
            bVarArr4[i6] = new b(dVar, 1, this.v0);
            this.A0 = i6 + 1;
        }
    }

    public boolean S(e.h.a.d dVar) {
        boolean z;
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.WRAP_CONTENT;
        boolean a0 = a0(64);
        d(dVar, a0);
        int size = this.q0.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar2 = this.q0.get(i2);
            boolean[] zArr = dVar2.S;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar2 instanceof a) {
                z2 = true;
            }
        }
        if (z2) {
            for (int i3 = 0; i3 < size; i3++) {
                d dVar3 = this.q0.get(i3);
                if (dVar3 instanceof a) {
                    a aVar3 = (a) dVar3;
                    for (int i4 = 0; i4 < aVar3.r0; i4++) {
                        d dVar4 = aVar3.q0[i4];
                        if (aVar3.t0 || dVar4.e()) {
                            int i5 = aVar3.s0;
                            if (i5 == 0 || i5 == 1) {
                                dVar4.S[0] = true;
                            } else if (i5 == 2 || i5 == 3) {
                                dVar4.S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        this.K0.clear();
        for (int i6 = 0; i6 < size; i6++) {
            d dVar5 = this.q0.get(i6);
            if (dVar5.c()) {
                if (dVar5 instanceof j) {
                    this.K0.add(dVar5);
                } else {
                    dVar5.d(dVar, a0);
                }
            }
        }
        while (this.K0.size() > 0) {
            int size2 = this.K0.size();
            Iterator<d> it = this.K0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j jVar = (j) it.next();
                HashSet<d> hashSet = this.K0;
                int i7 = 0;
                while (true) {
                    if (i7 >= jVar.r0) {
                        z = false;
                        continue;
                        break;
                    } else if (hashSet.contains(jVar.q0[i7])) {
                        z = true;
                        continue;
                        break;
                    } else {
                        i7++;
                    }
                }
                if (z) {
                    jVar.d(dVar, a0);
                    this.K0.remove(jVar);
                    break;
                }
            }
            if (size2 == this.K0.size()) {
                Iterator<d> it2 = this.K0.iterator();
                while (it2.hasNext()) {
                    it2.next().d(dVar, a0);
                }
                this.K0.clear();
            }
        }
        if (e.h.a.d.p) {
            HashSet<d> hashSet2 = new HashSet<>();
            for (int i8 = 0; i8 < size; i8++) {
                d dVar6 = this.q0.get(i8);
                if (!dVar6.c()) {
                    hashSet2.add(dVar6);
                }
            }
            b(this, dVar, hashSet2, m() == aVar2 ? 0 : 1, false);
            Iterator<d> it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                d next = it3.next();
                i.a(this, dVar, next);
                next.d(dVar, a0);
            }
        } else {
            for (int i9 = 0; i9 < size; i9++) {
                d dVar7 = this.q0.get(i9);
                if (dVar7 instanceof e) {
                    d.a[] aVarArr = dVar7.T;
                    d.a aVar4 = aVarArr[0];
                    d.a aVar5 = aVarArr[1];
                    if (aVar4 == aVar2) {
                        aVarArr[0] = aVar;
                    }
                    if (aVar5 == aVar2) {
                        aVarArr[1] = aVar;
                    }
                    dVar7.d(dVar, a0);
                    if (aVar4 == aVar2) {
                        dVar7.J(aVar4);
                    }
                    if (aVar5 == aVar2) {
                        dVar7.M(aVar5);
                    }
                } else {
                    i.a(this, dVar, dVar7);
                    if (!dVar7.c()) {
                        dVar7.d(dVar, a0);
                    }
                }
            }
        }
        if (this.z0 > 0) {
            m.e.b(this, dVar, null, 0);
        }
        if (this.A0 > 0) {
            m.e.b(this, dVar, null, 1);
        }
        return true;
    }

    public void T(c cVar) {
        WeakReference<c> weakReference = this.J0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.J0.get().c()) {
            this.J0 = new WeakReference<>(cVar);
        }
    }

    public void U(c cVar) {
        WeakReference<c> weakReference = this.H0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.H0.get().c()) {
            this.H0 = new WeakReference<>(cVar);
        }
    }

    public void V(c cVar) {
        WeakReference<c> weakReference = this.I0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.I0.get().c()) {
            this.I0 = new WeakReference<>(cVar);
        }
    }

    public void W(c cVar) {
        WeakReference<c> weakReference = this.G0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.G0.get().c()) {
            this.G0 = new WeakReference<>(cVar);
        }
    }

    public boolean X(boolean z, int i2) {
        boolean z2;
        int i3;
        g gVar;
        int i4;
        g gVar2;
        e.h.a.i.l.e eVar = this.s0;
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
            Iterator<o> it = eVar.f1413e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next.f1441f == i2 && !next.k()) {
                    z4 = false;
                    break;
                }
            }
            if (i2 == 0) {
                if (z4 && k2 == aVar2) {
                    e eVar2 = eVar.a;
                    eVar2.T[0] = aVar3;
                    eVar2.N(eVar.d(eVar2, 0));
                    e eVar3 = eVar.a;
                    gVar2 = eVar3.f1391d.f1440e;
                    i4 = eVar3.r();
                    gVar2.c(i4);
                }
            } else if (z4 && k3 == aVar2) {
                e eVar4 = eVar.a;
                eVar4.T[1] = aVar3;
                eVar4.I(eVar.d(eVar4, 1));
                e eVar5 = eVar.a;
                gVar2 = eVar5.f1392e.f1440e;
                i4 = eVar5.l();
                gVar2.c(i4);
            }
        }
        e eVar6 = eVar.a;
        d.a[] aVarArr = eVar6.T;
        if (i2 == 0) {
            if (aVarArr[0] == aVar3 || aVarArr[0] == aVar) {
                int r = eVar6.r() + s;
                eVar.a.f1391d.f1444i.c(r);
                gVar = eVar.a.f1391d.f1440e;
                i3 = r - s;
                gVar.c(i3);
                z2 = true;
            }
            z2 = false;
        } else {
            if (aVarArr[1] == aVar3 || aVarArr[1] == aVar) {
                int l2 = eVar6.l() + t;
                eVar.a.f1392e.f1444i.c(l2);
                gVar = eVar.a.f1392e.f1440e;
                i3 = l2 - t;
                gVar.c(i3);
                z2 = true;
            }
            z2 = false;
        }
        eVar.g();
        Iterator<o> it2 = eVar.f1413e.iterator();
        while (it2.hasNext()) {
            o next2 = it2.next();
            if (next2.f1441f == i2 && (next2.b != eVar.a || next2.f1442g)) {
                next2.e();
            }
        }
        Iterator<o> it3 = eVar.f1413e.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.f1441f == i2 && (z2 || next3.b != eVar.a)) {
                if (!next3.f1443h.f1423j || !next3.f1444i.f1423j || (!(next3 instanceof e.h.a.i.l.c) && !next3.f1440e.f1423j)) {
                    z3 = false;
                    break;
                }
            }
        }
        eVar.a.J(k2);
        eVar.a.M(k3);
        return z3;
    }

    public void Y() {
        this.s0.b = true;
    }

    public boolean a0(int i2) {
        return (this.D0 & i2) == i2;
    }

    public void b0(int i2) {
        this.D0 = i2;
        e.h.a.d.p = a0(512);
    }
}
