package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import java.util.List;

public final class e2 extends a0 implements c2 {
    public e2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
    }

    @Override // c.b.a.a.e.c.c2
    public final void a(Status status, List<ExposureWindow> list) {
        Parcel a_ = a_();
        s1.b(a_, status);
        a_.writeTypedList(list);
        zzc(1, a_);
    }
}
