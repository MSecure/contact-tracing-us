package c.b.a.a.g.e;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class h1 extends a implements e1 {
    public h1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        if (i != 1) {
            return false;
        }
        Status status = (Status) s1.a(parcel, Status.CREATOR);
        if (parcel.readInt() != 0) {
            z = true;
        }
        F(status, z);
        return true;
    }
}
