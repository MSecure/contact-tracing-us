package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
/* loaded from: classes.dex */
public abstract class y0 extends w implements z0 {
    public y0() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
    }

    @Override // f.b.a.c.e.c.w
    public final boolean p(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.e.S1((Status) j0.a(parcel, Status.CREATOR), parcel.readArrayList(j0.a), ((k) this).a);
        return true;
    }
}
