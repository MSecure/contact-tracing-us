package f.b.g;

import java.util.Arrays;
import java.util.Objects;

public final class s1 {

    /* renamed from: f  reason: collision with root package name */
    public static final s1 f3618f = new s1(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f3619d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3620e;

    public s1() {
        this(0, new int[8], new Object[8], true);
    }

    public s1(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f3619d = -1;
        this.a = i2;
        this.b = iArr;
        this.c = objArr;
        this.f3620e = z;
    }

    public static s1 d(s1 s1Var, s1 s1Var2) {
        int i2 = s1Var.a + s1Var2.a;
        int[] copyOf = Arrays.copyOf(s1Var.b, i2);
        System.arraycopy(s1Var2.b, 0, copyOf, s1Var.a, s1Var2.a);
        Object[] copyOf2 = Arrays.copyOf(s1Var.c, i2);
        System.arraycopy(s1Var2.c, 0, copyOf2, s1Var.a, s1Var2.a);
        return new s1(i2, copyOf, copyOf2, true);
    }

    public static s1 e() {
        return new s1(0, new int[8], new Object[8], true);
    }

    public static void g(int i2, Object obj, a2 a2Var) {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            ((n) a2Var).a.b0(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            ((n) a2Var).a.O(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            ((n) a2Var).a.K(i3, (j) obj);
        } else if (i4 == 3) {
            n nVar = (n) a2Var;
            nVar.a.Y(i3, 3);
            ((s1) obj).h(a2Var);
            nVar.a.Y(i3, 4);
        } else if (i4 == 5) {
            ((n) a2Var).a.M(i3, ((Integer) obj).intValue());
        } else {
            throw new RuntimeException(d0.d());
        }
    }

    public void a() {
        if (!this.f3620e) {
            throw new UnsupportedOperationException();
        }
    }

    public int b() {
        int i2;
        int i3 = this.f3619d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.a; i5++) {
            int i6 = this.b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                i2 = m.B(i7, ((Long) this.c[i5]).longValue());
            } else if (i8 == 1) {
                i2 = m.i(i7, ((Long) this.c[i5]).longValue());
            } else if (i8 == 2) {
                i2 = m.d(i7, (j) this.c[i5]);
            } else if (i8 == 3) {
                i4 = ((s1) this.c[i5]).b() + (m.y(i7) * 2) + i4;
            } else if (i8 == 5) {
                i2 = m.h(i7, ((Integer) this.c[i5]).intValue());
            } else {
                throw new IllegalStateException(d0.d());
            }
            i4 = i2 + i4;
        }
        this.f3619d = i4;
        return i4;
    }

    public boolean c(int i2, k kVar) {
        int A;
        a();
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            f(i2, Long.valueOf(kVar.s()));
            return true;
        } else if (i4 == 1) {
            f(i2, Long.valueOf(kVar.p()));
            return true;
        } else if (i4 == 2) {
            f(i2, kVar.l());
            return true;
        } else if (i4 == 3) {
            s1 s1Var = new s1(0, new int[8], new Object[8], true);
            do {
                A = kVar.A();
                if (A == 0) {
                    break;
                }
            } while (s1Var.c(A, kVar));
            kVar.a((i3 << 3) | 4);
            f(i2, s1Var);
            return true;
        } else if (i4 == 4) {
            return false;
        } else {
            if (i4 == 5) {
                f(i2, Integer.valueOf(kVar.o()));
                return true;
            }
            throw d0.d();
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof s1)) {
            return false;
        }
        s1 s1Var = (s1) obj;
        int i2 = this.a;
        if (i2 == s1Var.a) {
            int[] iArr = this.b;
            int[] iArr2 = s1Var.b;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    z = true;
                    break;
                } else if (iArr[i3] != iArr2[i3]) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                Object[] objArr = this.c;
                Object[] objArr2 = s1Var.c;
                int i4 = this.a;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        z2 = true;
                        break;
                    } else if (!objArr[i5].equals(objArr2[i5])) {
                        z2 = false;
                        break;
                    } else {
                        i5++;
                    }
                }
                return z2;
            }
        }
    }

    public void f(int i2, Object obj) {
        a();
        int i3 = this.a;
        int[] iArr = this.b;
        if (i3 == iArr.length) {
            int i4 = i3 + (i3 < 4 ? 8 : i3 >> 1);
            this.b = Arrays.copyOf(iArr, i4);
            this.c = Arrays.copyOf(this.c, i4);
        }
        int[] iArr2 = this.b;
        int i5 = this.a;
        iArr2[i5] = i2;
        this.c[i5] = obj;
        this.a = i5 + 1;
    }

    public void h(a2 a2Var) {
        if (this.a != 0) {
            Objects.requireNonNull(a2Var);
            for (int i2 = 0; i2 < this.a; i2++) {
                g(this.b[i2], this.c[i2], a2Var);
            }
        }
    }

    public int hashCode() {
        int i2 = this.a;
        int i3 = (527 + i2) * 31;
        int[] iArr = this.b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.c;
        int i8 = this.a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }
}
