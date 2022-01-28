package c.b.a.a.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;

public abstract class v2 extends a implements s2 {
    public v2() {
        super("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        a((Status) s1.a(parcel, Status.CREATOR), parcel.createTypedArrayList(TemporaryExposureKey.CREATOR));
        return true;
    }
}
