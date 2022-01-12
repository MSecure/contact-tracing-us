package org.spongycastle.asn1.pkcs;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class RSAPublicKey extends ASN1Object {
    public BigInteger modulus;
    public BigInteger publicExponent;

    public RSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.modulus = bigInteger;
        this.publicExponent = bigInteger2;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.modulus));
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.publicExponent));
        return new DERSequence(aSN1EncodableVector);
    }

    public RSAPublicKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            Enumeration objects = aSN1Sequence.getObjects();
            ASN1Integer instance = ASN1Integer.getInstance(objects.nextElement());
            if (instance != null) {
                this.modulus = new BigInteger(1, instance.bytes);
                ASN1Integer instance2 = ASN1Integer.getInstance(objects.nextElement());
                if (instance2 != null) {
                    this.publicExponent = new BigInteger(1, instance2.bytes);
                    return;
                }
                throw null;
            }
            throw null;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Bad sequence size: ");
        outline17.append(aSN1Sequence.size());
        throw new IllegalArgumentException(outline17.toString());
    }
}
