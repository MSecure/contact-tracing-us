package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.g.e.y9;

public final class zza implements Parcelable.Creator<Message> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Message createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        byte[] bArr = null;
        String str = null;
        String str2 = null;
        y9[] y9VarArr = null;
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                bArr = t.R(parcel, readInt);
            } else if (i2 == 2) {
                str2 = t.b0(parcel, readInt);
            } else if (i2 == 3) {
                str = t.b0(parcel, readInt);
            } else if (i2 == 4) {
                y9VarArr = (y9[]) t.d0(parcel, readInt, y9.CREATOR);
            } else if (i2 == 5) {
                j = t.u2(parcel, readInt);
            } else if (i2 != 1000) {
                t.O2(parcel, readInt);
            } else {
                i = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new Message(i, bArr, str, str2, y9VarArr, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Message[] newArray(int i) {
        return new Message[i];
    }
}
