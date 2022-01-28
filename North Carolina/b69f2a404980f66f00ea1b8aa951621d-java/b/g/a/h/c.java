package b.g.a.h;

import b.g.a.g;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public j f897a = new j(this);

    /* renamed from: b  reason: collision with root package name */
    public final d f898b;

    /* renamed from: c  reason: collision with root package name */
    public final b f899c;

    /* renamed from: d  reason: collision with root package name */
    public c f900d;

    /* renamed from: e  reason: collision with root package name */
    public int f901e = 0;
    public int f = -1;
    public a g = a.NONE;
    public int h = 0;
    public g i;

    public enum a {
        NONE,
        STRONG,
        WEAK
    }

    public enum b {
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

    public c(d dVar, b bVar) {
        this.f898b = dVar;
        this.f899c = bVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if ((r6.f898b.Q > 0) == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r4 != r12) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
        if (r4 != r12) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0085, code lost:
        if (r4 != r2) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008a A[RETURN] */
    public boolean a(c cVar, int i2, int i3, a aVar, int i4, boolean z) {
        boolean z2;
        if (cVar == null) {
            this.f900d = null;
            this.f901e = 0;
            this.f = -1;
            this.g = a.NONE;
            this.h = 2;
            return true;
        }
        if (!z) {
            b bVar = b.CENTER_Y;
            b bVar2 = b.CENTER_X;
            b bVar3 = b.BASELINE;
            b bVar4 = cVar.f899c;
            b bVar5 = this.f899c;
            if (bVar4 != bVar5) {
                switch (bVar5.ordinal()) {
                    case 0:
                    case 5:
                    case 7:
                    case 8:
                        z2 = false;
                        break;
                    case 1:
                    case 3:
                        z2 = bVar4 == b.LEFT || bVar4 == b.RIGHT;
                        if (cVar.f898b instanceof g) {
                            if (!z2) {
                            }
                        }
                        break;
                    case 2:
                    case 4:
                        boolean z3 = bVar4 == b.TOP || bVar4 == b.BOTTOM;
                        if (!(cVar.f898b instanceof g)) {
                            z2 = z3;
                            break;
                        } else if (!z3) {
                        }
                        break;
                    case 6:
                        if (bVar4 != bVar3) {
                            if (bVar4 != bVar2) {
                            }
                        }
                        z2 = false;
                        break;
                    default:
                        throw new AssertionError(this.f899c.name());
                }
                if (!z2) {
                }
            } else if (bVar5 == bVar3) {
                if (cVar.f898b.Q > 0) {
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
        this.f900d = cVar;
        if (i2 > 0) {
            this.f901e = i2;
        } else {
            this.f901e = 0;
        }
        this.f = i3;
        this.g = aVar;
        this.h = i4;
        return true;
    }

    public int b() {
        c cVar;
        if (this.f898b.Y == 8) {
            return 0;
        }
        int i2 = this.f;
        if (i2 <= -1 || (cVar = this.f900d) == null || cVar.f898b.Y != 8) {
            return this.f901e;
        }
        return i2;
    }

    public boolean c() {
        return this.f900d != null;
    }

    public void d() {
        this.f900d = null;
        this.f901e = 0;
        this.f = -1;
        this.g = a.STRONG;
        this.h = 0;
        this.f897a.i();
    }

    public void e() {
        g gVar = this.i;
        if (gVar == null) {
            this.i = new g(g.a.UNRESTRICTED);
        } else {
            gVar.c();
        }
    }

    public String toString() {
        return this.f898b.Z + ":" + this.f899c.toString();
    }
}
