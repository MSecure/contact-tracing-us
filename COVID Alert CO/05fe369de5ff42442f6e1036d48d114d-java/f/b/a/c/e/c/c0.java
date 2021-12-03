package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class c0 implements Parcelable.Creator<b0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final b0 createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        IBinder iBinder = null;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                m.h.q1(parcel, readInt);
            } else {
                iBinder = m.h.Y0(parcel, readInt);
            }
        }
        m.h.T(parcel, B1);
        return new b0(iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ b0[] newArray(int i2) {
        return new b0[i2];
    }
}
