package b.g.a.h;

import b.g.a.h.d;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static boolean[] f924a = new boolean[3];

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0037 A[RETURN] */
    public static boolean a(d dVar, int i) {
        d.a aVar = d.a.MATCH_CONSTRAINT;
        d.a[] aVarArr = dVar.C;
        if (aVarArr[i] != aVar) {
            return false;
        }
        char c2 = 1;
        if (dVar.G != 0.0f) {
            if (i != 0) {
                c2 = 0;
            }
            d.a aVar2 = aVarArr[c2];
            return false;
        }
        if (i == 0) {
            return dVar.f914e == 0 && dVar.h == 0 && dVar.i == 0;
        }
        if (dVar.f != 0 || dVar.k != 0 || dVar.l != 0) {
            return false;
        }
    }

    public static void b(d dVar, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        c[] cVarArr = dVar.A;
        cVarArr[i3].f897a.f = dVar.D.s.f897a;
        cVarArr[i3].f897a.g = (float) i2;
        cVarArr[i3].f897a.f930b = 1;
        cVarArr[i4].f897a.f = cVarArr[i3].f897a;
        cVarArr[i4].f897a.g = (float) dVar.j(i);
        dVar.A[i4].f897a.f930b = 1;
    }
}
