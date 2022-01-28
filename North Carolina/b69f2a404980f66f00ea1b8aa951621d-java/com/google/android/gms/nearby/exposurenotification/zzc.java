package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import java.util.ArrayList;

public final class zzc implements Parcelable.Creator<DiagnosisKeysDataMapping> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DiagnosisKeysDataMapping createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        ArrayList<Integer> arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                arrayList = i.j.K(parcel, readInt);
            } else if (i3 == 2) {
                i = i.j.R0(parcel, readInt);
            } else if (i3 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                i2 = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new DiagnosisKeysDataMapping(arrayList, i, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DiagnosisKeysDataMapping[] newArray(int i) {
        return new DiagnosisKeysDataMapping[i];
    }
}
