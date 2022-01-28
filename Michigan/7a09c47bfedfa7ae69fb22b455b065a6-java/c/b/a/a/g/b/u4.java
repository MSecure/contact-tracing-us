package c.b.a.a.g.b;

import java.util.Arrays;

public final class u4 extends e4<u4> implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3435d = k4.f3338e;

    /* renamed from: e  reason: collision with root package name */
    public String f3436e = "";

    /* renamed from: f  reason: collision with root package name */
    public byte[][] f3437f = k4.f3337d;

    public u4() {
        this.f3257c = null;
        this.f3330b = -1;
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final void a(c4 c4Var) {
        if (!Arrays.equals(this.f3435d, k4.f3338e)) {
            c4Var.d(1, this.f3435d);
        }
        byte[][] bArr = this.f3437f;
        if (bArr != null && bArr.length > 0) {
            int i = 0;
            while (true) {
                byte[][] bArr2 = this.f3437f;
                if (i >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    c4Var.d(2, bArr3);
                }
                i++;
            }
        }
        String str = this.f3436e;
        if (str != null && !str.equals("")) {
            c4Var.c(4, this.f3436e);
        }
        super.a(c4Var);
    }

    @Override // c.b.a.a.g.b.e4, java.lang.Object, c.b.a.a.g.b.j4
    public final Object clone() {
        try {
            u4 u4Var = (u4) super.clone();
            byte[][] bArr = this.f3437f;
            if (bArr != null && bArr.length > 0) {
                u4Var.f3437f = (byte[][]) bArr.clone();
            }
            return u4Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final int d() {
        super.d();
        int i = 0;
        int i2 = !Arrays.equals(this.f3435d, k4.f3338e) ? c4.i(1, this.f3435d) + 0 : 0;
        byte[][] bArr = this.f3437f;
        if (bArr != null && bArr.length > 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte[][] bArr2 = this.f3437f;
                if (i >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    i4++;
                    i3 += c4.u(bArr3.length) + bArr3.length;
                }
                i++;
            }
            i2 = i2 + i3 + (i4 * 1);
        }
        String str = this.f3436e;
        return (str == null || str.equals("")) ? i2 : i2 + c4.h(4, this.f3436e);
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final /* synthetic */ j4 e() {
        return (u4) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u4)) {
            return false;
        }
        u4 u4Var = (u4) obj;
        if (!Arrays.equals(this.f3435d, u4Var.f3435d)) {
            return false;
        }
        String str = this.f3436e;
        if (str == null) {
            if (u4Var.f3436e != null) {
                return false;
            }
        } else if (!str.equals(u4Var.f3436e)) {
            return false;
        }
        if (!i4.g(this.f3437f, u4Var.f3437f)) {
            return false;
        }
        g4 g4Var = this.f3257c;
        if (g4Var != null && !g4Var.a()) {
            return this.f3257c.equals(u4Var.f3257c);
        }
        g4 g4Var2 = u4Var.f3257c;
        return g4Var2 == null || g4Var2.a();
    }

    /* Return type fixed from 'c.b.a.a.g.b.e4' to match base method */
    @Override // c.b.a.a.g.b.e4
    public final /* synthetic */ u4 f() {
        return (u4) clone();
    }

    public final int hashCode() {
        int hashCode = (Arrays.hashCode(this.f3435d) + ((u4.class.getName().hashCode() + 527) * 31)) * 31;
        String str = this.f3436e;
        int i = 0;
        int e2 = (((i4.e(this.f3437f) + ((hashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31) + 1237) * 31;
        g4 g4Var = this.f3257c;
        if (g4Var != null && !g4Var.a()) {
            i = this.f3257c.hashCode();
        }
        return e2 + i;
    }
}
