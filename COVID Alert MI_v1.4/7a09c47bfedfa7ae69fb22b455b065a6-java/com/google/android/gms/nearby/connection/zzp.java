package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzp implements Parcelable.Creator<Strategy> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Strategy createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 3) {
                i = t.t2(parcel, readInt);
            } else if (i3 != 4) {
                t.O2(parcel, readInt);
            } else {
                i2 = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new Strategy(i, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
