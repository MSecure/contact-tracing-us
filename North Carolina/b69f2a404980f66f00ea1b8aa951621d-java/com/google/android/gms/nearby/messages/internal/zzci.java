package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.e.c.y9;
import com.google.android.gms.nearby.messages.Message;

public final class zzci implements Parcelable.Creator<Update> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Update createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        Message message = null;
        zzd zzd = null;
        zzb zzb = null;
        y9 y9Var = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 2:
                    i2 = i.j.R0(parcel, readInt);
                    break;
                case 3:
                    message = (Message) i.j.O(parcel, readInt, Message.CREATOR);
                    break;
                case 4:
                    zzd = (zzd) i.j.O(parcel, readInt, zzd.CREATOR);
                    break;
                case 5:
                    zzb = (zzb) i.j.O(parcel, readInt, zzb.CREATOR);
                    break;
                case 6:
                    y9Var = (y9) i.j.O(parcel, readInt, y9.CREATOR);
                    break;
                case 7:
                    bArr = i.j.F(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new Update(i, i2, message, zzd, zzb, y9Var, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Update[] newArray(int i) {
        return new Update[i];
    }
}
