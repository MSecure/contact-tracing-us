package c.b.c.a.m0;

import c.b.c.a.m0.s;
import java.lang.reflect.Array;
import java.math.BigInteger;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final long[] f3789a = d0.b(c(f3793e));

    /* renamed from: b  reason: collision with root package name */
    public static final s.a[][] f3790b = ((s.a[][]) Array.newInstance(s.a.class, 32, 8));

    /* renamed from: c  reason: collision with root package name */
    public static final s.a[] f3791c = new s.a[8];

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f3792d = BigInteger.valueOf(2).pow(255).subtract(BigInteger.valueOf(19));

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f3793e = BigInteger.valueOf(-121665).multiply(BigInteger.valueOf(121666).modInverse(f3792d)).mod(f3792d);
    public static final BigInteger f = BigInteger.valueOf(2).multiply(f3793e).mod(f3792d);
    public static final BigInteger g = BigInteger.valueOf(2).modPow(f3792d.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), f3792d);

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BigInteger f3794a;

        /* renamed from: b  reason: collision with root package name */
        public BigInteger f3795b;

        public b(a aVar) {
        }
    }

    static {
        b bVar = new b(null);
        BigInteger mod = BigInteger.valueOf(4).multiply(BigInteger.valueOf(5).modInverse(f3792d)).mod(f3792d);
        bVar.f3795b = mod;
        BigInteger multiply = mod.pow(2).subtract(BigInteger.ONE).multiply(f3793e.multiply(mod.pow(2)).add(BigInteger.ONE).modInverse(f3792d));
        BigInteger modPow = multiply.modPow(f3792d.add(BigInteger.valueOf(3)).divide(BigInteger.valueOf(8)), f3792d);
        if (!modPow.pow(2).subtract(multiply).mod(f3792d).equals(BigInteger.ZERO)) {
            modPow = modPow.multiply(g).mod(f3792d);
        }
        if (modPow.testBit(0)) {
            modPow = f3792d.subtract(modPow);
        }
        bVar.f3794a = modPow;
        d0.b(c(f));
        d0.b(c(g));
        b bVar2 = bVar;
        for (int i = 0; i < 32; i++) {
            b bVar3 = bVar2;
            for (int i2 = 0; i2 < 8; i2++) {
                f3790b[i][i2] = b(bVar3);
                bVar3 = a(bVar3, bVar2);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                bVar2 = a(bVar2, bVar2);
            }
        }
        b a2 = a(bVar, bVar);
        for (int i4 = 0; i4 < 8; i4++) {
            f3791c[i4] = b(bVar);
            bVar = a(bVar, a2);
        }
    }

    public static b a(b bVar, b bVar2) {
        b bVar3 = new b(null);
        BigInteger mod = f3793e.multiply(bVar.f3794a.multiply(bVar2.f3794a).multiply(bVar.f3795b).multiply(bVar2.f3795b)).mod(f3792d);
        bVar3.f3794a = bVar.f3794a.multiply(bVar2.f3795b).add(bVar2.f3794a.multiply(bVar.f3795b)).multiply(BigInteger.ONE.add(mod).modInverse(f3792d)).mod(f3792d);
        bVar3.f3795b = bVar.f3795b.multiply(bVar2.f3795b).add(bVar.f3794a.multiply(bVar2.f3794a)).multiply(BigInteger.ONE.subtract(mod).modInverse(f3792d)).mod(f3792d);
        return bVar3;
    }

    public static s.a b(b bVar) {
        return new s.a(d0.b(c(bVar.f3795b.add(bVar.f3794a).mod(f3792d))), d0.b(c(bVar.f3795b.subtract(bVar.f3794a).mod(f3792d))), d0.b(c(f.multiply(bVar.f3794a).multiply(bVar.f3795b).mod(f3792d))));
    }

    public static byte[] c(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b2 = bArr[i];
            int i2 = (32 - i) - 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b2;
        }
        return bArr;
    }
}
