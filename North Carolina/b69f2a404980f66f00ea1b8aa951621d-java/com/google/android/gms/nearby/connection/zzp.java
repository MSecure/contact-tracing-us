package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzp implements Parcelable.Creator<Strategy> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Strategy createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 3) {
                i = i.j.R0(parcel, readInt);
            } else if (i3 != 4) {
                i.j.g1(parcel, readInt);
            } else {
                i2 = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new Strategy(i, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
