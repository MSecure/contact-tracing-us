package c.b.a.a.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class l2 extends a implements i2 {
    public l2() {
        super("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        t((Status) s1.a(parcel, Status.CREATOR), parcel.readLong());
        return true;
    }
}
