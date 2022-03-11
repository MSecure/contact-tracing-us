package h.a.j1;

import h.a.j1.y;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
/* loaded from: classes.dex */
public class r0 implements Closeable {

    /* renamed from: f */
    public int f4311f;

    /* renamed from: g */
    public int f4312g;

    /* renamed from: h */
    public Inflater f4313h;

    /* renamed from: k */
    public int f4316k;

    /* renamed from: l */
    public int f4317l;
    public long m;
    public final y b = new y();
    public final CRC32 c = new CRC32();

    /* renamed from: d */
    public final b f4309d = new b(null);

    /* renamed from: e */
    public final byte[] f4310e = new byte[512];

    /* renamed from: i */
    public c f4314i = c.HEADER;

    /* renamed from: j */
    public boolean f4315j = false;
    public int n = 0;
    public int o = 0;
    public boolean p = true;

    /* loaded from: classes.dex */
    public class b {
        public b(a aVar) {
            r0.this = r1;
        }

        public static void a(b bVar, int i2) {
            int i3;
            r0 r0Var = r0.this;
            int i4 = r0Var.f4312g - r0Var.f4311f;
            if (i4 > 0) {
                int min = Math.min(i4, i2);
                r0 r0Var2 = r0.this;
                r0Var2.c.update(r0Var2.f4310e, r0Var2.f4311f, min);
                r0.this.f4311f += min;
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
                if ((r0Var.f4312g - r0Var.f4311f) + r0Var.b.b <= 0) {
                    return false;
                }
            } while (bVar.d() != 0);
            return true;
        }

        public static int c(b bVar) {
            r0 r0Var = r0.this;
            return (r0Var.f4312g - r0Var.f4311f) + r0Var.b.b;
        }

        public final int d() {
            int i2;
            r0 r0Var = r0.this;
            int i3 = r0Var.f4312g;
            int i4 = r0Var.f4311f;
            if (i3 - i4 > 0) {
                i2 = r0Var.f4310e[i4] & 255;
                r0Var.f4311f = i4 + 1;
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

    /* loaded from: classes.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:111:0x01e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00dc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
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
        f.b.a.c.b.o.b.G(!this.f4315j, "GzipInflatingBuffer is closed");
        boolean z2 = true;
        int i5 = 0;
        while (z2 && (i4 = i3 - i5) > 0) {
            switch (this.f4314i.ordinal()) {
                case 0:
                    if (b.c(this.f4309d) < 10) {
                        z2 = false;
                    } else if (this.f4309d.e() != 35615) {
                        throw new ZipException("Not in GZIP format");
                    } else if (this.f4309d.d() == 8) {
                        this.f4316k = this.f4309d.d();
                        b.a(this.f4309d, 6);
                        this.f4314i = c.HEADER_EXTRA_LEN;
                        z2 = true;
                    } else {
                        throw new ZipException("Unsupported compression method");
                    }
                case 1:
                    if ((this.f4316k & 4) != 4) {
                        cVar2 = cVar7;
                    } else if (b.c(this.f4309d) < 2) {
                        z2 = false;
                    } else {
                        this.f4317l = this.f4309d.e();
                        cVar2 = c.HEADER_EXTRA;
                    }
                    this.f4314i = cVar2;
                    z2 = true;
                case 2:
                    int c2 = b.c(this.f4309d);
                    int i6 = this.f4317l;
                    if (c2 < i6) {
                        z2 = false;
                    } else {
                        b.a(this.f4309d, i6);
                        this.f4314i = cVar7;
                        z2 = true;
                    }
                case 3:
                    c cVar8 = c.HEADER_COMMENT;
                    if ((this.f4316k & 8) == 8 && !b.b(this.f4309d)) {
                        z2 = false;
                    } else {
                        this.f4314i = cVar8;
                        z2 = true;
                    }
                    break;
                case 4:
                    c cVar9 = c.HEADER_CRC;
                    if ((this.f4316k & 16) == 16 && !b.b(this.f4309d)) {
                        z2 = false;
                    } else {
                        this.f4314i = cVar9;
                        z2 = true;
                    }
                    break;
                case 5:
                    c cVar10 = c.INITIALIZE_INFLATER;
                    if ((this.f4316k & 2) == 2) {
                        if (b.c(this.f4309d) < 2) {
                            z2 = false;
                        } else if ((65535 & ((int) this.c.getValue())) != this.f4309d.e()) {
                            throw new ZipException("Corrupt GZIP header");
                        }
                    }
                    this.f4314i = cVar10;
                    z2 = true;
                case 6:
                    Inflater inflater = this.f4313h;
                    if (inflater == null) {
                        this.f4313h = new Inflater(true);
                    } else {
                        inflater.reset();
                    }
                    this.c.reset();
                    int i7 = this.f4312g;
                    int i8 = this.f4311f;
                    int i9 = i7 - i8;
                    if (i9 > 0) {
                        this.f4313h.setInput(this.f4310e, i8, i9);
                        cVar3 = cVar5;
                    } else {
                        cVar3 = cVar6;
                    }
                    this.f4314i = cVar3;
                    z2 = true;
                case 7:
                    int i10 = i2 + i5;
                    f.b.a.c.b.o.b.G(this.f4313h != null, "inflater is null");
                    try {
                        int totalIn = this.f4313h.getTotalIn();
                        int inflate = this.f4313h.inflate(bArr, i10, i4);
                        int totalIn2 = this.f4313h.getTotalIn() - totalIn;
                        this.n += totalIn2;
                        this.o += totalIn2;
                        this.f4311f += totalIn2;
                        this.c.update(bArr, i10, inflate);
                        if (this.f4313h.finished()) {
                            this.m = this.f4313h.getBytesWritten() & 4294967295L;
                            cVar = cVar4;
                        } else {
                            if (this.f4313h.needsInput()) {
                                cVar = cVar6;
                            }
                            i5 += inflate;
                            if (this.f4314i != cVar4) {
                                z2 = d();
                            } else {
                                z2 = true;
                            }
                        }
                        this.f4314i = cVar;
                        i5 += inflate;
                        if (this.f4314i != cVar4) {
                        }
                    } catch (DataFormatException e2) {
                        StringBuilder h2 = f.a.a.a.a.h("Inflater data format exception: ");
                        h2.append(e2.getMessage());
                        throw new DataFormatException(h2.toString());
                    }
                case 8:
                    f.b.a.c.b.o.b.G(this.f4313h != null, "inflater is null");
                    f.b.a.c.b.o.b.G(this.f4311f == this.f4312g, "inflaterInput has unconsumed bytes");
                    int min = Math.min(this.b.b, 512);
                    if (min == 0) {
                        z2 = false;
                    } else {
                        this.f4311f = 0;
                        this.f4312g = min;
                        this.b.K(this.f4310e, 0, min);
                        this.f4313h.setInput(this.f4310e, this.f4311f, min);
                        this.f4314i = cVar5;
                        z2 = true;
                    }
                case 9:
                    z2 = d();
                default:
                    StringBuilder h3 = f.a.a.a.a.h("Invalid state: ");
                    h3.append(this.f4314i);
                    throw new AssertionError(h3.toString());
            }
        }
        if (z2 && (this.f4314i != c.HEADER || b.c(this.f4309d) >= 10)) {
            z = false;
        }
        this.p = z;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f4315j) {
            this.f4315j = true;
            this.b.close();
            Inflater inflater = this.f4313h;
            if (inflater != null) {
                inflater.end();
                this.f4313h = null;
            }
        }
    }

    public final boolean d() {
        if (this.f4313h != null && b.c(this.f4309d) <= 18) {
            this.f4313h.end();
            this.f4313h = null;
        }
        if (b.c(this.f4309d) < 8) {
            return false;
        }
        long value = this.c.getValue();
        b bVar = this.f4309d;
        if (value == (((long) bVar.e()) | (((long) bVar.e()) << 16))) {
            long j2 = this.m;
            b bVar2 = this.f4309d;
            if (j2 == ((((long) bVar2.e()) << 16) | ((long) bVar2.e()))) {
                this.c.reset();
                this.f4314i = c.HEADER;
                return true;
            }
        }
        throw new ZipException("Corrupt GZIP trailer");
    }
}
