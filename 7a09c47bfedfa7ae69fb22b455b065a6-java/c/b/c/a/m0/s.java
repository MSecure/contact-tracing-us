package c.b.c.a.m0;

import b.x.t;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.security.MessageDigest;
import java.util.Arrays;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5176a = new a(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* renamed from: b  reason: collision with root package name */
    public static final b f5177b = new b(new c(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f5178a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f5179b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f5180c;

        public a() {
            this.f5178a = new long[10];
            this.f5179b = new long[10];
            this.f5180c = new long[10];
        }

        public a(a aVar) {
            this.f5178a = Arrays.copyOf(aVar.f5178a, 10);
            this.f5179b = Arrays.copyOf(aVar.f5179b, 10);
            this.f5180c = Arrays.copyOf(aVar.f5180c, 10);
        }

        public a(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f5178a = jArr;
            this.f5179b = jArr2;
            this.f5180c = jArr3;
        }

        public void a(a aVar, int i) {
            m.a(this.f5178a, aVar.f5178a, i);
            m.a(this.f5179b, aVar.f5179b, i);
            m.a(this.f5180c, aVar.f5180c, i);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f5181a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f5182b;

        public b(b bVar) {
            this.f5181a = new c(bVar.f5181a);
            this.f5182b = Arrays.copyOf(bVar.f5182b, 10);
        }

        public b(c cVar, long[] jArr) {
            this.f5181a = cVar;
            this.f5182b = jArr;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f5183a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f5184b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f5185c;

        public c() {
            this.f5183a = new long[10];
            this.f5184b = new long[10];
            this.f5185c = new long[10];
        }

        public c(c cVar) {
            this.f5183a = Arrays.copyOf(cVar.f5183a, 10);
            this.f5184b = Arrays.copyOf(cVar.f5184b, 10);
            this.f5185c = Arrays.copyOf(cVar.f5185c, 10);
        }

        public c(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f5183a = jArr;
            this.f5184b = jArr2;
            this.f5185c = jArr3;
        }

        public static c a(c cVar, b bVar) {
            d0.c(cVar.f5183a, bVar.f5181a.f5183a, bVar.f5182b);
            long[] jArr = cVar.f5184b;
            c cVar2 = bVar.f5181a;
            d0.c(jArr, cVar2.f5184b, cVar2.f5185c);
            d0.c(cVar.f5185c, bVar.f5181a.f5185c, bVar.f5182b);
            return cVar;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final c f5186a = new c();

        /* renamed from: b  reason: collision with root package name */
        public final long[] f5187b = new long[10];

        public static d a(d dVar, b bVar) {
            d0.c(dVar.f5186a.f5183a, bVar.f5181a.f5183a, bVar.f5182b);
            long[] jArr = dVar.f5186a.f5184b;
            c cVar = bVar.f5181a;
            d0.c(jArr, cVar.f5184b, cVar.f5185c);
            d0.c(dVar.f5186a.f5185c, bVar.f5181a.f5185c, bVar.f5182b);
            long[] jArr2 = dVar.f5187b;
            c cVar2 = bVar.f5181a;
            d0.c(jArr2, cVar2.f5183a, cVar2.f5184b);
            return dVar;
        }
    }

    public static void a(b bVar, d dVar, a aVar) {
        long[] jArr = new long[10];
        long[] jArr2 = bVar.f5181a.f5183a;
        c cVar = dVar.f5186a;
        d0.g(jArr2, cVar.f5184b, cVar.f5183a);
        long[] jArr3 = bVar.f5181a.f5184b;
        c cVar2 = dVar.f5186a;
        d0.f(jArr3, cVar2.f5184b, cVar2.f5183a);
        long[] jArr4 = bVar.f5181a.f5184b;
        d0.c(jArr4, jArr4, aVar.f5179b);
        c cVar3 = bVar.f5181a;
        d0.c(cVar3.f5185c, cVar3.f5183a, aVar.f5178a);
        d0.c(bVar.f5182b, dVar.f5187b, aVar.f5180c);
        System.arraycopy(dVar.f5186a.f5185c, 0, bVar.f5181a.f5183a, 0, 10);
        long[] jArr5 = bVar.f5181a.f5183a;
        d0.g(jArr, jArr5, jArr5);
        c cVar4 = bVar.f5181a;
        d0.f(cVar4.f5183a, cVar4.f5185c, cVar4.f5184b);
        c cVar5 = bVar.f5181a;
        long[] jArr6 = cVar5.f5184b;
        d0.g(jArr6, cVar5.f5185c, jArr6);
        d0.g(bVar.f5181a.f5185c, jArr, bVar.f5182b);
        long[] jArr7 = bVar.f5182b;
        d0.f(jArr7, jArr, jArr7);
    }

    public static void b(b bVar, c cVar) {
        long[] jArr = new long[10];
        d0.e(bVar.f5181a.f5183a, cVar.f5183a);
        d0.e(bVar.f5181a.f5185c, cVar.f5184b);
        d0.e(bVar.f5182b, cVar.f5185c);
        long[] jArr2 = bVar.f5182b;
        d0.g(jArr2, jArr2, jArr2);
        d0.g(bVar.f5181a.f5184b, cVar.f5183a, cVar.f5184b);
        d0.e(jArr, bVar.f5181a.f5184b);
        c cVar2 = bVar.f5181a;
        d0.g(cVar2.f5184b, cVar2.f5185c, cVar2.f5183a);
        c cVar3 = bVar.f5181a;
        long[] jArr3 = cVar3.f5185c;
        d0.f(jArr3, jArr3, cVar3.f5183a);
        c cVar4 = bVar.f5181a;
        d0.f(cVar4.f5183a, jArr, cVar4.f5184b);
        long[] jArr4 = bVar.f5182b;
        d0.f(jArr4, jArr4, bVar.f5181a.f5185c);
    }

    public static int c(int i, int i2) {
        int i3 = (~(i ^ i2)) & BuildConfig.VERSION_CODE;
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
        b bVar = new b(f5177b);
        d dVar = new d();
        for (int i5 = 1; i5 < 64; i5 += 2) {
            a aVar = new a(f5176a);
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
            a aVar2 = new a(f5176a);
            f(aVar2, i6 / 2, bArr2[i6]);
            d.a(dVar, bVar);
            a(bVar, dVar, aVar2);
        }
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        d0.c(jArr, bVar.f5181a.f5183a, bVar.f5182b);
        c cVar2 = bVar.f5181a;
        d0.c(jArr2, cVar2.f5184b, cVar2.f5185c);
        d0.c(jArr3, bVar.f5181a.f5185c, bVar.f5182b);
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
        d0.c(jArr9, jArr9, t.f5188a);
        d0.g(jArr9, jArr9, jArr7);
        d0.d(jArr9, jArr9);
        if (t.k1(d0.a(jArr8), d0.a(jArr9))) {
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
        aVar.a(t.f5189b[i][0], c(i3, 1));
        aVar.a(t.f5189b[i][1], c(i3, 2));
        aVar.a(t.f5189b[i][2], c(i3, 3));
        aVar.a(t.f5189b[i][3], c(i3, 4));
        aVar.a(t.f5189b[i][4], c(i3, 5));
        aVar.a(t.f5189b[i][5], c(i3, 6));
        aVar.a(t.f5189b[i][6], c(i3, 7));
        aVar.a(t.f5189b[i][7], c(i3, 8));
        long[] copyOf = Arrays.copyOf(aVar.f5179b, 10);
        long[] copyOf2 = Arrays.copyOf(aVar.f5178a, 10);
        long[] copyOf3 = Arrays.copyOf(aVar.f5180c, 10);
        for (int i4 = 0; i4 < copyOf3.length; i4++) {
            copyOf3[i4] = -copyOf3[i4];
        }
        m.a(aVar.f5178a, copyOf, i2);
        m.a(aVar.f5179b, copyOf2, i2);
        m.a(aVar.f5180c, copyOf3, i2);
    }
}
