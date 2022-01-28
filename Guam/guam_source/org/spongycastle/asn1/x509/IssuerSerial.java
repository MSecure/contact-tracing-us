package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class IssuerSerial extends ASN1Object {
    public GeneralNames issuer;
    public DERBitString issuerUID;
    public ASN1Integer serial;

    public IssuerSerial(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2 || aSN1Sequence.size() == 3) {
            this.issuer = GeneralNames.getInstance(aSN1Sequence.getObjectAt(0));
            this.serial = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
            if (aSN1Sequence.size() == 3) {
                this.issuerUID = DERBitString.getInstance(aSN1Sequence.getObjectAt(2));
                return;
            }
            return;
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Bad sequence size: ");
        outline15.append(aSN1Sequence.size());
        throw new IllegalArgumentException(outline15.toString());
    }

    public static IssuerSerial getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Sequence instance = ASN1Sequence.getInstance(aSN1TaggedObject, z);
        if (instance instanceof IssuerSerial) {
            return (IssuerSerial) instance;
        }
        if (instance != null) {
            return new IssuerSerial(ASN1Sequence.getInstance(instance));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.issuer);
        aSN1EncodableVector.v.addElement(this.serial);
        DERBitString dERBitString = this.issuerUID;
        if (dERBitString != null) {
            aSN1EncodableVector.v.addElement(dERBitString);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
