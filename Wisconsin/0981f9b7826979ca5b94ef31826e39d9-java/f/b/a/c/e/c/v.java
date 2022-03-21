package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class v extends a {
    public static final Parcelable.Creator<v> CREATOR = new y();
    public t0 b;
    public DailySummariesConfig c;

    public v() {
    }

    public v(IBinder iBinder, DailySummariesConfig dailySummariesConfig) {
        t0 t0Var;
        if (iBinder == null) {
            t0Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
            t0Var = queryLocalInterface instanceof t0 ? (t0) queryLocalInterface : new v0(iBinder);
        }
        this.b = t0Var;
        this.c = dailySummariesConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            return m.h.U(this.b, vVar.b) && m.h.U(this.c, vVar.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        m.h.A1(parcel, 1, this.b.asBinder(), false);
        m.h.D1(parcel, 2, this.c, i2, false);
        m.h.M1(parcel, H1);
    }

    public v(w wVar) {
    }
}
