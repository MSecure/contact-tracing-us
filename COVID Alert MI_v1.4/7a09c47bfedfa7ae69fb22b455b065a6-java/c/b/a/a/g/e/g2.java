package c.b.a.a.g.e;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class g2 extends a implements h2 {
    public g2() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IIntCallback");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        p((Status) s1.a(parcel, Status.CREATOR), parcel.readInt());
        return true;
    }
}
