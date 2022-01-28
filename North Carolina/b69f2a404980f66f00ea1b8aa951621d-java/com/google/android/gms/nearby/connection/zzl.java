package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.b.k.i;

public final class zzl implements Parcelable.Creator<DiscoveryOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DiscoveryOptions createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        Strategy strategy = null;
        ParcelUuid parcelUuid = null;
        byte[] bArr = null;
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        int i = 0;
        int i2 = 0;
        long j = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    strategy = (Strategy) i.j.O(parcel, readInt, Strategy.CREATOR);
                    break;
                case 2:
                    z6 = i.j.N0(parcel, readInt);
                    break;
                case 3:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 4:
                    z2 = i.j.N0(parcel, readInt);
                    break;
                case 5:
                    z7 = i.j.N0(parcel, readInt);
                    break;
                case 6:
                    parcelUuid = (ParcelUuid) i.j.O(parcel, readInt, ParcelUuid.CREATOR);
                    break;
                case 7:
                default:
                    i.j.g1(parcel, readInt);
                    break;
                case 8:
                    z3 = i.j.N0(parcel, readInt);
                    break;
                case 9:
                    z4 = i.j.N0(parcel, readInt);
                    break;
                case 10:
                    z5 = i.j.N0(parcel, readInt);
                    break;
                case 11:
                    z8 = i.j.N0(parcel, readInt);
                    break;
                case 12:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 13:
                    i2 = i.j.R0(parcel, readInt);
                    break;
                case 14:
                    bArr = i.j.F(parcel, readInt);
                    break;
                case 15:
                    j = i.j.S0(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new DiscoveryOptions(strategy, z6, z, z2, z7, parcelUuid, z3, z4, z5, z8, i, i2, bArr, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DiscoveryOptions[] newArray(int i) {
        return new DiscoveryOptions[i];
    }
}
