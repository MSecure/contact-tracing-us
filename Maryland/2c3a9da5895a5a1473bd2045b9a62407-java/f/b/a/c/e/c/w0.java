package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;

public abstract class w0 extends u implements x0 {
    public w0() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
    }

    @Override // f.b.a.c.e.c.u
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.s1((Status) i0.a(parcel, Status.CREATOR), parcel.readArrayList(i0.a), ((i) this).a);
        return true;
    }
}
