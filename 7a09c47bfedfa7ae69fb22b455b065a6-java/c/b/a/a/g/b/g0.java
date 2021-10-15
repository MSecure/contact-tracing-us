package c.b.a.a.g.b;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class g0 extends x {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f3269b = Logger.getLogger(g0.class.getName());

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3270c = n3.h;

    /* renamed from: a  reason: collision with root package name */
    public i0 f3271a;

    public static class a extends g0 {

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3272d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3273e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3274f;

        /* renamed from: g  reason: collision with root package name */
        public int f3275g;

        public a(byte[] bArr, int i, int i2) {
            super(null);
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f3272d = bArr;
                    this.f3273e = i;
                    this.f3275g = i;
                    this.f3274f = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // c.b.a.a.g.b.g0
        public final void G(int i, int i2) {
            f0((i << 3) | 0);
            if (i2 >= 0) {
                f0(i2);
            } else {
                w((long) i2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void H(int i, long j) {
            f0((i << 3) | 1);
            M(j);
        }

        @Override // c.b.a.a.g.b.g0
        public final void L(int i, int i2) {
            f0((i << 3) | 0);
            f0(i2);
        }

        @Override // c.b.a.a.g.b.g0
        public final void M(long j) {
            try {
                byte[] bArr = this.f3272d;
                int i = this.f3275g;
                int i2 = i + 1;
                this.f3275g = i2;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.f3272d;
                int i3 = i2 + 1;
                this.f3275g = i3;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.f3272d;
                int i4 = i3 + 1;
                this.f3275g = i4;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.f3272d;
                int i5 = i4 + 1;
                this.f3275g = i5;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.f3272d;
                int i6 = i5 + 1;
                this.f3275g = i6;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.f3272d;
                int i7 = i6 + 1;
                this.f3275g = i7;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.f3272d;
                int i8 = i7 + 1;
                this.f3275g = i8;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.f3272d;
                this.f3275g = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3275g), Integer.valueOf(this.f3274f), 1), e2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void Q(int i, int i2) {
            f0((i << 3) | 5);
            g0(i2);
        }

        @Override // c.b.a.a.g.b.x
        public final void a(byte[] bArr, int i, int i2) {
            c(bArr, i, i2);
        }

        @Override // c.b.a.a.g.b.g0
        public void b() {
        }

        @Override // c.b.a.a.g.b.g0
        public final void c(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f3272d, this.f3275g, i2);
                this.f3275g += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3275g), Integer.valueOf(this.f3274f), Integer.valueOf(i2)), e2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void e0(int i) {
            if (i >= 0) {
                f0(i);
            } else {
                w((long) i);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void f(byte b2) {
            try {
                byte[] bArr = this.f3272d;
                int i = this.f3275g;
                this.f3275g = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3275g), Integer.valueOf(this.f3274f), 1), e2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void f0(int i) {
            if (!g0.f3270c || m() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f3272d;
                    int i2 = this.f3275g;
                    this.f3275g = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | RecyclerView.a0.FLAG_IGNORE);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3272d;
                    int i3 = this.f3275g;
                    this.f3275g = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3275g), Integer.valueOf(this.f3274f), 1), e2);
                }
            } else {
                while ((i & -128) != 0) {
                    byte[] bArr3 = this.f3272d;
                    int i4 = this.f3275g;
                    this.f3275g = i4 + 1;
                    n3.g(bArr3, (long) i4, (byte) ((i & 127) | RecyclerView.a0.FLAG_IGNORE));
                    i >>>= 7;
                }
                byte[] bArr4 = this.f3272d;
                int i5 = this.f3275g;
                this.f3275g = i5 + 1;
                n3.g(bArr4, (long) i5, (byte) i);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void g(int i, long j) {
            f0((i << 3) | 0);
            w(j);
        }

        @Override // c.b.a.a.g.b.g0
        public final void g0(int i) {
            try {
                byte[] bArr = this.f3272d;
                int i2 = this.f3275g;
                int i3 = i2 + 1;
                this.f3275g = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f3272d;
                int i4 = i3 + 1;
                this.f3275g = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f3272d;
                int i5 = i4 + 1;
                this.f3275g = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f3272d;
                this.f3275g = i5 + 1;
                bArr4[i5] = i >> 24;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3275g), Integer.valueOf(this.f3274f), 1), e2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void h(int i, y yVar) {
            f0((i << 3) | 2);
            o0(yVar);
        }

        @Override // c.b.a.a.g.b.g0
        public final void i(int i, e2 e2Var) {
            f0((i << 3) | 2);
            p0(e2Var);
        }

        @Override // c.b.a.a.g.b.g0
        public final void j(int i, e2 e2Var, u2 u2Var) {
            f0((i << 3) | 2);
            p pVar = (p) e2Var;
            int i2 = ((z0) pVar).zzjq;
            if (i2 == -1) {
                i2 = u2Var.j(pVar);
                ((z0) pVar).zzjq = i2;
            }
            f0(i2);
            u2Var.g(e2Var, this.f3271a);
        }

        @Override // c.b.a.a.g.b.g0
        public final void k(int i, String str) {
            f0((i << 3) | 2);
            q0(str);
        }

        @Override // c.b.a.a.g.b.g0
        public final int m() {
            return this.f3274f - this.f3275g;
        }

        public final void o0(y yVar) {
            f0(yVar.size());
            d0 d0Var = (d0) yVar;
            a(d0Var.f3242e, d0Var.j(), d0Var.size());
        }

        public final void p0(e2 e2Var) {
            f0(e2Var.d());
            e2Var.b(this);
        }

        public final void q0(String str) {
            int i = this.f3275g;
            try {
                int j0 = g0.j0(str.length() * 3);
                int j02 = g0.j0(str.length());
                if (j02 == j0) {
                    int i2 = i + j02;
                    this.f3275g = i2;
                    int b2 = p3.b(str, this.f3272d, i2, m());
                    this.f3275g = i;
                    f0((b2 - i) - j02);
                    this.f3275g = b2;
                    return;
                }
                f0(p3.a(str));
                this.f3275g = p3.b(str, this.f3272d, this.f3275g, m());
            } catch (s3 e2) {
                this.f3275g = i;
                l(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new c(e3);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void s(int i, int i2) {
            f0((i << 3) | i2);
        }

        @Override // c.b.a.a.g.b.g0
        public final void t(int i, y yVar) {
            s(1, 3);
            L(2, i);
            h(3, yVar);
            s(1, 4);
        }

        @Override // c.b.a.a.g.b.g0
        public final void u(int i, e2 e2Var) {
            s(1, 3);
            L(2, i);
            i(3, e2Var);
            s(1, 4);
        }

        @Override // c.b.a.a.g.b.g0
        public final void v(int i, boolean z) {
            f0((i << 3) | 0);
            f(z ? (byte) 1 : 0);
        }

        @Override // c.b.a.a.g.b.g0
        public final void w(long j) {
            if (!g0.f3270c || m() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f3272d;
                    int i = this.f3275g;
                    this.f3275g = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | RecyclerView.a0.FLAG_IGNORE);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f3272d;
                    int i2 = this.f3275g;
                    this.f3275g = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3275g), Integer.valueOf(this.f3274f), 1), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f3272d;
                    int i3 = this.f3275g;
                    this.f3275g = i3 + 1;
                    n3.g(bArr3, (long) i3, (byte) ((((int) j) & 127) | RecyclerView.a0.FLAG_IGNORE));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f3272d;
                int i4 = this.f3275g;
                this.f3275g = i4 + 1;
                n3.g(bArr4, (long) i4, (byte) ((int) j));
            }
        }
    }

    public static final class b extends a {
        public final ByteBuffer h;
        public int i;

        public b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            this.h = byteBuffer;
            this.i = byteBuffer.position();
        }

        @Override // c.b.a.a.g.b.g0.a, c.b.a.a.g.b.g0
        public final void b() {
            this.h.position(this.i + (this.f3275g - this.f3273e));
        }
    }

    public static class c extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        public c(String str) {
            super(r3.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(r3) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "));
            String valueOf = String.valueOf(str);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        public c(String str, Throwable th) {
            super(r3.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(r3) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
            String valueOf = String.valueOf(str);
        }

        public c(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public static final class d extends g0 {

        /* renamed from: d  reason: collision with root package name */
        public final ByteBuffer f3276d;

        /* renamed from: e  reason: collision with root package name */
        public final ByteBuffer f3277e;

        public d(ByteBuffer byteBuffer) {
            super(null);
            this.f3276d = byteBuffer;
            this.f3277e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.position();
        }

        @Override // c.b.a.a.g.b.g0
        public final void G(int i, int i2) {
            f0((i << 3) | 0);
            if (i2 >= 0) {
                f0(i2);
            } else {
                w((long) i2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void H(int i, long j) {
            f0((i << 3) | 1);
            M(j);
        }

        @Override // c.b.a.a.g.b.g0
        public final void L(int i, int i2) {
            f0((i << 3) | 0);
            f0(i2);
        }

        @Override // c.b.a.a.g.b.g0
        public final void M(long j) {
            try {
                this.f3277e.putLong(j);
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void Q(int i, int i2) {
            f0((i << 3) | 5);
            g0(i2);
        }

        @Override // c.b.a.a.g.b.x
        public final void a(byte[] bArr, int i, int i2) {
            c(bArr, i, i2);
        }

        @Override // c.b.a.a.g.b.g0
        public final void b() {
            this.f3276d.position(this.f3277e.position());
        }

        @Override // c.b.a.a.g.b.g0
        public final void c(byte[] bArr, int i, int i2) {
            try {
                this.f3277e.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e2) {
                throw new c(e2);
            } catch (BufferOverflowException e3) {
                throw new c(e3);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void e0(int i) {
            if (i >= 0) {
                f0(i);
            } else {
                w((long) i);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void f(byte b2) {
            try {
                this.f3277e.put(b2);
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void f0(int i) {
            while ((i & -128) != 0) {
                this.f3277e.put((byte) ((i & 127) | RecyclerView.a0.FLAG_IGNORE));
                i >>>= 7;
            }
            try {
                this.f3277e.put((byte) i);
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void g(int i, long j) {
            f0((i << 3) | 0);
            w(j);
        }

        @Override // c.b.a.a.g.b.g0
        public final void g0(int i) {
            try {
                this.f3277e.putInt(i);
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void h(int i, y yVar) {
            f0((i << 3) | 2);
            o0(yVar);
        }

        @Override // c.b.a.a.g.b.g0
        public final void i(int i, e2 e2Var) {
            f0((i << 3) | 2);
            q0(e2Var);
        }

        @Override // c.b.a.a.g.b.g0
        public final void j(int i, e2 e2Var, u2 u2Var) {
            f0((i << 3) | 2);
            p0(e2Var, u2Var);
        }

        @Override // c.b.a.a.g.b.g0
        public final void k(int i, String str) {
            f0((i << 3) | 2);
            r0(str);
        }

        @Override // c.b.a.a.g.b.g0
        public final int m() {
            return this.f3277e.remaining();
        }

        public final void o0(y yVar) {
            f0(yVar.size());
            d0 d0Var = (d0) yVar;
            a(d0Var.f3242e, d0Var.j(), d0Var.size());
        }

        public final void p0(e2 e2Var, u2 u2Var) {
            p pVar = (p) e2Var;
            int i = ((z0) pVar).zzjq;
            if (i == -1) {
                i = u2Var.j(pVar);
                ((z0) pVar).zzjq = i;
            }
            f0(i);
            u2Var.g(e2Var, this.f3271a);
        }

        public final void q0(e2 e2Var) {
            f0(e2Var.d());
            e2Var.b(this);
        }

        public final void r0(String str) {
            int position = this.f3277e.position();
            try {
                int j0 = g0.j0(str.length() * 3);
                int j02 = g0.j0(str.length());
                if (j02 == j0) {
                    int position2 = this.f3277e.position() + j02;
                    this.f3277e.position(position2);
                    try {
                        p3.c(str, this.f3277e);
                        int position3 = this.f3277e.position();
                        this.f3277e.position(position);
                        f0(position3 - position2);
                        this.f3277e.position(position3);
                    } catch (IndexOutOfBoundsException e2) {
                        throw new c(e2);
                    }
                } else {
                    f0(p3.a(str));
                    try {
                        p3.c(str, this.f3277e);
                    } catch (IndexOutOfBoundsException e3) {
                        throw new c(e3);
                    }
                }
            } catch (s3 e4) {
                this.f3277e.position(position);
                l(str, e4);
            } catch (IllegalArgumentException e5) {
                throw new c(e5);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void s(int i, int i2) {
            f0((i << 3) | i2);
        }

        @Override // c.b.a.a.g.b.g0
        public final void t(int i, y yVar) {
            s(1, 3);
            L(2, i);
            h(3, yVar);
            s(1, 4);
        }

        @Override // c.b.a.a.g.b.g0
        public final void u(int i, e2 e2Var) {
            s(1, 3);
            L(2, i);
            i(3, e2Var);
            s(1, 4);
        }

        @Override // c.b.a.a.g.b.g0
        public final void v(int i, boolean z) {
            f0((i << 3) | 0);
            f(z ? (byte) 1 : 0);
        }

        @Override // c.b.a.a.g.b.g0
        public final void w(long j) {
            while ((-128 & j) != 0) {
                this.f3277e.put((byte) ((((int) j) & 127) | RecyclerView.a0.FLAG_IGNORE));
                j >>>= 7;
            }
            try {
                this.f3277e.put((byte) ((int) j));
            } catch (BufferOverflowException e2) {
                throw new c(e2);
            }
        }
    }

    public static final class e extends g0 {

        /* renamed from: d  reason: collision with root package name */
        public final ByteBuffer f3278d;

        /* renamed from: e  reason: collision with root package name */
        public final ByteBuffer f3279e;

        /* renamed from: f  reason: collision with root package name */
        public final long f3280f;

        /* renamed from: g  reason: collision with root package name */
        public final long f3281g;
        public final long h;
        public final long i;
        public long j = this.f3281g;

        public e(ByteBuffer byteBuffer) {
            super(null);
            this.f3278d = byteBuffer;
            this.f3279e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long k = n3.f3369f.k(byteBuffer, n3.j);
            this.f3280f = k;
            this.f3281g = k + ((long) byteBuffer.position());
            long limit = this.f3280f + ((long) byteBuffer.limit());
            this.h = limit;
            this.i = limit - 10;
        }

        @Override // c.b.a.a.g.b.g0
        public final void G(int i2, int i3) {
            f0((i2 << 3) | 0);
            if (i3 >= 0) {
                f0(i3);
            } else {
                w((long) i3);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void H(int i2, long j2) {
            f0((i2 << 3) | 1);
            M(j2);
        }

        @Override // c.b.a.a.g.b.g0
        public final void L(int i2, int i3) {
            f0((i2 << 3) | 0);
            f0(i3);
        }

        @Override // c.b.a.a.g.b.g0
        public final void M(long j2) {
            this.f3279e.putLong((int) (this.j - this.f3280f), j2);
            this.j += 8;
        }

        @Override // c.b.a.a.g.b.g0
        public final void Q(int i2, int i3) {
            f0((i2 << 3) | 5);
            g0(i3);
        }

        @Override // c.b.a.a.g.b.x
        public final void a(byte[] bArr, int i2, int i3) {
            c(bArr, i2, i3);
        }

        @Override // c.b.a.a.g.b.g0
        public final void b() {
            this.f3278d.position((int) (this.j - this.f3280f));
        }

        @Override // c.b.a.a.g.b.g0
        public final void c(byte[] bArr, int i2, int i3) {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j2 = (long) i3;
                long j3 = this.j;
                if (this.h - j2 >= j3) {
                    n3.f3369f.h(bArr, (long) i2, j3, j2);
                    this.j += j2;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new c(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), Integer.valueOf(i3)));
        }

        @Override // c.b.a.a.g.b.g0
        public final void e0(int i2) {
            if (i2 >= 0) {
                f0(i2);
            } else {
                w((long) i2);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void f(byte b2) {
            long j2 = this.j;
            if (j2 < this.h) {
                this.j = 1 + j2;
                n3.f3369f.b(j2, b2);
                return;
            }
            throw new c(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), 1));
        }

        @Override // c.b.a.a.g.b.g0
        public final void f0(int i2) {
            if (this.j <= this.i) {
                while (true) {
                    int i3 = i2 & -128;
                    long j2 = this.j;
                    if (i3 == 0) {
                        this.j = 1 + j2;
                        n3.f3369f.b(j2, (byte) i2);
                        return;
                    }
                    this.j = j2 + 1;
                    n3.f3369f.b(j2, (byte) ((i2 & 127) | RecyclerView.a0.FLAG_IGNORE));
                    i2 >>>= 7;
                }
            } else {
                while (true) {
                    long j3 = this.j;
                    if (j3 >= this.h) {
                        throw new c(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), 1));
                    } else if ((i2 & -128) == 0) {
                        this.j = 1 + j3;
                        n3.f3369f.b(j3, (byte) i2);
                        return;
                    } else {
                        this.j = j3 + 1;
                        n3.f3369f.b(j3, (byte) ((i2 & 127) | RecyclerView.a0.FLAG_IGNORE));
                        i2 >>>= 7;
                    }
                }
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void g(int i2, long j2) {
            f0((i2 << 3) | 0);
            w(j2);
        }

        @Override // c.b.a.a.g.b.g0
        public final void g0(int i2) {
            this.f3279e.putInt((int) (this.j - this.f3280f), i2);
            this.j += 4;
        }

        @Override // c.b.a.a.g.b.g0
        public final void h(int i2, y yVar) {
            f0((i2 << 3) | 2);
            o0(yVar);
        }

        @Override // c.b.a.a.g.b.g0
        public final void i(int i2, e2 e2Var) {
            f0((i2 << 3) | 2);
            q0(e2Var);
        }

        @Override // c.b.a.a.g.b.g0
        public final void j(int i2, e2 e2Var, u2 u2Var) {
            f0((i2 << 3) | 2);
            p0(e2Var, u2Var);
        }

        @Override // c.b.a.a.g.b.g0
        public final void k(int i2, String str) {
            f0((i2 << 3) | 2);
            r0(str);
        }

        @Override // c.b.a.a.g.b.g0
        public final int m() {
            return (int) (this.h - this.j);
        }

        public final void o0(y yVar) {
            f0(yVar.size());
            d0 d0Var = (d0) yVar;
            a(d0Var.f3242e, d0Var.j(), d0Var.size());
        }

        public final void p0(e2 e2Var, u2 u2Var) {
            p pVar = (p) e2Var;
            int i2 = ((z0) pVar).zzjq;
            if (i2 == -1) {
                i2 = u2Var.j(pVar);
                ((z0) pVar).zzjq = i2;
            }
            f0(i2);
            u2Var.g(e2Var, this.f3271a);
        }

        public final void q0(e2 e2Var) {
            f0(e2Var.d());
            e2Var.b(this);
        }

        public final void r0(String str) {
            long j2 = this.j;
            try {
                int j0 = g0.j0(str.length() * 3);
                int j02 = g0.j0(str.length());
                if (j02 == j0) {
                    int i2 = ((int) (this.j - this.f3280f)) + j02;
                    this.f3279e.position(i2);
                    p3.c(str, this.f3279e);
                    int position = this.f3279e.position() - i2;
                    f0(position);
                    this.j += (long) position;
                    return;
                }
                int a2 = p3.a(str);
                f0(a2);
                this.f3279e.position((int) (this.j - this.f3280f));
                p3.c(str, this.f3279e);
                this.j += (long) a2;
            } catch (s3 e2) {
                this.j = j2;
                this.f3279e.position((int) (j2 - this.f3280f));
                l(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new c(e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new c(e4);
            }
        }

        @Override // c.b.a.a.g.b.g0
        public final void s(int i2, int i3) {
            f0((i2 << 3) | i3);
        }

        @Override // c.b.a.a.g.b.g0
        public final void t(int i2, y yVar) {
            s(1, 3);
            L(2, i2);
            h(3, yVar);
            s(1, 4);
        }

        @Override // c.b.a.a.g.b.g0
        public final void u(int i2, e2 e2Var) {
            s(1, 3);
            L(2, i2);
            i(3, e2Var);
            s(1, 4);
        }

        @Override // c.b.a.a.g.b.g0
        public final void v(int i2, boolean z) {
            f0((i2 << 3) | 0);
            f(z ? (byte) 1 : 0);
        }

        @Override // c.b.a.a.g.b.g0
        public final void w(long j2) {
            if (this.j <= this.i) {
                while ((j2 & -128) != 0) {
                    long j3 = this.j;
                    this.j = j3 + 1;
                    n3.f3369f.b(j3, (byte) ((((int) j2) & 127) | RecyclerView.a0.FLAG_IGNORE));
                    j2 >>>= 7;
                }
                long j4 = this.j;
                this.j = 1 + j4;
                n3.f3369f.b(j4, (byte) ((int) j2));
                return;
            }
            while (true) {
                long j5 = this.j;
                if (j5 >= this.h) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), 1));
                } else if ((j2 & -128) == 0) {
                    this.j = 1 + j5;
                    n3.f3369f.b(j5, (byte) ((int) j2));
                    return;
                } else {
                    this.j = j5 + 1;
                    n3.f3369f.b(j5, (byte) ((((int) j2) & 127) | RecyclerView.a0.FLAG_IGNORE));
                    j2 >>>= 7;
                }
            }
        }
    }

    public g0() {
    }

    public g0(h0 h0Var) {
    }

    public static int A(int i) {
        return h0(i) + 1;
    }

    public static int B(int i, y yVar) {
        int h0 = h0(i);
        int size = yVar.size();
        return j0(size) + size + h0;
    }

    public static int C(int i, e2 e2Var) {
        int h0 = h0(i);
        int d2 = e2Var.d();
        return h0 + j0(d2) + d2;
    }

    @Deprecated
    public static int D(int i, e2 e2Var, u2 u2Var) {
        int h0 = h0(i) << 1;
        p pVar = (p) e2Var;
        int i2 = ((z0) pVar).zzjq;
        if (i2 == -1) {
            i2 = u2Var.j(pVar);
            ((z0) pVar).zzjq = i2;
        }
        return h0 + i2;
    }

    public static int E(e2 e2Var) {
        int d2 = e2Var.d();
        return j0(d2) + d2;
    }

    public static g0 F(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int I(int i, long j) {
        return P(j) + h0(i);
    }

    @Deprecated
    public static int J(e2 e2Var) {
        return e2Var.d();
    }

    public static int K(byte[] bArr) {
        int length = bArr.length;
        return j0(length) + length;
    }

    public static int N(int i, long j) {
        return P(j) + h0(i);
    }

    public static int O(int i, long j) {
        return P(b0(j)) + h0(i);
    }

    public static int P(long j) {
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

    public static int R(int i) {
        return h0(i) + 8;
    }

    public static int S(int i, int i2) {
        return i0(i2) + h0(i);
    }

    public static int T(long j) {
        return P(b0(j));
    }

    public static int U() {
        return 8;
    }

    public static int V(int i) {
        return h0(i) + 8;
    }

    public static int W(int i, int i2) {
        return j0(i2) + h0(i);
    }

    public static int X(String str) {
        int i;
        try {
            i = p3.a(str);
        } catch (s3 unused) {
            i = str.getBytes(b1.f3229a).length;
        }
        return j0(i) + i;
    }

    public static int Y() {
        return 8;
    }

    public static int Z(int i, int i2) {
        return j0(n0(i2)) + h0(i);
    }

    public static int a0(int i) {
        return h0(i) + 4;
    }

    public static long b0(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int c0(int i) {
        return h0(i) + 4;
    }

    public static int d(m1 m1Var) {
        int a2 = m1Var.a();
        return j0(a2) + a2;
    }

    public static int d0(int i, int i2) {
        return i0(i2) + h0(i);
    }

    public static g0 e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            return n3.f3370g ? new e(byteBuffer) : new d(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static int h0(int i) {
        return j0(i << 3);
    }

    public static int i0(int i) {
        if (i >= 0) {
            return j0(i);
        }
        return 10;
    }

    public static int j0(int i) {
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

    public static int k0(int i) {
        return j0(n0(i));
    }

    public static int l0() {
        return 4;
    }

    public static int m0() {
        return 4;
    }

    public static int n() {
        return 4;
    }

    public static int n0(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int o(int i) {
        return h0(i) + 4;
    }

    public static int p(int i, String str) {
        return X(str) + h0(i);
    }

    public static int q(y yVar) {
        int size = yVar.size();
        return j0(size) + size;
    }

    public static int r(e2 e2Var, u2 u2Var) {
        p pVar = (p) e2Var;
        int i = ((z0) pVar).zzjq;
        if (i == -1) {
            i = u2Var.j(pVar);
            ((z0) pVar).zzjq = i;
        }
        return j0(i) + i;
    }

    public static int x() {
        return 8;
    }

    public static int y(int i) {
        return h0(i) + 8;
    }

    public static int z() {
        return 1;
    }

    public abstract void G(int i, int i2);

    public abstract void H(int i, long j);

    public abstract void L(int i, int i2);

    public abstract void M(long j);

    public abstract void Q(int i, int i2);

    public abstract void b();

    public abstract void c(byte[] bArr, int i, int i2);

    public abstract void e0(int i);

    public abstract void f(byte b2);

    public abstract void f0(int i);

    public abstract void g(int i, long j);

    public abstract void g0(int i);

    public abstract void h(int i, y yVar);

    public abstract void i(int i, e2 e2Var);

    public abstract void j(int i, e2 e2Var, u2 u2Var);

    public abstract void k(int i, String str);

    public final void l(String str, s3 s3Var) {
        f3269b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) s3Var);
        byte[] bytes = str.getBytes(b1.f3229a);
        try {
            f0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new c(e2);
        } catch (c e3) {
            throw e3;
        }
    }

    public abstract int m();

    public abstract void s(int i, int i2);

    public abstract void t(int i, y yVar);

    public abstract void u(int i, e2 e2Var);

    public abstract void v(int i, boolean z);

    public abstract void w(long j);
}
