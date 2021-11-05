package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import java.util.ArrayList;

public final class zze implements Parcelable.Creator<AppMetadata> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final AppMetadata createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                i.j.g1(parcel, readInt);
            } else {
                arrayList = i.j.S(parcel, readInt, AppIdentifier.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new AppMetadata(arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppMetadata[] newArray(int i) {
        return new AppMetadata[i];
    }
}
