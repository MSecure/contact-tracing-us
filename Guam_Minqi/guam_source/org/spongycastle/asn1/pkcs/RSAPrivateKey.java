package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class RSAPrivateKey extends ASN1Object {
    public BigInteger coefficient;
    public BigInteger exponent1;
    public BigInteger exponent2;
    public BigInteger modulus;
    public ASN1Sequence otherPrimeInfos = null;
    public BigInteger prime1;
    public BigInteger prime2;
    public BigInteger privateExponent;
    public BigInteger publicExponent;
    public BigInteger version;

    public RSAPrivateKey(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        BigInteger value = ((ASN1Integer) objects.nextElement()).getValue();
        if (value.intValue() == 0 || value.intValue() == 1) {
            this.version = value;
            this.modulus = ((ASN1Integer) objects.nextElement()).getValue();
            this.publicExponent = ((ASN1Integer) objects.nextElement()).getValue();
            this.privateExponent = ((ASN1Integer) objects.nextElement()).getValue();
            this.prime1 = ((ASN1Integer) objects.nextElement()).getValue();
            this.prime2 = ((ASN1Integer) objects.nextElement()).getValue();
            this.exponent1 = ((ASN1Integer) objects.nextElement()).getValue();
            this.exponent2 = ((ASN1Integer) objects.nextElement()).getValue();
            this.coefficient = ((ASN1Integer) objects.nextElement()).getValue();
            if (objects.hasMoreElements()) {
                this.otherPrimeInfos = (ASN1Sequence) objects.nextElement();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for RSA private key");
    }

    public static RSAPrivateKey getInstance(Object obj) {
        if (obj instanceof RSAPrivateKey) {
            return (RSAPrivateKey) obj;
        }
        if (obj != null) {
            return new RSAPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.version));
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.modulus));
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.publicExponent));
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.privateExponent));
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.prime1));
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.prime2));
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.exponent1));
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.exponent2));
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.coefficient));
        ASN1Sequence aSN1Sequence = this.otherPrimeInfos;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.v.addElement(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
