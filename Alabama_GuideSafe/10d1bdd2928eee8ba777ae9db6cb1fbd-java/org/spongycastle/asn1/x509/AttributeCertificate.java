package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class AttributeCertificate extends ASN1Object {
    public AttributeCertificateInfo acinfo;
    public AlgorithmIdentifier signatureAlgorithm;
    public DERBitString signatureValue;

    public AttributeCertificate(ASN1Sequence aSN1Sequence) {
        AttributeCertificateInfo attributeCertificateInfo;
        if (aSN1Sequence.size() == 3) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
            if (objectAt instanceof AttributeCertificateInfo) {
                attributeCertificateInfo = (AttributeCertificateInfo) objectAt;
            } else {
                attributeCertificateInfo = objectAt != null ? new AttributeCertificateInfo(ASN1Sequence.getInstance(objectAt)) : null;
            }
            this.acinfo = attributeCertificateInfo;
            this.signatureAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.signatureValue = DERBitString.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Bad sequence size: ");
        outline17.append(aSN1Sequence.size());
        throw new IllegalArgumentException(outline17.toString());
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.acinfo);
        aSN1EncodableVector.v.addElement(this.signatureAlgorithm);
        aSN1EncodableVector.v.addElement(this.signatureValue);
        return new DERSequence(aSN1EncodableVector);
    }
}
