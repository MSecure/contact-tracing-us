package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;

public abstract class s0 extends u implements t0 {
    public s0() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
    }

    @Override // f.b.a.c.e.c.u
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        boolean z = false;
        if (i2 != 1) {
            return false;
        }
        Status status = (Status) i0.a(parcel, Status.CREATOR);
        if (parcel.readInt() != 0) {
            z = true;
        }
        m.h.s1(status, Boolean.valueOf(z), ((o) this).a);
        return true;
    }
}
