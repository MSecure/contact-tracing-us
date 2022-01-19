package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class Extension extends ASN1Object {
    public static final ASN1ObjectIdentifier issuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28").intern();
    public boolean critical;
    public ASN1ObjectIdentifier extnId;
    public ASN1OctetString value;

    static {
        new ASN1ObjectIdentifier("2.5.29.9").intern();
        new ASN1ObjectIdentifier("2.5.29.14").intern();
        new ASN1ObjectIdentifier("2.5.29.15").intern();
        new ASN1ObjectIdentifier("2.5.29.16").intern();
        new ASN1ObjectIdentifier("2.5.29.17").intern();
        new ASN1ObjectIdentifier("2.5.29.18").intern();
        new ASN1ObjectIdentifier("2.5.29.19").intern();
        new ASN1ObjectIdentifier("2.5.29.20").intern();
        new ASN1ObjectIdentifier("2.5.29.21").intern();
        new ASN1ObjectIdentifier("2.5.29.23").intern();
        new ASN1ObjectIdentifier("2.5.29.24").intern();
        new ASN1ObjectIdentifier("2.5.29.27").intern();
        new ASN1ObjectIdentifier("2.5.29.29").intern();
        new ASN1ObjectIdentifier("2.5.29.30").intern();
        new ASN1ObjectIdentifier("2.5.29.31").intern();
        new ASN1ObjectIdentifier("2.5.29.32").intern();
        new ASN1ObjectIdentifier("2.5.29.33").intern();
        new ASN1ObjectIdentifier("2.5.29.35").intern();
        new ASN1ObjectIdentifier("2.5.29.36").intern();
        new ASN1ObjectIdentifier("2.5.29.37").intern();
        new ASN1ObjectIdentifier("2.5.29.46").intern();
        new ASN1ObjectIdentifier("2.5.29.54").intern();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1").intern();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11").intern();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12").intern();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2").intern();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3").intern();
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4").intern();
        new ASN1ObjectIdentifier("2.5.29.56").intern();
        new ASN1ObjectIdentifier("2.5.29.55").intern();
        new ASN1ObjectIdentifier("2.5.29.60").intern();
    }

    public Extension(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.extnId = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.critical = false;
            this.value = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        } else if (aSN1Sequence.size() == 3) {
            this.extnId = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.critical = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(1)).isTrue();
            this.value = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2));
        } else {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Bad sequence size: ");
            outline15.append(aSN1Sequence.size());
            throw new IllegalArgumentException(outline15.toString());
        }
    }

    public static Extension getInstance(Object obj) {
        if (obj instanceof Extension) {
            return (Extension) obj;
        }
        if (obj != null) {
            return new Extension(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public boolean equals(Object obj) {
        if (!(obj instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) obj;
        if (!extension.extnId.equals(this.extnId) || !extension.value.equals(this.value) || extension.critical != this.critical) {
            return false;
        }
        return true;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.critical) {
            return this.value.hashCode() ^ this.extnId.hashCode();
        }
        return ~(this.value.hashCode() ^ this.extnId.hashCode());
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.extnId);
        if (this.critical) {
            aSN1EncodableVector.v.addElement(ASN1Boolean.TRUE);
        }
        aSN1EncodableVector.v.addElement(this.value);
        return new DERSequence(aSN1EncodableVector);
    }
}
