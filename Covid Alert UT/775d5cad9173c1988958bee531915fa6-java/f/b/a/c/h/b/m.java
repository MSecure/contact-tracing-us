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
        int O1 = m.e.O1(parcel);
        a aVar = null;
        v vVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.e.l1(parcel, readInt);
            } else if (i3 == 2) {
                aVar = (a) m.e.L(parcel, readInt, a.CREATOR);
            } else if (i3 != 3) {
                m.e.C1(parcel, readInt);
            } else {
                vVar = (v) m.e.L(parcel, readInt, v.CREATOR);
            }
        }
        m.e.V(parcel, O1);
        return new n(i2, aVar, vVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n[] newArray(int i2) {
        return new n[i2];
    }
}
