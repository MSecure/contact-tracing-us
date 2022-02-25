package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class j0 extends a {
    public static final Parcelable.Creator<j0> CREATOR = new n0();
    public e1 b;

    public j0() {
    }

    public j0(IBinder iBinder) {
        e1 e1Var;
        if (iBinder == null) {
            e1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
            e1Var = queryLocalInterface instanceof e1 ? (e1) queryLocalInterface : new f1(iBinder);
        }
        this.b = e1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j0) {
            return m.h.U(this.b, ((j0) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        m.h.A1(parcel, 1, this.b.asBinder(), false);
        m.h.M1(parcel, H1);
    }

    public j0(l0 l0Var) {
    }
}
