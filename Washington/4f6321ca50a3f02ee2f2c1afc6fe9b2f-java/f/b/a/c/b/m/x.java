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
        int v1 = m.h.v1(parcel);
        IBinder iBinder = null;
        a aVar = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.h.T0(parcel, readInt);
            } else if (i3 == 2) {
                iBinder = m.h.S0(parcel, readInt);
            } else if (i3 == 3) {
                aVar = (a) m.h.I(parcel, readInt, a.CREATOR);
            } else if (i3 == 4) {
                z = m.h.P0(parcel, readInt);
            } else if (i3 != 5) {
                m.h.k1(parcel, readInt);
            } else {
                z2 = m.h.P0(parcel, readInt);
            }
        }
        m.h.T(parcel, v1);
        return new v(i2, iBinder, aVar, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v[] newArray(int i2) {
        return new v[i2];
    }
}
