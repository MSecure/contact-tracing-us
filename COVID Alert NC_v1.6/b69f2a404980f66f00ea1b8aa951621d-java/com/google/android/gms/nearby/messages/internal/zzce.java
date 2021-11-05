package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzce implements Parcelable.Creator<zzcf> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzcf createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        boolean z = false;
        zzag zzag = null;
        IBinder iBinder = null;
        String str = null;
        String str2 = null;
        ClientAppContext clientAppContext = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 2:
                    zzag = (zzag) i.j.O(parcel, readInt, zzag.CREATOR);
                    break;
                case 3:
                    iBinder = i.j.Q0(parcel, readInt);
                    break;
                case 4:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 5:
                    str2 = i.j.Q(parcel, readInt);
                    break;
                case 6:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 7:
                    clientAppContext = (ClientAppContext) i.j.O(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new zzcf(i, zzag, iBinder, str, str2, z, clientAppContext);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcf[] newArray(int i) {
        return new zzcf[i];
    }
}
