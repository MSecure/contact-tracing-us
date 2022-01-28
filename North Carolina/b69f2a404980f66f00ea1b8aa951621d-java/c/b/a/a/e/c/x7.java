package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class x7 extends a {
    public static final Parcelable.Creator<x7> CREATOR = new w7();

    /* renamed from: b  reason: collision with root package name */
    public String f2806b;

    /* renamed from: c  reason: collision with root package name */
    public int f2807c;

    public x7() {
    }

    public x7(String str, int i) {
        this.f2806b = str;
        this.f2807c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x7) {
            x7 x7Var = (x7) obj;
            return i.j.X(this.f2806b, x7Var.f2806b) && i.j.X(Integer.valueOf(this.f2807c), Integer.valueOf(x7Var.f2807c));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2806b, Integer.valueOf(this.f2807c)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2806b, false);
        i.j.u1(parcel, 2, this.f2807c);
        i.j.F1(parcel, e2);
    }
}
