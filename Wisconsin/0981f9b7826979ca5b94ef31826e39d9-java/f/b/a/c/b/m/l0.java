package f.b.a.c.b.m;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class l0 implements Parcelable.Creator<m> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final m createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 1) {
                i2 = m.h.S0(parcel, readInt);
            } else if (i5 == 2) {
                z = m.h.O0(parcel, readInt);
            } else if (i5 == 3) {
                z2 = m.h.O0(parcel, readInt);
            } else if (i5 == 4) {
                i3 = m.h.S0(parcel, readInt);
            } else if (i5 != 5) {
                m.h.j1(parcel, readInt);
            } else {
                i4 = m.h.S0(parcel, readInt);
            }
        }
        m.h.T(parcel, u1);
        return new m(i2, z, z2, i3, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m[] newArray(int i2) {
        return new m[i2];
    }
}
