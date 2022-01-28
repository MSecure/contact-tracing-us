package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class u0 extends a {
    public static final Parcelable.Creator<u0> CREATOR = new z0();

    /* renamed from: b  reason: collision with root package name */
    public i2 f3745b;

    public u0() {
    }

    public u0(IBinder iBinder) {
        i2 i2Var;
        if (iBinder == null) {
            i2Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
            i2Var = queryLocalInterface instanceof i2 ? (i2) queryLocalInterface : new k2(iBinder);
        }
        this.f3745b = i2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u0) {
            return t.j1(this.f3745b, ((u0) obj).f3745b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3745b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.p3(parcel, 1, this.f3745b.asBinder(), false);
        t.w4(parcel, m);
    }

    public u0(x0 x0Var) {
    }
}
