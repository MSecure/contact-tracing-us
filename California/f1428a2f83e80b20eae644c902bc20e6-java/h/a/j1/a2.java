package h.a.j1;

import h.a.c1;
import h.a.e1;
import h.a.f1;
import h.a.g0;
import h.a.k;
import h.a.l;
import h.a.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class a2 implements o0 {
    public final d a;
    public int b = -1;
    public d3 c;

    /* renamed from: d  reason: collision with root package name */
    public l f3550d = k.b.a;

    /* renamed from: e  reason: collision with root package name */
    public final c f3551e = new c(null);

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f3552f = new byte[5];

    /* renamed from: g  reason: collision with root package name */
    public final e3 f3553g;

    /* renamed from: h  reason: collision with root package name */
    public final w2 f3554h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3555i;

    /* renamed from: j  reason: collision with root package name */
    public int f3556j;

    /* renamed from: k  reason: collision with root package name */
    public int f3557k = -1;

    /* renamed from: l  reason: collision with root package name */
    public long f3558l;

    public final class b extends OutputStream {
        public final List<d3> b = new ArrayList();
        public d3 c;

        public b(a aVar) {
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            d3 d3Var = this.c;
            if (d3Var == null || d3Var.d() <= 0) {
                write(new byte[]{(byte) i2}, 0, 1);
                return;
            }
            this.c.e((byte) i2);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
            */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0042 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0012  */
        @Override // java.io.OutputStream
        public void write(byte[] r4, int r5, int r6) {
            /*
                r3 = this;
                h.a.j1.d3 r0 = r3.c
                if (r0 != 0) goto L_0x000f
                h.a.j1.a2 r0 = h.a.j1.a2.this
                h.a.j1.e3 r0 = r0.f3553g
                h.a.j1.d3 r0 = r0.a(r6)
                r1 = r0
                r0 = r3
                goto L_0x0032
            L_0x000f:
                r0 = r3
            L_0x0010:
                if (r6 <= 0) goto L_0x0042
                h.a.j1.d3 r1 = r0.c
                int r1 = r1.d()
                int r1 = java.lang.Math.min(r6, r1)
                if (r1 != 0) goto L_0x003a
                h.a.j1.d3 r1 = r0.c
                int r1 = r1.b()
                int r1 = r1 * 2
                int r1 = java.lang.Math.max(r6, r1)
                h.a.j1.a2 r2 = h.a.j1.a2.this
                h.a.j1.e3 r2 = r2.f3553g
                h.a.j1.d3 r1 = r2.a(r1)
            L_0x0032:
                r0.c = r1
                java.util.List<h.a.j1.d3> r2 = r0.b
                r2.add(r1)
                goto L_0x0010
            L_0x003a:
                h.a.j1.d3 r2 = r0.c
                r2.c(r4, r5, r1)
                int r5 = r5 + r1
                int r6 = r6 - r1
                goto L_0x0010
            L_0x0042:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.a.j1.a2.b.write(byte[], int, int):void");
        }
    }

    public interface d {
        void m(d3 d3Var, boolean z, boolean z2, int i2);
    }

    public a2(d dVar, e3 e3Var, w2 w2Var) {
        f.b.a.c.b.o.b.A(dVar, "sink");
        this.a = dVar;
        f.b.a.c.b.o.b.A(e3Var, "bufferAllocator");
        this.f3553g = e3Var;
        f.b.a.c.b.o.b.A(w2Var, "statsTraceCtx");
        this.f3554h = w2Var;
    }

    public static int i(InputStream inputStream, OutputStream outputStream) {
        boolean z;
        if (inputStream instanceof u) {
            return ((u) inputStream).c(outputStream);
        }
        int i2 = f.b.b.c.b.a;
        Objects.requireNonNull(inputStream);
        Objects.requireNonNull(outputStream);
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            z = false;
            if (read == -1) {
                break;
            }
            outputStream.write(bArr, 0, read);
            j2 += (long) read;
        }
        if (j2 <= 2147483647L) {
            z = true;
        }
        f.b.a.c.b.o.b.r(z, "Message size overflow: %s", j2);
        return (int) j2;
    }

    @Override // h.a.j1.o0
    public void a(int i2) {
        f.b.a.c.b.o.b.G(this.b == -1, "max size already set");
        this.b = i2;
    }

    @Override // h.a.j1.o0
    public o0 b(l lVar) {
        f.b.a.c.b.o.b.A(lVar, "Can't pass an empty compressor");
        this.f3550d = lVar;
        return this;
    }

    @Override // h.a.j1.o0
    public boolean c() {
        return this.f3555i;
    }

    @Override // h.a.j1.o0
    public void close() {
        d3 d3Var;
        if (!this.f3555i) {
            this.f3555i = true;
            d3 d3Var2 = this.c;
            if (!(d3Var2 == null || d3Var2.b() != 0 || (d3Var = this.c) == null)) {
                d3Var.a();
                this.c = null;
            }
            e(true, true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a A[LOOP:1: B:26:0x0078->B:27:0x007a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[LOOP:2: B:29:0x008a->B:30:0x008c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b A[LOOP:3: B:32:0x0099->B:33:0x009b, LOOP_END] */
    @Override // h.a.j1.o0
    public void d(InputStream inputStream) {
        int i2;
        if (!this.f3555i) {
            this.f3556j++;
            this.f3557k++;
            this.f3558l = 0;
            for (f1 f1Var : this.f3554h.a) {
                Objects.requireNonNull(f1Var);
            }
            boolean z = this.f3550d != k.b.a;
            try {
                if (!(inputStream instanceof g0)) {
                    if (!(inputStream instanceof ByteArrayInputStream)) {
                        i2 = -1;
                        int j2 = (i2 != 0 || !z) ? j(inputStream, i2) : g(inputStream);
                        if (i2 != -1 || j2 == i2) {
                            for (f1 f1Var2 : this.f3554h.a) {
                                Objects.requireNonNull(f1Var2);
                            }
                            w2 w2Var = this.f3554h;
                            long j3 = this.f3558l;
                            for (f1 f1Var3 : w2Var.a) {
                                f1Var3.a(j3);
                            }
                            for (f1 f1Var4 : this.f3554h.a) {
                                Objects.requireNonNull(f1Var4);
                            }
                        }
                        throw new e1(c1.m.g(String.format("Message length inaccurate %s != %s", Integer.valueOf(j2), Integer.valueOf(i2))));
                    }
                }
                i2 = inputStream.available();
                if (i2 != 0) {
                }
                if (i2 != -1) {
                }
                while (r1 < r0) {
                }
                w2 w2Var2 = this.f3554h;
                long j32 = this.f3558l;
                while (r3 < r2) {
                }
                while (r4 < r0) {
                }
            } catch (IOException e2) {
                throw new e1(c1.m.g("Failed to frame message").f(e2));
            } catch (RuntimeException e3) {
                throw new e1(c1.m.g("Failed to frame message").f(e3));
            }
        } else {
            throw new IllegalStateException("Framer already closed");
        }
    }

    public final void e(boolean z, boolean z2) {
        d3 d3Var = this.c;
        this.c = null;
        this.a.m(d3Var, z, z2, this.f3556j);
        this.f3556j = 0;
    }

    public final void f(b bVar, boolean z) {
        ByteBuffer wrap = ByteBuffer.wrap(this.f3552f);
        wrap.put(z ? (byte) 1 : 0);
        int i2 = 0;
        for (d3 d3Var : bVar.b) {
            i2 += d3Var.b();
        }
        wrap.putInt(i2);
        d3 a2 = this.f3553g.a(5);
        a2.c(this.f3552f, 0, wrap.position());
        if (i2 == 0) {
            this.c = a2;
            return;
        }
        this.a.m(a2, false, false, this.f3556j - 1);
        this.f3556j = 1;
        List<d3> list = bVar.b;
        for (int i3 = 0; i3 < list.size() - 1; i3++) {
            this.a.m(list.get(i3), false, false, 0);
        }
        this.c = list.get(list.size() - 1);
        this.f3558l = (long) i2;
    }

    @Override // h.a.j1.o0
    public void flush() {
        d3 d3Var = this.c;
        if (d3Var != null && d3Var.b() > 0) {
            e(false, true);
        }
    }

    /* JADX INFO: finally extract failed */
    public final int g(InputStream inputStream) {
        b bVar = new b(null);
        OutputStream c2 = this.f3550d.c(bVar);
        try {
            int i2 = i(inputStream, c2);
            c2.close();
            int i3 = this.b;
            if (i3 < 0 || i2 <= i3) {
                f(bVar, true);
                return i2;
            }
            throw new e1(c1.f3515l.g(String.format("message too large %d > %d", Integer.valueOf(i2), Integer.valueOf(this.b))));
        } catch (Throwable th) {
            c2.close();
            throw th;
        }
    }

    public final void h(byte[] bArr, int i2, int i3) {
        while (i3 > 0) {
            d3 d3Var = this.c;
            if (d3Var != null && d3Var.d() == 0) {
                e(false, false);
            }
            if (this.c == null) {
                this.c = this.f3553g.a(i3);
            }
            int min = Math.min(i3, this.c.d());
            this.c.c(bArr, i2, min);
            i2 += min;
            i3 -= min;
        }
    }

    public final int j(InputStream inputStream, int i2) {
        if (i2 != -1) {
            this.f3558l = (long) i2;
            int i3 = this.b;
            if (i3 < 0 || i2 <= i3) {
                ByteBuffer wrap = ByteBuffer.wrap(this.f3552f);
                wrap.put((byte) 0);
                wrap.putInt(i2);
                if (this.c == null) {
                    this.c = this.f3553g.a(wrap.position() + i2);
                }
                h(this.f3552f, 0, wrap.position());
                return i(inputStream, this.f3551e);
            }
            throw new e1(c1.f3515l.g(String.format("message too large %d > %d", Integer.valueOf(i2), Integer.valueOf(this.b))));
        }
        b bVar = new b(null);
        int i4 = i(inputStream, bVar);
        int i5 = this.b;
        if (i5 < 0 || i4 <= i5) {
            f(bVar, false);
            return i4;
        }
        throw new e1(c1.f3515l.g(String.format("message too large %d > %d", Integer.valueOf(i4), Integer.valueOf(this.b))));
    }

    public class c extends OutputStream {
        public c(a aVar) {
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            a2.this.h(new byte[]{(byte) i2}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            a2.this.h(bArr, i2, i3);
        }
    }
}
