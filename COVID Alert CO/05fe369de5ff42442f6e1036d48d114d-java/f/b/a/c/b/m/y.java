package f.b.a.c.b.m;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.c;

public final class y implements Parcelable.Creator<z> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final z createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        Bundle bundle = null;
        c[] cVarArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                bundle = m.h.A(parcel, readInt);
            } else if (i3 == 2) {
                cVarArr = (c[]) m.h.N(parcel, readInt, c.CREATOR);
            } else if (i3 == 3) {
                i2 = m.h.Z0(parcel, readInt);
            } else if (i3 != 4) {
                m.h.q1(parcel, readInt);
            } else {
                d dVar = (d) m.h.J(parcel, readInt, d.CREATOR);
            }
        }
        m.h.T(parcel, B1);
        return new z(bundle, cVarArr, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z[] newArray(int i2) {
        return new z[i2];
    }
}
