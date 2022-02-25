package f.b.f;

import f.b.f.w1;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class m extends i {
    public static final Logger b = Logger.getLogger(m.class.getName());
    public static final boolean c = v1.f3378h;
    public n a;

    public static abstract class b extends m {

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3341d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3342e;

        /* renamed from: f  reason: collision with root package name */
        public int f3343f;

        /* renamed from: g  reason: collision with root package name */
        public int f3344g;

        public b(int i2) {
            super(null);
            if (i2 >= 0) {
                int max = Math.max(i2, 20);
                this.f3341d = new byte[max];
                this.f3342e = max;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        @Override // f.b.f.m
        public final int G() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void d0(int i2) {
            byte[] bArr = this.f3341d;
            int i3 = this.f3343f;
            int i4 = i3 + 1;
            this.f3343f = i4;
            bArr[i3] = (byte) (i2 & 255);
            int i5 = i4 + 1;
            this.f3343f = i5;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i5 + 1;
            this.f3343f = i6;
            bArr[i5] = (byte) ((i2 >> 16) & 255);
            this.f3343f = i6 + 1;
            bArr[i6] = (byte) ((i2 >> 24) & 255);
            this.f3344g += 4;
        }

        public final void e0(long j2) {
            byte[] bArr = this.f3341d;
            int i2 = this.f3343f;
            int i3 = i2 + 1;
            this.f3343f = i3;
            bArr[i2] = (byte) ((int) (j2 & 255));
            int i4 = i3 + 1;
            this.f3343f = i4;
            bArr[i3] = (byte) ((int) ((j2 >> 8) & 255));
            int i5 = i4 + 1;
            this.f3343f = i5;
            bArr[i4] = (byte) ((int) ((j2 >> 16) & 255));
            int i6 = i5 + 1;
            this.f3343f = i6;
            bArr[i5] = (byte) ((int) (255 & (j2 >> 24)));
            int i7 = i6 + 1;
            this.f3343f = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i7 + 1;
            this.f3343f = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i8 + 1;
            this.f3343f = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.f3343f = i9 + 1;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
            this.f3344g += 8;
        }

        public final void f0(int i2) {
            if (m.c) {
                long j2 = (long) this.f3343f;
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f3341d;
                    int i3 = this.f3343f;
                    this.f3343f = i3 + 1;
                    v1.s(bArr, (long) i3, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                byte[] bArr2 = this.f3341d;
                int i4 = this.f3343f;
                this.f3343f = i4 + 1;
                v1.s(bArr2, (long) i4, (byte) i2);
                this.f3344g += (int) (((long) this.f3343f) - j2);
                return;
            }
            while ((i2 & -128) != 0) {
                byte[] bArr3 = this.f3341d;
                int i5 = this.f3343f;
                this.f3343f = i5 + 1;
                bArr3[i5] = (byte) ((i2 & 127) | 128);
                this.f3344g++;
                i2 >>>= 7;
            }
            byte[] bArr4 = this.f3341d;
            int i6 = this.f3343f;
            this.f3343f = i6 + 1;
            bArr4[i6] = (byte) i2;
            this.f3344g++;
        }

        public final void g0(long j2) {
            if (m.c) {
                long j3 = (long) this.f3343f;
                while ((j2 & -128) != 0) {
                    byte[] bArr = this.f3341d;
                    int i2 = this.f3343f;
                    this.f3343f = i2 + 1;
                    v1.s(bArr, (long) i2, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f3341d;
                int i3 = this.f3343f;
                this.f3343f = i3 + 1;
                v1.s(bArr2, (long) i3, (byte) ((int) j2));
                this.f3344g += (int) (((long) this.f3343f) - j3);
                return;
            }
            while ((j2 & -128) != 0) {
                byte[] bArr3 = this.f3341d;
                int i4 = this.f3343f;
                this.f3343f = i4 + 1;
                bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
                this.f3344g++;
                j2 >>>= 7;
            }
            byte[] bArr4 = this.f3341d;
            int i5 = this.f3343f;
            this.f3343f = i5 + 1;
            bArr4[i5] = (byte) ((int) j2);
            this.f3344g++;
        }
    }

    public static class c extends m {

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3345d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3346e;

        /* renamed from: f  reason: collision with root package name */
        public int f3347f;

        public c(byte[] bArr, int i2, int i3) {
            super(null);
            Objects.requireNonNull(bArr, "buffer");
            int i4 = i2 + i3;
            if ((i2 | i3 | (bArr.length - i4)) >= 0) {
                this.f3345d = bArr;
                this.f3347f = i2;
                this.f3346e = i4;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        @Override // f.b.f.m
        public final int G() {
            return this.f3346e - this.f3347f;
        }

        @Override // f.b.f.m
        public final void H(byte b) {
            try {
                byte[] bArr = this.f3345d;
                int i2 = this.f3347f;
                this.f3347f = i2 + 1;
                bArr[i2] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3347f), Integer.valueOf(this.f3346e), 1), e2);
            }
        }

        @Override // f.b.f.m
        public final void I(int i2, boolean z) {
            a0((i2 << 3) | 0);
            H(z ? (byte) 1 : 0);
        }

        @Override // f.b.f.m
        public final void J(byte[] bArr, int i2, int i3) {
            a0(i3);
            d0(bArr, i2, i3);
        }

        @Override // f.b.f.m
        public final void K(int i2, j jVar) {
            a0((i2 << 3) | 2);
            L(jVar);
        }

        @Override // f.b.f.m
        public final void L(j jVar) {
            a0(jVar.size());
            jVar.C(this);
        }

        @Override // f.b.f.m
        public final void M(int i2, int i3) {
            a0((i2 << 3) | 5);
            N(i3);
        }

        @Override // f.b.f.m
        public final void N(int i2) {
            try {
                byte[] bArr = this.f3345d;
                int i3 = this.f3347f;
                int i4 = i3 + 1;
                this.f3347f = i4;
                bArr[i3] = (byte) (i2 & 255);
                int i5 = i4 + 1;
                this.f3347f = i5;
                bArr[i4] = (byte) ((i2 >> 8) & 255);
                int i6 = i5 + 1;
                this.f3347f = i6;
                bArr[i5] = (byte) ((i2 >> 16) & 255);
                this.f3347f = i6 + 1;
                bArr[i6] = (byte) ((i2 >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3347f), Integer.valueOf(this.f3346e), 1), e2);
            }
        }

        @Override // f.b.f.m
        public final void O(int i2, long j2) {
            a0((i2 << 3) | 1);
            P(j2);
        }

        @Override // f.b.f.m
        public final void P(long j2) {
            try {
                byte[] bArr = this.f3345d;
                int i2 = this.f3347f;
                int i3 = i2 + 1;
                this.f3347f = i3;
                bArr[i2] = (byte) (((int) j2) & 255);
                int i4 = i3 + 1;
                this.f3347f = i4;
                bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
                int i5 = i4 + 1;
                this.f3347f = i5;
                bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
                int i6 = i5 + 1;
                this.f3347f = i6;
                bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
                int i7 = i6 + 1;
                this.f3347f = i7;
                bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
                int i8 = i7 + 1;
                this.f3347f = i8;
                bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
                int i9 = i8 + 1;
                this.f3347f = i9;
                bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
                this.f3347f = i9 + 1;
                bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3347f), Integer.valueOf(this.f3346e), 1), e2);
            }
        }

        @Override // f.b.f.m
        public final void Q(int i2, int i3) {
            a0((i2 << 3) | 0);
            if (i3 >= 0) {
                a0(i3);
            } else {
                c0((long) i3);
            }
        }

        @Override // f.b.f.m
        public final void R(int i2) {
            if (i2 >= 0) {
                a0(i2);
            } else {
                c0((long) i2);
            }
        }

        @Override // f.b.f.m
        public final void S(int i2, t0 t0Var, j1 j1Var) {
            a0((i2 << 3) | 2);
            a0(((a) t0Var).getSerializedSize(j1Var));
            j1Var.h(t0Var, this.a);
        }

        @Override // f.b.f.m
        public final void T(t0 t0Var) {
            a0(t0Var.getSerializedSize());
            t0Var.writeTo(this);
        }

        @Override // f.b.f.m
        public final void U(int i2, t0 t0Var) {
            Y(1, 3);
            Z(2, i2);
            a0(26);
            a0(t0Var.getSerializedSize());
            t0Var.writeTo(this);
            Y(1, 4);
        }

        @Override // f.b.f.m
        public final void V(int i2, j jVar) {
            Y(1, 3);
            Z(2, i2);
            K(3, jVar);
            Y(1, 4);
        }

        @Override // f.b.f.m
        public final void W(int i2, String str) {
            a0((i2 << 3) | 2);
            X(str);
        }

        @Override // f.b.f.m
        public final void X(String str) {
            int c;
            int i2 = this.f3347f;
            try {
                int A = m.A(str.length() * 3);
                int A2 = m.A(str.length());
                if (A2 == A) {
                    int i3 = i2 + A2;
                    this.f3347f = i3;
                    c = w1.c(str, this.f3345d, i3, G());
                    this.f3347f = i2;
                    a0((c - i2) - A2);
                } else {
                    a0(w1.d(str));
                    c = w1.c(str, this.f3345d, this.f3347f, G());
                }
                this.f3347f = c;
            } catch (w1.c e2) {
                this.f3347f = i2;
                F(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new d(e3);
            }
        }

        @Override // f.b.f.m
        public final void Y(int i2, int i3) {
            a0((i2 << 3) | i3);
        }

        @Override // f.b.f.m
        public final void Z(int i2, int i3) {
            a0((i2 << 3) | 0);
            a0(i3);
        }

        @Override // f.b.f.i
        public final void a(byte[] bArr, int i2, int i3) {
            d0(bArr, i2, i3);
        }

        @Override // f.b.f.m
        public final void a0(int i2) {
            if (!m.c || d.a() || G() < 5) {
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f3345d;
                    int i3 = this.f3347f;
                    this.f3347f = i3 + 1;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3345d;
                    int i4 = this.f3347f;
                    this.f3347f = i4 + 1;
                    bArr2[i4] = (byte) i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3347f), Integer.valueOf(this.f3346e), 1), e2);
                }
            } else if ((i2 & -128) == 0) {
                byte[] bArr3 = this.f3345d;
                int i5 = this.f3347f;
                this.f3347f = i5 + 1;
                v1.s(bArr3, (long) i5, (byte) i2);
            } else {
                byte[] bArr4 = this.f3345d;
                int i6 = this.f3347f;
                this.f3347f = i6 + 1;
                v1.s(bArr4, (long) i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & -128) == 0) {
                    byte[] bArr5 = this.f3345d;
                    int i8 = this.f3347f;
                    this.f3347f = i8 + 1;
                    v1.s(bArr5, (long) i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.f3345d;
                int i9 = this.f3347f;
                this.f3347f = i9 + 1;
                v1.s(bArr6, (long) i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & -128) == 0) {
                    byte[] bArr7 = this.f3345d;
                    int i11 = this.f3347f;
                    this.f3347f = i11 + 1;
                    v1.s(bArr7, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.f3345d;
                int i12 = this.f3347f;
                this.f3347f = i12 + 1;
                v1.s(bArr8, (long) i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & -128) == 0) {
                    byte[] bArr9 = this.f3345d;
                    int i14 = this.f3347f;
                    this.f3347f = i14 + 1;
                    v1.s(bArr9, (long) i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.f3345d;
                int i15 = this.f3347f;
                this.f3347f = i15 + 1;
                v1.s(bArr10, (long) i15, (byte) (i13 | 128));
                byte[] bArr11 = this.f3345d;
                int i16 = this.f3347f;
                this.f3347f = i16 + 1;
                v1.s(bArr11, (long) i16, (byte) (i13 >>> 7));
            }
        }

        @Override // f.b.f.m
        public final void b0(int i2, long j2) {
            a0((i2 << 3) | 0);
            c0(j2);
        }

        @Override // f.b.f.m
        public final void c0(long j2) {
            if (!m.c || G() < 10) {
                while ((j2 & -128) != 0) {
                    byte[] bArr = this.f3345d;
                    int i2 = this.f3347f;
                    this.f3347f = i2 + 1;
                    bArr[i2] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3345d;
                    int i3 = this.f3347f;
                    this.f3347f = i3 + 1;
                    bArr2[i3] = (byte) ((int) j2);
                } catch (IndexOutOfBoundsException e2) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3347f), Integer.valueOf(this.f3346e), 1), e2);
                }
            } else {
                while ((j2 & -128) != 0) {
                    byte[] bArr3 = this.f3345d;
                    int i4 = this.f3347f;
                    this.f3347f = i4 + 1;
                    v1.s(bArr3, (long) i4, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr4 = this.f3345d;
                int i5 = this.f3347f;
                this.f3347f = i5 + 1;
                v1.s(bArr4, (long) i5, (byte) ((int) j2));
            }
        }

        public final void d0(byte[] bArr, int i2, int i3) {
            try {
                System.arraycopy(bArr, i2, this.f3345d, this.f3347f, i3);
                this.f3347f += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3347f), Integer.valueOf(this.f3346e), Integer.valueOf(i3)), e2);
            }
        }
    }

    public static class d extends IOException {
        public d(String str, Throwable th) {
            super(f.a.a.a.a.t("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th);
        }

        public d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public static final class e extends b {

        /* renamed from: h  reason: collision with root package name */
        public final OutputStream f3348h;

        public e(OutputStream outputStream, int i2) {
            super(i2);
            Objects.requireNonNull(outputStream, "out");
            this.f3348h = outputStream;
        }

        @Override // f.b.f.m
        public void H(byte b) {
            if (this.f3343f == this.f3342e) {
                h0();
            }
            byte[] bArr = this.f3341d;
            int i2 = this.f3343f;
            this.f3343f = i2 + 1;
            bArr[i2] = b;
            this.f3344g++;
        }

        @Override // f.b.f.m
        public void I(int i2, boolean z) {
            j0(11);
            f0((i2 << 3) | 0);
            byte b = z ? (byte) 1 : 0;
            byte[] bArr = this.f3341d;
            int i3 = this.f3343f;
            this.f3343f = i3 + 1;
            bArr[i3] = b;
            this.f3344g++;
        }

        @Override // f.b.f.m
        public void J(byte[] bArr, int i2, int i3) {
            j0(5);
            f0(i3);
            k0(bArr, i2, i3);
        }

        @Override // f.b.f.m
        public void K(int i2, j jVar) {
            a0((i2 << 3) | 2);
            L(jVar);
        }

        @Override // f.b.f.m
        public void L(j jVar) {
            a0(jVar.size());
            jVar.C(this);
        }

        @Override // f.b.f.m
        public void M(int i2, int i3) {
            j0(14);
            f0((i2 << 3) | 5);
            d0(i3);
        }

        @Override // f.b.f.m
        public void N(int i2) {
            j0(4);
            d0(i2);
        }

        @Override // f.b.f.m
        public void O(int i2, long j2) {
            j0(18);
            f0((i2 << 3) | 1);
            e0(j2);
        }

        @Override // f.b.f.m
        public void P(long j2) {
            j0(8);
            e0(j2);
        }

        @Override // f.b.f.m
        public void Q(int i2, int i3) {
            j0(20);
            f0((i2 << 3) | 0);
            if (i3 >= 0) {
                f0(i3);
            } else {
                g0((long) i3);
            }
        }

        @Override // f.b.f.m
        public void R(int i2) {
            if (i2 >= 0) {
                j0(5);
                f0(i2);
                return;
            }
            c0((long) i2);
        }

        @Override // f.b.f.m
        public void S(int i2, t0 t0Var, j1 j1Var) {
            a0((i2 << 3) | 2);
            a0(((a) t0Var).getSerializedSize(j1Var));
            j1Var.h(t0Var, this.a);
        }

        @Override // f.b.f.m
        public void T(t0 t0Var) {
            a0(t0Var.getSerializedSize());
            t0Var.writeTo(this);
        }

        @Override // f.b.f.m
        public void U(int i2, t0 t0Var) {
            Y(1, 3);
            Z(2, i2);
            a0(26);
            a0(t0Var.getSerializedSize());
            t0Var.writeTo(this);
            Y(1, 4);
        }

        @Override // f.b.f.m
        public void V(int i2, j jVar) {
            Y(1, 3);
            Z(2, i2);
            K(3, jVar);
            Y(1, 4);
        }

        @Override // f.b.f.m
        public void W(int i2, String str) {
            a0((i2 << 3) | 2);
            X(str);
        }

        @Override // f.b.f.m
        public void X(String str) {
            int i2;
            try {
                int length = str.length() * 3;
                int A = m.A(length);
                int i3 = A + length;
                int i4 = this.f3342e;
                if (i3 > i4) {
                    byte[] bArr = new byte[length];
                    int c = w1.c(str, bArr, 0, length);
                    a0(c);
                    k0(bArr, 0, c);
                    return;
                }
                if (i3 > i4 - this.f3343f) {
                    h0();
                }
                int A2 = m.A(str.length());
                int i5 = this.f3343f;
                if (A2 == A) {
                    int i6 = i5 + A2;
                    try {
                        this.f3343f = i6;
                        int c2 = w1.c(str, this.f3341d, i6, this.f3342e - i6);
                        this.f3343f = i5;
                        i2 = (c2 - i5) - A2;
                        f0(i2);
                        this.f3343f = c2;
                    } catch (w1.c e2) {
                        this.f3344g -= this.f3343f - i5;
                        this.f3343f = i5;
                        throw e2;
                    } catch (ArrayIndexOutOfBoundsException e3) {
                        throw new d(e3);
                    }
                } else {
                    i2 = w1.d(str);
                    f0(i2);
                    this.f3343f = w1.c(str, this.f3341d, this.f3343f, i2);
                }
                this.f3344g += i2;
            } catch (w1.c e4) {
                F(str, e4);
            }
        }

        @Override // f.b.f.m
        public void Y(int i2, int i3) {
            a0((i2 << 3) | i3);
        }

        @Override // f.b.f.m
        public void Z(int i2, int i3) {
            j0(20);
            f0((i2 << 3) | 0);
            f0(i3);
        }

        @Override // f.b.f.i
        public void a(byte[] bArr, int i2, int i3) {
            k0(bArr, i2, i3);
        }

        @Override // f.b.f.m
        public void a0(int i2) {
            j0(5);
            f0(i2);
        }

        @Override // f.b.f.m
        public void b0(int i2, long j2) {
            j0(20);
            f0((i2 << 3) | 0);
            g0(j2);
        }

        @Override // f.b.f.m
        public void c0(long j2) {
            j0(10);
            g0(j2);
        }

        public final void h0() {
            this.f3348h.write(this.f3341d, 0, this.f3343f);
            this.f3343f = 0;
        }

        public void i0() {
            if (this.f3343f > 0) {
                h0();
            }
        }

        public final void j0(int i2) {
            if (this.f3342e - this.f3343f < i2) {
                h0();
            }
        }

        public void k0(byte[] bArr, int i2, int i3) {
            int i4 = this.f3342e;
            int i5 = this.f3343f;
            if (i4 - i5 >= i3) {
                System.arraycopy(bArr, i2, this.f3341d, i5, i3);
                this.f3343f += i3;
            } else {
                int i6 = i4 - i5;
                System.arraycopy(bArr, i2, this.f3341d, i5, i6);
                int i7 = i2 + i6;
                i3 -= i6;
                this.f3343f = this.f3342e;
                this.f3344g += i6;
                h0();
                if (i3 <= this.f3342e) {
                    System.arraycopy(bArr, i7, this.f3341d, 0, i3);
                    this.f3343f = i3;
                } else {
                    this.f3348h.write(bArr, i7, i3);
                }
            }
            this.f3344g += i3;
        }
    }

    public m() {
    }

    public m(a aVar) {
    }

    public static int A(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int B(int i2, long j2) {
        return C(j2) + y(i2);
    }

    public static int C(long j2) {
        int i2;
        if ((-128 & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if ((-34359738368L & j2) != 0) {
            i2 = 6;
            j2 >>>= 28;
        } else {
            i2 = 2;
        }
        if ((-2097152 & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & -16384) != 0 ? i2 + 1 : i2;
    }

    public static int D(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static long E(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int c(int i2, boolean z) {
        return y(i2) + 1;
    }

    public static int d(int i2, j jVar) {
        return y(i2) + p(jVar.size());
    }

    public static int e(j jVar) {
        return p(jVar.size());
    }

    public static int f(int i2, double d2) {
        return y(i2) + 8;
    }

    public static int g(int i2, int i3) {
        return y(i2) + m(i3);
    }

    public static int h(int i2, int i3) {
        return y(i2) + 4;
    }

    public static int i(int i2, long j2) {
        return y(i2) + 8;
    }

    public static int j(int i2, float f2) {
        return y(i2) + 4;
    }

    @Deprecated
    public static int k(int i2, t0 t0Var, j1 j1Var) {
        return (y(i2) * 2) + ((a) t0Var).getSerializedSize(j1Var);
    }

    public static int l(int i2, int i3) {
        return m(i3) + y(i2);
    }

    public static int m(int i2) {
        if (i2 >= 0) {
            return A(i2);
        }
        return 10;
    }

    public static int n(int i2, long j2) {
        return y(i2) + C(j2);
    }

    public static int o(g0 g0Var) {
        return p(g0Var.b != null ? g0Var.b.size() : g0Var.a != null ? g0Var.a.getSerializedSize() : 0);
    }

    public static int p(int i2) {
        return A(i2) + i2;
    }

    public static int q(int i2, int i3) {
        return y(i2) + 4;
    }

    public static int r(int i2, long j2) {
        return y(i2) + 8;
    }

    public static int s(int i2, int i3) {
        return t(i3) + y(i2);
    }

    public static int t(int i2) {
        return A(D(i2));
    }

    public static int u(int i2, long j2) {
        return v(j2) + y(i2);
    }

    public static int v(long j2) {
        return C(E(j2));
    }

    public static int w(int i2, String str) {
        return x(str) + y(i2);
    }

    public static int x(String str) {
        int i2;
        try {
            i2 = w1.d(str);
        } catch (w1.c unused) {
            i2 = str.getBytes(c0.a).length;
        }
        return p(i2);
    }

    public static int y(int i2) {
        return A((i2 << 3) | 0);
    }

    public static int z(int i2, int i3) {
        return A(i3) + y(i2);
    }

    public final void F(String str, w1.c cVar) {
        b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) cVar);
        byte[] bytes = str.getBytes(c0.a);
        try {
            a0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new d(e2);
        } catch (d e3) {
            throw e3;
        }
    }

    public abstract int G();

    public abstract void H(byte b2);

    public abstract void I(int i2, boolean z);

    public abstract void J(byte[] bArr, int i2, int i3);

    public abstract void K(int i2, j jVar);

    public abstract void L(j jVar);

    public abstract void M(int i2, int i3);

    public abstract void N(int i2);

    public abstract void O(int i2, long j2);

    public abstract void P(long j2);

    public abstract void Q(int i2, int i3);

    public abstract void R(int i2);

    public abstract void S(int i2, t0 t0Var, j1 j1Var);

    public abstract void T(t0 t0Var);

    public abstract void U(int i2, t0 t0Var);

    public abstract void V(int i2, j jVar);

    public abstract void W(int i2, String str);

    public abstract void X(String str);

    public abstract void Y(int i2, int i3);

    public abstract void Z(int i2, int i3);

    public abstract void a0(int i2);

    public final void b() {
        if (G() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void b0(int i2, long j2);

    public abstract void c0(long j2);
}
