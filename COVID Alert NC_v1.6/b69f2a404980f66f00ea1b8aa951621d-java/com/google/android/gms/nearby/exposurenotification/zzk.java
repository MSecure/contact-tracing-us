package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzk implements Parcelable.Creator<ExposureSummary> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ExposureSummary createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i5 == 2) {
                i2 = i.j.R0(parcel, readInt);
            } else if (i5 == 3) {
                i3 = i.j.R0(parcel, readInt);
            } else if (i5 == 4) {
                iArr = i.j.J(parcel, readInt);
            } else if (i5 != 5) {
                i.j.g1(parcel, readInt);
            } else {
                i4 = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new ExposureSummary(i, i2, i3, iArr, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExposureSummary[] newArray(int i) {
        return new ExposureSummary[i];
    }
}
