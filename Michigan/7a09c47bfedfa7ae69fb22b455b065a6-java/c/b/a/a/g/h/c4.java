package c.b.a.a.g.h;

import c.b.a.a.g.h.b1;
import java.util.Arrays;

public final class c4 {

    /* renamed from: f  reason: collision with root package name */
    public static final c4 f3851f = new c4(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f3852a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f3853b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f3854c;

    /* renamed from: d  reason: collision with root package name */
    public int f3855d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3856e;

    public c4() {
        this(0, new int[8], new Object[8], true);
    }

    public c4(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f3855d = -1;
        this.f3852a = i;
        this.f3853b = iArr;
        this.f3854c = objArr;
        this.f3856e = z;
    }

    public static void b(int i, Object obj, v4 v4Var) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((d1) v4Var).k(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((d1) v4Var).j(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((d1) v4Var).d(i2, (q0) obj);
        } else if (i3 == 3) {
            d1 d1Var = (d1) v4Var;
            int i4 = i2 << 3;
            ((b1.b) d1Var.f3864a).k(i4 | 3);
            ((c4) obj).c(v4Var);
            ((b1.b) d1Var.f3864a).k(i4 | 4);
        } else if (i3 == 5) {
            ((d1) v4Var).o(i2, ((Integer) obj).intValue());
        } else {
            throw new RuntimeException(c2.d());
        }
    }

    public static c4 e() {
        return new c4(0, new int[8], new Object[8], true);
    }

    public final void a(int i, Object obj) {
        if (this.f3856e) {
            int i2 = this.f3852a;
            if (i2 == this.f3853b.length) {
                int i3 = this.f3852a + (i2 < 4 ? 8 : i2 >> 1);
                this.f3853b = Arrays.copyOf(this.f3853b, i3);
                this.f3854c = Arrays.copyOf(this.f3854c, i3);
            }
            int[] iArr = this.f3853b;
            int i4 = this.f3852a;
            iArr[i4] = i;
            this.f3854c[i4] = obj;
            this.f3852a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void c(v4 v4Var) {
        if (this.f3852a != 0) {
            if (((d1) v4Var) != null) {
                for (int i = 0; i < this.f3852a; i++) {
                    b(this.f3853b[i], this.f3854c[i], v4Var);
                }
                return;
            }
            throw null;
        }
    }

    public final int d() {
        int i;
        int i2 = this.f3855d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3852a; i4++) {
            int i5 = this.f3853b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = b1.z(i6, ((Long) this.f3854c[i4]).longValue());
            } else if (i7 == 1) {
                ((Long) this.f3854c[i4]).longValue();
                i = b1.D(i6);
            } else if (i7 == 2) {
                i = b1.t(i6, (q0) this.f3854c[i4]);
            } else if (i7 == 3) {
                i3 = ((c4) this.f3854c[i4]).d() + (b1.m(i6) << 1) + i3;
            } else if (i7 == 5) {
                ((Integer) this.f3854c[i4]).intValue();
                i = b1.L(i6);
            } else {
                throw new IllegalStateException(c2.d());
            }
            i3 = i + i3;
        }
        this.f3855d = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c4)) {
            return false;
        }
        c4 c4Var = (c4) obj;
        int i = this.f3852a;
        if (i == c4Var.f3852a) {
            int[] iArr = this.f3853b;
            int[] iArr2 = c4Var.f3853b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.f3854c;
                Object[] objArr2 = c4Var.f3854c;
                int i3 = this.f3852a;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.f3852a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f3853b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f3854c;
        int i7 = this.f3852a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }
}
