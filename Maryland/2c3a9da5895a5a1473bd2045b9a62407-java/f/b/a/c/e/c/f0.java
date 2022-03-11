package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class f0 extends a {
    public static final Parcelable.Creator<f0> CREATOR = new g0();
    public n1 b;

    public f0() {
    }

    public f0(IBinder iBinder) {
        n1 n1Var;
        if (iBinder == null) {
            n1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
            n1Var = queryLocalInterface instanceof n1 ? (n1) queryLocalInterface : new l1(iBinder);
        }
        this.b = n1Var;
    }

    public /* synthetic */ f0(e0 e0Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f0) {
            return m.h.U(this.b, ((f0) obj).b);
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
}
