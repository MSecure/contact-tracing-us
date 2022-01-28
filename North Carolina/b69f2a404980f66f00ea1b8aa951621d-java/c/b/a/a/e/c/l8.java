package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class l8 implements Parcelable.Creator<m8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final m8 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        boolean z = false;
        w8 w8Var = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = i.j.Q(parcel, readInt);
            } else if (i == 2) {
                w8Var = (w8) i.j.O(parcel, readInt, w8.CREATOR);
            } else if (i != 3) {
                i.j.g1(parcel, readInt);
            } else {
                z = i.j.N0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new m8(str, w8Var, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m8[] newArray(int i) {
        return new m8[i];
    }
}
