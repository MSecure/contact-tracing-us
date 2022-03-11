package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class s1 extends a {
    public static final Parcelable.Creator<s1> CREATOR = new t1();
    public r0 b;
    public m0 c;

    public s1() {
    }

    public s1(IBinder iBinder, IBinder iBinder2) {
        r0 r0Var;
        m0 m0Var = null;
        if (iBinder == null) {
            r0Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanResultListener");
            r0Var = queryLocalInterface instanceof r0 ? (r0) queryLocalInterface : new q0(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
            m0Var = queryLocalInterface2 instanceof m0 ? (m0) queryLocalInterface2 : new o0(iBinder2);
        }
        this.b = r0Var;
        this.c = m0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s1) {
            s1 s1Var = (s1) obj;
            return m.h.U(this.b, s1Var.b) && m.h.U(this.c, s1Var.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        r0 r0Var = this.b;
        m.h.B1(parcel, 1, r0Var == null ? null : r0Var.asBinder(), false);
        m.h.B1(parcel, 2, this.c.asBinder(), false);
        m.h.N1(parcel, I1);
    }

    public s1(r1 r1Var) {
    }
}
