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

public abstract class k {
    public int a;
    public int b = 100;
    public int c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public l f3634d;

    public static final class b extends k {

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f3635e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f3636f;

        /* renamed from: g  reason: collision with root package name */
        public int f3637g;

        /* renamed from: h  reason: collision with root package name */
        public int f3638h;

        /* renamed from: i  reason: collision with root package name */
        public int f3639i;

        /* renamed from: j  reason: collision with root package name */
        public int f3640j;

        /* renamed from: k  reason: collision with root package name */
        public int f3641k;

        /* renamed from: l  reason: collision with root package name */
        public int f3642l = Integer.MAX_VALUE;

        public b(byte[] bArr, int i2, int i3, boolean z, a aVar) {
            super(null);
            this.f3635e = bArr;
            this.f3637g = i3 + i2;
            this.f3639i = i2;
            this.f3640j = i2;
            this.f3636f = z;
        }

        @Override // f.b.g.k
        public int A() {
            if (e()) {
                this.f3641k = 0;
                return 0;
            }
            int H = H();
            this.f3641k = H;
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
            if (this.f3637g - this.f3639i >= 10) {
                while (i5 < 10) {
                    byte[] bArr = this.f3635e;
                    int i6 = this.f3639i;
                    this.f3639i = i6 + 1;
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
            int i2 = this.f3639i;
            if (i2 != this.f3637g) {
                byte[] bArr = this.f3635e;
                this.f3639i = i2 + 1;
                return bArr[i2];
            }
            throw d0.h();
        }

        public int F() {
            int i2 = this.f3639i;
            if (this.f3637g - i2 >= 4) {
                byte[] bArr = this.f3635e;
                this.f3639i = i2 + 4;
                return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
            }
            throw d0.h();
        }

        public long G() {
            int i2 = this.f3639i;
            if (this.f3637g - i2 >= 8) {
                byte[] bArr = this.f3635e;
                this.f3639i = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw d0.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        public int H() {
            int i2;
            int i3 = this.f3639i;
            int i4 = this.f3637g;
            if (i4 != i3) {
                byte[] bArr = this.f3635e;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.f3639i = i5;
                    return b;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b ^ (bArr[i5] << 7);
                    if (i7 < 0) {
                        i2 = i7 ^ -128;
                    } else {
                        int i8 = i6 + 1;
                        int i9 = i7 ^ (bArr[i6] << 14);
                        if (i9 >= 0) {
                            i2 = i9 ^ 16256;
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ -2080896;
                            } else {
                                i8 = i6 + 1;
                                byte b2 = bArr[i6];
                                i2 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i6 = i8 + 1;
                                    if (bArr[i8] < 0) {
                                        i8 = i6 + 1;
                                        if (bArr[i6] < 0) {
                                            i6 = i8 + 1;
                                            if (bArr[i8] < 0) {
                                                i8 = i6 + 1;
                                                if (bArr[i6] < 0) {
                                                    i6 = i8 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i6 = i8;
                    }
                    this.f3639i = i6;
                    return i2;
                }
            }
            return (int) J();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        public long I() {
            long j2;
            long j3;
            long j4;
            int i2;
            int i3 = this.f3639i;
            int i4 = this.f3637g;
            if (i4 != i3) {
                byte[] bArr = this.f3635e;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.f3639i = i5;
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
                            i6 = i8;
                            j2 = (long) (i9 ^ 16256);
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ -2080896;
                            } else {
                                long j5 = (long) i10;
                                int i11 = i6 + 1;
                                long j6 = j5 ^ (((long) bArr[i6]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    i6 = i11 + 1;
                                    long j7 = j6 ^ (((long) bArr[i11]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i11 = i6 + 1;
                                        j6 = j7 ^ (((long) bArr[i6]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i6 = i11 + 1;
                                            j7 = j6 ^ (((long) bArr[i11]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                int i12 = i6 + 1;
                                                long j8 = (j7 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                                i6 = j8 < 0 ? i12 + 1 : i12;
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                }
                                j2 = j6 ^ j4;
                                i6 = i11;
                            }
                        }
                        this.f3639i = i6;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.f3639i = i6;
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
            int i2 = this.f3637g + this.f3638h;
            this.f3637g = i2;
            int i3 = i2 - this.f3640j;
            int i4 = this.f3642l;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.f3638h = i5;
                this.f3637g = i2 - i5;
                return;
            }
            this.f3638h = 0;
        }

        public void L(int i2) {
            if (i2 >= 0) {
                int i3 = this.f3637g;
                int i4 = this.f3639i;
                if (i2 <= i3 - i4) {
                    this.f3639i = i4 + i2;
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
            if (this.f3641k != i2) {
                throw d0.a();
            }
        }

        @Override // f.b.g.k
        public int d() {
            return this.f3639i - this.f3640j;
        }

        @Override // f.b.g.k
        public boolean e() {
            return this.f3639i == this.f3637g;
        }

        @Override // f.b.g.k
        public void i(int i2) {
            this.f3642l = i2;
            K();
        }

        @Override // f.b.g.k
        public int j(int i2) {
            if (i2 >= 0) {
                int d2 = d() + i2;
                int i3 = this.f3642l;
                if (d2 <= i3) {
                    this.f3642l = d2;
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
                int i2 = this.f3637g;
                int i3 = this.f3639i;
                if (H <= i2 - i3) {
                    boolean z = this.f3636f;
                    j m = j.m(this.f3635e, i3, H);
                    this.f3639i += H;
                    return m;
                }
            }
            if (H == 0) {
                return j.c;
            }
            if (H > 0) {
                int i4 = this.f3637g;
                int i5 = this.f3639i;
                if (H <= i4 - i5) {
                    int i6 = H + i5;
                    this.f3639i = i6;
                    bArr = Arrays.copyOfRange(this.f3635e, i5, i6);
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
            if (H > 0 && H <= this.f3637g - this.f3639i) {
                String str = new String(this.f3635e, this.f3639i, H, c0.a);
                this.f3639i += H;
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
                int i2 = this.f3637g;
                int i3 = this.f3639i;
                if (H <= i2 - i3) {
                    String b = w1.b(this.f3635e, i3, H);
                    this.f3639i += H;
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

    public static final class c extends k {

        /* renamed from: e  reason: collision with root package name */
        public final InputStream f3643e;

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f3644f;

        /* renamed from: g  reason: collision with root package name */
        public int f3645g;

        /* renamed from: h  reason: collision with root package name */
        public int f3646h;

        /* renamed from: i  reason: collision with root package name */
        public int f3647i;

        /* renamed from: j  reason: collision with root package name */
        public int f3648j;

        /* renamed from: k  reason: collision with root package name */
        public int f3649k;

        /* renamed from: l  reason: collision with root package name */
        public int f3650l = Integer.MAX_VALUE;

        public c(InputStream inputStream, int i2, a aVar) {
            super(null);
            Charset charset = c0.a;
            this.f3643e = inputStream;
            this.f3644f = new byte[i2];
            this.f3645g = 0;
            this.f3647i = 0;
            this.f3649k = 0;
        }

        @Override // f.b.g.k
        public int A() {
            if (e()) {
                this.f3648j = 0;
                return 0;
            }
            int K = K();
            this.f3648j = K;
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
            if (this.f3645g - this.f3647i >= 10) {
                while (i5 < 10) {
                    byte[] bArr = this.f3644f;
                    int i6 = this.f3647i;
                    this.f3647i = i6 + 1;
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
            if (this.f3647i == this.f3645g) {
                O(1);
            }
            byte[] bArr = this.f3644f;
            int i2 = this.f3647i;
            this.f3647i = i2 + 1;
            return bArr[i2];
        }

        public final byte[] F(int i2, boolean z) {
            byte[] G = G(i2);
            if (G != null) {
                return z ? (byte[]) G.clone() : G;
            }
            int i3 = this.f3647i;
            int i4 = this.f3645g;
            int i5 = i4 - i3;
            this.f3649k += i4;
            this.f3647i = 0;
            this.f3645g = 0;
            List<byte[]> H = H(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f3644f, i3, bArr, 0, i5);
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
                int i3 = this.f3649k;
                int i4 = this.f3647i;
                int i5 = i3 + i4 + i2;
                if (i5 - this.c <= 0) {
                    int i6 = this.f3650l;
                    if (i5 <= i6) {
                        int i7 = this.f3645g - i4;
                        int i8 = i2 - i7;
                        if (i8 >= 4096 && i8 > this.f3643e.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.f3644f, this.f3647i, bArr, 0, i7);
                        this.f3649k += this.f3645g;
                        this.f3647i = 0;
                        this.f3645g = 0;
                        while (i7 < i2) {
                            int read = this.f3643e.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.f3649k += read;
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
                    int read = this.f3643e.read(bArr, i3, min - i3);
                    if (read != -1) {
                        this.f3649k += read;
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
            int i2 = this.f3647i;
            if (this.f3645g - i2 < 4) {
                O(4);
                i2 = this.f3647i;
            }
            byte[] bArr = this.f3644f;
            this.f3647i = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public long J() {
            int i2 = this.f3647i;
            if (this.f3645g - i2 < 8) {
                O(8);
                i2 = this.f3647i;
            }
            byte[] bArr = this.f3644f;
            this.f3647i = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        public int K() {
            int i2;
            int i3 = this.f3647i;
            int i4 = this.f3645g;
            if (i4 != i3) {
                byte[] bArr = this.f3644f;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.f3647i = i5;
                    return b;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b ^ (bArr[i5] << 7);
                    if (i7 < 0) {
                        i2 = i7 ^ -128;
                    } else {
                        int i8 = i6 + 1;
                        int i9 = i7 ^ (bArr[i6] << 14);
                        if (i9 >= 0) {
                            i2 = i9 ^ 16256;
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ -2080896;
                            } else {
                                i8 = i6 + 1;
                                byte b2 = bArr[i6];
                                i2 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i6 = i8 + 1;
                                    if (bArr[i8] < 0) {
                                        i8 = i6 + 1;
                                        if (bArr[i6] < 0) {
                                            i6 = i8 + 1;
                                            if (bArr[i8] < 0) {
                                                i8 = i6 + 1;
                                                if (bArr[i6] < 0) {
                                                    i6 = i8 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i6 = i8;
                    }
                    this.f3647i = i6;
                    return i2;
                }
            }
            return (int) M();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        public long L() {
            long j2;
            long j3;
            long j4;
            int i2;
            int i3 = this.f3647i;
            int i4 = this.f3645g;
            if (i4 != i3) {
                byte[] bArr = this.f3644f;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.f3647i = i5;
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
                            i6 = i8;
                            j2 = (long) (i9 ^ 16256);
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ -2080896;
                            } else {
                                long j5 = (long) i10;
                                int i11 = i6 + 1;
                                long j6 = j5 ^ (((long) bArr[i6]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    i6 = i11 + 1;
                                    long j7 = j6 ^ (((long) bArr[i11]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i11 = i6 + 1;
                                        j6 = j7 ^ (((long) bArr[i6]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i6 = i11 + 1;
                                            j7 = j6 ^ (((long) bArr[i11]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                int i12 = i6 + 1;
                                                long j8 = (j7 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                                i6 = j8 < 0 ? i12 + 1 : i12;
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                }
                                j2 = j6 ^ j4;
                                i6 = i11;
                            }
                        }
                        this.f3647i = i6;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.f3647i = i6;
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
            int i2 = this.f3645g + this.f3646h;
            this.f3645g = i2;
            int i3 = this.f3649k + i2;
            int i4 = this.f3650l;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.f3646h = i5;
                this.f3645g = i2 - i5;
                return;
            }
            this.f3646h = 0;
        }

        public final void O(int i2) {
            if (Q(i2)) {
                return;
            }
            if (i2 > (this.c - this.f3649k) - this.f3647i) {
                throw new d0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw d0.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
            throw new java.lang.IllegalStateException(r8.f3643e.getClass() + "#skip returned invalid result: " + r1 + "\nThe InputStream implementation is buggy.");
         */
        public void P(int i2) {
            int i3 = this.f3645g;
            int i4 = this.f3647i;
            if (i2 <= i3 - i4 && i2 >= 0) {
                this.f3647i = i4 + i2;
            } else if (i2 >= 0) {
                int i5 = this.f3649k;
                int i6 = i5 + i4;
                int i7 = i6 + i2;
                int i8 = this.f3650l;
                if (i7 <= i8) {
                    this.f3649k = i6;
                    int i9 = i3 - i4;
                    this.f3645g = 0;
                    this.f3647i = 0;
                    while (true) {
                        if (i9 >= i2) {
                            break;
                        }
                        try {
                            long j2 = (long) (i2 - i9);
                            long skip = this.f3643e.skip(j2);
                            int i10 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                            if (i10 < 0 || skip > j2) {
                            } else if (i10 == 0) {
                                break;
                            } else {
                                i9 += (int) skip;
                            }
                        } catch (Throwable th) {
                            this.f3649k += i9;
                            N();
                            throw th;
                        }
                    }
                    this.f3649k += i9;
                    N();
                    if (i9 < i2) {
                        int i11 = this.f3645g;
                        int i12 = i11 - this.f3647i;
                        this.f3647i = i11;
                        while (true) {
                            O(1);
                            int i13 = i2 - i12;
                            int i14 = this.f3645g;
                            if (i13 > i14) {
                                i12 += i14;
                                this.f3647i = i14;
                            } else {
                                this.f3647i = i13;
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
            int i3 = this.f3647i;
            int i4 = i3 + i2;
            int i5 = this.f3645g;
            if (i4 > i5) {
                int i6 = this.c;
                int i7 = this.f3649k;
                if (i2 > (i6 - i7) - i3 || i7 + i3 + i2 > this.f3650l) {
                    return false;
                }
                if (i3 > 0) {
                    if (i5 > i3) {
                        byte[] bArr = this.f3644f;
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.f3649k += i3;
                    this.f3645g -= i3;
                    this.f3647i = 0;
                }
                InputStream inputStream = this.f3643e;
                byte[] bArr2 = this.f3644f;
                int i8 = this.f3645g;
                int read = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.c - this.f3649k) - i8));
                if (read == 0 || read < -1 || read > this.f3644f.length) {
                    throw new IllegalStateException(this.f3643e.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.f3645g += read;
                    N();
                    if (this.f3645g >= i2) {
                        return true;
                    }
                    return Q(i2);
                }
            } else {
                throw new IllegalStateException(f.a.a.a.a.u("refillBuffer() called when ", i2, " bytes were already available in buffer"));
            }
        }

        @Override // f.b.g.k
        public void a(int i2) {
            if (this.f3648j != i2) {
                throw d0.a();
            }
        }

        @Override // f.b.g.k
        public int d() {
            return this.f3649k + this.f3647i;
        }

        @Override // f.b.g.k
        public boolean e() {
            return this.f3647i == this.f3645g && !Q(1);
        }

        @Override // f.b.g.k
        public void i(int i2) {
            this.f3650l = i2;
            N();
        }

        @Override // f.b.g.k
        public int j(int i2) {
            if (i2 >= 0) {
                int i3 = this.f3649k + this.f3647i + i2;
                int i4 = this.f3650l;
                if (i3 <= i4) {
                    this.f3650l = i3;
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
            int i2 = this.f3645g;
            int i3 = this.f3647i;
            if (K <= i2 - i3 && K > 0) {
                j m = j.m(this.f3644f, i3, K);
                this.f3647i += K;
                return m;
            } else if (K == 0) {
                return j.c;
            } else {
                byte[] G = G(K);
                if (G != null) {
                    j jVar = j.c;
                    return j.m(G, 0, G.length);
                }
                int i4 = this.f3647i;
                int i5 = this.f3645g;
                int i6 = i5 - i4;
                this.f3649k += i5;
                this.f3647i = 0;
                this.f3645g = 0;
                List<byte[]> H = H(K - i6);
                byte[] bArr = new byte[K];
                System.arraycopy(this.f3644f, i4, bArr, 0, i6);
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
            if (K > 0 && K <= this.f3645g - this.f3647i) {
                String str = new String(this.f3644f, this.f3647i, K, c0.a);
                this.f3647i += K;
                return str;
            } else if (K == 0) {
                return "";
            } else {
                if (K > this.f3645g) {
                    return new String(F(K, false), c0.a);
                }
                O(K);
                String str2 = new String(this.f3644f, this.f3647i, K, c0.a);
                this.f3647i += K;
                return str2;
            }
        }

        @Override // f.b.g.k
        public String z() {
            byte[] bArr;
            int K = K();
            int i2 = this.f3647i;
            int i3 = this.f3645g;
            if (K <= i3 - i2 && K > 0) {
                bArr = this.f3644f;
                this.f3647i = i2 + K;
            } else if (K == 0) {
                return "";
            } else {
                if (K <= i3) {
                    O(K);
                    bArr = this.f3644f;
                    this.f3647i = K + 0;
                } else {
                    bArr = F(K, false);
                }
                i2 = 0;
            }
            return w1.b(bArr, i2, K);
        }
    }

    public static final class d extends k {

        /* renamed from: e  reason: collision with root package name */
        public final ByteBuffer f3651e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f3652f;

        /* renamed from: g  reason: collision with root package name */
        public final long f3653g;

        /* renamed from: h  reason: collision with root package name */
        public long f3654h;

        /* renamed from: i  reason: collision with root package name */
        public long f3655i;

        /* renamed from: j  reason: collision with root package name */
        public long f3656j;

        /* renamed from: k  reason: collision with root package name */
        public int f3657k;

        /* renamed from: l  reason: collision with root package name */
        public int f3658l;
        public int m = Integer.MAX_VALUE;

        public d(ByteBuffer byteBuffer, boolean z, a aVar) {
            super(null);
            this.f3651e = byteBuffer;
            long a = v1.a(byteBuffer);
            this.f3653g = a;
            this.f3654h = ((long) byteBuffer.limit()) + a;
            long position = a + ((long) byteBuffer.position());
            this.f3655i = position;
            this.f3656j = position;
            this.f3652f = z;
        }

        @Override // f.b.g.k
        public int A() {
            if (e()) {
                this.f3658l = 0;
                return 0;
            }
            int I = I();
            this.f3658l = I;
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
                    long j2 = this.f3655i;
                    this.f3655i = 1 + j2;
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
            return (int) (j2 - this.f3653g);
        }

        public byte F() {
            long j2 = this.f3655i;
            if (j2 != this.f3654h) {
                this.f3655i = 1 + j2;
                return v1.h(j2);
            }
            throw d0.h();
        }

        public int G() {
            long j2 = this.f3655i;
            if (this.f3654h - j2 >= 4) {
                this.f3655i = 4 + j2;
                return ((v1.h(j2 + 3) & 255) << 24) | (v1.h(j2) & 255) | ((v1.h(1 + j2) & 255) << 8) | ((v1.h(2 + j2) & 255) << 16);
            }
            throw d0.h();
        }

        public long H() {
            long j2 = this.f3655i;
            if (this.f3654h - j2 >= 8) {
                this.f3655i = 8 + j2;
                return ((((long) v1.h(j2 + 7)) & 255) << 56) | (((long) v1.h(j2)) & 255) | ((((long) v1.h(1 + j2)) & 255) << 8) | ((((long) v1.h(2 + j2)) & 255) << 16) | ((((long) v1.h(3 + j2)) & 255) << 24) | ((((long) v1.h(4 + j2)) & 255) << 32) | ((((long) v1.h(5 + j2)) & 255) << 40) | ((((long) v1.h(6 + j2)) & 255) << 48);
            }
            throw d0.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
            if (f.b.g.v1.h(r4) < 0) goto L_0x0085;
         */
        public int I() {
            int i2;
            long j2 = this.f3655i;
            if (this.f3654h != j2) {
                long j3 = j2 + 1;
                byte h2 = v1.h(j2);
                if (h2 >= 0) {
                    this.f3655i = j3;
                    return h2;
                } else if (this.f3654h - j3 >= 9) {
                    long j4 = j3 + 1;
                    int h3 = h2 ^ (v1.h(j3) << 7);
                    if (h3 < 0) {
                        i2 = h3 ^ -128;
                    } else {
                        long j5 = j4 + 1;
                        int h4 = h3 ^ (v1.h(j4) << 14);
                        if (h4 >= 0) {
                            i2 = h4 ^ 16256;
                        } else {
                            j4 = j5 + 1;
                            int h5 = h4 ^ (v1.h(j5) << 21);
                            if (h5 < 0) {
                                i2 = h5 ^ -2080896;
                            } else {
                                j5 = j4 + 1;
                                byte h6 = v1.h(j4);
                                i2 = (h5 ^ (h6 << 28)) ^ 266354560;
                                if (h6 < 0) {
                                    j4 = j5 + 1;
                                    if (v1.h(j5) < 0) {
                                        j5 = j4 + 1;
                                        if (v1.h(j4) < 0) {
                                            j4 = j5 + 1;
                                            if (v1.h(j5) < 0) {
                                                j5 = j4 + 1;
                                                if (v1.h(j4) < 0) {
                                                    j4 = j5 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        j4 = j5;
                    }
                    this.f3655i = j4;
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
            long j5 = this.f3655i;
            if (this.f3654h != j5) {
                long j6 = j5 + 1;
                byte h2 = v1.h(j5);
                if (h2 >= 0) {
                    this.f3655i = j6;
                    return (long) h2;
                } else if (this.f3654h - j6 >= 9) {
                    long j7 = j6 + 1;
                    int h3 = h2 ^ (v1.h(j6) << 7);
                    if (h3 < 0) {
                        i2 = h3 ^ -128;
                    } else {
                        long j8 = j7 + 1;
                        int h4 = h3 ^ (v1.h(j7) << 14);
                        if (h4 >= 0) {
                            j2 = (long) (h4 ^ 16256);
                        } else {
                            j7 = j8 + 1;
                            int h5 = h4 ^ (v1.h(j8) << 21);
                            if (h5 < 0) {
                                i2 = h5 ^ -2080896;
                            } else {
                                j8 = j7 + 1;
                                long h6 = ((long) h5) ^ (((long) v1.h(j7)) << 28);
                                if (h6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j9 = j8 + 1;
                                    long h7 = h6 ^ (((long) v1.h(j8)) << 35);
                                    if (h7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j8 = j9 + 1;
                                        h6 = h7 ^ (((long) v1.h(j9)) << 42);
                                        if (h6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j9 = j8 + 1;
                                            h7 = h6 ^ (((long) v1.h(j8)) << 49);
                                            if (h7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j8 = j9 + 1;
                                                j2 = (h7 ^ (((long) v1.h(j9)) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    long j10 = 1 + j8;
                                                    if (((long) v1.h(j8)) >= 0) {
                                                        j7 = j10;
                                                        this.f3655i = j7;
                                                        return j2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j2 = h7 ^ j3;
                                    j7 = j9;
                                    this.f3655i = j7;
                                    return j2;
                                }
                                j2 = h6 ^ j4;
                            }
                        }
                        j7 = j8;
                        this.f3655i = j7;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.f3655i = j7;
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
            long j2 = this.f3654h + ((long) this.f3657k);
            this.f3654h = j2;
            int i2 = (int) (j2 - this.f3656j);
            int i3 = this.m;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.f3657k = i4;
                this.f3654h = j2 - ((long) i4);
                return;
            }
            this.f3657k = 0;
        }

        public final int M() {
            return (int) (this.f3654h - this.f3655i);
        }

        public void N(int i2) {
            if (i2 >= 0 && i2 <= M()) {
                this.f3655i += (long) i2;
            } else if (i2 < 0) {
                throw d0.f();
            } else {
                throw d0.h();
            }
        }

        @Override // f.b.g.k
        public void a(int i2) {
            if (this.f3658l != i2) {
                throw d0.a();
            }
        }

        @Override // f.b.g.k
        public int d() {
            return (int) (this.f3655i - this.f3656j);
        }

        @Override // f.b.g.k
        public boolean e() {
            return this.f3655i == this.f3654h;
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
                v1.f3698f.c(this.f3655i, bArr, 0, j2);
                this.f3655i += j2;
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
                v1.f3698f.c(this.f3655i, bArr, 0, j2);
                String str = new String(bArr, c0.a);
                this.f3655i += j2;
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
                int E = E(this.f3655i);
                ByteBuffer byteBuffer = this.f3651e;
                w1.a aVar = w1.a;
                Objects.requireNonNull(aVar);
                String a = byteBuffer.hasArray() ? aVar.a(byteBuffer.array(), byteBuffer.arrayOffset() + E, I) : byteBuffer.isDirect() ? aVar.c(byteBuffer, E, I) : aVar.b(byteBuffer, E, I);
                this.f3655i += (long) I;
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
        } else if (byteBuffer.isDirect() && v1.f3699g) {
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
