package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class q8 extends a {
    public static final Parcelable.Creator<q8> CREATOR = new p8();

    /* renamed from: b  reason: collision with root package name */
    public int f3697b;

    /* renamed from: c  reason: collision with root package name */
    public String f3698c;

    public q8() {
    }

    public q8(int i, String str) {
        this.f3697b = i;
        this.f3698c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q8) {
            q8 q8Var = (q8) obj;
            return t.j1(Integer.valueOf(this.f3697b), Integer.valueOf(q8Var.f3697b)) && t.j1(this.f3698c, q8Var.f3698c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3697b), this.f3698c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f3697b);
        t.w3(parcel, 2, this.f3698c, false);
        t.w4(parcel, m);
    }
}
