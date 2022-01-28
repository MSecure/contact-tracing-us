package org.spongycastle.asn1.pkcs;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;

public class CertificationRequestInfo extends ASN1Object {
    public ASN1Set attributes = null;
    public X500Name subject;
    public SubjectPublicKeyInfo subjectPKInfo;
    public ASN1Integer version = new ASN1Integer(0);

    public CertificationRequestInfo(ASN1Sequence aSN1Sequence) {
        Attribute attribute;
        this.version = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        this.subject = X500Name.getInstance(aSN1Sequence.getObjectAt(1));
        this.subjectPKInfo = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(2));
        if (aSN1Sequence.size() > 3) {
            this.attributes = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(3), false);
        }
        ASN1Set aSN1Set = this.attributes;
        if (aSN1Set != null) {
            Enumeration objects = aSN1Set.getObjects();
            while (objects.hasMoreElements()) {
                Object nextElement = objects.nextElement();
                if (nextElement == null || (nextElement instanceof Attribute)) {
                    attribute = (Attribute) nextElement;
                } else if (nextElement instanceof ASN1Sequence) {
                    attribute = new Attribute((ASN1Sequence) nextElement);
                } else {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("unknown object in factory: ");
                    outline15.append(nextElement.getClass().getName());
                    throw new IllegalArgumentException(outline15.toString());
                }
                if (attribute.attrType.equals(PKCSObjectIdentifiers.pkcs_9_at_challengePassword) && attribute.attrValues.size() != 1) {
                    throw new IllegalArgumentException("challengePassword attribute must have one value");
                }
            }
        }
        if (this.subject == null || this.version == null || this.subjectPKInfo == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.version);
        aSN1EncodableVector.v.addElement(this.subject);
        aSN1EncodableVector.v.addElement(this.subjectPKInfo);
        ASN1Set aSN1Set = this.attributes;
        if (aSN1Set != null) {
            aSN1EncodableVector.v.addElement(new DERTaggedObject(false, 0, aSN1Set));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
