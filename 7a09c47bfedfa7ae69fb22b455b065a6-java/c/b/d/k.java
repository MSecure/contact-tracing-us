package c.b.d;

import androidx.recyclerview.widget.RecyclerView;
import c.b.d.i1;
import c.b.d.w2;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public int f5336a;

    /* renamed from: b  reason: collision with root package name */
    public int f5337b = 100;

    /* renamed from: c  reason: collision with root package name */
    public int f5338c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public l f5339d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5340e = false;

    public static final class b extends k {

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f5341f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f5342g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m = Integer.MAX_VALUE;

        public b(byte[] bArr, int i2, int i3, boolean z, a aVar) {
            super(null);
            this.f5341f = bArr;
            this.h = i3 + i2;
            this.j = i2;
            this.k = i2;
            this.f5342g = z;
        }

        @Override // c.b.d.k
        public int A() {
            return L();
        }

        @Override // c.b.d.k
        public long B() {
            return M();
        }

        @Override // c.b.d.k
        public int C() {
            return k.b(y());
        }

        @Override // c.b.d.k
        public long D() {
            return k.c(N());
        }

        @Override // c.b.d.k
        public String E() {
            int y = y();
            if (y > 0 && y <= this.h - this.j) {
                String str = new String(this.f5341f, this.j, y, n0.f5438a);
                this.j += y;
                return str;
            } else if (y == 0) {
                return "";
            } else {
                if (y < 0) {
                    throw o0.f();
                }
                throw o0.i();
            }
        }

        @Override // c.b.d.k
        public String F() {
            int y = y();
            if (y > 0) {
                int i2 = this.h;
                int i3 = this.j;
                if (y <= i2 - i3) {
                    String b2 = w2.b(this.f5341f, i3, y);
                    this.j += y;
                    return b2;
                }
            }
            if (y == 0) {
                return "";
            }
            if (y <= 0) {
                throw o0.f();
            }
            throw o0.i();
        }

        @Override // c.b.d.k
        public int G() {
            if (f()) {
                this.l = 0;
                return 0;
            }
            int y = y();
            this.l = y;
            if ((y >>> 3) != 0) {
                return y;
            }
            throw o0.b();
        }

        @Override // c.b.d.k
        public int H() {
            return y();
        }

        @Override // c.b.d.k
        public long I() {
            return N();
        }

        @Override // c.b.d.k
        public boolean J(int i2) {
            int i3;
            int G;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 != 0) {
                if (i4 == 1) {
                    i3 = 8;
                } else if (i4 == 2) {
                    i3 = y();
                } else if (i4 == 3) {
                    do {
                        G = G();
                        if (G == 0) {
                            break;
                        }
                    } while (J(G));
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                } else if (i4 == 4) {
                    return false;
                } else {
                    if (i4 == 5) {
                        Q(4);
                        return true;
                    }
                    throw o0.d();
                }
                Q(i3);
                return true;
            }
            if (this.h - this.j >= 10) {
                while (i5 < 10) {
                    byte[] bArr = this.f5341f;
                    int i6 = this.j;
                    this.j = i6 + 1;
                    if (bArr[i6] < 0) {
                        i5++;
                    }
                }
                throw o0.e();
            }
            while (i5 < 10) {
                if (K() < 0) {
                    i5++;
                }
            }
            throw o0.e();
            return true;
        }

        public byte K() {
            int i2 = this.j;
            if (i2 != this.h) {
                byte[] bArr = this.f5341f;
                this.j = i2 + 1;
                return bArr[i2];
            }
            throw o0.i();
        }

        public int L() {
            int i2 = this.j;
            if (this.h - i2 >= 4) {
                byte[] bArr = this.f5341f;
                this.j = i2 + 4;
                return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
            }
            throw o0.i();
        }

        public long M() {
            int i2 = this.j;
            if (this.h - i2 >= 8) {
                byte[] bArr = this.f5341f;
                this.j = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw o0.i();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        public long N() {
            long j2;
            long j3;
            long j4;
            int i2;
            int i3 = this.j;
            int i4 = this.h;
            if (i4 != i3) {
                byte[] bArr = this.f5341f;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.j = i5;
                    return (long) b2;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b2 ^ (bArr[i5] << 7);
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
                        this.j = i6;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.j = i6;
                    return j2;
                }
            }
            return O();
        }

        public long O() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte K = K();
                j2 |= ((long) (K & Byte.MAX_VALUE)) << i2;
                if ((K & 128) == 0) {
                    return j2;
                }
            }
            throw o0.e();
        }

        public final void P() {
            int i2 = this.h + this.i;
            this.h = i2;
            int i3 = i2 - this.k;
            int i4 = this.m;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.i = i5;
                this.h = i2 - i5;
                return;
            }
            this.i = 0;
        }

        public void Q(int i2) {
            if (i2 >= 0) {
                int i3 = this.h;
                int i4 = this.j;
                if (i2 <= i3 - i4) {
                    this.j = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw o0.f();
            }
            throw o0.i();
        }

        @Override // c.b.d.k
        public void a(int i2) {
            if (this.l != i2) {
                throw o0.a();
            }
        }

        @Override // c.b.d.k
        public int d() {
            int i2 = this.m;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - e();
        }

        @Override // c.b.d.k
        public int e() {
            return this.j - this.k;
        }

        @Override // c.b.d.k
        public boolean f() {
            return this.j == this.h;
        }

        @Override // c.b.d.k
        public void k(int i2) {
            this.m = i2;
            P();
        }

        @Override // c.b.d.k
        public int l(int i2) {
            if (i2 >= 0) {
                int e2 = e() + i2;
                int i3 = this.m;
                if (e2 <= i3) {
                    this.m = e2;
                    P();
                    return i3;
                }
                throw o0.i();
            }
            throw o0.f();
        }

        @Override // c.b.d.k
        public boolean m() {
            return N() != 0;
        }

        @Override // c.b.d.k
        public j n() {
            byte[] bArr;
            int y = y();
            if (y > 0 && y <= this.h - this.j) {
                boolean z = this.f5342g;
                j g2 = j.g(this.f5341f, this.j, y);
                this.j += y;
                return g2;
            } else if (y == 0) {
                return j.f5320c;
            } else {
                if (y > 0) {
                    int i2 = this.h;
                    int i3 = this.j;
                    if (y <= i2 - i3) {
                        int i4 = y + i3;
                        this.j = i4;
                        bArr = Arrays.copyOfRange(this.f5341f, i3, i4);
                        return j.C(bArr);
                    }
                }
                if (y > 0) {
                    throw o0.i();
                } else if (y == 0) {
                    bArr = n0.f5440c;
                    return j.C(bArr);
                } else {
                    throw o0.f();
                }
            }
        }

        @Override // c.b.d.k
        public double o() {
            return Double.longBitsToDouble(M());
        }

        @Override // c.b.d.k
        public int p() {
            return y();
        }

        @Override // c.b.d.k
        public int q() {
            return L();
        }

        @Override // c.b.d.k
        public long r() {
            return M();
        }

        @Override // c.b.d.k
        public float s() {
            return Float.intBitsToFloat(L());
        }

        @Override // c.b.d.k
        public void t(int i2, i1.a aVar, z zVar) {
            int i3 = this.f5336a;
            if (i3 < this.f5337b) {
                this.f5336a = i3 + 1;
                aVar.mergeFrom(this, zVar);
                a((i2 << 3) | 4);
                this.f5336a--;
                return;
            }
            throw o0.h();
        }

        @Override // c.b.d.k
        public int u() {
            return y();
        }

        @Override // c.b.d.k
        public long v() {
            return N();
        }

        @Override // c.b.d.k
        public <T extends i1> T w(w1<T> w1Var, z zVar) {
            int y = y();
            if (this.f5336a < this.f5337b) {
                int l2 = l(y);
                this.f5336a++;
                T parsePartialFrom = w1Var.parsePartialFrom(this, zVar);
                a(0);
                this.f5336a--;
                this.m = l2;
                P();
                return parsePartialFrom;
            }
            throw o0.h();
        }

        @Override // c.b.d.k
        public void x(i1.a aVar, z zVar) {
            int y = y();
            if (this.f5336a < this.f5337b) {
                int l2 = l(y);
                this.f5336a++;
                aVar.mergeFrom(this, zVar);
                a(0);
                this.f5336a--;
                this.m = l2;
                P();
                return;
            }
            throw o0.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        @Override // c.b.d.k
        public int y() {
            int i2;
            int i3 = this.j;
            int i4 = this.h;
            if (i4 != i3) {
                byte[] bArr = this.f5341f;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.j = i5;
                    return b2;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b2 ^ (bArr[i5] << 7);
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
                                byte b3 = bArr[i6];
                                i2 = (i10 ^ (b3 << 28)) ^ 266354560;
                                if (b3 < 0) {
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
                    this.j = i6;
                    return i2;
                }
            }
            return (int) O();
        }
    }

    public static final class c extends k {

        /* renamed from: f  reason: collision with root package name */
        public final InputStream f5343f;

        /* renamed from: g  reason: collision with root package name */
        public final byte[] f5344g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m = Integer.MAX_VALUE;
        public a n = null;

        public interface a {
            void a();
        }

        public c(InputStream inputStream, int i2, a aVar) {
            super(null);
            n0.b(inputStream, "input");
            this.f5343f = inputStream;
            this.f5344g = new byte[i2];
            this.h = 0;
            this.j = 0;
            this.l = 0;
        }

        @Override // c.b.d.k
        public int A() {
            return O();
        }

        @Override // c.b.d.k
        public long B() {
            return P();
        }

        @Override // c.b.d.k
        public int C() {
            return k.b(y());
        }

        @Override // c.b.d.k
        public long D() {
            return k.c(Q());
        }

        @Override // c.b.d.k
        public String E() {
            int y = y();
            if (y > 0 && y <= this.h - this.j) {
                String str = new String(this.f5344g, this.j, y, n0.f5438a);
                this.j += y;
                return str;
            } else if (y == 0) {
                return "";
            } else {
                if (y > this.h) {
                    return new String(L(y, false), n0.f5438a);
                }
                T(y);
                String str2 = new String(this.f5344g, this.j, y, n0.f5438a);
                this.j += y;
                return str2;
            }
        }

        @Override // c.b.d.k
        public String F() {
            byte[] bArr;
            int y = y();
            int i2 = this.j;
            if (y <= this.h - i2 && y > 0) {
                bArr = this.f5344g;
                this.j = i2 + y;
            } else if (y == 0) {
                return "";
            } else {
                if (y <= this.h) {
                    T(y);
                    bArr = this.f5344g;
                    this.j = y + 0;
                } else {
                    bArr = L(y, false);
                }
                i2 = 0;
            }
            return w2.b(bArr, i2, y);
        }

        @Override // c.b.d.k
        public int G() {
            if (f()) {
                this.k = 0;
                return 0;
            }
            int y = y();
            this.k = y;
            if ((y >>> 3) != 0) {
                return y;
            }
            throw o0.b();
        }

        @Override // c.b.d.k
        public int H() {
            return y();
        }

        @Override // c.b.d.k
        public long I() {
            return Q();
        }

        @Override // c.b.d.k
        public boolean J(int i2) {
            int i3;
            int G;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 != 0) {
                if (i4 == 1) {
                    i3 = 8;
                } else if (i4 == 2) {
                    i3 = y();
                } else if (i4 == 3) {
                    do {
                        G = G();
                        if (G == 0) {
                            break;
                        }
                    } while (J(G));
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                } else if (i4 == 4) {
                    return false;
                } else {
                    if (i4 == 5) {
                        U(4);
                        return true;
                    }
                    throw o0.d();
                }
                U(i3);
                return true;
            }
            if (this.h - this.j >= 10) {
                while (i5 < 10) {
                    byte[] bArr = this.f5344g;
                    int i6 = this.j;
                    this.j = i6 + 1;
                    if (bArr[i6] < 0) {
                        i5++;
                    }
                }
                throw o0.e();
            }
            while (i5 < 10) {
                if (K() < 0) {
                    i5++;
                }
            }
            throw o0.e();
            return true;
        }

        public byte K() {
            if (this.j == this.h) {
                T(1);
            }
            byte[] bArr = this.f5344g;
            int i2 = this.j;
            this.j = i2 + 1;
            return bArr[i2];
        }

        public final byte[] L(int i2, boolean z) {
            byte[] M = M(i2);
            if (M != null) {
                return z ? (byte[]) M.clone() : M;
            }
            int i3 = this.j;
            int i4 = this.h;
            int i5 = i4 - i3;
            this.l += i4;
            this.j = 0;
            this.h = 0;
            List<byte[]> N = N(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f5344g, i3, bArr, 0, i5);
            Iterator it = ((ArrayList) N).iterator();
            while (it.hasNext()) {
                byte[] bArr2 = (byte[]) it.next();
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return bArr;
        }

        public final byte[] M(int i2) {
            if (i2 == 0) {
                return n0.f5440c;
            }
            if (i2 >= 0) {
                int i3 = this.l;
                int i4 = this.j;
                int i5 = i3 + i4 + i2;
                if (i5 - this.f5338c <= 0) {
                    int i6 = this.m;
                    if (i5 <= i6) {
                        int i7 = this.h - i4;
                        int i8 = i2 - i7;
                        if (i8 >= 4096 && i8 > this.f5343f.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.f5344g, this.j, bArr, 0, i7);
                        this.l += this.h;
                        this.j = 0;
                        this.h = 0;
                        while (i7 < i2) {
                            int read = this.f5343f.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.l += read;
                                i7 += read;
                            } else {
                                throw o0.i();
                            }
                        }
                        return bArr;
                    }
                    U((i6 - i3) - i4);
                    throw o0.i();
                }
                throw new o0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw o0.f();
        }

        public final List<byte[]> N(int i2) {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int min = Math.min(i2, 4096);
                byte[] bArr = new byte[min];
                int i3 = 0;
                while (i3 < min) {
                    int read = this.f5343f.read(bArr, i3, min - i3);
                    if (read != -1) {
                        this.l += read;
                        i3 += read;
                    } else {
                        throw o0.i();
                    }
                }
                i2 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int O() {
            int i2 = this.j;
            if (this.h - i2 < 4) {
                T(4);
                i2 = this.j;
            }
            byte[] bArr = this.f5344g;
            this.j = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public long P() {
            int i2 = this.j;
            if (this.h - i2 < 8) {
                T(8);
                i2 = this.j;
            }
            byte[] bArr = this.f5344g;
            this.j = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        public long Q() {
            long j2;
            long j3;
            long j4;
            int i2;
            int i3 = this.j;
            int i4 = this.h;
            if (i4 != i3) {
                byte[] bArr = this.f5344g;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.j = i5;
                    return (long) b2;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b2 ^ (bArr[i5] << 7);
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
                        this.j = i6;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.j = i6;
                    return j2;
                }
            }
            return R();
        }

        public long R() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte K = K();
                j2 |= ((long) (K & Byte.MAX_VALUE)) << i2;
                if ((K & 128) == 0) {
                    return j2;
                }
            }
            throw o0.e();
        }

        public final void S() {
            int i2 = this.h + this.i;
            this.h = i2;
            int i3 = this.l + i2;
            int i4 = this.m;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.i = i5;
                this.h = i2 - i5;
                return;
            }
            this.i = 0;
        }

        public final void T(int i2) {
            if (V(i2)) {
                return;
            }
            if (i2 > (this.f5338c - this.l) - this.j) {
                throw new o0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw o0.i();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0075, code lost:
            r8.l += r3;
            S();
         */
        public void U(int i2) {
            long skip;
            int i3 = this.h;
            int i4 = this.j;
            if (i2 <= i3 - i4 && i2 >= 0) {
                this.j = i4 + i2;
            } else if (i2 >= 0) {
                int i5 = this.l;
                int i6 = this.j;
                int i7 = i5 + i6;
                int i8 = i7 + i2;
                int i9 = this.m;
                if (i8 <= i9) {
                    int i10 = 0;
                    if (this.n == null) {
                        this.l = i7;
                        this.h = 0;
                        this.j = 0;
                        i10 = this.h - i6;
                        while (true) {
                            if (i10 >= i2) {
                                break;
                            }
                            try {
                                long j2 = (long) (i2 - i10);
                                skip = this.f5343f.skip(j2);
                                int i11 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                                if (i11 < 0 || skip > j2) {
                                } else if (i11 == 0) {
                                    break;
                                } else {
                                    i10 += (int) skip;
                                }
                            } catch (Throwable th) {
                                this.l += i10;
                                S();
                                throw th;
                            }
                        }
                        throw new IllegalStateException(this.f5343f.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                    }
                    if (i10 < i2) {
                        int i12 = this.h;
                        int i13 = i12 - this.j;
                        this.j = i12;
                        while (true) {
                            T(1);
                            int i14 = i2 - i13;
                            int i15 = this.h;
                            if (i14 > i15) {
                                i13 += i15;
                                this.j = i15;
                            } else {
                                this.j = i14;
                                return;
                            }
                        }
                    }
                } else {
                    U((i9 - i5) - i6);
                    throw o0.i();
                }
            } else {
                throw o0.f();
            }
        }

        public final boolean V(int i2) {
            int i3 = this.j;
            if (i3 + i2 > this.h) {
                int i4 = this.f5338c;
                int i5 = this.l;
                if (i2 > (i4 - i5) - i3 || i5 + i3 + i2 > this.m) {
                    return false;
                }
                a aVar = this.n;
                if (aVar != null) {
                    aVar.a();
                }
                int i6 = this.j;
                if (i6 > 0) {
                    int i7 = this.h;
                    if (i7 > i6) {
                        byte[] bArr = this.f5344g;
                        System.arraycopy(bArr, i6, bArr, 0, i7 - i6);
                    }
                    this.l += i6;
                    this.h -= i6;
                    this.j = 0;
                }
                InputStream inputStream = this.f5343f;
                byte[] bArr2 = this.f5344g;
                int i8 = this.h;
                int read = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.f5338c - this.l) - i8));
                if (read == 0 || read < -1 || read > this.f5344g.length) {
                    throw new IllegalStateException(this.f5343f.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.h += read;
                    S();
                    if (this.h >= i2) {
                        return true;
                    }
                    return V(i2);
                }
            } else {
                throw new IllegalStateException(c.a.a.a.a.o("refillBuffer() called when ", i2, " bytes were already available in buffer"));
            }
        }

        @Override // c.b.d.k
        public void a(int i2) {
            if (this.k != i2) {
                throw o0.a();
            }
        }

        @Override // c.b.d.k
        public int d() {
            int i2 = this.m;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - (this.l + this.j);
        }

        @Override // c.b.d.k
        public int e() {
            return this.l + this.j;
        }

        @Override // c.b.d.k
        public boolean f() {
            return this.j == this.h && !V(1);
        }

        @Override // c.b.d.k
        public void k(int i2) {
            this.m = i2;
            S();
        }

        @Override // c.b.d.k
        public int l(int i2) {
            if (i2 >= 0) {
                int i3 = this.l + this.j + i2;
                int i4 = this.m;
                if (i3 <= i4) {
                    this.m = i3;
                    S();
                    return i4;
                }
                throw o0.i();
            }
            throw o0.f();
        }

        @Override // c.b.d.k
        public boolean m() {
            return Q() != 0;
        }

        @Override // c.b.d.k
        public j n() {
            int y = y();
            int i2 = this.h;
            int i3 = this.j;
            if (y <= i2 - i3 && y > 0) {
                j g2 = j.g(this.f5344g, i3, y);
                this.j += y;
                return g2;
            } else if (y == 0) {
                return j.f5320c;
            } else {
                byte[] M = M(y);
                if (M != null) {
                    return j.e(M);
                }
                int i4 = this.j;
                int i5 = this.h;
                int i6 = i5 - i4;
                this.l += i5;
                this.j = 0;
                this.h = 0;
                List<byte[]> N = N(y - i6);
                byte[] bArr = new byte[y];
                System.arraycopy(this.f5344g, i4, bArr, 0, i6);
                Iterator it = ((ArrayList) N).iterator();
                while (it.hasNext()) {
                    byte[] bArr2 = (byte[]) it.next();
                    System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                    i6 += bArr2.length;
                }
                return j.C(bArr);
            }
        }

        @Override // c.b.d.k
        public double o() {
            return Double.longBitsToDouble(P());
        }

        @Override // c.b.d.k
        public int p() {
            return y();
        }

        @Override // c.b.d.k
        public int q() {
            return O();
        }

        @Override // c.b.d.k
        public long r() {
            return P();
        }

        @Override // c.b.d.k
        public float s() {
            return Float.intBitsToFloat(O());
        }

        @Override // c.b.d.k
        public void t(int i2, i1.a aVar, z zVar) {
            int i3 = this.f5336a;
            if (i3 < this.f5337b) {
                this.f5336a = i3 + 1;
                aVar.mergeFrom(this, zVar);
                a((i2 << 3) | 4);
                this.f5336a--;
                return;
            }
            throw o0.h();
        }

        @Override // c.b.d.k
        public int u() {
            return y();
        }

        @Override // c.b.d.k
        public long v() {
            return Q();
        }

        @Override // c.b.d.k
        public <T extends i1> T w(w1<T> w1Var, z zVar) {
            int y = y();
            if (this.f5336a < this.f5337b) {
                int l2 = l(y);
                this.f5336a++;
                T parsePartialFrom = w1Var.parsePartialFrom(this, zVar);
                a(0);
                this.f5336a--;
                this.m = l2;
                S();
                return parsePartialFrom;
            }
            throw o0.h();
        }

        @Override // c.b.d.k
        public void x(i1.a aVar, z zVar) {
            int y = y();
            if (this.f5336a < this.f5337b) {
                int l2 = l(y);
                this.f5336a++;
                aVar.mergeFrom(this, zVar);
                a(0);
                this.f5336a--;
                this.m = l2;
                S();
                return;
            }
            throw o0.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        @Override // c.b.d.k
        public int y() {
            int i2;
            int i3 = this.j;
            int i4 = this.h;
            if (i4 != i3) {
                byte[] bArr = this.f5344g;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.j = i5;
                    return b2;
                } else if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b2 ^ (bArr[i5] << 7);
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
                                byte b3 = bArr[i6];
                                i2 = (i10 ^ (b3 << 28)) ^ 266354560;
                                if (b3 < 0) {
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
                    this.j = i6;
                    return i2;
                }
            }
            return (int) R();
        }
    }

    public static final class d extends k {

        /* renamed from: f  reason: collision with root package name */
        public final ByteBuffer f5345f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f5346g;
        public final long h;
        public long i;
        public long j;
        public long k;
        public int l;
        public int m;
        public int n = Integer.MAX_VALUE;

        public d(ByteBuffer byteBuffer, boolean z, a aVar) {
            super(null);
            this.f5345f = byteBuffer;
            long a2 = v2.a(byteBuffer);
            this.h = a2;
            this.i = a2 + ((long) byteBuffer.limit());
            long position = this.h + ((long) byteBuffer.position());
            this.j = position;
            this.k = position;
            this.f5346g = z;
        }

        @Override // c.b.d.k
        public int A() {
            return M();
        }

        @Override // c.b.d.k
        public long B() {
            return N();
        }

        @Override // c.b.d.k
        public int C() {
            return k.b(y());
        }

        @Override // c.b.d.k
        public long D() {
            return k.c(O());
        }

        @Override // c.b.d.k
        public String E() {
            int y = y();
            if (y > 0 && y <= R()) {
                byte[] bArr = new byte[y];
                long j2 = (long) y;
                v2.f5899f.c(this.j, bArr, 0, j2);
                String str = new String(bArr, n0.f5438a);
                this.j += j2;
                return str;
            } else if (y == 0) {
                return "";
            } else {
                if (y < 0) {
                    throw o0.f();
                }
                throw o0.i();
            }
        }

        @Override // c.b.d.k
        public String F() {
            int y = y();
            if (y > 0 && y <= R()) {
                int K = K(this.j);
                ByteBuffer byteBuffer = this.f5345f;
                w2.a aVar = w2.f5905a;
                if (aVar != null) {
                    String a2 = byteBuffer.hasArray() ? aVar.a(byteBuffer.array(), byteBuffer.arrayOffset() + K, y) : byteBuffer.isDirect() ? aVar.c(byteBuffer, K, y) : aVar.b(byteBuffer, K, y);
                    this.j += (long) y;
                    return a2;
                }
                throw null;
            } else if (y == 0) {
                return "";
            } else {
                if (y <= 0) {
                    throw o0.f();
                }
                throw o0.i();
            }
        }

        @Override // c.b.d.k
        public int G() {
            if (f()) {
                this.m = 0;
                return 0;
            }
            int y = y();
            this.m = y;
            if ((y >>> 3) != 0) {
                return y;
            }
            throw o0.b();
        }

        @Override // c.b.d.k
        public int H() {
            return y();
        }

        @Override // c.b.d.k
        public long I() {
            return O();
        }

        @Override // c.b.d.k
        public boolean J(int i2) {
            int i3;
            int G;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 != 0) {
                if (i4 == 1) {
                    i3 = 8;
                } else if (i4 == 2) {
                    i3 = y();
                } else if (i4 == 3) {
                    do {
                        G = G();
                        if (G == 0) {
                            break;
                        }
                    } while (J(G));
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                } else if (i4 == 4) {
                    return false;
                } else {
                    if (i4 == 5) {
                        S(4);
                        return true;
                    }
                    throw o0.d();
                }
                S(i3);
                return true;
            }
            if (R() >= 10) {
                while (i5 < 10) {
                    long j2 = this.j;
                    this.j = 1 + j2;
                    if (v2.h(j2) < 0) {
                        i5++;
                    }
                }
                throw o0.e();
            }
            while (i5 < 10) {
                if (L() < 0) {
                    i5++;
                }
            }
            throw o0.e();
            return true;
        }

        public final int K(long j2) {
            return (int) (j2 - this.h);
        }

        public byte L() {
            long j2 = this.j;
            if (j2 != this.i) {
                this.j = 1 + j2;
                return v2.h(j2);
            }
            throw o0.i();
        }

        public int M() {
            long j2 = this.j;
            if (this.i - j2 >= 4) {
                this.j = 4 + j2;
                return ((v2.h(j2 + 3) & 255) << 24) | (v2.h(j2) & 255) | ((v2.h(1 + j2) & 255) << 8) | ((v2.h(2 + j2) & 255) << 16);
            }
            throw o0.i();
        }

        public long N() {
            long j2 = this.j;
            if (this.i - j2 >= 8) {
                this.j = 8 + j2;
                return ((((long) v2.h(j2 + 7)) & 255) << 56) | (((long) v2.h(j2)) & 255) | ((((long) v2.h(1 + j2)) & 255) << 8) | ((((long) v2.h(2 + j2)) & 255) << 16) | ((((long) v2.h(3 + j2)) & 255) << 24) | ((((long) v2.h(4 + j2)) & 255) << 32) | ((((long) v2.h(5 + j2)) & 255) << 40) | ((((long) v2.h(6 + j2)) & 255) << 48);
            }
            throw o0.i();
        }

        public long O() {
            long j2;
            long j3;
            long j4;
            int i2;
            long j5 = this.j;
            if (this.i != j5) {
                long j6 = j5 + 1;
                byte h2 = v2.h(j5);
                if (h2 >= 0) {
                    this.j = j6;
                    return (long) h2;
                } else if (this.i - j6 >= 9) {
                    long j7 = j6 + 1;
                    int h3 = h2 ^ (v2.h(j6) << 7);
                    if (h3 < 0) {
                        i2 = h3 ^ -128;
                    } else {
                        long j8 = j7 + 1;
                        int h4 = h3 ^ (v2.h(j7) << 14);
                        if (h4 >= 0) {
                            j2 = (long) (h4 ^ 16256);
                        } else {
                            j7 = j8 + 1;
                            int h5 = h4 ^ (v2.h(j8) << 21);
                            if (h5 < 0) {
                                i2 = h5 ^ -2080896;
                            } else {
                                j8 = j7 + 1;
                                long h6 = ((long) h5) ^ (((long) v2.h(j7)) << 28);
                                if (h6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j9 = j8 + 1;
                                    long h7 = h6 ^ (((long) v2.h(j8)) << 35);
                                    if (h7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j8 = j9 + 1;
                                        h6 = h7 ^ (((long) v2.h(j9)) << 42);
                                        if (h6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j9 = j8 + 1;
                                            h7 = h6 ^ (((long) v2.h(j8)) << 49);
                                            if (h7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j8 = j9 + 1;
                                                j2 = (h7 ^ (((long) v2.h(j9)) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    long j10 = 1 + j8;
                                                    if (((long) v2.h(j8)) >= 0) {
                                                        j7 = j10;
                                                        this.j = j7;
                                                        return j2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j2 = h7 ^ j3;
                                    j7 = j9;
                                    this.j = j7;
                                    return j2;
                                }
                                j2 = h6 ^ j4;
                            }
                        }
                        j7 = j8;
                        this.j = j7;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.j = j7;
                    return j2;
                }
            }
            return P();
        }

        public long P() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte L = L();
                j2 |= ((long) (L & Byte.MAX_VALUE)) << i2;
                if ((L & 128) == 0) {
                    return j2;
                }
            }
            throw o0.e();
        }

        public final void Q() {
            long j2 = this.i + ((long) this.l);
            this.i = j2;
            int i2 = (int) (j2 - this.k);
            int i3 = this.n;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.l = i4;
                this.i = j2 - ((long) i4);
                return;
            }
            this.l = 0;
        }

        public final int R() {
            return (int) (this.i - this.j);
        }

        public void S(int i2) {
            if (i2 >= 0 && i2 <= R()) {
                this.j += (long) i2;
            } else if (i2 < 0) {
                throw o0.f();
            } else {
                throw o0.i();
            }
        }

        @Override // c.b.d.k
        public void a(int i2) {
            if (this.m != i2) {
                throw o0.a();
            }
        }

        @Override // c.b.d.k
        public int d() {
            int i2 = this.n;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - e();
        }

        @Override // c.b.d.k
        public int e() {
            return (int) (this.j - this.k);
        }

        @Override // c.b.d.k
        public boolean f() {
            return this.j == this.i;
        }

        @Override // c.b.d.k
        public void k(int i2) {
            this.n = i2;
            Q();
        }

        @Override // c.b.d.k
        public int l(int i2) {
            if (i2 >= 0) {
                int e2 = e() + i2;
                int i3 = this.n;
                if (e2 <= i3) {
                    this.n = e2;
                    Q();
                    return i3;
                }
                throw o0.i();
            }
            throw o0.f();
        }

        @Override // c.b.d.k
        public boolean m() {
            return O() != 0;
        }

        @Override // c.b.d.k
        public j n() {
            int y = y();
            if (y > 0 && y <= R()) {
                byte[] bArr = new byte[y];
                long j2 = (long) y;
                v2.f5899f.c(this.j, bArr, 0, j2);
                this.j += j2;
                return j.C(bArr);
            } else if (y == 0) {
                return j.f5320c;
            } else {
                if (y < 0) {
                    throw o0.f();
                }
                throw o0.i();
            }
        }

        @Override // c.b.d.k
        public double o() {
            return Double.longBitsToDouble(N());
        }

        @Override // c.b.d.k
        public int p() {
            return y();
        }

        @Override // c.b.d.k
        public int q() {
            return M();
        }

        @Override // c.b.d.k
        public long r() {
            return N();
        }

        @Override // c.b.d.k
        public float s() {
            return Float.intBitsToFloat(M());
        }

        @Override // c.b.d.k
        public void t(int i2, i1.a aVar, z zVar) {
            int i3 = this.f5336a;
            if (i3 < this.f5337b) {
                this.f5336a = i3 + 1;
                aVar.mergeFrom(this, zVar);
                a((i2 << 3) | 4);
                this.f5336a--;
                return;
            }
            throw o0.h();
        }

        @Override // c.b.d.k
        public int u() {
            return y();
        }

        @Override // c.b.d.k
        public long v() {
            return O();
        }

        @Override // c.b.d.k
        public <T extends i1> T w(w1<T> w1Var, z zVar) {
            int y = y();
            if (this.f5336a < this.f5337b) {
                int l2 = l(y);
                this.f5336a++;
                T parsePartialFrom = w1Var.parsePartialFrom(this, zVar);
                a(0);
                this.f5336a--;
                this.n = l2;
                Q();
                return parsePartialFrom;
            }
            throw o0.h();
        }

        @Override // c.b.d.k
        public void x(i1.a aVar, z zVar) {
            int y = y();
            if (this.f5336a < this.f5337b) {
                int l2 = l(y);
                this.f5336a++;
                aVar.mergeFrom(this, zVar);
                a(0);
                this.f5336a--;
                this.n = l2;
                Q();
                return;
            }
            throw o0.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
            if (c.b.d.v2.h(r4) < 0) goto L_0x0085;
         */
        @Override // c.b.d.k
        public int y() {
            int i2;
            long j2 = this.j;
            if (this.i != j2) {
                long j3 = j2 + 1;
                byte h2 = v2.h(j2);
                if (h2 >= 0) {
                    this.j = j3;
                    return h2;
                } else if (this.i - j3 >= 9) {
                    long j4 = j3 + 1;
                    int h3 = h2 ^ (v2.h(j3) << 7);
                    if (h3 < 0) {
                        i2 = h3 ^ -128;
                    } else {
                        long j5 = j4 + 1;
                        int h4 = h3 ^ (v2.h(j4) << 14);
                        if (h4 >= 0) {
                            i2 = h4 ^ 16256;
                        } else {
                            j4 = j5 + 1;
                            int h5 = h4 ^ (v2.h(j5) << 21);
                            if (h5 < 0) {
                                i2 = h5 ^ -2080896;
                            } else {
                                j5 = j4 + 1;
                                byte h6 = v2.h(j4);
                                i2 = (h5 ^ (h6 << 28)) ^ 266354560;
                                if (h6 < 0) {
                                    j4 = j5 + 1;
                                    if (v2.h(j5) < 0) {
                                        j5 = j4 + 1;
                                        if (v2.h(j4) < 0) {
                                            j4 = j5 + 1;
                                            if (v2.h(j5) < 0) {
                                                j5 = j4 + 1;
                                                if (v2.h(j4) < 0) {
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
                    this.j = j4;
                    return i2;
                }
            }
            return (int) P();
        }
    }

    public k(a aVar) {
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static k g(InputStream inputStream) {
        if (inputStream != null) {
            return new c(inputStream, 4096, null);
        }
        byte[] bArr = n0.f5440c;
        return i(bArr, 0, bArr.length);
    }

    public static k h(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return j(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), z);
        } else if (byteBuffer.isDirect() && v2.f5900g) {
            return new d(byteBuffer, z, null);
        } else {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.duplicate().get(bArr);
            return j(bArr, 0, remaining, true);
        }
    }

    public static k i(byte[] bArr, int i, int i2) {
        return j(bArr, i, i2, false);
    }

    public static k j(byte[] bArr, int i, int i2, boolean z) {
        b bVar = new b(bArr, i, i2, z, null);
        try {
            bVar.l(i2);
            return bVar;
        } catch (o0 e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int z(int i, InputStream inputStream) {
        if ((i & RecyclerView.a0.FLAG_IGNORE) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i2 |= (read & 127) << i3;
                if ((read & RecyclerView.a0.FLAG_IGNORE) == 0) {
                    return i2;
                }
                i3 += 7;
            } else {
                throw o0.i();
            }
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw o0.i();
            } else if ((read2 & RecyclerView.a0.FLAG_IGNORE) == 0) {
                return i2;
            } else {
                i3 += 7;
            }
        }
        throw o0.e();
    }

    public abstract int A();

    public abstract long B();

    public abstract int C();

    public abstract long D();

    public abstract String E();

    public abstract String F();

    public abstract int G();

    public abstract int H();

    public abstract long I();

    public abstract boolean J(int i);

    public abstract void a(int i);

    public abstract int d();

    public abstract int e();

    public abstract boolean f();

    public abstract void k(int i);

    public abstract int l(int i);

    public abstract boolean m();

    public abstract j n();

    public abstract double o();

    public abstract int p();

    public abstract int q();

    public abstract long r();

    public abstract float s();

    public abstract void t(int i, i1.a aVar, z zVar);

    public abstract int u();

    public abstract long v();

    public abstract <T extends i1> T w(w1<T> w1Var, z zVar);

    public abstract void x(i1.a aVar, z zVar);

    public abstract int y();
}
