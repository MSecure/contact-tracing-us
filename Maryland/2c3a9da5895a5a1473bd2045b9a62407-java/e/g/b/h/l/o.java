package e.g.b.h.l;

import e.g.b.h.c;
import e.g.b.h.d;

public abstract class o implements d {
    public int a;
    public d b;
    public l c;

    /* renamed from: d  reason: collision with root package name */
    public d.a f1334d;

    /* renamed from: e  reason: collision with root package name */
    public g f1335e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f1336f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1337g = false;

    /* renamed from: h  reason: collision with root package name */
    public f f1338h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public f f1339i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    public a f1340j = a.NONE;

    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public o(d dVar) {
        this.b = dVar;
    }

    @Override // e.g.b.h.l.d
    public void a(d dVar) {
    }

    public final void b(f fVar, f fVar2, int i2) {
        fVar.f1320l.add(fVar2);
        fVar.f1314f = i2;
        fVar2.f1319k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i2, g gVar) {
        fVar.f1320l.add(fVar2);
        fVar.f1320l.add(this.f1335e);
        fVar.f1316h = i2;
        fVar.f1317i = gVar;
        fVar2.f1319k.add(fVar);
        gVar.f1319k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            d dVar = this.b;
            int i5 = dVar.p;
            i4 = Math.max(dVar.o, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            d dVar2 = this.b;
            int i6 = dVar2.s;
            i4 = Math.max(dVar2.r, i2);
            if (i6 > 0) {
                i4 = Math.min(i6, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        }
        return i4;
    }

    public final f h(c cVar) {
        o oVar;
        o oVar2;
        c cVar2 = cVar.f1274f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1272d;
        int ordinal = cVar2.f1273e.ordinal();
        if (ordinal == 1) {
            oVar = dVar.f1286d;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                oVar2 = dVar.f1286d;
            } else if (ordinal == 4) {
                oVar2 = dVar.f1287e;
            } else if (ordinal != 5) {
                return null;
            } else {
                return dVar.f1287e.f1329k;
            }
            return oVar2.f1339i;
        } else {
            oVar = dVar.f1287e;
        }
        return oVar.f1338h;
    }

    public final f i(c cVar, int i2) {
        c cVar2 = cVar.f1274f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1272d;
        o oVar = i2 == 0 ? dVar.f1286d : dVar.f1287e;
        int ordinal = cVar2.f1273e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return oVar.f1338h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return oVar.f1339i;
        }
        return null;
    }

    public long j() {
        g gVar = this.f1335e;
        if (gVar.f1318j) {
            return (long) gVar.f1315g;
        }
        return 0;
    }

    public abstract boolean k();

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r14.a == 3) goto L_0x00b5;
     */
    public void l(c cVar, c cVar2, int i2) {
        float f2;
        d.a aVar;
        int i3;
        int i4;
        f h2 = h(cVar);
        f h3 = h(cVar2);
        if (h2.f1318j && h3.f1318j) {
            int d2 = cVar.d() + h2.f1315g;
            int d3 = h3.f1315g - cVar2.d();
            int i5 = d3 - d2;
            g gVar = this.f1335e;
            if (!gVar.f1318j && this.f1334d == (aVar = d.a.MATCH_CONSTRAINT)) {
                int i6 = this.a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        int g2 = g(gVar.m, i2);
                        g gVar2 = this.f1335e;
                        i3 = Math.min(g2, i5);
                        gVar = gVar2;
                    } else if (i6 == 2) {
                        d dVar = this.b;
                        d dVar2 = dVar.P;
                        if (dVar2 != null) {
                            g gVar3 = (i2 == 0 ? dVar2.f1286d : dVar2.f1287e).f1335e;
                            if (gVar3.f1318j) {
                                i4 = (int) ((((float) gVar3.f1315g) * (i2 == 0 ? dVar.q : dVar.t)) + 0.5f);
                            }
                        }
                    } else if (i6 == 3) {
                        d dVar3 = this.b;
                        o oVar = dVar3.f1286d;
                        if (oVar.f1334d == aVar && oVar.a == 3) {
                            m mVar = dVar3.f1287e;
                            if (mVar.f1334d == aVar) {
                            }
                        }
                        if (i2 == 0) {
                            oVar = dVar3.f1287e;
                        }
                        g gVar4 = oVar.f1335e;
                        if (gVar4.f1318j) {
                            float f3 = dVar3.S;
                            i3 = i2 == 1 ? (int) ((((float) gVar4.f1315g) / f3) + 0.5f) : (int) ((f3 * ((float) gVar4.f1315g)) + 0.5f);
                        }
                    }
                    gVar.c(i3);
                } else {
                    i4 = i5;
                }
                i3 = g(i4, i2);
                gVar.c(i3);
            }
            g gVar5 = this.f1335e;
            if (gVar5.f1318j) {
                int i7 = gVar5.f1315g;
                if (i7 == i5) {
                    this.f1338h.c(d2);
                    this.f1339i.c(d3);
                    return;
                }
                if (i2 == 0) {
                    f2 = this.b.Z;
                } else {
                    f2 = this.b.a0;
                }
                if (h2 == h3) {
                    d2 = h2.f1315g;
                    d3 = h3.f1315g;
                    f2 = 0.5f;
                }
                this.f1338h.c((int) ((((float) ((d3 - d2) - i7)) * f2) + ((float) d2) + 0.5f));
                this.f1339i.c(this.f1338h.f1315g + this.f1335e.f1315g);
            }
        }
    }
}
