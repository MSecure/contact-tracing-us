package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzn implements Parcelable.Creator<PayloadTransferUpdate> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final PayloadTransferUpdate createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                j = i.j.S0(parcel, readInt);
            } else if (i2 == 2) {
                i = i.j.R0(parcel, readInt);
            } else if (i2 == 3) {
                j2 = i.j.S0(parcel, readInt);
            } else if (i2 != 4) {
                i.j.g1(parcel, readInt);
            } else {
                j3 = i.j.S0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new PayloadTransferUpdate(j, i, j2, j3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PayloadTransferUpdate[] newArray(int i) {
        return new PayloadTransferUpdate[i];
    }
}
