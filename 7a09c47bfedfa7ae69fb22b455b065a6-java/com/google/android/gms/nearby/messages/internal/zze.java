package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zze implements Parcelable.Creator<ClientAppContext> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ClientAppContext createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = t.t2(parcel, readInt);
                    break;
                case 2:
                    str = t.b0(parcel, readInt);
                    break;
                case 3:
                    str2 = t.b0(parcel, readInt);
                    break;
                case 4:
                    z = t.q2(parcel, readInt);
                    break;
                case 5:
                    i2 = t.t2(parcel, readInt);
                    break;
                case 6:
                    str3 = t.b0(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new ClientAppContext(i, str, str2, z, i2, str3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ClientAppContext[] newArray(int i) {
        return new ClientAppContext[i];
    }
}
