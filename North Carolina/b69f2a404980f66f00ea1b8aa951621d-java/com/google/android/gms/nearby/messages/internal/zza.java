package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zza implements Parcelable.Creator<zzb> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzb createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i4 == 2) {
                i2 = i.j.R0(parcel, readInt);
            } else if (i4 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                i3 = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new zzb(i, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb[] newArray(int i) {
        return new zzb[i];
    }
}
