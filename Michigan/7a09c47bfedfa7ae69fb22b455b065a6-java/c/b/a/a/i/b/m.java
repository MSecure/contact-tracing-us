package c.b.a.a.i.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.a;
import c.b.a.a.d.m.x;

public final class m implements Parcelable.Creator<n> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final n createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        a aVar = null;
        int i = 0;
        x xVar = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i2 == 2) {
                aVar = (a) t.a0(parcel, readInt, a.CREATOR);
            } else if (i2 != 3) {
                t.O2(parcel, readInt);
            } else {
                xVar = (x) t.a0(parcel, readInt, x.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new n(i, aVar, xVar);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n[] newArray(int i) {
        return new n[i];
    }
}
