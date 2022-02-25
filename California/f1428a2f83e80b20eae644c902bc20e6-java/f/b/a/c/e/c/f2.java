package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class f2 implements Parcelable.Creator<e2> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final e2 createFromParcel(Parcel parcel) {
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
        return new e2(iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e2[] newArray(int i2) {
        return new e2[i2];
    }
}
