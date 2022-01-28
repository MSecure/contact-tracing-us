package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class m8 extends a {
    public static final Parcelable.Creator<m8> CREATOR = new l8();

    /* renamed from: b  reason: collision with root package name */
    public String f3658b;

    /* renamed from: c  reason: collision with root package name */
    public w8 f3659c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3660d;

    public m8() {
    }

    public m8(String str, w8 w8Var, boolean z) {
        this.f3658b = str;
        this.f3659c = w8Var;
        this.f3660d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m8) {
            m8 m8Var = (m8) obj;
            return t.j1(this.f3658b, m8Var.f3658b) && t.j1(this.f3659c, m8Var.f3659c) && t.j1(Boolean.valueOf(this.f3660d), Boolean.valueOf(m8Var.f3660d));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3658b, this.f3659c, Boolean.valueOf(this.f3660d)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3658b, false);
        t.v3(parcel, 2, this.f3659c, i, false);
        t.j3(parcel, 3, this.f3660d);
        t.w4(parcel, m);
    }
}
