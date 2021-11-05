package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class y9 extends a {
    public static final Parcelable.Creator<y9> CREATOR = new x9();

    /* renamed from: e  reason: collision with root package name */
    public static final y9 f2814e = new y9(1, "", null);

    /* renamed from: b  reason: collision with root package name */
    public final int f2815b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2816c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2817d;

    public y9(int i, String str, String str2) {
        Integer valueOf = Integer.valueOf(i);
        i.j.s(valueOf);
        this.f2815b = valueOf.intValue();
        this.f2816c = str == null ? "" : str;
        this.f2817d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y9)) {
            return false;
        }
        y9 y9Var = (y9) obj;
        return i.j.X(this.f2816c, y9Var.f2816c) && i.j.X(this.f2817d, y9Var.f2817d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2816c, this.f2817d});
    }

    public final String toString() {
        String str = this.f2816c;
        String str2 = this.f2817d;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 40);
        sb.append("NearbyDevice{handle=");
        sb.append(str);
        sb.append(", bluetoothAddress=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 3, this.f2816c, false);
        i.j.z1(parcel, 6, this.f2817d, false);
        i.j.u1(parcel, 1000, this.f2815b);
        i.j.F1(parcel, e2);
    }
}
