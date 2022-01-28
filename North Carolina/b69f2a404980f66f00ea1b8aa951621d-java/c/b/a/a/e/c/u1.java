package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import java.util.List;

public final class u1 extends a0 implements r1 {
    public u1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationListCallback");
    }

    @Override // c.b.a.a.e.c.r1
    public final void a(Status status, List<ExposureInformation> list) {
        Parcel a_ = a_();
        s1.b(a_, status);
        a_.writeTypedList(list);
        zzc(1, a_);
    }
}
