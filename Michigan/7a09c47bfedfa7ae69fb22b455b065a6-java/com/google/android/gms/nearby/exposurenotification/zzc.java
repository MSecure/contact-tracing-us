package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import java.util.ArrayList;

public final class zzc implements Parcelable.Creator<DiagnosisKeysDataMapping> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DiagnosisKeysDataMapping createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        ArrayList<Integer> arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                arrayList = t.X(parcel, readInt);
            } else if (i3 == 2) {
                i = t.t2(parcel, readInt);
            } else if (i3 != 3) {
                t.O2(parcel, readInt);
            } else {
                i2 = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new DiagnosisKeysDataMapping(arrayList, i, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DiagnosisKeysDataMapping[] newArray(int i) {
        return new DiagnosisKeysDataMapping[i];
    }
}
