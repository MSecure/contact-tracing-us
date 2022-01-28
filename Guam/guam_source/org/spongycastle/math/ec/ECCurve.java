package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.FiniteFields;
import org.spongycastle.math.field.GenericPolynomialExtensionField;

public abstract class ECCurve {
    public ECFieldElement a;
    public ECFieldElement b;
    public BigInteger cofactor;
    public int coord = 0;
    public FiniteField field;

    public static abstract class AbstractF2m extends ECCurve {
        /* JADX WARNING: Illegal instructions before constructor call */
        public AbstractF2m(int i, int i2, int i3, int i4) {
            super(r6);
            GenericPolynomialExtensionField genericPolynomialExtensionField;
            if (i2 != 0) {
                if (i3 == 0) {
                    if (i4 == 0) {
                        genericPolynomialExtensionField = FiniteFields.getBinaryExtensionField(new int[]{0, i2, i});
                    } else {
                        throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                    }
                } else if (i3 <= i2) {
                    throw new IllegalArgumentException("k2 must be > k1");
                } else if (i4 > i3) {
                    genericPolynomialExtensionField = FiniteFields.getBinaryExtensionField(new int[]{0, i2, i3, i4, i});
                } else {
                    throw new IllegalArgumentException("k3 must be > k2");
                }
                return;
            }
            throw new IllegalArgumentException("k1 must be > 0");
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement fromBigInteger2 = fromBigInteger(bigInteger2);
            int i = this.coord;
            if (i == 5 || i == 6) {
                if (!fromBigInteger.isZero()) {
                    fromBigInteger2 = fromBigInteger2.divide(fromBigInteger).add(fromBigInteger);
                } else if (!fromBigInteger2.square().equals(this.b)) {
                    throw new IllegalArgumentException();
                }
            }
            return new ECPoint.F2m((F2m) this, fromBigInteger, fromBigInteger2, z);
        }
    }

    public static abstract class AbstractFp extends ECCurve {
        public AbstractFp(BigInteger bigInteger) {
            super(FiniteFields.getPrimeField(bigInteger));
        }
    }

    public static class F2m extends AbstractF2m {
        public ECPoint.F2m infinity = new ECPoint.F2m(this, null, null, false);
        public int k1;
        public int k2;
        public int k3;
        public int m;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i, i2, i3, i4);
            this.m = i;
            this.k1 = i2;
            this.k2 = i3;
            this.k3 = i4;
            this.cofactor = null;
            this.a = fromBigInteger(bigInteger);
            this.b = fromBigInteger(bigInteger2);
            this.coord = 6;
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new ECPoint.F2m(this, eCFieldElement, eCFieldElement2, z);
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, bigInteger);
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.m;
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }
    }

    public static class Fp extends AbstractFp {
        public ECPoint.Fp infinity = new ECPoint.Fp(this, null, null, false);
        public BigInteger q;
        public BigInteger r;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            super(bigInteger);
            this.q = bigInteger;
            this.r = ECFieldElement.Fp.calculateResidue(bigInteger);
            this.a = fromBigInteger(bigInteger2);
            this.b = fromBigInteger(bigInteger3);
            this.cofactor = null;
            this.coord = 4;
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new ECPoint.Fp(this, eCFieldElement, eCFieldElement2, z);
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.Fp(this.q, this.r, bigInteger);
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.q.bitLength();
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        @Override // org.spongycastle.math.ec.ECCurve
        public ECPoint importPoint(ECPoint eCPoint) {
            int i;
            if (this == eCPoint.curve || this.coord != 2 || eCPoint.isInfinity() || ((i = eCPoint.curve.coord) != 2 && i != 3 && i != 4)) {
                return ECCurve.super.importPoint(eCPoint);
            }
            return new ECPoint.Fp(this, fromBigInteger(eCPoint.x.toBigInteger()), fromBigInteger(eCPoint.y.toBigInteger()), new ECFieldElement[]{fromBigInteger(eCPoint.zs[0].toBigInteger())}, eCPoint.withCompression);
        }
    }

    public ECCurve(FiniteField finiteField) {
        this.field = finiteField;
    }

    public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        return createRawPoint(fromBigInteger(bigInteger), fromBigInteger(bigInteger2), z);
    }

    public abstract ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z);

    public boolean equals(ECCurve eCCurve) {
        return this == eCCurve || (eCCurve != null && this.field.equals(eCCurve.field) && this.a.toBigInteger().equals(eCCurve.a.toBigInteger()) && this.b.toBigInteger().equals(eCCurve.b.toBigInteger()));
    }

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public int hashCode() {
        return (this.field.hashCode() ^ Integer.rotateLeft(this.a.toBigInteger().hashCode(), 8)) ^ Integer.rotateLeft(this.b.toBigInteger().hashCode(), 16);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        if (r0 != false) goto L_0x008d;
     */
    public ECPoint importPoint(ECPoint eCPoint) {
        boolean z;
        if (this == eCPoint.curve) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return getInfinity();
        }
        ECPoint normalize = eCPoint.normalize();
        ECPoint createPoint = createPoint(normalize.x.toBigInteger(), normalize.getYCoord().toBigInteger(), normalize.withCompression);
        boolean z2 = true;
        if (!createPoint.isInfinity() && createPoint.curve != null) {
            if (createPoint.satisfiesCurveEquation()) {
                BigInteger bigInteger = createPoint.curve.cofactor;
                if (bigInteger != null && !bigInteger.equals(ECConstants.ONE)) {
                    BigInteger abs = bigInteger.abs();
                    ECPoint infinity = createPoint.curve.getInfinity();
                    int bitLength = abs.bitLength();
                    if (bitLength > 0) {
                        if (abs.testBit(0)) {
                            infinity = createPoint;
                        }
                        ECPoint eCPoint2 = createPoint;
                        for (int i = 1; i < bitLength; i++) {
                            eCPoint2 = eCPoint2.twice();
                            if (abs.testBit(i)) {
                                infinity = infinity.add(eCPoint2);
                            }
                        }
                    }
                    if (bigInteger.signum() < 0) {
                        infinity = infinity.negate();
                    }
                    if (infinity.isInfinity()) {
                        z = false;
                    }
                }
                z = true;
            }
            z2 = false;
        }
        if (z2) {
            return createPoint;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ECCurve) && equals((ECCurve) obj));
    }
}
