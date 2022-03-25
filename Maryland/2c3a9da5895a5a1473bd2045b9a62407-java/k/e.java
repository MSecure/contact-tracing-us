package k;

import f.a.a.a.a;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Objects;

public final class e implements g, f, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f4109d = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public o b;
    public long c;

    public int A(byte[] bArr, int i2, int i3) {
        u.b((long) bArr.length, (long) i2, (long) i3);
        o oVar = this.b;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i3, oVar.c - oVar.b);
        System.arraycopy(oVar.a, oVar.b, bArr, i2, min);
        int i4 = oVar.b + min;
        oVar.b = i4;
        this.c -= (long) min;
        if (i4 == oVar.c) {
            this.b = oVar.a();
            p.a(oVar);
        }
        return min;
    }

    @Override // k.g
    public void G(long j2) {
        if (this.c < j2) {
            throw new EOFException();
        }
    }

    @Override // k.g
    public boolean J() {
        return this.c == 0;
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f K(int i2) {
        b0(i2);
        return this;
    }

    @Override // k.g
    public byte[] M(long j2) {
        u.b(this.c, 0, j2);
        if (j2 <= 2147483647L) {
            int i2 = (int) j2;
            byte[] bArr = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                int A = A(bArr, i3, i2 - i3);
                if (A != -1) {
                    i3 += A;
                } else {
                    throw new EOFException();
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    public h N() {
        try {
            return new h(M(this.c));
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String P(long j2, Charset charset) {
        u.b(this.c, 0, j2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j2 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
        } else if (j2 == 0) {
            return "";
        } else {
            o oVar = this.b;
            if (((long) oVar.b) + j2 > ((long) oVar.c)) {
                return new String(M(j2), charset);
            }
            String str = new String(oVar.a, oVar.b, (int) j2, charset);
            int i2 = (int) (((long) oVar.b) + j2);
            oVar.b = i2;
            this.c -= j2;
            if (i2 == oVar.c) {
                this.b = oVar.a();
                p.a(oVar);
            }
            return str;
        }
    }

    @Override // k.g
    public byte Q() {
        long j2 = this.c;
        if (j2 != 0) {
            o oVar = this.b;
            int i2 = oVar.b;
            int i3 = oVar.c;
            int i4 = i2 + 1;
            byte b2 = oVar.a[i2];
            this.c = j2 - 1;
            if (i4 == i3) {
                this.b = oVar.a();
                p.a(oVar);
            } else {
                oVar.b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public String V() {
        try {
            return P(this.c, u.a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String W(long j2) {
        String P;
        long j3 = 1;
        if (j2 > 0) {
            long j4 = j2 - 1;
            if (v(j4) == 13) {
                P = P(j4, u.a);
                j3 = 2;
                p(j3);
                return P;
            }
        }
        P = P(j2, u.a);
        p(j3);
        return P;
    }

    public h X() {
        long j2 = this.c;
        if (j2 <= 2147483647L) {
            int i2 = (int) j2;
            return i2 == 0 ? h.f4111f : new q(this, i2);
        }
        StringBuilder h2 = a.h("size > Integer.MAX_VALUE: ");
        h2.append(this.c);
        throw new IllegalArgumentException(h2.toString());
    }

    public o Y(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        o oVar = this.b;
        if (oVar == null) {
            o b2 = p.b();
            this.b = b2;
            b2.f4118g = b2;
            b2.f4117f = b2;
            return b2;
        }
        o oVar2 = oVar.f4118g;
        if (oVar2.c + i2 <= 8192 && oVar2.f4116e) {
            return oVar2;
        }
        o b3 = p.b();
        oVar2.b(b3);
        return b3;
    }

    public e Z(h hVar) {
        hVar.r(this);
        return this;
    }

    @Override // k.f
    public f a(byte[] bArr) {
        if (bArr != null) {
            a0(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public e a0(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = (long) i3;
            u.b((long) bArr.length, (long) i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                o Y = Y(1);
                int min = Math.min(i4 - i2, 8192 - Y.c);
                System.arraycopy(bArr, i2, Y.a, Y.c, min);
                i2 += min;
                Y.c += min;
            }
            this.c += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public e b0(int i2) {
        o Y = Y(1);
        byte[] bArr = Y.a;
        int i3 = Y.c;
        Y.c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.c++;
        return this;
    }

    public void c() {
        try {
            p(this.c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public e c0(int i2) {
        o Y = Y(4);
        byte[] bArr = Y.a;
        int i3 = Y.c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        Y.c = i6 + 1;
        this.c += 4;
        return this;
    }

    @Override // java.lang.Object
    public Object clone() {
        e eVar = new e();
        if (this.c != 0) {
            o oVar = new o(this.b);
            eVar.b = oVar;
            oVar.f4118g = oVar;
            oVar.f4117f = oVar;
            o oVar2 = this.b;
            while (true) {
                oVar2 = oVar2.f4117f;
                if (oVar2 == this.b) {
                    break;
                }
                eVar.b.f4118g.b(new o(oVar2));
            }
            eVar.c = this.c;
        }
        return eVar;
    }

    @Override // k.s, java.io.Closeable, java.lang.AutoCloseable, k.r
    public void close() {
    }

    public long d() {
        long j2 = this.c;
        if (j2 == 0) {
            return 0;
        }
        o oVar = this.b.f4118g;
        int i2 = oVar.c;
        return (i2 >= 8192 || !oVar.f4116e) ? j2 : j2 - ((long) (i2 - oVar.b));
    }

    public e d0(int i2) {
        o Y = Y(2);
        byte[] bArr = Y.a;
        int i3 = Y.c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        Y.c = i4 + 1;
        this.c += 2;
        return this;
    }

    public e e0(String str) {
        f0(str, 0, str.length());
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        long j2 = this.c;
        if (j2 != eVar.c) {
            return false;
        }
        long j3 = 0;
        if (j2 == 0) {
            return true;
        }
        o oVar = this.b;
        o oVar2 = eVar.b;
        int i2 = oVar.b;
        int i3 = oVar2.b;
        while (j3 < this.c) {
            long min = (long) Math.min(oVar.c - i2, oVar2.c - i3);
            int i4 = 0;
            while (((long) i4) < min) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (oVar.a[i2] != oVar2.a[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == oVar.c) {
                oVar = oVar.f4117f;
                i2 = oVar.b;
            }
            if (i3 == oVar2.c) {
                oVar2 = oVar2.f4117f;
                i3 = oVar2.b;
            }
            j3 += min;
        }
        return true;
    }

    public e f0(String str, int i2, int i3) {
        int i4;
        char charAt;
        if (i2 < 0) {
            throw new IllegalArgumentException(a.q("beginIndex < 0: ", i2));
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 <= str.length()) {
            while (i2 < i3) {
                char charAt2 = str.charAt(i2);
                if (charAt2 < 128) {
                    o Y = Y(1);
                    byte[] bArr = Y.a;
                    int i5 = Y.c - i2;
                    int min = Math.min(i3, 8192 - i5);
                    int i6 = i2 + 1;
                    bArr[i2 + i5] = (byte) charAt2;
                    while (true) {
                        i2 = i6;
                        if (i2 >= min || (charAt = str.charAt(i2)) >= 128) {
                            int i7 = Y.c;
                            int i8 = (i5 + i2) - i7;
                            Y.c = i7 + i8;
                            this.c += (long) i8;
                        } else {
                            i6 = i2 + 1;
                            bArr[i2 + i5] = (byte) charAt;
                        }
                    }
                    int i72 = Y.c;
                    int i82 = (i5 + i2) - i72;
                    Y.c = i72 + i82;
                    this.c += (long) i82;
                } else {
                    if (charAt2 < 2048) {
                        i4 = (charAt2 >> 6) | 192;
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        b0((charAt2 >> '\f') | 224);
                        i4 = ((charAt2 >> 6) & 63) | 128;
                    } else {
                        int i9 = i2 + 1;
                        char charAt3 = i9 < i3 ? str.charAt(i9) : 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            b0(63);
                            i2 = i9;
                        } else {
                            int i10 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                            b0((i10 >> 18) | 240);
                            b0(((i10 >> 12) & 63) | 128);
                            b0(((i10 >> 6) & 63) | 128);
                            b0((i10 & 63) | 128);
                            i2 += 2;
                        }
                    }
                    b0(i4);
                    b0((charAt2 & '?') | 128);
                    i2++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
    }

    @Override // k.f, k.r, java.io.Flushable
    public void flush() {
    }

    @Override // k.r
    public void h(e eVar, long j2) {
        o oVar;
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (eVar != this) {
            u.b(eVar.c, 0, j2);
            while (j2 > 0) {
                o oVar2 = eVar.b;
                int i2 = 0;
                if (j2 < ((long) (oVar2.c - oVar2.b))) {
                    o oVar3 = this.b;
                    o oVar4 = oVar3 != null ? oVar3.f4118g : null;
                    if (oVar4 != null && oVar4.f4116e) {
                        if ((((long) oVar4.c) + j2) - ((long) (oVar4.f4115d ? 0 : oVar4.b)) <= 8192) {
                            oVar2.c(oVar4, (int) j2);
                            eVar.c -= j2;
                            this.c += j2;
                            return;
                        }
                    }
                    int i3 = (int) j2;
                    Objects.requireNonNull(oVar2);
                    if (i3 <= 0 || i3 > oVar2.c - oVar2.b) {
                        throw new IllegalArgumentException();
                    }
                    if (i3 >= 1024) {
                        oVar = new o(oVar2);
                    } else {
                        oVar = p.b();
                        System.arraycopy(oVar2.a, oVar2.b, oVar.a, 0, i3);
                    }
                    oVar.c = oVar.b + i3;
                    oVar2.b += i3;
                    oVar2.f4118g.b(oVar);
                    eVar.b = oVar;
                }
                o oVar5 = eVar.b;
                long j3 = (long) (oVar5.c - oVar5.b);
                eVar.b = oVar5.a();
                o oVar6 = this.b;
                if (oVar6 == null) {
                    this.b = oVar5;
                    oVar5.f4118g = oVar5;
                    oVar5.f4117f = oVar5;
                } else {
                    oVar6.f4118g.b(oVar5);
                    o oVar7 = oVar5.f4118g;
                    if (oVar7 == oVar5) {
                        throw new IllegalStateException();
                    } else if (oVar7.f4116e) {
                        int i4 = oVar5.c - oVar5.b;
                        int i5 = 8192 - oVar7.c;
                        if (!oVar7.f4115d) {
                            i2 = oVar7.b;
                        }
                        if (i4 <= i5 + i2) {
                            oVar5.c(oVar7, i4);
                            oVar5.a();
                            p.a(oVar5);
                        }
                    }
                }
                eVar.c -= j3;
                this.c += j3;
                j2 -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public int hashCode() {
        o oVar = this.b;
        if (oVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = oVar.c;
            for (int i4 = oVar.b; i4 < i3; i4++) {
                i2 = (i2 * 31) + oVar.a[i4];
            }
            oVar = oVar.f4117f;
        } while (oVar != this.b);
        return i2;
    }

    @Override // k.g
    public e l() {
        return this;
    }

    @Override // k.s
    public long m(e eVar, long j2) {
        if (eVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 >= 0) {
            long j3 = this.c;
            if (j3 == 0) {
                return -1;
            }
            if (j2 > j3) {
                j2 = j3;
            }
            eVar.h(this, j2);
            return j2;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
    }

    @Override // k.g
    public h n(long j2) {
        return new h(M(j2));
    }

    @Override // k.g
    public void p(long j2) {
        while (j2 > 0) {
            o oVar = this.b;
            if (oVar != null) {
                int min = (int) Math.min(j2, (long) (oVar.c - oVar.b));
                long j3 = (long) min;
                this.c -= j3;
                j2 -= j3;
                o oVar2 = this.b;
                int i2 = oVar2.b + min;
                oVar2.b = i2;
                if (i2 == oVar2.c) {
                    this.b = oVar2.a();
                    p.a(oVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // k.g
    public short r() {
        long j2 = this.c;
        if (j2 >= 2) {
            o oVar = this.b;
            int i2 = oVar.b;
            int i3 = oVar.c;
            if (i3 - i2 < 2) {
                return (short) (((Q() & 255) << 8) | (Q() & 255));
            }
            byte[] bArr = oVar.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.c = j2 - 2;
            if (i5 == i3) {
                this.b = oVar.a();
                p.a(oVar);
            } else {
                oVar.b = i5;
            }
            return (short) i6;
        }
        StringBuilder h2 = a.h("size < 2: ");
        h2.append(this.c);
        throw new IllegalStateException(h2.toString());
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f s(int i2) {
        d0(i2);
        return this;
    }

    public String toString() {
        return X().toString();
    }

    public byte v(long j2) {
        u.b(this.c, j2, 1);
        o oVar = this.b;
        while (true) {
            int i2 = oVar.c;
            int i3 = oVar.b;
            long j3 = (long) (i2 - i3);
            if (j2 < j3) {
                return oVar.a[i3 + ((int) j2)];
            }
            j2 -= j3;
            oVar = oVar.f4117f;
        }
    }

    @Override // k.g
    public int w() {
        long j2 = this.c;
        if (j2 >= 4) {
            o oVar = this.b;
            int i2 = oVar.b;
            int i3 = oVar.c;
            if (i3 - i2 < 4) {
                return ((Q() & 255) << 24) | ((Q() & 255) << 16) | ((Q() & 255) << 8) | (Q() & 255);
            }
            byte[] bArr = oVar.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & 255);
            this.c = j2 - 4;
            if (i9 == i3) {
                this.b = oVar.a();
                p.a(oVar);
            } else {
                oVar.b = i9;
            }
            return i10;
        }
        StringBuilder h2 = a.h("size < 4: ");
        h2.append(this.c);
        throw new IllegalStateException(h2.toString());
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f x(int i2) {
        c0(i2);
        return this;
    }
}
