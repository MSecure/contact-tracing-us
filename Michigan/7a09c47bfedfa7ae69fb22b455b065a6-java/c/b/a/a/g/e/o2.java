package c.b.a.a.g.e;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.PackageConfiguration;

public abstract class o2 extends a implements p2 {
    public o2() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        r((Status) s1.a(parcel, Status.CREATOR), (PackageConfiguration) s1.a(parcel, PackageConfiguration.CREATOR));
        return true;
    }
}
