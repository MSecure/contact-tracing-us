package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public final class j2 extends a0 implements h2 {
    public j2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IIntCallback");
    }

    @Override // c.b.a.a.g.e.h2
    public final void p(Status status, int i) {
        Parcel a_ = a_();
        s1.b(a_, status);
        a_.writeInt(i);
        zzc(1, a_);
    }
}
