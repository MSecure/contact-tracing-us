package c.b.a.a.d.m;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.a;

public final class z implements Parcelable.Creator<x> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final x createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        a aVar = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i2 == 2) {
                iBinder = t.s2(parcel, readInt);
            } else if (i2 == 3) {
                aVar = (a) t.a0(parcel, readInt, a.CREATOR);
            } else if (i2 == 4) {
                z = t.q2(parcel, readInt);
            } else if (i2 != 5) {
                t.O2(parcel, readInt);
            } else {
                z2 = t.q2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new x(i, iBinder, aVar, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x[] newArray(int i) {
        return new x[i];
    }
}
