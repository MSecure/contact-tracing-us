package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class CertificateList extends ASN1Object {
    public int hashCodeValue;
    public boolean isHashCodeSet = false;
    public DERBitString sig;
    public AlgorithmIdentifier sigAlgId;
    public TBSCertList tbsCertList;

    public CertificateList(ASN1Sequence aSN1Sequence) {
        TBSCertList tBSCertList;
        if (aSN1Sequence.size() == 3) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
            if (objectAt instanceof TBSCertList) {
                tBSCertList = (TBSCertList) objectAt;
            } else {
                tBSCertList = objectAt != null ? new TBSCertList(ASN1Sequence.getInstance(objectAt)) : null;
            }
            this.tbsCertList = tBSCertList;
            this.sigAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.sig = DERBitString.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for CertificateList");
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        if (!this.isHashCodeSet) {
            this.hashCodeValue = super.hashCode();
            this.isHashCodeSet = true;
        }
        return this.hashCodeValue;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.tbsCertList);
        aSN1EncodableVector.v.addElement(this.sigAlgId);
        aSN1EncodableVector.v.addElement(this.sig);
        return new DERSequence(aSN1EncodableVector);
    }
}
