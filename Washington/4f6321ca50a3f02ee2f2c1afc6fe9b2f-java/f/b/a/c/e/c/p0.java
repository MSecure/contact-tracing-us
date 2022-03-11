package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;

public abstract class p0 extends a implements m0 {
    public p0() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
    }

    @Override // f.b.a.c.e.c.a
    public final boolean l(int i2, Parcel parcel, Parcel parcel2, int i3) {
        boolean z = false;
        if (i2 != 1) {
            return false;
        }
        Status status = (Status) z0.a(parcel, Status.CREATOR);
        if (parcel.readInt() != 0) {
            z = true;
        }
        m.h.s1(status, Boolean.valueOf(z), ((q) this).a);
        return true;
    }
}
