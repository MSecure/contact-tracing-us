package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class c2 implements Parcelable.Creator<b2> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final b2 createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        IBinder iBinder = null;
        boolean z = false;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.e.k1(parcel, readInt);
            } else if (i2 != 2) {
                m.e.C1(parcel, readInt);
            } else {
                z = m.e.h1(parcel, readInt);
            }
        }
        m.e.V(parcel, O1);
        return new b2(iBinder, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ b2[] newArray(int i2) {
        return new b2[i2];
    }
}
