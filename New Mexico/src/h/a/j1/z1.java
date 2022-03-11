package h.a.j1;

import h.a.c1;
import h.a.e1;
import h.a.f1;
import h.a.j1.k2;
import h.a.j1.r0;
import h.a.j1.y2;
import h.a.k;
import h.a.s;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.DataFormatException;
/* loaded from: classes.dex */
public class z1 implements Closeable, c0 {
    public b b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public final w2 f4363d;

    /* renamed from: e  reason: collision with root package name */
    public final c3 f4364e;

    /* renamed from: f  reason: collision with root package name */
    public s f4365f;

    /* renamed from: g  reason: collision with root package name */
    public r0 f4366g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f4367h;

    /* renamed from: i  reason: collision with root package name */
    public int f4368i;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4371l;
    public y m;
    public long o;
    public int r;

    /* renamed from: j  reason: collision with root package name */
    public e f4369j = e.HEADER;

    /* renamed from: k  reason: collision with root package name */
    public int f4370k = 5;
    public y n = new y();
    public boolean p = false;
    public int q = -1;
    public boolean s = false;
    public volatile boolean t = false;

    /* loaded from: classes.dex */
    public interface b {
        void a(y2.a aVar);

        void b(Throwable th);

        void e(boolean z);

        void f(int i2);
    }

    /* loaded from: classes.dex */
    public static class c implements y2.a {
        public InputStream a;

        public c(InputStream inputStream, a aVar) {
            this.a = inputStream;
        }

        @Override // h.a.j1.y2.a
        public InputStream next() {
            InputStream inputStream = this.a;
            this.a = null;
            return inputStream;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends FilterInputStream {
        public final int b;
        public final w2 c;

        /* renamed from: d  reason: collision with root package name */
        public long f4372d;

        /* renamed from: e  reason: collision with root package name */
        public long f4373e;

        /* renamed from: f  reason: collision with root package name */
        public long f4374f = -1;

        public d(InputStream inputStream, int i2, w2 w2Var) {
            super(inputStream);
            this.b = i2;
            this.c = w2Var;
        }

        public final void c() {
            if (this.f4373e > this.f4372d) {
                for (f1 f1Var : this.c.a) {
                    Objects.requireNonNull(f1Var);
                }
                this.f4372d = this.f4373e;
            }
        }

        public final void d() {
            long j2 = this.f4373e;
            int i2 = this.b;
            if (j2 > ((long) i2)) {
                throw new e1(c1.f4093l.g(String.format("Compressed gRPC message exceeds maximum size %d: %d bytes read", Integer.valueOf(i2), Long.valueOf(this.f4373e))));
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i2) {
            ((FilterInputStream) this).in.mark(i2);
            this.f4374f = this.f4373e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.f4373e++;
            }
            d();
            c();
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int read = ((FilterInputStream) this).in.read(bArr, i2, i3);
            if (read != -1) {
                this.f4373e += (long) read;
            }
            d();
            c();
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.f4374f != -1) {
                ((FilterInputStream) this).in.reset();
                this.f4373e = this.f4374f;
            } else {
                throw new IOException("Mark not set");
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j2) {
            long skip = ((FilterInputStream) this).in.skip(j2);
            this.f4373e += skip;
            d();
            c();
            return skip;
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        HEADER,
        BODY
    }

    public z1(b bVar, s sVar, int i2, w2 w2Var, c3 c3Var) {
        f.b.a.c.b.o.b.A(bVar, "sink");
        this.b = bVar;
        f.b.a.c.b.o.b.A(sVar, "decompressor");
        this.f4365f = sVar;
        this.c = i2;
        f.b.a.c.b.o.b.A(w2Var, "statsTraceCtx");
        this.f4363d = w2Var;
        f.b.a.c.b.o.b.A(c3Var, "transportTracer");
        this.f4364e = c3Var;
    }

    @Override // h.a.j1.c0
    public void J(r0 r0Var) {
        boolean z = true;
        f.b.a.c.b.o.b.G(this.f4365f == k.b.a, "per-message decompressor already set");
        if (this.f4366g != null) {
            z = false;
        }
        f.b.a.c.b.o.b.G(z, "full stream decompressor already set");
        f.b.a.c.b.o.b.A(r0Var, "Can't pass a null full stream decompressor");
        this.f4366g = r0Var;
        this.n = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:3:0x0007, B:5:0x000d, B:11:0x0017, B:13:0x001b, B:14:0x002b), top: B:28:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // h.a.j1.c0
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void L(j2 j2Var) {
        Throwable th;
        boolean z;
        f.b.a.c.b.o.b.A(j2Var, "data");
        boolean z2 = false;
        boolean z3 = true;
        try {
            if (!R() && !this.s) {
                z = false;
                if (z) {
                    r0 r0Var = this.f4366g;
                    if (r0Var != null) {
                        f.b.a.c.b.o.b.G(!r0Var.f4315j, "GzipInflatingBuffer is closed");
                        r0Var.b.d(j2Var);
                        r0Var.p = false;
                    } else {
                        this.n.d(j2Var);
                    }
                    try {
                        Q();
                    } catch (Throwable th2) {
                        th = th2;
                        z3 = false;
                        if (z3) {
                            j2Var.close();
                        }
                        throw th;
                    }
                } else {
                    z2 = true;
                }
                if (!z2) {
                    j2Var.close();
                    return;
                }
                return;
            }
            z = true;
            if (z) {
            }
            if (!z2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void Q() {
        if (!this.p) {
            this.p = true;
            while (true) {
                try {
                    if (this.t || this.o <= 0 || !V()) {
                        break;
                    }
                    int ordinal = this.f4369j.ordinal();
                    if (ordinal == 0) {
                        U();
                    } else if (ordinal == 1) {
                        T();
                        this.o--;
                    } else {
                        throw new AssertionError("Invalid state: " + this.f4369j);
                    }
                } finally {
                    this.p = false;
                }
            }
            if (this.t) {
                close();
                return;
            }
            if (this.s && S()) {
                close();
            }
        }
    }

    public boolean R() {
        return this.n == null && this.f4366g == null;
    }

    public final boolean S() {
        r0 r0Var = this.f4366g;
        if (r0Var != null) {
            f.b.a.c.b.o.b.G(true ^ r0Var.f4315j, "GzipInflatingBuffer is closed");
            return r0Var.p;
        } else if (this.n.b == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final void T() {
        InputStream inputStream;
        for (f1 f1Var : this.f4363d.a) {
            Objects.requireNonNull(f1Var);
        }
        this.r = 0;
        if (this.f4371l) {
            s sVar = this.f4365f;
            if (sVar != k.b.a) {
                try {
                    y yVar = this.m;
                    int i2 = k2.a;
                    inputStream = new d(sVar.b(new k2.a(yVar)), this.c, this.f4363d);
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                throw new e1(c1.m.g("Can't decode compressed gRPC message as compression not configured"));
            }
        } else {
            w2 w2Var = this.f4363d;
            int i3 = this.m.b;
            for (f1 f1Var2 : w2Var.a) {
                Objects.requireNonNull(f1Var2);
            }
            y yVar2 = this.m;
            int i4 = k2.a;
            inputStream = new k2.a(yVar2);
        }
        this.m = null;
        this.b.a(new c(inputStream, null));
        this.f4369j = e.HEADER;
        this.f4370k = 5;
    }

    public final void U() {
        int readUnsignedByte = this.m.readUnsignedByte();
        if ((readUnsignedByte & 254) == 0) {
            this.f4371l = (readUnsignedByte & 1) != 0;
            y yVar = this.m;
            yVar.c(4);
            int readUnsignedByte2 = yVar.readUnsignedByte() | (yVar.readUnsignedByte() << 24) | (yVar.readUnsignedByte() << 16) | (yVar.readUnsignedByte() << 8);
            this.f4370k = readUnsignedByte2;
            if (readUnsignedByte2 < 0 || readUnsignedByte2 > this.c) {
                throw new e1(c1.f4093l.g(String.format("gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.c), Integer.valueOf(this.f4370k))));
            }
            this.q++;
            for (f1 f1Var : this.f4363d.a) {
                Objects.requireNonNull(f1Var);
            }
            c3 c3Var = this.f4364e;
            c3Var.f4157g.a(1);
            c3Var.a.a();
            this.f4369j = e.BODY;
            return;
        }
        throw new e1(c1.m.g("gRPC frame header malformed: reserved bits not zero"));
    }

    public final boolean V() {
        int i2;
        Throwable th;
        int i3;
        int i4;
        int i5;
        int i6;
        e eVar = e.BODY;
        int i7 = 0;
        try {
            if (this.m == null) {
                this.m = new y();
            }
            int i8 = 0;
            i2 = 0;
            while (true) {
                try {
                    int i9 = this.f4370k - this.m.b;
                    if (i9 <= 0) {
                        if (i8 > 0) {
                            this.b.f(i8);
                            if (this.f4369j == eVar) {
                                if (this.f4366g != null) {
                                    this.f4363d.a((long) i2);
                                    i4 = this.r + i2;
                                } else {
                                    this.f4363d.a((long) i8);
                                    i4 = this.r + i8;
                                }
                                this.r = i4;
                            }
                        }
                        return true;
                    } else if (this.f4366g != null) {
                        try {
                            try {
                                byte[] bArr = this.f4367h;
                                if (bArr == null || this.f4368i == bArr.length) {
                                    this.f4367h = new byte[Math.min(i9, 2097152)];
                                    this.f4368i = 0;
                                }
                                int c2 = this.f4366g.c(this.f4367h, this.f4368i, Math.min(i9, this.f4367h.length - this.f4368i));
                                r0 r0Var = this.f4366g;
                                int i10 = r0Var.n;
                                r0Var.n = 0;
                                i8 += i10;
                                int i11 = r0Var.o;
                                r0Var.o = 0;
                                i2 += i11;
                                if (c2 == 0) {
                                    if (i8 > 0) {
                                        this.b.f(i8);
                                        if (this.f4369j == eVar) {
                                            if (this.f4366g != null) {
                                                this.f4363d.a((long) i2);
                                                i6 = this.r + i2;
                                            } else {
                                                this.f4363d.a((long) i8);
                                                i6 = this.r + i8;
                                            }
                                            this.r = i6;
                                        }
                                    }
                                    return false;
                                }
                                y yVar = this.m;
                                byte[] bArr2 = this.f4367h;
                                int i12 = this.f4368i;
                                int i13 = k2.a;
                                yVar.d(new k2.b(bArr2, i12, c2));
                                this.f4368i += c2;
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        } catch (DataFormatException e3) {
                            throw new RuntimeException(e3);
                        }
                    } else {
                        int i14 = this.n.b;
                        if (i14 == 0) {
                            if (i8 > 0) {
                                this.b.f(i8);
                                if (this.f4369j == eVar) {
                                    if (this.f4366g != null) {
                                        this.f4363d.a((long) i2);
                                        i5 = this.r + i2;
                                    } else {
                                        this.f4363d.a((long) i8);
                                        i5 = this.r + i8;
                                    }
                                    this.r = i5;
                                }
                            }
                            return false;
                        }
                        int min = Math.min(i9, i14);
                        i8 += min;
                        this.m.d(this.n.v(min));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i7 = i8;
                    if (i7 > 0) {
                        this.b.f(i7);
                        if (this.f4369j == eVar) {
                            if (this.f4366g != null) {
                                this.f4363d.a((long) i2);
                                i3 = this.r + i2;
                            } else {
                                this.f4363d.a((long) i7);
                                i3 = this.r + i7;
                            }
                            this.r = i3;
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            i2 = 0;
        }
    }

    @Override // h.a.j1.c0
    public void c(int i2) {
        f.b.a.c.b.o.b.p(i2 > 0, "numMessages must be > 0");
        if (!R()) {
            this.o += (long) i2;
            Q();
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
    @Override // java.io.Closeable, java.lang.AutoCloseable, h.a.j1.c0
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void close() {
        boolean z;
        if (!R()) {
            y yVar = this.m;
            boolean z2 = true;
            boolean z3 = yVar != null && yVar.b > 0;
            try {
                r0 r0Var = this.f4366g;
                if (r0Var != null) {
                    if (!z3) {
                        f.b.a.c.b.o.b.G(!r0Var.f4315j, "GzipInflatingBuffer is closed");
                        if (r0.b.c(r0Var.f4309d) == 0 && r0Var.f4314i == r0.c.HEADER) {
                            z = false;
                            if (z) {
                                z2 = false;
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    }
                    this.f4366g.close();
                    z3 = z2;
                }
                y yVar2 = this.n;
                if (yVar2 != null) {
                    yVar2.close();
                }
                y yVar3 = this.m;
                if (yVar3 != null) {
                    yVar3.close();
                }
                this.f4366g = null;
                this.n = null;
                this.m = null;
                this.b.e(z3);
            } catch (Throwable th) {
                this.f4366g = null;
                this.n = null;
                this.m = null;
                throw th;
            }
        }
    }

    @Override // h.a.j1.c0
    public void d(int i2) {
        this.c = i2;
    }

    @Override // h.a.j1.c0
    public void t() {
        if (!R()) {
            if (S()) {
                close();
            } else {
                this.s = true;
            }
        }
    }

    @Override // h.a.j1.c0
    public void x(s sVar) {
        f.b.a.c.b.o.b.G(this.f4366g == null, "Already set full stream decompressor");
        f.b.a.c.b.o.b.A(sVar, "Can't pass an empty decompressor");
        this.f4365f = sVar;
    }
}
