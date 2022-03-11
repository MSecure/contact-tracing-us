package e.h.a.i.l;

import e.h.a.i.d;
import e.h.a.i.f;
/* loaded from: classes.dex */
public class i extends o {
    public i(d dVar) {
        super(dVar);
        dVar.f1391d.f();
        dVar.f1392e.f();
        this.f1441f = ((f) dVar).u0;
    }

    @Override // e.h.a.i.l.o, e.h.a.i.l.d
    public void a(d dVar) {
        f fVar = this.f1443h;
        if (fVar.c && !fVar.f1423j) {
            this.f1443h.c((int) ((((float) fVar.f1425l.get(0).f1420g) * ((f) this.b).q0) + 0.5f));
        }
    }

    @Override // e.h.a.i.l.o
    public void d() {
        o oVar;
        d dVar = this.b;
        f fVar = (f) dVar;
        int i2 = fVar.r0;
        int i3 = fVar.s0;
        if (fVar.u0 == 1) {
            f fVar2 = this.f1443h;
            if (i2 != -1) {
                fVar2.f1425l.add(dVar.U.f1391d.f1443h);
                this.b.U.f1391d.f1443h.f1424k.add(this.f1443h);
                this.f1443h.f1419f = i2;
            } else if (i3 != -1) {
                fVar2.f1425l.add(dVar.U.f1391d.f1444i);
                this.b.U.f1391d.f1444i.f1424k.add(this.f1443h);
                this.f1443h.f1419f = -i3;
            } else {
                fVar2.b = true;
                fVar2.f1425l.add(dVar.U.f1391d.f1444i);
                this.b.U.f1391d.f1444i.f1424k.add(this.f1443h);
            }
            m(this.b.f1391d.f1443h);
            oVar = this.b.f1391d;
        } else {
            f fVar3 = this.f1443h;
            if (i2 != -1) {
                fVar3.f1425l.add(dVar.U.f1392e.f1443h);
                this.b.U.f1392e.f1443h.f1424k.add(this.f1443h);
                this.f1443h.f1419f = i2;
            } else if (i3 != -1) {
                fVar3.f1425l.add(dVar.U.f1392e.f1444i);
                this.b.U.f1392e.f1444i.f1424k.add(this.f1443h);
                this.f1443h.f1419f = -i3;
            } else {
                fVar3.b = true;
                fVar3.f1425l.add(dVar.U.f1392e.f1444i);
                this.b.U.f1392e.f1444i.f1424k.add(this.f1443h);
            }
            m(this.b.f1392e.f1443h);
            oVar = this.b.f1392e;
        }
        m(oVar.f1444i);
    }

    @Override // e.h.a.i.l.o
    public void e() {
        d dVar = this.b;
        if (((f) dVar).u0 == 1) {
            dVar.Z = this.f1443h.f1420g;
        } else {
            dVar.a0 = this.f1443h.f1420g;
        }
    }

    @Override // e.h.a.i.l.o
    public void f() {
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
