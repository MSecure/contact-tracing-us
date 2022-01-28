package b.g.a.h;

import b.g.a.b;
import b.g.a.e;
import b.g.a.g;
import b.g.a.h.d;
import java.util.ArrayList;

public class a extends h {
    public int l0 = 0;
    public ArrayList<j> m0 = new ArrayList<>(4);
    public boolean n0 = true;

    @Override // b.g.a.h.d
    public void a(e eVar) {
        Object[] objArr;
        boolean z;
        c cVar;
        g gVar;
        int i;
        int i2;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        d.a aVar2 = d.a.WRAP_CONTENT;
        c[] cVarArr = this.A;
        cVarArr[0] = this.s;
        cVarArr[2] = this.t;
        cVarArr[1] = this.u;
        cVarArr[3] = this.v;
        int i3 = 0;
        while (true) {
            objArr = this.A;
            if (i3 >= objArr.length) {
                break;
            }
            objArr[i3].i = eVar.l(objArr[i3]);
            i3++;
        }
        int i4 = this.l0;
        if (i4 >= 0 && i4 < 4) {
            c cVar2 = objArr[i4];
            int i5 = 0;
            while (true) {
                if (i5 >= this.k0) {
                    z = false;
                    break;
                }
                d dVar = this.j0[i5];
                if ((this.n0 || dVar.b()) && ((((i = this.l0) == 0 || i == 1) && dVar.i() == aVar) || (((i2 = this.l0) == 2 || i2 == 3) && dVar.m() == aVar))) {
                    z = true;
                } else {
                    i5++;
                }
            }
            int i6 = this.l0;
            if (i6 == 0 || i6 == 1 ? this.D.i() == aVar2 : this.D.m() == aVar2) {
                z = false;
            }
            for (int i7 = 0; i7 < this.k0; i7++) {
                d dVar2 = this.j0[i7];
                if (this.n0 || dVar2.b()) {
                    g l = eVar.l(dVar2.A[this.l0]);
                    c[] cVarArr2 = dVar2.A;
                    int i8 = this.l0;
                    cVarArr2[i8].i = l;
                    if (i8 == 0 || i8 == 2) {
                        g gVar2 = cVar2.i;
                        b m = eVar.m();
                        g n = eVar.n();
                        n.f886d = 0;
                        m.e(gVar2, l, n, 0);
                        if (z) {
                            m.f871d.h(eVar.k(1, null), (float) ((int) (m.f871d.c(n) * -1.0f)));
                        }
                        eVar.c(m);
                    } else {
                        g gVar3 = cVar2.i;
                        b m2 = eVar.m();
                        g n2 = eVar.n();
                        n2.f886d = 0;
                        m2.d(gVar3, l, n2, 0);
                        if (z) {
                            m2.f871d.h(eVar.k(1, null), (float) ((int) (m2.f871d.c(n2) * -1.0f)));
                        }
                        eVar.c(m2);
                    }
                }
            }
            int i9 = this.l0;
            if (i9 == 0) {
                eVar.d(this.u.i, this.s.i, 0, 6);
                if (!z) {
                    gVar = this.s.i;
                    cVar = this.D.u;
                } else {
                    return;
                }
            } else if (i9 == 1) {
                eVar.d(this.s.i, this.u.i, 0, 6);
                if (!z) {
                    gVar = this.s.i;
                    cVar = this.D.s;
                } else {
                    return;
                }
            } else if (i9 == 2) {
                eVar.d(this.v.i, this.t.i, 0, 6);
                if (!z) {
                    gVar = this.t.i;
                    cVar = this.D.v;
                } else {
                    return;
                }
            } else if (i9 == 3) {
                eVar.d(this.t.i, this.v.i, 0, 6);
                if (!z) {
                    gVar = this.t.i;
                    cVar = this.D.t;
                } else {
                    return;
                }
            } else {
                return;
            }
            eVar.d(gVar, cVar.i, 0, 5);
        }
    }

    @Override // b.g.a.h.d
    public boolean b() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d A[SYNTHETIC] */
    @Override // b.g.a.h.d
    public void c(int i) {
        c cVar;
        c cVar2;
        j jVar;
        c cVar3;
        d dVar = this.D;
        if (dVar != null && ((e) dVar).I(2)) {
            int i2 = this.l0;
            if (i2 == 0) {
                cVar = this.s;
            } else if (i2 == 1) {
                cVar = this.u;
            } else if (i2 == 2) {
                cVar = this.t;
            } else if (i2 == 3) {
                cVar = this.v;
            } else {
                return;
            }
            j jVar2 = cVar.f897a;
            jVar2.h = 5;
            int i3 = this.l0;
            if (i3 == 0 || i3 == 1) {
                this.t.f897a.j(null, 0.0f);
                cVar2 = this.v;
            } else {
                this.s.f897a.j(null, 0.0f);
                cVar2 = this.u;
            }
            cVar2.f897a.j(null, 0.0f);
            this.m0.clear();
            for (int i4 = 0; i4 < this.k0; i4++) {
                d dVar2 = this.j0[i4];
                if (this.n0 || dVar2.b()) {
                    int i5 = this.l0;
                    if (i5 == 0) {
                        cVar3 = dVar2.s;
                    } else if (i5 == 1) {
                        cVar3 = dVar2.u;
                    } else if (i5 == 2) {
                        cVar3 = dVar2.t;
                    } else if (i5 != 3) {
                        jVar = null;
                        if (jVar == null) {
                            this.m0.add(jVar);
                            jVar.f929a.add(jVar2);
                        }
                    } else {
                        cVar3 = dVar2.v;
                    }
                    jVar = cVar3.f897a;
                    if (jVar == null) {
                    }
                }
            }
        }
    }

    @Override // b.g.a.h.d
    public void s() {
        super.s();
        this.m0.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    @Override // b.g.a.h.d
    public void u() {
        j jVar;
        int size;
        int i;
        int i2;
        c cVar;
        float f;
        c cVar2;
        c cVar3;
        int i3 = this.l0;
        float f2 = Float.MAX_VALUE;
        if (i3 != 0) {
            if (i3 == 1) {
                cVar3 = this.u;
            } else if (i3 == 2) {
                cVar2 = this.t;
            } else if (i3 == 3) {
                cVar3 = this.v;
            } else {
                return;
            }
            jVar = cVar3.f897a;
            f2 = 0.0f;
            size = this.m0.size();
            j jVar2 = null;
            for (i = 0; i < size; i++) {
                j jVar3 = this.m0.get(i);
                if (jVar3.f930b == 1) {
                    int i4 = this.l0;
                    if (i4 == 0 || i4 == 2) {
                        f = jVar3.g;
                        if (f >= f2) {
                        }
                    } else {
                        f = jVar3.g;
                        if (f <= f2) {
                        }
                    }
                    jVar2 = jVar3.f;
                    f2 = f;
                } else {
                    return;
                }
            }
            jVar.f = jVar2;
            jVar.g = f2;
            jVar.a();
            i2 = this.l0;
            if (i2 != 0) {
                cVar = this.u;
            } else if (i2 == 1) {
                cVar = this.s;
            } else if (i2 == 2) {
                cVar = this.v;
            } else if (i2 == 3) {
                cVar = this.t;
            } else {
                return;
            }
            cVar.f897a.j(jVar2, f2);
        }
        cVar2 = this.s;
        jVar = cVar2.f897a;
        size = this.m0.size();
        j jVar22 = null;
        while (i < size) {
        }
        jVar.f = jVar22;
        jVar.g = f2;
        jVar.a();
        i2 = this.l0;
        if (i2 != 0) {
        }
        cVar.f897a.j(jVar22, f2);
    }
}
