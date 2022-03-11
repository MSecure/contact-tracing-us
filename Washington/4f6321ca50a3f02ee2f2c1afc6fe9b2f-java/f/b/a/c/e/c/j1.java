package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.f.b.e;

public abstract class j1 extends a implements k1 {
    public j1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
    }

    @Override // f.b.a.c.e.c.a
    public final boolean l(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.s1((Status) z0.a(parcel, Status.CREATOR), (e) z0.a(parcel, e.CREATOR), ((o) this).a);
        return true;
    }
}
