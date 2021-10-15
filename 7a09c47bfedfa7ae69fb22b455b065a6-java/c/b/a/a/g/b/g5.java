package c.b.a.a.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class g5 extends a {
    public static final Parcelable.Creator<g5> CREATOR = new h5();

    /* renamed from: b  reason: collision with root package name */
    public final String f3285b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3286c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3287d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3288e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3289f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3290g;
    public final String h;
    public final boolean i;
    public final int j;

    public g5(String str, int i2, int i3, String str2, String str3, String str4, boolean z, n4 n4Var) {
        t.C(str);
        this.f3285b = str;
        this.f3286c = i2;
        this.f3287d = i3;
        this.h = str2;
        this.f3288e = str3;
        this.f3289f = str4;
        this.f3290g = !z;
        this.i = z;
        this.j = n4Var.f3377b;
    }

    public g5(String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.f3285b = str;
        this.f3286c = i2;
        this.f3287d = i3;
        this.f3288e = str2;
        this.f3289f = str3;
        this.f3290g = z;
        this.h = str4;
        this.i = z2;
        this.j = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g5) {
            g5 g5Var = (g5) obj;
            return t.j1(this.f3285b, g5Var.f3285b) && this.f3286c == g5Var.f3286c && this.f3287d == g5Var.f3287d && t.j1(this.h, g5Var.h) && t.j1(this.f3288e, g5Var.f3288e) && t.j1(this.f3289f, g5Var.f3289f) && this.f3290g == g5Var.f3290g && this.i == g5Var.i && this.j == g5Var.j;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3285b, Integer.valueOf(this.f3286c), Integer.valueOf(this.f3287d), this.h, this.f3288e, this.f3289f, Boolean.valueOf(this.f3290g), Boolean.valueOf(this.i), Integer.valueOf(this.j)});
    }

    public final String toString() {
        return "PlayLoggerContext[" + "package=" + this.f3285b + ',' + "packageVersionCode=" + this.f3286c + ',' + "logSource=" + this.f3287d + ',' + "logSourceName=" + this.h + ',' + "uploadAccount=" + this.f3288e + ',' + "loggingId=" + this.f3289f + ',' + "logAndroidId=" + this.f3290g + ',' + "isAnonymous=" + this.i + ',' + "qosTier=" + this.j + "]";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int m = t.m(parcel);
        t.w3(parcel, 2, this.f3285b, false);
        t.q3(parcel, 3, this.f3286c);
        t.q3(parcel, 4, this.f3287d);
        t.w3(parcel, 5, this.f3288e, false);
        t.w3(parcel, 6, this.f3289f, false);
        t.j3(parcel, 7, this.f3290g);
        t.w3(parcel, 8, this.h, false);
        t.j3(parcel, 9, this.i);
        t.q3(parcel, 10, this.j);
        t.w4(parcel, m);
    }
}
