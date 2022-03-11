package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;

public abstract class b1 extends u implements c1 {
    public b1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
    }

    @Override // f.b.a.c.e.c.u
    public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.s1((Status) i0.a(parcel, Status.CREATOR), (DiagnosisKeysDataMapping) i0.a(parcel, DiagnosisKeysDataMapping.CREATOR), ((j) this).a);
        return true;
    }
}
