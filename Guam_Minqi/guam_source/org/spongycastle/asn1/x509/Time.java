package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.util.Strings;

public class Time extends ASN1Object implements ASN1Choice {
    public ASN1Primitive time;

    public Time(ASN1Primitive aSN1Primitive) {
        if ((aSN1Primitive instanceof ASN1UTCTime) || (aSN1Primitive instanceof ASN1GeneralizedTime)) {
            this.time = aSN1Primitive;
            return;
        }
        throw new IllegalArgumentException("unknown object passed to Time");
    }

    public static Time getInstance(Object obj) {
        if (obj == null || (obj instanceof Time)) {
            return (Time) obj;
        }
        if (obj instanceof ASN1UTCTime) {
            return new Time((ASN1UTCTime) obj);
        }
        if (obj instanceof ASN1GeneralizedTime) {
            return new Time((ASN1GeneralizedTime) obj);
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("unknown object in factory: ");
        outline15.append(obj.getClass().getName());
        throw new IllegalArgumentException(outline15.toString());
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return this.time;
    }

    public String toString() {
        String str;
        ASN1Primitive aSN1Primitive = this.time;
        if (!(aSN1Primitive instanceof ASN1UTCTime)) {
            return ((ASN1GeneralizedTime) aSN1Primitive).getTime();
        }
        String fromByteArray = Strings.fromByteArray(((ASN1UTCTime) aSN1Primitive).time);
        if (fromByteArray.indexOf(45) >= 0 || fromByteArray.indexOf(43) >= 0) {
            int indexOf = fromByteArray.indexOf(45);
            if (indexOf < 0) {
                indexOf = fromByteArray.indexOf(43);
            }
            if (indexOf == fromByteArray.length() - 3) {
                fromByteArray = GeneratedOutlineSupport.outline8(fromByteArray, "00");
            }
            if (indexOf == 10) {
                StringBuilder sb = new StringBuilder();
                GeneratedOutlineSupport.outline20(fromByteArray, 0, 10, sb, "00GMT");
                GeneratedOutlineSupport.outline20(fromByteArray, 10, 13, sb, ColorPropConverter.PACKAGE_DELIMITER);
                sb.append(fromByteArray.substring(13, 15));
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                GeneratedOutlineSupport.outline20(fromByteArray, 0, 12, sb2, "GMT");
                GeneratedOutlineSupport.outline20(fromByteArray, 12, 15, sb2, ColorPropConverter.PACKAGE_DELIMITER);
                sb2.append(fromByteArray.substring(15, 17));
                str = sb2.toString();
            }
        } else if (fromByteArray.length() == 11) {
            str = fromByteArray.substring(0, 10) + "00GMT+00:00";
        } else {
            str = fromByteArray.substring(0, 12) + "GMT+00:00";
        }
        if (str.charAt(0) < '5') {
            return GeneratedOutlineSupport.outline8("20", str);
        }
        return GeneratedOutlineSupport.outline8("19", str);
    }
}
