package c.b.a.a.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.p;

public final class k implements Parcelable.Creator<l> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final l createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        p pVar = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i2 != 2) {
                i.j.g1(parcel, readInt);
            } else {
                pVar = (p) i.j.O(parcel, readInt, p.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new l(i, pVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i) {
        return new l[i];
    }
}
