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
    public final b f3989d = new b(null);

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f3990e = new byte[512];

    /* renamed from: f  reason: collision with root package name */
    public int f3991f;

    /* renamed from: g  reason: collision with root package name */
    public int f3992g;

    /* renamed from: h  reason: collision with root package name */
    public Inflater f3993h;

    /* renamed from: i  reason: collision with root package name */
    public c f3994i = c.HEADER;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3995j = false;

    /* renamed from: k  reason: collision with root package name */
    public int f3996k;

    /* renamed from: l  reason: collision with root package name */
    public int f3997l;
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
            int i4 = r0Var.f3992g - r0Var.f3991f;
            if (i4 > 0) {
                int min = Math.min(i4, i2);
                r0 r0Var2 = r0.this;
                r0Var2.c.update(r0Var2.f3990e, r0Var2.f3991f, min);
                r0.this.f3991f += min;
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
                    yVar.x(new y.b(yVar, 0, bArr), min2);
                    r0.this.c.update(bArr, 0, min2);
                    i5 += min2;
                }
            }
            r0.this.n += i2;
        }

        public static boolean b(b bVar) {
            do {
                r0 r0Var = r0.this;
                if ((r0Var.f3992g - r0Var.f3991f) + r0Var.b.b <= 0) {
                    return false;
                }
            } while (bVar.d() != 0);
            return true;
        }

        public static int c(b bVar) {
            r0 r0Var = r0.this;
            return (r0Var.f3992g - r0Var.f3991f) + r0Var.b.b;
        }

        public final int d() {
            int i2;
            r0 r0Var = r0.this;
            int i3 = r0Var.f3992g;
            int i4 = r0Var.f3991f;
            if (i3 - i4 > 0) {
                i2 = r0Var.f3990e[i4] & 255;
                r0Var.f3991f = i4 + 1;
            } else {
                i2 = r0Var.b.readUnsignedByte();
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
        if (r16.f3994i != r2) goto L_0x01e0;
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
        f.b.a.c.b.o.b.F(!this.f3995j, "GzipInflatingBuffer is closed");
        boolean z2 = true;
        int i5 = 0;
        while (z2 && (i4 = i3 - i5) > 0) {
            switch (this.f3994i.ordinal()) {
                case 0:
                    if (b.c(this.f3989d) >= 10) {
                        if (this.f3989d.e() != 35615) {
                            throw new ZipException("Not in GZIP format");
                        } else if (this.f3989d.d() == 8) {
                            this.f3996k = this.f3989d.d();
                            b.a(this.f3989d, 6);
                            this.f3994i = c.HEADER_EXTRA_LEN;
                            z2 = true;
                            break;
                        } else {
                            throw new ZipException("Unsupported compression method");
                        }
                    }
                    z2 = false;
                    break;
                case 1:
                    if ((this.f3996k & 4) == 4) {
                        if (b.c(this.f3989d) >= 2) {
                            this.f3997l = this.f3989d.e();
                            cVar = c.HEADER_EXTRA;
                        }
                        z2 = false;
                        break;
                    } else {
                        cVar = cVar7;
                    }
                    this.f3994i = cVar;
                    z2 = true;
                    break;
                case 2:
                    int c2 = b.c(this.f3989d);
                    int i6 = this.f3997l;
                    if (c2 >= i6) {
                        b.a(this.f3989d, i6);
                        this.f3994i = cVar7;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 3:
                    c cVar8 = c.HEADER_COMMENT;
                    if ((this.f3996k & 8) != 8 || b.b(this.f3989d)) {
                        this.f3994i = cVar8;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 4:
                    c cVar9 = c.HEADER_CRC;
                    if ((this.f3996k & 16) != 16 || b.b(this.f3989d)) {
                        this.f3994i = cVar9;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 5:
                    c cVar10 = c.INITIALIZE_INFLATER;
                    if ((this.f3996k & 2) == 2) {
                        if (b.c(this.f3989d) >= 2) {
                            if ((65535 & ((int) this.c.getValue())) != this.f3989d.e()) {
                                throw new ZipException("Corrupt GZIP header");
                            }
                        }
                        z2 = false;
                        break;
                    }
                    this.f3994i = cVar10;
                    z2 = true;
                    break;
                case 6:
                    Inflater inflater = this.f3993h;
                    if (inflater == null) {
                        this.f3993h = new Inflater(true);
                    } else {
                        inflater.reset();
                    }
                    this.c.reset();
                    int i7 = this.f3992g;
                    int i8 = this.f3991f;
                    int i9 = i7 - i8;
                    if (i9 > 0) {
                        this.f3993h.setInput(this.f3990e, i8, i9);
                        cVar2 = cVar5;
                    } else {
                        cVar2 = cVar6;
                    }
                    this.f3994i = cVar2;
                    z2 = true;
                    break;
                case 7:
                    int i10 = i2 + i5;
                    f.b.a.c.b.o.b.F(this.f3993h != null, "inflater is null");
                    try {
                        int totalIn = this.f3993h.getTotalIn();
                        int inflate = this.f3993h.inflate(bArr, i10, i4);
                        int totalIn2 = this.f3993h.getTotalIn() - totalIn;
                        this.n += totalIn2;
                        this.o += totalIn2;
                        this.f3991f += totalIn2;
                        this.c.update(bArr, i10, inflate);
                        if (!this.f3993h.finished()) {
                            if (this.f3993h.needsInput()) {
                                cVar3 = cVar6;
                            }
                            i5 += inflate;
                            break;
                        } else {
                            this.m = this.f3993h.getBytesWritten() & 4294967295L;
                            cVar3 = cVar4;
                        }
                        this.f3994i = cVar3;
                        i5 += inflate;
                    } catch (DataFormatException e2) {
                        StringBuilder i11 = f.a.a.a.a.i("Inflater data format exception: ");
                        i11.append(e2.getMessage());
                        throw new DataFormatException(i11.toString());
                    }
                case 8:
                    f.b.a.c.b.o.b.F(this.f3993h != null, "inflater is null");
                    f.b.a.c.b.o.b.F(this.f3991f == this.f3992g, "inflaterInput has unconsumed bytes");
                    int min = Math.min(this.b.b, 512);
                    if (min != 0) {
                        this.f3991f = 0;
                        this.f3992g = min;
                        this.b.K(this.f3990e, 0, min);
                        this.f3993h.setInput(this.f3990e, this.f3991f, min);
                        this.f3994i = cVar5;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 9:
                    z2 = d();
                    break;
                default:
                    StringBuilder i12 = f.a.a.a.a.i("Invalid state: ");
                    i12.append(this.f3994i);
                    throw new AssertionError(i12.toString());
            }
        }
        if (z2 && (this.f3994i != c.HEADER || b.c(this.f3989d) >= 10)) {
            z = false;
        }
        this.p = z;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f3995j) {
            this.f3995j = true;
            this.b.close();
            Inflater inflater = this.f3993h;
            if (inflater != null) {
                inflater.end();
                this.f3993h = null;
            }
        }
    }

    public final boolean d() {
        if (this.f3993h != null && b.c(this.f3989d) <= 18) {
            this.f3993h.end();
            this.f3993h = null;
        }
        if (b.c(this.f3989d) < 8) {
            return false;
        }
        long value = this.c.getValue();
        b bVar = this.f3989d;
        if (value == (((long) bVar.e()) | (((long) bVar.e()) << 16))) {
            long j2 = this.m;
            b bVar2 = this.f3989d;
            if (j2 == ((((long) bVar2.e()) << 16) | ((long) bVar2.e()))) {
                this.c.reset();
                this.f3994i = c.HEADER;
                return true;
            }
        }
        throw new ZipException("Corrupt GZIP trailer");
    }
}
