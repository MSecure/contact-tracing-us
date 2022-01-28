package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzo implements Parcelable.Creator<TemporaryExposureKey> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final TemporaryExposureKey createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    bArr = t.R(parcel, readInt);
                    break;
                case 2:
                    i = t.t2(parcel, readInt);
                    break;
                case 3:
                    i2 = t.t2(parcel, readInt);
                    break;
                case 4:
                    i3 = t.t2(parcel, readInt);
                    break;
                case 5:
                    i4 = t.t2(parcel, readInt);
                    break;
                case 6:
                    i5 = t.t2(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new TemporaryExposureKey(bArr, i, i2, i3, i4, i5);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TemporaryExposureKey[] newArray(int i) {
        return new TemporaryExposureKey[i];
    }
}
