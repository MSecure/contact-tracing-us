package org.spongycastle.math.ec;

import androidx.recyclerview.widget.RecyclerView;
import com.google.common.util.concurrent.MoreExecutors;
import java.math.BigInteger;
import java.util.Random;

public abstract class ECFieldElement implements ECConstants {

    public static class Fp extends ECFieldElement {
        public BigInteger q;
        public BigInteger r;
        public BigInteger x;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.q = bigInteger;
            this.r = bigInteger2;
            this.x = bigInteger3;
        }

        public static BigInteger calculateResidue(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.ONE.shiftLeft(bitLength).subtract(bigInteger);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            BigInteger bigInteger = this.q;
            BigInteger bigInteger2 = this.r;
            BigInteger add = this.x.add(eCFieldElement.toBigInteger());
            if (add.compareTo(this.q) >= 0) {
                add = add.subtract(this.q);
            }
            return new Fp(bigInteger, bigInteger2, add);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            BigInteger add = this.x.add(ECConstants.ONE);
            if (add.compareTo(this.q) == 0) {
                add = ECConstants.ZERO;
            }
            return new Fp(this.q, this.r, add);
        }

        public final ECFieldElement checkSqrt(ECFieldElement eCFieldElement) {
            if (eCFieldElement.square().equals(this)) {
                return eCFieldElement;
            }
            return null;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.r, modReduce(this.x.multiply(modInverse(eCFieldElement.toBigInteger()))));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp) obj;
            return this.q.equals(fp.q) && this.x.equals(fp.x);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.q.bitLength();
        }

        public int hashCode() {
            return this.q.hashCode() ^ this.x.hashCode();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            return new Fp(this.q, this.r, modInverse(this.x));
        }

        public BigInteger modDouble(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            return shiftLeft.compareTo(this.q) >= 0 ? shiftLeft.subtract(this.q) : shiftLeft;
        }

        public BigInteger modInverse(BigInteger bigInteger) {
            boolean z;
            boolean z2;
            int bitLength = this.q.bitLength();
            int i = (bitLength + 31) >> 5;
            int[] fromBigInteger = MoreExecutors.fromBigInteger(bitLength, this.q);
            int[] fromBigInteger2 = MoreExecutors.fromBigInteger(bitLength, bigInteger);
            int[] iArr = new int[i];
            int length = fromBigInteger.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else if (fromBigInteger2[i2] != 0) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                if (MoreExecutors.isOne(length, fromBigInteger2)) {
                    System.arraycopy(fromBigInteger2, 0, iArr, 0, length);
                } else {
                    int[] iArr2 = new int[length];
                    System.arraycopy(fromBigInteger2, 0, iArr2, 0, length);
                    int[] iArr3 = new int[length];
                    iArr3[0] = 1;
                    int inversionStep = (iArr2[0] & 1) == 0 ? MoreExecutors.inversionStep(fromBigInteger, iArr2, length, iArr3, 0) : 0;
                    if (MoreExecutors.isOne(length, iArr2)) {
                        MoreExecutors.inversionResult(fromBigInteger, inversionStep, iArr3, iArr);
                    } else {
                        int[] iArr4 = new int[length];
                        System.arraycopy(fromBigInteger, 0, iArr4, 0, length);
                        int[] iArr5 = new int[length];
                        int i3 = length;
                        int i4 = 0;
                        while (true) {
                            int i5 = i3 - 1;
                            if (iArr2[i5] != 0 || iArr4[i5] != 0) {
                                while (true) {
                                    if (i5 < 0) {
                                        break;
                                    }
                                    int i6 = iArr2[i5] ^ RecyclerView.UNDEFINED_DURATION;
                                    int i7 = iArr4[i5] ^ RecyclerView.UNDEFINED_DURATION;
                                    if (i6 < i7) {
                                        z2 = false;
                                        break;
                                    } else if (i6 > i7) {
                                        break;
                                    } else {
                                        i5--;
                                    }
                                }
                                z2 = true;
                                if (z2) {
                                    MoreExecutors.subFrom(i3, iArr4, iArr2);
                                    inversionStep = MoreExecutors.inversionStep(fromBigInteger, iArr2, i3, iArr3, (MoreExecutors.subFrom(length, iArr5, iArr3) - i4) + inversionStep);
                                    if (MoreExecutors.isOne(i3, iArr2)) {
                                        MoreExecutors.inversionResult(fromBigInteger, inversionStep, iArr3, iArr);
                                        break;
                                    }
                                } else {
                                    MoreExecutors.subFrom(i3, iArr2, iArr4);
                                    i4 = MoreExecutors.inversionStep(fromBigInteger, iArr4, i3, iArr5, (MoreExecutors.subFrom(length, iArr3, iArr5) - inversionStep) + i4);
                                    if (MoreExecutors.isOne(i3, iArr4)) {
                                        MoreExecutors.inversionResult(fromBigInteger, i4, iArr5, iArr);
                                        break;
                                    }
                                }
                            } else {
                                i3 = i5;
                            }
                        }
                    }
                }
                byte[] bArr = new byte[(i << 2)];
                for (int i8 = 0; i8 < i; i8++) {
                    int i9 = iArr[i8];
                    if (i9 != 0) {
                        MoreExecutors.intToBigEndian(i9, bArr, ((i - 1) - i8) << 2);
                    }
                }
                return new BigInteger(1, bArr);
            }
            throw new IllegalArgumentException("'x' cannot be 0");
        }

        public BigInteger modMult(BigInteger bigInteger, BigInteger bigInteger2) {
            return modReduce(bigInteger.multiply(bigInteger2));
        }

        public BigInteger modReduce(BigInteger bigInteger) {
            if (this.r == null) {
                return bigInteger.mod(this.q);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.q.bitLength();
            boolean equals = this.r.equals(ECConstants.ONE);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.r);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.q) >= 0) {
                bigInteger = bigInteger.subtract(this.q);
            }
            if (!z || bigInteger.signum() == 0) {
                return bigInteger;
            }
            return this.q.subtract(bigInteger);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.r, modMult(this.x, eCFieldElement.toBigInteger()));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.q, this.r, modReduce(bigInteger.multiply(bigInteger2).subtract(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.q, this.r, modReduce(bigInteger.multiply(bigInteger2).add(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            if (this.x.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.q;
            return new Fp(bigInteger, this.r, bigInteger.subtract(this.x));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            BigInteger bigInteger;
            if (isZero() || isOne()) {
                return this;
            }
            boolean z = false;
            if (this.q.testBit(0)) {
                int i = 1;
                if (this.q.testBit(1)) {
                    BigInteger add = this.q.shiftRight(2).add(ECConstants.ONE);
                    BigInteger bigInteger2 = this.q;
                    return checkSqrt(new Fp(bigInteger2, this.r, this.x.modPow(add, bigInteger2)));
                } else if (this.q.testBit(2)) {
                    BigInteger modPow = this.x.modPow(this.q.shiftRight(3), this.q);
                    BigInteger modMult = modMult(modPow, this.x);
                    if (modMult(modMult, modPow).equals(ECConstants.ONE)) {
                        return checkSqrt(new Fp(this.q, this.r, modMult));
                    }
                    return checkSqrt(new Fp(this.q, this.r, modMult(modMult, ECConstants.TWO.modPow(this.q.shiftRight(2), this.q))));
                } else {
                    BigInteger shiftRight = this.q.shiftRight(1);
                    boolean z2 = false;
                    if (!this.x.modPow(shiftRight, this.q).equals(ECConstants.ONE)) {
                        return null;
                    }
                    BigInteger bigInteger3 = this.x;
                    BigInteger modDouble = modDouble(modDouble(bigInteger3));
                    BigInteger add2 = shiftRight.add(ECConstants.ONE);
                    BigInteger subtract = this.q.subtract(ECConstants.ONE);
                    Random random = new Random();
                    while (true) {
                        BigInteger bigInteger4 = new BigInteger(this.q.bitLength(), random);
                        if (bigInteger4.compareTo(this.q) >= 0 || !modReduce(bigInteger4.multiply(bigInteger4).subtract(modDouble)).modPow(shiftRight, this.q).equals(subtract)) {
                            z = z;
                        } else {
                            int bitLength = add2.bitLength();
                            int lowestSetBit = add2.getLowestSetBit();
                            BigInteger bigInteger5 = ECConstants.ONE;
                            BigInteger bigInteger6 = ECConstants.TWO;
                            int i2 = bitLength - i;
                            BigInteger bigInteger7 = bigInteger4;
                            BigInteger bigInteger8 = ECConstants.ONE;
                            BigInteger bigInteger9 = bigInteger8;
                            while (i2 >= lowestSetBit + 1) {
                                bigInteger9 = modMult(bigInteger9, bigInteger8);
                                if (add2.testBit(i2)) {
                                    bigInteger8 = modReduce(bigInteger9.multiply(bigInteger3));
                                    BigInteger modMult2 = modMult(bigInteger5, bigInteger7);
                                    BigInteger modReduce = modReduce(bigInteger7.multiply(bigInteger6).subtract(bigInteger4.multiply(bigInteger9)));
                                    bigInteger = shiftRight;
                                    bigInteger7 = modReduce(bigInteger7.multiply(bigInteger7).subtract(bigInteger8.shiftLeft(1)));
                                    bigInteger6 = modReduce;
                                    bigInteger5 = modMult2;
                                } else {
                                    bigInteger = shiftRight;
                                    bigInteger5 = modReduce(bigInteger5.multiply(bigInteger6).subtract(bigInteger9));
                                    bigInteger7 = modReduce(bigInteger7.multiply(bigInteger6).subtract(bigInteger4.multiply(bigInteger9)));
                                    bigInteger6 = modReduce(bigInteger6.multiply(bigInteger6).subtract(bigInteger9.shiftLeft(1)));
                                    bigInteger8 = bigInteger9;
                                }
                                i2--;
                                shiftRight = bigInteger;
                            }
                            BigInteger modMult3 = modMult(bigInteger9, bigInteger8);
                            BigInteger modReduce2 = modReduce(modMult3.multiply(bigInteger3));
                            BigInteger modReduce3 = modReduce(bigInteger5.multiply(bigInteger6).subtract(modMult3));
                            BigInteger modReduce4 = modReduce(bigInteger7.multiply(bigInteger6).subtract(bigInteger4.multiply(modMult3)));
                            BigInteger modMult4 = modMult(modMult3, modReduce2);
                            for (int i3 = 1; i3 <= lowestSetBit; i3++) {
                                modReduce3 = modMult(modReduce3, modReduce4);
                                modReduce4 = modReduce(modReduce4.multiply(modReduce4).subtract(modMult4.shiftLeft(1)));
                                modMult4 = modReduce(modMult4.multiply(modMult4));
                            }
                            BigInteger[] bigIntegerArr = {modReduce3, modReduce4};
                            BigInteger bigInteger10 = bigIntegerArr[0];
                            BigInteger bigInteger11 = bigIntegerArr[1];
                            if (modMult(bigInteger11, bigInteger11).equals(modDouble)) {
                                BigInteger bigInteger12 = this.q;
                                BigInteger bigInteger13 = this.r;
                                if (bigInteger11.testBit(0)) {
                                    bigInteger11 = this.q.subtract(bigInteger11);
                                }
                                return new Fp(bigInteger12, bigInteger13, bigInteger11.shiftRight(1));
                            } else if (!bigInteger10.equals(ECConstants.ONE) && !bigInteger10.equals(subtract)) {
                                return null;
                            } else {
                                i = 1;
                                z = false;
                                shiftRight = shiftRight;
                                z2 = false;
                            }
                        }
                    }
                }
            } else {
                throw new RuntimeException("not done yet");
            }
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger bigInteger = this.q;
            BigInteger bigInteger2 = this.r;
            BigInteger bigInteger3 = this.x;
            return new Fp(bigInteger, bigInteger2, modMult(bigInteger3, bigInteger3));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new Fp(this.q, this.r, modReduce(bigInteger.multiply(bigInteger).add(bigInteger2.multiply(bigInteger3))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            BigInteger bigInteger = this.q;
            BigInteger bigInteger2 = this.r;
            BigInteger subtract = this.x.subtract(eCFieldElement.toBigInteger());
            if (subtract.signum() < 0) {
                subtract = subtract.add(this.q);
            }
            return new Fp(bigInteger, bigInteger2, subtract);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.x;
        }
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public abstract ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3);

    public abstract ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public abstract ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2);

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }

    public static class F2m extends ECFieldElement {
        public int[] ks;
        public int m;
        public int representation;
        public LongArray x;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i3 == 0 && i4 == 0) {
                this.representation = 2;
                this.ks = new int[]{i2};
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i3 > 0) {
                this.representation = 3;
                this.ks = new int[]{i2, i3, i4};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.m = i;
            this.x = new LongArray(bigInteger);
        }

        public static void checkFieldElements(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if (!(eCFieldElement instanceof F2m) || !(eCFieldElement2 instanceof F2m)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            F2m f2m = (F2m) eCFieldElement;
            F2m f2m2 = (F2m) eCFieldElement2;
            if (f2m.representation != f2m2.representation) {
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            } else if (f2m.m != f2m2.m || !MoreExecutors.areEqual(f2m.ks, f2m2.ks)) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.x.clone();
            longArray.addShiftedByWords(((F2m) eCFieldElement).x, 0);
            return new F2m(this.m, this.ks, longArray);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            LongArray longArray;
            int i = this.m;
            int[] iArr = this.ks;
            LongArray longArray2 = this.x;
            if (longArray2.m_ints.length == 0) {
                longArray = new LongArray(new long[]{1});
            } else {
                int max = Math.max(1, longArray2.getUsedLength());
                long[] jArr = new long[max];
                long[] jArr2 = longArray2.m_ints;
                System.arraycopy(jArr2, 0, jArr, 0, Math.min(jArr2.length, max));
                jArr[0] = jArr[0] ^ 1;
                longArray = new LongArray(jArr);
            }
            return new F2m(i, iArr, longArray);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public int bitLength() {
            return this.x.degree();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.m == f2m.m && this.representation == f2m.representation && MoreExecutors.areEqual(this.ks, f2m.ks) && this.x.equals(f2m.x);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.m;
        }

        public int hashCode() {
            return (this.x.hashCode() ^ this.m) ^ MoreExecutors.hashCode(this.ks);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            int i;
            int i2 = this.m;
            int[] iArr = this.ks;
            LongArray longArray = this.x;
            int degree = longArray.degree();
            if (degree != 0) {
                int i3 = 1;
                if (degree != 1) {
                    int i4 = (i2 + 63) >>> 6;
                    LongArray longArray2 = new LongArray(i4);
                    LongArray.reduceBit(longArray2.m_ints, 0, i2, i2, iArr);
                    LongArray longArray3 = new LongArray(i4);
                    longArray3.m_ints[0] = 1;
                    LongArray longArray4 = new LongArray(i4);
                    int[] iArr2 = {degree, i2 + 1};
                    LongArray[] longArrayArr = {(LongArray) longArray.clone(), longArray2};
                    int[] iArr3 = {1, 0};
                    LongArray[] longArrayArr2 = {longArray3, longArray4};
                    int i5 = iArr2[1];
                    int i6 = iArr3[1];
                    int i7 = i5 - iArr2[0];
                    while (true) {
                        if (i7 < 0) {
                            i7 = -i7;
                            iArr2[i3] = i5;
                            iArr3[i3] = i6;
                            i3 = 1 - i3;
                            i5 = iArr2[i3];
                            i6 = iArr3[i3];
                        }
                        i = 1 - i3;
                        longArrayArr[i3].addShiftedByBitsSafe(longArrayArr[i], iArr2[i], i7);
                        int degreeFrom = longArrayArr[i3].degreeFrom(i5);
                        if (degreeFrom == 0) {
                            break;
                        }
                        int i8 = iArr3[i];
                        longArrayArr2[i3].addShiftedByBitsSafe(longArrayArr2[i], i8, i7);
                        int i9 = i8 + i7;
                        if (i9 > i6) {
                            i6 = i9;
                        } else if (i9 == i6) {
                            i6 = longArrayArr2[i3].degreeFrom(i6);
                        }
                        i7 += degreeFrom - i5;
                        i5 = degreeFrom;
                    }
                    longArray = longArrayArr2[i];
                }
                return new F2m(i2, iArr, longArray);
            }
            throw new IllegalStateException();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public boolean isOne() {
            return this.x.isOne();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public boolean isZero() {
            return this.x.isZero();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            long[] jArr;
            int i;
            int i2 = this.m;
            int[] iArr = this.ks;
            LongArray longArray = this.x;
            LongArray longArray2 = ((F2m) eCFieldElement).x;
            int degree = longArray.degree();
            if (degree != 0) {
                int degree2 = longArray2.degree();
                if (degree2 != 0) {
                    if (degree > degree2) {
                        degree2 = degree;
                        degree = degree2;
                    } else {
                        longArray2 = longArray;
                        longArray = longArray2;
                    }
                    int i3 = (degree + 63) >>> 6;
                    int i4 = (degree2 + 63) >>> 6;
                    int i5 = ((degree + degree2) + 62) >>> 6;
                    if (i3 == 1) {
                        long j = longArray2.m_ints[0];
                        if (j != 1) {
                            long[] jArr2 = new long[i5];
                            LongArray.multiplyWord(j, longArray.m_ints, i4, jArr2, 0);
                            longArray = new LongArray(jArr2, 0, LongArray.reduceInPlace(jArr2, 0, i5, i2, iArr));
                        }
                    } else {
                        int i6 = ((degree2 + 7) + 63) >>> 6;
                        int[] iArr2 = new int[16];
                        int i7 = i6 << 4;
                        long[] jArr3 = new long[i7];
                        iArr2[1] = i6;
                        System.arraycopy(longArray.m_ints, 0, jArr3, i6, i4);
                        int i8 = 2;
                        int i9 = i6;
                        for (int i10 = 16; i8 < i10; i10 = 16) {
                            i9 += i6;
                            iArr2[i8] = i9;
                            if ((i8 & 1) == 0) {
                                jArr = jArr3;
                                i = i7;
                                LongArray.shiftUp(jArr3, i9 >>> 1, jArr, i9, i6, 1);
                            } else {
                                jArr = jArr3;
                                i = i7;
                                LongArray.add(jArr3, i6, jArr, i9 - i6, jArr, i9, i6);
                            }
                            i8++;
                            i7 = i;
                            jArr3 = jArr;
                        }
                        long[] jArr4 = new long[i7];
                        LongArray.shiftUp(jArr3, 0, jArr4, 0, i7, 4);
                        long[] jArr5 = longArray2.m_ints;
                        int i11 = i5 << 3;
                        long[] jArr6 = new long[i11];
                        for (int i12 = 0; i12 < i3; i12++) {
                            long j2 = jArr5[i12];
                            int i13 = i12;
                            while (true) {
                                long j3 = j2 >>> 4;
                                LongArray.addBoth(jArr6, i13, jArr3, iArr2[((int) j2) & 15], jArr4, iArr2[((int) j3) & 15], i6);
                                j2 = j3 >>> 4;
                                if (j2 == 0) {
                                    break;
                                }
                                i13 += i5;
                            }
                        }
                        while (true) {
                            i11 -= i5;
                            if (i11 == 0) {
                                break;
                            }
                            LongArray.addShiftedUp(jArr6, i11 - i5, jArr6, i11, i5, 8);
                        }
                        longArray2 = new LongArray(jArr6, 0, LongArray.reduceInPlace(jArr6, 0, i5, i2, iArr));
                    }
                }
                longArray = longArray2;
            }
            return new F2m(i2, iArr, longArray);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            LongArray longArray = this.x;
            LongArray longArray2 = ((F2m) eCFieldElement).x;
            LongArray longArray3 = ((F2m) eCFieldElement2).x;
            LongArray longArray4 = ((F2m) eCFieldElement3).x;
            LongArray multiply = longArray.multiply(longArray2);
            LongArray multiply2 = longArray3.multiply(longArray4);
            if (multiply == longArray || multiply == longArray2) {
                multiply = (LongArray) multiply.clone();
            }
            multiply.addShiftedByWords(multiply2, 0);
            multiply.reduce(this.m, this.ks);
            return new F2m(this.m, this.ks, multiply);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            int i;
            if (this.x.isZero() || this.x.isOne() || (i = this.m) - 1 < 1) {
                return this;
            }
            int[] iArr = this.ks;
            LongArray longArray = this.x;
            int usedLength = longArray.getUsedLength();
            if (usedLength != 0) {
                int i2 = ((i + 63) >>> 6) << 1;
                long[] jArr = new long[i2];
                System.arraycopy(longArray.m_ints, 0, jArr, 0, usedLength);
                while (true) {
                    int i3 = i3 - 1;
                    if (i3 < 0) {
                        break;
                    }
                    int i4 = usedLength << 1;
                    while (true) {
                        usedLength--;
                        if (usedLength < 0) {
                            break;
                        }
                        long j = jArr[usedLength];
                        int i5 = i4 - 1;
                        jArr[i5] = LongArray.interleave2_32to64((int) (j >>> 32));
                        i4 = i5 - 1;
                        jArr[i4] = LongArray.interleave2_32to64((int) j);
                    }
                    usedLength = LongArray.reduceInPlace(jArr, 0, i2, i, iArr);
                }
                longArray = new LongArray(jArr, 0, usedLength);
            }
            return new F2m(i, iArr, longArray);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            int i = this.m;
            int[] iArr = this.ks;
            LongArray longArray = this.x;
            int usedLength = longArray.getUsedLength();
            if (usedLength != 0) {
                int i2 = usedLength << 1;
                long[] jArr = new long[i2];
                int i3 = 0;
                while (i3 < i2) {
                    long j = longArray.m_ints[i3 >>> 1];
                    int i4 = i3 + 1;
                    jArr[i3] = LongArray.interleave2_32to64((int) j);
                    i3 = i4 + 1;
                    jArr[i4] = LongArray.interleave2_32to64((int) (j >>> 32));
                }
                longArray = new LongArray(jArr, 0, LongArray.reduceInPlace(jArr, 0, i2, i, iArr));
            }
            return new F2m(i, iArr, longArray);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            LongArray longArray;
            LongArray longArray2 = this.x;
            LongArray longArray3 = ((F2m) eCFieldElement).x;
            LongArray longArray4 = ((F2m) eCFieldElement2).x;
            int usedLength = longArray2.getUsedLength();
            if (usedLength == 0) {
                longArray = longArray2;
            } else {
                int i = usedLength << 1;
                long[] jArr = new long[i];
                int i2 = 0;
                while (i2 < i) {
                    long j = longArray2.m_ints[i2 >>> 1];
                    int i3 = i2 + 1;
                    jArr[i2] = LongArray.interleave2_32to64((int) j);
                    i2 = i3 + 1;
                    jArr[i3] = LongArray.interleave2_32to64((int) (j >>> 32));
                }
                longArray = new LongArray(jArr, 0, i);
            }
            LongArray multiply = longArray3.multiply(longArray4);
            if (longArray == longArray2) {
                longArray = (LongArray) longArray.clone();
            }
            longArray.addShiftedByWords(multiply, 0);
            longArray.reduce(this.m, this.ks);
            return new F2m(this.m, this.ks, longArray);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            LongArray longArray = this.x;
            int usedLength = longArray.getUsedLength();
            if (usedLength == 0) {
                return ECConstants.ZERO;
            }
            int i = usedLength - 1;
            long j = longArray.m_ints[i];
            byte[] bArr = new byte[8];
            int i2 = 0;
            boolean z = false;
            for (int i3 = 7; i3 >= 0; i3--) {
                byte b = (byte) ((int) (j >>> (i3 * 8)));
                if (z || b != 0) {
                    bArr[i2] = b;
                    i2++;
                    z = true;
                }
            }
            byte[] bArr2 = new byte[((i * 8) + i2)];
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i4] = bArr[i4];
            }
            for (int i5 = usedLength - 2; i5 >= 0; i5--) {
                long j2 = longArray.m_ints[i5];
                int i6 = 7;
                while (i6 >= 0) {
                    bArr2[i2] = (byte) ((int) (j2 >>> (i6 * 8)));
                    i6--;
                    i2++;
                }
            }
            return new BigInteger(1, bArr2);
        }

        public F2m(int i, int[] iArr, LongArray longArray) {
            this.m = i;
            this.representation = iArr.length == 1 ? 2 : 3;
            this.ks = iArr;
            this.x = longArray;
        }
    }
}
