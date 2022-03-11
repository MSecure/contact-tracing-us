package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class w extends a {
    public static final Parcelable.Creator<w> CREATOR = new x();
    public x0 b;
    public DailySummariesConfig c;

    public w() {
    }

    public w(IBinder iBinder, DailySummariesConfig dailySummariesConfig) {
        x0 x0Var;
        if (iBinder == null) {
            x0Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
            x0Var = queryLocalInterface instanceof x0 ? (x0) queryLocalInterface : new v0(iBinder);
        }
        this.b = x0Var;
        this.c = dailySummariesConfig;
    }

    public /* synthetic */ w(v vVar) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            return m.h.U(this.b, wVar.b) && m.h.U(this.c, wVar.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.B1(parcel, 1, this.b.asBinder(), false);
        m.h.E1(parcel, 2, this.c, i2, false);
        m.h.N1(parcel, I1);
    }
}
