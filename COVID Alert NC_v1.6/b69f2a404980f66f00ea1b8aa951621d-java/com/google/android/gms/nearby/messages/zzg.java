package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzg implements Parcelable.Creator<Strategy> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Strategy createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i8 = 65535 & readInt;
            if (i8 != 1000) {
                switch (i8) {
                    case 1:
                        i2 = i.j.R0(parcel, readInt);
                        continue;
                    case 2:
                        i3 = i.j.R0(parcel, readInt);
                        continue;
                    case 3:
                        i4 = i.j.R0(parcel, readInt);
                        continue;
                    case 4:
                        z = i.j.N0(parcel, readInt);
                        continue;
                    case 5:
                        i5 = i.j.R0(parcel, readInt);
                        continue;
                    case 6:
                        i6 = i.j.R0(parcel, readInt);
                        continue;
                    case 7:
                        i7 = i.j.R0(parcel, readInt);
                        continue;
                    default:
                        i.j.g1(parcel, readInt);
                        continue;
                }
            } else {
                i = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new Strategy(i, i2, i3, i4, z, i5, i6, i7);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
