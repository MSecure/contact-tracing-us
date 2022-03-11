package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;

public abstract class s0 extends a implements t0 {
    public s0() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
    }

    @Override // f.b.a.c.e.c.a
    public final boolean l(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.s1((Status) z0.a(parcel, Status.CREATOR), parcel.readArrayList(z0.a), ((l) this).a);
        return true;
    }
}
