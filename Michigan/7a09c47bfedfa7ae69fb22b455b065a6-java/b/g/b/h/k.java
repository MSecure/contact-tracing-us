package b.g.b.h;

import b.g.b.c;
import java.util.ArrayList;

public class k extends d {
    public ArrayList<d> d0 = new ArrayList<>();

    public void E() {
        ArrayList<d> arrayList = this.d0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.d0.get(i);
                if (dVar instanceof k) {
                    ((k) dVar).E();
                }
            }
        }
    }

    @Override // b.g.b.h.d
    public void u() {
        this.d0.clear();
        super.u();
    }

    @Override // b.g.b.h.d
    public void v(c cVar) {
        super.v(cVar);
        int size = this.d0.size();
        for (int i = 0; i < size; i++) {
            this.d0.get(i).v(cVar);
        }
    }
}
