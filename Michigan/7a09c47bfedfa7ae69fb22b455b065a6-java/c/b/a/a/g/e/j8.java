package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class j8 extends a {
    public static final Parcelable.Creator<j8> CREATOR = new i8();

    /* renamed from: b  reason: collision with root package name */
    public String f3617b;

    public j8() {
    }

    public j8(String str) {
        this.f3617b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j8) {
            return t.j1(this.f3617b, ((j8) obj).f3617b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3617b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3617b, false);
        t.w4(parcel, m);
    }
}
