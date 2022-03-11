package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class z extends a {
    public static final Parcelable.Creator<z> CREATOR = new a0();
    public c1 b;

    public z() {
    }

    public z(IBinder iBinder) {
        c1 c1Var;
        if (iBinder == null) {
            c1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
            c1Var = queryLocalInterface instanceof c1 ? (c1) queryLocalInterface : new a1(iBinder);
        }
        this.b = c1Var;
    }

    public /* synthetic */ z(y yVar) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            return m.h.U(this.b, ((z) obj).b);
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
