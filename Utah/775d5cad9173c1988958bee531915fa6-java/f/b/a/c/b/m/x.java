package f.b.a.c.b.m;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.a;

public final class x implements Parcelable.Creator<v> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final v createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        IBinder iBinder = null;
        a aVar = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.e.l1(parcel, readInt);
            } else if (i3 == 2) {
                iBinder = m.e.k1(parcel, readInt);
            } else if (i3 == 3) {
                aVar = (a) m.e.L(parcel, readInt, a.CREATOR);
            } else if (i3 == 4) {
                z = m.e.h1(parcel, readInt);
            } else if (i3 != 5) {
                m.e.C1(parcel, readInt);
            } else {
                z2 = m.e.h1(parcel, readInt);
            }
        }
        m.e.V(parcel, O1);
        return new v(i2, iBinder, aVar, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v[] newArray(int i2) {
        return new v[i2];
    }
}
