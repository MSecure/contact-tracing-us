package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class q6 extends a {
    public static final Parcelable.Creator<q6> CREATOR = new u6();

    /* renamed from: b  reason: collision with root package name */
    public String f3696b;

    public q6() {
    }

    public q6(s6 s6Var) {
    }

    public q6(String str) {
        this.f3696b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q6) {
            return t.j1(this.f3696b, ((q6) obj).f3696b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3696b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3696b, false);
        t.w4(parcel, m);
    }
}
