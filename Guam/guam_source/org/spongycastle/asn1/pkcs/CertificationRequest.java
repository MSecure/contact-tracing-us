package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class CertificationRequest extends ASN1Object {
    public CertificationRequestInfo reqInfo = null;
    public AlgorithmIdentifier sigAlgId = null;
    public DERBitString sigBits = null;

    public CertificationRequest() {
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.reqInfo);
        aSN1EncodableVector.v.addElement(this.sigAlgId);
        aSN1EncodableVector.v.addElement(this.sigBits);
        return new DERSequence(aSN1EncodableVector);
    }

    public CertificationRequest(ASN1Sequence aSN1Sequence) {
        CertificationRequestInfo certificationRequestInfo = null;
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
        if (objectAt instanceof CertificationRequestInfo) {
            certificationRequestInfo = (CertificationRequestInfo) objectAt;
        } else if (objectAt != null) {
            certificationRequestInfo = new CertificationRequestInfo(ASN1Sequence.getInstance(objectAt));
        }
        this.reqInfo = certificationRequestInfo;
        this.sigAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.sigBits = (DERBitString) aSN1Sequence.getObjectAt(2);
    }
}
