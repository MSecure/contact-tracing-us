package h.a.j1;

import h.a.j1.y;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

public class r0 implements Closeable {
    public final y b = new y();
    public final CRC32 c = new CRC32();

    /* renamed from: d  reason: collision with root package name */
    public final b f3731d = new b(null);

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f3732e = new byte[512];

    /* renamed from: f  reason: collision with root package name */
    public int f3733f;

    /* renamed from: g  reason: collision with root package name */
    public int f3734g;

    /* renamed from: h  reason: collision with root package name */
    public Inflater f3735h;

    /* renamed from: i  reason: collision with root package name */
    public c f3736i = c.HEADER;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3737j = false;

    /* renamed from: k  reason: collision with root package name */
    public int f3738k;

    /* renamed from: l  reason: collision with root package name */
    public int f3739l;
    public long m;
    public int n = 0;
    public int o = 0;
    public boolean p = true;

    public class b {
        public b(a aVar) {
        }

        public static void a(b bVar, int i2) {
            int i3;
            r0 r0Var = r0.this;
            int i4 = r0Var.f3734g - r0Var.f3733f;
            if (i4 > 0) {
                int min = Math.min(i4, i2);
                r0 r0Var2 = r0.this;
                r0Var2.c.update(r0Var2.f3732e, r0Var2.f3733f, min);
                r0.this.f3733f += min;
                i3 = i2 - min;
            } else {
                i3 = i2;
            }
            if (i3 > 0) {
                byte[] bArr = new byte[512];
                int i5 = 0;
                while (i5 < i3) {
                    int min2 = Math.min(i3 - i5, 512);
                    y yVar = r0.this.b;
                    yVar.A(new y.b(yVar, 0, bArr), min2);
                    r0.this.c.update(bArr, 0, min2);
                    i5 += min2;
                }
            }
            r0.this.n += i2;
        }

        public static boolean b(b bVar) {
            do {
                r0 r0Var = r0.this;
                if ((r0Var.f3734g - r0Var.f3733f) + r0Var.b.b <= 0) {
                    return false;
                }
            } while (bVar.d() != 0);
            return true;
        }

        public static int c(b bVar) {
            r0 r0Var = r0.this;
            return (r0Var.f3734g - r0Var.f3733f) + r0Var.b.b;
        }

        public final int d() {
            int i2;
            r0 r0Var = r0.this;
            int i3 = r0Var.f3734g;
            int i4 = r0Var.f3733f;
            if (i3 - i4 > 0) {
                i2 = r0Var.f3732e[i4] & 255;
                r0Var.f3733f = i4 + 1;
            } else {
                i2 = r0Var.b.E();
            }
            r0.this.c.update(i2);
            r0.this.n++;
            return i2;
        }

        public final int e() {
            return d() | (d() << 8);
        }
    }

    public enum c {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00da, code lost:
        if (r16.f3736i != r2) goto L_0x01e0;
     */
    public int c(byte[] bArr, int i2, int i3) {
        int i4;
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4 = c.TRAILER;
        c cVar5 = c.INFLATING;
        c cVar6 = c.INFLATER_NEEDS_INPUT;
        c cVar7 = c.HEADER_NAME;
        boolean z = true;
        f.b.a.c.b.o.b.G(!this.f3737j, "GzipInflatingBuffer is closed");
        boolean z2 = true;
        int i5 = 0;
        while (z2 && (i4 = i3 - i5) > 0) {
            switch (this.f3736i.ordinal()) {
                case 0:
                    if (b.c(this.f3731d) >= 10) {
                        if (this.f3731d.e() != 35615) {
                            throw new ZipException("Not in GZIP format");
                        } else if (this.f3731d.d() == 8) {
                            this.f3738k = this.f3731d.d();
                            b.a(this.f3731d, 6);
                            this.f3736i = c.HEADER_EXTRA_LEN;
                            z2 = true;
                            break;
                        } else {
                            throw new ZipException("Unsupported compression method");
                        }
                    }
                    z2 = false;
                    break;
                case 1:
                    if ((this.f3738k & 4) == 4) {
                        if (b.c(this.f3731d) >= 2) {
                            this.f3739l = this.f3731d.e();
                            cVar = c.HEADER_EXTRA;
                        }
                        z2 = false;
                        break;
                    } else {
                        cVar = cVar7;
                    }
                    this.f3736i = cVar;
                    z2 = true;
                    break;
                case 2:
                    int c2 = b.c(this.f3731d);
                    int i6 = this.f3739l;
                    if (c2 >= i6) {
                        b.a(this.f3731d, i6);
                        this.f3736i = cVar7;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 3:
                    c cVar8 = c.HEADER_COMMENT;
                    if ((this.f3738k & 8) != 8 || b.b(this.f3731d)) {
                        this.f3736i = cVar8;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 4:
                    c cVar9 = c.HEADER_CRC;
                    if ((this.f3738k & 16) != 16 || b.b(this.f3731d)) {
                        this.f3736i = cVar9;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 5:
                    c cVar10 = c.INITIALIZE_INFLATER;
                    if ((this.f3738k & 2) == 2) {
                        if (b.c(this.f3731d) >= 2) {
                            if ((65535 & ((int) this.c.getValue())) != this.f3731d.e()) {
                                throw new ZipException("Corrupt GZIP header");
                            }
                        }
                        z2 = false;
                        break;
                    }
                    this.f3736i = cVar10;
                    z2 = true;
                    break;
                case 6:
                    Inflater inflater = this.f3735h;
                    if (inflater == null) {
                        this.f3735h = new Inflater(true);
                    } else {
                        inflater.reset();
                    }
                    this.c.reset();
                    int i7 = this.f3734g;
                    int i8 = this.f3733f;
                    int i9 = i7 - i8;
                    if (i9 > 0) {
                        this.f3735h.setInput(this.f3732e, i8, i9);
                        cVar2 = cVar5;
                    } else {
                        cVar2 = cVar6;
                    }
                    this.f3736i = cVar2;
                    z2 = true;
                    break;
                case 7:
                    int i10 = i2 + i5;
                    f.b.a.c.b.o.b.G(this.f3735h != null, "inflater is null");
                    try {
                        int totalIn = this.f3735h.getTotalIn();
                        int inflate = this.f3735h.inflate(bArr, i10, i4);
                        int totalIn2 = this.f3735h.getTotalIn() - totalIn;
                        this.n += totalIn2;
                        this.o += totalIn2;
                        this.f3733f += totalIn2;
                        this.c.update(bArr, i10, inflate);
                        if (!this.f3735h.finished()) {
                            if (this.f3735h.needsInput()) {
                                cVar3 = cVar6;
                            }
                            i5 += inflate;
                            break;
                        } else {
                            this.m = this.f3735h.getBytesWritten() & 4294967295L;
                            cVar3 = cVar4;
                        }
                        this.f3736i = cVar3;
                        i5 += inflate;
                    } catch (DataFormatException e2) {
                        StringBuilder h2 = f.a.a.a.a.h("Inflater data format exception: ");
                        h2.append(e2.getMessage());
                        throw new DataFormatException(h2.toString());
                    }
                case 8:
                    f.b.a.c.b.o.b.G(this.f3735h != null, "inflater is null");
                    f.b.a.c.b.o.b.G(this.f3733f == this.f3734g, "inflaterInput has unconsumed bytes");
                    int min = Math.min(this.b.b, 512);
                    if (min != 0) {
                        this.f3733f = 0;
                        this.f3734g = min;
                        this.b.O(this.f3732e, 0, min);
                        this.f3735h.setInput(this.f3732e, this.f3733f, min);
                        this.f3736i = cVar5;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 9:
                    z2 = d();
                    break;
                default:
                    StringBuilder h3 = f.a.a.a.a.h("Invalid state: ");
                    h3.append(this.f3736i);
                    throw new AssertionError(h3.toString());
            }
        }
        if (z2 && (this.f3736i != c.HEADER || b.c(this.f3731d) >= 10)) {
            z = false;
        }
        this.p = z;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f3737j) {
            this.f3737j = true;
            this.b.close();
            Inflater inflater = this.f3735h;
            if (inflater != null) {
                inflater.end();
                this.f3735h = null;
            }
        }
    }

    public final boolean d() {
        if (this.f3735h != null && b.c(this.f3731d) <= 18) {
            this.f3735h.end();
            this.f3735h = null;
        }
        if (b.c(this.f3731d) < 8) {
            return false;
        }
        long value = this.c.getValue();
        b bVar = this.f3731d;
        if (value == (((long) bVar.e()) | (((long) bVar.e()) << 16))) {
            long j2 = this.m;
            b bVar2 = this.f3731d;
            if (j2 == ((((long) bVar2.e()) << 16) | ((long) bVar2.e()))) {
                this.c.reset();
                this.f3736i = c.HEADER;
                return true;
            }
        }
        throw new ZipException("Corrupt GZIP trailer");
    }
}
