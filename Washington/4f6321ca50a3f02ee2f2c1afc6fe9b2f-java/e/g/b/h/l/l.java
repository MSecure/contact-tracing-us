package e.g.b.h.l;

import java.util.ArrayList;

public class l {
    public static int c;
    public o a = null;
    public ArrayList<o> b = new ArrayList<>();

    public l(o oVar, int i2) {
        c++;
        this.a = oVar;
    }

    public final long a(f fVar, long j2) {
        o oVar = fVar.f1299d;
        if (oVar instanceof j) {
            return j2;
        }
        int size = fVar.f1306k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f1306k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1299d != oVar) {
                    j3 = Math.min(j3, a(fVar2, ((long) fVar2.f1301f) + j2));
                }
            }
        }
        if (fVar != oVar.f1326i) {
            return j3;
        }
        long j4 = j2 - oVar.j();
        return Math.min(Math.min(j3, a(oVar.f1325h, j4)), j4 - ((long) oVar.f1325h.f1301f));
    }

    public final long b(f fVar, long j2) {
        o oVar = fVar.f1299d;
        if (oVar instanceof j) {
            return j2;
        }
        int size = fVar.f1306k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f1306k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1299d != oVar) {
                    j3 = Math.max(j3, b(fVar2, ((long) fVar2.f1301f) + j2));
                }
            }
        }
        if (fVar != oVar.f1325h) {
            return j3;
        }
        long j4 = j2 + oVar.j();
        return Math.max(Math.max(j3, b(oVar.f1326i, j4)), j4 - ((long) oVar.f1326i.f1301f));
    }
}
