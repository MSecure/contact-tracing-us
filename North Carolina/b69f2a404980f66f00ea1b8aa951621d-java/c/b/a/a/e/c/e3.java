package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

public final class e3 implements Parcelable.Creator<d3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d3 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = i.j.Q0(parcel, readInt);
            } else if (i != 2) {
                i.j.g1(parcel, readInt);
            } else {
                diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) i.j.O(parcel, readInt, DiagnosisKeysDataMapping.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new d3(iBinder, diagnosisKeysDataMapping);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d3[] newArray(int i) {
        return new d3[i];
    }
}
