package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzh implements Parcelable.Creator<zzi> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzi createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        ClientAppContext clientAppContext = null;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i2 == 2) {
                iBinder = i.j.Q0(parcel, readInt);
            } else if (i2 == 3) {
                str = i.j.Q(parcel, readInt);
            } else if (i2 != 4) {
                i.j.g1(parcel, readInt);
            } else {
                clientAppContext = (ClientAppContext) i.j.O(parcel, readInt, ClientAppContext.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new zzi(i, iBinder, str, clientAppContext);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }
}
