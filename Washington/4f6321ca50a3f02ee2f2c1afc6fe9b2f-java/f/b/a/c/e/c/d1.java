package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.f.b.d;

public abstract class d1 extends a implements b1 {
    public d1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
    }

    @Override // f.b.a.c.e.c.a
    public final boolean l(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.s1((Status) z0.a(parcel, Status.CREATOR), parcel.createTypedArrayList(d.CREATOR), ((t) this).a);
        return true;
    }
}
