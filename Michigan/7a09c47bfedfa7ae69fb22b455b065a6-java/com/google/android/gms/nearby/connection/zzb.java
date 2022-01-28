package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.x.t;

public final class zzb implements Parcelable.Creator<AdvertisingOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final AdvertisingOptions createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
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
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    strategy = (Strategy) t.a0(parcel, readInt, Strategy.CREATOR);
                    break;
                case 2:
                    z5 = t.q2(parcel, readInt);
                    break;
                case 3:
                    z6 = t.q2(parcel, readInt);
                    break;
                case 4:
                    z7 = t.q2(parcel, readInt);
                    break;
                case 5:
                    z8 = t.q2(parcel, readInt);
                    break;
                case 6:
                    bArr = t.R(parcel, readInt);
                    break;
                case 7:
                    z = t.q2(parcel, readInt);
                    break;
                case 8:
                    parcelUuid = (ParcelUuid) t.a0(parcel, readInt, ParcelUuid.CREATOR);
                    break;
                case 9:
                    z9 = t.q2(parcel, readInt);
                    break;
                case 10:
                    z10 = t.q2(parcel, readInt);
                    break;
                case 11:
                    z11 = t.q2(parcel, readInt);
                    break;
                case 12:
                    z2 = t.q2(parcel, readInt);
                    break;
                case 13:
                    z3 = t.q2(parcel, readInt);
                    break;
                case 14:
                    z4 = t.q2(parcel, readInt);
                    break;
                case 15:
                    i = t.t2(parcel, readInt);
                    break;
                case 16:
                    i2 = t.t2(parcel, readInt);
                    break;
                case 17:
                    bArr2 = t.R(parcel, readInt);
                    break;
                case 18:
                    j = t.u2(parcel, readInt);
                    break;
                case 19:
                    zzqArr = (zzq[]) t.d0(parcel, readInt, zzq.CREATOR);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new AdvertisingOptions(strategy, z5, z6, z7, z8, bArr, z, parcelUuid, z9, z10, z11, z2, z3, z4, i, i2, bArr2, j, zzqArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdvertisingOptions[] newArray(int i) {
        return new AdvertisingOptions[i];
    }
}
