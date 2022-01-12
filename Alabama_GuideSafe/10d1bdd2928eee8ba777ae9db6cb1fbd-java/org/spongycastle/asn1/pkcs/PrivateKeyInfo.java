package org.spongycastle.asn1.pkcs;

import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class PrivateKeyInfo extends ASN1Object {
    public AlgorithmIdentifier algId;
    public ASN1Set attributes;
    public ASN1OctetString privKey;

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) throws IOException {
        this.privKey = new DEROctetString(aSN1Encodable.toASN1Primitive().getEncoded("DER"));
        this.algId = algorithmIdentifier;
        this.attributes = null;
    }

    public static PrivateKeyInfo getInstance(Object obj) {
        if (obj instanceof PrivateKeyInfo) {
            return (PrivateKeyInfo) obj;
        }
        if (obj != null) {
            return new PrivateKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(new ASN1Integer(0));
        aSN1EncodableVector.v.addElement(this.algId);
        aSN1EncodableVector.v.addElement(this.privKey);
        ASN1Set aSN1Set = this.attributes;
        if (aSN1Set != null) {
            aSN1EncodableVector.v.addElement(new DERTaggedObject(false, 0, aSN1Set));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        if (((ASN1Integer) objects.nextElement()).getValue().intValue() == 0) {
            this.algId = AlgorithmIdentifier.getInstance(objects.nextElement());
            this.privKey = ASN1OctetString.getInstance(objects.nextElement());
            if (objects.hasMoreElements()) {
                this.attributes = ASN1Set.getInstance((ASN1TaggedObject) objects.nextElement(), false);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for private key info");
    }
}
