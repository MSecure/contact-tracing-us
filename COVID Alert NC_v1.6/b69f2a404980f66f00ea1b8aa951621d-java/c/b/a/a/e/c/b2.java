package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;

public final class b2 extends a0 implements z1 {
    public b2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
    }

    @Override // c.b.a.a.e.c.z1
    public final void U(Status status, ExposureSummary exposureSummary) {
        Parcel a_ = a_();
        s1.b(a_, status);
        s1.b(a_, exposureSummary);
        zzc(1, a_);
    }
}
