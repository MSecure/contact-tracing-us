package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;

public abstract class ECPoint {
    public static ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    public ECCurve curve;
    public boolean withCompression;
    public ECFieldElement x;
    public ECFieldElement y;
    public ECFieldElement[] zs;

    public static abstract class AbstractF2m extends ECPoint {
        public AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        @Override // org.spongycastle.math.ec.ECPoint
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECCurve eCCurve = this.curve;
            ECFieldElement eCFieldElement3 = this.x;
            ECFieldElement eCFieldElement4 = eCCurve.a;
            ECFieldElement eCFieldElement5 = eCCurve.b;
            int i = eCCurve.coord;
            if (i == 6) {
                ECFieldElement eCFieldElement6 = this.zs[0];
                boolean isOne = eCFieldElement6.isOne();
                if (eCFieldElement3.isZero()) {
                    ECFieldElement square = this.y.square();
                    if (!isOne) {
                        eCFieldElement5 = eCFieldElement5.multiply(eCFieldElement6.square());
                    }
                    return square.equals(eCFieldElement5);
                }
                ECFieldElement eCFieldElement7 = this.y;
                ECFieldElement square2 = eCFieldElement3.square();
                if (isOne) {
                    eCFieldElement2 = eCFieldElement7.square().add(eCFieldElement7).add(eCFieldElement4);
                    eCFieldElement = square2.square().add(eCFieldElement5);
                } else {
                    ECFieldElement square3 = eCFieldElement6.square();
                    ECFieldElement square4 = square3.square();
                    eCFieldElement2 = eCFieldElement7.add(eCFieldElement6).multiplyPlusProduct(eCFieldElement7, eCFieldElement4, square3);
                    eCFieldElement = square2.squarePlusProduct(eCFieldElement5, square4);
                }
                return eCFieldElement2.multiply(square2).equals(eCFieldElement);
            }
            ECFieldElement eCFieldElement8 = this.y;
            ECFieldElement multiply = eCFieldElement8.add(eCFieldElement3).multiply(eCFieldElement8);
            if (i != 0) {
                if (i == 1) {
                    ECFieldElement eCFieldElement9 = this.zs[0];
                    if (!eCFieldElement9.isOne()) {
                        ECFieldElement multiply2 = eCFieldElement9.multiply(eCFieldElement9.square());
                        multiply = multiply.multiply(eCFieldElement9);
                        eCFieldElement4 = eCFieldElement4.multiply(eCFieldElement9);
                        eCFieldElement5 = eCFieldElement5.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return multiply.equals(eCFieldElement3.add(eCFieldElement4).multiply(eCFieldElement3.square()).add(eCFieldElement5));
        }

        public AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public static abstract class AbstractFp extends ECPoint {
        public AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        @Override // org.spongycastle.math.ec.ECPoint
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement = this.x;
            ECFieldElement eCFieldElement2 = this.y;
            ECCurve eCCurve = this.curve;
            ECFieldElement eCFieldElement3 = eCCurve.a;
            ECFieldElement eCFieldElement4 = eCCurve.b;
            ECFieldElement square = eCFieldElement2.square();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 0) {
                if (curveCoordinateSystem == 1) {
                    ECFieldElement eCFieldElement5 = this.zs[0];
                    if (!eCFieldElement5.isOne()) {
                        ECFieldElement square2 = eCFieldElement5.square();
                        ECFieldElement multiply = eCFieldElement5.multiply(square2);
                        square = square.multiply(eCFieldElement5);
                        eCFieldElement3 = eCFieldElement3.multiply(square2);
                        eCFieldElement4 = eCFieldElement4.multiply(multiply);
                    }
                } else if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                    ECFieldElement eCFieldElement6 = this.zs[0];
                    if (!eCFieldElement6.isOne()) {
                        ECFieldElement square3 = eCFieldElement6.square();
                        ECFieldElement square4 = square3.square();
                        ECFieldElement multiply2 = square3.multiply(square4);
                        eCFieldElement3 = eCFieldElement3.multiply(square4);
                        eCFieldElement4 = eCFieldElement4.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return square.equals(eCFieldElement.square().add(eCFieldElement3).multiply(eCFieldElement).add(eCFieldElement4));
        }

        public AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.curve = eCCurve;
        this.x = eCFieldElement;
        this.y = eCFieldElement2;
        this.zs = eCFieldElementArr;
    }

    public abstract ECPoint add(ECPoint eCPoint);

    public ECPoint createScaledPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return this.curve.createRawPoint(this.x.multiply(eCFieldElement), this.y.multiply(eCFieldElement2), this.withCompression);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0117, code lost:
        if (r1.getYCoord().equals(r12.getYCoord()) != false) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0126, code lost:
        if (r1.equals(r3) != false) goto L_0x012a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010b  */
    public boolean equals(Object obj) {
        ECPoint eCPoint;
        ECPoint eCPoint2;
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ECPoint) || (eCPoint = (ECPoint) obj) == null) {
            return false;
        }
        ECCurve eCCurve = this.curve;
        ECCurve eCCurve2 = eCPoint.curve;
        boolean z2 = eCCurve == null;
        boolean z3 = eCCurve2 == null;
        boolean isInfinity = isInfinity();
        boolean isInfinity2 = eCPoint.isInfinity();
        if (!isInfinity && !isInfinity2) {
            if (!z2 || !z3) {
                if (z2) {
                    eCPoint = eCPoint.normalize();
                } else {
                    if (z3) {
                        eCPoint2 = normalize();
                    } else if (!eCCurve.equals(eCCurve2)) {
                        return false;
                    } else {
                        ECPoint[] eCPointArr = {this, eCCurve.importPoint(eCPoint)};
                        for (int i = 0; i < 2; i++) {
                            ECPoint eCPoint3 = eCPointArr[0 + i];
                            if (eCPoint3 != null && eCCurve != eCPoint3.curve) {
                                throw new IllegalArgumentException("'points' entries must be null or on this curve");
                            }
                        }
                        int i2 = eCCurve.coord;
                        if (!(i2 == 0 || i2 == 5)) {
                            ECFieldElement[] eCFieldElementArr = new ECFieldElement[2];
                            int[] iArr = new int[2];
                            int i3 = 0;
                            for (int i4 = 0; i4 < 2; i4++) {
                                int i5 = 0 + i4;
                                ECPoint eCPoint4 = eCPointArr[i5];
                                if (eCPoint4 != null) {
                                    int curveCoordinateSystem = eCPoint4.getCurveCoordinateSystem();
                                    if (!(curveCoordinateSystem == 0 || curveCoordinateSystem == 5 || eCPoint4.isInfinity() || eCPoint4.zs[0].isOne())) {
                                        eCFieldElementArr[i3] = eCPoint4.getZCoord(0);
                                        iArr[i3] = i5;
                                        i3++;
                                    }
                                }
                            }
                            if (i3 != 0) {
                                ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[i3];
                                eCFieldElementArr2[0] = eCFieldElementArr[0];
                                int i6 = 0;
                                while (true) {
                                    i6++;
                                    if (i6 >= i3) {
                                        break;
                                    }
                                    eCFieldElementArr2[i6] = eCFieldElementArr2[i6 - 1].multiply(eCFieldElementArr[0 + i6]);
                                }
                                int i7 = i6 - 1;
                                ECFieldElement invert = eCFieldElementArr2[i7].invert();
                                while (i7 > 0) {
                                    int i8 = i7 - 1;
                                    int i9 = i7 + 0;
                                    ECFieldElement eCFieldElement = eCFieldElementArr[i9];
                                    eCFieldElementArr[i9] = eCFieldElementArr2[i8].multiply(invert);
                                    invert = invert.multiply(eCFieldElement);
                                    i7 = i8;
                                }
                                eCFieldElementArr[0] = invert;
                                for (int i10 = 0; i10 < i3; i10++) {
                                    int i11 = iArr[i10];
                                    eCPointArr[i11] = eCPointArr[i11].normalize(eCFieldElementArr[i10]);
                                }
                            }
                        }
                        eCPoint2 = eCPointArr[0];
                        eCPoint = eCPointArr[1];
                    }
                    if (eCPoint2.x.equals(eCPoint.x)) {
                    }
                }
            }
            eCPoint2 = this;
            if (eCPoint2.x.equals(eCPoint.x)) {
            }
        } else if (isInfinity) {
            if (isInfinity2) {
                if (!z2) {
                    if (!z3) {
                    }
                }
                return z;
            }
        }
        z = false;
        return z;
    }

    public int getCurveCoordinateSystem() {
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.coord;
    }

    public ECFieldElement getYCoord() {
        return this.y;
    }

    public ECFieldElement getZCoord(int i) {
        if (i >= 0) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (i < eCFieldElementArr.length) {
                return eCFieldElementArr[i];
            }
        }
        return null;
    }

    public int hashCode() {
        int i;
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            i = 0;
        } else {
            i = ~eCCurve.hashCode();
        }
        if (isInfinity()) {
            return i;
        }
        ECPoint normalize = normalize();
        return (i ^ (normalize.x.hashCode() * 17)) ^ (normalize.getYCoord().hashCode() * 257);
    }

    public boolean isInfinity() {
        if (!(this.x == null || this.y == null)) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].isZero()) {
                return false;
            }
        }
        return true;
    }

    public abstract ECPoint negate();

    public ECPoint normalize() {
        int curveCoordinateSystem;
        if (isInfinity() || (curveCoordinateSystem = getCurveCoordinateSystem()) == 0 || curveCoordinateSystem == 5) {
            return this;
        }
        ECFieldElement zCoord = getZCoord(0);
        if (zCoord.isOne()) {
            return this;
        }
        return normalize(zCoord.invert());
    }

    public abstract boolean satisfiesCurveEquation();

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(this.x);
        stringBuffer.append(',');
        stringBuffer.append(this.y);
        for (int i = 0; i < this.zs.length; i++) {
            stringBuffer.append(',');
            stringBuffer.append(this.zs[i]);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public abstract ECPoint twice();

    public static class Fp extends AbstractFp {
        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:53:0x011f, code lost:
            if (r1 == r6) goto L_0x0121;
         */
        @Override // org.spongycastle.math.ec.ECPoint
        public ECPoint add(ECPoint eCPoint) {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            if (this == eCPoint) {
                return twice();
            }
            ECCurve eCCurve = this.curve;
            int i = eCCurve.coord;
            ECFieldElement eCFieldElement5 = this.x;
            ECFieldElement eCFieldElement6 = this.y;
            ECFieldElement eCFieldElement7 = eCPoint.x;
            ECFieldElement eCFieldElement8 = eCPoint.y;
            if (i == 0) {
                ECFieldElement subtract = eCFieldElement7.subtract(eCFieldElement5);
                ECFieldElement subtract2 = eCFieldElement8.subtract(eCFieldElement6);
                if (!subtract.isZero()) {
                    ECFieldElement divide = subtract2.divide(subtract);
                    ECFieldElement subtract3 = divide.square().subtract(eCFieldElement5).subtract(eCFieldElement7);
                    return new Fp(eCCurve, subtract3, divide.multiply(eCFieldElement5.subtract(subtract3)).subtract(eCFieldElement6), this.withCompression);
                } else if (subtract2.isZero()) {
                    return twice();
                } else {
                    return eCCurve.getInfinity();
                }
            } else if (i == 1) {
                ECFieldElement eCFieldElement9 = this.zs[0];
                ECFieldElement eCFieldElement10 = eCPoint.zs[0];
                boolean isOne = eCFieldElement9.isOne();
                boolean isOne2 = eCFieldElement10.isOne();
                if (!isOne) {
                    eCFieldElement8 = eCFieldElement8.multiply(eCFieldElement9);
                }
                if (!isOne2) {
                    eCFieldElement6 = eCFieldElement6.multiply(eCFieldElement10);
                }
                ECFieldElement subtract4 = eCFieldElement8.subtract(eCFieldElement6);
                if (!isOne) {
                    eCFieldElement7 = eCFieldElement7.multiply(eCFieldElement9);
                }
                if (!isOne2) {
                    eCFieldElement5 = eCFieldElement5.multiply(eCFieldElement10);
                }
                ECFieldElement subtract5 = eCFieldElement7.subtract(eCFieldElement5);
                if (!subtract5.isZero()) {
                    if (isOne) {
                        eCFieldElement9 = eCFieldElement10;
                    } else if (!isOne2) {
                        eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement10);
                    }
                    ECFieldElement square = subtract5.square();
                    ECFieldElement multiply = square.multiply(subtract5);
                    ECFieldElement multiply2 = square.multiply(eCFieldElement5);
                    ECFieldElement subtract6 = subtract4.square().multiply(eCFieldElement9).subtract(multiply).subtract(multiply2.add(multiply2));
                    return new Fp(eCCurve, subtract5.multiply(subtract6), multiply2.subtract(subtract6).multiplyMinusProduct(subtract4, eCFieldElement6, multiply), new ECFieldElement[]{multiply.multiply(eCFieldElement9)}, this.withCompression);
                } else if (subtract4.isZero()) {
                    return twice();
                } else {
                    return eCCurve.getInfinity();
                }
            } else if (i == 2 || i == 4) {
                ECFieldElement eCFieldElement11 = this.zs[0];
                ECFieldElement eCFieldElement12 = eCPoint.zs[0];
                boolean isOne3 = eCFieldElement11.isOne();
                if (isOne3 || !eCFieldElement11.equals(eCFieldElement12)) {
                    if (!isOne3) {
                        ECFieldElement square2 = eCFieldElement11.square();
                        eCFieldElement7 = square2.multiply(eCFieldElement7);
                        eCFieldElement8 = square2.multiply(eCFieldElement11).multiply(eCFieldElement8);
                    }
                    boolean isOne4 = eCFieldElement12.isOne();
                    if (!isOne4) {
                        ECFieldElement square3 = eCFieldElement12.square();
                        eCFieldElement5 = square3.multiply(eCFieldElement5);
                        eCFieldElement6 = square3.multiply(eCFieldElement12).multiply(eCFieldElement6);
                    }
                    ECFieldElement subtract7 = eCFieldElement5.subtract(eCFieldElement7);
                    ECFieldElement subtract8 = eCFieldElement6.subtract(eCFieldElement8);
                    if (!subtract7.isZero()) {
                        eCFieldElement = subtract7.square();
                        ECFieldElement multiply3 = eCFieldElement.multiply(subtract7);
                        ECFieldElement multiply4 = eCFieldElement.multiply(eCFieldElement5);
                        ECFieldElement subtract9 = subtract8.square().add(multiply3).subtract(multiply4.add(multiply4));
                        ECFieldElement multiplyMinusProduct = multiply4.subtract(subtract9).multiplyMinusProduct(subtract8, multiply3, eCFieldElement6);
                        ECFieldElement multiply5 = !isOne3 ? subtract7.multiply(eCFieldElement11) : subtract7;
                        eCFieldElement4 = !isOne4 ? multiply5.multiply(eCFieldElement12) : multiply5;
                        eCFieldElement2 = multiplyMinusProduct;
                        eCFieldElement3 = subtract9;
                    } else if (subtract8.isZero()) {
                        return twice();
                    } else {
                        return eCCurve.getInfinity();
                    }
                } else {
                    ECFieldElement subtract10 = eCFieldElement5.subtract(eCFieldElement7);
                    ECFieldElement subtract11 = eCFieldElement6.subtract(eCFieldElement8);
                    if (!subtract10.isZero()) {
                        ECFieldElement square4 = subtract10.square();
                        ECFieldElement multiply6 = eCFieldElement5.multiply(square4);
                        ECFieldElement multiply7 = eCFieldElement7.multiply(square4);
                        ECFieldElement multiply8 = multiply6.subtract(multiply7).multiply(eCFieldElement6);
                        ECFieldElement subtract12 = subtract11.square().subtract(multiply6).subtract(multiply7);
                        ECFieldElement subtract13 = multiply6.subtract(subtract12).multiply(subtract11).subtract(multiply8);
                        eCFieldElement4 = subtract10.multiply(eCFieldElement11);
                        eCFieldElement2 = subtract13;
                        eCFieldElement3 = subtract12;
                    } else if (subtract11.isZero()) {
                        return twice();
                    } else {
                        return eCCurve.getInfinity();
                    }
                }
                eCFieldElement = null;
                return new Fp(eCCurve, eCFieldElement3, eCFieldElement2, i == 4 ? new ECFieldElement[]{eCFieldElement4, calculateJacobianModifiedW(eCFieldElement4, eCFieldElement)} : new ECFieldElement[]{eCFieldElement4}, this.withCompression);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public ECFieldElement calculateJacobianModifiedW(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            ECFieldElement eCFieldElement3 = this.curve.a;
            if (eCFieldElement3.isZero() || eCFieldElement.isOne()) {
                return eCFieldElement3;
            }
            if (eCFieldElement2 == null) {
                eCFieldElement2 = eCFieldElement.square();
            }
            ECFieldElement square = eCFieldElement2.square();
            ECFieldElement negate = eCFieldElement3.negate();
            if (negate.bitLength() < eCFieldElement3.bitLength()) {
                return square.multiply(negate).negate();
            }
            return square.multiply(eCFieldElement3);
        }

        public ECFieldElement four(ECFieldElement eCFieldElement) {
            ECFieldElement add = eCFieldElement.add(eCFieldElement);
            return add.add(add);
        }

        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement[] eCFieldElementArr = this.zs;
            ECFieldElement eCFieldElement = eCFieldElementArr[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement calculateJacobianModifiedW = calculateJacobianModifiedW(eCFieldElementArr[0], null);
            eCFieldElementArr[1] = calculateJacobianModifiedW;
            return calculateJacobianModifiedW;
        }

        @Override // org.spongycastle.math.ec.ECPoint
        public ECFieldElement getZCoord(int i) {
            if (i == 1 && 4 == getCurveCoordinateSystem()) {
                return getJacobianModifiedW();
            }
            return ECPoint.super.getZCoord(i);
        }

        @Override // org.spongycastle.math.ec.ECPoint
        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECCurve eCCurve = this.curve;
            if (eCCurve.coord != 0) {
                return new Fp(eCCurve, this.x, this.y.negate(), this.zs, this.withCompression);
            }
            return new Fp(eCCurve, this.x, this.y.negate(), this.withCompression);
        }

        public ECFieldElement three(ECFieldElement eCFieldElement) {
            return eCFieldElement.add(eCFieldElement).add(eCFieldElement);
        }

        @Override // org.spongycastle.math.ec.ECPoint
        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            if (isInfinity()) {
                return this;
            }
            ECCurve eCCurve = this.curve;
            ECFieldElement eCFieldElement6 = this.y;
            if (eCFieldElement6.isZero()) {
                return eCCurve.getInfinity();
            }
            int i = eCCurve.coord;
            ECFieldElement eCFieldElement7 = this.x;
            if (i == 0) {
                ECFieldElement divide = three(eCFieldElement7.square()).add(this.curve.a).divide(eCFieldElement6.add(eCFieldElement6));
                ECFieldElement subtract = divide.square().subtract(eCFieldElement7.add(eCFieldElement7));
                return new Fp(eCCurve, subtract, divide.multiply(eCFieldElement7.subtract(subtract)).subtract(eCFieldElement6), this.withCompression);
            } else if (i == 1) {
                ECFieldElement eCFieldElement8 = this.zs[0];
                boolean isOne = eCFieldElement8.isOne();
                ECFieldElement eCFieldElement9 = eCCurve.a;
                if (!eCFieldElement9.isZero() && !isOne) {
                    eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement8.square());
                }
                ECFieldElement add = eCFieldElement9.add(three(eCFieldElement7.square()));
                if (isOne) {
                    eCFieldElement = eCFieldElement6;
                } else {
                    eCFieldElement = eCFieldElement6.multiply(eCFieldElement8);
                }
                ECFieldElement square = isOne ? eCFieldElement6.square() : eCFieldElement.multiply(eCFieldElement6);
                ECFieldElement four = four(eCFieldElement7.multiply(square));
                ECFieldElement subtract2 = add.square().subtract(four.add(four));
                ECFieldElement add2 = eCFieldElement.add(eCFieldElement);
                ECFieldElement multiply = subtract2.multiply(add2);
                ECFieldElement add3 = square.add(square);
                ECFieldElement multiply2 = four.subtract(subtract2).multiply(add);
                ECFieldElement square2 = add3.square();
                ECFieldElement subtract3 = multiply2.subtract(square2.add(square2));
                if (isOne) {
                    eCFieldElement2 = add3.add(add3);
                } else {
                    eCFieldElement2 = add2.square();
                }
                return new Fp(eCCurve, multiply, subtract3, new ECFieldElement[]{eCFieldElement2.add(eCFieldElement2).multiply(eCFieldElement)}, this.withCompression);
            } else if (i == 2) {
                ECFieldElement eCFieldElement10 = this.zs[0];
                boolean isOne2 = eCFieldElement10.isOne();
                ECFieldElement square3 = eCFieldElement6.square();
                ECFieldElement square4 = square3.square();
                ECFieldElement eCFieldElement11 = eCCurve.a;
                ECFieldElement negate = eCFieldElement11.negate();
                if (negate.toBigInteger().equals(BigInteger.valueOf(3))) {
                    if (isOne2) {
                        eCFieldElement5 = eCFieldElement10;
                    } else {
                        eCFieldElement5 = eCFieldElement10.square();
                    }
                    eCFieldElement3 = three(eCFieldElement7.add(eCFieldElement5).multiply(eCFieldElement7.subtract(eCFieldElement5)));
                    eCFieldElement4 = four(square3.multiply(eCFieldElement7));
                } else {
                    ECFieldElement three = three(eCFieldElement7.square());
                    if (isOne2) {
                        eCFieldElement3 = three.add(eCFieldElement11);
                    } else if (!eCFieldElement11.isZero()) {
                        ECFieldElement square5 = eCFieldElement10.square().square();
                        eCFieldElement3 = negate.bitLength() < eCFieldElement11.bitLength() ? three.subtract(square5.multiply(negate)) : three.add(square5.multiply(eCFieldElement11));
                    } else {
                        eCFieldElement3 = three;
                    }
                    eCFieldElement4 = four(eCFieldElement7.multiply(square3));
                }
                ECFieldElement subtract4 = eCFieldElement3.square().subtract(eCFieldElement4.add(eCFieldElement4));
                ECFieldElement subtract5 = eCFieldElement4.subtract(subtract4).multiply(eCFieldElement3).subtract(four(square4.add(square4)));
                ECFieldElement add4 = eCFieldElement6.add(eCFieldElement6);
                if (!isOne2) {
                    add4 = add4.multiply(eCFieldElement10);
                }
                return new Fp(eCCurve, subtract4, subtract5, new ECFieldElement[]{add4}, this.withCompression);
            } else if (i == 4) {
                ECFieldElement eCFieldElement12 = this.y;
                ECFieldElement eCFieldElement13 = this.zs[0];
                ECFieldElement jacobianModifiedW = getJacobianModifiedW();
                ECFieldElement add5 = three(eCFieldElement7.square()).add(jacobianModifiedW);
                ECFieldElement add6 = eCFieldElement12.add(eCFieldElement12);
                ECFieldElement multiply3 = add6.multiply(eCFieldElement12);
                ECFieldElement multiply4 = eCFieldElement7.multiply(multiply3);
                ECFieldElement add7 = multiply4.add(multiply4);
                ECFieldElement subtract6 = add5.square().subtract(add7.add(add7));
                ECFieldElement square6 = multiply3.square();
                ECFieldElement add8 = square6.add(square6);
                ECFieldElement subtract7 = add5.multiply(add7.subtract(subtract6)).subtract(add8);
                ECFieldElement multiply5 = add8.multiply(jacobianModifiedW);
                ECFieldElement add9 = multiply5.add(multiply5);
                if (!eCFieldElement13.isOne()) {
                    add6 = add6.multiply(eCFieldElement13);
                }
                return new Fp(this.curve, subtract6, subtract7, new ECFieldElement[]{add6, add9}, this.withCompression);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.withCompression = z;
        }
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        ECFieldElement[] eCFieldElementArr;
        int i = eCCurve == null ? 0 : eCCurve.coord;
        if (i == 0 || i == 5) {
            eCFieldElementArr = EMPTY_ZS;
        } else {
            ECFieldElement fromBigInteger = eCCurve.fromBigInteger(ECConstants.ONE);
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    eCFieldElementArr = new ECFieldElement[]{fromBigInteger, fromBigInteger, fromBigInteger};
                } else if (i == 4) {
                    eCFieldElementArr = new ECFieldElement[]{fromBigInteger, eCCurve.a};
                } else if (i != 6) {
                    throw new IllegalArgumentException("unknown coordinate system");
                }
            }
            eCFieldElementArr = new ECFieldElement[]{fromBigInteger};
        }
        this.curve = eCCurve;
        this.x = eCFieldElement;
        this.y = eCFieldElement2;
        this.zs = eCFieldElementArr;
    }

    public ECPoint normalize(ECFieldElement eCFieldElement) {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem != 1) {
            if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                ECFieldElement square = eCFieldElement.square();
                return createScaledPoint(square, square.multiply(eCFieldElement));
            } else if (curveCoordinateSystem != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return createScaledPoint(eCFieldElement, eCFieldElement);
    }

    public static class F2m extends AbstractF2m {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
                if (eCFieldElement != null) {
                    ECFieldElement.F2m.checkFieldElements(this.x, this.y);
                    if (eCCurve != null) {
                        ECFieldElement.F2m.checkFieldElements(this.x, this.curve.a);
                    }
                }
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        @Override // org.spongycastle.math.ec.ECPoint
        public ECPoint add(ECPoint eCPoint) {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECFieldElement eCFieldElement7;
            ECFieldElement eCFieldElement8;
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            ECCurve eCCurve = this.curve;
            int i = eCCurve.coord;
            ECFieldElement eCFieldElement9 = this.x;
            ECFieldElement eCFieldElement10 = eCPoint.x;
            if (i == 0) {
                ECFieldElement eCFieldElement11 = this.y;
                ECFieldElement eCFieldElement12 = eCPoint.y;
                ECFieldElement add = eCFieldElement9.add(eCFieldElement10);
                ECFieldElement add2 = eCFieldElement11.add(eCFieldElement12);
                if (!add.isZero()) {
                    ECFieldElement divide = add2.divide(add);
                    ECFieldElement add3 = divide.square().add(divide).add(add).add(eCCurve.a);
                    return new F2m(eCCurve, add3, divide.multiply(eCFieldElement9.add(add3)).add(add3).add(eCFieldElement11), this.withCompression);
                } else if (add2.isZero()) {
                    return twice();
                } else {
                    return eCCurve.getInfinity();
                }
            } else if (i == 1) {
                ECFieldElement eCFieldElement13 = this.y;
                ECFieldElement eCFieldElement14 = this.zs[0];
                ECFieldElement eCFieldElement15 = eCPoint.y;
                ECFieldElement eCFieldElement16 = eCPoint.zs[0];
                boolean isOne = eCFieldElement16.isOne();
                ECFieldElement multiply = eCFieldElement14.multiply(eCFieldElement15);
                if (isOne) {
                    eCFieldElement = eCFieldElement13;
                } else {
                    eCFieldElement = eCFieldElement13.multiply(eCFieldElement16);
                }
                ECFieldElement add4 = multiply.add(eCFieldElement);
                ECFieldElement multiply2 = eCFieldElement14.multiply(eCFieldElement10);
                if (isOne) {
                    eCFieldElement2 = eCFieldElement9;
                } else {
                    eCFieldElement2 = eCFieldElement9.multiply(eCFieldElement16);
                }
                ECFieldElement add5 = multiply2.add(eCFieldElement2);
                if (!add5.isZero()) {
                    ECFieldElement square = add5.square();
                    ECFieldElement multiply3 = square.multiply(add5);
                    if (!isOne) {
                        eCFieldElement14 = eCFieldElement14.multiply(eCFieldElement16);
                    }
                    ECFieldElement add6 = add4.add(add5);
                    ECFieldElement add7 = add6.multiplyPlusProduct(add4, square, eCCurve.a).multiply(eCFieldElement14).add(multiply3);
                    ECFieldElement multiply4 = add5.multiply(add7);
                    if (!isOne) {
                        square = square.multiply(eCFieldElement16);
                    }
                    return new F2m(eCCurve, multiply4, add4.multiplyPlusProduct(eCFieldElement9, add5, eCFieldElement13).multiplyPlusProduct(square, add6, add7), new ECFieldElement[]{multiply3.multiply(eCFieldElement14)}, this.withCompression);
                } else if (add4.isZero()) {
                    return twice();
                } else {
                    return eCCurve.getInfinity();
                }
            } else if (i != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            } else if (!eCFieldElement9.isZero()) {
                ECFieldElement eCFieldElement17 = this.y;
                ECFieldElement eCFieldElement18 = this.zs[0];
                ECFieldElement eCFieldElement19 = eCPoint.y;
                ECFieldElement eCFieldElement20 = eCPoint.zs[0];
                boolean isOne2 = eCFieldElement18.isOne();
                if (!isOne2) {
                    eCFieldElement4 = eCFieldElement10.multiply(eCFieldElement18);
                    eCFieldElement3 = eCFieldElement19.multiply(eCFieldElement18);
                } else {
                    eCFieldElement4 = eCFieldElement10;
                    eCFieldElement3 = eCFieldElement19;
                }
                boolean isOne3 = eCFieldElement20.isOne();
                if (!isOne3) {
                    eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement20);
                    eCFieldElement5 = eCFieldElement17.multiply(eCFieldElement20);
                } else {
                    eCFieldElement5 = eCFieldElement17;
                }
                ECFieldElement add8 = eCFieldElement5.add(eCFieldElement3);
                ECFieldElement add9 = eCFieldElement9.add(eCFieldElement4);
                if (!add9.isZero()) {
                    if (eCFieldElement10.isZero()) {
                        ECPoint normalize = normalize();
                        ECFieldElement eCFieldElement21 = normalize.x;
                        ECFieldElement yCoord = normalize.getYCoord();
                        ECFieldElement divide2 = yCoord.add(eCFieldElement19).divide(eCFieldElement21);
                        eCFieldElement6 = divide2.square().add(divide2).add(eCFieldElement21).add(eCCurve.a);
                        if (eCFieldElement6.isZero()) {
                            return new F2m(eCCurve, eCFieldElement6, eCCurve.b.sqrt(), this.withCompression);
                        }
                        eCFieldElement8 = divide2.multiply(eCFieldElement21.add(eCFieldElement6)).add(eCFieldElement6).add(yCoord).divide(eCFieldElement6).add(eCFieldElement6);
                        eCFieldElement7 = eCCurve.fromBigInteger(ECConstants.ONE);
                    } else {
                        ECFieldElement square2 = add9.square();
                        ECFieldElement multiply5 = add8.multiply(eCFieldElement9);
                        ECFieldElement multiply6 = add8.multiply(eCFieldElement4);
                        ECFieldElement multiply7 = multiply5.multiply(multiply6);
                        if (multiply7.isZero()) {
                            return new F2m(eCCurve, multiply7, eCCurve.b.sqrt(), this.withCompression);
                        }
                        ECFieldElement multiply8 = add8.multiply(square2);
                        ECFieldElement multiply9 = !isOne3 ? multiply8.multiply(eCFieldElement20) : multiply8;
                        ECFieldElement squarePlusProduct = multiply6.add(square2).squarePlusProduct(multiply9, eCFieldElement17.add(eCFieldElement18));
                        if (!isOne2) {
                            multiply9 = multiply9.multiply(eCFieldElement18);
                        }
                        eCFieldElement6 = multiply7;
                        eCFieldElement7 = multiply9;
                        eCFieldElement8 = squarePlusProduct;
                    }
                    return new F2m(eCCurve, eCFieldElement6, eCFieldElement8, new ECFieldElement[]{eCFieldElement7}, this.withCompression);
                } else if (add8.isZero()) {
                    return twice();
                } else {
                    return eCCurve.getInfinity();
                }
            } else if (eCFieldElement10.isZero()) {
                return eCCurve.getInfinity();
            } else {
                return eCPoint.add(this);
            }
        }

        @Override // org.spongycastle.math.ec.ECPoint
        public ECFieldElement getYCoord() {
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return this.y;
            }
            ECFieldElement eCFieldElement = this.x;
            ECFieldElement eCFieldElement2 = this.y;
            if (isInfinity() || eCFieldElement.isZero()) {
                return eCFieldElement2;
            }
            ECFieldElement multiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
            if (6 != curveCoordinateSystem) {
                return multiply;
            }
            ECFieldElement eCFieldElement3 = this.zs[0];
            return !eCFieldElement3.isOne() ? multiply.divide(eCFieldElement3) : multiply;
        }

        @Override // org.spongycastle.math.ec.ECPoint
        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.x;
            if (eCFieldElement.isZero()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 0) {
                return new F2m(this.curve, eCFieldElement, this.y.add(eCFieldElement), this.withCompression);
            } else if (curveCoordinateSystem == 1) {
                ECFieldElement eCFieldElement2 = this.y;
                ECFieldElement eCFieldElement3 = this.zs[0];
                return new F2m(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement), new ECFieldElement[]{eCFieldElement3}, this.withCompression);
            } else if (curveCoordinateSystem == 5) {
                return new F2m(this.curve, eCFieldElement, this.y.addOne(), this.withCompression);
            } else if (curveCoordinateSystem == 6) {
                ECFieldElement eCFieldElement4 = this.y;
                ECFieldElement eCFieldElement5 = this.zs[0];
                return new F2m(this.curve, eCFieldElement, eCFieldElement4.add(eCFieldElement5), new ECFieldElement[]{eCFieldElement5}, this.withCompression);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        @Override // org.spongycastle.math.ec.ECPoint
        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECFieldElement eCFieldElement7;
            if (isInfinity()) {
                return this;
            }
            ECCurve eCCurve = this.curve;
            ECFieldElement eCFieldElement8 = this.x;
            if (eCFieldElement8.isZero()) {
                return eCCurve.getInfinity();
            }
            int i = eCCurve.coord;
            if (i == 0) {
                ECFieldElement add = this.y.divide(eCFieldElement8).add(eCFieldElement8);
                ECFieldElement add2 = add.square().add(add).add(eCCurve.a);
                return new F2m(eCCurve, add2, eCFieldElement8.squarePlusProduct(add2, add.addOne()), this.withCompression);
            } else if (i == 1) {
                ECFieldElement eCFieldElement9 = this.y;
                ECFieldElement eCFieldElement10 = this.zs[0];
                boolean isOne = eCFieldElement10.isOne();
                if (isOne) {
                    eCFieldElement = eCFieldElement8;
                } else {
                    eCFieldElement = eCFieldElement8.multiply(eCFieldElement10);
                }
                if (!isOne) {
                    eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement10);
                }
                ECFieldElement square = eCFieldElement8.square();
                ECFieldElement add3 = square.add(eCFieldElement9);
                ECFieldElement square2 = eCFieldElement.square();
                ECFieldElement add4 = add3.add(eCFieldElement);
                ECFieldElement multiplyPlusProduct = add4.multiplyPlusProduct(add3, square2, eCCurve.a);
                return new F2m(eCCurve, eCFieldElement.multiply(multiplyPlusProduct), square.square().multiplyPlusProduct(eCFieldElement, multiplyPlusProduct, add4), new ECFieldElement[]{eCFieldElement.multiply(square2)}, this.withCompression);
            } else if (i == 6) {
                ECFieldElement eCFieldElement11 = this.y;
                ECFieldElement eCFieldElement12 = this.zs[0];
                boolean isOne2 = eCFieldElement12.isOne();
                if (isOne2) {
                    eCFieldElement2 = eCFieldElement11;
                } else {
                    eCFieldElement2 = eCFieldElement11.multiply(eCFieldElement12);
                }
                if (isOne2) {
                    eCFieldElement3 = eCFieldElement12;
                } else {
                    eCFieldElement3 = eCFieldElement12.square();
                }
                ECFieldElement eCFieldElement13 = eCCurve.a;
                if (isOne2) {
                    eCFieldElement4 = eCFieldElement13;
                } else {
                    eCFieldElement4 = eCFieldElement13.multiply(eCFieldElement3);
                }
                ECFieldElement add5 = eCFieldElement11.square().add(eCFieldElement2).add(eCFieldElement4);
                if (add5.isZero()) {
                    return new F2m(eCCurve, add5, eCCurve.b.sqrt(), this.withCompression);
                }
                ECFieldElement square3 = add5.square();
                if (isOne2) {
                    eCFieldElement5 = add5;
                } else {
                    eCFieldElement5 = add5.multiply(eCFieldElement3);
                }
                ECFieldElement eCFieldElement14 = eCCurve.b;
                if (eCFieldElement14.bitLength() < (eCCurve.getFieldSize() >> 1)) {
                    ECFieldElement square4 = eCFieldElement11.add(eCFieldElement8).square();
                    if (eCFieldElement14.isOne()) {
                        eCFieldElement7 = eCFieldElement4.add(eCFieldElement3).square();
                    } else {
                        eCFieldElement7 = eCFieldElement4.squarePlusProduct(eCFieldElement14, eCFieldElement3.square());
                    }
                    eCFieldElement6 = square4.add(add5).add(eCFieldElement3).multiply(square4).add(eCFieldElement7).add(square3);
                    if (eCFieldElement13.isZero()) {
                        eCFieldElement6 = eCFieldElement6.add(eCFieldElement5);
                    } else if (!eCFieldElement13.isOne()) {
                        eCFieldElement6 = eCFieldElement6.add(eCFieldElement13.addOne().multiply(eCFieldElement5));
                    }
                } else {
                    if (!isOne2) {
                        eCFieldElement8 = eCFieldElement8.multiply(eCFieldElement12);
                    }
                    eCFieldElement6 = eCFieldElement8.squarePlusProduct(add5, eCFieldElement2).add(square3).add(eCFieldElement5);
                }
                return new F2m(eCCurve, square3, eCFieldElement6, new ECFieldElement[]{eCFieldElement5}, this.withCompression);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.withCompression = z;
        }
    }
}
