package c.b.a.a.g.e;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class k1 extends a implements l1 {
    public k1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        a((Status) s1.a(parcel, Status.CREATOR), parcel.readArrayList(s1.f3704a));
        return true;
    }
}
