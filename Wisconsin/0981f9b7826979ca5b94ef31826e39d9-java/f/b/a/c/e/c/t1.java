package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class t1 implements Parcelable.Creator<s1> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final s1 createFromParcel(Parcel parcel) {
        int u1 = m.h.u1(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < u1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.h.R0(parcel, readInt);
            } else if (i2 != 2) {
                m.h.j1(parcel, readInt);
            } else {
                iBinder2 = m.h.R0(parcel, readInt);
            }
        }
        m.h.T(parcel, u1);
        return new s1(iBinder, iBinder2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s1[] newArray(int i2) {
        return new s1[i2];
    }
}
