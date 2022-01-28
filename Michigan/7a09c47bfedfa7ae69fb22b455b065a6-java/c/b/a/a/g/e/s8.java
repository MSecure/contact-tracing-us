package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class s8 extends a {
    public static final Parcelable.Creator<s8> CREATOR = new r8();

    /* renamed from: b  reason: collision with root package name */
    public int f3721b;

    public s8() {
    }

    public s8(int i) {
        this.f3721b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s8) {
            return t.j1(Integer.valueOf(this.f3721b), Integer.valueOf(((s8) obj).f3721b));
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3721b)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f3721b);
        t.w4(parcel, m);
    }
}
