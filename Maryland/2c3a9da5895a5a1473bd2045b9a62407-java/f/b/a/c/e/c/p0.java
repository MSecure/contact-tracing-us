package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class p0 extends a {
    public static final Parcelable.Creator<p0> CREATOR = new q0();
    public i1 b;

    public p0() {
    }

    public p0(IBinder iBinder) {
        i1 i1Var;
        if (iBinder == null) {
            i1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
            i1Var = queryLocalInterface instanceof i1 ? (i1) queryLocalInterface : new g1(iBinder);
        }
        this.b = i1Var;
    }

    public /* synthetic */ p0(o0 o0Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p0) {
            return m.h.U(this.b, ((p0) obj).b);
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
