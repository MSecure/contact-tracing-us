package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;

public class Certificate extends ASN1Object {
    public ASN1Sequence seq;
    public TBSCertificate tbsCert;

    public Certificate(ASN1Sequence aSN1Sequence) {
        TBSCertificate tBSCertificate;
        this.seq = aSN1Sequence;
        if (aSN1Sequence.size() == 3) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
            if (objectAt instanceof TBSCertificate) {
                tBSCertificate = (TBSCertificate) objectAt;
            } else {
                tBSCertificate = objectAt != null ? new TBSCertificate(ASN1Sequence.getInstance(objectAt)) : null;
            }
            this.tbsCert = tBSCertificate;
            AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            DERBitString.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
