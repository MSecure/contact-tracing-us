package e.g.a.i;

import e.b.a.m;
import e.g.a.g;
import e.g.a.i.l.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class c {
    public HashSet<c> a = null;
    public int b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1293d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1294e;

    /* renamed from: f  reason: collision with root package name */
    public c f1295f;

    /* renamed from: g  reason: collision with root package name */
    public int f1296g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f1297h = Integer.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public g f1298i;

    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public c(d dVar, a aVar) {
        this.f1293d = dVar;
        this.f1294e = aVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r8.f1293d.D == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r5 != r12) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r5 != r1) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
        if (r5 != r12) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0074, code lost:
        if (r5 != r2) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079 A[RETURN] */
    public boolean a(c cVar, int i2, int i3, boolean z) {
        boolean z2;
        if (cVar == null) {
            h();
            return true;
        }
        if (!z) {
            a aVar = a.CENTER_Y;
            a aVar2 = a.RIGHT;
            a aVar3 = a.CENTER_X;
            a aVar4 = a.LEFT;
            a aVar5 = a.BASELINE;
            a aVar6 = cVar.f1294e;
            a aVar7 = this.f1294e;
            if (aVar6 != aVar7) {
                switch (aVar7.ordinal()) {
                    case 0:
                    case 7:
                    case 8:
                        z2 = false;
                        break;
                    case 1:
                    case 3:
                        z2 = aVar6 == aVar4 || aVar6 == aVar2;
                        if (cVar.f1293d instanceof f) {
                            if (!z2) {
                            }
                        }
                        break;
                    case 2:
                    case 4:
                        boolean z3 = aVar6 == a.TOP || aVar6 == a.BOTTOM;
                        if (!(cVar.f1293d instanceof f)) {
                            z2 = z3;
                            break;
                        } else if (!z3) {
                        }
                        break;
                    case 5:
                        if (aVar6 != aVar4) {
                        }
                        z2 = false;
                        break;
                    case 6:
                        if (aVar6 != aVar5) {
                            if (aVar6 != aVar3) {
                            }
                        }
                        z2 = false;
                        break;
                    default:
                        throw new AssertionError(this.f1294e.name());
                }
                if (!z2) {
                }
            } else if (aVar7 == aVar5) {
                if (cVar.f1293d.D) {
                }
                z2 = false;
                if (!z2) {
                    return false;
                }
            }
            z2 = true;
            if (!z2) {
            }
        }
        this.f1295f = cVar;
        if (cVar.a == null) {
            cVar.a = new HashSet<>();
        }
        HashSet<c> hashSet = this.f1295f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f1296g = i2;
        this.f1297h = i3;
        return true;
    }

    public void b(int i2, ArrayList<n> arrayList, n nVar) {
        HashSet<c> hashSet = this.a;
        if (hashSet != null) {
            Iterator<c> it = hashSet.iterator();
            while (it.hasNext()) {
                m.e.X(it.next().f1293d, i2, arrayList, nVar);
            }
        }
    }

    public int c() {
        if (!this.c) {
            return 0;
        }
        return this.b;
    }

    public int d() {
        c cVar;
        if (this.f1293d.h0 == 8) {
            return 0;
        }
        int i2 = this.f1297h;
        if (i2 == Integer.MIN_VALUE || (cVar = this.f1295f) == null || cVar.f1293d.h0 != 8) {
            return this.f1296g;
        }
        return i2;
    }

    public boolean e() {
        c cVar;
        HashSet<c> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator<c> it = hashSet.iterator();
        while (it.hasNext()) {
            c next = it.next();
            switch (next.f1294e.ordinal()) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                    cVar = null;
                    break;
                case 1:
                    cVar = next.f1293d.K;
                    break;
                case 2:
                    cVar = next.f1293d.L;
                    break;
                case 3:
                    cVar = next.f1293d.I;
                    break;
                case 4:
                    cVar = next.f1293d.J;
                    break;
                default:
                    throw new AssertionError(next.f1294e.name());
            }
            if (cVar.g()) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        HashSet<c> hashSet = this.a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean g() {
        return this.f1295f != null;
    }

    public void h() {
        HashSet<c> hashSet;
        c cVar = this.f1295f;
        if (!(cVar == null || (hashSet = cVar.a) == null)) {
            hashSet.remove(this);
            if (this.f1295f.a.size() == 0) {
                this.f1295f.a = null;
            }
        }
        this.a = null;
        this.f1295f = null;
        this.f1296g = 0;
        this.f1297h = Integer.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }

    public void i() {
        g gVar = this.f1298i;
        if (gVar == null) {
            this.f1298i = new g(g.a.UNRESTRICTED);
        } else {
            gVar.c();
        }
    }

    public void j(int i2) {
        this.b = i2;
        this.c = true;
    }

    public String toString() {
        return this.f1293d.i0 + ":" + this.f1294e.toString();
    }
}
