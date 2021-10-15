package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import java.util.ArrayList;

public final class zze implements Parcelable.Creator<AppMetadata> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final AppMetadata createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                t.O2(parcel, readInt);
            } else {
                arrayList = t.e0(parcel, readInt, AppIdentifier.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new AppMetadata(arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppMetadata[] newArray(int i) {
        return new AppMetadata[i];
    }
}
