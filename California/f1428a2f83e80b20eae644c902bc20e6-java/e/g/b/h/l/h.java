package e.g.b.h.l;

import e.g.b.h.c;
import e.g.b.h.d;
import e.g.b.h.e;
import e.g.b.h.f;
import e.g.b.h.l.b;
import java.util.HashSet;
import java.util.Iterator;

public class h {
    public static b.a a = new b.a();

    public static boolean a(d dVar) {
        d.a aVar = d.a.MATCH_CONSTRAINT;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        d.a m = dVar.m();
        d.a q = dVar.q();
        d dVar2 = dVar.P;
        e eVar = dVar2 != null ? (e) dVar2 : null;
        if (eVar != null) {
            eVar.m();
        }
        if (eVar != null) {
            eVar.q();
        }
        boolean z = m == aVar3 || m == aVar2 || (m == aVar && dVar.f1282l == 0 && dVar.S == 0.0f && dVar.u(0)) || dVar.z();
        boolean z2 = q == aVar3 || q == aVar2 || (q == aVar && dVar.m == 0 && dVar.S == 0.0f && dVar.u(1)) || dVar.A();
        if (dVar.S <= 0.0f || (!z && !z2)) {
            return z && z2;
        }
        return true;
    }

    public static void b(d dVar, b.AbstractC0028b bVar, boolean z) {
        HashSet<c> hashSet;
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        if (!(dVar instanceof e) && dVar.y() && a(dVar)) {
            e.X(dVar, bVar, new b.a(), 0);
        }
        c i2 = dVar.i(c.a.LEFT);
        c i3 = dVar.i(c.a.RIGHT);
        int c = i2.c();
        int c2 = i3.c();
        HashSet<c> hashSet2 = i2.a;
        if (hashSet2 != null && i2.c) {
            Iterator<c> it = hashSet2.iterator();
            while (it.hasNext()) {
                c next = it.next();
                d dVar2 = next.f1260d;
                boolean a2 = a(dVar2);
                if (dVar2.y() && a2) {
                    e.X(dVar2, bVar, new b.a(), 0);
                }
                if (dVar2.m() != aVar || a2) {
                    if (!dVar2.y()) {
                        c cVar6 = dVar2.D;
                        if (next == cVar6 && dVar2.F.f1262f == null) {
                            int d2 = cVar6.d() + c;
                            dVar2.F(d2, dVar2.r() + d2);
                        } else {
                            c cVar7 = dVar2.F;
                            if (next == cVar7 && cVar6.f1262f == null) {
                                int d3 = c - cVar7.d();
                                dVar2.F(d3 - dVar2.r(), d3);
                            } else if (next == cVar6 && (cVar3 = cVar7.f1262f) != null && cVar3.c && !dVar2.w()) {
                                c(bVar, dVar2, z);
                            }
                        }
                        b(dVar2, bVar, z);
                    }
                } else if (dVar2.m() == aVar && dVar2.p >= 0 && dVar2.o >= 0) {
                    if ((dVar2.c0 == 8 || (dVar2.f1282l == 0 && dVar2.S == 0.0f)) && !dVar2.w() && !dVar2.A) {
                        c cVar8 = dVar2.D;
                        if (((next == cVar8 && (cVar5 = dVar2.F.f1262f) != null && cVar5.c) || (next == dVar2.F && (cVar4 = cVar8.f1262f) != null && cVar4.c)) && !dVar2.w()) {
                            d(dVar, bVar, dVar2, z);
                        }
                    }
                }
            }
        }
        if (!(dVar instanceof f) && (hashSet = i3.a) != null && i3.c) {
            Iterator<c> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                c next2 = it2.next();
                d dVar3 = next2.f1260d;
                boolean a3 = a(dVar3);
                if (dVar3.y() && a3) {
                    e.X(dVar3, bVar, new b.a(), 0);
                }
                c cVar9 = dVar3.D;
                boolean z2 = (next2 == cVar9 && (cVar2 = dVar3.F.f1262f) != null && cVar2.c) || (next2 == dVar3.F && (cVar = cVar9.f1262f) != null && cVar.c);
                if (dVar3.m() != aVar || a3) {
                    if (!dVar3.y()) {
                        c cVar10 = dVar3.D;
                        if (next2 == cVar10 && dVar3.F.f1262f == null) {
                            int d4 = cVar10.d() + c2;
                            dVar3.F(d4, dVar3.r() + d4);
                        } else {
                            c cVar11 = dVar3.F;
                            if (next2 == cVar11 && cVar10.f1262f == null) {
                                int d5 = c2 - cVar11.d();
                                dVar3.F(d5 - dVar3.r(), d5);
                            } else if (z2 && !dVar3.w()) {
                                c(bVar, dVar3, z);
                            }
                        }
                        b(dVar3, bVar, z);
                    }
                } else if (dVar3.m() == aVar && dVar3.p >= 0 && dVar3.o >= 0) {
                    if ((dVar3.c0 == 8 || (dVar3.f1282l == 0 && dVar3.S == 0.0f)) && !dVar3.w() && !dVar3.A && z2 && !dVar3.w()) {
                        d(dVar, bVar, dVar3, z);
                    }
                }
            }
        }
    }

    public static void c(b.AbstractC0028b bVar, d dVar, boolean z) {
        float f2 = dVar.Z;
        int c = dVar.D.f1262f.c();
        int c2 = dVar.F.f1262f.c();
        int d2 = dVar.D.d() + c;
        int d3 = c2 - dVar.F.d();
        if (c == c2) {
            f2 = 0.5f;
        } else {
            c = d2;
            c2 = d3;
        }
        int r = dVar.r();
        int i2 = (c2 - c) - r;
        if (c > c2) {
            i2 = (c - c2) - r;
        }
        int i3 = ((int) ((f2 * ((float) i2)) + 0.5f)) + c;
        int i4 = i3 + r;
        if (c > c2) {
            i4 = i3 - r;
        }
        dVar.F(i3, i4);
        b(dVar, bVar, z);
    }

    public static void d(d dVar, b.AbstractC0028b bVar, d dVar2, boolean z) {
        float f2 = dVar2.Z;
        int d2 = dVar2.D.d() + dVar2.D.f1262f.c();
        int c = dVar2.F.f1262f.c() - dVar2.F.d();
        if (c >= d2) {
            int r = dVar2.r();
            if (dVar2.c0 != 8) {
                int i2 = dVar2.f1282l;
                if (i2 == 2) {
                    if (!(dVar instanceof e)) {
                        dVar = dVar.P;
                    }
                    r = (int) (dVar2.Z * 0.5f * ((float) dVar.r()));
                } else if (i2 == 0) {
                    r = c - d2;
                }
                r = Math.max(dVar2.o, r);
                int i3 = dVar2.p;
                if (i3 > 0) {
                    r = Math.min(i3, r);
                }
            }
            int i4 = d2 + ((int) ((f2 * ((float) ((c - d2) - r))) + 0.5f));
            dVar2.F(i4, r + i4);
            b(dVar2, bVar, z);
        }
    }

    public static void e(b.AbstractC0028b bVar, d dVar) {
        float f2 = dVar.a0;
        int c = dVar.E.f1262f.c();
        int c2 = dVar.G.f1262f.c();
        int d2 = dVar.E.d() + c;
        int d3 = c2 - dVar.G.d();
        if (c == c2) {
            f2 = 0.5f;
        } else {
            c = d2;
            c2 = d3;
        }
        int l2 = dVar.l();
        int i2 = (c2 - c) - l2;
        if (c > c2) {
            i2 = (c - c2) - l2;
        }
        int i3 = (int) ((f2 * ((float) i2)) + 0.5f);
        int i4 = c + i3;
        int i5 = i4 + l2;
        if (c > c2) {
            i4 = c - i3;
            i5 = i4 - l2;
        }
        dVar.G(i4, i5);
        g(dVar, bVar);
    }

    public static void f(d dVar, b.AbstractC0028b bVar, d dVar2) {
        float f2 = dVar2.a0;
        int d2 = dVar2.E.d() + dVar2.E.f1262f.c();
        int c = dVar2.G.f1262f.c() - dVar2.G.d();
        if (c >= d2) {
            int l2 = dVar2.l();
            if (dVar2.c0 != 8) {
                int i2 = dVar2.m;
                if (i2 == 2) {
                    if (!(dVar instanceof e)) {
                        dVar = dVar.P;
                    }
                    l2 = (int) (f2 * 0.5f * ((float) dVar.l()));
                } else if (i2 == 0) {
                    l2 = c - d2;
                }
                l2 = Math.max(dVar2.r, l2);
                int i3 = dVar2.s;
                if (i3 > 0) {
                    l2 = Math.min(i3, l2);
                }
            }
            int i4 = d2 + ((int) ((f2 * ((float) ((c - d2) - l2))) + 0.5f));
            dVar2.G(i4, l2 + i4);
            g(dVar2, bVar);
        }
    }

    public static void g(d dVar, b.AbstractC0028b bVar) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        if (!(dVar instanceof e) && dVar.y() && a(dVar)) {
            e.X(dVar, bVar, new b.a(), 0);
        }
        c i2 = dVar.i(c.a.TOP);
        c i3 = dVar.i(c.a.BOTTOM);
        int c = i2.c();
        int c2 = i3.c();
        HashSet<c> hashSet = i2.a;
        if (hashSet != null && i2.c) {
            Iterator<c> it = hashSet.iterator();
            while (it.hasNext()) {
                c next = it.next();
                d dVar2 = next.f1260d;
                boolean a2 = a(dVar2);
                if (dVar2.y() && a2) {
                    e.X(dVar2, bVar, new b.a(), 0);
                }
                if (dVar2.q() != aVar || a2) {
                    if (!dVar2.y()) {
                        c cVar6 = dVar2.E;
                        if (next == cVar6 && dVar2.G.f1262f == null) {
                            int d2 = cVar6.d() + c;
                            dVar2.G(d2, dVar2.l() + d2);
                        } else {
                            c cVar7 = dVar2.G;
                            if (next == cVar7 && cVar7.f1262f == null) {
                                int d3 = c - cVar7.d();
                                dVar2.G(d3 - dVar2.l(), d3);
                            } else if (next == cVar6 && (cVar3 = cVar7.f1262f) != null && cVar3.c) {
                                e(bVar, dVar2);
                            }
                        }
                        g(dVar2, bVar);
                    }
                } else if (dVar2.q() == aVar && dVar2.s >= 0 && dVar2.r >= 0) {
                    if ((dVar2.c0 == 8 || (dVar2.m == 0 && dVar2.S == 0.0f)) && !dVar2.x() && !dVar2.A) {
                        c cVar8 = dVar2.E;
                        if (((next == cVar8 && (cVar5 = dVar2.G.f1262f) != null && cVar5.c) || (next == dVar2.G && (cVar4 = cVar8.f1262f) != null && cVar4.c)) && !dVar2.x()) {
                            f(dVar, bVar, dVar2);
                        }
                    }
                }
            }
        }
        if (!(dVar instanceof f)) {
            HashSet<c> hashSet2 = i3.a;
            if (hashSet2 != null && i3.c) {
                Iterator<c> it2 = hashSet2.iterator();
                while (it2.hasNext()) {
                    c next2 = it2.next();
                    d dVar3 = next2.f1260d;
                    boolean a3 = a(dVar3);
                    if (dVar3.y() && a3) {
                        e.X(dVar3, bVar, new b.a(), 0);
                    }
                    c cVar9 = dVar3.E;
                    boolean z = (next2 == cVar9 && (cVar2 = dVar3.G.f1262f) != null && cVar2.c) || (next2 == dVar3.G && (cVar = cVar9.f1262f) != null && cVar.c);
                    if (dVar3.q() != aVar || a3) {
                        if (!dVar3.y()) {
                            c cVar10 = dVar3.E;
                            if (next2 == cVar10 && dVar3.G.f1262f == null) {
                                int d4 = cVar10.d() + c2;
                                dVar3.G(d4, dVar3.l() + d4);
                            } else {
                                c cVar11 = dVar3.G;
                                if (next2 == cVar11 && cVar10.f1262f == null) {
                                    int d5 = c2 - cVar11.d();
                                    dVar3.G(d5 - dVar3.l(), d5);
                                } else if (z && !dVar3.x()) {
                                    e(bVar, dVar3);
                                }
                            }
                            g(dVar3, bVar);
                        }
                    } else if (dVar3.q() == aVar && dVar3.s >= 0 && dVar3.r >= 0) {
                        if ((dVar3.c0 == 8 || (dVar3.m == 0 && dVar3.S == 0.0f)) && !dVar3.x() && !dVar3.A && z && !dVar3.x()) {
                            f(dVar, bVar, dVar3);
                        }
                    }
                }
            }
            c i4 = dVar.i(c.a.BASELINE);
            if (i4.a != null && i4.c) {
                int c3 = i4.c();
                Iterator<c> it3 = i4.a.iterator();
                while (it3.hasNext()) {
                    c next3 = it3.next();
                    d dVar4 = next3.f1260d;
                    boolean a4 = a(dVar4);
                    if (dVar4.y() && a4) {
                        e.X(dVar4, bVar, new b.a(), 0);
                    }
                    if ((dVar4.q() != aVar || a4) && !dVar4.y() && next3 == dVar4.H) {
                        if (dVar4.y) {
                            int i5 = c3 - dVar4.W;
                            int i6 = dVar4.R + i5;
                            dVar4.V = i5;
                            dVar4.E.j(i5);
                            dVar4.G.j(i6);
                            c cVar12 = dVar4.H;
                            cVar12.b = c3;
                            cVar12.c = true;
                            dVar4.f1279i = true;
                        }
                        g(dVar4, bVar);
                    }
                }
            }
        }
    }
}
