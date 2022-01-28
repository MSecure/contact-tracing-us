package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzd implements Parcelable.Creator<ExposureConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ExposureConfiguration createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
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
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 2:
                    iArr = i.j.J(parcel, readInt);
                    break;
                case 3:
                    i2 = i.j.R0(parcel, readInt);
                    break;
                case 4:
                    iArr2 = i.j.J(parcel, readInt);
                    break;
                case 5:
                    i3 = i.j.R0(parcel, readInt);
                    break;
                case 6:
                    iArr3 = i.j.J(parcel, readInt);
                    break;
                case 7:
                    i4 = i.j.R0(parcel, readInt);
                    break;
                case 8:
                    iArr4 = i.j.J(parcel, readInt);
                    break;
                case 9:
                    i5 = i.j.R0(parcel, readInt);
                    break;
                case 10:
                    iArr5 = i.j.J(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new ExposureConfiguration(i, iArr, i2, iArr2, i3, iArr3, i4, iArr4, i5, iArr5);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExposureConfiguration[] newArray(int i) {
        return new ExposureConfiguration[i];
    }
}
