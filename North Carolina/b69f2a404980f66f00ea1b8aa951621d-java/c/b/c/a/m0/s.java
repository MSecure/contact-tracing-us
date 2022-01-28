package c.b.c.a.m0;

import java.security.MessageDigest;
import java.util.Arrays;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3777a = new a(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* renamed from: b  reason: collision with root package name */
    public static final b f3778b = new b(new c(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f3779a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f3780b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f3781c;

        public a() {
            this.f3779a = new long[10];
            this.f3780b = new long[10];
            this.f3781c = new long[10];
        }

        public a(a aVar) {
            this.f3779a = Arrays.copyOf(aVar.f3779a, 10);
            this.f3780b = Arrays.copyOf(aVar.f3780b, 10);
            this.f3781c = Arrays.copyOf(aVar.f3781c, 10);
        }

        public a(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f3779a = jArr;
            this.f3780b = jArr2;
            this.f3781c = jArr3;
        }

        public void a(a aVar, int i) {
            m.a(this.f3779a, aVar.f3779a, i);
            m.a(this.f3780b, aVar.f3780b, i);
            m.a(this.f3781c, aVar.f3781c, i);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f3782a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f3783b;

        public b(b bVar) {
            this.f3782a = new c(bVar.f3782a);
            this.f3783b = Arrays.copyOf(bVar.f3783b, 10);
        }

        public b(c cVar, long[] jArr) {
            this.f3782a = cVar;
            this.f3783b = jArr;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f3784a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f3785b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f3786c;

        public c() {
            this.f3784a = new long[10];
            this.f3785b = new long[10];
            this.f3786c = new long[10];
        }

        public c(c cVar) {
            this.f3784a = Arrays.copyOf(cVar.f3784a, 10);
            this.f3785b = Arrays.copyOf(cVar.f3785b, 10);
            this.f3786c = Arrays.copyOf(cVar.f3786c, 10);
        }

        public c(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f3784a = jArr;
            this.f3785b = jArr2;
            this.f3786c = jArr3;
        }

        public static c a(c cVar, b bVar) {
            d0.c(cVar.f3784a, bVar.f3782a.f3784a, bVar.f3783b);
            long[] jArr = cVar.f3785b;
            c cVar2 = bVar.f3782a;
            d0.c(jArr, cVar2.f3785b, cVar2.f3786c);
            d0.c(cVar.f3786c, bVar.f3782a.f3786c, bVar.f3783b);
            return cVar;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final c f3787a = new c();

        /* renamed from: b  reason: collision with root package name */
        public final long[] f3788b = new long[10];

        public static d a(d dVar, b bVar) {
            d0.c(dVar.f3787a.f3784a, bVar.f3782a.f3784a, bVar.f3783b);
            long[] jArr = dVar.f3787a.f3785b;
            c cVar = bVar.f3782a;
            d0.c(jArr, cVar.f3785b, cVar.f3786c);
            d0.c(dVar.f3787a.f3786c, bVar.f3782a.f3786c, bVar.f3783b);
            long[] jArr2 = dVar.f3788b;
            c cVar2 = bVar.f3782a;
            d0.c(jArr2, cVar2.f3784a, cVar2.f3785b);
            return dVar;
        }
    }

    public static void a(b bVar, d dVar, a aVar) {
        long[] jArr = new long[10];
        long[] jArr2 = bVar.f3782a.f3784a;
        c cVar = dVar.f3787a;
        d0.g(jArr2, cVar.f3785b, cVar.f3784a);
        long[] jArr3 = bVar.f3782a.f3785b;
        c cVar2 = dVar.f3787a;
        d0.f(jArr3, cVar2.f3785b, cVar2.f3784a);
        long[] jArr4 = bVar.f3782a.f3785b;
        d0.c(jArr4, jArr4, aVar.f3780b);
        c cVar3 = bVar.f3782a;
        d0.c(cVar3.f3786c, cVar3.f3784a, aVar.f3779a);
        d0.c(bVar.f3783b, dVar.f3788b, aVar.f3781c);
        System.arraycopy(dVar.f3787a.f3786c, 0, bVar.f3782a.f3784a, 0, 10);
        long[] jArr5 = bVar.f3782a.f3784a;
        d0.g(jArr, jArr5, jArr5);
        c cVar4 = bVar.f3782a;
        d0.f(cVar4.f3784a, cVar4.f3786c, cVar4.f3785b);
        c cVar5 = bVar.f3782a;
        long[] jArr6 = cVar5.f3785b;
        d0.g(jArr6, cVar5.f3786c, jArr6);
        d0.g(bVar.f3782a.f3786c, jArr, bVar.f3783b);
        long[] jArr7 = bVar.f3783b;
        d0.f(jArr7, jArr, jArr7);
    }

    public static void b(b bVar, c cVar) {
        long[] jArr = new long[10];
        d0.e(bVar.f3782a.f3784a, cVar.f3784a);
        d0.e(bVar.f3782a.f3786c, cVar.f3785b);
        d0.e(bVar.f3783b, cVar.f3786c);
        long[] jArr2 = bVar.f3783b;
        d0.g(jArr2, jArr2, jArr2);
        d0.g(bVar.f3782a.f3785b, cVar.f3784a, cVar.f3785b);
        d0.e(jArr, bVar.f3782a.f3785b);
        c cVar2 = bVar.f3782a;
        d0.g(cVar2.f3785b, cVar2.f3786c, cVar2.f3784a);
        c cVar3 = bVar.f3782a;
        long[] jArr3 = cVar3.f3786c;
        d0.f(jArr3, jArr3, cVar3.f3784a);
        c cVar4 = bVar.f3782a;
        d0.f(cVar4.f3784a, jArr, cVar4.f3785b);
        long[] jArr4 = bVar.f3783b;
        d0.f(jArr4, jArr4, bVar.f3782a.f3786c);
    }

    public static int c(int i, int i2) {
        int i3 = (~(i ^ i2)) & 255;
        int i4 = i3 & (i3 << 4);
        int i5 = i4 & (i4 << 2);
        return ((i5 & (i5 << 1)) >> 7) & 1;
    }

    public static byte[] d(byte[] bArr) {
        MessageDigest a2 = a0.i.a("SHA-512");
        a2.update(bArr, 0, 32);
        byte[] digest = a2.digest();
        digest[0] = (byte) (digest[0] & 248);
        digest[31] = (byte) (digest[31] & Byte.MAX_VALUE);
        digest[31] = (byte) (digest[31] | 64);
        return digest;
    }

    public static byte[] e(byte[] bArr) {
        byte[] bArr2 = new byte[64];
        for (int i = 0; i < 32; i++) {
            int i2 = i * 2;
            bArr2[i2 + 0] = (byte) (((bArr[i] & 255) >> 0) & 15);
            bArr2[i2 + 1] = (byte) (((bArr[i] & 255) >> 4) & 15);
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 63; i4++) {
            bArr2[i4] = (byte) (bArr2[i4] + i3);
            i3 = (bArr2[i4] + 8) >> 4;
            bArr2[i4] = (byte) (bArr2[i4] - (i3 << 4));
        }
        bArr2[63] = (byte) (bArr2[63] + i3);
        b bVar = new b(f3778b);
        d dVar = new d();
        for (int i5 = 1; i5 < 64; i5 += 2) {
            a aVar = new a(f3777a);
            f(aVar, i5 / 2, bArr2[i5]);
            d.a(dVar, bVar);
            a(bVar, dVar, aVar);
        }
        c cVar = new c();
        c.a(cVar, bVar);
        b(bVar, cVar);
        c.a(cVar, bVar);
        b(bVar, cVar);
        c.a(cVar, bVar);
        b(bVar, cVar);
        c.a(cVar, bVar);
        b(bVar, cVar);
        for (int i6 = 0; i6 < 64; i6 += 2) {
            a aVar2 = new a(f3777a);
            f(aVar2, i6 / 2, bArr2[i6]);
            d.a(dVar, bVar);
            a(bVar, dVar, aVar2);
        }
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        d0.c(jArr, bVar.f3782a.f3784a, bVar.f3783b);
        c cVar2 = bVar.f3782a;
        d0.c(jArr2, cVar2.f3785b, cVar2.f3786c);
        d0.c(jArr3, bVar.f3782a.f3786c, bVar.f3783b);
        long[] jArr4 = new long[10];
        d0.e(jArr4, jArr);
        long[] jArr5 = new long[10];
        d0.e(jArr5, jArr2);
        long[] jArr6 = new long[10];
        d0.e(jArr6, jArr3);
        long[] jArr7 = new long[10];
        d0.e(jArr7, jArr6);
        long[] jArr8 = new long[10];
        d0.f(jArr8, jArr5, jArr4);
        d0.c(jArr8, jArr8, jArr6);
        long[] jArr9 = new long[10];
        d0.c(jArr9, jArr4, jArr5);
        d0.c(jArr9, jArr9, t.f3789a);
        d0.g(jArr9, jArr9, jArr7);
        d0.d(jArr9, jArr9);
        if (c.b.a.a.c.n.c.K0(d0.a(jArr8), d0.a(jArr9))) {
            long[] jArr10 = new long[10];
            long[] jArr11 = new long[10];
            long[] jArr12 = new long[10];
            long[] jArr13 = new long[10];
            long[] jArr14 = new long[10];
            long[] jArr15 = new long[10];
            long[] jArr16 = new long[10];
            long[] jArr17 = new long[10];
            long[] jArr18 = new long[10];
            long[] jArr19 = new long[10];
            long[] jArr20 = new long[10];
            long[] jArr21 = new long[10];
            long[] jArr22 = new long[10];
            d0.e(jArr13, jArr3);
            d0.e(jArr22, jArr13);
            d0.e(jArr21, jArr22);
            d0.c(jArr14, jArr21, jArr3);
            d0.c(jArr15, jArr14, jArr13);
            d0.e(jArr21, jArr15);
            d0.c(jArr16, jArr21, jArr14);
            d0.e(jArr21, jArr16);
            d0.e(jArr22, jArr21);
            d0.e(jArr21, jArr22);
            d0.e(jArr22, jArr21);
            d0.e(jArr21, jArr22);
            d0.c(jArr17, jArr21, jArr16);
            d0.e(jArr21, jArr17);
            d0.e(jArr22, jArr21);
            for (int i7 = 2; i7 < 10; i7 += 2) {
                d0.e(jArr21, jArr22);
                d0.e(jArr22, jArr21);
            }
            d0.c(jArr18, jArr22, jArr17);
            d0.e(jArr21, jArr18);
            d0.e(jArr22, jArr21);
            for (int i8 = 2; i8 < 20; i8 += 2) {
                d0.e(jArr21, jArr22);
                d0.e(jArr22, jArr21);
            }
            d0.c(jArr21, jArr22, jArr18);
            d0.e(jArr22, jArr21);
            d0.e(jArr21, jArr22);
            for (int i9 = 2; i9 < 10; i9 += 2) {
                d0.e(jArr22, jArr21);
                d0.e(jArr21, jArr22);
            }
            d0.c(jArr19, jArr21, jArr17);
            d0.e(jArr21, jArr19);
            d0.e(jArr22, jArr21);
            for (int i10 = 2; i10 < 50; i10 += 2) {
                d0.e(jArr21, jArr22);
                d0.e(jArr22, jArr21);
            }
            d0.c(jArr20, jArr22, jArr19);
            d0.e(jArr22, jArr20);
            d0.e(jArr21, jArr22);
            for (int i11 = 2; i11 < 100; i11 += 2) {
                d0.e(jArr22, jArr21);
                d0.e(jArr21, jArr22);
            }
            d0.c(jArr22, jArr21, jArr20);
            d0.e(jArr21, jArr22);
            d0.e(jArr22, jArr21);
            for (int i12 = 2; i12 < 50; i12 += 2) {
                d0.e(jArr21, jArr22);
                d0.e(jArr22, jArr21);
            }
            d0.c(jArr21, jArr22, jArr19);
            d0.e(jArr22, jArr21);
            d0.e(jArr21, jArr22);
            d0.e(jArr22, jArr21);
            d0.e(jArr21, jArr22);
            d0.e(jArr22, jArr21);
            d0.c(jArr10, jArr22, jArr15);
            d0.c(jArr11, jArr, jArr10);
            d0.c(jArr12, jArr2, jArr10);
            byte[] a2 = d0.a(jArr12);
            a2[31] = (byte) (a2[31] ^ ((d0.a(jArr11)[0] & 1) << 7));
            return a2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static void f(a aVar, int i, byte b2) {
        int i2 = (b2 & 255) >> 7;
        int i3 = b2 - (((-i2) & b2) << 1);
        aVar.a(t.f3790b[i][0], c(i3, 1));
        aVar.a(t.f3790b[i][1], c(i3, 2));
        aVar.a(t.f3790b[i][2], c(i3, 3));
        aVar.a(t.f3790b[i][3], c(i3, 4));
        aVar.a(t.f3790b[i][4], c(i3, 5));
        aVar.a(t.f3790b[i][5], c(i3, 6));
        aVar.a(t.f3790b[i][6], c(i3, 7));
        aVar.a(t.f3790b[i][7], c(i3, 8));
        long[] copyOf = Arrays.copyOf(aVar.f3780b, 10);
        long[] copyOf2 = Arrays.copyOf(aVar.f3779a, 10);
        long[] copyOf3 = Arrays.copyOf(aVar.f3781c, 10);
        for (int i4 = 0; i4 < copyOf3.length; i4++) {
            copyOf3[i4] = -copyOf3[i4];
        }
        m.a(aVar.f3779a, copyOf, i2);
        m.a(aVar.f3780b, copyOf2, i2);
        m.a(aVar.f3781c, copyOf3, i2);
    }
}
