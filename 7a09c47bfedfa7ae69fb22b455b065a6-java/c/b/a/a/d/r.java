package c.b.a.a.d;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class r implements Parcelable.Creator<c> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = t.b0(parcel, readInt);
            } else if (i2 == 2) {
                i = t.t2(parcel, readInt);
            } else if (i2 != 3) {
                t.O2(parcel, readInt);
            } else {
                j = t.u2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new c(str, i, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }
}
