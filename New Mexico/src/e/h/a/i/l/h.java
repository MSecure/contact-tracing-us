package e.h.a.i.l;

import e.h.a.i.c;
import e.h.a.i.d;
import e.h.a.i.e;
import e.h.a.i.f;
import e.h.a.i.l.b;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h {
    public static b.a a = new b.a();
    public static int b;
    public static int c;

    public static boolean a(d dVar) {
        d.a aVar = d.a.MATCH_CONSTRAINT;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        d.a m = dVar.m();
        d.a q = dVar.q();
        d dVar2 = dVar.U;
        e eVar = dVar2 != null ? (e) dVar2 : null;
        if (eVar != null) {
            eVar.m();
        }
        if (eVar != null) {
            eVar.q();
        }
        boolean z = m == aVar3 || dVar.A() || m == aVar2 || (m == aVar && dVar.q == 0 && dVar.X == 0.0f && dVar.u(0)) || (m == aVar && dVar.q == 1 && dVar.v(0, dVar.r()));
        boolean z2 = q == aVar3 || dVar.B() || q == aVar2 || (q == aVar && dVar.r == 0 && dVar.X == 0.0f && dVar.u(1)) || (m == aVar && dVar.r == 1 && dVar.v(1, dVar.l()));
        if (dVar.X <= 0.0f || (!z && !z2)) {
            return z && z2;
        }
        return true;
    }

    public static void b(int i2, d dVar, b.AbstractC0031b bVar, boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        if (!dVar.f1399l) {
            b++;
            if (!(dVar instanceof e) && dVar.z() && a(dVar)) {
                e.Z(dVar, bVar, new b.a(), 0);
            }
            c i3 = dVar.i(c.a.LEFT);
            c i4 = dVar.i(c.a.RIGHT);
            int c2 = i3.c();
            int c3 = i4.c();
            HashSet<c> hashSet = i3.a;
            float f2 = 0.0f;
            if (hashSet != null && i3.c) {
                Iterator<c> it = hashSet.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    d dVar2 = next.f1377d;
                    int i5 = i2 + 1;
                    boolean a2 = a(dVar2);
                    if (dVar2.z() && a2) {
                        e.Z(dVar2, bVar, new b.a(), 0);
                    }
                    if (dVar2.m() != aVar || a2) {
                        if (!dVar2.z()) {
                            c cVar6 = dVar2.I;
                            if (next == cVar6 && dVar2.K.f1379f == null) {
                                int d2 = cVar6.d() + c2;
                                dVar2.G(d2, dVar2.r() + d2);
                            } else {
                                c cVar7 = dVar2.K;
                                if (next == cVar7 && cVar6.f1379f == null) {
                                    int d3 = c2 - cVar7.d();
                                    dVar2.G(d3 - dVar2.r(), d3);
                                } else if (next == cVar6 && (cVar3 = cVar7.f1379f) != null && cVar3.c && !dVar2.x()) {
                                    c(i5, bVar, dVar2, z);
                                }
                            }
                            b(i5, dVar2, bVar, z);
                        }
                    } else if (dVar2.m() == aVar && dVar2.u >= 0 && dVar2.t >= 0 && ((dVar2.h0 == 8 || (dVar2.q == 0 && dVar2.X == f2)) && !dVar2.x() && !dVar2.F)) {
                        c cVar8 = dVar2.I;
                        if (((next == cVar8 && (cVar5 = dVar2.K.f1379f) != null && cVar5.c) || (next == dVar2.K && (cVar4 = cVar8.f1379f) != null && cVar4.c)) && !dVar2.x()) {
                            d(i5, dVar, bVar, dVar2, z);
                        }
                    }
                    f2 = 0.0f;
                }
            }
            if (!(dVar instanceof f)) {
                HashSet<c> hashSet2 = i4.a;
                if (hashSet2 != null && i4.c) {
                    Iterator<c> it2 = hashSet2.iterator();
                    while (it2.hasNext()) {
                        c next2 = it2.next();
                        d dVar3 = next2.f1377d;
                        int i6 = i2 + 1;
                        boolean a3 = a(dVar3);
                        if (dVar3.z() && a3) {
                            e.Z(dVar3, bVar, new b.a(), 0);
                        }
                        c cVar9 = dVar3.I;
                        boolean z2 = (next2 == cVar9 && (cVar2 = dVar3.K.f1379f) != null && cVar2.c) || (next2 == dVar3.K && (cVar = cVar9.f1379f) != null && cVar.c);
                        if (dVar3.m() != aVar || a3) {
                            if (!dVar3.z()) {
                                c cVar10 = dVar3.I;
                                if (next2 == cVar10 && dVar3.K.f1379f == null) {
                                    int d4 = cVar10.d() + c3;
                                    dVar3.G(d4, dVar3.r() + d4);
                                } else {
                                    c cVar11 = dVar3.K;
                                    if (next2 == cVar11 && cVar10.f1379f == null) {
                                        int d5 = c3 - cVar11.d();
                                        dVar3.G(d5 - dVar3.r(), d5);
                                    } else if (z2 && !dVar3.x()) {
                                        c(i6, bVar, dVar3, z);
                                    }
                                }
                                b(i6, dVar3, bVar, z);
                            }
                        } else if (dVar3.m() == aVar && dVar3.u >= 0 && dVar3.t >= 0) {
                            if (dVar3.h0 != 8) {
                                if (dVar3.q == 0) {
                                    if (dVar3.X == 0.0f) {
                                    }
                                }
                            }
                            if (!dVar3.x() && !dVar3.F && z2 && !dVar3.x()) {
                                d(i6, dVar, bVar, dVar3, z);
                            }
                        }
                    }
                }
                dVar.f1399l = true;
            }
        }
    }

    public static void c(int i2, b.AbstractC0031b bVar, d dVar, boolean z) {
        float f2 = dVar.e0;
        int c2 = dVar.I.f1379f.c();
        int c3 = dVar.K.f1379f.c();
        c2 = dVar.I.d() + c2;
        c3 -= dVar.K.d();
        if (c2 == c3) {
            f2 = 0.5f;
        }
        int r = dVar.r();
        int i3 = (c3 - c2) - r;
        if (c2 > c3) {
            i3 = (c2 - c3) - r;
        }
        int i4 = ((int) (i3 > 0 ? (f2 * ((float) i3)) + 0.5f : f2 * ((float) i3))) + c2;
        int i5 = i4 + r;
        if (c2 > c3) {
            i5 = i4 - r;
        }
        dVar.G(i4, i5);
        b(i2 + 1, dVar, bVar, z);
    }

    public static void d(int i2, d dVar, b.AbstractC0031b bVar, d dVar2, boolean z) {
        float f2 = dVar2.e0;
        int d2 = dVar2.I.d() + dVar2.I.f1379f.c();
        int c2 = dVar2.K.f1379f.c() - dVar2.K.d();
        if (c2 >= d2) {
            int r = dVar2.r();
            if (dVar2.h0 != 8) {
                int i3 = dVar2.q;
                if (i3 == 2) {
                    if (!(dVar instanceof e)) {
                        dVar = dVar.U;
                    }
                    r = (int) (dVar2.e0 * 0.5f * ((float) dVar.r()));
                } else if (i3 == 0) {
                    r = c2 - d2;
                }
                r = Math.max(dVar2.t, r);
                int i4 = dVar2.u;
                if (i4 > 0) {
                    r = Math.min(i4, r);
                }
            }
            int i5 = d2 + ((int) ((f2 * ((float) ((c2 - d2) - r))) + 0.5f));
            dVar2.G(i5, r + i5);
            b(i2 + 1, dVar2, bVar, z);
        }
    }

    public static void e(int i2, b.AbstractC0031b bVar, d dVar) {
        float f2 = dVar.f0;
        int c2 = dVar.J.f1379f.c();
        int c3 = dVar.L.f1379f.c();
        c2 = dVar.J.d() + c2;
        c3 -= dVar.L.d();
        if (c2 == c3) {
            f2 = 0.5f;
        }
        int l2 = dVar.l();
        int i3 = (c3 - c2) - l2;
        if (c2 > c3) {
            i3 = (c2 - c3) - l2;
        }
        int i4 = (int) (i3 > 0 ? (f2 * ((float) i3)) + 0.5f : f2 * ((float) i3));
        int i5 = c2 + i4;
        int i6 = i5 + l2;
        if (c2 > c3) {
            i5 = c2 - i4;
            i6 = i5 - l2;
        }
        dVar.H(i5, i6);
        g(i2 + 1, dVar, bVar);
    }

    public static void f(int i2, d dVar, b.AbstractC0031b bVar, d dVar2) {
        float f2 = dVar2.f0;
        int d2 = dVar2.J.d() + dVar2.J.f1379f.c();
        int c2 = dVar2.L.f1379f.c() - dVar2.L.d();
        if (c2 >= d2) {
            int l2 = dVar2.l();
            if (dVar2.h0 != 8) {
                int i3 = dVar2.r;
                if (i3 == 2) {
                    if (!(dVar instanceof e)) {
                        dVar = dVar.U;
                    }
                    l2 = (int) (f2 * 0.5f * ((float) dVar.l()));
                } else if (i3 == 0) {
                    l2 = c2 - d2;
                }
                l2 = Math.max(dVar2.w, l2);
                int i4 = dVar2.x;
                if (i4 > 0) {
                    l2 = Math.min(i4, l2);
                }
            }
            int i5 = d2 + ((int) ((f2 * ((float) ((c2 - d2) - l2))) + 0.5f));
            dVar2.H(i5, l2 + i5);
            g(i2 + 1, dVar2, bVar);
        }
    }

    public static void g(int i2, d dVar, b.AbstractC0031b bVar) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        if (!dVar.m) {
            c++;
            if (!(dVar instanceof e) && dVar.z() && a(dVar)) {
                e.Z(dVar, bVar, new b.a(), 0);
            }
            c i3 = dVar.i(c.a.TOP);
            c i4 = dVar.i(c.a.BOTTOM);
            int c2 = i3.c();
            int c3 = i4.c();
            HashSet<c> hashSet = i3.a;
            if (hashSet != null && i3.c) {
                Iterator<c> it = hashSet.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    d dVar2 = next.f1377d;
                    int i5 = i2 + 1;
                    boolean a2 = a(dVar2);
                    if (dVar2.z() && a2) {
                        e.Z(dVar2, bVar, new b.a(), 0);
                    }
                    if (dVar2.q() != aVar || a2) {
                        if (!dVar2.z()) {
                            c cVar6 = dVar2.J;
                            if (next == cVar6 && dVar2.L.f1379f == null) {
                                int d2 = cVar6.d() + c2;
                                dVar2.H(d2, dVar2.l() + d2);
                            } else {
                                c cVar7 = dVar2.L;
                                if (next == cVar7 && cVar7.f1379f == null) {
                                    int d3 = c2 - cVar7.d();
                                    dVar2.H(d3 - dVar2.l(), d3);
                                } else if (next == cVar6 && (cVar3 = cVar7.f1379f) != null && cVar3.c) {
                                    e(i5, bVar, dVar2);
                                }
                            }
                            g(i5, dVar2, bVar);
                        }
                    } else if (dVar2.q() == aVar && dVar2.x >= 0 && dVar2.w >= 0 && ((dVar2.h0 == 8 || (dVar2.r == 0 && dVar2.X == 0.0f)) && !dVar2.y() && !dVar2.F)) {
                        c cVar8 = dVar2.J;
                        if (((next == cVar8 && (cVar5 = dVar2.L.f1379f) != null && cVar5.c) || (next == dVar2.L && (cVar4 = cVar8.f1379f) != null && cVar4.c)) && !dVar2.y()) {
                            f(i5, dVar, bVar, dVar2);
                        }
                    }
                }
            }
            if (!(dVar instanceof f)) {
                HashSet<c> hashSet2 = i4.a;
                if (hashSet2 != null && i4.c) {
                    Iterator<c> it2 = hashSet2.iterator();
                    while (it2.hasNext()) {
                        c next2 = it2.next();
                        d dVar3 = next2.f1377d;
                        int i6 = i2 + 1;
                        boolean a3 = a(dVar3);
                        if (dVar3.z() && a3) {
                            e.Z(dVar3, bVar, new b.a(), 0);
                        }
                        c cVar9 = dVar3.J;
                        boolean z = (next2 == cVar9 && (cVar2 = dVar3.L.f1379f) != null && cVar2.c) || (next2 == dVar3.L && (cVar = cVar9.f1379f) != null && cVar.c);
                        if (dVar3.q() != aVar || a3) {
                            if (!dVar3.z()) {
                                c cVar10 = dVar3.J;
                                if (next2 == cVar10 && dVar3.L.f1379f == null) {
                                    int d4 = cVar10.d() + c3;
                                    dVar3.H(d4, dVar3.l() + d4);
                                } else {
                                    c cVar11 = dVar3.L;
                                    if (next2 == cVar11 && cVar10.f1379f == null) {
                                        int d5 = c3 - cVar11.d();
                                        dVar3.H(d5 - dVar3.l(), d5);
                                    } else if (z && !dVar3.y()) {
                                        e(i6, bVar, dVar3);
                                    }
                                }
                                g(i6, dVar3, bVar);
                            }
                        } else if (dVar3.q() == aVar && dVar3.x >= 0 && dVar3.w >= 0 && (dVar3.h0 == 8 || (dVar3.r == 0 && dVar3.X == 0.0f))) {
                            if (!dVar3.y() && !dVar3.F && z && !dVar3.y()) {
                                f(i6, dVar, bVar, dVar3);
                            }
                        }
                    }
                }
                c i7 = dVar.i(c.a.BASELINE);
                if (i7.a != null && i7.c) {
                    int c4 = i7.c();
                    Iterator<c> it3 = i7.a.iterator();
                    while (it3.hasNext()) {
                        c next3 = it3.next();
                        d dVar4 = next3.f1377d;
                        int i8 = i2 + 1;
                        boolean a4 = a(dVar4);
                        if (dVar4.z() && a4) {
                            e.Z(dVar4, bVar, new b.a(), 0);
                        }
                        if (dVar4.q() != aVar || a4) {
                            if (!dVar4.z() && next3 == dVar4.M) {
                                int d6 = next3.d() + c4;
                                if (dVar4.D) {
                                    int i9 = d6 - dVar4.b0;
                                    int i10 = dVar4.W + i9;
                                    dVar4.a0 = i9;
                                    dVar4.J.j(i9);
                                    dVar4.L.j(i10);
                                    c cVar12 = dVar4.M;
                                    cVar12.b = d6;
                                    cVar12.c = true;
                                    dVar4.f1398k = true;
                                }
                                g(i8, dVar4, bVar);
                            }
                        }
                    }
                }
                dVar.m = true;
            }
        }
    }
}
