package e.h.a.i;

import e.b.a.m;
import e.h.a.g;
import e.h.a.i.l.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    public int b;
    public boolean c;

    /* renamed from: d */
    public final d f1377d;

    /* renamed from: e */
    public final a f1378e;

    /* renamed from: f */
    public c f1379f;

    /* renamed from: i */
    public g f1382i;
    public HashSet<c> a = null;

    /* renamed from: g */
    public int f1380g = 0;

    /* renamed from: h */
    public int f1381h = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
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
        this.f1377d = dVar;
        this.f1378e = aVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r8.f1377d.D == false) goto L_0x0044;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        if (r5 != r12) goto L_0x0042;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r5 != r1) goto L_0x0042;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
        if (r5 != r12) goto L_0x0044;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0074, code lost:
        if (r5 != r2) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
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
            a aVar6 = cVar.f1378e;
            a aVar7 = this.f1378e;
            if (aVar6 == aVar7) {
                if (aVar7 == aVar5) {
                    if (cVar.f1377d.D) {
                    }
                    z2 = false;
                }
                z2 = true;
            } else {
                switch (aVar7.ordinal()) {
                    case 0:
                    case 7:
                    case 8:
                        z2 = false;
                        break;
                    case 1:
                    case 3:
                        z2 = aVar6 == aVar4 || aVar6 == aVar2;
                        if (cVar.f1377d instanceof f) {
                            if (!z2) {
                            }
                            z2 = true;
                            break;
                        }
                        break;
                    case 2:
                    case 4:
                        boolean z3 = aVar6 == a.TOP || aVar6 == a.BOTTOM;
                        if (!(cVar.f1377d instanceof f)) {
                            z2 = z3;
                            break;
                        } else {
                            if (!z3) {
                            }
                            z2 = true;
                            break;
                        }
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
                        throw new AssertionError(this.f1378e.name());
                }
            }
            if (!z2) {
                return false;
            }
        }
        this.f1379f = cVar;
        if (cVar.a == null) {
            cVar.a = new HashSet<>();
        }
        HashSet<c> hashSet = this.f1379f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f1380g = i2;
        this.f1381h = i3;
        return true;
    }

    public void b(int i2, ArrayList<n> arrayList, n nVar) {
        HashSet<c> hashSet = this.a;
        if (hashSet != null) {
            Iterator<c> it = hashSet.iterator();
            while (it.hasNext()) {
                m.e.Y(it.next().f1377d, i2, arrayList, nVar);
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
        if (this.f1377d.h0 == 8) {
            return 0;
        }
        int i2 = this.f1381h;
        if (i2 == Integer.MIN_VALUE || (cVar = this.f1379f) == null || cVar.f1377d.h0 != 8) {
            return this.f1380g;
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
            switch (next.f1378e.ordinal()) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                    cVar = null;
                    break;
                case 1:
                    cVar = next.f1377d.K;
                    break;
                case 2:
                    cVar = next.f1377d.L;
                    break;
                case 3:
                    cVar = next.f1377d.I;
                    break;
                case 4:
                    cVar = next.f1377d.J;
                    break;
                default:
                    throw new AssertionError(next.f1378e.name());
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
        return this.f1379f != null;
    }

    public void h() {
        HashSet<c> hashSet;
        c cVar = this.f1379f;
        if (!(cVar == null || (hashSet = cVar.a) == null)) {
            hashSet.remove(this);
            if (this.f1379f.a.size() == 0) {
                this.f1379f.a = null;
            }
        }
        this.a = null;
        this.f1379f = null;
        this.f1380g = 0;
        this.f1381h = Integer.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }

    public void i() {
        g gVar = this.f1382i;
        if (gVar == null) {
            this.f1382i = new g(g.a.UNRESTRICTED);
        } else {
            gVar.c();
        }
    }

    public void j(int i2) {
        this.b = i2;
        this.c = true;
    }

    public String toString() {
        return this.f1377d.i0 + ":" + this.f1378e.toString();
    }
}
