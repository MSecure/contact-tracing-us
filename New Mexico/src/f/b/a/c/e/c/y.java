package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class y extends a {
    public static final Parcelable.Creator<y> CREATOR = new z();
    public z0 b;
    public DailySummariesConfig c;

    public y() {
    }

    public y(IBinder iBinder, DailySummariesConfig dailySummariesConfig) {
        z0 z0Var;
        if (iBinder == null) {
            z0Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
            z0Var = queryLocalInterface instanceof z0 ? (z0) queryLocalInterface : new x0(iBinder);
        }
        this.b = z0Var;
        this.c = dailySummariesConfig;
    }

    public /* synthetic */ y(x xVar) {
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (m.e.X(this.b, yVar.b) && m.e.X(this.c, yVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.c2(parcel, 1, this.b.asBinder(), false);
        m.e.f2(parcel, 2, this.c, i2, false);
        m.e.o2(parcel, j2);
    }
}
