package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.f.b.f;

public abstract class o1 extends w implements p1 {
    public o1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
    }

    @Override // f.b.a.c.e.c.w
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.e.K1((Status) j0.a(parcel, Status.CREATOR), (f) j0.a(parcel, f.CREATOR), ((n) this).a);
        return true;
    }
}
