package f.b.a.c.b.m;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class a0 implements Parcelable.Creator<d> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        m mVar = null;
        int[] iArr = null;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                mVar = (m) m.e.L(parcel, readInt, m.CREATOR);
            } else if (i3 == 2) {
                z = m.e.h1(parcel, readInt);
            } else if (i3 == 3) {
                z2 = m.e.h1(parcel, readInt);
            } else if (i3 == 4) {
                iArr = m.e.H(parcel, readInt);
            } else if (i3 != 5) {
                m.e.C1(parcel, readInt);
            } else {
                i2 = m.e.l1(parcel, readInt);
            }
        }
        m.e.V(parcel, O1);
        return new d(mVar, z, z2, iArr, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d[] newArray(int i2) {
        return new d[i2];
    }
}
