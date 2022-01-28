package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class w7 implements Parcelable.Creator<x7> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final x7 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = i.j.Q(parcel, readInt);
            } else if (i2 != 2) {
                i.j.g1(parcel, readInt);
            } else {
                i = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new x7(str, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x7[] newArray(int i) {
        return new x7[i];
    }
}
