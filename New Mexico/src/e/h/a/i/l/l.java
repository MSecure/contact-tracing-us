package e.h.a.i.l;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    public static int c;
    public o a;
    public ArrayList<o> b = new ArrayList<>();

    public l(o oVar, int i2) {
        this.a = null;
        c++;
        this.a = oVar;
    }

    public final long a(f fVar, long j2) {
        o oVar = fVar.f1417d;
        if (oVar instanceof j) {
            return j2;
        }
        int size = fVar.f1424k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f1424k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1417d != oVar) {
                    j3 = Math.min(j3, a(fVar2, ((long) fVar2.f1419f) + j2));
                }
            }
        }
        if (fVar != oVar.f1444i) {
            return j3;
        }
        long j4 = j2 - oVar.j();
        return Math.min(Math.min(j3, a(oVar.f1443h, j4)), j4 - ((long) oVar.f1443h.f1419f));
    }

    public final long b(f fVar, long j2) {
        o oVar = fVar.f1417d;
        if (oVar instanceof j) {
            return j2;
        }
        int size = fVar.f1424k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f1424k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1417d != oVar) {
                    j3 = Math.max(j3, b(fVar2, ((long) fVar2.f1419f) + j2));
                }
            }
        }
        if (fVar != oVar.f1443h) {
            return j3;
        }
        long j4 = j2 + oVar.j();
        return Math.max(Math.max(j3, b(oVar.f1444i, j4)), j4 - ((long) oVar.f1444i.f1419f));
    }
}
