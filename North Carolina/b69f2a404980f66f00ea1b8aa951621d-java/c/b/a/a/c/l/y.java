package c.b.a.a.c.l;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.a;

public final class y implements Parcelable.Creator<q> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final q createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        a aVar = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i2 == 2) {
                iBinder = i.j.Q0(parcel, readInt);
            } else if (i2 == 3) {
                aVar = (a) i.j.O(parcel, readInt, a.CREATOR);
            } else if (i2 == 4) {
                z = i.j.N0(parcel, readInt);
            } else if (i2 != 5) {
                i.j.g1(parcel, readInt);
            } else {
                z2 = i.j.N0(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new q(i, iBinder, aVar, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q[] newArray(int i) {
        return new q[i];
    }
}
