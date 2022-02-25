package e.g.b.h;

import e.b.a.m;
import e.g.b.g;
import e.g.b.h.l.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class c {
    public HashSet<c> a = null;
    public int b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1260d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1261e;

    /* renamed from: f  reason: collision with root package name */
    public c f1262f;

    /* renamed from: g  reason: collision with root package name */
    public int f1263g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f1264h = -1;

    /* renamed from: i  reason: collision with root package name */
    public g f1265i;

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
        this.f1260d = dVar;
        this.f1261e = aVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r6.f1260d.y == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if (r4 != r10) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r4 != r10) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006f, code lost:
        if (r4 != r2) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0074 A[RETURN] */
    public boolean a(c cVar, int i2, int i3, boolean z) {
        boolean z2;
        if (cVar == null) {
            h();
            return true;
        }
        if (!z) {
            a aVar = a.CENTER_Y;
            a aVar2 = a.CENTER_X;
            a aVar3 = a.BASELINE;
            a aVar4 = cVar.f1261e;
            a aVar5 = this.f1261e;
            if (aVar4 != aVar5) {
                switch (aVar5.ordinal()) {
                    case 0:
                    case 5:
                    case 7:
                    case 8:
                        z2 = false;
                        break;
                    case 1:
                    case 3:
                        z2 = aVar4 == a.LEFT || aVar4 == a.RIGHT;
                        if (cVar.f1260d instanceof f) {
                            if (!z2) {
                            }
                        }
                        break;
                    case 2:
                    case 4:
                        boolean z3 = aVar4 == a.TOP || aVar4 == a.BOTTOM;
                        if (!(cVar.f1260d instanceof f)) {
                            z2 = z3;
                            break;
                        } else if (!z3) {
                        }
                        break;
                    case 6:
                        if (aVar4 != aVar3) {
                            if (aVar4 != aVar2) {
                            }
                        }
                        z2 = false;
                        break;
                    default:
                        throw new AssertionError(this.f1261e.name());
                }
                if (!z2) {
                }
            } else if (aVar5 == aVar3) {
                if (cVar.f1260d.y) {
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
        this.f1262f = cVar;
        if (cVar.a == null) {
            cVar.a = new HashSet<>();
        }
        HashSet<c> hashSet = this.f1262f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        if (i2 > 0) {
            this.f1263g = i2;
        } else {
            this.f1263g = 0;
        }
        this.f1264h = i3;
        return true;
    }

    public void b(int i2, ArrayList<n> arrayList, n nVar) {
        HashSet<c> hashSet = this.a;
        if (hashSet != null) {
            Iterator<c> it = hashSet.iterator();
            while (it.hasNext()) {
                m.h.V(it.next().f1260d, i2, arrayList, nVar);
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
        if (this.f1260d.c0 == 8) {
            return 0;
        }
        int i2 = this.f1264h;
        if (i2 <= -1 || (cVar = this.f1262f) == null || cVar.f1260d.c0 != 8) {
            return this.f1263g;
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
            switch (next.f1261e.ordinal()) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                    cVar = null;
                    break;
                case 1:
                    cVar = next.f1260d.F;
                    break;
                case 2:
                    cVar = next.f1260d.G;
                    break;
                case 3:
                    cVar = next.f1260d.D;
                    break;
                case 4:
                    cVar = next.f1260d.E;
                    break;
                default:
                    throw new AssertionError(next.f1261e.name());
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
        return this.f1262f != null;
    }

    public void h() {
        HashSet<c> hashSet;
        c cVar = this.f1262f;
        if (!(cVar == null || (hashSet = cVar.a) == null)) {
            hashSet.remove(this);
            if (this.f1262f.a.size() == 0) {
                this.f1262f.a = null;
            }
        }
        this.a = null;
        this.f1262f = null;
        this.f1263g = 0;
        this.f1264h = -1;
        this.c = false;
        this.b = 0;
    }

    public void i() {
        g gVar = this.f1265i;
        if (gVar == null) {
            this.f1265i = new g(g.a.UNRESTRICTED);
        } else {
            gVar.c();
        }
    }

    public void j(int i2) {
        this.b = i2;
        this.c = true;
    }

    public String toString() {
        return this.f1260d.d0 + ":" + this.f1261e.toString();
    }
}
