package f.b.a.c.b.m;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class a0 implements Parcelable.Creator<d> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        m mVar = null;
        int[] iArr = null;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                mVar = (m) m.h.I(parcel, readInt, m.CREATOR);
            } else if (i3 == 2) {
                z = m.h.P0(parcel, readInt);
            } else if (i3 == 3) {
                z2 = m.h.P0(parcel, readInt);
            } else if (i3 == 4) {
                iArr = m.h.F(parcel, readInt);
            } else if (i3 != 5) {
                m.h.k1(parcel, readInt);
            } else {
                i2 = m.h.T0(parcel, readInt);
            }
        }
        m.h.T(parcel, v1);
        return new d(mVar, z, z2, iArr, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d[] newArray(int i2) {
        return new d[i2];
    }
}
