package c.b.a.a.g.b;

import java.util.Arrays;

public final class i3 {

    /* renamed from: f  reason: collision with root package name */
    public static final i3 f3314f = new i3(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f3315a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f3316b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f3317c;

    /* renamed from: d  reason: collision with root package name */
    public int f3318d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3319e;

    public i3() {
        this(0, new int[8], new Object[8], true);
    }

    public i3(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f3318d = -1;
        this.f3315a = i;
        this.f3316b = iArr;
        this.f3317c = objArr;
        this.f3319e = z;
    }

    public static void c(int i, Object obj, b4 b4Var) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((i0) b4Var).f3309a.g(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((i0) b4Var).f3309a.H(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((i0) b4Var).f3309a.h(i2, (y) obj);
        } else if (i3 == 3) {
            i0 i0Var = (i0) b4Var;
            i0Var.f3309a.s(i2, 3);
            ((i3) obj).d(b4Var);
            i0Var.f3309a.s(i2, 4);
        } else if (i3 == 5) {
            ((i0) b4Var).f3309a.Q(i2, ((Integer) obj).intValue());
        } else {
            throw new RuntimeException(f1.c());
        }
    }

    public static i3 e() {
        return new i3(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int i;
        int i2 = this.f3318d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3315a; i4++) {
            int i5 = this.f3316b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = g0.N(i6, ((Long) this.f3317c[i4]).longValue());
            } else if (i7 == 1) {
                ((Long) this.f3317c[i4]).longValue();
                i = g0.R(i6);
            } else if (i7 == 2) {
                i = g0.B(i6, (y) this.f3317c[i4]);
            } else if (i7 == 3) {
                i3 = ((i3) this.f3317c[i4]).a() + (g0.h0(i6) << 1) + i3;
            } else if (i7 == 5) {
                ((Integer) this.f3317c[i4]).intValue();
                i = g0.a0(i6);
            } else {
                throw new IllegalStateException(f1.c());
            }
            i3 = i + i3;
        }
        this.f3318d = i3;
        return i3;
    }

    public final void b(int i, Object obj) {
        if (this.f3319e) {
            int i2 = this.f3315a;
            if (i2 == this.f3316b.length) {
                int i3 = this.f3315a + (i2 < 4 ? 8 : i2 >> 1);
                this.f3316b = Arrays.copyOf(this.f3316b, i3);
                this.f3317c = Arrays.copyOf(this.f3317c, i3);
            }
            int[] iArr = this.f3316b;
            int i4 = this.f3315a;
            iArr[i4] = i;
            this.f3317c[i4] = obj;
            this.f3315a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void d(b4 b4Var) {
        if (this.f3315a != 0) {
            if (((i0) b4Var) != null) {
                for (int i = 0; i < this.f3315a; i++) {
                    c(this.f3316b[i], this.f3317c[i], b4Var);
                }
                return;
            }
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof i3)) {
            return false;
        }
        i3 i3Var = (i3) obj;
        int i = this.f3315a;
        if (i == i3Var.f3315a) {
            int[] iArr = this.f3316b;
            int[] iArr2 = i3Var.f3316b;
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
                Object[] objArr = this.f3317c;
                Object[] objArr2 = i3Var.f3317c;
                int i3 = this.f3315a;
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
        int i = this.f3315a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f3316b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f3317c;
        int i7 = this.f3315a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }
}
