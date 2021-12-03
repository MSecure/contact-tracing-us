package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class r0 extends a {
    public static final Parcelable.Creator<r0> CREATOR = new s0();
    public k1 b;

    public r0() {
    }

    public r0(IBinder iBinder) {
        k1 k1Var;
        if (iBinder == null) {
            k1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
            k1Var = queryLocalInterface instanceof k1 ? (k1) queryLocalInterface : new i1(iBinder);
        }
        this.b = k1Var;
    }

    public /* synthetic */ r0(q0 q0Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r0) {
            return m.e.W(this.b, ((r0) obj).b);
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
