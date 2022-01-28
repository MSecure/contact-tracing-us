package c.b.a.a.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;

public abstract class y1 extends a implements z1 {
    public y1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        U((Status) s1.a(parcel, Status.CREATOR), (ExposureSummary) s1.a(parcel, ExposureSummary.CREATOR));
        return true;
    }
}
