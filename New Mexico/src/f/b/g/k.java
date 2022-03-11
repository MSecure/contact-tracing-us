package f.b.g;

import f.b.g.j;
import f.b.g.w1;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class k {
    public int a;
    public int b = 100;
    public int c = Integer.MAX_VALUE;

    /* renamed from: d */
    public l f3889d;

    /* loaded from: classes.dex */
    public static final class b extends k {

        /* renamed from: e */
        public final byte[] f3890e;

        /* renamed from: f */
        public final boolean f3891f;

        /* renamed from: g */
        public int f3892g;

        /* renamed from: h */
        public int f3893h;

        /* renamed from: i */
        public int f3894i;

        /* renamed from: j */
        public int f3895j;

        /* renamed from: k */
        public int f3896k;

        /* renamed from: l */
        public int f3897l = Integer.MAX_VALUE;

        public b(byte[] bArr, int i2, int i3, boolean z, a aVar) {
            super(null);
            this.f3890e = bArr;
            this.f3892g = i3 + i2;
            this.f3894i = i2;
            this.f3895j = i2;
            this.f3891f = z;
        }

        @Override // f.b.g.k
        public int A() {
            if (e()) {
                this.f3896k = 0;
                return 0;
            }
            int H = H();
            this.f3896k = H;
            if ((H >>> 3) != 0) {
                return H;
            }
            throw d0.b();
        }

        @Override // f.b.g.k
        public int B() {
            return H();
        }

        @Override // f.b.g.k
        public long C() {
            return I();
        }

        @Override // f.b.g.k
        public boolean D(int i2) {
            int i3;
            int A;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 != 0) {
                if (i4 == 1) {
                    i3 = 8;
                } else if (i4 == 2) {
                    i3 = H();
                } else if (i4 == 3) {
                    do {
                        A = A();
                        if (A == 0) {
                            break;
                        }
                    } while (D(A));
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                } else if (i4 == 4) {
                    return false;
                } else {
                    if (i4 == 5) {
                        L(4);
                        return true;
                    }
                    throw d0.d();
                }
                L(i3);
                return true;
            }
            if (this.f3892g - this.f3894i >= 10) {
                while (i5 < 10) {
                    byte[] bArr = this.f3890e;
                    int i6 = this.f3894i;
                    this.f3894i = i6 + 1;
                    if (bArr[i6] < 0) {
                        i5++;
                    }
                }
                throw d0.e();
            }
            while (i5 < 10) {
                if (E() < 0) {
                    i5++;
                }
            }
            throw d0.e();
            return true;
        }

        public byte E() {
            int i2 = this.f3894i;
            if (i2 != this.f3892g) {
                byte[] bArr = this.f3890e;
                this.f3894i = i2 + 1;
                return bArr[i2];
            }
            throw d0.h();
        }

        public int F() {
            int i2 = this.f3894i;
            if (this.f3892g - i2 >= 4) {
                byte[] bArr = this.f3890e;
                this.f3894i = i2 + 4;
                return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
            }
            throw d0.h();
        }

        public long G() {
            int i2 = this.f3894i;
            if (this.f3892g - i2 >= 8) {
                byte[] bArr = this.f3890e;
                this.f3894i = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw d0.h();
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public int H() {
            int i2;
            int i3 = this.f3894i;
            int i4 = this.f3892g;
            if (i4 != i3) {
                byte[] bArr = this.f3890e;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.f3894i = i5;
                    return b;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b ^ (bArr[i5] << 7);
                    if (i7 < 0) {
                        i2 = i7 ^ -128;
                    } else {
                        i6++;
                        int i8 = i7 ^ (bArr[i6] << 14);
                        if (i8 >= 0) {
                            i2 = i8 ^ 16256;
                        } else {
                            i6++;
                            int i9 = i8 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                i2 = i9 ^ -2080896;
                            } else {
                                i6++;
                                byte b2 = bArr[i6];
                                i2 = (i9 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i6++;
                                    if (bArr[i6] < 0) {
                                        i6++;
                                        if (bArr[i6] < 0) {
                                            i6++;
                                            if (bArr[i6] < 0) {
                                                i6++;
                                                if (bArr[i6] < 0) {
                                                    i6++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.f3894i = i6;
                    return i2;
                }
            }
            return (int) J();
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public long I() {
            long j2;
            long j3;
            long j4;
            int i2;
            int i3 = this.f3894i;
            int i4 = this.f3892g;
            if (i4 != i3) {
                byte[] bArr = this.f3890e;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.f3894i = i5;
                    return (long) b;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b ^ (bArr[i5] << 7);
                    if (i7 < 0) {
                        i2 = i7 ^ -128;
                    } else {
                        int i8 = i6 + 1;
                        int i9 = i7 ^ (bArr[i6] << 14);
                        if (i9 >= 0) {
                            j2 = (long) (i9 ^ 16256);
                            i6 = i8;
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ -2080896;
                            } else {
                                long j5 = (long) i10;
                                i6++;
                                long j6 = j5 ^ (((long) bArr[i6]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    i6++;
                                    long j7 = j6 ^ (((long) bArr[i6]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i6++;
                                        j6 = j7 ^ (((long) bArr[i6]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i6++;
                                            j7 = j6 ^ (((long) bArr[i6]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                int i11 = i6 + 1;
                                                long j8 = (j7 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                                i6 = j8 < 0 ? i11 + 1 : i11;
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                }
                                j2 = j6 ^ j4;
                            }
                        }
                        this.f3894i = i6;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.f3894i = i6;
                    return j2;
                }
            }
            return J();
        }

        public long J() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte E = E();
                j2 |= ((long) (E & Byte.MAX_VALUE)) << i2;
                if ((E & 128) == 0) {
                    return j2;
                }
            }
            throw d0.e();
        }

        public final void K() {
            int i2 = this.f3892g + this.f3893h;
            this.f3892g = i2;
            int i3 = i2 - this.f3895j;
            int i4 = this.f3897l;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.f3893h = i5;
                this.f3892g = i2 - i5;
                return;
            }
            this.f3893h = 0;
        }

        public void L(int i2) {
            if (i2 >= 0) {
                int i3 = this.f3892g;
                int i4 = this.f3894i;
                if (i2 <= i3 - i4) {
                    this.f3894i = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw d0.f();
            }
            throw d0.h();
        }

        @Override // f.b.g.k
        public void a(int i2) {
            if (this.f3896k != i2) {
                throw d0.a();
            }
        }

        @Override // f.b.g.k
        public int d() {
            return this.f3894i - this.f3895j;
        }

        @Override // f.b.g.k
        public boolean e() {
            return this.f3894i == this.f3892g;
        }

        @Override // f.b.g.k
        public void i(int i2) {
            this.f3897l = i2;
            K();
        }

        @Override // f.b.g.k
        public int j(int i2) {
            if (i2 >= 0) {
                int d2 = d() + i2;
                int i3 = this.f3897l;
                if (d2 <= i3) {
                    this.f3897l = d2;
                    K();
                    return i3;
                }
                throw d0.h();
            }
            throw d0.f();
        }

        @Override // f.b.g.k
        public boolean k() {
            return I() != 0;
        }

        @Override // f.b.g.k
        public j l() {
            byte[] bArr;
            int H = H();
            if (H > 0) {
                int i2 = this.f3892g;
                int i3 = this.f3894i;
                if (H <= i2 - i3) {
                    boolean z = this.f3891f;
                    j m = j.m(this.f3890e, i3, H);
                    this.f3894i += H;
                    return m;
                }
            }
            if (H == 0) {
                return j.c;
            }
            if (H > 0) {
                int i4 = this.f3892g;
                int i5 = this.f3894i;
                if (H <= i4 - i5) {
                    int i6 = H + i5;
                    this.f3894i = i6;
                    bArr = Arrays.copyOfRange(this.f3890e, i5, i6);
                    j jVar = j.c;
                    return new j.h(bArr);
                }
            }
            if (H > 0) {
                throw d0.h();
            } else if (H == 0) {
                bArr = c0.b;
                j jVar2 = j.c;
                return new j.h(bArr);
            } else {
                throw d0.f();
            }
        }

        @Override // f.b.g.k
        public double m() {
            return Double.longBitsToDouble(G());
        }

        @Override // f.b.g.k
        public int n() {
            return H();
        }

        @Override // f.b.g.k
        public int o() {
            return F();
        }

        @Override // f.b.g.k
        public long p() {
            return G();
        }

        @Override // f.b.g.k
        public float q() {
            return Float.intBitsToFloat(F());
        }

        @Override // f.b.g.k
        public int r() {
            return H();
        }

        @Override // f.b.g.k
        public long s() {
            return I();
        }

        @Override // f.b.g.k
        public int u() {
            return F();
        }

        @Override // f.b.g.k
        public long v() {
            return G();
        }

        @Override // f.b.g.k
        public int w() {
            return k.b(H());
        }

        @Override // f.b.g.k
        public long x() {
            return k.c(I());
        }

        @Override // f.b.g.k
        public String y() {
            int H = H();
            if (H > 0 && H <= this.f3892g - this.f3894i) {
                String str = new String(this.f3890e, this.f3894i, H, c0.a);
                this.f3894i += H;
                return str;
            } else if (H == 0) {
                return "";
            } else {
                if (H < 0) {
                    throw d0.f();
                }
                throw d0.h();
            }
        }

        @Override // f.b.g.k
        public String z() {
            int H = H();
            if (H > 0) {
                int i2 = this.f3892g;
                int i3 = this.f3894i;
                if (H <= i2 - i3) {
                    String b = w1.b(this.f3890e, i3, H);
                    this.f3894i += H;
                    return b;
                }
            }
            if (H == 0) {
                return "";
            }
            if (H <= 0) {
                throw d0.f();
            }
            throw d0.h();
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends k {

        /* renamed from: e */
        public final InputStream f3898e;

        /* renamed from: f */
        public final byte[] f3899f;

        /* renamed from: h */
        public int f3901h;

        /* renamed from: j */
        public int f3903j;

        /* renamed from: l */
        public int f3905l = Integer.MAX_VALUE;

        /* renamed from: g */
        public int f3900g = 0;

        /* renamed from: i */
        public int f3902i = 0;

        /* renamed from: k */
        public int f3904k = 0;

        public c(InputStream inputStream, int i2, a aVar) {
            super(null);
            Charset charset = c0.a;
            this.f3898e = inputStream;
            this.f3899f = new byte[i2];
        }

        @Override // f.b.g.k
        public int A() {
            if (e()) {
                this.f3903j = 0;
                return 0;
            }
            int K = K();
            this.f3903j = K;
            if ((K >>> 3) != 0) {
                return K;
            }
            throw d0.b();
        }

        @Override // f.b.g.k
        public int B() {
            return K();
        }

        @Override // f.b.g.k
        public long C() {
            return L();
        }

        @Override // f.b.g.k
        public boolean D(int i2) {
            int i3;
            int A;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 != 0) {
                if (i4 == 1) {
                    i3 = 8;
                } else if (i4 == 2) {
                    i3 = K();
                } else if (i4 == 3) {
                    do {
                        A = A();
                        if (A == 0) {
                            break;
                        }
                    } while (D(A));
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                } else if (i4 == 4) {
                    return false;
                } else {
                    if (i4 == 5) {
                        P(4);
                        return true;
                    }
                    throw d0.d();
                }
                P(i3);
                return true;
            }
            if (this.f3900g - this.f3902i >= 10) {
                while (i5 < 10) {
                    byte[] bArr = this.f3899f;
                    int i6 = this.f3902i;
                    this.f3902i = i6 + 1;
                    if (bArr[i6] < 0) {
                        i5++;
                    }
                }
                throw d0.e();
            }
            while (i5 < 10) {
                if (E() < 0) {
                    i5++;
                }
            }
            throw d0.e();
            return true;
        }

        public byte E() {
            if (this.f3902i == this.f3900g) {
                O(1);
            }
            byte[] bArr = this.f3899f;
            int i2 = this.f3902i;
            this.f3902i = i2 + 1;
            return bArr[i2];
        }

        public final byte[] F(int i2, boolean z) {
            byte[] G = G(i2);
            if (G != null) {
                return z ? (byte[]) G.clone() : G;
            }
            int i3 = this.f3902i;
            int i4 = this.f3900g;
            int i5 = i4 - i3;
            this.f3904k += i4;
            this.f3902i = 0;
            this.f3900g = 0;
            List<byte[]> H = H(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f3899f, i3, bArr, 0, i5);
            Iterator it = ((ArrayList) H).iterator();
            while (it.hasNext()) {
                byte[] bArr2 = (byte[]) it.next();
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return bArr;
        }

        public final byte[] G(int i2) {
            if (i2 == 0) {
                return c0.b;
            }
            if (i2 >= 0) {
                int i3 = this.f3904k;
                int i4 = this.f3902i;
                int i5 = i3 + i4 + i2;
                if (i5 - this.c <= 0) {
                    int i6 = this.f3905l;
                    if (i5 <= i6) {
                        int i7 = this.f3900g - i4;
                        int i8 = i2 - i7;
                        if (i8 >= 4096 && i8 > this.f3898e.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.f3899f, this.f3902i, bArr, 0, i7);
                        this.f3904k += this.f3900g;
                        this.f3902i = 0;
                        this.f3900g = 0;
                        while (i7 < i2) {
                            int read = this.f3898e.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.f3904k += read;
                                i7 += read;
                            } else {
                                throw d0.h();
                            }
                        }
                        return bArr;
                    }
                    P((i6 - i3) - i4);
                    throw d0.h();
                }
                throw new d0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw d0.f();
        }

        public final List<byte[]> H(int i2) {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int min = Math.min(i2, 4096);
                byte[] bArr = new byte[min];
                int i3 = 0;
                while (i3 < min) {
                    int read = this.f3898e.read(bArr, i3, min - i3);
                    if (read != -1) {
                        this.f3904k += read;
                        i3 += read;
                    } else {
                        throw d0.h();
                    }
                }
                i2 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int I() {
            int i2 = this.f3902i;
            if (this.f3900g - i2 < 4) {
                O(4);
                i2 = this.f3902i;
            }
            byte[] bArr = this.f3899f;
            this.f3902i = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public long J() {
            int i2 = this.f3902i;
            if (this.f3900g - i2 < 8) {
                O(8);
                i2 = this.f3902i;
            }
            byte[] bArr = this.f3899f;
            this.f3902i = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public int K() {
            int i2;
            int i3 = this.f3902i;
            int i4 = this.f3900g;
            if (i4 != i3) {
                byte[] bArr = this.f3899f;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.f3902i = i5;
                    return b;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b ^ (bArr[i5] << 7);
                    if (i7 < 0) {
                        i2 = i7 ^ -128;
                    } else {
                        i6++;
                        int i8 = i7 ^ (bArr[i6] << 14);
                        if (i8 >= 0) {
                            i2 = i8 ^ 16256;
                        } else {
                            i6++;
                            int i9 = i8 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                i2 = i9 ^ -2080896;
                            } else {
                                i6++;
                                byte b2 = bArr[i6];
                                i2 = (i9 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i6++;
                                    if (bArr[i6] < 0) {
                                        i6++;
                                        if (bArr[i6] < 0) {
                                            i6++;
                                            if (bArr[i6] < 0) {
                                                i6++;
                                                if (bArr[i6] < 0) {
                                                    i6++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.f3902i = i6;
                    return i2;
                }
            }
            return (int) M();
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public long L() {
            long j2;
            long j3;
            long j4;
            int i2;
            int i3 = this.f3902i;
            int i4 = this.f3900g;
            if (i4 != i3) {
                byte[] bArr = this.f3899f;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.f3902i = i5;
                    return (long) b;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b ^ (bArr[i5] << 7);
                    if (i7 < 0) {
                        i2 = i7 ^ -128;
                    } else {
                        int i8 = i6 + 1;
                        int i9 = i7 ^ (bArr[i6] << 14);
                        if (i9 >= 0) {
                            j2 = (long) (i9 ^ 16256);
                            i6 = i8;
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ -2080896;
                            } else {
                                long j5 = (long) i10;
                                i6++;
                                long j6 = j5 ^ (((long) bArr[i6]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    i6++;
                                    long j7 = j6 ^ (((long) bArr[i6]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i6++;
                                        j6 = j7 ^ (((long) bArr[i6]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i6++;
                                            j7 = j6 ^ (((long) bArr[i6]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                int i11 = i6 + 1;
                                                long j8 = (j7 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                                i6 = j8 < 0 ? i11 + 1 : i11;
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                }
                                j2 = j6 ^ j4;
                            }
                        }
                        this.f3902i = i6;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.f3902i = i6;
                    return j2;
                }
            }
            return M();
        }

        public long M() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte E = E();
                j2 |= ((long) (E & Byte.MAX_VALUE)) << i2;
                if ((E & 128) == 0) {
                    return j2;
                }
            }
            throw d0.e();
        }

        public final void N() {
            int i2 = this.f3900g + this.f3901h;
            this.f3900g = i2;
            int i3 = this.f3904k + i2;
            int i4 = this.f3905l;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.f3901h = i5;
                this.f3900g = i2 - i5;
                return;
            }
            this.f3901h = 0;
        }

        public final void O(int i2) {
            if (Q(i2)) {
                return;
            }
            if (i2 > (this.c - this.f3904k) - this.f3902i) {
                throw new d0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw d0.h();
        }

        public void P(int i2) {
            int i3 = this.f3900g;
            int i4 = this.f3902i;
            if (i2 <= i3 - i4 && i2 >= 0) {
                this.f3902i = i4 + i2;
            } else if (i2 >= 0) {
                int i5 = this.f3904k;
                int i6 = i5 + i4;
                int i7 = i6 + i2;
                int i8 = this.f3905l;
                if (i7 <= i8) {
                    this.f3904k = i6;
                    int i9 = i3 - i4;
                    this.f3900g = 0;
                    this.f3902i = 0;
                    while (i9 < i2) {
                        try {
                            long j2 = (long) (i2 - i9);
                            long skip = this.f3898e.skip(j2);
                            int i10 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                            if (i10 < 0 || skip > j2) {
                                throw new IllegalStateException(this.f3898e.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                            } else if (i10 == 0) {
                                break;
                            } else {
                                i9 += (int) skip;
                            }
                        } finally {
                            this.f3904k += i9;
                            N();
                        }
                    }
                    if (i9 < i2) {
                        int i11 = this.f3900g;
                        int i12 = i11 - this.f3902i;
                        this.f3902i = i11;
                        while (true) {
                            O(1);
                            int i13 = i2 - i12;
                            int i14 = this.f3900g;
                            if (i13 > i14) {
                                i12 += i14;
                                this.f3902i = i14;
                            } else {
                                this.f3902i = i13;
                                return;
                            }
                        }
                    }
                } else {
                    P((i8 - i5) - i4);
                    throw d0.h();
                }
            } else {
                throw d0.f();
            }
        }

        public final boolean Q(int i2) {
            int i3 = this.f3902i;
            int i4 = i3 + i2;
            int i5 = this.f3900g;
            if (i4 > i5) {
                int i6 = this.c;
                int i7 = this.f3904k;
                if (i2 > (i6 - i7) - i3 || i7 + i3 + i2 > this.f3905l) {
                    return false;
                }
                if (i3 > 0) {
                    if (i5 > i3) {
                        byte[] bArr = this.f3899f;
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.f3904k += i3;
                    this.f3900g -= i3;
                    this.f3902i = 0;
                }
                InputStream inputStream = this.f3898e;
                byte[] bArr2 = this.f3899f;
                int i8 = this.f3900g;
                int read = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.c - this.f3904k) - i8));
                if (read == 0 || read < -1 || read > this.f3899f.length) {
                    throw new IllegalStateException(this.f3898e.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.f3900g += read;
                    N();
                    if (this.f3900g >= i2) {
                        return true;
                    }
                    return Q(i2);
                }
            } else {
                throw new IllegalStateException(f.a.a.a.a.v("refillBuffer() called when ", i2, " bytes were already available in buffer"));
            }
        }

        @Override // f.b.g.k
        public void a(int i2) {
            if (this.f3903j != i2) {
                throw d0.a();
            }
        }

        @Override // f.b.g.k
        public int d() {
            return this.f3904k + this.f3902i;
        }

        @Override // f.b.g.k
        public boolean e() {
            return this.f3902i == this.f3900g && !Q(1);
        }

        @Override // f.b.g.k
        public void i(int i2) {
            this.f3905l = i2;
            N();
        }

        @Override // f.b.g.k
        public int j(int i2) {
            if (i2 >= 0) {
                int i3 = this.f3904k + this.f3902i + i2;
                int i4 = this.f3905l;
                if (i3 <= i4) {
                    this.f3905l = i3;
                    N();
                    return i4;
                }
                throw d0.h();
            }
            throw d0.f();
        }

        @Override // f.b.g.k
        public boolean k() {
            return L() != 0;
        }

        @Override // f.b.g.k
        public j l() {
            int K = K();
            int i2 = this.f3900g;
            int i3 = this.f3902i;
            if (K <= i2 - i3 && K > 0) {
                j m = j.m(this.f3899f, i3, K);
                this.f3902i += K;
                return m;
            } else if (K == 0) {
                return j.c;
            } else {
                byte[] G = G(K);
                if (G != null) {
                    j jVar = j.c;
                    return j.m(G, 0, G.length);
                }
                int i4 = this.f3902i;
                int i5 = this.f3900g;
                int i6 = i5 - i4;
                this.f3904k += i5;
                this.f3902i = 0;
                this.f3900g = 0;
                List<byte[]> H = H(K - i6);
                byte[] bArr = new byte[K];
                System.arraycopy(this.f3899f, i4, bArr, 0, i6);
                Iterator it = ((ArrayList) H).iterator();
                while (it.hasNext()) {
                    byte[] bArr2 = (byte[]) it.next();
                    System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                    i6 += bArr2.length;
                }
                j jVar2 = j.c;
                return new j.h(bArr);
            }
        }

        @Override // f.b.g.k
        public double m() {
            return Double.longBitsToDouble(J());
        }

        @Override // f.b.g.k
        public int n() {
            return K();
        }

        @Override // f.b.g.k
        public int o() {
            return I();
        }

        @Override // f.b.g.k
        public long p() {
            return J();
        }

        @Override // f.b.g.k
        public float q() {
            return Float.intBitsToFloat(I());
        }

        @Override // f.b.g.k
        public int r() {
            return K();
        }

        @Override // f.b.g.k
        public long s() {
            return L();
        }

        @Override // f.b.g.k
        public int u() {
            return I();
        }

        @Override // f.b.g.k
        public long v() {
            return J();
        }

        @Override // f.b.g.k
        public int w() {
            return k.b(K());
        }

        @Override // f.b.g.k
        public long x() {
            return k.c(L());
        }

        @Override // f.b.g.k
        public String y() {
            int K = K();
            if (K > 0 && K <= this.f3900g - this.f3902i) {
                String str = new String(this.f3899f, this.f3902i, K, c0.a);
                this.f3902i += K;
                return str;
            } else if (K == 0) {
                return "";
            } else {
                if (K > this.f3900g) {
                    return new String(F(K, false), c0.a);
                }
                O(K);
                String str2 = new String(this.f3899f, this.f3902i, K, c0.a);
                this.f3902i += K;
                return str2;
            }
        }

        @Override // f.b.g.k
        public String z() {
            byte[] bArr;
            int K = K();
            int i2 = this.f3902i;
            int i3 = this.f3900g;
            if (K <= i3 - i2 && K > 0) {
                bArr = this.f3899f;
                this.f3902i = i2 + K;
            } else if (K == 0) {
                return "";
            } else {
                if (K <= i3) {
                    O(K);
                    bArr = this.f3899f;
                    this.f3902i = K + 0;
                } else {
                    bArr = F(K, false);
                }
                i2 = 0;
            }
            return w1.b(bArr, i2, K);
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends k {

        /* renamed from: e */
        public final ByteBuffer f3906e;

        /* renamed from: f */
        public final boolean f3907f;

        /* renamed from: g */
        public final long f3908g;

        /* renamed from: h */
        public long f3909h;

        /* renamed from: i */
        public long f3910i;

        /* renamed from: j */
        public long f3911j;

        /* renamed from: k */
        public int f3912k;

        /* renamed from: l */
        public int f3913l;
        public int m = Integer.MAX_VALUE;

        public d(ByteBuffer byteBuffer, boolean z, a aVar) {
            super(null);
            this.f3906e = byteBuffer;
            long a = v1.a(byteBuffer);
            this.f3908g = a;
            this.f3909h = ((long) byteBuffer.limit()) + a;
            long position = a + ((long) byteBuffer.position());
            this.f3910i = position;
            this.f3911j = position;
            this.f3907f = z;
        }

        @Override // f.b.g.k
        public int A() {
            if (e()) {
                this.f3913l = 0;
                return 0;
            }
            int I = I();
            this.f3913l = I;
            if ((I >>> 3) != 0) {
                return I;
            }
            throw d0.b();
        }

        @Override // f.b.g.k
        public int B() {
            return I();
        }

        @Override // f.b.g.k
        public long C() {
            return J();
        }

        @Override // f.b.g.k
        public boolean D(int i2) {
            int i3;
            int A;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 != 0) {
                if (i4 == 1) {
                    i3 = 8;
                } else if (i4 == 2) {
                    i3 = I();
                } else if (i4 == 3) {
                    do {
                        A = A();
                        if (A == 0) {
                            break;
                        }
                    } while (D(A));
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                } else if (i4 == 4) {
                    return false;
                } else {
                    if (i4 == 5) {
                        N(4);
                        return true;
                    }
                    throw d0.d();
                }
                N(i3);
                return true;
            }
            if (M() >= 10) {
                while (i5 < 10) {
                    long j2 = this.f3910i;
                    this.f3910i = 1 + j2;
                    if (v1.h(j2) < 0) {
                        i5++;
                    }
                }
                throw d0.e();
            }
            while (i5 < 10) {
                if (F() < 0) {
                    i5++;
                }
            }
            throw d0.e();
            return true;
        }

        public final int E(long j2) {
            return (int) (j2 - this.f3908g);
        }

        public byte F() {
            long j2 = this.f3910i;
            if (j2 != this.f3909h) {
                this.f3910i = 1 + j2;
                return v1.h(j2);
            }
            throw d0.h();
        }

        public int G() {
            long j2 = this.f3910i;
            if (this.f3909h - j2 >= 4) {
                this.f3910i = 4 + j2;
                return ((v1.h(j2 + 3) & 255) << 24) | (v1.h(j2) & 255) | ((v1.h(1 + j2) & 255) << 8) | ((v1.h(2 + j2) & 255) << 16);
            }
            throw d0.h();
        }

        public long H() {
            long j2 = this.f3910i;
            if (this.f3909h - j2 >= 8) {
                this.f3910i = 8 + j2;
                return ((((long) v1.h(j2 + 7)) & 255) << 56) | (((long) v1.h(j2)) & 255) | ((((long) v1.h(1 + j2)) & 255) << 8) | ((((long) v1.h(2 + j2)) & 255) << 16) | ((((long) v1.h(3 + j2)) & 255) << 24) | ((((long) v1.h(4 + j2)) & 255) << 32) | ((((long) v1.h(5 + j2)) & 255) << 40) | ((((long) v1.h(6 + j2)) & 255) << 48);
            }
            throw d0.h();
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
            if (f.b.g.v1.h(r4) < 0) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public int I() {
            int i2;
            long j2 = this.f3910i;
            if (this.f3909h != j2) {
                long j3 = j2 + 1;
                byte h2 = v1.h(j2);
                if (h2 >= 0) {
                    this.f3910i = j3;
                    return h2;
                } else if (this.f3909h - j3 >= 9) {
                    long j4 = j3 + 1;
                    int h3 = h2 ^ (v1.h(j3) << 7);
                    if (h3 < 0) {
                        i2 = h3 ^ -128;
                    } else {
                        j4++;
                        int h4 = h3 ^ (v1.h(j4) << 14);
                        if (h4 >= 0) {
                            i2 = h4 ^ 16256;
                        } else {
                            j4++;
                            int h5 = h4 ^ (v1.h(j4) << 21);
                            if (h5 < 0) {
                                i2 = h5 ^ -2080896;
                            } else {
                                j4++;
                                byte h6 = v1.h(j4);
                                i2 = (h5 ^ (h6 << 28)) ^ 266354560;
                                if (h6 < 0) {
                                    j4++;
                                    if (v1.h(j4) < 0) {
                                        j4++;
                                        if (v1.h(j4) < 0) {
                                            j4++;
                                            if (v1.h(j4) < 0) {
                                                j4++;
                                                if (v1.h(j4) < 0) {
                                                    j4++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.f3910i = j4;
                    return i2;
                }
            }
            return (int) K();
        }

        public long J() {
            long j2;
            long j3;
            long j4;
            int i2;
            long j5 = this.f3910i;
            if (this.f3909h != j5) {
                long j6 = j5 + 1;
                byte h2 = v1.h(j5);
                if (h2 >= 0) {
                    this.f3910i = j6;
                    return (long) h2;
                } else if (this.f3909h - j6 >= 9) {
                    long j7 = j6 + 1;
                    int h3 = h2 ^ (v1.h(j6) << 7);
                    if (h3 < 0) {
                        i2 = h3 ^ -128;
                    } else {
                        j7++;
                        int h4 = h3 ^ (v1.h(j7) << 14);
                        if (h4 >= 0) {
                            j2 = (long) (h4 ^ 16256);
                        } else {
                            j7++;
                            int h5 = h4 ^ (v1.h(j7) << 21);
                            if (h5 < 0) {
                                i2 = h5 ^ -2080896;
                            } else {
                                j7++;
                                long h6 = ((long) h5) ^ (((long) v1.h(j7)) << 28);
                                if (h6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    j7++;
                                    long h7 = h6 ^ (((long) v1.h(j7)) << 35);
                                    if (h7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j7++;
                                        h6 = h7 ^ (((long) v1.h(j7)) << 42);
                                        if (h6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j7++;
                                            h7 = h6 ^ (((long) v1.h(j7)) << 49);
                                            if (h7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j7++;
                                                j2 = (h7 ^ (((long) v1.h(j7)) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    j7 = 1 + j7;
                                                    if (((long) v1.h(j7)) >= 0) {
                                                        this.f3910i = j7;
                                                        return j2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j2 = h7 ^ j3;
                                    this.f3910i = j7;
                                    return j2;
                                }
                                j2 = h6 ^ j4;
                            }
                        }
                        this.f3910i = j7;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.f3910i = j7;
                    return j2;
                }
            }
            return K();
        }

        public long K() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte F = F();
                j2 |= ((long) (F & Byte.MAX_VALUE)) << i2;
                if ((F & 128) == 0) {
                    return j2;
                }
            }
            throw d0.e();
        }

        public final void L() {
            long j2 = this.f3909h + ((long) this.f3912k);
            this.f3909h = j2;
            int i2 = (int) (j2 - this.f3911j);
            int i3 = this.m;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.f3912k = i4;
                this.f3909h = j2 - ((long) i4);
                return;
            }
            this.f3912k = 0;
        }

        public final int M() {
            return (int) (this.f3909h - this.f3910i);
        }

        public void N(int i2) {
            if (i2 >= 0 && i2 <= M()) {
                this.f3910i += (long) i2;
            } else if (i2 < 0) {
                throw d0.f();
            } else {
                throw d0.h();
            }
        }

        @Override // f.b.g.k
        public void a(int i2) {
            if (this.f3913l != i2) {
                throw d0.a();
            }
        }

        @Override // f.b.g.k
        public int d() {
            return (int) (this.f3910i - this.f3911j);
        }

        @Override // f.b.g.k
        public boolean e() {
            return this.f3910i == this.f3909h;
        }

        @Override // f.b.g.k
        public void i(int i2) {
            this.m = i2;
            L();
        }

        @Override // f.b.g.k
        public int j(int i2) {
            if (i2 >= 0) {
                int d2 = d() + i2;
                int i3 = this.m;
                if (d2 <= i3) {
                    this.m = d2;
                    L();
                    return i3;
                }
                throw d0.h();
            }
            throw d0.f();
        }

        @Override // f.b.g.k
        public boolean k() {
            return J() != 0;
        }

        @Override // f.b.g.k
        public j l() {
            int I = I();
            if (I > 0 && I <= M()) {
                byte[] bArr = new byte[I];
                long j2 = (long) I;
                v1.f3953f.c(this.f3910i, bArr, 0, j2);
                this.f3910i += j2;
                j jVar = j.c;
                return new j.h(bArr);
            } else if (I == 0) {
                return j.c;
            } else {
                if (I < 0) {
                    throw d0.f();
                }
                throw d0.h();
            }
        }

        @Override // f.b.g.k
        public double m() {
            return Double.longBitsToDouble(H());
        }

        @Override // f.b.g.k
        public int n() {
            return I();
        }

        @Override // f.b.g.k
        public int o() {
            return G();
        }

        @Override // f.b.g.k
        public long p() {
            return H();
        }

        @Override // f.b.g.k
        public float q() {
            return Float.intBitsToFloat(G());
        }

        @Override // f.b.g.k
        public int r() {
            return I();
        }

        @Override // f.b.g.k
        public long s() {
            return J();
        }

        @Override // f.b.g.k
        public int u() {
            return G();
        }

        @Override // f.b.g.k
        public long v() {
            return H();
        }

        @Override // f.b.g.k
        public int w() {
            return k.b(I());
        }

        @Override // f.b.g.k
        public long x() {
            return k.c(J());
        }

        @Override // f.b.g.k
        public String y() {
            int I = I();
            if (I > 0 && I <= M()) {
                byte[] bArr = new byte[I];
                long j2 = (long) I;
                v1.f3953f.c(this.f3910i, bArr, 0, j2);
                String str = new String(bArr, c0.a);
                this.f3910i += j2;
                return str;
            } else if (I == 0) {
                return "";
            } else {
                if (I < 0) {
                    throw d0.f();
                }
                throw d0.h();
            }
        }

        @Override // f.b.g.k
        public String z() {
            int I = I();
            if (I > 0 && I <= M()) {
                int E = E(this.f3910i);
                ByteBuffer byteBuffer = this.f3906e;
                w1.a aVar = w1.a;
                Objects.requireNonNull(aVar);
                String a = byteBuffer.hasArray() ? aVar.a(byteBuffer.array(), byteBuffer.arrayOffset() + E, I) : byteBuffer.isDirect() ? aVar.c(byteBuffer, E, I) : aVar.b(byteBuffer, E, I);
                this.f3910i += (long) I;
                return a;
            } else if (I == 0) {
                return "";
            } else {
                if (I <= 0) {
                    throw d0.f();
                }
                throw d0.h();
            }
        }
    }

    public k(a aVar) {
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static k f(InputStream inputStream) {
        if (inputStream != null) {
            return new c(inputStream, 4096, null);
        }
        byte[] bArr = c0.b;
        return h(bArr, 0, bArr.length, false);
    }

    public static k g(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return h(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), z);
        } else if (byteBuffer.isDirect() && v1.f3954g) {
            return new d(byteBuffer, z, null);
        } else {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.duplicate().get(bArr);
            return h(bArr, 0, remaining, true);
        }
    }

    public static k h(byte[] bArr, int i2, int i3, boolean z) {
        b bVar = new b(bArr, i2, i3, z, null);
        try {
            bVar.j(i3);
            return bVar;
        } catch (d0 e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int t(int i2, InputStream inputStream) {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = i2 & 127;
        int i4 = 7;
        while (i4 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i3 |= (read & 127) << i4;
                if ((read & 128) == 0) {
                    return i3;
                }
                i4 += 7;
            } else {
                throw d0.h();
            }
        }
        while (i4 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw d0.h();
            } else if ((read2 & 128) == 0) {
                return i3;
            } else {
                i4 += 7;
            }
        }
        throw d0.e();
    }

    public abstract int A();

    public abstract int B();

    public abstract long C();

    public abstract boolean D(int i2);

    public abstract void a(int i2);

    public abstract int d();

    public abstract boolean e();

    public abstract void i(int i2);

    public abstract int j(int i2);

    public abstract boolean k();

    public abstract j l();

    public abstract double m();

    public abstract int n();

    public abstract int o();

    public abstract long p();

    public abstract float q();

    public abstract int r();

    public abstract long s();

    public abstract int u();

    public abstract long v();

    public abstract int w();

    public abstract long x();

    public abstract String y();

    public abstract String z();
}
