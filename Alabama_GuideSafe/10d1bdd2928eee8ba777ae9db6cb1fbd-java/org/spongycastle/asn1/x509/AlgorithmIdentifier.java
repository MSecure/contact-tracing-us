package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class AlgorithmIdentifier extends ASN1Object {
    public ASN1ObjectIdentifier algorithm;
    public ASN1Encodable parameters;

    public AlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.algorithm = aSN1ObjectIdentifier;
        this.parameters = aSN1Encodable;
    }

    public static AlgorithmIdentifier getInstance(Object obj) {
        if (obj instanceof AlgorithmIdentifier) {
            return (AlgorithmIdentifier) obj;
        }
        if (obj != null) {
            return new AlgorithmIdentifier(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.algorithm);
        ASN1Encodable aSN1Encodable = this.parameters;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.v.addElement(aSN1Encodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public AlgorithmIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Bad sequence size: ");
            outline17.append(aSN1Sequence.size());
            throw new IllegalArgumentException(outline17.toString());
        }
        this.algorithm = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.parameters = aSN1Sequence.getObjectAt(1);
        } else {
            this.parameters = null;
        }
    }
}
