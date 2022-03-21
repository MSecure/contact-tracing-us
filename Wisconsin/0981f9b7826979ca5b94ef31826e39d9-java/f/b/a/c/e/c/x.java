package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class x extends a {
    public static final Parcelable.Creator<x> CREATOR = new a0();
    public y0 b;

    public x() {
    }

    public x(IBinder iBinder) {
        y0 y0Var;
        if (iBinder == null) {
            y0Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
            y0Var = queryLocalInterface instanceof y0 ? (y0) queryLocalInterface : new a1(iBinder);
        }
        this.b = y0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return m.h.U(this.b, ((x) obj).b);
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

    public x(z zVar) {
    }
}
