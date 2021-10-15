package c.b.c.a.j0.a;

import c.b.c.a.j0.a.l;
import java.util.Arrays;

public final class m1 {

    /* renamed from: f  reason: collision with root package name */
    public static final m1 f4983f = new m1(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f4984a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f4985b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f4986c;

    /* renamed from: d  reason: collision with root package name */
    public int f4987d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4988e;

    public m1() {
        this(0, new int[8], new Object[8], true);
    }

    public m1(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f4987d = -1;
        this.f4984a = i;
        this.f4985b = iArr;
        this.f4986c = objArr;
        this.f4988e = z;
    }

    public static m1 b() {
        return new m1(0, new int[8], new Object[8], true);
    }

    public static void d(int i, Object obj, u1 u1Var) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((m) u1Var).h(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((m) u1Var).e(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((m) u1Var).b(i2, (i) obj);
        } else if (i3 == 3) {
            m mVar = (m) u1Var;
            int i4 = i2 << 3;
            ((l.b) mVar.f4982a).V(i4 | 3);
            ((m1) obj).e(u1Var);
            ((l.b) mVar.f4982a).V(i4 | 4);
        } else if (i3 == 5) {
            ((m) u1Var).d(i2, ((Integer) obj).intValue());
        } else {
            throw new RuntimeException(b0.d());
        }
    }

    public int a() {
        int i;
        int i2 = this.f4987d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f4984a; i4++) {
            int i5 = this.f4985b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = l.J(i6, ((Long) this.f4986c[i4]).longValue());
            } else if (i7 == 1) {
                i = l.k(i6, ((Long) this.f4986c[i4]).longValue());
            } else if (i7 == 2) {
                i = l.d(i6, (i) this.f4986c[i4]);
            } else if (i7 == 3) {
                i3 = ((m1) this.f4986c[i4]).a() + (l.G(i6) * 2) + i3;
            } else if (i7 == 5) {
                i = l.i(i6, ((Integer) this.f4986c[i4]).intValue());
            } else {
                throw new IllegalStateException(b0.d());
            }
            i3 = i + i3;
        }
        this.f4987d = i3;
        return i3;
    }

    public void c(int i, Object obj) {
        if (this.f4988e) {
            int i2 = this.f4984a;
            if (i2 == this.f4985b.length) {
                int i3 = this.f4984a + (i2 < 4 ? 8 : i2 >> 1);
                this.f4985b = Arrays.copyOf(this.f4985b, i3);
                this.f4986c = Arrays.copyOf(this.f4986c, i3);
            }
            int[] iArr = this.f4985b;
            int i4 = this.f4984a;
            iArr[i4] = i;
            this.f4986c[i4] = obj;
            this.f4984a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void e(u1 u1Var) {
        if (this.f4984a != 0) {
            if (((m) u1Var) != null) {
                for (int i = 0; i < this.f4984a; i++) {
                    d(this.f4985b[i], this.f4986c[i], u1Var);
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
        if (obj == null || !(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        int i = this.f4984a;
        if (i == m1Var.f4984a) {
            int[] iArr = this.f4985b;
            int[] iArr2 = m1Var.f4985b;
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
                Object[] objArr = this.f4986c;
                Object[] objArr2 = m1Var.f4986c;
                int i3 = this.f4984a;
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
        int i = this.f4984a;
        int i2 = (527 + i) * 31;
        int[] iArr = this.f4985b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f4986c;
        int i7 = this.f4984a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }
}
