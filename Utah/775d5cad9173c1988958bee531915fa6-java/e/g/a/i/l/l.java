package e.g.a.i.l;

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
        o oVar = fVar.f1333d;
        if (oVar instanceof j) {
            return j2;
        }
        int size = fVar.f1340k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f1340k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1333d != oVar) {
                    j3 = Math.min(j3, a(fVar2, ((long) fVar2.f1335f) + j2));
                }
            }
        }
        if (fVar != oVar.f1360i) {
            return j3;
        }
        long j4 = j2 - oVar.j();
        return Math.min(Math.min(j3, a(oVar.f1359h, j4)), j4 - ((long) oVar.f1359h.f1335f));
    }

    public final long b(f fVar, long j2) {
        o oVar = fVar.f1333d;
        if (oVar instanceof j) {
            return j2;
        }
        int size = fVar.f1340k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f1340k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1333d != oVar) {
                    j3 = Math.max(j3, b(fVar2, ((long) fVar2.f1335f) + j2));
                }
            }
        }
        if (fVar != oVar.f1359h) {
            return j3;
        }
        long j4 = j2 + oVar.j();
        return Math.max(Math.max(j3, b(oVar.f1360i, j4)), j4 - ((long) oVar.f1360i.f1335f));
    }
}
