package c.b.a.a.g.h;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class b1 extends r0 {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f3842b = Logger.getLogger(b1.class.getName());

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3843c = j4.h;

    /* renamed from: a  reason: collision with root package name */
    public d1 f3844a;

    public static class a extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        public a(String str, Throwable th) {
            super(r3.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(r3) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
            String valueOf = String.valueOf(str);
        }

        public a(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public static class b extends b1 {

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3845d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3846e;

        /* renamed from: f  reason: collision with root package name */
        public int f3847f;

        public b(byte[] bArr, int i) {
            super(null);
            if ((i | 0 | (bArr.length - i)) >= 0) {
                this.f3845d = bArr;
                this.f3847f = 0;
                this.f3846e = i;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }

        @Override // c.b.a.a.g.h.b1
        public final int E() {
            return this.f3846e - this.f3847f;
        }

        @Override // c.b.a.a.g.h.b1
        public final void G(int i, int i2) {
            k((i << 3) | 0);
            if (i2 >= 0) {
                k(i2);
            } else {
                O((long) i2);
            }
        }

        @Override // c.b.a.a.g.h.b1
        public final void O(long j) {
            if (!b1.f3843c || E() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f3845d;
                    int i = this.f3847f;
                    this.f3847f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | RecyclerView.a0.FLAG_IGNORE);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3845d;
                    int i2 = this.f3847f;
                    this.f3847f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3847f), Integer.valueOf(this.f3846e), 1), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f3845d;
                    int i3 = this.f3847f;
                    this.f3847f = i3 + 1;
                    j4.f(bArr3, (long) i3, (byte) ((((int) j) & 127) | RecyclerView.a0.FLAG_IGNORE));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f3845d;
                int i4 = this.f3847f;
                this.f3847f = i4 + 1;
                j4.f(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        @Override // c.b.a.a.g.h.b1
        public final void Q(long j) {
            try {
                byte[] bArr = this.f3845d;
                int i = this.f3847f;
                int i2 = i + 1;
                this.f3847f = i2;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.f3845d;
                int i3 = i2 + 1;
                this.f3847f = i3;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.f3845d;
                int i4 = i3 + 1;
                this.f3847f = i4;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.f3845d;
                int i5 = i4 + 1;
                this.f3847f = i5;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.f3845d;
                int i6 = i5 + 1;
                this.f3847f = i6;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.f3845d;
                int i7 = i6 + 1;
                this.f3847f = i7;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.f3845d;
                int i8 = i7 + 1;
                this.f3847f = i8;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.f3845d;
                this.f3847f = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3847f), Integer.valueOf(this.f3846e), 1), e2);
            }
        }

        public final void W(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f3845d, this.f3847f, i2);
                this.f3847f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3847f), Integer.valueOf(this.f3846e), Integer.valueOf(i2)), e2);
            }
        }

        public final void X(int i, int i2) {
            k((i << 3) | i2);
        }

        public final void Y(int i, q0 q0Var) {
            k((i << 3) | 2);
            Z(q0Var);
        }

        public final void Z(q0 q0Var) {
            k(q0Var.size());
            x0 x0Var = (x0) q0Var;
            W(x0Var.f4062e, x0Var.p(), x0Var.size());
        }

        public final void a0(c3 c3Var) {
            k(c3Var.d());
            c3Var.f(this);
        }

        public final void b0(int i, int i2) {
            k((i << 3) | 0);
            k(i2);
        }

        public final void c0(String str) {
            int i = this.f3847f;
            try {
                int o = b1.o(str.length() * 3);
                int o2 = b1.o(str.length());
                if (o2 == o) {
                    int i2 = i + o2;
                    this.f3847f = i2;
                    int b2 = k4.f3928a.b(str, this.f3845d, i2, E());
                    this.f3847f = i;
                    k((b2 - i) - o2);
                    this.f3847f = b2;
                    return;
                }
                k(k4.a(str));
                this.f3847f = k4.f3928a.b(str, this.f3845d, this.f3847f, E());
            } catch (o4 e2) {
                this.f3847f = i;
                b1.f3842b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e2);
                byte[] bytes = str.getBytes(u1.f4042a);
                try {
                    k(bytes.length);
                    W(bytes, 0, bytes.length);
                } catch (IndexOutOfBoundsException e3) {
                    throw new a(e3);
                } catch (a e4) {
                    throw e4;
                }
            } catch (IndexOutOfBoundsException e5) {
                throw new a(e5);
            }
        }

        @Override // c.b.a.a.g.h.b1
        public final void j(int i) {
            if (i >= 0) {
                k(i);
            } else {
                O((long) i);
            }
        }

        @Override // c.b.a.a.g.h.b1
        public final void k(int i) {
            if (!b1.f3843c || m0.a() || E() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f3845d;
                    int i2 = this.f3847f;
                    this.f3847f = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | RecyclerView.a0.FLAG_IGNORE);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3845d;
                    int i3 = this.f3847f;
                    this.f3847f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3847f), Integer.valueOf(this.f3846e), 1), e2);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.f3845d;
                int i4 = this.f3847f;
                this.f3847f = i4 + 1;
                j4.f(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.f3845d;
                int i5 = this.f3847f;
                this.f3847f = i5 + 1;
                j4.f(bArr4, (long) i5, (byte) (i | RecyclerView.a0.FLAG_IGNORE));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.f3845d;
                    int i7 = this.f3847f;
                    this.f3847f = i7 + 1;
                    j4.f(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.f3845d;
                int i8 = this.f3847f;
                this.f3847f = i8 + 1;
                j4.f(bArr6, (long) i8, (byte) (i6 | RecyclerView.a0.FLAG_IGNORE));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.f3845d;
                    int i10 = this.f3847f;
                    this.f3847f = i10 + 1;
                    j4.f(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.f3845d;
                int i11 = this.f3847f;
                this.f3847f = i11 + 1;
                j4.f(bArr8, (long) i11, (byte) (i9 | RecyclerView.a0.FLAG_IGNORE));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.f3845d;
                    int i13 = this.f3847f;
                    this.f3847f = i13 + 1;
                    j4.f(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.f3845d;
                int i14 = this.f3847f;
                this.f3847f = i14 + 1;
                j4.f(bArr10, (long) i14, (byte) (i12 | RecyclerView.a0.FLAG_IGNORE));
                byte[] bArr11 = this.f3845d;
                int i15 = this.f3847f;
                this.f3847f = i15 + 1;
                j4.f(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // c.b.a.a.g.h.b1
        public final void l(int i) {
            try {
                byte[] bArr = this.f3845d;
                int i2 = this.f3847f;
                int i3 = i2 + 1;
                this.f3847f = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f3845d;
                int i4 = i3 + 1;
                this.f3847f = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f3845d;
                int i5 = i4 + 1;
                this.f3847f = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f3845d;
                this.f3847f = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3847f), Integer.valueOf(this.f3846e), 1), e2);
            }
        }

        @Override // c.b.a.a.g.h.b1
        public final void w(byte b2) {
            try {
                byte[] bArr = this.f3845d;
                int i = this.f3847f;
                this.f3847f = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3847f), Integer.valueOf(this.f3846e), 1), e2);
            }
        }
    }

    public b1() {
    }

    public b1(a1 a1Var) {
    }

    public static b1 A(byte[] bArr) {
        return new b(bArr, bArr.length);
    }

    public static int B(int i, long j) {
        return R(c(j)) + o(i << 3);
    }

    public static int C(byte[] bArr) {
        int length = bArr.length;
        return o(length) + length;
    }

    public static int D(int i) {
        return o(i << 3) + 8;
    }

    public static int F(int i) {
        return o(i << 3) + 8;
    }

    public static int H() {
        return 1;
    }

    public static int I(int i, int i2) {
        return n(i2) + o(i << 3);
    }

    public static int J(int i, int i2) {
        return o(i2) + o(i << 3);
    }

    public static int K(int i, int i2) {
        return o(s(i2)) + o(i << 3);
    }

    public static int L(int i) {
        return o(i << 3) + 4;
    }

    public static int M(int i) {
        return o(i << 3) + 4;
    }

    public static int N(int i, int i2) {
        return n(i2) + o(i << 3);
    }

    public static int P() {
        return 4;
    }

    public static int R(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int S(long j) {
        return R(c(j));
    }

    public static int T(String str) {
        int i;
        try {
            i = k4.a(str);
        } catch (o4 unused) {
            i = str.getBytes(u1.f4042a).length;
        }
        return o(i) + i;
    }

    public static int U() {
        return 8;
    }

    public static int V() {
        return 8;
    }

    public static int a(h2 h2Var) {
        int b2 = h2Var.b();
        return o(b2) + b2;
    }

    public static int b(c3 c3Var, q3 q3Var) {
        g0 g0Var = (g0) c3Var;
        int i = ((t1) g0Var).zzya;
        if (i == -1) {
            i = q3Var.e(g0Var);
            ((t1) g0Var).zzya = i;
        }
        return o(i) + i;
    }

    public static long c(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int d() {
        return 8;
    }

    public static int e(int i) {
        return o(i << 3) + 4;
    }

    public static int f(int i, String str) {
        return T(str) + o(i << 3);
    }

    public static int g(q0 q0Var) {
        int size = q0Var.size();
        return o(size) + size;
    }

    public static int h(int i) {
        return o(i << 3) + 8;
    }

    public static int i(int i) {
        return o(i << 3) + 1;
    }

    public static int m(int i) {
        return o(i << 3);
    }

    public static int n(int i) {
        if (i >= 0) {
            return o(i);
        }
        return 10;
    }

    public static int o(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int p(int i) {
        return o(s(i));
    }

    public static int q() {
        return 4;
    }

    public static int r() {
        return 4;
    }

    public static int s(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int t(int i, q0 q0Var) {
        int o = o(i << 3);
        int size = q0Var.size();
        return o(size) + size + o;
    }

    @Deprecated
    public static int u(int i, c3 c3Var, q3 q3Var) {
        int o = o(i << 3) << 1;
        g0 g0Var = (g0) c3Var;
        int i2 = ((t1) g0Var).zzya;
        if (i2 == -1) {
            i2 = q3Var.e(g0Var);
            ((t1) g0Var).zzya = i2;
        }
        return o + i2;
    }

    public static int v(c3 c3Var) {
        int d2 = c3Var.d();
        return o(d2) + d2;
    }

    public static int x(int i, long j) {
        return R(j) + o(i << 3);
    }

    @Deprecated
    public static int y(c3 c3Var) {
        return c3Var.d();
    }

    public static int z(int i, long j) {
        return R(j) + o(i << 3);
    }

    public abstract int E();

    public abstract void G(int i, int i2);

    public abstract void O(long j);

    public abstract void Q(long j);

    public abstract void j(int i);

    public abstract void k(int i);

    public abstract void l(int i);

    public abstract void w(byte b2);
}
