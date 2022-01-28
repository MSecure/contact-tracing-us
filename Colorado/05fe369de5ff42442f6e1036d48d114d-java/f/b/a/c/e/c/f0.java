package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class f0 implements Parcelable.Creator<e0> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final e0 createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        IBinder iBinder = null;
        String str = null;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.h.Y0(parcel, readInt);
            } else if (i2 != 2) {
                m.h.q1(parcel, readInt);
            } else {
                str = m.h.M(parcel, readInt);
            }
        }
        m.h.T(parcel, B1);
        return new e0(iBinder, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ e0[] newArray(int i2) {
        return new e0[i2];
    }
}
