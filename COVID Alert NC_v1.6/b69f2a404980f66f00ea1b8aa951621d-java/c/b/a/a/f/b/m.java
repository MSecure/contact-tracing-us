package c.b.a.a.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.a;
import c.b.a.a.c.l.q;

public final class m implements Parcelable.Creator<n> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final n createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        a aVar = null;
        int i = 0;
        q qVar = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i2 == 2) {
                aVar = (a) i.j.O(parcel, readInt, a.CREATOR);
            } else if (i2 != 3) {
                i.j.g1(parcel, readInt);
            } else {
                qVar = (q) i.j.O(parcel, readInt, q.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new n(i, aVar, qVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n[] newArray(int i) {
        return new n[i];
    }
}
