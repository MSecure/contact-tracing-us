package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.b.k.i;

public final class zzb implements Parcelable.Creator<AdvertisingOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final AdvertisingOptions createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        Strategy strategy = null;
        byte[] bArr = null;
        ParcelUuid parcelUuid = null;
        byte[] bArr2 = null;
        zzq[] zzqArr = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i = 0;
        int i2 = 0;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = true;
        long j = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    strategy = (Strategy) i.j.O(parcel, readInt, Strategy.CREATOR);
                    break;
                case 2:
                    z5 = i.j.N0(parcel, readInt);
                    break;
                case 3:
                    z6 = i.j.N0(parcel, readInt);
                    break;
                case 4:
                    z7 = i.j.N0(parcel, readInt);
                    break;
                case 5:
                    z8 = i.j.N0(parcel, readInt);
                    break;
                case 6:
                    bArr = i.j.F(parcel, readInt);
                    break;
                case 7:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 8:
                    parcelUuid = (ParcelUuid) i.j.O(parcel, readInt, ParcelUuid.CREATOR);
                    break;
                case 9:
                    z9 = i.j.N0(parcel, readInt);
                    break;
                case 10:
                    z10 = i.j.N0(parcel, readInt);
                    break;
                case 11:
                    z11 = i.j.N0(parcel, readInt);
                    break;
                case 12:
                    z2 = i.j.N0(parcel, readInt);
                    break;
                case 13:
                    z3 = i.j.N0(parcel, readInt);
                    break;
                case 14:
                    z4 = i.j.N0(parcel, readInt);
                    break;
                case 15:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 16:
                    i2 = i.j.R0(parcel, readInt);
                    break;
                case 17:
                    bArr2 = i.j.F(parcel, readInt);
                    break;
                case 18:
                    j = i.j.S0(parcel, readInt);
                    break;
                case 19:
                    zzqArr = (zzq[]) i.j.R(parcel, readInt, zzq.CREATOR);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new AdvertisingOptions(strategy, z5, z6, z7, z8, bArr, z, parcelUuid, z9, z10, z11, z2, z3, z4, i, i2, bArr2, j, zzqArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdvertisingOptions[] newArray(int i) {
        return new AdvertisingOptions[i];
    }
}
