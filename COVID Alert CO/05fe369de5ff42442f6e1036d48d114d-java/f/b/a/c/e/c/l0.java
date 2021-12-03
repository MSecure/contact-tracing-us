package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class l0 extends a {
    public static final Parcelable.Creator<l0> CREATOR = new m0();
    public k1 b;

    public l0() {
    }

    public l0(IBinder iBinder) {
        k1 k1Var;
        if (iBinder == null) {
            k1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
            k1Var = queryLocalInterface instanceof k1 ? (k1) queryLocalInterface : new i1(iBinder);
        }
        this.b = k1Var;
    }

    public /* synthetic */ l0(k0 k0Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l0) {
            return m.h.U(this.b, ((l0) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        m.h.H1(parcel, 1, this.b.asBinder(), false);
        m.h.T1(parcel, O1);
    }
}
