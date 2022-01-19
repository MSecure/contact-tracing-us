package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECCurve;

public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    public static final BigInteger ONE = BigInteger.valueOf(1);
    public ECCurve curve;
    public X9ECPoint g;
    public BigInteger h;
    public BigInteger n;
    public byte[] seed;

    public X9ECParameters(ASN1Sequence aSN1Sequence) {
        if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) || !((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue().equals(ONE)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        X9Curve x9Curve = new X9Curve(X9FieldID.getInstance(aSN1Sequence.getObjectAt(1)), ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2)));
        this.curve = x9Curve.curve;
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(3);
        if (objectAt instanceof X9ECPoint) {
            this.g = (X9ECPoint) objectAt;
        } else {
            this.g = new X9ECPoint(this.curve, (ASN1OctetString) objectAt);
        }
        this.n = ((ASN1Integer) aSN1Sequence.getObjectAt(4)).getValue();
        this.seed = x9Curve.seed;
        if (aSN1Sequence.size() == 6) {
            this.h = ((ASN1Integer) aSN1Sequence.getObjectAt(5)).getValue();
        }
    }

    public static X9ECParameters getInstance(Object obj) {
        if (obj instanceof X9ECParameters) {
            return (X9ECParameters) obj;
        }
        if (obj != null) {
            return new X9ECParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(new ASN1Integer(ONE));
        aSN1EncodableVector.v.addElement(null);
        aSN1EncodableVector.v.addElement(new X9Curve(this.curve, this.seed));
        aSN1EncodableVector.v.addElement(this.g);
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.n));
        BigInteger bigInteger = this.h;
        if (bigInteger != null) {
            aSN1EncodableVector.v.addElement(new ASN1Integer(bigInteger));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
