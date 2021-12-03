package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;

public final class i2 implements Parcelable.Creator<h2> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final h2 createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        IBinder iBinder = null;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = null;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.h.Y0(parcel, readInt);
            } else if (i2 != 2) {
                m.h.q1(parcel, readInt);
            } else {
                diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) m.h.J(parcel, readInt, DiagnosisKeysDataMapping.CREATOR);
            }
        }
        m.h.T(parcel, B1);
        return new h2(iBinder, diagnosisKeysDataMapping);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ h2[] newArray(int i2) {
        return new h2[i2];
    }
}
