package b.g.a.h;

import b.g.a.c;
import java.util.ArrayList;

public class n extends d {
    public ArrayList<d> j0 = new ArrayList<>();

    @Override // b.g.a.h.d
    public void D() {
        int i = this.I;
        int i2 = this.J;
        this.M = i;
        this.N = i2;
        ArrayList<d> arrayList = this.j0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                d dVar = this.j0.get(i3);
                dVar.z(this.M + this.O, this.N + this.P);
                if (!(dVar instanceof e)) {
                    dVar.D();
                }
            }
        }
    }

    public void F() {
        D();
        ArrayList<d> arrayList = this.j0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.j0.get(i);
                if (dVar instanceof n) {
                    ((n) dVar).F();
                }
            }
        }
    }

    @Override // b.g.a.h.d
    public void r() {
        this.j0.clear();
        super.r();
    }

    @Override // b.g.a.h.d
    public void t(c cVar) {
        super.t(cVar);
        int size = this.j0.size();
        for (int i = 0; i < size; i++) {
            this.j0.get(i).t(cVar);
        }
    }

    @Override // b.g.a.h.d
    public void z(int i, int i2) {
        this.O = i;
        this.P = i2;
        int size = this.j0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.j0.get(i3).z(this.I + this.O, this.J + this.P);
        }
    }
}
