package c.b.d;

import java.util.Arrays;

public final class r2 {

    /* renamed from: f  reason: collision with root package name */
    public static final r2 f5781f = new r2(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f5782a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f5783b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f5784c;

    /* renamed from: d  reason: collision with root package name */
    public int f5785d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5786e;

    public r2() {
        this(0, new int[8], new Object[8], true);
    }

    public r2(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f5785d = -1;
        this.f5782a = i;
        this.f5783b = iArr;
        this.f5784c = objArr;
        this.f5786e = z;
    }

    public static r2 b() {
        return new r2(0, new int[8], new Object[8], true);
    }

    public static void d(int i, Object obj, y2 y2Var) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((n) y2Var).f5437a.u0(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((n) y2Var).f5437a.f0(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((n) y2Var).f5437a.a0(i2, (j) obj);
        } else if (i3 == 3) {
            n nVar = (n) y2Var;
            nVar.l(i2);
            ((r2) obj).e(y2Var);
            nVar.b(i2);
        } else if (i3 == 5) {
            ((n) y2Var).f5437a.d0(i2, ((Integer) obj).intValue());
        } else {
            throw new RuntimeException(o0.d());
        }
    }

    public int a() {
        int i;
        int i2 = this.f5785d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f5782a; i4++) {
            int i5 = this.f5783b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = m.Q(i6, ((Long) this.f5784c[i4]).longValue());
            } else if (i7 == 1) {
                i = m.m(i6, ((Long) this.f5784c[i4]).longValue());
            } else if (i7 == 2) {
                i = m.f(i6, (j) this.f5784c[i4]);
            } else if (i7 == 3) {
                i3 = ((r2) this.f5784c[i4]).a() + (m.N(i6) * 2) + i3;
            } else if (i7 == 5) {
                i = m.k(i6, ((Integer) this.f5784c[i4]).intValue());
            } else {
                throw new IllegalStateException(o0.d());
            }
            i3 = i + i3;
        }
        this.f5785d = i3;
        return i3;
    }

    public void c(int i, Object obj) {
        if (this.f5786e) {
            int i2 = this.f5782a;
            if (i2 == this.f5783b.length) {
                int i3 = this.f5782a + (i2 < 4 ? 8 : i2 >> 1);
                this.f5783b = Arrays.copyOf(this.f5783b, i3);
                this.f5784c = Arrays.copyOf(this.f5784c, i3);
            }
            int[] iArr = this.f5783b;
            int i4 = this.f5782a;
            iArr[i4] = i;
            this.f5784c[i4] = obj;
            this.f5782a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void e(y2 y2Var) {
        if (this.f5782a != 0) {
            if (((n) y2Var) != null) {
                for (int i = 0; i < this.f5782a; i++) {
                    d(this.f5783b[i], this.f5784c[i], y2Var);
                }
                return;
            }
            throw null;
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof r2)) {
            return false;
        }
        r2 r2Var = (r2) obj;
        int i = this.f5782a;
        if (i == r2Var.f5782a) {
            int[] iArr = this.f5783b;
            int[] iArr2 = r2Var.f5783b;
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
                Object[] objArr = this.f5784c;
                Object[] objArr2 = r2Var.f5784c;
                int i3 = this.f5782a;
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

    public int hashCode() {
        int i = this.f5782a;
        int i2 = (527 + i) * 31;
        int[] iArr = this.f5783b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f5784c;
        int i7 = this.f5782a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }
}
