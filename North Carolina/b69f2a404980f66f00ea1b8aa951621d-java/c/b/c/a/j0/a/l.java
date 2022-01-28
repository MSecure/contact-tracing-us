package c.b.c.a.j0.a;

import androidx.recyclerview.widget.RecyclerView;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.q1;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class l extends g {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f3599b = Logger.getLogger(l.class.getName());

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3600c = p1.h;

    /* renamed from: a  reason: collision with root package name */
    public m f3601a;

    public static class b extends l {

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3602d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3603e;
        public int f;

        public b(byte[] bArr, int i, int i2) {
            super(null);
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f3602d = bArr;
                    this.f = i;
                    this.f3603e = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // c.b.c.a.j0.a.l
        public final int O() {
            return this.f3603e - this.f;
        }

        @Override // c.b.c.a.j0.a.l
        public final void P(byte b2) {
            try {
                byte[] bArr = this.f3602d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3603e), 1), e2);
            }
        }

        @Override // c.b.c.a.j0.a.l
        public final void R(int i) {
            try {
                byte[] bArr = this.f3602d;
                int i2 = this.f;
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) (i & 255);
                byte[] bArr2 = this.f3602d;
                int i4 = i3 + 1;
                this.f = i4;
                bArr2[i3] = (byte) ((i >> 8) & 255);
                byte[] bArr3 = this.f3602d;
                int i5 = i4 + 1;
                this.f = i5;
                bArr3[i4] = (byte) ((i >> 16) & 255);
                byte[] bArr4 = this.f3602d;
                this.f = i5 + 1;
                bArr4[i5] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3603e), 1), e2);
            }
        }

        @Override // c.b.c.a.j0.a.l
        public final void S(long j) {
            try {
                byte[] bArr = this.f3602d;
                int i = this.f;
                int i2 = i + 1;
                this.f = i2;
                bArr[i] = (byte) (((int) j) & 255);
                byte[] bArr2 = this.f3602d;
                int i3 = i2 + 1;
                this.f = i3;
                bArr2[i2] = (byte) (((int) (j >> 8)) & 255);
                byte[] bArr3 = this.f3602d;
                int i4 = i3 + 1;
                this.f = i4;
                bArr3[i3] = (byte) (((int) (j >> 16)) & 255);
                byte[] bArr4 = this.f3602d;
                int i5 = i4 + 1;
                this.f = i5;
                bArr4[i4] = (byte) (((int) (j >> 24)) & 255);
                byte[] bArr5 = this.f3602d;
                int i6 = i5 + 1;
                this.f = i6;
                bArr5[i5] = (byte) (((int) (j >> 32)) & 255);
                byte[] bArr6 = this.f3602d;
                int i7 = i6 + 1;
                this.f = i7;
                bArr6[i6] = (byte) (((int) (j >> 40)) & 255);
                byte[] bArr7 = this.f3602d;
                int i8 = i7 + 1;
                this.f = i8;
                bArr7[i7] = (byte) (((int) (j >> 48)) & 255);
                byte[] bArr8 = this.f3602d;
                this.f = i8 + 1;
                bArr8[i8] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3603e), 1), e2);
            }
        }

        @Override // c.b.c.a.j0.a.l
        public final void T(int i, int i2) {
            V((i << 3) | 0);
            if (i2 >= 0) {
                V(i2);
            } else {
                W((long) i2);
            }
        }

        @Override // c.b.c.a.j0.a.l
        public final void U(int i) {
            if (i >= 0) {
                V(i);
            } else {
                W((long) i);
            }
        }

        @Override // c.b.c.a.j0.a.l
        public final void V(int i) {
            if (!l.f3600c || d.a() || O() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f3602d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | RecyclerView.d0.FLAG_IGNORE);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3602d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3603e), 1), e2);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.f3602d;
                int i4 = this.f;
                this.f = i4 + 1;
                p1.q(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.f3602d;
                int i5 = this.f;
                this.f = i5 + 1;
                p1.q(bArr4, (long) i5, (byte) (i | RecyclerView.d0.FLAG_IGNORE));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.f3602d;
                    int i7 = this.f;
                    this.f = i7 + 1;
                    p1.q(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.f3602d;
                int i8 = this.f;
                this.f = i8 + 1;
                p1.q(bArr6, (long) i8, (byte) (i6 | RecyclerView.d0.FLAG_IGNORE));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.f3602d;
                    int i10 = this.f;
                    this.f = i10 + 1;
                    p1.q(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.f3602d;
                int i11 = this.f;
                this.f = i11 + 1;
                p1.q(bArr8, (long) i11, (byte) (i9 | RecyclerView.d0.FLAG_IGNORE));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.f3602d;
                    int i13 = this.f;
                    this.f = i13 + 1;
                    p1.q(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.f3602d;
                int i14 = this.f;
                this.f = i14 + 1;
                p1.q(bArr10, (long) i14, (byte) (i12 | RecyclerView.d0.FLAG_IGNORE));
                byte[] bArr11 = this.f3602d;
                int i15 = this.f;
                this.f = i15 + 1;
                p1.q(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // c.b.c.a.j0.a.l
        public final void W(long j) {
            if (!l.f3600c || O() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f3602d;
                    int i = this.f;
                    this.f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | RecyclerView.d0.FLAG_IGNORE);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3602d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3603e), 1), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f3602d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    p1.q(bArr3, (long) i3, (byte) ((((int) j) & 127) | RecyclerView.d0.FLAG_IGNORE));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f3602d;
                int i4 = this.f;
                this.f = i4 + 1;
                p1.q(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void X(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f3602d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3603e), Integer.valueOf(i2)), e2);
            }
        }

        public final void Y(int i, i iVar) {
            V((i << 3) | 2);
            Z(iVar);
        }

        public final void Z(i iVar) {
            V(iVar.size());
            i.g gVar = (i.g) iVar;
            X(gVar.f3569e, gVar.u(), gVar.size());
        }

        public final void a0(String str) {
            int i;
            int i2 = this.f;
            try {
                int I = l.I(str.length() * 3);
                int I2 = l.I(str.length());
                if (I2 == I) {
                    int i3 = i2 + I2;
                    this.f = i3;
                    i = q1.f3635a.b(str, this.f3602d, i3, O());
                    this.f = i2;
                    V((i - i2) - I2);
                } else {
                    V(q1.d(str));
                    i = q1.f3635a.b(str, this.f3602d, this.f, O());
                }
                this.f = i;
            } catch (q1.c e2) {
                this.f = i2;
                l.f3599b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e2);
                byte[] bytes = str.getBytes(a0.f3518a);
                try {
                    V(bytes.length);
                    X(bytes, 0, bytes.length);
                } catch (IndexOutOfBoundsException e3) {
                    throw new c(e3);
                } catch (c e4) {
                    throw e4;
                }
            } catch (IndexOutOfBoundsException e5) {
                throw new c(e5);
            }
        }

        public final void b0(int i, int i2) {
            V((i << 3) | i2);
        }

        public final void c0(int i, int i2) {
            V((i << 3) | 0);
            V(i2);
        }
    }

    public static class c extends IOException {
        public c(String str, Throwable th) {
            super(c.a.a.a.a.o("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th);
        }

        public c(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public l() {
    }

    public l(a aVar) {
    }

    public static int A(int i, int i2) {
        return B(i2) + G(i);
    }

    public static int B(int i) {
        return I(L(i));
    }

    public static int C(int i, long j) {
        return D(j) + G(i);
    }

    public static int D(long j) {
        return K(M(j));
    }

    public static int E(int i, String str) {
        return F(str) + G(i);
    }

    public static int F(String str) {
        int i;
        try {
            i = q1.d(str);
        } catch (q1.c unused) {
            i = str.getBytes(a0.f3518a).length;
        }
        return u(i);
    }

    public static int G(int i) {
        return I((i << 3) | 0);
    }

    public static int H(int i, int i2) {
        return I(i2) + G(i);
    }

    public static int I(int i) {
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

    public static int J(int i, long j) {
        return K(j) + G(i);
    }

    public static int K(long j) {
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

    public static int L(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long M(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static l N(byte[] bArr) {
        return new b(bArr, 0, bArr.length);
    }

    public static int a(int i, boolean z) {
        return G(i) + 1;
    }

    public static int b() {
        return 1;
    }

    public static int c(byte[] bArr) {
        return u(bArr.length);
    }

    public static int d(int i, i iVar) {
        return G(i) + u(iVar.size());
    }

    public static int e(i iVar) {
        return u(iVar.size());
    }

    public static int f(int i, double d2) {
        return G(i) + 8;
    }

    public static int g() {
        return 8;
    }

    public static int h(int i, int i2) {
        return G(i) + r(i2);
    }

    public static int i(int i, int i2) {
        return G(i) + 4;
    }

    public static int j() {
        return 4;
    }

    public static int k(int i, long j) {
        return G(i) + 8;
    }

    public static int l() {
        return 8;
    }

    public static int m(int i, float f) {
        return G(i) + 4;
    }

    public static int n() {
        return 4;
    }

    @Deprecated
    public static int o(int i, r0 r0Var, f1 f1Var) {
        return (G(i) * 2) + ((a) r0Var).b(f1Var);
    }

    @Deprecated
    public static int p(r0 r0Var) {
        return r0Var.getSerializedSize();
    }

    public static int q(int i, int i2) {
        return r(i2) + G(i);
    }

    public static int r(int i) {
        if (i >= 0) {
            return I(i);
        }
        return 10;
    }

    public static int s(int i, long j) {
        return G(i) + K(j);
    }

    public static int t(e0 e0Var) {
        int i;
        if (e0Var.f3548c != null) {
            i = e0Var.f3548c.size();
        } else {
            i iVar = e0Var.f3546a;
            i = iVar != null ? iVar.size() : e0Var.f3547b != null ? e0Var.f3547b.getSerializedSize() : 0;
        }
        return u(i);
    }

    public static int u(int i) {
        return I(i) + i;
    }

    public static int v(r0 r0Var) {
        return u(r0Var.getSerializedSize());
    }

    public static int w(int i, int i2) {
        return G(i) + 4;
    }

    public static int x() {
        return 4;
    }

    public static int y(int i, long j) {
        return G(i) + 8;
    }

    public static int z() {
        return 8;
    }

    public abstract int O();

    public abstract void P(byte b2);

    public final void Q(int i) {
        b bVar = (b) this;
        if (i >= 0) {
            bVar.V(i);
        } else {
            bVar.W((long) i);
        }
    }

    public abstract void R(int i);

    public abstract void S(long j);

    public abstract void T(int i, int i2);

    public abstract void U(int i);

    public abstract void V(int i);

    public abstract void W(long j);
}
