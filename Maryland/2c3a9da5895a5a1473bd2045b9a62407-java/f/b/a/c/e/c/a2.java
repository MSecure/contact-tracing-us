package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;

public final class a2 implements Parcelable.Creator<z1> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final z1 createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        IBinder iBinder = null;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = null;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.h.S0(parcel, readInt);
            } else if (i2 != 2) {
                m.h.k1(parcel, readInt);
            } else {
                diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) m.h.I(parcel, readInt, DiagnosisKeysDataMapping.CREATOR);
            }
        }
        m.h.T(parcel, v1);
        return new z1(iBinder, diagnosisKeysDataMapping);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ z1[] newArray(int i2) {
        return new z1[i2];
    }
}
