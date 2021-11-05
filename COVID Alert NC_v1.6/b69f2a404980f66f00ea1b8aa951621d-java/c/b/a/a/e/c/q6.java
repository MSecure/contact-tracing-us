package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class q6 extends a {
    public static final Parcelable.Creator<q6> CREATOR = new u6();

    /* renamed from: b  reason: collision with root package name */
    public String f2702b;

    public q6() {
    }

    public q6(s6 s6Var) {
    }

    public q6(String str) {
        this.f2702b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q6) {
            return i.j.X(this.f2702b, ((q6) obj).f2702b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2702b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2702b, false);
        i.j.F1(parcel, e2);
    }
}
