package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.e.c.ba;
import c.b.a.a.e.c.u9;
import com.google.android.gms.nearby.messages.internal.zzae;
import java.util.ArrayList;

public final class zzc implements Parcelable.Creator<MessageFilter> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final MessageFilter createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                arrayList = i.j.S(parcel, readInt, zzae.CREATOR);
            } else if (i3 == 2) {
                arrayList2 = i.j.S(parcel, readInt, ba.CREATOR);
            } else if (i3 == 3) {
                z = i.j.N0(parcel, readInt);
            } else if (i3 == 4) {
                arrayList3 = i.j.S(parcel, readInt, u9.CREATOR);
            } else if (i3 == 5) {
                i2 = i.j.R0(parcel, readInt);
            } else if (i3 != 1000) {
                i.j.g1(parcel, readInt);
            } else {
                i = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new MessageFilter(i, arrayList, arrayList2, z, arrayList3, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageFilter[] newArray(int i) {
        return new MessageFilter[i];
    }
}
