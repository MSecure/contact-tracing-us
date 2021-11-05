package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zze implements Parcelable.Creator<ExposureInformation> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ExposureInformation createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        long j = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j = t.u2(parcel, readInt);
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
                    iArr = t.W(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new ExposureInformation(j, i, i2, i3, i4, iArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExposureInformation[] newArray(int i) {
        return new ExposureInformation[i];
    }
}
