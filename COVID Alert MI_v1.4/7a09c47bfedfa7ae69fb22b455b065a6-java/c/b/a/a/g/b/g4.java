package c.b.a.a.g.b;

import java.util.ArrayList;

public final class g4 implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public int[] f3282b;

    /* renamed from: c  reason: collision with root package name */
    public h4[] f3283c;

    /* renamed from: d  reason: collision with root package name */
    public int f3284d;

    static {
        new ArrayList();
    }

    public g4() {
        this(10);
    }

    public g4(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.f3282b = new int[i5];
        this.f3283c = new h4[i5];
        this.f3284d = 0;
    }

    public final boolean a() {
        return this.f3284d == 0;
    }

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        int i = this.f3284d;
        g4 g4Var = new g4(i);
        System.arraycopy(this.f3282b, 0, g4Var.f3282b, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            h4[] h4VarArr = this.f3283c;
            if (h4VarArr[i2] != null) {
                g4Var.f3283c[i2] = (h4) h4VarArr[i2].clone();
            }
        }
        g4Var.f3284d = i;
        return g4Var;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g4)) {
            return false;
        }
        g4 g4Var = (g4) obj;
        int i = this.f3284d;
        if (i != g4Var.f3284d) {
            return false;
        }
        int[] iArr = this.f3282b;
        int[] iArr2 = g4Var.f3282b;
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
            h4[] h4VarArr = this.f3283c;
            h4[] h4VarArr2 = g4Var.f3283c;
            int i3 = this.f3284d;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!h4VarArr[i4].equals(h4VarArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f3284d; i2++) {
            i = (((i * 31) + this.f3282b[i2]) * 31) + this.f3283c[i2].hashCode();
        }
        return i;
    }
}
