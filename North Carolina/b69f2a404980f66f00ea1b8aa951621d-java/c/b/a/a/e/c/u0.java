package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class u0 extends a {
    public static final Parcelable.Creator<u0> CREATOR = new z0();

    /* renamed from: b  reason: collision with root package name */
    public i2 f2746b;

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
        this.f2746b = i2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u0) {
            return i.j.X(this.f2746b, ((u0) obj).f2746b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2746b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 1, this.f2746b.asBinder(), false);
        i.j.F1(parcel, e2);
    }

    public u0(x0 x0Var) {
    }
}
