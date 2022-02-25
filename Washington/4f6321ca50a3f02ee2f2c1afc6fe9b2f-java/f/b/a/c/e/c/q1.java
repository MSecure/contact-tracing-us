package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;

public abstract class q1 extends a implements n1 {
    public q1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
    }

    @Override // f.b.a.c.e.c.a
    public final boolean l(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.s1((Status) z0.a(parcel, Status.CREATOR), parcel.createTypedArrayList(TemporaryExposureKey.CREATOR), ((p) this).a);
        return true;
    }
}
