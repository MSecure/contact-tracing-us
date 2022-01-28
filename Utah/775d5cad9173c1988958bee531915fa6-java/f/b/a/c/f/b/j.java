package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import java.util.ArrayList;

public final class j implements Parcelable.Creator<DiagnosisKeysDataMapping> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DiagnosisKeysDataMapping createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        int i2 = 0;
        ArrayList<Integer> arrayList = null;
        int i3 = 0;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                arrayList = m.e.I(parcel, readInt);
            } else if (i4 == 2) {
                i2 = m.e.l1(parcel, readInt);
            } else if (i4 != 3) {
                m.e.C1(parcel, readInt);
            } else {
                i3 = m.e.l1(parcel, readInt);
            }
        }
        m.e.V(parcel, O1);
        return new DiagnosisKeysDataMapping(arrayList, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DiagnosisKeysDataMapping[] newArray(int i2) {
        return new DiagnosisKeysDataMapping[i2];
    }
}
