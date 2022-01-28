package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;

public abstract class s1 extends w implements t1 {
    public s1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
    }

    @Override // f.b.a.c.e.c.w
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.y1((Status) j0.a(parcel, Status.CREATOR), parcel.createTypedArrayList(TemporaryExposureKey.CREATOR), ((r) this).a);
        return true;
    }
}
