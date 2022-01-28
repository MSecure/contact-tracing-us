package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzad implements Parcelable.Creator<zzae> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzae createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = i.j.Q(parcel, readInt);
            } else if (i2 == 2) {
                str2 = i.j.Q(parcel, readInt);
            } else if (i2 != 1000) {
                i.j.g1(parcel, readInt);
            } else {
                i = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new zzae(i, str, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzae[] newArray(int i) {
        return new zzae[i];
    }
}
