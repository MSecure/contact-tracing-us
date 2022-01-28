package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class y9 extends a {
    public static final Parcelable.Creator<y9> CREATOR = new x9();

    /* renamed from: e  reason: collision with root package name */
    public static final y9 f3821e = new y9(1, "", null);

    /* renamed from: b  reason: collision with root package name */
    public final int f3822b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3823c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3824d;

    public y9(int i, String str, String str2) {
        Integer valueOf = Integer.valueOf(i);
        t.C(valueOf);
        this.f3822b = valueOf.intValue();
        this.f3823c = str == null ? "" : str;
        this.f3824d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y9)) {
            return false;
        }
        y9 y9Var = (y9) obj;
        return t.j1(this.f3823c, y9Var.f3823c) && t.j1(this.f3824d, y9Var.f3824d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3823c, this.f3824d});
    }

    public final String toString() {
        String str = this.f3823c;
        String str2 = this.f3824d;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 40);
        sb.append("NearbyDevice{handle=");
        sb.append(str);
        sb.append(", bluetoothAddress=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 3, this.f3823c, false);
        t.w3(parcel, 6, this.f3824d, false);
        t.q3(parcel, 1000, this.f3822b);
        t.w4(parcel, m);
    }
}
