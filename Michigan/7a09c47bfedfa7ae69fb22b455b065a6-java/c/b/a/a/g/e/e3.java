package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

public final class e3 implements Parcelable.Creator<d3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d3 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = t.s2(parcel, readInt);
            } else if (i != 2) {
                t.O2(parcel, readInt);
            } else {
                diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) t.a0(parcel, readInt, DiagnosisKeysDataMapping.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new d3(iBinder, diagnosisKeysDataMapping);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d3[] newArray(int i) {
        return new d3[i];
    }
}
