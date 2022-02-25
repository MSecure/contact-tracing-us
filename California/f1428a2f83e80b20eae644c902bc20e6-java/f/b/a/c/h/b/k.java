package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.u;

public final class k implements Parcelable.Creator<l> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final l createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        int i2 = 0;
        u uVar = null;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.h.S0(parcel, readInt);
            } else if (i3 != 2) {
                m.h.j1(parcel, readInt);
            } else {
                uVar = (u) m.h.I(parcel, readInt, u.CREATOR);
            }
        }
        m.h.T(parcel, u1);
        return new l(i2, uVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i2) {
        return new l[i2];
    }
}
