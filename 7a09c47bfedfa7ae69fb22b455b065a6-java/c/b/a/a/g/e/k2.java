package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public final class k2 extends a0 implements i2 {
    public k2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
    }

    @Override // c.b.a.a.g.e.i2
    public final void q(Status status, long j) {
        Parcel a_ = a_();
        s1.b(a_, status);
        a_.writeLong(j);
        zzc(1, a_);
    }
}
