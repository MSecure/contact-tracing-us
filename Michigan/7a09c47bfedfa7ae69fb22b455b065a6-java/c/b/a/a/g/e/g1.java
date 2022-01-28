package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public final class g1 extends a0 implements e1 {
    public g1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
    }

    @Override // c.b.a.a.g.e.e1
    public final void F(Status status, boolean z) {
        Parcel a_ = a_();
        s1.b(a_, status);
        a_.writeInt(z ? 1 : 0);
        zzc(1, a_);
    }
}
