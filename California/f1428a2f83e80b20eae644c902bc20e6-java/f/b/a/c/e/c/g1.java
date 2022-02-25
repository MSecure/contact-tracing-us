package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;

public abstract class g1 extends a implements e1 {
    public g1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
    }

    @Override // f.b.a.c.e.c.a
    public final boolean l(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.r1((Status) z0.a(parcel, Status.CREATOR), Long.valueOf(parcel.readLong()), ((j) this).a);
        return true;
    }
}
