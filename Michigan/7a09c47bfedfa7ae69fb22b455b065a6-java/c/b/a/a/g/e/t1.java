package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

public final class t1 extends a0 implements q1 {
    public t1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
    }

    @Override // c.b.a.a.g.e.q1
    public final void d(Status status, DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        Parcel a_ = a_();
        s1.b(a_, status);
        s1.b(a_, diagnosisKeysDataMapping);
        zzc(1, a_);
    }
}
