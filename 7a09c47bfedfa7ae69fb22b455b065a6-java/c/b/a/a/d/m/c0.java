package c.b.a.a.d.m;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class c0 implements Parcelable.Creator<d> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        n nVar = null;
        int[] iArr = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                nVar = (n) t.a0(parcel, readInt, n.CREATOR);
            } else if (i2 == 2) {
                z = t.q2(parcel, readInt);
            } else if (i2 == 3) {
                z2 = t.q2(parcel, readInt);
            } else if (i2 == 4) {
                iArr = t.W(parcel, readInt);
            } else if (i2 != 5) {
                t.O2(parcel, readInt);
            } else {
                i = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new d(nVar, z, z2, iArr, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d[] newArray(int i) {
        return new d[i];
    }
}
