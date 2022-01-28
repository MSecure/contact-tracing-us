package c.b.c.a.m0;

import c.b.c.a.m0.s;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.lang.reflect.Array;
import java.math.BigInteger;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final long[] f5188a = d0.b(c(f5192e));

    /* renamed from: b  reason: collision with root package name */
    public static final s.a[][] f5189b = ((s.a[][]) Array.newInstance(s.a.class, 32, 8));

    /* renamed from: c  reason: collision with root package name */
    public static final s.a[] f5190c = new s.a[8];

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f5191d = BigInteger.valueOf(2).pow(BuildConfig.VERSION_CODE).subtract(BigInteger.valueOf(19));

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f5192e = BigInteger.valueOf(-121665).multiply(BigInteger.valueOf(121666).modInverse(f5191d)).mod(f5191d);

    /* renamed from: f  reason: collision with root package name */
    public static final BigInteger f5193f = BigInteger.valueOf(2).multiply(f5192e).mod(f5191d);

    /* renamed from: g  reason: collision with root package name */
    public static final BigInteger f5194g = BigInteger.valueOf(2).modPow(f5191d.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), f5191d);

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BigInteger f5195a;

        /* renamed from: b  reason: collision with root package name */
        public BigInteger f5196b;

        public b(a aVar) {
        }
    }

    static {
        b bVar = new b(null);
        BigInteger mod = BigInteger.valueOf(4).multiply(BigInteger.valueOf(5).modInverse(f5191d)).mod(f5191d);
        bVar.f5196b = mod;
        BigInteger multiply = mod.pow(2).subtract(BigInteger.ONE).multiply(f5192e.multiply(mod.pow(2)).add(BigInteger.ONE).modInverse(f5191d));
        BigInteger modPow = multiply.modPow(f5191d.add(BigInteger.valueOf(3)).divide(BigInteger.valueOf(8)), f5191d);
        if (!modPow.pow(2).subtract(multiply).mod(f5191d).equals(BigInteger.ZERO)) {
            modPow = modPow.multiply(f5194g).mod(f5191d);
        }
        if (modPow.testBit(0)) {
            modPow = f5191d.subtract(modPow);
        }
        bVar.f5195a = modPow;
        d0.b(c(f5193f));
        d0.b(c(f5194g));
        b bVar2 = bVar;
        for (int i = 0; i < 32; i++) {
            b bVar3 = bVar2;
            for (int i2 = 0; i2 < 8; i2++) {
                f5189b[i][i2] = b(bVar3);
                bVar3 = a(bVar3, bVar2);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                bVar2 = a(bVar2, bVar2);
            }
        }
        b a2 = a(bVar, bVar);
        for (int i4 = 0; i4 < 8; i4++) {
            f5190c[i4] = b(bVar);
            bVar = a(bVar, a2);
        }
    }

    public static b a(b bVar, b bVar2) {
        b bVar3 = new b(null);
        BigInteger mod = f5192e.multiply(bVar.f5195a.multiply(bVar2.f5195a).multiply(bVar.f5196b).multiply(bVar2.f5196b)).mod(f5191d);
        bVar3.f5195a = bVar.f5195a.multiply(bVar2.f5196b).add(bVar2.f5195a.multiply(bVar.f5196b)).multiply(BigInteger.ONE.add(mod).modInverse(f5191d)).mod(f5191d);
        bVar3.f5196b = bVar.f5196b.multiply(bVar2.f5196b).add(bVar.f5195a.multiply(bVar2.f5195a)).multiply(BigInteger.ONE.subtract(mod).modInverse(f5191d)).mod(f5191d);
        return bVar3;
    }

    public static s.a b(b bVar) {
        return new s.a(d0.b(c(bVar.f5196b.add(bVar.f5195a).mod(f5191d))), d0.b(c(bVar.f5196b.subtract(bVar.f5195a).mod(f5191d))), d0.b(c(f5193f.multiply(bVar.f5195a).multiply(bVar.f5196b).mod(f5191d))));
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
