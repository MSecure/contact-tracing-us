package e.g.a.i;

import e.g.a.c;
import java.util.ArrayList;

public class k extends d {
    public ArrayList<d> q0 = new ArrayList<>();

    @Override // e.g.a.i.d
    public void C() {
        this.q0.clear();
        super.C();
    }

    @Override // e.g.a.i.d
    public void E(c cVar) {
        super.E(cVar);
        int size = this.q0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.q0.get(i2).E(cVar);
        }
    }

    public void Q() {
        ArrayList<d> arrayList = this.q0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = this.q0.get(i2);
                if (dVar instanceof k) {
                    ((k) dVar).Q();
                }
            }
        }
    }
}
