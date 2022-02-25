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
    public final b f3739d = new b(null);

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f3740e = new byte[512];

    /* renamed from: f  reason: collision with root package name */
    public int f3741f;

    /* renamed from: g  reason: collision with root package name */
    public int f3742g;

    /* renamed from: h  reason: collision with root package name */
    public Inflater f3743h;

    /* renamed from: i  reason: collision with root package name */
    public c f3744i = c.HEADER;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3745j = false;

    /* renamed from: k  reason: collision with root package name */
    public int f3746k;

    /* renamed from: l  reason: collision with root package name */
    public int f3747l;
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
            int i4 = r0Var.f3742g - r0Var.f3741f;
            if (i4 > 0) {
                int min = Math.min(i4, i2);
                r0 r0Var2 = r0.this;
                r0Var2.c.update(r0Var2.f3740e, r0Var2.f3741f, min);
                r0.this.f3741f += min;
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
                if ((r0Var.f3742g - r0Var.f3741f) + r0Var.b.b <= 0) {
                    return false;
                }
            } while (bVar.d() != 0);
            return true;
        }

        public static int c(b bVar) {
            r0 r0Var = r0.this;
            return (r0Var.f3742g - r0Var.f3741f) + r0Var.b.b;
        }

        public final int d() {
            int i2;
            r0 r0Var = r0.this;
            int i3 = r0Var.f3742g;
            int i4 = r0Var.f3741f;
            if (i3 - i4 > 0) {
                i2 = r0Var.f3740e[i4] & 255;
                r0Var.f3741f = i4 + 1;
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
        if (r16.f3744i != r2) goto L_0x01e0;
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
        f.b.a.c.b.o.b.G(!this.f3745j, "GzipInflatingBuffer is closed");
        boolean z2 = true;
        int i5 = 0;
        while (z2 && (i4 = i3 - i5) > 0) {
            switch (this.f3744i.ordinal()) {
                case 0:
                    if (b.c(this.f3739d) >= 10) {
                        if (this.f3739d.e() != 35615) {
                            throw new ZipException("Not in GZIP format");
                        } else if (this.f3739d.d() == 8) {
                            this.f3746k = this.f3739d.d();
                            b.a(this.f3739d, 6);
                            this.f3744i = c.HEADER_EXTRA_LEN;
                            z2 = true;
                            break;
                        } else {
                            throw new ZipException("Unsupported compression method");
                        }
                    }
                    z2 = false;
                    break;
                case 1:
                    if ((this.f3746k & 4) == 4) {
                        if (b.c(this.f3739d) >= 2) {
                            this.f3747l = this.f3739d.e();
                            cVar = c.HEADER_EXTRA;
                        }
                        z2 = false;
                        break;
                    } else {
                        cVar = cVar7;
                    }
                    this.f3744i = cVar;
                    z2 = true;
                    break;
                case 2:
                    int c2 = b.c(this.f3739d);
                    int i6 = this.f3747l;
                    if (c2 >= i6) {
                        b.a(this.f3739d, i6);
                        this.f3744i = cVar7;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 3:
                    c cVar8 = c.HEADER_COMMENT;
                    if ((this.f3746k & 8) != 8 || b.b(this.f3739d)) {
                        this.f3744i = cVar8;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 4:
                    c cVar9 = c.HEADER_CRC;
                    if ((this.f3746k & 16) != 16 || b.b(this.f3739d)) {
                        this.f3744i = cVar9;
                        z2 = true;
                        break;
                    }
                    z2 = false;
                    break;
                case 5:
                    c cVar10 = c.INITIALIZE_INFLATER;
                    if ((this.f3746k & 2) == 2) {
                        if (b.c(this.f3739d) >= 2) {
                            if ((65535 & ((int) this.c.getValue())) != this.f3739d.e()) {
                                throw new ZipException("Corrupt GZIP header");
                            }
                        }
                        z2 = false;
                        break;
                    }
                    this.f3744i = cVar10;
                    z2 = true;
                    break;
                case 6:
                    Inflater inflater = this.f3743h;
                    if (inflater == null) {
                        this.f3743h = new Inflater(true);
                    } else {
                        inflater.reset();
                    }
                    this.c.reset();
                    int i7 = this.f3742g;
                    int i8 = this.f3741f;
                    int i9 = i7 - i8;
                    if (i9 > 0) {
                        this.f3743h.setInput(this.f3740e, i8, i9);
                        cVar2 = cVar5;
                    } else {
                        cVar2 = cVar6;
                    }
                    this.f3744i = cVar2;
                    z2 = true;
                    break;
                case 7:
                    int i10 = i2 + i5;
                    f.b.a.c.b.o.b.G(this.f3743h != null, "inflater is null");
                    try {
                        int totalIn = this.f3743h.getTotalIn();
                        int inflate = this.f3743h.inflate(bArr, i10, i4);
                        int totalIn2 = this.f3743h.getTotalIn() - totalIn;
                        this.n += totalIn2;
                        this.o += totalIn2;
                        this.f3741f += totalIn2;
                        this.c.update(bArr, i10, inflate);
                        if (!this.f3743h.finished()) {
                            if (this.f3743h.needsInput()) {
                                cVar3 = cVar6;
                            }
                            i5 += inflate;
                            break;
                        } else {
                            this.m = this.f3743h.getBytesWritten() & 4294967295L;
                            cVar3 = cVar4;
                        }
                        this.f3744i = cVar3;
                        i5 += inflate;
                    } catch (DataFormatException e2) {
                        StringBuilder h2 = f.a.a.a.a.h("Inflater data format exception: ");
                        h2.append(e2.getMessage());
                        throw new DataFormatException(h2.toString());
                    }
                case 8:
                    f.b.a.c.b.o.b.G(this.f3743h != null, "inflater is null");
                    f.b.a.c.b.o.b.G(this.f3741f == this.f3742g, "inflaterInput has unconsumed bytes");
                    int min = Math.min(this.b.b, 512);
                    if (min != 0) {
                        this.f3741f = 0;
                        this.f3742g = min;
                        this.b.O(this.f3740e, 0, min);
                        this.f3743h.setInput(this.f3740e, this.f3741f, min);
                        this.f3744i = cVar5;
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
                    h3.append(this.f3744i);
                    throw new AssertionError(h3.toString());
            }
        }
        if (z2 && (this.f3744i != c.HEADER || b.c(this.f3739d) >= 10)) {
            z = false;
        }
        this.p = z;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f3745j) {
            this.f3745j = true;
            this.b.close();
            Inflater inflater = this.f3743h;
            if (inflater != null) {
                inflater.end();
                this.f3743h = null;
            }
        }
    }

    public final boolean d() {
        if (this.f3743h != null && b.c(this.f3739d) <= 18) {
            this.f3743h.end();
            this.f3743h = null;
        }
        if (b.c(this.f3739d) < 8) {
            return false;
        }
        long value = this.c.getValue();
        b bVar = this.f3739d;
        if (value == (((long) bVar.e()) | (((long) bVar.e()) << 16))) {
            long j2 = this.m;
            b bVar2 = this.f3739d;
            if (j2 == ((((long) bVar2.e()) << 16) | ((long) bVar2.e()))) {
                this.c.reset();
                this.f3744i = c.HEADER;
                return true;
            }
        }
        throw new ZipException("Corrupt GZIP trailer");
    }
}
