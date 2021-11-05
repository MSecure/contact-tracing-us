package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class l8 implements Parcelable.Creator<m8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final m8 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        boolean z = false;
        w8 w8Var = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = t.b0(parcel, readInt);
            } else if (i == 2) {
                w8Var = (w8) t.a0(parcel, readInt, w8.CREATOR);
            } else if (i != 3) {
                t.O2(parcel, readInt);
            } else {
                z = t.q2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new m8(str, w8Var, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m8[] newArray(int i) {
        return new m8[i];
    }
}
