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
    public final b f3835d = new b(null);

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f3836e = new byte[512];

    /* renamed from: f  reason: collision with root package name */
    public int f3837f;

    /* renamed from: g  reason: collision with root package name */
    public int f3838g;

    /* renamed from: h  reason: collision with root package name */
    public Inflater f3839h;

    /* renamed from: i  reason: collision with root package name */
    public c f3840i = c.HEADER;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3841j = false;

    /* renamed from: k  reason: collision with root package name */
    public int f3842k;

    /* renamed from: l  reason: collision with root package name */
    public int f3843l;
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
            int i4 = r0Var.f3838g - r0Var.f3837f;
            if (i4 > 0) {
                int min = Math.min(i4, i2);
                r0 r0Var2 = r0.this;
                r0Var2.c.update(r0Var2.f3836e, r0Var2.f3837f, min);
                r0.this.f3837f += min;
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
                if ((r0Var.f3838g - r0Var.f3837f) + r0Var.b.b <= 0) {
                    return false;
                }
            } while (bVar.d() != 0);
            return true;
        }

        public static int c(b bVar) {
            r0 r0Var = r0.this;
            return (r0Var.f3838g - r0Var.f3837f) + r0Var.b.b;
        }

        public final int d() {
            int i2;
            r0 r0Var = r0.this;
            int i3 = r0Var.f3838g;
            int i4 = r0Var.f3837f;
            if (i3 - i4 > 0) {
                i2 = r0Var.f3836e[i4] & 255;
                r0Var.f3837f = i4 + 1;
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
        if (r16.f3840i != r2) goto L_0x01e0;
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
        f.b.a.c.b.o.b.G(!this.f3841j, "GzipInflatingBuffer is closed");
        boolean z2 = true;
        int i5 = 0;
        while (z2 && (i4 = i3 - i5) > 0) {
            switch (this.f3840i.ordinal()) {
                case 0:
                    if (b.c(this.f3835d) >= 10) {
                        if (this.f3835d.e() != 35615) {
                            throw new ZipException("Not in GZIP format");
                        } else if (this.f3835d.d() == 8) {
                            this.f3842k = this.f3835d.d();
                            b.a(this.f3835d, 6);
                            this.f3840i = c.HEADER_EXTRA_LEN;
                            z2 = true;
                            break;
                        } else {
                            throw new ZipException("Unsupported compression method");
                        }
                    }
                    z2 = false;
                    break;
                case 1:
                    if ((this.f3842k & 4) == 4) {
                        if (b.c(this.f3835d) >= 2) {
                            this.f3843l = this.f3835d.e();
                            cVar = c.HEADER_EXTRA;
                        }
                        z2 = false;
                        break;
                    } else {
                        cVar = cVar7;
                    }
                    this.f3840i = cVar;
                    z2 = true;
                    break;
                case 2:
                    int c2 = b.c(this.f3835d);
                    int i6 = this.f3843l;
                    if (c2 >= i6) {
                        b.a(this.f3835d, i6);
                        this.f3840i = cVar7;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 3:
                    c cVar8 = c.HEADER_COMMENT;
                    if ((this.f3842k & 8) != 8 || b.b(this.f3835d)) {
                        this.f3840i = cVar8;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 4:
                    c cVar9 = c.HEADER_CRC;
                    if ((this.f3842k & 16) != 16 || b.b(this.f3835d)) {
                        this.f3840i = cVar9;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 5:
                    c cVar10 = c.INITIALIZE_INFLATER;
                    if ((this.f3842k & 2) == 2) {
                        if (b.c(this.f3835d) >= 2) {
                            if ((65535 & ((int) this.c.getValue())) != this.f3835d.e()) {
                                throw new ZipException("Corrupt GZIP header");
                            }
                        }
                        z2 = false;
                        break;
                    }
                    this.f3840i = cVar10;
                    z2 = true;
                    break;
                case 6:
                    Inflater inflater = this.f3839h;
                    if (inflater == null) {
                        this.f3839h = new Inflater(true);
                    } else {
                        inflater.reset();
                    }
                    this.c.reset();
                    int i7 = this.f3838g;
                    int i8 = this.f3837f;
                    int i9 = i7 - i8;
                    if (i9 > 0) {
                        this.f3839h.setInput(this.f3836e, i8, i9);
                        cVar2 = cVar5;
                    } else {
                        cVar2 = cVar6;
                    }
                    this.f3840i = cVar2;
                    z2 = true;
                    break;
                case 7:
                    int i10 = i2 + i5;
                    f.b.a.c.b.o.b.G(this.f3839h != null, "inflater is null");
                    try {
                        int totalIn = this.f3839h.getTotalIn();
                        int inflate = this.f3839h.inflate(bArr, i10, i4);
                        int totalIn2 = this.f3839h.getTotalIn() - totalIn;
                        this.n += totalIn2;
                        this.o += totalIn2;
                        this.f3837f += totalIn2;
                        this.c.update(bArr, i10, inflate);
                        if (!this.f3839h.finished()) {
                            if (this.f3839h.needsInput()) {
                                cVar3 = cVar6;
                            }
                            i5 += inflate;
                            break;
                        } else {
                            this.m = this.f3839h.getBytesWritten() & 4294967295L;
                            cVar3 = cVar4;
                        }
                        this.f3840i = cVar3;
                        i5 += inflate;
                    } catch (DataFormatException e2) {
                        StringBuilder h2 = f.a.a.a.a.h("Inflater data format exception: ");
                        h2.append(e2.getMessage());
                        throw new DataFormatException(h2.toString());
                    }
                case 8:
                    f.b.a.c.b.o.b.G(this.f3839h != null, "inflater is null");
                    f.b.a.c.b.o.b.G(this.f3837f == this.f3838g, "inflaterInput has unconsumed bytes");
                    int min = Math.min(this.b.b, 512);
                    if (min != 0) {
                        this.f3837f = 0;
                        this.f3838g = min;
                        this.b.O(this.f3836e, 0, min);
                        this.f3839h.setInput(this.f3836e, this.f3837f, min);
                        this.f3840i = cVar5;
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
                    h3.append(this.f3840i);
                    throw new AssertionError(h3.toString());
            }
        }
        if (z2 && (this.f3840i != c.HEADER || b.c(this.f3835d) >= 10)) {
            z = false;
        }
        this.p = z;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f3841j) {
            this.f3841j = true;
            this.b.close();
            Inflater inflater = this.f3839h;
            if (inflater != null) {
                inflater.end();
                this.f3839h = null;
            }
        }
    }

    public final boolean d() {
        if (this.f3839h != null && b.c(this.f3835d) <= 18) {
            this.f3839h.end();
            this.f3839h = null;
        }
        if (b.c(this.f3835d) < 8) {
            return false;
        }
        long value = this.c.getValue();
        b bVar = this.f3835d;
        if (value == (((long) bVar.e()) | (((long) bVar.e()) << 16))) {
            long j2 = this.m;
            b bVar2 = this.f3835d;
            if (j2 == ((((long) bVar2.e()) << 16) | ((long) bVar2.e()))) {
                this.c.reset();
                this.f3840i = c.HEADER;
                return true;
            }
        }
        throw new ZipException("Corrupt GZIP trailer");
    }
}
