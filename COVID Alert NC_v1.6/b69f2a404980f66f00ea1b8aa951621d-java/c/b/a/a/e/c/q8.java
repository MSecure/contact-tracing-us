package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class q8 extends a {
    public static final Parcelable.Creator<q8> CREATOR = new p8();

    /* renamed from: b  reason: collision with root package name */
    public int f2703b;

    /* renamed from: c  reason: collision with root package name */
    public String f2704c;

    public q8() {
    }

    public q8(int i, String str) {
        this.f2703b = i;
        this.f2704c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q8) {
            q8 q8Var = (q8) obj;
            return i.j.X(Integer.valueOf(this.f2703b), Integer.valueOf(q8Var.f2703b)) && i.j.X(this.f2704c, q8Var.f2704c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2703b), this.f2704c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2703b);
        i.j.z1(parcel, 2, this.f2704c, false);
        i.j.F1(parcel, e2);
    }
}
