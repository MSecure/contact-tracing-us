package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class r8 implements Parcelable.Creator<s8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final s8 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                i.j.g1(parcel, readInt);
            } else {
                i = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new s8(i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s8[] newArray(int i) {
        return new s8[i];
    }
}
