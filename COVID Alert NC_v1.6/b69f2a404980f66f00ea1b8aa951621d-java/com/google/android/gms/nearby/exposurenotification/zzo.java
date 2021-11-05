package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzo implements Parcelable.Creator<TemporaryExposureKey> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final TemporaryExposureKey createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    bArr = i.j.F(parcel, readInt);
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
                    i5 = i.j.R0(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new TemporaryExposureKey(bArr, i, i2, i3, i4, i5);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TemporaryExposureKey[] newArray(int i) {
        return new TemporaryExposureKey[i];
    }
}
