package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.a;
import f.b.a.c.b.m.v;

public final class m implements Parcelable.Creator<n> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final n createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        a aVar = null;
        v vVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.h.Z0(parcel, readInt);
            } else if (i3 == 2) {
                aVar = (a) m.h.J(parcel, readInt, a.CREATOR);
            } else if (i3 != 3) {
                m.h.q1(parcel, readInt);
            } else {
                vVar = (v) m.h.J(parcel, readInt, v.CREATOR);
            }
        }
        m.h.T(parcel, B1);
        return new n(i2, aVar, vVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n[] newArray(int i2) {
        return new n[i2];
    }
}
