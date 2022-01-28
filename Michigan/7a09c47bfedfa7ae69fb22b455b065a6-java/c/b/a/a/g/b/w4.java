package c.b.a.a.g.b;

import java.util.Arrays;

public final class w4 extends e4<w4> implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public long f3459d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f3460e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f3461f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f3462g = 0;
    public String h = "";
    public x4[] i;
    public byte[] j;
    public l4 k;
    public byte[] l;
    public String m;
    public String n;
    public t4 o;
    public String p;
    public long q;
    public u4 r;
    public byte[] s;
    public String t;
    public int[] u;
    public m4 v;
    public boolean w;

    public w4() {
        if (x4.f3471f == null) {
            synchronized (i4.f3320a) {
                if (x4.f3471f == null) {
                    x4.f3471f = new x4[0];
                }
            }
        }
        this.i = x4.f3471f;
        byte[] bArr = k4.f3338e;
        this.j = bArr;
        this.k = null;
        this.l = bArr;
        this.m = "";
        this.n = "";
        this.o = null;
        this.p = "";
        this.q = 180000;
        this.r = null;
        this.s = bArr;
        this.t = "";
        this.u = k4.f3334a;
        this.v = null;
        this.w = false;
        this.f3257c = null;
        this.f3330b = -1;
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final void a(c4 c4Var) {
        long j2 = this.f3459d;
        if (j2 != 0) {
            c4Var.p(1, j2);
        }
        String str = this.f3461f;
        if (str != null && !str.equals("")) {
            c4Var.c(2, this.f3461f);
        }
        x4[] x4VarArr = this.i;
        if (x4VarArr != null && x4VarArr.length > 0) {
            int i2 = 0;
            while (true) {
                x4[] x4VarArr2 = this.i;
                if (i2 >= x4VarArr2.length) {
                    break;
                }
                x4 x4Var = x4VarArr2[i2];
                if (x4Var != null) {
                    c4Var.b(3, x4Var);
                }
                i2++;
            }
        }
        if (!Arrays.equals(this.j, k4.f3338e)) {
            c4Var.d(4, this.j);
        }
        if (!Arrays.equals(this.l, k4.f3338e)) {
            c4Var.d(6, this.l);
        }
        t4 t4Var = this.o;
        if (t4Var != null) {
            c4Var.b(7, t4Var);
        }
        String str2 = this.m;
        if (str2 != null && !str2.equals("")) {
            c4Var.c(8, this.m);
        }
        l4 l4Var = this.k;
        if (l4Var != null) {
            c4Var.n(9, l4Var);
        }
        int i3 = this.f3462g;
        if (i3 != 0) {
            c4Var.k(11, i3);
        }
        String str3 = this.n;
        if (str3 != null && !str3.equals("")) {
            c4Var.c(13, this.n);
        }
        String str4 = this.p;
        if (str4 != null && !str4.equals("")) {
            c4Var.c(14, this.p);
        }
        long j3 = this.q;
        if (j3 != 180000) {
            c4Var.j(15, 0);
            c4Var.q((j3 >> 63) ^ (j3 << 1));
        }
        u4 u4Var = this.r;
        if (u4Var != null) {
            c4Var.b(16, u4Var);
        }
        long j4 = this.f3460e;
        if (j4 != 0) {
            c4Var.p(17, j4);
        }
        if (!Arrays.equals(this.s, k4.f3338e)) {
            c4Var.d(18, this.s);
        }
        int[] iArr = this.u;
        if (iArr != null && iArr.length > 0) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.u;
                if (i4 >= iArr2.length) {
                    break;
                }
                c4Var.k(20, iArr2[i4]);
                i4++;
            }
        }
        m4 m4Var = this.v;
        if (m4Var != null) {
            c4Var.n(23, m4Var);
        }
        String str5 = this.t;
        if (str5 != null && !str5.equals("")) {
            c4Var.c(24, this.t);
        }
        boolean z = this.w;
        if (z) {
            c4Var.j(25, 0);
            byte b2 = z ? (byte) 1 : 0;
            if (c4Var.f3239a.hasRemaining()) {
                c4Var.f3239a.put(b2);
            } else {
                throw new d4(c4Var.f3239a.position(), c4Var.f3239a.limit());
            }
        }
        String str6 = this.h;
        if (str6 != null && !str6.equals("")) {
            c4Var.c(26, this.h);
        }
        super.a(c4Var);
    }

    @Override // c.b.a.a.g.b.e4, java.lang.Object, c.b.a.a.g.b.j4
    public final Object clone() {
        try {
            w4 w4Var = (w4) super.clone();
            x4[] x4VarArr = this.i;
            if (x4VarArr != null && x4VarArr.length > 0) {
                w4Var.i = new x4[x4VarArr.length];
                int i2 = 0;
                while (true) {
                    x4[] x4VarArr2 = this.i;
                    if (i2 >= x4VarArr2.length) {
                        break;
                    }
                    if (x4VarArr2[i2] != null) {
                        w4Var.i[i2] = (x4) x4VarArr2[i2].clone();
                    }
                    i2++;
                }
            }
            l4 l4Var = this.k;
            if (l4Var != null) {
                w4Var.k = l4Var;
            }
            t4 t4Var = this.o;
            if (t4Var != null) {
                w4Var.o = (t4) t4Var.clone();
            }
            u4 u4Var = this.r;
            if (u4Var != null) {
                w4Var.r = (u4) u4Var.clone();
            }
            int[] iArr = this.u;
            if (iArr != null && iArr.length > 0) {
                w4Var.u = (int[]) iArr.clone();
            }
            m4 m4Var = this.v;
            if (m4Var != null) {
                w4Var.v = m4Var;
            }
            return w4Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final int d() {
        int[] iArr;
        super.d();
        long j2 = this.f3459d;
        int i2 = 0;
        int l2 = j2 != 0 ? c4.l(1, j2) + 0 : 0;
        String str = this.f3461f;
        if (str != null && !str.equals("")) {
            l2 += c4.h(2, this.f3461f);
        }
        x4[] x4VarArr = this.i;
        if (x4VarArr != null && x4VarArr.length > 0) {
            int i3 = 0;
            while (true) {
                x4[] x4VarArr2 = this.i;
                if (i3 >= x4VarArr2.length) {
                    break;
                }
                x4 x4Var = x4VarArr2[i3];
                if (x4Var != null) {
                    l2 += c4.g(3, x4Var);
                }
                i3++;
            }
        }
        if (!Arrays.equals(this.j, k4.f3338e)) {
            l2 += c4.i(4, this.j);
        }
        if (!Arrays.equals(this.l, k4.f3338e)) {
            l2 += c4.i(6, this.l);
        }
        t4 t4Var = this.o;
        if (t4Var != null) {
            l2 += c4.g(7, t4Var);
        }
        String str2 = this.m;
        if (str2 != null && !str2.equals("")) {
            l2 += c4.h(8, this.m);
        }
        l4 l4Var = this.k;
        if (l4Var != null) {
            l2 += g0.C(9, l4Var);
        }
        int i4 = this.f3462g;
        if (i4 != 0) {
            l2 += c4.t(i4) + c4.s(11);
        }
        String str3 = this.n;
        if (str3 != null && !str3.equals("")) {
            l2 += c4.h(13, this.n);
        }
        String str4 = this.p;
        if (str4 != null && !str4.equals("")) {
            l2 += c4.h(14, this.p);
        }
        long j3 = this.q;
        if (j3 != 180000) {
            l2 += c4.r((j3 >> 63) ^ (j3 << 1)) + c4.s(15);
        }
        u4 u4Var = this.r;
        if (u4Var != null) {
            l2 += c4.g(16, u4Var);
        }
        long j4 = this.f3460e;
        if (j4 != 0) {
            l2 += c4.l(17, j4);
        }
        if (!Arrays.equals(this.s, k4.f3338e)) {
            l2 += c4.i(18, this.s);
        }
        int[] iArr2 = this.u;
        if (iArr2 != null && iArr2.length > 0) {
            int i5 = 0;
            while (true) {
                iArr = this.u;
                if (i2 >= iArr.length) {
                    break;
                }
                i5 += c4.t(iArr[i2]);
                i2++;
            }
            l2 = l2 + i5 + (iArr.length * 2);
        }
        m4 m4Var = this.v;
        if (m4Var != null) {
            l2 += g0.C(23, m4Var);
        }
        String str5 = this.t;
        if (str5 != null && !str5.equals("")) {
            l2 += c4.h(24, this.t);
        }
        if (this.w) {
            l2 += c4.s(25) + 1;
        }
        String str6 = this.h;
        return (str6 == null || str6.equals("")) ? l2 : l2 + c4.h(26, this.h);
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final /* synthetic */ j4 e() {
        return (w4) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w4)) {
            return false;
        }
        w4 w4Var = (w4) obj;
        if (this.f3459d != w4Var.f3459d || this.f3460e != w4Var.f3460e) {
            return false;
        }
        String str = this.f3461f;
        if (str == null) {
            if (w4Var.f3461f != null) {
                return false;
            }
        } else if (!str.equals(w4Var.f3461f)) {
            return false;
        }
        if (this.f3462g != w4Var.f3462g) {
            return false;
        }
        String str2 = this.h;
        if (str2 == null) {
            if (w4Var.h != null) {
                return false;
            }
        } else if (!str2.equals(w4Var.h)) {
            return false;
        }
        if (!i4.c(this.i, w4Var.i) || !Arrays.equals(this.j, w4Var.j)) {
            return false;
        }
        l4 l4Var = this.k;
        if (l4Var == null) {
            if (w4Var.k != null) {
                return false;
            }
        } else if (!l4Var.equals(w4Var.k)) {
            return false;
        }
        if (!Arrays.equals(this.l, w4Var.l)) {
            return false;
        }
        String str3 = this.m;
        if (str3 == null) {
            if (w4Var.m != null) {
                return false;
            }
        } else if (!str3.equals(w4Var.m)) {
            return false;
        }
        String str4 = this.n;
        if (str4 == null) {
            if (w4Var.n != null) {
                return false;
            }
        } else if (!str4.equals(w4Var.n)) {
            return false;
        }
        t4 t4Var = this.o;
        if (t4Var == null) {
            if (w4Var.o != null) {
                return false;
            }
        } else if (!t4Var.equals(w4Var.o)) {
            return false;
        }
        String str5 = this.p;
        if (str5 == null) {
            if (w4Var.p != null) {
                return false;
            }
        } else if (!str5.equals(w4Var.p)) {
            return false;
        }
        if (this.q != w4Var.q) {
            return false;
        }
        u4 u4Var = this.r;
        if (u4Var == null) {
            if (w4Var.r != null) {
                return false;
            }
        } else if (!u4Var.equals(w4Var.r)) {
            return false;
        }
        if (!Arrays.equals(this.s, w4Var.s)) {
            return false;
        }
        String str6 = this.t;
        if (str6 == null) {
            if (w4Var.t != null) {
                return false;
            }
        } else if (!str6.equals(w4Var.t)) {
            return false;
        }
        if (!i4.a(this.u, w4Var.u)) {
            return false;
        }
        m4 m4Var = this.v;
        if (m4Var == null) {
            if (w4Var.v != null) {
                return false;
            }
        } else if (!m4Var.equals(w4Var.v)) {
            return false;
        }
        if (this.w != w4Var.w) {
            return false;
        }
        g4 g4Var = this.f3257c;
        if (g4Var != null && !g4Var.a()) {
            return this.f3257c.equals(w4Var.f3257c);
        }
        g4 g4Var2 = w4Var.f3257c;
        return g4Var2 == null || g4Var2.a();
    }

    /* Return type fixed from 'c.b.a.a.g.b.e4' to match base method */
    @Override // c.b.a.a.g.b.e4
    public final /* synthetic */ w4 f() {
        return (w4) clone();
    }

    public final int hashCode() {
        long j2 = this.f3459d;
        long j3 = this.f3460e;
        int hashCode = (((((w4.class.getName().hashCode() + 527) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31 * 31;
        String str = this.f3461f;
        int i2 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f3462g) * 31;
        String str2 = this.h;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        int i3 = 1237;
        int hashCode4 = Arrays.hashCode(this.j) + ((((((hashCode2 + hashCode3) * 31 * 31) + 1237) * 31) + i4.d(this.i)) * 31);
        l4 l4Var = this.k;
        int hashCode5 = (Arrays.hashCode(this.l) + (((hashCode4 * 31) + (l4Var == null ? 0 : l4Var.hashCode())) * 31)) * 31;
        String str3 = this.m;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.n;
        int hashCode7 = hashCode6 + (str4 == null ? 0 : str4.hashCode());
        t4 t4Var = this.o;
        int hashCode8 = ((hashCode7 * 31) + (t4Var == null ? 0 : t4Var.hashCode())) * 31;
        String str5 = this.p;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        long j4 = this.q;
        u4 u4Var = this.r;
        int hashCode10 = (Arrays.hashCode(this.s) + ((((((hashCode8 + hashCode9) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (u4Var == null ? 0 : u4Var.hashCode())) * 31)) * 31;
        String str6 = this.t;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31 * 31;
        int[] iArr = this.u;
        int hashCode12 = (iArr == null || iArr.length == 0) ? 0 : Arrays.hashCode(iArr);
        m4 m4Var = this.v;
        int hashCode13 = (((hashCode11 + hashCode12) * 31 * 31) + (m4Var == null ? 0 : m4Var.hashCode())) * 31;
        if (this.w) {
            i3 = 1231;
        }
        int i4 = (hashCode13 + i3) * 31;
        g4 g4Var = this.f3257c;
        if (g4Var != null && !g4Var.a()) {
            i2 = this.f3257c.hashCode();
        }
        return i4 + i2;
    }
}
