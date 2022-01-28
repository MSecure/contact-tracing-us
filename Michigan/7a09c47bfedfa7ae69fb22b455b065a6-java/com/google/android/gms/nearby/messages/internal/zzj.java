package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzj implements Parcelable.Creator<zzk> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzk createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        ClientAppContext clientAppContext = null;
        int i2 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i3 == 2) {
                clientAppContext = (ClientAppContext) t.a0(parcel, readInt, ClientAppContext.CREATOR);
            } else if (i3 != 3) {
                t.O2(parcel, readInt);
            } else {
                i2 = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new zzk(i, clientAppContext, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i) {
        return new zzk[i];
    }
}
