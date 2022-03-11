package e.h.a.i.l;

import e.h.a.i.l.f;
/* loaded from: classes.dex */
public class g extends f {
    public int m;

    public g(o oVar) {
        super(oVar);
        this.f1418e = oVar instanceof k ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // e.h.a.i.l.f
    public void c(int i2) {
        if (!this.f1423j) {
            this.f1423j = true;
            this.f1420g = i2;
            for (d dVar : this.f1424k) {
                dVar.a(dVar);
            }
        }
    }
}
