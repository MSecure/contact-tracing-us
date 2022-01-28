package b.g.b.h;

import b.g.b.g;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final d f1499a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1500b;

    /* renamed from: c  reason: collision with root package name */
    public c f1501c;

    /* renamed from: d  reason: collision with root package name */
    public int f1502d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f1503e = -1;

    /* renamed from: f  reason: collision with root package name */
    public g f1504f;

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
        this.f1499a = dVar;
        this.f1500b = aVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r6.f1499a.w == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r4 != r10) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        if (r4 != r10) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0074, code lost:
        if (r4 != r2) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079 A[RETURN] */
    public boolean a(c cVar, int i, int i2, boolean z) {
        boolean z2;
        if (cVar == null) {
            this.f1501c = null;
            this.f1502d = 0;
            this.f1503e = -1;
            return true;
        }
        if (!z) {
            a aVar = a.CENTER_Y;
            a aVar2 = a.CENTER_X;
            a aVar3 = a.BASELINE;
            a aVar4 = cVar.f1500b;
            a aVar5 = this.f1500b;
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
                        if (cVar.f1499a instanceof f) {
                            if (!z2) {
                            }
                        }
                        break;
                    case 2:
                    case 4:
                        boolean z3 = aVar4 == a.TOP || aVar4 == a.BOTTOM;
                        if (!(cVar.f1499a instanceof f)) {
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
                        throw new AssertionError(this.f1500b.name());
                }
                if (!z2) {
                }
            } else if (aVar5 == aVar3) {
                if (cVar.f1499a.w) {
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
        this.f1501c = cVar;
        if (i > 0) {
            this.f1502d = i;
        } else {
            this.f1502d = 0;
        }
        this.f1503e = i2;
        return true;
    }

    public int b() {
        c cVar;
        if (this.f1499a.V == 8) {
            return 0;
        }
        int i = this.f1503e;
        if (i <= -1 || (cVar = this.f1501c) == null || cVar.f1499a.V != 8) {
            return this.f1502d;
        }
        return i;
    }

    public boolean c() {
        return this.f1501c != null;
    }

    public void d() {
        this.f1501c = null;
        this.f1502d = 0;
        this.f1503e = -1;
    }

    public void e() {
        g gVar = this.f1504f;
        if (gVar == null) {
            this.f1504f = new g(g.a.UNRESTRICTED);
        } else {
            gVar.c();
        }
    }

    public String toString() {
        return this.f1499a.W + ":" + this.f1500b.toString();
    }
}
