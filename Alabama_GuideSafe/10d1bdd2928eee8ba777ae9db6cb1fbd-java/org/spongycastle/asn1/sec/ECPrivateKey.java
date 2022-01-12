package org.spongycastle.asn1.sec;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;

public class ECPrivateKey extends ASN1Object {
    public ASN1Sequence seq;

    public ECPrivateKey(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
    }

    public final ASN1Primitive getObjectInTag(int i) {
        Enumeration objects = this.seq.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) objects.nextElement();
            if (aSN1Encodable instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
                if (aSN1TaggedObject.tagNo == i) {
                    ASN1Primitive object = aSN1TaggedObject.getObject();
                    if (object != null) {
                        return object;
                    }
                    throw null;
                }
            }
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
