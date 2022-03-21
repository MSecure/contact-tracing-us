package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class b0 extends a {
    public static final Parcelable.Creator<b0> CREATOR = new e0();
    public b1 b;
    public String c;

    public b0() {
    }

    public b0(IBinder iBinder, String str) {
        b1 b1Var;
        if (iBinder == null) {
            b1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
            b1Var = queryLocalInterface instanceof b1 ? (b1) queryLocalInterface : new c1(iBinder);
        }
        this.b = b1Var;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            return m.h.U(this.b, b0Var.b) && m.h.U(this.c, b0Var.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        m.h.A1(parcel, 1, this.b.asBinder(), false);
        m.h.E1(parcel, 2, this.c, false);
        m.h.M1(parcel, H1);
    }

    public b0(c0 c0Var) {
    }
}
