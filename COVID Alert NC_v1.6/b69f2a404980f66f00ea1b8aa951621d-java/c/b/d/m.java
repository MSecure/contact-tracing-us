package c.b.d;

import androidx.recyclerview.widget.RecyclerView;
import c.b.d.v2;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class m extends h {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f3991b = Logger.getLogger(m.class.getName());

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3992c = u2.h;

    /* renamed from: a  reason: collision with root package name */
    public n f3993a;

    public static abstract class b extends m {

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3994d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3995e;
        public int f;
        public int g;

        public b(int i) {
            super(null);
            if (i >= 0) {
                int max = Math.max(i, 20);
                this.f3994d = new byte[max];
                this.f3995e = max;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        @Override // c.b.d.m
        public final int W() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void w0(int i) {
            byte[] bArr = this.f3994d;
            int i2 = this.f;
            int i3 = i2 + 1;
            this.f = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            this.f = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            this.f = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.f = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
            this.g += 4;
        }

        public final void x0(long j) {
            byte[] bArr = this.f3994d;
            int i = this.f;
            int i2 = i + 1;
            this.f = i2;
            bArr[i] = (byte) ((int) (j & 255));
            int i3 = i2 + 1;
            this.f = i3;
            bArr[i2] = (byte) ((int) ((j >> 8) & 255));
            int i4 = i3 + 1;
            this.f = i4;
            bArr[i3] = (byte) ((int) ((j >> 16) & 255));
            int i5 = i4 + 1;
            this.f = i5;
            bArr[i4] = (byte) ((int) (255 & (j >> 24)));
            int i6 = i5 + 1;
            this.f = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            this.f = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            this.f = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.f = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            this.g += 8;
        }

        public final void y0(int i) {
            if (m.f3992c) {
                long j = (long) this.f;
                while ((i & -128) != 0) {
                    byte[] bArr = this.f3994d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    u2.t(bArr, (long) i2, (byte) ((i & 127) | RecyclerView.d0.FLAG_IGNORE));
                    i >>>= 7;
                }
                byte[] bArr2 = this.f3994d;
                int i3 = this.f;
                this.f = i3 + 1;
                u2.t(bArr2, (long) i3, (byte) i);
                this.g += (int) (((long) this.f) - j);
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.f3994d;
                int i4 = this.f;
                this.f = i4 + 1;
                bArr3[i4] = (byte) ((i & 127) | RecyclerView.d0.FLAG_IGNORE);
                this.g++;
                i >>>= 7;
            }
            byte[] bArr4 = this.f3994d;
            int i5 = this.f;
            this.f = i5 + 1;
            bArr4[i5] = (byte) i;
            this.g++;
        }

        public final void z0(long j) {
            if (m.f3992c) {
                long j2 = (long) this.f;
                while ((j & -128) != 0) {
                    byte[] bArr = this.f3994d;
                    int i = this.f;
                    this.f = i + 1;
                    u2.t(bArr, (long) i, (byte) ((((int) j) & 127) | RecyclerView.d0.FLAG_IGNORE));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f3994d;
                int i2 = this.f;
                this.f = i2 + 1;
                u2.t(bArr2, (long) i2, (byte) ((int) j));
                this.g += (int) (((long) this.f) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.f3994d;
                int i3 = this.f;
                this.f = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | RecyclerView.d0.FLAG_IGNORE);
                this.g++;
                j >>>= 7;
            }
            byte[] bArr4 = this.f3994d;
            int i4 = this.f;
            this.f = i4 + 1;
            bArr4[i4] = (byte) ((int) j);
            this.g++;
        }
    }

    public static class c extends m {

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3996d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3997e;
        public int f;

        public c(byte[] bArr, int i, int i2) {
            super(null);
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f3996d = bArr;
                    this.f = i;
                    this.f3997e = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // c.b.d.m
        public final int W() {
            return this.f3997e - this.f;
        }

        @Override // c.b.d.m
        public final void X(byte b2) {
            try {
                byte[] bArr = this.f3996d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3997e), 1), e2);
            }
        }

        @Override // c.b.d.m
        public final void Y(int i, boolean z) {
            t0((i << 3) | 0);
            X(z ? (byte) 1 : 0);
        }

        @Override // c.b.d.m
        public final void Z(byte[] bArr, int i, int i2) {
            t0(i2);
            w0(bArr, i, i2);
        }

        @Override // c.b.d.h
        public final void a(byte[] bArr, int i, int i2) {
            w0(bArr, i, i2);
        }

        @Override // c.b.d.m
        public final void a0(int i, j jVar) {
            t0((i << 3) | 2);
            b0(jVar);
        }

        @Override // c.b.d.m
        public final void b0(j jVar) {
            t0(jVar.size());
            jVar.w(this);
        }

        @Override // c.b.d.m
        public final void d0(int i, int i2) {
            t0((i << 3) | 5);
            e0(i2);
        }

        @Override // c.b.d.m
        public final void e0(int i) {
            try {
                byte[] bArr = this.f3996d;
                int i2 = this.f;
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) (i & 255);
                byte[] bArr2 = this.f3996d;
                int i4 = i3 + 1;
                this.f = i4;
                bArr2[i3] = (byte) ((i >> 8) & 255);
                byte[] bArr3 = this.f3996d;
                int i5 = i4 + 1;
                this.f = i5;
                bArr3[i4] = (byte) ((i >> 16) & 255);
                byte[] bArr4 = this.f3996d;
                this.f = i5 + 1;
                bArr4[i5] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3997e), 1), e2);
            }
        }

        @Override // c.b.d.m
        public final void f0(int i, long j) {
            t0((i << 3) | 1);
            g0(j);
        }

        @Override // c.b.d.m
        public final void g0(long j) {
            try {
                byte[] bArr = this.f3996d;
                int i = this.f;
                int i2 = i + 1;
                this.f = i2;
                bArr[i] = (byte) (((int) j) & 255);
                byte[] bArr2 = this.f3996d;
                int i3 = i2 + 1;
                this.f = i3;
                bArr2[i2] = (byte) (((int) (j >> 8)) & 255);
                byte[] bArr3 = this.f3996d;
                int i4 = i3 + 1;
                this.f = i4;
                bArr3[i3] = (byte) (((int) (j >> 16)) & 255);
                byte[] bArr4 = this.f3996d;
                int i5 = i4 + 1;
                this.f = i5;
                bArr4[i4] = (byte) (((int) (j >> 24)) & 255);
                byte[] bArr5 = this.f3996d;
                int i6 = i5 + 1;
                this.f = i6;
                bArr5[i5] = (byte) (((int) (j >> 32)) & 255);
                byte[] bArr6 = this.f3996d;
                int i7 = i6 + 1;
                this.f = i7;
                bArr6[i6] = (byte) (((int) (j >> 40)) & 255);
                byte[] bArr7 = this.f3996d;
                int i8 = i7 + 1;
                this.f = i8;
                bArr7[i7] = (byte) (((int) (j >> 48)) & 255);
                byte[] bArr8 = this.f3996d;
                this.f = i8 + 1;
                bArr8[i8] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3997e), 1), e2);
            }
        }

        @Override // c.b.d.m
        public final void i0(int i, int i2) {
            t0((i << 3) | 0);
            if (i2 >= 0) {
                t0(i2);
            } else {
                v0((long) i2);
            }
        }

        @Override // c.b.d.m
        public final void j0(int i) {
            if (i >= 0) {
                t0(i);
            } else {
                v0((long) i);
            }
        }

        @Override // c.b.d.m
        public final void k0(int i, h1 h1Var) {
            t0((i << 3) | 2);
            t0(h1Var.getSerializedSize());
            h1Var.writeTo(this);
        }

        @Override // c.b.d.m
        public final void l0(int i, h1 h1Var, c2 c2Var) {
            t0((i << 3) | 2);
            t0(((b) h1Var).getSerializedSize(c2Var));
            c2Var.j(h1Var, this.f3993a);
        }

        @Override // c.b.d.m
        public final void m0(h1 h1Var) {
            t0(h1Var.getSerializedSize());
            h1Var.writeTo(this);
        }

        @Override // c.b.d.m
        public final void n0(int i, h1 h1Var) {
            r0(1, 3);
            s0(2, i);
            k0(3, h1Var);
            r0(1, 4);
        }

        @Override // c.b.d.m
        public final void o0(int i, j jVar) {
            r0(1, 3);
            s0(2, i);
            a0(3, jVar);
            r0(1, 4);
        }

        @Override // c.b.d.m
        public final void p0(int i, String str) {
            t0((i << 3) | 2);
            q0(str);
        }

        @Override // c.b.d.m
        public final void q0(String str) {
            int c2;
            int i = this.f;
            try {
                int P = m.P(str.length() * 3);
                int P2 = m.P(str.length());
                if (P2 == P) {
                    int i2 = i + P2;
                    this.f = i2;
                    c2 = v2.c(str, this.f3996d, i2, W());
                    this.f = i;
                    t0((c2 - i) - P2);
                } else {
                    t0(v2.d(str));
                    c2 = v2.c(str, this.f3996d, this.f, W());
                }
                this.f = c2;
            } catch (v2.c e2) {
                this.f = i;
                U(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new d(e3);
            }
        }

        @Override // c.b.d.m
        public final void r0(int i, int i2) {
            t0((i << 3) | i2);
        }

        @Override // c.b.d.m
        public final void s0(int i, int i2) {
            t0((i << 3) | 0);
            t0(i2);
        }

        @Override // c.b.d.m
        public final void t0(int i) {
            if (!m.f3992c || e.a() || W() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f3996d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | RecyclerView.d0.FLAG_IGNORE);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3996d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3997e), 1), e2);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.f3996d;
                int i4 = this.f;
                this.f = i4 + 1;
                u2.t(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.f3996d;
                int i5 = this.f;
                this.f = i5 + 1;
                u2.t(bArr4, (long) i5, (byte) (i | RecyclerView.d0.FLAG_IGNORE));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.f3996d;
                    int i7 = this.f;
                    this.f = i7 + 1;
                    u2.t(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.f3996d;
                int i8 = this.f;
                this.f = i8 + 1;
                u2.t(bArr6, (long) i8, (byte) (i6 | RecyclerView.d0.FLAG_IGNORE));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.f3996d;
                    int i10 = this.f;
                    this.f = i10 + 1;
                    u2.t(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.f3996d;
                int i11 = this.f;
                this.f = i11 + 1;
                u2.t(bArr8, (long) i11, (byte) (i9 | RecyclerView.d0.FLAG_IGNORE));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.f3996d;
                    int i13 = this.f;
                    this.f = i13 + 1;
                    u2.t(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.f3996d;
                int i14 = this.f;
                this.f = i14 + 1;
                u2.t(bArr10, (long) i14, (byte) (i12 | RecyclerView.d0.FLAG_IGNORE));
                byte[] bArr11 = this.f3996d;
                int i15 = this.f;
                this.f = i15 + 1;
                u2.t(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // c.b.d.m
        public final void u0(int i, long j) {
            t0((i << 3) | 0);
            v0(j);
        }

        @Override // c.b.d.m
        public final void v0(long j) {
            if (!m.f3992c || W() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f3996d;
                    int i = this.f;
                    this.f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | RecyclerView.d0.FLAG_IGNORE);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3996d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3997e), 1), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f3996d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    u2.t(bArr3, (long) i3, (byte) ((((int) j) & 127) | RecyclerView.d0.FLAG_IGNORE));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f3996d;
                int i4 = this.f;
                this.f = i4 + 1;
                u2.t(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void w0(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f3996d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.f3997e), Integer.valueOf(i2)), e2);
            }
        }
    }

    public static class d extends IOException {
        public d(String str, Throwable th) {
            super(c.a.a.a.a.o("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th);
        }

        public d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public static final class e extends b {
        public final OutputStream h;

        public e(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.h = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        public final void A0() {
            this.h.write(this.f3994d, 0, this.f);
            this.f = 0;
        }

        public final void B0(int i) {
            if (this.f3995e - this.f < i) {
                A0();
            }
        }

        public void C0(byte[] bArr, int i, int i2) {
            int i3 = this.f3995e;
            int i4 = this.f;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.f3994d, i4, i2);
                this.f += i2;
            } else {
                int i5 = i3 - i4;
                System.arraycopy(bArr, i, this.f3994d, i4, i5);
                int i6 = i + i5;
                i2 -= i5;
                this.f = this.f3995e;
                this.g += i5;
                A0();
                if (i2 <= this.f3995e) {
                    System.arraycopy(bArr, i6, this.f3994d, 0, i2);
                    this.f = i2;
                } else {
                    this.h.write(bArr, i6, i2);
                }
            }
            this.g += i2;
        }

        @Override // c.b.d.m
        public void X(byte b2) {
            if (this.f == this.f3995e) {
                A0();
            }
            byte[] bArr = this.f3994d;
            int i = this.f;
            this.f = i + 1;
            bArr[i] = b2;
            this.g++;
        }

        @Override // c.b.d.m
        public void Y(int i, boolean z) {
            B0(11);
            y0((i << 3) | 0);
            byte b2 = z ? (byte) 1 : 0;
            byte[] bArr = this.f3994d;
            int i2 = this.f;
            this.f = i2 + 1;
            bArr[i2] = b2;
            this.g++;
        }

        @Override // c.b.d.m
        public void Z(byte[] bArr, int i, int i2) {
            B0(5);
            y0(i2);
            C0(bArr, i, i2);
        }

        @Override // c.b.d.h
        public void a(byte[] bArr, int i, int i2) {
            C0(bArr, i, i2);
        }

        @Override // c.b.d.m
        public void a0(int i, j jVar) {
            t0((i << 3) | 2);
            b0(jVar);
        }

        @Override // c.b.d.m
        public void b0(j jVar) {
            t0(jVar.size());
            jVar.w(this);
        }

        @Override // c.b.d.m
        public void d0(int i, int i2) {
            B0(14);
            y0((i << 3) | 5);
            w0(i2);
        }

        @Override // c.b.d.m
        public void e0(int i) {
            B0(4);
            w0(i);
        }

        @Override // c.b.d.m
        public void f0(int i, long j) {
            B0(18);
            y0((i << 3) | 1);
            x0(j);
        }

        @Override // c.b.d.m
        public void g0(long j) {
            B0(8);
            x0(j);
        }

        @Override // c.b.d.m
        public void i0(int i, int i2) {
            B0(20);
            y0((i << 3) | 0);
            if (i2 >= 0) {
                y0(i2);
            } else {
                z0((long) i2);
            }
        }

        @Override // c.b.d.m
        public void j0(int i) {
            if (i >= 0) {
                B0(5);
                y0(i);
                return;
            }
            v0((long) i);
        }

        @Override // c.b.d.m
        public void k0(int i, h1 h1Var) {
            t0((i << 3) | 2);
            t0(h1Var.getSerializedSize());
            h1Var.writeTo(this);
        }

        @Override // c.b.d.m
        public void l0(int i, h1 h1Var, c2 c2Var) {
            t0((i << 3) | 2);
            t0(((b) h1Var).getSerializedSize(c2Var));
            c2Var.j(h1Var, this.f3993a);
        }

        @Override // c.b.d.m
        public void m0(h1 h1Var) {
            t0(h1Var.getSerializedSize());
            h1Var.writeTo(this);
        }

        @Override // c.b.d.m
        public void n0(int i, h1 h1Var) {
            r0(1, 3);
            s0(2, i);
            k0(3, h1Var);
            r0(1, 4);
        }

        @Override // c.b.d.m
        public void o0(int i, j jVar) {
            r0(1, 3);
            s0(2, i);
            a0(3, jVar);
            r0(1, 4);
        }

        @Override // c.b.d.m
        public void p0(int i, String str) {
            t0((i << 3) | 2);
            q0(str);
        }

        @Override // c.b.d.m
        public void q0(String str) {
            int i;
            try {
                int length = str.length() * 3;
                int P = m.P(length);
                int i2 = P + length;
                if (i2 > this.f3995e) {
                    byte[] bArr = new byte[length];
                    int c2 = v2.c(str, bArr, 0, length);
                    t0(c2);
                    C0(bArr, 0, c2);
                    return;
                }
                if (i2 > this.f3995e - this.f) {
                    A0();
                }
                int P2 = m.P(str.length());
                int i3 = this.f;
                if (P2 == P) {
                    int i4 = i3 + P2;
                    try {
                        this.f = i4;
                        int c3 = v2.c(str, this.f3994d, i4, this.f3995e - i4);
                        this.f = i3;
                        i = (c3 - i3) - P2;
                        y0(i);
                        this.f = c3;
                    } catch (v2.c e2) {
                        this.g -= this.f - i3;
                        this.f = i3;
                        throw e2;
                    } catch (ArrayIndexOutOfBoundsException e3) {
                        throw new d(e3);
                    }
                } else {
                    i = v2.d(str);
                    y0(i);
                    this.f = v2.c(str, this.f3994d, this.f, i);
                }
                this.g += i;
            } catch (v2.c e4) {
                U(str, e4);
            }
        }

        @Override // c.b.d.m
        public void r0(int i, int i2) {
            t0((i << 3) | i2);
        }

        @Override // c.b.d.m
        public void s0(int i, int i2) {
            B0(20);
            y0((i << 3) | 0);
            y0(i2);
        }

        @Override // c.b.d.m
        public void t0(int i) {
            B0(5);
            y0(i);
        }

        @Override // c.b.d.m
        public void u0(int i, long j) {
            B0(20);
            y0((i << 3) | 0);
            z0(j);
        }

        @Override // c.b.d.m
        public void v0(long j) {
            B0(10);
            z0(j);
        }
    }

    public m() {
    }

    public m(a aVar) {
    }

    public static int A(h1 h1Var) {
        return x(h1Var.getSerializedSize());
    }

    public static int B(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int C(int i, j jVar) {
        int O = O(2, i);
        return f(3, jVar) + O + (N(1) * 2);
    }

    public static int D(int i, int i2) {
        return N(i) + 4;
    }

    public static int E() {
        return 4;
    }

    public static int F(int i, long j) {
        return N(i) + 8;
    }

    public static int G() {
        return 8;
    }

    public static int H(int i, int i2) {
        return I(i2) + N(i);
    }

    public static int I(int i) {
        return P(S(i));
    }

    public static int J(int i, long j) {
        return K(j) + N(i);
    }

    public static int K(long j) {
        return R(T(j));
    }

    public static int L(int i, String str) {
        return M(str) + N(i);
    }

    public static int M(String str) {
        int i;
        try {
            i = v2.d(str);
        } catch (v2.c unused) {
            i = str.getBytes(m0.f3998a).length;
        }
        return x(i);
    }

    public static int N(int i) {
        return P((i << 3) | 0);
    }

    public static int O(int i, int i2) {
        return P(i2) + N(i);
    }

    public static int P(int i) {
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

    public static int Q(int i, long j) {
        return R(j) + N(i);
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

    public static int S(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long T(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static m V(byte[] bArr) {
        return new c(bArr, 0, bArr.length);
    }

    public static int c(int i, boolean z) {
        return N(i) + 1;
    }

    public static int d() {
        return 1;
    }

    public static int e(byte[] bArr) {
        return x(bArr.length);
    }

    public static int f(int i, j jVar) {
        return N(i) + x(jVar.size());
    }

    public static int g(j jVar) {
        return x(jVar.size());
    }

    public static int h(int i, double d2) {
        return N(i) + 8;
    }

    public static int i() {
        return 8;
    }

    public static int j(int i, int i2) {
        return N(i) + t(i2);
    }

    public static int k(int i, int i2) {
        return N(i) + 4;
    }

    public static int l() {
        return 4;
    }

    public static int m(int i, long j) {
        return N(i) + 8;
    }

    public static int n() {
        return 8;
    }

    public static int o(int i, float f) {
        return N(i) + 4;
    }

    public static int p() {
        return 4;
    }

    @Deprecated
    public static int q(int i, h1 h1Var, c2 c2Var) {
        return (N(i) * 2) + ((b) h1Var).getSerializedSize(c2Var);
    }

    @Deprecated
    public static int r(h1 h1Var) {
        return h1Var.getSerializedSize();
    }

    public static int s(int i, int i2) {
        return t(i2) + N(i);
    }

    public static int t(int i) {
        if (i >= 0) {
            return P(i);
        }
        return 10;
    }

    public static int u(int i, long j) {
        return N(i) + R(j);
    }

    public static int v(int i, q0 q0Var) {
        return w(q0Var) + N(i);
    }

    public static int w(q0 q0Var) {
        int i;
        if (q0Var.f4055d != null) {
            i = q0Var.f4055d.size();
        } else {
            j jVar = q0Var.f4052a;
            i = jVar != null ? jVar.size() : q0Var.f4054c != null ? q0Var.f4054c.getSerializedSize() : 0;
        }
        return x(i);
    }

    public static int x(int i) {
        return P(i) + i;
    }

    public static int y(int i, h1 h1Var) {
        int O = O(2, i);
        return z(3, h1Var) + O + (N(1) * 2);
    }

    public static int z(int i, h1 h1Var) {
        return N(i) + x(h1Var.getSerializedSize());
    }

    public final void U(String str, v2.c cVar) {
        f3991b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) cVar);
        byte[] bytes = str.getBytes(m0.f3998a);
        try {
            t0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new d(e2);
        } catch (d e3) {
            throw e3;
        }
    }

    public abstract int W();

    public abstract void X(byte b2);

    public abstract void Y(int i, boolean z);

    public abstract void Z(byte[] bArr, int i, int i2);

    public abstract void a0(int i, j jVar);

    public final void b() {
        if (W() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void b0(j jVar);

    public final void c0(int i, double d2) {
        f0(i, Double.doubleToRawLongBits(d2));
    }

    public abstract void d0(int i, int i2);

    public abstract void e0(int i);

    public abstract void f0(int i, long j);

    public abstract void g0(long j);

    @Deprecated
    public final void h0(int i, h1 h1Var) {
        r0(i, 3);
        h1Var.writeTo(this);
        r0(i, 4);
    }

    public abstract void i0(int i, int i2);

    public abstract void j0(int i);

    public abstract void k0(int i, h1 h1Var);

    public abstract void l0(int i, h1 h1Var, c2 c2Var);

    public abstract void m0(h1 h1Var);

    public abstract void n0(int i, h1 h1Var);

    public abstract void o0(int i, j jVar);

    public abstract void p0(int i, String str);

    public abstract void q0(String str);

    public abstract void r0(int i, int i2);

    public abstract void s0(int i, int i2);

    public abstract void t0(int i);

    public abstract void u0(int i, long j);

    public abstract void v0(long j);
}
