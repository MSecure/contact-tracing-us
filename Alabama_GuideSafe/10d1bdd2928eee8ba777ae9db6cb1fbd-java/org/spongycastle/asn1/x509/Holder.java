package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class Holder extends ASN1Object {
    public IssuerSerial baseCertificateID;
    public GeneralNames entityName;
    public ObjectDigestInfo objectDigestInfo;
    public int version = 1;

    public Holder(ASN1TaggedObject aSN1TaggedObject) {
        int i = aSN1TaggedObject.tagNo;
        if (i == 0) {
            this.baseCertificateID = IssuerSerial.getInstance(aSN1TaggedObject, true);
        } else if (i == 1) {
            this.entityName = GeneralNames.getInstance(aSN1TaggedObject, true);
        } else {
            throw new IllegalArgumentException("unknown tag in Holder");
        }
        this.version = 0;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        if (this.version == 1) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            IssuerSerial issuerSerial = this.baseCertificateID;
            if (issuerSerial != null) {
                aSN1EncodableVector.v.addElement(new DERTaggedObject(false, 0, issuerSerial));
            }
            GeneralNames generalNames = this.entityName;
            if (generalNames != null) {
                aSN1EncodableVector.v.addElement(new DERTaggedObject(false, 1, generalNames));
            }
            ObjectDigestInfo objectDigestInfo2 = this.objectDigestInfo;
            if (objectDigestInfo2 != null) {
                aSN1EncodableVector.v.addElement(new DERTaggedObject(false, 2, objectDigestInfo2));
            }
            return new DERSequence(aSN1EncodableVector);
        }
        GeneralNames generalNames2 = this.entityName;
        if (generalNames2 != null) {
            return new DERTaggedObject(true, 1, generalNames2);
        }
        return new DERTaggedObject(true, 0, this.baseCertificateID);
    }

    public Holder(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 3) {
            for (int i = 0; i != aSN1Sequence.size(); i++) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
                int i2 = instance.tagNo;
                if (i2 == 0) {
                    this.baseCertificateID = IssuerSerial.getInstance(instance, false);
                } else if (i2 == 1) {
                    this.entityName = GeneralNames.getInstance(instance, false);
                } else if (i2 == 2) {
                    this.objectDigestInfo = ObjectDigestInfo.getInstance(instance, false);
                } else {
                    throw new IllegalArgumentException("unknown tag in Holder");
                }
            }
            this.version = 1;
            return;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Bad sequence size: ");
        outline17.append(aSN1Sequence.size());
        throw new IllegalArgumentException(outline17.toString());
    }
}
