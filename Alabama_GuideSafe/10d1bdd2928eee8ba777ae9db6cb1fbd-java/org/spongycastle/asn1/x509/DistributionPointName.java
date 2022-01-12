package org.spongycastle.asn1.x509;

import com.facebook.react.bridge.ColorPropConverter;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Strings;

public class DistributionPointName extends ASN1Object implements ASN1Choice {
    public ASN1Encodable name;
    public int type;

    public DistributionPointName(ASN1TaggedObject aSN1TaggedObject) {
        int i = aSN1TaggedObject.tagNo;
        this.type = i;
        if (i == 0) {
            this.name = GeneralNames.getInstance(aSN1TaggedObject, false);
        } else {
            this.name = ASN1Set.getInstance(aSN1TaggedObject, false);
        }
    }

    public final void appendObject(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(ColorPropConverter.PACKAGE_DELIMITER);
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.type, this.name);
    }

    public String toString() {
        String str = Strings.LINE_SEPARATOR;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPointName: [");
        stringBuffer.append(str);
        if (this.type == 0) {
            appendObject(stringBuffer, str, "fullName", this.name.toString());
        } else {
            appendObject(stringBuffer, str, "nameRelativeToCRLIssuer", this.name.toString());
        }
        stringBuffer.append("]");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
