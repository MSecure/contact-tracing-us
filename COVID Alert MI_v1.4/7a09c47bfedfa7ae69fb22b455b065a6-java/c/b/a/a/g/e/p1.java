package c.b.a.a.g.e;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

public abstract class p1 extends a implements q1 {
    public p1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        d((Status) s1.a(parcel, Status.CREATOR), (DiagnosisKeysDataMapping) s1.a(parcel, DiagnosisKeysDataMapping.CREATOR));
        return true;
    }
}
