package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.f.b.b;

public final class c2 implements Parcelable.Creator<b2> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final b2 createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        IBinder iBinder = null;
        b bVar = null;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 3) {
                iBinder = m.h.R0(parcel, readInt);
            } else if (i2 != 4) {
                m.h.j1(parcel, readInt);
            } else {
                bVar = (b) m.h.I(parcel, readInt, b.CREATOR);
            }
        }
        m.h.T(parcel, u1);
        return new b2(iBinder, bVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b2[] newArray(int i2) {
        return new b2[i2];
    }
}
