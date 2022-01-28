package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class r0 extends a {
    public static final Parcelable.Creator<r0> CREATOR = new w0();

    /* renamed from: b  reason: collision with root package name */
    public p2 f3701b;

    public r0() {
    }

    public r0(IBinder iBinder) {
        p2 p2Var;
        if (iBinder == null) {
            p2Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
            p2Var = queryLocalInterface instanceof p2 ? (p2) queryLocalInterface : new r2(iBinder);
        }
        this.f3701b = p2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r0) {
            return t.j1(this.f3701b, ((r0) obj).f3701b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3701b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.p3(parcel, 1, this.f3701b.asBinder(), false);
        t.w4(parcel, m);
    }

    public r0(t0 t0Var) {
    }
}
