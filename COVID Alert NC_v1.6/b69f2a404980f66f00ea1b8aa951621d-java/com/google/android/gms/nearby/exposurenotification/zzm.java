package com.google.android.gms.nearby.exposurenotification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzm implements Parcelable.Creator<PackageConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final PackageConfiguration createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                i.j.g1(parcel, readInt);
            } else {
                bundle = i.j.E(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new PackageConfiguration(bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PackageConfiguration[] newArray(int i) {
        return new PackageConfiguration[i];
    }
}
