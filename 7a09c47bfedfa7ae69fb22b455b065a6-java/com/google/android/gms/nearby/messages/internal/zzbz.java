package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.messages.Strategy;

public final class zzbz implements Parcelable.Creator<zzca> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzca createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
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
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = t.t2(parcel, readInt);
                    break;
                case 2:
                    zzag = (zzag) t.a0(parcel, readInt, zzag.CREATOR);
                    break;
                case 3:
                    strategy = (Strategy) t.a0(parcel, readInt, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder = t.s2(parcel, readInt);
                    break;
                case 5:
                    str = t.b0(parcel, readInt);
                    break;
                case 6:
                    str2 = t.b0(parcel, readInt);
                    break;
                case 7:
                    z = t.q2(parcel, readInt);
                    break;
                case 8:
                    iBinder2 = t.s2(parcel, readInt);
                    break;
                case 9:
                    z2 = t.q2(parcel, readInt);
                    break;
                case 10:
                    clientAppContext = (ClientAppContext) t.a0(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                case 11:
                    i2 = t.t2(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new zzca(i, zzag, strategy, iBinder, str, str2, z, iBinder2, z2, clientAppContext, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzca[] newArray(int i) {
        return new zzca[i];
    }
}
