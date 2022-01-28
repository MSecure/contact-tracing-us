package e.g.a.i.l;

import e.g.a.i.c;
import e.g.a.i.d;

public abstract class o implements d {
    public int a;
    public d b;
    public l c;

    /* renamed from: d  reason: collision with root package name */
    public d.a f1355d;

    /* renamed from: e  reason: collision with root package name */
    public g f1356e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f1357f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1358g = false;

    /* renamed from: h  reason: collision with root package name */
    public f f1359h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public f f1360i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    public a f1361j = a.NONE;

    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public o(d dVar) {
        this.b = dVar;
    }

    @Override // e.g.a.i.l.d
    public void a(d dVar) {
    }

    public final void b(f fVar, f fVar2, int i2) {
        fVar.f1341l.add(fVar2);
        fVar.f1335f = i2;
        fVar2.f1340k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i2, g gVar) {
        fVar.f1341l.add(fVar2);
        fVar.f1341l.add(this.f1356e);
        fVar.f1337h = i2;
        fVar.f1338i = gVar;
        fVar2.f1340k.add(fVar);
        gVar.f1340k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            d dVar = this.b;
            int i5 = dVar.u;
            i4 = Math.max(dVar.t, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            d dVar2 = this.b;
            int i6 = dVar2.x;
            i4 = Math.max(dVar2.w, i2);
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
        c cVar2 = cVar.f1295f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1293d;
        int ordinal = cVar2.f1294e.ordinal();
        if (ordinal == 1) {
            oVar = dVar.f1307d;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                oVar2 = dVar.f1307d;
            } else if (ordinal == 4) {
                oVar2 = dVar.f1308e;
            } else if (ordinal != 5) {
                return null;
            } else {
                return dVar.f1308e.f1350k;
            }
            return oVar2.f1360i;
        } else {
            oVar = dVar.f1308e;
        }
        return oVar.f1359h;
    }

    public final f i(c cVar, int i2) {
        c cVar2 = cVar.f1295f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1293d;
        o oVar = i2 == 0 ? dVar.f1307d : dVar.f1308e;
        int ordinal = cVar2.f1294e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return oVar.f1359h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return oVar.f1360i;
        }
        return null;
    }

    public long j() {
        g gVar = this.f1356e;
        if (gVar.f1339j) {
            return (long) gVar.f1336g;
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
        if (h2.f1339j && h3.f1339j) {
            int d2 = cVar.d() + h2.f1336g;
            int d3 = h3.f1336g - cVar2.d();
            int i5 = d3 - d2;
            g gVar = this.f1356e;
            if (!gVar.f1339j && this.f1355d == (aVar = d.a.MATCH_CONSTRAINT)) {
                int i6 = this.a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        int g2 = g(gVar.m, i2);
                        g gVar2 = this.f1356e;
                        i3 = Math.min(g2, i5);
                        gVar = gVar2;
                    } else if (i6 == 2) {
                        d dVar = this.b;
                        d dVar2 = dVar.U;
                        if (dVar2 != null) {
                            g gVar3 = (i2 == 0 ? dVar2.f1307d : dVar2.f1308e).f1356e;
                            if (gVar3.f1339j) {
                                i4 = (int) ((((float) gVar3.f1336g) * (i2 == 0 ? dVar.v : dVar.y)) + 0.5f);
                            }
                        }
                    } else if (i6 == 3) {
                        d dVar3 = this.b;
                        o oVar = dVar3.f1307d;
                        if (oVar.f1355d == aVar && oVar.a == 3) {
                            m mVar = dVar3.f1308e;
                            if (mVar.f1355d == aVar) {
                            }
                        }
                        if (i2 == 0) {
                            oVar = dVar3.f1308e;
                        }
                        g gVar4 = oVar.f1356e;
                        if (gVar4.f1339j) {
                            float f3 = dVar3.X;
                            i3 = i2 == 1 ? (int) ((((float) gVar4.f1336g) / f3) + 0.5f) : (int) ((f3 * ((float) gVar4.f1336g)) + 0.5f);
                        }
                    }
                    gVar.c(i3);
                } else {
                    i4 = i5;
                }
                i3 = g(i4, i2);
                gVar.c(i3);
            }
            g gVar5 = this.f1356e;
            if (gVar5.f1339j) {
                int i7 = gVar5.f1336g;
                if (i7 == i5) {
                    this.f1359h.c(d2);
                    this.f1360i.c(d3);
                    return;
                }
                if (i2 == 0) {
                    f2 = this.b.e0;
                } else {
                    f2 = this.b.f0;
                }
                if (h2 == h3) {
                    d2 = h2.f1336g;
                    d3 = h3.f1336g;
                    f2 = 0.5f;
                }
                this.f1359h.c((int) ((((float) ((d3 - d2) - i7)) * f2) + ((float) d2) + 0.5f));
                this.f1360i.c(this.f1359h.f1336g + this.f1356e.f1336g);
            }
        }
    }
}
