package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class j1 extends w implements k1 {
    public j1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
    }

    @Override // f.b.a.c.e.c.w
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        C((Status) j0.a(parcel, Status.CREATOR), parcel.readLong());
        return true;
    }
}
