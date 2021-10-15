package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.g.e.y9;
import com.google.android.gms.nearby.messages.Message;

public final class zzci implements Parcelable.Creator<Update> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Update createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        Message message = null;
        zzd zzd = null;
        zzb zzb = null;
        y9 y9Var = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = t.t2(parcel, readInt);
                    break;
                case 2:
                    i2 = t.t2(parcel, readInt);
                    break;
                case 3:
                    message = (Message) t.a0(parcel, readInt, Message.CREATOR);
                    break;
                case 4:
                    zzd = (zzd) t.a0(parcel, readInt, zzd.CREATOR);
                    break;
                case 5:
                    zzb = (zzb) t.a0(parcel, readInt, zzb.CREATOR);
                    break;
                case 6:
                    y9Var = (y9) t.a0(parcel, readInt, y9.CREATOR);
                    break;
                case 7:
                    bArr = t.R(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new Update(i, i2, message, zzd, zzb, y9Var, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Update[] newArray(int i) {
        return new Update[i];
    }
}
