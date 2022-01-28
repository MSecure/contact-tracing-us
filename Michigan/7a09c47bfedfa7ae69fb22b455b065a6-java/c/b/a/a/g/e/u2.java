package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.List;

public final class u2 extends a0 implements s2 {
    public u2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
    }

    @Override // c.b.a.a.g.e.s2
    public final void a(Status status, List<TemporaryExposureKey> list) {
        Parcel a_ = a_();
        s1.b(a_, status);
        a_.writeTypedList(list);
        zzc(1, a_);
    }
}
