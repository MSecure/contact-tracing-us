package c.b.d;

import java.util.Arrays;

public final class q2 {
    public static final q2 f = new q2(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f4056a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f4057b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f4058c;

    /* renamed from: d  reason: collision with root package name */
    public int f4059d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4060e;

    public q2() {
        this(0, new int[8], new Object[8], true);
    }

    public q2(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f4059d = -1;
        this.f4056a = i;
        this.f4057b = iArr;
        this.f4058c = objArr;
        this.f4060e = z;
    }

    public static q2 b() {
        return new q2(0, new int[8], new Object[8], true);
    }

    public static void d(int i, Object obj, x2 x2Var) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((n) x2Var).f4006a.u0(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((n) x2Var).f4006a.f0(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((n) x2Var).f4006a.a0(i2, (j) obj);
        } else if (i3 == 3) {
            n nVar = (n) x2Var;
            nVar.l(i2);
            ((q2) obj).e(x2Var);
            nVar.b(i2);
        } else if (i3 == 5) {
            ((n) x2Var).f4006a.d0(i2, ((Integer) obj).intValue());
        } else {
            throw new RuntimeException(n0.d());
        }
    }

    public int a() {
        int i;
        int i2 = this.f4059d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f4056a; i4++) {
            int i5 = this.f4057b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = m.Q(i6, ((Long) this.f4058c[i4]).longValue());
            } else if (i7 == 1) {
                i = m.m(i6, ((Long) this.f4058c[i4]).longValue());
            } else if (i7 == 2) {
                i = m.f(i6, (j) this.f4058c[i4]);
            } else if (i7 == 3) {
                i3 = ((q2) this.f4058c[i4]).a() + (m.N(i6) * 2) + i3;
            } else if (i7 == 5) {
                i = m.k(i6, ((Integer) this.f4058c[i4]).intValue());
            } else {
                throw new IllegalStateException(n0.d());
            }
            i3 = i + i3;
        }
        this.f4059d = i3;
        return i3;
    }

    public void c(int i, Object obj) {
        if (this.f4060e) {
            int i2 = this.f4056a;
            if (i2 == this.f4057b.length) {
                int i3 = this.f4056a + (i2 < 4 ? 8 : i2 >> 1);
                this.f4057b = Arrays.copyOf(this.f4057b, i3);
                this.f4058c = Arrays.copyOf(this.f4058c, i3);
            }
            int[] iArr = this.f4057b;
            int i4 = this.f4056a;
            iArr[i4] = i;
            this.f4058c[i4] = obj;
            this.f4056a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void e(x2 x2Var) {
        if (this.f4056a != 0) {
            if (((n) x2Var) != null) {
                for (int i = 0; i < this.f4056a; i++) {
                    d(this.f4057b[i], this.f4058c[i], x2Var);
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
        if (obj == null || !(obj instanceof q2)) {
            return false;
        }
        q2 q2Var = (q2) obj;
        int i = this.f4056a;
        if (i == q2Var.f4056a) {
            int[] iArr = this.f4057b;
            int[] iArr2 = q2Var.f4057b;
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
                Object[] objArr = this.f4058c;
                Object[] objArr2 = q2Var.f4058c;
                int i3 = this.f4056a;
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
        int i = this.f4056a;
        int i2 = (527 + i) * 31;
        int[] iArr = this.f4057b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f4058c;
        int i7 = this.f4056a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }
}
