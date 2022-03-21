package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;

public final class z1 implements Parcelable.Creator<y1> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final y1 createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        IBinder iBinder = null;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = null;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.h.R0(parcel, readInt);
            } else if (i2 != 2) {
                m.h.j1(parcel, readInt);
            } else {
                diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) m.h.I(parcel, readInt, DiagnosisKeysDataMapping.CREATOR);
            }
        }
        m.h.T(parcel, u1);
        return new y1(iBinder, diagnosisKeysDataMapping);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ y1[] newArray(int i2) {
        return new y1[i2];
    }
}
