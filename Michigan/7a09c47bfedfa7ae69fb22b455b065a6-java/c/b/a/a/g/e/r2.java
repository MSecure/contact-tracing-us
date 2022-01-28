package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.PackageConfiguration;

public final class r2 extends a0 implements p2 {
    public r2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
    }

    @Override // c.b.a.a.g.e.p2
    public final void r(Status status, PackageConfiguration packageConfiguration) {
        Parcel a_ = a_();
        s1.b(a_, status);
        s1.b(a_, packageConfiguration);
        zzc(1, a_);
    }
}
