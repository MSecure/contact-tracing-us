package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;

public class Attribute extends ASN1Object {
    public ASN1ObjectIdentifier attrType;
    public ASN1Set attrValues;

    public Attribute(ASN1Sequence aSN1Sequence) {
        this.attrType = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.attrValues = (ASN1Set) aSN1Sequence.getObjectAt(1);
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.attrType);
        aSN1EncodableVector.v.addElement(this.attrValues);
        return new DERSequence(aSN1EncodableVector);
    }
}
