package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.f.b.e;

public abstract class e1 extends u implements f1 {
    public e1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
    }

    @Override // f.b.a.c.e.c.u
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.s1((Status) i0.a(parcel, Status.CREATOR), parcel.createTypedArrayList(e.CREATOR), ((s) this).a);
        return true;
    }
}
