package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.f.b.b;

public final class d2 implements Parcelable.Creator<c2> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final c2 createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        IBinder iBinder = null;
        b bVar = null;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 3) {
                iBinder = m.h.S0(parcel, readInt);
            } else if (i2 != 4) {
                m.h.k1(parcel, readInt);
            } else {
                bVar = (b) m.h.I(parcel, readInt, b.CREATOR);
            }
        }
        m.h.T(parcel, v1);
        return new c2(iBinder, bVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ c2[] newArray(int i2) {
        return new c2[i2];
    }
}
