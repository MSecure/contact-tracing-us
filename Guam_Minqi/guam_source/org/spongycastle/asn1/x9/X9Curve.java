package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.GenericPolynomialExtensionField;

public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    public ECCurve curve;
    public ASN1ObjectIdentifier fieldIdentifier = null;
    public byte[] seed;

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.curve = eCCurve;
        this.seed = bArr;
        boolean z = false;
        if (eCCurve.field.getDimension() == 1) {
            this.fieldIdentifier = X9ObjectIdentifiers.prime_field;
            return;
        }
        FiniteField finiteField = this.curve.field;
        if (finiteField.getDimension() > 1 && finiteField.getCharacteristic().equals(ECConstants.TWO) && (finiteField instanceof GenericPolynomialExtensionField)) {
            z = true;
        }
        if (z) {
            this.fieldIdentifier = X9ObjectIdentifiers.characteristic_two_field;
            return;
        }
        throw new IllegalArgumentException("This type of ECCurve is not implemented");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00de  */
    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        int fieldSize;
        byte[] byteArray;
        byte[] bArr;
        byte[] bArr2;
        int fieldSize2;
        byte[] byteArray2;
        byte[] bArr3;
        byte[] bArr4;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.fieldIdentifier.equals(X9ObjectIdentifiers.prime_field)) {
            ECFieldElement eCFieldElement = this.curve.a;
            int fieldSize3 = (eCFieldElement.getFieldSize() + 7) / 8;
            byte[] byteArray3 = eCFieldElement.toBigInteger().toByteArray();
            if (fieldSize3 < byteArray3.length) {
                bArr4 = new byte[fieldSize3];
                System.arraycopy(byteArray3, byteArray3.length - fieldSize3, bArr4, 0, fieldSize3);
            } else {
                if (fieldSize3 > byteArray3.length) {
                    bArr4 = new byte[fieldSize3];
                    System.arraycopy(byteArray3, 0, bArr4, fieldSize3 - byteArray3.length, byteArray3.length);
                }
                aSN1EncodableVector.v.addElement(new DEROctetString(byteArray3));
                ECFieldElement eCFieldElement2 = this.curve.b;
                fieldSize2 = (eCFieldElement2.getFieldSize() + 7) / 8;
                byteArray2 = eCFieldElement2.toBigInteger().toByteArray();
                if (fieldSize2 >= byteArray2.length) {
                    bArr3 = new byte[fieldSize2];
                    System.arraycopy(byteArray2, byteArray2.length - fieldSize2, bArr3, 0, fieldSize2);
                } else {
                    if (fieldSize2 > byteArray2.length) {
                        bArr3 = new byte[fieldSize2];
                        System.arraycopy(byteArray2, 0, bArr3, fieldSize2 - byteArray2.length, byteArray2.length);
                    }
                    aSN1EncodableVector.v.addElement(new DEROctetString(byteArray2));
                }
                byteArray2 = bArr3;
                aSN1EncodableVector.v.addElement(new DEROctetString(byteArray2));
            }
            byteArray3 = bArr4;
            aSN1EncodableVector.v.addElement(new DEROctetString(byteArray3));
            ECFieldElement eCFieldElement22 = this.curve.b;
            fieldSize2 = (eCFieldElement22.getFieldSize() + 7) / 8;
            byteArray2 = eCFieldElement22.toBigInteger().toByteArray();
            if (fieldSize2 >= byteArray2.length) {
            }
            byteArray2 = bArr3;
            aSN1EncodableVector.v.addElement(new DEROctetString(byteArray2));
        } else if (this.fieldIdentifier.equals(X9ObjectIdentifiers.characteristic_two_field)) {
            ECFieldElement eCFieldElement3 = this.curve.a;
            int fieldSize4 = (eCFieldElement3.getFieldSize() + 7) / 8;
            byte[] byteArray4 = eCFieldElement3.toBigInteger().toByteArray();
            if (fieldSize4 < byteArray4.length) {
                bArr2 = new byte[fieldSize4];
                System.arraycopy(byteArray4, byteArray4.length - fieldSize4, bArr2, 0, fieldSize4);
            } else {
                if (fieldSize4 > byteArray4.length) {
                    bArr2 = new byte[fieldSize4];
                    System.arraycopy(byteArray4, 0, bArr2, fieldSize4 - byteArray4.length, byteArray4.length);
                }
                aSN1EncodableVector.v.addElement(new DEROctetString(byteArray4));
                ECFieldElement eCFieldElement4 = this.curve.b;
                fieldSize = (eCFieldElement4.getFieldSize() + 7) / 8;
                byteArray = eCFieldElement4.toBigInteger().toByteArray();
                if (fieldSize >= byteArray.length) {
                    bArr = new byte[fieldSize];
                    System.arraycopy(byteArray, byteArray.length - fieldSize, bArr, 0, fieldSize);
                } else {
                    if (fieldSize > byteArray.length) {
                        bArr = new byte[fieldSize];
                        System.arraycopy(byteArray, 0, bArr, fieldSize - byteArray.length, byteArray.length);
                    }
                    aSN1EncodableVector.v.addElement(new DEROctetString(byteArray));
                }
                byteArray = bArr;
                aSN1EncodableVector.v.addElement(new DEROctetString(byteArray));
            }
            byteArray4 = bArr2;
            aSN1EncodableVector.v.addElement(new DEROctetString(byteArray4));
            ECFieldElement eCFieldElement42 = this.curve.b;
            fieldSize = (eCFieldElement42.getFieldSize() + 7) / 8;
            byteArray = eCFieldElement42.toBigInteger().toByteArray();
            if (fieldSize >= byteArray.length) {
            }
            byteArray = bArr;
            aSN1EncodableVector.v.addElement(new DEROctetString(byteArray));
        }
        byte[] bArr5 = this.seed;
        if (bArr5 != null) {
            aSN1EncodableVector.v.addElement(new DERBitString(bArr5));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9Curve(X9FieldID x9FieldID, ASN1Sequence aSN1Sequence) {
        int i;
        int i2;
        int i3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = x9FieldID.id;
        this.fieldIdentifier = aSN1ObjectIdentifier;
        if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.prime_field)) {
            BigInteger value = ((ASN1Integer) x9FieldID.parameters).getValue();
            this.curve = new ECCurve.Fp(value, new ECFieldElement.Fp(value, ECFieldElement.Fp.calculateResidue(value), new BigInteger(1, ((ASN1OctetString) aSN1Sequence.getObjectAt(0)).getOctets())).x, new ECFieldElement.Fp(value, ECFieldElement.Fp.calculateResidue(value), new BigInteger(1, ((ASN1OctetString) aSN1Sequence.getObjectAt(1)).getOctets())).x);
        } else if (this.fieldIdentifier.equals(X9ObjectIdentifiers.characteristic_two_field)) {
            ASN1Sequence instance = ASN1Sequence.getInstance(x9FieldID.parameters);
            int intValue = ((ASN1Integer) instance.getObjectAt(0)).getValue().intValue();
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) instance.getObjectAt(1);
            if (aSN1ObjectIdentifier2.equals(X9ObjectIdentifiers.tpBasis)) {
                i3 = ASN1Integer.getInstance(instance.getObjectAt(2)).getValue().intValue();
                i2 = 0;
                i = 0;
            } else if (aSN1ObjectIdentifier2.equals(X9ObjectIdentifiers.ppBasis)) {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObjectAt(2));
                int intValue2 = ASN1Integer.getInstance(instance2.getObjectAt(0)).getValue().intValue();
                int intValue3 = ASN1Integer.getInstance(instance2.getObjectAt(1)).getValue().intValue();
                i = ASN1Integer.getInstance(instance2.getObjectAt(2)).getValue().intValue();
                i3 = intValue2;
                i2 = intValue3;
            } else {
                throw new IllegalArgumentException("This type of EC basis is not implemented");
            }
            this.curve = new ECCurve.F2m(intValue, i3, i2, i, new ECFieldElement.F2m(intValue, i3, i2, i, new BigInteger(1, ((ASN1OctetString) aSN1Sequence.getObjectAt(0)).getOctets())).toBigInteger(), new ECFieldElement.F2m(intValue, i3, i2, i, new BigInteger(1, ((ASN1OctetString) aSN1Sequence.getObjectAt(1)).getOctets())).toBigInteger());
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
        if (aSN1Sequence.size() == 3) {
            this.seed = ((DERBitString) aSN1Sequence.getObjectAt(2)).getBytes();
        }
    }
}
