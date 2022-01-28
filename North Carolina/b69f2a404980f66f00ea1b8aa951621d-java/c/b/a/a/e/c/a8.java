package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class a8 implements Parcelable.Creator<b8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final b8 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        int i = 0;
        byte[] bArr = null;
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
                bArr = i.j.F(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new b8(str, i, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b8[] newArray(int i) {
        return new b8[i];
    }
}
