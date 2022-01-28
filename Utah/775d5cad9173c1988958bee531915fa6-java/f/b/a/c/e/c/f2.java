package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;

public final class f2 implements Parcelable.Creator<e2> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final e2 createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        IBinder iBinder = null;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                m.e.C1(parcel, readInt);
            } else {
                iBinder = m.e.k1(parcel, readInt);
            }
        }
        m.e.V(parcel, O1);
        return new e2(iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ e2[] newArray(int i2) {
        return new e2[i2];
    }
}
