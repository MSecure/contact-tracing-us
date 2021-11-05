package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.e.c.y9;

public final class zza implements Parcelable.Creator<Message> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Message createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        byte[] bArr = null;
        String str = null;
        String str2 = null;
        y9[] y9VarArr = null;
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                bArr = i.j.F(parcel, readInt);
            } else if (i2 == 2) {
                str2 = i.j.Q(parcel, readInt);
            } else if (i2 == 3) {
                str = i.j.Q(parcel, readInt);
            } else if (i2 == 4) {
                y9VarArr = (y9[]) i.j.R(parcel, readInt, y9.CREATOR);
            } else if (i2 == 5) {
                j = i.j.S0(parcel, readInt);
            } else if (i2 != 1000) {
                i.j.g1(parcel, readInt);
            } else {
                i = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new Message(i, bArr, str, str2, y9VarArr, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Message[] newArray(int i) {
        return new Message[i];
    }
}
