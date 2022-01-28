package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.messages.Message;

public final class zzaf implements Parcelable.Creator<zzag> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzag createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        Message message = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                message = (Message) t.a0(parcel, readInt, Message.CREATOR);
            } else if (i2 != 1000) {
                t.O2(parcel, readInt);
            } else {
                i = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new zzag(i, message);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzag[] newArray(int i) {
        return new zzag[i];
    }
}
