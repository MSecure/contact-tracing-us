package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class x9 implements Parcelable.Creator<y9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final y9 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 3) {
                str = t.b0(parcel, readInt);
            } else if (i2 == 6) {
                str2 = t.b0(parcel, readInt);
            } else if (i2 != 1000) {
                t.O2(parcel, readInt);
            } else {
                i = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new y9(i, str, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ y9[] newArray(int i) {
        return new y9[i];
    }
}
