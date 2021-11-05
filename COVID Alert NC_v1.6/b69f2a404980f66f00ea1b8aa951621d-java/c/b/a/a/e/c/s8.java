package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class s8 extends a {
    public static final Parcelable.Creator<s8> CREATOR = new r8();

    /* renamed from: b  reason: collision with root package name */
    public int f2725b;

    public s8() {
    }

    public s8(int i) {
        this.f2725b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s8) {
            return i.j.X(Integer.valueOf(this.f2725b), Integer.valueOf(((s8) obj).f2725b));
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2725b)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2725b);
        i.j.F1(parcel, e2);
    }
}
