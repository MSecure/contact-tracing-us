package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.f.b.b;

public final class l2 implements Parcelable.Creator<k2> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final k2 createFromParcel(Parcel parcel) {
        int B1 = m.h.B1(parcel);
        IBinder iBinder = null;
        b bVar = null;
        while (parcel.dataPosition() < B1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 3) {
                iBinder = m.h.Y0(parcel, readInt);
            } else if (i2 != 4) {
                m.h.q1(parcel, readInt);
            } else {
                bVar = (b) m.h.J(parcel, readInt, b.CREATOR);
            }
        }
        m.h.T(parcel, B1);
        return new k2(iBinder, bVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ k2[] newArray(int i2) {
        return new k2[i2];
    }
}
