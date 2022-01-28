package c.b.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import b.x.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a extends c.b.a.a.d.m.o.a {
    public static final Parcelable.Creator<a> CREATOR = new c();
    public static final byte[][] j;

    /* renamed from: b  reason: collision with root package name */
    public final String f4074b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f4075c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[][] f4076d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[][] f4077e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[][] f4078f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[][] f4079g;
    public final int[] h;
    public final byte[][] i;

    static {
        byte[][] bArr = new byte[0][];
        j = bArr;
        new a("", null, bArr, bArr, bArr, bArr, null, null);
    }

    public a(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.f4074b = str;
        this.f4075c = bArr;
        this.f4076d = bArr2;
        this.f4077e = bArr3;
        this.f4078f = bArr4;
        this.f4079g = bArr5;
        this.h = iArr;
        this.i = bArr6;
    }

    public static List<Integer> t(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<String> x(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] bArr2 : bArr) {
            arrayList.add(Base64.encodeToString(bArr2, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static void y(StringBuilder sb, String str, byte[][] bArr) {
        String str2;
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            str2 = "null";
        } else {
            sb.append("(");
            int length = bArr.length;
            boolean z = true;
            int i2 = 0;
            while (i2 < length) {
                byte[] bArr2 = bArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append("'");
                sb.append(Base64.encodeToString(bArr2, 3));
                sb.append("'");
                i2++;
                z = false;
            }
            str2 = ")";
        }
        sb.append(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return t.m1(this.f4074b, aVar.f4074b) && Arrays.equals(this.f4075c, aVar.f4075c) && t.m1(x(this.f4076d), x(aVar.f4076d)) && t.m1(x(this.f4077e), x(aVar.f4077e)) && t.m1(x(this.f4078f), x(aVar.f4078f)) && t.m1(x(this.f4079g), x(aVar.f4079g)) && t.m1(t(this.h), t(aVar.h)) && t.m1(x(this.i), x(aVar.i));
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ExperimentTokens");
        sb.append("(");
        String str2 = this.f4074b;
        if (str2 == null) {
            str = "null";
        } else {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 2);
            sb2.append("'");
            sb2.append(str2);
            sb2.append("'");
            str = sb2.toString();
        }
        sb.append(str);
        sb.append(", ");
        byte[] bArr = this.f4075c;
        sb.append("direct");
        sb.append("=");
        if (bArr == null) {
            sb.append("null");
        } else {
            sb.append("'");
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append("'");
        }
        sb.append(", ");
        y(sb, "GAIA", this.f4076d);
        sb.append(", ");
        y(sb, "PSEUDO", this.f4077e);
        sb.append(", ");
        y(sb, "ALWAYS", this.f4078f);
        sb.append(", ");
        y(sb, "OTHER", this.f4079g);
        sb.append(", ");
        int[] iArr = this.h;
        sb.append("weak");
        sb.append("=");
        if (iArr == null) {
            sb.append("null");
        } else {
            sb.append("(");
            int length = iArr.length;
            boolean z = true;
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append(i3);
                i2++;
                z = false;
            }
            sb.append(")");
        }
        sb.append(", ");
        y(sb, "directs", this.i);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int m = t.m(parcel);
        t.w3(parcel, 2, this.f4074b, false);
        t.l3(parcel, 3, this.f4075c, false);
        t.m3(parcel, 4, this.f4076d, false);
        t.m3(parcel, 5, this.f4077e, false);
        t.m3(parcel, 6, this.f4078f, false);
        t.m3(parcel, 7, this.f4079g, false);
        t.r3(parcel, 8, this.h, false);
        t.m3(parcel, 9, this.i, false);
        t.w4(parcel, m);
    }
}
