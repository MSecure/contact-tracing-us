package c.b.a.a.g.e;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;

public abstract class v1 extends a implements r1 {
    public v1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationListCallback");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        a((Status) s1.a(parcel, Status.CREATOR), parcel.createTypedArrayList(ExposureInformation.CREATOR));
        return true;
    }
}
