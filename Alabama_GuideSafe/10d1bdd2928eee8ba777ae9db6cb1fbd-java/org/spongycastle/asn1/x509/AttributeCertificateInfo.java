package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class AttributeCertificateInfo extends ASN1Object {
    public AttCertValidityPeriod attrCertValidityPeriod;
    public ASN1Sequence attributes;
    public Extensions extensions;
    public Holder holder;
    public AttCertIssuer issuer;
    public DERBitString issuerUniqueID;
    public ASN1Integer serialNumber;
    public AlgorithmIdentifier signature;
    public ASN1Integer version;

    public AttributeCertificateInfo(ASN1Sequence aSN1Sequence) {
        int i;
        Holder holder2;
        AttCertIssuer attCertIssuer;
        Holder holder3;
        if (aSN1Sequence.size() < 6 || aSN1Sequence.size() > 9) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Bad sequence size: ");
            outline17.append(aSN1Sequence.size());
            throw new IllegalArgumentException(outline17.toString());
        }
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
            i = 1;
        } else {
            this.version = new ASN1Integer(0);
            i = 0;
        }
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i);
        AttCertValidityPeriod attCertValidityPeriod = null;
        if (objectAt instanceof Holder) {
            holder2 = (Holder) objectAt;
        } else {
            if (objectAt instanceof ASN1TaggedObject) {
                holder3 = new Holder(ASN1TaggedObject.getInstance(objectAt));
            } else if (objectAt != null) {
                holder3 = new Holder(ASN1Sequence.getInstance(objectAt));
            } else {
                holder2 = null;
            }
            holder2 = holder3;
        }
        this.holder = holder2;
        ASN1Encodable objectAt2 = aSN1Sequence.getObjectAt(i + 1);
        if (objectAt2 == null || (objectAt2 instanceof AttCertIssuer)) {
            attCertIssuer = (AttCertIssuer) objectAt2;
        } else if (objectAt2 instanceof V2Form) {
            attCertIssuer = new AttCertIssuer(V2Form.getInstance(objectAt2));
        } else if (objectAt2 instanceof GeneralNames) {
            attCertIssuer = new AttCertIssuer((GeneralNames) objectAt2);
        } else if (objectAt2 instanceof ASN1TaggedObject) {
            attCertIssuer = new AttCertIssuer(V2Form.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) objectAt2, false)));
        } else if (objectAt2 instanceof ASN1Sequence) {
            attCertIssuer = new AttCertIssuer(GeneralNames.getInstance(objectAt2));
        } else {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("unknown object in factory: ");
            outline172.append(objectAt2.getClass().getName());
            throw new IllegalArgumentException(outline172.toString());
        }
        this.issuer = attCertIssuer;
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i + 2));
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i + 3));
        ASN1Encodable objectAt3 = aSN1Sequence.getObjectAt(i + 4);
        if (objectAt3 instanceof AttCertValidityPeriod) {
            attCertValidityPeriod = (AttCertValidityPeriod) objectAt3;
        } else if (objectAt3 != null) {
            attCertValidityPeriod = new AttCertValidityPeriod(ASN1Sequence.getInstance(objectAt3));
        }
        this.attrCertValidityPeriod = attCertValidityPeriod;
        this.attributes = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i + 5));
        for (int i2 = i + 6; i2 < aSN1Sequence.size(); i2++) {
            ASN1Encodable objectAt4 = aSN1Sequence.getObjectAt(i2);
            if (objectAt4 instanceof DERBitString) {
                this.issuerUniqueID = DERBitString.getInstance(aSN1Sequence.getObjectAt(i2));
            } else if ((objectAt4 instanceof ASN1Sequence) || (objectAt4 instanceof Extensions)) {
                this.extensions = Extensions.getInstance(aSN1Sequence.getObjectAt(i2));
            }
        }
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.version.getValue().intValue() != 0) {
            aSN1EncodableVector.v.addElement(this.version);
        }
        aSN1EncodableVector.v.addElement(this.holder);
        aSN1EncodableVector.v.addElement(this.issuer);
        aSN1EncodableVector.v.addElement(this.signature);
        aSN1EncodableVector.v.addElement(this.serialNumber);
        aSN1EncodableVector.v.addElement(this.attrCertValidityPeriod);
        aSN1EncodableVector.v.addElement(this.attributes);
        DERBitString dERBitString = this.issuerUniqueID;
        if (dERBitString != null) {
            aSN1EncodableVector.v.addElement(dERBitString);
        }
        Extensions extensions2 = this.extensions;
        if (extensions2 != null) {
            aSN1EncodableVector.v.addElement(extensions2);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
