package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzd implements Parcelable.Creator<ExposureConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ExposureConfiguration createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int[] iArr = null;
        int[] iArr2 = null;
        int[] iArr3 = null;
        int[] iArr4 = null;
        int[] iArr5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = t.t2(parcel, readInt);
                    break;
                case 2:
                    iArr = t.W(parcel, readInt);
                    break;
                case 3:
                    i2 = t.t2(parcel, readInt);
                    break;
                case 4:
                    iArr2 = t.W(parcel, readInt);
                    break;
                case 5:
                    i3 = t.t2(parcel, readInt);
                    break;
                case 6:
                    iArr3 = t.W(parcel, readInt);
                    break;
                case 7:
                    i4 = t.t2(parcel, readInt);
                    break;
                case 8:
                    iArr4 = t.W(parcel, readInt);
                    break;
                case 9:
                    i5 = t.t2(parcel, readInt);
                    break;
                case 10:
                    iArr5 = t.W(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new ExposureConfiguration(i, iArr, i2, iArr2, i3, iArr3, i4, iArr4, i5, iArr5);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExposureConfiguration[] newArray(int i) {
        return new ExposureConfiguration[i];
    }
}
