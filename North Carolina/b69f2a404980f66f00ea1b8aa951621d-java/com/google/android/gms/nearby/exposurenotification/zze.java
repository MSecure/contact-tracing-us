package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zze implements Parcelable.Creator<ExposureInformation> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ExposureInformation createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        long j = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j = i.j.S0(parcel, readInt);
                    break;
                case 2:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 3:
                    i2 = i.j.R0(parcel, readInt);
                    break;
                case 4:
                    i3 = i.j.R0(parcel, readInt);
                    break;
                case 5:
                    i4 = i.j.R0(parcel, readInt);
                    break;
                case 6:
                    iArr = i.j.J(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new ExposureInformation(j, i, i2, i3, i4, iArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExposureInformation[] newArray(int i) {
        return new ExposureInformation[i];
    }
}
