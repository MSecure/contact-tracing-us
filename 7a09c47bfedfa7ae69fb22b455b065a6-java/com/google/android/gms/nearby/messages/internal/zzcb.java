package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzcb implements Parcelable.Creator<zzcc> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzcc createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        boolean z = false;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
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
                    z = t.q2(parcel, readInt);
                    break;
                case 5:
                    str = t.b0(parcel, readInt);
                    break;
                case 6:
                    clientAppContext = (ClientAppContext) t.a0(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new zzcc(i, iBinder, iBinder2, z, str, clientAppContext);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcc[] newArray(int i) {
        return new zzcc[i];
    }
}
