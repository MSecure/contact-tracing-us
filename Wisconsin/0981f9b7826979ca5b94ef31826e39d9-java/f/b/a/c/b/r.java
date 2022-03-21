package f.b.a.c.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class r implements Parcelable.Creator<c> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        String str = null;
        int i2 = 0;
        long j2 = -1;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                str = m.h.L(parcel, readInt);
            } else if (i3 == 2) {
                i2 = m.h.S0(parcel, readInt);
            } else if (i3 != 3) {
                m.h.j1(parcel, readInt);
            } else {
                j2 = m.h.T0(parcel, readInt);
            }
        }
        m.h.T(parcel, u1);
        return new c(str, i2, j2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i2) {
        return new c[i2];
    }
}
