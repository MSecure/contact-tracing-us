package c.b.a.a.d.m;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class n0 implements Parcelable.Creator<n> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final n createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i4 == 2) {
                z = t.q2(parcel, readInt);
            } else if (i4 == 3) {
                z2 = t.q2(parcel, readInt);
            } else if (i4 == 4) {
                i2 = t.t2(parcel, readInt);
            } else if (i4 != 5) {
                t.O2(parcel, readInt);
            } else {
                i3 = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new n(i, z, z2, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n[] newArray(int i) {
        return new n[i];
    }
}
