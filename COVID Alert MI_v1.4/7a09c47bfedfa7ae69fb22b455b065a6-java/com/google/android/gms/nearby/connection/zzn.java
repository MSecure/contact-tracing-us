package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzn implements Parcelable.Creator<PayloadTransferUpdate> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final PayloadTransferUpdate createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                j = t.u2(parcel, readInt);
            } else if (i2 == 2) {
                i = t.t2(parcel, readInt);
            } else if (i2 == 3) {
                j2 = t.u2(parcel, readInt);
            } else if (i2 != 4) {
                t.O2(parcel, readInt);
            } else {
                j3 = t.u2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new PayloadTransferUpdate(j, i, j2, j3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PayloadTransferUpdate[] newArray(int i) {
        return new PayloadTransferUpdate[i];
    }
}
