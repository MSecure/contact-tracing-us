package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
/* loaded from: classes.dex */
public abstract class d1 extends w implements e1 {
    public d1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
    }

    @Override // f.b.a.c.e.c.w
    public final boolean p(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.e.S1((Status) j0.a(parcel, Status.CREATOR), (DiagnosisKeysDataMapping) j0.a(parcel, DiagnosisKeysDataMapping.CREATOR), ((l) this).a);
        return true;
    }
}
