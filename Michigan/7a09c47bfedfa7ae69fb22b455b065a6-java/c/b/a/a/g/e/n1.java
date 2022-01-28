package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import java.util.List;

public final class n1 extends a0 implements l1 {
    public n1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
    }

    @Override // c.b.a.a.g.e.l1
    public final void a(Status status, List<DailySummary> list) {
        Parcel a_ = a_();
        s1.b(a_, status);
        a_.writeList(list);
        zzc(1, a_);
    }
}
