package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zze implements Parcelable.Creator<ClientAppContext> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ClientAppContext createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 2:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 3:
                    str2 = i.j.Q(parcel, readInt);
                    break;
                case 4:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 5:
                    i2 = i.j.R0(parcel, readInt);
                    break;
                case 6:
                    str3 = i.j.Q(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new ClientAppContext(i, str, str2, z, i2, str3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ClientAppContext[] newArray(int i) {
        return new ClientAppContext[i];
    }
}
