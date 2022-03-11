package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class h1 extends u implements i1 {
    public h1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
    }

    @Override // f.b.a.c.e.c.u
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        A((Status) i0.a(parcel, Status.CREATOR), parcel.readLong());
        return true;
    }
}
