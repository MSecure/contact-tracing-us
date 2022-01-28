package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.k.o.h;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class j3 extends a {
    public static final Parcelable.Creator<j3> CREATOR = new k3();

    /* renamed from: b  reason: collision with root package name */
    public h f3614b;

    public j3() {
    }

    public j3(IBinder iBinder) {
        this.f3614b = h.a.f0(iBinder);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j3) {
            return t.j1(this.f3614b, ((j3) obj).f3614b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3614b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.p3(parcel, 1, this.f3614b.asBinder(), false);
        t.w4(parcel, m);
    }

    public j3(i3 i3Var) {
    }
}
