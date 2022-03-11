package e.g.b.h;

import e.g.b.c;
import java.util.ArrayList;

public class k extends d {
    public ArrayList<d> l0 = new ArrayList<>();

    @Override // e.g.b.h.d
    public void B() {
        this.l0.clear();
        super.B();
    }

    @Override // e.g.b.h.d
    public void D(c cVar) {
        super.D(cVar);
        int size = this.l0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.l0.get(i2).D(cVar);
        }
    }

    public void P() {
        ArrayList<d> arrayList = this.l0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = this.l0.get(i2);
                if (dVar instanceof k) {
                    ((k) dVar).P();
                }
            }
        }
    }
}
