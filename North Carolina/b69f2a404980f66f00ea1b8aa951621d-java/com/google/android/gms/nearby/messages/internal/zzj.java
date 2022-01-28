package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzj implements Parcelable.Creator<zzk> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzk createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        ClientAppContext clientAppContext = null;
        int i2 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i3 == 2) {
                clientAppContext = (ClientAppContext) i.j.O(parcel, readInt, ClientAppContext.CREATOR);
            } else if (i3 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                i2 = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new zzk(i, clientAppContext, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i) {
        return new zzk[i];
    }
}
