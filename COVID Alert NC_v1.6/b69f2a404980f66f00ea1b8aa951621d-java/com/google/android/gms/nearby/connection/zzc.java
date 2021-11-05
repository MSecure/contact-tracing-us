package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzc implements Parcelable.Creator<AppIdentifier> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final AppIdentifier createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                i.j.g1(parcel, readInt);
            } else {
                str = i.j.Q(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new AppIdentifier(str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppIdentifier[] newArray(int i) {
        return new AppIdentifier[i];
    }
}
