package e.h.a.i.l;

import e.h.a.i.a;
import e.h.a.i.d;
import e.h.a.i.l.f;
/* loaded from: classes.dex */
public class j extends o {
    public j(d dVar) {
        super(dVar);
    }

    @Override // e.h.a.i.l.o, e.h.a.i.l.d
    public void a(d dVar) {
        a aVar = (a) this.b;
        int i2 = aVar.s0;
        int i3 = 0;
        int i4 = -1;
        for (f fVar : this.f1443h.f1425l) {
            int i5 = fVar.f1420g;
            if (i4 == -1 || i5 < i4) {
                i4 = i5;
            }
            if (i3 < i5) {
                i3 = i5;
            }
        }
        if (i2 == 0 || i2 == 2) {
            this.f1443h.c(i4 + aVar.u0);
        } else {
            this.f1443h.c(i3 + aVar.u0);
        }
    }

    @Override // e.h.a.i.l.o
    public void d() {
        o oVar;
        d dVar = this.b;
        if (dVar instanceof a) {
            f fVar = this.f1443h;
            fVar.b = true;
            a aVar = (a) dVar;
            int i2 = aVar.s0;
            boolean z = aVar.t0;
            int i3 = 0;
            if (i2 == 0) {
                fVar.f1418e = f.a.LEFT;
                while (i3 < aVar.r0) {
                    d dVar2 = aVar.q0[i3];
                    if (z || dVar2.h0 != 8) {
                        f fVar2 = dVar2.f1391d.f1443h;
                        fVar2.f1424k.add(this.f1443h);
                        this.f1443h.f1425l.add(fVar2);
                    }
                    i3++;
                }
            } else if (i2 != 1) {
                if (i2 == 2) {
                    fVar.f1418e = f.a.TOP;
                    while (i3 < aVar.r0) {
                        d dVar3 = aVar.q0[i3];
                        if (z || dVar3.h0 != 8) {
                            f fVar3 = dVar3.f1392e.f1443h;
                            fVar3.f1424k.add(this.f1443h);
                            this.f1443h.f1425l.add(fVar3);
                        }
                        i3++;
                    }
                } else if (i2 == 3) {
                    fVar.f1418e = f.a.BOTTOM;
                    while (i3 < aVar.r0) {
                        d dVar4 = aVar.q0[i3];
                        if (z || dVar4.h0 != 8) {
                            f fVar4 = dVar4.f1392e.f1444i;
                            fVar4.f1424k.add(this.f1443h);
                            this.f1443h.f1425l.add(fVar4);
                        }
                        i3++;
                    }
                } else {
                    return;
                }
                m(this.b.f1392e.f1443h);
                oVar = this.b.f1392e;
                m(oVar.f1444i);
            } else {
                fVar.f1418e = f.a.RIGHT;
                while (i3 < aVar.r0) {
                    d dVar5 = aVar.q0[i3];
                    if (z || dVar5.h0 != 8) {
                        f fVar5 = dVar5.f1391d.f1444i;
                        fVar5.f1424k.add(this.f1443h);
                        this.f1443h.f1425l.add(fVar5);
                    }
                    i3++;
                }
            }
            m(this.b.f1391d.f1443h);
            oVar = this.b.f1391d;
            m(oVar.f1444i);
        }
    }

    @Override // e.h.a.i.l.o
    public void e() {
        d dVar = this.b;
        if (dVar instanceof a) {
            int i2 = ((a) dVar).s0;
            if (i2 == 0 || i2 == 1) {
                dVar.Z = this.f1443h.f1420g;
            } else {
                dVar.a0 = this.f1443h.f1420g;
            }
        }
    }

    @Override // e.h.a.i.l.o
    public void f() {
        this.c = null;
        this.f1443h.b();
    }

    @Override // e.h.a.i.l.o
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.f1443h.f1424k.add(fVar);
        fVar.f1425l.add(this.f1443h);
    }
}
