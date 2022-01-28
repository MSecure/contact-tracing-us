package f.b.g;

import f.b.g.d0;
import f.b.g.j;
import f.b.g.m0;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public abstract class g implements h1 {

    public static final class b extends g {
        public final boolean a;
        public final byte[] b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f3610d;

        /* renamed from: e  reason: collision with root package name */
        public int f3611e;

        /* renamed from: f  reason: collision with root package name */
        public int f3612f;

        public b(ByteBuffer byteBuffer, boolean z) {
            super(null);
            this.a = z;
            this.b = byteBuffer.array();
            this.c = byteBuffer.position() + byteBuffer.arrayOffset();
            this.f3610d = byteBuffer.limit() + byteBuffer.arrayOffset();
        }

        @Override // f.b.g.h1
        public void A(List<Boolean> list) {
            int i2;
            int i3;
            int i4;
            if (list instanceof h) {
                h hVar = (h) list;
                int i5 = this.f3611e & 7;
                if (i5 == 0) {
                    do {
                        hVar.i(J());
                        if (!Q()) {
                            i4 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i4;
                    return;
                } else if (i5 == 2) {
                    i2 = this.c + b0();
                    while (this.c < i2) {
                        hVar.i(b0() != 0);
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 0) {
                    do {
                        list.add(Boolean.valueOf(J()));
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                    return;
                } else if (i6 == 2) {
                    i2 = this.c + b0();
                    while (this.c < i2) {
                        list.add(Boolean.valueOf(b0() != 0));
                    }
                } else {
                    throw d0.d();
                }
            }
            f0(i2);
        }

        @Override // f.b.g.h1
        public void B(List<Long> list) {
            int i2;
            int i3;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i4 = this.f3611e & 7;
                if (i4 == 1) {
                    do {
                        k0Var.i(O());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int b0 = b0();
                    j0(b0);
                    int i5 = this.c + b0;
                    while (this.c < i5) {
                        k0Var.i(X());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 1) {
                    do {
                        list.add(Long.valueOf(O()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else if (i6 == 2) {
                    int b02 = b0();
                    j0(b02);
                    int i7 = this.c + b02;
                    while (this.c < i7) {
                        list.add(Long.valueOf(X()));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.g.h1
        public String C() {
            return Z(false);
        }

        @Override // f.b.g.h1
        public long D() {
            g0(0);
            return c0();
        }

        @Override // f.b.g.h1
        public String E() {
            return Z(true);
        }

        @Override // f.b.g.h1
        public int F() {
            g0(5);
            return U();
        }

        @Override // f.b.g.h1
        public void G(List<Long> list) {
            int i2;
            int i3;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i4 = this.f3611e & 7;
                if (i4 == 1) {
                    do {
                        k0Var.i(n());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int b0 = b0();
                    j0(b0);
                    int i5 = this.c + b0;
                    while (this.c < i5) {
                        k0Var.i(X());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 1) {
                    do {
                        list.add(Long.valueOf(n()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else if (i6 == 2) {
                    int b02 = b0();
                    j0(b02);
                    int i7 = this.c + b02;
                    while (this.c < i7) {
                        list.add(Long.valueOf(X()));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.g.h1
        public void H(List<Integer> list) {
            int i2;
            int i3;
            int i4;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i5 = this.f3611e & 7;
                if (i5 == 0) {
                    do {
                        b0Var.i(j());
                        if (!Q()) {
                            i4 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i4;
                    return;
                } else if (i5 == 2) {
                    i2 = this.c + b0();
                    while (this.c < i2) {
                        b0Var.i(b0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 0) {
                    do {
                        list.add(Integer.valueOf(j()));
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                    return;
                } else if (i6 == 2) {
                    i2 = this.c + b0();
                    while (this.c < i2) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw d0.d();
                }
            }
            f0(i2);
        }

        @Override // f.b.g.h1
        public <T> T I(Class<T> cls, r rVar) {
            g0(3);
            return (T) T(e1.c.a(cls), rVar);
        }

        @Override // f.b.g.h1
        public boolean J() {
            g0(0);
            return b0() != 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.g.h1
        public <T> void K(List<T> list, j1<T> j1Var, r rVar) {
            int i2;
            int i3 = this.f3611e;
            if ((i3 & 7) == 2) {
                do {
                    list.add(Y(j1Var, rVar));
                    if (!Q()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (b0() == i3);
                this.c = i2;
                return;
            }
            throw d0.d();
        }

        @Override // f.b.g.h1
        public void L(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3611e & 7;
                if (i4 == 0) {
                    do {
                        b0Var.i(g());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        b0Var.i(b0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i5 = this.f3611e & 7;
                if (i5 == 0) {
                    do {
                        list.add(Integer.valueOf(g()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.g.h1
        public int M() {
            if (Q()) {
                return Integer.MAX_VALUE;
            }
            int b0 = b0();
            this.f3611e = b0;
            if (b0 == this.f3612f) {
                return Integer.MAX_VALUE;
            }
            return b0 >>> 3;
        }

        @Override // f.b.g.h1
        public void N(List<String> list) {
            a0(list, false);
        }

        @Override // f.b.g.h1
        public long O() {
            g0(1);
            return W();
        }

        @Override // f.b.g.h1
        public <T> T P(j1<T> j1Var, r rVar) {
            g0(2);
            return (T) Y(j1Var, rVar);
        }

        public final boolean Q() {
            return this.c == this.f3610d;
        }

        public final byte R() {
            int i2 = this.c;
            if (i2 != this.f3610d) {
                byte[] bArr = this.b;
                this.c = i2 + 1;
                return bArr[i2];
            }
            throw d0.h();
        }

        public final Object S(y1 y1Var, Class<?> cls, r rVar) {
            switch (y1Var.ordinal()) {
                case 0:
                    return Double.valueOf(readDouble());
                case 1:
                    return Float.valueOf(readFloat());
                case 2:
                    return Long.valueOf(D());
                case 3:
                    return Long.valueOf(l());
                case 4:
                    return Integer.valueOf(j());
                case 5:
                    return Long.valueOf(n());
                case 6:
                    return Integer.valueOf(F());
                case 7:
                    return Boolean.valueOf(J());
                case 8:
                    return Z(true);
                case 9:
                default:
                    throw new RuntimeException("unsupported field type.");
                case 10:
                    return y(cls, rVar);
                case 11:
                    return e();
                case 12:
                    return Integer.valueOf(i());
                case 13:
                    return Integer.valueOf(g());
                case 14:
                    return Integer.valueOf(u());
                case 15:
                    return Long.valueOf(O());
                case 16:
                    return Integer.valueOf(q());
                case 17:
                    return Long.valueOf(t());
            }
        }

        public final <T> T T(j1<T> j1Var, r rVar) {
            int i2 = this.f3612f;
            this.f3612f = ((this.f3611e >>> 3) << 3) | 4;
            try {
                T g2 = j1Var.g();
                j1Var.c(g2, this, rVar);
                j1Var.i(g2);
                if (this.f3611e == this.f3612f) {
                    return g2;
                }
                throw d0.g();
            } finally {
                this.f3612f = i2;
            }
        }

        public final int U() {
            e0(4);
            return V();
        }

        public final int V() {
            int i2 = this.c;
            byte[] bArr = this.b;
            this.c = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public final long W() {
            e0(8);
            return X();
        }

        public final long X() {
            int i2 = this.c;
            byte[] bArr = this.b;
            this.c = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        public final <T> T Y(j1<T> j1Var, r rVar) {
            int b0 = b0();
            e0(b0);
            int i2 = this.f3610d;
            int i3 = this.c + b0;
            this.f3610d = i3;
            try {
                T g2 = j1Var.g();
                j1Var.c(g2, this, rVar);
                j1Var.i(g2);
                if (this.c == i3) {
                    return g2;
                }
                throw d0.g();
            } finally {
                this.f3610d = i2;
            }
        }

        public String Z(boolean z) {
            g0(2);
            int b0 = b0();
            if (b0 == 0) {
                return "";
            }
            e0(b0);
            if (z) {
                byte[] bArr = this.b;
                int i2 = this.c;
                if (!w1.h(bArr, i2, i2 + b0)) {
                    throw d0.c();
                }
            }
            String str = new String(this.b, this.c, b0, c0.a);
            this.c += b0;
            return str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.g.h1
        public <K, V> void a(Map<K, V> map, m0.a<K, V> aVar, r rVar) {
            g0(2);
            int b0 = b0();
            e0(b0);
            int i2 = this.f3610d;
            this.f3610d = this.c + b0;
            try {
                Object obj = aVar.b;
                Object obj2 = aVar.f3671d;
                while (true) {
                    int M = M();
                    if (M == Integer.MAX_VALUE) {
                        map.put(obj, obj2);
                        return;
                    } else if (M == 1) {
                        obj = S(aVar.a, null, null);
                    } else if (M != 2) {
                        try {
                            if (!p()) {
                                throw new d0("Unable to parse map entry.");
                            }
                        } catch (d0.a unused) {
                            if (!p()) {
                                throw new d0("Unable to parse map entry.");
                            }
                        }
                    } else {
                        obj2 = S(aVar.c, aVar.f3671d.getClass(), rVar);
                    }
                }
            } finally {
                this.f3610d = i2;
            }
        }

        public void a0(List<String> list, boolean z) {
            int i2;
            int i3;
            if ((this.f3611e & 7) != 2) {
                throw d0.d();
            } else if (!(list instanceof i0) || z) {
                do {
                    list.add(Z(z));
                    if (!Q()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (b0() == this.f3611e);
                this.c = i2;
            } else {
                i0 i0Var = (i0) list;
                do {
                    i0Var.e(e());
                    if (!Q()) {
                        i3 = this.c;
                    } else {
                        return;
                    }
                } while (b0() == this.f3611e);
                this.c = i3;
            }
        }

        @Override // f.b.g.h1
        public void b(List<Long> list) {
            int i2;
            int i3;
            int i4;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i5 = this.f3611e & 7;
                if (i5 == 0) {
                    do {
                        k0Var.i(l());
                        if (!Q()) {
                            i4 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i4;
                    return;
                } else if (i5 == 2) {
                    i2 = this.c + b0();
                    while (this.c < i2) {
                        k0Var.i(c0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 0) {
                    do {
                        list.add(Long.valueOf(l()));
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                    return;
                } else if (i6 == 2) {
                    i2 = this.c + b0();
                    while (this.c < i2) {
                        list.add(Long.valueOf(c0()));
                    }
                } else {
                    throw d0.d();
                }
            }
            f0(i2);
        }

        public final int b0() {
            int i2;
            int i3 = this.c;
            int i4 = this.f3610d;
            if (i4 != i3) {
                byte[] bArr = this.b;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.c = i5;
                    return b2;
                } else if (i4 - i5 < 9) {
                    return (int) d0();
                } else {
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
                                                    if (bArr[i8] < 0) {
                                                        throw d0.e();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i6 = i8;
                    }
                    this.c = i6;
                    return i2;
                }
            } else {
                throw d0.h();
            }
        }

        @Override // f.b.g.h1
        public void c(List<String> list) {
            a0(list, true);
        }

        public long c0() {
            long j2;
            long j3;
            long j4;
            int i2;
            int i3 = this.c;
            int i4 = this.f3610d;
            if (i4 != i3) {
                byte[] bArr = this.b;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.c = i5;
                    return (long) b2;
                } else if (i4 - i5 < 9) {
                    return d0();
                } else {
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
                                                if (j8 < 0) {
                                                    i6 = i12 + 1;
                                                    if (((long) bArr[i12]) < 0) {
                                                        throw d0.e();
                                                    }
                                                } else {
                                                    i6 = i12;
                                                }
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
                        this.c = i6;
                        return j2;
                    }
                    j2 = (long) i2;
                    this.c = i6;
                    return j2;
                }
            } else {
                throw d0.h();
            }
        }

        @Override // f.b.g.h1
        public <T> T d(j1<T> j1Var, r rVar) {
            g0(3);
            return (T) T(j1Var, rVar);
        }

        public final long d0() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte R = R();
                j2 |= ((long) (R & Byte.MAX_VALUE)) << i2;
                if ((R & 128) == 0) {
                    return j2;
                }
            }
            throw d0.e();
        }

        @Override // f.b.g.h1
        public j e() {
            j jVar;
            g0(2);
            int b0 = b0();
            if (b0 == 0) {
                return j.c;
            }
            e0(b0);
            if (this.a) {
                byte[] bArr = this.b;
                int i2 = this.c;
                j jVar2 = j.c;
                jVar = new j.d(bArr, i2, b0);
            } else {
                jVar = j.m(this.b, this.c, b0);
            }
            this.c += b0;
            return jVar;
        }

        public final void e0(int i2) {
            if (i2 < 0 || i2 > this.f3610d - this.c) {
                throw d0.h();
            }
        }

        @Override // f.b.g.h1
        public void f(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3611e & 7;
                if (i4 == 0) {
                    do {
                        b0Var.i(q());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        b0Var.i(k.b(b0()));
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i5 = this.f3611e & 7;
                if (i5 == 0) {
                    do {
                        list.add(Integer.valueOf(q()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Integer.valueOf(k.b(b0())));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        public final void f0(int i2) {
            if (this.c != i2) {
                throw d0.h();
            }
        }

        @Override // f.b.g.h1
        public int g() {
            g0(0);
            return b0();
        }

        public final void g0(int i2) {
            if ((this.f3611e & 7) != i2) {
                throw d0.d();
            }
        }

        @Override // f.b.g.h1
        public void h(List<Float> list) {
            int i2;
            int i3;
            if (list instanceof x) {
                x xVar = (x) list;
                int i4 = this.f3611e & 7;
                if (i4 == 2) {
                    int b0 = b0();
                    i0(b0);
                    int i5 = this.c + b0;
                    while (this.c < i5) {
                        xVar.i(Float.intBitsToFloat(V()));
                    }
                } else if (i4 == 5) {
                    do {
                        xVar.i(readFloat());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 2) {
                    int b02 = b0();
                    i0(b02);
                    int i7 = this.c + b02;
                    while (this.c < i7) {
                        list.add(Float.valueOf(Float.intBitsToFloat(V())));
                    }
                } else if (i6 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else {
                    throw d0.d();
                }
            }
        }

        public final void h0(int i2) {
            e0(i2);
            this.c += i2;
        }

        @Override // f.b.g.h1
        public int i() {
            g0(0);
            return b0();
        }

        public final void i0(int i2) {
            e0(i2);
            if ((i2 & 3) != 0) {
                throw d0.g();
            }
        }

        @Override // f.b.g.h1
        public int j() {
            g0(0);
            return b0();
        }

        public final void j0(int i2) {
            e0(i2);
            if ((i2 & 7) != 0) {
                throw d0.g();
            }
        }

        @Override // f.b.g.h1
        public int k() {
            return this.f3611e;
        }

        @Override // f.b.g.h1
        public long l() {
            g0(0);
            return c0();
        }

        @Override // f.b.g.h1
        public void m(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3611e & 7;
                if (i4 == 2) {
                    int b0 = b0();
                    i0(b0);
                    int i5 = this.c + b0;
                    while (this.c < i5) {
                        b0Var.i(V());
                    }
                } else if (i4 == 5) {
                    do {
                        b0Var.i(F());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 2) {
                    int b02 = b0();
                    i0(b02);
                    int i7 = this.c + b02;
                    while (this.c < i7) {
                        list.add(Integer.valueOf(V()));
                    }
                } else if (i6 == 5) {
                    do {
                        list.add(Integer.valueOf(F()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.g.h1
        public long n() {
            g0(1);
            return W();
        }

        @Override // f.b.g.h1
        public void o(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3611e & 7;
                if (i4 == 2) {
                    int b0 = b0();
                    i0(b0);
                    int i5 = this.c + b0;
                    while (this.c < i5) {
                        b0Var.i(V());
                    }
                } else if (i4 == 5) {
                    do {
                        b0Var.i(u());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 2) {
                    int b02 = b0();
                    i0(b02);
                    int i7 = this.c + b02;
                    while (this.c < i7) {
                        list.add(Integer.valueOf(V()));
                    }
                } else if (i6 == 5) {
                    do {
                        list.add(Integer.valueOf(u()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else {
                    throw d0.d();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
        @Override // f.b.g.h1
        public boolean p() {
            int i2;
            int i3;
            int i4;
            if (Q() || (i2 = this.f3611e) == (i3 = this.f3612f)) {
                return false;
            }
            int i5 = i2 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    i4 = 8;
                } else if (i5 == 2) {
                    i4 = b0();
                } else if (i5 == 3) {
                    this.f3612f = ((i2 >>> 3) << 3) | 4;
                    while (M() != Integer.MAX_VALUE && p()) {
                        while (M() != Integer.MAX_VALUE) {
                            while (M() != Integer.MAX_VALUE) {
                            }
                        }
                    }
                    if (this.f3611e == this.f3612f) {
                        this.f3612f = i3;
                        return true;
                    }
                    throw d0.g();
                } else if (i5 == 5) {
                    h0(4);
                    return true;
                } else {
                    throw d0.d();
                }
                h0(i4);
                return true;
            }
            int i6 = this.f3610d;
            int i7 = this.c;
            if (i6 - i7 >= 10) {
                byte[] bArr = this.b;
                int i8 = 0;
                while (true) {
                    if (i8 >= 10) {
                        break;
                    }
                    int i9 = i7 + 1;
                    if (bArr[i7] >= 0) {
                        this.c = i9;
                        break;
                    }
                    i8++;
                    i7 = i9;
                }
                return true;
            }
            for (int i10 = 0; i10 < 10; i10++) {
                if (R() >= 0) {
                    return true;
                }
            }
            throw d0.e();
        }

        @Override // f.b.g.h1
        public int q() {
            g0(0);
            return k.b(b0());
        }

        @Override // f.b.g.h1
        public void r(List<Long> list) {
            int i2;
            int i3;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i4 = this.f3611e & 7;
                if (i4 == 0) {
                    do {
                        k0Var.i(t());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        k0Var.i(k.c(c0()));
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i5 = this.f3611e & 7;
                if (i5 == 0) {
                    do {
                        list.add(Long.valueOf(t()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Long.valueOf(k.c(c0())));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.g.h1
        public double readDouble() {
            g0(1);
            return Double.longBitsToDouble(W());
        }

        @Override // f.b.g.h1
        public float readFloat() {
            g0(5);
            return Float.intBitsToFloat(U());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.g.h1
        public <T> void s(List<T> list, j1<T> j1Var, r rVar) {
            int i2;
            int i3 = this.f3611e;
            if ((i3 & 7) == 3) {
                do {
                    list.add(T(j1Var, rVar));
                    if (!Q()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (b0() == i3);
                this.c = i2;
                return;
            }
            throw d0.d();
        }

        @Override // f.b.g.h1
        public long t() {
            g0(0);
            return k.c(c0());
        }

        @Override // f.b.g.h1
        public int u() {
            g0(5);
            return U();
        }

        @Override // f.b.g.h1
        public void v(List<j> list) {
            int i2;
            if ((this.f3611e & 7) == 2) {
                do {
                    list.add(e());
                    if (!Q()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (b0() == this.f3611e);
                this.c = i2;
                return;
            }
            throw d0.d();
        }

        @Override // f.b.g.h1
        public void w(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3611e & 7;
                if (i4 == 0) {
                    do {
                        b0Var.i(i());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int b0 = this.c + b0();
                    while (this.c < b0) {
                        b0Var.i(b0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i5 = this.f3611e & 7;
                if (i5 == 0) {
                    do {
                        list.add(Integer.valueOf(i()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int b02 = this.c + b0();
                    while (this.c < b02) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.g.h1
        public void x(List<Double> list) {
            int i2;
            int i3;
            if (list instanceof o) {
                o oVar = (o) list;
                int i4 = this.f3611e & 7;
                if (i4 == 1) {
                    do {
                        oVar.i(readDouble());
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int b0 = b0();
                    j0(b0);
                    int i5 = this.c + b0;
                    while (this.c < i5) {
                        oVar.i(Double.longBitsToDouble(X()));
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!Q()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i2;
                } else if (i6 == 2) {
                    int b02 = b0();
                    j0(b02);
                    int i7 = this.c + b02;
                    while (this.c < i7) {
                        list.add(Double.valueOf(Double.longBitsToDouble(X())));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.g.h1
        public <T> T y(Class<T> cls, r rVar) {
            g0(2);
            return (T) Y(e1.c.a(cls), rVar);
        }

        @Override // f.b.g.h1
        public void z(List<Long> list) {
            int i2;
            int i3;
            int i4;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i5 = this.f3611e & 7;
                if (i5 == 0) {
                    do {
                        k0Var.i(D());
                        if (!Q()) {
                            i4 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i4;
                    return;
                } else if (i5 == 2) {
                    i2 = this.c + b0();
                    while (this.c < i2) {
                        k0Var.i(c0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3611e & 7;
                if (i6 == 0) {
                    do {
                        list.add(Long.valueOf(D()));
                        if (!Q()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f3611e);
                    this.c = i3;
                    return;
                } else if (i6 == 2) {
                    i2 = this.c + b0();
                    while (this.c < i2) {
                        list.add(Long.valueOf(c0()));
                    }
                } else {
                    throw d0.d();
                }
            }
            f0(i2);
        }
    }

    public g(a aVar) {
    }
}
