package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class t1 extends a {
    public static final Parcelable.Creator<t1> CREATOR = new u1();
    public t0 b;
    public u0 c;

    public t1() {
    }

    public t1(IBinder iBinder, IBinder iBinder2) {
        u0 u0Var;
        t0 t0Var = null;
        if (iBinder == null) {
            u0Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanResultListener");
            u0Var = queryLocalInterface instanceof u0 ? (u0) queryLocalInterface : new u0(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
            t0Var = queryLocalInterface2 instanceof t0 ? (t0) queryLocalInterface2 : new r0(iBinder2);
        }
        this.c = u0Var;
        this.b = t0Var;
    }

    public /* synthetic */ t1(s1 s1Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t1) {
            t1 t1Var = (t1) obj;
            return m.h.U(this.c, t1Var.c) && m.h.U(this.b, t1Var.b);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.b});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder iBinder;
        int I1 = m.h.I1(parcel, 20293);
        u0 u0Var = this.c;
        if (u0Var == null) {
            iBinder = null;
        } else {
            iBinder = u0Var.a;
        }
        m.h.B1(parcel, 1, iBinder, false);
        m.h.B1(parcel, 2, this.b.asBinder(), false);
        m.h.N1(parcel, I1);
    }
}
