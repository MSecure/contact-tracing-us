package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class V2Form extends ASN1Object {
    public IssuerSerial baseCertificateID;
    public GeneralNames issuerName;
    public ObjectDigestInfo objectDigestInfo;

    public V2Form(ASN1Sequence aSN1Sequence) {
        int i;
        if (aSN1Sequence.size() <= 3) {
            if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject)) {
                this.issuerName = GeneralNames.getInstance(aSN1Sequence.getObjectAt(0));
                i = 1;
            } else {
                i = 0;
            }
            while (i != aSN1Sequence.size()) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
                int i2 = instance.tagNo;
                if (i2 == 0) {
                    this.baseCertificateID = IssuerSerial.getInstance(instance, false);
                } else if (i2 == 1) {
                    this.objectDigestInfo = ObjectDigestInfo.getInstance(instance, false);
                } else {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Bad tag number: ");
                    outline17.append(instance.tagNo);
                    throw new IllegalArgumentException(outline17.toString());
                }
                i++;
            }
            return;
        }
        StringBuilder outline172 = GeneratedOutlineSupport.outline17("Bad sequence size: ");
        outline172.append(aSN1Sequence.size());
        throw new IllegalArgumentException(outline172.toString());
    }

    public static V2Form getInstance(Object obj) {
        if (obj instanceof V2Form) {
            return (V2Form) obj;
        }
        if (obj != null) {
            return new V2Form(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralNames generalNames = this.issuerName;
        if (generalNames != null) {
            aSN1EncodableVector.v.addElement(generalNames);
        }
        IssuerSerial issuerSerial = this.baseCertificateID;
        if (issuerSerial != null) {
            aSN1EncodableVector.v.addElement(new DERTaggedObject(false, 0, issuerSerial));
        }
        ObjectDigestInfo objectDigestInfo2 = this.objectDigestInfo;
        if (objectDigestInfo2 != null) {
            aSN1EncodableVector.v.addElement(new DERTaggedObject(false, 1, objectDigestInfo2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
