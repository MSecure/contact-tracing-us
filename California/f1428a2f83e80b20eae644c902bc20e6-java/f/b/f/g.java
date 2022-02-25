package f.b.f;

import f.b.f.d0;
import f.b.f.j;
import f.b.f.m0;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public abstract class g implements h1 {

    public static final class b extends g {
        public final boolean a;
        public final byte[] b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f3288d;

        /* renamed from: e  reason: collision with root package name */
        public int f3289e;

        /* renamed from: f  reason: collision with root package name */
        public int f3290f;

        public b(ByteBuffer byteBuffer, boolean z) {
            super(null);
            this.a = z;
            this.b = byteBuffer.array();
            this.c = byteBuffer.position() + byteBuffer.arrayOffset();
            this.f3288d = byteBuffer.limit() + byteBuffer.arrayOffset();
        }

        @Override // f.b.f.h1
        public <T> T A(Class<T> cls, r rVar) {
            i0(2);
            return (T) a0(e1.c.a(cls), rVar);
        }

        @Override // f.b.f.h1
        public void B(List<Long> list) {
            int i2;
            int i3;
            int i4;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i5 = this.f3289e & 7;
                if (i5 == 0) {
                    do {
                        k0Var.i(F());
                        if (!S()) {
                            i4 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i4;
                    return;
                } else if (i5 == 2) {
                    i2 = this.c + d0();
                    while (this.c < i2) {
                        k0Var.i(e0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 0) {
                    do {
                        list.add(Long.valueOf(F()));
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                    return;
                } else if (i6 == 2) {
                    i2 = this.c + d0();
                    while (this.c < i2) {
                        list.add(Long.valueOf(e0()));
                    }
                } else {
                    throw d0.d();
                }
            }
            h0(i2);
        }

        @Override // f.b.f.h1
        public void C(List<Boolean> list) {
            int i2;
            int i3;
            int i4;
            if (list instanceof h) {
                h hVar = (h) list;
                int i5 = this.f3289e & 7;
                if (i5 == 0) {
                    do {
                        hVar.i(L());
                        if (!S()) {
                            i4 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i4;
                    return;
                } else if (i5 == 2) {
                    i2 = this.c + d0();
                    while (this.c < i2) {
                        hVar.i(d0() != 0);
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 0) {
                    do {
                        list.add(Boolean.valueOf(L()));
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                    return;
                } else if (i6 == 2) {
                    i2 = this.c + d0();
                    while (this.c < i2) {
                        list.add(Boolean.valueOf(d0() != 0));
                    }
                } else {
                    throw d0.d();
                }
            }
            h0(i2);
        }

        @Override // f.b.f.h1
        public void D(List<Long> list) {
            int i2;
            int i3;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i4 = this.f3289e & 7;
                if (i4 == 1) {
                    do {
                        k0Var.i(Q());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int d0 = d0();
                    l0(d0);
                    int i5 = this.c + d0;
                    while (this.c < i5) {
                        k0Var.i(Z());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 1) {
                    do {
                        list.add(Long.valueOf(Q()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else if (i6 == 2) {
                    int d02 = d0();
                    l0(d02);
                    int i7 = this.c + d02;
                    while (this.c < i7) {
                        list.add(Long.valueOf(Z()));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.f.h1
        public String E() {
            return b0(false);
        }

        @Override // f.b.f.h1
        public long F() {
            i0(0);
            return e0();
        }

        @Override // f.b.f.h1
        public String G() {
            return b0(true);
        }

        @Override // f.b.f.h1
        public int H() {
            i0(5);
            return W();
        }

        @Override // f.b.f.h1
        public void I(List<Long> list) {
            int i2;
            int i3;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i4 = this.f3289e & 7;
                if (i4 == 1) {
                    do {
                        k0Var.i(n());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int d0 = d0();
                    l0(d0);
                    int i5 = this.c + d0;
                    while (this.c < i5) {
                        k0Var.i(Z());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 1) {
                    do {
                        list.add(Long.valueOf(n()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else if (i6 == 2) {
                    int d02 = d0();
                    l0(d02);
                    int i7 = this.c + d02;
                    while (this.c < i7) {
                        list.add(Long.valueOf(Z()));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.f.h1
        public void J(List<Integer> list) {
            int i2;
            int i3;
            int i4;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i5 = this.f3289e & 7;
                if (i5 == 0) {
                    do {
                        b0Var.i(j());
                        if (!S()) {
                            i4 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i4;
                    return;
                } else if (i5 == 2) {
                    i2 = this.c + d0();
                    while (this.c < i2) {
                        b0Var.i(d0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 0) {
                    do {
                        list.add(Integer.valueOf(j()));
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                    return;
                } else if (i6 == 2) {
                    i2 = this.c + d0();
                    while (this.c < i2) {
                        list.add(Integer.valueOf(d0()));
                    }
                } else {
                    throw d0.d();
                }
            }
            h0(i2);
        }

        @Override // f.b.f.h1
        public <T> T K(Class<T> cls, r rVar) {
            i0(3);
            return (T) V(e1.c.a(cls), rVar);
        }

        @Override // f.b.f.h1
        public boolean L() {
            i0(0);
            return d0() != 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.f.h1
        public <T> void M(List<T> list, j1<T> j1Var, r rVar) {
            int i2;
            int i3 = this.f3289e;
            if ((i3 & 7) == 2) {
                do {
                    list.add(a0(j1Var, rVar));
                    if (!S()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (d0() == i3);
                this.c = i2;
                return;
            }
            throw d0.d();
        }

        @Override // f.b.f.h1
        public void N(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3289e & 7;
                if (i4 == 0) {
                    do {
                        b0Var.i(g());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int d0 = this.c + d0();
                    while (this.c < d0) {
                        b0Var.i(d0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i5 = this.f3289e & 7;
                if (i5 == 0) {
                    do {
                        list.add(Integer.valueOf(g()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int d02 = this.c + d0();
                    while (this.c < d02) {
                        list.add(Integer.valueOf(d0()));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.f.h1
        public int O() {
            if (S()) {
                return Integer.MAX_VALUE;
            }
            int d0 = d0();
            this.f3289e = d0;
            if (d0 == this.f3290f) {
                return Integer.MAX_VALUE;
            }
            return d0 >>> 3;
        }

        @Override // f.b.f.h1
        public void P(List<String> list) {
            c0(list, false);
        }

        @Override // f.b.f.h1
        public long Q() {
            i0(1);
            return Y();
        }

        @Override // f.b.f.h1
        public <T> T R(j1<T> j1Var, r rVar) {
            i0(2);
            return (T) a0(j1Var, rVar);
        }

        public final boolean S() {
            return this.c == this.f3288d;
        }

        public final byte T() {
            int i2 = this.c;
            if (i2 != this.f3288d) {
                byte[] bArr = this.b;
                this.c = i2 + 1;
                return bArr[i2];
            }
            throw d0.h();
        }

        public final Object U(y1 y1Var, Class<?> cls, r rVar) {
            switch (y1Var.ordinal()) {
                case 0:
                    return Double.valueOf(o());
                case 1:
                    return Float.valueOf(u());
                case 2:
                    return Long.valueOf(F());
                case 3:
                    return Long.valueOf(l());
                case 4:
                    return Integer.valueOf(j());
                case 5:
                    return Long.valueOf(n());
                case 6:
                    return Integer.valueOf(H());
                case 7:
                    return Boolean.valueOf(L());
                case 8:
                    return b0(true);
                case 9:
                default:
                    throw new RuntimeException("unsupported field type.");
                case 10:
                    return A(cls, rVar);
                case 11:
                    return e();
                case 12:
                    return Integer.valueOf(i());
                case 13:
                    return Integer.valueOf(g());
                case 14:
                    return Integer.valueOf(w());
                case 15:
                    return Long.valueOf(Q());
                case 16:
                    return Integer.valueOf(r());
                case 17:
                    return Long.valueOf(v());
            }
        }

        public final <T> T V(j1<T> j1Var, r rVar) {
            int i2 = this.f3290f;
            this.f3290f = ((this.f3289e >>> 3) << 3) | 4;
            try {
                T g2 = j1Var.g();
                j1Var.c(g2, this, rVar);
                j1Var.i(g2);
                if (this.f3289e == this.f3290f) {
                    return g2;
                }
                throw d0.g();
            } finally {
                this.f3290f = i2;
            }
        }

        public final int W() {
            g0(4);
            return X();
        }

        public final int X() {
            int i2 = this.c;
            byte[] bArr = this.b;
            this.c = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public final long Y() {
            g0(8);
            return Z();
        }

        public final long Z() {
            int i2 = this.c;
            byte[] bArr = this.b;
            this.c = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.f.h1
        public <K, V> void a(Map<K, V> map, m0.a<K, V> aVar, r rVar) {
            i0(2);
            int d0 = d0();
            g0(d0);
            int i2 = this.f3288d;
            this.f3288d = this.c + d0;
            try {
                Object obj = aVar.b;
                Object obj2 = aVar.f3349d;
                while (true) {
                    int O = O();
                    if (O == Integer.MAX_VALUE) {
                        map.put(obj, obj2);
                        return;
                    } else if (O == 1) {
                        obj = U(aVar.a, null, null);
                    } else if (O != 2) {
                        try {
                            if (!q()) {
                                throw new d0("Unable to parse map entry.");
                            }
                        } catch (d0.a unused) {
                            if (!q()) {
                                throw new d0("Unable to parse map entry.");
                            }
                        }
                    } else {
                        obj2 = U(aVar.c, aVar.f3349d.getClass(), rVar);
                    }
                }
            } finally {
                this.f3288d = i2;
            }
        }

        public final <T> T a0(j1<T> j1Var, r rVar) {
            int d0 = d0();
            g0(d0);
            int i2 = this.f3288d;
            int i3 = this.c + d0;
            this.f3288d = i3;
            try {
                T g2 = j1Var.g();
                j1Var.c(g2, this, rVar);
                j1Var.i(g2);
                if (this.c == i3) {
                    return g2;
                }
                throw d0.g();
            } finally {
                this.f3288d = i2;
            }
        }

        @Override // f.b.f.h1
        public void b(List<Long> list) {
            int i2;
            int i3;
            int i4;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i5 = this.f3289e & 7;
                if (i5 == 0) {
                    do {
                        k0Var.i(l());
                        if (!S()) {
                            i4 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i4;
                    return;
                } else if (i5 == 2) {
                    i2 = this.c + d0();
                    while (this.c < i2) {
                        k0Var.i(e0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 0) {
                    do {
                        list.add(Long.valueOf(l()));
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                    return;
                } else if (i6 == 2) {
                    i2 = this.c + d0();
                    while (this.c < i2) {
                        list.add(Long.valueOf(e0()));
                    }
                } else {
                    throw d0.d();
                }
            }
            h0(i2);
        }

        public String b0(boolean z) {
            i0(2);
            int d0 = d0();
            if (d0 == 0) {
                return "";
            }
            g0(d0);
            if (z) {
                byte[] bArr = this.b;
                int i2 = this.c;
                if (!w1.h(bArr, i2, i2 + d0)) {
                    throw d0.c();
                }
            }
            String str = new String(this.b, this.c, d0, c0.a);
            this.c += d0;
            return str;
        }

        @Override // f.b.f.h1
        public void c(List<String> list) {
            c0(list, true);
        }

        public void c0(List<String> list, boolean z) {
            int i2;
            int i3;
            if ((this.f3289e & 7) != 2) {
                throw d0.d();
            } else if (!(list instanceof i0) || z) {
                do {
                    list.add(b0(z));
                    if (!S()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (d0() == this.f3289e);
                this.c = i2;
            } else {
                i0 i0Var = (i0) list;
                do {
                    i0Var.e(e());
                    if (!S()) {
                        i3 = this.c;
                    } else {
                        return;
                    }
                } while (d0() == this.f3289e);
                this.c = i3;
            }
        }

        @Override // f.b.f.h1
        public <T> T d(j1<T> j1Var, r rVar) {
            i0(3);
            return (T) V(j1Var, rVar);
        }

        public final int d0() {
            int i2;
            int i3 = this.c;
            int i4 = this.f3288d;
            if (i4 != i3) {
                byte[] bArr = this.b;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.c = i5;
                    return b2;
                } else if (i4 - i5 < 9) {
                    return (int) f0();
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

        @Override // f.b.f.h1
        public j e() {
            j jVar;
            i0(2);
            int d0 = d0();
            if (d0 == 0) {
                return j.c;
            }
            g0(d0);
            if (this.a) {
                byte[] bArr = this.b;
                int i2 = this.c;
                j jVar2 = j.c;
                jVar = new j.d(bArr, i2, d0);
            } else {
                jVar = j.m(this.b, this.c, d0);
            }
            this.c += d0;
            return jVar;
        }

        public long e0() {
            long j2;
            long j3;
            long j4;
            int i2;
            int i3 = this.c;
            int i4 = this.f3288d;
            if (i4 != i3) {
                byte[] bArr = this.b;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.c = i5;
                    return (long) b2;
                } else if (i4 - i5 < 9) {
                    return f0();
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

        @Override // f.b.f.h1
        public void f(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3289e & 7;
                if (i4 == 0) {
                    do {
                        b0Var.i(r());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int d0 = this.c + d0();
                    while (this.c < d0) {
                        b0Var.i(k.b(d0()));
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i5 = this.f3289e & 7;
                if (i5 == 0) {
                    do {
                        list.add(Integer.valueOf(r()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int d02 = this.c + d0();
                    while (this.c < d02) {
                        list.add(Integer.valueOf(k.b(d0())));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        public final long f0() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte T = T();
                j2 |= ((long) (T & Byte.MAX_VALUE)) << i2;
                if ((T & 128) == 0) {
                    return j2;
                }
            }
            throw d0.e();
        }

        @Override // f.b.f.h1
        public int g() {
            i0(0);
            return d0();
        }

        public final void g0(int i2) {
            if (i2 < 0 || i2 > this.f3288d - this.c) {
                throw d0.h();
            }
        }

        @Override // f.b.f.h1
        public void h(List<Float> list) {
            int i2;
            int i3;
            if (list instanceof x) {
                x xVar = (x) list;
                int i4 = this.f3289e & 7;
                if (i4 == 2) {
                    int d0 = d0();
                    k0(d0);
                    int i5 = this.c + d0;
                    while (this.c < i5) {
                        xVar.i(Float.intBitsToFloat(X()));
                    }
                } else if (i4 == 5) {
                    do {
                        xVar.i(u());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 2) {
                    int d02 = d0();
                    k0(d02);
                    int i7 = this.c + d02;
                    while (this.c < i7) {
                        list.add(Float.valueOf(Float.intBitsToFloat(X())));
                    }
                } else if (i6 == 5) {
                    do {
                        list.add(Float.valueOf(u()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else {
                    throw d0.d();
                }
            }
        }

        public final void h0(int i2) {
            if (this.c != i2) {
                throw d0.h();
            }
        }

        @Override // f.b.f.h1
        public int i() {
            i0(0);
            return d0();
        }

        public final void i0(int i2) {
            if ((this.f3289e & 7) != i2) {
                throw d0.d();
            }
        }

        @Override // f.b.f.h1
        public int j() {
            i0(0);
            return d0();
        }

        public final void j0(int i2) {
            g0(i2);
            this.c += i2;
        }

        @Override // f.b.f.h1
        public int k() {
            return this.f3289e;
        }

        public final void k0(int i2) {
            g0(i2);
            if ((i2 & 3) != 0) {
                throw d0.g();
            }
        }

        @Override // f.b.f.h1
        public long l() {
            i0(0);
            return e0();
        }

        public final void l0(int i2) {
            g0(i2);
            if ((i2 & 7) != 0) {
                throw d0.g();
            }
        }

        @Override // f.b.f.h1
        public void m(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3289e & 7;
                if (i4 == 2) {
                    int d0 = d0();
                    k0(d0);
                    int i5 = this.c + d0;
                    while (this.c < i5) {
                        b0Var.i(X());
                    }
                } else if (i4 == 5) {
                    do {
                        b0Var.i(H());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 2) {
                    int d02 = d0();
                    k0(d02);
                    int i7 = this.c + d02;
                    while (this.c < i7) {
                        list.add(Integer.valueOf(X()));
                    }
                } else if (i6 == 5) {
                    do {
                        list.add(Integer.valueOf(H()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.f.h1
        public long n() {
            i0(1);
            return Y();
        }

        @Override // f.b.f.h1
        public double o() {
            i0(1);
            return Double.longBitsToDouble(Y());
        }

        @Override // f.b.f.h1
        public void p(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3289e & 7;
                if (i4 == 2) {
                    int d0 = d0();
                    k0(d0);
                    int i5 = this.c + d0;
                    while (this.c < i5) {
                        b0Var.i(X());
                    }
                } else if (i4 == 5) {
                    do {
                        b0Var.i(w());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 2) {
                    int d02 = d0();
                    k0(d02);
                    int i7 = this.c + d02;
                    while (this.c < i7) {
                        list.add(Integer.valueOf(X()));
                    }
                } else if (i6 == 5) {
                    do {
                        list.add(Integer.valueOf(w()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else {
                    throw d0.d();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
        @Override // f.b.f.h1
        public boolean q() {
            int i2;
            int i3;
            int i4;
            if (S() || (i2 = this.f3289e) == (i3 = this.f3290f)) {
                return false;
            }
            int i5 = i2 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    i4 = 8;
                } else if (i5 == 2) {
                    i4 = d0();
                } else if (i5 == 3) {
                    this.f3290f = ((i2 >>> 3) << 3) | 4;
                    while (O() != Integer.MAX_VALUE && q()) {
                        while (O() != Integer.MAX_VALUE) {
                            while (O() != Integer.MAX_VALUE) {
                            }
                        }
                    }
                    if (this.f3289e == this.f3290f) {
                        this.f3290f = i3;
                        return true;
                    }
                    throw d0.g();
                } else if (i5 == 5) {
                    j0(4);
                    return true;
                } else {
                    throw d0.d();
                }
                j0(i4);
                return true;
            }
            int i6 = this.f3288d;
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
                if (T() >= 0) {
                    return true;
                }
            }
            throw d0.e();
        }

        @Override // f.b.f.h1
        public int r() {
            i0(0);
            return k.b(d0());
        }

        @Override // f.b.f.h1
        public void s(List<Long> list) {
            int i2;
            int i3;
            if (list instanceof k0) {
                k0 k0Var = (k0) list;
                int i4 = this.f3289e & 7;
                if (i4 == 0) {
                    do {
                        k0Var.i(v());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int d0 = this.c + d0();
                    while (this.c < d0) {
                        k0Var.i(k.c(e0()));
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i5 = this.f3289e & 7;
                if (i5 == 0) {
                    do {
                        list.add(Long.valueOf(v()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int d02 = this.c + d0();
                    while (this.c < d02) {
                        list.add(Long.valueOf(k.c(e0())));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.f.h1
        public <T> void t(List<T> list, j1<T> j1Var, r rVar) {
            int i2;
            int i3 = this.f3289e;
            if ((i3 & 7) == 3) {
                do {
                    list.add(V(j1Var, rVar));
                    if (!S()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (d0() == i3);
                this.c = i2;
                return;
            }
            throw d0.d();
        }

        @Override // f.b.f.h1
        public float u() {
            i0(5);
            return Float.intBitsToFloat(W());
        }

        @Override // f.b.f.h1
        public long v() {
            i0(0);
            return k.c(e0());
        }

        @Override // f.b.f.h1
        public int w() {
            i0(5);
            return W();
        }

        @Override // f.b.f.h1
        public void x(List<j> list) {
            int i2;
            if ((this.f3289e & 7) == 2) {
                do {
                    list.add(e());
                    if (!S()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (d0() == this.f3289e);
                this.c = i2;
                return;
            }
            throw d0.d();
        }

        @Override // f.b.f.h1
        public void y(List<Integer> list) {
            int i2;
            int i3;
            if (list instanceof b0) {
                b0 b0Var = (b0) list;
                int i4 = this.f3289e & 7;
                if (i4 == 0) {
                    do {
                        b0Var.i(i());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int d0 = this.c + d0();
                    while (this.c < d0) {
                        b0Var.i(d0());
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i5 = this.f3289e & 7;
                if (i5 == 0) {
                    do {
                        list.add(Integer.valueOf(i()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int d02 = this.c + d0();
                    while (this.c < d02) {
                        list.add(Integer.valueOf(d0()));
                    }
                } else {
                    throw d0.d();
                }
            }
        }

        @Override // f.b.f.h1
        public void z(List<Double> list) {
            int i2;
            int i3;
            if (list instanceof o) {
                o oVar = (o) list;
                int i4 = this.f3289e & 7;
                if (i4 == 1) {
                    do {
                        oVar.i(o());
                        if (!S()) {
                            i3 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i3;
                } else if (i4 == 2) {
                    int d0 = d0();
                    l0(d0);
                    int i5 = this.c + d0;
                    while (this.c < i5) {
                        oVar.i(Double.longBitsToDouble(Z()));
                    }
                } else {
                    throw d0.d();
                }
            } else {
                int i6 = this.f3289e & 7;
                if (i6 == 1) {
                    do {
                        list.add(Double.valueOf(o()));
                        if (!S()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (d0() == this.f3289e);
                    this.c = i2;
                } else if (i6 == 2) {
                    int d02 = d0();
                    l0(d02);
                    int i7 = this.c + d02;
                    while (this.c < i7) {
                        list.add(Double.valueOf(Double.longBitsToDouble(Z())));
                    }
                } else {
                    throw d0.d();
                }
            }
        }
    }

    public g(a aVar) {
    }
}
