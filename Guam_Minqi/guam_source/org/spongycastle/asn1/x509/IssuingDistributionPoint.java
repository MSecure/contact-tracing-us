package org.spongycastle.asn1.x509;

import com.facebook.react.bridge.ColorPropConverter;
import org.pathcheck.covidsafepaths.BuildConfig;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.util.Strings;

public class IssuingDistributionPoint extends ASN1Object {
    public DistributionPointName distributionPoint;
    public boolean indirectCRL;
    public boolean onlyContainsAttributeCerts;
    public boolean onlyContainsCACerts;
    public boolean onlyContainsUserCerts;
    public ReasonFlags onlySomeReasons;
    public ASN1Sequence seq;

    public IssuingDistributionPoint(ASN1Sequence aSN1Sequence) {
        DistributionPointName distributionPointName;
        this.seq = aSN1Sequence;
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            int i2 = instance.tagNo;
            if (i2 == 0) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) instance.getObject();
                if (aSN1TaggedObject == null || (aSN1TaggedObject instanceof DistributionPointName)) {
                    distributionPointName = (DistributionPointName) aSN1TaggedObject;
                } else {
                    distributionPointName = new DistributionPointName(aSN1TaggedObject);
                }
                this.distributionPoint = distributionPointName;
            } else if (i2 == 1) {
                this.onlyContainsUserCerts = ASN1Boolean.getInstance(instance, false).isTrue();
            } else if (i2 == 2) {
                this.onlyContainsCACerts = ASN1Boolean.getInstance(instance, false).isTrue();
            } else if (i2 == 3) {
                this.onlySomeReasons = new ReasonFlags(DERBitString.getInstance(instance, false));
            } else if (i2 == 4) {
                this.indirectCRL = ASN1Boolean.getInstance(instance, false).isTrue();
            } else if (i2 == 5) {
                this.onlyContainsAttributeCerts = ASN1Boolean.getInstance(instance, false).isTrue();
            } else {
                throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
            }
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

    public final String booleanToString(boolean z) {
        return z ? BuildConfig.DISPLAY_CALL_EMERGENCY_SERVICES : "false";
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }

    public String toString() {
        String str = Strings.LINE_SEPARATOR;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(str);
        DistributionPointName distributionPointName = this.distributionPoint;
        if (distributionPointName != null) {
            appendObject(stringBuffer, str, "distributionPoint", distributionPointName.toString());
        }
        boolean z = this.onlyContainsUserCerts;
        if (z) {
            appendObject(stringBuffer, str, "onlyContainsUserCerts", booleanToString(z));
        }
        boolean z2 = this.onlyContainsCACerts;
        if (z2) {
            appendObject(stringBuffer, str, "onlyContainsCACerts", booleanToString(z2));
        }
        ReasonFlags reasonFlags = this.onlySomeReasons;
        if (reasonFlags != null) {
            appendObject(stringBuffer, str, "onlySomeReasons", reasonFlags.getString());
        }
        boolean z3 = this.onlyContainsAttributeCerts;
        if (z3) {
            appendObject(stringBuffer, str, "onlyContainsAttributeCerts", booleanToString(z3));
        }
        boolean z4 = this.indirectCRL;
        if (z4) {
            appendObject(stringBuffer, str, "indirectCRL", booleanToString(z4));
        }
        stringBuffer.append("]");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
