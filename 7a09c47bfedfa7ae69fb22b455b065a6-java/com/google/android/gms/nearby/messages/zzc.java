package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.g.e.ba;
import c.b.a.a.g.e.u9;
import com.google.android.gms.nearby.messages.internal.zzae;
import java.util.ArrayList;

public final class zzc implements Parcelable.Creator<MessageFilter> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final MessageFilter createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                arrayList = t.e0(parcel, readInt, zzae.CREATOR);
            } else if (i3 == 2) {
                arrayList2 = t.e0(parcel, readInt, ba.CREATOR);
            } else if (i3 == 3) {
                z = t.q2(parcel, readInt);
            } else if (i3 == 4) {
                arrayList3 = t.e0(parcel, readInt, u9.CREATOR);
            } else if (i3 == 5) {
                i2 = t.t2(parcel, readInt);
            } else if (i3 != 1000) {
                t.O2(parcel, readInt);
            } else {
                i = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new MessageFilter(i, arrayList, arrayList2, z, arrayList3, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageFilter[] newArray(int i) {
        return new MessageFilter[i];
    }
}
