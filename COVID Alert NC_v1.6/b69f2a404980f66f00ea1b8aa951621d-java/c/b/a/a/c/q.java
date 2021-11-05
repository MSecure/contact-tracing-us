package c.b.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class q implements Parcelable.Creator<c> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = i.j.Q(parcel, readInt);
            } else if (i2 == 2) {
                i = i.j.R0(parcel, readInt);
            } else if (i2 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                j = i.j.S0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new c(str, i, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }
}
