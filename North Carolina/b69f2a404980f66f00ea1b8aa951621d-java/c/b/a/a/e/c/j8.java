package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class j8 extends a {
    public static final Parcelable.Creator<j8> CREATOR = new i8();

    /* renamed from: b  reason: collision with root package name */
    public String f2629b;

    public j8() {
    }

    public j8(String str) {
        this.f2629b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j8) {
            return i.j.X(this.f2629b, ((j8) obj).f2629b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2629b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2629b, false);
        i.j.F1(parcel, e2);
    }
}
