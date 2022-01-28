package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzg implements Parcelable.Creator<zzd> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzd createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        double d2 = 0.0d;
        int i2 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i3 == 2) {
                i2 = i.j.R0(parcel, readInt);
            } else if (i3 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                d2 = i.j.P0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new zzd(i, i2, d2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd[] newArray(int i) {
        return new zzd[i];
    }
}
