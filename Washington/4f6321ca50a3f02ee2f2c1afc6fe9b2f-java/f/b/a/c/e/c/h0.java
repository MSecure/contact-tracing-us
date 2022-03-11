package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class h0 extends a {
    public static final Parcelable.Creator<h0> CREATOR = new k0();
    public l1 b;
    public n1 c;

    public h0() {
    }

    public h0(IBinder iBinder, IBinder iBinder2) {
        l1 l1Var;
        n1 n1Var = null;
        if (iBinder == null) {
            l1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyHistoryResultListener");
            l1Var = queryLocalInterface instanceof l1 ? (l1) queryLocalInterface : new o1(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
            n1Var = queryLocalInterface2 instanceof n1 ? (n1) queryLocalInterface2 : new p1(iBinder2);
        }
        this.b = l1Var;
        this.c = n1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h0) {
            h0 h0Var = (h0) obj;
            return m.h.U(this.b, h0Var.b) && m.h.U(this.c, h0Var.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        l1 l1Var = this.b;
        m.h.B1(parcel, 1, l1Var == null ? null : l1Var.asBinder(), false);
        m.h.B1(parcel, 2, this.c.asBinder(), false);
        m.h.N1(parcel, I1);
    }

    public h0(i0 i0Var) {
    }
}
