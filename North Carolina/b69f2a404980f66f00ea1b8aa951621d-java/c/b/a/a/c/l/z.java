package c.b.a.a.c.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.c;

public final class z implements Parcelable.Creator<a0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final a0 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        Bundle bundle = null;
        int i = 0;
        c[] cVarArr = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                bundle = i.j.E(parcel, readInt);
            } else if (i2 == 2) {
                cVarArr = (c[]) i.j.R(parcel, readInt, c.CREATOR);
            } else if (i2 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                i = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new a0(bundle, cVarArr, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a0[] newArray(int i) {
        return new a0[i];
    }
}
