package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class d0 extends a {
    public static final Parcelable.Creator<d0> CREATOR = new g0();
    public k1 b;

    public d0() {
    }

    public d0(IBinder iBinder) {
        k1 k1Var;
        if (iBinder == null) {
            k1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
            k1Var = queryLocalInterface instanceof k1 ? (k1) queryLocalInterface : new m1(iBinder);
        }
        this.b = k1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d0) {
            return m.h.U(this.b, ((d0) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.B1(parcel, 1, this.b.asBinder(), false);
        m.h.N1(parcel, I1);
    }

    public d0(f0 f0Var) {
    }
}
