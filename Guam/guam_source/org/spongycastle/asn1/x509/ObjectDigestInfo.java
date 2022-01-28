package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class ObjectDigestInfo extends ASN1Object {
    public AlgorithmIdentifier digestAlgorithm;
    public ASN1Enumerated digestedObjectType;
    public DERBitString objectDigest;
    public ASN1ObjectIdentifier otherObjectTypeID;

    public ObjectDigestInfo(ASN1Sequence aSN1Sequence) {
        ASN1Enumerated aSN1Enumerated;
        if (aSN1Sequence.size() > 4 || aSN1Sequence.size() < 3) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Bad sequence size: ");
            outline15.append(aSN1Sequence.size());
            throw new IllegalArgumentException(outline15.toString());
        }
        int i = 0;
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
        if (objectAt == null || (objectAt instanceof ASN1Enumerated)) {
            aSN1Enumerated = (ASN1Enumerated) objectAt;
        } else if (objectAt instanceof byte[]) {
            try {
                aSN1Enumerated = (ASN1Enumerated) ASN1Primitive.fromByteArray((byte[]) objectAt);
            } catch (Exception e) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline3(e, GeneratedOutlineSupport.outline15("encoding error in getInstance: ")));
            }
        } else {
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("illegal object in getInstance: ");
            outline152.append(objectAt.getClass().getName());
            throw new IllegalArgumentException(outline152.toString());
        }
        this.digestedObjectType = aSN1Enumerated;
        if (aSN1Sequence.size() == 4) {
            this.otherObjectTypeID = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            i = 1;
        }
        this.digestAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i + 1));
        this.objectDigest = DERBitString.getInstance(aSN1Sequence.getObjectAt(i + 2));
    }

    public static ObjectDigestInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Sequence instance = ASN1Sequence.getInstance(aSN1TaggedObject, z);
        if (instance instanceof ObjectDigestInfo) {
            return (ObjectDigestInfo) instance;
        }
        if (instance != null) {
            return new ObjectDigestInfo(ASN1Sequence.getInstance(instance));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.digestedObjectType);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.otherObjectTypeID;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.v.addElement(aSN1ObjectIdentifier);
        }
        aSN1EncodableVector.v.addElement(this.digestAlgorithm);
        aSN1EncodableVector.v.addElement(this.objectDigest);
        return new DERSequence(aSN1EncodableVector);
    }
}
