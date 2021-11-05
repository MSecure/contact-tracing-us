package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class z9 implements Parcelable.Creator<ba> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ba createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        boolean z = false;
        byte[] bArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = i.j.R0(parcel, readInt);
            } else if (i3 == 2) {
                bArr = i.j.F(parcel, readInt);
            } else if (i3 == 3) {
                z = i.j.N0(parcel, readInt);
            } else if (i3 != 1000) {
                i.j.g1(parcel, readInt);
            } else {
                i = i.j.R0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new ba(i, i2, bArr, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ba[] newArray(int i) {
        return new ba[i];
    }
}
