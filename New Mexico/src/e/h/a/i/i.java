package e.h.a.i;

import e.h.a.d;
import e.h.a.i.d;
/* loaded from: classes.dex */
public class i {
    public static boolean[] a = new boolean[3];

    public static void a(e eVar, d dVar, d dVar2) {
        d.a aVar = d.a.MATCH_PARENT;
        dVar2.n = -1;
        dVar2.o = -1;
        d.a aVar2 = eVar.T[0];
        d.a aVar3 = d.a.WRAP_CONTENT;
        if (aVar2 != aVar3 && dVar2.T[0] == aVar) {
            int i2 = dVar2.I.f1380g;
            int r = eVar.r() - dVar2.K.f1380g;
            c cVar = dVar2.I;
            cVar.f1382i = dVar.l(cVar);
            c cVar2 = dVar2.K;
            cVar2.f1382i = dVar.l(cVar2);
            dVar.e(dVar2.I.f1382i, i2);
            dVar.e(dVar2.K.f1382i, r);
            dVar2.n = 2;
            dVar2.Z = i2;
            int i3 = r - i2;
            dVar2.V = i3;
            int i4 = dVar2.c0;
            if (i3 < i4) {
                dVar2.V = i4;
            }
        }
        if (eVar.T[1] != aVar3 && dVar2.T[1] == aVar) {
            int i5 = dVar2.J.f1380g;
            int l2 = eVar.l() - dVar2.L.f1380g;
            c cVar3 = dVar2.J;
            cVar3.f1382i = dVar.l(cVar3);
            c cVar4 = dVar2.L;
            cVar4.f1382i = dVar.l(cVar4);
            dVar.e(dVar2.J.f1382i, i5);
            dVar.e(dVar2.L.f1382i, l2);
            if (dVar2.b0 > 0 || dVar2.h0 == 8) {
                c cVar5 = dVar2.M;
                cVar5.f1382i = dVar.l(cVar5);
                dVar.e(dVar2.M.f1382i, dVar2.b0 + i5);
            }
            dVar2.o = 2;
            dVar2.a0 = i5;
            int i6 = l2 - i5;
            dVar2.W = i6;
            int i7 = dVar2.d0;
            if (i6 < i7) {
                dVar2.W = i7;
            }
        }
    }

    public static final boolean b(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
