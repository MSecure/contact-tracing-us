package c.b.a.a.g.e;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;

public abstract class f2 extends a implements c2 {
    public f2() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        a((Status) s1.a(parcel, Status.CREATOR), parcel.createTypedArrayList(ExposureWindow.CREATOR));
        return true;
    }
}
