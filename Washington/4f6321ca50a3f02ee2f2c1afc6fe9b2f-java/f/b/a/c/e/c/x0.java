package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;

public abstract class x0 extends a implements y0 {
    public x0() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
    }

    @Override // f.b.a.c.e.c.a
    public final boolean l(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.h.s1((Status) z0.a(parcel, Status.CREATOR), (DiagnosisKeysDataMapping) z0.a(parcel, DiagnosisKeysDataMapping.CREATOR), ((m) this).a);
        return true;
    }
}
