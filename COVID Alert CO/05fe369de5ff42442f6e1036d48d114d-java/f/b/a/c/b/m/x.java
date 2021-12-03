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
        int B1 = m.h.B1(parcel);
        IBinder iBinder = null;
        a aVar = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = m.h.Z0(parcel, readInt);
            } else if (i3 == 2) {
                iBinder = m.h.Y0(parcel, readInt);
            } else if (i3 == 3) {
                aVar = (a) m.h.J(parcel, readInt, a.CREATOR);
            } else if (i3 == 4) {
                z = m.h.V0(parcel, readInt);
            } else if (i3 != 5) {
                m.h.q1(parcel, readInt);
            } else {
                z2 = m.h.V0(parcel, readInt);
            }
        }
        m.h.T(parcel, B1);
        return new v(i2, iBinder, aVar, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v[] newArray(int i2) {
        return new v[i2];
    }
}
