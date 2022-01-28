package c.b.a.a.g.b;

import java.util.Arrays;

public final class t4 extends e4<t4> implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public String[] f3420d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f3421e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f3422f = k4.f3334a;

    /* renamed from: g  reason: collision with root package name */
    public long[] f3423g;
    public long[] h;

    public t4() {
        String[] strArr = k4.f3336c;
        this.f3420d = strArr;
        this.f3421e = strArr;
        long[] jArr = k4.f3335b;
        this.f3423g = jArr;
        this.h = jArr;
        this.f3257c = null;
        this.f3330b = -1;
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final void a(c4 c4Var) {
        String[] strArr = this.f3420d;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.f3420d;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    c4Var.c(1, str);
                }
                i2++;
            }
        }
        String[] strArr3 = this.f3421e;
        if (strArr3 != null && strArr3.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr4 = this.f3421e;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    c4Var.c(2, str2);
                }
                i3++;
            }
        }
        int[] iArr = this.f3422f;
        if (iArr != null && iArr.length > 0) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.f3422f;
                if (i4 >= iArr2.length) {
                    break;
                }
                c4Var.k(3, iArr2[i4]);
                i4++;
            }
        }
        long[] jArr = this.f3423g;
        if (jArr != null && jArr.length > 0) {
            int i5 = 0;
            while (true) {
                long[] jArr2 = this.f3423g;
                if (i5 >= jArr2.length) {
                    break;
                }
                c4Var.p(4, jArr2[i5]);
                i5++;
            }
        }
        long[] jArr3 = this.h;
        if (jArr3 != null && jArr3.length > 0) {
            while (true) {
                long[] jArr4 = this.h;
                if (i >= jArr4.length) {
                    break;
                }
                c4Var.p(5, jArr4[i]);
                i++;
            }
        }
        super.a(c4Var);
    }

    @Override // c.b.a.a.g.b.e4, java.lang.Object, c.b.a.a.g.b.j4
    public final Object clone() {
        try {
            t4 t4Var = (t4) super.clone();
            String[] strArr = this.f3420d;
            if (strArr != null && strArr.length > 0) {
                t4Var.f3420d = (String[]) strArr.clone();
            }
            String[] strArr2 = this.f3421e;
            if (strArr2 != null && strArr2.length > 0) {
                t4Var.f3421e = (String[]) strArr2.clone();
            }
            int[] iArr = this.f3422f;
            if (iArr != null && iArr.length > 0) {
                t4Var.f3422f = (int[]) iArr.clone();
            }
            long[] jArr = this.f3423g;
            if (jArr != null && jArr.length > 0) {
                t4Var.f3423g = (long[]) jArr.clone();
            }
            long[] jArr2 = this.h;
            if (jArr2 != null && jArr2.length > 0) {
                t4Var.h = (long[]) jArr2.clone();
            }
            return t4Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final int d() {
        int i;
        long[] jArr;
        int[] iArr;
        super.d();
        String[] strArr = this.f3420d;
        int i2 = 0;
        if (strArr == null || strArr.length <= 0) {
            i = 0;
        } else {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.f3420d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i5++;
                    i4 += c4.o(str);
                }
                i3++;
            }
            i = (i5 * 1) + i4 + 0;
        }
        String[] strArr3 = this.f3421e;
        if (strArr3 != null && strArr3.length > 0) {
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                String[] strArr4 = this.f3421e;
                if (i6 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i6];
                if (str2 != null) {
                    i8++;
                    i7 += c4.o(str2);
                }
                i6++;
            }
            i = i + i7 + (i8 * 1);
        }
        int[] iArr2 = this.f3422f;
        if (iArr2 != null && iArr2.length > 0) {
            int i9 = 0;
            int i10 = 0;
            while (true) {
                iArr = this.f3422f;
                if (i9 >= iArr.length) {
                    break;
                }
                i10 += c4.t(iArr[i9]);
                i9++;
            }
            i = i + i10 + (iArr.length * 1);
        }
        long[] jArr2 = this.f3423g;
        if (jArr2 != null && jArr2.length > 0) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                jArr = this.f3423g;
                if (i11 >= jArr.length) {
                    break;
                }
                i12 += c4.r(jArr[i11]);
                i11++;
            }
            i = i + i12 + (jArr.length * 1);
        }
        long[] jArr3 = this.h;
        if (jArr3 == null || jArr3.length <= 0) {
            return i;
        }
        int i13 = 0;
        while (true) {
            long[] jArr4 = this.h;
            if (i2 >= jArr4.length) {
                return i + i13 + (jArr4.length * 1);
            }
            i13 += c4.r(jArr4[i2]);
            i2++;
        }
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final /* synthetic */ j4 e() {
        return (t4) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t4)) {
            return false;
        }
        t4 t4Var = (t4) obj;
        if (!i4.c(this.f3420d, t4Var.f3420d) || !i4.c(this.f3421e, t4Var.f3421e) || !i4.a(this.f3422f, t4Var.f3422f) || !i4.b(this.f3423g, t4Var.f3423g) || !i4.b(this.h, t4Var.h)) {
            return false;
        }
        g4 g4Var = this.f3257c;
        if (g4Var != null && !g4Var.a()) {
            return this.f3257c.equals(t4Var.f3257c);
        }
        g4 g4Var2 = t4Var.f3257c;
        return g4Var2 == null || g4Var2.a();
    }

    /* Return type fixed from 'c.b.a.a.g.b.e4' to match base method */
    @Override // c.b.a.a.g.b.e4
    public final /* synthetic */ t4 f() {
        return (t4) clone();
    }

    public final int hashCode() {
        int hashCode = (((((t4.class.getName().hashCode() + 527) * 31) + i4.d(this.f3420d)) * 31) + i4.d(this.f3421e)) * 31;
        int[] iArr = this.f3422f;
        int i = 0;
        int hashCode2 = (hashCode + ((iArr == null || iArr.length == 0) ? 0 : Arrays.hashCode(iArr))) * 31;
        long[] jArr = this.f3423g;
        int hashCode3 = (hashCode2 + ((jArr == null || jArr.length == 0) ? 0 : Arrays.hashCode(jArr))) * 31;
        long[] jArr2 = this.h;
        int hashCode4 = (hashCode3 + ((jArr2 == null || jArr2.length == 0) ? 0 : Arrays.hashCode(jArr2))) * 31;
        g4 g4Var = this.f3257c;
        if (g4Var != null && !g4Var.a()) {
            i = this.f3257c.hashCode();
        }
        return hashCode4 + i;
    }
}
