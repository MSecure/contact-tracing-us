package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x500.X500Name;

public class TBSCertificate extends ASN1Object {
    public Extensions extensions;
    public ASN1Sequence seq;
    public ASN1Integer version;

    public TBSCertificate(ASN1Sequence aSN1Sequence) {
        int i;
        boolean z;
        boolean z2;
        this.seq = aSN1Sequence;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            this.version = ASN1Integer.getInstance(((ASN1TaggedObject) aSN1Sequence.getObjectAt(0)).getObject());
            i = 0;
        } else {
            this.version = new ASN1Integer(0);
            i = -1;
        }
        if (this.version.getValue().equals(BigInteger.valueOf(0))) {
            z = false;
            z2 = true;
        } else if (this.version.getValue().equals(BigInteger.valueOf(1))) {
            z2 = false;
            z = true;
        } else if (this.version.getValue().equals(BigInteger.valueOf(2))) {
            z2 = false;
            z = false;
        } else {
            throw new IllegalArgumentException("version number not recognised");
        }
        ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i + 1));
        AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i + 2));
        X500Name.getInstance(aSN1Sequence.getObjectAt(i + 3));
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(i + 4);
        Time.getInstance(aSN1Sequence2.getObjectAt(0));
        Time.getInstance(aSN1Sequence2.getObjectAt(1));
        X500Name.getInstance(aSN1Sequence.getObjectAt(i + 5));
        int i2 = i + 6;
        SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(i2));
        int size = (aSN1Sequence.size() - i2) - 1;
        if (size == 0 || !z2) {
            while (size > 0) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i2 + size);
                int i3 = aSN1TaggedObject.tagNo;
                if (i3 == 1) {
                    DERBitString.getInstance(aSN1TaggedObject, false);
                } else if (i3 == 2) {
                    DERBitString.getInstance(aSN1TaggedObject, false);
                } else if (i3 != 3) {
                    continue;
                } else if (!z) {
                    this.extensions = Extensions.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, true));
                } else {
                    throw new IllegalArgumentException("version 2 certificate cannot contain extensions");
                }
                size--;
            }
            return;
        }
        throw new IllegalArgumentException("version 1 certificate contains extra data");
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
