package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.k.o.h;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class j3 extends a {
    public static final Parcelable.Creator<j3> CREATOR = new k3();

    /* renamed from: b  reason: collision with root package name */
    public h f2626b;

    public j3() {
    }

    public j3(IBinder iBinder) {
        this.f2626b = h.a.i0(iBinder);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j3) {
            return i.j.X(this.f2626b, ((j3) obj).f2626b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2626b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 1, this.f2626b.asBinder(), false);
        i.j.F1(parcel, e2);
    }

    public j3(i3 i3Var) {
    }
}
