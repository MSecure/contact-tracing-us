package e.g.b.h;

import e.g.b.d;
import e.g.b.h.d;

public class i {
    public static boolean[] a = new boolean[3];

    public static void a(e eVar, d dVar, d dVar2) {
        d.a aVar = d.a.MATCH_PARENT;
        dVar2.f1279j = -1;
        dVar2.f1280k = -1;
        d.a aVar2 = eVar.O[0];
        d.a aVar3 = d.a.WRAP_CONTENT;
        if (aVar2 != aVar3 && dVar2.O[0] == aVar) {
            int i2 = dVar2.D.f1262g;
            int r = eVar.r() - dVar2.F.f1262g;
            c cVar = dVar2.D;
            cVar.f1264i = dVar.l(cVar);
            c cVar2 = dVar2.F;
            cVar2.f1264i = dVar.l(cVar2);
            dVar.e(dVar2.D.f1264i, i2);
            dVar.e(dVar2.F.f1264i, r);
            dVar2.f1279j = 2;
            dVar2.U = i2;
            int i3 = r - i2;
            dVar2.Q = i3;
            int i4 = dVar2.X;
            if (i3 < i4) {
                dVar2.Q = i4;
            }
        }
        if (eVar.O[1] != aVar3 && dVar2.O[1] == aVar) {
            int i5 = dVar2.E.f1262g;
            int l2 = eVar.l() - dVar2.G.f1262g;
            c cVar3 = dVar2.E;
            cVar3.f1264i = dVar.l(cVar3);
            c cVar4 = dVar2.G;
            cVar4.f1264i = dVar.l(cVar4);
            dVar.e(dVar2.E.f1264i, i5);
            dVar.e(dVar2.G.f1264i, l2);
            if (dVar2.W > 0 || dVar2.c0 == 8) {
                c cVar5 = dVar2.H;
                cVar5.f1264i = dVar.l(cVar5);
                dVar.e(dVar2.H.f1264i, dVar2.W + i5);
            }
            dVar2.f1280k = 2;
            dVar2.V = i5;
            int i6 = l2 - i5;
            dVar2.R = i6;
            int i7 = dVar2.Y;
            if (i6 < i7) {
                dVar2.R = i7;
            }
        }
    }

    public static final boolean b(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
