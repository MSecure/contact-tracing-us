package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class g0 implements Parcelable.Creator<d0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d0 createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        IBinder iBinder = null;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                m.h.j1(parcel, readInt);
            } else {
                iBinder = m.h.R0(parcel, readInt);
            }
        }
        m.h.T(parcel, u1);
        return new d0(iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d0[] newArray(int i2) {
        return new d0[i2];
    }
}
