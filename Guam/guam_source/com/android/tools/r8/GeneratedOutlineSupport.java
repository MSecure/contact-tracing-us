package com.android.tools.r8;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: outline */
public class GeneratedOutlineSupport {
    public static float outline0(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static int outline1(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static String outline10(String str, TemporalField temporalField) {
        return str + temporalField;
    }

    public static String outline11(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String outline12(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String outline13(TemporalAccessor temporalAccessor, StringBuilder sb) {
        sb.append(temporalAccessor.getClass().getName());
        return sb.toString();
    }

    public static String outline14(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder outline15(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder outline16(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder outline17(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder outline18(String str, TemporalAccessor temporalAccessor, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(temporalAccessor);
        sb.append(str2);
        return sb;
    }

    public static ASN1ObjectIdentifier outline19(String str) {
        return new ASN1ObjectIdentifier(str).intern();
    }

    public static String outline2(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static void outline20(String str, int i, int i2, StringBuilder sb, String str2) {
        sb.append(str.substring(i, i2));
        sb.append(str2);
    }

    public static String outline3(Exception exc, StringBuilder sb) {
        sb.append(exc.toString());
        return sb.toString();
    }

    public static String outline4(String str, int i) {
        return str + i;
    }

    public static String outline5(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String outline6(String str, long j) {
        return str + j;
    }

    public static String outline7(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String outline8(String str, String str2) {
        return str + str2;
    }

    public static String outline9(String str, String str2, String str3) {
        return str + str2 + str3;
    }
}
