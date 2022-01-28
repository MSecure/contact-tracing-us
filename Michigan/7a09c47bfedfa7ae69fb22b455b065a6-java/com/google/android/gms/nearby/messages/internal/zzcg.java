package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzcg implements Parcelable.Creator<zzch> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzch createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        String str = null;
        String str2 = null;
        ClientAppContext clientAppContext = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = t.t2(parcel, readInt);
                    break;
                case 2:
                    iBinder = t.s2(parcel, readInt);
                    break;
                case 3:
                    iBinder2 = t.s2(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) t.a0(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    i2 = t.t2(parcel, readInt);
                    break;
                case 6:
                    str = t.b0(parcel, readInt);
                    break;
                case 7:
                    str2 = t.b0(parcel, readInt);
                    break;
                case 8:
                    z = t.q2(parcel, readInt);
                    break;
                case 9:
                    clientAppContext = (ClientAppContext) t.a0(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new zzch(i, iBinder, iBinder2, pendingIntent, i2, str, str2, z, clientAppContext);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzch[] newArray(int i) {
        return new zzch[i];
    }
}
