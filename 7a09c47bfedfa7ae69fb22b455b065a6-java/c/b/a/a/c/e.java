package c.b.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class e implements Parcelable.Creator<d> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final d createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        long j = 0;
        long j2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                z = t.q2(parcel, readInt);
            } else if (i == 2) {
                j2 = t.u2(parcel, readInt);
            } else if (i != 3) {
                t.O2(parcel, readInt);
            } else {
                j = t.u2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new d(z, j, j2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d[] newArray(int i) {
        return new d[i];
    }
}
