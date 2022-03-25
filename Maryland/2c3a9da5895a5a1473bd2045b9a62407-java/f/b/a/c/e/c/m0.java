package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class m0 extends a {
    public static final Parcelable.Creator<m0> CREATOR = new n0();
    public r1 b;
    public o1 c;

    public m0() {
    }

    public m0(IBinder iBinder, IBinder iBinder2) {
        o1 o1Var;
        r1 r1Var = null;
        if (iBinder == null) {
            o1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyHistoryResultListener");
            o1Var = queryLocalInterface instanceof o1 ? (o1) queryLocalInterface : new o1(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
            r1Var = queryLocalInterface2 instanceof r1 ? (r1) queryLocalInterface2 : new p1(iBinder2);
        }
        this.c = o1Var;
        this.b = r1Var;
    }

    public /* synthetic */ m0(l0 l0Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            return m.h.U(this.c, m0Var.c) && m.h.U(this.b, m0Var.b);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.b});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder iBinder;
        int I1 = m.h.I1(parcel, 20293);
        o1 o1Var = this.c;
        if (o1Var == null) {
            iBinder = null;
        } else {
            iBinder = o1Var.a;
        }
        m.h.B1(parcel, 1, iBinder, false);
        m.h.B1(parcel, 2, this.b.asBinder(), false);
        m.h.N1(parcel, I1);
    }
}
