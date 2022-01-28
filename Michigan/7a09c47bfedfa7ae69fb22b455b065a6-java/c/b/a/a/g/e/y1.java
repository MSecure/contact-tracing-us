package c.b.a.a.g.e;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;

public abstract class y1 extends a implements z1 {
    public y1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        R((Status) s1.a(parcel, Status.CREATOR), (ExposureSummary) s1.a(parcel, ExposureSummary.CREATOR));
        return true;
    }
}
