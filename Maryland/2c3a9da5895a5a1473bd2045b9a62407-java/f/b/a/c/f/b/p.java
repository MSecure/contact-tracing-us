package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class p implements Parcelable.Creator<g> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final g createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 1) {
                i2 = m.h.T0(parcel, readInt);
            } else if (i5 == 2) {
                i3 = m.h.T0(parcel, readInt);
            } else if (i5 != 3) {
                m.h.k1(parcel, readInt);
            } else {
                i4 = m.h.T0(parcel, readInt);
            }
        }
        m.h.T(parcel, v1);
        return new g(i2, i3, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ g[] newArray(int i2) {
        return new g[i2];
    }
}
