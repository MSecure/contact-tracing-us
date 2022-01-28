package f.b.a.c.b.m;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class l0 implements Parcelable.Creator<m> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final m createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 1) {
                i2 = m.e.l1(parcel, readInt);
            } else if (i5 == 2) {
                z = m.e.h1(parcel, readInt);
            } else if (i5 == 3) {
                z2 = m.e.h1(parcel, readInt);
            } else if (i5 == 4) {
                i3 = m.e.l1(parcel, readInt);
            } else if (i5 != 5) {
                m.e.C1(parcel, readInt);
            } else {
                i4 = m.e.l1(parcel, readInt);
            }
        }
        m.e.V(parcel, O1);
        return new m(i2, z, z2, i3, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m[] newArray(int i2) {
        return new m[i2];
    }
}
