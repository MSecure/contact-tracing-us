package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzh implements Parcelable.Creator<zzi> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzi createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        ClientAppContext clientAppContext = null;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i2 == 2) {
                iBinder = t.s2(parcel, readInt);
            } else if (i2 == 3) {
                str = t.b0(parcel, readInt);
            } else if (i2 != 4) {
                t.O2(parcel, readInt);
            } else {
                clientAppContext = (ClientAppContext) t.a0(parcel, readInt, ClientAppContext.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new zzi(i, iBinder, str, clientAppContext);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }
}
