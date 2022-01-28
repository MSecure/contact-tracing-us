package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.messages.Strategy;

public final class zzbz implements Parcelable.Creator<zzca> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzca createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        zzag zzag = null;
        Strategy strategy = null;
        IBinder iBinder = null;
        String str = null;
        String str2 = null;
        IBinder iBinder2 = null;
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
                    strategy = (Strategy) i.j.O(parcel, readInt, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder = i.j.Q0(parcel, readInt);
                    break;
                case 5:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 6:
                    str2 = i.j.Q(parcel, readInt);
                    break;
                case 7:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 8:
                    iBinder2 = i.j.Q0(parcel, readInt);
                    break;
                case 9:
                    z2 = i.j.N0(parcel, readInt);
                    break;
                case 10:
                    clientAppContext = (ClientAppContext) i.j.O(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                case 11:
                    i2 = i.j.R0(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new zzca(i, zzag, strategy, iBinder, str, str2, z, iBinder2, z2, clientAppContext, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzca[] newArray(int i) {
        return new zzca[i];
    }
}
