package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class a0 implements Parcelable.Creator<z> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final z createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        IBinder iBinder = null;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                m.h.k1(parcel, readInt);
            } else {
                iBinder = m.h.S0(parcel, readInt);
            }
        }
        m.h.T(parcel, v1);
        return new z(iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ z[] newArray(int i2) {
        return new z[i2];
    }
}
