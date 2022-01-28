package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class h0 extends a {
    public static final Parcelable.Creator<h0> CREATOR = new i0();
    public p1 b;

    public h0() {
    }

    public h0(IBinder iBinder) {
        p1 p1Var;
        if (iBinder == null) {
            p1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
            p1Var = queryLocalInterface instanceof p1 ? (p1) queryLocalInterface : new n1(iBinder);
        }
        this.b = p1Var;
    }

    public /* synthetic */ h0(g0 g0Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h0) {
            return m.e.W(this.b, ((h0) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int b2 = m.e.b2(parcel, 20293);
        m.e.U1(parcel, 1, this.b.asBinder(), false);
        m.e.g2(parcel, b2);
    }
}
