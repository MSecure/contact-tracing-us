package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class x7 extends a {
    public static final Parcelable.Creator<x7> CREATOR = new w7();

    /* renamed from: b  reason: collision with root package name */
    public String f3813b;

    /* renamed from: c  reason: collision with root package name */
    public int f3814c;

    public x7() {
    }

    public x7(String str, int i) {
        this.f3813b = str;
        this.f3814c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x7) {
            x7 x7Var = (x7) obj;
            return t.j1(this.f3813b, x7Var.f3813b) && t.j1(Integer.valueOf(this.f3814c), Integer.valueOf(x7Var.f3814c));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3813b, Integer.valueOf(this.f3814c)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3813b, false);
        t.q3(parcel, 2, this.f3814c);
        t.w4(parcel, m);
    }
}
