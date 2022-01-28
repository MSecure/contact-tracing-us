package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzcb implements Parcelable.Creator<zzcc> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzcc createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        boolean z = false;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        ClientAppContext clientAppContext = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 2:
                    iBinder = i.j.Q0(parcel, readInt);
                    break;
                case 3:
                    iBinder2 = i.j.Q0(parcel, readInt);
                    break;
                case 4:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 5:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 6:
                    clientAppContext = (ClientAppContext) i.j.O(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new zzcc(i, iBinder, iBinder2, z, str, clientAppContext);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcc[] newArray(int i) {
        return new zzcc[i];
    }
}
