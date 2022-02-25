package e.g.b.h.l;

import e.g.b.h.a;
import e.g.b.h.d;
import e.g.b.h.l.f;

public class j extends o {
    public j(d dVar) {
        super(dVar);
    }

    @Override // e.g.b.h.l.o, e.g.b.h.l.d
    public void a(d dVar) {
        a aVar = (a) this.b;
        int i2 = aVar.n0;
        int i3 = 0;
        int i4 = -1;
        for (f fVar : this.f1326h.f1308l) {
            int i5 = fVar.f1303g;
            if (i4 == -1 || i5 < i4) {
                i4 = i5;
            }
            if (i3 < i5) {
                i3 = i5;
            }
        }
        if (i2 == 0 || i2 == 2) {
            this.f1326h.c(i4 + aVar.p0);
        } else {
            this.f1326h.c(i3 + aVar.p0);
        }
    }

    @Override // e.g.b.h.l.o
    public void d() {
        o oVar;
        d dVar = this.b;
        if (dVar instanceof a) {
            f fVar = this.f1326h;
            fVar.b = true;
            a aVar = (a) dVar;
            int i2 = aVar.n0;
            boolean z = aVar.o0;
            int i3 = 0;
            if (i2 == 0) {
                fVar.f1301e = f.a.LEFT;
                while (i3 < aVar.m0) {
                    d dVar2 = aVar.l0[i3];
                    if (z || dVar2.c0 != 8) {
                        f fVar2 = dVar2.f1274d.f1326h;
                        fVar2.f1307k.add(this.f1326h);
                        this.f1326h.f1308l.add(fVar2);
                    }
                    i3++;
                }
            } else if (i2 != 1) {
                if (i2 == 2) {
                    fVar.f1301e = f.a.TOP;
                    while (i3 < aVar.m0) {
                        d dVar3 = aVar.l0[i3];
                        if (z || dVar3.c0 != 8) {
                            f fVar3 = dVar3.f1275e.f1326h;
                            fVar3.f1307k.add(this.f1326h);
                            this.f1326h.f1308l.add(fVar3);
                        }
                        i3++;
                    }
                } else if (i2 == 3) {
                    fVar.f1301e = f.a.BOTTOM;
                    while (i3 < aVar.m0) {
                        d dVar4 = aVar.l0[i3];
                        if (z || dVar4.c0 != 8) {
                            f fVar4 = dVar4.f1275e.f1327i;
                            fVar4.f1307k.add(this.f1326h);
                            this.f1326h.f1308l.add(fVar4);
                        }
                        i3++;
                    }
                } else {
                    return;
                }
                m(this.b.f1275e.f1326h);
                oVar = this.b.f1275e;
                m(oVar.f1327i);
            } else {
                fVar.f1301e = f.a.RIGHT;
                while (i3 < aVar.m0) {
                    d dVar5 = aVar.l0[i3];
                    if (z || dVar5.c0 != 8) {
                        f fVar5 = dVar5.f1274d.f1327i;
                        fVar5.f1307k.add(this.f1326h);
                        this.f1326h.f1308l.add(fVar5);
                    }
                    i3++;
                }
            }
            m(this.b.f1274d.f1326h);
            oVar = this.b.f1274d;
            m(oVar.f1327i);
        }
    }

    @Override // e.g.b.h.l.o
    public void e() {
        d dVar = this.b;
        if (dVar instanceof a) {
            int i2 = ((a) dVar).n0;
            if (i2 == 0 || i2 == 1) {
                dVar.U = this.f1326h.f1303g;
            } else {
                dVar.V = this.f1326h.f1303g;
            }
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.c = null;
        this.f1326h.b();
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.f1326h.f1307k.add(fVar);
        fVar.f1308l.add(this.f1326h);
    }
}
