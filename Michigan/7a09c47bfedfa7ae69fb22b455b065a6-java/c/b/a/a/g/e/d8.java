package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class d8 extends a {
    public static final Parcelable.Creator<d8> CREATOR = new c8();

    /* renamed from: b  reason: collision with root package name */
    public String f3536b;

    public d8() {
    }

    public d8(String str) {
        this.f3536b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d8) {
            return t.j1(this.f3536b, ((d8) obj).f3536b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3536b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3536b, false);
        t.w4(parcel, m);
    }
}
