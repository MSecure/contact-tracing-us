package com.google.android.gms.nearby.exposurenotification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzm implements Parcelable.Creator<PackageConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final PackageConfiguration createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                t.O2(parcel, readInt);
            } else {
                bundle = t.Q(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new PackageConfiguration(bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PackageConfiguration[] newArray(int i) {
        return new PackageConfiguration[i];
    }
}
