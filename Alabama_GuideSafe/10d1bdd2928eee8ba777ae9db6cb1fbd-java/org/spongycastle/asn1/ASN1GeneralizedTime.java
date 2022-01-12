package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.common.util.concurrent.MoreExecutors;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.spongycastle.util.Strings;

public class ASN1GeneralizedTime extends ASN1Primitive {
    public byte[] time;

    public ASN1GeneralizedTime(byte[] bArr) {
        this.time = bArr;
    }

    public static ASN1GeneralizedTime getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1GeneralizedTime)) {
            return (ASN1GeneralizedTime) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1GeneralizedTime) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline4(e, GeneratedOutlineSupport.outline17("encoding error in getInstance: ")));
            }
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("illegal object in getInstance: ");
            outline17.append(obj.getClass().getName());
            throw new IllegalArgumentException(outline17.toString());
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1GeneralizedTime)) {
            return false;
        }
        return MoreExecutors.areEqual(this.time, ((ASN1GeneralizedTime) aSN1Primitive).time);
    }

    public final String calculateGMTOffset() {
        String str;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str = "-";
        } else {
            str = "+";
        }
        int i = rawOffset / 3600000;
        int i2 = (rawOffset - (((i * 60) * 60) * RNCWebViewManager.COMMAND_CLEAR_FORM_DATA)) / 60000;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(getDate())) {
                i += str.equals("+") ? 1 : -1;
            }
        } catch (ParseException unused) {
        }
        StringBuilder outline19 = GeneratedOutlineSupport.outline19("GMT", str);
        outline19.append(convert(i));
        outline19.append(ColorPropConverter.PACKAGE_DELIMITER);
        outline19.append(convert(i2));
        return outline19.toString();
    }

    public final String convert(int i) {
        if (i < 10) {
            return GeneratedOutlineSupport.outline5("0", i);
        }
        return Integer.toString(i);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(24, this.time);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.endsWith("Z")) {
            if (hasFractionalSeconds()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (fromByteArray.indexOf(45) > 0 || fromByteArray.indexOf(43) > 0) {
            fromByteArray = getTime();
            if (hasFractionalSeconds()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else {
            if (hasFractionalSeconds()) {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            } else {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
            }
            simpleDateFormat = simpleDateFormat2;
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }
        if (hasFractionalSeconds()) {
            String substring = fromByteArray.substring(14);
            int i = 1;
            while (i < substring.length() && '0' <= (r7 = substring.charAt(i)) && r7 <= '9') {
                i++;
            }
            int i2 = i - 1;
            if (i2 > 3) {
                fromByteArray = fromByteArray.substring(0, 14) + (substring.substring(0, 4) + substring.substring(i));
            } else if (i2 == 1) {
                StringBuilder sb = new StringBuilder();
                GeneratedOutlineSupport.outline23(substring, 0, i, sb, "00");
                sb.append(substring.substring(i));
                fromByteArray = fromByteArray.substring(0, 14) + sb.toString();
            } else if (i2 == 2) {
                StringBuilder sb2 = new StringBuilder();
                GeneratedOutlineSupport.outline23(substring, 0, i, sb2, "0");
                sb2.append(substring.substring(i));
                fromByteArray = fromByteArray.substring(0, 14) + sb2.toString();
            }
        }
        return simpleDateFormat.parse(fromByteArray);
    }

    public String getTime() {
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.charAt(fromByteArray.length() - 1) == 'Z') {
            return fromByteArray.substring(0, fromByteArray.length() - 1) + "GMT+00:00";
        }
        int length = fromByteArray.length() - 5;
        char charAt = fromByteArray.charAt(length);
        if (charAt == '-' || charAt == '+') {
            StringBuilder sb = new StringBuilder();
            sb.append(fromByteArray.substring(0, length));
            sb.append("GMT");
            int i = length + 3;
            GeneratedOutlineSupport.outline23(fromByteArray, length, i, sb, ColorPropConverter.PACKAGE_DELIMITER);
            sb.append(fromByteArray.substring(i));
            return sb.toString();
        }
        int length2 = fromByteArray.length() - 3;
        char charAt2 = fromByteArray.charAt(length2);
        if (charAt2 == '-' || charAt2 == '+') {
            StringBuilder sb2 = new StringBuilder();
            GeneratedOutlineSupport.outline23(fromByteArray, 0, length2, sb2, "GMT");
            sb2.append(fromByteArray.substring(length2));
            sb2.append(":00");
            return sb2.toString();
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17(fromByteArray);
        outline17.append(calculateGMTOffset());
        return outline17.toString();
    }

    public final boolean hasFractionalSeconds() {
        int i = 0;
        while (true) {
            byte[] bArr = this.time;
            if (i == bArr.length) {
                return false;
            }
            if (bArr[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return MoreExecutors.hashCode(this.time);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }
}
