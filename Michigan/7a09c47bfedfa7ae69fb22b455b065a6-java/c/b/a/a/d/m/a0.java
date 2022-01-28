package c.b.a.a.d.m;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.c;

public final class a0 implements Parcelable.Creator<b0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final b0 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        Bundle bundle = null;
        int i = 0;
        c[] cVarArr = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                bundle = t.Q(parcel, readInt);
            } else if (i2 == 2) {
                cVarArr = (c[]) t.d0(parcel, readInt, c.CREATOR);
            } else if (i2 == 3) {
                i = t.t2(parcel, readInt);
            } else if (i2 != 4) {
                t.O2(parcel, readInt);
            } else {
                d dVar = (d) t.a0(parcel, readInt, d.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new b0(bundle, cVarArr, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b0[] newArray(int i) {
        return new b0[i];
    }
}
