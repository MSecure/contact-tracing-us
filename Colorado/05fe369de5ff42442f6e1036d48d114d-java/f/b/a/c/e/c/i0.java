package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class i0 implements Parcelable.Creator<h0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final h0 createFromParcel(Parcel parcel) {
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
        return new h0(iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ h0[] newArray(int i2) {
        return new h0[i2];
    }
}
