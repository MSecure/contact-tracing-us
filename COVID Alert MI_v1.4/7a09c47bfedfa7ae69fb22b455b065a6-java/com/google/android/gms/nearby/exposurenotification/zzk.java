package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzk implements Parcelable.Creator<ExposureSummary> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ExposureSummary createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i5 == 2) {
                i2 = t.t2(parcel, readInt);
            } else if (i5 == 3) {
                i3 = t.t2(parcel, readInt);
            } else if (i5 == 4) {
                iArr = t.W(parcel, readInt);
            } else if (i5 != 5) {
                t.O2(parcel, readInt);
            } else {
                i4 = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new ExposureSummary(i, i2, i3, iArr, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExposureSummary[] newArray(int i) {
        return new ExposureSummary[i];
    }
}
