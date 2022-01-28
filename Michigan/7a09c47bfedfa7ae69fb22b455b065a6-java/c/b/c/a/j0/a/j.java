package c.b.c.a.j0.a;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public int f4960a;

    /* renamed from: b  reason: collision with root package name */
    public int f4961b = 100;

    /* renamed from: c  reason: collision with root package name */
    public k f4962c;

    public static final class b extends j {

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f4963d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4964e;

        /* renamed from: f  reason: collision with root package name */
        public int f4965f;

        /* renamed from: g  reason: collision with root package name */
        public int f4966g;
        public int h;
        public int i;
        public int j;
        public int k = Integer.MAX_VALUE;

        public b(byte[] bArr, int i2, int i3, boolean z, a aVar) {
            super(null);
            this.f4963d = bArr;
            this.f4965f = i3 + i2;
            this.h = i2;
            this.i = i2;
            this.f4964e = z;
        }

        @Override // c.b.c.a.j0.a.j
        public void a(int i2) {
            if (this.j != i2) {
                throw b0.a();
            }
        }

        @Override // c.b.c.a.j0.a.j
        public int d() {
            return this.h - this.i;
        }

        @Override // c.b.c.a.j0.a.j
        public boolean e() {
            return this.h == this.f4965f;
        }

        @Override // c.b.c.a.j0.a.j
        public int g(int i2) {
            if (i2 >= 0) {
                int d2 = d() + i2;
                int i3 = this.k;
                if (d2 <= i3) {
                    this.k = d2;
                    u();
                    return i3;
                }
                throw b0.h();
            }
            throw b0.f();
        }

        @Override // c.b.c.a.j0.a.j
        public boolean h() {
            return s() != 0;
        }

        @Override // c.b.c.a.j0.a.j
        public double i() {
            return Double.longBitsToDouble(q());
        }

        @Override // c.b.c.a.j0.a.j
        public float j() {
            return Float.intBitsToFloat(p());
        }

        @Override // c.b.c.a.j0.a.j
        public int k() {
            return j.b(r());
        }

        @Override // c.b.c.a.j0.a.j
        public long l() {
            return j.c(s());
        }

        @Override // c.b.c.a.j0.a.j
        public int m() {
            if (e()) {
                this.j = 0;
                return 0;
            }
            int r = r();
            this.j = r;
            if ((r >>> 3) != 0) {
                return r;
            }
            throw b0.b();
        }

        @Override // c.b.c.a.j0.a.j
        public boolean n(int i2) {
            int i3;
            int m;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 != 0) {
                if (i4 == 1) {
                    i3 = 8;
                } else if (i4 == 2) {
                    i3 = r();
                } else if (i4 == 3) {
                    do {
                        m = m();
                        if (m == 0) {
                            break;
                        }
                    } while (n(m));
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                } else if (i4 == 4) {
                    return false;
                } else {
                    if (i4 == 5) {
                        v(4);
                        return true;
                    }
                    throw b0.d();
                }
                v(i3);
                return true;
            }
            if (this.f4965f - this.h >= 10) {
                while (i5 < 10) {
                    byte[] bArr = this.f4963d;
                    int i6 = this.h;
                    this.h = i6 + 1;
                    if (bArr[i6] < 0) {
                        i5++;
                    }
                }
                throw b0.e();
            }
            while (i5 < 10) {
                if (o() < 0) {
                    i5++;
                }
            }
            throw b0.e();
            return true;
        }

        public byte o() {
            int i2 = this.h;
            if (i2 != this.f4965f) {
                byte[] bArr = this.f4963d;
                this.h = i2 + 1;
                return bArr[i2];
            }
            throw b0.h();
        }

        public int p() {
            int i2 = this.h;
            if (this.f4965f - i2 >= 4) {
                byte[] bArr = this.f4963d;
                this.h = i2 + 4;
                return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
            }
            throw b0.h();
        }

        public long q() {
            int i2 = this.h;
            if (this.f4965f - i2 >= 8) {
                byte[] bArr = this.f4963d;
                this.h = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw b0.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        public int r() {
            int i2;
            int i3 = this.h;
            int i4 = this.f4965f;
            if (i4 != i3) {
                byte[] bArr = this.f4963d;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.h = i5;
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
                    this.h = i6;
                    return i2;
                }
            }
            return (int) t();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        public long s() {
            long j2;
            long j3;
            long j4;
            int i2;
            int i3 = this.h;
            int i4 = this.f4965f;
            if (i4 != i3) {
                byte[] bArr = this.f4963d;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.h = i5;
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
                        this.h = i6;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.h = i6;
                    return j2;
                }
            }
            return t();
        }

        public long t() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte o = o();
                j2 |= ((long) (o & Byte.MAX_VALUE)) << i2;
                if ((o & 128) == 0) {
                    return j2;
                }
            }
            throw b0.e();
        }

        public final void u() {
            int i2 = this.f4965f + this.f4966g;
            this.f4965f = i2;
            int i3 = i2 - this.i;
            int i4 = this.k;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.f4966g = i5;
                this.f4965f = i2 - i5;
                return;
            }
            this.f4966g = 0;
        }

        public void v(int i2) {
            if (i2 >= 0) {
                int i3 = this.f4965f;
                int i4 = this.h;
                if (i2 <= i3 - i4) {
                    this.h = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw b0.f();
            }
            throw b0.h();
        }
    }

    public j(a aVar) {
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static j f(byte[] bArr, int i, int i2, boolean z) {
        b bVar = new b(bArr, i, i2, z, null);
        try {
            bVar.g(i2);
            return bVar;
        } catch (b0 e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract void a(int i);

    public abstract int d();

    public abstract boolean e();

    public abstract int g(int i);

    public abstract boolean h();

    public abstract double i();

    public abstract float j();

    public abstract int k();

    public abstract long l();

    public abstract int m();

    public abstract boolean n(int i);
}
