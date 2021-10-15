package b.g.b.h;

import b.g.b.b;
import b.g.b.d;
import b.g.b.g;
import b.g.b.h.c;
import b.g.b.h.d;

public class f extends d {
    public float d0 = -1.0f;
    public int e0 = -1;
    public int f0 = -1;
    public c g0 = this.y;
    public int h0;

    public f() {
        this.h0 = 0;
        this.G.clear();
        this.G.add(this.g0);
        int length = this.F.length;
        for (int i = 0; i < length; i++) {
            this.F[i] = this.g0;
        }
    }

    @Override // b.g.b.h.d
    public void D(d dVar) {
        if (this.I != null) {
            int o = dVar.o(this.g0);
            if (this.h0 == 1) {
                this.N = o;
                this.O = 0;
                w(this.I.i());
                B(0);
                return;
            }
            this.N = 0;
            this.O = o;
            B(this.I.o());
            w(0);
        }
    }

    public void E(int i) {
        if (this.h0 != i) {
            this.h0 = i;
            this.G.clear();
            this.g0 = this.h0 == 1 ? this.x : this.y;
            this.G.add(this.g0);
            int length = this.F.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.F[i2] = this.g0;
            }
        }
    }

    @Override // b.g.b.h.d
    public void b(d dVar) {
        d.a aVar = d.a.WRAP_CONTENT;
        e eVar = (e) this.I;
        if (eVar != null) {
            c f2 = eVar.f(c.a.LEFT);
            c f3 = eVar.f(c.a.RIGHT);
            d dVar2 = this.I;
            boolean z = true;
            boolean z2 = dVar2 != null && dVar2.H[0] == aVar;
            if (this.h0 == 0) {
                f2 = eVar.f(c.a.TOP);
                f3 = eVar.f(c.a.BOTTOM);
                d dVar3 = this.I;
                if (dVar3 == null || dVar3.H[1] != aVar) {
                    z = false;
                }
                z2 = z;
            }
            if (this.e0 != -1) {
                g l = dVar.l(this.g0);
                dVar.d(l, dVar.l(f2), this.e0, 7);
                if (z2) {
                    dVar.f(dVar.l(f3), l, 0, 5);
                }
            } else if (this.f0 != -1) {
                g l2 = dVar.l(this.g0);
                g l3 = dVar.l(f3);
                dVar.d(l2, l3, -this.f0, 7);
                if (z2) {
                    dVar.f(l2, dVar.l(f2), 0, 5);
                    dVar.f(l3, l2, 0, 5);
                }
            } else if (this.d0 != -1.0f) {
                g l4 = dVar.l(this.g0);
                g l5 = dVar.l(f3);
                float f4 = this.d0;
                b m = dVar.m();
                m.f1461d.h(l4, -1.0f);
                m.f1461d.h(l5, f4);
                dVar.c(m);
            }
        }
    }

    @Override // b.g.b.h.d
    public boolean c() {
        return true;
    }

    @Override // b.g.b.h.d
    public c f(c.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.h0 == 1) {
                    return this.g0;
                }
                break;
            case 2:
            case 4:
                if (this.h0 == 0) {
                    return this.g0;
                }
                break;
        }
        throw new AssertionError(aVar.name());
    }
}
